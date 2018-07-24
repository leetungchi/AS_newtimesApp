package newtimes.accounting;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAshworthFabricChart4Acc
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtYearFrom = new JTextField();
  JTextField txtYearTo = new JTextField();
  JLabel jLabel2 = new JLabel();
  JButton btnPrint = new JButton();
  int year=java.util.Calendar.getInstance().get(java.util.Calendar.getInstance().YEAR);
  JLabel lblSeaSon = new JLabel();
  JComboBox cbxSeason = new JComboBox();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  exgui.DataBindJCombobox dbCbxSzn;
  JComboBox cbxDiv = new JComboBox();
  JLabel lblDiv = new JLabel();
  JLabel jLabel3 = new JLabel();
  JComboBox cbxCreateUser = new JComboBox();
  JLabel jLabel4 = new JLabel();
  JComboBox cbxNonePI = new JComboBox(new String[]{"YES","NO"});
  JLabel jLabel5 = new JLabel();
  JComboBox cbxNoneRcv = new JComboBox(new String[]{"YES","NO"});
  JLabel jLabel6 = new JLabel();
  JTextField txtMill = new JTextField();
  JLabel lblSeaSon1 = new JLabel();
  JTextField txtDelFrom = new JTextField();
  JLabel lblSeaSon2 = new JLabel();
  JTextField txtDelTo = new JTextField();
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  public PnlAshworthFabricChart4Acc() {
    try {
      //jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("ASHWORTH FABRIC CHART FOR ACCOUNTING");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 13, 802, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("YEAR :");
    jLabel1.setBounds(new Rectangle(7, 81, 53, 22));
    txtYearFrom.setText("");
    txtYearFrom.setBounds(new Rectangle(62, 81, 59, 22));
    txtYearTo.setBounds(new Rectangle(142, 81, 59, 22));
    txtYearTo.setText("");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("~");
    jLabel2.setBounds(new Rectangle(116, 81, 28, 22));
    btnPrint.setBounds(new Rectangle(695, 107, 93, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    lblSeaSon.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeaSon.setText("SEASON");
    lblSeaSon.setBounds(new Rectangle(206, 81, 65, 20));
    cbxSeason.setBounds(new Rectangle(252, 81, 134, 21));
    cbxDiv.setBounds(new Rectangle(422, 109, 134, 21));
    lblDiv.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDiv.setText("DIVISION");
    lblDiv.setBounds(new Rectangle(359, 109, 67, 20));
    jLabel3.setBounds(new Rectangle(7, 112, 110, 22));
    jLabel3.setText("BY CREATE USER :");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCreateUser.setBounds(new Rectangle(111, 112, 236, 20));
    jLabel4.setBounds(new Rectangle(7, 48, 65, 22));
    jLabel4.setText("NONE PI :");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxNonePI.setBounds(new Rectangle(63, 48, 58, 22));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setText("NONE RECEIVE :");
    jLabel5.setBounds(new Rectangle(128, 48, 93, 22));
    cbxNoneRcv.setBounds(new Rectangle(223, 48, 49, 22));
    jLabel6.setBounds(new Rectangle(493, 47, 43, 22));
    jLabel6.setText("MILL");
    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    txtMill.setToolTipText("");
    txtMill.setText("");
    txtMill.setBounds(new Rectangle(538, 47, 110, 22));
    lblSeaSon1.setBounds(new Rectangle(287, 48, 73, 20));
    lblSeaSon1.setText("DEL FROM :");
    lblSeaSon1.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDelFrom.setText("");
    txtDelFrom.setBounds(new Rectangle(349, 48, 62, 22));
    lblSeaSon2.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeaSon2.setText("TO");
    lblSeaSon2.setBounds(new Rectangle(413, 48, 26, 20));
    txtDelTo.setBounds(new Rectangle(430, 48, 62, 22));
    rdoXAMT.setBackground(new Color(202, 202, 224));
    rdoXAMT.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoXAMT.setText("XAMT");
    rdoXAMT.setBounds(new Rectangle(559, 111, 66, 18));
    rdoAmt.setBounds(new Rectangle(632, 110, 57, 18));
    rdoAmt.setText("AMT");
    rdoAmt.setBackground(new Color(202, 202, 224));
    rdoAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoAmt.setSelected(true);
    slkBuyer.setBounds(new Rectangle(446, 81, 151, 19));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("BUYER");
    jLabel7.setBounds(new Rectangle(388, 81, 55, 18));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel8.setText("INCLUDE SAMPLE:");
    jLabel8.setBounds(new Rectangle(599, 78, 123, 22));
    cbxIncludeSmpl.setBounds(new Rectangle(713, 78, 83, 22));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(txtYearFrom, null);
    this.add(jLabel3, null);
    this.add(cbxCreateUser, null);
    this.add(txtDelFrom, null);
    this.add(jLabel4, null);
    this.add(cbxNonePI, null);
    this.add(jLabel5, null);
    this.add(cbxNoneRcv, null);
    this.add(lblSeaSon1, null);
    this.add(lblDiv, null);
    this.add(cbxDiv, null);
    genDataBindObj();
    buttonGroup2.add(rdoXAMT);
    buttonGroup2.add(rdoAmt);
    this.add(lblSeaSon2, null);
    this.add(txtDelTo, null);
    this.add(jLabel6, null);
    this.add(txtMill, null);
    this.add(txtYearTo, null);
    this.add(jLabel2, null);
    this.add(lblSeaSon, null);
    this.add(cbxSeason, null);
    this.add(jLabel7, null);
    this.add(slkBuyer, null);
    this.add(jLabel8, null);
    this.add(cbxIncludeSmpl, null);
    this.add(btnPrint, null);
    this.add(rdoXAMT, null);
    this.add(rdoAmt, null);
    cbxIncludeSmpl.setSelectedIndex(1);
  }
  protected  void genDataBindObj(){
  try{
    dataBindComps.clear();

    Vector division=
     exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select DIV_CODE,DIV_NAME from DIVISION where DIV_BYMKR_SEQ=82 and record_delete_flag='1' ",
        1,9999);

    exgui.DataBindJCombobox dbDivCbx= new exgui.DataBindJCombobox(
        cbxDiv,"P_DIV",
        division,"DIV_NAME","DIV_CODE",null,"ALL","ALL");
    dataBindComps.add(dbDivCbx);


    Vector seasons=newtimes.preproduction.guis.tempProperties.tmpSeason;
    dbCbxSzn= new exgui.DataBindJCombobox(
        cbxSeason,"P_SEASON",
        seasons,"SEA_NAME","SEA_NAME",null,"ALL",null);
    dataBindComps.add(dbCbxSzn);

    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
   dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtDelFrom, "P_DEL_FM", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateBgn);

    dbTxtDateEnd =
        new exgui.DataBindTextWithChecker(txtDelTo, "P_DEL_TO", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateEnd);




    Vector users=new Vector();
    Record rec0=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
    rec0.getFieldName().clear();
    rec0.getValueFields().clear();

    rec0.getFieldName().add("NAME");
    rec0.getValueFields().add("MELISA WANG KS");
    users.add(rec0);
    Record rec1=(Record)util.MiscFunc.deepCopy(rec0);
    rec1.set(0,"RICHARD KAO");
    users.add(rec1);

    Record rec2=(Record)util.MiscFunc.deepCopy(rec0);
    rec2.set(0,"GREEN KU");
    users.add(rec2);

    Record rec2_=(Record)util.MiscFunc.deepCopy(rec0);
   rec2_.set(0,"GREEN KU HA");
   users.add(rec2_);


    Record rec3=(Record)util.MiscFunc.deepCopy(rec0);
    rec3.set(0,"TRACY CHIEN");
    users.add(rec3);


    exgui.DataBindJCombobox dbCbxUser= new exgui.DataBindJCombobox(
        cbxCreateUser,"P_USER",
        users,"NAME","NAME","ALL","ALL","ALL");
    dataBindComps.add(dbCbxUser);


    Object chkYear = CellFormat.getIntVerifierAllowNull(4);
    DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtYearFrom, "",
        null, 4,
        (Object2String)chkYear,
        (CellTxtEditorFormat)chkYear);

     etdDate = new DataBindTextWithChecker(txtYearTo, "",
        null, 4,
        (Object2String)chkYear,
        (CellTxtEditorFormat)chkYear);


     txtYearFrom.setText(String.valueOf(year));
     txtYearFrom.setToolTipText("YYYY");

     txtYearTo.setText(String.valueOf(year));
     txtYearTo.setToolTipText("YYYY");
     //super.reportName="AS_FAB_ACC.rpt";
     slkBuyer.init("P_BUYER",new Integer(82),slkBuyer.TYPE_BUYER,true);
   }catch(Exception exp){
      exp.printStackTrace();
   }
  }

  protected java.util.HashMap composeParameters(){
   java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
   hm.put("P_YEAR_FM",txtYearFrom.getText());
   hm.put("P_YEAR_TO",txtYearTo.getText());
   hm.put("BUYER","82");
   hm.put("P_NONE_PI",cbxNonePI.getSelectedItem().toString().substring(0,1));
   hm.put("P_NONE_RCV",cbxNoneRcv.getSelectedItem().toString().substring(0,1));
   hm.put("P_INCL_SAMP",cbxIncludeSmpl.getSelectedItem().toString().substring(0,1));
   hm.put("P_MILL",(txtMill.getText().trim().length()==0)?"ALL":txtMill.getText().trim());
   Object objBuyer=slkBuyer.getSelectedValue();
   hm.put("P_BUYER",(objBuyer==null)?"0":objBuyer.toString());
   Object dateBgn = dbTxtDateBgn.getSelectedValue();
   Object dateEnd = dbTxtDateEnd.getSelectedValue();
   if (dateBgn == null) {
     hm.put("P_DEL_FM", "DATE(2000,01,01)");
   }
   if (dateEnd == null) {
     hm.put("P_DEL_TO", "DATE(2099,12,31)");
   }
   if(rdoAmt.isSelected()){
     reportName="AS_FAB_ACC.rpt";
   }else{
     reportName="AS_FAB_ACC_XAMT.rpt";
   }
   return hm;
  }
  void btnPrint_actionPerformed(ActionEvent e) {
    if(null==slkBuyer.getSelectedValue()){
      exgui.verification.VerifyLib.showAlert("Please Select Buyer","Please Select Buyer");
      return;
    }
    if(txtYearFrom.getText().trim().length()==0){
      txtYearFrom.setText(String.valueOf(year));
    }
    if(txtYearTo.getText().trim().length()==0){
      txtYearTo.setText(txtYearFrom.getText().trim());
    }
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
  JRadioButton rdoXAMT = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JRadioButton rdoAmt = new JRadioButton();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JComboBox cbxIncludeSmpl = new JComboBox(new String[]{"YES","NO","ALL"});
}
