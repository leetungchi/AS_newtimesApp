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

public class ManagerEdit extends JPanel {
  Frame1 frame;
  private JTextField txtAbbr = new JTextField();
  private JTextField txtMagCode = new JTextField();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JComboBox cmboDep = new JComboBox();
  private JComboBox cmboCen = new JComboBox();
  private JButton butnDel = new JButton();
  private JButton butnExit = new JButton();
  private exgui.DataBindJCombobox dbJCBXDep = null;
  private exgui.DataBindJCombobox dbJCBXCen = null;
  protected String orgMngCode=null;
  private java.util.HashMap hm =
      (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  static boolean isExit = false;
  JButton btnUpdate = new JButton();

  public ManagerEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    //txtAbbr.setBackground(new Color(212, 208, 200));
    txtAbbr.setEnabled(true);
    txtAbbr.setEditable(true);
    this.setMaxLength();
    cmboCen.setBackground(Color.white);
    cmboCen.setEnabled(true);
    cmboCen.setDoubleBuffered(false);
    cmboCen.setBounds(new Rectangle(335, 171, 271, 23));
    cmboCen.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCen_itemStateChanged(e);
      }
    });
    cmboDep.setBackground(Color.white);
    cmboDep.setEnabled(true);
    cmboDep.setBounds(new Rectangle(335, 203, 271, 23));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Manager Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setText(" * Manager Code :");
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setText(" Abbr :");
    jTextField2.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField4.setBounds(new Rectangle(178, 171, 155, 23));
    jTextField4.setText(" Center :");
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField5.setBounds(new Rectangle(178, 203, 155, 23));
    jTextField5.setText(" Department :");
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setForeground(Color.white);
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    txtMagCode.setBounds(new Rectangle(335, 107, 271, 23));
    txtMagCode.setEnabled(true);
    //txtMagCode.setEditable(false);
    //txtMagCode.setEnabled(false);
    txtAbbr.setBounds(new Rectangle(335, 139, 271, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnDel.setBackground(Color.lightGray);
    butnDel.setBounds(new Rectangle(308, 474, 80, 22));
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setForeground(Color.darkGray);
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(403, 474, 80, 22));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    btnUpdate.setBackground(Color.lightGray);
    btnUpdate.setBounds(new Rectangle(211, 474, 81, 22));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setForeground(Color.darkGray);
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    this.add(jTextField1, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField5, null);
    this.add(jTextField4, null);
    this.add(jTextField2, null);
    this.add(cmboDep, null);
    this.add(txtMagCode, null);
    this.add(txtAbbr, null);
    this.add(cmboCen, null);
    this.add(butnExit, null);
    this.add(butnDel, null);
    this.setCmboManager();
    this.setData2Fields();
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.manager.ManagerList(frame));
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
      this.add(butnDel, null);
      this.add(butnExit, null);
      this.add(btnUpdate, null);
      this.add(butnDel, null);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set CmboBox datas.");
    }
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("ORG_MNG_CODE",orgMngCode);
        hm.put("mng_code", txtMagCode.getText());
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_BASE_EJB.deleteManager(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.manager.ManagerList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      }catch(BasicMdlEJBs.ExcpDltReferedByUser  edUser){
        exgui.verification.VerifyLib.showPlanMsg("Sorry,This Record Is Referenced In Some User(s)",
                                                 "Record Referenced");

      }catch(BasicMdlEJBs.ExcpDltReferedByProdution edProdUsed){
       exgui.verification.VerifyLib.showPlanMsg("Sorry,This Record Is Referenced In Some Production(s)",
                                                "Record Referenced");
      }catch(java.rmi.RemoteException re){
       re.printStackTrace();
       util.ExceptionLog.exp2File(re,"");
       exgui.verification.VerifyLib.showAlert("Connection Or Server Side Error\nPlease Contact System Manager",
                                              "Remote Exception");

      }catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
      }finally{
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      txtMagCode.setText(recDetail.get("mng_code")==null?"":recDetail.get("mng_code").toString());
      txtAbbr.setText(recDetail.get("mng_abbr")==null?"":recDetail.get("mng_abbr").toString());
      cmboCen.setSelectedItem(recDetail.get("cen_name")==null?"":recDetail.get("cen_name").toString());
      cmboDep.setSelectedItem(recDetail.get("dep_name")==null?"":recDetail.get("dep_name").toString());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+
                                 recDetail.toString());
    }
  }

  void butnModify_actionPerformed(ActionEvent e) {
    if(txtMagCode.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("manager code can not be blank","manager code required");
      return;
    }
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("ORG_MNG_CODE",orgMngCode);
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("MNG_CODE", txtMagCode.getText().trim().toUpperCase());
        hm.put("MNG_ABBR", txtAbbr.getText().trim().toUpperCase());
        hm.put("MNG_DEP_CODE", dbJCBXDep.getSelectedValue());
        hm.put("MNG_CEN_CODE", dbJCBXCen.getSelectedValue());
        boolean isOk = exgui2.CONST.BASIC_BASE_EJB.updateManager(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.manager.ManagerList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
        }
      }catch(BasicMdlEJBs.ExcpDltReferedByUser  edUser){
        exgui.verification.VerifyLib.showPlanMsg("Sorry,This Manager Code Is Referenced In Some User(s)",
                                                 "Record Referenced");

      }catch(BasicMdlEJBs.ExcpDltReferedByProdution edProdUsed){
       exgui.verification.VerifyLib.showPlanMsg("Sorry,This Manager Code Is Referenced In Some Production(s)",
                                                "Record Referenced");
      }catch(java.rmi.RemoteException re){
       re.printStackTrace();
       util.ExceptionLog.exp2File(re,"");
       exgui.verification.VerifyLib.showAlert("Connection Or Server Side Error\nPlease Contact System Manager",
                                              "Remote Exception");
      }catch (Exception eDel) {
        exgui.verification.VerifyLib.showAlert("Update Fail!!\nPlease Check if Manager Code duplicated",
                                               "Update Fail!!");
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at modify data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtAbbr,null,"",15);
    tx = new exgui.DataBindText(txtMagCode,orgMngCode,"",20);
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

  void btnUpdate_actionPerformed(ActionEvent e) {
    butnModify_actionPerformed(e);
  }
}
