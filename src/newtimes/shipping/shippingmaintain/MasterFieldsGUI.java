package newtimes.shipping.shippingmaintain;

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

public class MasterFieldsGUI extends JPanel {
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JPanel jPanel1 = new JPanel();
  JTextField txtETA_M = new JTextField();
  JTextField txtFrom = new JTextField();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel114 = new JLabel();
  JLabel jLabel117 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JTextField txtTo = new JTextField();
  JTextField txtYear = new JTextField();
  JLabel jLabel113 = new JLabel();
  JLabel jLabel111 = new JLabel();
  JTextField txtHAWB = new JTextField();
  JTextField txtPort = new JTextField();
  JLabel jLabel17 = new JLabel();
  JRadioButton rb_FLAT = new JRadioButton("FLAT",false);
  JTextField txtETD_Y = new JTextField();
  JTextField txtMAWB = new JTextField();
  JLabel jLabel118 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JRadioButton rb_GOH = new JRadioButton("GOH",true);
  JLabel jLabel8 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JTextField txtETD_D = new JTextField();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel115 = new JLabel();
  JTextField txtMonth = new JTextField();
  JLabel jLabel1110 = new JLabel();
  JTextField txtETD_M = new JTextField();
  JTextField txtDimnetWT = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtNetWT = new JTextField();
  JTextField txtLC = new JTextField();
  JTextField txtFLT = new JTextField();
  JTextField txtGrossWT = new JTextField();
  JTextField txtAgent = new JTextField();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel1111 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JTextField txtDimentCTN = new JTextField();
  JLabel jLabel112 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField txtETA_D = new JTextField();
  JTextField txtSrnNo = new JTextField();
  JLabel jLabel119 = new JLabel();
  JTextField txtETA_Y = new JTextField();
  JLabel jLabel22 = new JLabel();
  JLabel labelSrnNo = new JLabel();
  JTextField txtDay = new JTextField();
  JTextField txtVia = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField txtAttn = new JTextField();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JPanel jPanel3 = new JPanel();
  JComboBox cmboDiv = new JComboBox();
  JTextField txtIC_Y = new JTextField();
  JComboBox cmboSeason = new JComboBox();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel23 = new JLabel();
  JTextField txtIC_M = new JTextField();
  JLabel jLabel110 = new JLabel();
  JTextField txtIC_D = new JTextField();
  JLabel jLabel24 = new JLabel();
  JLabel jLabel25 = new JLabel();
  JLabel jLabel121 = new JLabel();
  JTextField txtInv = new JTextField();

  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXCnty = null;
  exgui.DataBindJCombobox dbJCBXEx = null;
  exgui.DataBindJCombobox dbJCBXTo = null;
  exgui.DataBindJCombobox dbJCBXBillTo = null;
  exgui.DataBindJCombobox dbJCBXShipTo = null;
  exgui.DataBindJCombobox dbJCBXPrxTerm = null;
  exgui.DataBindJCombobox dbJCBXExpAgent = null;
  exgui.DataBindJCombobox dbJCBXExpForwr = null;

  MasterExtraTableEditor extTableEditor = new MasterExtraTableEditor();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel116 = new JLabel();
  JTextField txtTotalNegoAmt = new JTextField();
  JLabel jLabel18 = new JLabel();
  JTextField txtTotalNetAmt = new JTextField();
  JButton butnTableEdit = new JButton();
  JButton butnTablePaste = new JButton();
  JButton butnTableNew = new JButton();
  JButton butnTableDelete = new JButton();
  JButton butnTableCopy = new JButton();
  JLabel jLabel16 = new JLabel();
  JTextField txtDimnetWT_2 = new JTextField();
  JLabel jLabel122 = new JLabel();
  JTextField txtDimentCTN_2 = new JTextField();
  JLabel jLabel123 = new JLabel();
  JTextField txtNetWT_2 = new JTextField();
  JLabel jLabel124 = new JLabel();
  JTextField txtGrossWT_2 = new JTextField();
  JComboBox cmboCnty = new JComboBox();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTextArea txtAreaVessel = new JTextArea();
  JComboBox cmboOceanAir = new JComboBox();
  JComboBox cmboEx = new JComboBox();
  JComboBox cmboTo = new JComboBox();
  static String SRN_NO =
    util.ApplicationProperites.getProperties("SRN_NO").toString();
  JTextField txtScNo = new JTextField();
  JLabel labelScNo = new JLabel();
  JLabel jLabel1112 = new JLabel();
  JTextField txtDes = new JTextField();
  JLabel jLabel26 = new JLabel();
  JLabel jLabel125 = new JLabel();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel126 = new JLabel();
  JLabel jLabel127 = new JLabel();
  JLabel jLabel1113 = new JLabel();
  JTextField txtDimUnit = new JTextField();
  JTextField txtGrossUnit = new JTextField();
  JLabel jLabel1114 = new JLabel();
  JTextField txtNetUnit = new JTextField();
  JLabel jLabel1115 = new JLabel();
  JLabel jLabel128 = new JLabel();
  JLabel jLabel129 = new JLabel();
  JLabel jLabel1210 = new JLabel();
  JTextField txtCuft = new JTextField();
  JLabel jLabel1116 = new JLabel();
  JTextField txtNetNetDot = new JTextField();
  JLabel jLabel1117 = new JLabel();
  JLabel jLabel1211 = new JLabel();
  JTextField txtNetNetUnit = new JTextField();
  JLabel jLabel1212 = new JLabel();
  JTextField txtNetNet = new JTextField();
  JLabel jLabel1118 = new JLabel();
  JComboBox cmboPrxTerm = new JComboBox();
  JComboBox cmboExpAgent = new JComboBox();
  JComboBox cmboExpFowr = new JComboBox();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JComboBox cmboBill = new JComboBox();
  JComboBox cmboShip = new JComboBox();

  public MasterFieldsGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setMaxLength();
    this.setLayout(gridBagLayout2);
    this.setSize(new Dimension(767, 943));
    this.setBackground(new Color(204, 204, 225));
    this.setDebugGraphicsOptions(0);
    this.setOpaque(true);
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    txtETA_M.setBounds(new Rectangle(280, 263, 37, 20));
    txtFrom.setBounds(new Rectangle(583, 56, 180, 20));
    jLabel14.setBackground(new Color(143, 143, 188));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel14.setForeground(new Color(10,36,106));
    jLabel14.setOpaque(true);
    jLabel14.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel14.setText(" Container :");
    jLabel14.setBounds(new Rectangle(10, 516, 155, 20));
    jLabel114.setBounds(new Rectangle(389, 490, 155, 20));
    jLabel114.setText(" Gross WT :");
    jLabel114.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel114.setOpaque(true);
    jLabel114.setForeground(Color.white);
    jLabel114.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel114.setBackground(new Color(143, 143, 188));
    jLabel117.setBounds(new Rectangle(10, 292, 155, 70));
    jLabel117.setText(" Vessel :");
    jLabel117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel117.setOpaque(true);
    jLabel117.setForeground(Color.white);
    jLabel117.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel117.setBackground(new Color(143, 143, 188));
    jLabel9.setBounds(new Rectangle(10, 199, 155, 20));
    jLabel9.setText(" Agent :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    txtTo.setBounds(new Rectangle(583, 33, 180, 20));
    txtYear.setBounds(new Rectangle(214, 33, 54, 20));
    jLabel113.setBackground(new Color(143, 143, 188));
    jLabel113.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel113.setForeground(new Color(10,36,106));
    jLabel113.setOpaque(true);
    jLabel113.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel113.setText(" Ex :");
    jLabel113.setBounds(new Rectangle(334, 383, 44, 20));
    jLabel111.setBounds(new Rectangle(389, 33, 155, 20));
    jLabel111.setText(" To :");
    jLabel111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel111.setOpaque(true);
    jLabel111.setForeground(Color.white);
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel111.setBackground(new Color(143, 143, 188));
    txtHAWB.setBounds(new Rectangle(583, 148, 180, 20));
    txtPort.setBounds(new Rectangle(583, 217, 180, 20));
    jLabel17.setBounds(new Rectangle(10, 450, 155, 20));
    jLabel17.setText(" Original Country :");
    jLabel17.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel17.setOpaque(true);
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel17.setBackground(new Color(143, 143, 188));
    rb_FLAT.setBackground(Color.white);
    rb_FLAT.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_FLAT.setForeground(Color.darkGray);
    rb_FLAT.setHorizontalAlignment(SwingConstants.CENTER);
    rb_FLAT.setBounds(new Rectangle(273, 342, 106, 20));
    txtETD_Y.setBounds(new Rectangle(214, 240, 54, 20));
    txtMAWB.setBounds(new Rectangle(583, 171, 180, 20));
    jLabel118.setBounds(new Rectangle(389, 516, 155, 20));
    jLabel118.setText(" Net WT :");
    jLabel118.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel118.setOpaque(true);
    jLabel118.setForeground(new Color(10,36,106));
    jLabel118.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel118.setBackground(new Color(143, 143, 188));
    jLabel6.setForeground(new Color(10,36,106));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel6.setText("/");
    jLabel6.setBounds(new Rectangle(224, 33, 15, 25));
    jLabel5.setBounds(new Rectangle(273, 409, 15, 25));
    jLabel5.setText("/");
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 16));
    rb_GOH.setBounds(new Rectangle(167, 342, 106, 20));
    rb_GOH.setHorizontalAlignment(SwingConstants.CENTER);
    rb_GOH.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_GOH.setForeground(Color.darkGray);
    rb_GOH.setBackground(Color.white);
    jLabel8.setBounds(new Rectangle(273, 33, 15, 25));
    jLabel8.setText("/");
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel4.setText("/");
    jLabel4.setBounds(new Rectangle(224, 409, 15, 25));
    jLabel21.setBounds(new Rectangle(389, 83, 155, 20));
    jLabel21.setText(" Via :");
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setOpaque(true);
    jLabel21.setForeground(Color.white);
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setForeground(Color.white);
    jLabel12.setOpaque(true);
    jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel12.setText(" Dimnet WT :");
    jLabel12.setBounds(new Rectangle(10, 490, 155, 20));
    extTableEditor.setBounds(new Rectangle(13, 25, 628, 170));
    txtETD_D.setBounds(new Rectangle(328, 240, 37, 20));
    jLabel20.setBackground(new Color(143, 143, 188));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel20.setForeground(new Color(10,36,106));
    jLabel20.setOpaque(true);
    jLabel20.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel20.setText(" Ocean / Air :");
    jLabel20.setBounds(new Rectangle(389, 174, 155, 20));
    jLabel3.setBounds(new Rectangle(224, 383, 15, 25));
    jLabel3.setText("/");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel3.setForeground(new Color(10,36,106));
    jLabel115.setBackground(new Color(143, 143, 188));
    jLabel115.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel115.setForeground(Color.white);
    jLabel115.setOpaque(true);
    jLabel115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel115.setText(" HAWB / HBL# :");
    jLabel115.setBounds(new Rectangle(10, 251, 155, 20));
    txtMonth.setBounds(new Rectangle(280, 33, 37, 20));
    jLabel1110.setBackground(new Color(143, 143, 188));
    jLabel1110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1110.setForeground(Color.white);
    jLabel1110.setOpaque(true);
    jLabel1110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1110.setText(" FLT# :");
    jLabel1110.setBounds(new Rectangle(389, 292, 155, 20));
    txtETD_M.setBounds(new Rectangle(280, 240, 37, 20));
    txtDimnetWT.setBounds(new Rectangle(214, 286, 180, 20));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setText("/");
    jLabel2.setBounds(new Rectangle(273, 383, 15, 25));
    txtNetWT.setBounds(new Rectangle(583, 286, 180, 20));
    txtLC.setBounds(new Rectangle(214, 102, 180, 20));
    txtFLT.setBounds(new Rectangle(583, 194, 180, 20));
    txtGrossWT.setBounds(new Rectangle(583, 309, 180, 20));
    txtAgent.setBounds(new Rectangle(214, 125, 180, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(Color.white);
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Date :");
    jLabel19.setBounds(new Rectangle(10, 33, 155, 20));
    jLabel1111.setBounds(new Rectangle(389, 251, 155, 20));
    jLabel1111.setText(" MAWB / CBL# :");
    jLabel1111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1111.setOpaque(true);
    jLabel1111.setForeground(Color.white);
    jLabel1111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1111.setBackground(new Color(143, 143, 188));
    jLabel11.setBounds(new Rectangle(10, 409, 155, 20));
    jLabel11.setText(" ETA Date :");
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(Color.white);
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    txtDimentCTN.setBounds(new Rectangle(214, 309, 180, 20));
    jLabel112.setBounds(new Rectangle(389, 317, 155, 20));
    jLabel112.setText(" Port :");
    jLabel112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel112.setOpaque(true);
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel112.setBackground(new Color(143, 143, 188));
    jLabel7.setBounds(new Rectangle(10, 58, 155, 20));
    jLabel7.setText(" Attn :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    txtETA_D.setBounds(new Rectangle(328, 263, 37, 20));
    txtSrnNo.setBounds(new Rectangle(214, 10, 180, 20));
    txtSrnNo.setEditable(false);
    jLabel119.setBackground(new Color(143, 143, 188));
    jLabel119.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel119.setForeground(Color.white);
    jLabel119.setOpaque(true);
    jLabel119.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel119.setText(" To :");
    jLabel119.setBounds(new Rectangle(334, 409, 44, 20));
    txtETA_Y.setBounds(new Rectangle(214, 263, 54, 20));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setForeground(new Color(10,36,106));
    jLabel22.setOpaque(true);
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setText(" From :");
    jLabel22.setBounds(new Rectangle(389, 58, 155, 20));
    labelSrnNo.setBounds(new Rectangle(10, 8, 155, 20));
    labelSrnNo.setText(" SRN No. :");
    labelSrnNo.setHorizontalAlignment(SwingConstants.LEFT);
    labelSrnNo.setOpaque(true);
    labelSrnNo.setForeground(new Color(10,36,106));
    labelSrnNo.setFont(new java.awt.Font("Dialog", 1, 12));
    labelSrnNo.setBackground(new Color(143, 143, 188));
    txtDay.setBounds(new Rectangle(328, 33, 37, 20));
    txtVia.setBounds(new Rectangle(583, 79, 180, 20));
    jLabel15.setBounds(new Rectangle(10, 383, 155, 20));
    jLabel15.setText(" * ETD Date :");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(new Color(10,36,106));
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" L / C No. :");
    jLabel10.setBounds(new Rectangle(10, 174, 155, 20));
    txtAttn.setBounds(new Rectangle(214, 56, 180, 20));
    txtETA_M.setBounds(new Rectangle(233, 409, 37, 20));
    txtFrom.setBounds(new Rectangle(546, 58, 209, 20));
    txtTo.setBounds(new Rectangle(546, 33, 209, 20));
    txtYear.setBounds(new Rectangle(167, 33, 54, 20));
    txtHAWB.setBounds(new Rectangle(167, 251, 209, 20));
    txtPort.setBounds(new Rectangle(546, 317, 209, 20));
    txtETD_Y.setBounds(new Rectangle(167, 383, 54, 20));
    txtMAWB.setBounds(new Rectangle(546, 251, 209, 20));
    txtETD_D.setBounds(new Rectangle(281, 383, 37, 20));
    txtMonth.setBounds(new Rectangle(233, 33, 37, 20));
    txtETD_M.setBounds(new Rectangle(233, 383, 37, 20));
    txtDimnetWT.setText("0");
    txtDimnetWT.setHorizontalAlignment(SwingConstants.RIGHT);
    txtDimnetWT.setBounds(new Rectangle(167, 490, 54, 20));
    txtDimnetWT.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtDimnetWT_keyTyped(e);
      }
    });
    txtNetWT.setText("0");
    txtNetWT.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetWT.setBounds(new Rectangle(546, 516, 54, 20));
    txtNetWT.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtNetWT_keyTyped(e);
      }
    });
    txtLC.setBounds(new Rectangle(167, 174, 209, 20));
    txtFLT.setBounds(new Rectangle(546, 292, 209, 20));
    txtGrossWT.setText("0");
    txtGrossWT.setHorizontalAlignment(SwingConstants.RIGHT);
    txtGrossWT.setBounds(new Rectangle(546, 490, 54, 20));
    txtGrossWT.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtGrossWT_keyTyped(e);
      }
    });
    txtAgent.setBounds(new Rectangle(167, 199, 209, 20));
    txtDimentCTN.setText("0");
    txtDimentCTN.setHorizontalAlignment(SwingConstants.RIGHT);
    txtDimentCTN.setBounds(new Rectangle(167, 516, 54, 20));
    txtDimentCTN.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtDimentCTN_keyTyped(e);
      }
    });
    txtETA_D.setBounds(new Rectangle(281, 409, 37, 20));
    txtSrnNo.setBounds(new Rectangle(167, 8, 209, 20));
    txtETA_Y.setBounds(new Rectangle(167, 409, 54, 20));
    txtDay.setBounds(new Rectangle(281, 33, 37, 20));
    txtVia.setBounds(new Rectangle(546, 83, 209, 20));
    txtAttn.setBounds(new Rectangle(167, 58, 209, 20));
    jPanel3.setBounds(new Rectangle(7, 584, 744, 118));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Inspection Certificate "));
    cmboDiv.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(161, 55, 373, 20));
    txtIC_Y.setBounds(new Rectangle(168, 71, 54, 20));
    txtIC_Y.setBounds(new Rectangle(534, 27, 54, 20));
    cmboSeason.setBackground(Color.white);
    cmboSeason.setBounds(new Rectangle(161, 83, 197, 20));
    jLabel13.setBounds(new Rectangle(640, 27, 15, 25));
    jLabel13.setText("/");
    jLabel13.setForeground(new Color(10,36,106));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel23.setBounds(new Rectangle(11, 83, 148, 20));
    jLabel23.setText(" Season :");
    jLabel23.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel23.setOpaque(true);
    jLabel23.setForeground(new Color(10,36,106));
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel23.setBackground(new Color(143, 143, 188));
    txtIC_M.setBounds(new Rectangle(234, 71, 37, 20));
    txtIC_M.setBounds(new Rectangle(600, 27, 37, 20));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(new Color(10,36,106));
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" INV :");
    jLabel110.setBounds(new Rectangle(11, 27, 148, 20));
    txtIC_D.setBounds(new Rectangle(282, 71, 37, 20));
    txtIC_D.setBounds(new Rectangle(648, 27, 37, 20));
    jLabel24.setForeground(new Color(10,36,106));
    jLabel24.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel24.setText("/");
    jLabel24.setBounds(new Rectangle(591, 27, 15, 25));
    jLabel25.setBounds(new Rectangle(384, 27, 148, 20));
    jLabel25.setText(" Date :");
    jLabel25.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel25.setOpaque(true);
    jLabel25.setForeground(new Color(10,36,106));
    jLabel25.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel25.setBackground(new Color(143, 143, 188));
    jLabel121.setBackground(new Color(143, 143, 188));
    jLabel121.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel121.setForeground(Color.white);
    jLabel121.setOpaque(true);
    jLabel121.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel121.setText(" Division :");
    jLabel121.setBounds(new Rectangle(11, 55, 148, 20));
    txtInv.setBounds(new Rectangle(168, 42, 589, 20));
    txtInv.setBounds(new Rectangle(161, 27, 197, 20));
    jPanel4.setBorder(BorderFactory.createTitledBorder(" Extra "));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(7, 713, 744, 208));
    jLabel116.setBounds(new Rectangle(327, 171, 148, 20));
    jLabel116.setText(" Total NEGO Amount :");
    jLabel116.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel116.setOpaque(true);
    jLabel116.setForeground(new Color(10,36,106));
    jLabel116.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel116.setBackground(new Color(143, 143, 188));
    txtTotalNegoAmt.setBounds(new Rectangle(583, 508, 180, 20));
    txtTotalNegoAmt.setFont(new java.awt.Font("Dialog", 1, 12));
    txtTotalNegoAmt.setForeground(Color.black);
    txtTotalNegoAmt.setEditable(false);
    txtTotalNegoAmt.setHorizontalAlignment(SwingConstants.RIGHT);
    txtTotalNegoAmt.setBounds(new Rectangle(477, 171, 148, 20));
    jLabel18.setBackground(new Color(143, 143, 188));
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel18.setForeground(new Color(10,36,106));
    jLabel18.setOpaque(true);
    jLabel18.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel18.setText(" Total Net Amount :");
    jLabel18.setBounds(new Rectangle(13, 171, 148, 20));
    txtTotalNetAmt.setBounds(new Rectangle(214, 508, 180, 20));
    txtTotalNetAmt.setFont(new java.awt.Font("Dialog", 1, 12));
    txtTotalNetAmt.setForeground(Color.black);
    txtTotalNetAmt.setEditable(false);
    txtTotalNetAmt.setHorizontalAlignment(SwingConstants.RIGHT);
    txtTotalNetAmt.setBounds(new Rectangle(163, 171, 148, 20));
    butnTableEdit.setBounds(new Rectangle(649, 53, 79, 24));
    butnTableEdit.setFont(new java.awt.Font("Dialog", 0, 12));
    butnTableEdit.setText("Save");
    butnTableEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnTableEdit_actionPerformed(e);
      }
    });
    butnTablePaste.setBounds(new Rectangle(649, 110, 79, 24));
    butnTablePaste.setFont(new java.awt.Font("Dialog", 0, 12));
    butnTablePaste.setText("Paste");
    butnTablePaste.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnTablePaste_actionPerformed(e);
      }
    });
    butnTableNew.setBounds(new Rectangle(649, 25, 79, 24));
    butnTableNew.setFont(new java.awt.Font("Dialog", 0, 12));
    butnTableNew.setText("New");
    butnTableNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnTableNew_actionPerformed(e);
      }
    });
    butnTableDelete.setBounds(new Rectangle(649, 139, 79, 24));
    butnTableDelete.setFont(new java.awt.Font("Dialog", 0, 12));
    butnTableDelete.setText("Delete");
    butnTableDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnTableDelete_actionPerformed(e);
      }
    });
    butnTableCopy.setBounds(new Rectangle(649, 82, 79, 24));
    butnTableCopy.setFont(new java.awt.Font("Dialog", 0, 12));
    butnTableCopy.setText("Copy");
    butnTableCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnTableCopy_actionPerformed(e);
      }
    });
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel16.setForeground(new Color(10,36,106));
    jLabel16.setText(".");
    jLabel16.setBounds(new Rectangle(224, 490, 11, 20));
    txtDimnetWT_2.setText("00");
    txtDimnetWT_2.setBounds(new Rectangle(233, 490, 23, 20));
    jLabel122.setBounds(new Rectangle(224, 516, 11, 20));
    jLabel122.setText(".");
    jLabel122.setForeground(new Color(10,36,106));
    jLabel122.setFont(new java.awt.Font("Dialog", 1, 18));
    txtDimentCTN_2.setText("00");
    txtDimentCTN_2.setBounds(new Rectangle(233, 516, 23, 20));
    txtDimentCTN_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtDimentCTN_2_keyTyped(e);
      }
    });
    jLabel123.setBounds(new Rectangle(604, 516, 11, 20));
    jLabel123.setText(".");
    jLabel123.setForeground(new Color(10,36,106));
    jLabel123.setFont(new java.awt.Font("Dialog", 1, 18));
    txtNetWT_2.setBounds(new Rectangle(613, 516, 23, 20));
    txtNetWT_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtNetWT_2_keyTyped(e);
      }
    });
    txtNetWT_2.setText("00");
    jLabel124.setBounds(new Rectangle(604, 490, 11, 20));
    jLabel124.setText(".");
    jLabel124.setForeground(new Color(10,36,106));
    jLabel124.setFont(new java.awt.Font("Dialog", 1, 18));
    txtGrossWT_2.setBounds(new Rectangle(613, 490, 23, 20));
    txtGrossWT_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtGrossWT_2_keyTyped(e);
      }
    });
    txtGrossWT_2.setText("00");
    cmboCnty.setBounds(new Rectangle(167, 450, 375, 20));
    cmboCnty.setBackground(Color.white);
    jScrollPane3.setBounds(new Rectangle(167, 292, 212, 46));
    txtAreaVessel.setLineWrap(true);
    cmboOceanAir.setBounds(new Rectangle(546, 174, 209, 20));
    cmboEx.setBounds(new Rectangle(380, 383, 375, 21));
    cmboTo.setBounds(new Rectangle(380, 409, 375, 21));
    cmboOceanAir.setBackground(Color.white);
    cmboEx.setBackground(Color.white);
    cmboTo.setBackground(Color.white);
    txtScNo.setBounds(new Rectangle(167, 8, 209, 20));
    txtScNo.setForeground(new Color(10,36,106));
    labelScNo.setBounds(new Rectangle(10, 8, 155, 20));
    labelScNo.setText(" * SC No. :");
    labelScNo.setHorizontalAlignment(SwingConstants.LEFT);
    labelScNo.setOpaque(true);
    labelScNo.setForeground(new Color(10,36,106));
    labelScNo.setFont(new java.awt.Font("Dialog", 1, 12));
    labelScNo.setBackground(new Color(143, 143, 188));
    jLabel1112.setBounds(new Rectangle(10, 133, 155, 20));
    jLabel1112.setText(" Destination :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(Color.white);
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    txtDes.setBounds(new Rectangle(167, 240, 209, 20));
    txtDes.setBounds(new Rectangle(167, 133, 209, 20));
    jLabel26.setBackground(new Color(143, 143, 188));
    jLabel26.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel26.setForeground(new Color(10,36,106));
    jLabel26.setOpaque(true);
    jLabel26.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel26.setText(" Ship to :");
    jLabel26.setBounds(new Rectangle(10, 108, 155, 20));
    jLabel125.setBounds(new Rectangle(10, 83, 155, 20));
    jLabel125.setText(" Bill to :");
    jLabel125.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel125.setOpaque(true);
    jLabel125.setForeground(Color.white);
    jLabel125.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel125.setBackground(new Color(143, 143, 188));
    jLabel27.setBounds(new Rectangle(389, 108, 155, 20));
    jLabel27.setText(" Price Term :");
    jLabel27.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel27.setOpaque(true);
    jLabel27.setForeground(new Color(10,36,106));
    jLabel27.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel27.setBackground(new Color(143, 143, 188));
    jLabel126.setBackground(new Color(143, 143, 188));
    jLabel126.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel126.setForeground(new Color(10,36,106));
    jLabel126.setOpaque(true);
    jLabel126.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel126.setText(" Export Forwarder :");
    jLabel126.setBounds(new Rectangle(389, 225, 155, 20));
    jLabel127.setBounds(new Rectangle(10, 225, 155, 20));
    jLabel127.setText("Export Agent :");
    jLabel127.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel127.setOpaque(true);
    jLabel127.setForeground(new Color(10,36,106));
    jLabel127.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel127.setBackground(new Color(143, 143, 188));
    jLabel1113.setBounds(new Rectangle(270, 490, 44, 20));
    jLabel1113.setText(" Unit :");
    jLabel1113.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1113.setOpaque(true);
    jLabel1113.setForeground(Color.white);
    jLabel1113.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1113.setBackground(new Color(143, 143, 188));
    txtDimUnit.setBounds(new Rectangle(167, 490, 54, 20));
    txtDimUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtDimUnit.setText("0");
    txtDimUnit.setBounds(new Rectangle(316, 490, 40, 20));
    txtGrossUnit.setBounds(new Rectangle(311, 490, 54, 20));
    txtGrossUnit.setText("0");
    txtGrossUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtGrossUnit.setBounds(new Rectangle(692, 490, 40, 20));
    jLabel1114.setBackground(new Color(143, 143, 188));
    jLabel1114.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1114.setForeground(Color.white);
    jLabel1114.setOpaque(true);
    jLabel1114.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1114.setText(" Unit :");
    jLabel1114.setBounds(new Rectangle(646, 490, 44, 20));
    txtNetUnit.setBounds(new Rectangle(311, 490, 54, 20));
    txtNetUnit.setText("0");
    txtNetUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetUnit.setBounds(new Rectangle(692, 516, 40, 20));
    jLabel1115.setBackground(new Color(143, 143, 188));
    jLabel1115.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1115.setForeground(new Color(10,36,106));
    jLabel1115.setOpaque(true);
    jLabel1115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1115.setText(" Unit :");
    jLabel1115.setBounds(new Rectangle(646, 516, 44, 20));
    jLabel128.setBounds(new Rectangle(359, 490, 17, 20));
    jLabel128.setText("KG");
    jLabel128.setForeground(new Color(10,36,106));
    jLabel128.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel129.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel129.setForeground(new Color(10,36,106));
    jLabel129.setText("KG");
    jLabel129.setBounds(new Rectangle(735, 490, 17, 20));
    jLabel1210.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1210.setForeground(new Color(10,36,106));
    jLabel1210.setText("KG");
    jLabel1210.setBounds(new Rectangle(735, 516, 17, 20));
    txtCuft.setBounds(new Rectangle(161, 27, 197, 20));
    txtCuft.setBounds(new Rectangle(167, 542, 209, 20));
    jLabel1116.setBounds(new Rectangle(10, 542, 155, 20));
    jLabel1116.setText(" Dimenesion CUFT :");
    jLabel1116.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1116.setOpaque(true);
    jLabel1116.setForeground(Color.white);
    jLabel1116.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1116.setBackground(new Color(143, 143, 188));
    jLabel1117.setBackground(new Color(143, 143, 188));
    jLabel1117.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1117.setForeground(Color.white);
    jLabel1117.setOpaque(true);
    jLabel1117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1117.setText(" Net Net WT :");
    jLabel1117.setBounds(new Rectangle(389, 542, 155, 20));
    jLabel1211.setBounds(new Rectangle(735, 542, 17, 20));
    jLabel1211.setText("KG");
    jLabel1211.setForeground(new Color(10,36,106));
    jLabel1211.setFont(new java.awt.Font("Dialog", 1, 12));
    txtNetNetUnit.setBounds(new Rectangle(692, 516, 40, 20));
    txtNetNetUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetNetUnit.setText("0");
    txtNetNetUnit.setBounds(new Rectangle(692, 542, 40, 20));
    jLabel1212.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1212.setForeground(new Color(10,36,106));
    jLabel1212.setText(".");
    jLabel1212.setBounds(new Rectangle(604, 542, 11, 20));
    txtNetNet.setBounds(new Rectangle(546, 516, 54, 20));
    txtNetNet.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetNet.setText("0");
    txtNetNet.setBounds(new Rectangle(546, 542, 54, 20));
    txtNetNet.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtNetNet_keyTyped(e);
      }
    });
    jLabel1118.setBounds(new Rectangle(646, 542, 44, 20));
    jLabel1118.setText(" Unit :");
    jLabel1118.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1118.setOpaque(true);
    jLabel1118.setForeground(Color.white);
    jLabel1118.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1118.setBackground(new Color(143, 143, 188));
    txtNetNetDot.setText("00");
    txtNetNetDot.setBounds(new Rectangle(613, 542, 23, 20));
    cmboPrxTerm.setBounds(new Rectangle(546, 108, 209, 20));
    cmboExpAgent.setBounds(new Rectangle(167, 225, 209, 20));
    cmboExpFowr.setBounds(new Rectangle(546, 225, 209, 20));
    cmboExpAgent.setBackground(Color.white);
    cmboExpFowr.setBackground(Color.white);
    cmboPrxTerm.setBackground(Color.white);
    cmboBill.setBackground(Color.white);
    cmboShip.setBackground(Color.white);
    cmboBill.setBounds(new Rectangle(167, 83, 209, 20));
    cmboShip.setBounds(new Rectangle(167, 108, 209, 20));
    jPanel4.add(jLabel18, null);
    jPanel4.add(txtTotalNetAmt, null);
    jPanel4.add(butnTableDelete, null);
    jPanel4.add(butnTablePaste, null);
    jPanel4.add(butnTableNew, null);
    jPanel4.add(butnTableEdit, null);
    jPanel4.add(butnTableCopy, null);
    jPanel4.add(txtTotalNegoAmt, null);
    jPanel4.add(jLabel116, null);
    jPanel4.add(extTableEditor, null);
    jPanel1.add(txtCuft, null);
    jPanel1.add(jLabel1116, null);
    jPanel1.add(jLabel115, null);
    jPanel1.add(txtHAWB, null);
    jPanel1.add(jLabel1111, null);
    jPanel1.add(txtMAWB, null);
    jPanel1.add(jLabel117, null);
    jPanel1.add(jScrollPane3, null);
    jPanel1.add(jLabel1110, null);
    jPanel1.add(txtFLT, null);
    jPanel1.add(txtPort, null);
    jPanel1.add(jLabel112, null);
    jPanel1.add(rb_FLAT, null);
    jPanel1.add(rb_GOH, null);
    jPanel1.add(jLabel15, null);
    jPanel1.add(jLabel11, null);
    jPanel1.add(txtETD_Y, null);
    jPanel1.add(txtETA_Y, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(txtETD_M, null);
    jPanel1.add(txtETA_M, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(txtETD_D, null);
    jPanel1.add(txtETA_D, null);
    jPanel1.add(jLabel113, null);
    jPanel1.add(cmboEx, null);
    jPanel1.add(jLabel119, null);
    jPanel1.add(cmboTo, null);
    jPanel1.add(jLabel17, null);
    jPanel1.add(cmboCnty, null);
    jPanel1.add(jLabel12, null);
    jPanel1.add(txtDimnetWT, null);
    jPanel1.add(jLabel16, null);
    jPanel1.add(txtDimnetWT_2, null);
    jPanel1.add(jLabel14, null);
    jPanel1.add(txtDimentCTN, null);
    jPanel1.add(jLabel122, null);
    jPanel1.add(txtDimentCTN_2, null);
    jPanel1.add(jLabel114, null);
    jPanel1.add(txtGrossWT, null);
    jPanel1.add(jLabel124, null);
    jPanel1.add(txtGrossWT_2, null);
    jPanel1.add(jLabel118, null);
    jPanel1.add(txtNetWT, null);
    jPanel1.add(jLabel123, null);
    jPanel1.add(txtNetWT_2, null);
    jPanel1.add(jLabel127, null);
    jPanel1.add(jLabel126, null);
    jScrollPane3.getViewport().add(txtAreaVessel, null);
    this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(6, 3, 5, 2), 761, 931));
    jPanel1.add(jLabel19, null);
    jPanel1.add(txtYear, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(txtMonth, null);
    jPanel1.add(jLabel8, null);
    jPanel1.add(txtDay, null);
    jPanel1.add(jLabel111, null);
    jPanel1.add(txtTo, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(txtAttn, null);
    jPanel1.add(jLabel22, null);
    jPanel1.add(txtFrom, null);
    jPanel1.add(jLabel21, null);
    jPanel1.add(txtVia, null);
    jPanel3.add(jLabel110, null);
    jPanel3.add(txtInv, null);
    jPanel3.add(jLabel25, null);
    jPanel3.add(txtIC_Y, null);
    jPanel3.add(jLabel24, null);
    jPanel3.add(txtIC_M, null);
    jPanel3.add(jLabel13, null);
    jPanel3.add(txtIC_D, null);
    jPanel3.add(cmboDiv, null);
    jPanel3.add(jLabel121, null);
    jPanel3.add(jLabel23, null);
    jPanel3.add(cmboSeason, null);
    jPanel1.add(cmboBill, null);
    jPanel1.add(cmboShip, null);
    jPanel1.add(jPanel4, null);
    jPanel1.add(jLabel1112, null);
    jPanel1.add(txtDes, null);
    jPanel1.add(jLabel125, null);
    jPanel1.add(jLabel26, null);
    jPanel1.add(labelScNo, null);
    jPanel1.add(txtScNo, null);
    buttonGroup1.add(rb_GOH);
    buttonGroup1.add(rb_FLAT);
    jPanel1.add(jLabel27, null);
    jPanel1.add(jLabel10, null);
    jPanel1.add(txtLC, null);
    jPanel1.add(jLabel9, null);
    jPanel1.add(txtAgent, null);
    jPanel1.add(jLabel20, null);
    jPanel1.add(cmboOceanAir, null);
    jPanel1.add(jLabel1115, null);
    jPanel1.add(txtNetUnit, null);
    jPanel1.add(txtDimUnit, null);
    jPanel1.add(jLabel1113, null);
    jPanel1.add(jLabel128, null);
    jPanel1.add(jLabel1210, null);
    jPanel1.add(jLabel129, null);
    jPanel1.add(jLabel1114, null);
    jPanel1.add(txtGrossUnit, null);
    jPanel1.add(cmboPrxTerm, null);
    jPanel1.add(cmboExpAgent, null);
    jPanel1.add(cmboExpFowr, null);
    jPanel1.add(jLabel1117, null);
    jPanel1.add(txtNetNet, null);
    jPanel1.add(jLabel1212, null);
    jPanel1.add(txtNetNetDot, null);
    jPanel1.add(jLabel1118, null);
    jPanel1.add(txtNetNetUnit, null);
    jPanel1.add(jLabel1211, null);
    jPanel1.add(jPanel3, null);
    this.setCmboData();
  }

  boolean isVisible_SrnNoAndExtra(boolean isSrnNo) {
    boolean isShow = false;
    java.util.Vector vDataPrxTerm = null;
    try {
      if (isSrnNo) {
        this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(6, 3, 4, 2), 761, 931));
        labelScNo.setVisible(false);
        txtScNo.setVisible(false);
        jPanel1.add(txtSrnNo, null);
        jPanel1.add(labelSrnNo, null);
        jPanel1.add(jPanel4, null);
        isShow = true;

        vDataPrxTerm = exgui2.CONST.SHIP_MAIN_EJB.getShipPrxTerm();
        if(vDataPrxTerm.size()>0){
          database.datatype.Record recPrxTerm = (database.datatype.Record)
              vDataPrxTerm.get(0);
          dbJCBXPrxTerm = new exgui.DataBindJCombobox(cmboPrxTerm, vDataPrxTerm,
              "PRC_TRM", "PRC_TRM",
              recPrxTerm.get("PRC_TRM"), "", "");
          cmboPrxTerm.setSelectedIndex(0);
        }else{

          dbJCBXPrxTerm = null;
          cmboPrxTerm.removeAllItems();
        }



        this.setTotalAmt2TxtField();
      } else {
        this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(6, 3, 5, 2), 761, 575));
        isShow = false;

        vDataPrxTerm = exgui2.CONST.BASIC_MAIN_EJB.getPriceTermAll("PRC_TRM", "PRC_TRM");
        if(vDataPrxTerm.size()>0){
           database.datatype.Record recPrxTerm = (database.datatype.Record)vDataPrxTerm.get(0);
           dbJCBXPrxTerm = new exgui.DataBindJCombobox(cmboPrxTerm, vDataPrxTerm, "PRC_TRM", "PRC_TRM",
                                                recPrxTerm.get("PRC_TRM"), "", "");
           cmboPrxTerm.setSelectedIndex(0);
        }else{
           dbJCBXPrxTerm=null;
           cmboPrxTerm.removeAllItems();
        }
      }
    } catch (Exception eSN) {
      eSN.printStackTrace();
      util.ExceptionLog.exp2File(eSN, "error at show SRN No. field.");
    } finally {
      return isShow;
    }
  }

  void setTotalAmt2TxtField() {
    if (extTableEditor.getJtable().getRowCount() == 0) {
      txtTotalNegoAmt.setText("0");
      txtTotalNetAmt.setText("0");
    } else {
      database.datatype.Record recNET = null;
      database.datatype.Record recNEGO = null;
      try {
        if (MasterEdit.SRN_NO != null) {
          java.util.Vector vNET = exgui2.CONST.SHIP_MAIN_EJB.Total_Net_Amt(MasterEdit.SRN_NO);
          recNET = (database.datatype.Record) vNET.get(0);
          java.util.Vector vNEGO = exgui2.CONST.SHIP_MAIN_EJB.Total_NEGO_Amt(MasterEdit.SRN_NO);
          recNEGO = (database.datatype.Record) vNEGO.get(0);
        } else if (!SRN_NO.equals("")) {
          java.util.Vector vNET = exgui2.CONST.SHIP_MAIN_EJB.Total_Net_Amt(SRN_NO);
          recNET = (database.datatype.Record) vNET.get(0);
          java.util.Vector vNEGO = exgui2.CONST.SHIP_MAIN_EJB.Total_NEGO_Amt(SRN_NO);
          recNEGO = (database.datatype.Record) vNEGO.get(0);
        }
        txtTotalNetAmt.setText(recNET.get(0) == null ? "0" : recNET.get(0).toString());
        txtTotalNegoAmt.setText(recNEGO.get(0) == null ? "0" : recNEGO.get(0).toString());
      } catch (Exception eAmt) {
        eAmt.printStackTrace();
        util.ExceptionLog.exp2File(eAmt, "error at count Amount value.\n"+
                        "NET: "+recNET.toString()+"\nNEGO: "+recNEGO.toString());
      }
    }
  }

  void setCmboData() {
    java.util.Vector vDataDiv = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataCnty = null;
    java.util.Vector vDataBill = null;
    //java.util.Vector vDataShip = null;
    java.util.Vector vDataExpAgent = null;
    //java.util.Vector vDataExpFowr = null;

    try {
      vDataDiv = exgui2.CONST.BASIC_MAIN_EJB.getDivisionAll("DIV_CODE,DIV_NAME", "DIV_NAME");
      database.datatype.Record recDiv = (database.datatype.Record) vDataDiv.get(0);
      dbJCBXDiv = new exgui.DataBindJCombobox(cmboDiv, vDataDiv, "DIV_NAME",
                                           "DIV_NAME", recDiv.get("DIV_NAME"),"","");
      cmboDiv.setSelectedIndex(0);
      vDataSeason = exgui2.CONST.BASIC_MAIN_EJB.getSeasonAll("SEA_NAME", "SEA_NAME");
      database.datatype.Record recSeason = (database.datatype.Record) vDataSeason.get(0);
      dbJCBXSeason = new exgui.DataBindJCombobox(cmboSeason, vDataSeason, "SEA_NAME",
                                        "SEA_NAME", recSeason.get("SEA_NAME"),"","");
      cmboSeason.setSelectedIndex(0);
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record recCnty = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", recCnty.get("CNTY_NAME"),"","");
      dbJCBXEx = new exgui.DataBindJCombobox(cmboEx, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", recCnty.get("CNTY_NAME"),"","");
      dbJCBXTo = new exgui.DataBindJCombobox(cmboTo, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", recCnty.get("CNTY_NAME"),"","");

      vDataExpAgent = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF", 7);
      database.datatype.Record recExpAgent = (database.datatype.Record) vDataExpAgent.get(0);
      dbJCBXExpAgent = new exgui.DataBindJCombobox(cmboExpAgent, vDataExpAgent, "BYMKR_BRIEF",
                                         "BYMKR_SEQ", recExpAgent.get("BYMKR_SEQ"),"","");
      cmboExpAgent.setSelectedIndex(0);

      //vDataExpFowr = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF", 7);
      database.datatype.Record recExpFowr = (database.datatype.Record) vDataExpAgent.get(0);
      dbJCBXExpForwr = new exgui.DataBindJCombobox(cmboExpFowr, vDataExpAgent, "BYMKR_BRIEF",
                                        "BYMKR_SEQ", recExpFowr.get("BYMKR_SEQ"),"","");
      cmboExpFowr.setSelectedIndex(0);

      vDataBill = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF", 1);
      database.datatype.Record recBill = (database.datatype.Record) vDataBill.get(0);
      dbJCBXBillTo = new exgui.DataBindJCombobox(cmboBill, vDataBill, "BYMKR_BRIEF",
                                         "BYMKR_SEQ", recBill.get("BYMKR_SEQ"),"","");
      cmboBill.setSelectedIndex(0);

      //vDataShip = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF", 1);
      database.datatype.Record recShip = (database.datatype.Record) vDataBill.get(0);
      dbJCBXShipTo = new exgui.DataBindJCombobox(cmboShip, vDataBill, "BYMKR_BRIEF",
                                        "BYMKR_SEQ", recShip.get("BYMKR_SEQ"),"","");
      cmboShip.setSelectedIndex(0);


      cmboCnty.setSelectedIndex(0);
      cmboEx.setSelectedIndex(0);
      cmboTo.setSelectedIndex(0);
      cmboOceanAir.addItem("");
      cmboOceanAir.addItem("Air");
      cmboOceanAir.addItem("Boat");
      cmboOceanAir.addItem("West-Coast");
    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at Department JComboBox."+
                                 "\ndivision:"+vDataDiv.toString()+
                                 "\nseason:"+vDataSeason.toString()+
                                 "\ncountry:"+vDataCnty.toString());
    }
  }

  void butnTableNew_actionPerformed(ActionEvent e) {
    try {
      if (extTableEditor.getJtable().getRowCount() > 19) {
        exgui2.InfoMessage.warningMessage(new JFrame(),
                                          "Can not more than 20 records.");
      } else {
        extTableEditor.doAddNew();
        this.setTotalAmt2TxtField();
      }
    } catch (Exception eFty) {
      eFty.printStackTrace();
      util.ExceptionLog.exp2File(eFty, "error at new record.\n"+
                      "row counts:"+extTableEditor.getJtable().getRowCount());
    }
  }

  void butnTableDelete_actionPerformed(ActionEvent e) {
    try {
      extTableEditor.doDelete();
      this.setTotalAmt2TxtField();
    } catch (Exception eFty) {
      eFty.printStackTrace();
      util.ExceptionLog.exp2File(eFty, "error at delete record.");
    }
  }

  void butnTableEdit_actionPerformed(ActionEvent e) {
    try {
      extTableEditor.doUpdate();
      this.setTotalAmt2TxtField();
    } catch (Exception eFty) {
      eFty.printStackTrace();
      util.ExceptionLog.exp2File(eFty, "error at edit record.");
    }
  }

  void butnTableCopy_actionPerformed(ActionEvent e) {
    try {
      extTableEditor.doCopy();
    } catch (Exception eFty) {
      eFty.printStackTrace();
      util.ExceptionLog.exp2File(eFty, "error at copy record.");
    }
  }

  void butnTablePaste_actionPerformed(ActionEvent e) {
    try {
      extTableEditor.doPaste();
      this.setTotalAmt2TxtField();
    } catch (Exception eFty) {
      eFty.printStackTrace();
      util.ExceptionLog.exp2File(eFty, "error at paste record.");
    }
  }

  java.util.HashMap getDatas() {
    java.util.HashMap hm = new java.util.HashMap();
    Object[][] rb = {{rb_FLAT, "F"},{rb_GOH, "G"}};
    try {
      hm.put("SC_NO", txtScNo.getText().trim());
      hm.put("SHIP_NO", txtSrnNo.getText());
      hm.put("SHIP_DATE", exgui2.Stuff.dateProcessor(txtYear, txtMonth, txtDay));
      hm.put("SHIP_ETA_DATE", exgui2.Stuff.dateProcessor(txtETA_Y, txtETA_M, txtETA_D));
      hm.put("SHIP_ETD_DATE", exgui2.Stuff.dateProcessor(txtETD_Y, txtETD_M, txtETD_D));
      hm.put("SHIP_IC_DATE", exgui2.Stuff.dateProcessor(txtIC_Y, txtIC_M, txtIC_D));
      hm.put("SHIP_ATTN", txtAttn.getText());
      hm.put("SHIP_TO", txtTo.getText());
      hm.put("SHIP_FM", txtFrom.getText());
      hm.put("SHIP_VIA", txtVia.getText());
      hm.put("SHIP_LC_NO", txtLC.getText());
      hm.put("SHIP_AGENT", txtAgent.getText());
      hm.put("SHIP_VESSEL", txtAreaVessel.getText());
      hm.put("SHIP_GF", exgui2.Stuff.setRadioButtonValues(rb));

      hm.put("SHIP_HAWB", txtHAWB.getText());
      hm.put("SHIP_MAWB", txtMAWB.getText());
      hm.put("SHIP_FLT_NO", txtFLT.getText());
      hm.put("SHIP_USA_PORT", txtPort.getText());
      hm.put("SHIP_DIM_WT", txtDimnetWT.getText()+"."+txtDimnetWT_2.getText());
      hm.put("SHIP_DIM_CTN", txtDimentCTN.getText()+"."+txtDimentCTN_2.getText());
      hm.put("SHIP_CNTY_ORIG", dbJCBXCnty.getSelectedValue().toString());
      hm.put("SHIP_NET_WT", txtNetWT.getText()+"."+txtNetWT_2.getText());
      hm.put("SHIP_GROSS_WT", txtGrossWT.getText()+"."+txtGrossWT_2.getText());
      hm.put("SHIP_FTY_INV", txtInv.getText());
      hm.put("SHIP_IC_SEA", dbJCBXSeason.getSelectedValue().toString());
      hm.put("SHIP_IC_DIV", cmboDiv.getSelectedItem());
      hm.put("SHIP_OCEAN_AIR", cmboOceanAir.getSelectedItem().toString());
      hm.put("SHIP_ETD_EX", dbJCBXEx.getSelectedValue().toString());
      hm.put("SHIP_ETA_TO", dbJCBXTo.getSelectedValue().toString());

      hm.put("SHIP_FRWRDR", dbJCBXExpForwr.getSelectedValue().toString());
      hm.put("SHIP_BILL_TO", dbJCBXBillTo.getSelectedValue().toString());
      hm.put("SHIP_SHIP_TO", dbJCBXShipTo.getSelectedValue().toString());
      hm.put("SHIP_PRC_TRM", (dbJCBXPrxTerm==null)?"":dbJCBXPrxTerm.getSelectedValue().toString());
      hm.put("SHIP_DEST", txtDes.getText());
      hm.put("SHIP_NET_WT_UNIT", txtNetUnit.getText());
      hm.put("SHIP_GROSS_WT_UNIT", txtGrossUnit.getText());
      hm.put("SHIP_NET_NET_WT_UNIT", txtNetNetUnit.getText());
      hm.put("SHIP_NET_NET_WT", txtNetNet.getText()+"."+txtNetNetDot.getText());
      hm.put("SHIP_DIM_WT_UNIT", txtDimUnit.getText());
      hm.put("SHIP_DIM_CUFT", txtCuft.getText());
      hm.put("SHIP_EXPORT_AGENT", dbJCBXExpAgent.getSelectedValue().toString());
    } catch (Exception eData) {
      eData.printStackTrace();
      util.ExceptionLog.exp2File(eData, "error at put datas to HashMap.\n"+
                                 "HashMap datas:"+hm.toString());
    } finally {
      return hm;
    }
  }

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtScNo,null,"",20);
    tx = new exgui.DataBindText(txtAgent,null,"",27);
    tx = new exgui.DataBindText(txtAttn,null,"",27);
    tx = new exgui.DataBindText(txtInv,null,"",25);
    tx = new exgui.DataBindText(txtMAWB,null,"",25);
    tx = new exgui.DataBindText(txtDay,null,"",2);
    tx = new exgui.DataBindText(txtIC_D,null,"",2);
    tx = new exgui.DataBindText(txtDimentCTN,null,"",5);
    tx = new exgui.DataBindText(txtDimentCTN_2,null,"",2);
    tx = new exgui.DataBindText(txtDimnetWT,null,"",6);
    tx = new exgui.DataBindText(txtDimnetWT_2,null,"",2);
    tx = new exgui.DataBindText(txtETA_D,null,"",2);
    tx = new exgui.DataBindText(txtETA_M,null,"",2);
    tx = new exgui.DataBindText(txtETA_Y,null,"",4);
    tx = new exgui.DataBindText(txtETD_D,null,"",2);
    tx = new exgui.DataBindText(txtETD_M,null,"",2);
    tx = new exgui.DataBindText(txtETD_Y,null,"",4);
    tx = new exgui.DataBindText(txtFLT,null,"",25);
    tx = new exgui.DataBindText(txtFrom,null,"",27);
    tx = new exgui.DataBindText(txtGrossWT,null,"",6);
    tx = new exgui.DataBindText(txtGrossWT_2,null,"",2);
    tx = new exgui.DataBindText(txtHAWB,null,"",25);
    tx = new exgui.DataBindText(txtLC,null,"",50);
    tx = new exgui.DataBindText(txtMonth,null,"",2);
    tx = new exgui.DataBindText(txtIC_M,null,"",2);
    tx = new exgui.DataBindText(txtNetWT,null,"",6);
    tx = new exgui.DataBindText(txtNetWT_2,null,"",2);
    tx = new exgui.DataBindText(txtPort,null,"",10);
    tx = new exgui.DataBindText(txtTo,null,"",27);
    tx = new exgui.DataBindText(txtAreaVessel,null,"",70);
    tx = new exgui.DataBindText(txtVia,null,"",27);
    tx = new exgui.DataBindText(txtYear,null,"",4);
    tx = new exgui.DataBindText(txtIC_Y,null,"",4);
    tx = new exgui.DataBindText(txtDes,null,"",20);
    tx = new exgui.DataBindText(txtCuft,null,"",30);
    tx = new exgui.DataBindText(txtDimUnit,null,"",5);
    tx = new exgui.DataBindText(txtNetUnit,null,"",5);
    tx = new exgui.DataBindText(txtGrossUnit,null,"",5);
    tx = new exgui.DataBindText(txtNetNetUnit,null,"",5);
    tx = new exgui.DataBindText(txtNetNet,null,"",6);
    tx = new exgui.DataBindText(txtNetNetDot,null,"",2);
  }

  boolean checkFieldsData() {
    if (txtETD_Y.getText().trim().equals("") || txtETD_M.getText().trim().equals("")
        || txtETD_D.getText().trim().equals("")) {
      exgui2.InfoMessage.warningMessage(new JFrame(), "Must Input ETD Date.");
      return false;
    } else {
      java.util.Vector vYear = new java.util.Vector();
      java.util.Vector vMonth = new java.util.Vector();
      java.util.Vector vDay = new java.util.Vector();

      vYear.add(txtYear.getText().trim());
      vYear.add(txtETD_Y.getText().trim());
      vYear.add(txtETA_Y.getText().trim());
      vYear.add(txtIC_Y.getText().trim());

      vMonth.add(txtMonth.getText().trim());
      vMonth.add(txtETD_M.getText().trim());
      vMonth.add(txtETA_M.getText().trim());
      vMonth.add(txtIC_M.getText().trim());

      vDay.add(txtDay.getText().trim());
      vDay.add(txtETD_D.getText().trim());
      vDay.add(txtETA_D.getText().trim());
      vDay.add(txtIC_D.getText().trim());

      boolean checkDate = exgui2.Stuff.checkDate(vYear, vMonth, vDay);
      if (checkDate)
        return true;
      else
        return false;
    }
  }

  void txtDimnetWT_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtDimnetWT_2.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtDimnetWT.getText());
    }
  }

  void txtDimnetWT_2_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtDimnetWT_2.getText());
  }

  void txtDimentCTN_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtDimentCTN_2.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtDimentCTN.getText());
    }
  }

  void txtDimentCTN_2_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtDimentCTN_2.getText());
  }

  void txtGrossWT_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtGrossWT_2.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtGrossWT.getText());
    }
  }

  void txtGrossWT_2_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtGrossWT_2.getText());
  }

  void txtNetWT_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtNetWT_2.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtNetWT.getText());
    }
  }

  void txtNetWT_2_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtNetWT_2.getText());
  }

  void txtNetNet_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtNetNetDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtNetNet.getText());
    }
  }

  void txtNetNetDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtNetNetDot.getText());
  }
}
