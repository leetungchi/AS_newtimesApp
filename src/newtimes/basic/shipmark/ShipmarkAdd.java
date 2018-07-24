package newtimes.basic.shipmark;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ShipmarkAdd extends JPanel {
  Frame1 frame;
  JLabel jTextField3 = new JLabel();
  JLabel jTextField2 = new JLabel();
  JLabel jTextField1 = new JLabel();
  JButton butnAdd = new JButton();
  JLabel textAreaStatus = new JLabel();
  JButton butnExit = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jTextField4 = new JLabel();
  exgui.DataBindJCombobox dbJCBXBuyer = null;
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaMain = new JTextArea();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTextArea txtAreaPacking = new JTextArea();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea txtAreaSide = new JTextArea();
  SelectBuyerMaker slkChzBuyer = new SelectBuyerMaker();

  public ShipmarkAdd(Frame1 _frame) {
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
    jLabel1.setText("      ============  Shipmark Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("DialogInput", 1, 13));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("DialogInput", 1, 13));
    butnExit.setBounds(new Rectangle(412, 512, 80, 25));
    butnExit.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setRequestFocusEnabled(false);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(312, 512, 80, 25));
    butnAdd.setFont(new java.awt.Font("DialogInput", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    jTextField1.setBounds(new Rectangle(116, 56, 155, 23));
    jTextField1.setText(" Buyer :");
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(116, 82, 155, 225));
    jTextField2.setText(" Main Mark :");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setForeground(Color.white);
    jTextField2.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField3.setBounds(new Rectangle(116, 320, 155, 180));
    jTextField3.setText(" Side Mark :");
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setVerifyInputWhenFocusTarget(true);
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setText(" Packing Mark :");
    jTextField4.setBounds(new Rectangle(114, 301, 155, 68));
    jScrollPane1.setBounds(new Rectangle(273, 82, 423, 225));
    txtAreaMain.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtAreaMain.setLineWrap(true);
    jScrollPane3.setBounds(new Rectangle(271, 301, 423, 68));
    txtAreaPacking.setLineWrap(true);
    jScrollPane2.setBounds(new Rectangle(273, 320, 423, 178));
    txtAreaSide.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtAreaSide.setText("");
    txtAreaSide.setLineWrap(true);
    slkChzBuyer.setBounds(new Rectangle(274, 56, 420, 22));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    //this.add(jScrollPane3, null);
    //this.add(jTextField4, null);
    this.add(jTextField1, null);
    this.add(slkChzBuyer, null);
    this.add(jTextField2, null);
    this.add(jScrollPane1, null);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(jTextField3, null);
    this.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(txtAreaSide, null);
    jScrollPane1.getViewport().add(txtAreaMain, null);
    jScrollPane3.getViewport().add(txtAreaPacking, null);
    this.setCmboBuyer();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.shipmark.ShipmarkSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboBuyer() {
    java.util.Vector vDataBuyer = null;
    try {
      /*
      vDataBuyer = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF",1);
      database.datatype.Record rec = (database.datatype.Record) vDataBuyer.get(0);
      dbJCBXBuyer = new exgui.DataBindJCombobox(cmboBuyer, vDataBuyer, "BYMKR_BRIEF",
                                           "BYMKR_SEQ", rec.get("BYMKR_SEQ"),"","");
      */
      slkChzBuyer.init("",null,slkChzBuyer.TYPE_BUYER,true);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "buyer data:"+vDataBuyer.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtAreaMain,null,"",1000);
    tx = new exgui.DataBindText(txtAreaSide,null,"",1000);
    tx = new exgui.DataBindText(txtAreaPacking,null,"",300);
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    java.util.HashMap hm = new java.util.HashMap();
    try {
      hm.put("SHIPMARK_BYMKR_SEQ",slkChzBuyer.getSelectedValue()); //dbJCBXBuyer.getSelectedValue().toString());
      hm.put("SHIPMARK_MAIN_MARK", txtAreaMain.getText());
      hm.put("SHIPMARK_SIDE_MARK", txtAreaSide.getText());
      hm.put("SHIPMARK_PACKING", txtAreaPacking.getText());
      hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
      int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertShipmark(hm);
      if (exgui2.Stuff.insertMessage(frame, isOk))
        frame.showPanel(new newtimes.basic.shipmark.ShipmarkSearch(frame));
    } catch (Exception eAdd) {
      eAdd.printStackTrace();
      util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
