package newtimes.basic.quota;

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

public class QuotaAdd extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JButton butnAdd = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JButton butnExit = new JButton();
  private JTextField txtCat = new JTextField();
  private JLabel jTextField2 = new JLabel();
  private JTextField txtWeight = new JTextField();
  private JLabel jTextField3 = new JLabel();
  private JTextField txtRemark = new JTextField();
  private JLabel jTextField4 = new JLabel();
  private JComboBox cmboArea = new JComboBox();

  public QuotaAdd(Frame1 _frame) {
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
    txtCat.setBounds(new Rectangle(335, 107, 271, 23));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(395, 480, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField1.setText(" * Category :");
    //jTextField1.setEditable(false);
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Quota Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(301, 480, 80, 25));
    butnAdd.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
   // textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setText(" * Area-Code ( U / C / E / I ) :");
    jTextField2.setBounds(new Rectangle(178, 143, 155, 23));
    txtWeight.setBounds(new Rectangle(335, 180, 271, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setText(" Weight :");
    jTextField3.setBounds(new Rectangle(178, 180, 155, 23));
    txtRemark.setBounds(new Rectangle(335, 216, 271, 23));
    txtRemark.setText("");
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setText(" Remark :");
    jTextField4.setBounds(new Rectangle(178, 216, 155, 23));
    cmboArea.setBounds(new Rectangle(335, 143, 271, 23));
    cmboArea.setBackground(Color.white);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(txtCat, null);
    this.add(jTextField2, null);
    this.add(jTextField3, null);
    this.add(txtWeight, null);
    this.add(jTextField4, null);
    this.add(txtRemark, null);
    this.add(cmboArea, null);
    exgui2.Stuff.getQuotaAreaCode4JComboBox(cmboArea);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.quota.QuotaLit(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("QTA_CAT", txtCat.getText().trim().toUpperCase());
        hm.put("QTA_AREA", exgui2.Stuff.getQuotaAreaCodeValue4JComboBox(cmboArea));
        hm.put("QTA_WEIGHT", txtWeight.getText());
        hm.put("QTA_REMARK", txtRemark.getText());
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertQuota(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
        frame.showPanel(new newtimes.basic.quota.QuotaLit(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtCat,null,"",10);
    tx = new exgui.DataBindText(txtWeight,null,"",3);
    tx = new exgui.DataBindText(txtRemark,null,"",30);
  }

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtCat.getText(),"Quota Category can't be empty.");
    boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),"Quota Weight must be less than 999");
    if (nameNull && chkInt) { return true; }
    else { return false; }
  }
}
