package newtimes.reports.report_2.pendinglc;

import java.awt.*;
import exgui2.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PendingLCGUI extends JPanel {
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
  JRadioButton rb_LC_1 = new JRadioButton();
  JRadioButton rb_Pending_45 = new JRadioButton();
  JRadioButton rb_LC_2 = new JRadioButton();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JRadioButton rb_Pending_30 = new JRadioButton();
  JRadioButton rb_Pending_20 = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  String usrCenNameDf = null;
  String usrDepNameDf = null;
  String usrCenMod = null;
  String usrDepMod = null;
  String usrCenDF = null;
  String usrType = null;
  String usrCenCodeDf = null;
  boolean _isCenSelected = false;

  public PendingLCGUI() {
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
    rb_Pending_30.setBounds(new Rectangle(476, 276, 105, 20));
    rb_Pending_30.setText("30 Days");
    rb_Pending_30.setHorizontalAlignment(SwingConstants.LEFT);
    rb_Pending_30.setForeground(Color.darkGray);
    rb_Pending_30.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_Pending_30.setBackground(Color.white);
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Year :");
    jLabel10.setBounds(new Rectangle(200, 119, 170, 20));
    jLabel9.setBounds(new Rectangle(200, 276, 170, 20));
    jLabel9.setText(" Pending Days :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    txtYear.setBounds(new Rectangle(372, 119, 98, 20));
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    jLabel110.setBounds(new Rectangle(200, 41, 170, 20));
    jLabel110.setText(" Center :");
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setOpaque(true);
    jLabel110.setForeground(Color.white);
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setForeground(new Color(10,36,106));
    jLabel22.setOpaque(true);
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setText(" Season :");
    jLabel22.setBounds(new Rectangle(200, 237, 170, 20));
    rb_LC_2.setBackground(Color.white);
    rb_LC_2.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_LC_2.setForeground(Color.darkGray);
    rb_LC_2.setHorizontalAlignment(SwingConstants.LEFT);
    rb_LC_2.setText("2-Already L/C Require List, Not Yet L/C");
    rb_LC_2.setBounds(new Rectangle(372, 335, 312, 20));
    rb_Pending_45.setBounds(new Rectangle(372, 276, 105, 20));
    rb_Pending_45.setText("45 Days");
    rb_Pending_45.setSelected(true);
    rb_Pending_45.setHorizontalAlignment(SwingConstants.LEFT);
    rb_Pending_45.setForeground(Color.darkGray);
    rb_Pending_45.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_Pending_45.setBackground(Color.white);
    rb_LC_1.setBackground(Color.white);
    rb_LC_1.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_LC_1.setForeground(Color.darkGray);
    rb_LC_1.setHorizontalAlignment(SwingConstants.LEFT);
    rb_LC_1.setSelected(true);
    rb_LC_1.setText("1-Not Yet L/C Require List");
    rb_LC_1.setBounds(new Rectangle(372, 315, 312, 20));
    cmboCen.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(372, 41, 209, 20));
    jLabel7.setBounds(new Rectangle(200, 158, 170, 20));
    jLabel7.setText(" Division :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel1.setBounds(new Rectangle(478, 119, 77, 20));
    jLabel1.setText("( Year )");
    jLabel1.setForeground(new Color(143, 143, 188));
    jLabel11.setBackground(new Color(143, 143, 188));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setOpaque(true);
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setText(" L/C Type :");
    jLabel11.setBounds(new Rectangle(200, 315, 170, 40));
    cmboSea.setBackground(Color.white);
    cmboSea.setBounds(new Rectangle(372, 237, 209, 20));
    cmboDiv.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(372, 158, 209, 20));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setForeground(Color.white);
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" FTY :");
    jLabel19.setBounds(new Rectangle(200, 198, 170, 20));
    cmboDep.setBackground(Color.white);
    cmboDep.setBounds(new Rectangle(372, 80, 209, 20));
    jLabel1112.setBounds(new Rectangle(200, 80, 170, 20));
    jLabel1112.setText(" Department :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    popMaker.setBounds(new Rectangle(372, 198, 209, 20));
    this.setLayout(null);
    this.setSize(new Dimension(800, 600));
    this.setBackground(new Color(204, 204, 225));
    rb_Pending_20.setBackground(Color.white);
    rb_Pending_20.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_Pending_20.setForeground(Color.darkGray);
    rb_Pending_20.setHorizontalAlignment(SwingConstants.LEFT);
    rb_Pending_20.setText("20 Days");
    rb_Pending_20.setBounds(new Rectangle(580, 276, 105, 20));
    this.add(jLabel1112, null);
    this.add(popMaker, null);
    this.add(cmboDep, null);
    this.add(jLabel19, null);
    this.add(cmboDiv, null);
    this.add(cmboSea, null);
    this.add(jLabel1, null);
    this.add(jLabel7, null);
    this.add(cmboCen, null);
    this.add(rb_LC_1, null);
    this.add(rb_Pending_45, null);
    this.add(jLabel22, null);
    this.add(jLabel110, null);
    this.add(txtYear, null);
    this.add(jLabel9, null);
    this.add(jLabel10, null);
    this.add(rb_Pending_30, null);
    this.add(jLabel11, null);
    this.add(rb_Pending_20, null);
    this.add(rb_LC_2, null);
    buttonGroup1.add(rb_Pending_45);
    buttonGroup1.add(rb_Pending_30);
    buttonGroup1.add(rb_Pending_20);
    buttonGroup2.add(rb_LC_1);
    buttonGroup2.add(rb_LC_2);
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
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;

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

      cmboSea.setSelectedIndex(0);
      cmboDiv.setSelectedIndex(0);

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
