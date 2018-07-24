package newtimes.production.gui.prodmaintain;

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

public class PnlListPlanQta extends PnlTableEditor {
  newtimes.production.process.prodmaintain.DB_PlanQuota myHandler=
      newtimes.production.process.prodmaintain.DB_PlanQuota.getInstanceOfPlanQuotaHandler();
  public javax.swing.JLabel lblTotal=new exgui.BlueBkgWhiteCharLabel("          TOTAL:");
  public java.util.Hashtable combinVlu2Update=new java.util.Hashtable();
  public exgui.ultratable.CellTxtEditorFormat intvfyOpt=
      (exgui.ultratable.CellTxtEditorFormat)
      exgui.verification.CellFormat.getIntVerifierAllowNull(6);
  static String QUOTA_COLUMN_TITLE="   QUOTA  ¡¿";
  static String QTY_COLUMN_TITLE="QTY\n(Unit=Piece)";
  static String RATE_COLUMN="    ACHIVE RATE(%)    ";
  static String EST_PRX="    ESTIMATE\nPRICE    ";
  //protected java.util.Vector tmpCatAreaVct;
  protected exgui.ultratable.Wraper4tblCbx   tmpWrpObj4Cat=null;
  public PnlListPlanQta() {
    //super.setLayout(null);
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnPrev.setVisible(false);
    super.jbtnNext.setVisible(false);
    lblTotal.setLocation((int)jbtnNext.getLocation().getX()+10,
                         (int)jbtnNext.getLocation().getY());
    //this.setPreferredSize(new java.awt.Dimension(150,150));
    java.awt.Container  btnCtn=jbtnNext.getParent();
    btnCtn.removeAll();
    btnCtn.add(lblTotal);

  }
  public void tableChanged(javax.swing.event.TableModelEvent e){
    //if user did not chose any cat/area while editing plan qty,directy assign first one
    //System.out.println("activate tableChanged");
    try{
      if (e.getColumn() != 1)return;
      Object orgcatdata=getJtable().getValueAt(e.getFirstRow(), 0);
      if (orgcatdata==null||orgcatdata.toString()==null||orgcatdata.toString().trim().length()==0) {
        getJtable().setValueAt(
            tmpWrpObj4Cat, e.getFirstRow(),0);
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public void doUpdate()throws Exception{
    //sum all the value...
    combinVlu2Update.clear();
    javax.swing.JTable jtbl=getJtable();
    int totalsummedvalue=0;
    for(int i=0;i<15;i++){
      String key=jtbl.getValueAt(i,0).toString();
      //System.out.println("key is:"+key);
      Object valueObj=jtbl.getValueAt(i,1);
      Object catObj=jtbl.getValueAt(i,0);
      if(catObj==null||catObj.toString().trim().equals(""))continue;
      if(valueObj==null) continue;
      String value=valueObj.toString();
      if(value!=null){
       if(value.trim().equals(""))continue;
        if(!exgui.verification.VerifyLib.isInteger(value.trim())){
          exgui.verification.VerifyLib.showAlert("Number format error","Number format eror");
          break;
        }else{
          if(combinVlu2Update.containsKey(key)){
            if(Integer.parseInt(value.trim())==0)continue;
            int storedValue=Integer.parseInt((String)combinVlu2Update.get(key));
            storedValue+=Integer.parseInt(value.trim());
            combinVlu2Update.put(key,String.valueOf(storedValue));
            totalsummedvalue+=Integer.parseInt(value.trim());
          }else{
            if(Integer.parseInt(value.trim())==0)continue;
            combinVlu2Update.put(key,value.trim());
            totalsummedvalue+=Integer.parseInt(value.trim());
          }
        }
      }
    }
    lblTotal.setText("          TOTAL:"+totalsummedvalue);
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      //myHandler.updatePlanQuta(combinVlu2Update);
      super.doUpdate();
      //table_snapshot=util.MiscFunc.table2Text(getJtable());//update for modification compare
      //exgui.verification.VerifyLib.showAlert("Update OK","Update OK");
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Update Fail","Update Fail");
      throw e;
    }finally{
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  protected boolean updateModifiedRecord()throws Exception {

        if(!super.getMultiEditorJTable().isTableOk()) return false;
          if(_records2Update==null) return true;
          //if(_records2Update.size()==0){
            _records2Update=kvtModifiedField2Records(
               super.getMultiEditorJTable().getModifiedRowAndColumn()
            );
          //}
          /*
           remarked at 20030508,trigger the PagedDataFactory while update comand is invoked.
          //if(_records2Update.size()==0) return true;
          */
          dbHandler.updateRecords(getDisplayingRecords());
        _records2Update.removeAllElements();
       //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");
       return true;
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      //PLAN_PROD_HEAD_PK, PLAN_QTA_CAT, PLAN_QTA_AREA, PLAN_QTY, RECORD_CREATE_USER, RECORD_CREATE_DATE, RECORD_DELETE_FLAG, RECORD_DELETE_DATE, RECORD_DELETE_USER, RECORD_MODIFY_DATE, RECORD_MODIFY_USER, SUCC_RATE, EST_PRX, PROD_PLAN_NO,concat(plan_qta_cat,plan_qta_area) as cat_data  from PLAN where PLAN_PROD_HEAD_PK
      if(storedRecordColumn[columnAt].toLowerCase().equals("cat_data")){
        if(value2update!=null){
        //slit the last character,save to qta_cat,qta_area column
        //String qtaQtyValue=(String)concatedQtaQtyTbl.get(concatCAT_AREA);
        String concatCAT_AREA=value2update.toString();
        String qta_catValue=concatCAT_AREA.substring(0,concatCAT_AREA.length()-1);
        String qta_areaValue=concatCAT_AREA.substring(concatCAT_AREA.length()-1,concatCAT_AREA.length());
          rec.set("PLAN_QTA_CAT",qta_catValue);
          rec.set("PLAN_QTA_AREA",qta_areaValue);
          rec.set("cat_data",value2update);
        }else{
          rec.set("cat_data",null);
          rec.set("PLAN_QTA_CAT",null);
          rec.set("PLAN_QTA_AREA",null);
        }
      }else{
        rec.set(storedRecordColumn[columnAt],value2update);
      }
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return rec;
    }
  }
  public void firstPage(){
    super.firstPage();
    javax.swing.JTable jblt=getJtable();
    int totalint=0;
    //summ all the quantity to "TOTAL:" data.
    for(int i=0;i<15;i++){
      Object objvalue=jblt.getValueAt(i,1);
      Object objcat=jblt.getValueAt(i,0);
      if(objcat==null)continue;
      if(objcat.toString().trim().equals(""))continue;
      if(objvalue==null)continue;
      String orgvalue=objvalue.toString();
      if((orgvalue!=null) && (!orgvalue.trim().equals("")))
         totalint+=Integer.parseInt(orgvalue.trim());
    }
    lblTotal.setText("          TOTAL:"+totalint);
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(QUOTA_COLUMN_TITLE,"cat_data");
    iso.put(QTY_COLUMN_TITLE,"PLAN_QTY");
    iso.put(RATE_COLUMN,"SUCC_RATE");
    iso.put(EST_PRX,"EST_PRX");
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    try{
       java.util.Vector catarea2select=myHandler.getCatArea2Select();
       //make a blank record,as default value.
       Record tempRec=(Record)util.MiscFunc.deepCopy(catarea2select.get(0));
       tempRec.set(0,null);tempRec.set(1,"");tempRec.set(2,"");
       tempRec.set(3,"");tempRec.set(4,"");tempRec.set(5,"");
       tempRec.set(6,"");tempRec.set(7,"");tempRec.set(8,"");
       tempRec.set(9,"");tempRec.set(10,"");tempRec.set(11,null);
       catarea2select.add(0,tempRec);

       multiEditorJTableInSuper.addJComboBox(0,catarea2select,"CAT_DATA","CAT_DATA");
       multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor(
          ));

       String firstCat=(String)((Record)catarea2select.get(1)).get("CAT_DATA");
       tmpWrpObj4Cat=
          new exgui.ultratable.Wraper4tblCbx(firstCat,firstCat);
       this.getJtable().getModel().addTableModelListener(this);
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 15;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");

    QtyVfyObj valueValidator=new QtyVfyObj(super.getJtable());
    AchvRateVfyObj ratevfy=new AchvRateVfyObj();
    Object prxVfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(
      8,3);
    java.util.Hashtable htx=new java.util.Hashtable();
    htx.put(QTY_COLUMN_TITLE,valueValidator);
    htx.put(RATE_COLUMN,ratevfy);
    htx.put(EST_PRX,prxVfy);
    return htx;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    if(myHandler==null)
      myHandler=newtimes.production.process.prodmaintain.DB_PlanQuota.getInstanceOfPlanQuotaHandler();
    return myHandler;
  }
  class  AchvRateVfyObj
      implements exgui.ultratable.CellTxtEditorFormat ,
      exgui.Object2String {
    String myWarnningMsg="Must use Integer data,between 0~100";
    exgui.ultratable.CellTxtEditorFormat vfyObj=
        exgui.verification.CellFormat.getIntVerifierAllowNull(3);
    AchvRateVfyObj (){

    }
    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)vfyObj).getKeyListener();
    }
    public int getMaxLength(){return 3;}
    public String formatPromptMsg(){
     return myWarnningMsg;
    }
    public Object cellStringToObject(String str){
     return vfyObj.cellStringToObject(str);
    }
    public String Obj2String(Object obj){
      return ((exgui.Object2String)vfyObj).Obj2String(obj);
    }

    synchronized public boolean isFormatValid(String instr,int row,int column){
      if(!vfyObj.isFormatValid(instr,row,column))return false;
      if(instr!=null && instr.trim().length()>0){
        int rate=Integer.parseInt(instr);
        if(rate>100||rate<0){
          return false;
        }
      }
      return true;
    }
  }
  class QtyVfyObj implements exgui.ultratable.CellTxtEditorFormat {
   javax.swing.JTable _jtable;
   QtyVfyObj(javax.swing.JTable jtable){
     _jtable=jtable;
   }
    exgui.ultratable.CellTxtEditorFormat vfyObj=
        exgui.verification.CellFormat.getIntVerifierAllowNull(6);
   String myWarnningMsg="String must be in integer format";
   public int getMaxLength(){return 6;}
   public String formatPromptMsg(){
    return myWarnningMsg;
   }
   public Object cellStringToObject(String str){
    return vfyObj.cellStringToObject(str);
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)vfyObj).getKeyListener();
   }
   synchronized public boolean isFormatValid(String instr,int row,int column){
     if(!vfyObj.isFormatValid(instr,row,column)){
       myWarnningMsg=vfyObj.formatPromptMsg();
       _jtable.editCellAt(row,column);
       return false;
     }
     //sum up the value of quta quantities...
     int summed_value=0;
     for(int i=0;i<15;i++){
       Object vlObj=_jtable.getValueAt(i,1);
       Object catObj=_jtable.getValueAt(i,0);
       if(catObj==null)continue;
       if(catObj.toString()==null)continue;
       if(catObj.toString().trim().equals(""))continue;
       //Integer intObj=new Integer(0);
       if(vlObj!=null){
         if(!vlObj.toString().equals("")){
           if(exgui.verification.VerifyLib.isInteger(vlObj.toString())){
            summed_value+=Integer.parseInt(vlObj.toString());
           }else{
            exgui.verification.VerifyLib.showAlert(myWarnningMsg,myWarnningMsg);
            break;
           }
         }
       }
     }
      lblTotal.setText("          TOTAL:"+summed_value);
     return true;
    }
  }

}
