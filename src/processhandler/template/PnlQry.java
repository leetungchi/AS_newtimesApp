package processhandler.template;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQry extends JPanel {
  JButton BtnBack = new JButton();
  JButton BtnToList = new JButton();
  JLabel jLabel1 = new JLabel();
  JTextField txtKeyWord = new JTextField();
  JButton jbtnAddNew = new JButton();
  CommandSets cmdObj=null;
  public PnlQry() {
    try {
          cmdObj = (CommandSets) Properties.getCenteralControler().
          setSystemCommander(
          Constants.CMD_PROC_TEMP1
          );

      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    BtnBack.setBounds(new Rectangle(321, 291, 94, 27));
    BtnBack.setText("<-Back ");
    BtnBack.addActionListener(new PnlQry_BtnBack_actionAdapter(this));
    this.setLayout(null);
    BtnToList.setBounds(new Rectangle(58, 296, 105, 28));
    BtnToList.setText("submit");
    BtnToList.addActionListener(new PnlQry_BtnToList_actionAdapter(this));
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(new Color(118, 138, 190));
    jLabel1.setOpaque(true);
    jLabel1.setText("KEYWORD");
    jLabel1.setVerticalAlignment(SwingConstants.CENTER);
    jLabel1.setVerticalTextPosition(SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(87, 83, 64, 25));
    txtKeyWord.setText("");
    txtKeyWord.setBounds(new Rectangle(154, 84, 146, 23));
    jbtnAddNew.setBounds(new Rectangle(196, 290, 91, 31));
    jbtnAddNew.setText("New");
    jbtnAddNew.addActionListener(new PnlQry_jbtnAddNew_actionAdapter(this));
    this.add(BtnBack, null);
    this.add(jLabel1, null);
    this.add(txtKeyWord, null);
    this.add(BtnToList, null);
    this.add(jbtnAddNew, null);
  }

  void BtnBack_actionPerformed(ActionEvent ae) {
    try{
      Properties.getCenteralControler().goBack();
    }catch(Exception e){
       e.printStackTrace();
    }
  }

  void BtnToList_actionPerformed(ActionEvent e) {
    //set zero to record list.
    try{
    /*
      demostrating how to set properties for commands...
      1st ,directly set to properties of command objects
    */
     cmdObj.keywordFromQryGUI=txtKeyWord.getText();
     /*
      demostationg how to set properties for command object..
      2nd: set to system properties,for further need.
     */
     util.ApplicationProperites.setProperties(
      Constants.XNT_LIST_QRY_RESLUT_BGN_AT,new Integer(0)
     );
     Properties.getCenteralControler().doCommandExecute(
       Properties.getCenteralControler().SHOW_QURY_RESULT
     );
    }catch(Exception eCmd){
       eCmd.printStackTrace();
    }
  }

  void jbtnAddNew_actionPerformed(ActionEvent e) {
    try{
      Properties.getCenteralControler().doCommandExecute(
          Properties.getCenteralControler().GOTO_ADDMASTER
          );
    }catch(Exception eI){
       eI.printStackTrace();
    }
  }
}

class PnlQry_BtnBack_actionAdapter implements java.awt.event.ActionListener {
  PnlQry adaptee;

  PnlQry_BtnBack_actionAdapter(PnlQry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.BtnBack_actionPerformed(e);
  }
}

class PnlQry_BtnToList_actionAdapter implements java.awt.event.ActionListener {
  PnlQry adaptee;

  PnlQry_BtnToList_actionAdapter(PnlQry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.BtnToList_actionPerformed(e);
  }
}

class PnlQry_jbtnAddNew_actionAdapter implements java.awt.event.ActionListener {
  PnlQry adaptee;

  PnlQry_jbtnAddNew_actionAdapter(PnlQry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtnAddNew_actionPerformed(e);
  }
}