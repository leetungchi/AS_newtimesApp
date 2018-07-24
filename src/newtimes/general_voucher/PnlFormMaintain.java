package newtimes.general_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFormMaintain extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  Panel2List pnlList = null;//new JPanel();

  public PnlFormMaintain() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    java.util.Hashtable ht=new Hashtable();
    iso.put("FORM","FORM_ID");
    iso.put("PAGE","PAGE");
    iso.put("LINE","LINE");
    iso.put("CODE","CODE");
    iso.put("      DESCRIPTION      ","DESCRIPTION");
    ht.put("FORM",exgui.verification.CellFormat.getOrdinaryField(2));
    ht.put("PAGE",exgui.verification.CellFormat.getOrdinaryField(2));
    ht.put("LINE",exgui.verification.CellFormat.getDoubleFormatAllowNull(2,2));
    ht.put("CODE",exgui.verification.CellFormat.getOrdinaryField(8));
    ht.put("      DESCRIPTION      ",exgui.verification.CellFormat.getOrdinaryField(40));
    pnlList=new Panel2List( new TempDb(),100,iso,ht);
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("損益表欄位維護功能");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 801, 30));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnUpdate.setBounds(new Rectangle(186, 524, 115, 28));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(554, 524, 115, 28));
    pnlList.setBounds(new Rectangle(10, 56, 775, 464));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnUpdate, null);
    this.add(btnExit, null);
    this.add(pnlList, null);
    pnlList.firstPage();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(pnlList.isContextModified()){
         if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nAre You Sure To Exit Current Page?",
                                                      "Context Modified",false))return;
      }
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      pnlList.doUpdate();
      pnlList.reload();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Failed\nPlease Contact System Manager",
                                             "Update Failed");

    }

  }
  class Panel2List extends processhandler.template.PnlTableEditor {
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        jbtnPrev.setVisible(false);
        jbtnNext.setVisible(false);
        jbtnLast.setVisible(false);
        jbtn1st.setVisible(false);
    }
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().setRowHeight(20);
      getJtable().setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
       try{
         rec.set(storedRecordColumn[col],obj);
         return rec;
       }catch(Exception exp){
         exp.printStackTrace();
         return null;
       }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(getObject2StringConvertor());
    }
  }

  class  TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
    Record recBlank=null;
    TempDb(){
      try{
         recBlank=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
         recBlank.getFieldName().clear();
         recBlank.getValueFields().clear();
         recBlank.getModifiedFields().clear();
        //call all columns and values.
         recBlank.getFieldName().add("FORM_ID");
         recBlank.getFieldName().add("PAGE");
         recBlank.getFieldName().add("LINE");
         recBlank.getFieldName().add("CODE");
         recBlank.getFieldName().add("DESCRIPTION");
         recBlank.getFieldName().add("RECORD_CREATE_USER");
         recBlank.getFieldName().add("RECORD_CREATE_DATE");
         recBlank.getFieldName().add("RECORD_DELETE_FLAG");
         recBlank.getFieldName().add("RECORD_DELETE_DATE");
         recBlank.getFieldName().add("RECORD_DELETE_USER");
         recBlank.getFieldName().add("RECORD_MODIFY_DATE");
         recBlank.getFieldName().add("RECORD_MODIFY_USER");
         for(int i=0;i<recBlank.getFieldName().size();i++)recBlank.getValueFields().add(null);
         recBlank.set("RECORD_DELETE_FLAG","1");
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    public Record getBlankRecord()throws Exception{
      return (Record)util.MiscFunc.deepCopy(recBlank);
    }
    public void updateRecords(Vector vct)throws Exception{
       //get all vector to update.
       if(vct.size()==0)return;
       Vector vct2Proc=new Vector();
       for(int i=0;i<pnlList.getJtable().getRowCount();i++){
          Object objFM=pnlList.getJtable().getValueAt(i,0);
          Object objPage=pnlList.getJtable().getValueAt(i,1);
          Object objLine=pnlList.getJtable().getValueAt(i,2);
          Object objCode=pnlList.getJtable().getValueAt(i,3);
          Object objDecs=pnlList.getJtable().getValueAt(i,4);
          if((objFM==null || objFM.toString().trim().length()==0) ||
             (objPage==null || objPage.toString().trim().length()==0) ||
             (objLine==null || objLine.toString().trim().length()==0) ||
             (objCode==null || objCode.toString().trim().length()==0)
             ){
             continue;
          }else{
            Record rec=getBlankRecord();
            rec.set(0,objFM);
            rec.set(1,objPage);
            rec.set(2,objLine);
            rec.set(3,objCode);
            rec.set(4,objDecs);
            rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
            vct2Proc.add(rec);
          }
       }
       //vct2Proc
       util.MiscFunc.showProcessingMessage();
       newtimesejb.GnVoucher.GnVoucherFacadeHome  gvEjbHome=
           (newtimesejb.GnVoucher.GnVoucherFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.GnVoucher.GnVoucherFacade");
       newtimesejb.GnVoucher.GnVoucherFacade ejb=gvEjbHome.create();
       ejb.handleFormMaintainData(vct2Proc);
       util.MiscFunc.hideProcessingMessage();
    }
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,"select * from VH_FORM_MAINTAIN order by form_id,page,line",1,99999);
      //always add 10 blank records to it
      for(int i=0;i<10;i++){
        Record rec=getBlankRecord();
        rec.set("RECORD_CREATE_USER",util.PublicVariable.USER_RECORD.get(0));
        vct.add(rec);
      }
      return vct;
    }
  }
}
