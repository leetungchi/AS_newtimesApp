package processhandler.template;

import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Panel1 extends JPanel {
  JLabel jLabel1 = new JLabel();
  JTextField txtName = new JTextField();

  public Panel1() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.blue);
    jLabel1.setAlignmentX((float) 0.0);
    jLabel1.setOpaque(true);
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("MEMO");
    jLabel1.setVerticalAlignment(SwingConstants.CENTER);
    jLabel1.setVerticalTextPosition(SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(19, 59, 87, 26));
    this.setLayout(null);
    txtName.setText("");
    txtName.setBounds(new Rectangle(107, 60, 236, 27));
    this.add(jLabel1, null);
    this.add(txtName, null);
  }
}