package newtimes.bank;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import processhandler.template.PnlFieldsEditor;
import database.datatype.Record;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditBankHead
    //extends JPanel {
    extends PnlFieldsEditor{
  Record recB4Edit;
  BlueBkgWhiteCharLabel pnlTitleLabel = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();

  JButton btnCfm = new JButton();
  JButton btnExit = new JButton();
  JComboBox cbxCompany = new JComboBox();
  JComboBox cbxBank = new JComboBox();
  JTextField txtAccNo = new JTextField();
  JTextField txtInitAmt = new JTextField();
  JTextField txtChkDD = new JTextField();
  JButton btnDelete = new JButton();
   boolean isProcessingExit=false;
   boolean isButtonExitPressed=false;
  public static java.text.DecimalFormat initformatter=new java.text.DecimalFormat("###,###,###,###,###,###.00");
  public static objConvDecimalFormat numFormater=null;
  public PnlEditBankHead() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public static Object getConvDecimalFormat(){
     if(numFormater==null){
       numFormater=new objConvDecimalFormat(13,2);
     }
     return numFormater;
  }
  protected void jbInit() throws Exception {
    //pnlTitleLabel.setText("EDIT BANK HEAD");
    pnlTitleLabel.setBounds(new Rectangle(-3, 17, 801, 24));
    this.setLayout(null);
    btnCfm.setBounds(new Rectangle(141, 522, 133, 31));
    btnCfm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCfm.setText("CONFIRM EDIT");
    btnCfm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCfm_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(587, 522, 99, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel2.setText("COMPANY:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(157, 92, 162, 23));
    cbxCompany.setBounds(new Rectangle(320, 92, 235, 22));
    cbxBank.setBounds(new Rectangle(317, 172, 233, 22));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(157, 172, 162, 23));
    blueBkgWhiteCharLabel3.setText("BANK:");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(157, 253, 162, 23));
    blueBkgWhiteCharLabel4.setText("ACCOUNT NO:");
    txtAccNo.setText("");
    txtAccNo.setBounds(new Rectangle(318, 253, 233, 23));
    txtInitAmt.setBounds(new Rectangle(320, 333, 233, 23));
    txtInitAmt.setText("jTextField1");
    txtInitAmt.setText("");
    blueBkgWhiteCharLabel5.setText("INIT:");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(157, 333, 162, 23));
    txtChkDD.setBounds(new Rectangle(319, 413, 233, 23));
    txtChkDD.setText("jTextField1");
    txtChkDD.setText("");
    blueBkgWhiteCharLabel6.setText("CHK-DD:");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(157, 413, 162, 23));
    this.setBackground(new Color(202, 202, 224));
    btnDelete.setBounds(new Rectangle(364, 522, 108, 31));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    this.add(pnlTitleLabel, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxCompany, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(txtChkDD, null);
    this.add(txtInitAmt, null);
    this.add(cbxBank, null);
    this.add(txtAccNo, null);
    this.add(btnCfm, null);
    this.add(btnExit, null);
    this.add(btnDelete, null);
  }
  public void doPrint(){}
  public boolean isContextModified(){
    if(!gui2Record())return true;
    //return(!recToMapping.toString().equals(recClonedForCheck.toString()));
    //list all modified column and test values
    java.util.List modColumns=recToMapping.getModifiedFields();
    try{
      for (int i = 0; i < modColumns.size(); i++) {
        int colIndex =((Integer)modColumns.get(i)).intValue();
        Object newObj=recToMapping.get(colIndex);
        Object oldObj=recClonedForCheck.get(colIndex);
        if(((String)recToMapping.getFieldName().get(colIndex)).equals("INITIAL_AMT")){
          if(!numFormater.Obj2String(newObj).equals(numFormater.Obj2String(oldObj))){
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
  public void record2Gui(){
    try{
      if(recToMapping.getInt(0)==-1){
        pnlTitleLabel.setText("ADD BANK HEAD");
      }else{
        pnlTitleLabel.setText("EDIT BANK HEAD");
      }

      recB4Edit=(Record)util.MiscFunc.deepCopy(recToMapping);
      dataBoundGUIs.clear();
      java.util.Vector vctCompany=Constants.vctCompany;
      exgui.DataBindJCombobox DbJcbxcbxCompany =
          new exgui.DataBindJCombobox(cbxCompany,
                                      "COMP_ID",
                                      vctCompany,
                                      "COMPANY_NAME",
                                      "COMPANY_CODE",
                                      recToMapping.get("COMP_ID"));
      dataBoundGUIs.add(DbJcbxcbxCompany);

      java.util.Vector vctBanks=Constants.vctBank;
      exgui.DataBindJCombobox DbJcbxcbxBank =
          new exgui.DataBindJCombobox(cbxBank,"BANK_ID",
                                      vctBanks,"BANK_NAME","BANK_CODE",
                                      recToMapping.get("BANK_ID"));
     dataBoundGUIs.add(DbJcbxcbxBank);

      Object vftxtAccNo=exgui.verification.CellFormat.getOrdinaryField(15);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtAccNo,"ACCT_NO",
           recToMapping.get("ACCT_NO"),15,(exgui.Object2String)vftxtAccNo,
           (exgui.ultratable.CellTxtEditorFormat)vftxtAccNo)
      );
      Object vftxtInitAmt=new objConvDecimalFormat(13,2);
    //exgui.verification.CellFormat.getDoubleFormatAllowNull(13,2);

       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(txtInitAmt,"INITIAL_AMT",
                                            recToMapping.get("INITIAL_AMT"),15,
                                            (exgui.Object2String)vftxtInitAmt,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtInitAmt)
      );

      Object vftxtChkDD=RocDateFormator.getRocDateFormat();
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(
           txtChkDD,"CHK_DD",
           recToMapping.get("CHK_DD"),9,
           (exgui.Object2String)vftxtChkDD,
           (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD)
      );
      //initial all fields

      if(recToMapping.getInt(0)==-1){
        btnDelete.setEnabled(false);
      }else{
        btnDelete.setEnabled(true);
      }

      if(recToMapping.getInt(0)>0){
        //for editing mode,only MIS able to modify init and chk date
        if(!(util.PublicVariable.USER_RECORD.getInt(2)==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS||
          util.PublicVariable.USER_RECORD.getInt(2)==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS)){
          cbxCompany.setEditable(false);
          cbxCompany.setEnabled(false);
          cbxBank.setEditable(false);
          cbxBank.setEnabled(false);
          txtAccNo.setEditable(false);
          txtAccNo.setEnabled(false);
          txtInitAmt.setEditable(false);
          txtInitAmt.setEnabled(false);
          btnDelete.setEnabled(false);
        }
      }

      txtInitAmt.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(FocusEvent e) {
          txtInitAmt_focusLost(e);
        }
      });

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
   try{
     isButtonExitPressed=true;
     doExit();
   }catch(Exception exp){
      exp.printStackTrace();

   }
    /*
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }*/

  }
  public boolean gui2Record(){
    boolean result=super.gui2Record();
    if(!result)return result;
    if((!isButtonExitPressed) && txtChkDD.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Inptu CHK-DD",
                                             "Please Input CHK-DD");
      return false;
    }
    return true;
  }
  public void doDelete(){
    try{
      if (checkCompBankUsed(true))return;
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
  public boolean checkCompBankUsed(boolean is4Delete)throws Exception{
    String orgCompId=(String)recB4Edit.get(1);
    String orgBankId=(String)recB4Edit.get(2);

    String compId=(String)recToMapping.get(1);
    String bankId=(String)recToMapping.get(2);
    if(!is4Delete){
      if (orgCompId.equals(compId) && orgBankId.equals(bankId)) {
        return false;
      }
    }
    StringBuffer sb=new StringBuffer();
    sb.append("select a.*,b.BANK_NAME,c.COMPANY_NAME from BANK_CHK_DETAIL a,bank b,COMPANY4BANK c where ");
    sb.append("a.COMP_ID='");sb.append(orgCompId);sb.append("'");sb.append(" and ");
    sb.append("a.BANK_ID='");sb.append(orgBankId);sb.append("'");
    sb.append(" and a.BANK_ID=b.BANK_CODE and a.COMP_ID=c.COMPANY_CODE");
    Vector vctChks=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
     util.PublicVariable.USER_RECORD,
     sb.toString(),1,1);
     if(vctChks.size()>0){
       Record rec=(Record)vctChks.get(0);
       String bankName=(String)rec.get("BANK_NAME");
       String compName=(String)rec.get("COMPANY_NAME");
       exgui.verification.VerifyLib.showAlert("COMPANY:"+compName+" BANK:"+bankName+" USED IN CHECK DATA",
                                              "COMPANY & CHECK 使用中");
       return true;
     }
     return false;
  }
  void btnCfm_actionPerformed(ActionEvent e) {
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
        exgui.verification.VerifyLib.showAlert("新增失敗,請檢查是否已定義此 BANK & COMPANY 之組合",
                                               "新增失敗");
        return;
      }
    }else{
      try{
        //check if bank&comp mapping is already used
        if(checkCompBankUsed(false)){

            return;
        }
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
        exgui.verification.VerifyLib.showAlert("修改失敗,請檢查是否已定義此 BANK & COMPANY 之組合",
                                               "修改失敗");
        return;
      }
    }
   //record2Gui();
     //btnExit_actionPerformed(null);
  }
 static public class objConvDecimalFormat implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    java.text.DecimalFormat formatter = null;//new java.text.DecimalFormat("######.###");
    int _maxLength=0;
    int _intDigitLength=0,_floatDigitLength=0;
    String headString,tailString;
    Object objHandleKey=exgui.verification.CellFormat.getDoubleFormatAllowNull(13,2);
    //Object objHandleKey=new objConvDecimalFormat(13,2);
    public objConvDecimalFormat(int intDigitLength,int floatDigitLength){
      _maxLength=intDigitLength+floatDigitLength+1;//include "." character
      _intDigitLength=intDigitLength;
      _floatDigitLength=floatDigitLength;
      String totalString="####################";
      formatter=new java.text.DecimalFormat("###,###,###,###,###,##0.00");
      headString=totalString.substring(0,_intDigitLength);
      tailString=totalString.substring(0,_floatDigitLength);
    }

    public int getMaxLength(){return _maxLength ;}
    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)objHandleKey).getKeyListener();
    }
    public String formatPromptMsg(){return "String must be in decimal format:"+headString+"."+tailString;}
    public boolean isFormatValid(String inStr,int row,int column){
      return ((exgui.ultratable.CellTxtEditorFormat)objHandleKey).isFormatValid(inStr,row,column);
    }
    public String Obj2String(Object obj2kvt){
       if(obj2kvt==null) return "";
       return formatter.format(Double.parseDouble(obj2kvt.toString()));
    }
     public Object cellStringToObject(String String2kvt){
        if(String2kvt==null) return null;
        if(String2kvt.trim().length()==0) return null;
            try {
              Double d = new Double(
                ((Number)formatter.parse((String)String2kvt)).doubleValue());
              return d;
            } catch (java.text.ParseException ex) {
              return new Double(0.0);
            }
     }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    doDelete();
    //btnExit_actionPerformed(null);
  }

  void txtInitAmt_focusLost(FocusEvent e) {
    if(txtInitAmt.getText().length()>0 && txtInitAmt.getText().indexOf(",")==-1){
      txtInitAmt.setText(initformatter.format(Double.parseDouble(txtInitAmt.getText())));
    }
  }
}
