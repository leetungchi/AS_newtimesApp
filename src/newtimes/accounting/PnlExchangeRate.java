package newtimes.accounting;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import exgui.*;
import java.awt.event.*;
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

public class PnlExchangeRate
    //extends JPanel {
    extends newtimes.production.report.AbsQryPanel {
  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JLabel jLabel3 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JTextField txtDateBgn = new JTextField();
  TitledBorder titledBorder1;
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JComboBox cbxCurrency = new JComboBox(new String[]{"TWD","USD","RMB"});
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JComboBox cbxCurrencyBase = new JComboBox(new String[]{"TWD","USD","RMB"});
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnReport = new JButton();
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  boolean doingDB2Gui=false;
  exgui.DataBindJCombobox DbJcbxcbxCntr;

  public PnlExchangeRate() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
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
      //default end date is end day of currecnt mount

      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "P_DD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_DD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);

      doingDB2Gui=false;
      //cbxCntr.getItemListeners()[0].itemStateChanged(null);
      cbxCurrency.setSelectedIndex(0);
      cbxCurrencyBase.setSelectedIndex(1);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public HashMap composeParameters() {
    HashMap hm = super.composeParameters();
    hm.put("P_CURRENCY",cbxCurrency.getSelectedItem());
    hm.put("P_BASE",cbxCurrencyBase.getSelectedItem());
    return  hm;
  }
  protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"EXCHANGE RATE");
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder1);
    pnlDuriation.setBounds(new Rectangle(386, 60, 286, 53));
    pnlDuriation.setLayout(null);
    blueBkgWhiteCharLabel3.setText("Center");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(13, 54, 60, 19));
    jLabel2.setText("FROM:");
    jLabel2.setBounds(new Rectangle(8, 19, 56, 21));
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(187, 19, 87, 22));
    this.setLayout(null);
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(154, 19, 36, 24));
    cbxCntr.setBounds(new Rectangle(57, 54, 130, 22));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(52, 19, 87, 20));
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel4.setText("CURRENCY");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(11, 90, 75, 19));
    cbxCurrency.setBounds(new Rectangle(85, 89, 105, 22));
    blueBkgWhiteCharLabel5.setText("BASE");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(231, 92, 47, 19));
    cbxCurrencyBase.setBounds(new Rectangle(278, 91, 95, 22));
    blueBkgWhiteCharLabel1.setText("EXCHANGE RATE LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 15, 798, 26));
    btnReport.setBounds(new Rectangle(688, 75, 88, 26));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setText("QUERY");
    btnReport.addActionListener(new PnlExchangeRate_btnReport_actionAdapter(this));
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(txtDateEnd, null);
    pnlDuriation.add(jLabel3, null);
    this.add(btnReport, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(cbxCurrency, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(cbxCurrencyBase, null);
    this.add(pnlDuriation, null);
    reportName="exrate_det.rpt";
    genDataBindObj();
  }

  void btnReport_actionPerformed(ActionEvent e) {
    if(txtDateBgn.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Begin Date",
                                             "Please Input Begin Date");
      return;
    }
    if(txtDateEnd.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input END Date",
                                             "Please Input END Date");
      return;
    }
    super.JButtonQueryButtonAction(e);
  }
}

class PnlExchangeRate_btnReport_actionAdapter implements java.awt.event.ActionListener {
  PnlExchangeRate adaptee;

  PnlExchangeRate_btnReport_actionAdapter(PnlExchangeRate adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnReport_actionPerformed(e);
  }
}
