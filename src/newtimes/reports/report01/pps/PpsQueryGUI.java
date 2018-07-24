package newtimes.reports.report01.pps;

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

public class PpsQueryGUI extends JPanel {
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXCnty = null;
  boolean _isCenSelected = false;
  String usrType = null;
  String usrCenCodeDf = null;
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JComboBox cmboDep = new JComboBox();
  JComboBox cmboDiv = new JComboBox();
  JComboBox cmboSea = new JComboBox();
  JComboBox cmboCountry = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JRadioButton rb_Y = new JRadioButton();
  JRadioButton rb_N = new JRadioButton();
  JButton do_Extract = new JButton();
  JButton do_Recover = new JButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();

  public PpsQueryGUI() {
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Year :");
    jLabel10.setBounds(new Rectangle(207, 119, 155, 20));
    cmboCen.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(364, 41, 209, 20));
    jLabel9.setBounds(new Rectangle(207, 276, 155, 20));
    jLabel9.setText(" Country :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel7.setBounds(new Rectangle(207, 159, 155, 20));
    jLabel7.setText(" Division :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    txtYear.setBounds(new Rectangle(364, 119, 98, 20));
    jLabel110.setBounds(new Rectangle(207, 41, 155, 20));
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
    jLabel22.setBounds(new Rectangle(207, 237, 155, 20));
    jLabel1.setBounds(new Rectangle(470, 119, 77, 20));
    jLabel1.setText("( Year )");
    jLabel1.setForeground(new Color(143, 143, 188));
    cmboCountry.setBackground(Color.white);
    cmboCountry.setBounds(new Rectangle(364, 276, 209, 20));
    cmboSea.setBackground(Color.white);
    cmboSea.setBounds(new Rectangle(364, 237, 209, 20));
    cmboDiv.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(364, 159, 209, 20));
    cmboDep.setBackground(Color.white);
    cmboDep.setBounds(new Rectangle(364, 80, 209, 20));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setForeground(Color.white);
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" FTY :");
    jLabel19.setBounds(new Rectangle(207, 198, 155, 20));
    jLabel1112.setBounds(new Rectangle(207, 80, 155, 20));
    jLabel1112.setText(" Department :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    popMaker.setBounds(new Rectangle(364, 198, 209, 20));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel11.setBackground(new Color(143, 143, 188));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setOpaque(true);
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setText(" Include QTY = 0 ? :");
    jLabel11.setBounds(new Rectangle(207, 316, 155, 20));
    rb_Y.setBackground(Color.white);
    rb_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_Y.setForeground(Color.darkGray);
    rb_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rb_Y.setSelected(true);
    rb_Y.setText("Yes");
    rb_Y.setBounds(new Rectangle(364, 316, 105, 20));
    rb_N.setBackground(Color.white);
    rb_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_N.setForeground(Color.darkGray);
    rb_N.setHorizontalAlignment(SwingConstants.CENTER);
    rb_N.setText("No");
    rb_N.setBounds(new Rectangle(468, 316, 105, 20));
    do_Extract.setFont(new java.awt.Font("Dialog", 1, 12));
    do_Extract.setForeground(Color.darkGray);
    do_Extract.setBounds(new Rectangle(250, 438, 80, 25));
    do_Extract.setText("Extract");
    do_Extract.setMargin(new Insets(0, 0, 0, 0));
    do_Extract.setBounds(new Rectangle(309, 422, 80, 25));
    do_Extract.setBackground(Color.lightGray);
    do_Recover.setFont(new java.awt.Font("Dialog", 1, 12));
    do_Recover.setForeground(Color.darkGray);
    do_Recover.setBounds(new Rectangle(347, 438, 80, 25));
    do_Recover.setBackground(Color.lightGray);
    do_Recover.setBounds(new Rectangle(402, 422, 80, 25));
    do_Recover.setMargin(new Insets(0, 0, 0, 0));
    do_Recover.setSelected(false);
    do_Recover.setText("Recover");
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    this.add(jLabel110, null);
    this.add(cmboCen, null);
    this.add(cmboDep, null);
    this.add(jLabel1112, null);
    this.add(txtYear, null);
    this.add(jLabel10, null);
    this.add(jLabel1, null);
    this.add(cmboDiv, null);
    this.add(jLabel7, null);
    this.add(popMaker, null);
    this.add(jLabel19, null);
    this.add(cmboSea, null);
    this.add(jLabel22, null);
    this.add(cmboCountry, null);
    this.add(jLabel9, null);
    this.add(rb_Y, null);
    this.add(rb_N, null);
    this.add(jLabel11, null);
    this.add(do_Recover, null);
    this.add(do_Extract, null);
    buttonGroup1.add(rb_Y);
    buttonGroup1.add(rb_N);
    this.setCmboData();
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
      java.util.Vector vDataDep = CONST.BASIC_BASE_EJB.getDepByCenterCode(
          dbJCBXCen.getSelectedValue().toString(),"CEN_NAME,DEP_NAME");
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
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCountry, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"),"","null");
      cmboCen.setSelectedIndex(0);
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
    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at Department JComboBox.");
    }
  }

  void setDepItem(String whereClause) {
    java.util.Vector vDataDep = null;
    try {
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (vDataDep.size() > 0) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJCBXDep = new exgui.DataBindJCombobox(
            cmboDep, vDataDep, "DEP_NAME", "DEP_CODE", recDep.get("DEP_CODE"), "", "null");
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

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear,null,"",4);
  }
}
