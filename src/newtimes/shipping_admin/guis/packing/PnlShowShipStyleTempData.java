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

public class PnlShowShipStyleTempData extends JPanel {
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JLabel lblSCNO = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel lblSRN = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JLabel lblStyleItem = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtShipStylePackingRemark = new JTextArea();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtPackingType = new JTextField();

  public PnlShowShipStyleTempData() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    whiteBkgBlueCharLabel1.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel1.setForeground(Color.white);
    whiteBkgBlueCharLabel1.setText("S/C:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(347, 10, 86, 27));
    this.setLayout(null);
    lblSCNO.setBorder(BorderFactory.createLoweredBevelBorder());
    lblSCNO.setText("");
    lblSCNO.setBounds(new Rectangle(432, 10, 220, 27));
    blueBkgWhiteCharLabel1.setText("SRN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(1, 10, 99, 27));
    lblSRN.setBounds(new Rectangle(99, 10, 227, 27));
    lblSRN.setText("");
    lblSRN.setBorder(BorderFactory.createLoweredBevelBorder());
    whiteBkgBlueCharLabel2.setText("STYLE / ITEM :");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(1, 47, 99, 25));
    lblStyleItem.setBorder(BorderFactory.createLoweredBevelBorder());
    lblStyleItem.setText("");
    lblStyleItem.setBounds(new Rectangle(101, 46, 320, 27));
    blueBkgWhiteCharLabel2.setText("DESCRIPTION");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(1, 77, 99, 59));
    jScrollPane1.setBounds(new Rectangle(100, 77, 550, 60));
    txtShipStylePackingRemark.setText("");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(426, 46, 112, 25));
    whiteBkgBlueCharLabel3.setText("PACKING TYPE :");
    txtPackingType.setText("");
    txtPackingType.setBounds(new Rectangle(539, 45, 112, 27));
    this.add(lblSCNO, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtPackingType, null);
    this.add(lblSRN, null);
    this.add(lblStyleItem, null);
    this.add(jScrollPane1, null);
    this.add(whiteBkgBlueCharLabel3, null);
    jScrollPane1.getViewport().add(txtShipStylePackingRemark, null);
    exgui.DataBindText dbTxt=new exgui.DataBindText(txtPackingType,"","",50);
  }
}
