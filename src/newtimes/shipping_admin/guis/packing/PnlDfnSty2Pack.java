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

public class PnlDfnSty2Pack extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable jTable1 = new JTable();
  JButton btnAddNew = new JButton();
  JButton btnDup = new JButton();
  JButton btnExit = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();

  public PnlDfnSty2Pack() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("PACKING FOR STYLE:STYL1,PO:PPP-001");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(1, 33, 852, 28));
    this.setLayout(null);
    jScrollPane1.setBounds(new Rectangle(12, 101, 842, 219));
    btnAddNew.setBounds(new Rectangle(65, 374, 116, 30));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("NEW");
    btnDup.setText("DUPLICATE");
    btnDup.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDup.setBounds(new Rectangle(246, 374, 116, 30));
    btnExit.setBounds(new Rectangle(528, 374, 103, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    whiteBkgBlueCharLabel1.setText("CARTON BGN");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(14, 75, 104, 22));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(121, 75, 119, 22));
    whiteBkgBlueCharLabel2.setText("CARTON END");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(244, 75, 118, 22));
    whiteBkgBlueCharLabel3.setText("COLOR");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(366, 75, 210, 22));
    whiteBkgBlueCharLabel4.setText("SIZE1 SIZE2 SIZE3 ...");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(579, 75, 121, 22));
    whiteBkgBlueCharLabel5.setText("MEAS (L W H)");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(703, 75, 145, 22));
    whiteBkgBlueCharLabel6.setText("Wt (GW NW NNW) Unit");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(jTable1, null);
    this.add(btnDup, null);
    this.add(btnAddNew, null);
    this.add(btnExit, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(whiteBkgBlueCharLabel6, null);
  }
}
