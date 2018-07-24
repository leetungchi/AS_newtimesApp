package newtimes.production.gui.prodmaintain;

import exgui.*;
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

public class PnlQryGUI4Prod extends javax.swing.JPanel {
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JButton btnEXIT = new JButton();
  JButton btnAddNew = new JButton();
  JButton btnQryList = new JButton();
  public PnlQryGUI4Prod() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Production Maintain");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 15, 800, 30));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("Query Interface,ref P.6");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(130, 118, 241, 98));
    btnEXIT.setBounds(new Rectangle(464, 483, 82, 29));
    btnEXIT.setFont(new java.awt.Font("Serif", 1, 12));
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new PnlQryGUI4Prod_btnEXIT_actionAdapter(this));
    btnAddNew.setBounds(new Rectangle(259, 479, 96, 29));
    btnAddNew.setFont(new java.awt.Font("Serif", 1, 12));
    btnAddNew.setText("Add New");
    btnAddNew.addActionListener(new PnlQryGUI4Prod_btnAddNew_actionAdapter(this));
    btnQryList.setBounds(new Rectangle(55, 479, 82, 29));
    btnQryList.setFont(new java.awt.Font("Serif", 1, 12));
    btnQryList.setText("Extract");
    btnQryList.addActionListener(new PnlQryGUI4Prod_btnQryList_actionAdapter(this));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(btnAddNew, null);
    this.add(btnQryList, null);
    this.add(btnEXIT, null);
  }

  void btnEXIT_actionPerformed(ActionEvent e) {
     try{
       processhandler.template.Properties.getCenteralControler().goBack();
     }catch(Exception ex){
     }
  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new newtimes.production.process.prodmaintain.TgrToEditProductionHead()
          );
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }

  void btnQryList_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new newtimes.production.process.prodmaintain.TgrToListQryProductions()
          );
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }

}

class PnlQryGUI4Prod_btnEXIT_actionAdapter implements java.awt.event.ActionListener {
  PnlQryGUI4Prod adaptee;

  PnlQryGUI4Prod_btnEXIT_actionAdapter(PnlQryGUI4Prod adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnEXIT_actionPerformed(e);
  }
}

class PnlQryGUI4Prod_btnAddNew_actionAdapter implements java.awt.event.ActionListener {
  PnlQryGUI4Prod adaptee;

  PnlQryGUI4Prod_btnAddNew_actionAdapter(PnlQryGUI4Prod adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnAddNew_actionPerformed(e);
  }
}

class PnlQryGUI4Prod_btnQryList_actionAdapter implements java.awt.event.ActionListener {
  PnlQryGUI4Prod adaptee;

  PnlQryGUI4Prod_btnQryList_actionAdapter(PnlQryGUI4Prod adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQryList_actionPerformed(e);
  }
}