package newtimes.shipping_admin.guis.packing;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQrySRN extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlQryGUI = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtScNo = new JTextField();
  JButton btnGO = new JButton();
  JButton btnQry4Packing = new JButton();

  public PnlQrySRN() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    blueBkgWhiteCharLabel1.setText("PACKING MAINTEN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 18, 693, 31));
    this.setLayout(null);
    pnlQryGUI.setBorder(titledBorder2);
    pnlQryGUI.setBounds(new Rectangle(34, 82, 605, 232));
    pnlQryGUI.setLayout(null);
    blueBkgWhiteCharLabel2.setText("CREAT SRN BY SC");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(37, 339, 283, 31));
    txtScNo.setText("");
    txtScNo.setBounds(new Rectangle(320, 339, 140, 30));
    btnGO.setBounds(new Rectangle(461, 339, 92, 30));
    btnGO.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGO.setFocusPainted(true);
    btnGO.setText("CREATE");
    btnQry4Packing.setBounds(new Rectangle(487, 190, 105, 33));
    btnQry4Packing.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry4Packing.setText("QUERY");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlQryGUI, null);
    pnlQryGUI.add(btnQry4Packing, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtScNo, null);
    this.add(btnGO, null);
  }
}
