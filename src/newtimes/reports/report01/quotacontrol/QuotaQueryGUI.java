package newtimes.reports.report01.quotacontrol;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QuotaQueryGUI extends JPanel {
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JButton do_Extract = new JButton();
  JButton do_Add = new JButton();
  JLabel jLabel1 = new JLabel();
  JComboBox cmboArea = new JComboBox();
  JComboBox cmboCat = new JComboBox();
  JComboBox cmboCnty = new JComboBox();
  exgui.DataBindJCombobox dbJCBXCnty = null;
  exgui.DataBindJCombobox dbJCBXCat = null;
  static java.util.Vector vDataCnty = null;
  static java.util.Vector vDataCat = null;

  public QuotaQueryGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBounds(new Rectangle(117, 12, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ============  Quota Control  ============      ");

    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(Color.white);
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" Quota Area :");
    jLabel9.setBounds(new Rectangle(24, 55, 155, 20));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Country :");
    jLabel10.setBounds(new Rectangle(407, 55, 155, 20));
    jLabel11.setBackground(new Color(143, 143, 188));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setOpaque(true);
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setText(" Quota CAT :");
    jLabel11.setBounds(new Rectangle(24, 87, 155, 20));
    do_Extract.setFont(new java.awt.Font("Dialog", 1, 12));
    do_Extract.setForeground(Color.darkGray);
    do_Extract.setBounds(new Rectangle(250, 438, 80, 25));
    do_Extract.setText("Extract");
    do_Extract.setMargin(new Insets(0, 0, 0, 0));
    do_Extract.setBounds(new Rectangle(311, 123, 80, 25));
    do_Extract.setBackground(Color.lightGray);
    do_Add.setFont(new java.awt.Font("Dialog", 1, 12));
    do_Add.setForeground(Color.darkGray);
    do_Add.setBounds(new Rectangle(347, 438, 80, 25));
    do_Add.setBackground(Color.lightGray);
    do_Add.setBounds(new Rectangle(404, 123, 80, 25));
    do_Add.setMargin(new Insets(0, 0, 0, 0));
    do_Add.setSelected(false);
    do_Add.setText("ADD");
    cmboArea.setBounds(new Rectangle(181, 55, 209, 20));
    cmboCat.setBounds(new Rectangle(181, 87, 209, 20));
    cmboCnty.setBounds(new Rectangle(564, 55, 209, 20));
    cmboArea.setBackground(Color.white);
    cmboCat.setBackground(Color.white);
    cmboCnty.setBackground(Color.white);
    this.add(jLabel1, null);
    this.add(do_Extract, null);
    this.add(do_Add, null);
    this.add(jLabel9, null);
    this.add(jLabel10, null);
    this.add(jLabel11, null);
    this.add(cmboArea, null);
    this.add(cmboCnty, null);
    this.add(cmboCat, null);
    this.setCmbo();
  }

  void setCmbo() {
    try {
      cmboArea.addItem("");
      exgui2.Stuff.getQuotaAreaCode4JComboBox(cmboArea);

      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"),"","null");

      vDataCat = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("DISTINCT QTA_CAT","QTA_CAT");
      database.datatype.Record recCat = (database.datatype.Record)vDataCat.get(0);
      dbJCBXCat = new exgui.DataBindJCombobox(cmboCat, vDataCat, "QTA_CAT",
                                   "QTA_CAT", recCat.get("QTA_CAT"), "", "null");
      cmboCat.setSelectedIndex(0);
      cmboCnty.setSelectedIndex(0);
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at combobox.");
    }
  }
}
