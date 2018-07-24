package newtimes.shipping.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ShipDetailEditGUI extends JPanel {
  JPanel jPanel1 = new JPanel();

  //PrxTableEditor prxTableEditor = new PrxTableEditor();
  //QtyTableEditor qtyTableEditor = new QtyTableEditor();
   Jcmp_PrxList prxTableEditor=new Jcmp_PrxList();
   Jcmp_QtyList qtyTableEditor=new Jcmp_QtyList();
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  exgui.DataBindJCombobox dbJCBXFTY = null;
  JTextField txtTotalNegoAmt = new JTextField();
  JPanel jPanel5 = new JPanel();
  JTextField txtShipQTY = new JTextField();
  JTextField txtStyQty = new JTextField();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtRange = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField txtScNo = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel115 = new JLabel();
  JTextField txtBuy = new JTextField();
  JTextField txtMDPer = new JTextField();
  JTextField txtMDD = new JTextField();
  JLabel jLabel1111 = new JLabel();
  JTextField txtMDPc = new JTextField();
  JLabel jLabel120 = new JLabel();
  JTextField txtPO = new JTextField();
  JLabel jLabel22 = new JLabel();
  JTextField txtStyle = new JTextField();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtUnit = new JTextField();
  JLabel jLabel13 = new JLabel();
  JTextField txtMDLS = new JTextField();
  JComboBox cmboPCB = new JComboBox();
  JTextField txtBuy_Dot = new JTextField();
  JLabel jLabel16 = new JLabel();
  JTextField txtMDPc_Dot = new JTextField();
  JLabel jLabel17 = new JLabel();
  JTextField txtMDLS_Dot = new JTextField();
  JLabel jLabel111 = new JLabel();
  JTextField txtMDPer_Dot = new JTextField();
  JLabel jLabel112 = new JLabel();
  JTextField txtMDD_Dot = new JTextField();
  JLabel jLabel113 = new JLabel();
  JTextField txtFTY = new JTextField();
  JTextField txtDiv = new JTextField();
  JTextField txtSea = new JTextField();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel6 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  JButton butn_QTY_New = new JButton();
  JButton butn_QTY_Delete = new JButton();
  JButton butn_QTY_Edit = new JButton();
  JButton butn_prx_New = new JButton();
  JButton butn_prx_Delete = new JButton();
  JButton butn_prx_Edit = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JTextArea txtOdrStyQtyDesc = new JTextArea();

  public ShipDetailEditGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setLayout(null);
    this.setLayout(gridBagLayout1);
    this.setSize(new Dimension(763, 757));
    this.setPreferredSize(new Dimension(763, 757));
    this.setBackground(new Color(204, 204, 225));
    txtTotalNegoAmt.setBounds(new Rectangle(477, 171, 148, 20));
    txtTotalNegoAmt.setHorizontalAlignment(SwingConstants.RIGHT);
    txtTotalNegoAmt.setEditable(false);
    txtTotalNegoAmt.setForeground(Color.black);
    txtTotalNegoAmt.setFont(new java.awt.Font("Dialog", 1, 12));
    txtTotalNegoAmt.setBounds(new Rectangle(583, 508, 180, 20));
    jPanel5.setBorder(BorderFactory.createTitledBorder(" Ship Style QTY & Price "));
    jPanel5.setBackground(new Color(204, 204, 225));
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(11, 259, 744, 484));
    txtShipQTY.setBounds(new Rectangle(167, 416, 209, 20));
    txtShipQTY.setEnabled(false);
    txtShipQTY.setEditable(false);
    txtShipQTY.setBounds(new Rectangle(516, 176, 209, 20));
    txtStyQty.setBounds(new Rectangle(214, 508, 180, 20));
    txtStyQty.setEnabled(false);
    txtStyQty.setEditable(false);
    txtStyQty.setBounds(new Rectangle(148, 176, 209, 20));
    jLabel18.setBounds(new Rectangle(10, 176, 136, 20));
    jLabel18.setText(" Style QTY :");
    jLabel18.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel18.setOpaque(true);
    jLabel18.setForeground(new Color(10,36,106));
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel18.setBackground(new Color(143, 143, 188));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(new Color(10, 36, 106));
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Shipped QTY. :");
    jLabel110.setBounds(new Rectangle(372, 176, 142, 20));
    jPanel2.setBounds(new Rectangle(11, 1, 744, 83));
    jPanel2.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Production Data "));
    jPanel3.setBounds(new Rectangle(12, 86, 744, 173));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Ship Style Data "));
    jLabel21.setBounds(new Rectangle(461, 52, 76, 20));
    jLabel21.setText(" Range :");
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setOpaque(true);
    jLabel21.setForeground(Color.white);
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setText("( Year )");
    jLabel2.setBounds(new Rectangle(681, 109, 77, 20));
    jLabel2.setBounds(new Rectangle(191, 52, 52, 20));
    txtRange.setBounds(new Rectangle(583, 79, 180, 20));
    txtRange.setEnabled(false);
    txtRange.setEditable(false);
    txtRange.setBounds(new Rectangle(537, 52, 134, 20));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" S / C No. :");
    jLabel9.setBounds(new Rectangle(217, 23, 78, 20));
    txtYear.setEnabled(false);
    txtYear.setEditable(false);
    txtYear.setBounds(new Rectangle(80, 52, 98, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Division :");
    jLabel19.setBounds(new Rectangle(463, 24, 79, 20));
    jLabel7.setBounds(new Rectangle(243, 52, 74, 20));
    jLabel7.setText(" Season :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(Color.white);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    txtScNo.setBounds(new Rectangle(583, 148, 180, 20));
    txtScNo.setEnabled(false);
    txtScNo.setEditable(false);
    txtScNo.setBounds(new Rectangle(295, 23, 150, 20));
    jLabel15.setBounds(new Rectangle(15, 24, 65, 20));
    jLabel15.setText(" FTY :");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Year :");
    jLabel10.setBounds(new Rectangle(15, 52, 66, 20));
    jLabel1112.setBounds(new Rectangle(382, 25, 136, 20));
    jLabel1112.setText(" PO :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setForeground(Color.white);
    jLabel12.setOpaque(true);
    jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel12.setText("MKR DSCT UNIT :");
    jLabel12.setBounds(new Rectangle(14, 109, 136, 20));
    jLabel20.setBackground(new Color(143, 143, 188));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel20.setForeground(new Color(10,36,106));
    jLabel20.setOpaque(true);
    jLabel20.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel20.setText(" MKR DSCT Per :");
    jLabel20.setBounds(new Rectangle(382, 81, 136, 20));
    jLabel115.setBackground(new Color(143, 143, 188));
    jLabel115.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel115.setForeground(new Color(10,36,106));
    jLabel115.setOpaque(true);
    jLabel115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel115.setText(" Buy COMM :");
    jLabel115.setBounds(new Rectangle(14, 81, 136, 20));
    txtBuy.setBounds(new Rectangle(214, 194, 180, 20));
    txtBuy.setText("0");
    txtBuy.setHorizontalAlignment(SwingConstants.RIGHT);
    txtBuy.setBounds(new Rectangle(152, 81, 65, 20));
    txtBuy.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtBuy_keyTyped(e);
      }
    });
    txtMDPer.setBounds(new Rectangle(583, 125, 180, 20));
    txtMDPer.setToolTipText("");
    txtMDPer.setText("0");
    txtMDPer.setHorizontalAlignment(SwingConstants.RIGHT);
    txtMDPer.setBounds(new Rectangle(520, 81, 65, 20));
    txtMDPer.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDPer_keyTyped(e);
      }
    });
    txtMDD.setBounds(new Rectangle(546, 173, 209, 20));
    txtMDD.setText("0");
    txtMDD.setHorizontalAlignment(SwingConstants.RIGHT);
    txtMDD.setBounds(new Rectangle(520, 109, 65, 20));
    txtMDD.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDD_keyTyped(e);
      }
    });
    jLabel1111.setBounds(new Rectangle(382, 109, 136, 20));
    jLabel1111.setText(" MKR DSCT DZ :");
    jLabel1111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1111.setOpaque(true);
    jLabel1111.setForeground(Color.white);
    jLabel1111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1111.setBackground(new Color(143, 143, 188));
    txtMDPc.setBounds(new Rectangle(214, 286, 180, 20));
    txtMDPc.setText("0");
    txtMDPc.setHorizontalAlignment(SwingConstants.RIGHT);
    txtMDPc.setBounds(new Rectangle(152, 109, 65, 20));
    txtMDPc.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDPc_keyTyped(e);
      }
    });
    jLabel120.setBounds(new Rectangle(14, 25, 136, 20));
    jLabel120.setText(" Style :");
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setOpaque(true);
    jLabel120.setForeground(new Color(10,36,106));
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel120.setBackground(new Color(143, 143, 188));
    txtPO.setBounds(new Rectangle(583, 10, 180, 20));
    txtPO.setEnabled(false);
    txtPO.setEditable(false);
    txtPO.setBounds(new Rectangle(520, 25, 209, 20));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setForeground(Color.white);
    jLabel22.setOpaque(true);
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setText(" P / B / C :");
    jLabel22.setBounds(new Rectangle(382, 53, 136, 20));
    txtStyle.setBounds(new Rectangle(583, 102, 180, 20));
    txtStyle.setEnabled(false);
    txtStyle.setEditable(false);
    txtStyle.setBounds(new Rectangle(152, 25, 209, 20));
    jLabel23.setBounds(new Rectangle(14, 53, 136, 20));
    jLabel23.setText(" Unit :");
    jLabel23.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel23.setOpaque(true);
    jLabel23.setForeground(Color.white);
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel23.setBackground(new Color(143, 143, 188));
    jLabel3.setBounds(new Rectangle(631, 53, 52, 20));
    jLabel3.setBounds(new Rectangle(309, 53, 52, 20));
    jLabel3.setText("( PCS )");
    jLabel3.setForeground(new Color(143, 143, 188));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    txtUnit.setEnabled(false);
    txtUnit.setEditable(false);
    txtUnit.setBounds(new Rectangle(152, 53, 147, 20));
    jLabel13.setBounds(new Rectangle(14, 137, 136, 20));
    jLabel13.setText(" MKR DSCT Lump SUM :");
    jLabel13.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel13.setOpaque(true);
    jLabel13.setForeground(new Color(10,36,106));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setBackground(new Color(143, 143, 188));
    txtMDLS.setBounds(new Rectangle(152, 108, 209, 20));
    txtMDLS.setToolTipText("");
    txtMDLS.setText("0");
    txtMDLS.setHorizontalAlignment(SwingConstants.RIGHT);
    txtMDLS.setBounds(new Rectangle(152, 137, 65, 20));
    txtMDLS.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDLS_keyTyped(e);
      }
    });
    cmboPCB.setBounds(new Rectangle(520, 53, 51, 20));
    cmboPCB.setBackground(Color.white);
    txtBuy_Dot.setText("00");
    txtBuy_Dot.setBounds(new Rectangle(230, 81, 23, 20));
    txtBuy_Dot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtBuy_Dot_keyTyped(e);
      }
    });
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel16.setForeground(new Color(10,36,106));
    jLabel16.setText(".");
    jLabel16.setBounds(new Rectangle(221, 81, 11, 20));
    txtMDPc_Dot.setBounds(new Rectangle(230, 109, 23, 20));
    txtMDPc_Dot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDPc_Dot_keyTyped(e);
      }
    });
    txtMDPc_Dot.setText("00");
    jLabel17.setBounds(new Rectangle(221, 109, 11, 20));
    jLabel17.setText(".");
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 18));
    txtMDLS_Dot.setBounds(new Rectangle(230, 137, 23, 20));
    txtMDLS_Dot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDLS_Dot_keyTyped(e);
      }
    });
    txtMDLS_Dot.setText("00");
    jLabel111.setBounds(new Rectangle(221, 137, 11, 20));
    jLabel111.setText(".");
    jLabel111.setForeground(new Color(10,36,106));
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 18));
    txtMDPer_Dot.setBounds(new Rectangle(597, 81, 23, 20));
    txtMDPer_Dot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDPer_Dot_keyTyped(e);
      }
    });
    txtMDPer_Dot.setText("00");
    jLabel112.setBounds(new Rectangle(588, 81, 11, 20));
    jLabel112.setText(".");
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 18));
    txtMDD_Dot.setBounds(new Rectangle(597, 109, 23, 20));
    txtMDD_Dot.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtMDD_Dot_keyTyped(e);
      }
    });
    txtMDD_Dot.setText("00");
    jLabel113.setBounds(new Rectangle(588, 109, 11, 20));
    jLabel113.setText(".");
    jLabel113.setForeground(new Color(10,36,106));
    jLabel113.setFont(new java.awt.Font("Dialog", 1, 18));
    txtFTY.setEnabled(false);
    txtFTY.setEditable(false);
    txtFTY.setBounds(new Rectangle(80, 24, 106, 21));
    txtDiv.setEnabled(false);
    txtDiv.setEditable(false);
    txtDiv.setBounds(new Rectangle(542, 24, 132, 21));
    txtSea.setEnabled(false);
    txtSea.setEditable(false);
    txtSea.setBounds(new Rectangle(316, 52, 128, 21));
    jTabbedPane1.setBounds(new Rectangle(10, 206, 715, 265));
    jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        jTabbedPane1_stateChanged(e);
      }
    });
    jPanel4.setLayout(null);
    jPanel6.setLayout(null);
    qtyTableEditor.setBounds(new Rectangle(0, 0, 710, 243));
    prxTableEditor.setBounds(new Rectangle(0, 0, 710, 243));
    butn_QTY_New.setText("New");
    butn_QTY_New.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_QTY_New.setBounds(new Rectangle(2, 213, 79, 24));
    butn_QTY_Delete.setText("Delete");
    butn_QTY_Delete.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_QTY_Delete.setBounds(new Rectangle(168, 213, 79, 24));
    butn_QTY_Edit.setText("Save");
    butn_QTY_Edit.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_QTY_Edit.setBounds(new Rectangle(85, 213, 79, 24));
    butn_prx_New.setBounds(new Rectangle(2, 213, 79, 24));
    butn_prx_New.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_prx_New.setText("New");
    butn_prx_Delete.setBounds(new Rectangle(168, 213, 79, 24));
    butn_prx_Delete.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_prx_Delete.setText("Delete");
    butn_prx_Edit.setBounds(new Rectangle(85, 213, 79, 24));
    butn_prx_Edit.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_prx_Edit.setText("Save");
    butn_prx_Edit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_prx_Edit_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(12, 38, 706, 127));
    jLabel1.setText("Order Qty");
    jLabel1.setBounds(new Rectangle(12, 19, 115, 15));
    txtOdrStyQtyDesc.setBackground(Color.lightGray);
    txtOdrStyQtyDesc.setEditable(false);
    txtOdrStyQtyDesc.setText("");
    txtOdrStyQtyDesc.setFont(new java.awt.Font("DialogInput", 0, 12));
    jPanel3.add(jLabel20, null);
    jPanel3.add(txtMDPer, null);
    jPanel3.add(txtMDD, null);
    jPanel3.add(jLabel1111, null);
    jPanel3.add(jLabel22, null);
    jPanel3.add(jLabel120, null);
    jPanel3.add(txtStyle, null);
    jPanel3.add(jLabel1112, null);
    jPanel3.add(txtPO, null);
    jPanel3.add(jLabel23, null);
    jPanel3.add(txtUnit, null);
    jPanel3.add(jLabel3, null);
    jPanel3.add(txtMDPc, null);
    jPanel3.add(jLabel115, null);
    jPanel3.add(txtBuy, null);
    jPanel3.add(jLabel12, null);
    jPanel3.add(jLabel13, null);
    jPanel3.add(txtMDLS, null);
    jPanel3.add(cmboPCB, null);
    jPanel3.add(txtBuy_Dot, null);
    jPanel3.add(jLabel16, null);
    jPanel3.add(txtMDPc_Dot, null);
    jPanel3.add(jLabel17, null);
    jPanel3.add(txtMDLS_Dot, null);
    jPanel3.add(jLabel111, null);
    jPanel3.add(jLabel113, null);
    jPanel3.add(txtMDD_Dot, null);
    jPanel3.add(txtMDPer_Dot, null);
    jPanel3.add(jLabel112, null);
    jPanel1.add(jPanel5, null);
    jPanel1.add(jPanel2, null);
    jPanel2.add(jLabel15, null);
    jPanel2.add(txtFTY, null);
    jPanel2.add(jLabel19, null);
    jPanel2.add(txtDiv, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(txtScNo, null);
    jPanel2.add(jLabel10, null);
    jPanel2.add(txtYear, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(txtSea, null);
    jPanel2.add(jLabel21, null);
    jPanel2.add(txtRange, null);
    jPanel1.add(jPanel3, null);
    this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(8, 0, 4, 1), 761, 635));
    jPanel4.add(butn_QTY_Edit, null);
    jPanel4.add(butn_QTY_Delete, null);
    jPanel4.add(butn_QTY_New, null);
    jPanel4.add(qtyTableEditor, null);
    jTabbedPane1.add(jPanel6, "Price");
    jTabbedPane1.add(jPanel4, "QTY");
    jPanel6.add(butn_prx_Edit, null);
    jPanel6.add(butn_prx_Delete, null);
    jPanel6.add(butn_prx_New, null);
    jPanel6.add(prxTableEditor, null);
    jPanel5.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtOdrStyQtyDesc, null);
    jPanel5.add(jLabel1, null);
    jPanel5.add(jLabel18, null);
    jPanel5.add(txtStyQty, null);
    jPanel5.add(jLabel110, null);
    jPanel5.add(txtShipQTY, null);
    jPanel5.add(jTabbedPane1, null);
    this.setCmboPCB();
    butn_prx_New.setEnabled(false);
    butn_prx_Delete.setEnabled(false);
    if(Shipping_Const.EDITING_STHIPING_STYLE_QDR_QTY!=null){
      txtOdrStyQtyDesc.setText(Shipping_Const.EDITING_STHIPING_STYLE_QDR_QTY);
    }else{
      txtOdrStyQtyDesc.setText("");
    }
  }

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtBuy,null,"",2);
    tx = new exgui.DataBindText(txtBuy_Dot,null,"",2);
    tx = new exgui.DataBindText(txtMDPer,null,"",3);
    tx = new exgui.DataBindText(txtMDPer_Dot,null,"",2);
    tx = new exgui.DataBindText(txtMDPc,null,"",3);
    tx = new exgui.DataBindText(txtMDPc_Dot,null,"",2);
    tx = new exgui.DataBindText(txtMDD,null,"",3);
    tx = new exgui.DataBindText(txtMDD_Dot,null,"",2);
    tx = new exgui.DataBindText(txtMDLS,null,"",8);
    tx = new exgui.DataBindText(txtMDLS_Dot,null,"",2);
  }

  void setCmboPCB() {
    cmboPCB.addItem("");
    cmboPCB.addItem("P");
    cmboPCB.addItem("B");
    cmboPCB.addItem("C");
  }

  void txtBuy_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtBuy_Dot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtBuy.getText());
    }
  }

  void txtBuy_Dot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtBuy_Dot.getText());
  }

  void txtMDPc_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtMDPc_Dot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtMDPc.getText());
    }
  }

  void txtMDPc_Dot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtMDPc_Dot.getText());
  }

  void txtMDLS_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtMDLS_Dot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtMDLS.getText());
    }
  }

  void txtMDLS_Dot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtMDLS_Dot.getText());
  }

  void txtMDPer_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtMDPer_Dot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtMDPer.getText());
    }
  }

  void txtMDPer_Dot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtMDPer_Dot.getText());
  }

  void txtMDD_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtMDD_Dot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtMDD.getText());
    }
  }

  void txtMDD_Dot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtMDD_Dot.getText());
  }

  void butn_prx_Edit_actionPerformed(ActionEvent e) {
    try {
      prxTableEditor.doUpdate();
    } catch(Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, "error at update prices.");
    }
  }

  void jTabbedPane1_stateChanged(ChangeEvent e) {
    switch (jTabbedPane1.getSelectedIndex()) {
      case 0:
        jPanel4.remove(qtyTableEditor);
        qtyTableEditor=new Jcmp_QtyList();
        qtyTableEditor.setBounds(new Rectangle(0, 0, 710, 243));
        jPanel4.add(qtyTableEditor, null);
        qtyTableEditor.reload();
        break;
      case 1:
        prxTableEditor.reload();
        break;
    }
  }
}
