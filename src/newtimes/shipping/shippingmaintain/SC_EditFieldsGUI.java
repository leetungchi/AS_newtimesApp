package newtimes.shipping.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
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

public class SC_EditFieldsGUI extends JPanel {
  static String titleName = "Shipping S/C Edit";
  JLabel jLabel1112 = new JLabel();
  JTextField txtCtInsDot = new JTextField("00");
  JTextField txtScFrt = new JTextField("0");
  JTextField txtCtOth = new JTextField("0");
  JTextField txtScOthDot = new JTextField("00");
  JLabel jLabel14 = new JLabel();
  JTextField txtCtFrt = new JTextField("0");
  JLabel jLabel114 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JTextField txtScFrtDot = new JTextField("00");
  JTextField txtYear = new JTextField();
  JTextField txtScOth = new JTextField("0");
  JLabel jLabel111 = new JLabel();
  JTextField txtCTAmt = new JTextField();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel118 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtScInsDot = new JTextField("00");
  JLabel jLabel5 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField txtCtIns = new JTextField("0");
  JLabel jLabel4 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel116 = new JLabel();
  JTextField txtScNo = new JTextField();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel115 = new JLabel();
  JLabel jLabel1110 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtRange = new JTextField();
  JTextField txtScIns = new JTextField("0");
  JLabel jLabel19 = new JLabel();
  JTextField txtCTPrice = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel112 = new JLabel();
  JTextField txtSrnNo = new JTextField();
  JLabel jLabel120 = new JLabel();
  JTextField txtSCAmt = new JTextField();
  JLabel jLabel22 = new JLabel();
  JTextField txtCtOthDot = new JTextField("00");
  JTextField txtSCComm = new JTextField();
  JLabel jLabel15 = new JLabel();
  JTextField txtCtFrtDot = new JTextField("00");
  JLabel jLabel10 = new JLabel();
  JButton butnListShipDetail = new JButton();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXBuyer = null;
  exgui.DataBindJCombobox dbJCBXFTY = null;
  exgui.DataBindJCombobox dbJCBXMag = null;
  exgui.DataBindJCombobox dbJCBXCnty = null;
  JTextField txtFTY = new JTextField();
  JTextField txtBuyer = new JTextField();
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail_SC");
  String _SHIP_SC_PK = null;
  String _PROD_HEAD_PK = null;
  JTextField txtCen = new JTextField();
  JTextField txtMag = new JTextField();
  JTextField txtSea = new JTextField();
  JTextField txtDep = new JTextField();
  JTextField txtDiv = new JTextField();
  JTextField txtCnty = new JTextField();
  static database.datatype.Record recDetail = null;

  public SC_EditFieldsGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel10.setBounds(new Rectangle(30, 133, 180, 20));
    jLabel10.setText(" Range :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(new Color(10,36,106));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel15.setForeground(Color.white);
    jLabel15.setOpaque(true);
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setText(" SC Commission :");
    jLabel15.setBounds(new Rectangle(30, 283, 180, 20));
    jLabel22.setBounds(new Rectangle(398, 83, 180, 20));
    jLabel22.setText(" Division :");
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setOpaque(true);
    jLabel22.setForeground(new Color(10,36,106));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel120.setBackground(new Color(143, 143, 188));
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel120.setForeground(new Color(10,36,106));
    jLabel120.setOpaque(true);
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setText(" Country :");
    jLabel120.setBounds(new Rectangle(398, 133, 180, 20));
    jLabel112.setBackground(new Color(143, 143, 188));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setOpaque(true);
    jLabel112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel112.setText(" CT Amount :");
    jLabel112.setBounds(new Rectangle(398, 257, 180, 20));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setOpaque(true);
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setText(" Manager :");
    jLabel7.setBounds(new Rectangle(30, 83, 180, 20));
    jLabel19.setBounds(new Rectangle(30, 57, 180, 20));
    jLabel19.setText(" Center :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(Color.white);
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setText("( Year )");
    jLabel2.setBounds(new Rectangle(681, 109, 77, 20));
    jLabel1110.setBounds(new Rectangle(398, 232, 180, 20));
    jLabel1110.setText(" CT Discount :");
    jLabel1110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1110.setOpaque(true);
    jLabel1110.setForeground(Color.white);
    jLabel1110.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1110.setBackground(new Color(143, 143, 188));
    jLabel115.setBackground(new Color(143, 143, 188));
    jLabel115.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel115.setForeground(new Color(10,36,106));
    jLabel115.setOpaque(true);
    jLabel115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel115.setText(" SRN No. :");
    jLabel115.setBounds(new Rectangle(30, 32, 180, 20));
    jLabel13.setBackground(new Color(143, 143, 188));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel13.setForeground(new Color(10,36,106));
    jLabel13.setOpaque(true);
    jLabel13.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel13.setText(" SC Amount :");
    jLabel13.setBounds(new Rectangle(30, 257, 180, 20));
    jLabel3.setBounds(new Rectangle(359, 383, 13, 20));
    jLabel3.setText(".");
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setText(".");
    jLabel1.setBounds(new Rectangle(359, 333, 13, 20));
    jLabel20.setBounds(new Rectangle(398, 158, 180, 20));
    jLabel20.setText(" FTY :");
    jLabel20.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel20.setOpaque(true);
    jLabel20.setForeground(Color.white);
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel20.setBackground(new Color(143, 143, 188));
    jLabel116.setBackground(new Color(143, 143, 188));
    jLabel116.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel116.setForeground(Color.white);
    jLabel116.setOpaque(true);
    jLabel116.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel116.setText(" Season :");
    jLabel116.setBounds(new Rectangle(30, 109, 180, 20));
    jLabel12.setBounds(new Rectangle(30, 333, 180, 20));
    jLabel12.setText(" SC FRT :");
    jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel12.setOpaque(true);
    jLabel12.setForeground(new Color(10,36,106));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel21.setForeground(Color.white);
    jLabel21.setOpaque(true);
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setText(" Year :");
    jLabel21.setBounds(new Rectangle(398, 109, 180, 20));
    jLabel4.setBounds(new Rectangle(727, 332, 13, 20));
    jLabel4.setText(".");
    jLabel4.setForeground(new Color(10,36,106));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel8.setBounds(new Rectangle(359, 358, 13, 20));
    jLabel8.setText(".");
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel5.setBounds(new Rectangle(727, 357, 13, 20));
    jLabel5.setText(".");
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel6.setBounds(new Rectangle(727, 382, 13, 20));
    jLabel6.setText(".");
    jLabel6.setForeground(new Color(10,36,106));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel118.setBackground(new Color(143, 143, 188));
    jLabel118.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel118.setForeground(new Color(10,36,106));
    jLabel118.setOpaque(true);
    jLabel118.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel118.setText(" CT FRT :");
    jLabel118.setBounds(new Rectangle(398, 333, 180, 20));
    jLabel17.setBackground(new Color(143, 143, 188));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setOpaque(true);
    jLabel17.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel17.setText(" SC Other :");
    jLabel17.setBounds(new Rectangle(30, 382, 180, 20));
    jLabel18.setBounds(new Rectangle(398, 382, 180, 20));
    jLabel18.setText(" CT OTHER :");
    jLabel18.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel18.setOpaque(true);
    jLabel18.setForeground(new Color(10,36,106));
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel18.setBackground(new Color(143, 143, 188));
    jLabel111.setBackground(new Color(143, 143, 188));
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel111.setForeground(Color.white);
    jLabel111.setOpaque(true);
    jLabel111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel111.setText(" Department :");
    jLabel111.setBounds(new Rectangle(398, 57, 180, 20));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel9.setForeground(Color.white);
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" Buyer :");
    jLabel9.setBounds(new Rectangle(30, 158, 180, 20));
    jLabel114.setBackground(new Color(143, 143, 188));
    jLabel114.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel114.setForeground(Color.white);
    jLabel114.setOpaque(true);
    jLabel114.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel114.setText(" CT INS :");
    jLabel114.setBounds(new Rectangle(398, 357, 180, 20));
    jLabel14.setBounds(new Rectangle(30, 357, 180, 20));
    jLabel14.setText(" SC INS :");
    jLabel14.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel14.setOpaque(true);
    jLabel14.setForeground(Color.white);
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel14.setBackground(new Color(143, 143, 188));
    jLabel1112.setBounds(new Rectangle(398, 32, 180, 20));
    jLabel1112.setText(" SC No. :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1112.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    txtCtInsDot.setBounds(new Rectangle(705, 291, 24, 20));
    txtCtInsDot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCtInsDot_keyTyped(e);
      }
    });
    txtScFrt.setHorizontalAlignment(SwingConstants.RIGHT);
    txtScFrt.setBounds(new Rectangle(169, 267, 144, 20));
    txtScFrt.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtScFrt_keyTyped(e);
      }
    });
    txtCtOth.setHorizontalAlignment(SwingConstants.RIGHT);
    txtCtOth.setBounds(new Rectangle(548, 316, 144, 20));
    txtCtOth.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCtOth_keyTyped(e);
      }
    });
    txtScOthDot.setBounds(new Rectangle(325, 317, 24, 20));
    txtScOthDot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtScOthDot_keyTyped(e);
      }
    });
    jLabel14.setBounds(new Rectangle(13, 291, 155, 20));
    txtCtFrt.setHorizontalAlignment(SwingConstants.RIGHT);
    txtCtFrt.setBounds(new Rectangle(548, 266, 144, 20));
    txtCtFrt.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCtFrt_keyTyped(e);
      }
    });
    jLabel114.setBounds(new Rectangle(392, 291, 155, 20));
    jLabel9.setBounds(new Rectangle(392, 142, 155, 20));
    txtScFrtDot.setBounds(new Rectangle(325, 267, 24, 20));
    txtScFrtDot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtScFrtDot_keyTyped(e);
      }
    });
    txtYear.setEnabled(false);
    txtYear.setDoubleBuffered(false);
    txtYear.setEditable(false);
    txtYear.setBounds(new Rectangle(548, 93, 98, 20));
    txtScOth.setHorizontalAlignment(SwingConstants.RIGHT);
    txtScOth.setBounds(new Rectangle(169, 317, 144, 20));
    txtScOth.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtScOth_keyTyped(e);
      }
    });
    jLabel111.setBounds(new Rectangle(392, 41, 155, 20));
    txtCTAmt.setEnabled(false);
    txtCTAmt.setEditable(false);
    txtCTAmt.setBounds(new Rectangle(548, 191, 209, 20));
    jLabel18.setBounds(new Rectangle(392, 316, 155, 20));
    jLabel17.setBounds(new Rectangle(13, 316, 155, 20));
    jLabel118.setBounds(new Rectangle(392, 267, 155, 20));
    jLabel6.setBounds(new Rectangle(696, 316, 13, 20));
    txtScInsDot.setBounds(new Rectangle(325, 292, 24, 20));
    txtScInsDot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtScInsDot_keyTyped(e);
      }
    });
    jLabel5.setBounds(new Rectangle(696, 291, 13, 20));
    jLabel8.setBounds(new Rectangle(316, 292, 13, 20));
    txtCtIns.setHorizontalAlignment(SwingConstants.RIGHT);
    txtCtIns.setBounds(new Rectangle(548, 291, 144, 20));
    txtCtIns.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCtIns_keyTyped(e);
      }
    });
    jLabel4.setBounds(new Rectangle(696, 266, 13, 20));
    jLabel21.setBounds(new Rectangle(392, 93, 155, 20));
    jLabel12.setBounds(new Rectangle(13, 267, 155, 20));
    jLabel116.setBounds(new Rectangle(13, 93, 155, 20));
    txtScNo.setEnabled(false);
    txtScNo.setEditable(false);
    txtScNo.setBounds(new Rectangle(548, 16, 209, 20));
    jLabel20.setBounds(new Rectangle(13, 142, 155, 20));
    jLabel1.setBounds(new Rectangle(316, 267, 13, 20));
    jLabel3.setBounds(new Rectangle(316, 317, 13, 20));
    jLabel13.setBounds(new Rectangle(13, 191, 155, 20));
    jLabel115.setBounds(new Rectangle(13, 16, 155, 20));
    jLabel1110.setBounds(new Rectangle(392, 216, 155, 20));
    jLabel2.setBounds(new Rectangle(653, 93, 52, 20));
    txtRange.setEnabled(false);
    txtRange.setDoubleBuffered(false);
    txtRange.setEditable(false);
    txtRange.setBounds(new Rectangle(169, 117, 209, 20));
    txtScIns.setHorizontalAlignment(SwingConstants.RIGHT);
    txtScIns.setBounds(new Rectangle(169, 292, 144, 20));
    txtScIns.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtScIns_keyTyped(e);
      }
    });
    jLabel19.setBounds(new Rectangle(13, 41, 155, 20));
    txtCTPrice.setEnabled(false);
    txtCTPrice.setEditable(false);
    txtCTPrice.setBounds(new Rectangle(548, 216, 209, 20));
    jLabel7.setBounds(new Rectangle(13, 67, 155, 20));
    jLabel112.setBounds(new Rectangle(392, 191, 155, 20));
    txtSrnNo.setEnabled(false);
    txtSrnNo.setEditable(false);
    txtSrnNo.setBounds(new Rectangle(169, 16, 209, 20));
    jLabel120.setBounds(new Rectangle(392, 117, 155, 20));
    txtSCAmt.setEnabled(false);
    txtSCAmt.setEditable(false);
    txtSCAmt.setBounds(new Rectangle(169, 191, 209, 20));
    jLabel22.setBounds(new Rectangle(392, 67, 155, 20));
    txtCtOthDot.setBounds(new Rectangle(705, 316, 24, 20));
    txtCtOthDot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCtOthDot_keyTyped(e);
      }
    });
    txtSCComm.setEnabled(false);
    txtSCComm.setEditable(false);
    txtSCComm.setBounds(new Rectangle(169, 216, 209, 20));
    jLabel15.setBounds(new Rectangle(13, 216, 155, 20));
    txtCtFrtDot.setBounds(new Rectangle(705, 266, 24, 20));
    txtCtFrtDot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCtFrtDot_keyTyped(e);
      }
    });
    jLabel10.setBounds(new Rectangle(13, 117, 155, 20));
    jLabel1112.setBounds(new Rectangle(392, 16, 155, 20));
    butnListShipDetail.setText("List Ship Detail");
    butnListShipDetail.setForeground(Color.darkGray);
    butnListShipDetail.setFont(new java.awt.Font("Dialog", 1, 13));
    butnListShipDetail.setBounds(new Rectangle(321, 434, 131, 25));
    butnListShipDetail.setBackground(Color.lightGray);
    txtFTY.setEnabled(false);
    txtFTY.setEditable(false);
    txtFTY.setBounds(new Rectangle(169, 142, 209, 20));
    txtBuyer.setEnabled(false);
    txtBuyer.setEditable(false);
    txtBuyer.setBounds(new Rectangle(548, 142, 209, 20));
    txtCen.setEnabled(false);
    txtCen.setEditable(false);
    txtCen.setText("");
    txtCen.setBounds(new Rectangle(169, 41, 209, 20));
    txtMag.setEnabled(false);
    txtMag.setEditable(false);
    txtMag.setText("");
    txtMag.setBounds(new Rectangle(169, 67, 209, 20));
    txtSea.setEnabled(false);
    txtSea.setEditable(false);
    txtSea.setText("");
    txtSea.setBounds(new Rectangle(169, 93, 209, 20));
    txtDep.setEnabled(false);
    txtDep.setEditable(false);
    txtDep.setText("");
    txtDep.setBounds(new Rectangle(548, 41, 209, 20));
    txtDiv.setEnabled(false);
    txtDiv.setEditable(false);
    txtDiv.setText("");
    txtDiv.setBounds(new Rectangle(548, 67, 209, 20));
    txtCnty.setEnabled(false);
    txtCnty.setEditable(false);
    txtCnty.setBounds(new Rectangle(548, 117, 209, 20));
    this.add(jLabel115, null);
    this.add(jLabel9, null);
    this.add(txtYear, null);
    this.add(jLabel111, null);
    this.add(txtCTAmt, null);
    this.add(jLabel21, null);
    this.add(jLabel116, null);
    this.add(jLabel20, null);
    this.add(jLabel13, null);
    this.add(jLabel1110, null);
    this.add(txtRange, null);
    this.add(jLabel19, null);
    this.add(txtCTPrice, null);
    this.add(jLabel7, null);
    this.add(jLabel112, null);
    this.add(jLabel120, null);
    this.add(txtSCAmt, null);
    this.add(jLabel22, null);
    this.add(txtSCComm, null);
    this.add(jLabel15, null);
    this.add(jLabel10, null);
    this.add(txtSrnNo, null);
    this.add(jLabel1112, null);
    this.add(txtScNo, null);
    this.add(jLabel2, null);
    this.add(butnListShipDetail, null);
    this.add(jLabel12, null);
    this.add(txtCtInsDot, null);
    this.add(txtCtOth, null);
    this.add(txtScOthDot, null);
    this.add(jLabel14, null);
    this.add(txtCtFrt, null);
    this.add(jLabel114, null);
    this.add(txtScOth, null);
    this.add(jLabel18, null);
    this.add(jLabel17, null);
    this.add(jLabel118, null);
    this.add(jLabel6, null);
    this.add(txtScInsDot, null);
    this.add(jLabel5, null);
    this.add(jLabel8, null);
    this.add(txtCtIns, null);
    this.add(jLabel3, null);
    this.add(txtScIns, null);
    this.add(txtCtOthDot, null);
    this.add(txtScFrt, null);
    this.add(txtScFrtDot, null);
    this.add(jLabel1, null);
    this.add(jLabel4, null);
    this.add(txtCtFrtDot, null);
    this.add(txtFTY, null);
    this.add(txtBuyer, null);
    this.add(txtCen, null);
    this.add(txtMag, null);
    this.add(txtSea, null);
    this.add(txtDep, null);
    this.add(txtDiv, null);
    this.add(txtCnty, null);
    this.setData2Fields();
  }

  void setData2Fields() {
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      this._SHIP_SC_PK = recDetail.get("SHIP_SC_PK").toString();
      this._PROD_HEAD_PK = recDetail.get("PROD_HEAD_PK").toString();
      txtSrnNo.setText(recDetail.get("SRN_NO")==null?"":recDetail.get("SRN_NO").toString());
      txtScNo.setText(recDetail.get("SC_NO")==null?"":recDetail.get("SC_NO").toString());
      txtYear.setText(recDetail.get("YEAR")==null?"":recDetail.get("YEAR").toString());
      txtRange.setText(recDetail.get("RANGE")==null?"":recDetail.get("RANGE").toString());
      txtFTY.setText(recDetail.get("FTY")==null?"":recDetail.get("FTY").toString());
      txtBuyer.setText(recDetail.get("BUYER")==null?"":recDetail.get("BUYER").toString());
      txtSCAmt.setText(recDetail.get("SC_AMT")==null?"":recDetail.get("SC_AMT").toString());
      txtSCComm.setText(recDetail.get("SC_COMM")==null?"":recDetail.get("SC_COMM").toString());
      txtCTAmt.setText(recDetail.get("CT_AMT")==null?"":recDetail.get("CT_AMT").toString());
      txtCTPrice.setText(recDetail.get("CT_DISC")==null?"":recDetail.get("CT_DISC").toString());
      txtCen.setText(recDetail.get("CENTER")==null?"":recDetail.get("CENTER").toString());
      txtDep.setText(recDetail.get("DEPARTMENT")==null?"":recDetail.get("DEPARTMENT").toString());
      txtMag.setText(recDetail.get("MANAGER")==null?"":recDetail.get("MANAGER").toString());
      txtDiv.setText(recDetail.get("DIVISION")==null?"":recDetail.get("DIVISION").toString());
      txtSea.setText(recDetail.get("SEA")==null?"":recDetail.get("SEA").toString());
      txtCnty.setText(recDetail.get("COUNTRY")==null?"":recDetail.get("COUNTRY").toString());

      JTextField[] txtFields = null;
      java.util.Vector vScFrt = exgui2.Stuff.splitString(
          recDetail.get("SC_FRT")==null?"0.00":recDetail.get("SC_FRT").toString(),".");
      txtFields = new JTextField[] {txtScFrt, txtScFrtDot};
      exgui2.Stuff.setNo2Txt(txtFields, vScFrt);

      java.util.Vector vScIns = exgui2.Stuff.splitString(
          recDetail.get("SC_INS")==null?"0.00":recDetail.get("SC_INS").toString(),".");
      txtFields = new JTextField[] {txtScIns, txtScInsDot};
      exgui2.Stuff.setNo2Txt(txtFields, vScIns);

      java.util.Vector vScOth = exgui2.Stuff.splitString(
          recDetail.get("SC_OTHER")==null?"0.00":recDetail.get("SC_OTHER").toString(),".");
      txtFields = new JTextField[] {txtScOth, txtScOthDot};
      exgui2.Stuff.setNo2Txt(txtFields, vScOth);

      java.util.Vector vCtFrt = exgui2.Stuff.splitString(
          recDetail.get("CT_FRT")==null?"0.00":recDetail.get("CT_FRT").toString(),".");
      txtFields = new JTextField[] {txtCtFrt, txtCtFrtDot};
      exgui2.Stuff.setNo2Txt(txtFields, vCtFrt);

      java.util.Vector vCtIns = exgui2.Stuff.splitString(
          recDetail.get("CT_INS")==null?"0.00":recDetail.get("CT_INS").toString(),".");
      txtFields = new JTextField[] {txtCtIns, txtCtInsDot};
      exgui2.Stuff.setNo2Txt(txtFields, vCtIns);

      java.util.Vector vCtOth = exgui2.Stuff.splitString(
          recDetail.get("CT_OTHER")==null?"0.00":recDetail.get("CT_OTHER").toString(),".");
      txtFields = new JTextField[] {txtCtOth, txtCtOthDot};
      exgui2.Stuff.setNo2Txt(txtFields, vCtOth);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at set data to fields.\nrecord:"+recDetail.toString());
    }
  }

  java.util.HashMap getDatas() {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      hm.put("SHIP_SC_PK", this._SHIP_SC_PK);
      hm.put("SHIP_NO", txtSrnNo.getText());
      hm.put("PROD_HEAD_PK", this._PROD_HEAD_PK);
      hm.put("SC_FRT", (txtScFrt.getText().trim().equals("")?
             "0":txtScFrt.getText().trim())+"."+txtScFrtDot.getText().trim());
      hm.put("CT_FRT", (txtCtFrt.getText().trim().equals("")?
             "0":txtCtFrt.getText().trim())+"."+txtCtFrtDot.getText().trim());
      hm.put("SC_INS", (txtScIns.getText().trim().equals("")?
             "0":txtScIns.getText().trim())+"."+txtScInsDot.getText().trim());
      hm.put("CT_INS", (txtCtIns.getText().trim().equals("")?
             "0":txtCtIns.getText().trim())+"."+txtCtInsDot.getText().trim());
      hm.put("SC_OTHER", (txtScOth.getText().trim().equals("")?
             "0":txtScOth.getText().trim())+"."+txtScOthDot.getText().trim());
      hm.put("CT_OTHER", (txtCtOth.getText().trim().equals("")?
             "0":txtCtOth.getText().trim())+"."+txtCtOthDot.getText().trim());
    } catch (Exception eData) {
      eData.printStackTrace();
      util.ExceptionLog.exp2File(eData, "error at put datas to HashMap.");
    } finally {
      return hm;
    }
  }

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtSrnNo, null, "", 15);
    tx = new exgui.DataBindText(txtScNo, null, "", 20);
    tx = new exgui.DataBindText(txtYear, null, "", 4);
    tx = new exgui.DataBindText(txtRange, null, "", 40);
    tx = new exgui.DataBindText(txtScFrt, null, "", 8);
    tx = new exgui.DataBindText(txtScFrtDot, null, "", 2);
    tx = new exgui.DataBindText(txtScIns, null, "", 8);
    tx = new exgui.DataBindText(txtScInsDot, null, "", 2);
    tx = new exgui.DataBindText(txtScOth, null, "", 8);
    tx = new exgui.DataBindText(txtScOthDot, null, "", 2);
    tx = new exgui.DataBindText(txtCtFrt, null, "", 8);
    tx = new exgui.DataBindText(txtCtFrtDot, null, "", 2);
    tx = new exgui.DataBindText(txtCtIns, null, "", 8);
    tx = new exgui.DataBindText(txtCtInsDot, null, "", 2);
    tx = new exgui.DataBindText(txtCtOth, null, "", 8);
    tx = new exgui.DataBindText(txtCtOthDot, null, "", 2);
  }

  void txtScFrt_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtScFrtDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtScFrt.getText());
    }
  }

  void txtScFrtDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtScFrtDot.getText());
  }

  void txtScIns_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtScInsDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtScIns.getText());
    }
  }

  void txtScInsDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtScInsDot.getText());
  }

  void txtScOth_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtScOthDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtScOth.getText());
    }
  }

  void txtScOthDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtScOthDot.getText());
  }

  void txtCtFrt_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtCtFrtDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtCtFrt.getText());
    }
  }

  void txtCtFrtDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtCtFrtDot.getText());
  }

  void txtCtIns_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtCtInsDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtCtIns.getText());
    }
  }

  void txtCtInsDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtCtInsDot.getText());
  }

  void txtCtOth_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtCtOthDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtCtOth.getText());
    }
  }

  void txtCtOthDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtCtOthDot.getText());
  }
}
