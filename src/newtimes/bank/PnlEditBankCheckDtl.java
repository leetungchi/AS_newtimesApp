package newtimes.bank;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import processhandler.template.PnlFieldsEditor;
import database.datatype.Record;
import java.util.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditBankCheckDtl
//    extends JPanel {
    extends PnlFieldsEditor{
  BlueBkgWhiteCharLabel pnlTitleLabel = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxBank = new JComboBox();
  JComboBox cbxCompany = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JTextField txtCheckNO = new JTextField();
  JTextField txtIssueDate = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  JTextField txtIssueSeq = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  JTextField txtPayDate = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
  JTextField txtDC = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel9 = new BlueBkgWhiteCharLabel();
  JTextField txtAmount = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel10 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel20 = new BlueBkgWhiteCharLabel();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindJCombobox dbJcbxcbxCompany,dbJcbxcbxBank;
  int index4CbxBank;
  boolean isRecord2Gui=true;
  boolean isProcessingExit=false;
  JButton btnDelete = new JButton();
  JComboBox cbxPayeeItem = new JComboBox();
  JComboBox cbxType = new JComboBox();
  exgui.DataBindEditableJCombobox dbcbxPayeee;
  exgui.DataBindEditableJCombobox dbcbxtype;
  Vector typevct = new Vector();
  JTextField txtExchange = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel11 = new BlueBkgWhiteCharLabel();
  public PnlEditBankCheckDtl() {
    try {

      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected  void jbInit() throws Exception {
    //pnlTitleLabel.setText("EDIT CHECK DETAIL");
    pnlTitleLabel.setBounds(new Rectangle(0, 26, 779, 25));
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(196, 102, 162, 23));
    blueBkgWhiteCharLabel3.setText("BANK:");
    cbxBank.setBounds(new Rectangle(359, 102, 235, 22));
    cbxCompany.setBounds(new Rectangle(359, 60, 235, 22));
    cbxCompany.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCompany_itemStateChanged(e);
      }
    });
    blueBkgWhiteCharLabel2.setText("COMPANY:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(196, 60, 162, 23));
    blueBkgWhiteCharLabel4.setText("CHECK NO . ");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(196, 144, 162, 23));
    txtCheckNO.setText("");
    txtCheckNO.setBounds(new Rectangle(359, 144, 235, 23));
    txtIssueDate.setBounds(new Rectangle(359, 184, 235, 23));
    txtIssueDate.setBackground(new Color(202, 196, 224));
    txtIssueDate.setBorder(null);
    txtIssueDate.setText("");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(196, 184, 162, 23));
    blueBkgWhiteCharLabel5.setText("ISSUE-DD");
    blueBkgWhiteCharLabel6.setText("ISSUE SEQ");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(196, 229, 162, 23));
    txtIssueSeq.setBackground(new Color(202, 202, 224));
    txtIssueSeq.setBorder(null);
    txtIssueSeq.setText("");
    txtIssueSeq.setBounds(new Rectangle(359, 229, 235, 23));
    blueBkgWhiteCharLabel7.setText("PAY-DD");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(196, 271, 162, 23));
    txtPayDate.setText("");
    txtPayDate.setBounds(new Rectangle(359, 271, 235, 23));
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(196, 313, 162, 23));
    blueBkgWhiteCharLabel8.setText("D / C");
    txtDC.setBounds(new Rectangle(359, 313, 235, 23));
    txtDC.setText("");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(195, 355, 162, 23));
    blueBkgWhiteCharLabel9.setText("AMOUNT");
    txtAmount.setBounds(new Rectangle(359, 355, 235, 23));
    txtAmount.setText("");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(198, 433, 162, 23));
    blueBkgWhiteCharLabel10.setText("PAYEE");

    blueBkgWhiteCharLabel20.setBounds(new Rectangle(195, 438, 162, 23));
    blueBkgWhiteCharLabel20.setText("TYPE");
    btnOK.setBounds(new Rectangle(168, 526, 123, 28));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("CONFIRM");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(566, 526, 89, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnDelete.setBounds(new Rectangle(372, 526, 113, 28));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    cbxPayeeItem.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxPayeeItem_itemStateChanged(e);
      }
    });
    cbxPayeeItem.setEditable(true);
    cbxPayeeItem.setBounds(new Rectangle(361, 397, 235, 22));
    cbxType.setEditable(true);
    cbxType.setBounds(new Rectangle(361, 438, 235, 22));



    blueBkgWhiteCharLabel10.setBounds(new Rectangle(195, 397, 162, 23));
    txtExchange.setCaretPosition(0);
    txtExchange.setText("");
    txtExchange.setBounds(new Rectangle(360, 480, 235, 23));
    txtExchange.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        txtExchange_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel11.setToolTipText("");
    blueBkgWhiteCharLabel11.setText("EXCHANGE");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(195, 480, 162, 23));
    this.add(pnlTitleLabel, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxType);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(cbxCompany, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxBank, null);
    this.add(txtCheckNO, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(txtIssueDate, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(txtIssueSeq, null);
    this.add(blueBkgWhiteCharLabel7, null);
    this.add(txtPayDate, null);
    this.add(blueBkgWhiteCharLabel8, null);
    this.add(txtDC, null);
    this.add(txtAmount, null);
    this.add(cbxPayeeItem, null);
    this.add(btnExit, null);
    this.add(btnOK, null);
    this.add(btnDelete, null);
    this.add(blueBkgWhiteCharLabel9, null);
    this.add(blueBkgWhiteCharLabel11, null);
    this.add(blueBkgWhiteCharLabel20);
    this.add(blueBkgWhiteCharLabel10, null);
    this.add(txtExchange, null);
  }
  public void doPrint(){}
  public boolean gui2Record(){
    boolean result=super.gui2Record();
    if(!result)return result;
    //check if bank is bank.
    if(dbJcbxcbxBank==null || dbJcbxcbxBank.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Select Bank\nOr Define Bank Co-responding to the Company You selected in Bank-Head Edit GUI.",
                                             "Please Select Bank");
      return false;
    }
  /* //
    if(txtCheckNO.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigne CHECK NO",
                                             "Please Assigne CHECK NO");
      return false;

    }
*/
    //check pay date.
    if(txtPayDate.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigne Pay Date",
                                             "Please Assigne Pay Date");
      return false;
    }
    //check the pay date,can not befor the check date.
    java.util.Date datePayDate= (java.util.Date)
                                 new RocDateFormator().getRocDateFormat().cellStringToObject(txtPayDate.getText());
    java.util.Date dateCheck=
        (java.util.Date)Constants.hmCheckDateMap.get(dbJcbxcbxCompany.getSelectedValue()+"_"+dbJcbxcbxBank.getSelectedValue());
    if(datePayDate.before(dateCheck)){
      String dateString=new RocDateFormator().getRocDateFormat().Obj2String(dateCheck);
      exgui.verification.VerifyLib.showAlert("Pay Date Can Not Before "+dateString,
                                             "Pay Date Can Not Before "+dateString);
      txtPayDate.grabFocus();
      return false;
    }

    //check C/D code,can not be blank
    if(txtDC.getText().trim().length()<1){
      exgui.verification.VerifyLib.showAlert("Please Assigne C/D Of This Check",
                                             "Please Assigne C/D of This Check");
      txtDC.grabFocus();
      return false;
    }

    if(txtDC.getText().trim().length()>0 &&
       (!(txtDC.getText().trim().equalsIgnoreCase("D")||txtDC.getText().trim().equalsIgnoreCase("C")))){
      exgui.verification.VerifyLib.showAlert("C/D field Value should be \"C\" OR \"D\"",
                                             "C/D field value invalid.");
      txtDC.grabFocus();
      return false;
    }
    try{
      if (txtAmount.getText().trim().length() == 0 ||
          PnlEditBankHead.initformatter.parse(txtAmount.getText().trim()).
          doubleValue() == 0) {
        exgui.verification.VerifyLib.showAlert(
            "Please Assign Amount Of This Check",
            "Please Assign Amount Of This Check");
        txtAmount.grabFocus();
        return false;
      }
    }catch(Exception exp){
      exp.printStackTrace();
      return false;
    }
    if(dbcbxPayeee.getSelectedValue()==null || dbcbxPayeee.getSelectedValue().toString().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assign Payee Of This Check",
                                             "Please Assign payee Of This Check");
      cbxPayeeItem.grabFocus();
      return false;

    }
    /*
    if(txtPayee.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assign Payee Of This Check",
                                             "Please Assign payee Of This Check");
      txtPayee.grabFocus();
      return false;
    }*/

    return true;
  }
  public void doUpdate()throws Exception{
    if(recToMapping.getInt(0)<0){
      super.doAddNew();
      doExit();
      return;
    }
    super.doUpdate();

    doExit();
  }
  public void record2Gui(){
   try{
     if(recToMapping.getInt(0)==-1){
      pnlTitleLabel.setText("ADD CHECK DETAIL");
     }else{
      pnlTitleLabel.setText("EDIT CHECK DETAIL");
     }
     dataBoundGUIs.clear();
     Object vftxtChkDD=RocDateFormator.getRocDateFormat();
     Object vftxtCheckNO = exgui.verification.CellFormat.getOrdinaryField(10);
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCheckNO, "CHK_NO",
         recToMapping.get("CHK_NO"), 10,
         (exgui.Object2String)vftxtCheckNO,
                       (exgui.ultratable.CellTxtEditorFormat)vftxtCheckNO)
                       );
     //issue date is only generated by database.
     Object objSeq=recToMapping.get("ISSUE_SEQ");
     if(objSeq!=null){
       txtIssueSeq.setText(objSeq.toString());
     }
     new exgui.DataBindTextWithChecker(txtIssueDate,
         "ISSUE_DATE",
         recToMapping.get("ISSUE_DATE"), 9,
         (exgui.Object2String)vftxtChkDD,
         (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);

      txtIssueDate.setEditable(false);
      txtIssueSeq.setEditable(false);

     dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
         txtPayDate, "PAY_DD",
         recToMapping.get("PAY_DD"), 9,
         (exgui.Object2String)vftxtChkDD,
         (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD)
         );
     Object vftxtDC = exgui.verification.CellFormat.
         getOrdinaryFieldNotAllowNull(1);
     dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
         txtDC, "D_C",
         recToMapping.get("D_C"), 1,
         (exgui.Object2String)vftxtDC,
         (exgui.ultratable.CellTxtEditorFormat)vftxtDC)
         );
     Object vftxtAmount = PnlEditBankHead.getConvDecimalFormat();
         //exgui.verification.CellFormat.getDoubleFormatAllowNull(10, 2);
     dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
         txtAmount,
         "AMOUNT",
         recToMapping.get("AMOUNT"), 12,
         (exgui.Object2String)vftxtAmount,
         (exgui.ultratable.CellTxtEditorFormat)vftxtAmount)
         );

     //Object vftxtPayee = exgui.verification.CellFormat.getOrdinaryField(25);
    dbcbxPayeee= new exgui.DataBindEditableJCombobox(cbxPayeeItem,"PAYEE",Constants.VCT_PAYEE_ITEMS,
                                                    "ITEM_NAME","ITEM_NAME",recToMapping.get("PAYEE"),35) ;

     dataBoundGUIs.add(dbcbxPayeee);
     dataBoundGUIs.add( new exgui.DataBindEditableJCombobox(cbxType,"TYPE4USD",Constants.VCT_TYPE4USD,
                                                    "TYPE","TYPE",recToMapping.get("TYPE4USD"),4) );


     Object vftxtExchange = exgui.verification.CellFormat.getOrdinaryField(6);
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtExchange, "EXCHANGE",
                                                   recToMapping.get("EXCHANGE"), 6,
                                                   (exgui.Object2String)vftxtExchange,
                                                                 (exgui.ultratable.CellTxtEditorFormat)vftxtExchange)
                                                                 );




     isRecord2Gui=true;
     dbJcbxcbxCompany =
         new exgui.DataBindJCombobox(
         cbxCompany, "COMP_ID",
         Constants.vctCompany,
         "COMPANY_NAME",
         "COMPANY_CODE", recToMapping.get("COMP_ID"));
     isRecord2Gui=false;
     dataBoundGUIs.add(dbJcbxcbxCompany);
     index4CbxBank = dataBoundGUIs.size();
     dataBoundGUIs.add(null);//just to occupy a position.
     genBankCbx();//generate bank items to select.
     txtAmount.addFocusListener(new java.awt.event.FocusAdapter() {
       public void focusLost(FocusEvent e) {
         txtAmount__focusLost(e);
       }
     });

   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
   }
  }
  void txtAmount__focusLost(FocusEvent e) {
    if(txtAmount.getText().length()>0 && txtAmount.getText().indexOf(",")==-1){
      txtAmount.setText(PnlEditBankHead.initformatter.format(Double.parseDouble(txtAmount.getText())));
    }
  }

  protected void genBankCbx(){
    try{
      if (isRecord2Gui)return;
      Vector vct = (Vector)Constants.HM_COMPANY_BANK_MAP.get((String)
          dbJcbxcbxCompany.getSelectedValue());
      if(vct==null)vct=new Vector();
      if(vct.size()>0){
        dbJcbxcbxBank = new exgui.DataBindJCombobox(
            cbxBank, "BANK_ID", vct, "BANK_NAME", "BANK_CODE",
            recToMapping.get("BANK_ID"));
      }else{
        dbJcbxcbxBank = new exgui.DataBindJCombobox(
            cbxBank, "BANK_ID", vct, "BANK_NAME", "BANK_CODE",
            recToMapping.get("BANK_ID"),"",null);
      }

      dataBoundGUIs.set(index4CbxBank, dbJcbxcbxBank);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }

  void cbxCompany_itemStateChanged(ItemEvent e) {
   genBankCbx();
  }
  public boolean isContextModified(){
    if(isProcessingExit)return false;//for delete function
      if(!gui2Record())return true;
      //return(!recToMapping.toString().equals(recClonedForCheck.toString()));
      //list all modified column and test values
      java.util.List modColumns=recToMapping.getModifiedFields();
      try{
        for (int i = 0; i < modColumns.size(); i++) {
          int colIndex =((Integer)modColumns.get(i)).intValue();
          Object newObj=recToMapping.get(colIndex);
          Object oldObj=recClonedForCheck.get(colIndex);
          if(((String)recToMapping.getFieldName().get(colIndex)).equals("AMOUNT")){
            if(!PnlEditBankHead.numFormater.Obj2String(newObj).equals(PnlEditBankHead.numFormater.Obj2String(oldObj))){
              return true;
            }
          }else{
            if (!util.MiscFunc.isEqual(newObj, oldObj)) {
              System.out.println("column modified:" +
                                 (String)recToMapping.getFieldName().get(colIndex));
              System.out.println(" newObj:" + newObj + "," + " orgObj:" + oldObj);
              return true;
            }
          }
        }
        return false;

      }catch(Exception e){
        e.printStackTrace();
        util.ExceptionLog.exp2File(e,"exp while compare for modification check");
        return false;
      }

  }
  void btnOK_actionPerformed(ActionEvent e) {
    if(!gui2Record())return;
    if(recToMapping.getInt(0)==-1){
      try{
        dbprc.addRecord(recToMapping);
        //---do exit--
        isProcessingExit=true;
        processhandler.template.Properties.getCenteralControler().
            setDataProcesser(null);
        processhandler.template.Properties.getCenteralControler().goBack();

      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("新增失敗,請洽系統工程師",
                                               "新增失敗");
        return;
      }
    }else{
      try{
        java.util.Vector vct = new java.util.Vector();
        vct.add(recToMapping);
        dbprc.updateRecords(vct);
        //--do exit-----
        isProcessingExit=true;
        processhandler.template.Properties.getCenteralControler().
            setDataProcesser(null);
        processhandler.template.Properties.getCenteralControler().goBack();

      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("修改失敗,請洽系統工程師",
                                               "修改失敗");
        return;
      }
    }
   //record2Gui();
     //btnExit_actionPerformed(null);
  }
  public void doDelete(){
    try{
      boolean result=exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete It ?",
                                                              "Do You Sure To Delete It ?",false);
      if(!result)return;
      recToMapping.set("record_delete_user",util.PublicVariable.USER_RECORD.get(0));
      recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
      super.doDelete();
      //----do exit -------
      isProcessingExit=true;
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      //isProcessingExit=true;
      doExit();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
     doDelete();
  }
  void cbxPayeeItem_itemStateChanged(ItemEvent e) {

  }

  void txtExchange_actionPerformed(ActionEvent e) {

  }
}
