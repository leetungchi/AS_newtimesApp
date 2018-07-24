package newtimes.reports.report01.quotacontrol;

import java.awt.*;
import javax.swing.*;
import newtimes.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QuotaAddGUI extends JPanel {
//  Frame1 frame;
  JLabel jLabel11 = new JLabel();
  JComboBox cmboArea = new JComboBox();
  JComboBox cmboCnty = new JComboBox();
  JComboBox cmboCat = new JComboBox();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JTextField txtPercent = new JTextField();
  exgui.DataBindJCombobox dbJCBXCnty = null;
  exgui.DataBindJCombobox dbJCBXCat = null;
  JTextField txtPercentDot = new JTextField();
  JLabel jLabel118 = new JLabel();

  public QuotaAddGUI() {
//    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel10.setBounds(new Rectangle(20, 53, 155, 20));
    jLabel10.setText(" Country :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(new Color(10,36,106));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel9.setBounds(new Rectangle(20, 23, 155, 20));
    jLabel9.setText(" Quota Area :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    cmboCat.setBackground(Color.white);
    cmboCat.setBounds(new Rectangle(560, 23, 209, 20));
    cmboCnty.setBackground(Color.white);
    cmboCnty.setBounds(new Rectangle(177, 53, 209, 20));
    cmboArea.setBackground(Color.white);
    cmboArea.setBounds(new Rectangle(177, 23, 209, 20));
    jLabel11.setBounds(new Rectangle(403, 23, 155, 20));
    jLabel11.setText(" Quota CAT :");
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(Color.white);
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(new Dimension(800, 293));
    this.setBackground(new Color(204, 204, 225));
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setForeground(new Color(10,36,106));
    jLabel12.setOpaque(true);
    jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel12.setText(" Used Percent :");
    jLabel12.setBounds(new Rectangle(403, 53, 155, 20));
    txtPercent.setText("0");
    txtPercent.setHorizontalAlignment(SwingConstants.RIGHT);
    txtPercent.setBounds(new Rectangle(560, 53, 34, 20));
    txtPercent.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtPercent_keyTyped(e);
      }
    });
    txtPercentDot.setText("00");
    txtPercentDot.setBounds(new Rectangle(605, 53, 26, 20));
    jLabel118.setBounds(new Rectangle(597, 54, 13, 20));
    jLabel118.setText(".");
    jLabel118.setFont(new java.awt.Font("Dialog", 1, 18));
    this.add(txtPercent, null);
    this.add(jLabel9, null);
    this.add(cmboArea, null);
    this.add(cmboCat, null);
    this.add(jLabel11, null);
    this.add(cmboCnty, null);
    this.add(jLabel10, null);
    this.add(jLabel12, null);
    this.add(txtPercentDot, null);
    this.add(jLabel118, null);
    this.setCmbo();
  }

  void setCmbo() {
    java.util.Vector vDataCnty = null;
    java.util.Vector vDataCat = null;
    try {
      exgui2.Stuff.getQuotaAreaCode4JComboBox(cmboArea);

      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"));

      vDataCat = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("DISTINCT QTA_CAT","QTA_CAT");
      database.datatype.Record recCat = (database.datatype.Record)vDataCat.get(0);
      dbJCBXCat = new exgui.DataBindJCombobox(cmboCat, vDataCat, "QTA_CAT",
                                   "QTA_CAT", recCat.get("QTA_CAT"));
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at combobox.");
    }
  }

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtPercent, null, "", 3);
    tx = new exgui.DataBindText(txtPercentDot, null, "", 2);
  }

  void txtPercent_keyTyped(KeyEvent e) {
    if (e.getKeyChar() == '.') {
      txtPercentDot.requestFocus();
      e.consume();
    } else {
      newtimes.material.Util.filterNumInput(e, txtPercent.getText());
    }
  }

  void txtPercentDot_keyTyped(KeyEvent e) {
    newtimes.material.Util.filterNumInput(e, txtPercent.getText());
  }
}
