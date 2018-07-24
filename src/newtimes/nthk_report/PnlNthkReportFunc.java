package newtimes.nthk_report;

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

public class PnlNthkReportFunc extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnShipmentVarianceReport = new JButton();
  JButton btnExit = new JButton();
  JButton btnShipmentReport = new JButton();
  JButton btnOutStandingReport = new JButton();
  JButton btnOutStdByArea = new JButton();
  JButton btnNthkOutStanding = new JButton();
  JButton btnNthkShippingAmtMonth = new JButton();
  JButton btnNthkShippingAmtMonthSubGrp = new JButton();
  JButton btnTopMngReport = new JButton();
  JButton btnMntRptEtdCreateDate = new JButton();
  JButton btnCancelSum = new JButton();
  JButton btnExportMonthDay = new JButton();
  JButton btnDiffReport = new JButton();
  JButton btnTopMngByOutStanding = new JButton();
  JButton btnHkExpList = new JButton();
  JButton btnOutStdAllArea = new JButton();
  JButton btnOutStandingExport = new JButton();
  JButton btnCancelClose = new JButton();
  JButton btnQcOrderSummary = new JButton();
  JButton btnStatusReport = new JButton();

  public PnlNthkReportFunc() {
    try {
      util.PublicVariable.OPERATTING_CENTER="NTHK";
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  protected void jbInit() throws Exception {
    //util.PublicVariable.OPERATTING_CENTER=(String)util.PublicVariable.USER_RECORD.get(4);
    blueBkgWhiteCharLabel1.setText("NTHK REPORTS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 36, 800, 32));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnShipmentVarianceReport.setBackground(Color.white);
    btnShipmentVarianceReport.setBounds(new Rectangle(24, 84, 392, 26));
    btnShipmentVarianceReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipmentVarianceReport.setForeground(Color.black);
    btnShipmentVarianceReport.setText("SHIP VARIANCE REPORT");
    btnShipmentVarianceReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipmentVarianceReport_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(459, 533, 108, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnShipmentReport.setText("SHIPMENT  REPORT");
    btnShipmentReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipmentReport_actionPerformed(e);
      }
    });
    btnShipmentReport.setForeground(Color.black);
    btnShipmentReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipmentReport.setBounds(new Rectangle(24, 131, 392, 26));
    btnShipmentReport.setBackground(Color.white);
    btnOutStandingReport.setText("OUTSTANDING REPORT");
    btnOutStandingReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOutStandingReport_actionPerformed(e);
      }
    });
    btnOutStandingReport.setForeground(Color.black);
    btnOutStandingReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOutStandingReport.setBounds(new Rectangle(24, 177, 392, 26));
    btnOutStandingReport.setBackground(Color.white);
    btnOutStdByArea.setBackground(Color.white);
    btnOutStdByArea.setBounds(new Rectangle(24, 224, 392, 26));
    btnOutStdByArea.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOutStdByArea.setForeground(Color.black);
    btnOutStdByArea.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOutStdByArea_actionPerformed(e);
      }
    });
    btnOutStdByArea.setText("NTHK OUTSTANDING BY AREA");
    btnNthkOutStanding.setText("NTHK OUTSTANDING");
    btnNthkOutStanding.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNthkOutStanding_actionPerformed(e);
      }
    });
    btnNthkOutStanding.setForeground(Color.black);
    btnNthkOutStanding.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNthkOutStanding.setBounds(new Rectangle(24, 270, 392, 26));
    btnNthkOutStanding.setBackground(Color.white);
    btnNthkShippingAmtMonth.setBackground(Color.white);
    btnNthkShippingAmtMonth.setBounds(new Rectangle(24, 317, 392, 26));
    btnNthkShippingAmtMonth.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNthkShippingAmtMonth.setForeground(Color.black);
    btnNthkShippingAmtMonth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNthkShippingAmtMonth_actionPerformed(e);
      }
    });
    btnNthkShippingAmtMonth.setText("NTHK SHIPPING AMOUNT");
    btnNthkShippingAmtMonthSubGrp.setText("NTHK SHIPPING AMOUNT  (Sub Group)");
    btnNthkShippingAmtMonthSubGrp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNthkShippingAmtMonthSubGrp_actionPerformed(e);
      }
    });
    btnNthkShippingAmtMonthSubGrp.setForeground(Color.black);
    btnNthkShippingAmtMonthSubGrp.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNthkShippingAmtMonthSubGrp.setBounds(new Rectangle(24, 363, 392, 26));
    btnNthkShippingAmtMonthSubGrp.setBackground(Color.white);
    btnTopMngReport.setBackground(Color.white);
    btnTopMngReport.setBounds(new Rectangle(24, 408, 392, 26));
    btnTopMngReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnTopMngReport.setForeground(Color.black);
    btnTopMngReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTopMngReport_actionPerformed(e);
      }
    });
    btnTopMngReport.setText("Top Management Report");
    btnMntRptEtdCreateDate.setBackground(Color.white);
    btnMntRptEtdCreateDate.setBounds(new Rectangle(24, 450, 392, 26));
    btnMntRptEtdCreateDate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnMntRptEtdCreateDate.setText("Shipping Report Create Date & Report ETD Maintain");
    btnMntRptEtdCreateDate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnMntRptEtdCreateDate_actionPerformed(e);
      }
    });
    btnCancelSum.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancelSum_actionPerformed(e);
      }
    });
    btnCancelSum.setText("Sum of Cancelled  PO");
    btnCancelSum.setForeground(Color.black);
    btnCancelSum.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancelSum.setBounds(new Rectangle(438, 84, 314, 26));
    btnCancelSum.setBackground(Color.white);
    btnExportMonthDay.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExportMonthDay_actionPerformed(e);
      }
    });
    btnExportMonthDay.setText("EXPORT DATA");
    btnExportMonthDay.setForeground(Color.black);
    btnExportMonthDay.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExportMonthDay.setBounds(new Rectangle(438, 131, 314, 26));
    btnExportMonthDay.setBackground(Color.white);
    btnDiffReport.setBackground(Color.white);
    btnDiffReport.setBounds(new Rectangle(438, 177, 314, 26));
    btnDiffReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDiffReport.setForeground(Color.black);
    btnDiffReport.setText("DIFFERENCE REPORT");
    btnDiffReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDiffReport_actionPerformed(e);
      }
    });
    btnTopMngByOutStanding.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTopMngByOutStanding_actionPerformed(e);
      }
    });
    btnTopMngByOutStanding.setText("TOP MANAGMENT BY OUTSTANDING");
    btnTopMngByOutStanding.setForeground(Color.black);
    btnTopMngByOutStanding.setFont(new java.awt.Font("Dialog", 1, 11));
    btnTopMngByOutStanding.setBounds(new Rectangle(438, 224, 314, 26));
    btnTopMngByOutStanding.setBackground(Color.white);
    btnHkExpList.setBackground(Color.white);
    btnHkExpList.setBounds(new Rectangle(438, 270, 314, 26));
    btnHkExpList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnHkExpList.setForeground(Color.black);
    btnHkExpList.setText("LIST ALL EXPORT DATA");
    btnHkExpList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnHkExpList_actionPerformed(e);
      }
    });
    btnOutStdAllArea.setText("NTHK OUTSTANDING ALL AREA");
    btnOutStdAllArea.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOutStdAllArea_actionPerformed(e);
      }
    });
    btnOutStdAllArea.setForeground(Color.black);
    btnOutStdAllArea.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOutStdAllArea.setBounds(new Rectangle(438, 317, 314, 26));
    btnOutStdAllArea.setBackground(Color.white);
    btnOutStandingExport.setBackground(Color.white);
    btnOutStandingExport.setBounds(new Rectangle(438, 363, 314, 26));
    btnOutStandingExport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOutStandingExport.setForeground(Color.black);
    btnOutStandingExport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOutStandingExport_actionPerformed(e);
      }
    });
    btnOutStandingExport.setText("OUTSTANDING EXPORT");
    btnCancelClose.setBackground(Color.white);
    btnCancelClose.setBounds(new Rectangle(442, 406, 314, 26));
    btnCancelClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancelClose.setText("Cancel/Close S/C#");
    btnCancelClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancelClose_actionPerformed(e);
      }
    });
    btnQcOrderSummary.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQcOrderSummary_actionPerformed(e);
      }
    });
    btnQcOrderSummary.setText("QC ORDER SUMMARY");
    btnQcOrderSummary.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQcOrderSummary.setBounds(new Rectangle(442, 450, 314, 26));
    btnQcOrderSummary.setBackground(Color.white);
    btnStatusReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStatusReport_actionPerformed(e);
      }
    });
    btnStatusReport.setText("Status Report");
    btnStatusReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStatusReport.setBounds(new Rectangle(24, 487, 392, 26));
    btnStatusReport.setBackground(Color.white);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnOutStandingReport, null);
    this.add(btnShipmentVarianceReport, null);
    this.add(btnShipmentReport, null);
    this.add(btnOutStdByArea, null);
    this.add(btnNthkOutStanding, null);
    this.add(btnNthkShippingAmtMonth, null);
    this.add(btnNthkShippingAmtMonthSubGrp, null);
    this.add(btnTopMngReport, null);
    this.add(btnMntRptEtdCreateDate, null);
    this.add(btnCancelSum, null);
    this.add(btnExportMonthDay, null);
    this.add(btnDiffReport, null);
    this.add(btnTopMngByOutStanding, null);
    this.add(btnHkExpList, null);
    this.add(btnOutStdAllArea, null);
    this.add(btnOutStandingExport, null);
    this.add(btnCancelClose, null);
    this.add(btnQcOrderSummary, null);
    this.add(btnStatusReport, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    util.PublicVariable.OPERATTING_CENTER=(String)util.PublicVariable.USER_RECORD.get(4);
    JPanel panel = new newtimes.MainFunction((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();

  }

  void btnShipmentVarianceReport_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrShipVrnRpt());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }

  void btnShipmentReport_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrShipReport());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
  }

  void btnOutStandingReport_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrOutStandingRpt());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnOutStdByArea_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_NTHK_OUTSTANDING_BY_AREA;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnNthkOutStanding_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_NTHK_OUTSTANDING ;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnNthkShippingAmtMonth_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_NTHK_SHIPPING_AMOUNT_BY_MONTH ;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnNthkShippingAmtMonthSubGrp_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_NTHK_SHIPPING_AMOUNT_BY_MONTH_SUBGRP;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnTopMngReport_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_MANAGEMENT_REPORT;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }

  void btnMntRptEtdCreateDate_actionPerformed(ActionEvent e) {
     TgrGenQryGUI4RptEtdMtn.pnlQry=null;
     try {
       newtimes.nthk_report.PnlQry4CreateRptDate.IS_NTHK_CENTER=true;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new newtimes.nthk_report.TgrGenQryGUI4RptEtdMtn());
     } catch (Exception eP) {
       eP.printStackTrace();
     }

  }
  void btnCancelSum_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_DELTED_PO_LIST;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnExportMonthDay_actionPerformed(ActionEvent e) {
    DlgMonthlyExport dlg=new DlgMonthlyExport(util.PublicVariable.APP_FRAME,"Export PO/INVOICE DATA",true,"NTHK");
    dlg.setSize(400,330);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }
  void btnDiffReport_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_DEIFFERENCE_LIST;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnTopMngByOutStanding_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_TOP_MANANGEMENT_OUTSTANDING;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnHkExpList_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_LIST_NTHK_EXPORTED_DATA;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnOutStdAllArea_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_NTHK_OUTSTANDING_ALL_AREA;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
  }
  void btnOutStandingExport_actionPerformed(ActionEvent e) {
    DlgOutstandingExport dlg=new
        DlgOutstandingExport(util.PublicVariable.APP_FRAME,
                             "OUTSTANDING EXPORT FUNCTION",true,"NTHK");
       dlg.setSize(600,170);
       exgui.UIHelper.setToScreenCenter(dlg);
       dlg.show();

  }

  void btnCancelClose_actionPerformed(ActionEvent e) {
    DlgCancelCloseSc  dlg=new
        DlgCancelCloseSc(util.PublicVariable.APP_FRAME,
                             "Cancel / Close S/C#",true);
       dlg.setSize(610,385);
       exgui.UIHelper.setToScreenCenter(dlg);
       dlg.show();

  }
  void btnQcOrderSummary_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_NTHK_QC_ORDER_SUMMARY;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
  }
  void btnStatusReport_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_NTHK_STATUS_REPORT;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }


}
