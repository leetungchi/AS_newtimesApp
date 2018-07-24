package newtimes.production.gui.prodmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListStyleConsumption
    extends exgui.ultratable.FuncAbstractUltraTablePanel
    implements processhandler.DataProcesser
    //javax.swing.event.TableModelListener
    //java.awt.event.ItemListener
   {
  java.util.Hashtable obj2strincnv=null;
  InsertionOrderedHashMap clmHeadMapping=null;
  java.util.Vector colorRecords=null;
  java.util.Vector fabpoRecords=null;

  javax.swing.JComboBox colorCbx=null;
  public static String DISP_CLM_YY1=null;
  public static String DISP_CLM_YY2=null;
  public static String DISP_CLM_YY3=null;
  public static String DISP_CLM_YY4=null;
  public static String DISP_CLM_FBRC_PO="Fabric PO\n(Color Name)";
  public static String DISP_CLM_COLOR_NAME="  Color\nName  ";
  public static String DISP_CLM_COLOR_CODE="  Color\nCode  ";
  public static String DISP_SUMMED_YIELD="  Yield  ";
  public static float STY_YY1_VALUE=0;
  public static float STY_YY2_VALUE=0;
  public static float STY_YY3_VALUE=0;
  public static float STY_YY4_VALUE=0;
  public static String TOTAL_YY1_AT_HT="TOTAL_YY1";
  public static String TOTAL_YY2_AT_HT="TOTAL_YY2";
  public static String TOTAL_YY3_AT_HT="TOTAL_YY3";
  public static String TOTAL_YY4_AT_HT="TOTAL_YY4";
  public static String TOTAL_YIELD_AT_HT="TOTAL_YIELD";
  public static int TOTAL_YIELD_COLUMN_AT=5;
  /*
  public static util.InsertionOrderedHashMap
      _HeadColumnMapping=null;
  public static java.util.Hashtable strCnvCex=null;
  */
  boolean isComposed=false;
  boolean isRefinding=false;
  JLabel lblTotal=new JLabel("Total:");
  JLabel lblyyTtl1=new JLabel("");
  JLabel lblyyTtl2=new JLabel("");
  JLabel lblyyTtl3=new JLabel("");
  JLabel lblyyTtl4=new JLabel("");
  JLabel lblYields=new JLabel("");
  Hashtable lastStoredJtableData=null;
  JButton btnDefaultYY1=new JButton("Get Default YY1");
  YYfldVfyObj myvfy=new YYfldVfyObj(getJtable());
  java.text.NumberFormat nf=new java.text.DecimalFormat("######.##");
  protected String table_snapshot=null;
  protected boolean isModified;
  public PnlListStyleConsumption(PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        java.util.Vector colors,java.util.Vector fabpos){
     super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
     colorRecords=colors;
     fabpoRecords=fabpos;
     //remove the flipping page function button,
     //place the jlabes to display the sum of yy and yield.
    getLowerRightPanel().removeAll();
    btnDefaultYY1.addActionListener(new getDefalutYY1());
    getLowerRightPanel().add(btnDefaultYY1);
     getPanelContainsButtons().removeAll();
     //java.awt.GridLayout glayout=new java.awt.GridLayout(1,6);
     //getLowerRightPanel().setLayout(glayout);
     getLowerRightPanel().add(lblTotal,null);
     getLowerRightPanel().add(lblyyTtl1,null);
     getLowerRightPanel().add(lblyyTtl2,null);
     getLowerRightPanel().add(lblyyTtl3,null);
     getLowerRightPanel().add(lblyyTtl4,null);
     getLowerRightPanel().add(lblYields,null);
     //getJtable().getParent().setSize(new Dimension(300,200));
     this.setBounds(0,0,300,200);
  }
  class getDefalutYY1 implements java.awt.event.ActionListener{
    public void actionPerformed(java.awt.event.ActionEvent e){
       //find out all the default yy1,fill to
       JTable tbl=getJtable();
       for(int i=0;i<getJtable().getRowCount();i++){
           tbl.editCellAt(i,0);
           JComboBox cbx=(JComboBox)tbl.getEditorComponent();
           //System.out.println(" index is:"+cbx.getSelectedIndex());
           Record rec=(Record)fabpoRecords.get(cbx.getSelectedIndex());
           Object defaultyy1_value=rec.get(7);
           tbl.setValueAt((defaultyy1_value==null)?"":defaultyy1_value.toString(),i,1);
           myvfy.modifiedYYvalue((defaultyy1_value==null)?"":defaultyy1_value.toString(),i,1);
       }
    }
  }
  public void exitCurrentGui(){}
  public boolean isContextModified(){
    if((util.MiscFunc.table2Text(getJtable()).equals(table_snapshot))){
      return isModified;
    }else{
      return true;
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
      if(!storedRecordColumn[columnAt].toLowerCase().equals("fcqx_total_yield"))
                              rec.set(storedRecordColumn[columnAt],value2update);
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return rec;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
    return super.tblHeadColumn;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
   // /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   isRefinding=true;
   multiEditorJTableInSuper.addJComboBox(0,fabpoRecords,"COMPOSE","Fcq_seq");
   //multiEditorJTableInSuper.addJComboBox(1,colorRecords,"PROD_COLOR_NAME","PROD_COLOR_PK");
   isRefinding=false;
   multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
   multiEditorJTableInSuper.setTableColumn2Grp("Consumption", 1);
   multiEditorJTableInSuper.setTableColumn2Grp("Consumption", 2);
   multiEditorJTableInSuper.setTableColumn2Grp("Consumption", 3);
   multiEditorJTableInSuper.setTableColumn2Grp("Consumption", 4);
   ((exgui.MultiClassTableModel)getJtable().getModel()).removeEditableColumn(DISP_CLM_FBRC_PO);
   ((exgui.MultiClassTableModel)getJtable().getModel()).removeEditableColumn(DISP_SUMMED_YIELD);
  }
  public void itemStateChanged(java.awt.event.ItemEvent e){
    isModified=true;
    if(!isRefinding){
     int slkAt=colorCbx.getSelectedIndex();
     if(slkAt<0) slkAt=0;
     database.datatype.Record rec=(database.datatype.Record)fabpoRecords.get(slkAt);
     //getJtable().setValueAt(rec.get(2),getJtable().getEditingRow(),1);
     getJtable().setValueAt(rec.get(4),getJtable().getEditingRow(),1);
     getJtable().setValueAt(rec.get(5),getJtable().getEditingRow(),2);
    }
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 99999;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    exgui.ultratable.CellTxtEditorFormat vfyObj=
        exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);

    java.util.Hashtable ht=new java.util.Hashtable();
    ht.put(DISP_CLM_YY1,myvfy);
    ht.put(DISP_CLM_YY2,myvfy);
    ht.put(DISP_CLM_YY3,myvfy);
    ht.put(DISP_CLM_YY4,myvfy);
    ht.put(DISP_SUMMED_YIELD,vfyObj);
    return ht;
  }
  public void doAddNew()throws Exception{
    DlgBchAddFabClr4StyConsum dlg2add=new DlgBchAddFabClr4StyConsum(
        processhandler.template.Properties.getMainFrame(),
        "Add Fabric Colors",true,
        (newtimes.production.process.prodmaintain.DB_FbcClrQty)this.dbHandler,this);
    dlg2add.setSize(400,350);
    dlg2add.show();
    if(dlg2add.getOperationStatus()==dlg2add.STATUS_CLOSE_CANCEL||
       dlg2add.getOperationStatus()==dlg2add.STATUS_OPERATING)return;
    this.goPage(_rowPosition,_rowCounts);
  }
  public void doDelete(){
    super.doDeleteRecord();
  }
  public void doPaste(){
     Object storedObj=util.ApplicationProperites.getProperties(
       id4ApplicationProperties
     );
     if(storedObj==null){
       exgui.verification.VerifyLib.showPlanMsg(
       "No Copied Data To Paste","No Copied Data To Paste");
       return;
     }
     if(getJtable().getSelectedRow()<0){
       exgui.verification.VerifyLib.showPlanMsg(
       "Please Select A Row To Paste Copied Data","Please Select A Row");
       return;
     }
     int selectedRow=getJtable().getSelectedRow();
     if(super.getJtable().getCellEditor()!=null)
       super.getJtable().getCellEditor().cancelCellEditing();
     copiedColumns=(Object[])storedObj;
     //style & po no need to copy
     for(int i=1;i<copiedColumns.length;i++){
         if(getJtable().isCellEditable(selectedRow,i)){
           getJtable().setValueAt(
               copiedColumns[i],
               selectedRow, i
               );
         }
     }
    reCountAllYY();
    showTotalValuesToGUI();
    isModified=true;
  }
  public void doCopy(){
    super.doCopy();
  }
  protected void makeTable(java.util.Vector vct){
    super.makeTable(vct);
    reCountAllYY();
    table_snapshot=util.MiscFunc.table2Text(getJtable());
    isModified=false;
    showTotalValuesToGUI();
  }
  public void doExit()throws Exception{
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  public void doUpdate()throws Exception{
    Cursor ksr=null;
     if(getParent()!=null){
       ksr=getParent().getCursor();
       getParent().setCursor(new Cursor(Cursor.WAIT_CURSOR));
     }
     try{
       if(!super.confirmUpdate()) return;
       util.MiscFunc.showProcessingMessage();
       dbHandler.updateRecords(getDisplayingRecords());
       this.goPage(1,9999999);
       isModified=false;
       util.MiscFunc.hideProcessingMessage();
      //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");
     }catch(Exception e){
       throw e;
     }finally{
       if(ksr!=null)getParent().setCursor(ksr);
       util.MiscFunc.hideProcessingMessage();
     }
  }
  public void reCountAllYY(){
    java.util.Vector vct=getDisplayingRecords();
    if(lastStoredJtableData==null)lastStoredJtableData=new Hashtable();
    lastStoredJtableData.clear();
    float sumnedYield=0;
    //for(int j=3;j<8;j++){
    for(int j=1;j<TOTAL_YIELD_COLUMN_AT+1 ;j++){
      double sumnedYYX=0;
      for(int i=0;i<vct.size();i++){
        Object cellObj=getJtable().getValueAt(i,j);
        String strInCell=(cellObj==null)?"":cellObj.toString();
            //System.out.print("cellObj is "+cellObj);
        lastStoredJtableData.put(String.valueOf(i)+"_"+String.valueOf(j),strInCell);
        if(strInCell.trim().length()>0){
          sumnedYYX+=Double.parseDouble(strInCell.trim());
        }
      }//sum the value to hashtable.
      String keyYY=getTotalYYCLMnameInStoreData(j);
      lastStoredJtableData.put(keyYY,nf.format(sumnedYYX));
    }

  }
  public void showTotalValuesToGUI(){
    //when everything is over ,show to jlabel.
    lblyyTtl1.setText("YY1:"+lastStoredJtableData.get(TOTAL_YY1_AT_HT).toString());
    lblyyTtl2.setText("YY2:"+lastStoredJtableData.get(TOTAL_YY2_AT_HT).toString());
    lblyyTtl3.setText("YY3:"+lastStoredJtableData.get(TOTAL_YY3_AT_HT).toString());
    lblyyTtl4.setText("YY4:"+lastStoredJtableData.get(TOTAL_YY4_AT_HT).toString());
    lblYields.setText("YIELDS:"+lastStoredJtableData.get(TOTAL_YIELD_AT_HT).toString());
  }
  float getUsingSTY_YY_BY_TblClm(int columnInJtable){
    switch(columnInJtable){
      case 1:
        return STY_YY1_VALUE;
      case 2:
        return STY_YY2_VALUE;
      case 3:
        return STY_YY3_VALUE;
      case 4:
        return STY_YY4_VALUE;
    }
    return STY_YY4_VALUE;
  }
  String getTotalYYCLMnameInStoreData(int columnInJtable){
    switch(columnInJtable){
      case 1:
        return TOTAL_YY1_AT_HT;
      case 2:
        return TOTAL_YY2_AT_HT;
      case 3:
        return TOTAL_YY3_AT_HT;
      case 4:
        return TOTAL_YY4_AT_HT;
    }
    return TOTAL_YIELD_AT_HT;
  }

  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return dbHandler;
  }
  class YYfldVfyObj implements exgui.ultratable.CellTxtEditorFormat {
   javax.swing.JTable _jtable;
   YYfldVfyObj(javax.swing.JTable jtable){
     _jtable=jtable;
   }
    exgui.ultratable.CellTxtEditorFormat vfyObj=
        exgui.verification.CellFormat.getIntVerifierAllowNull(7);
   String myWarnningMsg="String must be in integer format";
   public int getMaxLength(){return 7;}
   public String formatPromptMsg(){
    return myWarnningMsg;
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)vfyObj).getKeyListener();
   }

   public Object cellStringToObject(String str){
    return vfyObj.cellStringToObject(str);
   }
   void modifiedYYvalue(String str,int row,int column ){
     isModified=true;
     //find out the last sumned row & column of YY1,
     double usingStyYYValue=getUsingSTY_YY_BY_TblClm(column);
     String lastStoredCellString=(String)lastStoredJtableData.get(String.valueOf(row)+"_"+String.valueOf(column));
     if(lastStoredCellString==null)lastStoredCellString="";
     double newYYValue=(str.trim().length()==0)?0:Double.parseDouble(str);
     double lastYYValue=(lastStoredCellString.trim().length()==0)?0:Double.parseDouble(lastStoredCellString.trim());
     String  lastStoredJtableData_value=(String)lastStoredJtableData.get(TOTAL_YIELD_AT_HT);
     double lastTotalYIELD=
         (lastStoredJtableData_value==null||lastStoredJtableData_value.trim().length()==0)?0:Double.parseDouble(lastStoredJtableData_value);
     //minuse the last sumed YIELD value...
     String strTemp=
     (String)lastStoredJtableData.get(String.valueOf(row)+
                                      "_"+String.valueOf(TOTAL_YIELD_COLUMN_AT));

     double lastSumedYieldAtRow=(strTemp==null||strTemp.trim().length()==0)?0:Double.parseDouble(strTemp);


     lastTotalYIELD-=lastSumedYieldAtRow;
     lastSumedYieldAtRow-=(util.MiscFunc.getDoubleMultiply(lastYYValue,usingStyYYValue));
     lastSumedYieldAtRow+=(util.MiscFunc.getDoubleMultiply(newYYValue,usingStyYYValue));
     lastTotalYIELD+=lastSumedYieldAtRow;

     lastStoredJtableData.put(TOTAL_YIELD_AT_HT,
                              nf.format(lastTotalYIELD));

     lastStoredJtableData.put(String.valueOf(row)+"_"+String.valueOf(TOTAL_YIELD_COLUMN_AT),
                              nf.format(lastSumedYieldAtRow));

     getJtable().setValueAt(nf.format(lastSumedYieldAtRow),row,TOTAL_YIELD_COLUMN_AT);


     double lastSumedYYxClm=
            Double.parseDouble(
            (String)lastStoredJtableData.get(getTotalYYCLMnameInStoreData(column))
            );
     lastSumedYYxClm-=lastYYValue;
     lastSumedYYxClm+=newYYValue;
     lastStoredJtableData.put(
      getTotalYYCLMnameInStoreData(column),
      nf.format(lastSumedYYxClm));

     lastStoredJtableData.put(String.valueOf(row)+"_"+String.valueOf(column),str.trim());
     showTotalValuesToGUI();
   }
   synchronized public boolean isFormatValid(String instr,int row,int column){
     isModified=true;
     if(!_jtable.isCellEditable(row,column))return true;
     if(!vfyObj.isFormatValid(instr,row,column)){
       myWarnningMsg=vfyObj.formatPromptMsg();
       _jtable.editCellAt(row,column);
       return false;
     }
     modifiedYYvalue(instr,row,column);
     return true;
    }
  }
}
