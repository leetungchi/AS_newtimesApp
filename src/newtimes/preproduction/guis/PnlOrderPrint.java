package newtimes.preproduction.guis;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import com.inet.viewer.ReportViewerBean;
public class PnlOrderPrint extends JPanel {
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel lblOderPrintType = new JLabel();
  JRadioButton rdoTypeSC = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoTypeCT = new JRadioButton();
  JButton btnDoPrint = new JButton();
  static String  REPORT_TYPE_SC_DOC="SC_DOC.rpt";
  static String  REPORT_TYPE_CT_DOC="CT_DOC.rpt";
  JButton btnSndCnfm = new JButton();
  JButton btnReject = new JButton();
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
  JButton btnCbn2Parent = new JButton();
  JButton btnF4Form = new JButton();
  JButton btnQcForm = new JButton();
  JButton btnGetSeriesSc = new JButton();
  JButton btnPiBrooks = new JButton();
  JButton btnOrderChange = new JButton();
  String sc_no;
  JButton btnCtRef = new JButton();
  JButton btnCtNotice = new JButton();
  public PnlOrderPrint() {
    try {
      sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    blueBkgWhiteCharLabel1.setText("===============Order Print===============");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 5, 525, 31));
    this.setLayout(null);
    lblOderPrintType.setFont(new java.awt.Font("Dialog", 1, 11));
    lblOderPrintType.setHorizontalAlignment(SwingConstants.CENTER);
    lblOderPrintType.setText("ORDER TYPE:");
    lblOderPrintType.setBounds(new Rectangle(20, 67, 82, 24));
    rdoTypeSC.setBackground(Color.white);
    rdoTypeSC.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoTypeSC.setHorizontalAlignment(SwingConstants.CENTER);
    rdoTypeSC.setSelected(true);
    rdoTypeSC.setText("S/C");
    rdoTypeSC.setBounds(new Rectangle(105, 67, 65, 24));
    rdoTypeCT.setBackground(Color.white);
    rdoTypeCT.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoTypeCT.setHorizontalAlignment(SwingConstants.CENTER);
    rdoTypeCT.setSelected(false);
    rdoTypeCT.setText("C/T");
    rdoTypeCT.setBounds(new Rectangle(168, 67, 73, 24));
    btnDoPrint.setBounds(new Rectangle(316, 66, 102, 29));
    btnDoPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDoPrint.setHorizontalAlignment(SwingConstants.CENTER);
    btnDoPrint.setText("Special Form");
    btnDoPrint.addActionListener(new PnlOrderPrint_btnDoPrint_actionAdapter(this));
    btnSndCnfm.setBounds(new Rectangle(27, 170, 125, 27));

    btnSndCnfm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSndCnfm.setText("GET S/C No.");
    btnSndCnfm.addActionListener(new PnlOrderPrint_btnSndCnfm_actionAdapter(this));
    btnReject.setBounds(new Rectangle(175, 170, 125, 27));

    btnReject.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReject.setText("Cancel S/C No");
    btnReject.addActionListener(new PnlOrderPrint_btnReject_actionAdapter(this));
    btnDirectPrint.setBounds(new Rectangle(420, 66, 102, 29));
    btnDirectPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDirectPrint.setText("A4 Form");
    btnDirectPrint.addActionListener(new PnlOrderPrint_btnDirectPrint_actionAdapter(this));
    rdoProfit.setBackground(Color.white);
    rdoProfit.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoProfit.setText("PROFIT");
    rdoProfit.setBounds(new Rectangle(239, 67, 76, 24));
    rdoDoc.setBackground(new Color(190, 255, 151));
    rdoDoc.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDoc.setSelected(true);
    rdoDoc.setText("DOC Price");
    rdoDoc.setBounds(new Rectangle(104, 94, 103, 23));
    rdoActPrx.setBackground(new Color(190, 255, 151));
    rdoActPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoActPrx.setText("Act. Price");
    rdoActPrx.setBounds(new Rectangle(207, 94, 108, 23));
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
    btnChangeStatus.addActionListener(new PnlOrderPrint_btnChangeStatus_actionAdapter(this));
    btnCbn2Parent.setBounds(new Rectangle(313, 170, 125, 27));
    btnCbn2Parent.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCbn2Parent.setText("COMBINE S/C");
    btnCbn2Parent.addActionListener(new PnlOrderPrint_btnCbn2Parent_actionAdapter(this));
    btnF4Form.setBounds(new Rectangle(420, 98, 102, 29));
    btnF4Form.setFont(new java.awt.Font("Dialog", 1, 11));
    btnF4Form.setText("F4 Form");
    btnF4Form.addActionListener(new PnlOrderPrint_btnF4Form_actionAdapter(this));
    btnQcForm.setBounds(new Rectangle(524, 98, 102, 29));
    btnQcForm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQcForm.setText("QC Form");
    btnQcForm.addActionListener(new PnlOrderPrint_btnQcForm_actionAdapter(this));
    btnGetSeriesSc.setBounds(new Rectangle(443, 170, 197, 27));
    btnGetSeriesSc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGetSeriesSc.setText("Get Series S/C#");
    btnGetSeriesSc.addActionListener(new PnlOrderPrint_btnGetSeriesSc_actionAdapter(this));
    btnPiBrooks.setBounds(new Rectangle(524, 66, 102, 28));
    btnPiBrooks.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPiBrooks.setSelectedIcon(null);
    btnPiBrooks.setText("PI ");
    btnPiBrooks.addActionListener(new PnlOrderPrint_btnPiBrooks_actionAdapter(this));
    btnOrderChange.addActionListener(new PnlOrderPrint_btnOrderChange_actionAdapter(this));
    btnOrderChange.setText("<html><body>ORDER<br> CHANGE</body></html>");
    btnOrderChange.setSelectedIcon(null);
    btnOrderChange.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOrderChange.setForeground(Color.red);
    btnOrderChange.setBounds(new Rectangle(662, 66, 100, 60));
    btnCtRef.setText("CT REF");
    btnCtRef.addActionListener(new PnlOrderPrint_btnCtRef_actionAdapter(this));
    btnCtRef.setSelectedIcon(null);
    btnCtRef.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCtRef.setBounds(new Rectangle(628, 66, 102, 28));

    btnCtNotice.setText("CT Notice");
   btnCtNotice.addActionListener(new PnlOrderPrint_btnCtNotice_actionAdapter(this));
   btnCtNotice.setSelectedIcon(null);
   btnCtNotice.setFont(new java.awt.Font("Dialog", 1, 11));
   btnCtNotice.setBounds(new Rectangle(628, 99, 102, 27));


    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblOderPrintType, null);
    this.add(rdoTypeSC, null);
    this.add(rdoTypeCT, null);
    buttonGroup1.add(rdoTypeSC);
    buttonGroup1.add(rdoTypeCT);
    this.add(rdoProfit, null);
    this.add(rdoDoc, null);
    this.add(rdoActPrx, null);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(txtSC_rev_no, null);
    this.add(txtCT_rev_no, null);
    this.add(btnSndCnfm, null);
    this.add(btnReject, null);
    this.add(btnChangeStatus, null);
    this.add(btnCbn2Parent, null);
    this.add(btnGetSeriesSc, null);
    btnSndCnfm.setVisible(true);
    btnReject.setVisible(false);
    btnChangeStatus.setVisible(false);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      btnGetSeriesSc.setVisible(true);
    }else{
      btnGetSeriesSc.setVisible(false);
    }

    if (!util.PublicVariable.USER_RECORD.get("USR_DEP_CODE").toString().equals("TPG01") && !util.PublicVariable.USER_RECORD.get("USR_PWD").toString().equals("4918")) {

        btnDirectPrint.setEnabled(false);
    }

    /*==================================
    btnSndCnfm.setVisible(true);
    btnReject.setVisible(true);
    btnChangeStatus.setVisible(true);
   //=====================================*/
    //btnChangeStatus.setVisible(false);
    //is not mis user,can not use send confirm & cancel s/c no button,this is only for TPE center.
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      btnF4Form.setVisible(false);
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      btnQcForm.setVisible(false);
    }

    //if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      String authrizedOfGenCancelSC =
          (String)util.PublicVariable.USER_RECORD.get("ALLOW_CANCEL_SC");
      if (authrizedOfGenCancelSC != null) {
        authrizedOfGenCancelSC = authrizedOfGenCancelSC.trim().toUpperCase();
        if (authrizedOfGenCancelSC.indexOf("C") != -1) {
          btnReject.setVisible(true);
          setChangeStatusButton();
        }
        if (authrizedOfGenCancelSC.indexOf("G") != -1) {
          btnSndCnfm.setVisible(true);
          setChangeStatusButton();
        }
      }
    //}
    buttonGroup1.add(rdoProfit);
    buttonGroup2.add(rdoDoc);
    buttonGroup2.add(rdoActPrx);
    Object objCTRev=
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_ct_revice_no");
    Object objSCRev=
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_sc_revice_no");
    txtSC_rev_no.setText((objSCRev==null)?"0":objSCRev.toString());
    txtCT_rev_no.setText((objCTRev==null)?"0":objCTRev.toString());
    this.add(btnDoPrint, null);
    this.add(btnDirectPrint, null);
    this.add(btnF4Form, null);
    this.add(btnPiBrooks, null);
    this.add(btnCtRef, null);
    this.add(btnQcForm, null);
    this.add(btnCtNotice, null);

    if(util.PublicVariable.OPERATTING_CENTER.equals("001") &&
       util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS&&
      util.ApplicationProperites.getProperties(sc_no+"_order_chage")!=null ){
      this.add(btnOrderChange, null);
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
      boolean alreadyCheckCommission=false;
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
        String styUnit=(String)recSty.get("STY_UNIT");
        if(styUnit==null){
          exgui.verification.VerifyLib.showAlert("Please Assign \"UNIT\" for "+sty_TITLE,
                                                 "Column not assigned yet");
          return false;
        }
        if("PACK".equals(styUnit)||"PACKS".equals(styUnit)){
          Object objPPK=recSty.get("STY_TOP_SMPL");
          if(null==objPPK || Double.parseDouble(objPPK.toString())==0){
            exgui.verification.VerifyLib.showAlert("Please Assign \"PPK\" for "+sty_TITLE,
                                                   "Column not assigned yet");
            return false;
          }
        }

        if("TPH02".equals(prod_record.get("PROD_DEPTMENT"))||"TPH03".equals(prod_record.get("PROD_DEPTMENT"))){
          //check style commission
          if(!alreadyCheckCommission){
              Object buyerComm=recSty.get("STY_BUY_COMM");
              double commPercent=-1;
              if(buyerComm!=null){
                commPercent=Double.parseDouble(buyerComm.toString());
                if(commPercent<5){
                  if(exgui.verification.VerifyLib.showConfirm("Commission under 5%\nDo you Want Continue Processing ?",
                                                              "Commission under 5%",false)){
                    alreadyCheckCommission=true;
                  }else{
                    return false;
                  }
                }
              }

            }
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
             genSCReportViewer(reportName),
             true);
         dlg.setSize(700, 500);
         dlg.show();
       } else if (rdoTypeCT.isSelected()) {
         String reportName=null;
         if(isTPECenter){
           reportName="FORM_CT.rpt";
         }else if(isNTHKCenter){
            reportName="FORM_HK_CT_DOC.rpt";
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

  void btnSndCnfm_actionPerformed(ActionEvent e) {
     try{
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       util.MiscFunc.showProcessingMessage();

       if(!checkConfirm())return;
       if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
         //check buyer brief for S/C No generation.
         String prefixStr=
             (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_BUYER_PREFIX4SC");
         String hkSubGrp=
             (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_HK_SUBGRP");
         if(hkSubGrp==null){
           exgui.verification.VerifyLib.showAlert("Please Assigne Sub Group Code",
                                                  "Please Assigne Sub Group Code");
           return;
         }
         if(prefixStr==null){
           exgui.verification.VerifyLib.showAlert("Please Assigne Buyer Prefix,1 Charater",
                                                  "Please Assigne Buyer Prefix");
           return;
         }
         if(prefixStr.length()>2){
           exgui.verification.VerifyLib.showAlert("Please  Buyer Prefix Only Allow One Charater",
                                                  "Please Assigne Buyer Prefix");
           return;
         }
       }
       //if is ashworsh & sample type production.have to test commission
       if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
         if(82==newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER") &&
            "Y".equals(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_IS_SAMPLE"))){
            java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                  util.PublicVariable.USER_RECORD,
                  "select count(*) from style where prod_head_pk="+newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK+
                " and record_delete_flag='1' and sty_buy_comm >0 ",1,9999);
            Record recTestBuyerComm=(Record)vct.get(0);
            if(recTestBuyerComm.getInt(0)>0){
              exgui.verification.VerifyLib.showAlert("For Sample Product\nThe Style's Buyer Commission should be Zero",
                                                     "Buyer Commission Error");
              return;
            }

         }
       }
       /*
       newtimes.production.process.audit_sc_ct.DB_ProdAudits handler=
           new newtimes.production.process.audit_sc_ct.DB_ProdAudits();
       */
      /*
      if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_DEPTMENT").toString().equals(
        "TPQ01")){
           DlgAssigneQQSC dlgQQSC=new DlgAssigneQQSC(util.PublicVariable.APP_FRAME,"Assigne S/C",true);
           dlgQQSC.setSize(400,185);
           exgui.UIHelper.setToScreenCenter(dlgQQSC);
           util.MiscFunc.hideProcessingMessage();
           dlgQQSC.show();
           if(0==dlgQQSC.txtSC.getText().trim().length())return;
      }
*/
       //System.out.println("b4 up2cnfm ,current editing head rocrod is:"+newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.toString());
       database.datatype.Record xxrec=(database.datatype.Record)
         handler.getRecordByPk(
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("prod_head_pk")
         );

      System.out.println("->"+(String)xxrec.get("prod_sc_no"));

       handler.update2Confirm(null);



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
       "S/C No:"+
       (String)rec.get("prod_sc_no")+
       " Generated\nPlease Re-enter Production Editing Unit",
       "Get S/C No. OK");
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

  void btnReject_actionPerformed(ActionEvent e) {
      //for rejection,we need to check if shipping qty greater than zero
      try{
        //first,have to check if shipped
        StringBuffer sb=new StringBuffer();
        sb.append("select shipping.ship_etd_date,ship_sc.* from ship_sc ,shipping ");
        sb.append("where shipping.ship_no=ship_sc.ship_no and shipping.record_delete_flag='1' and ship_sc.PROD_HEAD_PK in ");
        sb.append("(select prod_head_pk from production where prod_sc_no ='");
        sb.append((String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no"));
        sb.append("')");

       java.util.Vector vctChkShip=
         exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           sb.toString(),
           1,99999
         );
        if(vctChkShip.size()>0){
          exgui.verification.VerifyLib.showAlert("Sorry,This Production Is Shipped,Can Not Cancel It",
                                                 "Production shipped");
          return;
        }

        //if this record is combined with child record,alert uer.
        String combinedList=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_COMBIN_PK_LIST");
        if(combinedList!=null && combinedList.trim().length()>0){
          exgui.verification.VerifyLib.showAlert("Production:"+combinedList+" Combined With This Record\n"+
                                                 "Please Cancel S/C No. Of Combined  Record(s) Firstly",
                                                 "Please Cancel S/C No. Of Combined Records");
          return;
        }

        //ask user to input reason of cancelation.
        String result=JOptionPane.showInputDialog(
         util.PublicVariable.APP_FRAME,
          "Please Input Reason Of Cancellation:","S/C Cancel Reason",
          JOptionPane.QUESTION_MESSAGE);
        if(result==null)return;
        if(result.trim().length()==0){
          exgui.verification.VerifyLib.showPlanMsg("Reason Can not be empty",
                                                   "Please Input Reason");
          return;
        }
        if(result.trim().getBytes().length>500){
          exgui.verification.VerifyLib.showPlanMsg("Reason Can not Over 500 Characters",
                                                   "Reason Is Too Long");
          return;
        }

        newtimes.production.ProdMaintain_Properties.setWaitCursor();
        util.MiscFunc.showProcessingMessage();
        /*
        newtimes.production.process.audit_sc_ct.DB_ProdAudits handler=
            new newtimes.production.process.audit_sc_ct.DB_ProdAudits();
        */

         handler.cancelSC_No(result);
         util.MiscFunc.hideProcessingMessage();
         exgui.verification.VerifyLib.showPlanMsg(
        "Production S/C No Canceled.\nPlease Re-enter Production Editing Unit",
        "Please Re-Enter Production Editing Unit");

      }catch(newtimesejb.preproduction.AlreadyShippedException ase){
        util.MiscFunc.hideProcessingMessage();
        exgui.verification.VerifyLib.showPlanMsg(
       "Production Shipped\nCan Not Cancel S/C No.","Production Shipped");
      }catch(Exception exp){
        util.MiscFunc.hideProcessingMessage();
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert(
        "Connection Fail\nPlease Contact System Manager",
        "Exception of EJB Connection");
      }finally{
        util.MiscFunc.hideProcessingMessage();
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
  }
  protected String get_PK_List(int _prodSeq)throws Exception{
    Object combinPK=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_COMBIN_PARENT_PK");
    String combinPKList=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_COMBIN_PK_LIST");
    StringBuffer sb=new StringBuffer();
    if(combinPK!=null){
      //there is parent record,find it ,and append it
      Record parentProdPk=
          newtimes.preproduction.process.DB_Preprod.getInstance().findbyPk(Integer.parseInt(combinPK.toString()));
      combinPKList=(String)parentProdPk.get("PRODUCTION_COMBIN_PK_LIST");
      sb.append("[");
      sb.append(combinPK.toString());
      sb.append(",");
      sb.append(combinPKList);
      sb.append("]");
    }else{
      //this is a head production,in the combine list,also combine self please.
      if(combinPKList!=null){
        sb.append("[");
        sb.append(String.valueOf(_prodSeq));
        sb.append(",");
        sb.append(combinPKList);
        sb.append("]");
      }else{
        sb.append("[");sb.append(String.valueOf(_prodSeq));sb.append("]");
      }
    }
    return sb.toString();
  }
  protected JPanel genCTReportViewer(String rpt_name){
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      Object lastPrintOutCountObj=
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
      "production_print_count");
      int lastPrintCount=
          (lastPrintOutCountObj==null)?0:Integer.parseInt(lastPrintOutCountObj.toString());
      int ct_rev_no=Integer.parseInt(txtCT_rev_no.getText().trim());

      lastPrintCount++;
      int _prodSeq=
           newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
       handler.updatePrintStatus(lastPrintCount,-1,ct_rev_no);
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set("production_ct_revice_no",ct_rev_no);
       newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
       java.util.HashMap mp=new java.util.HashMap();
       mp.put("iprod_head_pk",String.valueOf(_prodSeq));
       mp.put("prod_pk",String.valueOf(_prodSeq));
       mp.put("prod_head_pk",String.valueOf(_prodSeq));
       mp.put("times",String.valueOf(lastPrintCount));
       mp.put("P_CT_SEQ","0");
       if(rdoActPrx.isSelected())
          mp.put("doc_act","2");
       else
          mp.put("doc_act","1");
         //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt(rpt_name,null,mp);
         //com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
         newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,rpt_name,mp);
         if (rpt_name == "CT_NOTICE.rpt" )
        {
           viewer.setReportName("http://rpt2.nttpe.com.tw:9000/?file:////rpt//CT_NOTICE.rpt");
        }

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
           reportName="HK_CT_DOC.rpt";
        }else if(isBWCenter){
          reportName="B_LONG_HK_CT_DOC.rpt";
        }else{
          reportName=  "LONG_HK_CT_DOC.rpt";
        }

        DlgViewRpt dlg = new DlgViewRpt(
            processhandler.template.Properties.getMainFrame(),
            "C/T report",genCTReportViewer(reportName),true);
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

  void btnCbn2Parent_actionPerformed(ActionEvent e) {

    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      if(!checkConfirm())return;
      util.MiscFunc.hideProcessingMessage();
      DlgListSC4Combine dlgListSc=new  DlgListSC4Combine(
         util.PublicVariable.APP_FRAME,"SELECT BUYER S/C NO TO COMBINE",true,
         (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_CEN_CODE"),
         (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_DEPTMENT"),
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER"));
        dlgListSc.setSize(400,350);
        exgui.UIHelper.setToScreenCenter(dlgListSc); dlgListSc.show();
        if(dlgListSc.getSelectedSC()==null)return;
        if(dlgListSc.getDialogStatus()!=dlgListSc.STATUS_CLOSE_NORMALLY )return;
        String sc=dlgListSc.getSelectedSC();
      util.MiscFunc.showProcessingMessage();
        handler.combineProdHead(sc);
      database.datatype.Record rec=(database.datatype.Record)
          handler.getRecordByPk(
             newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("prod_head_pk")
          );
      processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(rec);
      newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showPlanMsg(
      "S/C No:"+
      (String)rec.get("prod_sc_no")+
      " Generated\nPlease Re-enter Production Editing Unit",
      "Get S/C No. OK");
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
     reportName = "CT_DOC_REF_QC.rpt";
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
     //check buyer_prerix_code
     if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.toString().indexOf("|PRODUCTION_BUYER_PREFIX4SC=")!=-1){
       if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_BUYER_PREFIX4SC")==null ||
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_BUYER_PREFIX4SC").toString().trim().length()==0){
          exgui.verification.VerifyLib.showAlert(
         "Pleaes Assigne Buyer Prefix Code In Production Head",
         "Pleaes Assigne Buyer Prefix Code In Production Head");
         return;
       }
       if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_HK_SUBGRP")==null ||
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_HK_SUBGRP").toString().trim().length()==0){
          exgui.verification.VerifyLib.showAlert(
         "Pleaes Assigne SUB GROUP CODE In Production Head",
         "Pleaes Assigne SUB GROUP CODE In Production Head");
         return;
       }

     }else{
       if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_BUYER_PREFIX4SC")==null ||
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_BUYER_PREFIX4SC").toString().trim().length()==0){
         exgui.verification.VerifyLib.showAlert(
             "Pleaes Assigne Buyer Prefix Code In Production Head",
             "Pleaes Assigne Buyer Prefix Code In Production Head");
         return;
       }
       if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_HK_SUBGRP")==null ||
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_HK_SUBGRP").toString().trim().length()==0){
          exgui.verification.VerifyLib.showAlert(
         "Pleaes Assigne SUB GROUP CODE In Production Head",
         "Pleaes Assigne SUB GROUP CODE In Production Head");
         return;
       }

     }
     //show dialog to input the count of sc to generate
     DlgSeriesSc dlgGenScCount=new DlgSeriesSc(util.PublicVariable.APP_FRAME,
                                               "Please Input The Count To Generate S/C",
                                               true,null);
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
      Integer.parseInt(dlgGenScCount.txtCount.getText().trim()),null
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

  void btnPiBrooks_actionPerformed(ActionEvent e) {
    //if buuer is "JOE-ANNE",report name is PI_OJE.rpt

    String piReport="PI_STANDARD.rpt";
    try{
      String pay_term = (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_PYT_TRM");
      if (pay_term.equals("L/C") && (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER") == 12327)) {
          piReport="PI_STANDARD_LC.rpt";
      }
/*
      if (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(
          "PROD_BUYER") == 8374) {
        piReport = "PI_JOE.rpt";
      }
 */
      //for THE WORLDS GLOBAL SOURCE, LLC
      if (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(
          "PROD_BUYER") == 7530) {
        piReport = "PI_WORLD.rpt";
      }
      //buyer BARCO
      if (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(
          "PROD_BUYER") == 12098) {
        piReport = "PI_BARCO.rpt";
      }
      // BUYER brooks
      if (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(
        "PROD_BUYER") == 8898) {
      piReport = "PI_BROOKS.rpt";
    }


      //if agent is STUIDO HOAC,set to PI_STUDIO.rpt.
      Object objAgent=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_AGENT");
      if ((objAgent!=null) && (objAgent.toString().length()>0) && (Integer.parseInt(objAgent.toString())==11612)) {
        piReport = "PI_STUDIO.rpt";
      }

    //if buyer is so low,pi is for PI_Stuidio.rpt.
    if (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(
        "PROD_BUYER") == 166) {
      piReport = "PI_STUDIO.rpt";
    }

    }catch(Exception exp){
      exp.printStackTrace();
    }
    DlgViewRpt dlg = new DlgViewRpt(
     processhandler.template.Properties.getMainFrame(),
     "PI REPORT",
     genSCReportViewer(piReport),
     true);
    dlg.setSize(700, 500);
    dlg.show();

  }

  void btnOrderChange_actionPerformed(ActionEvent e) {
    util.MiscFunc.showProcessingMessage();
    try{
      newtimesejb.TPE_MIS.TpeMisFuncHome tpeMisEjbHome =
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.
          PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc tpeMISejb = tpeMisEjbHome.create();
      java.util.HashMap hm = new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE", "GET_ORDER_CHANGE_TEXT");
      hm.put("SC_NO", sc_no);
      String verNo=(String)util.ApplicationProperites.getProperties(sc_no+"_order_chage");
      hm.put("VER_NO",verNo);
      java.util.HashMap hmResult = tpeMISejb.tpeMisFunc(hm);
      String txtCmpData = (String)hmResult.get("COMP_RESULT");
      util.MiscFunc.hideProcessingMessage();
      //System.out.println(txtCmpData);
      DlgOrderChagneContext dlg=new DlgOrderChagneContext();
      dlg.setSize(560,475);
      dlg.txtOrderChagne.setText(txtCmpData);
      dlg.show();
  }catch(Exception exp){
    exp.printStackTrace();
    util.ExceptionLog.exp2File(exp,"");
    exgui.verification.VerifyLib.showAlert("ERROR WHILE GENERATING ORDER CHAGNE TEXT\nPlease Contact System Manager",
                                           "Server Side Error");
  }

  }

  void btnCtRef_actionPerformed(ActionEvent e) {
    try{
      Object objSCNO = newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_SC_NO");
      if(objSCNO==null || objSCNO.toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("NO S/C#","NO S/C#");
        return;
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    String rptName="CT_DOC_REF.rpt";
    DlgViewRpt dlg = new DlgViewRpt(
        processhandler.template.Properties.getMainFrame(),
        "C/T REF",genCTReportViewer(rptName),true);
    dlg.setSize(700, 500);
    dlg.show();

  }
  void btnCtNotice_actionPerformed(ActionEvent e) {
    /* try{
      Object objSCNO = newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_SC_NO");
      if(objSCNO==null || objSCNO.toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("NO S/C#","NO S/C#");
        return;
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    } */
    String rptName="CT_NOTICE.rpt";
    DlgViewRpt dlg = new DlgViewRpt(
        processhandler.template.Properties.getMainFrame(),
        "C/T NOTICE",genCTReportViewer(rptName),true);
    dlg.setSize(700, 500);
    dlg.show();

  }

}

class PnlOrderPrint_btnDoPrint_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnDoPrint_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnDoPrint_actionPerformed(e);
  }
}

class PnlOrderPrint_btnSndCnfm_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnSndCnfm_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnSndCnfm_actionPerformed(e);
  }
}

class PnlOrderPrint_btnReject_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnReject_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnReject_actionPerformed(e);
  }
}

class PnlOrderPrint_btnDirectPrint_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnDirectPrint_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnDirectPrint_actionPerformed(e);
  }
}

class PnlOrderPrint_btnChangeStatus_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnChangeStatus_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnChangeStatus_actionPerformed(e);
  }
}

class PnlOrderPrint_btnCbn2Parent_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnCbn2Parent_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCbn2Parent_actionPerformed(e);
  }
}

class PnlOrderPrint_btnF4Form_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnF4Form_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnF4Form_actionPerformed(e);
  }
}

class PnlOrderPrint_btnQcForm_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnQcForm_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQcForm_actionPerformed(e);
  }
}

class PnlOrderPrint_btnGetSeriesSc_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnGetSeriesSc_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetSeriesSc_actionPerformed(e);
  }
}

class PnlOrderPrint_btnPiBrooks_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnPiBrooks_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnPiBrooks_actionPerformed(e);
  }
}

class PnlOrderPrint_btnOrderChange_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnOrderChange_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnOrderChange_actionPerformed(e);
  }
}

class PnlOrderPrint_btnCtRef_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnCtRef_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCtRef_actionPerformed(e);
  }
}
class PnlOrderPrint_btnCtNotice_actionAdapter implements java.awt.event.ActionListener {
  PnlOrderPrint adaptee;

  PnlOrderPrint_btnCtNotice_actionAdapter(PnlOrderPrint adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCtNotice_actionPerformed(e);
  }
}

