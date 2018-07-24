package newtimes.production.gui.order_change;

import java.awt.*;
import javax.swing.JPanel;
import exgui.*;
import javax.swing.JLabel;
public class PnlOrdChgPrint extends JPanel {
  JLabel whiteBkgBlueCharLabel1 = new JLabel();

  public PnlOrdChgPrint() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    whiteBkgBlueCharLabel1.setText("Orde Chage Print");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(58, 96, 199, 89));
    this.setLayout(null);
    this.add(whiteBkgBlueCharLabel1, null);
  }
}