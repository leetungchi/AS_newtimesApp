package newtimes.production.gui.audit_sc_ct;

import java.awt.*;
import javax.swing.JPanel;
import exgui.*;
import javax.swing.JLabel;
public class PnlScCtView extends JPanel {
  JLabel whiteBkgBlueCharLabel1 = new JLabel();

  public PnlScCtView() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    whiteBkgBlueCharLabel1.setText("PreView S/C & C/T");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(31, 21, 329, 223));
    this.setLayout(null);
    this.add(whiteBkgBlueCharLabel1, null);
  }
}