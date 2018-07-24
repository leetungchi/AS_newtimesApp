package newtimes.fty_exam;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlOthersFunction extends JPanel {
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnFtyAuth = new JButton();

  public PnlOthersFunction() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 33, 799, 37));
    blueBkgWhiteCharLabel1.setText("Other Functions");
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    btnExit.setBounds(new Rectangle(322, 534, 155, 37));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    this.setLayout(null);
    btnFtyAuth.setBackground(Color.white);
    btnFtyAuth.setBounds(new Rectangle(216, 88, 368, 33));
    btnFtyAuth.setFont(new java.awt.Font("Dialog", 0, 12));
    btnFtyAuth.setText("Åç¼t³æ¤¸");
    btnFtyAuth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFtyAuth_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnFtyAuth, null);
  }
  void btnExit_actionPerformed(ActionEvent e) {
    JPanel panel = new newtimes.MainFunction((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();

  }

  void btnFtyAuth_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.fty_exam.TgrFtyExamFuncList());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
