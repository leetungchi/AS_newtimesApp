package newtimes.production.report;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlShipmentQtyRpt
    extends newtimes.production.report.AbsQryPanel {
    //extends JPanel{

  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel jLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCntr = new JComboBox();
  JButton btnQry = new JButton();
  JTextField txtDateBgn = new JTextField();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   DataBindJCombobox dbCbxDep;
   protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
   boolean doingDB2Gui=false;
   JTextField   txtTwdUsd=new JTextField();
   JTextField   txtRmbUsd=new JTextField();
   JTextField   txtHkdUsd=new JTextField();
   SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
   SelectBuyerMaker slkMaker = new SelectBuyerMaker();

  public PnlShipmentQtyRpt() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"Delivery Date Range");
    pnlDuriation.setLayout(null);
    pnlDuriation.setBounds(new Rectangle(511, 40, 165, 76));
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder1);
    jLabel2.setBounds(new Rectangle(10, 20, 56, 21));
    jLabel2.setText("FROM:");
    txtDateEnd.setBounds(new Rectangle(54, 43, 87, 22));
    txtDateEnd.setText("");
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 53, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(20, 43, 36, 24));
    blueBkgWhiteCharLabel1.setText("ORDER QTY BY BUYER/MAKER/MONTH");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 803, 28));
    //cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(54, 51, 130, 22));
    btnQry.setBounds(new Rectangle(693, 56, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlShipmentQtyRpt_btnQry_actionAdapter(this));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(54, 20, 87, 20));
    this.setBackground(new Color(202, 202, 224));
    jLabel1.setText("BUYER");
    jLabel1.setBounds(new Rectangle(214, 46, 62, 24));
    jLabel5.setBounds(new Rectangle(214, 83, 62, 24));
    jLabel5.setText("MAKER");
    slkBuyer.setBounds(new Rectangle(265, 48, 229, 23));
    slkMaker.setBounds(new Rectangle(265, 83, 229, 23));
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(jLabel3, null);
    pnlDuriation.add(txtDateEnd, null);

    this.add(jLabel1, null);
    this.add(slkBuyer, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCntr, null);
    this.add(btnQry, null);
    this.add(pnlDuriation, null);
    this.add(slkMaker, null);
    this.add(jLabel5, null);
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("",null,slkMaker.TYPE_MAKER,true);
    cbxCntr.setNextFocusableComponent(slkBuyer);
    slkBuyer.setNextFocusableComponent(slkMaker);
    slkMaker.setNextFocusableComponent(txtDateBgn);
    txtDateBgn.setNextFocusableComponent(txtDateEnd);
    txtDateEnd.setNextFocusableComponent(btnQry);
    cbxCntr.grabFocus();

    genDataBindObj();
    reportName="NTFE_SUM_QTY.rpt";

}
public void genDataBindObj() {
  doingDB2Gui=true;
  dataBindComps.clear();
  try{
    if (tempProperties.tmpCenters.size() > 1) {
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, "P_CENTER",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "'ALL'", null);
      dataBindComps.add(DbJcbxcbxCntr);
    } else {
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, "P_CENTER",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(DbJcbxcbxCntr);
    }

    //default end date is end day of currecnt mount

    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtDateBgn, "P_ETD_FM", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateBgn);

    dbTxtDateEnd =
        new exgui.DataBindTextWithChecker(txtDateEnd, "P_ETD_TO", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateEnd);


    Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1",
      1, 1);
        Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
    database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
   exgui.DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbTwdChg);
   exgui.DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbRmbChg);
   exgui.DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbHkdChg);

    doingDB2Gui=false;
    //cbxCntr.getItemListeners()[0].itemStateChanged(null);
  }catch(Exception exp){
    exp.printStackTrace();
  }
}
public HashMap composeParameters() {
  HashMap hm = super.composeParameters();
  Object dateBgn = dbTxtDateBgn.getSelectedValue();
  Object dateEnd = dbTxtDateEnd.getSelectedValue();
  int year=java.util.GregorianCalendar.getInstance().get(java.util.GregorianCalendar.YEAR);
  if (dateBgn == null) {
    hm.put("P_ETD_FM", "DATE("+year+",01,01)");
  }
  if (dateEnd == null) {
    hm.put("P_ETD_TO", "DATE("+year+",12,31)");
  }
  hm.put("P_BUYER",slkBuyer.getSelectedValue()==null ? "0":slkBuyer.getSelectedValue().toString());
  hm.put("P_MAKER",slkMaker.getSelectedValue()==null ? "0":slkMaker.getSelectedValue().toString());
  return hm;
}


void btnQry_actionPerformed(ActionEvent e) {
  String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
  newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
  super.JButtonQueryButtonAction(e);
  newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel5 = new JLabel();
}

class PnlShipmentQtyRpt_btnQry_actionAdapter implements java.awt.event.
  ActionListener {
  PnlShipmentQtyRpt adaptee;

PnlShipmentQtyRpt_btnQry_actionAdapter(PnlShipmentQtyRpt adaptee) {
  this.adaptee = adaptee;
}

 public void actionPerformed(ActionEvent e) {
   adaptee.btnQry_actionPerformed(e);
 }
}

