package newtimes.preproduction.guis;
import newtimes.preproduction.process.*;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPrxBrkDnList extends PnlTableEditor {
  DB_PrxBrkDn  myProcessor=null;
  static String DISP_KLM_COLOR_CODE="Color Name";
  static String DISP_KLM_UNIT="Unit";
  static String DISP_KLM_CURRENCY="Currency";
  static String DISP_KLM_PRICE="Price";
  static String DISP_KLM_LKN_DESC="Lock in Description";
  static String DISP_KLM_PROTO_DESC="Proto Description";
  static String KLM_COLOR_CODE="PRICE_BREAKDOWN_CLIB_SEQ";
  static String KLM_UNIT="PRICE_BREAKDOWN_UNIT";
  static String KLM_CURRENCY="PRICE_BREAKDOWN_UNIT_CURRENCY";
  static String KLM_PRICE="PRICE_BREAKDOWN_PRICE";
  static String KLM_LKN_DESC="PRICE_BREAKDOWN_LOCKIN_DESC";
  static String KLM_PROTO_DESC="PRICE_BREAKDOWN_PROTO_DESC";

  Vector clibDatas;
  public PnlPrxBrkDnList() {
    getJtable().setRowHeight(60);
    setBackground(new java.awt.Color(204, 204, 225));
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
     String storedKlms[]=getStoredRecordColumns();
     /*
     if(columnAt==0){
       rec.set("PRICE_BREAKDOWN_CLIB_SEQ",value2update);
     }else{
       rec.set(storedKlms[columnAt-1],value2update);
     }*/
      rec.set(storedKlms[columnAt],value2update);
      rec.set("EDIT_MODE","E");
     return rec;
    }catch(Exception e){
      e.printStackTrace();
      return rec;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
    InsertionOrderedHashMap hm=new InsertionOrderedHashMap();
    hm.put(DISP_KLM_COLOR_CODE,KLM_COLOR_CODE);
    hm.put(DISP_KLM_UNIT      ,KLM_UNIT);
    hm.put(DISP_KLM_CURRENCY  ,KLM_CURRENCY);
    hm.put(DISP_KLM_PRICE     ,KLM_PRICE);
    hm.put(DISP_KLM_LKN_DESC  ,KLM_LKN_DESC);
    hm.put(DISP_KLM_PROTO_DESC,KLM_PROTO_DESC);
    return hm;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/

    multiEditorJTableInSuper.addJComboBox(0,clibDatas,
                                           "PCLIB_COLOR_NAME",
                                           "PCLIB_sEQ");
    Vector unitsRec=newtimes.preproduction.guis.tempProperties.tmpUnits;
    multiEditorJTableInSuper.addJComboBox(1,unitsRec,
                                            "UNIT",
                                            "UNIT");
    Vector currencyRec=newtimes.preproduction.guis.tempProperties.tmpCurrency;
    multiEditorJTableInSuper.addJComboBox(2,currencyRec,
                                            "CRNCY_NAME",
                                            "CRNCY_NAME");


     multiEditorJTableInSuper.setTextEditorVerifiers(this.getObject2StringConvertor());
     multiEditorJTableInSuper.addTextAreaEditor(4,200);
     multiEditorJTableInSuper.addTextAreaEditor(5,200);
     multiEditorJTableInSuper.setTextEditorVerifiers(this.getObject2StringConvertor());
         ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(
        new myUnitEditablePolicy());
  }
  class myUnitEditablePolicy implements exgui.CellEditablePolicy{
    //to avoid chage unit after editting qty.
    public boolean isCellEditable(int row,int column){
      try{
        if (column != 0)
          return true;
        Record rec = (Record) getDisplayingRecords().get(row);
        if ( ( (String) rec.get("EDIT_MODE")).trim().equalsIgnoreCase("E")) {
           return false;
        }
        return true;
      }catch(Exception e){
        e.printStackTrace();
        return false;
      }
    }
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 5;
  }
  protected Hashtable getObject2StringConvertor() {
    java.util.Hashtable ht=new Hashtable();
    Object vfyUnit=exgui.verification.CellFormat.getOrdinaryField(5);
    Object vfyPrice=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
    //ht.put(DISP_KLM_UNIT,vfyUnit);
    //ht.put(DISP_KLM_CURRENCY,vfyUnit);
    ht.put(DISP_KLM_PRICE,vfyPrice);
    //ht.put(DISP_KLM_COMMENT,cmtCnv);
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    myProcessor=DB_PrxBrkDn.getInstanceOfPrxBrkdn();
    this.clibDatas=myProcessor.PREPROD_COLOR_LIBS;//this attribute is update at each time call DB_LabDipsStts.getAvailableClibs(preprodHeadPK);
    this.dbHandler=myProcessor;
    return dbHandler;
  }
}