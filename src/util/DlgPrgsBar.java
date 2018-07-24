package util;

import java.awt.*;
import javax.swing.*;

public class DlgPrgsBar extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel lblTitleMsg = new JLabel();
  JLabel lblAnimation = new JLabel();
  JPanel jPanel1 = new JPanel();
  FlowLayout flowLayout1 = new FlowLayout();

  public DlgPrgsBar(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgPrgsBar() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    lblTitleMsg.setFont(new java.awt.Font("Dialog", 1, 11));
    lblTitleMsg.setText("Processing Now...");
    lblAnimation.setIcon(exgui.UIHelper.getIcon("processing.gif"));
    lblAnimation.setOpaque(true);
    lblAnimation.setDoubleBuffered(true);
    lblAnimation.setText("");
    jPanel1.setLayout(flowLayout1);
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(lblAnimation, null);
    panel1.add(lblTitleMsg, BorderLayout.NORTH);
  }
}
