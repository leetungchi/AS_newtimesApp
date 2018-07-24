package newtimes.general_voucher.F107;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */


public class PnlF107FuncList extends JPanel {
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnMaintain = new JButton();

  public PnlF107FuncList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    btnExit.setBounds(new Rectangle(355, 518, 87, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("美金台幣毛利維護功能");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 10, 799, 33));
    btnMaintain.setBounds(new Rectangle(249, 83, 305, 28));
    btnMaintain.setFont(new java.awt.Font("Dialog", 0, 12));
    btnMaintain.setText("美金台幣毛利維護");
    btnMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnMaintain_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnMaintain, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnMaintain_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(new TgrF107GenMtn());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
