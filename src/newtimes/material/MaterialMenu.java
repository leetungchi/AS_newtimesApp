package newtimes.material;

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

public class MaterialMenu extends JPanel {
 Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JButton butnLogout = new JButton();
  private JButton butnExit = new JButton();
  private JLabel labelTitle = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  static protected java.util.Vector Destination4Mtrl=null;
  public MaterialMenu(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    CONST.HIST = new UI_History();
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Material Maintain  ============      ");
    jLabel1.setBounds(new Rectangle(117, 93, 566, 24));
    labelTitle.setText("title");
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(432, 492, 80, 25));
    butnExit.setBackground(Color.lightGray);
    butnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogout_actionPerformed(e);
      }
    });
    butnLogout.setText("Logout");
    butnLogout.setForeground(Color.darkGray);
    butnLogout.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogout.setBounds(new Rectangle(290, 492, 80, 25));
    butnLogout.setBackground(Color.lightGray);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jButton1.setBackground(Color.white);
    jButton1.setBounds(new Rectangle(211, 186, 378, 23));
    jButton1.setFont(new java.awt.Font("Dialog", 0, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setHorizontalAlignment(SwingConstants.LEFT);
    jButton1.setText(" 1.  Material Maintain");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setBackground(Color.white);
    jButton2.setBounds(new Rectangle(211, 223, 378, 23));
    jButton2.setFont(new java.awt.Font("Dialog", 0, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setHorizontalAlignment(SwingConstants.LEFT);
    jButton2.setText(" 2.  Restore Delete Data");
    jButton2.addActionListener(new ActionListener(this));
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    this.add(textAreaStatus, null);
    this.add(butnLogout, null);
    this.add(butnExit, null);
    this.add(jLabel1, null);
    this.add(labelTitle, null);
    this.add(jButton1, null);
    this.add(jButton2, null);
    this.Destination4Mtrl=newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations();
  }
  void butnLogout_actionPerformed(ActionEvent e) {
    frame.showPanel(new newtimes.Login(frame));
  }
  void butnExit_actionPerformed(ActionEvent e) {
    frame.showPanel(new newtimes.MainFunction(frame));
  }
  private void waitCurrency(){
    while(!newtimes.preproduction.process.AttributeFactory.isCurrencyDataReady()){
      try{
        Thread.currentThread().sleep(100);
      }catch(java.lang.InterruptedException ie){

      }
    }
  }
  void jButton1_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    waitCurrency();
    CONST.HIST.insertState(CONST.HIST.MENU,frame);
    frame.showPanel(new newtimes.material.MaterialSearch(frame,1));
    this.setCursor(tCur);
  }
  void jButton2_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    waitCurrency();
    CONST.HIST.insertState(CONST.HIST.MENU,frame);
    frame.showPanel(new newtimes.material.MaterialSearch(frame,2));
    this.setCursor(tCur);
  }
}

class ActionListener implements java.awt.event.ActionListener {
  MaterialMenu adaptee;

  ActionListener(MaterialMenu adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}
