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

public class PnlListAddedPckStyles extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JButton btnAddNewFromSC = new JButton();
  JButton btnView4SRN = new JButton();
  JButton txtPrint4Packing = new JButton();
  JButton btnExit = new JButton();

  public PnlListAddedPckStyles() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("STYLES IN THIS PACKING");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 22, 701, 35));
    this.setLayout(null);
    jScrollPane1.setBounds(new Rectangle(7, 88, 664, 185));
    whiteBkgBlueCharLabel1.setText("S/C NO");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 65, 157, 20));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(169, 65, 157, 20));
    whiteBkgBlueCharLabel2.setText("STYLE NO");
    whiteBkgBlueCharLabel3.setText("PO");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(329, 65, 132, 20));
    whiteBkgBlueCharLabel4.setText("View For This S/C");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(466, 65, 203, 20));
    btnAddNewFromSC.setBounds(new Rectangle(8, 286, 130, 27));
    btnAddNewFromSC.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNewFromSC.setText("ADD");
    btnView4SRN.setBounds(new Rectangle(169, 286, 148, 27));
    btnView4SRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnView4SRN.setText("VIEW WHOLE SRN");
    txtPrint4Packing.setText("PRINT");
    txtPrint4Packing.setBounds(new Rectangle(342, 286, 148, 27));
    txtPrint4Packing.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.setBounds(new Rectangle(523, 286, 148, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jScrollPane1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(btnAddNewFromSC, null);
    this.add(btnView4SRN, null);
    this.add(txtPrint4Packing, null);
    this.add(btnExit, null);
  }
}
