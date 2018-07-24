package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import javax.swing.event.*;
import exgui.ultratable.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryDebitNotePayDtl extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnQry = new JButton();
  JPanel PnlQryDbCrNoDtlConditions = new JPanel();
  Border border1;
  BlueBkgWhiteCharLabel lblDBNO1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  JComboBox cbxDep = new JComboBox();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtDbCrNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtTmpDbCrNo = new JTextField();
  JComboBox cbxBuyerMakerType = new JComboBox(new String[]{"BUYER","MAKER","OTHER"});
  WhiteBkgBlueCharLabel lblCenter4 = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker selectBuyerMaker = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter3 = new WhiteBkgBlueCharLabel();
  JTextField txtMerchRef = new JTextField();
  WhiteBkgBlueCharLabel lblCenter5 = new WhiteBkgBlueCharLabel();
  JComboBox cbxFactory = new JComboBox();
  WhiteBkgBlueCharLabel lblCenter6 = new WhiteBkgBlueCharLabel();
  JTextField txtFtyInv = new JTextField();
  WhiteBkgBlueCharLabel lblCenter7 = new WhiteBkgBlueCharLabel();
  JTextField txtVcNo = new JTextField();
  JTextField txtRcptNo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter8 = new WhiteBkgBlueCharLabel();
  exgui.DataBindJCombobox dbCbxDep=null;
  exgui.DataBindJCombobox DbJcbxcbxMerchID,DbJcbxcbxType;
  exgui.DataBindEditableJCombobox DbJcbxcbxFactory;
  java.util.List payDtlConditionList=new java.util.ArrayList();
  BlueBkgWhiteCharLabel lblDBNO2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxType = new JComboBox();
  static String  PAYDTL_QTY_CONDITION_BGN_DBCRNO  ="PAYDTL_QTY_CONDITION_BGN_DBCRNO";
  static String  PAYDTL_QTY_CONDITION_TEMP_DBCRNO ="PAYDTL_QTY_CONDITION_TEMP_DBCRNO";
  String DrCrTypeValue[]={"","D","C","B","M"};
  String DrCrTypeString[]={"","DEBIT","CREDIT","BUYER COMMISSION","MAKER COMMISSION"};
  exgui.ultratable.Wraper4tblCbx DrCrType[]=new exgui.ultratable.Wraper4tblCbx[5];
  boolean init_now=false;
  DataBindComboboxTable DbJcbxcbxTBLMerchID = new exgui.ultratable.DataBindComboboxTable();
  JTextField txtYear = new JTextField();
  WhiteBkgBlueCharLabel lblCenter9 = new WhiteBkgBlueCharLabel();
  JTextField txtSZN = new JTextField();
  WhiteBkgBlueCharLabel lblCenter10 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenter12 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenterText = new WhiteBkgBlueCharLabel();
  //JTextField DbJcbxcbxTBLMerchID = new JTextField();
  public PnlQryDebitNotePayDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {

    border1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"DB/CR# 條件查詢");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 29, 801, 32));
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("細項查詢 & 印表");
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(597, 495, 97, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnQry.setText("Query");
    btnQry.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent e) {
        btnQry_focusGained(e);
      }
      public void focusLost(FocusEvent e) {
        btnQry_focusLost(e);
      }
    });
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setBounds(new Rectangle(223, 495, 97, 32));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    PnlQryDbCrNoDtlConditions.setBackground(new Color(202, 202, 224));
    PnlQryDbCrNoDtlConditions.setBorder(border1);
    PnlQryDbCrNoDtlConditions.setBounds(new Rectangle(35, 138, 727, 63));
    PnlQryDbCrNoDtlConditions.setLayout(null);
    lblDBNO1.setBounds(new Rectangle(6, 22, 63, 26));
    lblDBNO1.setText("DEP. :");
    lblCenter1.setBounds(new Rectangle(222, 22, 117, 25));
    lblCenter1.setBackground(new Color(143, 143, 188));
    lblCenter1.setForeground(Color.white);
    lblCenter1.setText("YYYYMM From:");
    txtDateFrom.setSelectionStart(0);
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(339, 22, 58, 25));
    cbxDep.setBounds(new Rectangle(68, 22, 148, 26));
    txtDateTo.setBounds(new Rectangle(435, 22, 58, 25));
    txtDateTo.setText("");
    lblCenter2.setBackground(new Color(143, 143, 188));
    lblCenter2.setForeground(Color.white);
    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(396, 22, 38, 25));
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setForeground(SystemColor.text);
    blueBkgWhiteCharLabel2.setText("直接輸入DB/CR# 起始字元查詢");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(35, 101, 255, 28));
    txtDbCrNo.setText("");
    txtDbCrNo.setBounds(new Rectangle(289, 101, 163, 28));
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setText("掛帳號碼查詢");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(465, 100, 149, 31));
    txtTmpDbCrNo.setText("");
    txtTmpDbCrNo.setBounds(new Rectangle(614, 101, 162, 28));
    cbxBuyerMakerType.setBounds(new Rectangle(159, 203, 81, 26));
    cbxBuyerMakerType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerMakerType_itemStateChanged(e);
      }
    });
    lblCenter4.setText("BUYER / MAKER");
    lblCenter4.setBounds(new Rectangle(35, 203, 123, 25));
    selectBuyerMaker.setBounds(new Rectangle(241, 203, 291, 26));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(35, 232, 123, 25));
    blueBkgWhiteCharLabel3.setText("MERCH-ID");
    blueBkgWhiteCharLabel3.setForeground(SystemColor.text);
    lblCenter3.setBackground(new Color(143, 143, 188));
    lblCenter3.setForeground(Color.white);
    lblCenter3.setText("MERCH-REF");
    lblCenter3.setBounds(new Rectangle(313, 232, 100, 25));
    txtMerchRef.setBounds(new Rectangle(413, 232, 120, 25));
    txtMerchRef.setText("");
    txtMerchRef.setSelectionStart(0);
    lblCenter5.setBounds(new Rectangle(35, 262, 123, 25));
    lblCenter5.setText("FACTORY");
    cbxFactory.setBounds(new Rectangle(159, 262, 257, 25));
    lblCenter6.setText("FTY-INV.");
    lblCenter6.setBounds(new Rectangle(428, 262, 126, 25));
    txtFtyInv.setBounds(new Rectangle(553, 262, 228, 25));
    txtFtyInv.setText("");
    txtFtyInv.setSelectionStart(0);
    lblCenter7.setBounds(new Rectangle(35, 292, 124, 25));
    lblCenter7.setText("傳票號碼");
    lblCenter7.setForeground(Color.white);
    lblCenter7.setBackground(new Color(143, 143, 188));
    lblCenter7.setFont(new java.awt.Font("Dialog", 0, 16));
    txtVcNo.setSelectionStart(0);
    txtVcNo.setText("");
    txtVcNo.setBounds(new Rectangle(159, 292, 257, 25));
    txtRcptNo.setBounds(new Rectangle(552, 293, 229, 25));
    txtRcptNo.setText("");
    txtRcptNo.setSelectionStart(0);
    lblCenter8.setFont(new java.awt.Font("Dialog", 0, 16));
    lblCenter8.setBackground(new Color(143, 143, 188));
    lblCenter8.setForeground(Color.white);
    lblCenter8.setText("發票號碼");
    lblCenter8.setBounds(new Rectangle(428, 293, 124, 25));
    lblDBNO2.setText("TYPE");
    lblDBNO2.setBounds(new Rectangle(502, 22, 71, 26));
    cbxType.setBounds(new Rectangle(572, 22, 148, 26));
    this.setBackground(new Color(202, 202, 224));
    /*
    cbxMerchId.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxMerchId_itemStateChanged(e);
      }
    });*/
    //DbJcbxcbxTBLMerchID.setNextFocusableComponent(txtMerchRef);
    DbJcbxcbxTBLMerchID.setRequestFocusEnabled(false);
    DbJcbxcbxTBLMerchID.setBounds(new Rectangle(158, 232, 153, 27));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(160, 321, 77, 25));
    lblCenter9.setText("YEAR");
    lblCenter9.setBounds(new Rectangle(37, 321, 123, 25));
    txtSZN.setBounds(new Rectangle(353, 321, 77, 25));
    txtSZN.setText("");
    lblCenter10.setBounds(new Rectangle(253, 321, 100, 25));
    lblCenter10.setText("SEASON");
    lblCenter10.setForeground(Color.white);
    lblCenter10.setBackground(new Color(143, 143, 188));
    lblCenter12.setBounds(new Rectangle(35, 71, 123, 25));
    lblCenter12.setText("CENTER");
    lblCenterText.setBounds(new Rectangle(156, 71, 297, 25));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnQry, null);
    PnlQryDbCrNoDtlConditions.add(lblDBNO1, null);
    PnlQryDbCrNoDtlConditions.add(cbxDep, null);
    this.add(txtDbCrNo, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(PnlQryDbCrNoDtlConditions, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtTmpDbCrNo, null);
    this.add(lblCenter4, null);
    this.add(selectBuyerMaker, null);
    this.add(cbxBuyerMakerType, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(DbJcbxcbxTBLMerchID, null);

    this.add(lblCenter3, null);
    this.add(txtMerchRef, null);
    PnlQryDbCrNoDtlConditions.add(lblCenter1, null);
    PnlQryDbCrNoDtlConditions.add(txtDateFrom, null);
    PnlQryDbCrNoDtlConditions.add(lblCenter2, null);
    PnlQryDbCrNoDtlConditions.add(txtDateTo, null);
    PnlQryDbCrNoDtlConditions.add(lblDBNO2, null);
    PnlQryDbCrNoDtlConditions.add(cbxType, null);
    this.add(lblCenter5, null);
    this.add(cbxFactory, null);
    this.add(lblCenter7, null);
    this.add(txtVcNo, null);
    this.add(lblCenter8, null);
    this.add(txtRcptNo, null);
    this.add(lblCenter6, null);
    this.add(txtFtyInv, null);
    this.add(txtYear, null);
    this.add(lblCenter9, null);
    this.add(lblCenter10, null);
    this.add(txtSZN, null);
    this.add(lblCenter12, null);
    this.add(lblCenterText, null);
    String centerName=
        (String)((database.datatype.Record)Constans.recGetCenterRec(util.PublicVariable.OPERATTING_CENTER)).get(1);
    lblCenterText.setText(centerName);
    init_now=true;
    cbxFactory.setEditable(true);
    selectBuyerMaker.init("", null, selectBuyerMaker.TYPE_BUYER, true);

    if(newtimes.accounting.debit_note.Constans.VCT_DEBITNOTE_KIND==null){
      newtimes.accounting.debit_note.Constans.VCT_DEBITNOTE_KIND=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select a.*,to_char(a.dbnt_kind_seq) as seq_str from DEBITNOTE_KIND a where a.record_delete_flag='1'",
         1,9999999);
    }

    for(int i=0;i<5;i++){
         DrCrType[i]=new exgui.ultratable.Wraper4tblCbx();
         DrCrType[i].setValue(DrCrTypeValue[i]);
         DrCrType[i].setString(DrCrTypeString[i]);
      }

    cbxType.setModel(new javax.swing.DefaultComboBoxModel(DrCrType));
    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_PREFIX",
            null,"",null);

      if(Constans.VCT_MERCH ==null){
        Constans.VCT_MERCH=
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                 "select * from debitnote_user where cen_code='"+util.PublicVariable.OPERATTING_CENTER+"' order by usr_code"
                 ,1,99999);

      }




      java.util.Vector dbntUsers=Constans.VCT_MERCH;
      /*
      DbJcbxcbxMerchID = new exgui.DataBindJCombobox(
                                     cbxMerchId,"DBNT_PAYDTL_MERCHID",
                                     dbntUsers,"USR_name","USR_CODE",
                                     null,"",null);


      payDtlConditionList.add(DbJcbxcbxMerchID);


      */
        util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
        iso.put("CODE","USR_CODE");
        iso.put("姓名","USR_NAME");
        iso.put("NAME","USR_ENG_NAME");
        DbJcbxcbxTBLMerchID.init("DBNT_PAYDTL_MERCHID", dbntUsers, iso, 250, 150, "USR_CODE", "USR_CODE", null);
        payDtlConditionList.add(DbJcbxcbxTBLMerchID);
      //select nvl(buyer_maker.BYMKR_CHINESE_BRIEF,buyer_maker.BYMKR_NAME) as bymker_tmp_name
      //from buyer_maker where selectable_center  like '%,001,%' and buyer_maker.BYMKR_MULTI_TYPE like '%,2,%'

      if(Constans.VCT_FTY_NAMES==null){
        Constans.VCT_FTY_NAMES=
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                 "select nvl(buyer_maker.BYMKR_CHINESE_BRIEF,buyer_maker.BYMKR_NAME) as bymker_tmp_name  "+
                 "from buyer_maker where selectable_center   like '%,001,%' and buyer_maker.BYMKR_MULTI_TYPE like '%,2,%'"+
                 " and record_delete_flag='1' order by bymker_tmp_name"
                 ,1,99999);
      }


      java.util.Vector vctFty=Constans.VCT_FTY_NAMES;


       DbJcbxcbxFactory = new exgui.DataBindEditableJCombobox(cbxFactory,
                                             "DBNT_PAYDTL_FTY",
                                             vctFty,
                                             "BYMKER_TMP_NAME","BYMKER_TMP_NAME",
                                            null,100);
      payDtlConditionList.add(DbJcbxcbxFactory);


     Object vftxtMerchRef=exgui.verification.CellFormat.getOrdinaryField(20);
      payDtlConditionList.add(
             new exgui.DataBindTextWithChecker(
             txtMerchRef,"DBNT_PAYDTL_MERCHREF",
             null, 20,
             (exgui.Object2String)vftxtMerchRef,
             (exgui.ultratable.CellTxtEditorFormat)vftxtMerchRef)
             );



      payDtlConditionList.add(
             new exgui.DataBindTextWithChecker(
             txtFtyInv, "DBNT_PAYDTL_FTY_INV",
             null, 20,
             (exgui.Object2String)vftxtMerchRef,
             (exgui.ultratable.CellTxtEditorFormat)vftxtMerchRef)
             );

      payDtlConditionList.add(
            new exgui.DataBindTextWithChecker(txtVcNo,"DBNT_PAYDTL_CV",
             null,20,
             (exgui.Object2String)vftxtMerchRef,
             (exgui.ultratable.CellTxtEditorFormat)vftxtMerchRef)
             );
      payDtlConditionList.add(
               new exgui.DataBindTextWithChecker(
               txtRcptNo,"DBNT_PAYDTL_RCPT",
               null,20,
               (exgui.Object2String)vftxtMerchRef,
               (exgui.ultratable.CellTxtEditorFormat)vftxtMerchRef)
               );
    //cbxMerchId.setUI(new exgui.WideComboBoxUI(100));

    Object vftxtyear=exgui.verification.CellFormat.getOrdinaryField(2);
    payDtlConditionList.add(
       new exgui.DataBindTextWithChecker(txtYear,
                                         "DBNT_PAYDTL_YEAR",
                                         null,2,
                                         (exgui.Object2String)vftxtyear,
                                         (exgui.ultratable.CellTxtEditorFormat)vftxtyear));


       Object vftxtSZN=exgui.verification.CellFormat.getOrdinaryField(3);
       payDtlConditionList.add(
          new exgui.DataBindTextWithChecker(txtSZN,
                                            "DBNT_PAYDTL_SZN",
                                            null,3,
                                            (exgui.Object2String)vftxtSZN,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtSZN));

    init_now=false;


  }
  protected void composePayDtlQryCondition(){
     for(int i=0;i<payDtlConditionList.size();i++){
       Object obj=null;
       String keyName=null;
       Object guiObj=  payDtlConditionList.get(i);
       if(guiObj instanceof exgui.DataBindTextWithChecker ){
          obj=((exgui.DataBindTextWithChecker)guiObj).getSelectedValue();
          keyName=((exgui.DataBindTextWithChecker)guiObj).getOrgRecField();

       }else if(guiObj instanceof exgui.SwingSingleSelection){
         keyName=((exgui.DataBindGUIObject)guiObj).getOrgRecField();
         obj=((exgui.SwingSingleSelection)guiObj).getSelectedValue();
       }else{
                  obj=((exgui.DataBindJCombobox)guiObj).getSelectedValue();
                  keyName=((exgui.DataBindJCombobox)guiObj).getOrgRecField();

       }
       //System.out.println(" key is "+keyName);
       //System.out.println(" value is "+obj);
       if(obj!=null && obj.toString().trim().length()>0){
         newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(keyName,obj);
       }
     }
  }
  protected boolean ComposeCondition(){
    newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.clear();
    composePayDtlQryCondition();
    boolean isDbCrRead=false;
    if(txtDbCrNo.getText().trim().length()>0 ){
     newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
        PAYDTL_QTY_CONDITION_BGN_DBCRNO,
        txtDbCrNo.getText());
        isDbCrRead=true;
    }
    if(txtTmpDbCrNo.getText().trim().length()>0 ){
     newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
        PAYDTL_QTY_CONDITION_TEMP_DBCRNO,
        txtTmpDbCrNo.getText());
        isDbCrRead=true;
    }

    if(isDbCrRead)return true;

    //if false,means have formate error.
    if(txtDateFrom.getText().trim().length()>0){
      if(txtDateFrom.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM","DATE FORMATE IS YYYYMM");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(0,4))<2006){
        exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2006","YEAR CAN NOT LESS THAN 2006");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))<1||
         Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))>12){
        exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ","MONTH RANGE ERROR");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
    }

      if(txtDateFrom.getText().trim().length()>0){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(PnlQryDebitNote.CONDITION_DATE_FROM,txtDateFrom.getText().trim());
      }
     if(txtDateTo.getText().trim().length()>0){
       if (txtDateTo.getText().trim().length() < 6) {
         exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM",
                                                "DATE FORMATE IS YYYYMM");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(0, 4)) < 2006) {
         exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2006",
                                                "YEAR CAN NOT LESS THAN 2006");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) < 1 ||
           Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) > 12) {
         exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ",
                                                "MONTH RANGE ERROR");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
     }
      if(txtDateFrom.getText().trim().length()>0 &&
         txtDateTo.getText().trim().length()>0 ){
         if(Integer.parseInt(txtDateFrom.getText().trim())>
            Integer.parseInt(txtDateTo.getText().trim())){
           exgui.verification.VerifyLib.showAlert("\"From\" Date Can Not After \"To\" Date","Date Compare Error");
           return false;
         }
      }
      if(txtDateTo.getText().trim().length()>0){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(PnlQryDebitNote.CONDITION_DATE_TO,txtDateTo.getText().trim());
      }
      if(dbCbxDep.getSelectedValue()!=null){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          PnlQryDebitNote.CONDITION_DEPT,
          dbCbxDep.getSelectedValue());
      }
      if(selectBuyerMaker.getSelectedValue()!=null){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          PnlQryDebitNote.CONDITION_BUYER_MAKER ,
          selectBuyerMaker.getSelectedValue().toString());
      }
      String type=(String)((exgui.ultratable.Wraper4tblCbx)cbxType.getSelectedItem()).getValue();

      if(!type.equals("")){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          PnlQryDebitNote.CONDITION_TYPE,
          type);
      }


      return true;

  }

  void btnQry_actionPerformed(ActionEvent e) {
    try{
      PnlListQryPayDtl.HASHMAP_PAYDTL_CHECKLIST.clear();
      Constans.BGN_POS_OF_QRY_PAY_DTL_DRCR_NO=1;
      if(!ComposeCondition())return;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new TgrListQryDebitNotePayDtl()
       );
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {
    selectBuyerMaker.init("",null,
    Integer.parseInt(
    (String)
    newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
    ),true);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      newtimes.accounting.debit_note.Constans.PNL2QUERY_PAY_DETAIL=null;
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnQry_focusGained(FocusEvent e) {
    System.out.println("BUTTON QUERY FOCUSED ");

  }

  void btnQry_focusLost(FocusEvent e) {
      /*
      if(e.getOppositeComponent()==DbJcbxcbxTBLMerchID.getGUIcomponent()){
        btnQry.grabFocus();
      }
      */
  }
  /*
  void cbxMerchId_itemStateChanged(ItemEvent e) {
    if(init_now)return;
    if(e.getStateChange()!=e.SELECTED)return;
     String merchCont=(String)cbxMerchId.getSelectedItem();
     if(merchCont.trim().length()>0){
       String mercName=util.MiscFunc.split(merchCont," ")[1];
       lblMerchName.setText(mercName);
     }else{
       lblMerchName.setText("");
     }
  }*/
 /*
  void lblMerchName_mouseClicked(MouseEvent e) {
     cbxMerchId.showPopup();
  }*/


}
