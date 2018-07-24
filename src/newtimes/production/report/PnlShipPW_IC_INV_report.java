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
import javax.swing.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlShipPW_IC_INV_report
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
  String shipDimCuft=null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxFormSelection =null;
  String form_name[]={
      "ORIGINAL",
      "ORIGINAL (WITH COMM)",
      //"ACE STYLE BOUTIQUE",
      "AIDAN INDUSTRIES",
      "ALICE + OLIVIA",
      "AMERICAN EAGLE",
      "CAROLE HOCHMAN DESIGNS",
      "CHRISTIAN CASEY",
      "MAST INDUSTRIES",
      "VICTORIA'S SECRET DIRECT"
  };
  String report_name[]={
      "INV_1.RPT",
      "INV_1X.RPT",
      //"INV_3.RPT",
      "INV_4.RPT",
      "INV_5.RPT",
      "INV_6.RPT",
      "INV_3.RPT",
      "PWH_INV.RPT",
      "INV_2.RPT",
      "INV_2.RPT"
  };
  JRadioButton rdF4 = new JRadioButton();

  public PnlShipPW_IC_INV_report(JPanel pnl,String SRN) {
      this(pnl);
      orgSrn=SRN;
  }
  public PnlShipPW_IC_INV_report(JPanel pnl) {
  try {
    //jbInit();
    java.util.ArrayList al=new java.util.ArrayList();
    for(int i=0;i<report_name.length;i++){
       exgui.ultratable.Wraper4tblCbx
           wrapObj=new exgui.ultratable.Wraper4tblCbx();
       wrapObj.setString(form_name[i]);
       wrapObj.setValue(report_name[i]);
       al.add(wrapObj);
    }
    exgui.ultratable.Wraper4tblCbx[] wrapArr=
        (exgui.ultratable.Wraper4tblCbx[])al.toArray(new exgui.ultratable.Wraper4tblCbx[0]);
    cbxFormSelection=new JComboBox(wrapArr);
    pnlPlaceView=pnl;

  }
  catch(Exception ex) {
    ex.printStackTrace();
  }
}


 public void jbInit() throws Exception {
   /*
    ORIGINAL                 (INV_1.RPT)
    ACE STYLE BOUTIQUE       (INV_3.RPT)
    AIDAN INDUSTRIES         (INV_4.RPT)
    ALICE + OLIVIA           (INV_5.RPT)
    AMERICAN EAGLE           (INV_6.RPT)
    CAROLE HOCHMAN DESIGNS   (INV_3.RPT)
    CHRISTIAN CASEY          (PWH_INV.RPT)
    MAST INDUSTRIES          (INV_2.RPT)
    VICTORIA'S SECRET DIRECT (INV_2.RPT)
    */
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134)),"");
    blueBkgWhiteCharLabel1.setText("INVOICE / I.C. LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 17, 800, 25));
    this.setLayout(null);
    txtSRN.setText("");
    txtSRN.setBounds(new Rectangle(664, 54, 113, 23));
    blueBkgWhiteCharLabel2.setText(" SRN NO.");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(581, 54, 83, 23));
    rdoINV.setBackground(new Color(202, 202, 224));
    rdoINV.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoINV.setRequestFocusEnabled(true);
    rdoINV.setSelected(false);
    rdoINV.setText("INVOICE");
    rdoINV.setBounds(new Rectangle(3, 62, 82, 19));
    rdoINV.addItemListener(new PnlShipPW_IC_INV_report_rdoINV_itemAdapter(this));
    //rdoINV.addChangeListener(new PnlShipPW_IC_INV_report_rdoINV_changeAdapter(this));
    rdoIC.setBackground(new Color(202, 202, 224));
    rdoIC.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoIC.setSelected(true);
    rdoIC.setText("IC");
    rdoIC.setBounds(new Rectangle(3, 84, 43, 25));
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
    rdoBuyerPrx.setBounds(new Rectangle(89, 58, 111, 21));
    rdoMakerPrx.setBounds(new Rectangle(209, 58, 111, 21));
    rdoMakerPrx.setText("Maker Prx.");
    rdoMakerPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoMakerPrx.setBackground(new Color(202, 202, 224));
    PnlByrFtyLcNo.setBackground(new Color(202, 202, 224));
    PnlByrFtyLcNo.setBorder(titledBorder1);
    PnlByrFtyLcNo.setBounds(new Rectangle(324, 88, 302, 29));
    PnlByrFtyLcNo.setLayout(null);
    rdoUsingBuyerLcNo.setBackground(new Color(202, 202, 224));
    rdoUsingBuyerLcNo.setText("Use Buyer L/C No");
    rdoUsingBuyerLcNo.setBounds(new Rectangle(3, 2, 138, 24));
    rdoUsingFtyLcNo.setBounds(new Rectangle(154, 2, 129, 25));
    rdoUsingFtyLcNo.setText("Use Fty L/C No");
    rdoUsingFtyLcNo.setBackground(new Color(202, 202, 224));
    rdoUsingFtyLcNo.setSelected(true);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(323, 56, 78, 23));
    blueBkgWhiteCharLabel3.setText(" FORM:");
    cbxFormSelection.setBounds(new Rectangle(403, 56, 166, 22));
    rdF4.setBounds(new Rectangle(50, 84, 82, 25));
    rdF4.setText("F4 Form");
    rdF4.setFont(new java.awt.Font("Dialog", 1, 11));
    rdF4.setSelected(false);
    rdF4.setBackground(new Color(202, 202, 224));
    this.add(blueBkgWhiteCharLabel1, null);
    buttonGroup1.add(rdoINV);
    buttonGroup1.add(rdoIC);
    genDataBindObj();
    txtSRN.addFocusListener(new xxFks());
    buttonGroup2.add(rdoBuyerPrx);
    buttonGroup2.add(rdoMakerPrx);
    PnlByrFtyLcNo.add(rdoUsingFtyLcNo, null);
    PnlByrFtyLcNo.add(rdoUsingBuyerLcNo, null);

    this.add(rdoBuyerPrx, null);
    this.add(rdoMakerPrx, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxFormSelection, null);

      this.add(blueBkgWhiteCharLabel2, null);
    this.add(rdoINV, null);
    this.add(rdoIC, null);
      this.add(txtSRN, null);
      this.add(btnQry, null);
    this.add(PnlByrFtyLcNo, null);

    buttonGroup3.add(rdoUsingBuyerLcNo);
    buttonGroup3.add(rdoUsingFtyLcNo);
    buttonGroup1.add(rdF4);
    this.add(rdF4, null);
    if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
        rdF4.setVisible(true);
    }else{
      rdF4.setVisible(false);
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
    if(rdoUsingBuyerLcNo.isSelected()){
        hm.put("P_BYR_FTY_LC","BYR");
    }else{
       hm.put("P_BYR_FTY_LC","FTY");
    }

      if(rdoIC.isSelected()){
        reportName="HK_PW_IC.rpt";
        if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE || (shipDimCuft!=null && shipDimCuft.startsWith("ASN:"))){
          reportName="PRL_IC.rpt";
        }
      }else if(rdF4.isSelected()){
          reportName="PRL_IC_F4.rpt";
      }else{
        reportName=
             (String)
            ((exgui.ultratable.Wraper4tblCbx)cbxFormSelection.getSelectedItem()).getValue();
      }
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
   try{
     String srn=null;

    if(txtSRN.getText().trim().length()<7){
      if(txtSRN.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("Numeric Part Of SRN is 6 Digits Length",
                                               "Numeric Part Of SRN is 6 Digits Length");
        return;
      }

        Record recShipHead=newtimes.shipping_admin.ShippingAdmin_Const.completeSrnByNumRecord(txtSRN.getText().trim());
        if(recShipHead!=null){
           srn=(String)recShipHead.get(0);
           shipDimCuft=(String)recShipHead.get("SHIP_DIM_CUFT");
           if(shipDimCuft!=null && shipDimCuft.startsWith("ASN:")){
             rdF4.setVisible(true);
           }else{
             rdF4.setVisible(false);
           }
        }


        if (srn == null) {
             exgui.verification.VerifyLib.showAlert("No Such SRN","No Such SRN");
             return;
        }
        txtSRN.setText(srn);
    }else{
      if("NTD".equals(util.PublicVariable.OPERATTING_CENTER)){
        /*
        System.out.println("record ship head is =======================\n" +
                           newtimes.shipping_admin.ShippingAdmin_Const.
                           SHIPPING_EDITING_HEAD_RECORD.toString());
        shipDimCuft = (String)newtimes.shipping_admin.ShippingAdmin_Const.
            SHIPPING_EDITING_HEAD_RECORD.get("SHIP_DIM_CUFT");
        */
       /*
        if(shipDimCuft!=null && shipDimCuft.startsWith("ASN:")){
          rdF4.setVisible(true);
        }else{
          rdF4.setVisible(false);
        }
        */
      }
      /*
      if("NTD".endsWith(util.PublicVariable.OPERATTING_CENTER)){
        if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
          shipDimCuft="ASN:xxx";
        }else{
           shipDimCuft=null;
        }
      }
      */
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


  void rdoINV_itemStateChanged(ItemEvent e) {
    if(rdoINV.isSelected()){
     rdoBuyerPrx.setSelected(true);
     rdoUsingBuyerLcNo.setSelected(true);
   }else{
     rdoBuyerPrx.setSelected(true);
     rdoUsingFtyLcNo.setSelected(true);
   }


  }

}


class PnlShipPW_IC_INV_report_rdoINV_itemAdapter implements java.awt.event.ItemListener {
  PnlShipPW_IC_INV_report adaptee;

  PnlShipPW_IC_INV_report_rdoINV_itemAdapter(PnlShipPW_IC_INV_report adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.rdoINV_itemStateChanged(e);
  }
}
