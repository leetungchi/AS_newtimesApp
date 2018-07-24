package newtimes.material;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MaterialAdd extends JPanel {
  Frame1 frame;
  private JSplitPane jSplitPane1 = new JSplitPane();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JScrollPane jScrollPane2 = new JScrollPane();
  private JPanel jPanel1 = new JPanel();
  private JPanel jPanel2 = new JPanel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField6 = new JLabel();
  private JLabel jTextField7 = new JLabel();
  private JLabel jTextField8 = new JLabel();
  private JLabel jTextField9 = new JLabel();
  private JLabel jTextField10 = new JLabel();
  private JLabel jTextField11 = new JLabel();
  private JLabel jTextField12 = new JLabel();
  private JLabel jTextField13 = new JLabel();
  private JLabel jTextField14 = new JLabel();
  private JLabel jTextField15 = new JLabel();
  private JLabel jTextField16 = new JLabel();
  private JLabel jTextField17 = new JLabel();
  private JTextField jTextField19 = new JTextField();
  private JTextField jTextField21 = new JTextField();
  private JTextField jTextField22 = new JTextField();
  private JTextField jTextField23 = new JTextField();
  private JTextField jTextField24 = new JTextField();
  private JTextField jTextField25 = new JTextField();
  private JTextField jTextField26 = new JTextField();
  private JTextField jTextField27 = new JTextField();
  private JTextField jTextField28 = new JTextField();
  private JTextField jTextField29 = new JTextField();
  private JTextField jTextField30 = new JTextField();
  private JTextField jTextField31 = new JTextField();
  private JTextField jTextField32 = new JTextField();
  private JTextField jTextField33 = new JTextField();
  private JTextField jTextField34 = new JTextField();
  private JPanel jPanel3 = new JPanel();
  private JButton btnNew = new JButton();
  private JButton btnConfirm = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private JButton jButton5 = new JButton();
  private JButton jButton6 = new JButton();
  private JTabbedPane jTabbedPane1 = new JTabbedPane();
  private JPanel jPanel4 = new JPanel();
  private JPanel jPanel5 = new JPanel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField35 = new JTextField();
  private JTextField jTextField36 = new JTextField();
  private JComboBox jComboBox1 = new JComboBox();
  private JTextField jTextField37 = new JTextField();
  private JTextField jTextField38 = new JTextField();
  private JTextField jTextField39 = new JTextField();
  private JTextField jTextField40 = new JTextField();
  private JTextField jTextField41 = new JTextField();
  private JTextField jTextField42 = new JTextField();
  private JTextField jTextField43 = new JTextField();
  private JTextField jTextField44 = new JTextField();
  private JTextField jTextField45 = new JTextField();
  private JTextField jTextField46 = new JTextField();
  private JTextField jTextField47 = new JTextField();
  private JTextField jTextField48 = new JTextField();
  private JTextField jTextField49 = new JTextField();
  private JTextField jTextField50 = new JTextField();
  private JTextField jTextField51 = new JTextField();
  private JTextField jTextField52 = new JTextField();
  private JTextField jTextField53 = new JTextField();
  private JTextField jTextField54 = new JTextField();
  private JTextField jTextField55 = new JTextField();
  private JComboBox jComboBox2 = new JComboBox();
  private JTextField jTextField56 = new JTextField();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel7 = new JLabel();
  private JLabel jLabel8 = new JLabel();
  private JButton jButton7 = new JButton();
  private JTextField jTextField57 = new JTextField();
  private JTextField jTextField58 = new JTextField();
  private JTextField jTextField59 = new JTextField();
  private JTextField jTextField60 = new JTextField();
  private JTextField jTextField61 = new JTextField();
  private JTextField jTextField62 = new JTextField();
  private JTextField jTextField63 = new JTextField();
  private JTextField jTextField64 = new JTextField();
  private JTextField jTextField65 = new JTextField();
  private JTextField jTextField66 = new JTextField();
  private JTextField jTextField67 = new JTextField();
  private JTextField jTextField68 = new JTextField();
  private JLabel jLabel9 = new JLabel();
  private JLabel jLabel10 = new JLabel();
  private JLabel jLabel11 = new JLabel();
  private JTextField jTextField69 = new JTextField();
  private JTextField jTextField70 = new JTextField();
  private JTextField jTextField71 = new JTextField();
  private JTextField jTextField72 = new JTextField();
  private JTextField jTextField73 = new JTextField();
  private JTextField jTextField74 = new JTextField();
  private JTextField jTextField610 = new JTextField();
  private JTextField jTextField75 = new JTextField();
  private JTextField jTextField611 = new JTextField();
  private JTextField jTextField612 = new JTextField();
  private JTextField jTextField613 = new JTextField();
  private JLabel jLabel12 = new JLabel();
  private JLabel jLabel13 = new JLabel();
  private JTextField jTextField614 = new JTextField();
  private JLabel jLabel14 = new JLabel();
  private JTextField jTextField76 = new JTextField();
  private JTextArea jTextArea1 = new JTextArea();
  private JLabel jLabel15 = new JLabel();
  private JScrollPane jScrollPane3 = new JScrollPane();
  private JTable jTable1 = null;
  private exgui2.DefTableModel tableModel = new exgui2.DefTableModel();
  private JComboBox jComboBox3 = new JComboBox();
  private JComboBox jComboBox4 = new JComboBox();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jTextField18 = new JLabel();
  JTextField jTextField310 = new JTextField();
  JLabel jTextField110 = new JLabel();
  JTextField jTextField311 = new JTextField();
  JLabel jTextField111 = new JLabel();
  JComboBox jComboBox5 = new JComboBox();

  public MaterialAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    this.setTable();
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setFont(new java.awt.Font("Dialog", 1, 12));
    this.setForeground(SystemColor.desktop);
    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane1.setBorder(null);
    jSplitPane1.setContinuousLayout(true);
    jSplitPane1.setOneTouchExpandable(true);
    jSplitPane1.setBounds(new Rectangle(0, 0, 793, 544));
    jSplitPane1.setDividerSize(10);
    jPanel1.setLayout(gridBagLayout1);
    jPanel2.setLayout(gridBagLayout2);
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setEnabled(false);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Material Head  ============      ");
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setText(" Center :");
    jTextField1.setOpaque(true);
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setBorder(null);
    jTextField2.setText(" MTR-NO. :");
    jTextField2.setOpaque(true);
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(Color.white);
    jTextField3.setBorder(null);
    jTextField3.setText(" Type :");
    jTextField3.setOpaque(true);
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setText(" Description :");
    jTextField4.setOpaque(true);
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setBorder(null);
    jTextField5.setText(" Content :");
    jTextField5.setOpaque(true);
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setBorder(null);
    jTextField6.setText(" Construstion :");
    jTextField6.setOpaque(true);
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(Color.white);
    jTextField7.setBorder(null);
    jTextField7.setText(" Detail Remark :");
    jTextField7.setOpaque(true);
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(Color.white);
    jTextField8.setBorder(null);
    jTextField8.setText(" Finish :");
    jTextField8.setOpaque(true);
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(new Color(10,36,106));
    jTextField9.setBorder(null);
    jTextField9.setText(" Width :");
    jTextField9.setOpaque(true);
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(new Color(10,36,106));
    jTextField10.setBorder(null);
    jTextField10.setText(" Cutable Width :");
    jTextField10.setOpaque(true);
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(Color.white);
    jTextField11.setBorder(null);
    jTextField11.setText(" Weight :");
    jTextField11.setOpaque(true);
    jTextField12.setBackground(new Color(143, 143, 188));
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setForeground(new Color(10,36,106));
    jTextField12.setBorder(null);
    jTextField12.setText(" Yarn ends :");
    jTextField12.setOpaque(true);
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setForeground(new Color(10,36,106));
    jTextField13.setBorder(null);
    jTextField13.setText(" Yarn gauge :");
    jTextField13.setOpaque(true);
    jTextField14.setBackground(new Color(143, 143, 188));
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setForeground(Color.white);
    jTextField14.setBorder(null);
    jTextField14.setText(" Yarn horizon :");
    jTextField14.setOpaque(true);
    jTextField15.setBackground(new Color(143, 143, 188));
    jTextField15.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField15.setForeground(Color.white);
    jTextField15.setBorder(null);
    jTextField15.setText(" Yarn vertic :");
    jTextField15.setOpaque(true);
    jTextField16.setBackground(new Color(143, 143, 188));
    jTextField16.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField16.setForeground(new Color(10,36,106));
    jTextField16.setBorder(null);
    jTextField16.setText(" Wash Method :");
    jTextField16.setOpaque(true);
    jTextField17.setBackground(new Color(143, 143, 188));
    jTextField17.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField17.setForeground(new Color(10,36,106));
    jTextField17.setBorder(null);
    jTextField17.setText(" Package :");
    jTextField17.setOpaque(true);
    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jPanel3.setBackground(new Color(143, 143, 188));
    jPanel3.setBounds(new Rectangle(-1, 544, 800, 30));
    jPanel3.setLayout(null);
    btnNew.setBackground(Color.lightGray);
    btnNew.setBounds(new Rectangle(6, 5, 96, 20));
    btnNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNew.setText("NEW RECORD");
    btnNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNew_actionPerformed(e);
      }
    });
    btnConfirm.setBackground(Color.lightGray);
    btnConfirm.setBounds(new Rectangle(108, 5, 96, 20));
    btnConfirm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnConfirm.setText("CONFIRM EDIT");
    jButton3.setBackground(Color.lightGray);
    jButton3.setBounds(new Rectangle(210, 5, 60, 20));
    jButton3.setEnabled(false);
    jButton3.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton3.setText("COPY");
    jButton4.setBackground(Color.lightGray);
    jButton4.setBounds(new Rectangle(276, 5, 60, 20));
    jButton4.setEnabled(false);
    jButton4.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton4.setDoubleBuffered(false);
    jButton4.setText("PASTE");
    jButton5.setBackground(Color.lightGray);
    jButton5.setBounds(new Rectangle(342, 5, 60, 20));
    jButton5.setEnabled(false);
    jButton5.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton5.setText("DELETE");
    jButton6.setBackground(Color.lightGray);
    jButton6.setBounds(new Rectangle(506, 5, 60, 20));
    jButton6.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton6.setText("EXIT");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton6_actionPerformed(e);
      }
    });
    jTabbedPane1.setTabPlacement(JTabbedPane.TOP);
    jTabbedPane1.setBackground(new Color(210, 208, 200));

    jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTabbedPane1.setForeground(new Color(10,36,106));

    jPanel4.setLayout(null);
    jPanel5.setBackground(new Color(190, 190, 225));
    jPanel5.setLayout(null);
    jLabel2.setText("      ============  Material Detail Add  ============      ");
    jLabel2.setBounds(new Rectangle(100, 18, 566, 24));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextField35.setBackground(new Color(143, 143, 188));
    jTextField35.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField35.setForeground(new Color(10,36,106));
    jTextField35.setBorder(null);
    jTextField35.setText(" Mill :");
    jTextField35.setOpaque(true);
    jTextField35.setBounds(new Rectangle(21, 57, 111, 25));
    jTextField36.setBackground(new Color(143, 143, 188));
    jTextField36.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField36.setForeground(new Color(10,36,106));
    jTextField36.setBorder(null);
    jTextField36.setText(" Mill\'s MTR-NO :");
    jTextField36.setOpaque(true);
    jTextField36.setBounds(new Rectangle(359, 57, 111, 25));
    jComboBox1.setBounds(new Rectangle(133, 57, 208, 25));
    jTextField37.setText("jTextField37");
    jTextField37.setBounds(new Rectangle(471, 57, 173, 25));
    jTextField38.setBackground(new Color(143, 143, 188));
    jTextField38.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField38.setForeground(Color.white);
    jTextField38.setBorder(null);
    jTextField38.setText(" USD :");
    jTextField38.setOpaque(true);
    jTextField38.setBounds(new Rectangle(21, 103, 80, 25));
    jTextField39.setBackground(new Color(143, 143, 188));
    jTextField39.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField39.setForeground(new Color(10,36,106));
    jTextField39.setBorder(null);
    jTextField39.setText(" Local :");
    jTextField39.setOpaque(true);
    jTextField39.setBounds(new Rectangle(21, 136, 80, 25));
    jTextField40.setBackground(new Color(143, 143, 188));
    jTextField40.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField40.setForeground(Color.white);
    jTextField40.setBorder(null);
    jTextField40.setText(" UNIT :");
    jTextField40.setOpaque(true);
    jTextField40.setBounds(new Rectangle(202, 103, 80, 25));
    jTextField41.setBackground(new Color(143, 143, 188));
    jTextField41.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField41.setBorder(null);
    jTextField41.setText(" UNIT :");
    jTextField41.setOpaque(true);
    jTextField41.setBounds(new Rectangle(202, 136, 80, 25));
    jTextField42.setBackground(new Color(143, 143, 188));
    jTextField42.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField42.setForeground(Color.white);
    jTextField42.setBorder(null);
    jTextField42.setText(" CNFM USD :");
    jTextField42.setOpaque(true);
    jTextField42.setBounds(new Rectangle(341, 103, 80, 25));
    jTextField43.setBackground(new Color(143, 143, 188));
    jTextField43.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField43.setForeground(new Color(10,36,106));
    jTextField43.setBorder(null);
    jTextField43.setText(" CNFM Local :");
    jTextField43.setOpaque(true);
    jTextField43.setBounds(new Rectangle(341, 136, 80, 25));
    jTextField44.setBackground(new Color(143, 143, 188));
    jTextField44.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField44.setForeground(Color.white);
    jTextField44.setBorder(null);
    jTextField44.setText(" TERM :");
    jTextField44.setOpaque(true);
    jTextField44.setBounds(new Rectangle(522, 102, 80, 25));
    jTextField45.setBackground(new Color(143, 143, 188));
    jTextField45.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField45.setForeground(Color.white);
    jTextField45.setBorder(null);
    jTextField45.setText(" DEST :");
    jTextField45.setOpaque(true);
    jTextField45.setBounds(new Rectangle(522, 136, 80, 25));
    jTextField46.setText("000");
    jTextField46.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField46.setBounds(new Rectangle(102, 103, 42, 25));
    jTextField47.setText("00");
    jTextField47.setBounds(new Rectangle(156, 103, 28, 25));
    jTextField48.setBounds(new Rectangle(283, 103, 42, 25));
    jTextField49.setBounds(new Rectangle(422, 103, 42, 25));
    jTextField50.setBounds(new Rectangle(478, 103, 28, 25));
    jTextField51.setText("jTextField51");
    jTextField51.setBounds(new Rectangle(102, 136, 42, 25));
    jTextField52.setText("jTextField52");
    jTextField52.setBounds(new Rectangle(156, 136, 28, 25));
    jTextField53.setText("jTextField53");
    jTextField53.setBounds(new Rectangle(283, 136, 42, 25));
    jTextField54.setText("jTextField54");
    jTextField54.setBounds(new Rectangle(422, 136, 42, 25));
    jTextField55.setBounds(new Rectangle(478, 136, 28, 25));
    jComboBox2.setBounds(new Rectangle(605, 102, 144, 25));
    jTextField56.setBounds(new Rectangle(605, 136, 144, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel3.setText(".");
    jLabel3.setBounds(new Rectangle(147, 110, 13, 21));
    jLabel4.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel4.setText("/");
    jLabel4.setBounds(new Rectangle(189, 103, 12, 27));
    jLabel5.setBounds(new Rectangle(147, 144, 13, 21));
    jLabel5.setText(".");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel6.setBounds(new Rectangle(468, 110, 13, 21));
    jLabel6.setText(".");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel7.setBounds(new Rectangle(468, 143, 13, 21));
    jLabel7.setText(".");
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel8.setBounds(new Rectangle(189, 136, 12, 27));
    jLabel8.setText("/");
    jLabel8.setFont(new java.awt.Font("Dialog", 0, 20));
    jButton7.setBackground(Color.lightGray);
    jButton7.setBounds(new Rectangle(408, 5, 60, 20));
    jButton7.setEnabled(false);
    jButton7.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton7.setText("Print");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton7_actionPerformed(e);
      }
    });
    jTextField57.setBackground(new Color(143, 143, 188));
    jTextField57.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField57.setForeground(Color.white);
    jTextField57.setBorder(null);
    jTextField57.setText(" DUPS MINQTY :");
    jTextField57.setOpaque(true);
    jTextField57.setBounds(new Rectangle(21, 184, 111, 25));
    jTextField58.setBackground(new Color(143, 143, 188));
    jTextField58.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField58.setForeground(Color.white);
    jTextField58.setBorder(null);
    jTextField58.setCaretColor(Color.white);
    jTextField58.setText(" LEAD TIME :");
    jTextField58.setOpaque(true);
    jTextField58.setBounds(new Rectangle(341, 184, 111, 25));
    jTextField59.setText("123456");
    jTextField59.setBounds(new Rectangle(133, 184, 69, 25));
    jTextField60.setText("123");
    jTextField60.setBounds(new Rectangle(453, 184, 37, 25));
    jTextField61.setBackground(new Color(143, 143, 188));
    jTextField61.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField61.setForeground(new Color(10,36,106));
    jTextField61.setBorder(null);
    jTextField61.setText(" BULK MINQTY :");
    jTextField61.setOpaque(true);
    jTextField61.setBounds(new Rectangle(21, 216, 111, 25));
    jTextField62.setText("jTextField62");
    jTextField62.setBounds(new Rectangle(133, 216, 69, 25));
    jTextField63.setBackground(new Color(143, 143, 188));
    jTextField63.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField63.setForeground(new Color(10,36,106));
    jTextField63.setBorder(null);
    jTextField63.setText(" BULK MINQTY :");
    jTextField63.setOpaque(true);
    jTextField63.setBounds(new Rectangle(341, 216, 111, 25));
    jTextField64.setText("jTextField64");
    jTextField64.setBounds(new Rectangle(453, 216, 37, 25));
    jTextField65.setBackground(new Color(143, 143, 188));
    jTextField65.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField65.setForeground(Color.white);
    jTextField65.setBorder(null);
    jTextField65.setText(" Commited Date-1 :");
    jTextField65.setOpaque(true);
    jTextField65.setBounds(new Rectangle(21, 260, 111, 25));
    jTextField66.setText("2003");
    jTextField66.setBounds(new Rectangle(133, 260, 39, 25));
    jTextField67.setText("01");
    jTextField67.setBounds(new Rectangle(184, 260, 30, 25));
    jTextField68.setText("22");
    jTextField68.setBounds(new Rectangle(225, 260, 30, 25));
    jLabel9.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel9.setText("/");
    jLabel9.setBounds(new Rectangle(175, 260, 12, 27));
    jLabel10.setBounds(new Rectangle(216, 260, 12, 27));
    jLabel10.setText("/");
    jLabel10.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setForeground(new Color(143, 143, 188));
    jLabel11.setText("(YYYY/MM/DD)");
    jLabel11.setBounds(new Rectangle(258, 263, 84, 19));
    jTextField69.setBackground(new Color(143, 143, 188));
    jTextField69.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField69.setForeground(Color.white);
    jTextField69.setBorder(null);
    jTextField69.setText(" Commited Yard-1 :");
    jTextField69.setBounds(new Rectangle(341, 260, 111, 25));
    jTextField70.setText("123456");
    jTextField70.setBounds(new Rectangle(453, 260, 63, 25));
    jTextField71.setBackground(new Color(143, 143, 188));
    jTextField71.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField71.setForeground(new Color(10,36,106));
    jTextField71.setBorder(null);
    jTextField71.setText(" Confirm Person-1 :");
    jTextField71.setOpaque(true);
    jTextField71.setBounds(new Rectangle(21, 293, 111, 25));
    jTextField72.setText("jTextField72");
    jTextField72.setBounds(new Rectangle(133, 293, 383, 26));
    jTextField73.setBounds(new Rectangle(133, 358, 383, 26));
    jTextField73.setText("jTextField72");
    jTextField74.setBounds(new Rectangle(21, 358, 111, 25));
    jTextField74.setText(" Confirm Person-2 :");
    jTextField74.setOpaque(true);
    jTextField74.setBorder(null);
    jTextField74.setForeground(new Color(10,36,106));
    jTextField74.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField74.setBackground(new Color(143, 143, 188));
    jTextField610.setBounds(new Rectangle(341, 325, 111, 25));
    jTextField610.setText(" Commited Yard-2 :");
    jTextField610.setOpaque(true);
    jTextField610.setBorder(null);
    jTextField610.setForeground(Color.white);
    jTextField610.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField610.setBackground(new Color(143, 143, 188));
    jTextField75.setBounds(new Rectangle(453, 325, 63, 25));
    jTextField75.setText("123456");
    jTextField611.setBounds(new Rectangle(225, 325, 30, 25));
    jTextField611.setText("22");
    jTextField612.setBounds(new Rectangle(184, 325, 30, 25));
    jTextField612.setText("01");
    jTextField613.setBounds(new Rectangle(133, 325, 39, 25));
    jTextField613.setText("2003");
    jLabel12.setBounds(new Rectangle(258, 328, 84, 19));
    jLabel12.setText("(YYYY/MM/DD)");
    jLabel12.setForeground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel13.setText("/");
    jLabel13.setBounds(new Rectangle(216, 325, 12, 27));
    jTextField614.setBounds(new Rectangle(21, 325, 111, 25));
    jTextField614.setText(" Commited Date-2 :");
    jTextField614.setOpaque(true);
    jTextField614.setBorder(null);
    jTextField614.setForeground(Color.white);
    jTextField614.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField614.setBackground(new Color(143, 143, 188));
    jLabel14.setBounds(new Rectangle(175, 325, 12, 27));
    jLabel14.setText("/");
    jLabel14.setFont(new java.awt.Font("Dialog", 0, 20));
    jTextField76.setBackground(new Color(143, 143, 188));
    jTextField76.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField76.setForeground(Color.white);
    jTextField76.setBorder(null);
    jTextField76.setText(" Detail Remark :");
    jTextField76.setOpaque(true);
    jTextField76.setBounds(new Rectangle(21, 399, 111, 25));
    jTextArea1.setText("jTextArea1");
    jTextArea1.setBounds(new Rectangle(133, 399, 612, 49));
    jLabel15.setBounds(new Rectangle(100, 16, 566, 24));
    jLabel15.setText("      ============  History List - Edit  ============      ");
    jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 13));
    jScrollPane3.getViewport().setBackground(new Color(204, 204, 225));
    jScrollPane3.setBounds(new Rectangle(22, 68, 719, 384));
    jPanel2.setBackground(new Color(210, 208, 200));
    jPanel4.setBackground(new Color(210, 208, 200));
    jTextField18.setOpaque(true);
    jTextField18.setText(" Pattern Name :");
    jTextField18.setBorder(null);
    jTextField18.setForeground(Color.white);
    jTextField18.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField18.setBackground(new Color(143, 143, 188));
    jTextField110.setOpaque(true);
    jTextField110.setText(" Tariff No :");
    jTextField110.setBorder(null);
    jTextField110.setForeground(Color.white);
    jTextField110.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField110.setBackground(new Color(143, 143, 188));
    jTextField111.setBackground(new Color(143, 143, 188));
    jTextField111.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField111.setForeground(new Color(10,36,106));
    jTextField111.setBorder(null);
    jTextField111.setText(" Quota :");
    jTextField111.setOpaque(true);
    jPanel1.add(jTextField2,                          new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(44, 17, 0, 0), 65, -1));
    jPanel1.add(jTextField4,                          new GridBagConstraints(2, 2, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 17, 0, 0), 49, -1));
    jPanel1.add(jTextField22,                          new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 0), 181, -1));
    jPanel1.add(jTextField6,                          new GridBagConstraints(2, 3, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 17, 0, 0), 41, -1));
    jPanel1.add(jTextField24,                          new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 0), 181, -1));
    jPanel1.add(jTextField8,                          new GridBagConstraints(2, 4, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 17, 0, 0), 81, -1));
    jPanel1.add(jTextField26,                          new GridBagConstraints(1, 5, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 0), 181, -1));
    jPanel1.add(jTextField10,                          new GridBagConstraints(2, 5, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 17, 0, 0), 35, -1));
    jPanel1.add(jTextField28,                          new GridBagConstraints(1, 6, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 0), 181, -1));
    jPanel1.add(jTextField29,                          new GridBagConstraints(1, 7, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 0), 181, -1));
    jPanel1.add(jTextField13,                          new GridBagConstraints(2, 7, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 17, 0, 0), 50, -1));
    jPanel1.add(jTextField31,                          new GridBagConstraints(1, 8, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 0), 181, -1));
    jPanel1.add(jTextField15,                          new GridBagConstraints(2, 8, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 17, 0, 0), 53, -1));
    jPanel1.add(jTextField33,                          new GridBagConstraints(1, 9, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 0), 181, -1));
    jPanel1.add(jTextField17,                          new GridBagConstraints(2, 9, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 17, 0, 0), 64, -1));
    jPanel1.add(jLabel1,                          new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(19, 111, 0, 94), 217, 0));
    jPanel1.add(jComboBox3,                          new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(44, 0, 0, 0), 58, -1));
    jPanel1.add(jComboBox4,                          new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 0), 58, -1));
    jPanel1.add(jTextField32,                          new GridBagConstraints(3, 8, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField34,                          new GridBagConstraints(3, 9, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField19,                          new GridBagConstraints(3, 1, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(44, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField21,                          new GridBagConstraints(3, 2, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField23,                          new GridBagConstraints(3, 3, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField25,                          new GridBagConstraints(3, 4, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField27,                          new GridBagConstraints(3, 5, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField30,                          new GridBagConstraints(3, 7, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField5,                          new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 85, 0, 0), 68, -1));
    jPanel1.add(jTextField7,                         new GridBagConstraints(0, 4, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 85, 0, 0), 20, -1));
    jPanel1.add(jTextField9,                         new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 85, 0, 0), 79, -1));
    jPanel1.add(jTextField11,                         new GridBagConstraints(0, 6, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 85, 0, 0), 72, -1));
    jPanel1.add(jTextField12,                         new GridBagConstraints(0, 7, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 85, 0, 0), 55, -1));
    jPanel1.add(jTextField14,                         new GridBagConstraints(0, 8, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 85, 0, 0), 41, -1));
    jPanel1.add(jTextField16,                         new GridBagConstraints(0, 9, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 85, 0, 0), 34, -1));
    jPanel1.add(jTextField1,                         new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(44, 85, 0, 0), 74, -1));
    jPanel1.add(jTextField3,                         new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(14, 85, 0, 0), 85, -1));
    jPanel1.add(jTextField18,                       new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 85, 0, 0), 34, 0));
    jPanel1.add(jTextField310,                              new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 0), 181, 0));
    jPanel1.add(jTextField110,                                 new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 17, 0, 0), 64, 0));
    jPanel1.add(jTextField311,               new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 0, 0, 41), 183, -1));
    jPanel1.add(jTextField111,           new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(13, 85, 0, 0), 34, 0));
    jPanel1.add(jComboBox5,          new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(14, 0, 0, 0), 58, -1));
    jSplitPane1.setDividerLocation(533);
    jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
    jScrollPane1.getViewport().add(jPanel1, null);
    jSplitPane1.add(jScrollPane2, JSplitPane.BOTTOM);
    jScrollPane2.getViewport().add(jPanel2, null);
    jPanel2.add(jTabbedPane1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 1, 0, 0), 765, 453));
    this.add(jPanel3, null);
    jPanel3.add(btnNew, null);
    jPanel3.add(btnConfirm, null);
    jPanel3.add(jButton3, null);
    jPanel3.add(jButton4, null);
    jPanel3.add(jButton5, null);
    jPanel3.add(jButton7, null);
    jPanel3.add(jButton6, null);
    jPanel5.add(jLabel15, null);
    jPanel5.add(jScrollPane3, null);
    jScrollPane3.getViewport().add(jTable1, null);
    jTabbedPane1.add(jPanel4, "Price / Detail / Mill");
    jTabbedPane1.add(jPanel5, "History");
    jScrollPane3.getViewport().add(jTable1, null);
    this.add(jSplitPane1, null);
    jTabbedPane1.setEnabled(false);
  }

  void jButton6_actionPerformed(ActionEvent e) {
    //frame.showPanel(new newtimes.material.MaterialSearch(frame));
  }

  void btnNew_actionPerformed(ActionEvent e) {
    jTabbedPane1.setEnabled(true);
    jSplitPane1.setDividerLocation(250);
    jPanel2.setBackground(new Color(204, 204, 225));
    jTabbedPane1.setBackground(new Color(190, 190, 225));
    jPanel4.setBackground(new Color(190, 190, 225));
    jPanel4.add(jComboBox1, null);
    jPanel4.add(jTextField35, null);
    jPanel4.add(jTextField36, null);
    jPanel4.add(jTextField37, null);
    jPanel4.add(jTextField611, null);
    jPanel4.add(jLabel12, null);
    jPanel4.add(jTextField610, null);
    jPanel4.add(jTextField75, null);
    jPanel4.add(jTextField74, null);
    jPanel4.add(jTextField73, null);
    jPanel4.add(jTextField76, null);
    jPanel4.add(jTextArea1, null);
    jPanel4.add(jTextField44, null);
    jPanel4.add(jTextField48, null);
    jPanel4.add(jTextField46, null);
    jPanel4.add(jLabel4, null);
    jPanel4.add(jTextField45, null);
    jPanel4.add(jTextField47, null);
    jPanel4.add(jTextField55, null);
    jPanel4.add(jTextField50, null);
    jPanel4.add(jTextField42, null);
    jPanel4.add(jTextField49, null);
    jPanel4.add(jTextField56, null);
    jPanel4.add(jTextField40, null);
    jPanel4.add(jComboBox2, null);
    jPanel4.add(jLabel3, null);
    jPanel4.add(jLabel6, null);
    jPanel4.add(jTextField38, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(jTextField54, null);
    jPanel4.add(jTextField43, null);
    jPanel4.add(jTextField53, null);
    jPanel4.add(jTextField41, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(jTextField52, null);
    jPanel4.add(jLabel5, null);
    jPanel4.add(jTextField51, null);
    jPanel4.add(jTextField39, null);
    jPanel4.add(jTextField57, null);
    jPanel4.add(jTextField59, null);
    jPanel4.add(jTextField58, null);
    jPanel4.add(jTextField60, null);
    jPanel4.add(jTextField64, null);
    jPanel4.add(jTextField63, null);
    jPanel4.add(jTextField62, null);
    jPanel4.add(jTextField61, null);
    jPanel4.add(jTextField65, null);
    jPanel4.add(jTextField66, null);
    jPanel4.add(jLabel9, null);
    jPanel4.add(jTextField67, null);
    jPanel4.add(jLabel10, null);
    jPanel4.add(jTextField68, null);
    jPanel4.add(jLabel11, null);
    jPanel4.add(jTextField69, null);
    jPanel4.add(jTextField70, null);
    jPanel4.add(jTextField72, null);
    jPanel4.add(jTextField71, null);
    jPanel4.add(jTextField614, null);
    jPanel4.add(jTextField613, null);
    jPanel4.add(jLabel14, null);
    jPanel4.add(jTextField612, null);
    jPanel4.add(jLabel13, null);
    jPanel4.add(jLabel2, null);
    jPanel4.repaint();
    jPanel4.validate();

    jPanel1.setBackground(new Color(204, 204, 225));
    jComboBox3.setEnabled(false);
    jComboBox4.setEnabled(false);
    jTextField22.setBackground(new Color(212, 208, 200));
    jTextField22.setEnabled(false);
    jTextField24.setBackground(new Color(212, 208, 200));
    jTextField24.setEnabled(false);
    jTextField26.setBackground(new Color(212, 208, 200));
    jTextField26.setEnabled(false);
    jTextField28.setBackground(new Color(212, 208, 200));
    jTextField28.setEnabled(false);
    jTextField29.setBackground(new Color(212, 208, 200));
    jTextField29.setEnabled(false);
    jTextField31.setBackground(new Color(212, 208, 200));
    jTextField31.setEnabled(false);
    jTextField33.setBackground(new Color(212, 208, 200));
    jTextField33.setEnabled(false);
    jTextField19.setBackground(new Color(212, 208, 200));
    jTextField19.setEnabled(false);
    jTextField21.setBackground(new Color(212, 208, 200));
    jTextField21.setEnabled(false);
    jTextField23.setBackground(new Color(212, 208, 200));
    jTextField23.setEnabled(false);
    jTextField25.setBackground(new Color(212, 208, 200));
    jTextField25.setEnabled(false);
    jTextField27.setBackground(new Color(212, 208, 200));
    jTextField27.setEnabled(false);
    jTextField30.setBackground(new Color(212, 208, 200));
    jTextField30.setEnabled(false);
    jTextField32.setBackground(new Color(212, 208, 200));
    jTextField32.setEnabled(false);
    jTextField34.setBackground(new Color(212, 208, 200));
    jTextField34.setEnabled(false);
    jPanel1.repaint();
    jPanel1.validate();
  }

  void jButton7_actionPerformed(ActionEvent e) {
    //frame.showPanel(new newtimes.material.PrintSticker(frame));
  }

  void setTable(){
    try{
      Object[][] data = {{"1","","","","","","","","","","","",""},
                         {"2","","","","","","","","","","","",""},
                         {"","","","","","","","","","","","",""}};
      Object[] head = {"SEQ","Date","CIF/Yard","Color Pattern","Origin Year",
                       "Origin Season","Origin Div","Package Side Mark","N/J",
                       "Lock Year","Lock Season","Lock Div","Lock Date"};
      jTable1 = tableModel.DefTabelModel(data, head);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(jTextField22,null,"",60);
    tx = new exgui.DataBindText(jTextField24,null,"",200);
    tx = new exgui.DataBindText(jTextField34,null,"",200);
  }
}
