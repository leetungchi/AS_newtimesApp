package newtimes.nthk_accounting_enqry;

import java.awt.*;
import javax.swing.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlUpperListQryResult extends JPanel {
  JLabel jLabel2 = new JLabel();
  JLabel lblShowQryString = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();

  public PnlUpperListQryResult() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 8, 801, 26));
    blueBkgWhiteCharLabel1.setText("           S/C Detail List");
    blueBkgWhiteCharLabel1.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setText("Ship Total Enquiry");
    jLabel3.setBounds(new Rectangle(143, 73, 359, 20));
    jLabel1.setBounds(new Rectangle(143, 33, 359, 20));
    jLabel1.setText("Newtimes Group Of Companies");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    lblShowQryString.setBounds(new Rectangle(47, 98, 712, 74));
    lblShowQryString.setText("Select xxxxx from xxxx");
    lblShowQryString.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    lblShowQryString.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    lblShowQryString.setOpaque(true);
    lblShowQryString.setHorizontalAlignment(SwingConstants.LEFT);
    lblShowQryString.setHorizontalTextPosition(SwingConstants.LEFT);
    lblShowQryString.setForeground(Color.black);
    lblShowQryString.setBackground(Color.yellow);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("ERP Systems (General Enquiry)");
    jLabel2.setBounds(new Rectangle(144, 52, 359, 20));
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblShowQryString, null);
    this.add(jLabel2, null);
    this.add(jLabel1, null);
    this.add(jLabel3, null);
    this.setPreferredSize(new Dimension(800,180));
    this.setSize(new Dimension(800, 175));
  }
}
