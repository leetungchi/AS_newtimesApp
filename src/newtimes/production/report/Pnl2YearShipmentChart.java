package newtimes.production.report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl2YearShipmentChart
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

  public Pnl2YearShipmentChart() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"ETD RANGE");
    pnlDuriation.setLayout(null);
    pnlDuriation.setBounds(new Rectangle(190, 37, 286, 51));
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder1);
    jLabel2.setBounds(new Rectangle(10, 20, 56, 21));
    jLabel2.setText("FROM:");
    txtDateEnd.setBounds(new Rectangle(189, 20, 87, 22));
    txtDateEnd.setText("");
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 53, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(156, 20, 36, 24));
    blueBkgWhiteCharLabel1.setText("2 YEAR SHIPMENT CHART");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 803, 28));
    //cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(54, 51, 130, 22));
    btnQry.setBounds(new Rectangle(693, 56, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlSrnNoDtlList_btnQry_actionAdapter(this));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(54, 20, 87, 20));
    this.setBackground(new Color(202, 202, 224));
    jLabel1.setText("BY");
    jLabel1.setBounds(new Rectangle(483, 54, 27, 20));
    cbxBy.setBounds(new Rectangle(503, 52, 158, 24));
    pnlDuriation.add(jLabel3, null);
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(txtDateEnd, null);
    this.add(jLabel1, null);
    this.add(cbxBy, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCntr, null);
    this.add(btnQry, null);
    this.add(pnlDuriation, null);
    genDataBindObj();
    reportName="YEAR_COMP.rpt&firstgroupassheets=false";
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

    //default begin datae is first day of current mount
    java.util.Calendar cld=java.util.Calendar.getInstance();
    cld.set(cld.DATE,1);
    java.util.Date dFrom=cld.getTime();
    cld.set(cld.DATE,cld.getActualMaximum(cld.DAY_OF_MONTH));
    java.util.Date dEnd=cld.getTime();
    //default end date is end day of currecnt mount

    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtDateBgn, "P_ETD_FM", dFrom,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateBgn);

    dbTxtDateEnd =
        new exgui.DataBindTextWithChecker(txtDateEnd, "P_ETD_TO", dEnd,
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
  if (dateBgn == null) {
    hm.put("P_ETD_FM", "DATE(2000,01,01)");
  }
  if (dateEnd == null) {
    hm.put("P_ETD_TO", "DATE(2099,12,31)");
  }
  hm.put("P_GP",byCode[(cbxBy.getSelectedIndex()==-1)?0:cbxBy.getSelectedIndex()]);
  return hm;
}


void btnQry_actionPerformed(ActionEvent e) {
  String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
  newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
  super.JButtonQueryButtonAction(e);
  newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;
  JLabel jLabel1 = new JLabel();
  JComboBox cbxBy = new JComboBox(new String[]{"GROUP","BUYER","COUNTRY","DEPT"});
  String[] byCode=new String[]{"A","B","C","D"};
}

class PnlSrnNoDtlList_btnQry_actionAdapter implements java.awt.event.
  ActionListener {
  Pnl2YearShipmentChart adaptee;

PnlSrnNoDtlList_btnQry_actionAdapter(Pnl2YearShipmentChart adaptee) {
  this.adaptee = adaptee;
}

 public void actionPerformed(ActionEvent e) {
   adaptee.btnQry_actionPerformed(e);
 }
}

