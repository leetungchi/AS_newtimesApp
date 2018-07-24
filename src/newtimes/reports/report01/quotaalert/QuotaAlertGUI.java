package newtimes.reports.report01.quotaalert;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.*;
import newtimes.material.Util;
import exgui2.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QuotaAlertGUI extends JPanel {
  GetBuyerMaker dlgBuyer = new GetBuyerMaker(1);
  PopAndSelect2Text popBuyer = new PopAndSelect2Text(dlgBuyer, "BYMKR_SEQ", "BYMKR_BRIEF");
  JLabel jLabel4 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JComboBox cmboCountry = new JComboBox();
  JTextField txtYear = new JTextField();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JComboBox cmboQCat = new JComboBox();
  JComboBox cmboQArea = new JComboBox();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField tfOver = new JTextField();
  JLabel jLabel8 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXQCat = null;
  exgui.DataBindJCombobox dbJCBXCountry = null;
  String usrCenNameDf = null;
  String usrCenMod = null;
  JLabel jLabel1 = new JLabel();

  public QuotaAlertGUI() {
    try {
      usrCenNameDf = util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString();
      usrCenMod = util.PublicVariable.USER_RECORD.get("USR_CEN_MOD").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,600);


    jLabel4.setBounds(new Rectangle(234, 286, 59, 20));
    jLabel4.setText("YEAR:");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel2.setBounds(new Rectangle(234, 97, 93, 20));
    jLabel2.setText("QUOTA AREA:");
    jLabel2.setVerticalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(10,36,106));
    cmboCountry.setBackground(Color.WHITE);
    cmboCountry.setBounds(new Rectangle(332, 210, 177, 22));
    cmboCountry.setBorder(BorderFactory.createEtchedBorder());
    txtYear.setBorder(BorderFactory.createEtchedBorder());
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(332, 286, 68, 22));
    jLabel6.setForeground(new Color(10,36,106));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("BUYER:");
    jLabel6.setBounds(new Rectangle(234, 248, 59, 20));
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("QUOTA CAT:");
    jLabel3.setBounds(new Rectangle(234, 135, 93, 20));
    cmboQCat.setBackground(Color.WHITE);
    cmboQCat.setBounds(new Rectangle(332, 135, 177, 22));
    cmboQCat.setBorder(BorderFactory.createEtchedBorder());
    cmboQArea.setBorder(BorderFactory.createEtchedBorder());
    cmboQArea.setBounds(new Rectangle(332, 97, 177, 22));
    cmboQArea.setBackground(Color.WHITE);
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("COUNTRY:");
    jLabel5.setBounds(new Rectangle(234, 210, 59, 20));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("% OVER:");
    jLabel7.setBounds(new Rectangle(234, 173, 59, 20));
    tfOver.setBounds(new Rectangle(332, 173, 68, 22));
    tfOver.setText("");
    tfOver.setBorder(BorderFactory.createEtchedBorder());
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setRequestFocusEnabled(true);
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setVerticalAlignment(SwingConstants.CENTER);
    jLabel8.setText(" CENTER:");
    jLabel8.setBounds(new Rectangle(232, 61, 93, 20));
    cmboCen.setBackground(Color.WHITE);
    cmboCen.setBounds(new Rectangle(332, 59, 177, 22));
    cmboCen.setBorder(BorderFactory.createEtchedBorder());
    popBuyer.setBounds(new Rectangle(332, 249, 224, 22));
    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setVerifyInputWhenFocusTarget(true);
    jLabel1.setText(" %");
    jLabel1.setBounds(new Rectangle(400, 175, 22, 18));
    this.add(jLabel8, null);
    this.add(jLabel2, null);
    this.add(cmboQArea, null);
    this.add(cmboCountry, null);
    this.add(jLabel6, null);
    this.add(jLabel3, null);
    this.add(jLabel5, null);
    this.add(txtYear, null);
    this.add(jLabel4, null);
    this.add(jLabel7, null);
    this.add(tfOver, null);
    this.add(cmboQCat, null);
    this.add(cmboCen, null);
    this.add(popBuyer, null);
    this.add(jLabel1, null);
    if (this.usrCenMod.equalsIgnoreCase("Y")) {
      this.cmboCen.setEnabled(true);
    } else {
      this.cmboCen.setEnabled(false);
    }
    this.setCmboData();
    this.setYearMaxLength();
    this.settfOverMaxLength();
  }
  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataBuyer = null;
    java.util.Vector vDataQCat = null;
    java.util.Vector vDataCountry = null;

    try {
      vDataCen = CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(
          cmboCen, vDataCen, "CEN_NAME", "CEN_CODE", recCen.get("CEN_CODE"),"","null");
      vDataCountry = CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME", "CNTY_NAME");
      database.datatype.Record recCountry = (database.datatype.Record) vDataCountry.get(0);
      dbJCBXCountry = new exgui.DataBindJCombobox(
          cmboCountry, vDataCountry, "CNTY_NAME", "CNTY_NAME", recCountry.get("CNTY_NAME"),"","null");
      vDataQCat = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("QTA_CAT","QTA_CAT");
      database.datatype.Record recQTA = (database.datatype.Record) vDataQCat.get(0) ;
      dbJCBXQCat = new exgui.DataBindJCombobox(cmboQCat, vDataQCat, "QTA_CAT",
                                          "QTA_CAT", recQTA.get("QTA_CAT"),"","null");

      cmboQArea.addItem("");
      cmboQArea.addItem("U");
      cmboQArea.addItem("C");
      cmboQArea.addItem("E");
      cmboQArea.addItem("I");

      cmboQArea.setSelectedIndex(0);
      cmboCountry.setSelectedIndex(0);
      cmboQCat.setSelectedIndex(0);
      cmboCen.setSelectedItem(this.usrCenNameDf);
    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at JComboBox.");
    }
  }

  void setYearMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear,null,"",4);
  }
  void settfOverMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(tfOver,null,"",5);
  }

}


