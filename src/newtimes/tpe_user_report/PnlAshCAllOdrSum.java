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

public class PnlAshCAllOdrSum
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtYearFrom = new JTextField();
  JTextField txtYearTo = new JTextField();
  JLabel jLabel2 = new JLabel();
  JButton btnPrint = new JButton();
  int year=java.util.Calendar.getInstance().get(java.util.Calendar.getInstance().YEAR);
  exgui.DataBindJCombobox dbCbxSzn;
  JLabel lblSeaSon = new JLabel();
  JComboBox cbxSeason = new JComboBox();
  JLabel lblDiv = new JLabel();
  JComboBox cbxDiv = new JComboBox();
  JLabel lblDelDDBy = new JLabel();
  JComboBox cbxDelDDBy = new JComboBox();
  JLabel lblSeaSon1 = new JLabel();
  JComboBox cbxGrpBy = new JComboBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  int indexOfDivision;
  BuyerChangeNotify buyerChangeNotify=new BuyerChangeNotify();
  public PnlAshCAllOdrSum() {
    try {
      //jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("ASHWORTH & CALLAWAY ORDER SUMMARY");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 5, 803, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("YEAR :");
    jLabel1.setBounds(new Rectangle(7, 43, 64, 26));
    txtYearFrom.setText("");
    txtYearFrom.setBounds(new Rectangle(62, 43, 53, 26));
    txtYearTo.setBounds(new Rectangle(149, 43, 54, 26));
    txtYearTo.setText("");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("~");
    jLabel2.setBounds(new Rectangle(115, 43, 32, 21));
    btnPrint.setBounds(new Rectangle(653, 78, 93, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    lblSeaSon.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeaSon.setText("SEASON");
    lblSeaSon.setBounds(new Rectangle(211, 43, 73, 20));
    cbxSeason.setBounds(new Rectangle(270, 43, 161, 21));
    lblDiv.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDiv.setText("DIVISION");
    lblDiv.setBounds(new Rectangle(445, 42, 67, 20));
    cbxDiv.setBounds(new Rectangle(499, 42, 126, 21));
    lblDelDDBy.setBounds(new Rectangle(634, 42, 75, 20));
    lblDelDDBy.setText("DEL DD BY");
    lblDelDDBy.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxDelDDBy.setBounds(new Rectangle(689, 42, 87, 21));
    lblSeaSon1.setBounds(new Rectangle(445, 78, 73, 20));
    lblSeaSon1.setText("GROUP BY");
    lblSeaSon1.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxGrpBy.setBounds(new Rectangle(537, 78, 88, 21));
    slkMaker.setBounds(new Rectangle(285, 78, 146, 23));
    jLabel3.setBounds(new Rectangle(211, 78, 64, 26));
    jLabel3.setText("MAKER :");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("BUYER :");
    jLabel4.setBounds(new Rectangle(5, 78, 64, 26));
    slkBuyer.setBounds(new Rectangle(62, 78, 146, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(txtYearFrom, null);
    this.add(lblSeaSon1, null);
    this.add(cbxGrpBy, null);
    this.add(btnPrint, null);
    this.add(slkMaker, null);
    this.add(jLabel4, null);
    this.add(slkBuyer, null);
    this.add(jLabel2, null);
    this.add(txtYearTo, null);
    this.add(cbxDiv, null);
    this.add(cbxSeason, null);
    this.add(lblDiv, null);
    this.add(lblDelDDBy, null);
    this.add(cbxDelDDBy, null);
    this.add(jLabel3, null);
    this.add(lblSeaSon, null);
    exgui.ultratable.Wraper4tblCbx itemWrapBuyer=new exgui.ultratable.Wraper4tblCbx();
    itemWrapBuyer.setString("BUYER");
    itemWrapBuyer.setValue("'LABEL'");

    exgui.ultratable.Wraper4tblCbx itemWrapDiv=new exgui.ultratable.Wraper4tblCbx();
    itemWrapDiv.setString("DIVISION");
    itemWrapDiv.setValue("'DIVISION'");
    cbxGrpBy.addItem(itemWrapDiv);
    cbxGrpBy.addItem(itemWrapBuyer);
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
    slkMaker.init("P_MAKER",null,slkMaker.TYPE_MAKER,true);
    dataBindComps.clear();
    //division value ,default is all
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
    slkBuyer.setModifyNotifyTo(buyerChangeNotify);
    slkBuyer.init("P_BUYER", new Integer(10788), slkBuyer.TYPE_BUYER, true);


    Vector seasons=newtimes.preproduction.guis.tempProperties.tmpSeason;
    dbCbxSzn= new exgui.DataBindJCombobox(
        cbxSeason,"P_SEASON",
        seasons,"SEA_NAME","SEA_NAME",null,"ALL",null);
    dataBindComps.add(dbCbxSzn);


    Vector delType=new Vector();
    Record rec0=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
    rec0.getFieldName().clear();
    rec0.getValueFields().clear();

    rec0.getFieldName().add("TYPE");
    rec0.getValueFields().add("BUYER");
    delType.add(rec0);
    Record rec1=(Record)util.MiscFunc.deepCopy(rec0);
    rec1.set(0,"MAKER");
    delType.add(rec1);
    exgui.DataBindJCombobox dbCbxType=
        new exgui.DataBindJCombobox(
        cbxDelDDBy,"P_BUYER_MAKER",
        delType,"TYPE","TYPE","BUYER");
    dataBindComps.add(dbCbxType);



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
     super.reportName="AS_SEA.rpt";
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
   hm.put("BYR_DIV",((exgui.ultratable.Wraper4tblCbx)cbxGrpBy.getSelectedItem()).getValue());
   hm.put(slkMaker.getOrgRecField(),(slkMaker.getSelectedValue()==null)?"0":slkMaker.getSelectedValue().toString());
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
