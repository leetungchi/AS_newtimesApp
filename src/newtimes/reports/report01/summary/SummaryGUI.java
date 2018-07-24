package newtimes.reports.report01.summary;

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

public class SummaryGUI extends JPanel {
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JRadioButton r_Plan = new JRadioButton();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JTextField txtFm_D = new JTextField();
  JRadioButton r_Ship = new JRadioButton();
  JLabel jLabel14 = new JLabel();
  JTextField txtFm_Y = new JTextField();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JTextField txtYear = new JTextField();
  JLabel jLabel9 = new JLabel();
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  JLabel jLabel111 = new JLabel();
  JComboBox cmboDep = new JComboBox();
  JLabel jLabel19 = new JLabel();
  JTextField txtTo_D = new JTextField();
  JTextField txtTo_Y = new JTextField();
  JLabel jLabel16 = new JLabel();
  JComboBox cmboSea = new JComboBox();
  JComboBox cmboDiv = new JComboBox();
  JLabel jLabel11 = new JLabel();
  JTextField txtTo_M = new JTextField();
  JComboBox cmboCntry = new JComboBox();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JRadioButton r_Order = new JRadioButton();
  JLabel jLabel17 = new JLabel();
  JComboBox cmboQTA = new JComboBox();
  JPanel jPanel7 = new JPanel();
  JComboBox cmboCen = new JComboBox();
  JCheckBox chkBxAMT = new JCheckBox();
  JLabel jLabel110 = new JLabel();
  JCheckBox chkBxQTY = new JCheckBox();
  JTextField txtFm_M = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JRadioButton rRow_QTA = new JRadioButton();
  JRadioButton rRow_DIV = new JRadioButton();
  JRadioButton rRow_FTY = new JRadioButton();
  JRadioButton rRow_SEA = new JRadioButton();
  JRadioButton rRow_Year = new JRadioButton();
  JRadioButton rRow_Date = new JRadioButton();
  JRadioButton rRow_Cntry = new JRadioButton();
  JRadioButton rCol_Date = new JRadioButton();
  JRadioButton rCol_QTA = new JRadioButton();
  JRadioButton rCol_SEA = new JRadioButton();
  JRadioButton rCol_Year = new JRadioButton();
  JRadioButton rCol_FTY = new JRadioButton();
  JRadioButton rCol_DIV = new JRadioButton();
  JRadioButton rCol_Cntry = new JRadioButton();
  JRadioButton r_QTA = new JRadioButton();
  JRadioButton r_Sel_QTA = new JRadioButton();
  JRadioButton r_DIV = new JRadioButton();
  JRadioButton r_Sel_DIV = new JRadioButton();
  JRadioButton r_FTY = new JRadioButton();
  JRadioButton r_Sel_FTY = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  ButtonGroup buttonGroup3 = new ButtonGroup();
  ButtonGroup buttonGroup4 = new ButtonGroup();
  JButton butnQTA = new JButton();
  JButton butnDIV = new JButton();
  JButton butnFTY = new JButton();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXCnty = null;
  exgui.DataBindJCombobox dbJCBXQTA = null;
  String usrCenNameDf = null;
  String usrDepNameDf = null;
  String usrCenMod = null;
  String usrDepMod = null;
  String usrPrintAMT = null;
  String usrCenDF = null;
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaQTA = new JTextArea();
  JScrollPane jScrollPane2 = new JScrollPane();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTextArea txtAreaDIV = new JTextArea();
  JTextArea txtAreaFTY = new JTextArea();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  ButtonGroup buttonGroup5 = new ButtonGroup();
  ButtonGroup buttonGroup6 = new ButtonGroup();

  public SummaryGUI() {
    try {
      usrCenDF =  util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      usrCenNameDf = util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString();
      usrDepNameDf = util.PublicVariable.USER_RECORD.get("DEP_NAME_DF").toString();
      usrCenMod = util.PublicVariable.USER_RECORD.get("USR_CEN_MOD").toString();
      usrDepMod = util.PublicVariable.USER_RECORD.get("USR_DEP_MOD").toString();
      usrPrintAMT = util.PublicVariable.USER_RECORD.get("USR_PRINT_AMT").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jPanel1.setLayout(null);
    this.setLayout(gridBagLayout1);
    this.setSize(new Dimension(773, 781));
    this.setBackground(new Color(204, 204, 225));
    jLabel8.setBackground(new Color(143, 143, 188));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setForeground(Color.white);
    jLabel8.setOpaque(true);
    jLabel8.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel8.setText(" Country :");
    jLabel8.setBounds(new Rectangle(15, 163, 136, 20));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setForeground(new Color(10,36,106));
    jLabel21.setOpaque(true);
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setText(" Year :");
    jLabel21.setBounds(new Rectangle(15, 248, 136, 20));
    jPanel4.setBorder(BorderFactory.createTitledBorder(" Content "));
    jPanel4.setBounds(new Rectangle(396, 148, 358, 93));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setLayout(null);
    r_Plan.setBackground(new Color(204, 204, 225));
    r_Plan.setFont(new java.awt.Font("Dialog", 0, 12));
    r_Plan.setSelected(true);
    r_Plan.setText("Plan");
    r_Plan.setBounds(new Rectangle(12, 24, 115, 26));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel20.setForeground(new Color(10,36,106));
    jLabel20.setText("/");
    jLabel20.setBounds(new Rectangle(255, 107, 15, 25));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(new Color(143, 143, 188));
    jLabel1.setText("( Year )");
    jLabel1.setBounds(new Rectangle(256, 248, 77, 20));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Report Type "));
    jPanel3.setBounds(new Rectangle(396, 8, 358, 129));
    txtFm_D.setBounds(new Rectangle(313, 107, 37, 20));
    r_Ship.setBackground(new Color(204, 204, 225));
    r_Ship.setFont(new java.awt.Font("Dialog", 0, 12));
    r_Ship.setText("Ship");
    r_Ship.setBounds(new Rectangle(12, 89, 115, 26));
    jLabel14.setBounds(new Rectangle(255, 132, 15, 25));
    jLabel14.setText("/");
    jLabel14.setForeground(new Color(10,36,106));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 16));
    txtFm_Y.setBounds(new Rectangle(198, 107, 54, 20));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Condition "));
    jPanel2.setBounds(new Rectangle(12, 8, 378, 310));
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setLayout(null);
    jPanel5.setBorder(BorderFactory.createTitledBorder(" Row ( Y ) "));
    jPanel5.setBounds(new Rectangle(12, 327, 144, 446));
    jPanel5.setBackground(new Color(204, 204, 225));
    jPanel5.setLayout(null);
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    txtYear.setBounds(new Rectangle(153, 248, 98, 20));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" Department :");
    jLabel9.setBounds(new Rectangle(15, 52, 136, 20));
    popMaker.setBounds(new Rectangle(153, 192, 209, 20));
    jLabel111.setText("To :");
    jLabel111.setForeground(new Color(10,36,106));
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel111.setBounds(new Rectangle(157, 132, 36, 21));
    cmboDep.setBounds(new Rectangle(153, 52, 209, 20));
    cmboDep.setBackground(Color.white);
    jLabel19.setBounds(new Rectangle(15, 192, 136, 20));
    jLabel19.setText(" FTY :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setBackground(new Color(143, 143, 188));
    txtTo_D.setBounds(new Rectangle(313, 132, 37, 20));
    txtTo_Y.setBounds(new Rectangle(198, 132, 54, 20));
    jLabel16.setBounds(new Rectangle(304, 132, 15, 25));
    jLabel16.setText("/");
    jLabel16.setForeground(new Color(10,36,106));
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 16));
    cmboSea.setBounds(new Rectangle(153, 80, 209, 20));
    cmboSea.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(153, 220, 209, 20));
    cmboDiv.setBackground(Color.white);
    jLabel11.setBackground(new Color(143, 143, 188));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setForeground(Color.white);
    jLabel11.setOpaque(true);
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setText(" Quota :");
    jLabel11.setBounds(new Rectangle(15, 275, 136, 20));
    txtTo_M.setBounds(new Rectangle(264, 132, 37, 20));
    cmboCntry.setBounds(new Rectangle(153, 163, 209, 20));
    cmboCntry.setBackground(Color.white);
    jLabel18.setBounds(new Rectangle(157, 107, 45, 21));
    jLabel18.setText("From :");
    jLabel18.setForeground(new Color(10,36,106));
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBounds(new Rectangle(15, 80, 136, 20));
    jLabel7.setText(" Season :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(Color.white);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    r_Order.setBackground(new Color(204, 204, 225));
    r_Order.setFont(new java.awt.Font("Dialog", 0, 12));
    r_Order.setText("Order");
    r_Order.setBounds(new Rectangle(12, 56, 115, 26));
    jLabel17.setBounds(new Rectangle(304, 107, 15, 25));
    jLabel17.setText("/");
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 16));
    cmboQTA.setBounds(new Rectangle(153, 275, 209, 20));
    cmboQTA.setBackground(Color.white);
    jPanel7.setBorder(BorderFactory.createTitledBorder(" Column ( X ) "));
    jPanel7.setBounds(new Rectangle(163, 327, 591, 446));
    jPanel7.setBackground(new Color(204, 204, 225));
    jPanel7.setLayout(null);
    cmboCen.setBounds(new Rectangle(153, 24, 209, 20));
    cmboCen.setBackground(Color.white);
    chkBxAMT.setBackground(new Color(204, 204, 225));
    chkBxAMT.setFont(new java.awt.Font("Dialog", 0, 12));
    chkBxAMT.setText("AMT");
    chkBxAMT.setBounds(new Rectangle(12, 54, 86, 23));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(new Color(10,36,106));
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Date :");
    jLabel110.setBounds(new Rectangle(15, 107, 136, 20));
    chkBxQTY.setBackground(new Color(204, 204, 225));
    chkBxQTY.setFont(new java.awt.Font("Dialog", 0, 12));
    chkBxQTY.setSelected(true);
    chkBxQTY.setText("QTY");
    chkBxQTY.setBounds(new Rectangle(12, 25, 86, 23));
    txtFm_M.setBounds(new Rectangle(264, 107, 37, 20));
    jLabel15.setBounds(new Rectangle(15, 24, 136, 20));
    jLabel15.setText(" Center :");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(Color.white);
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Division :");
    jLabel10.setBounds(new Rectangle(15, 220, 136, 20));
    jPanel1.setBackground(new Color(204, 204, 225));
    rRow_QTA.setBackground(new Color(204, 204, 225));
    rRow_QTA.setFont(new java.awt.Font("Dialog", 0, 12));
    rRow_QTA.setActionCommand("QUOTA");
    rRow_QTA.setContentAreaFilled(true);
    rRow_QTA.setSelected(true);
    rRow_QTA.setText("QTA");
    rRow_QTA.setBounds(new Rectangle(12, 24, 106, 20));
    rRow_DIV.setBackground(new Color(204, 204, 225));
    rRow_DIV.setFont(new java.awt.Font("Dialog", 0, 12));
    rRow_DIV.setActionCommand("PROD_BUYER_DIVISION");
    rRow_DIV.setSelected(false);
    rRow_DIV.setText("DIV");
    rRow_DIV.setBounds(new Rectangle(12, 56, 106, 20));
    rRow_FTY.setBackground(new Color(204, 204, 225));
    rRow_FTY.setFont(new java.awt.Font("Dialog", 0, 12));
    rRow_FTY.setText("FTY");
    rRow_FTY.setBounds(new Rectangle(12, 88, 106, 20));
    rRow_SEA.setBackground(new Color(204, 204, 225));
    rRow_SEA.setFont(new java.awt.Font("Dialog", 0, 12));
    rRow_SEA.setActionCommand("PROD_SEASON");
    rRow_SEA.setText("SEASON");
    rRow_SEA.setBounds(new Rectangle(12, 121, 106, 20));
    rRow_Year.setBackground(new Color(204, 204, 225));
    rRow_Year.setFont(new java.awt.Font("Dialog", 0, 12));
    rRow_Year.setActionCommand("PROD_YEAR");
    rRow_Year.setText("YEAR");
    rRow_Year.setBounds(new Rectangle(12, 153, 106, 20));
    rRow_Date.setBackground(new Color(204, 204, 225));
    rRow_Date.setFont(new java.awt.Font("Dialog", 0, 12));
    rRow_Date.setActionCommand("DEL_YYYYMM");
    rRow_Date.setText("DATE (YYYY/MM)");
    rRow_Date.setBounds(new Rectangle(12, 185, 122, 20));
    rRow_Cntry.setBackground(new Color(204, 204, 225));
    rRow_Cntry.setFont(new java.awt.Font("Dialog", 0, 12));
    rRow_Cntry.setActionCommand("PROD_CNTY_CODE");
    rRow_Cntry.setText("COUNTRY");
    rRow_Cntry.setBounds(new Rectangle(12, 217, 106, 20));
    rCol_Date.setBounds(new Rectangle(18, 389, 122, 20));
    rCol_Date.setText("DATE (YYYY/MM)");
    rCol_Date.setFont(new java.awt.Font("Dialog", 0, 12));
    rCol_Date.setActionCommand("DEL_YYYYMM");
    rCol_Date.setBackground(new Color(204, 204, 225));
    rCol_QTA.setBounds(new Rectangle(18, 24, 106, 20));
    rCol_QTA.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rCol_QTA_itemStateChanged(e);
      }
    });
    rCol_QTA.setText("QTA");
    rCol_QTA.setFont(new java.awt.Font("Dialog", 0, 12));
    rCol_QTA.setActionCommand("QUOTA");
    rCol_QTA.setSelected(true);
    rCol_QTA.setBackground(new Color(204, 204, 225));
    rCol_SEA.setBounds(new Rectangle(18, 344, 106, 20));
    rCol_SEA.setText("SEASON");
    rCol_SEA.setFont(new java.awt.Font("Dialog", 0, 12));
    rCol_SEA.setActionCommand("PROD_SEASON");
    rCol_SEA.setBackground(new Color(204, 204, 225));
    rCol_Year.setBounds(new Rectangle(18, 366, 106, 20));
    rCol_Year.setText("YEAR");
    rCol_Year.setFont(new java.awt.Font("Dialog", 0, 12));
    rCol_Year.setActionCommand("PROD_YEAR");
    rCol_Year.setBackground(new Color(204, 204, 225));
    rCol_FTY.setBounds(new Rectangle(18, 224, 106, 20));
    rCol_FTY.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rCol_FTY_itemStateChanged(e);
      }
    });
    rCol_FTY.setText("FTY");
    rCol_FTY.setFont(new java.awt.Font("Dialog", 0, 12));
    rCol_FTY.setBackground(new Color(204, 204, 225));
    rCol_DIV.setBounds(new Rectangle(18, 123, 106, 20));
    rCol_DIV.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rCol_DIV_itemStateChanged(e);
      }
    });
    rCol_DIV.setText("DIV");
    rCol_DIV.setFont(new java.awt.Font("Dialog", 0, 12));
    rCol_DIV.setActionCommand("PROD_BUYER_DIVISION");
    rCol_DIV.setBackground(new Color(204, 204, 225));
    rCol_Cntry.setBounds(new Rectangle(18, 411, 106, 20));
    rCol_Cntry.setText("COUNTRY");
    rCol_Cntry.setFont(new java.awt.Font("Dialog", 0, 12));
    rCol_Cntry.setActionCommand("PROD_CNTY_CODE");
    rCol_Cntry.setBackground(new Color(204, 204, 225));
    r_QTA.setBackground(new Color(204, 204, 225));
    r_QTA.setEnabled(true);
    r_QTA.setFont(new java.awt.Font("Dialog", 0, 12));
    r_QTA.setSelected(true);
    r_QTA.setText("The Preceding 12 QTA");
    r_QTA.setBounds(new Rectangle(149, 24, 231, 20));
    r_QTA.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        r_QTA_itemStateChanged(e);
      }
    });
    r_Sel_QTA.setBackground(new Color(204, 204, 225));
    r_Sel_QTA.setFont(new java.awt.Font("Dialog", 0, 12));
    r_Sel_QTA.setDoubleBuffered(false);
    r_Sel_QTA.setText("Select QTA");
    r_Sel_QTA.setBounds(new Rectangle(149, 44, 90, 20));
    r_Sel_QTA.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        r_Sel_QTA_itemStateChanged(e);
      }
    });
    r_DIV.setBackground(new Color(204, 204, 225));
    r_DIV.setEnabled(false);
    r_DIV.setFont(new java.awt.Font("Dialog", 0, 12));
    r_DIV.setSelected(true);
    r_DIV.setText("The Preceding 12 DIV");
    r_DIV.setBounds(new Rectangle(149, 123, 164, 20));
    r_DIV.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        r_DIV_itemStateChanged(e);
      }
    });
    r_Sel_DIV.setBackground(new Color(204, 204, 225));
    r_Sel_DIV.setEnabled(false);
    r_Sel_DIV.setFont(new java.awt.Font("Dialog", 0, 12));
    r_Sel_DIV.setText("Select DIV");
    r_Sel_DIV.setBounds(new Rectangle(149, 143, 89, 20));
    r_Sel_DIV.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        r_Sel_DIV_itemStateChanged(e);
      }
    });
    r_FTY.setBackground(new Color(204, 204, 225));
    r_FTY.setEnabled(false);
    r_FTY.setFont(new java.awt.Font("Dialog", 0, 12));
    r_FTY.setSelected(true);
    r_FTY.setText("The Preceding 12 FTY");
    r_FTY.setBounds(new Rectangle(149, 224, 164, 20));
    r_FTY.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        r_FTY_itemStateChanged(e);
      }
    });
    r_Sel_FTY.setBackground(new Color(204, 204, 225));
    r_Sel_FTY.setEnabled(false);
    r_Sel_FTY.setFont(new java.awt.Font("Dialog", 0, 12));
    r_Sel_FTY.setText("Select FTY");
    r_Sel_FTY.setBounds(new Rectangle(149, 244, 89, 20));
    r_Sel_FTY.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        r_Sel_FTY_itemStateChanged(e);
      }
    });
    butnQTA.setBounds(new Rectangle(553, 64, 24, 44));
    butnQTA.setEnabled(false);
    butnQTA.setFont(new java.awt.Font("Dialog", 1, 12));
    butnQTA.setText("...");
    butnDIV.setText("...");
    butnDIV.setFont(new java.awt.Font("Dialog", 1, 12));
    butnDIV.setDoubleBuffered(false);
    butnDIV.setBounds(new Rectangle(553, 163, 24, 44));
    butnDIV.setEnabled(false);
    butnFTY.setText("...");
    butnFTY.setFont(new java.awt.Font("Dialog", 1, 12));
    butnFTY.setBounds(new Rectangle(553, 270, 24, 44));
    butnFTY.setEnabled(false);
    jScrollPane1.setBounds(new Rectangle(171, 64, 380, 44));
    txtAreaQTA.setEnabled(false);
    txtAreaQTA.setEditable(false);
    txtAreaQTA.setText("");
    txtAreaQTA.setLineWrap(true);
    jScrollPane2.setBounds(new Rectangle(171, 163, 380, 44));
    jScrollPane3.setBounds(new Rectangle(171, 270, 380, 44));
    txtAreaDIV.setEnabled(false);
    txtAreaDIV.setEditable(false);
    txtAreaDIV.setText("");
    txtAreaDIV.setLineWrap(true);
    txtAreaFTY.setEnabled(false);
    txtAreaFTY.setEditable(false);
    txtAreaFTY.setLineWrap(true);
    this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 3, 9), 761, 775));
    jPanel4.add(chkBxAMT, null);
    jPanel4.add(chkBxQTY, null);
    jPanel1.add(jPanel3, null);
    jPanel1.add(jPanel5, null);
    jPanel5.add(rRow_QTA, null);
    jPanel5.add(rRow_DIV, null);
    jPanel5.add(rRow_FTY, null);
    jPanel5.add(rRow_SEA, null);
    jPanel5.add(rRow_Year, null);
    jPanel5.add(rRow_Date, null);
    jPanel1.add(jPanel7, null);
    jPanel7.add(rCol_QTA, null);
    jPanel7.add(r_QTA, null);
    jPanel1.add(jPanel2, null);
    jPanel3.add(r_Plan, null);
    jPanel3.add(r_Order, null);
    jPanel3.add(r_Ship, null);
    jPanel2.add(cmboSea, null);
    jPanel2.add(popMaker, null);
    jPanel2.add(jLabel19, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(jLabel110, null);
    jPanel2.add(jLabel15, null);
    jPanel2.add(cmboCen, null);
    jPanel2.add(jLabel17, null);
    jPanel2.add(jLabel20, null);
    jPanel2.add(txtFm_Y, null);
    jPanel2.add(txtFm_D, null);
    jPanel2.add(jLabel18, null);
    jPanel2.add(txtFm_M, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(cmboQTA, null);
    jPanel2.add(jLabel10, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(jLabel1, null);
    jPanel2.add(cmboDep, null);
    jPanel2.add(cmboCntry, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(jLabel21, null);
    jPanel2.add(cmboDiv, null);
    jPanel2.add(txtYear, null);
    jPanel2.add(txtTo_Y, null);
    jPanel2.add(jLabel111, null);
    jPanel2.add(jLabel14, null);
    jPanel2.add(txtTo_M, null);
    jPanel2.add(jLabel16, null);
    jPanel2.add(txtTo_D, null);
    jPanel1.add(jPanel4, null);
    buttonGroup2.add(r_QTA);
    buttonGroup2.add(r_Sel_QTA);
    buttonGroup3.add(r_DIV);
    buttonGroup3.add(r_Sel_DIV);
    buttonGroup4.add(r_FTY);
    buttonGroup4.add(r_Sel_FTY);
    jPanel7.add(r_Sel_QTA, null);
    jPanel7.add(butnQTA, null);
    jPanel7.add(jScrollPane1, null);
    jPanel7.add(rCol_Year, null);
    jPanel7.add(rCol_SEA, null);
    jPanel7.add(rCol_Date, null);
    jPanel7.add(rCol_Cntry, null);
    jPanel7.add(r_FTY, null);
    jPanel7.add(r_Sel_FTY, null);
    jPanel7.add(jScrollPane3, null);
    jPanel7.add(butnFTY, null);
    jPanel7.add(r_DIV, null);
    jPanel7.add(rCol_DIV, null);
    jPanel7.add(jScrollPane2, null);
    jPanel7.add(butnDIV, null);
    jPanel7.add(r_Sel_DIV, null);
    jPanel7.add(rCol_FTY, null);
    jScrollPane2.getViewport().add(txtAreaDIV, null);
    jScrollPane3.getViewport().add(txtAreaFTY, null);
    jScrollPane1.getViewport().add(txtAreaQTA, null);
    jPanel5.add(rRow_Cntry, null);
    buttonGroup1.add(r_Plan);
    buttonGroup1.add(r_Order);
    buttonGroup1.add(r_Ship);
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
    if (this.usrPrintAMT.equalsIgnoreCase("Y")) {
      chkBxAMT.setEnabled(true);
      chkBxAMT.setSelected(true);
    } else {
      chkBxAMT.setEnabled(false);
      chkBxAMT.setSelected(false);
    }
    this.setCmbo();
    buttonGroup5.add(rRow_QTA);
    buttonGroup5.add(rRow_DIV);
    buttonGroup5.add(rRow_FTY);
    buttonGroup5.add(rRow_SEA);
    buttonGroup5.add(rRow_Year);
    buttonGroup5.add(rRow_Date);
    buttonGroup5.add(rRow_Cntry);
    buttonGroup6.add(rCol_QTA);
    buttonGroup6.add(rCol_DIV);
    buttonGroup6.add(rCol_FTY);
    buttonGroup6.add(rCol_SEA);
    buttonGroup6.add(rCol_Year);
    buttonGroup6.add(rCol_Date);
    buttonGroup6.add(rCol_Cntry);
  }

  void setCmbo() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;
    java.util.Vector vDataDep = null;
    java.util.Vector vDataCnty = null;
    java.util.Vector vDataQTA = null;
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
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepByCenterCode(this.usrCenDF,"DEP_CODE,DEP_NAME");
      database.datatype.Record recDep = (database.datatype.Record) vDataDep.get(0);
      dbJCBXDep = new exgui.DataBindJCombobox(
          cmboDep, vDataDep, "DEP_NAME", "DEP_CODE", recDep.get("DEP_CODE"),"","null");
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(
          cmboCntry, vDataCnty, "CNTY_NAME","CNTY_NAME", rec.get("CNTY_NAME"),"","null");

      vDataQTA = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("(QTA_CAT || QTA_AREA) QTA_CAT","QTA_CAT");
      database.datatype.Record recQTA = (database.datatype.Record) vDataQTA.get(0);
      dbJCBXQTA = new exgui.DataBindJCombobox(cmboQTA, vDataQTA, "QTA_CAT",
                                        "QTA_CAT", recQTA.get("QTA_CAT"),"","null");

      cmboSea.setSelectedIndex(0);
      cmboDiv.setSelectedIndex(0);
      cmboCntry.setSelectedIndex(0);
      cmboQTA.setSelectedIndex(0);
      cmboCen.setSelectedItem(this.usrCenNameDf);
      cmboDep.setSelectedItem(this.usrDepNameDf);
    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at JComboBox.");
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear,null,"",4);
    tx = new exgui.DataBindText(txtFm_Y,null,"",4);
    tx = new exgui.DataBindText(txtFm_M,null,"",2);
    tx = new exgui.DataBindText(txtFm_D,null,"",2);
    tx = new exgui.DataBindText(txtTo_Y,null,"",4);
    tx = new exgui.DataBindText(txtTo_M,null,"",2);
    tx = new exgui.DataBindText(txtTo_D,null,"",2);
  }

  void rCol_QTA_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      r_QTA.setEnabled(true);
      r_Sel_QTA.setEnabled(true);
      if (r_Sel_QTA.isSelected()) {
        butnQTA.setEnabled(true);
        //txtAreaQTA.setEditable(true);
        txtAreaQTA.setEnabled(true);
      }
    } else {
      r_QTA.setEnabled(false);
      r_Sel_QTA.setEnabled(false);
      butnQTA.setEnabled(false);
      //txtAreaQTA.setEditable(false);
      txtAreaQTA.setEnabled(false);
    }
  }

  void rCol_DIV_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      r_DIV.setEnabled(true);
      r_Sel_DIV.setEnabled(true);
      if (r_Sel_DIV.isSelected()) {
        butnDIV.setEnabled(true);
        //txtAreaDIV.setEditable(true);
        txtAreaDIV.setEnabled(true);
      }
    } else {
      r_DIV.setEnabled(false);
      r_Sel_DIV.setEnabled(false);
      butnDIV.setEnabled(false);
      //txtAreaDIV.setEditable(false);
      txtAreaDIV.setEnabled(false);
    }
  }

  void rCol_FTY_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      r_FTY.setEnabled(true);
      r_Sel_FTY.setEnabled(true);
      if (r_Sel_FTY.isSelected()) {
        butnFTY.setEnabled(false);
        //txtAreaFTY.setEditable(true);
        txtAreaFTY.setEnabled(true);
      }
    } else {
      r_FTY.setEnabled(false);
      r_Sel_FTY.setEnabled(false);
      butnFTY.setEnabled(false);
      //txtAreaFTY.setEditable(false);
      txtAreaFTY.setEnabled(false);
    }
  }

  void r_QTA_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      //txtAreaQTA.setEditable(false);
      txtAreaQTA.setEnabled(false);
      butnQTA.setEnabled(false);
    } else {
      //txtAreaQTA.setEditable(true);
      txtAreaQTA.setEnabled(true);
      butnQTA.setEnabled(true);
    }
  }

  void r_Sel_QTA_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      //txtAreaQTA.setEditable(true);
      txtAreaQTA.setEnabled(true);
      butnQTA.setEnabled(true);
    } else {
      //txtAreaQTA.setEditable(false);
      txtAreaQTA.setEnabled(false);
      butnQTA.setEnabled(false);
    }
  }

  void r_DIV_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      //txtAreaDIV.setEditable(false);
      txtAreaDIV.setEnabled(false);
      butnDIV.setEnabled(false);
    } else {
      //txtAreaDIV.setEditable(true);
      txtAreaDIV.setEnabled(true);
      butnDIV.setEnabled(true);
    }
  }

  void r_Sel_DIV_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      //txtAreaDIV.setEditable(true);
      txtAreaDIV.setEnabled(true);
      butnDIV.setEnabled(true);
    } else {
      //txtAreaDIV.setEditable(false);
      txtAreaDIV.setEnabled(false);
      butnDIV.setEnabled(false);
    }
  }

  void r_FTY_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      //txtAreaFTY.setEditable(false);
      txtAreaFTY.setEnabled(false);
      butnFTY.setEnabled(false);
    } else {
      txtAreaFTY.setEnabled(true);
      //txtAreaFTY.setEditable(true);
      butnFTY.setEnabled(true);
    }
  }

  void r_Sel_FTY_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      txtAreaFTY.setEnabled(true);
      //txtAreaFTY.setEditable(true);
      butnFTY.setEnabled(true);
    } else {
      txtAreaFTY.setEnabled(false);
      //txtAreaFTY.setEditable(false);
      butnFTY.setEnabled(false);
    }
  }

  boolean check_txtYear(){
    if (!txtYear.getText().trim().equals("")) {
      if (exgui.verification.VerifyLib.isInteger(txtYear,
          "The Year field must be integer!") == true) {
        return true;
      } else {
        txtYear.grabFocus();
        return false;
      }
    } else {
      return true;
    }
  }

  boolean checkFieldsData() {
    java.util.Vector vYear = new java.util.Vector();
    java.util.Vector vMonth = new java.util.Vector();
    java.util.Vector vDay = new java.util.Vector();

    vYear.add(txtFm_Y.getText().trim());
    vYear.add(txtTo_Y.getText().trim());

    vMonth.add(txtFm_M.getText().trim());
    vMonth.add(txtTo_M.getText().trim());

    vDay.add(txtFm_D.getText().trim());
    vDay.add(txtTo_D.getText().trim());

    boolean checkDate = exgui2.Stuff.checkDate(vYear, vMonth, vDay);

    if(checkDate) {
      return true;
    } else {return false;}
  }
}
