package newtimes.shipping_admin.guis.packing;

import java.awt.*;
import exgui.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListSrn4Qry extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JButton btnExit = new JButton();

  public PnlListSrn4Qry() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("SRN LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 18, 676, 33));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("SRN LIST after Query,click each row to edit packing");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(27, 110, 599, 170));
    btnExit.setBounds(new Rectangle(497, 336, 93, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(btnExit, null);
  }
}
