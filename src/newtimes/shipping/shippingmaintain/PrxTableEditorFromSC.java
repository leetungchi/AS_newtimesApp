package newtimes.shipping.shippingmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PrxTableEditorFromSC extends PnlTableEditor {
  PrxDataFactoryAdapterFromSC listDataSrc = null;
  static final String LICENSEE = " \nLicensee";
  static final String COLOR = " \nColor";
  static final String BDP = " \nFOB Price";
  static final String BAP = "Buyer\nAct Price";
  static final String MAP = "Maker\nAct Price";
  static final String MDP = "Maker\nDoc Price";
  static InsertionOrderedHashMap iso = null;

  public PrxTableEditorFromSC() {
    super.firstPage();
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    getJtable().setRowHeight(20);
    System.out.println("activate  PrxTableEditorFromSC()");
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try {
      switch(columnAt) {
        case 2:
          rec.set("PRI_BYR_DOC_PRX", value2update);
          return rec;
        case 3:
          rec.set("PRI_BYR_ACT_PRX", value2update);
          return rec;
        case 4:
          rec.set("PRI_MKR_ACT_PRX", value2update);
          return rec;
        case 5:
          rec.set("PRI_MKR_DOC_PRX", value2update);
          return rec;
      }
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set record data."+
                                 "\nRecord Data:"+rec.toString());
    }
    return rec;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(LICENSEE, "LINCESEE");
      iso.put(COLOR, "COLOR");
      iso.put(BDP, "PRI_BYR_DOC_PRX");
      iso.put(BAP, "PRI_BYR_ACT_PRX");
      iso.put(MAP, "PRI_MKR_ACT_PRX");
      iso.put(MDP, "PRI_MKR_DOC_PRX");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try {
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    Object flt33cnv=exgui.verification.CellFormat.getDoubleFormat(7,3);
    Hashtable ht=new Hashtable();
    ht.put(BDP,new VfyFOBPrx());
    ht.put(BAP,new BuyActPrxVfy());
    ht.put(MAP,flt33cnv);
    ht.put(MDP,flt33cnv);
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    PrxDataFactoryAdapterFromSC prxSrc =
        PrxDataFactoryAdapterFromSC.getInstance();
    return prxSrc;
  }

  class VfyFOBPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
  Object orgFvyObj=null;
  public VfyFOBPrx(){
    orgFvyObj=exgui.verification.CellFormat.getDoubleFormat(7,3);
  }
  public exgui.ultratable.KeyProcess getKeyListener(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
  }
  public int getMaxLength(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
  }
  public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
  public boolean isFormatValid(String inStr,int row,int column){
    boolean isVld= ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
    if(!isVld)return isVld;
    //test if have to modify the remain 3 column.
    for(int i=2; i<6; i++){
      Object value = getJtable().getValueAt(row,i);
      if(value==null||
         value.toString().trim().length()==0||
         value.toString().trim().equals("0")){
        getJtable().setValueAt(inStr,row,i);
      }
    }
    return isVld;
  }
  public String Obj2String(Object obj2kvt){
    return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
  }
   public Object cellStringToObject(String String2kvt){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
   }
 }

 class BuyActPrxVfy extends VfyFOBPrx{
   public boolean isFormatValid(String inStr,int row,int column){
     boolean isVld= ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
     if(!isVld)return isVld;
     //test if have to modify the remain 3 column.
       Object value=getJtable().getValueAt(row,4);
       if(value==null||
          value.toString().trim().length()==0||
          value.toString().trim().equals("0")){
         getJtable().setValueAt(inStr,row,4);
       }
     return isVld;
   }
 }
}
