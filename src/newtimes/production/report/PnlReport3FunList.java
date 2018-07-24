package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.nthk_report.*;

public class PnlReport3FunList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnGoCulpReport = new JButton();
  JButton exit4Report3 = new JButton();
  JButton btnRptQcOffshore = new JButton();
  JButton btnRptChkcoo = new JButton();
  JButton btnProdStyle = new JButton();
  JButton btnProdColor = new JButton();
  JButton btnPS = new JButton();
  JButton btnShipList = new JButton();
  JButton btnConfirmationList = new JButton();
  JButton btnShippingDetlColor = new JButton();
  JButton btnPsListByFtyRpt = new JButton();
  JButton btnNthkDtlByScNo = new JButton();
  JButton btnHkOutStanding = new JButton();
  JButton btnShipAmtSrnSc = new JButton();
  JButton btnHkOutStandingSum = new JButton();
  JButton btnOrderSummery = new JButton();
  JButton btnOutStandingByMonthBuyer = new JButton();
  JButton btnBuyerSummaryByCreateDate = new JButton();
  JButton btnDelScheduelRpt = new JButton();
  JButton btnListMaker = new JButton();

  public PnlReport3FunList() {
    try {
 //     System.out.println(newtimes.Per.user_Dep);
      jbInit();
      setOption();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("REPORT  FUNCTIONS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(3, 18, 796, 31));
    this.setLayout(null);
    btnGoCulpReport.setBounds(new Rectangle(442, 169, 327, 27));
    btnGoCulpReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGoCulpReport.setText("FABRIC CHART");
    btnGoCulpReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGoCulpReport_actionPerformed(e);
      }
    });
    btnGoCulpReport.setVisible(false);
    exit4Report3.setBounds(new Rectangle(364, 531, 71, 25));
    exit4Report3.setFont(new java.awt.Font("Dialog", 1, 11));
    exit4Report3.setActionCommand("jButton1");
    exit4Report3.setText("EXIT");
    exit4Report3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        exit4Report3_actionPerformed(e);
      }
    });
    btnRptQcOffshore.setBounds(new Rectangle(57, 117, 327, 27));
    btnRptQcOffshore.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptQcOffshore.setText("75 DAYS WORK-SHEET BY FTY/DEP/BUYER");
    btnRptQcOffshore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptQcOffshore_actionPerformed(e);
      }
    });
    btnRptChkcoo.setBounds(new Rectangle(57, 169, 327, 27));
    btnRptChkcoo.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptChkcoo.setText("Check Order Coo");
    btnRptChkcoo.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      btnRptChkcoo_actionPerformed(e);
    }
  });


    btnProdStyle.setBounds(new Rectangle(57, 274, 327, 27));
    btnProdStyle.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProdStyle.setText("ORDER / UNSHIPPED DETAIL BY STYLE");
    btnProdStyle.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProdStyle_actionPerformed(e);
      }
    });
    btnProdColor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProdColor_actionPerformed(e);
      }
    });
    btnProdColor.setText("ORDER / UNSHIPPED DETAIL BY COLOR");
    btnProdColor.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProdColor.setBounds(new Rectangle(57, 222, 327, 27));
    btnPS.setBounds(new Rectangle(57, 64, 327, 27));
    btnPS.setFont(new java.awt.Font("Dialog", 1, 12));
    btnPS.setBorder(BorderFactory.createRaisedBevelBorder());
    btnPS.setHorizontalAlignment(SwingConstants.CENTER);
    btnPS.setText("Production Status Report");
    btnPS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPS_actionPerformed(e);
      }
    });
    btnShipList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipList_actionPerformed(e);
      }
    });
    btnShipList.setText("SHIPPING DETAIL BY STYLE");
    btnShipList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipList.setBounds(new Rectangle(442, 64, 327, 27));
    btnConfirmationList.setBounds(new Rectangle(442, 222, 327, 28));
    btnConfirmationList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnConfirmationList.setText("LIST OF CONFIRMATION (BY DEL-DATE)");
    btnConfirmationList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnConfirmationList_actionPerformed(e);
      }
    });
    btnShippingDetlColor.setBounds(new Rectangle(442, 117, 327, 27));
    btnShippingDetlColor.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShippingDetlColor.setText("SHIPPING DETAIL BY COLOR");
    btnShippingDetlColor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShippingDetlColor_actionPerformed(e);
      }
    });
    btnPsListByFtyRpt.setBounds(new Rectangle(57, 169, 327, 27));
    btnPsListByFtyRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPsListByFtyRpt.setMargin(new Insets(2, 14, 2, 14));
    btnPsListByFtyRpt.setText("P.S. LIST BY FACTORY");
    btnPsListByFtyRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPsListByFtyRpt_actionPerformed(e);
      }
    });
    btnPsListByFtyRpt.setVisible(false);
    btnNthkDtlByScNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNthkDtlByScNo_actionPerformed(e);
      }
    });
    btnNthkDtlByScNo.setText("DETAIL BY S/C NUMBER");
    btnNthkDtlByScNo.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNthkDtlByScNo.setBounds(new Rectangle(442, 274, 327, 28));
    btnHkOutStanding.setBounds(new Rectangle(57, 327, 327, 27));
    btnHkOutStanding.setFont(new java.awt.Font("Dialog", 1, 11));
    btnHkOutStanding.setText("HK OUTSTANDING DETAIL REPORT");
    btnHkOutStanding.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnHkOutStanding_actionPerformed(e);
      }
    });
    btnShipAmtSrnSc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipAmtSrnSc_actionPerformed(e);
      }
    });
    btnShipAmtSrnSc.setText("SHIP DETAIL BY SRN");
    btnShipAmtSrnSc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipAmtSrnSc.setBounds(new Rectangle(442, 327, 327, 27));
    btnHkOutStandingSum.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnHkOutStandingSum_actionPerformed(e);
      }
    });
    btnHkOutStandingSum.setText("HK OUTSTANDING SUMMARY REPORT");
    btnHkOutStandingSum.setFont(new java.awt.Font("Dialog", 1, 11));
    btnHkOutStandingSum.setBounds(new Rectangle(57, 375, 327, 27));
    btnOrderSummery.setBounds(new Rectangle(442, 375, 327, 27));
    btnOrderSummery.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOrderSummery.setText("ORDER DETAIL BY PO");
    btnOrderSummery.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOrderSummery_actionPerformed(e);
      }
    });
    btnOutStandingByMonthBuyer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOutStandingByMonthBuyer_actionPerformed(e);
      }
    });
    btnOutStandingByMonthBuyer.setText("OUTSTANDING BY MONTH BUYER");
    btnOutStandingByMonthBuyer.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOutStandingByMonthBuyer.setBounds(new Rectangle(57, 424, 327, 27));
    btnBuyerSummaryByCreateDate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBuyerSummaryByCreateDate_actionPerformed(e);
      }
    });
    btnBuyerSummaryByCreateDate.setText("BUYER SUMMARY BY CREATE DATE");
    btnBuyerSummaryByCreateDate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBuyerSummaryByCreateDate.setBounds(new Rectangle(442, 424, 327, 27));
    btnDelScheduelRpt.setBounds(new Rectangle(57, 465, 327, 27));
    btnDelScheduelRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelScheduelRpt.setText("DELIVERY SCHEDULE REPORT");
    btnDelScheduelRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelScheduelRpt_actionPerformed(e);
      }
    });
    btnListMaker.setBounds(new Rectangle(442, 465, 327, 27));
    btnListMaker.setFont(new java.awt.Font("Dialog", 1, 11));
    btnListMaker.setText("LIST MAKER");
    btnListMaker.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnListMaker_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS
       &&"NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
      this.add(btnProdStyle,null);
      this.add(btnConfirmationList,null);
      this.add(btnShipAmtSrnSc,null);
      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
        btnShipAmtSrnSc.setEnabled(false);
      }
      this.add(btnShipList,null);
      this.add(btnHkOutStanding,null);
      this.add(btnHkOutStandingSum,null);
    }else{
      this.add(btnShipList, null);
      this.add(btnPS, null);
      this.add(btnRptQcOffshore, null);
      this.add(btnRptChkcoo,null);
      this.add(btnPsListByFtyRpt, null);
      this.add(btnProdColor, null);
      this.add(btnProdStyle, null);
      this.add(btnConfirmationList, null);
      this.add(btnGoCulpReport, null);
      this.add(btnShippingDetlColor, null);
      this.add(btnNthkDtlByScNo, null);
      this.add(btnHkOutStanding, null);
      this.add(btnShipAmtSrnSc, null);
      this.add(btnHkOutStandingSum, null);
      this.add(btnOrderSummery, null);
      this.add(btnOutStandingByMonthBuyer, null);
      this.add(btnBuyerSummaryByCreateDate, null);
      this.add(btnDelScheduelRpt, null);
      this.add(btnListMaker, null);
    }
    this.add(exit4Report3, null);
  }

  void exit4Report3_actionPerformed(ActionEvent e) {
    JPanel panel = new newtimes.MainFunction((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();
  }

  void btnGoCulpReport_actionPerformed(ActionEvent e) {
     try{
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.production.report.TgrToQry4CulpProd());
     }catch(Exception exp){
       exp.printStackTrace();
     }
  }

  void btnRptQcOffshore_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenRptQCOffShore());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnRptChkcoo_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrRptCheckCoo());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }


  void btnProdStyle_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenRptProdStyle());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnProdColor_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenReport4ProdDetailColors ());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnPS_actionPerformed(ActionEvent e) {
    newtimes.Frame1 frame=
        (newtimes.Frame1)util.PublicVariable.APP_FRAME;
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    newtimes.reports.report01.ReportPS.RepPsSearch gui=new newtimes.reports.report01.ReportPS.RepPsSearch(frame);
    //gui.PanelInstance=gui;
    util.ApplicationProperites.setProperties("RepPsSearchGUI",gui);
    frame.showPanel(gui);
    this.setCursor(tCur);

  }
  void btnOutStanding_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenOutStandingRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnDelayOrder_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenDelayOdrRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnShipList_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenRptShippingList());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnConfirmationList_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenRptSCCnfmList());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnShippingDetlColor_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToShippDtlByColor());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnShipPendding_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenRptShipPendding());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnPsListByFtyRpt_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenPsFtyListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnNthkDtlByScNo_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenNthkDtlByScNo());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnHkOutStanding_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenHKoutStandingDtl());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnShipAmtSrnSc_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenShipAmtBySrnSc());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnHkOutStandingSum_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenHkoutStandingSummary());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnOrderSummery_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrGenOdrSummeryReport());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnOutStandingByMonthBuyer_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_REPORT_OUTSTANDING_MONTH_BUYER;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }


  }
  void btnBuyerSummaryByCreateDate_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_NTFE_REPORT_FOR_BUYER_SUMMARY_BY_CREATE_DATE;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }

  void btnDelScheduelRpt_actionPerformed(ActionEvent e) {
    try {
      TgrNthkMisReports.CURRENT_REPORT_SET_TO=TgrNthkMisReports.CONST_NTFE_REPORT_FOR_DELIVERY_SCHEDULE_REPORT;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNthkMisReports());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnListMaker_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrGenListMakerReport());
    }catch(Exception exp){
      exp.printStackTrace();
    }
   }

   void setOption()
   {
      if ( newtimes.Per.user_Dep.equals("TPC01") )
      {
         btnProdStyle.setEnabled(false);
         btnProdColor.setEnabled(false);
         btnPS.setEnabled(false);
         btnShipList.setEnabled(false);
         btnConfirmationList.setEnabled(false);
         btnShippingDetlColor.setEnabled(false);
         btnPsListByFtyRpt.setEnabled(false);
         btnNthkDtlByScNo.setEnabled(false);
         btnHkOutStanding.setEnabled(false);
         btnShipAmtSrnSc.setEnabled(false);
         btnHkOutStandingSum.setEnabled(false);
         btnOrderSummery.setEnabled(false);
         btnOutStandingByMonthBuyer.setEnabled(false);
         btnBuyerSummaryByCreateDate.setEnabled(false);
         btnDelScheduelRpt.setEnabled(false);
         btnListMaker.setEnabled(false);
         btnGoCulpReport.setEnabled(false);
      }
      if ( newtimes.Per.user_Dep.equals("TPJ09") )
     {
        btnProdStyle.setEnabled(true);
        btnRptQcOffshore.setEnabled(true);
        btnProdColor.setEnabled(false);
        btnPS.setEnabled(false);
        btnShipList.setEnabled(false);
        btnConfirmationList.setEnabled(false);
        btnShippingDetlColor.setEnabled(false);
        btnPsListByFtyRpt.setEnabled(false);
        btnNthkDtlByScNo.setEnabled(false);
        btnHkOutStanding.setEnabled(false);
        btnShipAmtSrnSc.setEnabled(false);
        btnHkOutStandingSum.setEnabled(false);
        btnOrderSummery.setEnabled(false);
        btnOutStandingByMonthBuyer.setEnabled(false);
        btnBuyerSummaryByCreateDate.setEnabled(false);
        btnDelScheduelRpt.setEnabled(false);
        btnListMaker.setEnabled(false);
        btnGoCulpReport.setEnabled(false);
     }

   }
}
