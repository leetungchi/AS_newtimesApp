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

public class DepEdit extends JPanel {
  Frame1 frame;
  private JButton butnDel = new JButton();
  private JTextField txtAbbrName = new JTextField();
  private JTextField txtDepName = new JTextField();
  private JButton butnModify = new JButton();
  private JTextField txtDepCode = new JTextField();
  private JButton butnExit = new JButton();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JComboBox cmboDir = new JComboBox();
  private JComboBox cmboCenter = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXdir = null;
  private exgui.DataBindJCombobox dbJCBXcenter = null;
  private java.util.HashMap hm =
      (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private exgui.DataBindText tx = null;
  JLabel jTextField7 = new JLabel();
  JTextField txtPrefix = new JTextField();
  static boolean isExit = false;
  boolean isInitialzing=false;
  Object orgDepValue=null;
  cbxCenter_changeListener cbxListen=new cbxCenter_changeListener();
  Object selectedValue=null;
  public DepEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
      cmboCenter.removeItemListener(cbxListen);
      cmboCenter.addItemListener(cbxListen);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    isInitialzing=true;
    this.setMaxLength();
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Departments Edit  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField1.setText(" * Department Code :");
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(178, 171, 155, 23));
    jTextField2.setText(" Department Name :");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField3.setBounds(new Rectangle(178, 203, 155, 23));
    jTextField3.setText(" Abbr Name :");
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setForeground(Color.white);
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setText(" Director :");
    jTextField4.setBounds(new Rectangle(178, 235, 155, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setText(" Center :");
    jTextField5.setBounds(new Rectangle(178, 267, 155, 23));
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
    butnExit.setBounds(new Rectangle(469, 495, 80, 25));
    butnExit.setBackground(Color.lightGray);
    txtDepCode.setEnabled(false);
    txtDepCode.setEditable(false);
    txtDepCode.setBounds(new Rectangle(335, 107, 271, 23));
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setForeground(Color.darkGray);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setBounds(new Rectangle(227, 495, 132, 25));
    butnModify.setBackground(Color.lightGray);
    txtDepName.setBounds(new Rectangle(335, 171, 271, 23));
    txtAbbrName.setBounds(new Rectangle(335, 203, 271, 23));
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnDel.setForeground(Color.darkGray);
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setBounds(new Rectangle(374, 495, 80, 25));
    butnDel.setBackground(Color.lightGray);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    cmboDir.setBackground(Color.white);
    cmboDir.setBounds(new Rectangle(335, 235, 271, 23));
    cmboCenter.setBackground(Color.white);
    cmboCenter.setBounds(new Rectangle(335, 235, 271, 23));
    cmboCenter.setBounds(new Rectangle(335, 267, 271, 23));
    cmboCenter.setBackground(Color.white);
    jTextField7.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField7.setText(" * Prefix :");
    //jTextField7.setEditable(false);
    jTextField7.setForeground(Color.white);
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    jTextField7.setForeground(Color.white);
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    txtPrefix.setEnabled(false);
    txtPrefix.setEditable(false);
    txtPrefix.setBounds(new Rectangle(335, 139, 38, 23));
    this.add(butnModify, null);
    this.add(textAreaStatus, null);
    this.add(jTextField1, null);
    this.add(jLabel1, null);
    this.add(txtDepCode, null);
    this.add(butnDel, null);
    this.add(butnExit, null);
    this.add(jTextField2, null);
    this.add(jTextField5, null);
    this.add(jTextField4, null);
    this.add(jTextField3, null);
    this.add(cmboCenter, null);
    this.add(txtDepName, null);
    this.add(txtAbbrName, null);
    this.add(cmboDir, null);
    this.add(jTextField7, null);
    this.add(txtPrefix, null);
    this.setComboBox();
    this.setData2Fields();
    isInitialzing=false;
    cmboCenter_itemStateChanged();
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.department.DepList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void setComboBox() {
    java.util.Vector vData = null;
    //java.util.Vector vDataDir = null;
    try {
      vData = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME","cen_name");
      //vDataDir = exgui2.CONST.BASIC_BASE_EJB.getUserFromType("USR_CODE,USR_NAME", "USR_CODE", 3);
      database.datatype.Record rec = (database.datatype.Record) vData.get(0);
      //database.datatype.Record recDir = (database.datatype.Record) vDataDir.get(0);
      dbJCBXcenter = new exgui.DataBindJCombobox(cmboCenter, vData, "CEN_NAME",
                                           "CEN_CODE", rec.get("CEN_CODE"));
      /*
      dbJCBXdir = new exgui.DataBindJCombobox(cmboDir, vDataDir, "USR_NAME",
                                           "USR_NAME", recDir.get("usr_code"));
      */
     //isInitialzing=false;
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "data:"+vData.toString());
    }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      txtDepCode.setText(recDetail.get("dep_code")==null?"":recDetail.get("dep_code").toString());
      txtPrefix.setText(recDetail.get("DEP_PREFIX")==null?"":recDetail.get("DEP_PREFIX").toString());
      txtDepName.setText(recDetail.get("dep_name")==null?"":recDetail.get("dep_name").toString());
      txtAbbrName.setText(recDetail.get("dep_abbr")==null?"":recDetail.get("dep_abbr").toString());
      cmboDir.setSelectedItem(recDetail.get("director")==null?"":recDetail.get("director").toString());
      cmboCenter.setSelectedItem(recDetail.get("cen_name")==null?"":recDetail.get("cen_name").toString());
      orgDepValue=(String)recDetail.get("DEP_DIRECTOR");
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+
                                 recDetail.toString());
    }
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("dep_code", txtDepCode.getText().trim().toUpperCase());
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_BASE_EJB.deleteDepartment(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.department.DepList(frame));
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

      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
      }finally{
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("dep_code", txtDepCode.getText().trim().toUpperCase());
        hm.put("DEP_PREFIX", txtPrefix.getText().trim().toUpperCase());
        hm.put("dep_name", txtDepName.getText().trim().toUpperCase());
        hm.put("dep_abbr", txtAbbrName.getText().trim().toUpperCase());
        hm.put("dir", dbJCBXdir.getSelectedValue());
        hm.put("center", dbJCBXcenter.getSelectedValue().toString());
        //hm.put("ALLOW_SWITCH_USER",cbxAllowSwitchUser.getSelectedItem());
        boolean isOk = exgui2.CONST.BASIC_BASE_EJB.updateDepartment(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.department.DepList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at modify data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setMaxLength(){
    tx = new exgui.DataBindText(txtDepName,null,"",60);
    tx = new exgui.DataBindText(txtAbbrName,null,"",9);
  }
  void cmboCenter_itemStateChanged() {
    if(isInitialzing)return;
    isInitialzing=true;
    if(util.MiscFunc.isEqual(selectedValue,dbJCBXcenter.getSelectedValue()))return;
    selectedValue=null;
    System.out.println("calles cmboCenter_itemStateChanged()");
    java.util.Vector vct=new java.util.Vector();
    if(dbJCBXcenter!=null && dbJCBXcenter.getSelectedValue()!=null){
      try{
        String usrCenCode=(String)dbJCBXcenter.getSelectedValue();
        selectedValue=usrCenCode;
        vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select usr_code,usr_name from userfile where record_delete_flag='1' and usr_type=3 and  usr_cen_code='"+usrCenCode+"'",
         1,9999);
      }catch(Exception exp){
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Error In Generating Directors Data\nPlease Contact System Manager",
                                               "Error In Generating Drirectors Data");
        vct=new java.util.Vector();
      }
    }
    dbJCBXdir = new exgui.DataBindJCombobox(cmboDir, vct, "USR_NAME",
                                        "USR_CODE", orgDepValue);
   System.out.println("end of calles cmboCenter_itemStateChanged()");
  }
 class cbxCenter_changeListener implements java.awt.event.ItemListener{
  synchronized public void itemStateChanged(ItemEvent e) {

     cmboCenter_itemStateChanged();
     isInitialzing=false;
   }
 }
}
