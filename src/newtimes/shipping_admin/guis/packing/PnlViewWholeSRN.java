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

public class PnlViewWholeSRN extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlEachSc = new JPanel();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  JPanel PnlStylInPacking = new JPanel();
  Border border2;
  TitledBorder titledBorder3;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTable jTable1 = new JTable();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JLabel lblTotalCartons = new JLabel();
  JLabel lblTotalQty = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  JLabel lblTotalQty1 = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel8 = new WhiteBkgBlueCharLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JPanel PnlStylInPacking1 = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel9 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel10 = new WhiteBkgBlueCharLabel();
  JLabel lblTotalCartons1 = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel11 = new WhiteBkgBlueCharLabel();
  JTable jTable2 = new JTable();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel12 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel13 = new WhiteBkgBlueCharLabel();
  JLabel lblTotalQty2 = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel14 = new WhiteBkgBlueCharLabel();
  JLabel lblTotalQty3 = new JLabel();
  JTable jTable3 = new JTable();
  JPanel pnlEachSc1 = new JPanel();
  JLabel lblTotalCartons2 = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel15 = new WhiteBkgBlueCharLabel();
  JScrollPane jScrollPane3 = new JScrollPane();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel16 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel17 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel18 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel19 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel110 = new WhiteBkgBlueCharLabel();
  JPanel PnlStylInPacking2 = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel20 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel21 = new WhiteBkgBlueCharLabel();
  JLabel lblTotalCartons3 = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel22 = new WhiteBkgBlueCharLabel();
  JPanel PnlStylInPacking3 = new JPanel();
  JScrollPane jScrollPane4 = new JScrollPane();
  JTable jTable4 = new JTable();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel111 = new WhiteBkgBlueCharLabel();
  Border border3;
  TitledBorder titledBorder4;
  Border border4;
  TitledBorder titledBorder5;
  JButton btnExit = new JButton();

  public PnlViewWholeSRN() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"S/C B50023");
    border2 = BorderFactory.createEmptyBorder();
    titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"STYLE:STY-BB,PO:152-35");
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border3,"STYLE:STY-BCC PO:00Z5");
    border4 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder5 = new TitledBorder(border4,"STYLE:sty PST ,PO:33-500");
    blueBkgWhiteCharLabel1.setText("PACKING VIEW");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 21, 989, 35));
    this.setLayout(null);
    pnlEachSc.setFont(new java.awt.Font("Dialog", 1, 11));
    pnlEachSc.setBorder(titledBorder2);
    pnlEachSc.setBounds(new Rectangle(4, 79, 983, 701));
    pnlEachSc.setLayout(null);
    PnlStylInPacking.setBorder(titledBorder3);
    PnlStylInPacking.setBounds(new Rectangle(6, 22, 874, 305));
    PnlStylInPacking.setLayout(null);
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(368, 24, 210, 22));
    whiteBkgBlueCharLabel4.setText("SIZE1 SIZE2 SIZE3 ...");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(581, 24, 121, 22));
    whiteBkgBlueCharLabel5.setText("MEAS (L W H)");
    jScrollPane1.setBounds(new Rectangle(13, 51, 843, 218));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(246, 24, 119, 22));
    whiteBkgBlueCharLabel2.setText("CARTON END");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(705, 24, 145, 22));
    whiteBkgBlueCharLabel6.setText("Wt (GW NW NNW) Unit");
    whiteBkgBlueCharLabel1.setText("CARTON BGN");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(139, 24, 104, 22));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(19, 24, 118, 22));
    whiteBkgBlueCharLabel3.setText("COLOR");
    lblTotalCartons.setText("TOTAL CTNS:5");
    lblTotalCartons.setBounds(new Rectangle(12, 275, 119, 21));
    lblTotalQty.setText("Total QTY:4050");
    lblTotalQty.setBounds(new Rectangle(120, 275, 134, 18));
    whiteBkgBlueCharLabel7.setText("SIZE1 SIZE2 SIZE3 ...");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(368, 24, 210, 22));
    lblTotalQty1.setBounds(new Rectangle(120, 275, 134, 18));
    lblTotalQty1.setText("Total QTY:4050");
    whiteBkgBlueCharLabel8.setText("MEAS (L W H)");
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(581, 24, 121, 22));
    jScrollPane2.setBounds(new Rectangle(13, 51, 843, 218));
    PnlStylInPacking1.setBorder(titledBorder3);
    PnlStylInPacking1.setBounds(new Rectangle(7, 364, 874, 305));
    PnlStylInPacking1.setLayout(null);
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(246, 24, 119, 22));
    whiteBkgBlueCharLabel9.setText("CARTON END");
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(705, 24, 145, 22));
    whiteBkgBlueCharLabel10.setText("Wt (GW NW NNW) Unit");
    lblTotalCartons1.setText("TOTAL CTNS:5");
    lblTotalCartons1.setBounds(new Rectangle(12, 275, 119, 21));
    whiteBkgBlueCharLabel11.setText("CARTON BGN");
    whiteBkgBlueCharLabel11.setBounds(new Rectangle(139, 24, 104, 22));
    whiteBkgBlueCharLabel12.setBounds(new Rectangle(19, 24, 118, 22));
    whiteBkgBlueCharLabel12.setText("COLOR");
    whiteBkgBlueCharLabel13.setText("SIZE1 SIZE2 SIZE3 ...");
    whiteBkgBlueCharLabel13.setBounds(new Rectangle(368, 24, 210, 22));
    lblTotalQty2.setText("Total QTY:4050");
    lblTotalQty2.setBounds(new Rectangle(120, 275, 134, 18));
    whiteBkgBlueCharLabel14.setText("MEAS (L W H)");
    whiteBkgBlueCharLabel14.setBounds(new Rectangle(581, 24, 121, 22));
    lblTotalQty3.setBounds(new Rectangle(120, 275, 134, 18));
    lblTotalQty3.setText("Total QTY:4050");
    pnlEachSc1.setLayout(null);
    pnlEachSc1.setBounds(new Rectangle(8, 793, 983, 701));
    pnlEachSc1.setBorder(titledBorder2);
    pnlEachSc1.setFont(new java.awt.Font("Dialog", 1, 11));
    lblTotalCartons2.setText("TOTAL CTNS:5");
    lblTotalCartons2.setBounds(new Rectangle(12, 275, 119, 21));
    whiteBkgBlueCharLabel15.setText("MEAS (L W H)");
    whiteBkgBlueCharLabel15.setBounds(new Rectangle(581, 24, 121, 22));
    jScrollPane3.setBounds(new Rectangle(13, 51, 843, 218));
    whiteBkgBlueCharLabel16.setBounds(new Rectangle(19, 24, 118, 22));
    whiteBkgBlueCharLabel16.setText("COLOR");
    whiteBkgBlueCharLabel17.setBounds(new Rectangle(19, 24, 118, 22));
    whiteBkgBlueCharLabel17.setText("COLOR");
    whiteBkgBlueCharLabel18.setBounds(new Rectangle(246, 24, 119, 22));
    whiteBkgBlueCharLabel18.setText("CARTON END");
    whiteBkgBlueCharLabel19.setText("SIZE1 SIZE2 SIZE3 ...");
    whiteBkgBlueCharLabel19.setBounds(new Rectangle(368, 24, 210, 22));
    whiteBkgBlueCharLabel110.setText("CARTON BGN");
    whiteBkgBlueCharLabel110.setBounds(new Rectangle(139, 24, 104, 22));
    PnlStylInPacking2.setBorder(titledBorder4);
    PnlStylInPacking2.setBounds(new Rectangle(6, 22, 874, 305));
    PnlStylInPacking2.setLayout(null);
    whiteBkgBlueCharLabel20.setBounds(new Rectangle(246, 24, 119, 22));
    whiteBkgBlueCharLabel20.setText("CARTON END");
    whiteBkgBlueCharLabel21.setBounds(new Rectangle(705, 24, 145, 22));
    whiteBkgBlueCharLabel21.setText("Wt (GW NW NNW) Unit");
    lblTotalCartons3.setText("TOTAL CTNS:5");
    lblTotalCartons3.setBounds(new Rectangle(12, 275, 119, 21));
    whiteBkgBlueCharLabel22.setText("CARTON BGN");
    whiteBkgBlueCharLabel22.setBounds(new Rectangle(139, 24, 104, 22));
    PnlStylInPacking3.setBorder(titledBorder5);
    PnlStylInPacking3.setBounds(new Rectangle(7, 364, 874, 305));
    PnlStylInPacking3.setLayout(null);
    jScrollPane4.setBounds(new Rectangle(13, 51, 843, 218));
    whiteBkgBlueCharLabel111.setBounds(new Rectangle(705, 24, 145, 22));
    whiteBkgBlueCharLabel111.setText("Wt (GW NW NNW) Unit");
    btnExit.setBounds(new Rectangle(686, 1501, 127, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlEachSc, null);
    PnlStylInPacking.add(whiteBkgBlueCharLabel4, null);
    PnlStylInPacking.add(whiteBkgBlueCharLabel5, null);
    PnlStylInPacking.add(jScrollPane1, null);
    PnlStylInPacking.add(whiteBkgBlueCharLabel6, null);
    PnlStylInPacking.add(whiteBkgBlueCharLabel1, null);
    PnlStylInPacking.add(whiteBkgBlueCharLabel2, null);
    PnlStylInPacking.add(whiteBkgBlueCharLabel3, null);
    PnlStylInPacking.add(lblTotalCartons, null);
    PnlStylInPacking.add(lblTotalQty, null);
    jScrollPane1.add(jTable1, null);
    pnlEachSc.add(PnlStylInPacking, null);
    PnlStylInPacking1.add(whiteBkgBlueCharLabel7, null);
    PnlStylInPacking1.add(whiteBkgBlueCharLabel8, null);
    PnlStylInPacking1.add(jScrollPane2, null);
    PnlStylInPacking1.add(whiteBkgBlueCharLabel10, null);
    PnlStylInPacking1.add(whiteBkgBlueCharLabel11, null);
    PnlStylInPacking1.add(whiteBkgBlueCharLabel9, null);
    PnlStylInPacking1.add(whiteBkgBlueCharLabel12, null);
    PnlStylInPacking1.add(lblTotalCartons1, null);
    PnlStylInPacking1.add(lblTotalQty1, null);
    this.add(pnlEachSc1, null);
    PnlStylInPacking2.add(whiteBkgBlueCharLabel13, null);
    PnlStylInPacking2.add(whiteBkgBlueCharLabel14, null);
    PnlStylInPacking2.add(jScrollPane3, null);
    PnlStylInPacking2.add(whiteBkgBlueCharLabel21, null);
    PnlStylInPacking2.add(whiteBkgBlueCharLabel22, null);
    PnlStylInPacking2.add(whiteBkgBlueCharLabel20, null);
    PnlStylInPacking2.add(whiteBkgBlueCharLabel17, null);
    PnlStylInPacking2.add(lblTotalCartons3, null);
    PnlStylInPacking2.add(lblTotalQty3, null);
    pnlEachSc1.add(PnlStylInPacking3, null);
    jScrollPane3.add(jTable4, null);
    pnlEachSc1.add(PnlStylInPacking2, null);
    PnlStylInPacking3.add(whiteBkgBlueCharLabel19, null);
    PnlStylInPacking3.add(whiteBkgBlueCharLabel15, null);
    PnlStylInPacking3.add(jScrollPane4, null);
    PnlStylInPacking3.add(whiteBkgBlueCharLabel111, null);
    PnlStylInPacking3.add(whiteBkgBlueCharLabel110, null);
    PnlStylInPacking3.add(whiteBkgBlueCharLabel18, null);
    PnlStylInPacking3.add(whiteBkgBlueCharLabel16, null);
    PnlStylInPacking3.add(lblTotalCartons2, null);
    PnlStylInPacking3.add(lblTotalQty2, null);
    this.add(btnExit, null);
    jScrollPane4.add(jTable3, null);
    jScrollPane2.add(jTable2, null);
    pnlEachSc.add(PnlStylInPacking1, null);
  }
}
