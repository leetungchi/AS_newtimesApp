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

public class ManagerSearch extends JPanel {
  Frame1 frame;
  private JButton butnAdd = new JButton();
  private JButton butnExtract = new JButton();
  private JButton butnExit = new JButton();
  private JTextField textAreaStatus = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JTextField jTextField1 = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JComboBox cmboDep = new JComboBox();
  private JComboBox cmboCen = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXDep = null;
  private exgui.DataBindJCombobox dbJCBXCen = null;

  public ManagerSearch(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    cmboCen.setBounds(new Rectangle(335, 112, 271, 23));
    cmboCen.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCen_itemStateChanged(e);
      }
    });
    cmboCen.setBackground(Color.white);
    cmboDep.setBounds(new Rectangle(335, 156, 271, 23));
    cmboDep.setBackground(Color.white);
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Manager Search  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextField1.setBounds(new Rectangle(178, 112, 155, 23));
    jTextField1.setText(" Center :");
    jTextField1.setBorder(null);
    jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(178, 156, 155, 23));
    jTextField2.setText(" Department :");
    jTextField2.setBorder(null);
    jTextField2.setEditable(false);
    jTextField2.setForeground(Color.white);
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(472, 462, 80, 25));
    butnExit.setBackground(Color.lightGray);
    butnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtract_actionPerformed(e);
      }
    });
    butnExtract.setText("Extract");
    butnExtract.setForeground(Color.darkGray);
    butnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtract.setBounds(new Rectangle(254, 462, 80, 25));
    butnExtract.setBackground(Color.lightGray);
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setText("Add New");
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(353, 462, 100, 25));
    butnAdd.setBackground(Color.lightGray);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.add(cmboCen, null);
    this.add(jTextField2, null);
    this.add(cmboDep, null);
    this.add(butnExtract, null);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(jLabel1, null);
    this.add(textAreaStatus, null);
    this.add(jTextField1, null);
    this.setCmboManager();
    if(util.ApplicationProperites.getProperties("allData")!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties("allData"));
    }
  }
  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.manager.ManagerAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butnExtract_actionPerformed(ActionEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("CEN_CODE",dbJCBXCen.getSelectedValue());
      hm.put("DEP_CODE",dbJCBXDep == null ? "null" : dbJCBXDep.getSelectedValue());
      hm.put("CEN_CODE_ITEM",cmboCen.getSelectedItem());
      hm.put("DEP_CODE_ITEM",cmboDep.getSelectedItem());
      util.ApplicationProperites.setProperties("allData", hm);
      frame.showPanel(new newtimes.basic.manager.ManagerList(frame));
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm, "error at HashMap."+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("allData");
    frame.showPanel(new newtimes.basic.BasicMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboManager() {
    java.util.Vector vDataCen = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME","cen_name");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                    "CEN_CODE", recCen.get("CEN_CODE"));
      cmboCen.setSelectedIndex(0);
      this.setDepItem("DEP_CEN_CODE = '"+dbJCBXCen.getSelectedValue()+"'");
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set CmboBox datas.");
    }
  }
  void ResetOrigValue(java.util.HashMap hm){
    cmboCen.setSelectedItem(hm.get("CEN_CODE_ITEM"));
    cmboDep.setSelectedItem(hm.get("DEP_CODE_ITEM"));
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
