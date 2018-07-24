package newtimes.basic.exchange;

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

public class ExchangeEdit extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JButton butnExit = new JButton();
  private JButton butnModify = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JTextField txtYM = new JTextField();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField6 = new JLabel();
  private JLabel jTextField7 = new JLabel();
  private JLabel jTextField8 = new JLabel();
  private JLabel jTextField9 = new JLabel();
  private JLabel jTextField10 = new JLabel();
  private JTextField txt1 = new JTextField();
  private JLabel jTextField12 = new JLabel();
  private JTextField txt2 = new JTextField();
  private JLabel jTextField14 = new JLabel();
  private JTextField txt3 = new JTextField();
  private JTextField txt4 = new JTextField();
  private JLabel jTextField17 = new JLabel();
  private JTextField txt5 = new JTextField();
  private JLabel jTextField19 = new JLabel();
  private JLabel jTextField20 = new JLabel();
  private JTextField txt6 = new JTextField();
  private JTextField txt10 = new JTextField();
  private JTextField txt9 = new JTextField();
  private JLabel jTextField112 = new JLabel();
  private JTextField txt8 = new JTextField();
  private JLabel jTextField114 = new JLabel();
  private JTextField txt7 = new JTextField();
  private JTextField txt12 = new JTextField();
  private JLabel jTextField116 = new JLabel();
  private JTextField txt11 = new JTextField();
  private JLabel jTextField23 = new JLabel();
  private JLabel jTextField118 = new JLabel();
  private JTextField txt16 = new JTextField();
  private JTextField txt15 = new JTextField();
  private JLabel jTextField1111 = new JLabel();
  private JTextField txt14 = new JTextField();
  private JLabel jTextField1113 = new JLabel();
  private JTextField txt13 = new JTextField();
  private JTextField txt18 = new JTextField();
  private JLabel jTextField1115 = new JLabel();
  private JTextField txt17 = new JTextField();
  private JLabel jTextField25 = new JLabel();
  private JLabel jTextField1117 = new JLabel();
  private JTextField txt22 = new JTextField();
  private JTextField txt21 = new JTextField();
  private JLabel jTextField11110 = new JLabel();
  private JTextField txt20 = new JTextField();
  private JLabel jTextField11112 = new JLabel();
  private JTextField txt19 = new JTextField();
  private JTextField txt24 = new JTextField();
  private JLabel jTextField11114 = new JLabel();
  private JTextField txt23 = new JTextField();
  private JLabel jTextField27 = new JLabel();
  private JLabel jTextField11116 = new JLabel();
  private JTextField txt28 = new JTextField();
  private JTextField txt27 = new JTextField();
  private JLabel jTextField11119 = new JLabel();
  private JTextField txt26 = new JTextField();
  private JLabel jTextField111111 = new JLabel();
  private JTextField txt25 = new JTextField();
  private JTextField txt30 = new JTextField();
  private JLabel jTextField111113 = new JLabel();
  private JTextField txt29 = new JTextField();
  private JLabel jTextField29 = new JLabel();
  private JLabel jTextField111115 = new JLabel();
  private JTextField txt31 = new JTextField();
  private JComboBox cmboBase = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXBase = null;
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private database.datatype.Record rec = null;
  private String[][] array = new String[31][6];
  private JTextField[] txt = {
      txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,
      txt9,txt10,txt11,txt12,txt13,
      txt14,txt15,txt16,txt17,txt18,
      txt19,txt20,txt21,txt22,txt23,
      txt24,txt25,txt26,txt27,txt28,
      txt29,txt30,txt31};
  protected exgui.DataBindTextWithChecker [] dbTxtChkers=
      new exgui.DataBindTextWithChecker[31];
  JLabel jTextField4 = new JLabel();
  JComboBox cmboExchange = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXExchange = null;
  private exgui.DataBindJCombobox dbJCBXCen = null;
  JComboBox cmboCen = new JComboBox();
  JLabel jTextField11 = new JLabel();
  JButton btnCopy2All = new JButton();

  public ExchangeEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    //this.setMaxLength();
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Exchange Rate Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setForeground(Color.darkGray);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setBounds(new Rectangle(279, 490, 134, 25));
    butnModify.setBackground(Color.lightGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(429, 490, 80, 25));
    butnExit.setBackground(Color.lightGray);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField1.setBounds(new Rectangle(82, 100, 155, 23));
    jTextField1.setText(" * YYYYMM :");
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(Color.white);
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    txtYM.setText("");
    txtYM.setBounds(new Rectangle(239, 100, 155, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setText(" * Base Currency :");
    jTextField3.setBounds(new Rectangle(82, 132, 155, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setText("   1");
    jTextField5.setBounds(new Rectangle(41, 202, 25, 23));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    //jTextField6.setEditable(false);
    jTextField6.setText("   7");
    jTextField6.setBounds(new Rectangle(41, 236, 25, 23));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(Color.white);
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    //jTextField7.setEditable(false);
    jTextField7.setText("  13");
    jTextField7.setBounds(new Rectangle(41, 271, 25, 23));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    //jTextField8.setEditable(false);
    jTextField8.setText("  19");
    jTextField8.setBounds(new Rectangle(41, 305, 25, 23));
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setBorder(null);
    jTextField9.setOpaque(true);
    //jTextField9.setEditable(false);
    jTextField9.setText("  25");
    jTextField9.setBounds(new Rectangle(41, 340, 25, 23));
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(new Color(10,36,106));
    jTextField10.setBorder(null);
    jTextField10.setOpaque(true);
    //jTextField10.setEditable(false);
    jTextField10.setText("  31");
    jTextField10.setBounds(new Rectangle(41, 374, 25, 23));
    txt1.setText("");
    txt1.setHorizontalAlignment(SwingConstants.RIGHT);
    txt1.setBounds(new Rectangle(67, 202, 81, 23));
    /*
    txt1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt1_keyTyped(e);
      }
    });
    */
    jTextField12.setBackground(new Color(143, 143, 188));
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setForeground(Color.white);
    jTextField12.setBorder(null);
    jTextField12.setOpaque(true);
    //jTextField12.setEditable(false);
    jTextField12.setText("   2");
    jTextField12.setBounds(new Rectangle(161, 202, 25, 23));
    txt2.setText("");
    txt2.setHorizontalAlignment(SwingConstants.RIGHT);
    txt2.setBounds(new Rectangle(187, 202, 81, 23));
    /*
    txt2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt2_keyTyped(e);
      }
    });
    */
    jTextField14.setBackground(new Color(143, 143, 188));
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setForeground(Color.white);
    jTextField14.setBorder(null);
    jTextField14.setOpaque(true);
    //jTextField14.setEditable(false);
    jTextField14.setText("   3");
    jTextField14.setBounds(new Rectangle(281, 202, 25, 23));
    txt3.setText("");
    txt3.setHorizontalAlignment(SwingConstants.RIGHT);
    txt3.setBounds(new Rectangle(307, 202, 81, 23));
    /*
    txt3.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt3_keyTyped(e);
      }
    });
    */
    txt4.setText("");
    txt4.setHorizontalAlignment(SwingConstants.RIGHT);
    txt4.setBounds(new Rectangle(427, 202, 81, 23));
    /*
    txt4.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt4_keyTyped(e);
      }
    });
    */
    jTextField17.setBackground(new Color(143, 143, 188));
    jTextField17.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField17.setForeground(Color.white);
    jTextField17.setBorder(null);
    jTextField17.setOpaque(true);
    //jTextField17.setEditable(false);
    jTextField17.setText("   5");
    jTextField17.setBounds(new Rectangle(521, 202, 25, 23));
    txt5.setText("");
    txt5.setHorizontalAlignment(SwingConstants.RIGHT);
    txt5.setBounds(new Rectangle(547, 202, 81, 23));
    /*
    txt5.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt5_keyTyped(e);
      }
    });
   */
    jTextField19.setBackground(new Color(143, 143, 188));
    jTextField19.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField19.setForeground(Color.white);
    jTextField19.setBorder(null);
    jTextField19.setOpaque(true);
    //jTextField19.setEditable(false);
    jTextField19.setText("   6");
    jTextField19.setBounds(new Rectangle(641, 202, 25, 23));
    jTextField20.setBackground(new Color(143, 143, 188));
    jTextField20.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField20.setForeground(Color.white);
    jTextField20.setBorder(null);
    jTextField20.setOpaque(true);
    //jTextField20.setEditable(false);
    jTextField20.setText("   4");
    jTextField20.setBounds(new Rectangle(401, 202, 25, 23));
    txt6.setText("");
    txt6.setHorizontalAlignment(SwingConstants.RIGHT);
    txt6.setBounds(new Rectangle(668, 202, 81, 23));
    /*
    txt6.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt6_keyTyped(e);
      }
    });
    */
    txt10.setBounds(new Rectangle(427, 236, 81, 23));
    /*
    txt10.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt10_keyTyped(e);
      }
    });
    */
    txt10.setText("");
    txt10.setHorizontalAlignment(SwingConstants.RIGHT);
    txt9.setBounds(new Rectangle(307, 236, 81, 23));
    /*
    txt9.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt9_keyTyped(e);
      }
    });
    */
    txt9.setForeground(Color.black);
    txt9.setText("");
    txt9.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField112.setBounds(new Rectangle(281, 236, 25, 23));
    jTextField112.setText("   9");
    jTextField112.setBorder(null);
    jTextField112.setOpaque(true);
    //jTextField112.setEditable(false);
    jTextField112.setForeground(new Color(10,36,106));
    jTextField112.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField112.setBackground(new Color(143, 143, 188));
    txt8.setBounds(new Rectangle(187, 236, 81, 23));
    /*
    txt8.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt8_keyTyped(e);
      }
    });
    */
    txt8.setText("");
    txt8.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField114.setBounds(new Rectangle(161, 236, 25, 23));
    jTextField114.setText("   8");
    jTextField114.setBorder(null);
    jTextField114.setOpaque(true);
    //jTextField114.setCaretColor(Color.black);
    //jTextField114.setEditable(false);
    jTextField114.setForeground(new Color(10,36,106));
    jTextField114.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField114.setBackground(new Color(143, 143, 188));
    txt7.setBounds(new Rectangle(67, 236, 81, 23));
    /*
    txt7.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt7_keyTyped(e);
      }
    });
    */
    txt7.setText("");
    txt7.setHorizontalAlignment(SwingConstants.RIGHT);
    txt12.setBounds(new Rectangle(668, 236, 81, 23));
    /*
    txt12.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt12_keyTyped(e);
      }
    });
    */
    txt12.setText("");
    txt12.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField116.setBounds(new Rectangle(641, 236, 25, 23));
    jTextField116.setText("  12");
    jTextField116.setBorder(null);
    jTextField116.setOpaque(true);
    //jTextField116.setEditable(false);
    jTextField116.setForeground(new Color(10,36,106));
    jTextField116.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField116.setBackground(new Color(143, 143, 188));
    txt11.setBounds(new Rectangle(547, 236, 81, 23));
    /*
    txt11.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt11_keyTyped(e);
      }
    });
    */
    txt11.setText("");
    txt11.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField23.setBounds(new Rectangle(401, 236, 25, 23));
    jTextField23.setText("  10");
    jTextField23.setBorder(null);
    jTextField23.setOpaque(true);
    //jTextField23.setEditable(false);
    jTextField23.setForeground(new Color(10,36,106));
    jTextField23.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField23.setBackground(new Color(143, 143, 188));
    jTextField118.setBounds(new Rectangle(521, 236, 25, 23));
    jTextField118.setText("  11");
    jTextField118.setBorder(null);
    jTextField118.setOpaque(true);
    //jTextField118.setEditable(false);
    jTextField118.setForeground(new Color(10,36,106));
    jTextField118.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField118.setBackground(new Color(143, 143, 188));
    txt16.setBounds(new Rectangle(427, 271, 81, 23));
    /*
    txt16.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt16_keyTyped(e);
      }
    });
    */
    txt16.setText("");
    txt16.setHorizontalAlignment(SwingConstants.RIGHT);
    txt15.setBounds(new Rectangle(307, 271, 81, 23));
    /*
    txt15.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt15_keyTyped(e);
      }
    });
    */
    txt15.setText("");
    txt15.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField1111.setBounds(new Rectangle(281, 271, 25, 23));
    jTextField1111.setText("  15");
    jTextField1111.setBorder(null);
    jTextField1111.setOpaque(true);
    //jTextField1111.setEditable(false);
    jTextField1111.setForeground(Color.white);
    jTextField1111.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1111.setBackground(new Color(143, 143, 188));
    txt14.setBounds(new Rectangle(187, 271, 81, 23));
    /*
    txt14.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt14_keyTyped(e);
      }
    });
    */
    txt14.setText("");
    txt14.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField1113.setBounds(new Rectangle(161, 271, 25, 23));
    jTextField1113.setText("  14");
    jTextField1113.setBorder(null);
    jTextField1113.setOpaque(true);
    //jTextField1113.setEditable(false);
    jTextField1113.setForeground(Color.white);
    jTextField1113.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1113.setBackground(new Color(143, 143, 188));
    txt13.setBounds(new Rectangle(67, 271, 81, 23));
    /*
    txt13.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt13_keyTyped(e);
      }
    });
    */
    txt13.setText("");
    txt13.setHorizontalAlignment(SwingConstants.RIGHT);
    txt18.setBounds(new Rectangle(668, 271, 81, 23));
    /*
    txt18.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt18_keyTyped(e);
      }
    });
    */
    txt18.setText("");
    txt18.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField1115.setBounds(new Rectangle(641, 271, 25, 23));
    jTextField1115.setText("  18");
    jTextField1115.setBorder(null);
    jTextField1115.setOpaque(true);
    //jTextField1115.setEditable(false);
    jTextField1115.setForeground(Color.white);
    jTextField1115.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1115.setBackground(new Color(143, 143, 188));
    txt17.setBounds(new Rectangle(547, 271, 81, 23));
    /*
    txt17.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt17_keyTyped(e);
      }
    });
    */
    txt17.setText("");
    txt17.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField25.setBounds(new Rectangle(401, 271, 25, 23));
    jTextField25.setText("  16");
    jTextField25.setBorder(null);
    jTextField25.setOpaque(true);
    //jTextField25.setEditable(false);
    jTextField25.setForeground(Color.white);
    jTextField25.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField25.setBackground(new Color(143, 143, 188));
    jTextField1117.setBounds(new Rectangle(521, 271, 25, 23));
    jTextField1117.setText("  17");
    jTextField1117.setBorder(null);
    jTextField1117.setOpaque(true);
    //jTextField1117.setEditable(false);
    jTextField1117.setForeground(Color.white);
    jTextField1117.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1117.setBackground(new Color(143, 143, 188));
    txt22.setBounds(new Rectangle(427, 305, 81, 23));
    /*
    txt22.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt22_keyTyped(e);
      }
    });
    */
    txt22.setText("");
    txt22.setHorizontalAlignment(SwingConstants.RIGHT);
    txt21.setBounds(new Rectangle(307, 305, 81, 23));
    /*
    txt21.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt21_keyTyped(e);
      }
    });
    */
    txt21.setText("");
    txt21.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField11110.setBounds(new Rectangle(281, 305, 25, 23));
    jTextField11110.setText("  21");
    jTextField11110.setBorder(null);
    jTextField11110.setOpaque(true);
    //jTextField11110.setEditable(false);
    jTextField11110.setForeground(new Color(10,36,106));
    jTextField11110.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11110.setBackground(new Color(143, 143, 188));
    txt20.setBounds(new Rectangle(187, 305, 81, 23));
    /*
    txt20.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt20_keyTyped(e);
      }
    });
    */
    txt20.setText("");
    txt20.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField11112.setBounds(new Rectangle(161, 305, 25, 23));
    jTextField11112.setText("  20");
    jTextField11112.setBorder(null);
    jTextField11112.setOpaque(true);
    //jTextField11112.setEditable(false);
    jTextField11112.setForeground(new Color(10,36,106));
    jTextField11112.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11112.setBackground(new Color(143, 143, 188));
    txt19.setBounds(new Rectangle(67, 305, 81, 23));
    /*
    txt19.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt19_keyTyped(e);
      }
    });
    */
    txt19.setText("");
    txt19.setHorizontalAlignment(SwingConstants.RIGHT);
    txt24.setBounds(new Rectangle(668, 305, 81, 23));
    /*
    txt24.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt24_keyTyped(e);
      }
    });
    */
    txt24.setText("");
    txt24.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField11114.setBounds(new Rectangle(641, 305, 25, 23));
    jTextField11114.setText("  24");
    jTextField11114.setBorder(null);
    jTextField11114.setOpaque(true);
    //jTextField11114.setEditable(false);
    jTextField11114.setForeground(new Color(10,36,106));
    jTextField11114.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11114.setBackground(new Color(143, 143, 188));
    txt23.setBounds(new Rectangle(547, 305, 81, 23));
    /*
    txt23.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt23_keyTyped(e);
      }
    });
    */
    txt23.setText("");
    txt23.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField27.setBounds(new Rectangle(401, 305, 25, 23));
    jTextField27.setText("  22");
    jTextField27.setBorder(null);
    jTextField27.setOpaque(true);
    //jTextField27.setEditable(false);
    jTextField27.setForeground(new Color(10,36,106));
    jTextField27.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField27.setBackground(new Color(143, 143, 188));
    jTextField11116.setBounds(new Rectangle(521, 305, 25, 23));
    jTextField11116.setText("  23");
    jTextField11116.setBorder(null);
    jTextField11116.setOpaque(true);
    //jTextField11116.setEditable(false);
    jTextField11116.setForeground(new Color(10,36,106));
    jTextField11116.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11116.setBackground(new Color(143, 143, 188));
    txt28.setBounds(new Rectangle(427, 340, 81, 23));
    /*
    txt28.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt28_keyTyped(e);
      }
    });
    */
    txt28.setText("");
    txt28.setHorizontalAlignment(SwingConstants.RIGHT);
    txt27.setBounds(new Rectangle(307, 340, 81, 23));
    /*
    txt27.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt27_keyTyped(e);
      }
    });
    */
    txt27.setText("");
    txt27.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField11119.setBounds(new Rectangle(281, 340, 25, 23));
    jTextField11119.setText("  27");
    jTextField11119.setBorder(null);
    jTextField11119.setOpaque(true);
    //jTextField11119.setEditable(false);
    jTextField11119.setForeground(Color.white);
    jTextField11119.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11119.setBackground(new Color(143, 143, 188));
    txt26.setBounds(new Rectangle(187, 340, 81, 23));
    /*
    txt26.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt26_keyTyped(e);
      }
    });
    */
    txt26.setText("");
    txt26.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField111111.setBounds(new Rectangle(161, 340, 25, 23));
    jTextField111111.setText("  26");
    jTextField111111.setBorder(null);
    jTextField111111.setOpaque(true);
    jTextField111111.setPreferredSize(new Dimension(20, 18));
    //jTextField111111.setEditable(false);
    jTextField111111.setForeground(Color.white);
    jTextField111111.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField111111.setBackground(new Color(143, 143, 188));
    txt25.setBounds(new Rectangle(67, 340, 81, 23));
    /*
    txt25.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt25_keyTyped(e);
      }
    });
    */
    txt25.setText("");
    txt25.setHorizontalAlignment(SwingConstants.RIGHT);
    txt30.setBounds(new Rectangle(668, 340, 81, 23));
    /*
    txt30.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt30_keyTyped(e);
      }
    });
    */
    txt30.setText("");
    txt30.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField111113.setBounds(new Rectangle(641, 340, 25, 23));
    jTextField111113.setText("  30");
    jTextField111113.setBorder(null);
    jTextField111113.setOpaque(true);
    //jTextField111113.setEditable(false);
    jTextField111113.setForeground(Color.white);
    jTextField111113.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField111113.setBackground(new Color(143, 143, 188));
    txt29.setBounds(new Rectangle(547, 340, 81, 23));
    /*
    txt29.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt29_keyTyped(e);
      }
    });
    */
    txt29.setText("");
    txt29.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField29.setBounds(new Rectangle(401, 340, 25, 23));
    jTextField29.setText("  28");
    jTextField29.setBorder(null);
    jTextField29.setOpaque(true);
    //jTextField29.setEditable(false);
    jTextField29.setForeground(Color.white);
    jTextField29.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField29.setBackground(new Color(143, 143, 188));
    jTextField111115.setBounds(new Rectangle(521, 340, 25, 23));
    jTextField111115.setText("  29");
    jTextField111115.setBorder(null);
    jTextField111115.setOpaque(true);
    //jTextField111115.setEditable(false);
    jTextField111115.setForeground(Color.white);
    jTextField111115.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField111115.setBackground(new Color(143, 143, 188));
    txt31.setBounds(new Rectangle(67, 374, 81, 23));
    /*
    txt31.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt31_keyTyped(e);
      }
    });
    */
    cmboBase.setBounds(new Rectangle(239, 132, 155, 23));
    cmboBase.setBackground(Color.white);
    /*
    txt1_1.setBounds(new Rectangle(113, 202, 35, 23));
    txt1_1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt1_1_keyTyped(e);
      }
    });

    txt7_7.setBounds(new Rectangle(113, 236, 35, 23));
    txt7_7.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt7_7_keyTyped(e);
      }
    });
    txt13_13.setBounds(new Rectangle(113, 271, 35, 23));
    txt13_13.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt13_13_keyTyped(e);
      }
    });
    txt19_19.setBounds(new Rectangle(113, 305, 35, 23));
    txt19_19.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt19_19_keyTyped(e);
      }
    });
    txt25_25.setBounds(new Rectangle(113, 340, 35, 23));
    txt25_25.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt25_25_keyTyped(e);
      }
    });
    txt31_31.setBounds(new Rectangle(113, 374, 35, 23));
    txt31_31.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt31_31_keyTyped(e);
      }
    });
    txt20_20.setBounds(new Rectangle(233, 305, 35, 23));
    txt20_20.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt20_20_keyTyped(e);
      }
    });
    txt2_2.setBounds(new Rectangle(233, 202, 35, 23));
    txt2_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt2_2_keyTyped(e);
      }
    });
    txt26_26.setBounds(new Rectangle(233, 340, 35, 23));
    txt26_26.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt26_26_keyTyped(e);
      }
    });
    txt8_8.setBounds(new Rectangle(233, 236, 35, 23));
    txt8_8.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt8_8_keyTyped(e);
      }
    });
    txt14_14.setBounds(new Rectangle(233, 271, 35, 23));
    txt14_14.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt14_14_keyTyped(e);
      }
    });
    txt9_9.setBounds(new Rectangle(354, 236, 35, 23));
    txt9_9.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt9_9_keyTyped(e);
      }
    });
    txt27_27.setBounds(new Rectangle(334, 320, 82, 73));
    txt27_27.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt27_27_keyTyped(e);
      }
    });
    txt15_15.setBounds(new Rectangle(344, 261, 44, 31));
    txt15_15.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt15_15_keyTyped(e);
      }
    });
    txt3_3.setBounds(new Rectangle(354, 202, 35, 23));
    txt3_3.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt3_3_keyTyped(e);
      }
    });
    txt21_21.setBounds(new Rectangle(354, 305, 35, 23));
    txt21_21.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt21_21_keyTyped(e);
      }
    });
    txt10_10.setBounds(new Rectangle(472, 236, 35, 23));
    txt10_10.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt10_10_keyTyped(e);
      }
    });
    txt28_28.setBounds(new Rectangle(472, 340, 35, 23));
    txt28_28.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt28_28_keyTyped(e);
      }
    });

    jLabel11116.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel11116.setText(".");
    jLabel11116.setBounds(new Rectangle(464, 271, 13, 25));
    jLabel11116.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        jLabel11116_keyTyped(e);
      }
    });
    txt16_16.setBounds(new Rectangle(472, 271, 35, 23));
    txt16_16.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt16_16_keyTyped(e);
      }
    });
    txt4_4.setBounds(new Rectangle(472, 202, 35, 23));
    txt4_4.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt4_4_keyTyped(e);
      }
    });
    txt22_22.setBounds(new Rectangle(472, 305, 35, 23));
    txt22_22.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt22_22_keyTyped(e);
      }
    });
    txt11_11.setBounds(new Rectangle(592, 236, 35, 23));
    txt11_11.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt11_11_keyTyped(e);
      }
    });
    txt29_29.setBounds(new Rectangle(592, 340, 35, 23));
    txt29_29.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt29_29_keyTyped(e);
      }
    });
    txt17_17.setBounds(new Rectangle(592, 271, 35, 23));
    txt17_17.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt17_17_keyTyped(e);
      }
    });
    txt5_5.setBounds(new Rectangle(592, 202, 35, 23));
    txt5_5.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt5_5_keyTyped(e);
      }
    });
    txt23_23.setBounds(new Rectangle(592, 305, 35, 23));
    txt23_23.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt23_23_keyTyped(e);
      }
    });
    txt12_12.setBounds(new Rectangle(716, 236, 35, 23));
    txt12_12.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt12_12_keyTyped(e);
      }
    });
    txt30_30.setBounds(new Rectangle(716, 340, 35, 23));
    txt30_30.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt30_30_keyTyped(e);
      }
    });
    txt18_18.setBounds(new Rectangle(716, 271, 35, 23));
    txt18_18.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt18_18_keyTyped(e);
      }
    });
    txt6_6.setBounds(new Rectangle(716, 202, 35, 23));
    txt6_6.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt6_6_keyTyped(e);
      }
    });
    txt24_24.setBounds(new Rectangle(716, 305, 35, 23));
    txt24_24.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txt24_24_keyTyped(e);
      }
    });*/
    jTextField4.setBounds(new Rectangle(406, 132, 155, 23));
    jTextField4.setText(" * Exchange Currency :");
    //jTextField4.setEditable(false);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    cmboExchange.setBounds(new Rectangle(563, 132, 155, 23));
    cmboExchange.setBackground(Color.white);
    cmboCen.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(563, 100, 155, 23));
    jTextField11.setBounds(new Rectangle(406, 100, 155, 23));
    jTextField11.setText(" * Center :");
    jTextField11.setBorder(null);
    jTextField11.setOpaque(true);
    //jTextField11.setEditable(false);
    jTextField11.setForeground(Color.white);
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setBackground(new Color(143, 143, 188));
    btnCopy2All.setBounds(new Rectangle(40, 166, 353, 28));
    btnCopy2All.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy2All.setText("COPY 1st EXCHANGE RATE TO ALL CELLS");
    btnCopy2All.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy2All_actionPerformed(e);
      }
    });
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnModify, null);
    this.add(txt9, null);
    this.add(jTextField112, null);
    this.add(txt15, null);
    this.add(jTextField1111, null);
    this.add(txt21, null);
    this.add(jTextField11110, null);
    this.add(txt27, null);
    this.add(jTextField11119, null);
    this.add(jTextField6, null);
    this.add(jTextField7, null);
    this.add(jTextField10, null);
    this.add(jTextField9, null);
    this.add(jTextField8, null);
    this.add(txt7, null);
    this.add(txt13, null);
    this.add(txt19, null);
    this.add(txt25, null);
    this.add(txt31, null);
    this.add(txt8, null);
    this.add(jTextField114, null);
    this.add(txt14, null);
    this.add(jTextField1113, null);
    this.add(txt20, null);
    this.add(jTextField11112, null);
    this.add(txt26, null);
    this.add(jTextField111111, null);
    this.add(jTextField23, null);
    this.add(txt10, null);
    this.add(txt16, null);
    this.add(jTextField25, null);
    this.add(txt22, null);
    this.add(jTextField27, null);
    this.add(txt28, null);
    this.add(jTextField29, null);
    this.add(txt11, null);
    this.add(jTextField118, null);
    this.add(txt17, null);
    this.add(jTextField1117, null);
    this.add(txt23, null);
    this.add(jTextField11116, null);
    this.add(txt29, null);
    this.add(jTextField111115, null);
    this.add(txt12, null);
    this.add(jTextField116, null);
    this.add(txt18, null);
    this.add(jTextField1115, null);
    this.add(txt24, null);
    this.add(jTextField11114, null);
    this.add(txt30, null);
    this.add(jTextField111113, null);
    this.add(txt1, null);
    this.add(jTextField5, null);
    this.add(txt2, null);
    this.add(jTextField12, null);
    this.add(jTextField14, null);
    this.add(jTextField20, null);
    this.add(jTextField17, null);
    this.add(jTextField19, null);
    this.add(txt3, null);
    this.add(txt4, null);
    this.add(txt5, null);
    this.add(txt6, null);
    this.add(cmboExchange, null);
    this.add(jTextField4, null);
    this.add(cmboBase, null);
    this.add(jTextField3, null);
    this.add(jTextField11, null);
    this.add(cmboCen, null);
    this.add(txtYM, null);
    this.add(jTextField1, null);
    this.add(btnCopy2All, null);
    this.setCmbo();
    this.setData2Fields();
    txt31.setHorizontalAlignment(SwingConstants.RIGHT);
  }

  void setData2Fields() {
    java.util.Vector v = null;
    try {
      txtYM.setText(hm.get("ymDate").equals("0") ? "" : hm.get("ymDate").toString());
      cmboBase.setSelectedItem(hm.get("EXRATE_BASE_CURRENCY")==null?"":hm.get("EXRATE_BASE_CURRENCY").toString());
      cmboExchange.setSelectedItem(hm.get("EXRATE_NAME")==null?"":hm.get("EXRATE_NAME").toString());
      cmboCen.setSelectedItem(hm.get("CENTER")==null?"":hm.get("CENTER").toString());
      v = exgui2.CONST.BASIC_MAIN_EJB.getExchangeRateList(hm);
      for (int i = 0; i < v.size(); i++) {
        rec = (database.datatype.Record) v.get(i);
        int day = Integer.parseInt(rec.get("DAY").toString())-1;
        array[day][0] = rec.get("DAY").toString();
        array[day][1] = rec.get("EXRATE_RATE")==null?"0":rec.get("EXRATE_RATE").toString();
        array[day][2] = rec.get("EXRATE_SEQ").toString();
        array[day][3] = rec.get("EXRATE_NAME").toString();
        array[day][4] = rec.get("EXRATE_DD").toString();
        array[day][5] = rec.get("EXRATE_RATE")==null?"0":rec.get("EXRATE_RATE").toString();
      }
      if (rec != null) {
        txtYM.setText(rec.get("YYYYMM").toString());
        cmboBase.setSelectedItem(rec.get("EXRATE_BASE_CURRENCY").toString());
        cmboExchange.setSelectedItem(rec.get("EXRATE_NAME").toString());
        cmboCen.setSelectedItem(rec.get("CENTER").toString());
      }
      Object objDecCnv=
          exgui.verification.CellFormat.getDoubleFormatAllowNull(5,4);
      for (int x = 0; x < txt.length; x++) {
        dbTxtChkers[x]=
            new exgui.DataBindTextWithChecker(txt[x],
                "",(array[x][1]==null)?null:new Float(array[x][1]), 10,
                (exgui.Object2String)objDecCnv,
                (exgui.ultratable.CellTxtEditorFormat)objDecCnv);

      }
      /*
      for (int x = 0; x < txt.length; x++) {
        if (array[x][1] != null) {
          array[x][1] = array[x][1].indexOf(".") == -1 ? array[x][1]+".0": array[x][1];
          java.util.Vector vX = exgui2.Stuff.splitString(array[x][1].toString(), ".");
          for (int y = 0; y < 2; y++) {
            if (array[x][1] != null && !array[x][1].equals("0")) {
              txt[x][y].setText(vX.get(y).toString());
            }
          }
        }
      }
      */
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+v.toString());
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.exchange.ExchangeSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
      if (result == 0) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        java.util.Vector v31 = new java.util.Vector();
        try {
          for (int x = 0; x < txt.length; x++) {
            java.util.HashMap hmMod = new java.util.HashMap();
            Object objRate=dbTxtChkers[x].getSelectedValue();
            String rate =(objRate==null)?"":objRate.toString();
            /*
            String rate = txt[x][0].getText().equals("") ? "0" : txt[x][0].getText();
                rate += txt[x][1].getText().equals("") ? "" : ".";
                rate += txt[x][1].getText().equals("") ? ".0" : txt[x][1].getText();
            */

            int y = Integer.parseInt( (txtYM.getText() + (x + 1)).substring(0, 4));
            int m = Integer.parseInt( (txtYM.getText() + (x + 1)).substring(4, 6));
            int d = Integer.parseInt( (txtYM.getText() + (x + 1)).substring(6));
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
            sdf.setLenient(false);
            java.util.Date date=null;
            try{
             date= sdf.parse(y+"/"+m+"/"+d);
            }catch(Exception exp){
              //31th day of some monthes,cuase parsing error,skip it.
              continue;
            }


            java.sql.Date sqld = new java.sql.Date(date.getTime());
            hmMod.put("EXRATE_SEQ", array[x][2]==null?"":array[x][2]);
            hmMod.put("EXRATE_DD", sqld);
            hmMod.put("EXRATE_BASE_CURRENCY", dbJCBXBase.getSelectedValue());
            hmMod.put("EXRATE_NAME", dbJCBXExchange.getSelectedValue());
            hmMod.put("EXRATE_CEN_CODE", dbJCBXCen.getSelectedValue());
            hmMod.put("EXRATE_RATE", rate);
            hmMod.put("old_rate", array[x][5]==null?"":array[x][5]);
            hmMod.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
            v31.add(hmMod);
          }
          int isOk = exgui2.CONST.BASIC_MAIN_EJB.updateExchangeRate(v31);
          if (exgui2.Stuff.updateMessage(frame, isOk))
            frame.showPanel(new newtimes.basic.exchange.ExchangeSearch(frame));
        } catch (Exception eM) {
          eM.printStackTrace();
          util.ExceptionLog.exp2File(eM,"error at update data.\nVector datas:"+v31.toString());
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
  }

  void setCmbo() {
    java.util.Vector vDataBase = null;
    java.util.Vector vDataExchante = null;
    java.util.Vector vDataCen = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "cen_name");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                           "CEN_CODE", recCen.get("CEN_CODE"));

      vDataExchante = exgui2.CONST.BASIC_MAIN_EJB.getCurrencyAll("CRNCY_NAME", "CRNCY_NAME");
      database.datatype.Record recEx = (database.datatype.Record) vDataExchante.get(0);
      dbJCBXExchange = new exgui.DataBindJCombobox(cmboExchange, vDataExchante, "CRNCY_NAME",
                                           "CRNCY_NAME", recEx.get("CRNCY_NAME"));

      vDataBase = exgui2.CONST.BASIC_MAIN_EJB.getCurrencyAll("CRNCY_NAME", "CRNCY_NAME");
      database.datatype.Record recBase = (database.datatype.Record) vDataBase.get(0);
      dbJCBXBase = new exgui.DataBindJCombobox(cmboBase, vDataBase, "CRNCY_NAME",
                                           "CRNCY_NAME", recBase.get("CRNCY_NAME"));
      cmboBase.setSelectedIndex(0);
      cmboExchange.setSelectedIndex(0);
      cmboCen.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt JComboBox Data.");
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYM,null,"",6);
    for (int x = 0; x < txt.length; x++) {
      for (int y = 0; y < 2; y++) {
        //tx = new exgui.DataBindText(txt[x][y],null,"",4);
      }
    }
  }

  void btnCopy2All_actionPerformed(ActionEvent e) {
    if(!dbTxtChkers[0].isValidx()) return;
    for(int i=1;i<txt.length;i++){
      txt[i].setText(txt[0].getText());
    }
  }
  /*
  void txt1_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt1_1.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt1.getText());
    }
  }

  void txt1_1_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt1_1.getText());
  }

  void txt2_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt2_2.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt2.getText());
    }
  }

  void txt2_2_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt2_2.getText());
  }

  void txt3_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt3_3.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt3.getText());
    }
  }

  void txt3_3_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt3_3.getText());
  }

  void txt4_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt4_4.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt4.getText());
    }
  }

  void txt4_4_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt4_4.getText());
  }

  void txt5_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt5_5.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt5.getText());
    }
  }

  void txt5_5_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt5_5.getText());
  }

  void txt6_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt6_6.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt6.getText());
    }
  }

  void txt6_6_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt6_6.getText());
  }

  void txt7_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt7_7.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt7.getText());
    }
  }

  void txt7_7_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt7_7.getText());
  }

  void txt8_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt8_8.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt8.getText());
    }
  }

  void txt8_8_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt8_8.getText());
  }

  void txt9_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt9_9.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt9.getText());
    }
  }

  void txt9_9_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt9_9.getText());
  }

  void txt10_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt10_10.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt10.getText());
    }
  }

  void txt10_10_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt10_10.getText());
  }

  void txt11_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt11_11.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt11.getText());
    }
  }

  void txt11_11_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt11_11.getText());
  }

  void txt12_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt12_12.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt12.getText());
    }
  }

  void txt12_12_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt12_12.getText());
  }

  void txt13_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt13_13.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt13.getText());
    }
  }

  void txt13_13_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt13_13.getText());
  }

  void txt14_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt14_14.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt14.getText());
    }
  }

  void txt14_14_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt14_14.getText());
  }

  void txt15_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt15_15.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt15.getText());
    }
  }

  void txt15_15_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt15_15.getText());
  }

  void txt16_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt16_16.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt16.getText());
    }
  }

  void jLabel11116_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt16_16.getText());
  }

  void txt17_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt17_17.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt17.getText());
    }
  }

  void txt17_17_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt17_17.getText());
  }

  void txt18_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt18_18.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt18.getText());
    }
  }

  void txt18_18_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt18_18.getText());
  }

  void txt19_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt19_19.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt19.getText());
    }
  }

  void txt19_19_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt19_19.getText());
  }

  void txt20_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt20_20.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt20.getText());
    }
  }

  void txt20_20_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt20_20.getText());
  }

  void txt21_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt21_21.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt21.getText());
    }
  }

  void txt21_21_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt21_21.getText());
  }

  void txt22_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt22_22.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt22.getText());
    }
  }

  void txt22_22_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt22_22.getText());
  }

  void txt23_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt23_23.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt23.getText());
    }
  }

  void txt23_23_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt23_23.getText());
  }

  void txt24_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt24_24.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt24.getText());
    }
  }

  void txt24_24_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt24_24.getText());
  }

  void txt25_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt25_25.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt25.getText());
    }
  }

  void txt25_25_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt25_25.getText());
  }

  void txt26_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt26_26.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt26.getText());
    }
  }

  void txt26_26_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt26_26.getText());
  }

  void txt27_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt27_27.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt27.getText());
    }
  }

  void txt27_27_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt27_27.getText());
  }

  void txt28_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt28_28.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt28.getText());
    }
  }

  void txt28_28_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt28_28.getText());
  }

  void txt29_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt29_29.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt29.getText());
    }
  }

  void txt29_29_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt29_29.getText());
  }

  void txt30_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt30_30.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt30.getText());
    }
  }

  void txt30_30_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt30_30.getText());
  }

  void txt31_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txt31_31.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txt31.getText());
    }
  }

  void txt31_31_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt31_31.getText());
  }

  void txt16_16_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txt16_16.getText());
  }*/
}
