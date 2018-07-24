package newtimes.production.report;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlLaurenIcList
    //extends JPanel {
    extends AbsQryPanel{
  JTextField txtCreateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();
  JTextField txtCreateBgn = new JTextField();
   protected   DataBindTextWithChecker dbTxtCreateBgn,dbTxtCreateEnd;
   protected   DataBindTextWithChecker dbTxtEtdBgn,dbTxtEtdEnd;
   boolean doingDB2Gui=false;

  public PnlLaurenIcList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"ON BOARD DATE");
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder2 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156)),"CREATE DATE");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156)),"ETD DATE");
    jLabel2.setBounds(new Rectangle(5, 15, 56, 21));
    jLabel2.setText("FROM:");
    txtCreateEnd.setBounds(new Rectangle(183, 13, 87, 22));
    txtCreateEnd.setText("");
    this.setLayout(null);
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(150, 13, 36, 24));
    blueBkgWhiteCharLabel1.setText("LIST LAUREN I.C.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 0, 801, 28));
    btnQry.setBounds(new Rectangle(693, 40, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlLaurenIcList_btnQry_actionAdapter(this));
    txtCreateBgn.setText("");
    txtCreateBgn.setBounds(new Rectangle(49, 15, 87, 20));
    this.setBackground(new Color(202, 202, 224));
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setBorder(titledBorder2);
    jPanel1.setBounds(new Rectangle(1, 27, 283, 44));
    jPanel1.setLayout(null);
    jPanel2.setLayout(null);
    jPanel2.setBounds(new Rectangle(360, 27, 283, 44));
    jPanel2.setBorder(titledBorder3);
    jPanel2.setBackground(new Color(202, 202, 224));
    txtEtdEnd.setBounds(new Rectangle(183, 13, 87, 22));
    txtEtdEnd.setText("");
    jLabel5.setBounds(new Rectangle(5, 15, 56, 21));
    jLabel5.setText("FROM:");
    jLabel6.setText("TO:");
    jLabel6.setBounds(new Rectangle(150, 13, 36, 24));
    txtEtdBgn.setText("");
    txtEtdBgn.setBounds(new Rectangle(49, 15, 87, 20));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(txtCreateBgn, null);
    jPanel1.add(txtCreateEnd, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(txtEtdBgn, null);
    jPanel2.add(txtEtdEnd, null);
    this.add(btnQry, null);
    this.add(jPanel2, null);
    genDataBindObj();
    reportName="SHIP_PRL.rpt";
}
public void genDataBindObj() {
  doingDB2Gui=true;
  dataBindComps.clear();
  try{
    //default begin datae is first day of current mount
    //default end date is end day of currecnt mount

    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtCreateBgn =
        new exgui.DataBindTextWithChecker(txtCreateBgn, "P_CRT_FM", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtCreateBgn);

    dbTxtCreateEnd =
        new exgui.DataBindTextWithChecker(txtCreateEnd, "P_CRT_TO", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtCreateEnd);



    dbTxtEtdBgn =
        new exgui.DataBindTextWithChecker(txtEtdBgn, "P_ETD_FM", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtEtdBgn);

    dbTxtEtdEnd =
        new exgui.DataBindTextWithChecker(txtEtdEnd, "P_ETD_TO", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtEtdEnd);




    doingDB2Gui=false;
  }catch(Exception exp){
    exp.printStackTrace();
  }
}
public HashMap composeParameters() {
  HashMap hm = super.composeParameters();
  Object dateBgn = dbTxtCreateBgn.getSelectedValue();
  Object dateEnd = dbTxtCreateEnd.getSelectedValue();
  if (dateBgn == null) {
    hm.put("P_CRT_FM", "DATE(2000,01,01)");
  }
  if (dateEnd == null) {
    hm.put("P_CRT_TO", "DATE(2099,12,31)");
  }

  Object dateEtdBgn = dbTxtEtdBgn.getSelectedValue();
  Object dateEtdEnd = dbTxtEtdEnd.getSelectedValue();
  if (dateEtdBgn == null) {
    hm.put("P_ETD_FM", "DATE(2000,01,01)");
  }
  if (dateEtdEnd == null) {
    hm.put("P_ETD_TO", "DATE(2099,12,31)");
  }

  return hm;
}

void btnQry_actionPerformed(ActionEvent e) {
  JButtonQueryButtonAction(e);
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder2;
  JPanel jPanel2 = new JPanel();
  JTextField txtEtdEnd = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtEtdBgn = new JTextField();
  Border border2;
  TitledBorder titledBorder3;

}

class PnlLaurenIcList_btnQry_actionAdapter implements java.awt.event.
  ActionListener {
PnlLaurenIcList adaptee;

PnlLaurenIcList_btnQry_actionAdapter(PnlLaurenIcList adaptee) {
  this.adaptee = adaptee;
}

 public void actionPerformed(ActionEvent e) {
   adaptee.btnQry_actionPerformed(e);
 }
}
