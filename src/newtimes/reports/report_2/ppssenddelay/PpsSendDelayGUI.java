package newtimes.reports.report_2.ppssenddelay;

import java.awt.*;
import javax.swing.*;
import exgui2.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PpsSendDelayGUI extends JPanel {
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  JLabel jLabel1112 = new JLabel();
  JComboBox cmboDep = new JComboBox();
  JLabel jLabel19 = new JLabel();
  JComboBox cmboDiv = new JComboBox();
  JComboBox cmboSea = new JComboBox();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JRadioButton rbExcOdr_Y = new JRadioButton();
  JComboBox cmboCountry = new JComboBox();
  JLabel jLabel22 = new JLabel();
  JRadioButton rbExcOdr_N = new JRadioButton();
  JLabel jLabel110 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JRadioButton rbExcCn_Y = new JRadioButton();
  JRadioButton rbExcCn_N = new JRadioButton();
  JRadioButton rbRCVD_20 = new JRadioButton();
  JLabel jLabel13 = new JLabel();
  JRadioButton rbRCVD_10 = new JRadioButton();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXCnty = null;
  String usrCenNameDf = null;
  String usrDepNameDf = null;
  String usrCenMod = null;
  String usrDepMod = null;
  String usrCenDF=null;
  ButtonGroup buttonGroup1 = new ButtonGroup();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  ButtonGroup buttonGroup3 = new ButtonGroup();
  String usrType = null;
  String usrCenCodeDf = null;
  boolean _isCenSelected = false;

  public PpsSendDelayGUI() {
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      usrCenNameDf = util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString();
      usrDepNameDf = util.PublicVariable.USER_RECORD.get("DEP_NAME_DF").toString();
      usrCenMod = util.PublicVariable.USER_RECORD.get("USR_CEN_MOD").toString();
      usrDepMod = util.PublicVariable.USER_RECORD.get("USR_DEP_MOD").toString();
      usrCenDF =  util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel10.setBounds(new Rectangle(201, 119, 170, 20));
    jLabel10.setText(" Year :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(Color.white);
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(Color.white);
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" Country :");
    jLabel9.setBounds(new Rectangle(201, 276, 170, 20));
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    txtYear.setBounds(new Rectangle(373, 119, 98, 20));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(Color.white);
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Center :");
    jLabel110.setBounds(new Rectangle(201, 41, 170, 20));
    rbExcOdr_N.setBounds(new Rectangle(477, 315, 105, 20));
    rbExcOdr_N.setText("No");
    rbExcOdr_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbExcOdr_N.setForeground(Color.darkGray);
    rbExcOdr_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbExcOdr_N.setBackground(Color.white);
    jLabel22.setBounds(new Rectangle(201, 237, 170, 20));
    jLabel22.setText(" Season :");
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setOpaque(true);
    jLabel22.setForeground(new Color(10,36,106));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    cmboCountry.setBounds(new Rectangle(373, 276, 209, 20));
    cmboCountry.setBackground(Color.white);
    rbExcOdr_Y.setBounds(new Rectangle(373, 315, 105, 20));
    rbExcOdr_Y.setText("Yes");
    rbExcOdr_Y.setSelected(true);
    rbExcOdr_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbExcOdr_Y.setForeground(Color.darkGray);
    rbExcOdr_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbExcOdr_Y.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(373, 41, 209, 20));
    cmboCen.setBackground(Color.white);
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setOpaque(true);
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setText(" Division :");
    jLabel7.setBounds(new Rectangle(201, 158, 170, 20));
    jLabel1.setForeground(new Color(143, 143, 188));
    jLabel1.setText("( Year )");
    jLabel1.setBounds(new Rectangle(479, 119, 77, 20));
    jLabel11.setBounds(new Rectangle(201, 315, 170, 20));
    jLabel11.setText(" Exclude Order - QTY = 0 ? :");
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    cmboSea.setBounds(new Rectangle(373, 237, 209, 20));
    cmboSea.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(373, 158, 209, 20));
    cmboDiv.setBackground(Color.white);
    jLabel19.setBounds(new Rectangle(201, 198, 170, 20));
    jLabel19.setText(" FTY :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(Color.white);
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    cmboDep.setBounds(new Rectangle(373, 80, 209, 20));
    cmboDep.setBackground(Color.white);
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setOpaque(true);
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setText(" Department :");
    jLabel1112.setBounds(new Rectangle(201, 80, 170, 20));
    popMaker.setBounds(new Rectangle(373, 198, 209, 20));
    this.setLayout(null);
    this.setSize(new Dimension(800, 600));
    this.setBackground(new Color(204, 204, 225));
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setForeground(Color.white);
    jLabel12.setOpaque(true);
    jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel12.setText(" Exclude Canada = 0 ? :");
    jLabel12.setBounds(new Rectangle(201, 354, 170, 20));
    rbExcCn_Y.setBackground(Color.white);
    rbExcCn_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbExcCn_Y.setForeground(Color.darkGray);
    rbExcCn_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbExcCn_Y.setSelected(true);
    rbExcCn_Y.setText("Yes");
    rbExcCn_Y.setBounds(new Rectangle(373, 354, 105, 20));
    rbExcCn_N.setBackground(Color.white);
    rbExcCn_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbExcCn_N.setForeground(Color.darkGray);
    rbExcCn_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbExcCn_N.setText("No");
    rbExcCn_N.setBounds(new Rectangle(477, 354, 105, 20));
    rbRCVD_20.setBounds(new Rectangle(477, 393, 105, 20));
    rbRCVD_20.setText("20 Days");
    rbRCVD_20.setHorizontalAlignment(SwingConstants.CENTER);
    rbRCVD_20.setForeground(Color.darkGray);
    rbRCVD_20.setFont(new java.awt.Font("Dialog", 1, 12));
    rbRCVD_20.setBackground(Color.white);
    jLabel13.setBounds(new Rectangle(201, 393, 170, 20));
    jLabel13.setText(" PPS Not Yet RCVD :");
    jLabel13.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel13.setOpaque(true);
    jLabel13.setForeground(new Color(10,36,106));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setBackground(new Color(143, 143, 188));
    rbRCVD_10.setBounds(new Rectangle(373, 393, 105, 20));
    rbRCVD_10.setText("10 Days");
    rbRCVD_10.setSelected(true);
    rbRCVD_10.setHorizontalAlignment(SwingConstants.CENTER);
    rbRCVD_10.setForeground(Color.darkGray);
    rbRCVD_10.setFont(new java.awt.Font("Dialog", 1, 12));
    rbRCVD_10.setBackground(Color.white);
    this.add(jLabel110, null);
    this.add(popMaker, null);
    this.add(jLabel1112, null);
    this.add(cmboDep, null);
    this.add(jLabel19, null);
    this.add(cmboDiv, null);
    this.add(cmboSea, null);
    this.add(jLabel11, null);
    this.add(jLabel1, null);
    this.add(jLabel7, null);
    this.add(cmboCen, null);
    this.add(rbExcOdr_Y, null);
    this.add(cmboCountry, null);
    this.add(jLabel22, null);
    this.add(rbExcOdr_N, null);
    this.add(txtYear, null);
    this.add(jLabel9, null);
    this.add(jLabel10, null);
    this.add(jLabel12, null);
    this.add(rbExcCn_Y, null);
    this.add(rbExcCn_N, null);
    this.add(rbRCVD_10, null);
    this.add(jLabel13, null);
    this.add(rbRCVD_20, null);
    if (this.usrCenMod.equalsIgnoreCase("Y")) {
      this.cmboCen.setEnabled(true);
    } else {
      this.cmboCen.setEnabled(false);
    }
    if (this.usrDepMod.equalsIgnoreCase("Y")) {
      this.cmboDep.setEnabled(true);
    } else {
      this.cmboDep.setEnabled(false);
    }
    this.setCmboData();
    buttonGroup1.add(rbExcOdr_Y);
    buttonGroup1.add(rbExcOdr_N);
    buttonGroup2.add(rbExcCn_Y);
    buttonGroup2.add(rbExcCn_N);
    buttonGroup3.add(rbRCVD_10);
    buttonGroup3.add(rbRCVD_20);
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;
    java.util.Vector vDataCnty = null;

    try {
      vDataCen = CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(
          cmboCen, vDataCen, "CEN_NAME", "CEN_CODE", recCen.get("CEN_CODE"),"","null");
      vDataSeason = CONST.BASIC_MAIN_EJB.getSeasonAll("SEA_NAME", "SEA_NAME");
      database.datatype.Record recSeason = (database.datatype.Record) vDataSeason.get(0);
      dbJCBXSeason = new exgui.DataBindJCombobox(
          cmboSea, vDataSeason, "SEA_NAME", "SEA_NAME", recSeason.get("SEA_NAME"),"","null");
      vDataDiv = CONST.BASIC_MAIN_EJB.getDivisionAll("DIV_CODE,DIV_NAME", "DIV_NAME");
      database.datatype.Record recDiv = (database.datatype.Record) vDataDiv.get(0);
      dbJCBXDiv = new exgui.DataBindJCombobox(
          cmboDiv, vDataDiv, "DIV_NAME", "DIV_CODE", recDiv.get("DIV_CODE"),"","null");
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(
          cmboCountry, vDataCnty, "CNTY_NAME","CNTY_NAME", rec.get("CNTY_NAME"),"","null");

      cmboSea.setSelectedIndex(0);
      cmboDiv.setSelectedIndex(0);
      cmboCountry.setSelectedIndex(0);

      if (usrType.equals("2") || usrType.equals("7")) {
        this._isCenSelected = true;
        cmboCen.addItemListener(new java.awt.event.ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            cmboCen_itemStateChanged(e);
          }
        });
        cmboCen.setSelectedIndex(0);
      } else {
        cmboCen.setSelectedItem(util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString());
        cmboCen.setEnabled(false);
        this._isCenSelected = false;
        this.setDepItem("DEP_CEN_CODE = '"+usrCenCodeDf+"'");
      }
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

  void setDepItem(String whereClause) {
    java.util.Vector vDataDep = null;
    try {
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (vDataDep.size() > 0) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJCBXDep = new exgui.DataBindJCombobox(
            cmboDep, vDataDep, "DEP_NAME", "DEP_CODE", recDep.get("DEP_CODE"), "", "null");
        cmboDep.setSelectedItem(this.usrDepNameDf);
      } else {
        cmboDep.removeAllItems();
      }
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD, "error at set Dep. items.\n"+"vector:"+vDataDep.toString());
    }
  }

  void cmboCen_itemStateChanged(ItemEvent e) {
    try {
      if (!dbJCBXCen.getSelectedValue().equals("null")) {
        this.setDepItem("DEP_CEN_CODE = '"+dbJCBXCen.getSelectedValue()+"'");
      }
    } catch (Exception eItem) {
      eItem.printStackTrace();
      util.ExceptionLog.exp2File(eItem, "error at change department item.");
    }
  }
}
