package newtimes.basic.season;

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

public class SeasonEdit extends JPanel {
  Frame1 frame;
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JTextField txtWeight = new JTextField();
  private JTextField txtSeason = new JTextField();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton butnDel = new JButton();
  private JButton butnModify = new JButton();
  private JButton butnExit = new JButton();
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  static boolean isExit = false;

  public SeasonEdit(Frame1 _frame) {
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
    jLabel1.setText("      ============  Season Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    txtSeason.setBounds(new Rectangle(335, 107, 271, 23));
    txtSeason.setEnabled(false);
    txtSeason.setOpaque(false);
    txtSeason.setEditable(false);
    txtWeight.setBounds(new Rectangle(335, 139, 271, 23));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(Color.white);
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setText(" Weight :");
    jTextField1.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setText(" * Season :");
    jTextField2.setBounds(new Rectangle(178, 107, 155, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnDel.setForeground(Color.darkGray);
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setBounds(new Rectangle(371, 480, 80, 25));
    butnDel.setBackground(Color.lightGray);
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setForeground(Color.darkGray);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setBounds(new Rectangle(225, 480, 131, 25));
    butnModify.setBackground(Color.lightGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(466, 480, 80, 25));
    butnExit.setBackground(Color.lightGray);
    this.add(jTextField2, null);
    this.add(jTextField1, null);
    this.add(txtWeight, null);
    this.add(txtSeason, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnModify, null);
    this.add(butnDel, null);
    //this.setCmboSeason();
    this.setData2Fields();
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.season.SeasonList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("SEA_NAME", txtSeason.getText().trim().toUpperCase());
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.deleteSeason(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.season.SeasonList(frame));
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
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("SEA_NAME", txtSeason.getText().trim().toUpperCase());
        //hm.put("SEA_YEAR", txtYear.getText().toString());
        //hm.put("SEA_BUYER", dbJCBXBuyer.getSelectedValue().toString());
        hm.put("SEA_WEIGHT", txtWeight.getText());
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.updateSeason(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.season.SeasonList(frame));
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
      txtSeason.setText(recDetail.get("sea_name")==null?"":recDetail.get("sea_name").toString());
      txtWeight.setText(recDetail.get("sea_weight")==null?"":recDetail.get("sea_weight").toString());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }

/*
  void setCmboSeason() {
    java.util.Vector vDataBuyer = null;
    try {
      vDataBuyer = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF",1);
      database.datatype.Record rec = (database.datatype.Record) vDataBuyer.get(0);
      dbJCBXBuyer = new exgui.DataBindJCombobox(cmboBuyer, vDataBuyer, "BYMKR_BRIEF",
                                           "BYMKR_SEQ", rec.get("BYMKR_SEQ"),"","");
      cmboBuyer.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "buyer data:"+vDataBuyer.toString());
    }
  }
*/
  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtWeight,null,"",3);
    //tx = new exgui.DataBindText(txtYear,null,"",4);
  }

  boolean checkFieldsData() {
    boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),"Season Weight must be less than 999");
    if (chkInt) { return true; }
    else { return false; }
  }
}
