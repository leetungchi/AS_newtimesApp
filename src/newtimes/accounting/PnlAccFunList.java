package newtimes.accounting;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URLClassLoader;
import java.net.URL;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAccFunList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnFabCommBalance = new JButton();
  JButton btnDailyShipmentReport4Accounting = new JButton();
  JButton btnFabCommNonePI = new JButton();
  JButton btnSttm4TotalComm = new JButton();
  JButton btnInv2Signe = new JButton();
  JButton btnInvChkList = new JButton();
  JButton btnCommAmtList = new JButton();
  JButton btnSrnNoDtlList = new JButton();
  JButton btnBankFunc = new JButton();
  JButton btnExchangeRate = new JButton();
  JButton btnOffShoreDebitNote = new JButton();
  JButton btnDebitNoteMaintain = new JButton();
  JButton btnAshworthFabricChartForAcc = new JButton();
  JButton btnLocalVoucher = new JButton();
  JButton btnGnAccItem = new JButton();
  JButton btnGnAccDataMaintain = new JButton();
  JButton btnProfitShareList = new JButton();
  JButton btnProfitShareListWithRcvAmt = new JButton();
  JButton btnAccProdStyleRPT = new JButton();
  JButton btnShipAmtBySRN = new JButton();
  JButton btnRptShipDtlBySrn = new JButton();
  JButton btnRptInvDbSmryList = new JButton();
  JButton btnFabType_N_None_RPT = new JButton();
  JButton btnInvoiceDeduct = new JButton();
  JButton btnProfitShareWithQty = new JButton();
  JButton btnStudioSummaryList = new JButton();
  JButton btnPaidStudio = new JButton();
  JButton btnDestAmtLess5K = new JButton();
  JButton btnCommDisc = new JButton();
  JButton btnInvDbnoDdk = new JButton();
  JButton btnInvPayList = new JButton();
  JButton btnDiffrpt = new JButton();
  public PnlAccFunList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void jbInit() throws Exception {
    util.PublicVariable.OPERATTING_CENTER=(String)util.PublicVariable.USER_RECORD.get(4);
    blueBkgWhiteCharLabel1.setText("ACCOUNTING DEPARTMENT REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 0, 798, 29));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(341, 536, 116, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnFabCommBalance.setBackground(Color.white);
    btnFabCommBalance.setBounds(new Rectangle(83, 71, 277, 29));
    btnFabCommBalance.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFabCommBalance.setText("FABRIC COMMISION BALANCE");
    btnFabCommBalance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFabCommBalance_actionPerformed(e);
      }
    });
    this.setBackground(new Color(204, 204, 225));
    btnDailyShipmentReport4Accounting.setBackground(Color.white);
    btnDailyShipmentReport4Accounting.setBounds(new Rectangle(82, 35, 277, 29));
    btnDailyShipmentReport4Accounting.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDailyShipmentReport4Accounting.setText("Daily Shipment Report For Accounting");
    btnDailyShipmentReport4Accounting.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDailyShipmentReport4Accounting_actionPerformed(e);
      }
    });
    btnFabCommNonePI.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFabCommNonePI_actionPerformed(e);
      }
    });
    btnFabCommNonePI.setText("PRINT FAB COMM BY NONE PI RCV DATE");
    btnFabCommNonePI.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFabCommNonePI.setBounds(new Rectangle(83, 107, 277, 29));
    btnFabCommNonePI.setBackground(Color.white);
    btnSttm4TotalComm.setBackground(Color.white);
    btnSttm4TotalComm.setBounds(new Rectangle(84, 214, 277, 29));
    btnSttm4TotalComm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSttm4TotalComm.setText("STATEMENT OF TOTAL COMMISSION");
    btnSttm4TotalComm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSttm4TotalComm_actionPerformed(e);
      }
    });
    btnInv2Signe.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnInv2Signe_actionPerformed(e);
      }
    });
    btnInv2Signe.setText("INVOICE RECEIVE LIST");
    btnInv2Signe.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInv2Signe.setBounds(new Rectangle(84, 143, 277, 29));
    btnInv2Signe.setBackground(Color.white);
    btnInvChkList.setBackground(Color.white);
    btnInvChkList.setBounds(new Rectangle(84, 178, 277, 29));
    btnInvChkList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInvChkList.setText("INVOICE CHECK LIST");
    btnInvChkList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnInvChkList_actionPerformed(e);
      }
    });
    btnCommAmtList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCommAmtList_actionPerformed(e);
      }
    });
    btnCommAmtList.setText("COMMISION AMOUNT LIST");
    btnCommAmtList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCommAmtList.setBounds(new Rectangle(85, 250, 277, 29));
    btnCommAmtList.setBackground(Color.white);
    btnSrnNoDtlList.setBackground(Color.white);
    btnSrnNoDtlList.setBounds(new Rectangle(86, 287, 277, 29));
    btnSrnNoDtlList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSrnNoDtlList.setText("SRN W/O DETAIL LIST");
    btnSrnNoDtlList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSrnNoDtlList_actionPerformed(e);
      }
    });
    btnBankFunc.setBackground(Color.white);
    btnBankFunc.setBounds(new Rectangle(386, 324, 168, 29));
    btnBankFunc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBankFunc.setText("BANK FUNCTIONS");
    btnBankFunc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBankFunc_actionPerformed(e);
      }
    });
    btnExchangeRate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExchangeRate_actionPerformed(e);
      }
    });
    btnExchangeRate.setText("EXCHANGE RATE");
    btnExchangeRate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExchangeRate.setBounds(new Rectangle(86, 324, 277, 29));
    btnExchangeRate.setBackground(Color.white);
    btnOffShoreDebitNote.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOffShoreDebitNote_actionPerformed(e);
      }
    });
    btnOffShoreDebitNote.setText("Offshore Debit Note");
    btnOffShoreDebitNote.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOffShoreDebitNote.setBounds(new Rectangle(386, 361, 168, 29));
    btnOffShoreDebitNote.setBackground(Color.white);
    btnDebitNoteMaintain.setBackground(Color.white);
    btnDebitNoteMaintain.setBounds(new Rectangle(386, 250, 168, 29));
    btnDebitNoteMaintain.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDebitNoteMaintain.setText("Debit Note Maintain");
    btnDebitNoteMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDebitNoteMaintain_actionPerformed(e);
      }
    });
    btnAshworthFabricChartForAcc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAshworthFabricChartForAcc_actionPerformed(e);
      }
    });
    btnAshworthFabricChartForAcc.setText("ASHWORTH FABRIC CHART FOR ACCOUNTING");
    btnAshworthFabricChartForAcc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAshworthFabricChartForAcc.setActionCommand("Daily Shipment Report For Accounting");
    btnAshworthFabricChartForAcc.setBounds(new Rectangle(388, 35, 376, 29));
    btnAshworthFabricChartForAcc.setBackground(Color.white);
    btnLocalVoucher.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnLocalVoucher_actionPerformed(e);
      }
    });
    btnLocalVoucher.setText("Local Voucher");
    btnLocalVoucher.setFont(new java.awt.Font("Dialog", 1, 11));
    btnLocalVoucher.setBounds(new Rectangle(386, 287, 168, 29));
    btnLocalVoucher.setBackground(Color.white);
    btnGnAccItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGnAccItem_actionPerformed(e);
      }
    });
    btnGnAccItem.setText("General Voucher MIS");
    btnGnAccItem.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGnAccItem.setToolTipText("");
    //btnGnAccItem.setBounds(new Rectangle(389, 144, 306, 29));
    btnGnAccItem.setBounds(new Rectangle(386, 178, 306, 29));
    btnGnAccItem.setBackground(Color.white);
    btnGnAccDataMaintain.setBackground(Color.white);
    btnGnAccDataMaintain.setBounds(new Rectangle(386, 143, 376, 29));
    btnGnAccDataMaintain.setToolTipText("");
    btnGnAccDataMaintain.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGnAccDataMaintain.setText("General Voucher Daily");
    btnGnAccDataMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGnAccDataMaintain_actionPerformed(e);
      }
    });
    btnProfitShareList.setBackground(Color.white);
    btnProfitShareList.setBounds(new Rectangle(388, 71, 141, 29));
    btnProfitShareList.setActionCommand("Daily Shipment Report For Accounting");
    btnProfitShareList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProfitShareList.setText("PROFIT SHARE LIST");
    btnProfitShareList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProfitShareList_actionPerformed(e);
      }
    });
    btnProfitShareListWithRcvAmt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProfitShareListWithRcvAmt_actionPerformed(e);
      }
    });
    btnProfitShareListWithRcvAmt.setText("PROFIT SHARE LIST WITH RCV AMT");
    btnProfitShareListWithRcvAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProfitShareListWithRcvAmt.setActionCommand("Daily Shipment Report For Accounting");
    btnProfitShareListWithRcvAmt.setBounds(new Rectangle(540, 71, 224, 29));
    btnProfitShareListWithRcvAmt.setBackground(Color.white);
    btnAccProdStyleRPT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAccProdStyleRPT_actionPerformed(e);
      }
    });
    btnAccProdStyleRPT.setText("ORDER / UNSHIPPED DETAIL BY STYLE");
    btnAccProdStyleRPT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAccProdStyleRPT.setBounds(new Rectangle(386, 214, 236, 29));
    btnAccProdStyleRPT.setBackground(Color.white);
    btnShipAmtBySRN.setBackground(Color.white);
    btnShipAmtBySRN.setBounds(new Rectangle(572, 250, 198, 29));
    btnShipAmtBySRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipAmtBySRN.setText("SHIPPING AMOUNT BY SRN");
    btnShipAmtBySRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipAmtBySRN_actionPerformed(e);
      }
    });
    btnRptShipDtlBySrn.setBackground(Color.white);
    btnRptShipDtlBySrn.setBounds(new Rectangle(573, 287, 198, 29));
    btnRptShipDtlBySrn.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptShipDtlBySrn.setText("SHIP DETAIL BY SRN");
    btnRptShipDtlBySrn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptShipDtlBySrn_actionPerformed(e);
      }
    });
    btnRptInvDbSmryList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptInvDbSmryList_actionPerformed(e);
      }
    });
    btnRptInvDbSmryList.setText("INVOICE /DN SUMMARY LIST");
    btnRptInvDbSmryList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptInvDbSmryList.setBounds(new Rectangle(573, 324, 198, 29));
    btnRptInvDbSmryList.setBackground(Color.white);
    btnFabType_N_None_RPT.setBackground(Color.white);
    btnFabType_N_None_RPT.setBounds(new Rectangle(87, 361, 277, 32));
    btnFabType_N_None_RPT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFabType_N_None_RPT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFabType_N_None_RPT_actionPerformed(e);
      }
    });
    btnFabType_N_None_RPT.setText("TYPE N & NONE FAB/ACC COMM");
    btnInvoiceDeduct.setBackground(Color.white);
    btnInvoiceDeduct.setBounds(new Rectangle(573, 361, 188, 29));
    btnInvoiceDeduct.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInvoiceDeduct.setText("INVOICE DEDUCT MAINTAIN");
    btnInvoiceDeduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnInvoiceDeduct_actionPerformed(e);
      }
    });

   // if(util.PublicVariable.OPERATTING_CENTER.equals("001")){

    //}




    btnProfitShareWithQty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProfitShareWithQty_actionPerformed(e);
      }
    });
    btnProfitShareWithQty.setText("PROFIT SHARE WITH QTY.");
    btnProfitShareWithQty.setFont(new java.awt.Font("Dialog", 1, 11));
    btnProfitShareWithQty.setActionCommand("Daily Shipment Report For Accounting");
    btnProfitShareWithQty.setBounds(new Rectangle(388, 107, 175, 29));
    btnProfitShareWithQty.setBackground(Color.white);
    btnStudioSummaryList.setBackground(Color.white);
    btnStudioSummaryList.setBounds(new Rectangle(589, 107, 175, 29));
    btnStudioSummaryList.setActionCommand("Daily Shipment Report For Accounting");
    btnStudioSummaryList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStudioSummaryList.setText("STUDIO SUMMARY LIST");
    btnStudioSummaryList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStudioSummaryList_actionPerformed(e);
      }
    });
    btnPaidStudio.setBackground(Color.white);
    btnPaidStudio.setBounds(new Rectangle(89, 401, 277, 29));
    btnPaidStudio.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPaidStudio.setText("PAID STUDIO MAINTAIN");
    btnPaidStudio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPaidStudio_actionPerformed(e);
      }
    });
    btnDestAmtLess5K.setBackground(Color.white);
    btnDestAmtLess5K.setBounds(new Rectangle(386, 401, 168, 29));
    btnDestAmtLess5K.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDestAmtLess5K.setText("DEST.  INV AMT < 5K");
    btnDestAmtLess5K.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDestAmtLess5K_actionPerformed(e);
      }
    });

   btnCommDisc.setBackground(Color.white);
   btnCommDisc.setBounds(new Rectangle(386, 438, 168, 29));
   btnCommDisc.setFont(new java.awt.Font("Dialog", 1, 11));
   btnCommDisc.setText("List INV Comm & Disc");
   btnCommDisc.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(ActionEvent e) {
       btnCommDisc_actionPerformed(e);
     }
   });


    btnInvDbnoDdk.setBackground(Color.white);
    btnInvDbnoDdk.setBounds(new Rectangle(572, 401, 175, 29));
    btnInvDbnoDdk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInvDbnoDdk.setText("INVOICE DBNO LIST");
    btnInvDbnoDdk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnInvDbnoDdk_actionPerformed(e);
      }
    });

    btnInvPayList.setBackground(Color.white);
    btnInvPayList.setBounds(new Rectangle(572, 438, 175, 29));
    btnInvPayList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInvPayList.setText("INVOICE PAYMENT LIST");
    btnInvPayList.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(ActionEvent e) {
             btnPayList_actionPerformed(e);
     }
   });



    btnDiffrpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDiffrpt_actionPerformed(e);
      }
    });
    btnDiffrpt.setText("Difference Amt List");
    btnDiffrpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDiffrpt.setToolTipText("");
    btnDiffrpt.setBounds(new Rectangle(625, 214, 155, 29));
    btnDiffrpt.setBackground(Color.white);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnDailyShipmentReport4Accounting, null);
    this.add(btnAshworthFabricChartForAcc, null);
    this.add(btnProfitShareList, null);
    this.add(btnProfitShareListWithRcvAmt, null);
    this.add(btnGnAccDataMaintain, null);
    this.add(btnDebitNoteMaintain, null);
    this.add(btnLocalVoucher, null);
    this.add(btnBankFunc, null);
    this.add(btnOffShoreDebitNote, null);
    this.add(btnShipAmtBySRN, null);
    this.add(btnRptShipDtlBySrn, null);
    this.add(btnAccProdStyleRPT, null);
 //********
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      this.add(btnGnAccItem, null);
    }

    if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS||
         util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS){

          this.add(btnRptInvDbSmryList, null);
          this.add(btnInvoiceDeduct, null);
          this.add(btnProfitShareWithQty, null);
          this.add(btnStudioSummaryList, null);
          this.add(btnDestAmtLess5K, null);
          this.add(btnInvDbnoDdk, null);
          this.add(btnInvPayList,null);
       }
      }
    this.add(btnCommDisc,null);
    this.add(btnExit, null);
    this.add(btnDiffrpt, null);
    this.add(btnFabCommBalance, null);
    this.add(btnFabCommNonePI, null);
    this.add(btnInv2Signe, null);
    this.add(btnInvChkList, null);
    this.add(btnSttm4TotalComm, null);
    this.add(btnCommAmtList, null);
    this.add(btnSrnNoDtlList, null);
    this.add(btnExchangeRate, null);
    this.add(btnFabType_N_None_RPT, null);
    this.add(btnPaidStudio, null);

  }

  void btnExit_actionPerformed(ActionEvent e) {
     newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;
     frame.showPanel(new newtimes.MainFunction(frame));
  }

  void btnFabCommBalance_actionPerformed(ActionEvent e) {
    try{
    AcctFunsConsts.PNL_QRY_FAB_COMMS=null;
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrToQryFabricComm());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnDailyShipmentReport4Accounting_actionPerformed(ActionEvent e) {
    newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.accountdepuse.DailyRec4AccountDepUse(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void btnFabCommNonePI_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrToFabNonePI_rpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnProfitDtlList_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrTogenProfitDtlListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnSttm4TotalComm_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrTogenStatementOfTotalCommission());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnInv2Signe_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrTogenInvoice2Signe());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnInvChkList_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrToGenInvoiceListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnCommAmtList_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrGenCommListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnSrnNoDtlList_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrSrnNoDtl());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnBankFunc_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      newtimes.bank.Constants.vctBank.clear();
      newtimes.bank.Constants.vctCompany.clear();
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.bank.TgrBankFunList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }
  void btnExchangeRate_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrExchageRateDetRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnOffShoreDebitNote_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.offshoredebitnote.TgrOffshoreDebitNoteFunctionList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
    void btnDebitNoteMaintain_actionPerformed(ActionEvent e) {
      try{
        newtimes.accounting.debit_note.Constans.PNL2QUERY=null;
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.accounting.debit_note.TgrShowDebitnoteFuncList());
      }catch(Exception exp){
        exp.printStackTrace();
       }
  }
  void btnAshworthFabricChartForAcc_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrAshworthFabricChart4Acc());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnLocalVoucher_actionPerformed(ActionEvent e) {
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.local_voucher.TgrShowLocalVoucherFunc());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  class MyClassLoader extends java.net.URLClassLoader{
    public MyClassLoader(java.net.URL url[],java.lang.ClassLoader parent){
      super(url,parent);
    }
    public void addURL(java.net.URL url2add){
      super.addURL(url2add);
    }
  }

  void btnGeneralVoucher_actionPerformed(ActionEvent ae) {
  /*
    try{
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
          );
   }catch(Exception exp){
     exp.printStackTrace();
   }
   try{


     StringBuffer sbURL2download=new StringBuffer();
     sbURL2download.append("http://");
     sbURL2download.append(util.MiscFunc.split(util.PublicVariable.SERVER_URL,",")[0]);
     sbURL2download.append(":7001/newtimesWebMdl");
     sbURL2download.append("/TPE_GN_VOUCHER");
     util.MiscFunc.installEJBStubJar(sbURL2download.toString(),"gn_voucher_stub.jar");
     Class runner=util.MiscFunc.installJAR(sbURL2download.toString(),"gn_voucher.jar",
                                           "newtimes.general_voucher.TgrGnVoucherFuncList");
      processhandler.CommandTrigger actionTriger=(processhandler.CommandTrigger) runner.newInstance();

       //thank God,We have the abstract Class--CommandTriger.

        processhandler.template.Properties.getCenteralControler().doCommandExecute(
          actionTriger
      );

   }catch(Exception exp){
     exp.printStackTrace();
   }
*/
  }
  void btngnTestAgain_actionPerformed(ActionEvent e) {
/*
    try{
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
           );

      }catch(Exception exp){
      exp.printStackTrace();
    }
    try{
      StringBuffer sbURL2download=new StringBuffer();
      sbURL2download.append("http://");
      sbURL2download.append(util.MiscFunc.split(util.PublicVariable.SERVER_URL,",")[0]);
      sbURL2download.append(":7001/newtimesWebMdl");
      sbURL2download.append("/TPE_GN_VOUCHER");
      Class initater=util.MiscFunc.installJAR(sbURL2download.toString(),"gn_voucher_test2.jar","newtimes.gn_voucher_test2.TgrGnVoucherFuncList");

      //java.lang.ClassLoader xLoader=Thread.currentThread().getContextClassLoader();
       processhandler.CommandTrigger actionTriger=
       (processhandler.CommandTrigger)initater.newInstance();
        //thank God,We have the abstract Class--CommandTriger.
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
           actionTriger
       );

    }catch(Exception exp){
      exp.printStackTrace();
    }
*/
  }
  void btnGnAccItem_actionPerformed(ActionEvent e) {

    try{
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
           );
    }catch(Exception exp){
      exp.printStackTrace();
    }

    //for running version
   /*
    try{
      StringBuffer sbURL2download=new StringBuffer();
      sbURL2download.append("http://");
      sbURL2download.append(util.MiscFunc.split(util.PublicVariable.SERVER_URL,",")[0]);
      sbURL2download.append(":7001/newtimesWebMdl");
      sbURL2download.append("/TPE_GN_VOUCHER");
      util.MiscFunc.installEJBStubJar(sbURL2download.toString(),"gn_voucher_stub.jar");
      Class initater=util.MiscFunc.installJAR(sbURL2download.toString(),
                                              "gn_voucher.jar","newtimes.general_voucher.TgrBasicFunc");

      //java.lang.ClassLoader xLoader=Thread.currentThread().getContextClassLoader();
       processhandler.CommandTrigger actionTriger=
       (processhandler.CommandTrigger)initater.newInstance();
        //thank God,We have the abstract Class--CommandTriger.
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
           actionTriger
       );

    }catch(Exception exp){
      exp.printStackTrace();
    }
    */

    //for debug mode

    try{
     newtimes.general_voucher.TgrBasicFunc tgr=new newtimes.general_voucher.TgrBasicFunc();
     processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

 }

  void btnGnAccDataMaintain_actionPerformed(ActionEvent e) {

    try{
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
           );
    }catch(Exception exp){
      exp.printStackTrace();
    }
    try{

      //for debug only

      processhandler.template.Properties.getCenteralControler().doCommandExecute(
                new newtimes.general_voucher.TgrAccDataMaintain()
      );

      //for runtime only
     /*
      StringBuffer sbURL2download=new StringBuffer();
      sbURL2download.append("http://");
      sbURL2download.append(util.MiscFunc.split(util.PublicVariable.SERVER_URL,",")[0]);
      sbURL2download.append(":7001/newtimesWebMdl");
      sbURL2download.append("/TPE_GN_VOUCHER");
      util.MiscFunc.installEJBStubJar(sbURL2download.toString(),"gn_voucher_stub.jar");

      Class initater=util.MiscFunc.installJAR(sbURL2download.toString(),
                                              "gn_voucher.jar","newtimes.general_voucher.TgrAccDataMaintain");
      //java.lang.ClassLoader xLoader=Thread.currentThread().getContextClassLoader();
       processhandler.CommandTrigger actionTriger=
       (processhandler.CommandTrigger)initater.newInstance();
        //thank God,We have the abstract Class--CommandTriger.
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
           actionTriger
       );
       */

    }catch(Exception exp){
      exp.printStackTrace();
    }

    /*
    try{
     newtimes.general_voucher.TgrAccDataMaintain tgr=new newtimes.general_voucher.TgrAccDataMaintain();
     processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }*/

  }
  void btnProfitShareList_actionPerformed(ActionEvent e) {
    try{
       newtimes.accounting.PnlProfitShareList.IS_WITH_RCV_AMT=false;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.TgrToGenProfitShareListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnProfitShareListWithRcvAmt_actionPerformed(ActionEvent e) {
    try{
       newtimes.accounting.PnlProfitShareList.IS_WITH_RCV_AMT=true;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.TgrToGenProfitShareListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnAccProdStyleRPT_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          new newtimes.production.report.TgrAccProdStyleRpt());
    }catch(Exception exp){
      exp.printStackTrace();

    }
  }
  void btnShipAmtBySRN_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.TgrShippingAmtBySRN());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnRptShipDtlBySrn_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrRptShipDtlBySrn());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptInvDbSmryList_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.TgrRptInvDbSmryList());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnFabType_N_None_RPT_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrRptFabTypeN_None());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnInvoiceDeduct_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrInvoiceDeductMng());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnProfitShareWithQty_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrPnlProfitShareListWithQty());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnStudioSummaryList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrRptStudioSummaryList());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnPaidStudio_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrPaidStudioMaintain());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnDestAmtLess5K_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrRptDestInvAmtLess5K());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  //**
  void btnCommDisc_actionPerformed(ActionEvent e) {
   try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptInvCommDisc());
   }catch(Exception exp){
     exp.printStackTrace();
    }

 }



  void btnInvDbnoDdk_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrRptInvDbnoDdk());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnPayList_actionPerformed(ActionEvent e) {
   try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptInvPayList());
   }catch(Exception exp){
     exp.printStackTrace();
    }

 }


  void btnDiffrpt_actionPerformed(ActionEvent e) {
    try{
   processhandler.template.Properties.getCenteralControler().doCommandExecute(
   new TgrRptDiffAmtList());
}catch(Exception exp){
  exp.printStackTrace();
 }

  }

}
