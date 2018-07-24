package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditDailyVoucher extends JPanel {
  BlueBkgWhiteCharLabel lblVhNo = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblVhData = new BlueBkgWhiteCharLabel();
  //JPanel pnlListVouchers = new JPanel();
  PnlTbl2EditDailyVoucher pnlListVoucherDetails=null;
  JButton btnGetDefaultDesc = new JButton();
  JButton btnExit = new JButton();
  JComboBox cbxCompany = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JTextField txtDate = new JTextField();
  JTextField txtVhNo = new JTextField();
  JButton btnUpate = new JButton();
  JPanel pnlFuncIns = new JPanel();
  TitledBorder titledBorder1;
  JLabel jLabel3 = new JLabel();
  JButton btnInsert = new JButton();
  JTextField txtInsRow = new JTextField();
  exgui.DataBindJCombobox dbCbxCompany;
  exgui.DataBindTextWithChecker dbTxtInitDate;
  String vhNo=null;
  java.util.Date initDate=null;
  boolean isGuiInit=true;
  static boolean isToRanderNow=false;
  int cbxSelectIndex;
  JButton btnDeleteWhole = new JButton();
  java.util.Hashtable htCompDateRange=null;
  static java.text.DateFormat DATE_FORAMT=new java.text.SimpleDateFormat("yyyyMM");
  JLabel lblDateRange = new JLabel();
  JLabel jLabel2 = new JLabel();
  JPanel pnl2CopyFrom = new JPanel();
  JButton btnCopyFrom = new JButton();
  JLabel jLabel4 = new JLabel();
  boolean forceSwitchCompany=false;
  JTextField txtCreateUser = new JTextField();
  BlueBkgWhiteCharLabel lblCreateUser = new BlueBkgWhiteCharLabel();
  JLabel jLabel5 = new JLabel();
  JLabel lblTtlDbt = new JLabel();
  JLabel lblTtlCdt = new JLabel();
  JLabel jLabel6 = new JLabel();
  public PnlEditDailyVoucher(String _vhNo,java.util.Date _date) {
    try {
      if(_vhNo!=null)vhNo=_vhNo;
      if(_date!=null)initDate=_date;
      jbInit();
      Constants.Pnl_EditDaily_Voucher=this;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    isToRanderNow=true;
    titledBorder1 = new TitledBorder("");
    this.setLayout(null);
    lblVhNo.setText("VOUCHER NO");
    lblVhNo.setBounds(new Rectangle(601, 31, 100, 27));
    lblVhData.setText("DATE");
    lblVhData.setBounds(new Rectangle(294, 31, 66, 27));
    btnGetDefaultDesc.setText("DEFAULT INVOICE DESC.");
    btnGetDefaultDesc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGetDefaultDesc_actionPerformed(e);
      }
    });
    btnGetDefaultDesc.setBounds(new Rectangle(19, 543, 172, 25));
    btnGetDefaultDesc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(700, 543, 88, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    cbxCompany.setBounds(new Rectangle(78, 31, 201, 26));
    cbxCompany.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCompany_itemStateChanged(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("COMPANY");
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(11, 31, 64, 27));
    txtDate.setBounds(new Rectangle(360, 31, 106, 27));
    txtVhNo.setFont(new java.awt.Font("Dialog", 1, 14));
    txtVhNo.setBounds(new Rectangle(700, 31, 79, 27));
    btnUpate.setText("UPDATE");
    btnUpate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpate_actionPerformed(e);
      }
    });
    btnUpate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpate.setForeground(Color.black);
    btnUpate.setBounds(new Rectangle(604, 543, 88, 25));
    pnlFuncIns.setBorder(BorderFactory.createLoweredBevelBorder());
    pnlFuncIns.setBounds(new Rectangle(196, 538, 212, 36));
    pnlFuncIns.setLayout(null);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("INSERT BEFOR ROW#");
    jLabel3.setBounds(new Rectangle(3, 5, 126, 24));
    btnInsert.setBounds(new Rectangle(161, 6, 42, 24));
    btnInsert.setFont(new java.awt.Font("Dialog", 1, 14));
    btnInsert.setText("+");
    btnInsert.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnInsert_actionPerformed(e);
      }
    });
    txtInsRow.setToolTipText("");
    txtInsRow.setText("");
    txtInsRow.setBounds(new Rectangle(130, 5, 27, 26));
    this.setBackground(new Color(202, 202, 224));
    btnDeleteWhole.setBounds(new Rectangle(416, 542, 169, 25));
    btnDeleteWhole.setFont(new java.awt.Font("Dialog", 0, 12));
    btnDeleteWhole.setForeground(Color.red);
    btnDeleteWhole.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDeleteWhole_actionPerformed(e);
      }
    });
    btnDeleteWhole.setText("刪除整張傳票");
    lblDateRange.setFont(new java.awt.Font("Dialog", 1, 12));
    lblDateRange.setForeground(Color.red);
    lblDateRange.setText("");
    lblDateRange.setBounds(new Rectangle(294, 4, 199, 24));
    jLabel2.setToolTipText("");
    jLabel2.setText("(YYYY/MM/DD)");
    jLabel2.setBounds(new Rectangle(471, 34, 92, 24));
    pnl2CopyFrom.setBackground(Color.yellow);
    pnl2CopyFrom.setBorder(BorderFactory.createLoweredBevelBorder());
    pnl2CopyFrom.setBounds(new Rectangle(196, 508, 143, 28));
    pnl2CopyFrom.setLayout(null);
    btnCopyFrom.setBounds(new Rectangle(87, 4, 43, 21));
    btnCopyFrom.setFont(new java.awt.Font("Dialog", 1, 12));
    btnCopyFrom.setText("...");
    btnCopyFrom.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try{
          btnCopyFrom_actionPerformed(e);
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }
    });
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("COPY FROM");
    jLabel4.setBounds(new Rectangle(10, 4, 80, 22));
    txtCreateUser.setEditable(false);
    txtCreateUser.setBounds(new Rectangle(606, 508, 179, 27));
    txtCreateUser.setFont(new java.awt.Font("Dialog", 0, 14));
    txtCreateUser.setForeground(Color.black);
    lblCreateUser.setBounds(new Rectangle(417, 508, 190, 27));
    lblCreateUser.setFont(new java.awt.Font("Dialog", 0, 16));
    lblCreateUser.setText("製單人");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("TOTAL Debit:");
    jLabel5.setBounds(new Rectangle(154, 485, 90, 22));
    lblTtlDbt.setFont(new java.awt.Font("Dialog", 1, 12));
    lblTtlDbt.setRequestFocusEnabled(false);
    lblTtlDbt.setText("");
    lblTtlDbt.setBounds(new Rectangle(232, 485, 102, 21));
    lblTtlCdt.setBounds(new Rectangle(434, 485, 113, 21));
    lblTtlCdt.setText("jLabel6");
    lblTtlCdt.setRequestFocusEnabled(false);
    lblTtlCdt.setFont(new java.awt.Font("Dialog", 1, 12));
    lblTtlCdt.setText("");
    jLabel6.setBounds(new Rectangle(351, 485, 91, 22));
    jLabel6.setText("TOTAL Credit:");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    pnlFuncIns.add(jLabel3, null);
    pnlFuncIns.add(txtInsRow, null);
    pnlFuncIns.add(btnInsert, null);
    this.add(btnExit, null);
    this.add(lblVhNo, null);
    this.add(jLabel1, null);
    this.add(cbxCompany, null);
    this.add(lblVhData, null);
    this.add(txtDate, null);
    this.add(txtVhNo, null);
    this.add(btnUpate, null);
    this.add(btnGetDefaultDesc, null);
    this.add(pnlFuncIns, null);
    this.add(btnDeleteWhole, null);
    //due to date range,have to load tpe_date_range each time.
    getCompanyList();
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtInitDate=
        new exgui.DataBindTextWithChecker(txtDate,"",initDate,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    if(vhNo!=null){
      txtVhNo.setText(vhNo);
      dbCbxCompany =
          new exgui.DataBindJCombobox(cbxCompany, "",
                                      newtimes.general_voucher.daily_voucher.
                                      Constants.VCT_GV_ACC_COMPANY,
                                      "comp_code_and_name", "cmp_code", vhNo.substring(0,1));
       txtDate.setEditable(false);
       cbxCompany.setEnabled(false);
        //find out create user....
        Vector vctTestUser=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select usr_name from userfile where usr_code=(select get_vh_create_user('"+vhNo+"') from dual)",1,9999);
         if(vctTestUser.size()!=0){
           Record recTestUser=(Record)vctTestUser.get(0);
           txtCreateUser.setText((String)recTestUser.get(0));
         }
       txtCreateUser.setEditable(false);
       if(!isDateInRange()){
         btnDeleteWhole.setEnabled(false);
         btnGetDefaultDesc.setEnabled(false);
         btnInsert.setEnabled(false);
         btnUpate.setEnabled(false);
         btnCopyFrom.setEnabled(false);
       }

    }else{
      lblCreateUser.setVisible(false);
      txtCreateUser.setVisible(false);
      btnDeleteWhole.setEnabled(false);
      dbCbxCompany =
          new exgui.DataBindJCombobox(cbxCompany, "",
                                      newtimes.general_voucher.daily_voucher.
                                      Constants.VCT_GV_ACC_COMPANY,
                                      "comp_code_and_name", "cmp_code", null);
      cbxSelectIndex=cbxCompany.getSelectedIndex();
    }
    txtVhNo.setEditable(false);
    isGuiInit=false;
    isToRanderNow=false;
    genDtlItemListingPanel();
    this.add(lblDateRange, null);
    this.add(jLabel2, null);
    this.add(pnl2CopyFrom, null);
    pnl2CopyFrom.add(jLabel4, null);
    pnl2CopyFrom.add(btnCopyFrom, null);
    this.add(lblTtlCdt, null);
    this.add(jLabel6, null);
  }
  boolean isDateInRange(){
    java.util.Date vhDate=(java.util.Date)dbTxtInitDate.getSelectedValue();
    int date2Num=Integer.parseInt(DATE_FORAMT.format(vhDate));
    Record recTpeDateRange=(Record)htCompDateRange.get(dbCbxCompany.getSelectedValue());
    int dateRangeBgn=Integer.parseInt(recTpeDateRange.get(3).toString());
    int dateRangeEnd=Integer.parseInt(recTpeDateRange.get(4).toString());
    if(date2Num>=dateRangeBgn &&  date2Num<=dateRangeEnd)return true;
    return false;
  }
  void getCompanyList()throws Exception{
    StringBuffer sb=new StringBuffer();
    sb.append("select substr(field_name,length(field_name),1) as cmp_code, ");
    sb.append("field_desc as cmp_name,");
    sb.append("substr(field_name,length(field_name),1)||'--'||field_desc  as comp_code_and_name ");
    sb.append(",RANGE_FROM,RANGE_TO ");
    sb.append(" from TPE_DATE_RANGE  ");
    sb.append("where record_delete_flag='1'  ");
    sb.append("and CEN_CODE='");sb.append(util.PublicVariable.OPERATTING_CENTER);sb.append("' ");
    sb.append("and FIELD_NAME LIKE 'GV_COMP_%' ");

    Constants.VCT_GV_ACC_COMPANY =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,9999);
    htCompDateRange=new Hashtable();
    for(int i=0;i<Constants.VCT_GV_ACC_COMPANY.size();i++){
      Record rec=(Record)Constants.VCT_GV_ACC_COMPANY.get(i);
      htCompDateRange.put(rec.get("cmp_code"),rec);
    }

  }
  void btnGetDefaultDesc_actionPerformed(ActionEvent e) {
    //check if invoice exists.
    if(!pnlListVoucherDetails.isAllAccCodeReady())return;
    Hashtable htSrnAndDesc=new Hashtable();
    StringBuffer sb=new StringBuffer();
    util.MiscFunc.showProcessingMessage();
    for(int i=0;i<99;i++){
      String strInvNo=(String)pnlListVoucherDetails.getJtable().getValueAt(i,5);
      if(!pnlListVoucherDetails.getJtable().isCellEditable(i,5))continue;
      if(strInvNo==null||strInvNo.trim().length()==0)continue;
      String strInvNoX="ZATW"+util.MiscFunc.Replace(strInvNo,"'","''");
      if(sb.length()>0)sb.append(",");
      sb.append("'");sb.append(strInvNoX);sb.append("'");
    }
    if(sb.length()==0){
      util.MiscFunc.hideProcessingMessage();
      return;
    }
    StringBuffer sbSql=new StringBuffer();
    sbSql.append("select a.ship_no, ");
    sbSql.append("e.prod_sc_no, ");
    sbSql.append("nvl(C.BYMKR_CHINESE_BRIEF,C.BYMKR_BRIEF) as buyer_name, ");
    sbSql.append("nvl(d.BYMKR_CHINESE_BRIEF,d.BYMKR_BRIEF) as maker_name  ");
    sbSql.append("from shipping a,prod_head b ,buyer_maker c,buyer_maker d,production e ");
    sbSql.append("where a.ship_no in  (");sbSql.append(sb.toString());sbSql.append(") and a.record_delete_flag='1' ");
    sbSql.append("and b.prod_head_pk=(select prod_head_pk from ship_sc  ");
    sbSql.append(" where ship_no=a.ship_no and record_delete_flag='1' and rownum=1)  ");
    sbSql.append("and b.prod_head_pk=e.prod_head_pk ");
    sbSql.append("and b.prod_buyer=c.bymkr_seq  ");
    sbSql.append("and b.prod_maker=d.bymkr_seq ");
    try{
      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD, sbSql.toString(), 1, 9999);
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        htSrnAndDesc.put((String)rec.get(0),rec);
      }

      for(int i=0;i<99;i++){
        if(!pnlListVoucherDetails.getJtable().isCellEditable(i,5))continue;
        String strInvNo=(String)pnlListVoucherDetails.getJtable().getValueAt(i,5);
        if(strInvNo==null||strInvNo.trim().length()==0)continue;
        Record rec=(Record)htSrnAndDesc.get("ZATW"+strInvNo);
        if(null!=rec){
          String desc=(String)rec.get(2)+" "+(String)rec.get(3);
          pnlListVoucherDetails.getJtable().setValueAt(desc,i,6);
        }
      }
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showAlert("Error while generating Default Description for Invoice",
                                             "Error");
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
   boolean is_SRN_Correct(){
    //this is called to check if SRN correct before update to dateabase
    Hashtable htSrnAndDesc=new Hashtable();
    StringBuffer sb=new StringBuffer();
    util.MiscFunc.showProcessingMessage();
    for(int i=0;i<99;i++){
      if(!pnlListVoucherDetails.getJtable().isCellEditable(i,5))continue;
      String strInvNo=(String)pnlListVoucherDetails.getJtable().getValueAt(i,5);
      if(strInvNo==null||strInvNo.trim().length()==0)continue;
      String strInvNoX="ZATW"+util.MiscFunc.Replace(strInvNo,"'","''");
      if(sb.length()>0)sb.append(",");
      sb.append("'");sb.append(strInvNoX);sb.append("'");
    }
    if(sb.length()==0){
      util.MiscFunc.hideProcessingMessage();
      return true;
    }
    StringBuffer sbSql=new StringBuffer();
    sbSql.append("select a.ship_no ");
    sbSql.append("from ship_sc a ");
    sbSql.append("where a.ship_no in  (");sbSql.append(sb.toString());sbSql.append(") and a.record_delete_flag='1' ");
    try{
      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD, sbSql.toString(), 1, 9999);
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        htSrnAndDesc.put((String)rec.get(0),rec);
      }

      for(int i=0;i<99;i++){
        if(!pnlListVoucherDetails.getJtable().isCellEditable(i,5))continue;
        String strInvNo=(String)pnlListVoucherDetails.getJtable().getValueAt(i,5);
        if(strInvNo==null||strInvNo.trim().length()==0)continue;
        if(!htSrnAndDesc.containsKey("ZATW"+strInvNo)){
          exgui.verification.VerifyLib.showAlert("INVOICE# not found at row:"+(i+1),"INV# NOT FOUND");
          return false;
        }
      }
      util.MiscFunc.hideProcessingMessage();
      return true;
    }catch(Exception exp){
      util.MiscFunc.hideProcessingMessage();
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error In checking Invoice#\nPlease Contact System Manager",
                                             "Error In checking Invoice#");
      return false;
    }
  }
  void btnUpate_actionPerformed(ActionEvent e) {
    try{
      pnlListVoucherDetails.isUpdatting=true;
      if(!is_SRN_Correct())return;
      if(!pnlListVoucherDetails.isAllAccCodeReady())return;
      if(dbTxtInitDate.getSelectedValue()==null){
        exgui.verification.VerifyLib.showAlert("Date Not Assigned ,Yet\n日期未定","Date Not Assigned");
        return ;
      }
      //date range checking left to  "pnlListVoucherDetails.doUpdate" function
      /*
      if(txtDate.isEditable()){
        if(!isDateInRange()){
          exgui.verification.VerifyLib.showAlert("Date Is Out Of Range\nPlease Contact MIS Department",
                                                 "Date Of Voucher is out of Range");
          return ;
        }
      }
      */
     // ********************************************** 2012/03/19
    JTable tbl=pnlListVoucherDetails.getJtable();
    boolean is_na = false;
    for(int i=0;i<tbl.getRowCount();i++){
          Object objACCNO=tbl.getValueAt(i,PnlTbl2EditDailyVoucher.ACC_CODE_COLUMN_AT);
          if ( objACCNO.toString().length() > 6 )
          {
            String first_code = objACCNO.toString().substring(0, 1);
            String vhdept_code = objACCNO.toString().substring(5, 7);
            if ( vhdept_code.equals("NA") || vhdept_code.equals("NS"))
            {
               if ( first_code.equals("5"))
                  is_na = true;
            }

            if ( vhdept_code.equals("JP"))
            {
                 is_na = true;
            }

          }
    }
    if (is_na )
    {
       exgui.verification.VerifyLib.showAlert("Can't set JP,NA,NS !","");
       return;
    }

    // **********************************************
      //for new VH use,if no VH,have to assigne date to generate.
      this.initDate=(java.util.Date)dbTxtInitDate.getSelectedValue();
      //have to check if debit amt == credit amt.
      pnlListVoucherDetails.doUpdate((String)dbCbxCompany.getSelectedValue(),initDate);

    }catch(Exception exp){
       exp.printStackTrace();
    }finally{
      pnlListVoucherDetails.isUpdatting=false;

    }
  }
  public void update2TotalLabel(){
    JTable tbl=pnlListVoucherDetails.getJtable();
    double ttlDbt=0,ttlCrt=0;
    java.text.NumberFormat nf=new java.text.DecimalFormat("###,###,###.##");
    for(int i=0;i<tbl.getRowCount();i++){
       Object objDbt=tbl.getValueAt(i,PnlTbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);
       Object objCrt=tbl.getValueAt(i,PnlTbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);
       if(objDbt==null && objCrt==null)continue;
       double dbt=Double.parseDouble((objDbt==null||objDbt.toString().trim().length()==0)?"0":objDbt.toString().trim());
       double crt=Double.parseDouble((objCrt==null||objCrt.toString().trim().length()==0)?"0":objCrt.toString().trim());
       ttlDbt+=dbt;ttlCrt+=crt;
    }
    lblTtlDbt.setText(nf.format(ttlDbt));
    lblTtlCdt.setText(nf.format(ttlCrt));
  }
  void genDtlItemListingPanel(){
   if(pnlListVoucherDetails!=null)this.remove(pnlListVoucherDetails);
    pnlListVoucherDetails=null;
    PnlTbl2EditDailyVoucher.VH_NO=this.vhNo;
    PnlTbl2EditDailyVoucher.COMP_CODE=((this.vhNo==null)?null:this.vhNo.substring(0,1));
    pnlListVoucherDetails=new PnlTbl2EditDailyVoucher();
    pnlListVoucherDetails.setBorder(BorderFactory.createLoweredBevelBorder());
    pnlListVoucherDetails.setBounds(new Rectangle(21, 60, 761, 408));
    this.add(pnlListVoucherDetails, null);
    this.add(lblCreateUser, null);
    this.add(txtCreateUser, null);
    this.add(jLabel5, null);
    this.add(lblTtlDbt, null);
    this.add(jLabel6, null);
    this.add(lblTtlCdt, null);
    this.validate();
    update2TotalLabel();
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(pnlListVoucherDetails.popmuAccCode!=null && pnlListVoucherDetails.popmuAccCode.isShowing()){
         pnlListVoucherDetails.popmuAccCode.setVisible(false);
      }
       if(pnlListVoucherDetails.isContextModified()){
         if(!exgui.verification.VerifyLib.showConfirm("Voucher Details Modified but not saved yet\nDo You Want Exit Without Confirmation?",
                                                      "Voucher Details Modified",false))return;
       }
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void cbxCompany_itemStateChanged(ItemEvent e) {
    if(isGuiInit)return;
    if(pnlListVoucherDetails!=null){
      if(e.getStateChange()==e.DESELECTED)return;
      if(isToRanderNow)return;

        if(pnlListVoucherDetails.isContextModified()){
         if(!forceSwitchCompany){
           //forceSwitchCompany is for "copy from" to use
           if (!exgui.verification.VerifyLib.showConfirm("This page had been modified\nBut not confirmed\nDo You Want To Change Company ?",
               "Page Modified")) {
             isToRanderNow = true;
             cbxCompany.setSelectedIndex(cbxSelectIndex);
             isToRanderNow = false;
             return;
           }
         }
       }
       cbxSelectIndex=cbxCompany.getSelectedIndex();
       genDtlItemListingPanel();
       pnlListVoucherDetails.companyChanged((String)dbCbxCompany.getSelectedValue());

     }
  }

  void btnInsert_actionPerformed(ActionEvent e) {
    if(!pnlListVoucherDetails.isAllAccCodeReady())return;
    String rowNo=txtInsRow.getText().trim();
   if(rowNo.length()==0){
     exgui.verification.VerifyLib.showAlert("Please Input Row#","Please Input Row #");
     txtInsRow.grabFocus();
     return;
   }
   int rowAt=0;
   try{
     rowAt=Integer.parseInt(rowNo);
   }catch(Exception exp){
     exp.printStackTrace();
     exgui.verification.VerifyLib.showAlert("Integer Only","Integer Only");
     txtInsRow.grabFocus();
     return;
   }
   if(rowAt<1 || rowAt>98){
     exgui.verification.VerifyLib.showAlert("Out Of Range,only allow 1~98","Out Of Range");
     txtInsRow.grabFocus();
     return;
   }
   String accCode=(String)pnlListVoucherDetails.getJtable().getValueAt(rowAt-1,pnlListVoucherDetails.ACC_CODE_COLUMN_AT);
   if(accCode==null || accCode.trim().length()==0){
     exgui.verification.VerifyLib.showAlert("ROW:"+rowAt+" is already blank\nYou May Edit it directly",
                                            "ROW is blank");
     return;
   }
   try{
     pnlListVoucherDetails.isReload4Insert=true;
     pnlListVoucherDetails.insertBlankRow(rowAt - 1);
     pnlListVoucherDetails.reload();
     pnlListVoucherDetails.isReload4Insert=false;
   }catch(Exception exp){
      exp.printStackTrace();
   }
  }
  void btnDeleteWhole_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("你確定要刪除整張傳票嗎?","確定整張刪除嗎?",false))return;
    try{
      newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome =
          (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.DailyVoucherFacade");
      newtimesejb.dailyVoucher.DailyVoucherFacade ejb = ejbHome.create();
       ejb.deleteVhNo(vhNo);
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("DELTE WHOLE VOUCHER FAILED!!\nPlease Contact System Manager",
                                             "Delte Whole Voucher Failed");

    }
    //.....
  }

  void btnCopyFrom_actionPerformed(ActionEvent e) throws Exception{
    String result=JOptionPane.showInputDialog(
     util.PublicVariable.APP_FRAME,
      "Please Input Voucher No:","Copy Detail From Other Voucher No.",
      JOptionPane.QUESTION_MESSAGE);
    if(result==null)return;
    if(result.trim().length()==0){
      return;
    }
    if(result.trim().length()!=8){
      exgui.verification.VerifyLib.showAlert("Voucher# is 8 Digigts","Voucher# is 8 Digits");
      return;
    }
    //S9060201
    //chk if 1st is nu-english
    String strBgn=result.trim().substring(0,1);
    if(!htCompDateRange.containsKey(strBgn)){
      exgui.verification.VerifyLib.showAlert("無此公司代號:"+strBgn,"No Such Company");
      return;
    }

    //chk if current company code matches target company code.
    String xntCmpCode=(String)dbCbxCompany.getSelectedValue();
    //get records...

      Vector vctSrc=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from VH_DETAIL where vh_no='"+result.trim()+"' order by VH_SEQ ",1,9999);
      if(vctSrc.size()==0){
        exgui.verification.VerifyLib.showAlert("查無此傳票編號","查無此傳票編號");
        return;
      }
      boolean haveChkAccCode=false;
      if(!xntCmpCode.equals(strBgn) ){
        haveChkAccCode=true;
      }
    /*
    if(!xntCmpCode.equals(strBgn) ){
      //if different company code,have to see already have any row defined
      for(int i=0;i<99;i++){
        String accCode=(String)pnlListVoucherDetails.getJtable().getValueAt(i,pnlListVoucherDetails.ACC_CODE_COLUMN_AT);
        if(accCode!=null  && accCode.trim().length()>0){
          if(exgui.verification.VerifyLib.showConfirm("公司不同,將會清除目前傳票內容\n確定要繼續嗎?","公司不同",false)){
          }else{
            return;
          }
        }
      }
      for(int j=0;j<Constants.VCT_GV_ACC_COMPANY.size();j++){
        Record rec=(Record)Constants.VCT_GV_ACC_COMPANY.get(j);
        if(rec.get(0).equals(strBgn)){
          forceSwitchCompany=true;
          cbxCompany.setSelectedIndex(j);
          forceSwitchCompany=false;
          break;
        }
      }
    }
    */
    //find out the blank rows range...
      int vh_seq=-1;
      for(int i=0;i<99;i++){
        boolean isblockSizeOk=true;
        for(int j=i;j<i+vctSrc.size();j++){
          String accCode=(String)pnlListVoucherDetails.getJtable().getValueAt(j,pnlListVoucherDetails.ACC_CODE_COLUMN_AT);
          if(accCode!=null && accCode.trim().length()>0){
            isblockSizeOk=false;
            break;
          }
        }
        if(isblockSizeOk){
          vh_seq=i;
          break;
        }
      }
      /*
      //find out the row has no acc code in it
      //determ the position to update....
      for(int i=0;i<pnlListVoucherDetails.getDisplayingRecords().size();i++){
        String accCode=(String)pnlListVoucherDetails.getJtable().getValueAt(i,pnlListVoucherDetails.ACC_CODE_COLUMN_AT);
        if(!(accCode!=null && accCode.trim().length()>0)){
          vh_seq=i;
          break;
        }
      }
      */

      //HashMap mpCodeNam2Map=(HashMap)Constants.hmCompanyAndAccCodeTwName.get(strBgn);
      HashMap mpCodeNam2Map=(HashMap)Constants.hmCompanyAndAccCodeTwName.get(xntCmpCode);
      if(mpCodeNam2Map==null){
        exgui.verification.VerifyLib.showAlert("目前的公司無會計科目","目前的公司無會計科目");
        return;
      }
      for(int i=0;i<vctSrc.size();i++){
        if((i+vh_seq)>99)break;
        Record rec=(Record)vctSrc.get(i);
        String accCode=rec.get(4).toString();
        String accTwName=null;
        if(haveChkAccCode){
          //1102S0C1
          String orgAccCode = new String(accCode);
          accCode = accCode.substring(0, 4) + xntCmpCode ;
          if (orgAccCode.length() > 5){
            accCode +=orgAccCode.subSequence(5, orgAccCode.length());
          }
        }
        //System.out.println("acc Code generate by copy is "+accCode);
        accTwName=(String)mpCodeNam2Map.get(accCode);
        if(null==accTwName)continue;

        pnlListVoucherDetails.getJtable().setValueAt(accCode,i+vh_seq,pnlListVoucherDetails.ACC_CODE_COLUMN_AT);
        pnlListVoucherDetails.getJtable().setValueAt(accTwName,i+vh_seq,pnlListVoucherDetails.ACC_TW_NAME_COLUMN_AT);
        if(pnlListVoucherDetails.isNormalAccCode(accCode,i+vh_seq)){
          String c_d=rec.get(5).toString();
          Object objAmt=rec.get(6);
          pnlListVoucherDetails.getJtable().setValueAt(objAmt,i+vh_seq,
                                                       (c_d.equals("D")) ?
                                                          pnlListVoucherDetails.DEBIT_AMT_COLUMN_AT:
                                                         pnlListVoucherDetails.CREDIT_AMT_COLUMN_AT);
          String srn=(String)rec.get(13);
          pnlListVoucherDetails.getJtable().setValueAt(srn,i+vh_seq,pnlListVoucherDetails.INVOICE_NO_COLUMN_AT);
          String acc_desc=(String)rec.get(7);
          pnlListVoucherDetails.getJtable().setValueAt(acc_desc,i+vh_seq,pnlListVoucherDetails.DESCRIPTION_COLUMN_AT);
        } //else,no need to update debit/credit amount and description.
      }
      pnlListVoucherDetails.getJtable().repaint();
      pnlListVoucherDetails.getJtable().validate();

  }
}
