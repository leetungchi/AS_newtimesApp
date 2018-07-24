package newtimes.preproduction.guis;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import com.inet.viewer.ReportViewerBean;
import java.util.Vector;
import javax.swing.event.*;
public class PnlNthkOrderPrint extends JPanel {
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel lblOderPrintType = new JLabel();
  JRadioButton rdoTypeSC = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoTypeCT = new JRadioButton();
  JButton btnDoPrint = new JButton();
  static String  REPORT_TYPE_SC_DOC="SC_DOC.rpt";
  static String  REPORT_TYPE_CT_DOC="CT_DOC.rpt";
  JButton btnDirectPrint = new JButton();
  JRadioButton rdoProfit = new JRadioButton();
  JRadioButton rdoDoc = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JRadioButton rdoActPrx = new JRadioButton();
  newtimes.production.process.audit_sc_ct.DB_ProdAudits handler=
           new newtimes.production.process.audit_sc_ct.DB_ProdAudits();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtSC_rev_no = new JTextField();
  JTextField txtCT_rev_no = new JTextField();
  com.inet.viewer.ReportViewerBean viewer=util.PublicVariable.inet_report_viewer;
  JButton btnChangeStatus = new JButton();
  JButton btnF4Form = new JButton();
  JButton btnQcForm = new JButton();
  JButton btnGetSeriesSc = new JButton();
  JPanel jPanel1 = new JPanel();
  JComboBox cbxCtSeq = new JComboBox();
  JLabel lblCtSeq = new JLabel();
  exgui.DataBindJCombobox dbCbxCtSeq;
  Vector vctCtSeqVector=null;
  String sc_no;
  JLabel lblCtWithColorCodeName = new JLabel();
  JComboBox cbxCtWithColorCodeName = new JComboBox(new String[]{"YES","NO"});
  JLabel lblCtWithBEF = new JLabel();
  JComboBox cbxCtWithBEF = new JComboBox(new String[]{"YES","NO"});//new JComboBox(new String[]{"YES","NO"});
  JLabel lblUnderForAndOnBehalfOf = new JLabel();
  public PnlNthkOrderPrint() {
    try {
      sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
      jbInit();
      newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler styHndl=new
          newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler(
           sc_no);

      vctCtSeqVector=styHndl.force2UpdateCtProdPkMap();
     iniCtSeqCombobox(vctCtSeqVector);

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void iniCtSeqCombobox(java.util.Vector vct)throws Exception{
    dbCbxCtSeq=new exgui.DataBindJCombobox(
                     cbxCtSeq,
                     "",
                     vct,
                     "PROD_CT_SEQ",
                     "PROD_HEAD_PK",
                     newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(0).toString());
    cbxCtSeq.addItemListener(new ItemChangListen());

  }
  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    blueBkgWhiteCharLabel1.setText("===============Order Print===============");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 5, 525, 31));
    this.setLayout(null);
    lblOderPrintType.setFont(new java.awt.Font("Dialog", 1, 11));
    lblOderPrintType.setHorizontalAlignment(SwingConstants.CENTER);
    lblOderPrintType.setText("<html><body>ORDER<br>TYPE</body></html>:");
    lblOderPrintType.setBounds(new Rectangle(2, 67, 63, 51));
    rdoTypeSC.setBackground(Color.white);
    rdoTypeSC.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoTypeSC.setHorizontalAlignment(SwingConstants.CENTER);
    rdoTypeSC.setSelected(true);
    rdoTypeSC.setText("S/C");
    rdoTypeSC.setBounds(new Rectangle(55, 52, 65, 22));
    rdoTypeCT.setBackground(Color.white);
    rdoTypeCT.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoTypeCT.setHorizontalAlignment(SwingConstants.LEFT);
    rdoTypeCT.setSelected(false);
    rdoTypeCT.setText("C/T");
    rdoTypeCT.setBounds(new Rectangle(118, 52, 138, 22));
    rdoTypeSC.addChangeListener(new PnlNthkOrderPrint_rdoTypeSC_changeAdapter(this));
    rdoTypeCT.addChangeListener(new PnlNthkOrderPrint_rdoTypeSC_changeAdapter(this));
    /*
    //get defalut value,if NTFE, C/T form defalut print:
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
      cbxCtWithBEF.setSelectedIndex(0);
    }else{
      cbxCtWithBEF.setSelectedIndex(1);
    }*/
    cbxCtWithBEF.setEnabled(false);
    cbxCtWithColorCodeName.setEnabled(false);

    btnDoPrint.setBounds(new Rectangle(335, 67, 108, 29));
    btnDoPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDoPrint.setHorizontalAlignment(SwingConstants.CENTER);
    btnDoPrint.setText("Special Form");
    btnDoPrint.addActionListener(new PnlNthkOrderPrint_btnDoPrint_actionAdapter(this));


    btnDirectPrint.setBounds(new Rectangle(452, 67, 108, 29));
    btnDirectPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDirectPrint.setText("A4 Form");
    btnDirectPrint.addActionListener(new PnlNthkOrderPrint_btnDirectPrint_actionAdapter(this));
    rdoProfit.setBackground(Color.white);
    rdoProfit.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoProfit.setText("PROFIT");
    rdoProfit.setBounds(new Rectangle(255, 52, 78, 22));
    rdoDoc.setBackground(new Color(190, 255, 151));
    rdoDoc.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDoc.setSelected(true);
    rdoDoc.setText("DOC Price");
    rdoDoc.setBounds(new Rectangle(55, 95, 128, 23));
    rdoActPrx.setBackground(new Color(190, 255, 151));
    rdoActPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoActPrx.setText("Act. Price");
    rdoActPrx.setBounds(new Rectangle(181, 95, 152, 23));
    jLabel1.setText("SC Rev No.:");
    jLabel1.setBounds(new Rectangle(109, 135, 76, 21));
    jLabel2.setText("CT Rev No.:");
    jLabel2.setBounds(new Rectangle(324, 135, 87, 21));
    txtCT_rev_no.setText("");
    txtSC_rev_no.setBounds(new Rectangle(190, 135, 106, 21));
    txtCT_rev_no.setBounds(new Rectangle(397, 134, 106, 21));
    txtCT_rev_no.setText("");
    btnChangeStatus.setBounds(new Rectangle(605, 170, 156, 27));
    btnChangeStatus.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChangeStatus.setText("");
    btnChangeStatus.addActionListener(new PnlNthkOrderPrint_btnChangeStatus_actionAdapter(this));
    btnF4Form.setBounds(new Rectangle(568, 67, 105, 29));
    btnF4Form.setFont(new java.awt.Font("Dialog", 1, 11));
    btnF4Form.setText("F4 Form");
    btnF4Form.addActionListener(new PnlNthkOrderPrint_btnF4Form_actionAdapter(this));
    btnQcForm.setBounds(new Rectangle(686, 67, 107, 29));
    btnQcForm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQcForm.setText("QC Form");
    btnQcForm.addActionListener(new PnlNthkOrderPrint_btnQcForm_actionAdapter(this));
    btnGetSeriesSc.setBounds(new Rectangle(443, 170, 197, 27));
    btnGetSeriesSc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGetSeriesSc.setText("Get Series S/C#");
    btnGetSeriesSc.addActionListener(new PnlNthkOrderPrint_btnGetSeriesSc_actionAdapter(this));
    jPanel1.setBackground(Color.white);
    jPanel1.setBounds(new Rectangle(55, 74, 278, 21));
    jPanel1.setLayout(null);
    cbxCtSeq.setBounds(new Rectangle(128, 0, 76, 20));
    lblCtSeq.setText("C/T SEQ:");
    lblCtSeq.setBounds(new Rectangle(66, 0, 62, 20));
    lblCtWithColorCodeName.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCtWithColorCodeName.setText("C/T WITH COLOR CODE");
    lblCtWithColorCodeName.setBounds(new Rectangle(65, 172, 155, 22));
    cbxCtWithColorCodeName.setBounds(new Rectangle(229, 172, 95, 21));
    lblCtWithBEF.setBounds(new Rectangle(65, 203, 213, 22));
    lblCtWithBEF.setText("C/T WITH BUYER NAME");
    lblCtWithBEF.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCtWithBEF.setBounds(new Rectangle(229, 203, 95, 21));
    lblUnderForAndOnBehalfOf.setFont(new java.awt.Font("Dialog", 1, 11));
    lblUnderForAndOnBehalfOf.setText("(UNDER \" FOR AND ON BEHALF OF \")");
    lblUnderForAndOnBehalfOf.setBounds(new Rectangle(65, 228, 246, 26));
    this.add(blueBkgWhiteCharLabel1, null);
    buttonGroup1.add(rdoTypeSC);
    buttonGroup1.add(rdoTypeCT);
    if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
      this.add(btnDoPrint, null);
    }
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(txtSC_rev_no, null);
    this.add(txtCT_rev_no, null);
    this.add(btnChangeStatus, null);
    this.add(btnDirectPrint, null);
    this.add(btnF4Form, null);
    this.add(btnQcForm, null);
    this.add(btnGetSeriesSc, null);
    this.add(lblOderPrintType, null);
    this.add(rdoTypeSC, null);
    this.add(rdoDoc, null);
    this.add(rdoTypeCT, null);
    this.add(rdoActPrx, null);
    btnChangeStatus.setVisible(false);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      btnGetSeriesSc.setVisible(true);
    }else{
      btnGetSeriesSc.setVisible(false);
    }
    /*==================================
    btnSndCnfm.setVisible(true);
    btnReject.setVisible(true);
    btnChangeStatus.setVisible(true);
   //=====================================*/
    //btnChangeStatus.setVisible(false);
    //is not mis user,can not use send confirm & cancel s/c no button,this is only for TPE center.
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")||
       util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      btnF4Form.setVisible(false);
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")||
       util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      btnQcForm.setVisible(false);
    }

    //if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
    //}
    buttonGroup1.add(rdoProfit);
    buttonGroup2.add(rdoDoc);
    buttonGroup2.add(rdoActPrx);
    this.add(rdoProfit, null);
    this.add(jPanel1, null);

    jPanel1.add(cbxCtSeq, null);
    Object objCTRev=
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_ct_revice_no");
    Object objSCRev=
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_sc_revice_no");
    txtSC_rev_no.setText((objSCRev==null)?"0":objSCRev.toString());
    txtCT_rev_no.setText((objCTRev==null)?"0":objCTRev.toString());
    jPanel1.add(lblCtSeq, null);
    btnDoPrint.setEnabled(false);
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
     this.add(cbxCtWithColorCodeName, null);
     this.add(cbxCtWithBEF, null);
     this.add(lblCtWithColorCodeName, null);
     this.add(lblCtWithBEF, null);
     this.add(lblUnderForAndOnBehalfOf, null);
     try{
       updateUploadQtyText(sc_no);
     }catch(Exception eexp){
       eexp.printStackTrace();
       exgui.verification.VerifyLib.showAlert("Update Qty Text Failed\nPlease Contact System Manager",
                                              "Update Qty Text Failed");
       throw eexp;
     }
    }
  }
  public static void updateUploadQtyText(String sc_no)throws Exception{
   Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from style where sty_sc_no='"+sc_no+"' and sty_img is not null and sty_qty_desc is null  and record_delete_flag='1'"
      ,1,9999);
     if(vct.size()==0)return;
     try{
       util.MiscFunc.showProcessingMessage();
       for (int i = 0; i < vct.size(); i++) {
         newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD =
             (Record)vct.get(i);
         String sizeClmStr = (String)newtimes.production.ProdMaintain_Properties.
             EDITING_STYLE_RECORD.get(107);

         newtimes.production.ProdMaintain_Properties.
             CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST =
             newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.
             getInt(0);
         if (sizeClmStr.indexOf(",,") != -1) {
           newtimesejb.excelhandler.ExcelUploadHandlerHome ejbHome =
               (newtimesejb.excelhandler.ExcelUploadHandlerHome)
               info_ejb.WeblogicServiceLocator.locateServiceHome(util.
               PublicVariable.SERVER_URL,
               "newtimesejb.excelhandler.ExcelUploadHandler");
           newtimesejb.excelhandler.ExcelUploadHandler ejb = ejbHome.create();

           ejb.refineQtyRec(newtimes.production.ProdMaintain_Properties.
                            CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
                            util.PublicVariable.USER_RECORD.get(0).toString());
         }

         newtimes.production.process.prodmaintain.DB_Trinity_PriceSizeQty
             orgQtyHandler =
             new newtimes.production.process.prodmaintain.
             DB_Trinity_PriceSizeQty();
         newtimes.production.gui.prodmaintain.PnlNthkQtyTempPnl pnlShowTbl =
             new newtimes.production.gui.prodmaintain.PnlNthkQtyTempPnl(
             orgQtyHandler);
         pnlShowTbl.firstPage();

         String tblTxt = newtimes.production.ProdMaintain_Properties.
             stylPriceSizeQtyTable2Text(
             pnlShowTbl.getJtable(), 4);
         System.out.println(tblTxt);

         orgQtyHandler.udpateQtyTbl2Text(newtimes.production.
                                         ProdMaintain_Properties.
                                         CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST
                                         , tblTxt);

       }

     }catch(Exception exp){
         throw exp;
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }
  }
  class ItemChangListen implements java.awt.event.ItemListener{
    public void itemStateChanged(java.awt.event.ItemEvent itemevent){
      if(itemevent.getStateChange() ==itemevent.SELECTED){
        int destProdPk=Integer.parseInt((String)dbCbxCtSeq.getSelectedValue());
        for(int i=0;i<vctCtSeqVector.size();i++){
          Record rec=(Record)vctCtSeqVector.get(i);
          if(rec.getInt(1)==destProdPk){
            Object objCtRevNo=rec.get(2);
            txtCT_rev_no.setText((objCtRevNo==null)?"0":objCtRevNo.toString());
            return;
          }
        }
      }
    }
  }
  protected void setChangeStatusButton(){
    if(!util.PublicVariable.OPERATTING_CENTER.equals("001"))return;//only TPE center require this buuton.
    try{
      //System.out.println("production head:"+newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.toString());
      Object objAuditStatus=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
          "PRODUCTION_AUDIT_STATUS");
      Object objSCNO=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_SC_NO");
      if(objAuditStatus==null)return;
      int auditStatus=Integer.parseInt(objAuditStatus.toString());
      if (auditStatus == newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED &&
          objSCNO!=null) {
        btnChangeStatus.setText("SET TO EDITING");
        //this.add(btnChangeStatus, null);
        btnChangeStatus.setVisible(true);
      }
      if (auditStatus == newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_EDITING &&
          objSCNO!=null) {
        btnChangeStatus.setText("SET TO CONFIRMED");
        //this.add(btnChangeStatus, null);
        btnChangeStatus.setVisible(true);
      }

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  protected boolean checkConfirm()throws Exception{
      //test if production can be send confirmed.only at status
      Record prod_record =
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD;
      Record productionRecord=
        newtimes.production.process.prodmaintain.DB_ProdSC.getInstanceOfProdSCHandler().getRecordByPk(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      if(productionRecord.get("PROD_AUDIT_STATUS")!= null){
        if(productionRecord.getInt("PROD_AUDIT_STATUS")==
           newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_WAIT_CONFIRM){
          exgui.verification.VerifyLib.showAlert(
            "production is already sent confirm",
            "production is already sent confirm"
            );
          return false;
        }

        if(productionRecord.getInt("PROD_AUDIT_STATUS")==
           newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED||
           productionRecord.getInt("PROD_AUDIT_STATUS")==
           newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_PRINTED){
            exgui.verification.VerifyLib.showAlert(
              "production is already confirmed",
              "production is already confirmed"
              );
            return false;
        }
      }

      if(prod_record.get("PROD_CEN_CODE")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"Center\" for this production"
                                               ,
                                               "Column not assigned yet");
        return false;
      }
      if(prod_record.get("PROD_DEPTMENT")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"Department\" for this production",
                                               "Column not assigned yet");
        return false;
      }
      if(prod_record.get("PROD_MNG_CODE")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"Manager\" for this production",
                                               "Column not assigned yet");
        return false;
      }
      if(prod_record.get("PROD_BUYER")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"Buyer\" for this production",
                                               "Column not assigned yet");
        return false;
      }
     Object prdType=productionRecord.get("PROD_TYPE");
     if(prdType.toString().equalsIgnoreCase("W")||
        prdType.toString().equalsIgnoreCase("K")||
        prdType.toString().equalsIgnoreCase("S")){
       if (prod_record.get("PROD_SEASON") == null) {
         exgui.verification.VerifyLib.showAlert(
             "Please Assign \"Season\" for this production",
             "Column not assigned yet");
         return false;
       }
       if (prod_record.get("PROD_YEAR") == null) {
         exgui.verification.VerifyLib.showAlert(
             "Please Assign \"Year\" for this production",
             "Column not assigned yet");
         return false;
       }
     }
     /* mark based on Eric (NTHK requirement)*/
     if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       if (prod_record.get("Prod_Maker") == null) {
         exgui.verification.VerifyLib.showAlert(
             "Please Assign \"MAKER\" for this production",
             "Column not assigned yet");
         return false;
       }

       if (productionRecord.get("PROD_QC_CNTY") == null) {
         exgui.verification.VerifyLib.showAlert(
             "Please Assign \"QC Country\" for this production",
             "Column not assigned yet");
         return false;
       }
     }

      if(productionRecord.get("PROD_PYT_TRM")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"Payment Term\" for this production",
                                               "Column not assigned yet");
        return false;
      }
      if(productionRecord.get("PROD_BRNCH_BRIEF")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"Branch\" for this production",
                                               "Column not assigned yet");
        return false;
      }
      if(productionRecord.get("PROD_SC_PRC_TRM")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"SC Price Term\" for this production",
                                               "Column not assigned yet");
        return false;
      }
      if(productionRecord.get("PROD_SC_DEST")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"SC Destination\" for this production",
                                               "Column not assigned yet");
        return false;
      }
      if(productionRecord.get("PROD_SC_CURRENCY")== null) {
        exgui.verification.VerifyLib.showAlert("Please Assign \"SC Currency\" for this production",
                                               "Column not assigned yet");
        return false;
      }

      //list all the style record,check one by one
      newtimes.production.process.prodmaintain.DB_StyleMisc stylesHdl
          =new newtimes.production.process.prodmaintain.DB_StyleMisc();
      java.util.Vector styleRecords=stylesHdl.getRecords(9,99999);
      if(styleRecords.size()==0){
        exgui.verification.VerifyLib.showAlert("There is not Styles To Send Confirm","NO Data To Confirm");
        return false;
      }
      for(int i=0;i<styleRecords.size();i++){
        Record recSty = (Record) styleRecords.get(i);
        //get STY_STYLE, STY_PO as title of this style record
        String sty_STYLE_String = (String) recSty.get("STY_STYLE");
        if(sty_STYLE_String==null){
          exgui.verification.VerifyLib.showAlert("\"Style\" is not assigned yet",
                                                 "Column Not Assigned yet");
          return false;
        }
        String sty_PO_String = (recSty.get("STY_PO")==null)?"":recSty.get("STY_PO").toString();
        String sty_TITLE = "STYL:" + sty_STYLE_String + " PO:" + sty_PO_String;
        if(recSty.get("STY_CT_PRC_TRM")==null){
          exgui.verification.VerifyLib.showAlert("Please Assign \"C/T PRICE TERM\" for "+sty_TITLE,
                                                 "Column Not Assigned yet");
          return false;
        }
        if(recSty.get("STY_CT_CURRENCY")==null){
          exgui.verification.VerifyLib.showAlert("Please Assign \"C/T CURRENCY\" for "+sty_TITLE,
                                                 "Column Not Assigned yet");
          return false;
        }
        Object objTtlOdrQty=recSty.get("sty_total_qty");//recSty.get("total_order_qty");
        float totlQdrQty=(objTtlOdrQty==null)?0:Float.parseFloat(objTtlOdrQty.toString());
        if(totlQdrQty<=0){
          exgui.verification.VerifyLib.showAlert("Please Assign \"Quantity\" for "+sty_TITLE,
                                                 "Column Not Assigned yet");
          return false;
        }
        //Object prdType=productionRecord.get("PROD_TYPE");
        String prdTypeStr=(prdType==null)?"":prdType.toString().toUpperCase().trim();
        /*
         (19)	3울1 (ORIG DEL(STYLE.STY_ORIG_DEL),RECFM DEL(STYLE. STY_RECFM_DEL),WEEKLY UPDT (STYLE. STY_UPDT)for product type is WEAVON,KNIT,SWEATER,ⓧⅵPRODUCTION TYPE쳂촑メ짨ぬ울�@)
         (20)	3 울 1 (ORIG WAY(STYLE.STY_ORIG_WAY),RECFM WAY(STYLE. STY_RECFM_SHIP), WEEKLY WAY(STYLE.STY_UPDT_SHIP),쪷첿)
         (21)	BUY-COMM (STYLE.STY_BUY_COMM)
         (22)	4울 1(MAKER DISCOUNT %(STYLE.STY_MKR_DSCT_PER, STYLE.STY_MKR_DSCT_PC, STYLE.STY_MKR_DSCT_DZ, STY_MKR_DSCT_LUMP_SUM))

        */
        if(prdTypeStr.equals("W")||
           prdTypeStr.equals("K")||
           prdTypeStr.equals("S")){
        }
        if(recSty.get("STY_UPDT")==null &&
           recSty.get("STY_RECFM_DEL")==null &&
           recSty.get("STY_ORIG_DEL")==null){
          exgui.verification.VerifyLib.showAlert("Please Assign: \"Updated Date\" \n" +
                                                   "or \"Reconfirm Delivery Date\" \n"+
                                                   "or \"Orignal Delivery Date\" for "+sty_TITLE,
                                                 "Column Not Assigned yet");
          return false;
        }
        if(recSty.get("STY_UPDT_SHIP")==null &&
           recSty.get("STY_RECFM_SHIP")==null &&
           recSty.get("STY_ORIG_WAY")==null){
          exgui.verification.VerifyLib.showAlert("Please Assign: \"Updated Shipping Method\"\n" +
                                                   "or \"Reconfirm Shipping Method\"\n"+
                                                   "or \"Orignal Shipping Method\" for "+sty_TITLE,
                                                 "Column Not Assigned yet");
          return false;
        }
        if(recSty.get("STY_MKR_DEL")==null){
          exgui.verification.VerifyLib.showAlert("Please Assign: \"Maker Delivery Date"+
                                                   " for "+sty_TITLE,
                                                 "Column Not Assigned yet");
          return false;
        }

        if(recSty.get("STY_UNIT")==null){
          exgui.verification.VerifyLib.showAlert("Please Assign \"UNIT\" for "+sty_TITLE,
                                                 "Column not assigned yet");
          return false;
        }
      }
    return true;
  }
  void btnDoPrint_actionPerformed(ActionEvent e) {
    if(txtSC_rev_no.getText().trim().length()==0||txtCT_rev_no.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigne Revice No. For S/C & C/T",
                                             "Pleaes Assign Revice Value");
      return;
    }
   try{
     int testScRevNo=Integer.parseInt(txtSC_rev_no.getText().trim());
     int testCtRevNo=Integer.parseInt(txtCT_rev_no.getText().trim());
     if((testScRevNo<0)||(testCtRevNo<0)){
       exgui.verification.VerifyLib.showAlert("S/C or C/T Revice No. Should Be Greater Than Zero",
                                              "Revice No. Format Error");
       return;
     }
   }catch(Exception exp){
     exgui.verification.VerifyLib.showAlert("S/C or C/T Revice No. Format Error",
                                            "Revice No. Format Error");
     return;
   }
     try{

       Object lastPrintOutCountObj=
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
       "production_print_count");
       int lastPrintCount=
           (lastPrintOutCountObj==null)?0:Integer.parseInt(lastPrintOutCountObj.toString());
       lastPrintCount++;
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       StringBuffer sb=new StringBuffer();
       String org_sc_no=
           (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_SC_NO");
       if(org_sc_no==null){
         exgui.verification.VerifyLib.showAlert(
         "Sorry,This Production is not confirmed yet","Production Not Confirmed");
         return;
       }

                 //String substr=org_sc_no.substring(12-8,12) ;
                 //String digts=substr.substring(substr.length()-4,substr.length());
                 //String frontDgt=substr.substring(0,3);
                 //String fixedSCNO=frontDgt+digts;

       boolean isNTHKCenter=util.PublicVariable.OPERATTING_CENTER.equals("NTHK");
       boolean isBWCenter=util.PublicVariable.OPERATTING_CENTER.equals("BW");
       boolean isTPECenter=util.PublicVariable.OPERATTING_CENTER.equals("001");



       if (rdoTypeSC.isSelected()) {
         String reportName=null;
         if(isTPECenter){
           reportName="FORM_SC.rpt";//"SC_DOC.rpt";
         }else if(isNTHKCenter){
            reportName="FORM_HK_SC_DOC.rpt";//"HK_SC_DOC.rpt";
         }else if(isBWCenter){
             reportName="BL_FORM_HK_SC_DOC.rpt";//"HK_SC_DOC.rpt";
         }else{
           reportName=   "L_FORM_HK_SC_DOC.rpt";//"LONG_HK_SC_DOC.rpt";
         }
         DlgViewRpt dlg = new DlgViewRpt(
             processhandler.template.Properties.getMainFrame(),
             "S/C report",
             genCTReportViewerWithPrintDate(reportName),
             //genSCReportViewer(reportName),
             true);
         dlg.setSize(700, 500);
         dlg.show();
       } else if (rdoTypeCT.isSelected()) {
         String reportName=null;
         if(isTPECenter){
           reportName="FORM_CT.rpt";
         }else if(isNTHKCenter){
            reportName ="FORM_HK_CT_DOC.rpt";
         }else if(isBWCenter){
           reportName="BL_HK_FORM_CT_DOC.rpt";
         }else{
           reportName= "L_HK_FORM_CT_DOC.rpt";
         }
         DlgViewRpt dlg = new DlgViewRpt(
             processhandler.template.Properties.getMainFrame(),
             "C/T report",
             genCTReportViewer(reportName),
             true);
         dlg.setSize(700, 500);
         dlg.show();
       } else {
         //genProfitReportViewer
         DlgViewRpt dlg = new DlgViewRpt(
             processhandler.template.Properties.getMainFrame(),
             "Profit report",
             genProfitReportViewer(),
             true);
         dlg.setSize(700, 500);
         dlg.show();
       }

     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"Error in Print Server");
       exgui.verification.VerifyLib.showAlert(
          "Print Server Error\nPlease Notify System Manager",
          "Print Server Error");
     }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }
  }


  protected String get_PK_List(int _prodSeq)throws Exception{
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<vctCtSeqVector.size();i++){
      Record rec=(Record)vctCtSeqVector.get(i);
      if(i!=0)sb.append(",");
      sb.append(rec.get(1));
    }
    String string="["+sb.toString()+"]";
    return string;
  }
  protected JPanel genCTReportViewerWithPrintDate(String rpt_name){
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      return genCTReportViewer(rpt_name);
    }
    int destProdPk=Integer.parseInt((String)dbCbxCtSeq.getSelectedValue());
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE","SET_CT_PRINT_DATE");
      hm.put("user_code",util.PublicVariable.USER_RECORD.get(0));
      hm.put("PROD_HEAD_PK",String.valueOf(destProdPk));
      ejb.tpeMisFunc(hm);
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Update C/T Print Date",
                                             "Update Ct Print Date Error");
    }
    return genCTReportViewer(rpt_name);
  }
  protected JPanel genCTReportViewer(String rpt_name){
    try{
     updateStyleColorSizeBreakDownRemark(false,rdoDoc.isSelected());
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      //get act c/t record by select index.
      int destProdPk=Integer.parseInt((String)dbCbxCtSeq.getSelectedValue());
      Record recProduction=handler.getRecordByPk(destProdPk);

      Object lastPrintOutCountObj=recProduction.get("production_print_count");
        //newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_print_count");
      int lastPrintCount=
          (lastPrintOutCountObj==null)?0:Integer.parseInt(lastPrintOutCountObj.toString());
      int ct_rev_no=Integer.parseInt(txtCT_rev_no.getText().trim());

      lastPrintCount++;
      int _prodSeq=destProdPk;

       //handler.updatePrintStatus(lastPrintCount,-1,ct_rev_no);
      handler.getEJB().updatePrintStatus(
         destProdPk,
         (String) util.PublicVariable.USER_RECORD.get("usr_code"),
         lastPrintCount,
         -1,ct_rev_no);

       //newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set("production_ct_revice_no",ct_rev_no);
       newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
       java.util.HashMap mp=new java.util.HashMap();
       mp.put("iprod_head_pk",String.valueOf(_prodSeq));
       mp.put("prod_pk",String.valueOf(_prodSeq));
       mp.put("prod_head_pk",String.valueOf(_prodSeq));
       mp.put("times",String.valueOf(lastPrintCount));
       mp.put("P_CT_SEQ",cbxCtSeq.getSelectedItem());
       if(cbxCtWithBEF.getSelectedItem().equals("YES")){
         mp.put("PRT_BEF","Y");
       }else{
         mp.put("PRT_BEF","N");
       }
       if(rdoActPrx.isSelected())
          mp.put("doc_act","2");
       else
          mp.put("doc_act","1");
         //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt(rpt_name,null,mp);
         //com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
         newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,rpt_name,mp);
         viewer.setHasGroupTree(false);
         //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
        viewer.start();
        JPanel pnl=new JPanel();
        pnl.setLayout(new java.awt.BorderLayout());
        pnl.add(viewer);
        viewer.setHasExportButton(true);
        return pnl;
     }catch(Throwable ex) {
         ex.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
         return null;
     }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }

  }
  protected JPanel genProfitReportViewer(){
   try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
      int _prodSeq=
           newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
       newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
       java.util.HashMap mp=new java.util.HashMap();
       mp.put("prod_pk",String.valueOf(_prodSeq));
       //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt("SC_Profit.rpt",null,mp);
         //com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
         viewer.setHasGroupTree(false);
         //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
        newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,"sc_profit.rpt",mp);
        viewer.start();
        JPanel pnl=new JPanel();
        pnl.setLayout(new java.awt.BorderLayout());
        pnl.add(viewer);
        viewer.setHasExportButton(true);
      return pnl;
    }catch(Throwable ex) {
        ex.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
        return null;
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

 }


  protected JPanel genSCReportViewer(String rpt_name){
    try{
      updateStyleColorSizeBreakDownRemark(true,rdoDoc.isSelected());
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      Object lastPrintOutCountObj=
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
      "production_print_count");
      int lastPrintCount=
          (lastPrintOutCountObj==null)?0:Integer.parseInt(lastPrintOutCountObj.toString());
      lastPrintCount++;
      int _prodSeq=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
      int sc_rev_no=Integer.parseInt(txtSC_rev_no.getText().trim());
       handler.updatePrintStatus(lastPrintCount,sc_rev_no,-1);
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set("production_sc_revice_no",sc_rev_no);
       newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
       java.util.HashMap mp=new java.util.HashMap();
       //mp.put("prod_pk",String.valueOf(_prodSeq));
       //test if this record combined.
       mp.put("prod_pk",get_PK_List(_prodSeq));
       mp.put("times",String.valueOf(lastPrintCount));
       if(rdoActPrx.isSelected())
          mp.put("doc_act","2");
       else
          mp.put("doc_act","1");
       //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt(rpt_name,null,mp);
        // com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
        newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,rpt_name,mp);
         viewer.setHasGroupTree(false);
         //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
        viewer.start();
        JPanel pnl=new JPanel();
        pnl.setLayout(new java.awt.BorderLayout());
        pnl.add(viewer);
        viewer.setHasExportButton(true);
      return pnl;
     }catch(Throwable ex) {

         ex.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
         return null;
     }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }

  }

  void btnDirectPrint_actionPerformed(ActionEvent e) {
    if(txtSC_rev_no.getText().trim().length()==0||txtCT_rev_no.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigne Revice No. For S/C & C/T",
                                             "Pleaes Assign Revice Value");
      return;
    }
   try{
     int testScRevNo=Integer.parseInt(txtSC_rev_no.getText().trim());
     int testCtRevNo=Integer.parseInt(txtCT_rev_no.getText().trim());
     if((testScRevNo<0)||(testCtRevNo<0)){
       exgui.verification.VerifyLib.showAlert("S/C or C/T Revice No. Should Be Greater Than Zero",
                                              "Revice No. Format Error");
       return;
     }
   }catch(Exception exp){
     exgui.verification.VerifyLib.showAlert("S/C or C/T Revice No. Format Error",
                                            "Revice No. Format Error");
     return;
   }

   boolean isNTHKCenter=util.PublicVariable.OPERATTING_CENTER.equals("NTHK");
   boolean isBWCenter=util.PublicVariable.OPERATTING_CENTER.equals("BW");
   boolean isTPECenter=util.PublicVariable.OPERATTING_CENTER.equals("001");

      if (rdoTypeSC.isSelected()) {
        String reportName=null;
        if(isTPECenter){
          reportName="SC_DOC.rpt";
        }else if(isNTHKCenter){
           reportName="HK_SC_DOC.rpt";
        }else if(isBWCenter){
          reportName="B_LONG_HK_SC_DOC.rpt";
        }else{
          reportName=  "LONG_HK_SC_DOC.rpt";
        }
        DlgViewRpt dlg = new DlgViewRpt(
            processhandler.template.Properties.getMainFrame(),
            "S/C report",genSCReportViewer(reportName),true);
        dlg.setSize(700, 500);
        dlg.show();
      } else if (rdoTypeCT.isSelected()) {
        String reportName=null;
        if(isTPECenter){
          reportName="CT_DOC.rpt";
        }else if(isNTHKCenter){
           //reportName="HK_CT_DOC.rpt";
           //if year is 8 ,switch to vendor supported CT form
           int desh_at=sc_no.indexOf("-");
           if(desh_at==-1){
             reportName = "HK_CT_DOC.rpt";
           }else{
             ++desh_at;
             int year_digit = Integer.parseInt(sc_no.substring(desh_at,desh_at + 1));
             if(year_digit>7){
                reportName = "R_HK_CT_DOC.rpt";
             }else{
                reportName = "HK_CT_DOC.rpt";
             }
           }

        }else if(isBWCenter){
          reportName="B_LONG_HK_CT_DOC.rpt";
        }else{
          reportName=  "LONG_HK_CT_DOC.rpt";
        }

        DlgViewRpt dlg = new DlgViewRpt(
            processhandler.template.Properties.getMainFrame(),
            "C/T report",
             genCTReportViewerWithPrintDate(reportName),
            //genCTReportViewer(reportName),
            true);
        dlg.setSize(700, 500);
        dlg.show();
      } else {
        //genProfitReportViewer
        DlgViewRpt dlg = new DlgViewRpt(
            processhandler.template.Properties.getMainFrame(),
            "Profit report",
            genProfitReportViewer(),
            true);
        dlg.setSize(700, 500);
        dlg.show();
      }
    }

  void btnChangeStatus_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      //if(!checkConfirm())return;
      /*
      newtimes.production.process.audit_sc_ct.DB_ProdAudits handler=
          new newtimes.production.process.audit_sc_ct.DB_ProdAudits();
      */
      //System.out.println("b4 up2cnfm ,current editing head rocrod is:"+newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.toString());
      if(btnChangeStatus.getText().indexOf("SET TO EDITING")!=-1){
        handler.update2Editing();
      }else if (btnChangeStatus.getText().indexOf("SET TO CONFIRMED")!=-1){
        handler.update2Confirmed();
      }
      //handler.update2Editing(null);
      //System.out.println("after up2nfm ,current editing head rocrod is:"+newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.toString());
      database.datatype.Record rec=(database.datatype.Record)
          handler.getRecordByPk(
             newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("prod_head_pk")
          );  //pgTblList.getDisplayingRecords().get(recAt);
      processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(rec);
      newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showPlanMsg(
      "Production Status Changed\nPlease Re-Entering Production Unit",
      "Status Changed");
       return;
    }catch(Exception exp){
       exp.printStackTrace();
       exgui.verification.VerifyLib.showAlert(
       "Connection Fail\nPlease Contact System Manager",
       "Exception of EJB Connection");
    }finally{
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }

  protected void updateStyleColorSizeBreakDownRemark(boolean isSc,boolean isDocPrx){
    try{
    //for NONE-NTHK center,need to update the column "STY_CLR_PRX_BKD" to replace the style's down remark field
     if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       util.MiscFunc.showProcessingMessage();
       newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler.udpateColorSizeBreakDownRemark(
       sc_no,isSc,isDocPrx,(cbxCtWithColorCodeName.getSelectedItem().equals("YES")?true:false)) ;
     }
     return;
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error in updating sytles's down remark\n"+
                                             "Please Check Maker & QC Country in \"C/T Head UINT\"",
                                              "Update Style down remark Failed");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  void btnF4Form_actionPerformed(ActionEvent e) {
    String reportName=null;
    boolean isNTHKCenter=util.PublicVariable.OPERATTING_CENTER.equals("NTHK");
    boolean isBWCenter=util.PublicVariable.OPERATTING_CENTER.equals("BW");

    String dlgTitle=null;
    if (rdoTypeSC.isSelected()) {
      //reportName=((isNTHKCenter)?"F4_HK_SC_DOC.rpt":"F4_LONG_HK_SC_DOC.rpt");
      if(isNTHKCenter){
        reportName = "F4_HK_SC_DOC.rpt";
      }else if(isBWCenter){
        reportName = "B_F4_LONG_HK_SC_DOC.rpt";
      }else{
        reportName =   "F4_LONG_HK_SC_DOC.rpt";
      }
      dlgTitle="S/C F4 Report";
    } else if (rdoTypeCT.isSelected()) {
      dlgTitle="C/T F4 Report";
      //reportName=((isNTHKCenter)?"F4_HK_CT_DOC.rpt":"F4_LONG_HK_CT_DOC.rpt");
      if(isNTHKCenter){
        reportName = "F4_HK_CT_DOC.rpt";
      }else if(isBWCenter){
        reportName = "B_F4_LONG_HK_CT_DOC.rpt";
      }else{
        reportName =   "F4_LONG_HK_CT_DOC.rpt";
      }
    }

    DlgViewRpt dlg = new DlgViewRpt(
        processhandler.template.Properties.getMainFrame(),
        dlgTitle,
        (rdoTypeSC.isSelected())?genSCReportViewer(reportName):genCTReportViewer(reportName)
        ,true);
    dlg.setSize(700, 500);
    dlg.show();
  }

  void btnQcForm_actionPerformed(ActionEvent e) {
    String reportName=null;
    String dlgTitle=null;
    boolean isBWCenter=util.PublicVariable.OPERATTING_CENTER.equals("BW");
    if(isBWCenter){
      reportName = "B_QC_LONG_HK_CT_DOC.rpt";
    }else{
      reportName =   "QC_LONG_HK_CT_DOC.rpt";
    }
    /*
    if (rdoTypeSC.isSelected()) {
      reportName="QC_LONG_HK_SC_DOC.rpt";
      dlgTitle="S/C QC Report";
    } else if (rdoTypeCT.isSelected()) {
      dlgTitle="C/T QC Report";
      reportName="QC_LONG_HK_CT_DOC.rpt";
    }*/
    DlgViewRpt dlg = new DlgViewRpt(
        processhandler.template.Properties.getMainFrame(),
        dlgTitle,
        (rdoTypeSC.isSelected())?genSCReportViewer(reportName):genCTReportViewer(reportName)
        ,true);
    dlg.setSize(700, 500);
    dlg.show();
  }

  void btnGetSeriesSc_actionPerformed(ActionEvent e) {
   try{
       String subGrpCode;
       //check buyer_prerix_code,sub group code.
       if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.toString().indexOf("|PRODUCTION_BUYER_PREFIX4SC=")!=-1){
         if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_BUYER_PREFIX4SC")==null ||
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_BUYER_PREFIX4SC").toString().trim().length()==0){
            exgui.verification.VerifyLib.showAlert(
           "Pleaes Assigne Buyer Prefix Code In Production Head",
           "Pleaes Assigne Buyer Prefix Code In Production Head");
           return;
         }
         subGrpCode=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_HK_SUBGRP");
         /*
         if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_HK_SUBGRP")==null ||
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_HK_SUBGRP").toString().trim().length()==0){
            exgui.verification.VerifyLib.showAlert(
           "Pleaes Assigne SUB GROUP CODE In Production Head",
           "Pleaes Assigne SUB GROUP CODE In Production Head");
           return;
         }*/

       }else{
         if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_BUYER_PREFIX4SC")==null ||
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_BUYER_PREFIX4SC").toString().trim().length()==0){
           exgui.verification.VerifyLib.showAlert(
               "Pleaes Assigne Buyer Prefix Code In Production Head",
               "Pleaes Assigne Buyer Prefix Code In Production Head");
           return;
         }
         subGrpCode=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_HK_SUBGRP");
         /*
         if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_HK_SUBGRP")==null ||
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_HK_SUBGRP").toString().trim().length()==0){
            exgui.verification.VerifyLib.showAlert(
           "Pleaes Assigne SUB GROUP CODE In Production Head",
           "Pleaes Assigne SUB GROUP CODE In Production Head");
           return;
         }*/

       }

     //show dialog to input the count of sc to generate
     DlgSeriesSc dlgGenScCount=new DlgSeriesSc(util.PublicVariable.APP_FRAME,
                                               "Please Input The Count To Generate S/C",
                                               true,subGrpCode);
     //dlgGenScCount.txtSubGrpCode.setText((subGrpCode==null)?"":subGrpCode);

     dlgGenScCount.setSize(new Dimension(400,230));
     exgui.UIHelper.setToScreenCenter(dlgGenScCount);
     dlgGenScCount.show();
     if(dlgGenScCount.txtCount.getText().trim().length()==0){
       return;
     }
     if(Integer.parseInt(dlgGenScCount.txtCount.getText().trim())<1){
       return;
     }

     util.MiscFunc.showProcessingMessage();
     String strSc[]=handler.getSeriesSC(
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("prod_head_pk"),
      Integer.parseInt(dlgGenScCount.txtCount.getText().trim()),
      dlgGenScCount.dbCbxHKSubGrp.getSelectedValue().toString()
      );
     StringBuffer sb=new StringBuffer();
     if(strSc.length==1){
       sb.append(strSc[0]);
     }else{
       sb.append(strSc[0]);
       sb.append("~");
       sb.append(strSc[strSc.length-1]);
     }
     /*
     for(int i=0;i<strSc.length;i++){
       if(i>0)sb.append(",");
       sb.append(strSc[i]);
     }*/
     exgui.verification.VerifyLib.showPlanMsg(
      "S/C Generated:\n"+sb.toString(),"S/C Generated");
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     exgui.verification.VerifyLib.showAlert(
      "Error While Generating Series S/C\nPlease Contact System Manager",
      "Error While Generating Series S/C");
   }finally{
     util.MiscFunc.hideProcessingMessage();
   }
  }

  void rdoTypeSC_stateChanged(ChangeEvent e) {
    /*
    if(rdoTypeSC.isSelected()){
        cbxCtWithBEF.setEnabled(false);
        cbxCtWithColorCodeName.setEnabled(false);
    }else{
      cbxCtWithBEF.setEnabled(true);
      cbxCtWithColorCodeName.setEnabled(true);
    }*/


     if(rdoTypeCT.isSelected()){
         cbxCtWithBEF.setEnabled(true);
         cbxCtWithColorCodeName.setEnabled(true);
     }else{
       cbxCtWithBEF.setEnabled(false);
       cbxCtWithColorCodeName.setEnabled(false);
     }
  }

}

class PnlNthkOrderPrint_btnDoPrint_actionAdapter implements java.awt.event.ActionListener {
  PnlNthkOrderPrint adaptee;

  PnlNthkOrderPrint_btnDoPrint_actionAdapter(PnlNthkOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnDoPrint_actionPerformed(e);
  }
}

class PnlNthkOrderPrint_btnDirectPrint_actionAdapter implements java.awt.event.ActionListener {
  PnlNthkOrderPrint adaptee;

  PnlNthkOrderPrint_btnDirectPrint_actionAdapter(PnlNthkOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnDirectPrint_actionPerformed(e);
  }
}

class PnlNthkOrderPrint_btnChangeStatus_actionAdapter implements java.awt.event.ActionListener {
  PnlNthkOrderPrint adaptee;

  PnlNthkOrderPrint_btnChangeStatus_actionAdapter(PnlNthkOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnChangeStatus_actionPerformed(e);
  }
}

class PnlNthkOrderPrint_btnF4Form_actionAdapter implements java.awt.event.ActionListener {
  PnlNthkOrderPrint adaptee;

  PnlNthkOrderPrint_btnF4Form_actionAdapter(PnlNthkOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnF4Form_actionPerformed(e);
  }
}

class PnlNthkOrderPrint_btnQcForm_actionAdapter implements java.awt.event.ActionListener {
  PnlNthkOrderPrint adaptee;

  PnlNthkOrderPrint_btnQcForm_actionAdapter(PnlNthkOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQcForm_actionPerformed(e);
  }
}

class PnlNthkOrderPrint_btnGetSeriesSc_actionAdapter implements java.awt.event.ActionListener {
  PnlNthkOrderPrint adaptee;

  PnlNthkOrderPrint_btnGetSeriesSc_actionAdapter(PnlNthkOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetSeriesSc_actionPerformed(e);
  }
}

class PnlNthkOrderPrint_rdoTypeSC_changeAdapter implements javax.swing.event.ChangeListener {
  PnlNthkOrderPrint adaptee;

  PnlNthkOrderPrint_rdoTypeSC_changeAdapter(PnlNthkOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.rdoTypeSC_stateChanged(e);
  }
}

