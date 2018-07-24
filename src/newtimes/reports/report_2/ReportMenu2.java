package newtimes.reports.report_2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import newtimes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ReportMenu2 extends JPanel {
  private Frame1 frame = null;
  private JLabel labelTitle = new JLabel();
  private JTextField textAreaStatus = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JButton butn_PPS = new JButton();
  private JButton butn_PendingLC = new JButton();
  private JButton butn_PendingHTag = new JButton();
  private JButton butn_PlanQTY = new JButton();
  private JButton butn_UnshippedDetails = new JButton();
  private JButton butn_SupplierList = new JButton();
  private JButton butn_OutstandingQTY = new JButton();
  private JButton butn_ShipmentOfBuyer = new JButton();
  private JButton butn_SalesAndProfit = new JButton();
  JButton butnExit = new JButton();
  JButton butnLogout = new JButton();

  public ReportMenu2(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    labelTitle.setText("title");
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Report II Maintain  ============      ");
    jLabel1.setBounds(new Rectangle(117, 93, 566, 24));
    butn_PPS.setBackground(Color.white);
    butn_PPS.setBounds(new Rectangle(211, 140, 378, 23));
    butn_PPS.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_PPS.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_PPS.setHorizontalAlignment(SwingConstants.LEFT);
    butn_PPS.setText(" 1.  PPS Send Delay");
    butn_PPS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_PPS_actionPerformed(e);
      }
    });
    butn_PendingLC.setBackground(Color.white);
    butn_PendingLC.setBounds(new Rectangle(211, 170, 378, 23));
    butn_PendingLC.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_PendingLC.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_PendingLC.setHorizontalAlignment(SwingConstants.LEFT);
    butn_PendingLC.setText(" 2.  Pending L/C 45-30-20 Days List");
    butn_PendingLC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_PendingLC_actionPerformed(e);
      }
    });
    butn_PendingHTag.setBackground(Color.white);
    butn_PendingHTag.setBounds(new Rectangle(211, 200, 378, 23));
    butn_PendingHTag.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_PendingHTag.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_PendingHTag.setHorizontalAlignment(SwingConstants.LEFT);
    butn_PendingHTag.setText(" 3.  Pending H\' Tag 45 Days List");
    butn_PendingHTag.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_PendingHTag_actionPerformed(e);
      }
    });
    butn_PlanQTY.setBackground(Color.white);
    butn_PlanQTY.setBounds(new Rectangle(211, 230, 378, 23));
    butn_PlanQTY.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_PlanQTY.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_PlanQTY.setHorizontalAlignment(SwingConstants.LEFT);
    butn_PlanQTY.setText(" 4.  Plan QTY Detail List (Not Yet Order)");
    butn_PlanQTY.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_PlanQTY_actionPerformed(e);
      }
    });
    butn_UnshippedDetails.setBackground(Color.white);
    butn_UnshippedDetails.setBounds(new Rectangle(211, 260, 378, 23));
    butn_UnshippedDetails.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_UnshippedDetails.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_UnshippedDetails.setHorizontalAlignment(SwingConstants.LEFT);
    butn_UnshippedDetails.setText(" 5.  Unshipped Details by Quota");
    butn_UnshippedDetails.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_UnshippedDetails_actionPerformed(e);
      }
    });
    butn_SupplierList.setBackground(Color.white);
    butn_SupplierList.setBounds(new Rectangle(211, 290, 378, 23));
    butn_SupplierList.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_SupplierList.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_SupplierList.setHorizontalAlignment(SwingConstants.LEFT);
    butn_SupplierList.setText(" 6.  Supplier List");
    butn_SupplierList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_SupplierList_actionPerformed(e);
      }
    });
    butn_OutstandingQTY.setBackground(Color.white);
    butn_OutstandingQTY.setBounds(new Rectangle(211, 320, 378, 23));
    butn_OutstandingQTY.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_OutstandingQTY.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_OutstandingQTY.setHorizontalAlignment(SwingConstants.LEFT);
    butn_OutstandingQTY.setText(" 7.  Outstanding QTY Report by FTY / DEL  ");
    butn_OutstandingQTY.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_OutstandingQTY_actionPerformed(e);
      }
    });
    butn_ShipmentOfBuyer.setBackground(Color.white);
    butn_ShipmentOfBuyer.setBounds(new Rectangle(211, 350, 378, 23));
    butn_ShipmentOfBuyer.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_ShipmentOfBuyer.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_ShipmentOfBuyer.setHorizontalAlignment(SwingConstants.LEFT);
    butn_ShipmentOfBuyer.setText(" 8.  Shipment of Buyer by Country / FTY");
    butn_ShipmentOfBuyer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_ShipmentOfBuyer_actionPerformed(e);
      }
    });
    butn_SalesAndProfit.setBackground(Color.white);
    butn_SalesAndProfit.setBounds(new Rectangle(211, 380, 378, 23));
    butn_SalesAndProfit.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_SalesAndProfit.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_SalesAndProfit.setHorizontalAlignment(SwingConstants.LEFT);
    butn_SalesAndProfit.setText(" 9.  Sales & Profit Report");
    butn_SalesAndProfit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_SalesAndProfit_actionPerformed(e);
      }
    });
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,600);
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(429, 490, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnLogout.setBackground(Color.lightGray);
    butnLogout.setBounds(new Rectangle(287, 490, 80, 25));
    butnLogout.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogout.setForeground(Color.darkGray);
    butnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogout_actionPerformed(e);
      }
    });
    butnLogout.setText("Logout");
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butn_PPS, null);
    this.add(butn_PendingLC, null);
    this.add(butn_PendingHTag, null);
    this.add(butn_PlanQTY, null);
    this.add(butn_UnshippedDetails, null);
    this.add(butn_SupplierList, null);
    this.add(butn_OutstandingQTY, null);
    this.add(butn_ShipmentOfBuyer, null);
    this.add(butn_SalesAndProfit, null);
    this.add(labelTitle, null);
    this.add(butnLogout, null);
    this.add(butnExit, null);
  }

  void butn_OutstandingQTY_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.outstandingqty.OutstandingQTY(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butnExit_actionPerformed(ActionEvent e) {
    frame.showPanel(new MainFunction(frame));
  }
  void butnLogout_actionPerformed(ActionEvent e) {
    frame.showPanel(new Login(frame));
  }

  void butn_SalesAndProfit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.salesprofit.SalesProfit(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_SupplierList_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.supplierlist.SupplierList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_PPS_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.ppssenddelay.PpsSendDelay(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_ShipmentOfBuyer_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.shipmentofbuyer.ShipmentOfBuyer(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_PendingLC_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.pendinglc.PendingLC(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_PendingHTag_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.pendinghtag.PendingHTag(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_UnshippedDetails_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.unshipped.UnShipped(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_PlanQTY_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.planqty.PlanQty(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
