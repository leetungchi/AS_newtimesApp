package newtimes.reports.report_2.salesprofit;

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

public class SalesProfitGUI extends JPanel {
  JLabel jLabel110 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel1112 = new JLabel();
  JComboBox cmboMag = new JComboBox();
  GetBuyerMaker dlgBuyer = new GetBuyerMaker(1);
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  PopAndSelect2Text popBuyer = new PopAndSelect2Text(dlgBuyer, "BYMKR_SEQ", "BYMKR_BRIEF");
  JLabel jLabel19 = new JLabel();
  JLabel jLabel112 = new JLabel();
  JLabel jLabel1110 = new JLabel();
  JRadioButton rb_BC = new JRadioButton();
  JRadioButton rb_DC = new JRadioButton();
  JRadioButton rb_C = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JScrollPane jScrollPane3 = new JScrollPane();
  JList listDep = new JList();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JTextField txtM_TO_Y = new JTextField();
  JTextField txtM_FM_M = new JTextField();
  JLabel jLabel113 = new JLabel();
  JTextField txtY2M_FM_Y = new JTextField();
  JPanel jPanel2 = new JPanel();
  JTextField txtY2M_TO_Y = new JTextField();
  JTextField txtY2M_TO_M = new JTextField();
  JLabel jLabel18 = new JLabel();
  JPanel jPanel1 = new JPanel();
  JTextField txtM_FM_Y = new JTextField();
  JLabel jLabel22 = new JLabel();
  JTextField txtM_TO_M = new JTextField();
  JTextField txtY2M_FM_M = new JTextField();
  JLabel jLabel116 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaMemo = new JTextArea();
  exgui.DataBindJList dbJListDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXMag = null;
  String usrType = null;
  String usrCenCodeDf = null;
  boolean _isCenSelected = false;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel5 = new JLabel();

  public SalesProfitGUI() {
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
    cmboCen.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(172, 18, 209, 20));
    jLabel110.setBounds(new Rectangle(15, 18, 155, 20));
    jLabel110.setText(" * Center :");
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setOpaque(true);
    jLabel110.setForeground(Color.white);
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(new Dimension(800, 600));
    this.setBackground(new Color(204, 204, 225));
    this.setMaximumSize(new Dimension(32767, 32767));
    jPanel4.setBorder(BorderFactory.createTitledBorder(" * Department "));
    jPanel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setBounds(new Rectangle(15, 46, 368, 156));
    jPanel4.setLayout(null);
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setForeground(Color.white);
    jLabel1112.setOpaque(true);
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setText(" Manager :");
    jLabel1112.setBounds(new Rectangle(15, 214, 155, 20));
    cmboMag.setBounds(new Rectangle(172, 214, 209, 20));
    cmboMag.setBackground(Color.white);
    popMaker.setBounds(new Rectangle(172, 281, 209, 20));
    jLabel19.setBounds(new Rectangle(39, 178, 141, 20));
    jLabel19.setText(" FTY :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(Color.white);
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setBounds(new Rectangle(15, 281, 155, 20));
    popBuyer.setBounds(new Rectangle(172, 248, 209, 20));
    jLabel112.setBackground(new Color(143, 143, 188));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setOpaque(true);
    jLabel112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel112.setText(" Buyer :");
    jLabel112.setBounds(new Rectangle(417, 178, 141, 20));
    jLabel112.setBounds(new Rectangle(15, 248, 155, 20));
    jLabel1110.setBounds(new Rectangle(20, 251, 155, 20));
    jLabel1110.setText(" Group by :");
    jLabel1110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1110.setOpaque(true);
    jLabel1110.setForeground(new Color(10,36,106));
    jLabel1110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1110.setBackground(new Color(143, 143, 188));
    jLabel1110.setBounds(new Rectangle(14, 315, 155, 20));
    rb_BC.setBackground(Color.white);
    rb_BC.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_BC.setForeground(Color.darkGray);
    rb_BC.setAlignmentY((float) 0.5);
    rb_BC.setSelected(true);
    rb_BC.setText("(1) Buyer   (2) Country");
    rb_BC.setBounds(new Rectangle(172, 315, 168, 20));
    rb_DC.setBackground(Color.white);
    rb_DC.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_DC.setForeground(Color.darkGray);
    rb_DC.setText("(1) Department   (2) Country");
    rb_DC.setBounds(new Rectangle(339, 315, 195, 20));
    rb_C.setBackground(Color.white);
    rb_C.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_C.setForeground(Color.darkGray);
    rb_C.setText("Country");
    rb_C.setBounds(new Rectangle(534, 315, 238, 20));
    jScrollPane3.setBounds(new Rectangle(11, 21, 345, 123));
    jLabel4.setBounds(new Rectangle(48, 54, 36, 21));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("To :");
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel21.setForeground(new Color(10,36,106));
    jLabel21.setText("/");
    jLabel21.setBounds(new Rectangle(149, 55, 15, 25));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel20.setForeground(new Color(10,36,106));
    jLabel20.setText("/");
    jLabel20.setBounds(new Rectangle(149, 26, 15, 25));
    txtM_TO_Y.setEnabled(false);
    txtM_TO_Y.setEditable(false);
    txtM_TO_Y.setBounds(new Rectangle(92, 55, 54, 20));
    txtM_FM_M.setEnabled(false);
    txtM_FM_M.setEditable(false);
    txtM_FM_M.setBounds(new Rectangle(158, 28, 37, 20));
    jLabel113.setBounds(new Rectangle(149, 53, 15, 25));
    jLabel113.setText("/");
    jLabel113.setForeground(new Color(10,36,106));
    jLabel113.setFont(new java.awt.Font("Dialog", 1, 16));
    txtY2M_FM_Y.setBounds(new Rectangle(92, 26, 54, 20));
    txtY2M_FM_Y.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(FocusEvent e) {
        txtY2M_FM_Y_focusLost(e);
      }
    });
    jPanel2.setBorder(BorderFactory.createTitledBorder(" * This-Month "));
    jPanel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setLayout(null);
    jPanel2.setBounds(new Rectangle(409, 108, 365, 94));
    txtY2M_TO_Y.setBounds(new Rectangle(92, 53, 54, 20));
    txtY2M_TO_Y.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(FocusEvent e) {
        txtY2M_TO_Y_focusLost(e);
      }
    });
    txtY2M_TO_M.setBounds(new Rectangle(158, 53, 37, 20));
    txtY2M_TO_M.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(FocusEvent e) {
        txtY2M_TO_M_focusLost(e);
      }
    });
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel18.setForeground(new Color(10,36,106));
    jLabel18.setText("OBD From :");
    jLabel18.setBounds(new Rectangle(20, 26, 78, 21));
    jPanel1.setBounds(new Rectangle(409, 10, 365, 94));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel1.setBorder(BorderFactory.createTitledBorder(" * Year-to-Month "));
    txtM_FM_Y.setEnabled(false);
    txtM_FM_Y.setEditable(false);
    txtM_FM_Y.setBounds(new Rectangle(92, 28, 54, 20));
    jLabel22.setBounds(new Rectangle(21, 28, 63, 21));
    jLabel22.setText("OBD From :");
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setForeground(new Color(10,36,106));
    txtM_TO_M.setEnabled(false);
    txtM_TO_M.setEditable(false);
    txtM_TO_M.setBounds(new Rectangle(158, 55, 37, 20));
    txtY2M_FM_M.setBounds(new Rectangle(158, 26, 37, 20));
    txtY2M_FM_M.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(FocusEvent e) {
        txtY2M_FM_M_focusLost(e);
      }
    });
    jLabel116.setBounds(new Rectangle(48, 53, 36, 21));
    jLabel116.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel116.setForeground(new Color(10,36,106));
    jLabel116.setText("To :");
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel23.setForeground(new Color(10,36,106));
    jLabel23.setText("/");
    jLabel23.setBounds(new Rectangle(149, 28, 15, 25));
    jPanel3.setBounds(new Rectangle(409, 207, 365, 94));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Memo "));
    jScrollPane1.setBounds(new Rectangle(13, 25, 338, 56));
    txtAreaMemo.setLineWrap(true);
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setText("(YYYY/MM)");
    jLabel1.setBounds(new Rectangle(200, 26, 72, 20));
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setText("(YYYY/MM)");
    jLabel2.setBounds(new Rectangle(199, 55, 65, 19));
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setText("(YYYY/MM)");
    jLabel3.setBounds(new Rectangle(200, 28, 71, 19));
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setText("(YYYY/MM)");
    jLabel5.setBounds(new Rectangle(200, 56, 62, 20));
    jPanel2.add(jLabel21, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(jLabel22, null);
    jPanel2.add(txtM_TO_Y, null);
    jPanel2.add(txtM_TO_M, null);
    jPanel2.add(jLabel23, null);
    jPanel2.add(txtM_FM_M, null);
    jPanel2.add(txtM_FM_Y, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jLabel3, null);
    this.add(jPanel1, null);
    this.add(rb_C, null);
    this.add(jLabel1110, null);
    this.add(rb_BC, null);
    this.add(rb_DC, null);
    jPanel1.add(jLabel18, null);
    jPanel1.add(txtY2M_FM_Y, null);
    jPanel1.add(jLabel20, null);
    jPanel1.add(txtY2M_FM_M, null);
    jPanel1.add(txtY2M_TO_Y, null);
    jPanel1.add(jLabel113, null);
    jPanel1.add(txtY2M_TO_M, null);
    jPanel1.add(jLabel116, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jLabel2, null);
    this.add(jPanel3, null);
    jPanel3.add(jScrollPane1, null);
    this.add(jLabel110, null);
    this.add(cmboCen, null);
    this.add(jLabel19, null);
    this.add(popMaker, null);
    this.add(jLabel112, null);
    this.add(popBuyer, null);
    this.add(jLabel1112, null);
    this.add(cmboMag, null);
    this.add(jPanel4, null);
    jPanel4.add(jScrollPane3, null);
    jScrollPane3.getViewport().add(listDep, null);
    jScrollPane1.getViewport().add(txtAreaMemo, null);
    this.add(jPanel2, null);
    buttonGroup1.add(rb_BC);
    buttonGroup1.add(rb_DC);
    buttonGroup1.add(rb_C);
    this.setCmboData();
  }

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtAreaMemo,null,"",18);
    tx = new exgui.DataBindText(txtY2M_FM_Y,null,"",4);
    tx = new exgui.DataBindText(txtY2M_FM_M,null,"",2);
    tx = new exgui.DataBindText(txtY2M_TO_Y,null,"",4);
    tx = new exgui.DataBindText(txtY2M_TO_M,null,"",2);
    tx = new exgui.DataBindText(txtM_FM_Y,null,"",4);
    tx = new exgui.DataBindText(txtM_FM_M,null,"",2);
    tx = new exgui.DataBindText(txtM_TO_Y,null,"",4);
    tx = new exgui.DataBindText(txtM_TO_M,null,"",2);
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataDep = null;
    java.util.Vector vDataMag = null;

    try {
      vDataCen = CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(
          cmboCen, vDataCen, "CEN_NAME", "CEN_CODE", recCen.get("CEN_CODE"),"","null");

      vDataMag = exgui2.CONST.BASIC_BASE_EJB.getManagerAll("MNG_CODE,MNG_ABBR","MNG_ABBR");
      database.datatype.Record recMag = (database.datatype.Record) vDataMag.get(0);
      dbJCBXMag = new exgui.DataBindJCombobox(cmboMag, vDataMag, "MNG_ABBR",
                                    "MNG_CODE", recMag.get("MNG_CODE"),"","null");
      cmboMag.setSelectedIndex(0);

      if (usrType.equals("2") || usrType.equals("7")) {
        this._isCenSelected = true;
        vDataDep = CONST.BASIC_BASE_EJB.getDepartmentAll("DEP_CODE,DEP_NAME", "DEP_NAME");
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJListDep = new exgui.DataBindJList(listDep, vDataDep, "DEP_NAME",
                                             "DEP_CODE", recDep.get("DEP_CODE"));
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
        dbJListDep = new exgui.DataBindJList(listDep, vDataDep, "DEP_NAME",
                                             "DEP_CODE", recDep.get("DEP_CODE"));
      } else {
        listDep = new JList(vDataDep);
        jScrollPane3.getViewport().add(listDep, null);
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

  void txtY2M_TO_Y_focusLost(FocusEvent e) {
    txtM_TO_Y.setText(txtY2M_TO_Y.getText());
  }

  void txtY2M_TO_M_focusLost(FocusEvent e) {
    txtM_TO_M.setText(txtY2M_TO_M.getText());
  }

  void txtY2M_FM_Y_focusLost(FocusEvent e) {
    txtM_FM_Y.setText(txtY2M_FM_Y.getText());
  }

  void txtY2M_FM_M_focusLost(FocusEvent e) {
    txtM_FM_M.setText(txtY2M_FM_M.getText());
  }
}
