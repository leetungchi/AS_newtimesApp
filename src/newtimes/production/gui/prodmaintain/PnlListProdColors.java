package newtimes.production.gui.prodmaintain;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import newtimes.production.process.prodmaintain.DB_ProdColorHandler;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListProdColors extends PnlTableEditor
    implements java.awt.event.ItemListener {
  DB_ProdColorHandler myHandler;
  static String COLUMN_COLOR_NAME="  COLOR NAME  ";
  static String COLUMN_COLOR_CODE="  COLOR CODE  ";

  static String COLUMN_NY_QTY1="NY\nQTY1";
  static String COLUMN_NY_QTY2="NY\nQTY2";
  static String COLUMN_NY_DELIVERY1="NY\nDelivery1";
  static String COLUMN_NY_DELIVERY2="NY\nDelivery2";
  static String COLUMN_BRSTL_QTY="Bristol\nQuantity";
  static String COLUMN_BRSTL_DLV="Bristol\nDelivery";
  static String COLUMN_CDA_QTY1="CDA\nQTY1";
  static String COLUMN_CDA_QTY2="CDA\nQTY2";

  //add at 20040203
  static String COLUMN_FINISH_DATE="Finish\nDate";
  static String COLUMN_PLAN_ETD="Plan\nETD";
  static String COLUMN_SMPL_PLAN_DATE="Plan";
  static String COLUMN_SMPL_ACT_DATE="Actual";
  static String COLUMN_INSP_PLAN_DATE=" Plan";
  static String COLUMN_INSP_ACT_DATE=" Actual";
  static String COLUMN_SHIPMENT_PLAN_DATE="Plan ";
  static String COLUMN_SHIPMEMT_ACT_DATE="Actual ";
  static String COLUMN_SMPL_APRL="Sample\nAPRL.";
  static String COLUMN_NEW_RUN="NEW\nRUN";
  //finsh add at 20040203
  static String COLUMN_REMARK="        Remark        ";

  java.util.HashMap colorCodeNameMapping;
  javax.swing.JComboBox jbcxColors=new javax.swing.JComboBox();
  Vector colorCodeItems=null;
  Vector colorName2Map=null;
  boolean isInitializing=false;
  int RECORD_MODIFY_USER_COLUMN_AT=0;
  String colorNameArr[]=null;
  String colorCodeArr[]=null;
  String colorRemarkArr[]=null;
  public PnlListProdColors() {
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    getJtable().setRowHeight(50);
    getJtable().addMouseMotionListener(newtimes.production.ProdMaintain_Properties.getJTableToolTipGenerator(getJtable(),1));
    try{
      RECORD_MODIFY_USER_COLUMN_AT=
        util.MiscFunc.getFieldIndexAtRecord(myHandler.getBlankRecord(),"RECORD_MODIFY_USER");
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      rec.set(storedRecordColumn[columnAt],value2update);
      rec.set(RECORD_MODIFY_USER_COLUMN_AT,util.PublicVariable.USER_RECORD.get("usr_code"));
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return rec;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(COLUMN_COLOR_NAME,"PROD_COLOR_NAME");//0
    iso.put(COLUMN_COLOR_CODE,"PROD_COLOR_CODE");//1
     iso.put(COLUMN_REMARK,"PROD_REMARK");
    //added at 20040203
    iso.put(COLUMN_FINISH_DATE,"FINISH_DATE"); //2
    iso.put(COLUMN_PLAN_ETD,"PLAN_ETD_DATE");  //3
    iso.put(COLUMN_SMPL_PLAN_DATE,"SMPL_PLAN_DATE"); //4
    iso.put(COLUMN_SMPL_ACT_DATE,"SMPL_ACT_DATE");//5
    iso.put(COLUMN_INSP_PLAN_DATE,"INSP_PLAN_DATE");//6
    iso.put(COLUMN_INSP_ACT_DATE,"INSP_ACT_DATE");//7
    iso.put(COLUMN_SHIPMENT_PLAN_DATE,"SHIPMENT_PLAN_DATE");//8
    iso.put(COLUMN_SHIPMEMT_ACT_DATE,"SHIPMENT_ACT_DATE");//9
    iso.put(COLUMN_SMPL_APRL,"SMPL_APRL");//10
    iso.put(COLUMN_NEW_RUN,"NEW_RUN");//11
//    iso.put(COLUMN_REMARK,"PROD_REMARK");
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
       multiEditorJTableInSuper.addTextAreaEditor(2,100);
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    multiEditorJTableInSuper.setTableColumn2Grp("SAMPLE",5);
    multiEditorJTableInSuper.setTableColumn2Grp("SAMPLE",6);
    multiEditorJTableInSuper.setTableColumn2Grp("INSPECT",7);
    multiEditorJTableInSuper.setTableColumn2Grp("INSPECT",8);
    multiEditorJTableInSuper.setTableColumn2Grp("SHIPMENT",9);
    multiEditorJTableInSuper.setTableColumn2Grp("SHIPMENT",10);
//    multiEditorJTableInSuper.addTextAreaEditor(12,100);
    isInitializing=true;
    colorCodeItems=new Vector();
    colorName2Map=new Vector();
    Vector preprodColors=myHandler.preprod_colors;
    for(int i=0;i<preprodColors.size();i++){
      Record recPrepColor=(Record)preprodColors.get(i);
      colorCodeItems.add(recPrepColor.get(0));
      colorName2Map.add(recPrepColor.get(1));
    }
    colorNameArr=(String[])colorName2Map.toArray(new String[0]);
    colorCodeArr=(String[])colorCodeItems.toArray(new String[0]);
    jbcxColors=new javax.swing.JComboBox(colorName2Map);
    jbcxColors.setEditable(true);
    jbcxColors.addItemListener(this);
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel();
    dtm.registEditableColumn(COLUMN_COLOR_NAME);
    javax.swing.DefaultCellEditor  dce=new javax.swing.DefaultCellEditor(jbcxColors);
    getJtable().getColumn(COLUMN_COLOR_NAME).setCellEditor(dce);
    isInitializing=false;
  }
  public void itemStateChanged(java.awt.event.ItemEvent e) {
    if(!isInitializing){
      int rowAt=getJtable().getEditingRow();
      if(rowAt<0) return;
      if(jbcxColors.getSelectedIndex()!=-1){
        getJtable().setValueAt(colorCodeItems.get(jbcxColors.getSelectedIndex()),rowAt,1);
      }
    }
  }
  protected int getEachPageRowCount() {
    return 9999;
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable ht=new Hashtable();
    Object int1Dtg=exgui.verification.CellFormat.getIntVerifierAllowNull(1);
    Object int2Dtg=exgui.verification.CellFormat.getIntVerifierAllowNull(3);
    Object char5Vft4ColorCode=exgui.verification.CellFormat.getOrdinaryField(8);
    Object char3Vft4ColorCode=exgui.verification.CellFormat.getOrdinaryField(4);
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object rmkVfy=exgui.verification.CellFormat.getOrdinaryField(100);
    ht.put(COLUMN_COLOR_CODE,char5Vft4ColorCode);
    ht.put(COLUMN_FINISH_DATE,dateVfy);
    ht.put(COLUMN_PLAN_ETD,dateVfy);
    ht.put(COLUMN_SMPL_PLAN_DATE,dateVfy);
    ht.put(COLUMN_SMPL_ACT_DATE,dateVfy);
    ht.put(COLUMN_INSP_PLAN_DATE,dateVfy);
    ht.put(COLUMN_INSP_ACT_DATE,dateVfy);
    ht.put(COLUMN_SHIPMENT_PLAN_DATE,dateVfy);
    ht.put(COLUMN_SHIPMEMT_ACT_DATE,dateVfy);
    ht.put(COLUMN_SMPL_APRL,dateVfy);
    ht.put(COLUMN_NEW_RUN,char3Vft4ColorCode);
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(myHandler==null){
      myHandler=new DB_ProdColorHandler(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
          );
    }
    return myHandler;
  }
 boolean isColorNamesOK(){
   //java.util.HashMap hmchecked=new java.util.HashMap();
   boolean isNeed2ChkColorCode=(!(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||util.PublicVariable.OPERATTING_CENTER.equals("001")));

   for(int i=0;i<getJtable().getRowCount();i++){
     String colorName=((String)getJtable().getValueAt(i,0)).trim();
     String colorCode=((String)getJtable().getValueAt(i,1)).trim();
     if(colorName.length()==0){
       exgui.verification.VerifyLib.showAlert("Color  Name Can Not Be blank","Color Name Can Not Be Blank");
       getJtable().editCellAt(i,0);
       return false;
     }
     if(colorName.length()>80){
       exgui.verification.VerifyLib.showAlert("Color  Name Too Long,Over 80 Characters","Color Name Too Long");
       getJtable().editCellAt(i,0);
       return false;
     }
     if(isNeed2ChkColorCode){
       //for NTHK user,need to check color code.
       if (colorCode.length() == 0) {
         exgui.verification.VerifyLib.showAlert("Color Code Can Not Be blank",
                                                "Color Code Can Not Be Blank");
         getJtable().editCellAt(i, 1);
         return false;
       }
     }

     /*
     if(hmchecked.containsKey(colorName)){
       exgui.verification.VerifyLib.showAlert("Color  Name Duplicated","Color Name Duplicate");
       getJtable().editCellAt(i,0);
       return false;
     }else{
       hmchecked.put(colorName,null);
     }
     */
   }
   return true;
 }
 public void doAddNew() throws Exception{
  //super.addRecord();
  //pop out the sub panel.allow user to add 20 record by bacth
  DlgAddBchProdColor dlg2add=new DlgAddBchProdColor(
      processhandler.template.Properties.getMainFrame(),
      "Add Colors",true,
      (DB_ProdColorHandler)this.dbHandler,colorNameArr,colorCodeArr,colorRemarkArr);
  dlg2add.setSize(500,350);
  dlg2add.show();
  if(dlg2add.getOperationStatus()==dlg2add.STATUS_CLOSE_CANCEL||
     dlg2add.getOperationStatus()==dlg2add.STATUS_OPERATING)return;
  this.doUpdate();
  this.goPage(_rowPosition,_rowCounts);
}
public void doPaste(){
  Object storedObj = util.ApplicationProperites.getProperties(
      id4ApplicationProperties
      );
  if (storedObj == null) {
    exgui.verification.VerifyLib.showPlanMsg(
        "No Copied Data To Paste", "No Copied Data To Paste");
    return;
  }
  if (getJtable().getSelectedRow() < 0) {
    exgui.verification.VerifyLib.showPlanMsg(
        "Please Select A Row To Paste Copied Data", "Please Select A Row");
    return;
  }
  int selectedRow[] = getJtable().getSelectedRows();
  if (super.getJtable().getCellEditor() != null)
    super.getJtable().getCellEditor().cancelCellEditing();
  copiedColumns = (Object[]) storedObj;
  for (int i = 2; i < copiedColumns.length; i++) {
    for(int j=0;j<selectedRow.length;j++){
      if(getJtable().getModel().isCellEditable(selectedRow[j], i)){
        getJtable().setValueAt(
            copiedColumns[i],
            selectedRow[j], i
            );
      }
    }
  }

}
 public void doDelete()throws Exception{
   //check if the color referacne to any price record

   if(getJtable().getSelectedRow()<0){
     exgui.verification.VerifyLib.showPlanMsg(
     "Please Select A Row To Delete","Please Select A Delete");
     return;
   }
   util.MiscFunc.showProcessingMessage();
   int selectRowId[]=getJtable().getSelectedRows();
  for(int i=0;i< selectRowId.length;i++){
    Record rec2delete = (Record)getDisplayingRecords().get(selectRowId[i]);
    String colorName2del=(String)rec2delete.get("PROD_COLOR_NAME");
    String colorCode2del=(String)rec2delete.get("PROD_COLOR_CODE");
    int prodColorPk = rec2delete.getInt(0);
    Vector vct2checkInPrice = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select count(*) from price where record_delete_flag='1' and  price.PROD_COLOR_PK=" +
        prodColorPk,
        1, 9999);

    int recCount = ((Record)vct2checkInPrice.get(0)).getInt(0);
    if (recCount > 0) {
      exgui.verification.VerifyLib.showAlert(
          "This Color "+colorName2del+":"+colorCode2del+" is referenced by Prices record(s)\nPlease Delete Qty reocrds Related To This Color Before You Delete This Color Data",
          "Color Is In Used");
      return;
    }
    vct2checkInPrice = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select count(*) from ship_price where record_delete_flag='1' and  ship_price.PROD_COLOR_PK=" +
        prodColorPk,
        1, 9999);
    recCount = ((Record)vct2checkInPrice.get(0)).getInt(0);
    if (recCount > 0) {
      exgui.verification.VerifyLib.showAlert(
          "This Color "+colorName2del+":"+colorCode2del+" is reference by Ship Prices record(s)\nPlease Delete Ship Qty/Price reocrds Related To This Color Before You Delete This Color Data",
          "Color Is In Used");
      return;
    }
  }
  util.MiscFunc.hideProcessingMessage();
   super.doDelete();
 }
 public void doUpdate()throws Exception{
   try{
     if (!isColorNamesOK())
       return;
     util.MiscFunc.showProcessingMessage();
     getJtable().clearSelection();
     super.updateModifiedRecord();
     myHandler.confirmedUpdate2CallRemote();
     table_snapshot=util.MiscFunc.table2Text(getJtable());
     //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
     reload();
   }catch(Exception e){
     util.MiscFunc.hideProcessingMessage();
     throw e;
   }finally{
     util.MiscFunc.hideProcessingMessage();
   }
 }
}
