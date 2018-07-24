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

public class PnlListSty2Add extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JButton btnEXIT = new JButton();

  public PnlListSty2Add() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("CLICK STYLES  TO ADD");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 29, 758, 39));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("ORG-STYLE");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(17, 101, 570, 32));
    btnEXIT.setBounds(new Rectangle(474, 376, 103, 27));
    btnEXIT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEXIT.setText("EXIT");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnEXIT, null);
    this.add(whiteBkgBlueCharLabel1, null);
  }
}
