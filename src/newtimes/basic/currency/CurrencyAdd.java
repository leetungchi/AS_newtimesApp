package newtimes.basic.currency;

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

public class CurrencyAdd extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JButton butnAdd = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JButton butnExit = new JButton();
  private JTextField txtCurrency = new JTextField();
  JLabel jTextField2 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaDesc = new JTextArea();

  public CurrencyAdd(Frame1 _frame) {
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
    txtCurrency.setBounds(new Rectangle(335, 107, 271, 23));
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
    jTextField1.setText(" * Currency :");
    //jTextField1.setEditable(false);
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Currency Add  ============      ");
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
    //textAreaStatus.setEditable(false);
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
    jTextField2.setText(" Description :");
    jTextField2.setBounds(new Rectangle(178, 146, 155, 98));
    jScrollPane1.setBounds(new Rectangle(335, 146, 271, 98));
    txtAreaDesc.setText("");
    txtAreaDesc.setLineWrap(true);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(txtCurrency, null);
    this.add(jTextField2, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtAreaDesc, null);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.currency.CurrencyList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("CRNCY_NAME", txtCurrency.getText().trim().toUpperCase());
        hm.put("CRNCY_DESC", txtAreaDesc.getText().trim());
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertCurrency(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
        frame.showPanel(new newtimes.basic.currency.CurrencyList(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtCurrency,null,"",3);
    tx = new exgui.DataBindText(txtAreaDesc,null,"",100);
  }

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtCurrency.getText(),"Currency can't be empty.");
    if (nameNull) { return true; }
    else { return false; }
  }
}
