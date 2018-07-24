package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditDebitNoteHead
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
   java.text.NumberFormat nf=new java.text.DecimalFormat("##########0.00");
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  JButton btnGotoDetail = new JButton();
  WhiteBkgBlueCharLabel lblDebitNoteNoTitle = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblDebitNoteNo = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel lblBranch = new BlueBkgWhiteCharLabel();
  JComboBox cbxBranch = new JComboBox();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  WhiteBkgBlueCharLabel lblBuyerMaker = new WhiteBkgBlueCharLabel();
  JComboBox cbxBuyerMakerType = new JComboBox(new String[]{"BUYER","MAKER","OTHER"});
  SelectBuyerMaker slkBuyerMaker = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel lblByMkrName = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAddr = new JTextArea();
  BlueBkgWhiteCharLabel lblCreateDate = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblCreateDateContext = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblPrintDate = new BlueBkgWhiteCharLabel();
  JTextField txtAttn = new JTextField();
  BlueBkgWhiteCharLabel lblAttn = new BlueBkgWhiteCharLabel();
  JComboBox cbxDiv = new JComboBox();
  BlueBkgWhiteCharLabel lblDivision = new BlueBkgWhiteCharLabel();
  JComboBox cbxCurrency = new JComboBox();
  WhiteBkgBlueCharLabel lblCurrency = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel lblAmountContext = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blAmount = new BlueBkgWhiteCharLabel();
  JTextField txtCollectionRemark = new JTextField();
  BlueBkgWhiteCharLabel lblRemark = new BlueBkgWhiteCharLabel();
  exgui.DataBindJCombobox DbJcbxcbxBranch;
  exgui.DataBindJCombobox DbJcbxcbxDiv;
  exgui.DataBindJCombobox DbJcbxcbxCurrency;
  exgui.DataBindJCombobox DbJcbxcbxKind;
  exgui.DataBindEditableJCombobox DbJcbxBuyerName;
  int indexOfDiv;
  boolean ifProcessingRec2Gui=true;
  JButton btnDelete = new JButton();
  WhiteBkgBlueCharLabel lblAddr1 = new WhiteBkgBlueCharLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea txtBankData = new JTextArea();
  JButton btnClearBankData = new JButton();
  JPanel jPanel1 = new JPanel();
  JButton btnAssignDbCrNo = new JButton();
  JButton btnGotoPayDtl = new JButton();
  JPanel jPanel2 = new JPanel();
  WhiteBkgBlueCharLabel lblAddr = new WhiteBkgBlueCharLabel();
  JButton btnClearBankAddr = new JButton();
  JButton btnPrint = new JButton();
  JTextField txtPrintDate = new JTextField();
  JTextField txtBatchNo = new JTextField();
  BlueBkgWhiteCharLabel lblBatchNo = new BlueBkgWhiteCharLabel();
  static String BUTTON_TITLE_4_PAYDETAIL_DEDUCT=null;
  static String TITLE_PAY_DETAIL="細項";
  static String TITLE_DEDUCT_DETAIL="銷帳";
  BlueBkgWhiteCharLabel lblBalanceAmt = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblBalanceAmtContext = new BlueBkgWhiteCharLabel();
  int buyerNameInputIndex=0;
  JComboBox cbxBuyerName = new JComboBox();
  JButton btnExportCreditDebit=new JButton("EXPORT");
  public PnlEditDebitNoteHead() {
    super(newtimes.accounting.debit_note.Constans.EDITING_DEBITNOTE_HEAD_ECORD,
          newtimes.accounting.debit_note.Constans.DEBIT_NOTE_HEAD_DBHANDLER);
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 public void record2Gui(){
   ifProcessingRec2Gui=true;
   dataBoundGUIs.clear();
   try{
     String mBYMKR_TYPE=(String)recToMapping.get("DBNT_BYMKR_TYPE");
       if(mBYMKR_TYPE==null)cbxBuyerMakerType.setSelectedItem("BUYER");
       else
       cbxBuyerMakerType.setSelectedItem(mBYMKR_TYPE);

     slkBuyerMaker.init("DBNT_BYMKR_SEQ",recToMapping.get("DBNT_BYMKR_SEQ"),
                        Integer.parseInt(
                        (String)
                        newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
                        )
                        ,true);
     slkBuyerMaker.setModifyNotifyTo(this);


    /*
     Object vftxtBuyerMakerName = exgui.verification.CellFormat.getOrdinaryField(60);
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuyerMakerName,
         "DBNT_BYMKR_NAME",
         recToMapping.get("DBNT_BYMKR_NAME"), 60,
         (exgui.Object2String)vftxtBuyerMakerName,
         (exgui.ultratable.CellTxtEditorFormat)vftxtBuyerMakerName)
                       );*/

    buyerNameInputIndex=dataBoundGUIs.size();
    dataBoundGUIs.add(null);//spare for DbJcbxcbxDiv


     Object vftxtAttn = exgui.verification.CellFormat.getOrdinaryField(60);
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtAttn, "DBNT_ATTN",
         recToMapping.get("DBNT_ATTN"), 60,
         (exgui.Object2String)vftxtAttn,
         (exgui.ultratable.CellTxtEditorFormat)vftxtAttn)
                       );

     Object vftxtAddr = exgui.verification.CellFormat.getOrdinaryField(250);
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtAddr, "DBNT_ADDR",
         recToMapping.get("DBNT_ADDR"), 250,
         (exgui.Object2String)vftxtAddr,
         (exgui.ultratable.CellTxtEditorFormat)vftxtAddr)
                       );

     Object vftxtCollectionRemark = exgui.verification.CellFormat.getOrdinaryField(255);
     dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(txtCollectionRemark,
                                           "DBNT_COLLECT_DESC",
                                           recToMapping.get("DBNT_COLLECT_DESC"), 255,
                                           (exgui.Object2String)vftxtCollectionRemark,
                                           (exgui.ultratable.CellTxtEditorFormat)vftxtCollectionRemark)
         );

       if(recToMapping.getInt("record_delete_flag")==-1){

         if(recToMapping.get(0).toString().substring(6,7).equals("C"))
          txtCollectionRemark.setText("CREDIT OF     CHARGE WITH DETAILS AS FOLLOWS:");
            else
          txtCollectionRemark.setText("COLLECTION OF     CHARGE WITH DETAILS AS FOLLOWS:");
       }

       if(newtimes.accounting.debit_note.Constans.VCT_BRANCH==null){
         newtimes.accounting.debit_note.Constans.VCT_BRANCH=
             exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select * from branch where record_delete_flag='1'",
            1,9999999);
       }
       DbJcbxcbxBranch = new exgui.DataBindJCombobox(cbxBranch,"DBNT_BRNCH_BRF",
                                      newtimes.accounting.debit_note.Constans.VCT_BRANCH,
                                      "BRNCH_NAME","BRNCH_BRIEF",
                                      recToMapping.get("DBNT_BRNCH_BRF"));
       dataBoundGUIs.add(DbJcbxcbxBranch);
       indexOfDiv=dataBoundGUIs.size();
       dataBoundGUIs.add(null);//spare for DbJcbxcbxDiv
       /*
       DbJcbxcbxDiv = new exgui.DataBindJCombobox(
                                  cbxDiv,
                                  "DBNT_BYMKR_DIV_CODE",
                                  newtimes.accounting.debit_note.Constans.VCT_DIVISION,
                                  "DIV_NAME",
                                  "DIV_CODE",
                                  recToMapping.get("DBNT_BYMKR_DIV_CODE"),
                                  "N/A",null); */

     DbJcbxcbxCurrency  = new exgui.DataBindJCombobox(
                         cbxCurrency,"DBNT_CURRENCY",
                         newtimes.preproduction.guis.tempProperties.tmpCurrency,
                         "CRNCY_NAME","CRNCY_NAME",
                         recToMapping.get("DBNT_CURRENCY"));
     dataBoundGUIs.add(DbJcbxcbxCurrency);




     dataBoundGUIs.add(DbJcbxcbxKind);

     Object vftxtBankData = exgui.verification.CellFormat.getOrdinaryField(2000);
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBankData, "BANK_DESC",
         recToMapping.get("BANK_DESC"), 2000,
         (exgui.Object2String)vftxtBankData,
         (exgui.ultratable.CellTxtEditorFormat)vftxtBankData));

     Object vftxtPrintDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtPrintDate, "DBNT_PRINT_DATE",
         recToMapping.get("DBNT_PRINT_DATE"), 10,
         (exgui.Object2String)vftxtPrintDate,
         (exgui.ultratable.CellTxtEditorFormat)vftxtPrintDate));


     java.text.SimpleDateFormat sd=new java.text.SimpleDateFormat("yyyy/MM/dd");
     lblDebitNoteNo.setText((String)recToMapping.get(0));
     if(recToMapping.getInt("record_delete_flag")!=-1){
       if(((String)recToMapping.get(0)).length()!=14){
        final String typeCode=((String)recToMapping.get(0)).substring(6,7);
         if(typeCode.equals("M")){
           this.add(lblBalanceAmt, null);
           this.add(lblBalanceAmtContext, null);
           this.add(txtBatchNo, null);
           this.add(lblBatchNo, null);
           lblBatchNo.setVisible(true);
           txtBatchNo.setVisible(true);
           Object vftxtBatchNo = exgui.verification.CellFormat.
               getOrdinaryField(20);
           dataBoundGUIs.add(
               new exgui.DataBindTextWithChecker(txtBatchNo,
                                                 "DBNT_MKRCNV_BATCHNO",
                                                 recToMapping.get("DBNT_MKRCNV_BATCHNO"), 20,
                                                 (exgui.Object2String)vftxtBatchNo,
                                                 (exgui.ultratable.CellTxtEditorFormat)vftxtBatchNo)
               );

           java.util.Vector vcxt = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
               "select round(a.dbnt_total_amt-get_ddk_amt(a.dbnt_no),2) as blc_amt,a.dbnt_no from debitnote_head a where a.dbnt_no='" +
               (String)Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0) + "'", 1, 99999999);
           Record recBlcAmt = (Record)vcxt.get(0);
           lblBalanceAmtContext.setText(recBlcAmt.get(0).toString());
         }else if(typeCode.equals("C")||typeCode.equals("D")){
           this.add(btnExportCreditDebit, null);
           btnExportCreditDebit.setVisible(true);
           btnExportCreditDebit.addActionListener(new java.awt.event.ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                    try{
                      exportToNewDbCr(typeCode);
                    }catch(Exception epxxxx){
                      epxxxx.printStackTrace();
                      util.ExceptionLog.exp2File(epxxxx,"");
                    }
                 }
                });

         }
       }
     }
     if(recToMapping.getInt("record_delete_flag")==-1){
       blueBkgWhiteCharLabel1.setText("ADD Debit Note Head");

     }else{
       blueBkgWhiteCharLabel1.setText("Edit Debit Note Head");
       Object objAmt=recToMapping.get("DBNT_TOTAL_AMT");
       lblAmountContext.setText(objAmt==null?"":nf.format(Double.parseDouble(objAmt.toString())));
       Object objflag=recToMapping.get("editable_flag");
       if("0".equals(objflag.toString())){
         btnUpdate.setEnabled(false);
         btnDelete.setEnabled(false);
       }
     }
     lblCreateDateContext.setText(sd.format(recToMapping.get("record_create_date")));
     getDivsionCbx(recToMapping.get("DBNT_BYMKR_SEQ")==null?null:recToMapping.get("DBNT_BYMKR_SEQ").toString());
     ifProcessingRec2Gui=false;
     if(recToMapping.getInt("Record_delete_flag")==-1){
       btnDelete.setVisible(false);
       btnGotoDetail.setVisible(false);
       btnGotoPayDtl.setVisible(false);
     }
     if(((String)recToMapping.get(0)).length()==14 &&((String)recToMapping.get(0)).startsWith("00")){
       btnAssignDbCrNo.setVisible(true);
     }else{
       btnAssignDbCrNo.setVisible(false);
     }
     //assign DbCrNo only allowin in edit mode
     if(recToMapping.getInt("Record_delete_flag")==-1){
       btnAssignDbCrNo.setVisible(false);
       cbxBranch_itemStateChanged(null);
       initBuyerNameCbx("",0);
     }else{
       String buyerName=(String)recToMapping.get("DBNT_BYMKR_NAME");
       initBuyerNameCbx((buyerName==null)?"":buyerName,
                        recToMapping.getInt("DBNT_BYMKR_SEQ"));

     }
     changeButtons();

   }catch(Exception exp){
     exp.printStackTrace();
   }

 }
 protected void exportToNewDbCr(String typeCode)throws Exception{
  String[] strDbCrTypeValue=(String[]) util.MiscFunc.deepCopy(DlgAddDebitNoteNo.DrCrTypeValue);
  String[] strDbCrTypeString=(String[]) util.MiscFunc.deepCopy(DlgAddDebitNoteNo.DrCrTypeString);

  //static String DrCrTypeValue[]={"D","C","B","M"};
  //static String DrCrTypeString[]={"DEBIT","CREDIT","BUYER COMMISSION","MAKER COMMISSION"};
  java.util.HashMap hmType=new java.util.HashMap();
  hmType.put("D","DEBIT");
  hmType.put("C","CREDIT");
  hmType.put("B","BUYER COMMISSION");
  hmType.put("M","MAKER COMMISSION");

  DlgAddDebitNoteNo.DrCrTypeValue=new String[]{typeCode};
  DlgAddDebitNoteNo.DrCrTypeString=new String[]{(String)hmType.get(typeCode)};
  DlgAddDebitNoteNo dlg=new DlgAddDebitNoteNo(util.PublicVariable.APP_FRAME,"expor to DB/CR",
                                              (String)recToMapping.get(0),
                                              true);
                  dlg.btnTempDbCr.setVisible(false);
                  dlg.setSize(410,325);
                  exgui.UIHelper.setToScreenCenter(dlg);
                  dlg.show();
   DlgAddDebitNoteNo.DrCrTypeValue=strDbCrTypeValue;
   DlgAddDebitNoteNo.DrCrTypeString=strDbCrTypeString;
 }
 protected void changeButtons()throws Exception{
   if(recToMapping.getInt("Record_delete_flag")==-1)return;
   String dbcrno=(String)recToMapping.get(0);
   if(dbcrno.length()==14){
     //掛帳者,不允許用銷帳
     btnGotoPayDtl.setText(TITLE_PAY_DETAIL);
     return ;
   }

   String type=dbcrno.substring(6,7);
   /*
   if(type.equals("B")){
     btnGotoPayDtl.setVisible(false);
     return;
   }
   */

   if(type.equals("M")||type.equals("B")){
     btnGotoPayDtl.setText(TITLE_DEDUCT_DETAIL);
     return;
   }
   if(type.equals("C")||type.equals("D")){
     btnGotoPayDtl.setText(TITLE_PAY_DETAIL);
   }
 }
 private void initBuyerNameCbx(String valueInit,int bymkrseq){
   try{
   java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select dbnt_bymkr_name from debitnote_bymkr_name where record_delete_flag='1' and dbnt_bymkr_seq="+
          String.valueOf(bymkrseq),
         1,9999);

   DbJcbxBuyerName=
       new exgui.DataBindEditableJCombobox(
                         cbxBuyerName,"DBNT_BYMKR_NAME",
                         vct,
                         "DBNT_BYMKR_NAME","DBNT_BYMKR_NAME",
                         valueInit,60);
     dataBoundGUIs.add(buyerNameInputIndex,DbJcbxBuyerName);
   }catch(Exception exp){
     exp.printStackTrace();
   }

 }
 public void changeBuyerMaker(Record recBuyerMaker){
   if(!ifProcessingRec2Gui){
     util.MiscFunc.showProcessingMessage();
     getDivsionCbx(recBuyerMaker == null ? null :
                   recBuyerMaker.get(0).toString());
     //txtBuyerMakerName.setText("");
     initBuyerNameCbx("",recBuyerMaker.getInt(0));
     if(recBuyerMaker!=null){
       try{
         Record recTmp=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,"select bymkr_warehouse,bymkr_contact_person,nvl(bymkr_name2,bymkr_name) as name from buyer_maker where bymkr_seq="+
           recBuyerMaker.get(0).toString(),1,1
         ).get(0);
         String bymkr_name=(String)recTmp.get(2);
         //txtBuyerMakerName.setText((bymkr_name==null)?"":bymkr_name);
         initBuyerNameCbx((bymkr_name==null)?"":bymkr_name,recBuyerMaker.getInt(0));
         if ("Y".equalsIgnoreCase((String)recTmp.get(0))) {
           StringBuffer sb=new StringBuffer();
           sb.append("10TH FL.,FORMOSA PLASTIC BLDG., 201,");
           sb.append("\n");
           sb.append("TUN HUA NORTH ROAD,TAIPEI, TAIWAN,R.O.C.");
           sb.append("\n");
           sb.append("TEL : 886-2-27133333 FAX: 886-2-27153336");
           txtAddr.setText(sb.toString());
         }
         //when at add mode,"Attetion" field is from buyer-maker's contact person
         if(recToMapping.getInt("record_delete_flag")==-1){
           String att2=(String)recTmp.get(1);
           txtAttn.setText((att2==null)?"":att2.trim());
         }
       }catch(Exception exp){
         exp.printStackTrace();
       }

     }
     util.MiscFunc.hideProcessingMessage();
   }
 }
 protected void getDivsionCbx(String buyerMakerSeq){
   try{
     if (buyerMakerSeq == null) {
       newtimes.accounting.debit_note.Constans.VCT_DIVISION = new java.util.Vector();
     } else {
       StringBuffer sb=new StringBuffer();
       sb.append("select * from division where div_bymkr_seq=");
       sb.append(buyerMakerSeq);
       /*
       sb.append(" and selectable_center like '%,");
       sb.append((String)util.PublicVariable.OPERATTING_CENTER);
       sb.append(",%' and record_delete_flag='1'"); */

      newtimes.accounting.debit_note.Constans.VCT_DIVISION=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           sb.toString(),1,99999);
     }

     DbJcbxcbxDiv = new exgui.DataBindEditableJCombobox(
         cbxDiv,
         "DBNT_BYMKR_DIV_CODE",
         newtimes.accounting.debit_note.Constans.VCT_DIVISION,
         "DIV_NAME",
         "DIV_NAME",
         recToMapping.get("DBNT_BYMKR_DIV_CODE"),
         "", null,50);

     dataBoundGUIs.set(indexOfDiv, DbJcbxcbxDiv);
   }catch(Exception exp){
     exp.printStackTrace();
   }

 }

 public boolean gui2Record(){
   boolean result=super.gui2Record();
   if(slkBuyerMaker.getSelectedValue()==null){
     exgui.verification.VerifyLib.showAlert("Please Select A "+cbxBuyerMakerType.getSelectedItem(),
                                            "Please Select A "+cbxBuyerMakerType.getSelectedItem());
     return false;
   }
   if(DbJcbxBuyerName.getSelectedValue()==null||
      DbJcbxBuyerName.getSelectedValue().toString().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("Please Assign Buyer-Maker Name","Please Assign Buyer-Maker Name");
     return false;
   }
   try{
     recToMapping.set("DBNT_BYMKR_TYPE", cbxBuyerMakerType.getSelectedItem());
     recToMapping.set("DBNT_BYMKR_SEQ", slkBuyerMaker.getSelectedValue());
   }catch(Exception exp){
     exp.printStackTrace();
     return false;
   }

   try{
     recToMapping.set("DBNT_BRNCH_BRF", DbJcbxcbxBranch.getSelectedValue());
   }catch(Exception exp){
     exp.printStackTrace();
   }
   return result;
 }
 public void doPrint(){}
 protected void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Edit/ADD Debit Note Head");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 37, 800, 34));
    this.setBackground(new Color(202, 202, 244));
    this.setLayout(null);
    btnUpdate.setBounds(new Rectangle(151, 533, 79, 32));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("OK");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(707, 533, 76, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGotoDetail.setBounds(new Rectangle(346, 533, 92, 32));
    btnGotoDetail.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGotoDetail.setText("Detail");
    btnGotoDetail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGotoDetail_actionPerformed(e);
      }
    });
    lblDebitNoteNoTitle.setText("DB/CR NO:");
    lblDebitNoteNoTitle.setBounds(new Rectangle(50, 91, 88, 26));
    lblDebitNoteNo.setText("");
    lblDebitNoteNo.setBounds(new Rectangle(136, 91, 352, 26));
    lblBranch.setText("BRANCH:");
    lblBranch.setBounds(new Rectangle(50, 127, 149, 26));
    cbxBranch.setBounds(new Rectangle(199, 127, 289, 26));
    cbxBranch.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBranch_itemStateChanged(e);
      }
    });
    lblBuyerMaker.setBounds(new Rectangle(50, 161, 149, 26));
    lblBuyerMaker.setText("BUYER / MAKER:");
    cbxBuyerMakerType.setBounds(new Rectangle(199, 161, 92, 26));
    cbxBuyerMakerType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerMakerType_itemStateChanged(e);
      }
    });
    slkBuyerMaker.setBounds(new Rectangle(291, 161, 197, 26));
    lblByMkrName.setBounds(new Rectangle(49, 193, 149, 26));
    lblByMkrName.setText("NAME:");
    jScrollPane1.setBounds(new Rectangle(198, 368, 583, 96));
    txtAddr.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtAddr.setText("");
    lblCreateDate.setText("CREATE DATE:");
    lblCreateDate.setBounds(new Rectangle(492, 91, 109, 26));
    lblCreateDateContext.setText("");
    lblCreateDateContext.setBounds(new Rectangle(601, 91, 175, 26));
    lblPrintDate.setBounds(new Rectangle(493, 127, 109, 26));
    lblPrintDate.setBackground(Color.white);
    lblPrintDate.setForeground(new Color(143, 143, 188));
    lblPrintDate.setText("PRINT DATE:");
    txtAttn.setBounds(new Rectangle(197, 468, 289, 26));
    txtAttn.setText("");
    lblAttn.setText("ATTENTION:");
    lblAttn.setBounds(new Rectangle(48, 468, 149, 26));
    cbxDiv.setBounds(new Rectangle(199, 227, 289, 26));
    cbxDiv.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxDiv_itemStateChanged(e);
      }
    });
    lblDivision.setBackground(Color.white);
    lblDivision.setForeground(new Color(143, 143, 188));
    lblDivision.setText("DIVISION:");
    lblDivision.setBounds(new Rectangle(50, 227, 149, 26));
    cbxCurrency.setBounds(new Rectangle(601, 161, 175, 26));
    lblCurrency.setBackground(new Color(143, 143, 188));
    lblCurrency.setForeground(Color.white);
    lblCurrency.setText("CURRENCY:");
    lblCurrency.setBounds(new Rectangle(493, 161, 109, 26));
    lblAmountContext.setText("");
    lblAmountContext.setForeground(new Color(143, 143, 188));
    lblAmountContext.setBackground(Color.white);
    lblAmountContext.setBounds(new Rectangle(601, 193, 175, 26));
    blAmount.setText("AMOUNT:");
    blAmount.setForeground(new Color(143, 143, 188));
    blAmount.setBackground(Color.white);
    blAmount.setBounds(new Rectangle(493, 193, 109, 26));
    txtCollectionRemark.setBounds(new Rectangle(147, 497, 631, 26));
    txtCollectionRemark.setText("");
    lblRemark.setFont(new java.awt.Font("Dialog", 1, 12));
    lblRemark.setText("REMARK:");
    lblRemark.setBounds(new Rectangle(48, 497, 99, 26));
    btnDelete.setBounds(new Rectangle(250, 533, 77, 32));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    lblAddr1.setBackground(new Color(143, 143, 188));
    lblAddr1.setForeground(Color.white);
    lblAddr1.setText("BANK DATA:");
    lblAddr1.setBounds(new Rectangle(1, 3, 152, 71));
    jScrollPane2.setBounds(new Rectangle(197, 255, 583, 114));
    btnClearBankData.setBounds(new Rectangle(36, 78, 112, 24));
    btnClearBankData.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClearBankData.setText("CLEAR");
    btnClearBankData.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClearBankData_actionPerformed(e);
      }
    });
    txtBankData.setFont(new java.awt.Font("DialogInput", 0, 12));
    jPanel1.setBackground(new Color(143, 143, 188));
    jPanel1.setBounds(new Rectangle(48, 256, 149, 110));
    jPanel1.setLayout(null);
    btnAssignDbCrNo.setBounds(new Rectangle(27, 533, 105, 31));
    btnAssignDbCrNo.setFont(new java.awt.Font("Dialog", Font.PLAIN, 11));
    btnAssignDbCrNo.setText("細項搬移");
    btnAssignDbCrNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAssignDbCrNo_actionPerformed(e);
      }
    });
    btnGotoPayDtl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGotoPayDtl_actionPerformed(e);
      }
    });
    btnGotoPayDtl.setText("細項");
    btnGotoPayDtl.setFont(new java.awt.Font("Dialog", 0, 12));
    btnGotoPayDtl.setBounds(new Rectangle(457, 533, 92, 32));
    jPanel2.setBackground(Color.white);
    jPanel2.setBounds(new Rectangle(48, 367, 151, 99));
    jPanel2.setLayout(null);
    lblAddr.setText("ADDRESS:");
    lblAddr.setBounds(new Rectangle(2, 0, 149, 74));
    btnClearBankAddr.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClearBankAddr_actionPerformed(e);
      }
    });
    btnClearBankAddr.setText("CLEAR");
    btnClearBankAddr.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClearBankAddr.setBounds(new Rectangle(37, 74, 112, 24));
    btnPrint.setBounds(new Rectangle(574, 533, 92, 32));
    btnPrint.setFont(new java.awt.Font("Dialog", 0, 12));
    btnPrint.setText("列印");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    txtPrintDate.setBounds(new Rectangle(601, 127, 170, 26));
    txtBatchNo.setBounds(new Rectangle(611, 468, 170, 26));
    lblBatchNo.setText("BATCH NO:");

    lblBatchNo.setForeground(new Color(143, 143, 188));
    btnExportCreditDebit.setBounds(new Rectangle(502, 468, 109, 26));

    lblBatchNo.setBackground(Color.white);
    lblBatchNo.setBounds(new Rectangle(502, 468, 109, 26));
    lblBalanceAmt.setBounds(new Rectangle(493, 227, 109, 26));
    lblBalanceAmt.setText("BALANCE AMT:");
    lblBalanceAmtContext.setBounds(new Rectangle(601, 227, 175, 26));
    lblBalanceAmtContext.setText("");
    cbxBuyerName.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerName_itemStateChanged(e);
      }
    });
    cbxBuyerName.setBounds(new Rectangle(198, 193, 289, 26));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblBranch, null);
    this.add(lblDebitNoteNo, null);
    this.add(lblByMkrName, null);
    this.add(lblDebitNoteNoTitle, null);
    this.add(lblBuyerMaker, null);
    this.add(cbxDiv, null);
    this.add(cbxBuyerMakerType, null);
    this.add(cbxBranch, null);
    this.add(slkBuyerMaker, null);
    this.add(lblDivision, null);
    this.add(lblCreateDate, null);
    this.add(lblCreateDateContext, null);
    this.add(lblPrintDate, null);
    this.add(lblCurrency, null);
    this.add(cbxCurrency, null);
    this.add(blAmount, null);
    this.add(lblAmountContext, null);
    this.add(jScrollPane2, null);
    this.add(lblRemark, null);
    this.add(txtCollectionRemark, null);
    this.add(lblAttn, null);
    this.add(txtAttn, null);
    this.add(jScrollPane1, null);
    this.add(jPanel1, null);
    jPanel1.add(lblAddr1, null);
    jPanel1.add(btnClearBankData, null);
    this.add(jPanel2, null);
    jPanel2.add(lblAddr, null);
    jPanel2.add(btnClearBankAddr, null);
    this.add(btnGotoDetail, null);
    this.add(btnGotoPayDtl, null);
    this.add(btnDelete, null);
    this.add(btnExit, null);
    this.add(btnAssignDbCrNo, null);
    this.add(btnUpdate, null);
    this.add(btnPrint, null);
    jScrollPane1.getViewport().add(txtAddr, null);
    jScrollPane2.getViewport().add(txtBankData, null);
    this.add(txtPrintDate, null);
    lblBatchNo.setVisible(false);
    txtBatchNo.setVisible(false);
    this.add(cbxBuyerName, null);
    /*
    this.add(lblBalanceAmt, null);
    this.add(lblBalanceAmtContext, null);
    */
    cbxDiv.setEditable(true);
    cbxBuyerName.setEditable(true);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       if(btnDelete.isVisible() && this.isContextModified()){
         if(!exgui.verification.VerifyLib.showConfirm("Context Modifed,Do you Sure To Exit ?",
                                                      "Context Modifed,Do you Sure To Exit ?",false)){
           return;
         }
       }
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      if(!gui2Record())return;
      /*
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome =
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.debitNote.DebitNoteFacde");
      newtimesejb.debitNote.DebitNoteFacde ejb=ejbHome.create();
      System.out.println(recToMapping.toString());
      Record tmpRc=ejb.editDebitNoteHead(recToMapping); */

     Record tmpRc =super.dbprc.addRecord(recToMapping);
     newtimes.accounting.debit_note.Constans.EDITING_DEBITNOTE_HEAD_ECORD=tmpRc;
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
     new newtimes.accounting.debit_note.TgrEditDebitNoteHead());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnGotoDetail_actionPerformed(ActionEvent e) {
    try{
      if(this.isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Context Modifed,Do you Sure To Exit ?",
                                                     "Context Modifed,Do you Sure To Exit ?",false)){
          return;
        }
      }
       PnlEditDebitNoteDetail.InitKindString="COMM.";
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrListDebitNoteDetail());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {
     if(!ifProcessingRec2Gui){
         slkBuyerMaker.init("DBNT_BYMKR_SEQ",null,
                            Integer.parseInt(
                            (String)
                            newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
                            )
                            ,true);
         getDivsionCbx(null);
     }
  }

  void cbxDiv_itemStateChanged(ItemEvent e) {

  }

  String getBankData(){
    String bankdata=(String)Constans.BankDataString.get(DbJcbxcbxBranch.getSelectedValue());
    if(null == bankdata)return "";
    return bankdata;
  }
  void cbxBranch_itemStateChanged(ItemEvent e) {
    if(!ifProcessingRec2Gui){
      //if branch is light & heavy,"Address" is branch address
      txtBankData.setText(getBankData());
      //2010 04 02,even light & heavy,still not effect to address column
      /*
      if("LIGHT&HEAVY".equals(DbJcbxcbxBranch.getSelectedValue())){
        for(int i=0;i<newtimes.accounting.debit_note.Constans.VCT_BRANCH.size();i++){
          Record rec=(Record)newtimes.accounting.debit_note.Constans.VCT_BRANCH.get(i);
          if(rec.get(0).equals("LIGHT&HEAVY")){
            StringBuffer sb=new StringBuffer();

            if(rec.get(2)!=null){
              sb.append(rec.get(2).toString().trim());
            }
            if(rec.get(3)!=null){
              if(sb.length()>0)sb.append("\n");
              sb.append(rec.get(3).toString().trim());
            }
            if(rec.get(4)!=null){
              if(sb.length()>0)sb.append("\n");
              sb.append(rec.get(4).toString().trim());
            }
            txtAddr.setText(sb.toString());
            return;
          }
        }
      }else{

      }
      */
    }

  }

  void btnDelete_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete ?",
                                                 "Are You Sure ",false)) return;
    try{
      java.util.Vector vct = new java.util.Vector();
      recToMapping.set("record_delete_flag", "0");
      vct.add(recToMapping);
      dbprc.updateRecords(vct);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
    }

  }

  void btnClearBankData_actionPerformed(ActionEvent e) {
    txtBankData.setText("");
  }
  Record recGetDbnt2Move(String destDbNt)throws Exception{
    String cenCode=(String)recToMapping.get("CEN_CODE");

    StringBuffer sb2chk=new StringBuffer();
    sb2chk.append("select * from DEBITNOTE_HEAD where CEN_CODE='");
    sb2chk.append(util.MiscFunc.Replace(cenCode,"'","''"));
    sb2chk.append("' and DBNT_NO='");
    sb2chk.append(util.MiscFunc.Replace(destDbNt,"'","''"));
    sb2chk.append("' and record_delete_flag='1'");

    java.util.Vector vct2check=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb2chk.toString(),1,9999
      );
    if(vct2check.size()==0){
      return null;
    }
    Record rec2Test=(Record)vct2check.get(0);
    return rec2Test;
  }

  void movePayDetailToOtherDebitNote(){
    String result=JOptionPane.showInputDialog(
     util.PublicVariable.APP_FRAME,
      "Please Dest. DB#:","將細項資料轉移到其他的DebitNote",
      JOptionPane.QUESTION_MESSAGE);
    if(result==null)return;
    if(result.trim().length()==0){
      return;
    }
    int dbNtLength=(util.PublicVariable.OPERATTING_CENTER.endsWith("001"))?10:12;
    if(result.trim().length()!=dbNtLength){
      exgui.verification.VerifyLib.showAlert("Length of DB# is "+dbNtLength+" Characters ","Length of DB# is "+dbNtLength+" Characters");
      return;
    }
    if(!(result.trim().substring(6,7).equals("D")||
       result.trim().substring(6,7).equals("C"))){
       exgui.verification.VerifyLib.showAlert("Dest. DB type Should be \"Debit\" Or \"Credit\"",
                                              "Dest DB Type Miss-match");
       return;
    }
    //check if s/c exists
    try{
      util.MiscFunc.showProcessingMessage();
      //DbDebitNoteHead dbDBHead=new DbDebitNoteHead();
      //Record rec2Test=dbDBHead.getRecordByPk(result.trim());
      Record rec2Test=recGetDbnt2Move(result.trim());
      if(null==rec2Test){
        exgui.verification.VerifyLib.showAlert("No Such DB#","No Such DB#");
        return;
      }
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from DEBITNOTE_PAY_DETAIL a WHERE a.RECORD_DELETE_FLAG='1' and a.DBNT_NO ='"+
        (String)Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0)+"'",
        1,9999
      );
      if(0==vct.size()){
        exgui.verification.VerifyLib.showAlert("本掛帳無細項可搬移","NO data to move");
        return;
      }
      java.util.Vector vctdest=new java.util.Vector();
      for(int i=0;i<vct.size();i++){
         Record rec=(Record)vct.get(i);
         rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
         rec.set(1,result.trim());
         vctdest.add(rec);
      }
      DbDebitNotePayDtl dbPayDtlHandler=new DbDebitNotePayDtl();
      dbPayDtlHandler.updateRecords(vctdest);

      vct.clear();
      recToMapping.set("record_delete_flag", "0");
      vct.add(recToMapping);
      dbprc.updateRecords(vct);
      processhandler.template.Properties.getCenteralControler().goBack();
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Connection Error\nPlease Notify System Manager",
                                             "Connection Error");
    }

  }
  void btnAssignDbCrNo_actionPerformed(ActionEvent e) {
    if(!gui2Record())return;
     movePayDetailToOtherDebitNote();
     /*
     DlgAddDebitNoteNo dlg=new DlgAddDebitNoteNo(util.PublicVariable.APP_FRAME,
                                                 "Generate DB/CR #",true);
     dlg.blueBkgWhiteCharLabel1.setText("GENERATE DB/CR # FOR TEMP RECORD");
     dlg.btnTempDbCr.setVisible(false);
     dlg.setSize(410,325);
     exgui.UIHelper.setToScreenCenter(dlg);
     dlg.show();
     if(dlg.finalDbCrNo==null){
       return;
     }
     try{
       ((DbDebitNoteHead)dbprc).updateDbCrNo((String)recToMapping.get(0),
                                             dlg.finalDbCrNo);
       Constans.QRY_DEBITNOTE_NO= dlg.finalDbCrNo;
       recToMapping.set(0,dlg.finalDbCrNo);
       Record tmpRc =super.dbprc.addRecord(recToMapping);
       newtimes.accounting.debit_note.Constans.EDITING_DEBITNOTE_HEAD_ECORD=tmpRc;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrEditDebitNoteHead());
     }catch(Exception exp){
       exp.printStackTrace();
     }*/

  }
  void btnGotoPayDtl_actionPerformed(ActionEvent e) {
    try{
      if(this.isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Context Modifed,Do you Sure To Exit ?",
                                                     "Context Modifed,Do you Sure To Exit ?",false)){
          return;
        }
      }
       if(btnGotoPayDtl.getText().equals(TITLE_DEDUCT_DETAIL)){
         processhandler.template.Properties.getCenteralControler().
             doCommandExecute(
             new newtimes.accounting.debit_note.TgrListDDKOfADbcr());
       }else{
         processhandler.template.Properties.getCenteralControler().
             doCommandExecute(
             new newtimes.accounting.debit_note.TgrListDebitNotePayDtl());
       }
    }catch(Exception exp){
      exp.printStackTrace();
     }


  }
  void btnClearBankAddr_actionPerformed(ActionEvent e) {
     txtAddr.setText("");
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    try{
      //show debit note report,
      com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.
          inet_report_viewer;
      String rpt_name = "dbno.rpt";
      java.util.HashMap hm = new java.util.HashMap();
      hm.put("P_DB_NO", lblDebitNoteNo.getText());
      hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
      newtimes.production.report.ReportCmdSet.myReportEngin.
          setReportNameAndParas(viewer, rpt_name, hm);
      viewer.setHasGroupTree(false);
      //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
      viewer.start();
      JPanel pnl = new JPanel();
      pnl.setLayout(new java.awt.BorderLayout());
      pnl.add(viewer);
      /*
      javax.print.PrintService defaultPrinterService=javax.print.PrintServiceLookup.lookupDefaultPrintService();
      String defaultPrinterName=defaultPrinterService.getName();
      */
      newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
          guis.DlgViewRpt(
          processhandler.template.Properties.getMainFrame(),
          "DB/CR REPORT",
          pnl, true);
      dlg.setSize(700, 500);
      /*
      try{
        java.lang.Runtime rt=java.lang.Runtime.getRuntime();
        rt.exec("C:\\ChagePrinterCPP\\Debug\\ChagePrinterCPP.exe \""+"\\\\110\\NEC"+"\"");
      }catch(Exception exp){
        exp.printStackTrace();
      }*/
      dlg.show();
      /*
      try{
        java.lang.Runtime rt=java.lang.Runtime.getRuntime();
        rt.exec("C:\\ChagePrinterCPP\\Debug\\ChagePrinterCPP.exe \""+defaultPrinterName+"\"");
      }catch(Exception exp){
        exp.printStackTrace();
      }*/

    }catch(Exception exp){
      exp.printStackTrace();

    }

  }
  void cbxBuyerName_itemStateChanged(ItemEvent e) {

  }

}
