package newtimes.tpe_user_report;
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

public class PnlAshworthFabricChart
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
  JTextField txtDelTo = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtDelFrom = new JTextField();
  JTextField txtMill = new JTextField();
  JLabel jLabel6 = new JLabel();
  JComboBox cbxHideAttLine = new JComboBox(new String[]{"YES","NO"});
  JLabel jLabel7 = new JLabel();
  DataBindTextWithChecker dbDelDateFrom,dbDelDateTo;
  int indexOfDivision;
  BuyerChangeNotify buyerChangeNotify=new BuyerChangeNotify();

  public PnlAshworthFabricChart() {
    try {
      //jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("ASHWORTH FABRIC CHART");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 3, 803, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("YEAR :");
    jLabel1.setBounds(new Rectangle(7, 42, 89, 22));
    txtYearFrom.setText("");
    txtYearFrom.setBounds(new Rectangle(62, 42, 48, 22));
    txtYearTo.setBounds(new Rectangle(136, 42, 48, 22));
    txtYearTo.setText("");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("~");
    jLabel2.setBounds(new Rectangle(112, 42, 30, 22));
    btnPrint.setBounds(new Rectangle(698, 70, 93, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    lblSeaSon.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeaSon.setText("SEASON");
    lblSeaSon.setBounds(new Rectangle(188, 42, 73, 20));
    cbxSeason.setBounds(new Rectangle(242, 42, 115, 21));
    cbxDiv.setBounds(new Rectangle(230, 77, 116, 21));
    lblDiv.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDiv.setText("DIVISION");
    lblDiv.setBounds(new Rectangle(181, 77, 67, 20));
    jLabel3.setBounds(new Rectangle(367, 42, 89, 22));
    jLabel3.setText("By Create User");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCreateUser.setBounds(new Rectangle(453, 42, 116, 20));
    jLabel4.setBounds(new Rectangle(585, 77, 26, 22));
    jLabel4.setText("~");
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDelTo.setToolTipText("YYYY");
    txtDelTo.setText(String.valueOf(year));
    txtDelTo.setBounds(new Rectangle(611, 77, 79, 22));
    jLabel5.setBounds(new Rectangle(479, 77, 47, 22));
    jLabel5.setText("DEL:");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDelFrom.setToolTipText("YYYY");
    txtDelFrom.setText(String.valueOf(year));
    txtDelFrom.setBounds(new Rectangle(512, 77, 76, 22));
    txtMill.setBounds(new Rectangle(398, 77, 76, 22));
    txtMill.setToolTipText("YYYY");
    txtMill.setText("");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setText("MILL:");
    jLabel6.setBounds(new Rectangle(360, 77, 47, 22));
    cbxHideAttLine.setBounds(new Rectangle(646, 42, 79, 22));
    jLabel7.setBounds(new Rectangle(588, 42, 68, 22));
    jLabel7.setText("ATT LINE:");
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
    slkBuyer.setBounds(new Rectangle(52, 77, 121, 21));
    jLabel8.setBounds(new Rectangle(5, 76, 73, 22));
    jLabel8.setText("BUYER :");
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtYearFrom, null);
    this.add(jLabel1, null);
    this.add(txtDelTo, null);
    this.add(jLabel2, null);
    this.add(txtYearTo, null);
    this.add(lblSeaSon, null);
    this.add(cbxSeason, null);
    this.add(jLabel4, null);
    this.add(jLabel5, null);
    this.add(txtDelFrom, null);
    this.add(cbxCreateUser, null);
    this.add(jLabel3, null);
    this.add(txtMill, null);
    this.add(btnPrint, null);
    this.add(cbxDiv, null);
    this.add(jLabel6, null);
    this.add(slkBuyer, null);
    this.add(jLabel8, null);
    this.add(lblDiv, null);
    this.add(jLabel7, null);
    this.add(cbxHideAttLine, null);
    cbxDiv.setUI(new exgui.WideComboBoxUI(200));

    genDataBindObj();
  }
  class BuyerChangeNotify implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record rec){
      try{
        Vector division =
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select DIV_CODE,DIV_NAME from DIVISION where DIV_BYMKR_SEQ="+rec.getInt(0)+" and record_delete_flag='1' ",
            1, 9999);

        exgui.DataBindJCombobox dbDivCbx = new exgui.DataBindJCombobox(
            cbxDiv, "P_DIV",
            division, "DIV_NAME", "DIV_CODE", null, "ALL", "ALL");
        dataBindComps.set(indexOfDivision, dbDivCbx);
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }

  protected  void genDataBindObj(){
  try{
    slkBuyer.init("P_BUYER",new Integer(10788),slkBuyer.TYPE_BUYER,true);
    slkBuyer.setModifyNotifyTo(buyerChangeNotify);
    dataBindComps.clear();
    /*
    Vector division=
     exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select DIV_CODE,DIV_NAME from DIVISION where DIV_BYMKR_SEQ=82 and record_delete_flag='1' ",
        1,9999);

    exgui.DataBindJCombobox dbDivCbx= new exgui.DataBindJCombobox(
        cbxDiv,"P_DIV",
        division,"DIV_NAME","DIV_CODE",null,"ALL","ALL");
    dataBindComps.add(dbDivCbx);*/
     dataBindComps.add(null);
     indexOfDivision=dataBindComps.size()-1;

    Vector seasons=newtimes.preproduction.guis.tempProperties.tmpSeason;
    dbCbxSzn= new exgui.DataBindJCombobox(
        cbxSeason,"P_SEASON",
        seasons,"SEA_NAME","SEA_NAME",null,"ALL",null);
    dataBindComps.add(dbCbxSzn);

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
    Object chkDelDate = CellFormat.getDateStringFormaterAllowNull();
     dbDelDateFrom = new DataBindTextWithChecker(txtDelFrom, "",
        null, 10,
        (Object2String)chkDelDate,
        (CellTxtEditorFormat)chkDelDate);

     dbDelDateTo = new DataBindTextWithChecker(txtDelTo, "",
        null, 10,
        (Object2String)chkDelDate,
        (CellTxtEditorFormat)chkDelDate);


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
     super.reportName="AS_FAB.rpt";
     buyerChangeNotify.changeBuyerMaker(slkBuyer.currentRecord());
   }catch(Exception exp){
      exp.printStackTrace();
   }
  }

  protected java.util.HashMap composeParameters(){
   java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
   hm.put("P_YEAR_FM",txtYearFrom.getText());
   hm.put("P_YEAR_TO",txtYearTo.getText());
   //hm.put("BUYER","82");
   hm.put(slkBuyer.getOrgRecField(),(slkBuyer.getSelectedValue()==null)?"0":slkBuyer.getSelectedValue().toString());
   hm.put("P_MILL",(txtMill.getText().trim().length()==0)?"ALL":txtMill.getText().trim());
   hm.put("P_HIDDEN",cbxHideAttLine.getSelectedItem().toString().substring(0,1));

   hm.put("P_DEL_FM",super.convert2QueryPara(dbDelDateFrom.getSelectedValue()==null?util.MiscFunc.toDate(2000,01,01):dbDelDateFrom.getSelectedValue()));
   hm.put("P_DEL_TO",super.convert2QueryPara(dbDelDateTo.getSelectedValue()==null?util.MiscFunc.toDate(2099,01,01):dbDelDateTo.getSelectedValue()));
   return hm;
  }
  void btnPrint_actionPerformed(ActionEvent e) {
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
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel8 = new JLabel();
}
