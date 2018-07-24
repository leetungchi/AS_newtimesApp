package newtimes.shipping.shipmentinfo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui2.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ShipmentInfoGUI extends JPanel {
  boolean _isCenSelected = false;
  String usrType = null;
  String usrCenCodeDf = null;
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXCnty = null;
  JComboBox cmboSea = new JComboBox();
  JComboBox cmboDep = new JComboBox();
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel1110 = new JLabel();
  JComboBox cmboDiv = new JComboBox();
  JLabel jLabel9 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel19 = new JLabel();
  JTextField txtRng = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel120 = new JLabel();
  JCheckBox chkBx_None = new JCheckBox("NONE");
  JLabel jLabel22 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JLabel jLabel110 = new JLabel();
  JComboBox cmboCountry = new JComboBox();
  JLabel jLabel10 = new JLabel();
  JButton do_ShipInfo = new JButton();
  JButton do_PrintUnShip = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JList listQTA = new JList();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JTextField txtETDFm_D = new JTextField();
  JTextField txtETDTo_D = new JTextField();
  JLabel jLabel14 = new JLabel();
  JTextField txtETDTo_Y = new JTextField();
  JLabel jLabel16 = new JLabel();
  JTextField txtETDFm_Y = new JTextField();
  JTextField txtETDTo_M = new JTextField();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JTextField txtETDFm_M = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JTextField txtDelFm_Y = new JTextField();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JTextField txtDelTo_D = new JTextField();
  JTextField txtDelTo_Y = new JTextField();
  JTextField txtDelTo_M = new JTextField();
  JTextField txtDelFm_M = new JTextField();
  JTextField txtDelFm_D = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtPO = new JTextField();
  JLabel jLabel1111 = new JLabel();
  JLabel jLabel1113 = new JLabel();
  JCheckBox chkBx_Yes = new JCheckBox();
  boolean isChk_None = false;
  boolean isChk_Yes = false;
  JComboBox CmbShipMethod = new JComboBox();


  public ShipmentInfoGUI() {
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
    popMaker.setBounds(new Rectangle(170, 38, 209, 20));
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setOpaque(true);
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setText(" Department :");
    jLabel1112.setBounds(new Rectangle(391, 12, 155, 20));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel1.setForeground(new Color(143, 143, 188));
    jLabel1.setText("( Year )");
    jLabel1.setBounds(new Rectangle(271, 91, 77, 20));
    jLabel13.setBackground(new Color(143, 143, 188));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setForeground(Color.white);
    jLabel13.setOpaque(true);
    jLabel13.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel13.setText(" Quota Area :");
    jLabel13.setBounds(new Rectangle(13, 166, 180, 20));
    jLabel1110.setBounds(new Rectangle(391, 91, 155, 20));
    jLabel1110.setText(" Ship Method :");
    jLabel1110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1110.setOpaque(true);
    jLabel1110.setForeground(Color.white);
    jLabel1110.setBackground(new Color(143, 143, 188));
    jLabel1110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" Country :");
    jLabel9.setBounds(new Rectangle(13, 117, 155, 20));
    jLabel19.setBounds(new Rectangle(13, 38, 155, 20));
    jLabel19.setText(" FTY :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(Color.white);
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    txtRng.setBounds(new Rectangle(548, 65, 209, 20));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setOpaque(true);
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setText(" Division :");
    jLabel7.setBounds(new Rectangle(13, 65, 155, 20));
    jLabel120.setBackground(new Color(143, 143, 188));
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel120.setForeground(new Color(10,36,106));
    jLabel120.setOpaque(true);
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setText(" Range :");
    jLabel120.setBounds(new Rectangle(391, 65, 155, 20));
    chkBx_None.setBackground(new Color(143, 143, 188));
    chkBx_None.setFont(new java.awt.Font("Dialog", 1, 12));
    chkBx_None.setForeground(new Color(10,36,106));
    chkBx_None.setToolTipText("");
    chkBx_None.setText(" None");
    chkBx_None.setBounds(new Rectangle(193, 166, 185, 20));
    chkBx_None.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        chkBx_None_itemStateChanged(e);
      }
    });
    jLabel22.setBounds(new Rectangle(391, 38, 155, 20));
    jLabel22.setText(" Season :");
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setOpaque(true);
    jLabel22.setForeground(Color.white);
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(new Color(10,36,106));
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Center :");
    jLabel110.setBounds(new Rectangle(13, 12, 155, 20));
    jLabel10.setBounds(new Rectangle(13, 91, 155, 20));
    jLabel10.setText(" Year :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(Color.white);
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    cmboSea.setBounds(new Rectangle(548, 38, 209, 20));
    cmboDep.setBounds(new Rectangle(548, 12, 209, 20));
    cmboDiv.setBounds(new Rectangle(170, 65, 209, 20));
    txtYear.setBounds(new Rectangle(170, 91, 98, 20));
    cmboCen.setBounds(new Rectangle(170, 12, 209, 20));
    cmboCountry.setBounds(new Rectangle(170, 117, 209, 20));
    do_ShipInfo.setFont(new java.awt.Font("Dialog", 1, 12));
    do_ShipInfo.setForeground(Color.darkGray);
    do_ShipInfo.setBounds(new Rectangle(250, 438, 80, 25));
    do_ShipInfo.setText("Ship-Info");
    do_ShipInfo.setMargin(new Insets(0, 0, 0, 0));
    do_ShipInfo.setBounds(new Rectangle(298, 431, 80, 25));
    do_ShipInfo.setBackground(Color.lightGray);
    do_PrintUnShip.setFont(new java.awt.Font("Dialog", 1, 12));
    do_PrintUnShip.setForeground(Color.darkGray);
    do_PrintUnShip.setBounds(new Rectangle(347, 438, 80, 25));
    do_PrintUnShip.setBackground(Color.lightGray);
    do_PrintUnShip.setBounds(new Rectangle(391, 431, 80, 25));
    do_PrintUnShip.setMargin(new Insets(0, 0, 0, 0));
    do_PrintUnShip.setText("Un-Ship");
    jScrollPane1.setBounds(new Rectangle(13, 186, 365, 169));
    cmboCen.setBackground(Color.white);
    cmboDep.setBackground(Color.white);
    cmboDiv.setBackground(Color.white);
    cmboSea.setBackground(Color.white);
    cmboCountry.setBackground(Color.white);
    jPanel1.setBounds(new Rectangle(391, 166, 365, 94));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel1.setBorder(BorderFactory.createTitledBorder(" ETD Date "));
    jPanel2.setBounds(new Rectangle(391, 261, 365, 94));
    jPanel2.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" DEL-DD "));
    txtETDFm_D.setBounds(new Rectangle(176, 26, 37, 20));
    txtETDTo_D.setBounds(new Rectangle(176, 52, 37, 20));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel14.setForeground(new Color(10,36,106));
    jLabel14.setText("/");
    jLabel14.setBounds(new Rectangle(118, 52, 15, 25));
    txtETDTo_Y.setBounds(new Rectangle(61, 52, 54, 20));
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel16.setForeground(new Color(10,36,106));
    jLabel16.setText("/");
    jLabel16.setBounds(new Rectangle(167, 52, 15, 25));
    txtETDFm_Y.setBounds(new Rectangle(61, 26, 54, 20));
    txtETDTo_M.setBounds(new Rectangle(127, 52, 37, 20));
    jLabel20.setBounds(new Rectangle(118, 26, 15, 25));
    jLabel20.setText("/");
    jLabel20.setForeground(new Color(10,36,106));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel18.setForeground(new Color(10,36,106));
    jLabel18.setText("From :");
    jLabel18.setBounds(new Rectangle(20, 26, 45, 21));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setText("/");
    jLabel17.setBounds(new Rectangle(167, 26, 15, 25));
    txtETDFm_M.setBounds(new Rectangle(127, 26, 37, 20));
    jLabel15.setBounds(new Rectangle(20, 52, 36, 21));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setText("To :");
    jLabel8.setBounds(new Rectangle(119, 55, 15, 25));
    jLabel8.setText("/");
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel4.setText("To :");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel4.setBounds(new Rectangle(21, 54, 36, 21));
    jLabel12.setBounds(new Rectangle(168, 55, 15, 25));
    jLabel12.setText("/");
    jLabel12.setForeground(new Color(10,36,106));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 16));
    txtDelFm_Y.setBounds(new Rectangle(62, 28, 54, 20));
    jLabel6.setBounds(new Rectangle(21, 28, 45, 21));
    jLabel6.setText("From :");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setForeground(new Color(10,36,106));
    jLabel11.setBounds(new Rectangle(168, 28, 15, 25));
    jLabel11.setText("/");
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 16));
    txtDelTo_D.setBounds(new Rectangle(177, 55, 37, 20));
    txtDelTo_Y.setBounds(new Rectangle(62, 55, 54, 20));
    txtDelTo_M.setBounds(new Rectangle(128, 55, 37, 20));
    txtDelFm_M.setBounds(new Rectangle(128, 28, 37, 20));
    txtDelFm_D.setBounds(new Rectangle(177, 28, 37, 20));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setText("/");
    jLabel5.setBounds(new Rectangle(119, 28, 15, 25));
    txtPO.setBounds(new Rectangle(548, 117, 209, 20));
    jLabel1111.setBackground(new Color(143, 143, 188));
    jLabel1111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1111.setForeground(new Color(10,36,106));
    jLabel1111.setOpaque(true);
    jLabel1111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1111.setText(" PO :");
    jLabel1111.setBounds(new Rectangle(391, 117, 155, 20));
    jLabel1113.setBounds(new Rectangle(13, 381, 155, 20));
    jLabel1113.setText(" Print BLNC QTY > 0 :");
    jLabel1113.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1113.setOpaque(true);
    jLabel1113.setForeground(new Color(10,36,106));
    jLabel1113.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1113.setBackground(new Color(143, 143, 188));
    chkBx_Yes.setBackground(Color.white);
    chkBx_Yes.setFont(new java.awt.Font("Dialog", 1, 12));
    chkBx_Yes.setForeground(Color.darkGray);
    chkBx_Yes.setText(" Yes");
    chkBx_Yes.setBounds(new Rectangle(170, 381, 209, 20));
    chkBx_Yes.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        chkBx_Yes_itemStateChanged(e);
      }
    });
    CmbShipMethod.setBounds(new Rectangle(548, 90, 209, 20));
    this.add(popMaker, null);
    this.add(jLabel110, null);
    this.add(jLabel9, null);
    this.add(jLabel19, null);
    this.add(jLabel7, null);
    this.add(chkBx_None, null);
    this.add(jLabel10, null);
    this.add(cmboCountry, null);
    this.add(cmboCen, null);
    this.add(cmboDiv, null);
    this.add(txtYear, null);
    this.add(jLabel1, null);
    this.add(cmboDep, null);
    this.add(cmboSea, null);
    this.add(txtRng, null);
    this.add(jLabel1112, null);
    this.add(jLabel120, null);
    this.add(jLabel22, null);
    this.add(jLabel1110, null);
    this.add(do_PrintUnShip, null);
    this.add(do_ShipInfo, null);
    jPanel1.add(txtETDFm_D, null);
    jPanel1.add(txtETDTo_D, null);
    jPanel1.add(jLabel14, null);
    jPanel1.add(txtETDTo_Y, null);
    jPanel1.add(jLabel16, null);
    jPanel1.add(txtETDFm_Y, null);
    jPanel1.add(txtETDTo_M, null);
    jPanel1.add(jLabel20, null);
    jPanel1.add(jLabel18, null);
    jPanel1.add(jLabel17, null);
    jPanel1.add(txtETDFm_M, null);
    jPanel1.add(jLabel15, null);
    this.add(jPanel2, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(jLabel12, null);
    jPanel2.add(txtDelFm_Y, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(txtDelTo_D, null);
    jPanel2.add(txtDelTo_Y, null);
    jPanel2.add(txtDelTo_M, null);
    jPanel2.add(txtDelFm_M, null);
    jPanel2.add(txtDelFm_D, null);
    jPanel2.add(jLabel5, null);
    this.add(jLabel13, null);
    this.add(jScrollPane1, null);
    this.add(jLabel1113, null);
    this.add(chkBx_Yes, null);
    jScrollPane1.getViewport().add(listQTA, null);
    this.add(jPanel1, null);
    this.add(jLabel1111, null);
    this.add(txtPO, null);
    this.add(CmbShipMethod, null);
    this.setCmboData();
    CmbShipMethod.setBackground(Color.white);
    CmbShipMethod.addItem("");
    CmbShipMethod.addItem("Boat");
    CmbShipMethod.addItem("Air");
    CmbShipMethod.addItem("West-Coast");
    CmbShipMethod.setSelectedIndex(0);
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;
    java.util.Vector vDataCnty = null;

    try {
      listQTA.setListData(exgui2.Stuff.QUOTA_AREA);
      listQTA.setSelectedIndex(0);
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

  void chkBx_None_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      listQTA.setEnabled(false);
      listQTA.setBackground(Color.lightGray);
      this.isChk_None = true;
    } else {
      listQTA.setEnabled(true);
      listQTA.setBackground(Color.white);
      this.isChk_None = false;
    }
  }

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear, null, "", 4);
    tx = new exgui.DataBindText(txtETDFm_Y, null, "", 4);
    tx = new exgui.DataBindText(txtETDFm_M, null, "", 2);
    tx = new exgui.DataBindText(txtETDFm_D, null, "", 2);
    tx = new exgui.DataBindText(txtETDTo_Y, null, "", 4);
    tx = new exgui.DataBindText(txtETDTo_M, null, "", 2);
    tx = new exgui.DataBindText(txtETDTo_D, null, "", 2);
    tx = new exgui.DataBindText(txtDelFm_Y, null, "", 4);
    tx = new exgui.DataBindText(txtDelFm_M, null, "", 2);
    tx = new exgui.DataBindText(txtDelFm_D, null, "", 2);
    tx = new exgui.DataBindText(txtDelTo_Y, null, "", 4);
    tx = new exgui.DataBindText(txtDelTo_M, null, "", 2);
    tx = new exgui.DataBindText(txtDelTo_D, null, "", 2);
  }

  void chkBx_Yes_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      this.isChk_Yes = true;
      this.do_PrintUnShip.setEnabled(false);
    } else {
      this.isChk_Yes = false;
      this.do_PrintUnShip.setEnabled(true);
    }
  }
}
