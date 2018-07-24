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

public class CityAdd extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton butnAdd = new JButton();
  private JButton butnExit = new JButton();
  private JLabel jTextField4 = new JLabel();
  private JTextField txtChName = new JTextField();
  private JTextField txtCityName = new JTextField();
  private JLabel jTextField5 = new JLabel();
  private JComboBox cmboCnty = new JComboBox();
  private JLabel jTextField6 = new JLabel();
  private exgui.DataBindJCombobox dbJCBXCnty=null,dbJcbxAreas=null;

  JLabel jTextField7 = new JLabel();
  JComboBox cbxAreas = new JComboBox();
  JLabel jTextField8 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  PnlCenterSelections pnlCenterSelections1 = new PnlCenterSelections();

  public CityAdd(Frame1 _frame) {
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
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  City Add  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setPreferredSize(new Dimension(0, 0));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(310, 479, 80, 25));
    butnAdd.setBackground(Color.lightGray);
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(410, 479, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(new Color(10,36,106));
    //jTextField4.setEditable(false);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    jTextField4.setText(" * City Name :");
    jTextField4.setBounds(new Rectangle(178, 107, 155, 23));
    txtChName.setBounds(new Rectangle(335, 139, 271, 23));
    txtCityName.setBounds(new Rectangle(335, 107, 271, 23));
    txtCityName.setDisabledTextColor(Color.gray);
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(new Color(10,36,106));
    //jTextField5.setEditable(false);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    jTextField5.setText(" Country :");
    jTextField5.setBounds(new Rectangle(178, 172, 155, 23));
    cmboCnty.setBounds(new Rectangle(335, 172, 271, 23));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(Color.white);
    //jTextField6.setEditable(false);
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setText(" City Chinese Name :");
    jTextField6.setBounds(new Rectangle(178, 139, 155, 23));
    cmboCnty.setBackground(Color.white);
    jTextField7.setBounds(new Rectangle(178, 202, 155, 23));
    jTextField7.setText(" AREA:");
    jTextField7.setOpaque(true);
    jTextField7.setBorder(null);
    jTextField7.setForeground(Color.white);
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    cbxAreas.setBackground(Color.white);
    cbxAreas.setBounds(new Rectangle(334, 202, 270, 22));
    jTextField8.setBounds(new Rectangle(177, 234, 156, 162));
    jTextField8.setText("<html><body>Selectable<br>Centers</body></html>");
    jTextField8.setOpaque(true);
    jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField8.setBorder(null);
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setBackground(new Color(143, 143, 188));
    jScrollPane1.setBounds(new Rectangle(333, 235, 271, 161));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(cmboCnty, null);
    this.add(jTextField4, null);
    this.add(jTextField6, null);
    this.add(jTextField5, null);
    this.add(txtCityName, null);
    this.add(txtChName, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    this.add(jTextField7, null);
    this.add(cbxAreas, null);
    this.add(jTextField8, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(pnlCenterSelections1, null);
    this.setCmboCity();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.city.CitySearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboCity() {
    java.util.Vector vDataCnty = null,vDataAreas=null;
    try {
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      vDataAreas=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,"select * from world_area order by area_name",1,9999);
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"));
      cmboCnty.setSelectedIndex(0);
      dbJcbxAreas= new exgui.DataBindJCombobox(cbxAreas, vDataAreas,
                                               "AREA_NAME",
                                               "Area_pk",null,"",null);
      pnlCenterSelections1.setCenterCammaString(null);

    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "country data:"+vDataCnty.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtCityName,null,"",40);
    tx = new exgui.DataBindText(txtChName,null,"",40);
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("CITY_NAME", txtCityName.getText().trim().toUpperCase());
        hm.put("CITY_CHINESE_NAME", txtChName.getText());
        hm.put("CITY_CNTY_NAME", dbJCBXCnty.getSelectedValue().toString());
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("CITY_AREA_PK",dbJcbxAreas.getSelectedValue());
        hm.put("SELECTABLE_CENTER", pnlCenterSelections1.getCenterCammaString() );
        int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertCity(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.city.CitySearch(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtCityName.getText(),"City Name can't be empty.");
    if (nameNull) { return true; }
    else { return false; }
  }
}
