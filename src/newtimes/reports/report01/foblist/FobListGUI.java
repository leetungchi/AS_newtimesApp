package newtimes.reports.report01.foblist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import exgui2.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FobListGUI extends JPanel {
  JComboBox cmboDiv = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JLabel jLabel110 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel10 = new JLabel();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  String usrCenNameDf = null;
  String usrDepNameDf = null;
  String usrCenMod = null;
  String usrDepMod = null;
  JLabel jLabel11 = new JLabel();
  JTextField txtRange1 = new JTextField();
  JTextField txtRange2 = new JTextField();
  JTextField txtRange3 = new JTextField();
  JTextField txtRange4 = new JTextField();
  JTextField txtRange5 = new JTextField();
  JTextField txtRange6 = new JTextField();
  JTextField txtRange7 = new JTextField();
  JTextField txtRange8 = new JTextField();

  public FobListGUI() {
    try {
      usrCenNameDf = util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString();
      usrDepNameDf = util.PublicVariable.USER_RECORD.get("DEP_NAME_DF").toString();
      usrCenMod = util.PublicVariable.USER_RECORD.get("USR_CEN_MOD").toString();
      usrDepMod = util.PublicVariable.USER_RECORD.get("USR_DEP_MOD").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel10.setBounds(new Rectangle(208, 161, 155, 20));
    jLabel10.setText(" Year :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(Color.white);
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    txtYear.setBounds(new Rectangle(365, 161, 54, 20));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(Color.white);
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Center :");
    jLabel110.setBounds(new Rectangle(208, 83, 155, 20));
    cmboCen.setBounds(new Rectangle(365, 83, 209, 20));
    cmboCen.setBackground(Color.white);
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setOpaque(true);
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setText(" Division :");
    jLabel7.setBounds(new Rectangle(208, 123, 155, 20));
    jLabel1.setForeground(new Color(143, 143, 188));
    jLabel1.setText("( Year )");
    jLabel1.setBounds(new Rectangle(422, 160, 77, 20));
    cmboDiv.setBounds(new Rectangle(365, 123, 209, 20));
    cmboDiv.setBackground(Color.white);
    this.setLayout(null);
    this.setSize(new Dimension(800, 600));
    this.setBackground(new Color(204, 204, 225));
    jLabel11.setBackground(new Color(143, 143, 188));
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setOpaque(true);
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setText(" Range :");
    jLabel11.setBounds(new Rectangle(208, 200, 155, 20));
    txtRange1.setText("");
    txtRange1.setBounds(new Rectangle(364, 200, 55, 20));
    txtRange2.setBounds(new Rectangle(425, 200, 55, 20));
    txtRange2.setText("");
    txtRange3.setBounds(new Rectangle(486, 200, 55, 20));
    txtRange3.setText("");
    txtRange4.setBounds(new Rectangle(547, 200, 55, 20));
    txtRange4.setText("");
    txtRange5.setBounds(new Rectangle(364, 231, 55, 20));
    txtRange5.setText("");
    txtRange6.setBounds(new Rectangle(425, 231, 55, 20));
    txtRange6.setText("");
    txtRange7.setBounds(new Rectangle(486, 231, 55, 20));
    txtRange7.setText("");
    txtRange8.setBounds(new Rectangle(547, 231, 55, 20));
    txtRange8.setText("");
    this.add(jLabel110, null);
    this.add(cmboCen, null);
    this.add(txtYear, null);
    this.add(jLabel10, null);
    this.add(jLabel7, null);
    this.add(cmboDiv, null);
    this.add(jLabel11, null);
    this.add(txtRange1, null);
    this.add(txtRange5, null);
    this.add(txtRange6, null);
    this.add(txtRange7, null);
    this.add(txtRange8, null);
    this.add(txtRange3, null);
    this.add(txtRange4, null);
    this.add(txtRange2, null);
    this.add(jLabel1, null);
    if (this.usrCenMod.equalsIgnoreCase("Y")) {
      this.cmboCen.setEnabled(true);
    } else {
      this.cmboCen.setEnabled(false);
    }
    this.setCmboData();
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;
    java.util.Vector vDataDep = null;

    try {
      vDataCen = CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(
          cmboCen, vDataCen, "CEN_NAME", "CEN_CODE", recCen.get("CEN_CODE"),"","null");
      vDataDiv = CONST.BASIC_MAIN_EJB.getDivisionAll("DIV_CODE,DIV_NAME", "DIV_NAME");
      database.datatype.Record recDiv = (database.datatype.Record) vDataDiv.get(0);
      dbJCBXDiv = new exgui.DataBindJCombobox(
          cmboDiv, vDataDiv, "DIV_NAME", "DIV_CODE", recDiv.get("DIV_CODE"),"","null");

      cmboDiv.setSelectedIndex(0);
      cmboCen.setSelectedItem(this.usrCenNameDf);
    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at JComboBox.");
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear,null,"",4);
  }
}
