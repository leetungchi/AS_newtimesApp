package newtimes.preproduction.guis;

import java.awt.*;
import exgui.*;
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

public class PnlQry4NthkAppvPo extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnQry = new JButton();

  public PnlQry4NthkAppvPo() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("ENQUIRE FOR PO APPROVE.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(22, 29, 621, 31));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(82, 379, 125, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnQry.setBounds(new Rectangle(514, 376, 107, 32));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("ENQUIRE");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnQry, null);
  }

  void btnQry_actionPerformed(ActionEvent e) {
    try{
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.preproduction.process.TgrApproveNthkPo());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.preproduction.process.TgrShowFuncList());

        //processhandler.template.Properties.getCenteralControler().goBack();
      }catch(Exception ie){
        ie.printStackTrace();
      }
     processhandler.template.Properties.getCenteralControler().getTriggerHistory().clear();
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
