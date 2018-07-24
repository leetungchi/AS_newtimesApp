package newtimes.basic.size;

import java.awt.*;
import newtimes.*;
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

public class SizeEdit extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton butnExit = new JButton();
  private JButton butnModify = new JButton();
  private JLabel jTextField6 = new JLabel();
  private JTextField txtS7 = new JTextField();
  private JTextField txtS2 = new JTextField();
  private JTextField txtS15 = new JTextField();
  private JLabel jTextField9 = new JLabel();
  private JLabel jTextField7 = new JLabel();
  private JTextField txtS14 = new JTextField();
  private JLabel jTextField12 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JTextField txtS1 = new JTextField();
  private JLabel jTextField17 = new JLabel();
  private JTextField txtS8 = new JTextField();
  private JLabel jTextField114 = new JLabel();
  private JTextField txtS13 = new JTextField();
  private JLabel jTextField18 = new JLabel();
  private JTextField txtS5 = new JTextField();
  private JTextField txtS19 = new JTextField();
  private JLabel jTextField8 = new JLabel();
  private JLabel jTextField19 = new JLabel();
  private JLabel jTextField115 = new JLabel();
  private JLabel jTextField111 = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JTextField txtS3 = new JTextField();
  private JLabel jTextField11 = new JLabel();
  private JTextField txtS16 = new JTextField();
  private JTextField txtS18 = new JTextField();
  private JLabel jTextField110 = new JLabel();
  private JTextField txtS11 = new JTextField();
  private JLabel jTextField13 = new JLabel();
  private JTextField txtS20 = new JTextField();
  private JLabel jTextField10 = new JLabel();
  private JTextField txtS22 = new JTextField();
  private JLabel jTextField16 = new JLabel();
  private JTextField txtS4 = new JTextField();
  private JTextField txtS24 = new JTextField();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField113 = new JLabel();
  private JTextField txtS9 = new JTextField();
  private JLabel jTextField15 = new JLabel();
  private JTextField txtS17 = new JTextField();
  private JTextField txtS6 = new JTextField();
  private JTextField txtS10 = new JTextField();
  private JTextField txtS12 = new JTextField();
  private JLabel jTextField14 = new JLabel();
  private JLabel jTextField112 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JTextField txtS23 = new JTextField();
  private JTextField txtS21 = new JTextField();
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private String _oldSize = null;
  static boolean isExit = false;
  java.util.HashMap hm2CheckDup=new java.util.HashMap();
  JButton btnDelete = new JButton();
  public SizeEdit(Frame1 _frame) {
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
    butnModify.setBackground(Color.lightGray);
    butnModify.setBounds(new Rectangle(397, 482, 135, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setText("Confirm Modify");
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(551, 482, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Size Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setOpaque(true);
    jTextField6.setBorder(null);
    jTextField6.setText("        5");
    jTextField6.setBounds(new Rectangle(413, 99, 59, 23));
    txtS7.setBackground(Color.white);
    txtS7.setForeground(new Color(10,36,106));
//    txtS7.setNextFocusableComponent(txtS8);
    txtS7.setDisabledTextColor(Color.gray);
    txtS7.setBounds(new Rectangle(479, 172, 59, 18));
    txtS7.setBounds(new Rectangle(561, 124, 59, 23));
    txtS2.setBackground(Color.white);
    txtS2.setForeground(new Color(10,36,106));
//    txtS2.setNextFocusableComponent(txtS3);
    txtS2.setDisabledTextColor(Color.gray);
    txtS2.setBounds(new Rectangle(105, 172, 59, 18));
    txtS2.setBounds(new Rectangle(187, 124, 59, 23));
    txtS15.setBounds(new Rectangle(485, 195, 59, 23));
    txtS15.setBounds(new Rectangle(561, 197, 59, 23));
    txtS15.setDisabledTextColor(Color.gray);
//    txtS15.setNextFocusableComponent(txtS9);
    txtS15.setForeground(new Color(10,36,106));
    txtS15.setBackground(Color.white);
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setOpaque(true);
    jTextField9.setBorder(null);
    jTextField9.setText("        8");
    jTextField9.setBounds(new Rectangle(635, 99, 59, 23));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(Color.white);
    jTextField7.setOpaque(true);
    jTextField7.setBorder(null);
    jTextField7.setText("        6");
    jTextField7.setBounds(new Rectangle(487, 99, 59, 23));
    txtS14.setBounds(new Rectangle(411, 195, 59, 23));
    txtS14.setBounds(new Rectangle(487, 197, 59, 23));
    txtS14.setDisabledTextColor(Color.gray);
//    txtS14.setNextFocusableComponent(txtS15);
    txtS14.setForeground(new Color(10,36,106));
    txtS14.setBackground(Color.white);
    jTextField12.setBackground(new Color(143, 143, 188));
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setForeground(new Color(10,36,106));
    jTextField12.setOpaque(true);
    jTextField12.setBorder(null);
    jTextField12.setText("       11");
    jTextField12.setBounds(new Rectangle(263, 172, 59, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setForeground(Color.white);
    jTextField3.setOpaque(true);
    jTextField3.setBorder(null);
    jTextField3.setText("        2");
    jTextField3.setBounds(new Rectangle(187, 99, 59, 23));
    txtS1.setBackground(Color.white);
    txtS1.setForeground(new Color(10,36,106));
//    txtS1.setNextFocusableComponent(txtS2);
    txtS1.setDisabledTextColor(Color.gray);
    txtS1.setBounds(new Rectangle(29, 172, 59, 18));
    txtS1.setBounds(new Rectangle(111, 124, 59, 23));
    jTextField17.setBackground(new Color(143, 143, 188));
    jTextField17.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField17.setForeground(Color.white);
    jTextField17.setOpaque(true);
    jTextField17.setBorder(null);
    jTextField17.setText("       16");
    jTextField17.setBounds(new Rectangle(635, 172, 59, 23));
    txtS8.setBackground(Color.white);
    txtS8.setForeground(new Color(10,36,106));
    txtS8.setDisabledTextColor(Color.gray);
    txtS8.setBounds(new Rectangle(553, 172, 59, 18));
    txtS8.setBounds(new Rectangle(635, 124, 59, 23));
    jTextField114.setBackground(new Color(143, 143, 188));
    jTextField114.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField114.setForeground(new Color(10,36,106));
    jTextField114.setOpaque(true);
    jTextField114.setBorder(null);
    jTextField114.setText("       19");
    jTextField114.setBounds(new Rectangle(263, 245, 59, 23));
    txtS13.setBounds(new Rectangle(633, 195, 59, 23));
    txtS13.setBounds(new Rectangle(413, 197, 59, 23));
    txtS13.setDisabledTextColor(Color.gray);
    txtS13.setForeground(new Color(10,36,106));
    txtS13.setBackground(Color.white);
    jTextField18.setBackground(new Color(143, 143, 188));
    jTextField18.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField18.setForeground(new Color(10,36,106));
    jTextField18.setOpaque(true);
    jTextField18.setBorder(null);
    jTextField18.setText("       21");
    jTextField18.setBounds(new Rectangle(413, 245, 59, 23));
    txtS5.setBackground(Color.white);
    txtS5.setForeground(new Color(10,36,106));
//    txtS5.setNextFocusableComponent(txtS6);
    txtS5.setDisabledTextColor(Color.gray);
    txtS5.setBounds(new Rectangle(331, 172, 59, 18));
    txtS5.setBounds(new Rectangle(413, 124, 59, 23));
    txtS19.setBounds(new Rectangle(109, 195, 59, 23));
    txtS19.setBounds(new Rectangle(263, 270, 59, 23));
    txtS19.setDisabledTextColor(Color.gray);
//    txtS19.setNextFocusableComponent(txtS18);
    txtS19.setForeground(new Color(10,36,106));
    txtS19.setBackground(Color.white);
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setOpaque(true);
    jTextField8.setBorder(null);
    jTextField8.setText("       7");
    jTextField8.setBounds(new Rectangle(561, 99, 59, 23));
    jTextField19.setBackground(new Color(143, 143, 188));
    jTextField19.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField19.setForeground(Color.white);
    jTextField19.setOpaque(true);
    jTextField19.setBorder(null);
    jTextField19.setText("       22");
    jTextField19.setBounds(new Rectangle(487, 245, 59, 23));
    jTextField115.setBackground(new Color(143, 143, 188));
    jTextField115.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField115.setForeground(Color.white);
    jTextField115.setOpaque(true);
    jTextField115.setBorder(null);
    jTextField115.setText("       20");
    jTextField115.setBounds(new Rectangle(338, 245, 59, 23));
    jTextField111.setBackground(new Color(143, 143, 188));
    jTextField111.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField111.setForeground(Color.white);
    jTextField111.setOpaque(true);
    jTextField111.setBorder(null);
    jTextField111.setText("       24");
    jTextField111.setBounds(new Rectangle(635, 245, 59, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setOpaque(true);
    jTextField5.setBorder(null);
    jTextField5.setText("        4");
    jTextField5.setBounds(new Rectangle(338, 99, 59, 23));
    txtS3.setBackground(Color.white);
    txtS3.setForeground(new Color(10,36,106));
//    txtS3.setNextFocusableComponent(txtS4);
    txtS3.setDisabledTextColor(Color.gray);
    txtS3.setBounds(new Rectangle(181, 172, 59, 18));
    txtS3.setBounds(new Rectangle(263, 124, 59, 23));
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(Color.white);
    jTextField11.setOpaque(true);
    jTextField11.setBorder(null);
    jTextField11.setText("       10");
    jTextField11.setBounds(new Rectangle(187, 172, 59, 23));
    txtS16.setBounds(new Rectangle(261, 195, 59, 23));
    txtS16.setBounds(new Rectangle(635, 197, 59, 23));
    txtS16.setDisabledTextColor(Color.gray);
//    txtS16.setNextFocusableComponent(txtS12);
    txtS16.setForeground(new Color(10,36,106));
    txtS16.setBackground(Color.white);
    txtS18.setBounds(new Rectangle(185, 195, 59, 23));
    txtS18.setBounds(new Rectangle(187, 270, 59, 23));
    txtS18.setDisabledTextColor(Color.gray);
//    txtS18.setNextFocusableComponent(txtS17);
    txtS18.setForeground(new Color(10,36,106));
    txtS18.setBackground(Color.white);
    jTextField110.setBackground(new Color(143, 143, 188));
    jTextField110.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField110.setForeground(new Color(10,36,106));
    jTextField110.setOpaque(true);
    jTextField110.setBorder(null);
    jTextField110.setText("       23");
    jTextField110.setBounds(new Rectangle(561, 245, 59, 23));
    txtS11.setBounds(new Rectangle(109, 195, 59, 23));
    txtS11.setBounds(new Rectangle(263, 197, 59, 23));
    txtS11.setDisabledTextColor(Color.gray);
//    txtS11.setNextFocusableComponent(txtS10);
    txtS11.setForeground(new Color(10,36,106));
    txtS11.setBackground(Color.white);
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setForeground(Color.white);
    jTextField13.setOpaque(true);
    jTextField13.setBorder(null);
    jTextField13.setText("       12");
    jTextField13.setBounds(new Rectangle(338, 172, 59, 23));
    txtS20.setBounds(new Rectangle(336, 195, 59, 23));
    txtS20.setBounds(new Rectangle(338, 270, 59, 23));
    txtS20.setDisabledTextColor(Color.gray);
//    txtS20.setNextFocusableComponent(txtS21);
    txtS20.setForeground(new Color(10,36,106));
    txtS20.setBackground(Color.white);
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(new Color(10,36,106));
    jTextField10.setOpaque(true);
    jTextField10.setBorder(null);
    jTextField10.setText("        9");
    jTextField10.setBounds(new Rectangle(111, 172, 59, 23));
    txtS22.setBounds(new Rectangle(485, 195, 59, 23));
    txtS22.setBounds(new Rectangle(487, 270, 59, 23));
    txtS22.setDisabledTextColor(Color.gray);
//    txtS22.setNextFocusableComponent(txtS23);
    txtS22.setForeground(new Color(10,36,106));
    txtS22.setBackground(Color.white);
    jTextField16.setBackground(new Color(143, 143, 188));
    jTextField16.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField16.setForeground(new Color(10,36,106));
    jTextField16.setOpaque(true);
    jTextField16.setBorder(null);
    jTextField16.setText("       15");
    jTextField16.setBounds(new Rectangle(561, 172, 59, 23));
    txtS4.setBackground(Color.white);
    txtS4.setForeground(new Color(10,36,106));
//    txtS4.setNextFocusableComponent(txtS5);
    txtS4.setDisabledTextColor(Color.gray);
    txtS4.setBounds(new Rectangle(256, 172, 59, 18));
    txtS4.setBounds(new Rectangle(338, 124, 59, 23));
    txtS24.setBounds(new Rectangle(633, 195, 59, 23));
    txtS24.setBounds(new Rectangle(635, 270, 59, 23));
    txtS24.setDisabledTextColor(Color.gray);
    txtS24.setForeground(new Color(10,36,106));
    txtS24.setBackground(Color.white);
    jTextField2.setBounds(new Rectangle(111, 99, 59, 23));
    jTextField2.setText("        1");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField113.setBackground(new Color(143, 143, 188));
    jTextField113.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField113.setForeground(Color.white);
    jTextField113.setOpaque(true);
    jTextField113.setBorder(null);
    jTextField113.setText("       18");
    jTextField113.setBounds(new Rectangle(187, 245, 59, 23));
    txtS9.setBounds(new Rectangle(559, 195, 59, 23));
    txtS9.setBounds(new Rectangle(111, 197, 59, 23));
    txtS9.setDisabledTextColor(Color.gray);
//    txtS9.setNextFocusableComponent(txtS13);
    txtS9.setForeground(new Color(10,36,106));
    txtS9.setBackground(Color.white);
    jTextField15.setBackground(new Color(143, 143, 188));
    jTextField15.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField15.setForeground(Color.white);
    jTextField15.setOpaque(true);
    jTextField15.setBorder(null);
    jTextField15.setText("       14");
    jTextField15.setBounds(new Rectangle(487, 172, 59, 23));
    txtS17.setBounds(new Rectangle(261, 195, 59, 23));
    txtS17.setBounds(new Rectangle(111, 270, 59, 23));
    txtS17.setDisabledTextColor(Color.gray);
//    txtS17.setNextFocusableComponent(txtS20);
    txtS17.setForeground(new Color(10,36,106));
    txtS17.setBackground(Color.white);
    txtS6.setBackground(Color.white);
    txtS6.setForeground(new Color(10,36,106));
//    txtS6.setNextFocusableComponent(txtS7);
    txtS6.setDisabledTextColor(Color.gray);
    txtS6.setBounds(new Rectangle(405, 172, 59, 18));
    txtS6.setBounds(new Rectangle(487, 124, 59, 23));
    txtS10.setBounds(new Rectangle(185, 195, 59, 23));
    txtS10.setBounds(new Rectangle(187, 197, 59, 23));
    txtS10.setDisabledTextColor(Color.gray);
//    txtS10.setNextFocusableComponent(txtS16);
    txtS10.setForeground(new Color(10,36,106));
    txtS10.setBackground(Color.white);
    txtS12.setBounds(new Rectangle(336, 195, 59, 23));
    txtS12.setBounds(new Rectangle(338, 197, 59, 23));
    txtS12.setDisabledTextColor(Color.gray);
//    txtS12.setNextFocusableComponent(txtS14);
    txtS12.setForeground(new Color(10,36,106));
    txtS12.setBackground(Color.white);
    jTextField14.setBackground(new Color(143, 143, 188));
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setForeground(new Color(10,36,106));
    jTextField14.setOpaque(true);
    jTextField14.setBorder(null);
    jTextField14.setText("       13");
    jTextField14.setBounds(new Rectangle(413, 172, 59, 23));
    jTextField112.setBackground(new Color(143, 143, 188));
    jTextField112.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField112.setForeground(new Color(10,36,106));
    jTextField112.setOpaque(true);
    jTextField112.setBorder(null);
    jTextField112.setText("       17");
    jTextField112.setBounds(new Rectangle(111, 245, 59, 23));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setOpaque(true);
    jTextField4.setBorder(null);
    jTextField4.setText("        3");
    jTextField4.setBounds(new Rectangle(263, 99, 59, 23));
    txtS23.setBounds(new Rectangle(559, 195, 59, 23));
    txtS23.setBounds(new Rectangle(561, 270, 59, 23));
    txtS23.setDisabledTextColor(Color.gray);
//    txtS23.setNextFocusableComponent(txtS24);
    txtS23.setForeground(new Color(10,36,106));
    txtS23.setBackground(Color.white);
    txtS21.setBounds(new Rectangle(411, 195, 59, 23));
    txtS21.setBounds(new Rectangle(413, 270, 59, 23));
    txtS21.setDisabledTextColor(Color.gray);
//    txtS21.setNextFocusableComponent(txtS22);
    txtS21.setForeground(new Color(10,36,106));
    txtS21.setBackground(Color.white);
    btnDelete.setBackground(Color.lightGray);
    btnDelete.setBounds(new Rectangle(243, 482, 110, 24));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.darkGray);
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField4, null);
    this.add(jTextField111, null);
    this.add(jTextField113, null);
    this.add(jTextField10, null);
    this.add(jTextField13, null);
    this.add(jTextField18, null);
    this.add(jTextField17, null);
    this.add(jTextField6, null);
    this.add(jTextField114, null);
    this.add(jTextField16, null);
    this.add(jTextField12, null);
    this.add(jTextField11, null);
    this.add(jTextField112, null);
    this.add(jTextField2, null);
    this.add(jTextField19, null);
    this.add(jTextField110, null);
    this.add(jTextField3, null);
    this.add(jTextField5, null);
    this.add(jTextField8, null);
    this.add(jTextField9, null);
    this.add(jTextField7, null);
    this.add(jTextField15, null);
    this.add(jTextField115, null);
    this.add(jTextField14, null);


    this.add(txtS1, null);
    this.add(txtS2, null);
    this.add(txtS3, null);
    this.add(txtS4, null);
    this.add(txtS5, null);
    this.add(txtS6, null);
    this.add(txtS7, null);
    this.add(txtS8, null);
    this.add(txtS9, null);
    this.add(txtS10, null);
    this.add(txtS11, null);

    this.add(txtS12, null);
    this.add(txtS13, null);
    this.add(txtS14, null);
    this.add(txtS15, null);
    this.add(txtS16, null);
    this.add(txtS17, null);
    this.add(txtS18, null);
    this.add(txtS19, null);


    this.add(txtS20, null);
    this.add(txtS21, null);
    this.add(txtS22, null);
    this.add(txtS23, null);
    this.add(txtS24, null);
    this.add(butnModify, null);
    this.add(butnExit, null);
    this.add(btnDelete, null);

    this.setData2Fields();
  }
  protected boolean doCheckDupSize(JTextField txt){
    if(txt.getText().trim().length()==0)return true;
    if(hm2CheckDup.containsKey(txt.getText().trim().toUpperCase())){
      exgui.verification.VerifyLib.showAlert("Size Duplicated","Size Duplicated");
      txt.grabFocus();
      txt.selectAll();
      return false;
    }
    hm2CheckDup.put(txt.getText().trim().toUpperCase(),txt.getText().trim().toUpperCase());
    return true;
  }
  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
    if (result == 0) {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm2CheckDup.clear();
        database.datatype.Record recDetail = (database.datatype.Record)hm.get("recDetail");
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("size_delete", this._oldSize);
        hm.put("SIZE1", txtS1.getText().trim().toUpperCase());if(!doCheckDupSize(txtS1))return;
        hm.put("SIZE2", txtS2.getText().trim().toUpperCase());if(!doCheckDupSize(txtS2))return;
        hm.put("SIZE3", txtS3.getText().trim().toUpperCase());if(!doCheckDupSize(txtS3))return;
        hm.put("SIZE4", txtS4.getText().trim().toUpperCase());if(!doCheckDupSize(txtS4))return;
        hm.put("SIZE5", txtS5.getText().trim().toUpperCase());if(!doCheckDupSize(txtS5))return;
        hm.put("SIZE6", txtS6.getText().trim().toUpperCase());if(!doCheckDupSize(txtS6))return;
        hm.put("SIZE7", txtS7.getText().trim().toUpperCase());if(!doCheckDupSize(txtS7))return;
        hm.put("SIZE8", txtS8.getText().trim().toUpperCase());if(!doCheckDupSize(txtS8))return;
        hm.put("SIZE9", txtS9.getText().trim().toUpperCase());if(!doCheckDupSize(txtS9))return;
        hm.put("SIZE10", txtS10.getText().trim().toUpperCase());if(!doCheckDupSize(txtS10))return;
        hm.put("SIZE11", txtS11.getText().trim().toUpperCase());if(!doCheckDupSize(txtS11))return;
        hm.put("SIZE12", txtS12.getText().trim().toUpperCase());if(!doCheckDupSize(txtS12))return;
        hm.put("SIZE13", txtS13.getText().trim().toUpperCase());if(!doCheckDupSize(txtS13))return;
        hm.put("SIZE14", txtS14.getText().trim().toUpperCase());if(!doCheckDupSize(txtS14))return;
        hm.put("SIZE15", txtS15.getText().trim().toUpperCase());if(!doCheckDupSize(txtS15))return;
        hm.put("SIZE16", txtS16.getText().trim().toUpperCase());if(!doCheckDupSize(txtS16))return;
        hm.put("SIZE17", txtS17.getText().trim().toUpperCase());if(!doCheckDupSize(txtS17))return;
        hm.put("SIZE18", txtS18.getText().trim().toUpperCase());if(!doCheckDupSize(txtS18))return;
        hm.put("SIZE19", txtS19.getText().trim().toUpperCase());if(!doCheckDupSize(txtS19))return;
        hm.put("SIZE20", txtS20.getText().trim().toUpperCase());if(!doCheckDupSize(txtS20))return;
        hm.put("SIZE21", txtS21.getText().trim().toUpperCase());if(!doCheckDupSize(txtS21))return;
        hm.put("SIZE22", txtS22.getText().trim().toUpperCase());if(!doCheckDupSize(txtS22))return;
        hm.put("SIZE23", txtS23.getText().trim().toUpperCase());if(!doCheckDupSize(txtS23))return;
        hm.put("SIZE24", txtS24.getText().trim().toUpperCase());if(!doCheckDupSize(txtS24))return;
        hm2CheckDup.clear();
        int isOk = exgui2.CONST.BASIC_MAIN_EJB.updateSize(hm);
        if (exgui2.Stuff.updateMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.size.SizeList(frame));
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at modify data." + hm.toString());
      }finally{
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.size.SizeList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setData2Fields() {
      database.datatype.Record recDetail = null;
      try {
        recDetail = (database.datatype.Record)hm.get("recDetail");
        this._oldSize = recDetail.get("SIZE_CODE")==null?"":recDetail.get("SIZE_CODE").toString();
        txtS1.setText(recDetail.get("size1")==null?"":recDetail.get("size1").toString());
        txtS2.setText(recDetail.get("size2")==null?"":recDetail.get("size2").toString());
        txtS3.setText(recDetail.get("size3")==null?"":recDetail.get("size3").toString());
        txtS4.setText(recDetail.get("size4")==null?"":recDetail.get("size4").toString());
        txtS5.setText(recDetail.get("size5")==null?"":recDetail.get("size5").toString());
        txtS6.setText(recDetail.get("size6")==null?"":recDetail.get("size6").toString());
        txtS7.setText(recDetail.get("size7")==null?"":recDetail.get("size7").toString());
        txtS8.setText(recDetail.get("size8")==null?"":recDetail.get("size8").toString());
        txtS9.setText(recDetail.get("size9")==null?"":recDetail.get("size9").toString());
        txtS10.setText(recDetail.get("size10")==null?"":recDetail.get("size10").toString());
        txtS11.setText(recDetail.get("size11")==null?"":recDetail.get("size11").toString());
        txtS12.setText(recDetail.get("size12")==null?"":recDetail.get("size12").toString());
        txtS13.setText(recDetail.get("size13")==null?"":recDetail.get("size13").toString());
        txtS14.setText(recDetail.get("size14")==null?"":recDetail.get("size14").toString());
        txtS15.setText(recDetail.get("size15")==null?"":recDetail.get("size15").toString());
        txtS16.setText(recDetail.get("size16")==null?"":recDetail.get("size16").toString());
        txtS17.setText(recDetail.get("size17")==null?"":recDetail.get("size17").toString());
        txtS18.setText(recDetail.get("size18")==null?"":recDetail.get("size18").toString());
        txtS19.setText(recDetail.get("size19")==null?"":recDetail.get("size19").toString());
        txtS20.setText(recDetail.get("size20")==null?"":recDetail.get("size20").toString());
        txtS21.setText(recDetail.get("size21")==null?"":recDetail.get("size21").toString());
        txtS22.setText(recDetail.get("size22")==null?"":recDetail.get("size22").toString());
        txtS23.setText(recDetail.get("size23")==null?"":recDetail.get("size23").toString());
        txtS24.setText(recDetail.get("size24")==null?"":recDetail.get("size24").toString());
      } catch (Exception e) {
        e.printStackTrace();
        util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
      }
    }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtS1,null,"",10);
    tx = new exgui.DataBindText(txtS2,null,"",10);
    tx = new exgui.DataBindText(txtS3,null,"",10);
    tx = new exgui.DataBindText(txtS4,null,"",10);
    tx = new exgui.DataBindText(txtS5,null,"",10);
    tx = new exgui.DataBindText(txtS6,null,"",10);
    tx = new exgui.DataBindText(txtS7,null,"",10);
    tx = new exgui.DataBindText(txtS8,null,"",10);
    tx = new exgui.DataBindText(txtS9,null,"",10);
    tx = new exgui.DataBindText(txtS10,null,"",10);
    tx = new exgui.DataBindText(txtS11,null,"",10);
    tx = new exgui.DataBindText(txtS12,null,"",10);
    tx = new exgui.DataBindText(txtS13,null,"",10);
    tx = new exgui.DataBindText(txtS14,null,"",10);
    tx = new exgui.DataBindText(txtS15,null,"",10);
    tx = new exgui.DataBindText(txtS16,null,"",10);
    tx = new exgui.DataBindText(txtS17,null,"",10);
    tx = new exgui.DataBindText(txtS18,null,"",10);
    tx = new exgui.DataBindText(txtS19,null,"",10);
    tx = new exgui.DataBindText(txtS20,null,"",10);
    tx = new exgui.DataBindText(txtS21,null,"",10);
    tx = new exgui.DataBindText(txtS22,null,"",10);
    tx = new exgui.DataBindText(txtS23,null,"",10);
    tx = new exgui.DataBindText(txtS24,null,"",10);
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame, "DELETE ?");
    if (result != 0) return;
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    java.util.Vector vctpk=new java.util.Vector();
    database.datatype.Record recDetail = (database.datatype.Record)hm.get("recDetail");
    vctpk.add(recDetail.get(0));
    try{
      exgui2.CONST.BASIC_MAIN_EJB.deleteFunction("sizefile_tbl", vctpk,
                                                 (String)util.PublicVariable.
                                                 USER_RECORD.get("usr_code"));
      frame.showPanel(new newtimes.basic.size.SizeList(frame));
    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Delete Fail,Please Contact System Manager","DELETE FAIL");
      util.ExceptionLog.exp2File(exp,"delete fail");
      exp.printStackTrace();
    }finally{
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

  }
}
