package newtimes.production.report;

import java.awt.*;
import java.awt.*;
import exgui.*;
import java.awt.event.*;
import javax.swing.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryPackingReports
  extends AbsQryPanel  {
  //extends JPanel  {
BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
JButton btnPrint = new JButton();
exgui.DataBindJCombobox dbcbxCenter;
BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
JTextField txtSRN = new JTextField();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoShipAdv = new JRadioButton();
  JRadioButton rdoCommInve = new JRadioButton();
  JRadioButton rdoPackingList = new JRadioButton();
  JRadioButton rdoClrBrkDwn_Y = new JRadioButton();
  ButtonGroup buttonGroupPackingList = new ButtonGroup();
  JRadioButton rdoClrBrkDwn_N = new JRadioButton();
  JLabel jLabel1 = new JLabel();
  JButton btnExpPxk2ShipQty = new JButton();
  JPanel pnlPlaceView;
  JButton btnSyncPrice = new JButton();
  JRadioButton rdo1Style1Page_N = new JRadioButton();
  JLabel jLabel2 = new JLabel();
  JRadioButton rdo1Style1Page_Y = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JRadioButton rdoDiamondSummaryReport = new JRadioButton();
  JComboBox cbxConsolidationBox = new JComboBox(new String[]{"Head Load","Middle Load","Tail Load","FCL","LCL"});
  JLabel jLabel3 = new JLabel();
  boolean continueImportEvenPrxDiff=false;
  JRadioButton rdoPackingList2Excel = new JRadioButton();
public PnlQryPackingReports(JPanel pnl) {
  try {
    //jbInit();
    pnlPlaceView=pnl;
  }
  catch(Exception ex) {
    ex.printStackTrace();
  }
}

public void jbInit() throws Exception {
  blueBkgWhiteCharLabel1.setText("S/C COLOR BALANCE QTY LIST");
  blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 23, 801, 37));
  this.setLayout(null);
  btnPrint.setBounds(new Rectangle(666, 102, 127, 27));
  btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
  btnPrint.setText("PRINT");
  btnPrint.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      btnPrint_actionPerformed(e);
    }
  });
  blueBkgWhiteCharLabel3.setText("SRN NO.");
  blueBkgWhiteCharLabel3.setBounds(new Rectangle(7, 71, 183, 21));
  txtSRN.setBounds(new Rectangle(190, 70, 148, 23));
  rdoShipAdv.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoShipAdv.setSelected(true);
    rdoShipAdv.setText("SHIP ADVICE");
    rdoShipAdv.setBounds(new Rectangle(9, 96, 129, 25));
    rdoShipAdv.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rdoShipAdv_itemStateChanged(e);
      }
    });
    rdoCommInve.setBounds(new Rectangle(208, 95, 154, 25));
    rdoCommInve.setText("Commercial Invoice");
    rdoCommInve.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoCommInve.setSelected(true);
    rdoPackingList.setBounds(new Rectangle(438, 95, 129, 21));
    rdoPackingList.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rdoPackingList_itemStateChanged(e);
      }
    });
    rdoPackingList.setText("PACKING LIST");
    rdoPackingList.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPackingList.setSelected(true);
    rdoClrBrkDwn_Y.setBackground(Color.white);
    rdoClrBrkDwn_Y.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoClrBrkDwn_Y.setActionCommand("YES");
    rdoClrBrkDwn_Y.setText("YES");
    rdoClrBrkDwn_Y.setBounds(new Rectangle(544, 120, 59, 26));
    rdoClrBrkDwn_N.setBounds(new Rectangle(601, 120, 59, 26));
    rdoClrBrkDwn_N.setText("NO");
    rdoClrBrkDwn_N.setActionCommand("YES");
    rdoClrBrkDwn_N.setSelected(true);
    rdoClrBrkDwn_N.setBackground(Color.white);
    rdoClrBrkDwn_N.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setOpaque(true);
    jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel1.setText("Color B\'Down");
    jLabel1.setBounds(new Rectangle(460, 120, 85, 26));
    btnExpPxk2ShipQty.setBounds(new Rectangle(12, 125, 147, 26));
    btnExpPxk2ShipQty.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExpPxk2ShipQty.setText("Import Packing Qty");
    btnExpPxk2ShipQty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExpPxk2ShipQty_actionPerformed(e);
      }
    });
    btnSyncPrice.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSyncPrice_actionPerformed(e);
      }
    });
    btnSyncPrice.setText("Update Ship Price By PO Price");
    btnSyncPrice.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSyncPrice.setBounds(new Rectangle(11, 165, 215, 26));
    rdo1Style1Page_N.setFont(new java.awt.Font("Dialog", 1, 11));
    rdo1Style1Page_N.setBackground(Color.white);
    rdo1Style1Page_N.setSelected(true);
    rdo1Style1Page_N.setActionCommand("YES");
    rdo1Style1Page_N.setText("NO");
    rdo1Style1Page_N.setBounds(new Rectangle(601, 150, 59, 26));
    jLabel2.setBounds(new Rectangle(461, 150, 84, 26));
    jLabel2.setText("1 Style 1 Page");
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setBackground(Color.white);
    rdo1Style1Page_Y.setBounds(new Rectangle(544, 150, 59, 26));
    rdo1Style1Page_Y.setText("YES");
    rdo1Style1Page_Y.setActionCommand("YES");
    rdo1Style1Page_Y.setFont(new java.awt.Font("Dialog", 1, 11));
    rdo1Style1Page_Y.setBackground(Color.white);
    rdoDiamondSummaryReport.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDiamondSummaryReport.setText("Diamond Summary Report");
    rdoDiamondSummaryReport.setBounds(new Rectangle(208, 124, 185, 19));
    cbxConsolidationBox.setBounds(new Rectangle(342, 150, 114, 24));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("Consolidation Box");
    jLabel3.setBounds(new Rectangle(238, 150, 112, 22));
    rdoPackingList2Excel.setSelected(true);
    rdoPackingList2Excel.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPackingList2Excel.setText("PACKING LIST (EXCEL)");
    rdoPackingList2Excel.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rdoPackingList2Excel_itemStateChanged(e);
      }
    });
    rdoPackingList2Excel.setBounds(new Rectangle(438, 77, 184, 21));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtSRN, null);
  genDataBindObj();
    buttonGroup1.add(rdoShipAdv);
    buttonGroup1.add(rdoCommInve);
    buttonGroup1.add(rdoDiamondSummaryReport);
    buttonGroup1.add(rdoPackingList);
    buttonGroupPackingList.add(rdoClrBrkDwn_Y);
    this.add(rdoCommInve, null);
    this.add(rdoShipAdv, null);
    this.add(btnExpPxk2ShipQty, null);
    this.add(rdoDiamondSummaryReport, null);
    this.add(cbxConsolidationBox, null);
    this.add(btnPrint, null);
    this.add(rdoPackingList, null);
    this.add(jLabel1, null);
    this.add(rdoClrBrkDwn_N, null);
    this.add(rdoClrBrkDwn_Y, null);
    this.add(jLabel2, null);
    this.add(rdo1Style1Page_Y, null);
    this.add(rdo1Style1Page_N, null);
    //only NTHK center allow to use this function
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      this.add(btnSyncPrice, null);
    }
    buttonGroupPackingList.add(rdoClrBrkDwn_N);
    txtSRN.addFocusListener(new xxFks());
    buttonGroup2.add(rdo1Style1Page_Y);
    buttonGroup2.add(rdo1Style1Page_N);
    this.add(jLabel3, null);
    this.add(rdoPackingList2Excel, null);
    buttonGroup1.add(rdoPackingList2Excel);
    rdoPackingList2Excel.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rdoPackingList_itemStateChanged(e);
      }
    });

}
  public class xxFks implements java.awt.event.FocusListener{
    public void focusGained(java.awt.event.FocusEvent fe) {
      txtSRN.selectAll();
    }
    public void focusLost(java.awt.event.FocusEvent fe) {
       //check srn
       checkSRN();
    }

  }

public void genDataBindObj(){
  try{

  }catch(Exception exp){
    exp.printStackTrace();
  }

  reportName="SHIP_ADV.RPT";
}
void updateConsolidationBox()throws Exception{
   newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
       (newtimesejb.TPE_MIS.TpeMisFuncHome)
       info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
        "newtimesejb.TPE_MIS.TpeMisFunc");
    newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
    java.util.HashMap hm=new java.util.HashMap();
    hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_CONSOLIDATION_BOX");
    hm.put("SRN",txtSRN.getText().trim());
    hm.put("CONSOLIDATION_BOX",cbxConsolidationBox.getSelectedItem());
    ejb.tpeMisFunc(hm);
}
public java.util.HashMap composeParameters(){
  java.util.HashMap hm= new java.util.HashMap();
  hm.put("P_SRN_NO",txtSRN.getText().trim());
  hm.put("P_SRN",txtSRN.getText().trim());
  if(rdoPackingList.isSelected()||rdoPackingList2Excel.isSelected()){
    if(rdoClrBrkDwn_N.isSelected()){
      try {
        hm.put("COL_BDN", "N");
      } catch (Exception ex) {}
    }else{
      hm.put("COL_BDN","Y");
    }
    if(rdo1Style1Page_Y.isSelected()){
      hm.put("P_STY_PAGE","Y");
    }else{
      hm.put("P_STY_PAGE","N");
    }
  }
  hm.put("P_CB",cbxConsolidationBox.getSelectedItem());
  return hm;
}
protected boolean isBuyerSoya(String srn){
  StringBuffer sbTestSoya=new StringBuffer();
  sbTestSoya.append("select upper(BYMKR_NAME) from buyer_maker ");
  sbTestSoya.append("where bymkr_seq in ");
  sbTestSoya.append("(select prod_buyer from prod_head where prod_head_pk in ");
  sbTestSoya.append("(select prod_head_pk from ship_sc ");
  sbTestSoya.append(" where ship_no='");
  sbTestSoya.append(srn);
  sbTestSoya.append("' and record_delete_flag='1' )) ");
  sbTestSoya.append(" and upper(BYMKR_NAME) like 'SOYA %' ");
  try{
    util.MiscFunc.showProcessingMessage();
    java.util.Vector vct =
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sbTestSoya.toString(), 1, 1);
    if(vct.size()==0) return false;
    return true;
  }catch(Exception exp){
    exp.printStackTrace();
    return false;
  }finally{
    util.MiscFunc.hideProcessingMessage();
  }
}
void checkSRN(){
  if(txtSRN.getText().trim().length()<7){
    if(txtSRN.getText().trim().length()<6){
      exgui.verification.VerifyLib.showAlert("Numeric Part Of SRN is 6 Digits Length",
                                             "Numeric Part Of SRN is 6 Digits Length");
      txtSRN.setText("");
      //return false;
    }
    try{
      Record recShipping = newtimes.shipping_admin.ShippingAdmin_Const.
          completeSrnByNumRecord(txtSRN.getText().trim());
      if (recShipping == null) {
           exgui.verification.VerifyLib.showAlert("No Such SRN","No Such SRN");
           txtSRN.setText("");
      }
      txtSRN.setText((String)recShipping.get(0));
      Object obj=recShipping.get(1);
      if(obj!=null)
        cbxConsolidationBox.setSelectedItem((String)obj);
       else
        cbxConsolidationBox.setSelectedIndex(0);
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error In Retreiving SRN ","Error In Retreiving SRN ");
      util.ExceptionLog.exp2File(exp,"");
      txtSRN.setText("");
    }
    /*
    exgui.verification.VerifyLib.showAlert("Pleaase Input SRN NO","Please Input SRN NO");
    return;*/

  }else{
    String iniNumber=txtSRN.getText().trim();
    StringBuffer sb=new StringBuffer();
    String sql = "select ship_no, (select C_B_DESC FROM SHIPPING_CONSOLIDATION_BOX where SHIPPING_CONSOLIDATION_BOX.ship_no=shipping.ship_no) as CB_DESC from shipping where  (ship_no like '";
    sb= new StringBuffer(sql);
    sb.append(String.valueOf(iniNumber));
    sb.append("') and record_delete_flag='1'");
    try{
      java.util.Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),
          1, 99999);
       if(vct.size()==0){
         txtSRN.setText("");
         exgui.verification.VerifyLib.showAlert("No Such SRN","No Such SRN");
         return;
       }
      Record rec = (Record)vct.get(0);
      txtSRN.setText((String)rec.get(0));
      Object obj=rec.get(1);
      if(obj!=null)
        cbxConsolidationBox.setSelectedItem((String)obj);
       else
        cbxConsolidationBox.setSelectedIndex(0);
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error In Retreiving SRN ","Error In Retreiving SRN ");
      util.ExceptionLog.exp2File(exp,"");
      txtSRN.setText("");
    }
  }
}

void btnPrint_actionPerformed(ActionEvent e) {
  if(txtSRN.getText().trim().length()==0)return;
  if(rdoCommInve.isSelected()){
    reportName="COMM_INV.RPT";
  }else if (rdoShipAdv.isSelected()){
    try{
      updateConsolidationBox();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error In Updatting Consolidation Box Data",
                                             "Error In Updatting Consolidation Box Data");
    }
    reportName="SHIP_ADV.RPT";
  }else if(rdoDiamondSummaryReport.isSelected()){
    reportName="NTHK_SRN_BDN.rpt";
  }else if(rdoPackingList2Excel.isSelected()){
    reportName="PACKING_DET_CSV.rpt";
  }else{
    //----TEST if Buyer is soya----------
    if(isBuyerSoya(txtSRN.getText().trim())){
      reportName="SOYA_PACKING.RPT";
    }else{
      reportName="PACKING_DET.RPT";
    }
  }


  if(rdoDiamondSummaryReport.isSelected()){
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
       "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";

  }else{
    super.JButtonQueryButtonAction(e);
  }

}
 protected void generateReport(java.util.HashMap paraHm,String reportName)throws Exception{
  try{
   newtimes.production.ProdMaintain_Properties.setWaitCursor();
  /*
   newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt(
    reportName ,null,paraHm);
  */
   com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer;
       //new com.inet.viewer.ReportViewerBean();
       //util.PublicVariable.inet_report_viewer;
 newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,reportName,paraHm);
 /*
  viewer.setReportName("http://rpt.nttpe.com.tw:9000/file:///d://rpt//"+reportName);
  java.util.Iterator itr=paraHm.keySet().iterator();
  while(itr.hasNext()){
    String keyObj=(String)itr.next();
    Object value=paraHm.get(keyObj);
    viewer.setReportParameter(keyObj,(value==null)?"":value.toString());
  }
  */

   viewer.setHasGroupTree(false);
   //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
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


  void rdoPackingList_itemStateChanged(ItemEvent e) {
    if(rdoPackingList.isSelected()||rdoPackingList2Excel.isSelected()){
      rdoClrBrkDwn_Y.setEnabled(true);
      rdoClrBrkDwn_N.setEnabled(true);
      rdo1Style1Page_Y.setEnabled(true);
      rdo1Style1Page_N.setEnabled(true);
    }else{
      rdoClrBrkDwn_Y.setEnabled(false);
      rdoClrBrkDwn_N.setEnabled(false);
      rdo1Style1Page_Y.setEnabled(false);
      rdo1Style1Page_N.setEnabled(false);
    }
  }
  boolean checkPoSrnPriceDeff(String srn)throws Exception{
    continueImportEvenPrxDiff=false;
   util.MiscFunc.showProcessingMessage();
    StringBuffer sb=new StringBuffer();
    sb.append("select ");
     sb.append("c.sty_style,c.sty_po, ");//0,1
     sb.append("c.sty_sc_no, ");//2
     sb.append("a.PRI_BYR_ACT_PRX as ship_Buyer_act_prx, ");//3
     sb.append("a.PRI_BYR_DOC_PRX as ship_Buyer_doc_prx, ");//4
     sb.append("a.PRI_MKR_ACT_PRX as ship_maker_act_prx, ");//5
     sb.append("a.PRI_MKR_ACT_PRX as ship_maker_doc_prx, ");//6
     sb.append("e.PRI_BYR_ACT_PRX as PO_Buyer_act_prx, ");//7
     sb.append("e.PRI_BYR_DOC_PRX as PO_Buyer_doc_prx, ");//8
     sb.append("e.PRI_MKR_ACT_PRX as PO_maker_act_prx, ");//9
     sb.append("e.PRI_MKR_ACT_PRX as PO_maker_doc_prx ");//10

     sb.append("from ship_price a,ship_style b,style c,price e ");
     sb.append("where 1=1  ");
     sb.append("and a.ship_style_pk=b.SHIP_STYLE_PK ");
     sb.append("and b.sty_seq=c.sty_seq ");
     sb.append("and c.sty_seq=e.PRI_STY_SEQ ");
     sb.append("and a.record_delete_flag='1' ");
     sb.append("and e.record_delete_flag='1' ");
     sb.append("and b.record_delete_flag='1' ");
     sb.append("and c.record_delete_flag='1' ");
     sb.append("and b.ship_sc_pk in ");
     sb.append("(select ship_sc_pk from ship_sc  ");
     sb.append("where record_delete_flag='1' and ship_no='");sb.append(srn);sb.append("') ");
     sb.append("order by c.sty_seq ,a.ship_price_pk");

     java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sb.toString(),1,999999);
         sb=new StringBuffer();
      util.MiscFunc.hideProcessingMessage();
     for(int i=0;i<vct.size();i++){
       Record rec = (Record)vct.get(i);
       Object objShipByrActPrx = rec.get(3);
       Object objShipByrDocPrx = rec.get(4);
       Object objShipMkrActPrx = rec.get(5);
       Object objShipMkrDocPrx = rec.get(6);
       Object objPoByrActPrx = rec.get(7);
       Object objPoByrDocPrx = rec.get(8);
       Object objPoMkrActPrx = rec.get(9);
       Object objPoMkrDocPrx = rec.get(10);
       double shipByrActPrx =
           Double.parseDouble(objShipByrActPrx == null ||
                              objShipByrActPrx.toString().trim().equals("") ?
                              "0" : objShipByrActPrx.toString());
       double shipByrDocPrx =
           Double.parseDouble(objShipByrDocPrx == null ||
                              objShipByrDocPrx.toString().trim().equals("") ?
                              "0" : objShipByrDocPrx.toString());

       double shipMkrActPrx =
           Double.parseDouble(objShipMkrActPrx == null ||
                              objShipMkrActPrx.toString().trim().equals("") ?
                              "0" : objShipMkrActPrx.toString());
       double shipMkrDocPrx =
           Double.parseDouble(objShipMkrDocPrx == null ||
                              objShipMkrDocPrx.toString().trim().equals("") ?
                              "0" : objShipMkrDocPrx.toString());

       double poByrActPrx =
           Double.parseDouble(objPoByrActPrx == null ||
                              objPoByrActPrx.toString().trim().equals("") ?
                              "0" : objPoByrActPrx.toString());
       double poByrDocPrx =
           Double.parseDouble(objPoByrDocPrx == null ||
                              objPoByrDocPrx.toString().trim().equals("") ?
                              "0" : objPoByrDocPrx.toString());

       double poMkrActPrx =
           Double.parseDouble(objPoMkrActPrx == null ||
                              objPoMkrActPrx.toString().trim().equals("") ?
                              "0" : objPoMkrActPrx.toString());
       double poMkrDocPrx =
           Double.parseDouble(objPoMkrDocPrx == null ||
                              objPoMkrDocPrx.toString().trim().equals("") ?
                              "0" : objPoMkrDocPrx.toString());
       StringBuffer sbPrxDiff = new StringBuffer();

       if (shipByrActPrx != poByrActPrx) {
         sbPrxDiff.append("Buyer Act Prx, PO :");
         sbPrxDiff.append(String.valueOf(poByrActPrx));
         sbPrxDiff.append(", SHIPPING:");
         sbPrxDiff.append(String.valueOf(shipByrActPrx));
       }

       if (shipByrDocPrx != poByrDocPrx) {
         if (sbPrxDiff.length() > 0)sbPrxDiff.append("\n");
         sbPrxDiff.append("Buyer Doc Prx, PO :");
         sbPrxDiff.append(String.valueOf(poByrDocPrx));
         sbPrxDiff.append(", SHIPPING:");
         sbPrxDiff.append(String.valueOf(shipByrDocPrx));
       }

       if (shipMkrActPrx != poMkrActPrx) {
         if (sbPrxDiff.length() > 0)sbPrxDiff.append("\n");
         sbPrxDiff.append("Maker Act Prx, PO :");
         sbPrxDiff.append(String.valueOf(poMkrActPrx));
         sbPrxDiff.append(", SHIPPING:");
         sbPrxDiff.append(String.valueOf(shipMkrActPrx));
       }

       if (shipMkrDocPrx != poMkrDocPrx) {
         if (sbPrxDiff.length() > 0)sbPrxDiff.append("\n");
         sbPrxDiff.append("Maker Doc Prx, PO :");
         sbPrxDiff.append(String.valueOf(poMkrDocPrx));
         sbPrxDiff.append(", SHIPPING:");
         sbPrxDiff.append(String.valueOf(shipMkrDocPrx));
       }

       if (sbPrxDiff.length() > 0) {
         if(sb.length()>0)sb.append("\n\n");
         String sty_style=(String)rec.get(0);
         if(null==sty_style)sty_style="";
         String sty_po=(String)rec.get(1);
         if(null==sty_po)sty_po="";
         sb.append("STYLE:");
         sb.append(sty_style);
         if(sty_po.length()>0){sb.append("    PO:");sb.append(sty_po);}
         sb.append("   PRICE DIFF:\n");
         sb.append(sbPrxDiff.toString());
       }
     }
     if(sb.length()>0){
       sb.append("\n\n");
       //sb.append("Continue Import Procedure ?");
        DlgListPriceDiff dlg=new DlgListPriceDiff(util.PublicVariable.APP_FRAME,
                                                  "PO & INVOICE Price Diff",true,this);
        dlg.setSize(520,400);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.txtPrxDiffList.setText(sb.toString());
        dlg.txtPrxDiffList.setCaretPosition(0);
        dlg.show();

        if(!continueImportEvenPrxDiff){
          return false;
        }
       /*
       if(!exgui.verification.VerifyLib.showConfirm(sb.toString(),"PO & INVOICE Price Diff",false)){
         return false;
       }*/
     }
     return true;
  }
  void btnExpPxk2ShipQty_actionPerformed(ActionEvent e) {
      try{
         if(txtSRN.getText().trim().length()==0)return;
         if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
           if (!checkPoSrnPriceDeff(txtSRN.getText().trim()))return;
         }

          util.MiscFunc.showProcessingMessage();
          //before exporting packing QTY to shipping Qty,have to check if PO price different ship detail price
          newtimesejb.packing.PackingDirectQtyFacadeHome  ejbHome=
              (newtimesejb.packing.PackingDirectQtyFacadeHome)
               info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                                 "newtimesejb.packing.PackingDirectQtyFacade");
          newtimesejb.packing.PackingDirectQtyFacade ejb=ejbHome.create();
          ejb.exportSRNpacking2ShipQty(txtSRN.getText().trim().toUpperCase(),
                                       (String)util.PublicVariable.USER_RECORD.get(0));

        }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
           exgui.verification.VerifyLib.showAlert("Error While Importing Packing Qty!!\nPlease Contact System Manager",
                                                  "Error In Import Packing Qty");
        }finally{
            util.MiscFunc.hideProcessingMessage();
        }
  }

  void rdoShipAdv_itemStateChanged(ItemEvent e) {
     if(rdoShipAdv.isSelected()){
       //btnExpPxk2ShipQty.setEnabled(true);
     }else{
       //btnExpPxk2ShipQty.setEnabled(false);
     }
  }
  void btnSyncPrice_actionPerformed(ActionEvent e) {
   try{
    if(txtSRN.getText().trim().length()==0)return;
     util.MiscFunc.showProcessingMessage();
     newtimesejb.packing.PackingDirectQtyFacadeHome  ejbHome=
         (newtimesejb.packing.PackingDirectQtyFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                            "newtimesejb.packing.PackingDirectQtyFacade");
     newtimesejb.packing.PackingDirectQtyFacade ejb=ejbHome.create();
     ejb.updateShipPriceByPoPrice(txtSRN.getText().trim().toUpperCase(),
                                  (String)util.PublicVariable.USER_RECORD.get(0));
   }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Update Ship Price By Po Price!!\nPlease Contact System Manager",
                                             "Error In Update Ship Price");
   }finally{
       util.MiscFunc.hideProcessingMessage();
   }

  }
  void rdoPackingList2Excel_itemStateChanged(ItemEvent e) {

  }

}
