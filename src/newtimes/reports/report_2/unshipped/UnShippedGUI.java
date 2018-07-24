package newtimes.reports.report_2.unshipped;

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

public class UnShippedGUI extends JPanel {
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  JLabel jLabel1112 = new JLabel();
  JComboBox cmboDep = new JComboBox();
  JLabel jLabel19 = new JLabel();
  JComboBox cmboDiv = new JComboBox();
  JComboBox cmboSea = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel10 = new JLabel();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXQuota = null;
  String usrCenNameDf = null;
  String usrDepNameDf = null;
  String usrCenMod = null;
  String usrDepMod = null;
  String usrCenDF = null;
  JLabel jLabel23 = new JLabel();
  JComboBox cmboQuota = new JComboBox();
  String usrType = null;
  String usrCenCodeDf = null;
  boolean _isCenSelected = false;

  public UnShippedGUI() {
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
    jLabel10.setBounds(new Rectangle(209, 119, 155, 20));
    jLabel10.setText(" Year :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(Color.white);
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    txtYear.setBounds(new Rectangle(366, 119, 98, 20));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(Color.white);
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Center :");
    jLabel110.setBounds(new Rectangle(209, 41, 155, 20));
    jLabel22.setBounds(new Rectangle(209, 237, 155, 20));
    jLabel22.setText(" Season :");
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setOpaque(true);
    jLabel22.setForeground(new Color(10,36,106));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    cmboCen.setBounds(new Rectangle(366, 41, 209, 20));
    cmboCen.setBackground(Color.white);
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setOpaque(true);
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setText(" Division :");
    jLabel7.setBounds(new Rectangle(209, 159, 155, 20));
    jLabel1.setForeground(new Color(143, 143, 188));
    jLabel1.setText("( Year )");
    jLabel1.setBounds(new Rectangle(472, 119, 77, 20));
    cmboSea.setBounds(new Rectangle(366, 237, 209, 20));
    cmboSea.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(366, 159, 209, 20));
    cmboDiv.setBackground(Color.white);
    jLabel19.setBounds(new Rectangle(209, 198, 155, 20));
    jLabel19.setText(" FTY :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(Color.white);
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    cmboDep.setBounds(new Rectangle(366, 80, 209, 20));
    cmboDep.setBackground(Color.white);
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setOpaque(true);
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setText(" Department :");
    jLabel1112.setBounds(new Rectangle(209, 80, 155, 20));
    popMaker.setBounds(new Rectangle(366, 198, 209, 20));
    this.setLayout(null);
    this.setSize(new Dimension(800, 600));
    this.setBackground(new Color(204, 204, 225));
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel23.setBackground(new Color(143, 143, 188));
    jLabel23.setForeground(Color.white);
    jLabel23.setOpaque(true);
    jLabel23.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel23.setText(" Quota :");
    jLabel23.setBounds(new Rectangle(209, 276, 155, 20));
    cmboQuota.setBackground(Color.white);
    cmboQuota.setBounds(new Rectangle(366, 276, 209, 20));
    this.add(jLabel110, null);
    this.add(popMaker, null);
    this.add(jLabel1112, null);
    this.add(cmboDep, null);
    this.add(jLabel19, null);
    this.add(cmboDiv, null);
    this.add(cmboSea, null);
    this.add(jLabel1, null);
    this.add(jLabel7, null);
    this.add(cmboCen, null);
    this.add(jLabel22, null);
    this.add(txtYear, null);
    this.add(jLabel10, null);
    this.add(jLabel23, null);
    this.add(cmboQuota, null);
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
    java.util.Vector vDataQuota = null;

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
      vDataQuota = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("(QTA_CAT || QTA_AREA) QTA_CAT","QTA_CAT");
      database.datatype.Record recQTA = (database.datatype.Record) vDataQuota.get(0) ;
      dbJCBXQuota = new exgui.DataBindJCombobox(cmboQuota, vDataQuota, "QTA_CAT",
                                          "QTA_CAT", recQTA.get("QTA_CAT"),"","null");


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
      cmboQuota.setSelectedIndex(0);
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
