package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;

public class PnlSendSCcnfm extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel lblSCNO = new JLabel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  JLabel lblMSR_I = new JLabel();
  JLabel lblMSR_I1 = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel lblProdHeadRmrk = new JLabel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JLabel lblProdEndRmrk = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel pnlInSCcontentPnl = new JPanel();
  GridLayout gridLayout1 = new GridLayout();

  public PnlSendSCcnfm() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"S/C Data");
    this.setLayout(borderLayout1);
    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("S/C NO.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(1, 30, 87, 24));
    lblSCNO.setText("");
    lblSCNO.setBounds(new Rectangle(88, 30, 174, 25));
    blueBkgWhiteCharLabel2.setText("MESSRS");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(1, 57, 87, 24));
    lblMSR_I.setText("");
    lblMSR_I.setBounds(new Rectangle(89, 58, 517, 23));
    lblMSR_I1.setBounds(new Rectangle(87, 83, 519, 23));
    lblMSR_I1.setText("");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(1, 83, 87, 24));
    blueBkgWhiteCharLabel3.setText("MESSRS");
    lblProdHeadRmrk.setBorder(BorderFactory.createLoweredBevelBorder());
    lblProdHeadRmrk.setText("production head memo \u4FE5░ипе");
    lblProdHeadRmrk.setBounds(new Rectangle(3, 112, 785, 88));
    lblProdEndRmrk.setBounds(new Rectangle(4, 558, 781, 88));
    lblProdEndRmrk.setText("production head memo");
    lblProdEndRmrk.setBorder(BorderFactory.createLoweredBevelBorder());
    jScrollPane1.setBorder(titledBorder2);
    jScrollPane1.setBounds(new Rectangle(4, 216, 783, 321));
    pnlInSCcontentPnl.setLayout(gridLayout1);
    gridLayout1.setRows(2);
    gridLayout1.setVgap(30);
    this.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(lblSCNO, null);
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(lblMSR_I, null);
    jPanel1.add(blueBkgWhiteCharLabel3, null);
    jPanel1.add(lblMSR_I1, null);
    jPanel1.add(lblProdEndRmrk, null);
    jPanel1.add(jScrollPane1, null);
    jPanel1.add(lblProdHeadRmrk, null);
    jScrollPane1.getViewport().add(pnlInSCcontentPnl, null);
  }
}