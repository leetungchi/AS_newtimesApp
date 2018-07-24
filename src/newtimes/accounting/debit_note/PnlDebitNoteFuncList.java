package newtimes.accounting.debit_note;

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

public class PnlDebitNoteFuncList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQryAddDebitNote = new JButton();
  JButton btnQryPayDtl = new JButton();
  JButton btnExit = new JButton();
  JButton btnQryRpt_PaidFtyFee = new JButton();
  JButton btnExpSrn2Dbnt = new JButton();
  JButton btnBuyerCommNotYetExportedDB = new JButton();
  JButton btnExpSrnFromMkrDiscount = new JButton();
  JButton btnQryDDK = new JButton();
  JButton btnDdkChkBatchList = new JButton();
  JButton btnDbCrList = new JButton();
  JButton bntNortonTemplate = new JButton();
  JButton btnDbCrBuyerNameMtn = new JButton();
  JButton btnStatementAcc = new JButton();
  JButton btnSrnHeadStylePoModification = new JButton();
  JButton btnDbSeqList = new JButton();
  JButton btnDbCrRptByMonth = new JButton();
  JButton btnStatementAcc4Buyer = new JButton();
  JButton btnStatementAcc4BuyerHK = new JButton();
  JButton btnRptWithCommDtlList = new JButton();
  JButton btnRptWithCommDtlList1 = new JButton();

  public PnlDebitNoteFuncList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 8, 802, 32));
    blueBkgWhiteCharLabel1.setText("======= Debit Note Maintain ======");
    this.setBackground(new Color(202, 202, 224));
    this.setFont(new java.awt.Font("Dialog", 1, 11));
    this.setLayout(null);
    btnQryAddDebitNote.setBackground(Color.white);
    btnQryAddDebitNote.setBounds(new Rectangle(94, 46, 322, 32));
    btnQryAddDebitNote.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryAddDebitNote.setText("Query/Add DebitNote Head & Detail");
    btnQryAddDebitNote.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryAddDebitNote_actionPerformed(e);
      }
    });
    btnQryPayDtl.setText("細項查詢");
    btnQryPayDtl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryPayDtl_actionPerformed(e);
      }
    });
    btnQryPayDtl.setFont(new java.awt.Font("Dialog", 0, 16));
    btnQryPayDtl.setBounds(new Rectangle(94, 95, 322, 32));
    btnQryPayDtl.setBackground(Color.white);
    btnExit.setBackground(Color.white);
    btnExit.setBounds(new Rectangle(345, 522, 118, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnQryRpt_PaidFtyFee.setBackground(Color.white);
    btnQryRpt_PaidFtyFee.setBounds(new Rectangle(94, 144, 322, 32));
    btnQryRpt_PaidFtyFee.setFont(new java.awt.Font("Dialog", 0, 16));
    btnQryRpt_PaidFtyFee.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryRpt_PaidFtyFee_actionPerformed(e);
      }
    });
    btnQryRpt_PaidFtyFee.setText("支付工廠費用統計表");
    btnExpSrn2Dbnt.setText("Export Buyer Comm. To D/B");
    btnExpSrn2Dbnt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExpSrn2Dbnt_actionPerformed(e);
      }
    });
    btnExpSrn2Dbnt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExpSrn2Dbnt.setBounds(new Rectangle(94, 192, 322, 32));
    btnExpSrn2Dbnt.setBackground(Color.white);
    btnBuyerCommNotYetExportedDB.setBackground(Color.white);
    btnBuyerCommNotYetExportedDB.setBounds(new Rectangle(433, 46, 322, 32));
    btnBuyerCommNotYetExportedDB.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBuyerCommNotYetExportedDB.setText("BUYER COMM. & MAKER DISC.  NOT YET EXPORT");
    btnBuyerCommNotYetExportedDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBuyerCommNotYetExportedDB_actionPerformed(e);
      }
    });
    btnExpSrnFromMkrDiscount.setBackground(Color.white);
    btnExpSrnFromMkrDiscount.setBounds(new Rectangle(94, 241, 322, 32));
    btnExpSrnFromMkrDiscount.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExpSrnFromMkrDiscount.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExpSrnFromMkrDiscount_actionPerformed(e);
      }
    });
    btnExpSrnFromMkrDiscount.setText("Export Maker Disocunt To D/B");
    btnQryDDK.setText("DEDUCT MAINTENANCE");
    btnQryDDK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryDDK_actionPerformed(e);
      }
    });
    btnQryDDK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryDDK.setBounds(new Rectangle(94, 290, 322, 32));
    btnQryDDK.setBackground(Color.white);
    btnDdkChkBatchList.setBackground(Color.white);
    btnDdkChkBatchList.setBounds(new Rectangle(94, 339, 322, 32));
    btnDdkChkBatchList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDdkChkBatchList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDdkChkBatchList_actionPerformed(e);
      }
    });
    btnDdkChkBatchList.setText("DEDUCT CHECK BATCH LIST");
    btnDbCrList.setText("DEBIT / CREDIT LIST");
    btnDbCrList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDbCrList_actionPerformed(e);
      }
    });
    btnDbCrList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDbCrList.setBounds(new Rectangle(94, 387, 322, 32));
    btnDbCrList.setBackground(Color.white);
    bntNortonTemplate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bntNortonTemplate_actionPerformed(e);
      }
    });
    bntNortonTemplate.setText("NORTON TEMPLATE");
    bntNortonTemplate.setFont(new java.awt.Font("Dialog", 1, 11));
    bntNortonTemplate.setBounds(new Rectangle(433, 96, 322, 32));
    bntNortonTemplate.setBackground(Color.white);
    btnDbCrBuyerNameMtn.setBackground(Color.white);
    btnDbCrBuyerNameMtn.setBounds(new Rectangle(433, 146, 322, 32));
    btnDbCrBuyerNameMtn.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDbCrBuyerNameMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDbCrBuyerNameMtn_actionPerformed(e);
      }
    });
    btnDbCrBuyerNameMtn.setText("BUYER NAME MAINTAIN");
    btnStatementAcc.setBackground(Color.white);
    btnStatementAcc.setBounds(new Rectangle(95, 436, 322, 32));
    btnStatementAcc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStatementAcc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStatementAcc_actionPerformed(e);
      }
    });
    btnStatementAcc.setText("MAKER STATEMENT OF ACCOUNT");
    btnSrnHeadStylePoModification.setText("SRN HEAD & STYLE / PO Modification");
    btnSrnHeadStylePoModification.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSrnHeadStylePoModification_actionPerformed(e);
      }
    });
    btnSrnHeadStylePoModification.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSrnHeadStylePoModification.setBounds(new Rectangle(433, 196, 322, 32));
    btnSrnHeadStylePoModification.setBackground(Color.white);
    btnDbSeqList.setBackground(Color.white);
    btnDbSeqList.setBounds(new Rectangle(433, 246, 322, 32));
    btnDbSeqList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDbSeqList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDbSeqList_actionPerformed(e);
      }
    });
    btnDbSeqList.setText("DEBITNOTE SEQUENCIAL LIST");
    btnDbCrRptByMonth.setText("DB/CR PRT BY MONTH/SUMMARY");
    btnDbCrRptByMonth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDbCrRptByMonth_actionPerformed(e);
      }
    });
    btnDbCrRptByMonth.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDbCrRptByMonth.setBounds(new Rectangle(434, 294, 322, 32));
    btnDbCrRptByMonth.setBackground(Color.white);
    btnStatementAcc4Buyer.setText("BUYER STATEMENT OF ACCOUNT");
    btnStatementAcc4Buyer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStatementAcc4Buyer_actionPerformed(e);
      }
    });
    btnStatementAcc4Buyer.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStatementAcc4Buyer.setBounds(new Rectangle(94, 485, 322, 32));
    btnStatementAcc4Buyer.setBackground(Color.white);
    btnStatementAcc4BuyerHK.setBackground(Color.white);
    btnStatementAcc4BuyerHK.setBounds(new Rectangle(434, 338, 322, 32));
    btnStatementAcc4BuyerHK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStatementAcc4BuyerHK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStatementAcc4BuyerHK_actionPerformed(e);
      }
    });
    btnStatementAcc4BuyerHK.setText("NT STATEMENT");
    btnRptWithCommDtlList.setText("DEBIT NOTE WITH COMM DETAIL LIST");
    btnRptWithCommDtlList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptWithCommDtlList_actionPerformed(e);
      }
    });
    btnRptWithCommDtlList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptWithCommDtlList.setBounds(new Rectangle(434, 386, 322, 32));
    btnRptWithCommDtlList.setBackground(Color.white);
    btnRptWithCommDtlList1.setBackground(Color.white);
    btnRptWithCommDtlList1.setBounds(new Rectangle(435, 436, 322, 32));
    btnRptWithCommDtlList1.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptWithCommDtlList1.setToolTipText("");
    btnRptWithCommDtlList1.setVerifyInputWhenFocusTarget(true);
    btnRptWithCommDtlList1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptWithCommDtlList1_actionPerformed(e);
      }
    });
    btnRptWithCommDtlList1.setText("DEBIT NOTE BUYER COMM LIST");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQryPayDtl, null);
    this.add(btnQryAddDebitNote, null);
    this.add(btnQryRpt_PaidFtyFee, null);
    this.add(btnExpSrn2Dbnt, null);
    this.add(btnExpSrnFromMkrDiscount, null);
    this.add(btnQryDDK, null);
    this.add(btnDdkChkBatchList, null);
    this.add(btnDbCrList, null);
    this.add(btnBuyerCommNotYetExportedDB, null);
    this.add(bntNortonTemplate, null);
    this.add(btnExit, null);
    this.add(btnDbCrBuyerNameMtn, null);
    this.add(btnSrnHeadStylePoModification, null);
    this.add(btnDbSeqList, null);
    this.add(btnStatementAcc4Buyer, null);
    this.add(btnDbCrRptByMonth, null);
    this.add(btnRptWithCommDtlList, null);
    this.add(btnStatementAcc4BuyerHK, null);
    this.add(btnStatementAcc, null);
    this.add(btnRptWithCommDtlList1, null);
    if(newtimes.accounting.debit_note.Constans.hmBuyerMakerType==null){
      newtimes.accounting.debit_note.Constans.hmBuyerMakerType=new java.util.HashMap();
      newtimes.accounting.debit_note.Constans.hmBuyerMakerType.put("BUYER",String.valueOf(newtimes.preproduction.buyermakerselect.SelectBuyerMaker.TYPE_BUYER));
      newtimes.accounting.debit_note.Constans.hmBuyerMakerType.put("MAKER",String.valueOf(newtimes.preproduction.buyermakerselect.SelectBuyerMaker.TYPE_MAKER));
      newtimes.accounting.debit_note.Constans.hmBuyerMakerType.put("OTHER",String.valueOf(newtimes.preproduction.buyermakerselect.SelectBuyerMaker.TYPE_OTHERS));
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnQryAddDebitNote_actionPerformed(ActionEvent e) {
    try{
      newtimes.accounting.debit_note.Constans.PNL2QUERY=null;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrShowQryGui());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnQryPayDtl_actionPerformed(ActionEvent e) {
    try{
      newtimes.accounting.debit_note.Constans.PNL2QUERY_PAY_DETAIL=null;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrShowQryGui4PayDtl());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnQryRpt_PaidFtyFee_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrQryRpt4PaidFtyFee());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnExpSrn2Dbnt_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrShowExportSrn2Debitnote());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnBuyerCommNotYetExportedDB_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrShowQryUnExportedBuyerComm());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnExpSrnFromMkrDiscount_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrShowExportSrnMkr2Debitnote());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnQryDDK_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrQryDDK());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnDdkChkBatchList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrDdkChkBatchList());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnDbCrList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrDbCrListRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnSrnHeadBasicMtn_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.local_voucher.TgrSrnHeadBasicFields()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void bntNortonTemplate_actionPerformed(ActionEvent e) {
   try{
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrNortonTemplate()
     );
   }catch(Exception exp){

   }
  }
  void btnDbCrBuyerNameMtn_actionPerformed(ActionEvent e) {
     DlgListDebitNoteBuyerName dlg=new DlgListDebitNoteBuyerName(util.PublicVariable.APP_FRAME,"BUYER NAME",true);
     dlg.setSize(460,485);
     exgui.UIHelper.setToScreenCenter(dlg);
     dlg.show();
  }
  void btnStatementAcc_actionPerformed(ActionEvent e) {
    try{
      PnlStatementOfAccounting.isMakerStatmentRpt=true;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrStatementAcc()
      );
    }catch(Exception exp){

    }


  }
  void btnSrnHeadStylePoModification_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.local_voucher.TgrSrnHeadBasicFields()
      );
    }catch(Exception exp){

    }

  }
  void btnDbSeqList_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrDbSeqListRpt()
      );
    }catch(Exception exp){

    }

  }
  void btnDbCrRptByMonth_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrDbCrRptByMonth()
      );
    }catch(Exception exp){

    }

  }
  void btnStatementAcc4Buyer_actionPerformed(ActionEvent e) {
    try{
      PnlStatementOfAccounting.isMakerStatmentRpt=false;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrStatementAcc()
      );
    }catch(Exception exp){

    }

  }
  void btnStatementAcc4BuyerHK_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrStatementAccHK()
      );
    }catch(Exception exp){

    }

  }
  void btnRptWithCommDtlList_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrRptWithCommDtlList()
      );
    }catch(Exception exp){

    }

  }
  void btnRptWithCommDtlList1_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrRptBuyerCommList()
      );
    }catch(Exception exp){

    }


  }
}
