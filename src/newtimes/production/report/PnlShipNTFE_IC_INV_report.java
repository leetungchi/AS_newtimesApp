package newtimes.production.report ;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlShipNTFE_IC_INV_report
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtSRN = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JRadioButton rdoINV = new JRadioButton();
  JRadioButton rdoIC = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JButton btnQry = new JButton();
  JPanel pnlPlaceView;
  JButton btnSyncPrice = new JButton();
  String orgSrn=null;
  JRadioButton rdoBuyerPrx = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JRadioButton rdoMakerPrx = new JRadioButton();
  JPanel PnlByrFtyLcNo = new JPanel();
  TitledBorder titledBorder1;
  JRadioButton rdoUsingBuyerLcNo = new JRadioButton();
  JRadioButton rdoUsingFtyLcNo = new JRadioButton();
  ButtonGroup buttonGroup3 = new ButtonGroup();
  JRadioButton rdoBuyerInvoice = new JRadioButton();
  public PnlShipNTFE_IC_INV_report(JPanel pnl,String SRN) {
      this(pnl);
      orgSrn=SRN;
  }
  public PnlShipNTFE_IC_INV_report(JPanel pnl) {
  try {
    //jbInit();
    pnlPlaceView=pnl;
  }
  catch(Exception ex) {
    ex.printStackTrace();
  }
}


 public void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134)),"");
    blueBkgWhiteCharLabel1.setText("INVOICE / I.C. LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 17, 800, 25));
    this.setLayout(null);
    txtSRN.setText("");
    txtSRN.setBounds(new Rectangle(572, 54, 205, 23));
    blueBkgWhiteCharLabel2.setText(" SRN NO.");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(490, 54, 83, 23));
    rdoINV.setBackground(new Color(202, 202, 224));
    rdoINV.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoINV.setSelected(true);
    rdoINV.setText("INVOICE");
    rdoINV.setBounds(new Rectangle(26, 63, 109, 19));
    rdoIC.setBackground(new Color(202, 202, 224));
    rdoIC.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoIC.setSelected(true);
    rdoIC.setText("IC");
    rdoIC.setBounds(new Rectangle(26, 85, 63, 25));
    btnQry.setBounds(new Rectangle(645, 91, 131, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    rdoBuyerPrx.setBackground(new Color(202, 202, 224));
    rdoBuyerPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoBuyerPrx.setSelected(true);
    rdoBuyerPrx.setText("Buyer Prx.");
    rdoBuyerPrx.setBounds(new Rectangle(154, 58, 111, 21));
    rdoMakerPrx.setBounds(new Rectangle(274, 58, 111, 21));
    rdoMakerPrx.setText("Maker Prx.");
    rdoMakerPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoMakerPrx.setBackground(new Color(202, 202, 224));
    PnlByrFtyLcNo.setBackground(new Color(202, 202, 224));
    PnlByrFtyLcNo.setBorder(titledBorder1);
    PnlByrFtyLcNo.setBounds(new Rectangle(283, 87, 337, 29));
    PnlByrFtyLcNo.setLayout(null);
    rdoUsingBuyerLcNo.setBackground(new Color(202, 202, 224));
    rdoUsingBuyerLcNo.setText("Use Buyer L/C No");
    rdoUsingBuyerLcNo.setBounds(new Rectangle(11, 1, 128, 25));
    rdoUsingFtyLcNo.setBounds(new Rectangle(191, 2, 128, 25));
    rdoUsingFtyLcNo.setText("Use Fty L/C No");
    rdoUsingFtyLcNo.setBackground(new Color(202, 202, 224));
    rdoUsingBuyerLcNo.setSelected(true);
    rdoBuyerInvoice.setSelected(true);
    rdoBuyerInvoice.setBounds(new Rectangle(100, 85, 151, 25));
    rdoBuyerInvoice.setText("INVOICE (BUYER INV#)");
    rdoBuyerInvoice.setSelected(true);
    rdoBuyerInvoice.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoBuyerInvoice.setBackground(new Color(202, 202, 224));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(rdoIC, null);
    this.add(rdoINV, null);
    buttonGroup1.add(rdoINV);
    buttonGroup1.add(rdoIC);
    buttonGroup1.add(rdoBuyerInvoice);
    genDataBindObj();
    txtSRN.addFocusListener(new xxFks());
    buttonGroup2.add(rdoBuyerPrx);
    buttonGroup2.add(rdoMakerPrx);
    PnlByrFtyLcNo.add(rdoUsingFtyLcNo, null);
    PnlByrFtyLcNo.add(rdoUsingBuyerLcNo, null);
    this.add(rdoBuyerInvoice, null);

    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      this.add(blueBkgWhiteCharLabel2, null);
      this.add(txtSRN, null);
      this.add(btnQry, null);
      this.add(rdoBuyerPrx, null);
      this.add(rdoMakerPrx, null);
      this.add(PnlByrFtyLcNo, null);
    }
    buttonGroup3.add(rdoUsingBuyerLcNo);
    buttonGroup3.add(rdoUsingFtyLcNo);
    if(util.PublicVariable.OPERATTING_CENTER.equals("BW")){
     rdoIC.setSelected(true);
    }
  }
  public class xxFks implements java.awt.event.FocusListener{
    public void focusGained(java.awt.event.FocusEvent fe) {
      txtSRN.selectAll();
    }
    public void focusLost(java.awt.event.FocusEvent fe) {

    }

  }
  public void genDataBindObj(){
    try{
      dataBindComps.clear();
      Object chkSrn = CellFormat.getOrdinaryField(12);
      DataBindTextWithChecker srnField = new DataBindTextWithChecker(txtSRN, "P_SRN_NO",
          orgSrn, 13,
          (Object2String)chkSrn,
          (CellTxtEditorFormat)chkSrn);
      dataBindComps.add(srnField);
    }catch(Exception epx){
      epx.printStackTrace();
    }
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    if(rdoBuyerPrx.isSelected()){
      hm.put("P_BUYER_MAKER","BUYER");
    }else{
      hm.put("P_BUYER_MAKER","MAKER");
    }


    if(rdoIC.isSelected()){
      if(rdoUsingBuyerLcNo.isSelected()){
        hm.put("P_BYR_FTY_LC","BYR");
      }else{
       hm.put("P_BYR_FTY_LC","FTY");
      }
      reportName="HK_IC.rpt";
      if("PW".equals(util.PublicVariable.OPERATTING_CENTER)){
        reportName="HK_PW_IC.rpt";
      }else if("BW".equals(util.PublicVariable.OPERATTING_CENTER)){
        reportName="HK_BW_IC.rpt";
      }else if("NTD".equals(util.PublicVariable.OPERATTING_CENTER)){
        reportName="HK_DEP_IC.rpt";
      }
    }else if(rdoBuyerInvoice.isSelected()){
      reportName="HK_FE_BUY_INV.rpt";
    }else{
      reportName="HK_FE_INV.rpt";
    }
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
   try{
    if(txtSRN.getText().trim().length()<7){
      if(txtSRN.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("Numeric Part Of SRN is 6 Digits Length",
                                               "Numeric Part Of SRN is 6 Digits Length");
        return;
      }
        String srn = newtimes.shipping_admin.ShippingAdmin_Const.
            completeSrnByNum(txtSRN.getText().trim());
        if (srn == null) {
             exgui.verification.VerifyLib.showAlert("No Such SRN","No Such SRN");
             return;
        }
        txtSRN.setText(srn);
    }
   }catch(Exception exp){
     exp.printStackTrace();
   }
   JButtonQueryButtonAction(null);
  }

  protected void generateReport(java.util.HashMap paraHm,String reportName)throws Exception{
   try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer;
    newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,reportName,paraHm);
    viewer.setHasGroupTree(false);
    viewer.start();
    pnlPlaceView.removeAll();
    pnlPlaceView.setLayout(new java.awt.BorderLayout());
    pnlPlaceView.add(viewer);
    pnlPlaceView.repaint();
    pnlPlaceView.validate();
  }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }

 }

}
