package newtimes.basic.city;

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

public class CitySearch extends JPanel {
  Frame1 frame;
  private JComboBox cmboCnty = new JComboBox();
  private JTextField jTextField1 = new JTextField();
  private JTextField textAreaStatus = new JTextField();
  private JButton butnExit = new JButton();
  private JButton butnAdd = new JButton();
  private JButton butnExtract = new JButton();
  private JLabel jLabel1 = new JLabel();
  private exgui.DataBindJCombobox dbJCBXCnty = null,dbCbxCenter=null;

  JComboBox cbxCenter = new JComboBox();
  static java.util.Vector vctCenters=null;
  JTextField jTextField2 = new JTextField();
//  private BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB basicMainEJB =
//    (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB)util.ApplicationProperites.getProperties("basicMainEJB");

  public CitySearch(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  City Search  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    butnExtract.setBackground(Color.lightGray);
    butnExtract.setBounds(new Rectangle(254, 462, 80, 25));
    butnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtract.setForeground(Color.darkGray);
    butnExtract.setText("Extract");
    butnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtract_actionPerformed(e);
      }
    });
    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(353, 462, 100, 25));
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add New");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(472, 462, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setEditable(false);
    jTextField1.setText(" Country :");
    jTextField1.setBounds(new Rectangle(157, 112, 176, 23));
    cmboCnty.setBackground(Color.white);
    cmboCnty.setBounds(new Rectangle(335, 112, 271, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    cbxCenter.setBounds(new Rectangle(335, 145, 271, 23));
    jTextField2.setBounds(new Rectangle(157, 145, 176, 23));
    jTextField2.setText(" SELECTABLE CENTER :");
    jTextField2.setEditable(false);
    jTextField2.setBorder(null);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    this.add(butnExit, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(cmboCnty, null);
    this.add(butnExtract, null);
    this.add(butnAdd, null);
    this.add(cbxCenter, null);
    this.add(jTextField2, null);
    this.setCmboCity();
    if(util.ApplicationProperites.getProperties("allData")!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties("allData"));
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.BasicMenu(frame));
    util.ApplicationProperites.removeProperites("allData");
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.city.CityAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnExtract_actionPerformed(ActionEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("CNTY_NAME",dbJCBXCnty.getSelectedValue());
      hm.put("CNTY_NAME_ITEM",cmboCnty.getSelectedItem());
      hm.put("SELECTABLE_CENTER",dbCbxCenter.getSelectedValue());
      util.ApplicationProperites.setProperties("allData", hm);
      frame.showPanel(new newtimes.basic.city.CityList(frame));
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm, "error at HashMap."+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setCmboCity() {
    java.util.Vector vDataCnty = null;
    try {
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"),"","null");
      if(vctCenters==null){
        vctCenters=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD ,"select * from center where record_delete_flag='1' order by CEN_NAME",1,999);
      }
      dbCbxCenter = new exgui.DataBindJCombobox(
                       cbxCenter, vctCenters, "CEN_NAME","CEN_CODE",
                       (util.ApplicationProperites.getProperties("allData")==null)?
                       util.PublicVariable.OPERATTING_CENTER:
                       ((java.util.HashMap)util.ApplicationProperites.getProperties("allData")).get("SELECTABLE_CENTER")
                       ,"",null);

      cmboCnty.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "country data:"+vDataCnty.toString());
    }
  }

  void ResetOrigValue(java.util.HashMap hm){
    cmboCnty.setSelectedItem(hm.get("CNTY_NAME_ITEM"));
  }

}
