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

public class SeasonAdd extends JPanel {
  Frame1 frame;
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JTextField txtSeason = new JTextField();
  private JTextField txtWeight = new JTextField();
  private JLabel textAreaStatus = new JLabel();
  private JButton butnAdd = new JButton();
  private JButton butnExit = new JButton();
  private JLabel jLabel1 = new JLabel();
  //private exgui.DataBindJCombobox dbJCBXBuyer = null;

  public SeasonAdd(Frame1 _frame) {
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
    jLabel1.setText("      ============  Season Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(403, 481, 80, 25));
    butnExit.setBackground(Color.lightGray);
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(309, 481, 80, 25));
    butnAdd.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    txtWeight.setBounds(new Rectangle(335, 139, 271, 23));
    txtSeason.setBounds(new Rectangle(335, 107, 271, 23));
    jTextField1.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField1.setText(" Weight :");
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(Color.white);
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField2.setText(" * Season :");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setRequestFocusEnabled(true);
    this.add(jTextField1, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(txtWeight, null);
    this.add(txtSeason, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    this.add(jTextField2, null);
    //this.setCmboSeason();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.season.SeasonList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("SEA_NAME", txtSeason.getText().trim().toUpperCase());
        hm.put("SEA_WEIGHT", txtWeight.getText());
        //hm.put("SEA_YEAR", txtYear.getText());
        //hm.put("SEA_BUYER", dbJCBXBuyer.getSelectedValue().toString());
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertSeason(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.season.SeasonList(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
/*
  void setCmboSeason() {
    java.util.Vector vDataBuyer = null;
    try {
      vDataBuyer = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF",1);
      database.datatype.Record rec = (database.datatype.Record) vDataBuyer.get(0);
      dbJCBXBuyer = new exgui.DataBindJCombobox(cmboBuyer, vDataBuyer, "BYMKR_BRIEF",
                                           "BYMKR_SEQ", rec.get("BYMKR_SEQ"),"","");
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "buyer data:"+vDataBuyer.toString());
    }
  }
*/

  boolean checkFieldsData() {
    boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),"Season Weight must be less than 999");
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtSeason.getText(),"Season Name can't be empty.");
    if (nameNull && chkInt) { return true; }
    else { return false; }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtWeight,null,"",3);
    tx = new exgui.DataBindText(txtSeason,null,"",60);
    //tx = new exgui.DataBindText(txtYear,null,"",4);
  }
}
