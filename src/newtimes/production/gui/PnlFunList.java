package newtimes.production.gui;

import javax.swing.JPanel;
import exgui.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFunList extends JPanel {
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JLabel whiteBkgBlueCharLabel2 = new JLabel();
  JLabel whiteBkgBlueCharLabel3 = new JLabel();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  public PnlFunList() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Production");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 7, 801, 32));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("Production Maintain");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(150, 200, 470, 28));
    whiteBkgBlueCharLabel1.addMouseListener(new PnlFunList_whiteBkgBlueCharLabel1_mouseAdapter(this));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(150, 267, 470, 28));
    whiteBkgBlueCharLabel2.setText("S/C & C/T Audit");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(150, 330, 470, 28));
    whiteBkgBlueCharLabel3.setText("Print Report");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(150, 388, 470, 28));
    whiteBkgBlueCharLabel4.setText("Restore Deleted Production");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(whiteBkgBlueCharLabel4, null);
  }

  void whiteBkgBlueCharLabel1_mouseClicked(MouseEvent e) {
    try{
      //swith to the command center --Production mantain.
      processhandler.template.Properties.getCenteralControler().
          setSystemCommander(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
          );
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          new newtimes.production.process.prodmaintain.TgrToGenQryGui4Prod()
          );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

}

class PnlFunList_whiteBkgBlueCharLabel1_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlFunList adaptee;

  PnlFunList_whiteBkgBlueCharLabel1_mouseAdapter(PnlFunList adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.whiteBkgBlueCharLabel1_mouseClicked(e);
  }
}