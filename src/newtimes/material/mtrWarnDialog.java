package newtimes.material;

import java.awt.*;
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

public class mtrWarnDialog extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JButton jButton1 = new JButton();
  String message = null;

  public mtrWarnDialog(Frame frame, String title, String Message, boolean modal){
    super(frame, title, modal);
    util.MiscFunc.hideProcessingMessage();
    try {
      jLabel1.setText(Message);
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

  }

  public mtrWarnDialog() {
    this(null, "", "", false);
  }
  private void jbInit() throws Exception {
    setBounds(400,300, 280 ,105);
    panel1.setLayout(null);
    panel1.setBounds(0,0, 280 ,105);
    jLabel1.setEnabled(true);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(Color.blue);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel1.setIconTextGap(4);
    jLabel1.setBounds(new Rectangle(18, 26, 247, 17));
    jButton1.setBounds(new Rectangle(106, 52, 73, 27));
    jButton1.setText("OK");
    jButton1.addActionListener(new mtrWarnDialog_jButton1_actionAdapter(this));
    this.getContentPane().setLayout(null);
    panel1.add(jLabel1);
    panel1.add(jButton1);
    this.getContentPane().add(panel1, null);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setSize(280 ,125);
    this.setVisible(true);
  }

  void jButton1_actionPerformed(ActionEvent e) {
    setVisible(false);
    dispose();
  }
}

class mtrWarnDialog_jButton1_actionAdapter implements java.awt.event.ActionListener {
  mtrWarnDialog adaptee;

  mtrWarnDialog_jButton1_actionAdapter(mtrWarnDialog adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
