package newtimes.general_voucher.rush;

import java.awt.*;
import exgui.*;
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

public class PnlRushFuncList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAdd2Rush = new JButton();
  JButton btnChkBlns = new JButton();
  JButton btnRxMtn = new JButton();
  JButton btnRxMapping = new JButton();
  JButton btnRxWorkSheet = new JButton();
  JButton btnRxBlns = new JButton();
  JButton btnExit = new JButton();
  public PnlRushFuncList() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("RUSH Maintain");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 22, 803, 31));
    this.setLayout(null);
    btnAdd2Rush.setBackground(Color.white);
    btnAdd2Rush.setBounds(new Rectangle(207, 87, 385, 27));
    btnAdd2Rush.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd2Rush.setText("ADD TO RUSH");
    btnAdd2Rush.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd2Rush_actionPerformed(e);
      }
    });
    btnChkBlns.setText("CHECK BALANCE");
    btnChkBlns.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnChkBlns_actionPerformed(e);
      }
    });
    btnChkBlns.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChkBlns.setBounds(new Rectangle(207, 266, 385, 27));
    btnChkBlns.setBackground(Color.white);
    btnRxMtn.setBackground(Color.white);
    btnRxMtn.setBounds(new Rectangle(207, 132, 385, 27));
    btnRxMtn.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRxMtn.setText("RUSH MAINTAIN");
    btnRxMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRxMtn_actionPerformed(e);
      }
    });
    btnRxMapping.setText("勾沖作業");
    btnRxMapping.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRxMapping_actionPerformed(e);
      }
    });
    btnRxMapping.setFont(new java.awt.Font("Dialog", 0, 14));
    btnRxMapping.setBounds(new Rectangle(207, 221, 385, 27));
    btnRxMapping.setBackground(Color.white);
    btnRxWorkSheet.setBackground(Color.white);
    btnRxWorkSheet.setBounds(new Rectangle(207, 176, 385, 27));
    btnRxWorkSheet.setFont(new java.awt.Font("Dialog", 0, 14));
    btnRxWorkSheet.setText("勾沖工作表");
    btnRxWorkSheet.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRxWorkSheet_actionPerformed(e);
      }
    });
    btnRxBlns.setBackground(Color.white);
    btnRxBlns.setBounds(new Rectangle(207, 310, 385, 27));
    btnRxBlns.setFont(new java.awt.Font("Dialog", 0, 14));
    btnRxBlns.setText("資產負債沖帳餘額明細表");
    btnRxBlns.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRxBlns_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(347, 523, 106, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnAdd2Rush, null);
    this.add(btnRxMtn, null);
    this.add(btnRxWorkSheet, null);
    this.add(btnRxMapping, null);
    this.add(btnChkBlns, null);
    this.add(btnRxBlns, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnAdd2Rush_actionPerformed(ActionEvent e) {
    try{
      TgrAdd2Rush tgr = new TgrAdd2Rush();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnRxMtn_actionPerformed(ActionEvent e) {
    try{
      Constants.pnlQry=null;
      TgrRxMtnQry tgr = new TgrRxMtnQry();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }


  }

  void btnRxMapping_actionPerformed(ActionEvent e) {
    try{
      TgrRxOperation tgr = new TgrRxOperation();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnRxWorkSheet_actionPerformed(ActionEvent e) {
    try{
      TgrRptB4RxOperation tgr = new  TgrRptB4RxOperation();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnRxBlns_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.TgrRptAccDbCrOffset  tgr =
          new newtimes.general_voucher.TgrRptAccDbCrOffset();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnChkBlns_actionPerformed(ActionEvent e) {
    try{
      TgrRxChkBalance tgr = new  TgrRxChkBalance();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }


}
