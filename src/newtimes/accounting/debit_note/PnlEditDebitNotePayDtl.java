package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import exgui.ultratable.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditDebitNotePayDtl
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor{
  BlueBkgWhiteCharLabel lblTitle = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblDdCrNo = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtStyItem = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblDdCrNo2 = new WhiteBkgBlueCharLabel();
  JTextField txtMerchRef = new JTextField();
  JComboBox cbxFactory = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JTextField txtFtyInv = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo3 = new WhiteBkgBlueCharLabel();
  JTextField txtCV_NO = new JTextField();
  JTextField txtReceiptNo = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo4 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCurrency = new JComboBox();
  JTextField txtFullAmt = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  JTextField txtOffAmt1 = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo5 = new WhiteBkgBlueCharLabel();
  JTextField txtOffDate1 = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo6 = new WhiteBkgBlueCharLabel();
  JTextField txtOffDate2 = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo7 = new WhiteBkgBlueCharLabel();
  JTextField txtOffAmt2 = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo8 = new WhiteBkgBlueCharLabel();
  JTextField txtRemark = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblBuyerMakerNameFromDbCrHead = new BlueBkgWhiteCharLabel();
  DataBindComboboxTable dbCbxTblMerchID = new DataBindComboboxTable();
  WhiteBkgBlueCharLabel lblDdCrNo9 = new WhiteBkgBlueCharLabel();
  JTextField txtYear = new JTextField();
  WhiteBkgBlueCharLabel lblDdCrNo10 = new WhiteBkgBlueCharLabel();
  JTextField txtSZN = new JTextField();

  public PnlEditDebitNotePayDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    lblTitle.setFont(new java.awt.Font("Dialog", 1, 16));
    lblTitle.setText("細項編輯");
    lblTitle.setBounds(new Rectangle(-2, 16, 614, 28));
    this.setLayout(null);
    this.setFont(new java.awt.Font("DialogInput", 0, 11));
    lblDdCrNo.setText("DEBIT-NOTE :");
    lblDdCrNo.setBounds(new Rectangle(-1, 42, 612, 28));
    blueBkgWhiteCharLabel1.setText("BUYER:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(11, 85, 110, 26));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(353, 85, 106, 26));
    blueBkgWhiteCharLabel2.setText("STYLE ITEM:");
    txtStyItem.setText("");
    txtStyItem.setBounds(new Rectangle(459, 85, 128, 26));
    lblDdCrNo1.setBounds(new Rectangle(11, 118, 110, 26));
    lblDdCrNo1.setText("MERCH-ID");
    lblDdCrNo2.setText("MERCH-REF");
    lblDdCrNo2.setBounds(new Rectangle(353, 118, 106, 26));
    txtMerchRef.setBounds(new Rectangle(459, 118, 128, 26));
    txtMerchRef.setText("");
    cbxFactory.setBounds(new Rectangle(121, 150, 228, 26));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(11, 150, 110, 26));
    blueBkgWhiteCharLabel3.setText("FACTORY:");
    blueBkgWhiteCharLabel4.setText("FTY-INV");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(353, 150, 106, 26));
    txtFtyInv.setBounds(new Rectangle(459, 150, 128, 26));
    txtFtyInv.setText("");
    lblDdCrNo3.setBounds(new Rectangle(11, 180, 110, 26));
    lblDdCrNo3.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo3.setText("傳票號碼");
    txtCV_NO.setText("");
    txtCV_NO.setBounds(new Rectangle(121, 180, 228, 26));
    txtReceiptNo.setBounds(new Rectangle(459, 180, 128, 26));
    txtReceiptNo.setText("");
    lblDdCrNo4.setText("發票號碼");
    lblDdCrNo4.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo4.setBounds(new Rectangle(354, 180, 106, 26));
    blueBkgWhiteCharLabel5.setText("CURRENCY");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(11, 210, 110, 26));
    cbxCurrency.setBounds(new Rectangle(121, 210, 228, 26));
    txtFullAmt.setText("");
    txtFullAmt.setBounds(new Rectangle(459, 210, 128, 26));
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(354, 210, 106, 26));
    blueBkgWhiteCharLabel6.setText("FULL AMOUNT");
    txtOffAmt1.setText("");
    txtOffAmt1.setBounds(new Rectangle(318, 242, 71, 26));
    lblDdCrNo5.setBounds(new Rectangle(194, 242, 124, 26));
    lblDdCrNo5.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo5.setText("OFF AMOUNT1");
    txtOffDate1.setText("");
    txtOffDate1.setBounds(new Rectangle(121, 242, 71, 26));
    lblDdCrNo6.setText("OFF DATE 1");
    lblDdCrNo6.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo6.setBounds(new Rectangle(11, 242, 110, 26));
    txtOffDate2.setText("");
    txtOffDate2.setBounds(new Rectangle(121, 272, 71, 26));
    lblDdCrNo7.setText("OFF AMOUNT2");
    lblDdCrNo7.setBackground(new Color(143, 143, 188));
    lblDdCrNo7.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo7.setForeground(Color.white);
    lblDdCrNo7.setBounds(new Rectangle(194, 272, 124, 26));
    txtOffAmt2.setBounds(new Rectangle(318, 272, 71, 26));
    txtOffAmt2.setText("");
    lblDdCrNo8.setBounds(new Rectangle(11, 272, 110, 26));
    lblDdCrNo8.setBackground(new Color(143, 143, 188));
    lblDdCrNo8.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo8.setForeground(Color.white);
    lblDdCrNo8.setText("OFF DATE 2");
    txtRemark.setText("");
    txtRemark.setBounds(new Rectangle(121, 301, 467, 26));
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(11, 301, 110, 26));
    blueBkgWhiteCharLabel7.setText("REMARK");
    lblBuyerMakerNameFromDbCrHead.setBounds(new Rectangle(121, 85, 227, 26));
    lblBuyerMakerNameFromDbCrHead.setText("BUYER:");
    dbCbxTblMerchID.setBounds(new Rectangle(122, 118, 225, 26));
    lblDdCrNo9.setText("YEAR");
    lblDdCrNo9.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo9.setBounds(new Rectangle(391, 242, 124, 26));
    txtYear.setBounds(new Rectangle(515, 242, 71, 26));
    txtYear.setText("");
    lblDdCrNo10.setBounds(new Rectangle(391, 272, 124, 26));
    lblDdCrNo10.setForeground(Color.white);
    lblDdCrNo10.setFont(new java.awt.Font("Dialog", 0, 16));
    lblDdCrNo10.setBackground(new Color(143, 143, 188));
    lblDdCrNo10.setText("SEASON");
    txtSZN.setText("");
    txtSZN.setBounds(new Rectangle(515, 272, 71, 26));
    this.add(lblTitle, null);
    this.add(lblDdCrNo, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblDdCrNo1, null);
    this.add(cbxFactory, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtCV_NO, null);
    this.add(lblDdCrNo3, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(cbxCurrency, null);
    this.add(txtOffDate1, null);
    this.add(lblDdCrNo6, null);
    this.add(txtOffDate2, null);
    this.add(lblDdCrNo8, null);
    this.add(txtRemark, null);
    this.add(blueBkgWhiteCharLabel7, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtStyItem, null);
    this.add(lblDdCrNo2, null);
    this.add(txtMerchRef, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtFtyInv, null);
    this.add(lblDdCrNo4, null);
    this.add(txtReceiptNo, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(txtFullAmt, null);
    this.add(lblBuyerMakerNameFromDbCrHead, null);
    this.add(dbCbxTblMerchID, null);
    this.add(lblDdCrNo7, null);
    this.add(lblDdCrNo5, null);
    this.add(txtOffAmt1, null);
    this.add(txtOffAmt2, null);
    this.add(lblDdCrNo9, null);
    this.add(txtYear, null);
    this.add(lblDdCrNo10, null);
    this.add(txtSZN, null);
    cbxFactory.setEditable(true);
  }
  public void record2Gui(){
    try{
      util.MiscFunc.showProcessingMessage();
      if(recToMapping.getInt(0)<1){
        lblTitle.setText("細項新增");
      }
      lblDdCrNo.setText("DEBIT-NOTE :"+(String)recToMapping.get(1));

    dataBoundGUIs.clear();

    Object vftxtStyItem=exgui.verification.CellFormat.getOrdinaryField(20);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtStyItem,"DBNT_PAYDTL_STY_ITEM",recToMapping.get("DBNT_PAYDTL_STY_ITEM"),20,(exgui.Object2String)vftxtStyItem,(exgui.ultratable.CellTxtEditorFormat)vftxtStyItem)
    );
    Object vftxtMerchRef=exgui.verification.CellFormat.getOrdinaryField(20);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtMerchRef,"DBNT_PAYDTL_MERCHREF",recToMapping.get("DBNT_PAYDTL_MERCHREF"),20,(exgui.Object2String)vftxtMerchRef,(exgui.ultratable.CellTxtEditorFormat)vftxtMerchRef)
    );
    Object vftxtFtyInv=exgui.verification.CellFormat.getOrdinaryField(20);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFtyInv,"DBNT_PAYDTL_FTY_INV",recToMapping.get("DBNT_PAYDTL_FTY_INV"),20,(exgui.Object2String)vftxtFtyInv,(exgui.ultratable.CellTxtEditorFormat)vftxtFtyInv)
    );
    Object vftxtCV_NO=exgui.verification.CellFormat.getOrdinaryField(20);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCV_NO,"DBNT_PAYDTL_CV",recToMapping.get("DBNT_PAYDTL_CV"),20,(exgui.Object2String)vftxtCV_NO,(exgui.ultratable.CellTxtEditorFormat)vftxtCV_NO)
    );
    Object vftxtReceiptNo=exgui.verification.CellFormat.getOrdinaryField(20);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtReceiptNo,"DBNT_PAYDTL_RCPT",recToMapping.get("DBNT_PAYDTL_RCPT"),20,(exgui.Object2String)vftxtReceiptNo,(exgui.ultratable.CellTxtEditorFormat)vftxtReceiptNo)
    );
     txtFullAmt.setHorizontalAlignment(txtFullAmt.RIGHT);
    Object vftxtFullAmt=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFullAmt,"DBNT_PAYDTL_FULLAMT",recToMapping.get("DBNT_PAYDTL_FULLAMT"),11,(exgui.Object2String)vftxtFullAmt,(exgui.ultratable.CellTxtEditorFormat)vftxtFullAmt)
    );
    txtOffAmt1.setHorizontalAlignment(txtFullAmt.RIGHT);
    Object vftxtOffAmt1=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtOffAmt1,"DBNT_PAYDTL_OFFAMT1",recToMapping.get("DBNT_PAYDTL_OFFAMT1"),11,(exgui.Object2String)vftxtOffAmt1,(exgui.ultratable.CellTxtEditorFormat)vftxtOffAmt1)
    );
    Object vftxtOffDate1=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtOffDate1,"DBNT_PAYDTL_OFFDATE1",
         recToMapping.get("DBNT_PAYDTL_OFFDATE1"),10,
         (exgui.Object2String)vftxtOffDate1,
         (exgui.ultratable.CellTxtEditorFormat)vftxtOffDate1)
    );
     dataBoundGUIs.add( new exgui.DataBindTextWithChecker
                        (txtOffDate2,"DBNT_PAYDTL_OFFDATE2",
                         recToMapping.get("DBNT_PAYDTL_OFFDATE2"),10,
                         (exgui.Object2String)vftxtOffDate1,
                         (exgui.ultratable.CellTxtEditorFormat)vftxtOffDate1)
    );
  txtOffAmt2.setHorizontalAlignment(txtOffAmt2.RIGHT);
    Object vftxtOffAmt2=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtOffAmt2,"DBNT_PAYDTL_OFFAMT2",recToMapping.get("DBNT_PAYDTL_OFFAMT2"),11,(exgui.Object2String)vftxtOffAmt2,(exgui.ultratable.CellTxtEditorFormat)vftxtOffAmt2)
    );
    Object vftxtRemark=exgui.verification.CellFormat.getOrdinaryField(250);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtRemark,"DBNT_PAYDTL_DESC",recToMapping.get("DBNT_PAYDTL_DESC"),250,(exgui.Object2String)vftxtRemark,(exgui.ultratable.CellTxtEditorFormat)vftxtRemark)
    );
     //select nvl(buyer_maker.BYMKR_CHINESE_BRIEF,buyer_maker.BYMKR_NAME) as bymker_tmp_name
     //from buyer_maker where selectable_center  like '%,001,%' and buyer_maker.BYMKR_MULTI_TYPE like '%,1,%'
     if(Constans.VCT_BUYERNAMES ==null){
       Constans.VCT_BUYERNAMES=
           exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                "select nvl(buyer_maker.BYMKR_CHINESE_BRIEF,buyer_maker.BYMKR_NAME) as bymker_tmp_name  "+
                "from buyer_maker where selectable_center  like '%,001,%' and buyer_maker.BYMKR_MULTI_TYPE like '%,1,%'"+
                " order by bymker_tmp_name"
                ,1,99999);
     }
     lblBuyerMakerNameFromDbCrHead.setText((String)Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(4));
     recToMapping.set("DBNT_PAYDTL_BUYERNAME",lblBuyerMakerNameFromDbCrHead.getText());
    /*
    java.util.Vector vctBuyer= Constans.VCT_BUYERNAMES;
    exgui.DataBindEditableJCombobox  DbJcbxcbxBuyer =
        new exgui.DataBindEditableJCombobox(cbxBuyer,"DBNT_PAYDTL_BUYERNAME",vctBuyer,
                                    "BYMKER_TMP_NAME","BYMKER_TMP_NAME",
                                    recToMapping.get("DBNT_PAYDTL_BUYERNAME"),100);

    dataBoundGUIs.add(DbJcbxcbxBuyer);*/

    //cbxBuyer.setUI(new exgui.WideComboBoxUI(200));


    if(Constans.VCT_MERCH ==null){
      Constans.VCT_MERCH=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
               "select * from debitnote_user where cen_code='"+util.PublicVariable.OPERATTING_CENTER+"' order by usr_name "
               ,1,99999);
    }



    java.util.Vector dbntUsers=Constans.VCT_MERCH;
    /*
    exgui.DataBindJCombobox DbJcbxcbxMerchID = new exgui.DataBindJCombobox(
                                   cbxMerchID,"DBNT_PAYDTL_MERCHID",
                                   dbntUsers,"USR_NAME","USR_CODE",
                                   recToMapping.get("DBNT_PAYDTL_MERCHID"),"",null);
    dataBoundGUIs.add(DbJcbxcbxMerchID);
    */
   util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
   iso.put("CODE","USR_CODE");
   iso.put("姓名","USR_NAME");
   iso.put("NAME","USR_ENG_NAME");
   dbCbxTblMerchID.init("DBNT_PAYDTL_MERCHID", dbntUsers, iso, 250, 150, "USR_CODE", "USR_CODE", recToMapping.get("DBNT_PAYDTL_MERCHID"));
   dataBoundGUIs.add(dbCbxTblMerchID);


      /*
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(txtMerchId,
                                            "DBNT_PAYDTL_MERCHID",
                                            recToMapping.get("DBNT_PAYDTL_MERCHID"),10,
                                            (exgui.Object2String)vftxtFtyInv,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtFtyInv)
      );*/


    //select nvl(buyer_maker.BYMKR_CHINESE_BRIEF,buyer_maker.BYMKR_NAME) as bymker_tmp_name
    //from buyer_maker where selectable_center  like '%,001,%' and buyer_maker.BYMKR_MULTI_TYPE like '%,2,%'

    if(Constans.VCT_FTY_NAMES==null){
      Constans.VCT_FTY_NAMES=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
               "select nvl(buyer_maker.BYMKR_CHINESE_BRIEF,buyer_maker.BYMKR_NAME) as bymker_tmp_name  "+
               "from buyer_maker where selectable_center  like '%,001,%' and buyer_maker.BYMKR_MULTI_TYPE like '%,2,%'"+
               " order by bymker_tmp_name"
               ,1,99999);
    }


    java.util.Vector vctFty=Constans.VCT_FTY_NAMES;


      exgui.DataBindEditableJCombobox DbJcbxcbxFactory =
               new exgui.DataBindEditableJCombobox(cbxFactory,
                                           "DBNT_PAYDTL_FTY",
                                           vctFty,
                                           "BYMKER_TMP_NAME","BYMKER_TMP_NAME",
                                           recToMapping.get("DBNT_PAYDTL_FTY"),100);


   dataBoundGUIs.add(DbJcbxcbxFactory);
   //cbxFactory.setUI(new exgui.WideComboBoxUI(200));

   exgui.DataBindJCombobox DbJcbxcbxCurrency =
       new exgui.DataBindJCombobox(cbxCurrency,"DBNT_PAYDTL_CURRENCY",
                                   newtimes.preproduction.guis.tempProperties.tmpCurrency
                                   ,"CRNCY_NAME","CRNCY_NAME",
                                   recToMapping.get("DBNT_PAYDTL_CURRENCY"));
   dataBoundGUIs.add(DbJcbxcbxCurrency);

   Object vftxtyear=exgui.verification.CellFormat.getOrdinaryField(2);
   dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtYear,
                                        "DBNT_PAYDTL_YEAR",
                                        recToMapping.get("DBNT_PAYDTL_YEAR"),2,
                                        (exgui.Object2String)vftxtyear,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtyear));


      Object vftxtSZN=exgui.verification.CellFormat.getOrdinaryField(3);
      dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(txtSZN,
                                           "DBNT_PAYDTL_SZN",
                                           recToMapping.get("DBNT_PAYDTL_SZN"),3,
                                           (exgui.Object2String)vftxtSZN,
                                           (exgui.ultratable.CellTxtEditorFormat)vftxtSZN));



    //((javax.swing.text.JTextComponent)cbxBuyer.getEditor().getEditorComponent()).setCaretPosition(0);
    ((javax.swing.text.JTextComponent)cbxFactory.getEditor().getEditorComponent()).setCaretPosition(0);

  }catch(Exception exp){
      exp.printStackTrace();
  }finally{
     util.MiscFunc.hideProcessingMessage();
  }

 }
 public boolean gui2Record(){
   return super.gui2Record();
 }
 public boolean isContextModified(){return false ;}
 public void doUpdate(){
   java.util.Vector vct=new java.util.Vector();
   try{
     recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
     vct.add(recToMapping);
     dbprc.updateRecords(vct);
   }catch(Exception exp){
     exp.printStackTrace();
     exgui.verification.VerifyLib.showAlert("Update Fail !!\nPlease Contact System Manager","Update Fail");
   }
 }
 public void doDelete(){
   java.util.Vector vct=new java.util.Vector();
   try{
     recToMapping.set("record_delete_flag","0");
     recToMapping.set("record_delete_user",util.PublicVariable.USER_RECORD.get(0));
     vct.add(recToMapping);
     dbprc.updateRecords(vct);
   }catch(Exception exp){
     exp.printStackTrace();
     exgui.verification.VerifyLib.showAlert("Update Fail !!\nPlease Contact System Manager","Update Fail");
   }

 }
  public void doPrint(){}
}
