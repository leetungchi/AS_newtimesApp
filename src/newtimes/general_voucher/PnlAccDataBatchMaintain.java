package newtimes.general_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAccDataBatchMaintain extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtCmp = new JTextField();
  JTextField txtYYYYMM = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtAccCodeFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtAccCodeTo = new JTextField();
  JTextField txtDepFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JButton btnDeleteAccCode = new JButton();
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JTextField txtDepTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JButton btnCopy = new JButton();
  JButton btnExit = new JButton();

  public PnlAccDataBatchMaintain() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"COPY TO");
    blueBkgWhiteCharLabel1.setText("ACCOUNT DATA BATCH MAINTAIN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 31, 802, 37));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("COMPANY");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(193, 74, 104, 27));
    txtCmp.setText("");
    txtCmp.setBounds(new Rectangle(299, 74, 138, 27));
    txtYYYYMM.setBounds(new Rectangle(568, 74, 138, 27));
    txtYYYYMM.setText("jTextField1");
    txtYYYYMM.setText("");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(463, 74, 104, 27));
    whiteBkgBlueCharLabel2.setText("YYYYMM");
    blueBkgWhiteCharLabel2.setText("ACC CODE From:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(193, 112, 105, 27));
    txtAccCodeFrom.setText("");
    txtAccCodeFrom.setBounds(new Rectangle(299, 112, 90, 27));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(388, 112, 44, 27));
    blueBkgWhiteCharLabel3.setText("To");
    txtAccCodeTo.setBounds(new Rectangle(433, 112, 90, 27));
    txtAccCodeTo.setText("");
    txtDepFrom.setBounds(new Rectangle(299, 150, 90, 27));
    txtDepFrom.setText("");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(193, 149, 104, 27));
    whiteBkgBlueCharLabel3.setText("DEP CODE");
    btnDeleteAccCode.setBounds(new Rectangle(428, 149, 170, 31));
    btnDeleteAccCode.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDeleteAccCode.setText("DELETE ACC CODE");
    btnDeleteAccCode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDeleteAccCode_actionPerformed(e);
      }
    });
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(193, 197, 414, 64));
    jPanel1.setLayout(null);
    txtDepTo.setText("");
    txtDepTo.setBounds(new Rectangle(160, 18, 90, 27));
    whiteBkgBlueCharLabel4.setText("TO NEW DEP CODE");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(24, 19, 136, 27));
    btnCopy.setBounds(new Rectangle(261, 18, 137, 30));
    btnCopy.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy.setText("COPY");
    btnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(365, 284, 70, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    jPanel1.add(txtDepTo, null);
    jPanel1.add(btnCopy, null);
    jPanel1.add(whiteBkgBlueCharLabel4, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(btnDeleteAccCode, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtAccCodeFrom, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtAccCodeTo, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtCmp, null);
    this.add(txtYYYYMM, null);
    this.add(txtDepFrom, null);
    this.add(btnExit, null);
    Object vftxtComp=exgui.verification.CellFormat.getOrdinaryField(1);
    new exgui.DataBindTextWithChecker(txtCmp,
                                      "",
                                       null,1,
                                      (exgui.Object2String)vftxtComp,
                                      (exgui.ultratable.CellTxtEditorFormat)vftxtComp);


    Object vftxtDep=exgui.verification.CellFormat.getOrdinaryField(2);
    new exgui.DataBindTextWithChecker(txtDepFrom,
                                      "",
                                       null,2,
                                      (exgui.Object2String)vftxtDep,
                                      (exgui.ultratable.CellTxtEditorFormat)vftxtDep);

    new exgui.DataBindTextWithChecker(txtDepTo,
                                      "",
                                       null,2,
                                      (exgui.Object2String)vftxtDep,
                                      (exgui.ultratable.CellTxtEditorFormat)vftxtDep);



      Object vftxtYY=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
        new exgui.DataBindTextWithChecker(txtYYYYMM,
                                          "",
                                           null,6,
                                          (exgui.Object2String)vftxtYY,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtYY);

        Object vftxtAccCode=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
          new exgui.DataBindTextWithChecker(txtAccCodeFrom,
                                            "",
                                             null,4,
                                            (exgui.Object2String)vftxtAccCode,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtAccCode);

          new exgui.DataBindTextWithChecker(txtAccCodeTo,
                                            "",
                                             null,4,
                                            (exgui.Object2String)vftxtAccCode,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtAccCode);



  }
  boolean isYYYYMMOK(){
    if(txtCmp.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Compy Code","Please Input Company Code");
      return false;
    }
    if(!Constants.HT_ACC_COMPANY.containsKey("GV_COMP_"+txtCmp.getText().trim().toUpperCase())){
      exgui.verification.VerifyLib.showAlert("Compay Code Not Exists ",
                                             "Compay Code Not Exists");
      return false;

    }
    if(txtYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("Please Input YYYYMM","Please Input YYYYMM");
      return false;
    }
    if(txtYYYYMM.getText().trim().length()>0){
      String monthDigit = txtYYYYMM.getText().trim().substring(4, 6);
      if (Integer.parseInt(monthDigit) < 0 || (Integer.parseInt(monthDigit) > 12 && Integer.parseInt(monthDigit)!=99)) {
        exgui.verification.VerifyLib.showAlert("月份應介於1~12之間", "YYYYMM 格式有誤");
        txtYYYYMM.selectAll();
        txtYYYYMM.grabFocus();
        return false;
      }
    }

    if(txtAccCodeFrom.getText().trim().length()<4){
      exgui.verification.VerifyLib.showAlert("Please Input From Acc Code Code","Please Input Acc Code");
      return false;
    }
    if(txtAccCodeTo.getText().trim().length()<4){
      exgui.verification.VerifyLib.showAlert("Please Input End Acc Code Code","Please Input Acc Code");
      return false;
    }
   if(txtDepFrom.getText().trim().length()<2){
     exgui.verification.VerifyLib.showAlert("Please Input DEP Code","Please Input DEP Code");
     return false;

   }

    return true;

  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnCopy_actionPerformed(ActionEvent e) {
    //target is gv_acc_data,
    //test if have acc_data

    if(!isYYYYMMOK())return;
    if(txtDepTo.getText().trim().length()<2){
      exgui.verification.VerifyLib.showAlert("Please Input Dest. DEP Code","Please Input Dest. Code");
      return ;
    }

    StringBuffer sql=new StringBuffer();
    sql.append("select a.* from gv_acc_data a where ");
    sql.append("A.YYYYMM='");sql.append(txtYYYYMM.getText().trim());sql.append("' ");
    sql.append("and A.COMP='");sql.append(txtCmp.getText().trim().toUpperCase());sql.append("' ");
    sql.append("and to_number(substr(A.ACC_CODE,1,4)) >=");sql.append(txtAccCodeFrom.getText().trim());sql.append(" ");
    sql.append("and to_number(substr(A.ACC_CODE,1,4)) <=");sql.append(txtAccCodeTo.getText().trim());sql.append(" ");
    sql.append("and substr(a.acc_code, 6,2)='");sql.append(txtDepFrom.getText().trim().toUpperCase());sql.append("' ");
    sql.append("order by to_number(substr(A.ACC_CODE,1,4))");
    try{
      java.util.Vector vctAccCode =
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                               sql.toString(), 1, 99999);
      if(vctAccCode.size()==0){
        exgui.verification.VerifyLib.showAlert("查無此條件下的主檔資料",
                                               "查無此條件下的主檔資料");
        return;
      }
      util.MiscFunc.showProcessingMessage();
      java.util.Vector vct2Procee=new java.util.Vector();
      java.sql.Date now=new java.sql.Date(System.currentTimeMillis());
      database.datatype.Record recNew=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("GV_ACC_DATA_tbl");
      String newDepCode=txtDepTo.getText().trim().toUpperCase();
      String orgDepCode=txtDepFrom.getText().trim().toUpperCase();
      for(int i=0;i<vctAccCode.size();i++){
        database.datatype.Record recSrc=(database.datatype.Record)vctAccCode.get(i);
        database.datatype.Record recDest=(database.datatype.Record)util.MiscFunc.deepCopy(recNew);
        for(int j=0;j<recDest.getFieldName().size();j++){
          recDest.set(j,recSrc.get(j));
        }
        recDest.set(12,util.PublicVariable.USER_RECORD.get(0));//create user
        recDest.set(18,util.PublicVariable.USER_RECORD.get(0));//modify user
        recDest.set(13,now);//create date
        recDest.set(17,now);//modify date
        String accCode=(String)recSrc.get(4);
        String accCodeDestt=accCode.substring(0,5)+newDepCode+accCode.substring(7,accCode.length());
        recDest.set(4,accCodeDestt);
        String accCodeDescription=(String)recSrc.get(6);
        if(null==accCodeDescription)accCodeDescription="";
        accCodeDescription=util.MiscFunc.Replace(accCodeDescription,"-"+orgDepCode,"-"+newDepCode);
        recDest.set(6,accCodeDescription);
        vct2Procee.add(recDest);
      }
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");

      newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
      java.util.HashMap hmParam=new java.util.HashMap();
      hmParam.put("TPEMISCFUNC_ACTION_CODE","AXN_CODE_COPY_GV_ACC_DATA_FROM_DEP2DEP");
      hmParam.put("VCT2PROCE",vct2Procee);
      ejb2update.tpeMisFunc(hmParam);
      exgui.verification.VerifyLib.showPlanMsg("Process Finished","Process Finished");

    }catch(Exception exp){
       exp.printStackTrace();
       exgui.verification.VerifyLib.showAlert("Error While query Acc Data From Server",
                                              "Error While query Acc Data From Server");

    }

  }

  void btnDeleteAccCode_actionPerformed(ActionEvent e) {
    StringBuffer sql=new StringBuffer();
    util.MiscFunc.showProcessingMessage();
    sql.append("select a.* from gv_acc_data a where ");
    sql.append("A.YYYYMM='");sql.append(txtYYYYMM.getText().trim());sql.append("' ");
    sql.append("and A.COMP='");sql.append(txtCmp.getText().trim().toUpperCase());sql.append("' ");
    sql.append("and to_number(substr(A.ACC_CODE,1,4)) >=");sql.append(txtAccCodeFrom.getText().trim());sql.append(" ");
    sql.append("and to_number(substr(A.ACC_CODE,1,4)) <=");sql.append(txtAccCodeTo.getText().trim());sql.append(" ");
    sql.append("and substr(a.acc_code, 6,2)='");sql.append(txtDepFrom.getText().trim().toUpperCase());sql.append("' ");

    try{
      java.util.Vector vctAccCode =
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                               sql.toString(), 1, 99999);
      if(vctAccCode.size()==0){
        exgui.verification.VerifyLib.showAlert("查無此條件下的主檔資料",
                                               "查無此條件下的主檔資料");
        return;
      }
      if(!exgui.verification.VerifyLib.showConfirm("確定刪除此條件下的科目主檔嗎?\n一旦刪除無法恢復","確定刪除科目主檔嗎?",false)){
        return;
      }
      sql=new StringBuffer();
      sql.append("delete from gv_acc_data  where ");
      sql.append("YYYYMM='");sql.append(txtYYYYMM.getText().trim());sql.append("' ");
      sql.append("and COMP='");sql.append(txtCmp.getText().trim().toUpperCase());sql.append("' ");
      sql.append("and to_number(substr(ACC_CODE,1,4)) >=");sql.append(txtAccCodeFrom.getText().trim());sql.append(" ");
      sql.append("and to_number(substr(ACC_CODE,1,4)) <=");sql.append(txtAccCodeTo.getText().trim());sql.append(" ");
      sql.append("and substr(acc_code, 6,2)='");sql.append(txtDepFrom.getText().trim().toUpperCase());sql.append("' ");

      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");

      newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
      java.util.HashMap hmParam=new java.util.HashMap();
      hmParam.put("TPEMISCFUNC_ACTION_CODE","AXN_CODE_DELETE_GV_ACC_DATA_FROM");
      hmParam.put("SQL2DEL",sql.toString());
      hmParam.put("USER_ID",util.PublicVariable.USER_RECORD.get(0));
      ejb2update.tpeMisFunc(hmParam);
      exgui.verification.VerifyLib.showPlanMsg("Process Finished","Process Finished");

    }catch(Exception exp){
      exp.printStackTrace();
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While query Acc Data From Server",
                                             "Error While query Acc Data From Server");
    }

  //target is gv_acc_data,

  }
}
