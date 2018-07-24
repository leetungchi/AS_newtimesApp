package newtimes.shipping.shippingmaintain;

import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: This UI moved into the MasterFieldsGUI.java.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class IC_FieldsGUI extends JPanel {
  JLabel jLabel21 = new JLabel();
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField txtAttn = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField txtMonth = new JTextField();
  JTextField txtDay = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField txtYear1 = new JTextField();
  JComboBox jComboBox1 = new JComboBox();
  JComboBox jComboBox2 = new JComboBox();
  JLabel jLabel1 = new JLabel();

  public IC_FieldsGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    txtAttn.setBounds(new Rectangle(177, 71, 209, 20));
    txtAttn.setBounds(new Rectangle(168, 42, 589, 20));
    jLabel10.setBounds(new Rectangle(11, 128, 155, 20));
    jLabel10.setText(" Division :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(new Color(10,36,106));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setOpaque(true);
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setText(" Date :");
    jLabel7.setBounds(new Rectangle(11, 71, 155, 20));
    jLabel19.setBounds(new Rectangle(11, 42, 155, 20));
    jLabel19.setText(" INV :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(Color.white);
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel1112.setBounds(new Rectangle(11, 13, 155, 20));
    jLabel1112.setText(" SRN No. :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setForeground(Color.white);
    jLabel21.setOpaque(true);
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setText(" Season :");
    jLabel21.setBounds(new Rectangle(11, 99, 155, 20));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setText("/");
    jLabel8.setBounds(new Rectangle(274, 71, 15, 25));
    txtMonth.setBounds(new Rectangle(233, 33, 37, 20));
    txtMonth.setBounds(new Rectangle(234, 71, 37, 20));
    txtDay.setBounds(new Rectangle(281, 33, 37, 20));
    txtDay.setBounds(new Rectangle(282, 71, 37, 20));
    jLabel6.setBounds(new Rectangle(225, 71, 15, 25));
    jLabel6.setText("/");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel6.setForeground(new Color(10,36,106));
    txtYear1.setBounds(new Rectangle(167, 33, 54, 20));
    txtYear1.setBounds(new Rectangle(168, 71, 54, 20));
    jComboBox1.setBounds(new Rectangle(168, 99, 589, 20));
    jComboBox2.setBounds(new Rectangle(168, 128, 589, 20));
    jComboBox1.setBackground(Color.white);
    jComboBox2.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel1.setText("jLabel1");
    jLabel1.setBounds(new Rectangle(168, 13, 589, 20));
    this.add(jLabel1112, null);
    this.add(jLabel19, null);
    this.add(jLabel21, null);
    this.add(jLabel7, null);
    this.add(jLabel10, null);
    this.add(txtAttn, null);
    this.add(txtYear1, null);
    this.add(txtDay, null);
    this.add(jLabel8, null);
    this.add(txtMonth, null);
    this.add(jLabel6, null);
    this.add(jComboBox1, null);
    this.add(jComboBox2, null);
    this.add(jLabel1, null);
  }
}
