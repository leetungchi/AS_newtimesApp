package util;

import javax.swing.*;
import java.awt.*;

public class FrameProcessingBar extends JFrame {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel lblTitleMsg = new JLabel();
  JLabel lblAnimation = new JLabel();

  public FrameProcessingBar() {
    try {
      jbInit();
      this.addWindowListener(new myWindowListener());
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  class myWindowListener extends java.awt.event.WindowAdapter{
    public void windowIconified(java.awt.event.WindowEvent e){
      System.out.println("calls Iconfy");
      setState(JFrame.NORMAL);
    }
  }
  void jbInit() throws Exception {
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.setResizable(false);
    this.setState(Frame.NORMAL);
    this.setTitle("PROCESSING NOW");
    this.getContentPane().setLayout(borderLayout1);
    lblTitleMsg.setFont(new java.awt.Font("Dialog", 1, 11));
    lblTitleMsg.setText("Processing Now");
    lblAnimation.setIcon(new ImageIcon("D:/NewtimesChloeClient/NewtimesAppHK/classes/images/start_dn.gif"));
    lblAnimation.setOpaque(true);
    lblAnimation.setDoubleBuffered(true);
    lblAnimation.setBounds(new Rectangle(13, 42, 450, 21));
    lblAnimation.setText("");
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(lblTitleMsg, null);
    jPanel1.add(lblAnimation, null);
  }
}
