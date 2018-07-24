package newtimes.general_voucher.stock;

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

public class PnlStockFunList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAdd2Stock = new JButton();
  JButton btnExit = new JButton();
  JButton btnpnlStockRushOperation = new JButton();
  JButton btnRptStockRush = new JButton();
  JButton btnRptAccStockOffset = new JButton();
  JButton btnCreateNewStockFile = new JButton();
  JButton btnRptAccPur = new JButton();
  JButton btnRptAccInventory = new JButton();

  public PnlStockFunList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("存貨系統");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 17, 801, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setForeground(Color.black);
    this.setLayout(null);
    btnAdd2Stock.setBounds(new Rectangle(232, 63, 336, 32));
    btnAdd2Stock.setFont(new java.awt.Font("Dialog", 1, 14));
    btnAdd2Stock.setText("Add To Stock");
    btnAdd2Stock.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd2Stock_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(331, 509, 108, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnpnlStockRushOperation.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnpnlStockRushOperation_actionPerformed(e);
      }
    });
    btnpnlStockRushOperation.setText("RUSH AND MAINTAIN");
    btnpnlStockRushOperation.setFont(new java.awt.Font("Dialog", 1, 14));
    btnpnlStockRushOperation.setBounds(new Rectangle(232, 168, 336, 32));
    btnRptStockRush.setBounds(new Rectangle(232, 116, 336, 32));
    btnRptStockRush.setFont(new java.awt.Font("Dialog", 1, 14));
    btnRptStockRush.setText("存貨勾沖表");
    btnRptStockRush.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptStockRush_actionPerformed(e);
      }
    });
    btnRptAccStockOffset.setBounds(new Rectangle(232, 221, 336, 32));
    btnRptAccStockOffset.setFont(new java.awt.Font("Dialog", 1, 14));
    btnRptAccStockOffset.setText("存貨分類帳");
    btnRptAccStockOffset.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccStockOffset_actionPerformed(e);
      }
    });
    btnCreateNewStockFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCreateNewStockFile_actionPerformed(e);
      }
    });
    btnCreateNewStockFile.setText("CREATE NEW STOCK FILE");
    btnCreateNewStockFile.setFont(new java.awt.Font("Dialog", 1, 14));
    btnCreateNewStockFile.setBounds(new Rectangle(232, 273, 336, 32));
    btnRptAccPur.setBounds(new Rectangle(232, 326, 336, 32));
    btnRptAccPur.setFont(new java.awt.Font("Dialog", 1, 14));
    btnRptAccPur.setText("進貨帳 / 銷貨帳");
    btnRptAccPur.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccPur_actionPerformed(e);
      }
    });
    btnRptAccInventory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccInventory_actionPerformed(e);
      }
    });
    btnRptAccInventory.setText("期末存貨明細表");
    btnRptAccInventory.setFont(new java.awt.Font("Dialog", 1, 14));
    btnRptAccInventory.setBounds(new Rectangle(232, 378, 336, 32));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnAdd2Stock, null);
    this.add(btnRptAccStockOffset, null);
    this.add(btnCreateNewStockFile, null);
    this.add(btnRptAccPur, null);
    this.add(btnRptAccInventory, null);
    this.add(btnpnlStockRushOperation, null);
    this.add(btnRptStockRush, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnAdd2Stock_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrAdd2Stock());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnpnlStockRushOperation_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrStockRushOperation());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptStockRush_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptStockRush());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnRptAccStockOffset_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptAccStockOffset());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnCreateNewStockFile_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrCreateNewStockFile());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptAccPur_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptAccPur());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptAccInventory_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptAccInventory());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
