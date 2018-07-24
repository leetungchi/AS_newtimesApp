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

public class Pnl_MIS_Func_List extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnStyleCloseMaintain = new JButton();
  JButton btnBatchUpdateDelivery = new JButton();
  JButton btnDelayOrderCheckList = new JButton();
  JButton btnExit = new JButton();
  JButton btnPrintBuyerCommission = new JButton();
  JButton btnProfitList = new JButton();
  JButton btnSalseProfitReport = new JButton();
  JButton btnFabType_N_None_RPT = new JButton();
  JButton btnFabAccCommList = new JButton();
  JButton btnKormarFtyAmnt = new JButton();
  JButton btnBuyerMakerTop12 = new JButton();
  JButton btnTimeRateRpt = new JButton();
  JButton btnFabCommMkrDiscLessStandard = new JButton();
  JButton btnNoneScList = new JButton();
  JButton btnTPE_MIS_FUNC = new JButton();
  JButton btnProfitShare = new JButton();
  JButton btnFabAccNoCommList = new JButton();
  JButton btnPendingStyleProfitList = new JButton();
  JButton btnListLaurenIc = new JButton();
  JButton btnSalseProfitReportXmonth = new JButton();
  JButton btnNthkInvList = new JButton();
  JButton btnLaurenMakerList = new JButton();
  JButton btnVsdUpload = new JButton();
  JButton btnProdOffShore = new JButton();
  JButton btnShipOffShore = new JButton();
  JButton btnDuplicateSRN = new JButton();
  JButton btnInspectionReport = new JButton();
  JButton btnPrintScStickerLabel = new JButton();

  public Pnl_MIS_Func_List() {
    try {
      util.PublicVariable.OPERATTING_CENTER=(String)util.PublicVariable.USER_RECORD.get(4);
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("MIS UTILITY");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 9, 797, 30));
    this.setLayout(null);
    this.setBackground(new Color(204, 204, 225));
    this.setForeground(Color.black);
    btnStyleCloseMaintain.setBackground(Color.white);
    btnStyleCloseMaintain.setBounds(new Rectangle(60, 46, 354, 32));
    btnStyleCloseMaintain.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStyleCloseMaintain.setText("STYLE CLOSE MAINTAIN");
    btnStyleCloseMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStyleCloseMaintain_actionPerformed(e);
      }
    });
    btnBatchUpdateDelivery.setText("BATCH UPDATE DELIVERY");
    btnBatchUpdateDelivery.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBatchUpdateDelivery_actionPerformed(e);
      }
    });
    btnBatchUpdateDelivery.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBatchUpdateDelivery.setBounds(new Rectangle(60, 88, 354, 32));
    btnBatchUpdateDelivery.setBackground(Color.white);
    btnDelayOrderCheckList.setText("DELAY ORDER CHECK LIST");
    btnDelayOrderCheckList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelayOrderCheckList_actionPerformed(e);
      }
    });
    btnDelayOrderCheckList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelayOrderCheckList.setBounds(new Rectangle(60, 131, 354, 32));
    btnDelayOrderCheckList.setBackground(Color.white);
    btnExit.setBounds(new Rectangle(348, 507, 101, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnPrintBuyerCommission.setBackground(Color.white);
    btnPrintBuyerCommission.setBounds(new Rectangle(60, 173, 354, 32));
    btnPrintBuyerCommission.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrintBuyerCommission.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrintBuyerCommission_actionPerformed(e);
      }
    });
    btnPrintBuyerCommission.setText("PRINT BUYER COMMISSION");
    btnProfitList.setBackground(Color.white);
    btnProfitList.setBounds(new Rectangle(60, 215, 174, 32));
    btnProfitList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProfitList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProfitList_actionPerformed(e);
      }
    });
    btnProfitList.setText("PROFIT DETAIL LIST");
    btnSalseProfitReport.setText("SALES PROFIT REPORT");
    btnSalseProfitReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSalseProfitReport_actionPerformed(e);
      }
    });
    btnSalseProfitReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSalseProfitReport.setBounds(new Rectangle(60, 258, 354, 32));
    btnSalseProfitReport.setBackground(Color.white);
    btnFabType_N_None_RPT.setBackground(Color.white);
    btnFabType_N_None_RPT.setBounds(new Rectangle(60, 342, 354, 32));
    btnFabType_N_None_RPT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFabType_N_None_RPT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFabType_N_None_RPT_actionPerformed(e);
      }
    });
    btnFabType_N_None_RPT.setText("TYPE N & NONE FAB/ACC COMM");
    btnFabAccCommList.setText("FAB & ACCESSORIES COMM LIST");
    btnFabAccCommList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFabAccCommList_actionPerformed(e);
      }
    });
    btnFabAccCommList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFabAccCommList.setBounds(new Rectangle(60, 300, 354, 32));
    btnFabAccCommList.setBackground(Color.white);
    btnKormarFtyAmnt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnKormarFtyAmnt_actionPerformed(e);
      }
    });
    btnKormarFtyAmnt.setText("KOMAR FTY AMOUNT");
    btnKormarFtyAmnt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnKormarFtyAmnt.setBounds(new Rectangle(447, 46, 303, 32));
    btnKormarFtyAmnt.setBackground(Color.white);
    btnBuyerMakerTop12.setBackground(Color.white);
    btnBuyerMakerTop12.setBounds(new Rectangle(447, 87, 303, 32));
    btnBuyerMakerTop12.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBuyerMakerTop12.setText("BUYER MAKER TOP 12,50");
    btnBuyerMakerTop12.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBuyerMakerTop12_actionPerformed(e);
      }
    });
    btnTimeRateRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTimeRateRpt_actionPerformed(e);
      }
    });
    btnTimeRateRpt.setText("ON TIME RATE");
    btnTimeRateRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnTimeRateRpt.setBounds(new Rectangle(447, 127, 303, 32));
    btnTimeRateRpt.setBackground(Color.white);
    btnFabCommMkrDiscLessStandard.setBackground(Color.white);
    btnFabCommMkrDiscLessStandard.setBounds(new Rectangle(447, 168, 303, 32));
    btnFabCommMkrDiscLessStandard.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFabCommMkrDiscLessStandard.setText("FAB COMM & MKR DISC LESS STANDARD");
    btnFabCommMkrDiscLessStandard.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFabCommMkrDiscLessStandard_actionPerformed(e);
      }
    });
    btnNoneScList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNoneScList_actionPerformed(e);
      }
    });
    btnNoneScList.setText("NONE S/C# LIST");
    btnNoneScList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNoneScList.setBounds(new Rectangle(447, 208, 303, 32));
    btnNoneScList.setBackground(Color.white);
    btnTPE_MIS_FUNC.setBackground(Color.white);
    btnTPE_MIS_FUNC.setBounds(new Rectangle(447, 289, 303, 32));
    btnTPE_MIS_FUNC.setFont(new java.awt.Font("Dialog", 0, 12));
    btnTPE_MIS_FUNC.setText("台北MIS專用");
    btnTPE_MIS_FUNC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTPE_MIS_FUNC_actionPerformed(e);
      }
    });
    btnProfitShare.setText("PROFIT SHARE LIST");
    btnProfitShare.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProfitShare_actionPerformed(e);
      }
    });
    btnProfitShare.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProfitShare.setBounds(new Rectangle(253, 215, 161, 32));
    btnProfitShare.setBackground(Color.white);
    btnFabAccNoCommList.setText("FABRIC & ACCESSORYIES NO COMM LIST");
    btnFabAccNoCommList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFabAccNoCommList_actionPerformed(e);
      }
    });
    btnFabAccNoCommList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFabAccNoCommList.setBounds(new Rectangle(60, 385, 354, 32));
    btnFabAccNoCommList.setBackground(Color.white);
    btnPendingStyleProfitList.setText("PENDING STYLE PROFIT LIST");
    btnPendingStyleProfitList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPendingStyleProfitList_actionPerformed(e);
      }
    });
    btnPendingStyleProfitList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPendingStyleProfitList.setBounds(new Rectangle(447, 329, 303, 32));
    btnPendingStyleProfitList.setBackground(Color.white);
    btnListLaurenIc.setBackground(Color.white);
    btnListLaurenIc.setBounds(new Rectangle(447, 371, 138, 32));
    btnListLaurenIc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnListLaurenIc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnListLaurenIc_actionPerformed(e);
      }
    });
    btnListLaurenIc.setText("LIST LAUREN I.C.");
    btnSalseProfitReportXmonth.setBackground(Color.white);
    btnSalseProfitReportXmonth.setBounds(new Rectangle(447, 249, 303, 32));
    btnSalseProfitReportXmonth.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSalseProfitReportXmonth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSalseProfitReportXmonth_actionPerformed(e);
      }
    });
    btnSalseProfitReportXmonth.setText("SALES PROFIT REPORT SINGLE MONTH");
    btnNthkInvList.setBackground(Color.white);
    btnNthkInvList.setBounds(new Rectangle(447, 410, 122, 32));
    btnNthkInvList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNthkInvList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNthkInvList_actionPerformed(e);
      }
    });
    btnNthkInvList.setText("NTHK INV LIST");
    btnLaurenMakerList.setText("LAUREN VENDOR LIST");
    btnLaurenMakerList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnLaurenMakerList_actionPerformed(e);
      }
    });
    btnLaurenMakerList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnLaurenMakerList.setBounds(new Rectangle(598, 371, 152, 32));
    btnLaurenMakerList.setBackground(Color.white);
    btnVsdUpload.setText("VSD UPLOAD");
    btnVsdUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnVsdUpload_actionPerformed(e);
      }
    });
    btnVsdUpload.setFont(new java.awt.Font("Dialog", 1, 11));
    btnVsdUpload.setBounds(new Rectangle(607, 410, 143, 32));
    btnVsdUpload.setBackground(Color.white);
    btnProdOffShore.setBackground(Color.white);
    btnProdOffShore.setBounds(new Rectangle(253, 427, 161, 32));
    btnProdOffShore.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProdOffShore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProdOffShore_actionPerformed(e);
      }
    });
    btnProdOffShore.setText("PROD OFFSHORE");
    btnShipOffShore.setText("SHIP OFFSHORE");
    btnShipOffShore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipOffShore_actionPerformed(e);
      }
    });
    btnShipOffShore.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipOffShore.setBounds(new Rectangle(60, 427, 174, 32));
    btnShipOffShore.setBackground(Color.white);
    btnDuplicateSRN.setBackground(Color.white);
    btnDuplicateSRN.setBounds(new Rectangle(60, 467, 354, 32));
    btnDuplicateSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDuplicateSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDuplicateSRN_actionPerformed(e);
      }
    });
    btnDuplicateSRN.setText("Print Duplicate SRN");
    btnInspectionReport.setText("INSPECTION REPORT");
    btnInspectionReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnInspectionReport_actionPerformed(e);
      }
    });
    btnInspectionReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInspectionReport.setBounds(new Rectangle(447, 467, 303, 32));
    btnInspectionReport.setBackground(Color.white);
    btnPrintScStickerLabel.setBackground(Color.white);
    btnPrintScStickerLabel.setBounds(new Rectangle(447, 373, 303, 32));
    btnPrintScStickerLabel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrintScStickerLabel.setText("PRINT S/C STICKER LABELS");
    btnPrintScStickerLabel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrintScStickerLabel_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnKormarFtyAmnt, null);
    this.add(btnStyleCloseMaintain, null);
    //this.add(btnTPE_MIS_FUNC, null);




    this.add(btnBuyerMakerTop12, null);
    this.add(btnTimeRateRpt, null);
    this.add(btnFabCommMkrDiscLessStandard, null);
    this.add(btnNoneScList, null);
    this.add(btnPendingStyleProfitList, null);
    this.add(btnBatchUpdateDelivery, null);
    this.add(btnDelayOrderCheckList, null);
    this.add(btnPrintBuyerCommission, null);
    this.add(btnProfitList, null);
    this.add(btnProfitShare, null);
    this.add(btnSalseProfitReport, null);
    this.add(btnFabAccCommList, null);
    this.add(btnFabType_N_None_RPT, null);
    this.add(btnFabAccNoCommList, null);
    //some buttons are determed by center to display or not.

    testCetner();

  }
  void testCetner(){


     if(util.PublicVariable.OPERATTING_CENTER.equals("001")&&
        util.PublicVariable.USER_RECORD.getInt(2)==
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
       this.add(btnTPE_MIS_FUNC, null);
       this.add(btnSalseProfitReportXmonth, null);
       this.add(btnPrintScStickerLabel, null);

       return;
     }
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
       this.add(btnListLaurenIc, null);
       this.add(btnLaurenMakerList, null);
       this.add(btnInspectionReport, null);
    }
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      this.add(btnProdOffShore, null);
      this.add(btnShipOffShore, null);
      if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
        this.add(btnDuplicateSRN, null);
      }
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("PW")&&
       newtimes.shipping_admin.ShippingAdmin_Const.isUserEric()){
      this.add(btnVsdUpload, null);
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      this.add(btnNthkInvList, null);
    }
    if(!util.PublicVariable.OPERATTING_CENTER.equals("001")&&
       util.PublicVariable.USER_RECORD.getInt(2)==
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      this.add(btnInspectionReport, null);
    }

  }

  void btnStyleCloseMaintain_actionPerformed(ActionEvent e) {
    String usrType = null;
    newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if (usrType.equals("2")) {
        frame.showPanel(new newtimes.shipping.styleclose.StyleClose_SF(frame));
      } else {
        exgui2.InfoMessage.warningMessage(frame,"You Have No Authorizations.");
      }
    } catch (Exception eS) {
      eS.printStackTrace();
      util.ExceptionLog.exp2File(eS,
           "error at attempt to check authorization.\nuser type:"+usrType);
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

  }

  void btnBatchUpdateDelivery_actionPerformed(ActionEvent e) {
      ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(
         new newtimes.shipping.PnlBatchUpdateDel()
         );
  }

  void btnDelayOrderCheckList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenDelayOdrRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

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
    }*/
  }
  void btnPrintBuyerCommission_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenBuyerCommList4MIS());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnProfitList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.TgrTogenProfitDtlListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnSalseProfitReport_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenSalesProfitReport());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnFabType_N_None_RPT_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenFabTypeN_None_RPT());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnFabAccCommList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenFabAccCommList());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnKormarFtyAmnt_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenKormarFtyAmtRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnBuyerMakerTop12_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenTop12BuyerMakerList());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnTimeRateRpt_actionPerformed(ActionEvent e) {
    //TgrToGenTimeRate
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenTimeRate());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnFabCommMkrDiscLessStandard_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenFabCommMkrDisctLessStandardRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }


  }
  void btnNoneScList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrNoneScNoList());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnTPE_MIS_FUNC_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          new newtimes.production.report.TgrToGenTPE_MIS_FUNC());
    }catch(Exception exp){
      exp.printStackTrace();
    }
    /*
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    Pnl_MIS_Func_List  pnl =new Pnl_MIS_Func_List();
    pnl.setSize(800,600);
    jframe.getContentPane().add(pnl);
    jframe.repaint();
    jframe.show();*/
  }
  void btnProfitShare_actionPerformed(ActionEvent e) {
    try{
       newtimes.accounting.PnlProfitShareList.IS_WITH_RCV_AMT=false;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.TgrToGenProfitShareListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnFabAccNoCommList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenFabAccNoCommList());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnPendingStyleProfitList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrPendingStyleProfitList());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnListLaurenIc_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrLaurenIcList());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnSalseProfitReportXmonth_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrToGenSalesProfitReportSingleMonth());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnNthkInvList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrNthkInvList());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnLaurenMakerList_actionPerformed(ActionEvent e) {
   try{
     util.MiscFunc.showProcessingMessage();
     newtimesejb.TPE_MIS.TpeMisFuncHome ejbTpeMisHome=
         (newtimesejb.TPE_MIS.TpeMisFuncHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                             "newtimesejb.TPE_MIS.TpeMisFunc");
   newtimesejb.TPE_MIS.TpeMisFunc ejbTpeMis=ejbTpeMisHome.create();
   java.util.HashMap hmPara=new java.util.HashMap();
   hmPara.put("TPEMISCFUNC_ACTION_CODE","LAUREN_MAKER_LIST");
   java.util.HashMap hm=ejbTpeMis.tpeMisFunc(hmPara);
   byte[] dataResult=(byte[])hm.get("RESULT");
   java.text.DateFormat df=new java.text.SimpleDateFormat("yyyyMMdd");
   String fileName="c:\\"+df.format(new java.sql.Date(System.currentTimeMillis()))+".xls";
   java.io.File file=new java.io.File(fileName);
   if(file.exists())file.delete();
   java.io.FileOutputStream fo=new java.io.FileOutputStream(file);
   fo.write(dataResult);
   fo.close();
   exgui.verification.VerifyLib.showPlanMsg("upload OK\nPlease Chek Result File:"+fileName,"upload OK");
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"error whle generate csv for Lauren Makers ");
   }finally{
     util.MiscFunc.hideProcessingMessage();
   }


  }
  void btnVsdUpload_actionPerformed(ActionEvent e ) {
     //660x430
     newtimes.vsd_upload.DlgUpload dlg2upload=new
         newtimes.vsd_upload.DlgUpload(util.PublicVariable.APP_FRAME,"UPLOAD VAD CSV",true);
     dlg2upload.setSize(675,430);
     exgui.UIHelper.setToScreenCenter(dlg2upload);
     dlg2upload.show();
  }
  void btnProdOffShore_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrOffShoreProd());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnShipOffShore_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrOffShoreShip());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnDuplicateSRN_actionPerformed(ActionEvent e) {
    try {
      //show debit note report,
      com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.
          inet_report_viewer;
      String rpt_name = "DUPLICATE_DTL.rpt";
      java.util.HashMap hm = new java.util.HashMap();

      String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
      newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
      newtimes.production.report.ReportCmdSet.myReportEngin.
          setReportNameAndParas(viewer, rpt_name, hm);
      viewer.setHasGroupTree(false);
      //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
      viewer.start();
      JPanel pnl = new JPanel();
      pnl.setLayout(new java.awt.BorderLayout());
      pnl.add(viewer);
      String rptTitle="Duplicate SRN Detail";
      newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
          guis.DlgViewRpt(
          processhandler.template.Properties.getMainFrame(),
          rptTitle,
          pnl, true);
      dlg.setSize(700, 500);
      dlg.show();
      newtimes.production.report.ReportProxyEngine.reportServerURL=tempURL;

    } catch (Exception exp) {
      exp.printStackTrace();

    }

  }
  void btnInspectionReport_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrInspectionReport());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnPrintScStickerLabel_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrPrintScStickerLbl());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
}
