package newtimes.basic.systemvalue;

import java.awt.*;
import newtimes.*;
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

public class SysValueQuery extends JPanel {
  Frame1 frame;
  JTextField textAreaStatus = new JTextField();
  JButton butnExtract = new JButton();
  JButton butnAdd = new JButton();
  JLabel jLabel1 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JTextField jTextField1 = new JTextField();
  JButton butnExit = new JButton();
  JTextField jTextField2 = new JTextField();
  private exgui.DataBindJCombobox dbJCBXCen = null;
  JComboBox cmboCrncy = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXCrncy = null;
  JTextField jTextField3 = new JTextField();
  JTextField txtIC = new JTextField();
  JLabel jLabel2 = new JLabel();

  public SysValueQuery(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(479, 495, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jTextField1.setBounds(new Rectangle(193, 106, 155, 23));
    jTextField1.setText(" Center :");
    jTextField1.setEditable(false);
    jTextField1.setBorder(null);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    cmboCen.setBounds(new Rectangle(350, 106, 271, 23));
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  System Value Search  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setText("Add New");
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(360, 495, 100, 25));
    butnAdd.setBackground(Color.lightGray);
    butnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtract_actionPerformed(e);
      }
    });
    butnExtract.setText("Extract");
    butnExtract.setForeground(Color.darkGray);
    butnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtract.setBounds(new Rectangle(261, 495, 80, 25));
    butnExtract.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setEditable(false);
    jTextField2.setText(" Currency :");
    jTextField2.setBounds(new Rectangle(193, 146, 155, 23));
    cmboCen.setBackground(Color.white);
    cmboCrncy.setBounds(new Rectangle(350, 146, 271, 23));
    cmboCrncy.setBackground(Color.white);
    jTextField3.setBounds(new Rectangle(193, 186, 155, 23));
    jTextField3.setText(" IC :");
    jTextField3.setEditable(false);
    jTextField3.setBorder(null);
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    txtIC.setText("");
    txtIC.setBounds(new Rectangle(350, 186, 271, 23));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setText("(Input First Letter)");
    jLabel2.setBounds(new Rectangle(350, 213, 111, 23));
    this.add(butnExtract, null);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(cmboCen, null);
    this.add(jTextField1, null);
    this.add(jTextField2, null);
    this.add(cmboCrncy, null);
    this.add(jTextField3, null);
    this.add(txtIC, null);
    this.add(jLabel2, null);
    this.setCmbo();
  }
  void butnExtract_actionPerformed(ActionEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("CENTER",dbJCBXCen.getSelectedValue());
      hm.put("LOCAL_CURRENCY_NAME",dbJCBXCrncy.getSelectedValue());
      hm.put("IC_NAME",txtIC.getText().trim().equals("")?"null":txtIC.getText());
      util.ApplicationProperites.setProperties("allData", hm);
      frame.showPanel(new newtimes.basic.systemvalue.SysValueList(frame));
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm, "error at HashMap."+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.systemvalue.SysValueAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.MiscMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmbo() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataCrncy = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME","cen_name");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                    "CEN_CODE", recCen.get("CEN_CODE"),"","null");
      vDataCrncy = exgui2.CONST.BASIC_MAIN_EJB.getCurrencyAll("CRNCY_NAME", "CRNCY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCrncy.get(0);
      dbJCBXCrncy = new exgui.DataBindJCombobox(cmboCrncy, vDataCrncy, "CRNCY_NAME",
                                           "CRNCY_NAME", rec.get("CRNCY_NAME"),"","null");
      cmboCrncy.setSelectedIndex(0);
      cmboCen.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set CmboBox datas.");
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtIC,null,"",40);
  }
}
