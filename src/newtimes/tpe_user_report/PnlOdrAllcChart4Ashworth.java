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

public class PnlOdrAllcChart4Ashworth
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
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel lblSeaSon1 = new JLabel();
  JLabel lblSeaSon2 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  BuyerChangeNotify buyerchange=null;
  int indexOfDivision;
  JCheckBox chkExcludeSmpl = new JCheckBox();
  public PnlOdrAllcChart4Ashworth() {
    try {
      //jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("ORDER ALLOCATION CHART FOR ASHWORTH");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 5, 803, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("YEAR :");
    jLabel1.setBounds(new Rectangle(5, 43, 47, 22));
    txtYearFrom.setText("");
    txtYearFrom.setBounds(new Rectangle(61, 43, 34, 22));
    txtYearTo.setBounds(new Rectangle(124, 43, 34, 22));
    txtYearTo.setText("");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("~");
    jLabel2.setBounds(new Rectangle(96, 43, 26, 22));
    btnPrint.setBounds(new Rectangle(713, 66, 84, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    lblSeaSon.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeaSon.setText("SEASON");
    lblSeaSon.setBounds(new Rectangle(406, 43, 55, 20));
    cbxSeason.setBounds(new Rectangle(457, 43, 161, 21));
    cbxDiv.setBounds(new Rectangle(280, 68, 150, 21));
    lblDiv.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDiv.setText("DIVISION");
    lblDiv.setBounds(new Rectangle(222, 68, 54, 20));
    jLabel3.setBounds(new Rectangle(167, 43, 94, 22));
    jLabel3.setText(" CREATE USER :");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCreateUser.setBounds(new Rectangle(250, 43, 150, 20));
    slkMaker.setBounds(new Rectangle(504, 68, 147, 23));
    lblSeaSon1.setBounds(new Rectangle(451, 68, 73, 24));
    lblSeaSon1.setText("MAKER");
    lblSeaSon1.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeaSon2.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeaSon2.setText("BUYER");
    lblSeaSon2.setBounds(new Rectangle(5, 68, 73, 24));
    slkBuyer.setBounds(new Rectangle(59, 70, 155, 21));
    chkExcludeSmpl.setBackground(new Color(202, 202, 224));
    chkExcludeSmpl.setFont(new java.awt.Font("Dialog", 1, 11));
    chkExcludeSmpl.setSelected(true);
    chkExcludeSmpl.setText("Exclude Sample");
    chkExcludeSmpl.setBounds(new Rectangle(628, 42, 123, 20));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtYearFrom, null);
    this.add(lblSeaSon2, null);
    this.add(slkBuyer, null);
    this.add(slkMaker, null);
    this.add(lblSeaSon1, null);
    this.add(btnPrint, null);
    this.add(lblDiv, null);
    this.add(cbxDiv, null);
    this.add(jLabel2, null);
    this.add(txtYearTo, null);
    this.add(jLabel3, null);
    this.add(cbxCreateUser, null);

    this.add(lblSeaSon, null);
    this.add(cbxSeason, null);
    this.add(jLabel1, null);
    this.add(chkExcludeSmpl, null);
    slkBuyer.init("P_BUYER", new Integer(10788), slkBuyer.TYPE_BUYER, true);
    buyerchange=new BuyerChangeNotify();
    slkBuyer.setModifyNotifyTo(buyerchange);
    cbxDiv.setUI(new exgui.WideComboBoxUI(200));
    genDataBindObj();
    txtYearFrom.setText("");
    txtYearTo.setText("");

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
    slkMaker.init("P_MAKER",null,slkMaker.TYPE_MAKER,true);
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
    DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtYearFrom, "",
        null, 4,
        (Object2String)chkYear,
        (CellTxtEditorFormat)chkYear);

     etdDate = new DataBindTextWithChecker(txtYearTo, "",
        null, 4,
        (Object2String)chkYear,
        (CellTxtEditorFormat)chkYear);


     txtYearFrom.setToolTipText("YYYY");

     txtYearTo.setToolTipText("YYYY");
     super.reportName="AS_LST.rpt";

     buyerchange.changeBuyerMaker(slkBuyer.currentRecord());
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
   hm.put(slkMaker.getOrgRecField(),(slkMaker.getSelectedValue()==null)?"0":slkMaker.getSelectedValue().toString());
   hm.put("P_EXSMP",(chkExcludeSmpl.isSelected())?"Y":"N");
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
}
