package newtimes.production.report;

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

public class Pnl_Summary_Fun_List_Nthk extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnCrossSummaryQtyAmtRpt = new JButton();
  JButton btnPendingAndShipping = new JButton();
  JButton btn2ShipmentQty = new JButton();

  public Pnl_Summary_Fun_List_Nthk() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Summary Report");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 22, 800, 38));
    this.setBackground(new Color(202, 202, 224));
    this.setForeground(new Color(202, 202, 224));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(359, 496, 82, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnCrossSummaryQtyAmtRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCrossSummaryQtyAmtRpt_actionPerformed(e);
      }
    });
    btnCrossSummaryQtyAmtRpt.setText("SUMMARY QUANTITY AMOUNT REPORT");
    btnCrossSummaryQtyAmtRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCrossSummaryQtyAmtRpt.setBounds(new Rectangle(193, 67, 415, 28));
    btnCrossSummaryQtyAmtRpt.setBackground(Color.white);
    btnPendingAndShipping.setBackground(Color.white);
    btnPendingAndShipping.setBounds(new Rectangle(194, 113, 415, 28));
    btnPendingAndShipping.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPendingAndShipping.setText("PENDDING & SHIPPING");
    btnPendingAndShipping.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPendingAndShipping_actionPerformed(e);
      }
    });
    btn2ShipmentQty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn2ShipmentQty_actionPerformed(e);
      }
    });
    btn2ShipmentQty.setText("ORDER QTY BY BUYER/MAKER/MONTH");
    btn2ShipmentQty.setFont(new java.awt.Font("Dialog", 1, 11));
    btn2ShipmentQty.setBounds(new Rectangle(193, 160, 415, 28));
    btn2ShipmentQty.setBackground(Color.white);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnCrossSummaryQtyAmtRpt, null);
    this.add(btnPendingAndShipping, null);
    this.add(btn2ShipmentQty, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    JPanel panel = new newtimes.MainFunction((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();
   /*
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }
    */
  }

  void btnCrossSummaryQtyAmtRpt_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenCorssSummaryQtyAmtRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnPendingAndShipping_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrPenddingAndShippingReport());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btn2ShipmentQty_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new  TgrShipmentQtyRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
