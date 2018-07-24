package newtimes.shipping;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ShippingMenu extends JPanel {
  Frame1 frame;
  JButton butn_Commerical_Invoice = new JButton();
  JTextField textAreaStatus = new JTextField();
  JButton butn_Shipment_Info = new JButton();
  JButton butn_PreAlert_Daily_Report = new JButton();
  JLabel labelTitle = new JLabel();
  JLabel jLabel1 = new JLabel();
  JButton butnExit = new JButton();
  JButton butn_Shipping = new JButton();
  JButton butnLogout = new JButton();
  JButton btnEditShipHeadDetail = new JButton();
  JButton btnPackingReports = new JButton();
  JButton btnNTFE_INV_IC_Report = new JButton();
  JButton btnPrintShipDoc = new JButton();
  JButton btnUploadEDI = new JButton();
  JButton btnUploadAsn = new JButton();
  JButton btnEditShipHeadDetail4Loran = new JButton();
  JButton btnBrandBaseStatus = new JButton();

  public ShippingMenu(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    butnLogout.setText("Logout");
    butnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogout_actionPerformed(e);
      }
    });
    butnLogout.setForeground(Color.darkGray);
    butnLogout.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogout.setBounds(new Rectangle(284, 481, 80, 25));
    butnLogout.setBackground(Color.lightGray);
    butn_Shipping.setText(" 1.  Shipping Maintain");
    butn_Shipping.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Shipping_actionPerformed(e);
      }
    });
    butn_Shipping.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Shipping.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Shipping.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Shipping.setBounds(new Rectangle(210, 370, 381, 23));
    butn_Shipping.setBackground(Color.white);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(426, 481, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jLabel1.setBounds(new Rectangle(114, 51, 566, 24));
    jLabel1.setText("      ============  Shipping Maintain  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setText("title");
    butn_PreAlert_Daily_Report.setText("   Pre-Alert Daily Report");
    butn_PreAlert_Daily_Report.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_PreAlert_Daily_Report_actionPerformed(e);
      }
    });
    butn_PreAlert_Daily_Report.setHorizontalAlignment(SwingConstants.LEFT);
    butn_PreAlert_Daily_Report.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_PreAlert_Daily_Report.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_PreAlert_Daily_Report.setBounds(new Rectangle(210, 275, 381, 23));
    butn_PreAlert_Daily_Report.setBackground(Color.white);
    butn_Shipment_Info.setText("   Shipment Information");
    butn_Shipment_Info.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Shipment_Info_actionPerformed(e);
      }
    });
    butn_Shipment_Info.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Shipment_Info.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Shipment_Info.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Shipment_Info.setBounds(new Rectangle(210, 223, 381, 23));
    butn_Shipment_Info.setBackground(Color.white);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    butn_Commerical_Invoice.setText("   Commerical Invoice");
    butn_Commerical_Invoice.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Commerical_Invoice_actionPerformed(e);
      }
    });
    butn_Commerical_Invoice.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Commerical_Invoice.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Commerical_Invoice.setDebugGraphicsOptions(0);
    butn_Commerical_Invoice.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Commerical_Invoice.setBounds(new Rectangle(210, 327, 381, 23));
    butn_Commerical_Invoice.setBackground(Color.white);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    btnEditShipHeadDetail.setBackground(Color.white);
    btnEditShipHeadDetail.setBounds(new Rectangle(179, 97, 459, 33));
    btnEditShipHeadDetail.setFont(new java.awt.Font("Dialog", 1, 12));
    btnEditShipHeadDetail.setBorder(BorderFactory.createRaisedBevelBorder());
    btnEditShipHeadDetail.setMaximumSize(new Dimension(121, 22));
    btnEditShipHeadDetail.setMinimumSize(new Dimension(121, 22));
    btnEditShipHeadDetail.setHorizontalAlignment(SwingConstants.CENTER);
    btnEditShipHeadDetail.setHorizontalTextPosition(SwingConstants.TRAILING);
    newtimes.shipping_admin.ShippingAdmin_Const.PNL_QRY_SHIPMASTER_CONDITIONS=null;
    btnEditShipHeadDetail.setText("Shipping Maintain");
    btnEditShipHeadDetail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditShipHeadDetail_actionPerformed(e);
      }
    });
    //this.add(butn_Commerical_Invoice, null);
    btnPackingReports.setText("SHIPMENT ADVICE / COMMERCIAL INVOICE / PACKING LIST");
    btnPackingReports.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPackingReports_actionPerformed(e);
      }
    });
    btnPackingReports.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPackingReports.setBounds(new Rectangle(135, 352, 388, 33));
    btnPackingReports.setBackground(Color.white);
    btnNTFE_INV_IC_Report.setBackground(Color.white);
    btnNTFE_INV_IC_Report.setBounds(new Rectangle(135, 410, 380, 33));
    btnNTFE_INV_IC_Report.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNTFE_INV_IC_Report.setText("INVOICE & I.C. FOR NTFE");
    btnNTFE_INV_IC_Report.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNTFE_INV_IC_Report_actionPerformed(e);
      }
    });
    btnPrintShipDoc.setBackground(Color.white);
    btnPrintShipDoc.setBounds(new Rectangle(179, 182, 459, 33));
    btnPrintShipDoc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrintShipDoc.setText("Print Shipping Document");
    btnPrintShipDoc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrintShipDoc_actionPerformed(e);
      }
    });


    btnUploadEDI.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUploadEDI_actionPerformed(e);
      }
    });
    btnUploadEDI.setText("Upload EDI PO CSV file");
    btnUploadEDI.setHorizontalTextPosition(SwingConstants.TRAILING);
    btnUploadEDI.setHorizontalAlignment(SwingConstants.CENTER);
    btnUploadEDI.setMinimumSize(new Dimension(121, 22));
    btnUploadEDI.setMaximumSize(new Dimension(121, 22));
    btnUploadEDI.setBorder(BorderFactory.createRaisedBevelBorder());
    btnUploadEDI.setFont(new java.awt.Font("Dialog", 1, 12));
    btnUploadEDI.setBounds(new Rectangle(182, 382, 459, 33));
    btnUploadEDI.setBackground(Color.white);
    btnUploadAsn.setBackground(Color.white);
    btnUploadAsn.setBounds(new Rectangle(182, 436, 459, 33));
    btnUploadAsn.setFont(new java.awt.Font("Dialog", 1, 12));
    btnUploadAsn.setBorder(BorderFactory.createRaisedBevelBorder());
    btnUploadAsn.setMaximumSize(new Dimension(121, 22));
    btnUploadAsn.setMinimumSize(new Dimension(121, 22));
    btnUploadAsn.setHorizontalAlignment(SwingConstants.CENTER);
    btnUploadAsn.setHorizontalTextPosition(SwingConstants.TRAILING);
    btnUploadAsn.setText("Upload ASN CSV file");
    btnUploadAsn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUploadAsn_actionPerformed(e);
      }
    });
    btnEditShipHeadDetail4Loran.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditShipHeadDetail4Loran_actionPerformed(e);
      }
    });
    btnEditShipHeadDetail4Loran.setText("Shipping Maintain For LAUREN");
    btnEditShipHeadDetail4Loran.setHorizontalTextPosition(SwingConstants.TRAILING);
    btnEditShipHeadDetail4Loran.setHorizontalAlignment(SwingConstants.CENTER);
    btnEditShipHeadDetail4Loran.setMinimumSize(new Dimension(121, 22));
    btnEditShipHeadDetail4Loran.setMaximumSize(new Dimension(121, 22));
    btnEditShipHeadDetail4Loran.setBorder(BorderFactory.createRaisedBevelBorder());
    btnEditShipHeadDetail4Loran.setFont(new java.awt.Font("Dialog", 1, 12));
    btnEditShipHeadDetail4Loran.setBounds(new Rectangle(179, 143, 459, 33));
    btnEditShipHeadDetail4Loran.setBackground(Color.white);
    btnBrandBaseStatus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBrandBaseStatus_actionPerformed(e);
      }
    });
    btnBrandBaseStatus.setText("BrandBase Status");
    btnBrandBaseStatus.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBrandBaseStatus.setBounds(new Rectangle(179, 266, 459, 33));
    btnBrandBaseStatus.setBackground(Color.white);
    this.add(textAreaStatus, null);
    //this.add(butn_Shipment_Info, null);
    //this.add(butn_PreAlert_Daily_Report, null);
    this.add(labelTitle, null);
    this.add(butnExit, null);
    this.add(butnLogout, null);
    //this.add(btnNTFE_INV_IC_Report, null);
    //this.add(btnPackingReports, null);
    this.add(btnPrintShipDoc, null);
    this.add(btnEditShipHeadDetail, null);
    this.add(jLabel1, null);

    if(util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
      this.add(btnEditShipHeadDetail4Loran, null);
    }
    /*
    if(util.PublicVariable.USER_RECORD.get(0).equals("NDANTHONYLIU") ){
      this.add(btnEditShipHeadDetail4Loran, null);
    }
    */
    if(util.PublicVariable.USER_RECORD.get(0).equals("NDANTHONYLIU") ){
      this.add(btnUploadEDI, null);
      this.add(btnUploadAsn, null);
    }
    //this.add(butn_Shipping, null);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
      if("NTFE".equals(util.PublicVariable.USER_RECORD.get(0)) ||
         "DENNIS".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KANGIECHAN".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WANGIECHAN".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KCHIPANWONG".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WCHIPANWONG".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KPATCHIAING".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WPATCHIANG".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KWINNIEAU".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WWINNIEAU".equals(util.PublicVariable.USER_RECORD.get(0))||
         "SF".equals(util.PublicVariable.USER_RECORD.get(5))||
         "AE".equals(util.PublicVariable.USER_RECORD.get(5))){
         this.add(btnBrandBaseStatus, null);
       }
    }




  }

  void butnExit_actionPerformed(ActionEvent e) {
    newtimes.nthk_enqry.EnqryConstants.STORED_PNL_4_QRY=null;
    newtimes.nthk_enqry.PnlQryGui.isFromProdEnqire=true;
    frame.showPanel(new MainFunction(frame));
  }

  void butnLogout_actionPerformed(ActionEvent e) {
    frame.showPanel(new Login(frame));
  }

  void butn_Shipping_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.shippingmaintain.MasterSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Style_Close_actionPerformed(ActionEvent e) {
    String usrType = null;
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

  void butn_Daily_Shipment_Record_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.accountdepuse.DailyRec4AccountDepUse(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Shipment_Info_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.shipmentinfo.ShipmentInfo(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_PreAlert_Daily_Report_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.prealertdailyreport.PreAlertDailyReport(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Commerical_Invoice_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.invoice.Invoice(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void btnEditShipHeadDetail_actionPerformed(ActionEvent e) {
    try{
      newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE=false;
      newtimes.shipping_admin.ShippingAdmin_Const.INIT_ASN_CODE=null;
        //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
        newtimes.production.ProdMaintain_Properties.setWaitCursor();
        newtimes.shipping_admin.ShippingAdmin_Const.DESTINATIONS=
               newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations();
         processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND);

         processhandler.template.Properties.getCenteralControler().setDataProcesser(null);

         processhandler.template.Properties.getCenteralControler().doCommandExecute(
                new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());

      }catch(Exception eP){
        eP.printStackTrace();
      }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }

  }
  void btnBatchUpdateDel_actionPerformed(ActionEvent e) {
    frame.showPanel(new PnlBatchUpdateDel());
  }
  void btnPackingReports_actionPerformed(ActionEvent e) {
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.shipping.PnlPlacePackingReports pnlSplit=new newtimes.shipping.PnlPlacePackingReports();
    pnlSplit.setPreferredSize(new Dimension(800,580));
    pnlSplit.setSize(800,580);
    javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       newtimes.production.report.PnlQryPackingReports   pnl=new newtimes.production.report.PnlQryPackingReports(tempDownPnl);
       pnl.jbInit();
       pnl.setPreferredSize(new Dimension(800,200));
       pnlSplit.setPanel(pnl,tempDownPnl);
       pnlSplit.setDivision(0.35);
       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(pnlSplit);

       pnlSplit.validate();
       pnlSplit.repaint();
       jframe.repaint();
       jframe.validate();
    }catch(Exception exp){
      exp.printStackTrace();
      //throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
   public static void btnGotoInvIcReport(String SRN){
     try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
     newtimes.shipping.PnlPlacePackingReports pnlSplit=new newtimes.shipping.PnlPlacePackingReports();
     pnlSplit.exitByTrigger=true;//where to from,where to goback
     pnlSplit.setPreferredSize(new Dimension(800,580));
     pnlSplit.setSize(800,580);
     javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();

        tempDownPnl.setLayout(new java.awt.BorderLayout());
        tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
        if(util.PublicVariable.OPERATTING_CENTER.equals("PW")||
           util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
          newtimes.production.report.PnlShipPW_IC_INV_report
              pnl=new newtimes.production.report.PnlShipPW_IC_INV_report (tempDownPnl,SRN);
           pnl.jbInit();
           pnl.setPreferredSize(new Dimension(800,200));
           pnlSplit.setPanel(pnl,tempDownPnl);
        }else{
          newtimes.production.report.PnlShipNTFE_IC_INV_report
              pnl=new newtimes.production.report.PnlShipNTFE_IC_INV_report (tempDownPnl,SRN);
           pnl.jbInit();
           pnl.setPreferredSize(new Dimension(800,200));
           pnlSplit.setPanel(pnl,tempDownPnl);
        }
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(pnlSplit);
        pnlSplit.validate();
        pnlSplit.setDivision(0.25);
        pnlSplit.repaint();
        jframe.repaint();
        jframe.validate();
     }catch(Exception exp){
       exp.printStackTrace();
       //throw new processhandler.commands.CommandException("Error For report engin");
     }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }

   }
   void btnNTFE_INV_IC_Report_actionPerformed(ActionEvent e) {
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.shipping.PnlPlacePackingReports pnlSplit=new newtimes.shipping.PnlPlacePackingReports();
    pnlSplit.setPreferredSize(new Dimension(800,580));
    pnlSplit.setSize(800,580);
    javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());

       if(util.PublicVariable.OPERATTING_CENTER.equals("PW")||
          util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
         newtimes.production.report.PnlShipPW_IC_INV_report
             pnl = new newtimes.production.report.PnlShipPW_IC_INV_report(
             tempDownPnl);
         pnl.jbInit();
         pnl.setPreferredSize(new Dimension(800, 200));
         pnlSplit.setPanel(pnl, tempDownPnl);

       }else{
         newtimes.production.report.PnlShipNTFE_IC_INV_report
             pnl = new newtimes.production.report.PnlShipNTFE_IC_INV_report(
             tempDownPnl);
         pnl.jbInit();
         pnl.setPreferredSize(new Dimension(800, 200));
         pnlSplit.setPanel(pnl, tempDownPnl);

       }


       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(pnlSplit);
       pnlSplit.validate();
       pnlSplit.setDivision(0.25);
       pnlSplit.repaint();
       jframe.repaint();
       jframe.validate();
    }catch(Exception exp){
      exp.printStackTrace();
      //throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void btnPrintShipDoc_actionPerformed(ActionEvent e) {
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        btnPackingReports_actionPerformed(e);
      }else{
        btnNTFE_INV_IC_Report_actionPerformed(e);
      }
  }
  void btnUploadEDI_actionPerformed(ActionEvent e) {
    DlgUploadEDI dlg=new DlgUploadEDI(util.PublicVariable.APP_FRAME,"UPLOAD EDI FILES",true);
    dlg.setSize(550,355);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
  void btnUploadAsn_actionPerformed(ActionEvent e) {
    DlgUploadAsn dlg=new DlgUploadAsn(util.PublicVariable.APP_FRAME,"UPLOAD ASN CSV FILE",true);
    dlg.setSize(550,165);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
  void btnEditShipHeadDetail4Loran_actionPerformed(ActionEvent e) {
    try{
        newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE=true;
        newtimes.shipping_admin.ShippingAdmin_Const.INIT_ASN_CODE=null;
        //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
        newtimes.production.ProdMaintain_Properties.setWaitCursor();
        newtimes.shipping_admin.ShippingAdmin_Const.DESTINATIONS=
               newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations();
         processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND);

         processhandler.template.Properties.getCenteralControler().setDataProcesser(null);

         processhandler.template.Properties.getCenteralControler().doCommandExecute(
                new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());

      }catch(Exception eP){
        eP.printStackTrace();
      }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
  }
  void btnBrandBaseStatus_actionPerformed(ActionEvent e) {
     try{
       newtimes.nthk_enqry.EnqryConstants.STORED_PNL_4_QRY=null;
        newtimes.nthk_enqry.PnlQryGui.isFromProdEnqire=false;
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
               new newtimes.nthk_enqry.TgrShowQryGui4BrandBaseStatus());
     }catch(Exception exp){
       exp.printStackTrace();
     }
  }

}
