package newtimes.basic.user;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import exgui2.*;
import database.datatype.Record;
import newtimes.preproduction.buyermakerselect.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class UserFieldsPanel extends JPanel {
  Frame1 frame;
  ButtonGroup bgMill = new ButtonGroup();
  ButtonGroup bgProduct = new ButtonGroup();
  ButtonGroup bgMag = new ButtonGroup();
  ButtonGroup bgDep = new ButtonGroup();
  ButtonGroup bgCen = new ButtonGroup();
  ButtonGroup bgBuyer = new ButtonGroup();
  ButtonGroup bgAmt = new ButtonGroup();
  ButtonGroup bgProfit = new ButtonGroup();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJList dbJlistMag=null;
  exgui.DataBindJCombobox dbJCBXBuyer = null;
  exgui.DataBindJCombobox dbJCBXMagDF = null;
  exgui.DataBindJCombobox dbJCBXCenDF = null;
  exgui.DataBindJCombobox dbJCBXDepDF = null;
  GetBuyerMaker dlgBuyer = new GetBuyerMaker(1);
  String fromWhere = null;
  database.datatype.Record recDetail = null;
  java.util.Vector vItems = new java.util.Vector();
  java.util.Vector vMagCode = new java.util.Vector();
  Object[] objMag = null;
  JPanel jPanel1 = new JPanel();
  JLabel jTextField6 = new JLabel();
  JPasswordField txtUsrPwd = new JPasswordField();
  JLabel jTextField3 = new JLabel();
  JLabel jTextField12 = new JLabel();
  JList list_selected = new JList();
  JLabel jTextField8 = new JLabel();
  JLabel jTextField19 = new JLabel();
  JLabel jTextField5 = new JLabel();
  JRadioButton rbProd_Y = new JRadioButton("Yes",true);
  JRadioButton rbProd_N = new JRadioButton("No");
  JComboBox cmboDep = new JComboBox();
  JRadioButton rbMill_Y = new JRadioButton("Yes",true);
  JLabel jTextField13 = new JLabel();
  JLabel jTextField10 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JLabel jTextField2 = new JLabel();
  JLabel jTextField15 = new JLabel();
  JLabel jTextField1 = new JLabel();
  JRadioButton rbCen_Y = new JRadioButton("Yes");
  JComboBox cmboUsrType = new JComboBox();
  JLabel jTextField14 = new JLabel();
  JComboBox cmboCenDF = new JComboBox();
  JRadioButton rbMill_N = new JRadioButton("No");
  JLabel jTextField9 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JRadioButton rbAmt_Y = new JRadioButton("Yes",true);
  JRadioButton rbCen_N = new JRadioButton("No",true);
  JTextField txtUsrName = new JTextField();
  JLabel jLabel1 = new JLabel();
  JRadioButton rbDep_N = new JRadioButton("No",true);
  JLabel jTextField17 = new JLabel();
  JComboBox cmboMagDF = new JComboBox();
  JRadioButton rbBuy_Y = new JRadioButton("Yes");
  JLabel jLabel2 = new JLabel();
  JLabel jTextField18 = new JLabel();
  JRadioButton rbProf_Y = new JRadioButton("Yes",true);
  JPanel jPanel2 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JLabel jTextField11 = new JLabel();
  JRadioButton rbProf_N = new JRadioButton("No");
  JRadioButton rbDep_Y = new JRadioButton("Yes");
  JList list_unSelect = new JList();
  JRadioButton rbBuy_N = new JRadioButton("NO",true);
  JTextField txtUsrCode = new JTextField();
  JRadioButton rbMag_N = new JRadioButton("No",true);
  JLabel jTextField16 = new JLabel();
  JRadioButton rbAmt_N = new JRadioButton("No");
  JComboBox cmboDepDF = new JComboBox();
  JRadioButton rbMag_Y = new JRadioButton("Yes");
  JScrollPane jScrollPane3 = new JScrollPane();
  JLabel jTextField4 = new JLabel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jTextField7 = new JLabel();
  JLabel jTextField20 = new JLabel();
  JCheckBox chkboxCancelSC = new JCheckBox();
  JCheckBox chkboxGenSC = new JCheckBox();
  java.util.Vector vDataMag;
  database.datatype.Record recMag;
  java.util.HashMap managerMap;
  Object orgDfManagerCode=null;
  boolean initializingComboboxes=false;
  Object orgSelectCenValue;
  Object orgSelectDepValue;
  Object orgWhereClause4True;
  Object orgWhereClause4False;
  boolean beginCheckCenter=true;
  JLabel jTextField21 = new JLabel();
  JComboBox cbxAxzByCm = new JComboBox(
                                 new String[]{
                                    "Un-Readable",
                                    "Read-Only",
                                    "Allow-Modify"}
                                 );
  JComboBox cbxAxzMkrDisc = new JComboBox(
                                 new String[]{
                                    "Un-Readable",
                                    "Read-Only",
                                    "Allow-Modify"}
                                 );
  SelectBuyerMaker slkBuyer = new MyBuyerMakerSelect();

  public UserFieldsPanel(Frame1 _frame, String _fromWhere) {
    frame = _frame;
    fromWhere = _fromWhere;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  class MyBuyerMakerSelect extends newtimes.preproduction.buyermakerselect.SelectBuyerMaker{
     protected void btnDots_actionPerformed(java.awt.event.ActionEvent e){
        super.center_code=(String)dbJCBXCen.getSelectedValue();
        super.btnDots_actionPerformed(e);
     }
  }
  void jbInit() throws Exception {
    jTextField4.setBounds(new Rectangle(7, 44, 84, 23));
    jTextField4.setText(" * User Type :");
    jTextField4.setOpaque(true);
    jTextField4.setBorder(null);
    jTextField4.setForeground(Color.white);
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    jScrollPane3.setBounds(new Rectangle(13, 40, 353, 109));
    rbMag_Y.setBounds(new Rectangle(136, 86, 81, 23));
    rbMag_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbMag_Y.setForeground(Color.darkGray);
    rbMag_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbMag_Y.setBackground(Color.white);
    cmboDepDF.setBounds(new Rectangle(144, 56, 209, 23));
    cmboDepDF.setBackground(Color.white);
    rbAmt_N.setForeground(Color.darkGray);
    rbAmt_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbAmt_N.setBackground(Color.white);
    rbAmt_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbAmt_N.setBounds(new Rectangle(218, 212, 82, 23));
    jTextField16.setBackground(new Color(143, 143, 188));
    jTextField16.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField16.setForeground(new Color(10,36,106));
    jTextField16.setBorder(null);
    jTextField16.setOpaque(true);
    jTextField16.setText(" Mill :");
    jTextField16.setBounds(new Rectangle(42, 149, 91, 23));
    rbMag_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbMag_N.setBackground(Color.white);
    rbMag_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbMag_N.setForeground(Color.darkGray);
    rbMag_N.setBounds(new Rectangle(218, 86, 82, 23));
    txtUsrCode.setBounds(new Rectangle(177, 13, 209, 23));
    txtUsrCode.setBounds(new Rectangle(92, 15, 162, 23));
    txtUsrCode.setText("");
    txtUsrCode.setForeground(new Color(10,36,106));
    rbBuy_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbBuy_N.setBackground(Color.white);
    rbBuy_N.setForeground(Color.darkGray);
    rbBuy_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbBuy_N.setBounds(new Rectangle(218, 117, 82, 23));
    list_unSelect.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        list_unSelect_mouseClicked(e);
      }
    });
    list_unSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    rbDep_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbDep_Y.setBackground(Color.white);
    rbDep_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbDep_Y.setForeground(Color.darkGray);
    rbDep_Y.setBounds(new Rectangle(136, 54, 81, 23));
    rbProf_N.setForeground(Color.darkGray);
    rbProf_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbProf_N.setBackground(Color.white);
    rbProf_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbProf_N.setBounds(new Rectangle(218, 243, 82, 23));
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(Color.white);
    jTextField11.setBorder(null);
    jTextField11.setOpaque(true);
    jTextField11.setText(" Buyer :");
    jTextField11.setBounds(new Rectangle(42, 117, 91, 23));
    jScrollPane2.setBounds(new Rectangle(387, 40, 353, 109));
    jPanel5.setBorder(BorderFactory.createTitledBorder(" * Default Values for UI "));
    jPanel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel5.setBackground(new Color(204, 204, 225));
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(8, 238, 373, 156));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" * Manager "));
    jPanel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setLayout(null);
    jPanel2.setBounds(new Rectangle(7, 72, 756, 161));
    rbProf_Y.setBounds(new Rectangle(136, 243, 81, 23));
    rbProf_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbProf_Y.setForeground(Color.darkGray);
    rbProf_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbProf_Y.setBackground(Color.white);
    jTextField18.setBounds(new Rectangle(17, 116, 126, 23));
    jTextField18.setText(" Buyer :");
    jTextField18.setOpaque(true);
    jTextField18.setBorder(null);
    jTextField18.setForeground(Color.white);
    jTextField18.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField18.setBackground(new Color(143, 143, 188));
    jLabel2.setVerifyInputWhenFocusTarget(true);
    jLabel2.setText("Selected");
    jLabel2.setBounds(new Rectangle(13, 22, 52, 16));
    rbBuy_Y.setBounds(new Rectangle(136, 117, 81, 23));
    rbBuy_Y.setForeground(Color.darkGray);
    rbBuy_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbBuy_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbBuy_Y.setBackground(Color.white);
    cmboMagDF.setBackground(Color.white);
    cmboMagDF.setBounds(new Rectangle(144, 86, 209, 23));
    jTextField17.setBounds(new Rectangle(515, 44, 91, 23));
    jTextField17.setText(" * Department :");
    jTextField17.setBorder(null);
    jTextField17.setOpaque(true);
    jTextField17.setForeground(Color.white);
    jTextField17.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField17.setBackground(new Color(143, 143, 188));
    rbDep_N.setBounds(new Rectangle(218, 54, 82, 23));
    rbDep_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbDep_N.setForeground(Color.darkGray);
    rbDep_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbDep_N.setBackground(Color.white);
    jLabel1.setBounds(new Rectangle(387, 22, 75, 16));
    jLabel1.setText("Un-Select ");
    jLabel1.setVerifyInputWhenFocusTarget(true);
    txtUsrName.setBounds(new Rectangle(177, 42, 209, 23));
    txtUsrName.setForeground(new Color(10,36,106));
    txtUsrName.setBounds(new Rectangle(603, 16, 160, 23));
    rbCen_N.setBounds(new Rectangle(218, 23, 82, 23));
    rbCen_N.setForeground(Color.darkGray);
    rbCen_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbCen_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbCen_N.setBackground(Color.white);
    rbAmt_Y.setBackground(Color.white);
    rbAmt_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbAmt_Y.setForeground(Color.darkGray);
    rbAmt_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbAmt_Y.setBounds(new Rectangle(136, 212, 81, 23));
    jPanel4.setBounds(new Rectangle(397, 238, 359, 285));
    jPanel4.setLayout(null);
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel4.setBorder(BorderFactory.createTitledBorder(" * Modify "));
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setBorder(null);
    jTextField9.setOpaque(true);
    jTextField9.setText(" Print Profit :");
    jTextField9.setBounds(new Rectangle(42, 240, 91, 23));
    rbMill_N.setBackground(Color.white);
    rbMill_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbMill_N.setForeground(Color.darkGray);
    rbMill_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbMill_N.setBounds(new Rectangle(218, 149, 82, 23));
    cmboCenDF.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCenDF_itemStateChanged(e);
      }
    });
    cmboCenDF.setBounds(new Rectangle(144, 26, 209, 23));
    cmboCenDF.setBackground(Color.white);
    jTextField14.setBackground(new Color(143, 143, 188));
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setForeground(new Color(10,36,106));
    jTextField14.setBorder(null);
    jTextField14.setOpaque(true);
    jTextField14.setText(" Manager :");
    jTextField14.setBounds(new Rectangle(42, 86, 91, 23));
    cmboUsrType.setBounds(new Rectangle(91, 44, 161, 23));
    cmboUsrType.setAutoscrolls(false);
    cmboUsrType.setBackground(Color.white);
    rbCen_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbCen_Y.setBackground(Color.white);
    rbCen_Y.setForeground(Color.darkGray);
    rbCen_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbCen_Y.setBounds(new Rectangle(136, 23, 81, 23));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setOpaque(true);
    jTextField1.setBorder(null);
    jTextField1.setText(" * User Code :");
    jTextField1.setBounds(new Rectangle(8, 15, 85, 23));
    jTextField15.setBackground(new Color(143, 143, 188));
    jTextField15.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField15.setForeground(Color.white);
    jTextField15.setBorder(null);
    jTextField15.setOpaque(true);
    jTextField15.setText(" Product :");
    jTextField15.setBounds(new Rectangle(42, 180, 91, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setOpaque(true);
    jTextField2.setBorder(null);
    jTextField2.setText(" * User Name :");
    jTextField2.setBounds(new Rectangle(515, 16, 88, 23));
    cmboCen.setBackground(Color.white);
    cmboCen.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCen_itemStateChanged(e);
      }
    });
    cmboCen.setBounds(new Rectangle(339, 44, 160, 23));
    jTextField10.setBounds(new Rectangle(17, 86, 126, 23));
    jTextField10.setText(" Manager :");
    jTextField10.setOpaque(true);
    jTextField10.setBorder(null);
    jTextField10.setForeground(new Color(10,36,106));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setForeground(Color.white);
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    jTextField13.setText(" Department :");
    jTextField13.setBounds(new Rectangle(42, 54, 91, 23));
    rbMill_Y.setForeground(Color.darkGray);
    rbMill_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbMill_Y.setBackground(Color.white);
    rbMill_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbMill_Y.setBounds(new Rectangle(136, 149, 81, 23));
    cmboDep.setBackground(Color.white);
    cmboDep.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboDep_itemStateChanged(e);
      }
    });
    cmboDep.setBounds(new Rectangle(606, 44, 160, 23));
    rbProd_N.setForeground(Color.darkGray);
    rbProd_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rbProd_N.setBackground(Color.white);
    rbProd_N.setHorizontalAlignment(SwingConstants.CENTER);
    rbProd_N.setBounds(new Rectangle(218, 180, 82, 23));
    rbProd_Y.setBounds(new Rectangle(136, 180, 81, 23));
    rbProd_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rbProd_Y.setForeground(Color.darkGray);
    rbProd_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rbProd_Y.setBackground(Color.white);
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    jTextField5.setText(" Center :");
    jTextField5.setBounds(new Rectangle(17, 26, 126, 23));
    jTextField19.setBounds(new Rectangle(262, 44, 77, 23));
    jTextField19.setText(" * Center :");
    jTextField19.setBorder(null);
    jTextField19.setOpaque(true);
    jTextField19.setForeground(Color.white);
    jTextField19.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField19.setBackground(new Color(143, 143, 188));
    jTextField8.setBounds(new Rectangle(42, 212, 91, 23));
    jTextField8.setText(" Print Amount :");
    jTextField8.setOpaque(true);
    jTextField8.setBorder(null);
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setBackground(new Color(143, 143, 188));
    list_selected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list_selected.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        list_selected_mouseClicked(e);
      }
    });
    jTextField12.setBackground(new Color(143, 143, 188));
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setForeground(new Color(10,36,106));
    jTextField12.setBorder(null);
    jTextField12.setOpaque(true);
    jTextField12.setText(" Center :");
    jTextField12.setBounds(new Rectangle(42, 23, 91, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setOpaque(true);
    jTextField3.setBorder(null);
    jTextField3.setText(" * User Password :");
    jTextField3.setBounds(new Rectangle(262, 15, 116, 23));
    txtUsrPwd.setBounds(new Rectangle(376, 15, 123, 23));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(Color.white);
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setText(" Department :");
    jTextField6.setBounds(new Rectangle(17, 56, 126, 23));
    this.setLayout(gridBagLayout1);
    this.setSize(new Dimension(778, 564));
    this.setBackground(new Color(204, 204, 225));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    jLabel3.setForeground(Color.red);
    jLabel3.setText(" (Dobule Click to Un-Select) :");
    jLabel3.setBounds(new Rectangle(76, 23, 251, 16));
    jLabel4.setBounds(new Rectangle(455, 22, 251, 16));
    jLabel4.setText(" (Dobule Click to Select) :");
    jLabel4.setForeground(Color.red);
    jTextField7.setBounds(new Rectangle(10, 464, 118, 49));
    jTextField7.setText("<html><body>Allow To Cancel <br> Generate S/C NO.</body></html>");
    jTextField7.setOpaque(true);
    jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField7.setBorder(null);
    jTextField7.setForeground(new Color(10, 36, 106));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField20.setBounds(new Rectangle(10, 398, 210, 25));
    jTextField20.setText(" Buyer Commission");
    jTextField20.setOpaque(true);
    jTextField20.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField20.setHorizontalTextPosition(SwingConstants.CENTER);
    jTextField20.setBorder(null);
    jTextField20.setForeground(new Color(10,36,106));
    jTextField20.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField20.setBackground(new Color(143, 143, 188));
    //jComboBox1.setBounds(new Rectangle(221, 398, 133, 25));
    //jComboBox2.setBounds(new Rectangle(219, 464, 137, 23));
    //cbxAxzByCmMkrDisct.setBounds(new Rectangle(220, 399, 170, 23));
    //jCheckBox1.setText("Allow To Generate S/C No.");
    //jCheckBox1.setBounds(new Rectangle(128, 465, 240, 22));
    //chkboxGenSC1.setBounds(new Rectangle(128, 493, 240, 20));
    chkboxCancelSC.setFont(new java.awt.Font("Dialog", 1, 11));
    chkboxCancelSC.setText("Allow To Cancel S/C No.");
    chkboxCancelSC.setBounds(new Rectangle(127, 464, 155, 25));
    chkboxGenSC.setFont(new java.awt.Font("Dialog", 1, 11));
    chkboxGenSC.setText("Allow To Generate S/C");
    chkboxGenSC.setBounds(new Rectangle(127, 491, 155, 21));
    jTextField21.setBackground(new Color(143, 143, 188));
    jTextField21.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField21.setForeground(Color.white);
    jTextField21.setBorder(null);
    jTextField21.setHorizontalTextPosition(SwingConstants.CENTER);
    jTextField21.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField21.setOpaque(true);
    jTextField21.setText(" Maker Discount");
    jTextField21.setBounds(new Rectangle(10, 431, 210, 25));
    //cbxAxzByCm1.setBounds(new Rectangle(220, 432, 170, 23));
    cbxAxzByCm.setBounds(new Rectangle(220, 398, 157, 23));
    cbxAxzMkrDisc.setBounds(new Rectangle(220, 431, 157, 23));
    slkBuyer.setBounds(new Rectangle(143, 116, 211, 23));
    this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 1, 3, 1), 775, 560));
    jPanel4.add(rbCen_N, null);
    jPanel4.add(jTextField12, null);
    jPanel4.add(jTextField13, null);
    jPanel4.add(jTextField14, null);
    jPanel4.add(jTextField11, null);
    jPanel4.add(jTextField16, null);
    jPanel4.add(jTextField15, null);
    jPanel4.add(jTextField8, null);
    jPanel4.add(jTextField9, null);
    jPanel4.add(rbCen_Y, null);
    jPanel4.add(rbDep_Y, null);
    jPanel4.add(rbMag_Y, null);
    jPanel4.add(rbBuy_Y, null);
    jPanel4.add(rbMill_Y, null);
    jPanel4.add(rbProd_Y, null);
    jPanel4.add(rbAmt_Y, null);
    jPanel4.add(rbProf_Y, null);
    jPanel4.add(rbDep_N, null);
    jPanel4.add(rbMag_N, null);
    jPanel4.add(rbBuy_N, null);
    jPanel4.add(rbMill_N, null);
    jPanel4.add(rbProd_N, null);
    jPanel4.add(rbAmt_N, null);
    jPanel4.add(rbProf_N, null);
    //jPanel1.add(jComboBox1, null);
    //jPanel1.add(jComboBox2, null);
    jPanel1.add(jPanel4, null);
    jPanel1.add(jTextField20, null);
    jPanel1.add(jTextField7, null);
    jPanel1.add(jTextField1, null);
    jPanel1.add(txtUsrCode, null);
    jPanel1.add(jTextField3, null);
    jPanel1.add(txtUsrPwd, null);
    jPanel1.add(jTextField2, null);
    jPanel1.add(txtUsrName, null);
    jPanel1.add(jTextField4, null);
    jPanel1.add(cmboUsrType, null);
    jPanel1.add(jTextField19, null);
    jPanel1.add(cmboCen, null);
    jPanel1.add(jTextField17, null);
    jPanel1.add(cmboDep, null);
    jPanel1.add(jPanel2, null);
    jPanel2.add(jScrollPane3, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jLabel1, null);
    jPanel2.add(jScrollPane2, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(jLabel4, null);
    jPanel1.add(jPanel5, null);
    jScrollPane2.add(list_unSelect, null);
    jScrollPane3.add(list_selected, null);
    jPanel5.add(cmboMagDF, null);
    jPanel5.add(jTextField10, null);
    jPanel5.add(jTextField18, null);
    jPanel5.add(jTextField6, null);
    jPanel5.add(cmboDepDF, null);
    jPanel5.add(jTextField5, null);
    jPanel5.add(cmboCenDF, null);
    jPanel5.add(slkBuyer, null);
    bgCen.add(rbCen_Y);
    bgCen.add(rbCen_N);
    bgDep.add(rbDep_Y);
    bgDep.add(rbDep_N);
    bgMag.add(rbMag_Y);
    bgMag.add(rbMag_N);
    bgBuyer.add(rbBuy_Y);
    bgBuyer.add(rbBuy_N);
    bgMill.add(rbMill_Y);
    bgMill.add(rbMill_N);
    bgProduct.add(rbProd_Y);
    bgProduct.add(rbProd_N);
    bgAmt.add(rbAmt_Y);
    bgAmt.add(rbAmt_N);
    bgProfit.add(rbProf_Y);
    bgProfit.add(rbProf_N);
    jScrollPane2.getViewport().add(list_unSelect, null);
    jScrollPane3.getViewport().add(list_selected, null);
    //jPanel1.add(cbxAxzByCmMkrDisct, null);
    jPanel1.add(chkboxCancelSC, null);
    jPanel1.add(chkboxGenSC, null);
    //jPanel1.add(cbxAxzByCm1, null);
    jPanel1.add(jTextField21, null);
    jPanel1.add(cbxAxzByCm, null);
    jPanel1.add(cbxAxzMkrDisc, null);
    //jPanel1.add(jCheckBox1, null);
    //jPanel1.add(chkboxGenSC1, null);
    exgui2.Stuff.getUserType4JComboBox(cmboUsrType);
    cmboUsrType.setSelectedItem("User");
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    this.setComboData();
    setMaxLength();
    initDepManagerList(recMag);
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtUsrCode,null,"",20);
    tx = new exgui.DataBindText(txtUsrPwd,null,"",16);
    tx = new exgui.DataBindText(txtUsrName,null,"",20);
  }

  boolean checkFieldsData() {
    boolean isOK = false;
    boolean codeNull = exgui2.Stuff.checkNull(frame,txtUsrCode.getText().trim(),"User Code can't be empty.");
    boolean nameNull = exgui2.Stuff.checkNull(frame,txtUsrName.getText().trim(),"User Name can't be empty.");
    boolean pwdNull = exgui2.Stuff.checkNull(frame,new String(txtUsrPwd.getPassword()).trim(),"User Password can't be empty.");
    if(dbJCBXDep==null || dbJCBXDep.getSelectedValue() ==null ){
      exgui2.InfoMessage.warningMessage(
          frame, "Please select a department.");
      return false;
    }
    if(dbJCBXDepDF==null || dbJCBXDepDF.getSelectedValue() ==null ){
      exgui2.InfoMessage.warningMessage(
          frame, "Please select a default department.");
      return false;
    }

    if(codeNull && nameNull && pwdNull) {
      if (vMagCode.isEmpty() || slkBuyer.getSelectedValue() == null) {
        if (vMagCode.isEmpty()) {
          exgui2.InfoMessage.warningMessage(
              frame, "Manager can't be empty.");
          isOK = false;
        } else {
          exgui2.InfoMessage.warningMessage(
              frame, "Default Buyer can't be empty.");
          isOK = false;
        }
      } else {
        isOK = true;
      }
    } else {
      isOK = false;
    }
    return isOK;
  }

  void setComboData() {
    java.util.Vector vDataCen = null;
     vDataMag = null;
     initializingComboboxes=true;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      vDataMag = exgui2.CONST.BASIC_BASE_EJB.getManagerAll("MNG_CODE,MNG_ABBR", "MNG_ABBR");
      //full fill the manager map...
      managerMap=new java.util.HashMap();
      for(int i=0;i<vDataMag.size();i++){
         Record rec=(Record)vDataMag.get(i);
         managerMap.put(rec.get("mng_code"),rec);
      }
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      recMag = (database.datatype.Record) vDataMag.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                           "CEN_CODE", recCen.get("CEN_CODE"));
      dbJCBXCenDF = new exgui.DataBindJCombobox(cmboCenDF, vDataCen, "CEN_NAME",
                                           "CEN_CODE", recCen.get("CEN_CODE"));
      dbJCBXMagDF = new exgui.DataBindJCombobox(cmboMagDF, vDataMag, "MNG_ABBR",
                                           "MNG_CODE", recMag.get("MNG_CODE"),"",null);
      orgDfManagerCode=dbJCBXMagDF.getSelectedValue();

      if (fromWhere.equals("NEW")) {
        this.setDepItem("DEP_CEN_CODE = '"+dbJCBXCen.getSelectedValue()+"'", false);
        this.setDepItem(" DEP_CEN_CODE = '" + dbJCBXCenDF.getSelectedValue() + "'", true);
      } else {
        java.util.HashMap hm =
          (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
        recDetail = (database.datatype.Record) hm.get("recDetail");
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt JComboBox.");
    }finally{
      initializingComboboxes=false;
    }
  }

  java.util.HashMap setData2HashMap() {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      hm.put("USR_CODE", txtUsrCode.getText().trim().toUpperCase());
      hm.put("USR_PWD", String.copyValueOf(txtUsrPwd.getPassword()));
      hm.put("USR_NAME", txtUsrName.getText().trim());
      hm.put("USR_TYPE", exgui2.Stuff.getUserTypeValue4JComboBox(cmboUsrType));
      hm.put("USR_CEN_CODE", dbJCBXCen.getSelectedValue().toString());
      hm.put("USR_DEP_CODE", dbJCBXDep == null ? "" : dbJCBXDep.getSelectedValue());
      hm.put("USR_MNG_CODE_DF", dbJCBXMagDF.getSelectedValue().toString());
      hm.put("USR_CEN_CODE_DF", dbJCBXCenDF.getSelectedValue().toString());
      hm.put("USR_DEP_CODE_DF", dbJCBXDepDF == null ? "" : dbJCBXDepDF.getSelectedValue());

      int axzByCmIndex=cbxAxzByCm.getSelectedIndex();
      int axzMkDiscIndex=cbxAxzMkrDisc.getSelectedIndex();
      StringBuffer sbtmpAxzByrCmMkDisc=new StringBuffer();

      switch(axzByCmIndex){
        case 0:
          //hm.put("EDIT_BYMKR_COMM_DISCOUNT",null);
          break;
        case 1:
          sbtmpAxzByrCmMkDisc.append("BR");
          //hm.put("EDIT_BYMKR_COMM_DISCOUNT","R");
          break;
        case 2:
          sbtmpAxzByrCmMkDisc.append("BW");
          //hm.put("EDIT_BYMKR_COMM_DISCOUNT","W");
      }

      switch(axzMkDiscIndex){
        case 0:
          //hm.put("EDIT_BYMKR_COMM_DISCOUNT",null);
          break;
        case 1:
          sbtmpAxzByrCmMkDisc.append("MR");
          //hm.put("EDIT_BYMKR_COMM_DISCOUNT","R");
          break;
        case 2:
          sbtmpAxzByrCmMkDisc.append("MW");
          //hm.put("EDIT_BYMKR_COMM_DISCOUNT","W");
      }
      if(sbtmpAxzByrCmMkDisc.toString().trim().length()==0){
        hm.put("EDIT_BYMKR_COMM_DISCOUNT",null);
      }else{
        hm.put("EDIT_BYMKR_COMM_DISCOUNT",sbtmpAxzByrCmMkDisc.toString().trim());
      }

      String cnclGenSc="";
      if(chkboxCancelSC.isSelected()) cnclGenSc+="C";
      if(chkboxGenSC.isSelected()) cnclGenSc+="G";
      hm.put("ALLOW_CANCEL_SC",cnclGenSc);


      hm.put("MNG_CODE", vMagCode);

      if (fromWhere.equals("EDIT")) {
        if (recDetail.get("BYMKR_BRIEF") != null) {
          /*
          if (recDetail.get("BYMKR_BRIEF").toString().trim().
              equals(popBuyer.getText())) {
            hm.put("USR_BUY_DF", recDetail.get("USR_BUY_DF"));
          } else {
            hm.put("USR_BUY_DF", popBuyer.getSelectedBuyerValue());
          }*/

          hm.put("USR_BUY_DF", slkBuyer.getSelectedValue());

        } else {
          hm.put("USR_BUY_DF", "2");
        }
      } else {
        if (slkBuyer.getSelectedValue() != null) {
          hm.put("USR_BUY_DF", slkBuyer.getSelectedValue() );
        } else {
          hm.put("USR_BUY_DF", "2");
        }
      }
      hm.put("USR_CEN_MOD", exgui2.Stuff.setRadioButtonYesOrNo(rbCen_Y, rbCen_N));
      hm.put("USR_DEP_MOD", exgui2.Stuff.setRadioButtonYesOrNo(rbDep_Y, rbDep_N));
      hm.put("USR_MNG_MOD", exgui2.Stuff.setRadioButtonYesOrNo(rbMag_Y, rbMag_N));
      hm.put("USR_BUY_MOD", exgui2.Stuff.setRadioButtonYesOrNo(rbBuy_Y, rbBuy_N));
      hm.put("USR_MOD_MILL", exgui2.Stuff.setRadioButtonYesOrNo(rbMill_Y, rbMill_N));
      hm.put("USR_MOD_PROD", exgui2.Stuff.setRadioButtonYesOrNo(rbProd_Y, rbProd_N));
      hm.put("USR_PRINT_AMT", exgui2.Stuff.setRadioButtonYesOrNo(rbAmt_Y, rbAmt_N));
      hm.put("USR_PRINT_PROFIT", exgui2.Stuff.setRadioButtonYesOrNo(rbProf_Y, rbProf_N));
      //System.out.println("#hm:"+hm.toString());
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm,
        "error at datas, when put datas in HashMap."+hm.toString());
    } finally {
      return hm;
    }
  }
 protected void initDepManagerList(Record recMag){
   //MNG_DEP_CODE, MNG_CEN_CODE
   if(initializingComboboxes)return;
   java.util.Vector orgManagerList=null;
   Object objMagCode=null;
   try{
     setCursor(new Cursor(Cursor.WAIT_CURSOR));
     if(dbJCBXDep!=null){
       objMagCode=dbJCBXDep.getSelectedValue();
       orgSelectDepValue= objMagCode;
     }else{
       if(vMagCode!=null && vMagCode.size()>0){
         objMagCode = vMagCode.get(0);
       }else{
         objMagCode=null;
       }
     }
     orgSelectCenValue= dbJCBXCen.getSelectedValue();
     orgManagerList =
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.
                                             USER_RECORD,
                                             "select * from manager where MNG_CEN_CODE='" +
                                             dbJCBXCen.getSelectedValue() +
                                             "' "+((objMagCode!=null)?("and MNG_DEP_CODE='" +
                                             objMagCode+"'"):""), 1, 999);

     dbJlistMag = new exgui.DataBindJList(list_unSelect, orgManagerList,
                                          "MNG_ABBR",
                                          "MNG_CODE",
                                          (recMag == null) ? null :
                                          recMag.get("MNG_CODE"));
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     exgui.verification.VerifyLib.showAlert(""+exp.getMessage(),"Error While Requesting Manager Datas");
   }finally{
     setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
   }

 }
  void setDepItem(String whereClause, boolean isDepDef) {
    java.util.Vector vDataDep = null;
    if(isDepDef){
      if (util.MiscFunc.isEqual(whereClause, orgWhereClause4True))return;
      orgWhereClause4True = whereClause;
    }else{
      if (util.MiscFunc.isEqual(whereClause, orgWhereClause4False))return;
      orgWhereClause4False = whereClause;
    }
    try {
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (!vDataDep.isEmpty()) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        if (!isDepDef) {
          dbJCBXDep = new exgui.DataBindJCombobox(
              cmboDep, vDataDep, "DEP_NAME", "DEP_CODE", recDep.get("DEP_CODE"));
          cmboDep.setSelectedIndex(0);
        } else {
          dbJCBXDepDF = new exgui.DataBindJCombobox(cmboDepDF, vDataDep, "DEP_NAME",
                                           "DEP_CODE", recDep.get("DEP_CODE"));
          cmboDepDF.setSelectedIndex(0);
        }
      } else {
        if (!isDepDef) {
          dbJCBXDep = null;
          cmboDep.removeAllItems();
        } else {
          dbJCBXDepDF = null;
          cmboDepDF.removeAllItems();
        }
      }
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD, "error at set Dep. items.");
    }finally{
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void cmboCen_itemStateChanged(ItemEvent e) {
    if(initializingComboboxes)return;
    //System.out.println("cmboCen_itemStateChanged");
    //if (e.getStateChange() == e.SELECTED) {
      if (dbJCBXCen != null) {
        if(beginCheckCenter && util.MiscFunc.isEqual(orgSelectCenValue,dbJCBXCen.getSelectedValue()))return;
        orgSelectCenValue=dbJCBXCen.getSelectedValue();
        this.setDepItem("DEP_CEN_CODE = '" + dbJCBXCen.getSelectedValue() + "'", false);
        cmboCenDF.setSelectedItem(cmboCen.getSelectedItem());
        cmboCenDF_itemStateChanged(null);
        initDepManagerList(null);
      }
    //}
  }

  void cmboCenDF_itemStateChanged(ItemEvent e) {
    //System.out.println("cmboCenDF_itemStateChanged");
    if(initializingComboboxes)return;
    //if (e.getStateChange() == e.SELECTED) {
      if (dbJCBXCenDF != null) {
        this.setDepItem("DEP_CEN_CODE = '" + dbJCBXCenDF.getSelectedValue() + "'", true);
      }
    //}
  }

  void cmboDep_itemStateChanged(ItemEvent e) {
     //System.out.println("cmboDep_itemStateChanged");
     if(initializingComboboxes)return;
     if(dbJCBXDep!=null){
       if (util.MiscFunc.isEqual(orgSelectDepValue, dbJCBXDep.getSelectedValue()))return;
       orgSelectDepValue = dbJCBXDep.getSelectedValue();
     }

     cmboDepDF.setSelectedItem(cmboDep.getSelectedItem());
     initDepManagerList(null);
     //set manager list to uncheck list.
  }
  void init_dbJCBXMagDF(){
    try{
      java.util.Vector storeVctor=new java.util.Vector();
      //fillter the tmpMamagers only contacts the managers.
      Object initValue=null;
      for(int j=0;j<vMagCode.size();j++){
        Object obj=managerMap.get(vMagCode.get(j));
        if(obj!=null){
          storeVctor.add(obj);
        }
      }
      if(dbJCBXMagDF!=null && recDetail!=null){
        orgDfManagerCode = recDetail.get("USR_MNG_CODE_DF"); // dbJCBXMagDF.getSelectedValue();//for latter's mapping
      }else{
        orgDfManagerCode=null;
      }
      dbJCBXMagDF = new exgui.DataBindJCombobox(cmboMagDF, storeVctor,
                                          "MNG_ABBR",
                                          "MNG_CODE", orgDfManagerCode,"",null);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void list_unSelect_mouseClicked(MouseEvent e) {
    int i = 0;
    if (e==null || e.getClickCount() == 2) {
      objMag = dbJlistMag.getSelectedValues();
      if(objMag==null||objMag.length<=0){
        return;
      }
      //test if already added....
      if(vItems.contains(list_unSelect.getSelectedValue()))return;
      vItems.add(list_unSelect.getSelectedValue());
      vMagCode.add(objMag[i]);
      list_selected.setListData(vItems);
      i ++;
      init_dbJCBXMagDF();
    }
  }

  void list_selected_mouseClicked(MouseEvent e) {
    if (e==null||e.getClickCount() == 2) {
     if (list_selected.getSelectedIndex() > -1) {
        vItems.remove(list_selected.getSelectedIndex());
        vMagCode.remove(list_selected.getSelectedIndex());
        list_selected.setListData(vItems);
        init_dbJCBXMagDF();
      }
    }
  }
}
