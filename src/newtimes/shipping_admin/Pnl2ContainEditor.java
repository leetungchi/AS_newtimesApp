package newtimes.shipping_admin;

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

public class Pnl2ContainEditor extends JPanel {
  public JScrollPane jScrollPane1 = new JScrollPane();
  JButton btnAdd = new JButton();
  JButton btnDelete = new JButton();
  JButton btnCopy = new JButton();
  JButton btnPast = new JButton();
  public processhandler.template.PnlTableEditor  myFuncPnl;
  JButton btnDoUpdate = new JButton();
  public Pnl2ContainEditor() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setLayout(null);
    jScrollPane1.setBounds(new Rectangle(18, 30, 748, 457));
    btnAdd.setBounds(new Rectangle(21, 494, 141, 35));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setBounds(new Rectangle(177, 494, 141, 35));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy.setText("COPY");
    btnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy_actionPerformed(e);
      }
    });
    btnCopy.setBounds(new Rectangle(479, 494, 141, 35));
    btnCopy.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPast.setText("PASTE");
    btnPast.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPast_actionPerformed(e);
      }
    });
    btnPast.setBounds(new Rectangle(632, 494, 141, 35));
    btnPast.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDoUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDoUpdate.setBounds(new Rectangle(331, 494, 141, 35));
    btnDoUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDoUpdate_actionPerformed(e);
      }
    });
    btnDoUpdate.setText("UPDATE");
    this.add(jScrollPane1, null);
    this.add(btnAdd, null);
    this.add(btnDelete, null);
    this.add(btnCopy, null);
    this.add(btnPast, null);
    this.add(btnDoUpdate, null);
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
      myFuncPnl.doAddNew();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    try{
      myFuncPnl.doDelete();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnCopy_actionPerformed(ActionEvent e) {
    myFuncPnl.doCopy();
  }

  void btnPast_actionPerformed(ActionEvent e) {
    myFuncPnl.doPaste();
  }
  void btnDoUpdate_actionPerformed(ActionEvent e) {
    try{
      myFuncPnl.doUpdate();
    }catch(Exception exp){
        exp.printStackTrace();
    }

  }
}
