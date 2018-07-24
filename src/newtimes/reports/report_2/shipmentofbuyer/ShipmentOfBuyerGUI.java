package newtimes.reports.report_2.shipmentofbuyer;

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

public class ShipmentOfBuyerGUI extends JPanel {
  GetBuyerMaker dlgBuyer = new GetBuyerMaker(1);
  PopAndSelect2Text popBuyer = new PopAndSelect2Text(dlgBuyer, "BYMKR_SEQ", "BYMKR_BRIEF");
  JPanel jPanel4 = new JPanel();
  JLabel jLabel110 = new JLabel();
  JLabel jLabel112 = new JLabel();
  JList listDep = new JList();
  JComboBox cmboCen = new JComboBox();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel10 = new JLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTextArea txtAreaMemo = new JTextArea();
  exgui.DataBindJList dbJListDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  String usrCenNameDf = null;
  String usrCenMod = null;
  String usrCenDF = null;
  String usrType = null;
  String usrCenCodeDf = null;
  boolean _isCenSelected = false;

  public ShipmentOfBuyerGUI() {
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      usrCenNameDf = util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString();
      usrCenMod = util.PublicVariable.USER_RECORD.get("USR_CEN_MOD").toString();
      usrCenDF =  util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    popBuyer.setBounds(new Rectangle(373, 272, 209, 20));
    this.setLayout(null);
    this.setSize(new Dimension(800, 600));
    this.setBackground(new Color(204, 204, 225));
    jPanel4.setBorder(BorderFactory.createTitledBorder(" * Department "));
    jPanel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setBounds(new Rectangle(216, 70, 368, 156));
    jPanel4.setLayout(null);
    jLabel110.setBounds(new Rectangle(216, 42, 155, 20));
    jLabel110.setText(" * Center :");
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setOpaque(true);
    jLabel110.setForeground(Color.white);
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel112.setBackground(new Color(143, 143, 188));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setOpaque(true);
    jLabel112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel112.setText(" Buyer :");
    jLabel112.setBounds(new Rectangle(417, 178, 141, 20));
    jLabel112.setBounds(new Rectangle(216, 272, 155, 20));
    cmboCen.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(373, 42, 209, 20));
    jPanel3.setBounds(new Rectangle(216, 303, 365, 94));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Memo "));
    jLabel1.setForeground(new Color(143, 143, 188));
    jLabel1.setText("( Year )");
    jLabel1.setBounds(new Rectangle(478, 238, 77, 20));
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    txtYear.setBounds(new Rectangle(373, 238, 98, 20));
    jLabel10.setBounds(new Rectangle(216, 238, 155, 20));
    jLabel10.setText(" Year :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(Color.white);
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jScrollPane2.setBounds(new Rectangle(11, 21, 345, 123));
    jScrollPane3.setBounds(new Rectangle(12, 26, 338, 56));
    txtAreaMemo.setText("");
    txtAreaMemo.setLineWrap(true);
    this.add(jLabel110, null);
    this.add(cmboCen, null);
    this.add(jLabel10, null);
    this.add(txtYear, null);
    this.add(jLabel1, null);
    this.add(jLabel112, null);
    this.add(popBuyer, null);
    this.add(jPanel4, null);
    this.add(jPanel3, null);
    jPanel4.add(jScrollPane2,null);
    jPanel3.add(jScrollPane3,null);
    jScrollPane2.getViewport().add(listDep, null);
    jScrollPane3.getViewport().add(txtAreaMemo, null);
    if (this.usrCenMod.equalsIgnoreCase("Y")) {
      this.cmboCen.setEnabled(true);
    } else {
      this.cmboCen.setEnabled(false);
    }
    this.setCmboData();
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;

    try {
      vDataCen = CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(
          cmboCen, vDataCen, "CEN_NAME", "CEN_CODE", recCen.get("CEN_CODE"));
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
      util.ExceptionLog.exp2File(eDep, "error at Department JComboBox.");
    }
  }

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtAreaMemo,null,"",40);
    tx = new exgui.DataBindText(txtYear,null,"",4);
  }

  void setDepItem(String whereClause) {
    java.util.Vector vDataDep = null;
    try {
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (vDataDep.size() > 0) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJListDep = new exgui.DataBindJList(
            listDep, vDataDep, "DEP_NAME", "DEP_CODE", recDep.get("DEP_CODE"));
      } else {
        listDep.setListData(vDataDep);
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
      } else {
        listDep.setListData(new Object[0]);
      }
    } catch (Exception eItem) {
      eItem.printStackTrace();
      util.ExceptionLog.exp2File(eItem, "error at change department item.");
    }
  }
}
