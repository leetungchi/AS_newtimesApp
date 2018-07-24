package newtimes.basic.manager;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ManagerAdd extends JPanel {
  Frame1 frame;
  private JButton butnAdd = new JButton();
  private JButton butnExit = new JButton();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JComboBox cmboDep = new JComboBox();
  private JComboBox cmboCen = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXDep = null;
  private exgui.DataBindJCombobox dbJCBXCen = null;
  private exgui.DataBindJCombobox dbJCBXMag = null;
  private JComboBox cmboMag = new JComboBox();
  private JLabel jTextField6 = new JLabel();

  public ManagerAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    cmboCen.setBounds(new Rectangle(335, 105, 271, 23));
    cmboCen.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCen_itemStateChanged(e);
      }
    });
    cmboCen.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCen_itemStateChanged(e);
      }
    });
    cmboCen.setBackground(Color.white);
    cmboDep.setBounds(new Rectangle(335, 137, 271, 23));
    cmboDep.setBackground(Color.white);
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Manager Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setText(" Center :");
    jTextField4.setBounds(new Rectangle(178, 105, 155, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setText(" Department :");
    jTextField5.setBounds(new Rectangle(178, 137, 155, 23));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(397, 472, 80, 25));
    butnExit.setBackground(Color.lightGray);
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(303, 472, 80, 25));
    butnAdd.setBackground(Color.lightGray);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    cmboMag.setBackground(Color.white);
    cmboMag.setBounds(new Rectangle(335, 171, 271, 23));
    jTextField6.setBounds(new Rectangle(178, 171, 155, 23));
    jTextField6.setText(" Manager :");
    //jTextField6.setEditable(false);
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setBackground(new Color(143, 143, 188));
    this.add(jLabel1, null);
    this.add(textAreaStatus, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    this.add(cmboCen, null);
    this.add(jTextField4, null);
    this.add(jTextField5, null);
    this.add(cmboDep, null);
    this.add(jTextField6, null);
    this.add(cmboMag, null);
    this.setCmboManager();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.manager.ManagerSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboManager() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataMag = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME","cen_name");
      vDataMag = exgui2.CONST.BASIC_BASE_EJB.getUsrExceptMagCode("USR_CODE", "USR_CODE", "USR_CODE");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      database.datatype.Record recMag = (database.datatype.Record) vDataMag.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                    "CEN_CODE", recCen.get("CEN_CODE"));
      dbJCBXMag = new exgui.DataBindJCombobox(cmboMag, vDataMag, "MAG_NAME",
                                           "USR_CODE", recMag.get("USR_CODE"));
      cmboCen.setSelectedIndex(0);
      cmboMag.setSelectedIndex(0);
      this.setDepItem("DEP_CEN_CODE = '"+dbJCBXCen.getSelectedValue()+"'");
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set CmboBox datas.");
    }
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    java.util.HashMap hm = new java.util.HashMap();
    try {
      hm.put("MNG_CODE", dbJCBXMag.getSelectedValue());      //USR_CODE
      String magAbbr = cmboMag.getSelectedItem().toString(); //USR_NAME
      int indexMag = magAbbr.indexOf("(");
      hm.put("MNG_ABBR", magAbbr.substring(0, indexMag).trim().toUpperCase());
      hm.put("MNG_DEP_CODE", dbJCBXDep.getSelectedValue());
      hm.put("MNG_CEN_CODE", dbJCBXCen.getSelectedValue());
      hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
      int isOk = exgui2.CONST.BASIC_BASE_EJB.insertManager(hm);
      if (exgui2.Stuff.insertMessage(frame, isOk))
        frame.showPanel(new newtimes.basic.manager.ManagerSearch(frame));
    } catch (Exception eIn) {
      eIn.printStackTrace();
      util.ExceptionLog.exp2File(eIn, "HashMap:" + hm.toString());
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void cmboCen_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      if (dbJCBXCen != null) {
        this.setDepItem("DEP_CEN_CODE = '" + dbJCBXCen.getSelectedValue() + "'");
      }
    }
  }

  void setDepItem(String whereClause) {
    java.util.Vector vDataDep = null;
    try {
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (!vDataDep.isEmpty()) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJCBXDep = new exgui.DataBindJCombobox(
            cmboDep, vDataDep, "DEP_NAME", "DEP_CODE", recDep.get("DEP_CODE"), "", "null");
        cmboDep.setSelectedIndex(0);
      } else {
        dbJCBXDep = null;
        cmboDep.removeAllItems();
      }
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD, "error at set Dep. items.\n"+"vector:"+vDataDep.toString());
    }
  }
}
