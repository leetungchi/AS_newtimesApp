package newtimes.accounting.local_voucher;


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

public class PnlListDDK4XLV extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnEXIT = new JButton();
  //JPanel jPanel1 = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblBalanceAmt = new WhiteBkgBlueCharLabel();
  Panel2List pnl2list=null;
  DbLocalVoucherDDK dbHandlerDDK=new DbLocalVoucherDDK();
  JButton btnUpdate = new JButton();
  boolean isUpdateing=false;
  JButton btnDelete = new JButton();
  String SRN;
  PnlQryLocalVoucher pnlParent;
  public PnlListDDK4XLV(String _SRN,PnlQryLocalVoucher _pnlParent) {
    try {
      SRN=_SRN;
      pnlParent=_pnlParent;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("DEDUCT HISTORY LIST OF LOCAL VOUCHER OF"+SRN);
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
    iso.put(" CHECK NO ","CHK_NO");
    iso.put("CHECK\nAMT","CHK_AMT");
    iso.put("XRate","exchange_rate");
    iso.put("DEDUCT\nAMT","DDK_AMT");
    iso.put("傳票號碼","ACC_VOUCHER");
    iso.put("發票號碼","PURCHASE_VOUCHER");
    iso.put("OTHER\nAMT","OTHER_AMT");
    iso.put("   DESC  ","OTHER_AMT_DESC");

    iso.put("DEDUCT\nDATE","DDK_DATE");
    iso.put("CREATE\nDATE","record_create_date");
    iso.put("DEDUCT\nBY","RECORD_CREATE_USER");

    java.util.Hashtable ht=new Hashtable();
    Object objDcm=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(11,2); //exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
    Object objDateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object objChkCnv20=exgui.verification.CellFormat.getOrdinaryField(20);
    Object chr30=exgui.verification.CellFormat.getOrdinaryField(30);

    ht.put("傳票號碼",objChkCnv20);
    ht.put("發票號碼",objChkCnv20);
    ht.put("OTHER\nAMT","OTHER_AMT");
    ht.put("   DESC  ",chr30);


    ht.put(" CHECK NO ",objChkCnv20);
    ht.put("XRate",objDcm);
    ht.put("DEDUCT\nAMT",objDcm);
    ht.put("CHECK\nAMT",objDcm);
    ht.put("OTHER\nAMT",objDcm);
    ht.put("DEDUCT\nDATE",objDateCnv);
    ht.put("CREATE\nDATE",objDateCnv);

    pnl2list=new  Panel2List(new TempDb(),9999,iso,ht);
    pnl2list.setBounds(new Rectangle(12, 115, 775, 398));
    this.add(pnl2list, null);
    reloadAndBalance();
  }

  protected void reloadAndBalance()throws Exception{
    StringBuffer sb=new StringBuffer();

    sb.append("select ");
    sb.append("round( a.disc_amt +");
    sb.append(" ( decode(nvl(a.exchange_rate,0),0,1,a.exchange_rate) *  nvl(a.diff_ttl,0))");

    sb.append("- nvl ((select sum(c.DDK_AMT)  ");
    sb.append(" from LOCAL_VOUCHER_DEDUCT c  ");
    sb.append(" where c.SHIP_NO=a.ship_no  ");
    sb.append(" and c.record_delete_flag='1'),0) ");

    sb.append("-nvl ((select sum(c.OTHER_AMT)  ");
    sb.append(" from LOCAL_VOUCHER_DEDUCT c  ");
    sb.append(" where c.SHIP_NO=a.ship_no  ");
    sb.append(" and c.record_delete_flag='1'),0) ");

    sb.append(",2) ");
    sb.append(" as local_voucher_balance  ");
    sb.append("from  local_voucher a  ");
    sb.append("where a.ship_no='");
    sb.append(SRN);
    sb.append("'");



    Vector vcxt=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString()
      ,1,99999999);
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
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn("CREATE\nDATE");
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn("XRate");
       exgui.ultratable.CellRenderor4Amount cell4amt=new exgui.ultratable.CellRenderor4Amount();
        getJtable().getColumnModel().getColumn(1).setCellRenderer(cell4amt);
        getJtable().getColumnModel().getColumn(2+1).setCellRenderer(cell4amt);
        getJtable().getColumnModel().getColumn(5+1).setCellRenderer(cell4amt);
        getJtable().getColumnModel().getColumn(2).setPreferredWidth(45);
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
        "select * from LOCAL_VOUCHER_DEDUCT where SHIP_NO='"+SRN+"' order by LV_DDK_SEQ",
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
      pnlParent.pnl2list.doUpdateCurrentPage();
      pnlParent.pnl2list.reload();
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
         System.out.println("rec to delete "+rec.toString() );
         vct2del.add(rec);
       }
       util.MiscFunc.showProcessingMessage();
       pnl2list.getPagedDataFactory().updateRecords(vct2del);
       pnl2list.reload();

     }catch(Exception exp){
       exp.printStackTrace();
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }

  }

}
