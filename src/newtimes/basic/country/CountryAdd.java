package newtimes.basic.country;

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

public class CountryAdd extends JPanel {
  Frame1 frame;
  private JButton butnAdd = new JButton();
  private JTextField txtWeight = new JTextField();
  private JTextField txtCntyName = new JTextField();
  private JButton butnExit = new JButton();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  JTextField txtCode = new JTextField();
  JLabel jTextField3 = new JLabel();

  public CountryAdd(Frame1 _frame) {
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
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Country Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField1.setText(" * Country Name :");
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField2.setText(" Weight :");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setForeground(Color.white);
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(403, 488, 80, 25));
    butnExit.setBackground(Color.lightGray);
    txtCntyName.setBounds(new Rectangle(335, 107, 271, 23));
    txtWeight.setBounds(new Rectangle(335, 139, 271, 23));
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(309, 488, 80, 25));
    butnAdd.setBackground(Color.lightGray);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    txtCode.setBounds(new Rectangle(335, 167, 271, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(Color.white);
    jTextField3.setOpaque(true);
    jTextField3.setBorder(null);
    jTextField3.setText(" CODE:");
    jTextField3.setBounds(new Rectangle(178, 167, 155, 23));
    this.add(textAreaStatus, null);
    this.add(jTextField2, null);
    this.add(jTextField1, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    this.add(txtWeight, null);
    this.add(txtCntyName, null);
    this.add(txtCode, null);
    this.add(jTextField3, null);
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.country.CountryList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("CNTY_NAME", txtCntyName.getText().trim().toUpperCase());
        hm.put("CNTY_WEIGHT", txtWeight.getText().trim().toUpperCase());
        hm.put("CNTY_CODE", txtCode.getText().trim().toUpperCase());
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertCountry(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.country.CountryList(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtCntyName,null,"",60);
    tx = new exgui.DataBindText(txtWeight,null,"",3);
    tx = new exgui.DataBindText(txtCode,null,"",2);
  }

  boolean checkFieldsData() {
    boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),"Country Weight must be less than 999");
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtCntyName.getText(),"Country Name can't be empty.");
    if (nameNull && chkInt) { return true; }
    else { return false; }
  }
}
