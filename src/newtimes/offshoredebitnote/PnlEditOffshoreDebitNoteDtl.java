package newtimes.offshoredebitnote;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditOffshoreDebitNoteDtl
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JComboBox cbxCountry = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField txtDrCrNo = new JTextField();
  JTextField txtDate = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JTextField txtFields[]=new JTextField[10];
  JButton btnDelete = new JButton();
  //JTextField txtCommFee = new JTextField(); 0
  //JTextField txtMiscFee = new JTextField(); 1
  //JTextField txtSampleFee = new JTextField(); 2
  //JTextField txtTrvlFee = new JTextField(); 3
  //JTextField txtTransportFee = new JTextField(); 4
  //JTextField txtClaimFee = new JTextField(); 5
  //JTextField txtApFee = new JTextField(); 6
  //JTextField txtTelFee = new JTextField(); 7
  //JTextField txtSocialFee = new JTextField(); 8
  //JTextField txtArFee = new JTextField(); 9

  public PnlEditOffshoreDebitNoteDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void doPrint(){}
  public void record2Gui(){
    dataBoundGUIs.clear();
    try{
    dataBoundGUIs.add(
          new exgui.DataBindJCombobox(cbxDep,
                                      "DTL_DEP_CODE",
                                      PnlQryOffshoreDebitNote.vctDep,
                                      "DEP_CODE",
                                      "DEP_CODE", recToMapping.get("DTL_DEP_CODE")));

    dataBoundGUIs.add(
          new exgui.DataBindJCombobox(cbxCountry, "DTL_CNTY_PK",
                                      PnlQryOffshoreDebitNote.vctCountry,
                                      "CNTY_NAME", "CNTY_PK",
                                      recToMapping.get("DTL_CNTY_PK")));


    Object vftxtDrCrNo=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(20);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDrCrNo,"DTL_DRCR_NO",
         recToMapping.get("DTL_DRCR_NO"),20,(exgui.Object2String)vftxtDrCrNo,(exgui.ultratable.CellTxtEditorFormat)vftxtDrCrNo)
    );

    Object vftxtDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtDate,
                                        "DTL_DATE",
                                        recToMapping.get("DTL_DATE"),
                                        10,(exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtDate)
    );

    Object vftxtFee=newtimes.bank.PnlEditBankHead.getConvDecimalFormat();
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFields[0],"DTL_COMM_FEE",
         recToMapping.get("DTL_COMM_FEE"),12,
         (exgui.Object2String)vftxtFee,
         (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[1]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtFields[1],
                                        "DTL_MISC_FEE",
                                        recToMapping.get("DTL_MISC_FEE"),12,
                                        (exgui.Object2String)vftxtFee,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[2]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtFields[2],
                                        "DTL_SMPL_FEE",
                                        recToMapping.get("DTL_SMPL_FEE"),12,
                                        (exgui.Object2String)vftxtFee,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[3]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtFields[3],"DTL_TRVL_FEE",
                                        recToMapping.get("DTL_TRVL_FEE"),12,
                                        (exgui.Object2String)vftxtFee,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[4]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtFields[4],
                                        "DTL_TRNPORT_FEE",
                                        recToMapping.get("DTL_TRNPORT_FEE"),12,
                                        (exgui.Object2String)vftxtFee,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[5]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtFields[5],"DTL_CLAIM_FEE",
                                        recToMapping.get("DTL_CLAIM_FEE"),12,
                                        (exgui.Object2String)vftxtFee,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[6]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(
      txtFields[6],"DTL_AP_FEE",recToMapping.get("DTL_AP_FEE"),12,
      (exgui.Object2String)vftxtFee,
      (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[7]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(
      txtFields[7],"DTL_TEL_FEE",
      recToMapping.get("DTL_TEL_FEE"),12,
      (exgui.Object2String)vftxtFee,
      (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[8]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtFields[8],"DTL_SOCIAL_FEE",
                                        recToMapping.get("DTL_SOCIAL_FEE"),12,
                                        (exgui.Object2String)vftxtFee,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
    //Object vftxtFields[9]=exgui.verification.CellFormat.getDoubleFormatAllowNull(11,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtFields[9],"DTL_AR_FEE",
                                        recToMapping.get("DTL_AR_FEE"),12,
                                        (exgui.Object2String)vftxtFee,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtFee)
    );
     FXLISTEN obj2listen=new FXLISTEN();
     for(int i=0;i<10;i++){
       txtFields[i].addFocusListener(obj2listen);
     }


    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  class FXLISTEN extends java.awt.event.FocusAdapter{
    public void focusLost(java.awt.event.FocusEvent fe){
      if(!(fe.getSource() instanceof javax.swing.JTextField))return;
      javax.swing.JTextField txtObj=(javax.swing.JTextField )fe.getSource();
      if(txtObj.getText().length()>0 && txtObj.getText().indexOf(",")==-1){
        txtObj.setText(newtimes.bank.PnlEditBankHead.initformatter.format(Double.parseDouble(txtObj.getText())));
      }

    }
  }
  public boolean gui2Record(){
    boolean result=super.gui2Record();
    if(!result)return false;
    //check date,DR/CR NO and at least one fee field inputed
    if(txtDate.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Date",
                                             "Please Input Date");
      txtDate.grabFocus();
      return false;
    }
    if(txtDrCrNo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please DR/CR NO.",
                                             "Please DR/CR NO.");
      txtDrCrNo.grabFocus();
      return false;
    }
    //at least one fee have tobe input.
    try{
      for (int i = 0; i < 10; i++) {
        if (txtFields[i].
            getText().trim().length()>0 &&
            newtimes.bank.PnlEditBankHead.initformatter.parse(txtFields[i].
            getText().trim()).doubleValue() != 0) {
           return true;
        }
      }
      exgui.verification.VerifyLib.showAlert("請至少輸少一款項",
                                             "請至少輸少一款項");
      return false;
    }catch(Exception exp){
      exp.printStackTrace();
    }

    return false;
  }
  protected void jbInit() throws Exception {
    for(int i=0;i<10;i++){
      txtFields[i]=new JTextField();
    }
    blueBkgWhiteCharLabel1.setText("Detail Of Offshore Debit Note");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 21, 800, 34));
    this.setLayout(null);
    btnUpdate.setBounds(new Rectangle(298, 506, 127, 29));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("Confirm Update");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(606, 503, 120, 34));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jLabel2.setBounds(new Rectangle(80, 64, 113, 26));
    jLabel2.setText("DEPARTMENT : ");
    jLabel2.setBackground(new Color(143, 143, 188));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setForeground(Color.white);
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBackground(new Color(143, 143, 188));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.white);
    jLabel1.setOpaque(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("COUNTRY : ");
    jLabel1.setBounds(new Rectangle(325, 64, 113, 26));
    cbxDep.setBounds(new Rectangle(197, 64, 119, 25));
    cbxCountry.setBounds(new Rectangle(442, 64, 223, 23));
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setOpaque(true);
    jLabel3.setForeground(Color.white);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setBackground(new Color(143, 143, 188));
    jLabel3.setText("DR/CR NO : ");
    jLabel3.setBounds(new Rectangle(80, 100, 113, 26));
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setOpaque(true);
    jLabel4.setForeground(Color.white);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setBackground(new Color(143, 143, 188));
    jLabel4.setText("DATE : ");
    jLabel4.setBounds(new Rectangle(80, 135, 113, 26));
    txtDrCrNo.setText("");
    txtDrCrNo.setBounds(new Rectangle(197, 100, 221, 27));
    txtDate.setText("");
    txtDate.setBounds(new Rectangle(197, 135, 166, 26));
    jLabel5.setText("YYYY/MM/DD");
    jLabel5.setBounds(new Rectangle(370, 137, 92, 25));
    jLabel6.setBounds(new Rectangle(80, 169, 113, 26));
    jLabel6.setText("佣金支出 :");
    jLabel6.setBackground(new Color(143, 143, 188));
    jLabel6.setFont(new java.awt.Font("Monospaced", 0, 12));
    jLabel6.setForeground(Color.white);
    jLabel6.setOpaque(true);
    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(Color.white);
    jLabel7.setFont(new java.awt.Font("Monospaced", 0, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setText("什 費 :");
    jLabel7.setBounds(new Rectangle(80, 202, 113, 26));
    jLabel8.setBounds(new Rectangle(80, 236, 113, 26));
    jLabel8.setText("樣品費 :");
    jLabel8.setBackground(new Color(143, 143, 188));
    jLabel8.setFont(new java.awt.Font("Monospaced", 0, 12));
    jLabel8.setForeground(Color.white);
    jLabel8.setOpaque(true);
    jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Monospaced", 0, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setText("旅費 :");
    jLabel9.setBounds(new Rectangle(80, 268, 113, 26));
    jLabel10.setBounds(new Rectangle(80, 301, 113, 26));
    jLabel10.setText("運費 :");
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Monospaced", 0, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(Color.white);
    jLabel11.setFont(new java.awt.Font("Monospaced", 0, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    jLabel11.setText("交際費 :");
    jLabel11.setBounds(new Rectangle(309, 169, 113, 26));
    jLabel12.setBounds(new Rectangle(309, 236, 113, 26));
    jLabel12.setText("CLAIM :");
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Monospaced", 1, 12));
    jLabel12.setForeground(Color.white);
    jLabel12.setOpaque(true);
    jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel13.setBounds(new Rectangle(309, 202, 113, 26));
    jLabel13.setText("電話費 :");
    jLabel13.setBackground(new Color(143, 143, 188));
    jLabel13.setFont(new java.awt.Font("Monospaced", 0, 12));
    jLabel13.setForeground(Color.white);
    jLabel13.setOpaque(true);
    jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel14.setOpaque(true);
    jLabel14.setForeground(Color.white);
    jLabel14.setFont(new java.awt.Font("Monospaced", 1, 12));
    jLabel14.setBackground(new Color(143, 143, 188));
    jLabel14.setText("A / P :");
    jLabel14.setBounds(new Rectangle(309, 268, 113, 26));
    jLabel15.setBounds(new Rectangle(309, 301, 113, 26));
    jLabel15.setText("A / R :");
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel15.setFont(new java.awt.Font("Monospaced", 1, 12));
    jLabel15.setForeground(Color.white);
    jLabel15.setOpaque(true);
    jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
    txtFields[0].setText("");
    txtFields[0].setBounds(new Rectangle(193, 170, 110, 25));
    txtFields[1].setBounds(new Rectangle(193, 202, 110, 25));
    txtFields[1].setText("jTextField1");
    txtFields[1].setText("");
    txtFields[2].setBounds(new Rectangle(193, 236, 110, 25));
    txtFields[2].setText("jTextField1");
    txtFields[2].setText("");
    txtFields[3].setBounds(new Rectangle(193, 268, 110, 25));
    txtFields[3].setText("jTextField1");
    txtFields[3].setText("");
    txtFields[4].setBounds(new Rectangle(193, 301, 110, 25));
    txtFields[4].setText("jTextField1");
    txtFields[4].setText("");
    txtFields[5].setText("");
    txtFields[5].setText("");
    txtFields[5].setBounds(new Rectangle(422, 236, 110, 25));
    txtFields[6].setText("");
    txtFields[6].setText("");
    txtFields[6].setBounds(new Rectangle(422, 268, 110, 25));
    txtFields[7].setText("");
    txtFields[7].setText("");
    txtFields[7].setBounds(new Rectangle(422, 202, 110, 25));
    txtFields[8].setBounds(new Rectangle(422, 170, 110, 25));
    txtFields[8].setText("");
    txtFields[9].setText("");
    txtFields[9].setBounds(new Rectangle(422, 301, 110, 25));
    btnDelete.setBounds(new Rectangle(114, 506, 97, 27));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE ");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel2, null);
    this.add(cbxDep, null);
    this.add(jLabel1, null);
    this.add(cbxCountry, null);
    this.add(txtDrCrNo, null);
    this.add(jLabel3, null);
    this.add(jLabel4, null);
    this.add(txtDate, null);
    this.add(jLabel5, null);
    this.add(jLabel6, null);
    this.add(jLabel7, null);
    this.add(jLabel8, null);
    this.add(jLabel9, null);
    this.add(jLabel10, null);
    this.add(jLabel11, null);
    this.add(jLabel13, null);
    this.add(jLabel12, null);
    this.add(jLabel14, null);
    this.add(jLabel15, null);
    this.add(btnUpdate, null);
    this.add(btnExit, null);
    this.add(btnDelete, null);
    this.add(txtFields[0], null);
    this.add(txtFields[1], null);
    this.add(txtFields[2], null);
    this.add(txtFields[3], null);
    this.add(txtFields[4], null);
    this.add(txtFields[5], null);
    this.add(txtFields[6], null);
    this.add(txtFields[7], null);
    this.add(txtFields[8], null);
    this.add(txtFields[9], null);
  }
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
        if(((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_COMM_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_MISC_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_SMPL_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_TRVL_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_TRNPORT_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_CLAIM_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_AP_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_TEL_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_SOCIAL_FEE")||
           ((String)recToMapping.getFieldName().get(colIndex)).equals("DTL_AR_FEE")){
          if(!newtimes.bank.PnlEditBankHead.numFormater.Obj2String(newObj).equals(
              newtimes.bank.PnlEditBankHead.numFormater.Obj2String(oldObj))){
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
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Do You Really Want To Exit without Confirmation ?",
                                                     "Data Modified,But Not Confirm Yet",false)){
          return;
        }
      }
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    if(!gui2Record())return;
    try{
      super.doUpdate();
      exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
      btnExit_actionPerformed(null);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("更新失敗,請洽系統管理員","Update Faile");
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("真的要刪除這筆資料嗎?","Do you Sure To Delete ?",false)){
      return;
    }
    try{
      recToMapping.set("record_delete_flag","0");
      recToMapping.set("record_delete_user",util.PublicVariable.USER_RECORD.get(0));
      recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
      doUpdate();
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("刪除失敗,請洽系統管理員","Update Faile");
    }



  }
}
