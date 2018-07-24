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

public class Pnl_Shipping_Dep_Report_FunList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnShipPending = new JButton();
  JButton btnExit = new JButton();
  JButton btnShippingScColorBalance = new JButton();
  JButton btnPackingReports = new JButton();
  JButton btnShipInvoiceList = new JButton();
  JButton btnShipWorkList = new JButton();
  JButton btnShipUsrWorkLoad = new JButton();
  JButton btnCashApply = new JButton();
  JButton btnTotalShipEnquiry = new JButton();
  JButton btnTotalShipLackDetail = new JButton();
  JButton btnWarnning4MkrBuyerPrx = new JButton();
  JButton btnInqryCustPoInfor = new JButton();
  JButton btnCustPoList = new JButton();
  JButton btnShipAdv = new JButton();
  JButton btnCommInv = new JButton();
  JButton btnTpCommInv = new JButton();
  JButton btnJLpoqty = new JButton();
  public Pnl_Shipping_Dep_Report_FunList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("SHIPPING DEPARTMENT REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 0, 804, 32));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnShipPending.setText("15 DAYS PENDING REPORT");
    btnShipPending.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipPending_actionPerformed(e);
      }
    });
    btnShipPending.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipPending.setBounds(new Rectangle(24, 35, 356, 33));
    btnShipPending.setBackground(Color.white);
    btnExit.setBounds(new Rectangle(361, 541, 76, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnShippingScColorBalance.setBackground(Color.white);
    btnShippingScColorBalance.setBounds(new Rectangle(24, 92, 356, 33));
    btnShippingScColorBalance.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShippingScColorBalance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShippingScColorBalance_actionPerformed(e);
      }
    });
    btnShippingScColorBalance.setText("S/C COLOR BALANCE QTY LIST");
    btnPackingReports.setText("SHIPMENT ADVICE / COMMERCIAL INVOICE / PACKING LIST");
    btnPackingReports.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPackingReports_actionPerformed(e);
      }
    });
    btnPackingReports.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPackingReports.setBounds(new Rectangle(163, 422, 459, 33));
    btnPackingReports.setBackground(Color.white);
    btnShipInvoiceList.setBackground(Color.white);
    btnShipInvoiceList.setBounds(new Rectangle(24, 148, 356, 33));
    btnShipInvoiceList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipInvoiceList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipInvoiceList_actionPerformed(e);
      }
    });
    btnShipInvoiceList.setText("SHIPMENT INVOICE LIST");
    btnShipWorkList.setText("SHIPPING DEPT WORK LOAD");
    btnShipWorkList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipWorkList_actionPerformed(e);
      }
    });
    btnShipWorkList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipWorkList.setBounds(new Rectangle(24, 205, 356, 33));
    btnShipWorkList.setBackground(Color.white);
    btnShipUsrWorkLoad.setBackground(Color.white);
    btnShipUsrWorkLoad.setBounds(new Rectangle(24, 262, 356, 33));
    btnShipUsrWorkLoad.setFont(new java.awt.Font("Dialog", 1, 11));
    btnShipUsrWorkLoad.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShipUsrWorkLoad_actionPerformed(e);
      }
    });
    btnShipUsrWorkLoad.setText("SHIPPING DEPT USER WORK LOAD");
    btnCashApply.setText("CASH APPLY FORM");
    btnCashApply.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCashApply_actionPerformed(e);
      }
    });
    btnCashApply.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCashApply.setBounds(new Rectangle(24, 318, 356, 33));
    btnCashApply.setBackground(Color.white);

    btnTotalShipEnquiry.setBackground(Color.white);
    btnTotalShipEnquiry.setBounds(new Rectangle(24, 375, 356, 33));
    btnTotalShipEnquiry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnTotalShipEnquiry.setText("Total Ship Enquiry");
    btnTotalShipEnquiry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTotalShipEnquiry_actionPerformed(e);
      }
    });
    btnTotalShipLackDetail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTotalShipLackDetail_actionPerformed(e);
      }
    });
    btnTotalShipLackDetail.setText("SRN WITHOUT DETAIL");
    btnTotalShipLackDetail.setFont(new java.awt.Font("Dialog", 1, 11));
    btnTotalShipLackDetail.setBounds(new Rectangle(24, 431, 356, 33));
    btnTotalShipLackDetail.setBackground(Color.white);

    btnWarnning4MkrBuyerPrx.setBackground(Color.white);
    btnInqryCustPoInfor.setBackground(Color.white);

    btnWarnning4MkrBuyerPrx.setBounds(new Rectangle(24, 488, 356, 33));
    btnInqryCustPoInfor.setBounds(new Rectangle(474, 35, 297, 33));

    btnWarnning4MkrBuyerPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInqryCustPoInfor.setFont(new java.awt.Font("Dialog", 1, 11));

    btnWarnning4MkrBuyerPrx.setText("WARNING FOR MAKER PRICE EQUAL OR OVER BUYER PRICE");
    btnInqryCustPoInfor.setText("INQUERY CUST P.O. INFORMATION");


    btnWarnning4MkrBuyerPrx.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnWarnning4MkrBuyerPrx_actionPerformed(e);
      }
    });


    if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
      btnInqryCustPoInfor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
          try{
            processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new TgrRptInqCustPoInfor());
          }catch(Exception exp){
            exp.printStackTrace();
          }
      }
      });
      this.add(btnInqryCustPoInfor, null);
  }


    if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
     this.add(btnWarnning4MkrBuyerPrx, null);
    }
    btnCustPoList.setText("CUST. PO. LIST");
    btnCustPoList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCustPoList_actionPerformed(e);
      }
    });
    btnCustPoList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCustPoList.setBounds(new Rectangle(474, 92, 297, 33));
    btnCustPoList.setBackground(Color.white);
    this.add(btnExit, null);

    btnShipAdv.setText("SHIPPING ADVICE");
   btnShipAdv.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(ActionEvent e) {
       btnShipAdv_actionPerformed(e);
     }
   });
   btnShipAdv.setFont(new java.awt.Font("Dialog", 1, 11));
   btnShipAdv.setBounds(new Rectangle(474, 148, 297, 33));
   btnShipAdv.setBackground(Color.white);

  btnCommInv.setText("J.L. COMMERCIAL  INVOICE");
  btnCommInv.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      btnCommInv_actionPerformed(e);
    }
  });
  btnCommInv.setFont(new java.awt.Font("Dialog", 1, 11));
  btnCommInv.setBounds(new Rectangle(474, 262, 297, 33));
  btnCommInv.setBackground(Color.white);

  btnJLpoqty.setText("J.L. PO Item-ID QTY");
   btnJLpoqty.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(ActionEvent e) {
       btnJLpoqty_actionPerformed(e);
     }
   });
   btnJLpoqty.setFont(new java.awt.Font("Dialog", 1, 11));
   btnJLpoqty.setBounds(new Rectangle(474, 317, 297, 33));
   btnJLpoqty.setBackground(Color.white);


  btnTpCommInv.setText("COMMERCIAL  INVOICE");
  btnTpCommInv.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      btnTpCommInv_actionPerformed(e);
    }
  });
  btnTpCommInv.setFont(new java.awt.Font("Dialog", 1, 11));
  btnTpCommInv.setBounds(new Rectangle(474, 207, 297, 33));
  btnTpCommInv.setBackground(Color.white);





    this.add(btnTotalShipEnquiry, null);
    this.add(btnShippingScColorBalance, null);
    this.add(btnShipInvoiceList, null);
    this.add(btnShipWorkList, null);
    this.add(btnShipUsrWorkLoad, null);
    this.add(btnCashApply, null);
    this.add(btnTotalShipLackDetail, null);
    this.add(blueBkgWhiteCharLabel1, null);
    //this.add(btnWarnning4MkrBuyerPrx, null);
    this.add(btnShipPending, null);
    if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
      this.add(btnCustPoList, null);
      this.add(btnShipAdv, null);
      this.add(btnCommInv, null);
      this.add(btnTpCommInv, null);
      this.add(btnJLpoqty, null);
    }
    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      this.add(btnNthkDiamondSummary, null);
    }*/
    //this.add(btnPackingReports, null);
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


  void btnShipPending_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenRptShipPendding());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnShippingScColorBalance_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenScColorBlcRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  void btnPackingReports_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenPackingReport());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnShipInvoiceList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenShipInvList());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnShipWorkList_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenShipWorkLoadRpt());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnShipUsrWorkLoad_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenShipUserWorkLoad());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void btnCashApply_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrToGenCashApply());
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }

  void btnTotalShipEnquiry_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
     newtimes.nthk_accounting_enqry.EnqryConstants.STORED_PNL_4_QRY=null;
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
     );
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.nthk_accounting_enqry.TgrShowQryGui());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }
  void btnTotalShipLackDetail_actionPerformed(ActionEvent e) {
    /*
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
     );
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.nthk_accounting_enqry.TgrListShipLackDetail());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
    */
   try{
   processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.TgrSrnNoDtl());
   }catch(Exception exp){
     exp.printStackTrace();
   }

  }
  void btnWarnning4MkrBuyerPrx_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
        newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
      );
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.production.report.TgrWarnning4MkrPrxBuyerPrx());

    }catch(Exception exp){
      exp.printStackTrace();
      //throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }

  void btnCustPoList_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.report.TgrRptCustPoList());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();

    }
  }
  void btnShipAdv_actionPerformed(ActionEvent e) {
   newtimes.production.ProdMaintain_Properties.setWaitCursor();
   try{
   processhandler.template.Properties.getCenteralControler().doCommandExecute(
     new newtimes.production.report.TgrRptShipAdv());
   }catch(Exception ie){
     ie.printStackTrace();
   }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();

   }
 }
 void btnCommInv_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.report.TgrRptCommInv());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();

    }
  }
  void btnJLpoqty_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.report.TgrRptJLpoqty());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();

    }
  }


  void btnTpCommInv_actionPerformed(ActionEvent e) {
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.production.report.TgrTpRptCommInv());
      }catch(Exception ie){
        ie.printStackTrace();
      }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();

      }
    }



}
