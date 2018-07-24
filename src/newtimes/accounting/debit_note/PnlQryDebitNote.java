package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryDebitNote extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  JButton btnQryDebitNote = new JButton();
  WhiteBkgBlueCharLabel lblCenter = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenterContext = new WhiteBkgBlueCharLabel();
  JButton btnKindMaintain = new JButton();
  BlueBkgWhiteCharLabel lblDBNO1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxDep = new JComboBox();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel lblDBNO2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxType = new JComboBox();
  JComboBox cbxKind = new JComboBox();
  WhiteBkgBlueCharLabel lblCenter3 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenter4 = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker selectBuyerMaker = new SelectBuyerMaker();
  JComboBox cbxBuyerMakerType = new JComboBox(new String[]{"BUYER","MAKER","OTHER"});
  static String DrCrTypeValue[]={"","D","C","B","M"};
  static String DrCrTypeString[]={"","DEBIT","CREDIT","BUYER COMMISSION","MAKER COMMISSION"};
  exgui.ultratable.Wraper4tblCbx DrCrType[]=new exgui.ultratable.Wraper4tblCbx[5];
  exgui.DataBindJCombobox dbCbxDep;
  exgui.DataBindJCombobox DbJcbxcbxKind;
  public static String CONDITION_DEPT="DEP_ABBR";
  public static String CONDITION_BUYER_MAKER="BUYER_MAKER";
  public static String CONDITION_BUYER_MAKER_NAME="BUYER_MAKER_NAME";
  public static String CONDITION_DATE_FROM="DATE_FROM";
  public static String CONDITION_DATE_TO="DATE_TO";
  public static String CONDITION_TYPE="DBCM_TYPE";
  public static String CONDITION_KIND="DBCR_KIND";
  public static String CONDITION_TEMP_DBCRNO="TEMP_DBCRNO";
  public static String CONDITION_QRY_EXACT_BATCH="EXACT_BATCH_NO";
  public static String CONDITION_DDK_CHECKNO="DDK_CHECKNO";
  public static String CONDITION_QRY_SHIP_NO="_QRY_SHIP_NO";
  public static String CONDITION_SINGLE_DB_NO="_SINGLE_DB_NO";
  public static String CONDITION_CENTER_CODE="CENTER_CODE";
  JTextField txtTmpDrBr = new JTextField();
  //JButton btnQryBatchNo = new JButton();
  JTextField txtBatchNo = new JTextField();
  BlueBkgWhiteCharLabel lblDBNO3 = new BlueBkgWhiteCharLabel();
  JTextField txtDDK_ChkNo = new JTextField();
  JButton btnQryBatch = new JButton();
  JButton btnQryTempDbRcNo = new JButton();
  BlueBkgWhiteCharLabel lblShipNo = new BlueBkgWhiteCharLabel();
  JTextField txtSRN = new JTextField();
  JTextField txtSingleDbNo = new JTextField();
  JButton btnQrySingleDbNo = new JButton();
  String centerName=null;
  String centerCode=null;
  public PnlQryDebitNote() {
    try {
      database.datatype.Record recCenter=newtimes.accounting.debit_note.Constans.recGetCenterRec((String)util.PublicVariable.OPERATTING_CENTER);
      centerName=recCenter.get(1).toString();
      centerCode=(String)util.PublicVariable.OPERATTING_CENTER;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Query Debit Note");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 37, 797, 32));
    this.setBackground(new Color(202, 202, 244));
    this.setLayout(null);
    btnAddNew.setBounds(new Rectangle(110, 497, 100, 33));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("ADD NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(601, 497, 100, 33));
    btnQryDebitNote.setText("Query");
    btnQryDebitNote.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryDebitNote_actionPerformed(e);
      }
    });
    btnQryDebitNote.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryDebitNote.setBounds(new Rectangle(348, 497, 100, 33));
    lblCenter.setText("CENTER:");
    lblCenter.setBounds(new Rectangle(201, 80, 123, 25));
    lblCenterContext.setBounds(new Rectangle(323, 80, 269, 25));
    lblCenterContext.setText("TAIPEI");
    btnKindMaintain.setBounds(new Rectangle(111, 439, 148, 33));
    btnKindMaintain.setFont(new java.awt.Font("Dialog", 1, 11));
    btnKindMaintain.setText("DB/CR Kind Maintain");
    btnKindMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnKindMaintain_actionPerformed(e);
      }
    });
    lblDBNO1.setBounds(new Rectangle(201, 117, 123, 26));
    lblDBNO1.setText("DEP. :");
    cbxDep.setBounds(new Rectangle(324, 117, 268, 26));
    lblCenter1.setBounds(new Rectangle(202, 193, 123, 25));
    lblCenter1.setText("YYYYMM From:");
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(326, 193, 98, 25));
    txtDateTo.setBounds(new Rectangle(470, 193, 122, 25));
    txtDateTo.setText("");
    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(423, 193, 46, 25));
    lblDBNO2.setText("TYPE");
    lblDBNO2.setBounds(new Rectangle(202, 230, 123, 26));
    cbxType.setBounds(new Rectangle(326, 230, 268, 26));
    cbxKind.setBounds(new Rectangle(326, 268, 269, 26));
    lblCenter3.setText("KIND:");
    lblCenter3.setBounds(new Rectangle(202, 268, 123, 25));
    lblCenter4.setText("BUYER / MAKER");
    lblCenter4.setBounds(new Rectangle(201, 155, 123, 25));
    selectBuyerMaker.setBounds(new Rectangle(431, 154, 161, 26));
    cbxBuyerMakerType.setBounds(new Rectangle(325, 154, 103, 26));
    cbxBuyerMakerType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerMakerType_itemStateChanged(e);
      }
    });
    txtTmpDrBr.setText("");
    txtTmpDrBr.setBounds(new Rectangle(325, 445, 141, 26));
    txtBatchNo.setBounds(new Rectangle(325, 409, 141, 26));
    txtBatchNo.setText("");
    lblDBNO3.setBackground(Color.white);
    lblDBNO3.setForeground(new Color(143, 143, 188));
    lblDBNO3.setText("DEDUCT CHECK NO.");
    lblDBNO3.setBounds(new Rectangle(202, 339, 215, 26));
    txtDDK_ChkNo.setBounds(new Rectangle(417, 339, 177, 26));
    btnQryBatch.setBounds(new Rectangle(464, 409, 129, 26));
    btnQryBatch.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryBatch.setText("Query Batch No.");
    btnQryBatch.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryBatch_actionPerformed(e);
      }
    });
    btnQryTempDbRcNo.setText("本眀琩高");
    btnQryTempDbRcNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryTempDbRcNo_actionPerformed(e);
      }
    });
    btnQryTempDbRcNo.setBounds(new Rectangle(464, 445, 129, 26));
    btnQryTempDbRcNo.setFont(new java.awt.Font("Dialog", 0, 12));
    lblShipNo.setBounds(new Rectangle(202, 304, 123, 26));
    lblShipNo.setText("INVOICE NO");
    txtSRN.setBounds(new Rectangle(325, 304, 269, 26));
    txtSingleDbNo.setText("");
    txtSingleDbNo.setBounds(new Rectangle(325, 376, 141, 26));
    btnQrySingleDbNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQrySingleDbNo_actionPerformed(e);
      }
    });
    btnQrySingleDbNo.setText("SINGLE D/B #");
    btnQrySingleDbNo.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQrySingleDbNo.setBounds(new Rectangle(464, 376, 129, 26));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQryDebitNote, null);
    this.add(btnAddNew, null);
    this.add(btnExit, null);
    //this.add(btnQryBatchNo, null);
    this.add(btnQryTempDbRcNo, null);
    this.add(txtBatchNo, null);
    this.add(txtTmpDrBr, null);
    this.add(btnQryBatch, null);
    this.add(cbxType, null);
    this.add(lblCenter, null);
    this.add(lblCenterContext, null);
    this.add(lblDBNO1, null);
    this.add(cbxDep, null);
    this.add(lblCenter4, null);
    this.add(cbxBuyerMakerType, null);
    this.add(selectBuyerMaker, null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(lblDBNO2, null);
    this.add(lblCenter3, null);
    this.add(cbxKind, null);
    this.add(lblShipNo, null);
    this.add(txtSRN, null);
    this.add(lblDBNO3, null);
    this.add(txtDDK_ChkNo, null);
    this.add(txtSingleDbNo, null);
    this.add(btnQrySingleDbNo, null);
    //this.add(btnKindMaintain, null);

    if(util.PublicVariable.USER_RECORD.getInt(2)==
       newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      this.add(btnKindMaintain, null);
    }
    //init the combobox content...

    lblCenterContext.setText(centerName);
    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_PREFIX",
            null,"",null);
      for(int i=0;i<5;i++){
           DrCrType[i]=new exgui.ultratable.Wraper4tblCbx();
           DrCrType[i].setValue(DrCrTypeValue[i]);
           DrCrType[i].setString(DrCrTypeString[i]);
        }
      cbxType.setModel(new javax.swing.DefaultComboBoxModel(DrCrType));
      selectBuyerMaker.init("",null,selectBuyerMaker.TYPE_BUYER,true);

      if(newtimes.accounting.debit_note.Constans.VCT_DEBITNOTE_KIND==null){
        newtimes.accounting.debit_note.Constans.VCT_DEBITNOTE_KIND=
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select a.*,to_char(a.dbnt_kind_seq) as seq_str from DEBITNOTE_KIND a where a.record_delete_flag='1'",
           1,9999999);
      }

      DbJcbxcbxKind =
          new exgui.DataBindJCombobox(
          cbxKind, "DBNT_DTL_KIND",
          Constans.VCT_DEBITNOTE_KIND,
          "DBNT_KIND_DESC",
          "SEQ_STR",
          null, "", null);

        Object vftxtYearMonth = exgui.verification.CellFormat.getIntVerifierAllowNull(6);
        //java.util.Calendar cldr=java.util.Calendar.getInstance();
        new exgui.DataBindTextWithChecker(txtDateFrom, "_YEAR",
                                          "", 6,
                                          (exgui.Object2String)vftxtYearMonth,
                                          (exgui.ultratable.CellTxtEditorFormat)
                                          vftxtYearMonth);
        new exgui.DataBindTextWithChecker(txtDateTo, "_YEAR",
                                          "", 6,
                                          (exgui.Object2String)vftxtYearMonth,
                                          (exgui.ultratable.CellTxtEditorFormat)
                                          vftxtYearMonth);

            Object vftxtTempDbCr = exgui.verification.CellFormat.getOrdinaryField(10);
            new exgui.DataBindTextWithChecker(txtTmpDrBr, "",
                                              "", 10,
                                              (exgui.Object2String)vftxtTempDbCr,
                                              (exgui.ultratable.CellTxtEditorFormat)
                                              vftxtTempDbCr);



  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  protected boolean ComposeCondition(){
    newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.clear();
     //"ZATWMM503227"
    //if false,means have formate error.
    newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_CENTER_CODE,centerCode);

    if(txtSRN.getText().trim().length()>0){
      if(txtSRN.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("Length of INVOICE NO Should Be At Least 6 Characters","Inovice# Too Short");
        txtSRN.grabFocus();
        txtSRN.selectAll();
        return false;
      }else{
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_QRY_SHIP_NO,
                                                                            txtSRN.getText().trim());
      }
    }
    if(txtDateFrom.getText().trim().length()>0){
      if(txtDateFrom.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM","DATE FORMATE IS YYYYMM");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(0,4))<2005){
        exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2005","YEAR CAN NOT LESS THAN 2005");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))<1||
         Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))>12){
        exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ","MONTH RANGE ERROR");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
    }

      if(txtDateFrom.getText().trim().length()>0){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_DATE_FROM,txtDateFrom.getText().trim());
      }
     if(txtDateTo.getText().trim().length()>0){
       if (txtDateTo.getText().trim().length() < 6) {
         exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM",
                                                "DATE FORMATE IS YYYYMM");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(0, 4)) < 2005) {
         exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2005",
                                                "YEAR CAN NOT LESS THAN 2005");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) < 1 ||
           Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) > 12) {
         exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ",
                                                "MONTH RANGE ERROR");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
     }
      if(txtDateFrom.getText().trim().length()>0 &&
         txtDateTo.getText().trim().length()>0 ){
         if(Integer.parseInt(txtDateFrom.getText().trim())>
            Integer.parseInt(txtDateTo.getText().trim())){
           exgui.verification.VerifyLib.showAlert("\"From\" Date Can Not After \"To\" Date","Date Compare Error");
           return false;
         }
      }
      if(txtDateTo.getText().trim().length()>0){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_DATE_TO,txtDateTo.getText().trim());
      }
      if(dbCbxDep.getSelectedValue()!=null){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          CONDITION_DEPT,
          dbCbxDep.getSelectedValue());
      }
      if(selectBuyerMaker.getSelectedValue()!=null){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          CONDITION_BUYER_MAKER ,
          selectBuyerMaker.getSelectedValue().toString());
      }
      if(DbJcbxcbxKind.getSelectedValue()!=null){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          CONDITION_KIND,
          DbJcbxcbxKind.getSelectedValue());
      }
      String type=(String)((exgui.ultratable.Wraper4tblCbx)cbxType.getSelectedItem()).getValue();

      if(!type.equals("")){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          CONDITION_TYPE,
          type);
      }
      String chkNo=txtDDK_ChkNo.getText().trim();
      if(!chkNo.equals("")){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          CONDITION_DDK_CHECKNO,
          chkNo);
      }

    return true;
  }
  void btnQryDebitNote_actionPerformed(ActionEvent e) {
    try{
      //PnlListQryDebitNote.Pnl2List=null;//initialize;
       //Constans.BGN_POS_OF_QRY_DRCR_NO=0;
       if(!ComposeCondition())return;
       /*
       newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put("BEGIN_DRCRNO_STRING",
              txtDebitNoteNo.getText().trim().toUpperCase()); */
       newtimes.accounting.debit_note.Constans.BGN_POS_OF_QRY_DRCR_NO=1;
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrListQryDebitNote());
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    DlgAddDebitNoteNo dlg=new DlgAddDebitNoteNo(util.PublicVariable.APP_FRAME,
                                                "ADD NEW DB/CR RECORD",true);
    dlg.setSize(410,325);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    /*
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrEditDebitNoteHead());
    }catch(Exception exp){
      exp.printStackTrace();
     }
    */
  }

  void btnKindMaintain_actionPerformed(ActionEvent e) {
    DlgDrCrKindMaintain dlg=new DlgDrCrKindMaintain(util.PublicVariable.APP_FRAME,"Maintain DB/CR Kind",true);
    dlg.setSize(400,360);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }

  void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {
    selectBuyerMaker.init("",null,
    Integer.parseInt(
    (String)
    newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
    ),true);
  }


  void btnQryBatch_actionPerformed(ActionEvent e) {
    if(txtBatchNo.getText().trim().length()<"HH070002".length()){
      exgui.verification.VerifyLib.showAlert("Length of Batch No is 8 characters",
                                             "Length of Batch No is 8 characters");
      return;
    }
    try{
      newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.clear();
      newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_CENTER_CODE,centerCode);
      newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_QRY_EXACT_BATCH,
                                                                          txtBatchNo.getText().trim());
      newtimes.accounting.debit_note.Constans.BGN_POS_OF_QRY_DRCR_NO = 1;
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          new newtimes.accounting.debit_note.TgrListQryDebitNote());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnQryTempDbRcNo_actionPerformed(ActionEvent e) {
    if(txtTmpDrBr.getText().trim().startsWith("-")){
      exgui.verification.VerifyLib.showAlert("本眀絏ぃ璽计","本眀絏ぃ璽计");
      return;
    }
    try{
      newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.clear();
      newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_CENTER_CODE,centerCode);
      newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_TEMP_DBCRNO,txtTmpDrBr.getText().trim());
      newtimes.accounting.debit_note.Constans.BGN_POS_OF_QRY_DRCR_NO = 1;
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          new newtimes.accounting.debit_note.TgrListQryDebitNote());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnQrySingleDbNo_actionPerformed(ActionEvent e) {
     //single D/B# should at least 10 characters
     try{
       if(txtSingleDbNo.getText().trim().length()<10){
         exgui.verification.VerifyLib.showAlert("DB/CR# Should At Least 10 Characters",
                                                "DB/CR# Should At Least 10 Characters");
         return;
       }
       newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.clear();
       newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_CENTER_CODE,centerCode);
       newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(CONDITION_SINGLE_DB_NO,
                                                                           txtSingleDbNo.getText().trim());
       newtimes.accounting.debit_note.Constans.BGN_POS_OF_QRY_DRCR_NO = 1;
       processhandler.template.Properties.getCenteralControler().
           doCommandExecute(
           new newtimes.accounting.debit_note.TgrListQryDebitNote());
     }catch(Exception exp){
       exp.printStackTrace();
     }

  }
}
