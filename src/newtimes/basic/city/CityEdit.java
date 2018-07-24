package newtimes.basic.city;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class CityEdit extends JPanel {
  Frame1 frame;
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JComboBox cmboCnty = new JComboBox();
  private JTextField txtChName = new JTextField();
  private JLabel jTextField1 = new JLabel();
  private JTextField txtCityName = new JTextField();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton butnDel = new JButton();
  private JButton butnModify = new JButton();
  private JButton butnExit = new JButton();
  private exgui.DataBindJCombobox dbJCBXCnty = null,dbJcbxAreas=null;
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  static boolean isExit = false;
  Object orgCityValue,orgCountryValue,orgAreaValue;
  public CityEdit(Frame1 _frame) {
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
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  City Edit  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    txtCityName.setEnabled(false);
    txtCityName.setEditable(false);
    txtCityName.setBounds(new Rectangle(335, 107, 271, 23));
    jTextField1.setBounds(new Rectangle(178, 172, 155, 23));
    jTextField1.setText(" Country :");
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    txtChName.setBounds(new Rectangle(335, 139, 271, 23));
    cmboCnty.setBounds(new Rectangle(335, 172, 271, 23));
    jTextField2.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField2.setText(" * City Name :");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField3.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField3.setText(" City Chinese Name :");
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setForeground(Color.white);
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setDebugGraphicsOptions(0);
    butnDel.setBackground(Color.lightGray);
    butnDel.setBounds(new Rectangle(386, 485, 80, 25));
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setForeground(Color.darkGray);
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnModify.setBackground(Color.lightGray);
    butnModify.setBounds(new Rectangle(236, 485, 131, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(485, 485, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    cmboCnty.setBackground(Color.white);
    jTextField7.setBounds(new Rectangle(179, 202, 155, 23));
    jTextField7.setText(" AREA:");
    jTextField7.setOpaque(true);
    jTextField7.setBorder(null);
    jTextField7.setForeground(Color.white);
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    cbxAreas.setBackground(Color.white);
    cbxAreas.setBounds(new Rectangle(335, 202, 270, 22));
    jScrollPane1.setBounds(new Rectangle(335, 232, 271, 161));
    jTextField8.setBounds(new Rectangle(179, 231, 156, 162));
    jTextField8.setText("<html><body>Selectable<br>Centers</body></html>");
    jTextField8.setOpaque(true);
    jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField8.setBorder(null);
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setBackground(new Color(143, 143, 188));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnModify, null);
    this.add(butnDel, null);
    this.add(txtCityName, null);
    this.add(jTextField2, null);
    this.add(jTextField3, null);
    this.add(txtChName, null);
    this.add(cmboCnty, null);
    this.add(jTextField1, null);
    this.add(jTextField7, null);
    this.add(cbxAreas, null);
    this.add(jScrollPane1, null);
    this.add(jTextField8, null);
    jScrollPane1.getViewport().add(pnlCenterSelections1, null);
    this.setCmboCity();
    this.setData2Fields();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.city.CityList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboCity() {
    java.util.Vector vDataCnty = null;
    try {
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");

      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"));

      cmboCnty.setEnabled(false);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "country data:"+vDataCnty.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtChName,null,"",40);
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    //check if this city name is used in production
    try{
      java.util.Vector vctChk = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select count(*) from prod_head where record_delete_flag='1' and prod_city_name='"+
          util.MiscFunc.Replace(txtCityName.getText(),"'","''")+
          "'",1,1);
      database.datatype.Record recTmp=(database.datatype.Record)vctChk.get(0);
      int counts=recTmp.getInt(0);
      if(counts>0){
        exgui.verification.VerifyLib.showAlert("This City is used in some productions",
                                               "Data Is Used");
        return;
      }

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert(
      "Error While Checking Reference Of City\nPlease Contact System Manager",
      "Error in Checking City Reference");
      return;
    }
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        java.util.Vector pkValue= new java.util.Vector();
        pkValue.add(orgCityValue);
        pkValue.add(orgCountryValue);
        hm.put("CITY_PK_VALUE",pkValue);
        hm.put("CITY_NAME", txtCityName.getText());
        hm.put("CITY_CNTY_NAME", dbJCBXCnty.getSelectedValue().toString());
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("CITY_AREA_PK",dbJcbxAreas.getSelectedValue());
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.deleteCity(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.city.CityList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        java.util.Vector pkValue= new java.util.Vector();
        pkValue.add(orgCityValue);
        pkValue.add(orgCountryValue);
        hm.put("CITY_PK_VALUE",pkValue);
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("CITY_NAME", txtCityName.getText().trim().toUpperCase());
        hm.put("CITY_CHINESE_NAME", txtChName.getText());
        hm.put("CITY_CNTY_NAME", dbJCBXCnty.getSelectedValue().toString());
        hm.put("CITY_AREA_PK", dbJcbxAreas.getSelectedValue());
        hm.put("SELECTABLE_CENTER",pnlCenterSelections1.getCenterCammaString());
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.updateCity(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.city.CityList(frame));
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

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      txtCityName.setText(recDetail.get("city_name")==null?"":recDetail.get("city_name").toString());
      txtChName.setText(recDetail.get("city_chinese_name")==null?"":recDetail.get("city_chinese_name").toString());
      cmboCnty.setSelectedItem(recDetail.get("cnty_name")==null?"":recDetail.get("cnty_name").toString());
      pnlCenterSelections1.setCenterCammaString((String)recDetail.get("selectable_center"));
      java.util.Vector vDataAreas=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,"select * from world_area order by area_name",1,9999);
      dbJcbxAreas= new exgui.DataBindJCombobox(cbxAreas, vDataAreas,
                                           "AREA_NAME",
                                           "Area_pk",recDetail.get("city_area_pk"),"",null);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }
  JLabel jTextField7 = new JLabel();
  JComboBox cbxAreas = new JComboBox();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jTextField8 = new JLabel();
  PnlCenterSelections pnlCenterSelections1 = new PnlCenterSelections();
}
