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

public class PnlApprove extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();

  public PnlApprove() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    setPreferredSize(new Dimension(800,600));
    blueBkgWhiteCharLabel1.setText("APPROVE PO.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(8, 30, 616, 31));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(496, 374, 96, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
     processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
