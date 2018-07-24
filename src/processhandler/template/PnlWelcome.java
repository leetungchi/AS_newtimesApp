package processhandler.template;

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

public class PnlWelcome extends JPanel {
  JLabel jLabel1 = new JLabel();

  public PnlWelcome() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBackground(new Color(10,36,106));
    jLabel1.setOpaque(true);
    jLabel1.setToolTipText("Click me to enter the Query Interface.");
    jLabel1.setText("Click to Enter Qurery Interface");
    jLabel1.setBounds(new Rectangle(94, 104, 165, 34));
    jLabel1.addMouseListener(new WelcomePnl_jLabel1_mouseAdapter(this));
    this.setLayout(null);
    this.add(jLabel1, null);
  }

  void jLabel1_mouseClicked(MouseEvent e) {
    try{
       Properties.getCenteralControler().setSystemCommander(Constants.CMD_PROC_TEMP1);
       Properties.getCenteralControler().doCommandExecute(
           Properties.getCenteralControler().SHOW_QUERY_GUI
       );
    }catch(Exception eII){
       exgui.verification.VerifyLib.showAlert(eII.getMessage(),
       "Command Exception while attemp to generate Qurey GUI");
    }
  }
}

class WelcomePnl_jLabel1_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlWelcome adaptee;

  WelcomePnl_jLabel1_mouseAdapter(PnlWelcome adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jLabel1_mouseClicked(e);
  }
}
