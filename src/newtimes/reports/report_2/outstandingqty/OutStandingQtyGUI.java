package newtimes.reports.report_2.outstandingqty;

import java.awt.*;
import java.awt.event.*;
import exgui2.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class OutStandingQtyGUI extends JPanel {
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JComboBox cmboDep = new JComboBox();
  JComboBox cmboDiv = new JComboBox();
  JComboBox cmboSea = new JComboBox();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JLabel jLabel1 = new JLabel();
  boolean _isCenSelected = false;
  String usrType = null;
  String usrCenCodeDf = null;

  public OutStandingQtyGUI() {
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
    jLabel1.setBounds(new Rectangle(117, 12, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ============  Outstanding QTY Report by FTY/DEL  ============      ");

    cmboCen.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(184, 60, 209, 20));
    jLabel7.setBounds(new Rectangle(27, 113, 155, 20));
    jLabel7.setText(" Division :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel110.setBounds(new Rectangle(27, 60, 155, 20));
    jLabel110.setText(" Center :");
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setOpaque(true);
    jLabel110.setForeground(new Color(10,36,106));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setForeground(Color.white);
    jLabel22.setOpaque(true);
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setText(" Season :");
    jLabel22.setBounds(new Rectangle(405, 86, 155, 20));
    cmboSea.setBackground(Color.white);
    cmboSea.setBounds(new Rectangle(562, 86, 209, 20));
    cmboDiv.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(184, 113, 209, 20));
    cmboDep.setBackground(Color.white);
    cmboDep.setBounds(new Rectangle(562, 60, 209, 20));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setForeground(Color.white);
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" FTY :");
    jLabel19.setBounds(new Rectangle(27, 86, 155, 20));
    jLabel1112.setBounds(new Rectangle(405, 60, 155, 20));
    jLabel1112.setText(" Department :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    popMaker.setBounds(new Rectangle(184, 86, 209, 20));
    this.setLayout(null);
    this.setSize(new Dimension(800, 156));
    this.setBackground(new Color(204, 204, 225));
    this.add(jLabel1, null);
    this.add(jLabel1112, null);
    this.add(cmboCen, null);
    this.add(popMaker, null);
    this.add(jLabel19, null);
    this.add(jLabel110, null);
    this.add(jLabel7, null);
    this.add(cmboDiv, null);
    this.add(cmboDep, null);
    this.add(jLabel22, null);
    this.add(cmboSea, null);
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

      cmboCen.setSelectedIndex(0);
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
}
