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

public class Pnl_Summary_Fun_List extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnOutStandingReport = new JButton();
  JButton btnExit = new JButton();
  JButton btnCrossSummaryQtyAmtRpt = new JButton();
  JButton btnPendingAndShipping = new JButton();
  JButton btn3YearSalesReport = new JButton();
  JButton btnProfitAmtRpt = new JButton();
  JButton btnSalestAmtRpt = new JButton();
  JButton btn2YearShipmentChart = new JButton();
  JButton btn2ShipmentQty = new JButton();
  JButton btnShipAmtAccAnlRpt = new JButton();
  JButton btnNbAmtCommission = new JButton();

  public Pnl_Summary_Fun_List() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Summary Report");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 3, 800, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setForeground(new Color(202, 202, 224));
    this.setLayout(null);
    btnOutStandingReport.setBackground(Color.white);
    btnOutStandingReport.setBounds(new Rectangle(192, 37, 415, 28));
    btnOutStandingReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOutStandingReport.setText("OUTSTANDING AMOUNT REPORT BY BUYER");
    btnOutStandingReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOutStandingReport_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(359, 512, 82, 29));
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
    btnCrossSummaryQtyAmtRpt.setBounds(new Rectangle(192, 85, 415, 28));
    btnCrossSummaryQtyAmtRpt.setBackground(Color.white);
    btnPendingAndShipping.setBackground(Color.white);
    btnPendingAndShipping.setBounds(new Rectangle(192, 133, 415, 28));
    btnPendingAndShipping.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPendingAndShipping.setText("PENDDING & SHIPPING");
    btnPendingAndShipping.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPendingAndShipping_actionPerformed(e);
      }
    });
    btn3YearSalesReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn3YearSalesReport_actionPerformed(e);
      }
    });
    btn3YearSalesReport.setText("3 YEAR SALES REPORT");
    btn3YearSalesReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btn3YearSalesReport.setBounds(new Rectangle(192, 229, 415, 28));
    btn3YearSalesReport.setBackground(Color.white);
    btnProfitAmtRpt.setBackground(Color.white);
    btnProfitAmtRpt.setBounds(new Rectangle(192, 326, 415, 28));
    btnProfitAmtRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProfitAmtRpt.setText("PROFIT AMOUNT REPORT");
    btnProfitAmtRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProfitAmtRpt_actionPerformed(e);
      }
    });
    btnSalestAmtRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSalestAmtRpt_actionPerformed(e);
      }
    });
    btnSalestAmtRpt.setText("SALES AMOUNT REPORT");
    btnSalestAmtRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSalestAmtRpt.setBounds(new Rectangle(192, 374, 415, 28));
    btnSalestAmtRpt.setBackground(Color.white);
    btn2YearShipmentChart.setBackground(Color.white);
    btn2YearShipmentChart.setBounds(new Rectangle(192, 422, 415, 28));
    btn2YearShipmentChart.setFont(new java.awt.Font("Dialog", 1, 11));
    btn2YearShipmentChart.setText("2 YEAR SHIPMENT CHART");
    btn2YearShipmentChart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn2YearShipmentChart_actionPerformed(e);
      }
    });
    btn2ShipmentQty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn2ShipmentQty_actionPerformed(e);
      }
    });
    btn2ShipmentQty.setText("ORDER QTY BY BUYER/MAKER/MONTH");
    btn2ShipmentQty.setFont(new java.awt.Font("Dialog", 1, 11));
    btn2ShipmentQty.setBounds(new Rectangle(192, 470, 415, 28));
    btn2ShipmentQty.setBackground(Color.white);
    btnShipAmtAccAnlRpt.setBackground(Color.white);
    btnShipAmtAccAnlRpt.setBounds(new Rectangle(192, 278, 415, 28));
    btnShipAmtAccAnlRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipAmtAccAnlRpt.setText("SHIP AMOUNT 會計年度統計");
    btnShipAmtAccAnlRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipAmtAccAnlRpt_actionPerformed(e);
      }
    });
    btnNbAmtCommission.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNbAmtCommission_actionPerformed(e);
      }
    });
    btnNbAmtCommission.setText("NB AMOUNT & COMMISSION");
    btnNbAmtCommission.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNbAmtCommission.setBounds(new Rectangle(192, 181, 415, 28));
    btnNbAmtCommission.setBackground(Color.white);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnCrossSummaryQtyAmtRpt, null);
    this.add(btnPendingAndShipping, null);
    this.add(btnProfitAmtRpt, null);
    this.add(btnSalestAmtRpt, null);
    this.add(btn2YearShipmentChart, null);
    this.add(btnOutStandingReport, null);
    this.add(btnExit, null);
    this.add(btn2ShipmentQty, null);
    this.add(btnShipAmtAccAnlRpt, null);
    this.add(btn3YearSalesReport, null);
    this.add(btnNbAmtCommission, null);
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

  void btnOutStandingReport_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenOutStandingRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

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
  void btn3YearSalesReport_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new Tgr3YearSalesReport());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnProfitAmtRpt_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrProfitSalesAmtRpt(true));
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnSalestAmtRpt_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new  TgrProfitSalesAmtRpt(false));
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btn2YearShipmentChart_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new  Tgr2YearShipmentChart());
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
  void btnShipAmtAccAnlRpt_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrShipAmtAccAnlRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnNbAmtCommission_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new  TgrNbAmtCommRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
