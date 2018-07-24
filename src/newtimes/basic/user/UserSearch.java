package newtimes.basic.user;

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

public class UserSearch extends JPanel {
  Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JTextField jTextField3 = new JTextField();
  private JComboBox cmboCen = new JComboBox();
  private JComboBox cmboDep = new JComboBox();
  private JComboBox cmboMag = new JComboBox();
  private JButton butnExit = new JButton();
  private JButton butnExtract = new JButton();
  private JButton butnAdd = new JButton();
  private exgui.DataBindJCombobox dbJCBXDep = null;
  private exgui.DataBindJCombobox dbJCBXCen = null;
  private exgui.DataBindJCombobox dbJCBXMag = null;

  public UserSearch(Frame1 _frame) {
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
    jLabel1.setText("      ============  User Search  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setFont(new java.awt.Font("Dialog", 0, 11));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setEditable(false);
    jTextField1.setText(" Center :");
    jTextField1.setBounds(new Rectangle(186, 112, 155, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setEditable(false);
    jTextField2.setText(" Department :");
    jTextField2.setBounds(new Rectangle(186, 156, 155, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    jTextField3.setEditable(false);
    jTextField3.setText(" Manager :");
    jTextField3.setBounds(new Rectangle(186, 199, 155, 23));
    cmboCen.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(343, 112, 271, 23));
    cmboCen.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cmboCen_actionPerformed(e);
      }
    });
    cmboCen.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCen_itemStateChanged(e);
      }
    });
    cmboDep.setBackground(Color.white);
    cmboDep.setBounds(new Rectangle(343, 156, 271, 23));
    cmboDep.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboDep_itemStateChanged(e);
      }
    });
    cmboMag.setBackground(Color.white);
    cmboMag.setBounds(new Rectangle(343, 199, 271, 23));
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
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnAdd, null);
    this.add(butnExtract, null);
    this.add(butnExit, null);
    this.add(cmboCen, null);
    this.add(jTextField1, null);
    this.add(jTextField2, null);
    this.add(cmboDep, null);
    this.add(jTextField3, null);
    this.add(cmboMag, null);
    this.setCmboUser();
    if(util.ApplicationProperites.getProperties("allData")!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties("allData"));
    }
  }

  void setCmboUser() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataMag = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME","cen_name");
      vDataMag = exgui2.CONST.BASIC_BASE_EJB.getManagerAll("MNG_CODE,MNG_ABBR","MNG_ABBR");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      database.datatype.Record recMag = (database.datatype.Record) vDataMag.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                    "CEN_CODE", recCen.get("CEN_CODE"));
      dbJCBXMag = new exgui.DataBindJCombobox(cmboMag, vDataMag, "MNG_ABBR",
                                    "MNG_CODE", recMag.get("MNG_CODE"),"","null");
      this.setDepItem("DEP_CEN_CODE = '"+dbJCBXCen.getSelectedValue()+"'");
      cmboMag.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set CmboBox datas.");
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("allData");
    util.ApplicationProperites.removeProperites("recDetail");
    frame.showPanel(new newtimes.basic.BasicMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.user.UserAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboData() {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      hm.put("usr_code", util.PublicVariable.USER_RECORD.get("USR_CODE"));
      hm.put("cen_code", dbJCBXCen.getSelectedValue());
      hm.put("dep_code", dbJCBXDep == null ? "null" : dbJCBXDep.getSelectedValue());
      hm.put("mng_code", dbJCBXMag.getSelectedValue());
      hm.put("cen_code_item", cmboCen.getSelectedItem());
      hm.put("dep_code_item", cmboDep.getSelectedItem());
      hm.put("mng_code_item", cmboMag.getSelectedItem());
      util.ApplicationProperites.setProperties("allData", hm);
      frame.showPanel(new newtimes.basic.user.UserList(frame));
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm, "error at HashMap." + hm.toString());
    }
  }

  void butnExtract_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    this.setCmboData();
    frame.showPanel(new newtimes.basic.user.UserList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void ResetOrigValue(java.util.HashMap hm){
    cmboCen.setSelectedItem(hm.get("cen_code_item"));
    cmboDep.setSelectedItem(hm.get("dep_code_item"));
    cmboMag.setSelectedItem(hm.get("mng_code_item"));
  }

  void cmboCen_itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == e.SELECTED) {
      if (dbJCBXCen != null) {
        this.setDepItem("DEP_CEN_CODE = '" + dbJCBXCen.getSelectedValue() + "'");

      }
    }
  }
  void initManagerList(){
    try{
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
      java.util.Vector vct=new java.util.Vector();
      if(dbJCBXCen!=null && dbJCBXDep!=null){
        Object objCen = dbJCBXCen.getSelectedValue();
        Object objDep = dbJCBXDep.getSelectedValue();
       if(objCen!=null && (!objCen.toString().toUpperCase().equals("NULL"))
          && objDep!=null && (!objDep.toString().toUpperCase().equals("NULL")))
        vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from manager where mng_cen_code='" +
            objCen + "' and mng_dep_code ='" + objDep +
            "' and record_delete_flag='1'", 1, 999
            );
      }

      dbJCBXMag = new exgui.DataBindJCombobox(cmboMag, vct, "MNG_ABBR",
                                    "MNG_CODE", "null","","null");

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error in obtainning manager datas\nPlease Contact System Manager",
                                             "Error In Manager Datas");
    }finally{
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }
  void setDepItem(String whereClause) {
    java.util.Vector vDataDep = null;
    setCursor(new Cursor(Cursor.WAIT_CURSOR));
    try {
      /* exgui2.CONST.BASIC_BASE_EJB => ¨ú±o ejb ¦WºÙ
         getDepartment => ejb METHOD */
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
      initManagerList();
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD, "error at set Dep. items.\n"+"vector:"+vDataDep.toString());
    }finally{
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void cmboDep_itemStateChanged(ItemEvent e) {
    initManagerList();
  }

  void cmboCen_actionPerformed(ActionEvent e) {

  }
}
