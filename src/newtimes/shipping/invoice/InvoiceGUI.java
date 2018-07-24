package newtimes.shipping.invoice;

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

public class InvoiceGUI extends JPanel {
  JTextField txtSrnNo1 = new JTextField();
  JLabel jLabel1112 = new JLabel();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JButton do_Print = new JButton();
  JLabel jLabel1 = new JLabel();
  JTextField[] txtSrnNo = {txtSrnNo1};

  public InvoiceGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBounds(new Rectangle(117, 12, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ============  Commercial Invoice  ============      ");
    jLabel1112.setBounds(new Rectangle(10, 13, 155, 41));
    jLabel1112.setText(" SRN NO. :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(Color.white);
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel1112.setBounds(new Rectangle(228, 59, 115, 20));
    txtSrnNo1.setBounds(new Rectangle(167, 13, 115, 20));
    txtSrnNo1.setBounds(new Rectangle(344, 59, 155, 20));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    do_Print.setFont(new java.awt.Font("Dialog", 1, 12));
    do_Print.setForeground(Color.darkGray);
    do_Print.setBounds(new Rectangle(250, 438, 80, 25));
    do_Print.setText("Print");
    do_Print.setMargin(new Insets(0, 0, 0, 0));
    do_Print.setBounds(new Rectangle(503, 59, 68, 20));
    do_Print.setBackground(Color.lightGray);
    this.add(jLabel1, null);
    this.add(do_Print, null);
    this.add(txtSrnNo1, null);
    this.add(jLabel1112, null);
  }

}
