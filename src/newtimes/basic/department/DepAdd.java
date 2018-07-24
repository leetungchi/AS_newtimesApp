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

public class DepAdd extends JPanel {
  Frame1 frame;
  private JButton butnAdd = new JButton();
  private JTextField txtAbbrName = new JTextField();
  private JTextField txtDepName = new JTextField();
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
  private exgui.DataBindText tx = null;
  private exgui.DataBindJCombobox dbJCBXname = null;
  private exgui.DataBindJCombobox dbJCBXdir = null;
  JLabel jTextField7 = new JLabel();
  JTextField txtPrefix = new JTextField();
  boolean isInitialzing=false;
  Object selectedCenValue=null;
  public DepAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    isInitialzing=true;
    this.setMaxLength();
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Department Add  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setText(" * Department Code :");
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setText(" Department Name :");
    jTextField2.setBounds(new Rectangle(178, 171, 155, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(Color.white);
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setText(" Abbr Name :");
    jTextField3.setBounds(new Rectangle(178, 203, 155, 23));
    jTextField4.setBounds(new Rectangle(178, 235, 155, 23));
    jTextField4.setText(" Director :");
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField5.setBounds(new Rectangle(178, 267, 155, 23));
    jTextField5.setText(" Center :");
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
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(422, 489, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    txtDepCode.setBounds(new Rectangle(335, 107, 271, 23));
    txtDepName.setBounds(new Rectangle(335, 171, 271, 23));
    txtAbbrName.setBounds(new Rectangle(335, 203, 271, 23));
    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(328, 489, 80, 25));
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    cmboDir.setBackground(Color.white);
    cmboDir.setAutoscrolls(false);
    cmboDir.setBounds(new Rectangle(335, 235, 271, 23));
    cmboCenter.setBackground(Color.white);
    cmboCenter.setBounds(new Rectangle(335, 267, 271, 23));
    cmboCenter.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboCenter_itemStateChanged(e);
      }
    });
    jTextField7.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField7.setText(" * Prefix :");
    //jTextField7.setEditable(false);
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    jTextField7.setForeground(Color.white);
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    txtPrefix.setBounds(new Rectangle(335, 139, 38, 23));
    //cbxAllowSwitchUser.setSelectedItem(recDetail.get("ALLOW_SWITCH_USER"));
    this.add(butnExit, null);
    this.add(textAreaStatus, null);
    this.add(jTextField1, null);
    this.add(jLabel1, null);
    this.add(butnAdd, null);
    this.add(txtDepCode, null);
    this.add(txtDepName, null);
    this.add(jTextField5, null);
    this.add(jTextField4, null);
    this.add(jTextField3, null);
    this.add(jTextField2, null);
    this.add(txtAbbrName, null);
    this.add(cmboDir, null);
    this.add(cmboCenter, null);
    this.add(txtPrefix, null);
    this.add(jTextField7, null);
    this.setCmbo();
    cmboCenter_itemStateChanged(null);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.department.DepSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setMaxLength(){
    tx = new exgui.DataBindText(txtPrefix,null,"",2);
    tx = new exgui.DataBindText(txtDepCode,null,"",5);
    tx = new exgui.DataBindText(txtDepName,null,"",60);
    tx = new exgui.DataBindText(txtAbbrName,null,"",9);
  }

  void setCmbo() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataDir = null;

    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "cen_name");
      //vDataDir = exgui2.CONST.BASIC_BASE_EJB.getUserFromType("USR_CODE,USR_NAME", "USR_CODE", 3);
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      //database.datatype.Record recDir = (database.datatype.Record) vDataDir.get(0);
      dbJCBXname = new exgui.DataBindJCombobox(cmboCenter, vDataCen, "CEN_NAME",
                                           "CEN_CODE", recCen.get("CEN_CODE"));
      /*
      dbJCBXdir = new exgui.DataBindJCombobox(cmboDir, vDataDir, "USR_NAME",
                                           "USR_NAME", recDir.get("usr_code"));
      */
     isInitialzing=false;
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "center data:"+vDataCen.toString()+
                                 "\ndirector data:"+vDataDir.toString());
    }
  }

  boolean checkFieldsData() {
    boolean codeNull = exgui2.Stuff.checkNull(frame,txtDepCode.getText(),"Department Code can't be empty.");
    boolean prefixNull = exgui2.Stuff.checkNull(frame,txtPrefix.getText(),"Department Prefix can't be empty.");
    if(codeNull && prefixNull) {
      return true;
    } else {return false;}
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("dep_code", txtDepCode.getText().trim().toUpperCase());
        hm.put("DEP_PREFIX", txtPrefix.getText().trim().toUpperCase());
        hm.put("dep_name", txtDepName.getText().trim().toUpperCase());
        hm.put("dep_abbr", txtAbbrName.getText().trim().toUpperCase());
        hm.put("dir", dbJCBXdir.getSelectedValue());
        hm.put("center", dbJCBXname.getSelectedValue().toString());
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        //hm.put("ALLOW_SWITCH_USER",cbxAllowSwitchUser.getSelectedItem());
        int isOk = exgui2.CONST.BASIC_BASE_EJB.insertDepartment(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.department.DepSearch(frame));
      } catch (Exception eIn) {
        eIn.printStackTrace();
        util.ExceptionLog.exp2File(eIn, "HashMap:" + hm.toString());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void cmboCenter_itemStateChanged(ItemEvent e) {
    if(isInitialzing)return;
    java.util.Vector vct=new java.util.Vector();
    if(util.MiscFunc.isEqual(selectedCenValue,dbJCBXname.getSelectedValue()))return;
    selectedCenValue=null;
    if(dbJCBXname!=null && dbJCBXname.getSelectedValue()!=null){
      try{
        String usrCenCode=(String)dbJCBXname.getSelectedValue();
        selectedCenValue=usrCenCode;
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
                                        "USR_CODE", null);

    /*
    if(vct.size()>0){
      dbJCBXdir = new exgui.DataBindJCombobox(cmboDir, vct, "USR_NAME",
                                              "USR_CODE", null);
    }else{
      dbJCBXdir = new exgui.DataBindJCombobox(cmboDir, vct, "USR_NAME",
                                              "USR_CODE", null,"",null);
    }*/

  }
}
