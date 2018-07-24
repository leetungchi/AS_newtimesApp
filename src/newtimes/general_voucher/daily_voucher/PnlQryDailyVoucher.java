package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryDailyVoucher extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtInvNo = new JTextField();
  JButton btnAdd = new JButton();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtDateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  exgui.DataBindJCombobox dbCbxCompany,dbAccUser;
  exgui.DataBindTextWithChecker dbTxtDateFrom,dbTxtDateTo;
  static StringBuffer SB_CONDITOIN_STR;
  JLabel jLabel1 = new JLabel();
  JTextField txtVhNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCreateUser = new JComboBox();
  //JTextField txtAccCode = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  newtimes.general_voucher.DbAccCodeEditor dbCbxTblAccItem = new newtimes.general_voucher.DbAccCodeEditor();
  public PnlQryDailyVoucher() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("DAILY VOUCHER MAINTENANCE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 20, 806, 28));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel1.setForeground(Color.white);
    whiteBkgBlueCharLabel1.setText("VOUCHER NO");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(188, 106, 107, 28));
    txtInvNo.setText("");
    txtInvNo.setBounds(new Rectangle(295, 209, 114, 28));
    btnAdd.setBounds(new Rectangle(329, 505, 102, 28));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnQry.setText("EXTRACT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setBounds(new Rectangle(81, 505, 102, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setBounds(new Rectangle(561, 505, 102, 28));
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel2.setText("VOUCHER DATE FROM:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(188, 158, 157, 28));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(346, 158, 79, 28));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(425, 158, 34, 28));
    blueBkgWhiteCharLabel3.setText("TO");
    txtDateTo.setBounds(new Rectangle(459, 158, 79, 28));
    txtDateTo.setText("");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(188, 55, 108, 28));
    whiteBkgBlueCharLabel2.setText("COMPANY");
    cbxCompany.setBounds(new Rectangle(297, 55, 214, 28));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("(YYYY/MM/DD)");
    jLabel1.setBounds(new Rectangle(541, 158, 94, 23));
    txtVhNo.setBounds(new Rectangle(295, 106, 114, 28));
    txtVhNo.setText("");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(188, 209, 107, 28));
    whiteBkgBlueCharLabel3.setText("INVOICE NO");
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel4.setForeground(new Color(144, 144, 188));
    whiteBkgBlueCharLabel4.setText("製單人");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(188, 312, 108, 28));
    cbxCreateUser.setBounds(new Rectangle(295, 312, 214, 28));
    dbCbxTblAccItem.setBounds(new Rectangle(294, 261, 213, 28));
    //txtAccCode.setText("");
    whiteBkgBlueCharLabel5.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel5.setForeground(Color.white);
    whiteBkgBlueCharLabel5.setText("科目");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(187, 261, 107, 28));
    this.add(cbxCompany, null);
    this.add(txtVhNo, null);
    this.add(txtDateFrom, null);
    this.add(txtDateTo, null);
    this.add(txtInvNo, null);
    this.add(cbxCreateUser, null);

    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnAdd, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(whiteBkgBlueCharLabel4, null);

    this.add(whiteBkgBlueCharLabel2, null);

    this.add(blueBkgWhiteCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);

    this.add(jLabel1, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(dbCbxTblAccItem, null);
    /// accounting user...
    StringBuffer sb_sql = new StringBuffer();
    sb_sql.append("select * from ");
    sb_sql.append("(select usr_code,usr_name from userfile where usr_type = 9 and usr_cen_code='001' ");
    sb_sql.append(" union all ");
    sb_sql.append("select usr_code,usr_name from userfile where usr_code='JENNY LIU') ");
    sb_sql.append("order by usr_name ");
    dbAccUser =
   /*     new exgui.DataBindJCombobox(cbxCreateUser, "",
                                     exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                     "select usr_code,usr_name from userfile where usr_type = 9 and usr_cen_code='001' order by usr_name"
                                     ,1,9999) ,
                                    "usr_name", "usr_code",null,"ALL",null);  */
        new exgui.DataBindJCombobox(cbxCreateUser, "",
                           exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                           sb_sql.toString()
                           ,1,9999) ,
                          "usr_name", "usr_code",null,"ALL",null);



    dbCbxCompany =
        new exgui.DataBindJCombobox(cbxCompany, "",
                                    newtimes.general_voucher.daily_voucher.
                                    Constants.VCT_GV_ACC_COMPANY,
                                    "comp_code_and_name", "cmp_code",null,"ALL",null);

    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateFrom=
        new exgui.DataBindTextWithChecker(txtDateFrom,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    dbTxtDateTo=
        new exgui.DataBindTextWithChecker(txtDateTo,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);

    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("CODE","ITEM_CODE");
    iso.put("D/C","D_C");
    iso.put("     NAME    ","ITEM_NAME");

     java.util.Vector vct_acc_item=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from GV_ACC_ITEM where record_delete_flag='1'",1,999);


    dbCbxTblAccItem.init("VH_ACCOUNT",
                         vct_acc_item, iso, 250, 150,
                         "ITEM_CODE", "ITEM_CODE",
                         null);

  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
       if(Constants.VCT_STAFF==null)Constants.initStaffVector();
       TgrEditDailyVoucher.INIT_DATE=null;
       TgrEditDailyVoucher.INIT_VH_NO=null;
       TgrEditDailyVoucher tgr=new TgrEditDailyVoucher();
       processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

 void composeQryParam(){
   //QRY_STR_LIST=new java.util.ArrayList();
   SB_CONDITOIN_STR=new StringBuffer();
   SB_CONDITOIN_STR.append(" ");

   if(null!=dbTxtDateFrom.getSelectedValue()){
     SB_CONDITOIN_STR.append(" and ");
     SB_CONDITOIN_STR.append(" VH_DATE >=to_date('");
     SB_CONDITOIN_STR.append(txtDateFrom.getText());
     SB_CONDITOIN_STR.append("','yyyy/mm/dd') ");
   }
   if(null!=dbTxtDateTo.getSelectedValue()){
     SB_CONDITOIN_STR.append(" and ");
     SB_CONDITOIN_STR.append(" VH_DATE <=to_date('");
     SB_CONDITOIN_STR.append(txtDateTo.getText());
     SB_CONDITOIN_STR.append("','yyyy/mm/dd') ");
   }

   if(null!=dbAccUser.getSelectedValue()){
     SB_CONDITOIN_STR.append(" and ");
     SB_CONDITOIN_STR.append(" get_vh_create_user(vh_no)='");
     SB_CONDITOIN_STR.append(dbAccUser.getSelectedValue());
     SB_CONDITOIN_STR.append("' ");
   }

   if(null!=dbCbxCompany.getSelectedValue()){
     SB_CONDITOIN_STR.append(" and substr(vh_no,1,1)='");
     String cmpyCode=(String)dbCbxCompany.getSelectedValue();
     cmpyCode=util.MiscFunc.Replace(cmpyCode,"'","''");
     SB_CONDITOIN_STR.append(cmpyCode);
     SB_CONDITOIN_STR.append("' ");
   }
   if(txtVhNo.getText().trim().length()>0){
     SB_CONDITOIN_STR.append(" and VH_NO like '");
     String vhNo=txtVhNo.getText().toUpperCase();
     vhNo=util.MiscFunc.Replace(vhNo,"'","''");
     SB_CONDITOIN_STR.append(vhNo);SB_CONDITOIN_STR.append("%' ");
   }
   if(txtInvNo.getText().trim().length()>0){
     SB_CONDITOIN_STR.append(" and VH_INVOICE like '");
     String invNo=txtInvNo.getText().toUpperCase();
     invNo=util.MiscFunc.Replace(invNo,"'","''");
     SB_CONDITOIN_STR.append(invNo);SB_CONDITOIN_STR.append("%' ");
   }
   //database.datatype.Record recAcc=(database.datatype.Record)dbCbxTblAccItem.getPnlList().getDisplayingRecords().get(dbCbxTblAccItem.getPnlList().getJtable().getSelectedRow());
   //if(recAcc.get(1)!=null){
   if(dbCbxTblAccItem.getSelectedValue()!=null){
       SB_CONDITOIN_STR.append(" and substr(VH_ACCOUNT,1,4)='");
       /*
       database.datatype.Record rec=(database.datatype.Record)
           dbCbxTblAccItem.getPnlList().getDisplayingRecords().get(dbCbxTblAccItem.getPnlList().getJtable().getSelectedRow());
       */
       //SB_CONDITOIN_STR.append(recAcc.get(1));
       SB_CONDITOIN_STR.append(dbCbxTblAccItem.getSelectedValue());
       SB_CONDITOIN_STR.append("' ");
   }


 }
  void btnQry_actionPerformed(ActionEvent e) {
    try{
      if(txtDateFrom.getText().trim().length()==0 &&
         txtInvNo.getText().trim().length()==0 &&
         txtVhNo.getText().trim().length()==0  ){
        exgui.verification.VerifyLib.showAlert("請輸入傳票日期或是欲查詢的傳票編號","查詢範圍過大");
        return;
      }
      PnlListDailyVoucher.INIT_ROW_POS=1;
      composeQryParam();
      if(Constants.VCT_STAFF==null)Constants.initStaffVector();
       TgrListDailyVoucherQryResult tgr=new TgrListDailyVoucherQryResult();
       processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
