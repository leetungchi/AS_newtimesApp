package newtimes.accounting.debit_note;

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

public class PnlListDDKOfADbcr extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnEXIT = new JButton();
  //JPanel jPanel1 = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblBalanceAmt = new WhiteBkgBlueCharLabel();
  Panel2List pnl2list=null;
  DbDebitNoteDDK dbHandlerDDK=new DbDebitNoteDDK();
  JButton btnUpdate = new JButton();
  boolean isUpdateing=false;
  JButton btnDelete = new JButton();
  public PnlListDDKOfADbcr() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("DEDUCT HISTORY LIST OF "+(String)Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0));
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 31, 802, 30));
    this.setLayout(null);
    btnEXIT.setBounds(new Rectangle(587, 531, 129, 32));
    btnEXIT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));

    whiteBkgBlueCharLabel1.setText("BALANCE AMT:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(12, 74, 115, 33));
    lblBalanceAmt.setText("");
    lblBalanceAmt.setBounds(new Rectangle(126, 74, 153, 33));
    btnUpdate.setBounds(new Rectangle(85, 531, 129, 32));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnDelete.setBounds(new Rectangle(336, 531, 129, 32));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnEXIT, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(lblBalanceAmt, null);
    this.add(btnUpdate, null);
    this.add(btnDelete, null);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("       CHECK NO           ","CHK_NO");
    iso.put("   CHECK AMT        ","CHK_AMT");
    iso.put("   DEDUCT AMT       ","DDK_AMT");
    iso.put("OTHER AMT","DDK_OTHER_AMT");
    iso.put("  DESC.   ","DDK_DESC");
    iso.put("  DEDUCT DATE ","DDK_DATE");
    iso.put("CREATE DATE   ","record_create_date");
    iso.put("   DEDUCT BY   ","RECORD_CREATE_USER");
    java.util.Hashtable ht=new Hashtable();
    Object objDcm=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(11,2); //exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
    Object objDateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object objChkCnv20=exgui.verification.CellFormat.getOrdinaryField(20);
    Object objChkCnv100=exgui.verification.CellFormat.getOrdinaryField(100);
    ht.put("       CHECK NO           ",objChkCnv20);
    ht.put("   DEDUCT AMT       ",objDcm);
    ht.put("   CHECK AMT        ",objDcm);
    ht.put("OTHER AMT",objDcm);
    ht.put("  DESC.   ",objChkCnv100);

    ht.put("  DEDUCT DATE ",objDateCnv);
    ht.put("CREATE DATE   ",objDateCnv);

    pnl2list=new  Panel2List(new TempDb(),9999,iso,ht);
    pnl2list.setBounds(new Rectangle(12, 115, 775, 398));
    this.add(pnl2list, null);
    reloadAndBalance();
  }

  protected void reloadAndBalance()throws Exception{
    Vector vcxt=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select round(a.dbnt_total_amt-get_ddk_amt(a.dbnt_no),2) as blc_amt from debitnote_head a where a.dbnt_no='"+
      (String)Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0)+"'",1,99999999);
    Record recBlcAmt=(Record)vcxt.get(0);
    lblBalanceAmt.setText(recBlcAmt.get(0).toString());
    pnl2list.firstPage();
  }
  class Panel2List extends exgui.ultratable.FuncAbstractUltraTablePanel {
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
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
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn("CREATE DATE   ");
       exgui.ultratable.CellRenderor4Amount cell4amt=new exgui.ultratable.CellRenderor4Amount();
        getJtable().getColumnModel().getColumn(1).setCellRenderer(cell4amt);
        getJtable().getColumnModel().getColumn(2).setCellRenderer(cell4amt);
        getJtable().getColumnModel().getColumn(3).setCellRenderer(cell4amt);

    }
    public void doUpdate()throws Exception{
        super.updateModifiedRecord();
    }
  }

 class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
   public Vector getRecords(int bgn,int rowcount)throws Exception{
     util.MiscFunc.showProcessingMessage();
       Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
        "select * from DEBITNOTE_DEDUCT where DBNT_NO='"+(String)Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0)+"' order by DBNT_DDK_SEQ",
        bgn,rowcount);
     util.MiscFunc.hideProcessingMessage();
     return vct;
    }
   public void updateRecords(Vector vct2update)throws Exception{
     if(vct2update==null || vct2update.size()==0 && isUpdateing){
       exgui.verification.VerifyLib.showAlert("No Data To Update","No Data To Update");
       return;
     }
     util.MiscFunc.showProcessingMessage();
     dbHandlerDDK.updateRecords(vct2update);
     util.MiscFunc.hideProcessingMessage();
   }
 }
  void btnEXIT_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      isUpdateing=true;
      pnl2list.doUpdate();
      reloadAndBalance();
      isUpdateing=false;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("update Fail,Please contact System manager",
                                             "update Fail,Please contact System manager");
    }
  }
  void btnDelete_actionPerformed(ActionEvent e) {
     int rows[]=pnl2list.getJtable().getSelectedRows();
     if(rows.length==0){
       exgui.verification.VerifyLib.showAlert("Please Seelect Row To Delete",
                                              "Please Seelect Row");
     }
     if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete Select Rows ?","Do You Sure",false) ){
       return;
     }
     Vector vct2del=new Vector();
     try{
       for(int i=0;i<rows.length;i++){
         database.datatype.Record rec=(database.datatype.Record)pnl2list.getDisplayingRecords().get(rows[i]);
         rec.set("record_delete_flag","0");
         rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
         vct2del.add(rec);
       }
       util.MiscFunc.showProcessingMessage();
       pnl2list.getPagedDataFactory().updateRecords(vct2del);
       //pnl2list.reload();
       reloadAndBalance();
     }catch(Exception exp){
       exp.printStackTrace();
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }

  }

}
