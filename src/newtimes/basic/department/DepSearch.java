package newtimes.basic.department;

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

public class DepSearch extends JPanel {
  Frame1 frame;
  private JButton butnAdd = new JButton();
  private JButton butnExtract = new JButton();
  private JButton butnExit = new JButton();
  private JTextField textAreaStatus = new JTextField();
  private JTextField jTextField1 = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JComboBox cmboCenter = new JComboBox();
  private exgui.DataBindJCombobox dbJCBX = null;
//  private BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB basicEJB =
//    (BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB)util.ApplicationProperites.getProperties("basicEJB");

  public DepSearch(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    cmboCenter.setBounds(new Rectangle(335, 112, 271, 23));
    cmboCenter.setBackground(Color.white);
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Department Search  ============      ");
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
    this.add(jTextField1, null);
    this.add(jLabel1, null);
    this.add(cmboCenter, null);
    this.add(textAreaStatus, null);
    this.add(butnAdd, null);
    this.add(butnExtract, null);
    this.add(butnExit, null);
    this.setCmboCenter();
    if(util.ApplicationProperites.getProperties("allData")!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties("allData"));
    }
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.department.DepAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnExtract_actionPerformed(ActionEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("cen_code",dbJCBX.getSelectedValue());
      hm.put("cen_code_item",cmboCenter.getSelectedItem());
      util.ApplicationProperites.setProperties("allData", hm);
      frame.showPanel(new newtimes.basic.department.DepList(frame));
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

  void setCmboCenter() {
    java.util.Vector vData = null;
    try {
      vData = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME","cen_name");
      database.datatype.Record rec = (database.datatype.Record) vData.get(0);
      dbJCBX = new exgui.DataBindJCombobox(cmboCenter, vData, "CEN_NAME",
                                           "CEN_CODE", rec.get("CEN_CODE"),"","null");
//      cmboCenter.setSelectedItem(util.PublicVariable.USER_RECORD.get("cen_name"));
      cmboCenter.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "data:"+vData.toString());
    }
  }

  void ResetOrigValue(java.util.HashMap hm){
    cmboCenter.setSelectedItem(hm.get("cen_code_item"));
  }

}
