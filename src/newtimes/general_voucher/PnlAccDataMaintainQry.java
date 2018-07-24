package newtimes.general_voucher;

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

public class PnlAccDataMaintainQry extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtYYYYMMFrom = new JTextField();
  JTextField txtYYYYMMTo = new JTextField();
  //JTextField txtAccCode = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField txtComp = new JTextField();
  static String QUERY_STRING;
  DbAccCodeEditor dbCbxTblAccItem = new DbAccCodeEditor();
  JButton btnInqry = new JButton();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  public PnlAccDataMaintainQry() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("VOUCHER ACCOUNT MAINTAIN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 22, 802, 31));
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(318, 495, 134, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("EXTRACT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnAddNew.setText("NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnAddNew.setBounds(new Rectangle(465, 495, 107, 28));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(586, 495, 134, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setBackground(new Color(143, 143, 188));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.white);
    jLabel1.setOpaque(true);
    jLabel1.setText("  DATE FROM:");
    jLabel1.setBounds(new Rectangle(229, 133, 83, 28));
    jLabel2.setBounds(new Rectangle(415, 133, 26, 28));
    jLabel2.setText("TO");
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setBackground(Color.white);
    txtYYYYMMFrom.setText("");
    txtYYYYMMFrom.setBounds(new Rectangle(312, 133, 49, 28));
    txtYYYYMMTo.setBounds(new Rectangle(440, 133, 52, 28));
    dbCbxTblAccItem.setBounds(new Rectangle(311, 179, 176, 28));
    //txtAccCode.setText("");
    jLabel7.setBounds(new Rectangle(229, 179, 83, 28));
    jLabel7.setText("  ACC CODE:");
    jLabel7.setOpaque(true);
    jLabel7.setForeground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel7.setBackground(Color.white);
    jLabel8.setBounds(new Rectangle(229, 88, 83, 28));
    jLabel8.setText("COMPANY:");
    jLabel8.setOpaque(true);
    jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel8.setForeground(new Color(143, 143, 188));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel8.setBackground(Color.white);
    txtComp.setBounds(new Rectangle(311, 87, 56, 28));
    btnInqry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnInqry_actionPerformed(e);
      }
    });
    btnInqry.setText("ENQUIRE");
    btnInqry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnInqry.setBounds(new Rectangle(91, 495, 134, 28));
    jLabel3.setText("YYYYMM");
    jLabel3.setBounds(new Rectangle(360, 133, 57, 30));
    jLabel4.setBounds(new Rectangle(493, 133, 61, 30));
    jLabel4.setText("YYYYMM");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(txtYYYYMMFrom, null);
    this.add(dbCbxTblAccItem, null);
    this.add(jLabel7, null);
    this.add(jLabel8, null);
    this.add(txtComp, null);
    this.add(btnExit, null);
    this.add(btnInqry, null);
    this.add(btnQry, null);
    this.add(btnAddNew, null);
    this.add(jLabel4, null);
    this.add(jLabel3, null);
    this.add(jLabel2, null);
    this.add(txtYYYYMMTo, null);
    Object vftxtComp=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(1);
    new exgui.DataBindTextWithChecker(txtComp,
                                      "",
                                       null,1,
                                      (exgui.Object2String)vftxtComp,
                                      (exgui.ultratable.CellTxtEditorFormat)vftxtComp);


      Object vftxtYY=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
        new exgui.DataBindTextWithChecker(txtYYYYMMFrom,
                                          "",
                                           null,6,
                                          (exgui.Object2String)vftxtYY,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtYY);

        new exgui.DataBindTextWithChecker(txtYYYYMMTo,
                                          "",
                                           null,6,
                                          (exgui.Object2String)vftxtYY,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtYY);

         txtComp.setToolTipText(Constants.getCompayToolTips());
      txtComp.setText("S");
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("CODE","ITEM_CODE");
      iso.put("D/C","D_C");
      iso.put("     NAME    ","ITEM_NAME");

      dbCbxTblAccItem.init("ACC_CODE",
                           Constants.VCT_ACC_ITEM, iso, 250, 150,
                           "ITEM_CODE", "ITEM_CODE",
                           null);
      if(util.PublicVariable.USER_RECORD.getInt(2)!=newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
        btnAddNew.setVisible(false);
        btnQry.setVisible(false);
      }

  }
  boolean isYYYYMMOK (){
     if(txtComp.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("Please Input Compy Code","Please Input Company Code");
       return false;
     }
     if(!Constants.HT_ACC_COMPANY.containsKey("GV_COMP_"+txtComp.getText().trim().toUpperCase())){
       exgui.verification.VerifyLib.showAlert("Compay Code Not Exists ",
                                              "Compay Code Not Exists");
       return false;

     }
     if(((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).getText().trim().length()<4){
       exgui.verification.VerifyLib.showAlert("Please Input ACC Code,at Least 4 Characters",
                                              "Please Input ACC Code");
       return false;
     }

     String accItemCode=((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).getText().trim().substring(0,4);
     database.datatype.Record recAccItem=(database.datatype.Record)Constants.HT_ACC_ITEM.get(accItemCode);
     if(null==recAccItem){
       exgui.verification.VerifyLib.showAlert("  無此會計項目 : "+accItemCode,"無此會計項目");
       return false;
     }



     if(txtYYYYMMFrom.getText().trim().length()==0||
        txtYYYYMMTo.getText().trim().length()==0){
       //exgui.verification.VerifyLib.showAlert("年月期間皆為必填","年月期間皆為必填");
       //return false;
     }
     if(txtYYYYMMFrom.getText().trim().length()>0 && txtYYYYMMFrom.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("YYYYMM 為6個數字\n例\"200903\"","YYYYMM 為6個數字");
       txtYYYYMMFrom.selectAll();
       txtYYYYMMFrom.grabFocus();
       return false;
     }
     if(txtYYYYMMTo.getText().trim().length()>0 && txtYYYYMMTo.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("YYYYMM 為5個數字\n例\"200906\"","YYYYMM 為6個數字");
       txtYYYYMMTo.selectAll();
       txtYYYYMMTo.grabFocus();
       return false;
     }

     /*
     if(txtYYYYMMFrom.getText().trim().length()>0){
       if(Integer.parseInt(txtYYYYMMFrom.getText().trim())<50){
          exgui.verification.VerifyLib.showAlert("YEAR TOO FEW",
                                                 "YEAR TOO FEW");
          txtYYYYMMFrom.grabFocus();
          return false;
       }
     }

     if(txtYYYYMMTo.getText().trim().length()>0){
       if(Integer.parseInt(txtYYYYMMFrom.getText().trim())<50){
          exgui.verification.VerifyLib.showAlert("YEAR TOO FEW",
                                                 "YEAR TOO FEW");
          txtYYYYMMTo.grabFocus();
          return false;
       }
     }*/
     if(txtYYYYMMFrom.getText().length()>0){
       String monthDigit = txtYYYYMMFrom.getText().trim().substring(4, 6);
       if (Integer.parseInt(monthDigit) < 0 || (Integer.parseInt(monthDigit) > 12 && Integer.parseInt(monthDigit) !=99)) {
         exgui.verification.VerifyLib.showAlert("月份應介於1~12之間", "YYYYMM 格式有誤");
         txtYYYYMMFrom.selectAll();
         txtYYYYMMFrom.grabFocus();
         return false;
       }
     }
     if(txtYYYYMMTo.getText().trim().length()>0){
       String monthDigit = txtYYYYMMTo.getText().trim().substring(4, 6);
       if (Integer.parseInt(monthDigit) < 0 || (Integer.parseInt(monthDigit) > 12 && Integer.parseInt(monthDigit)!=99)) {
         exgui.verification.VerifyLib.showAlert("月份應介於1~12之間", "YYYYMM 格式有誤");
         txtYYYYMMTo.selectAll();
         txtYYYYMMTo.grabFocus();
         return false;
       }
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
 String composeSQL( ){
     StringBuffer sb=new StringBuffer();
     sb.append("select  ");
     sb.append("REC_SEQ, ");
     sb.append("CEN_CODE, ");
     sb.append("COMP, ");
     sb.append("YYYYMM, ");
     sb.append("ACC_CODE, ");
     sb.append("D_C, ");
     sb.append("REC_DESC, ");
     sb.append("INIT_AMT, ");
     sb.append("D_AMT, ");
     sb.append("C_AMT, ");
     sb.append("BLNC_AMT");
     sb.append(",CNTL_CODE ");
     sb.append(",RECORD_CREATE_USER");
     sb.append(",RECORD_CREATE_DATE ");
     sb.append(",RECORD_DELETE_FLAG ");
     sb.append(",RECORD_DELETE_DATE ");
     sb.append(",RECORD_DELETE_USER ");
     sb.append(",RECORD_MODIFY_DATE ");
     sb.append(",RECORD_MODIFY_USER ");
     sb.append(",");
     sb.append(Constants.getBalanceSQL("b", "a", "GET_BLNC_AMT"));

     sb.append(" from GV_ACC_DATA a where a.record_delete_flag='1' and a.cen_code='");
     sb.append(util.PublicVariable.OPERATTING_CENTER);
     sb.append("' and ");
     sb.append(" substr(a.acc_code,5,1)='");
     sb.append(util.MiscFunc.Replace(txtComp.getText().trim(),"'","''"));
     sb.append("'");
     if(txtYYYYMMFrom.getText().trim().length()>0){
       sb.append(" and ");
       sb.append("  a.yyyymm >=");
       sb.append(String.valueOf(Integer.parseInt(txtYYYYMMFrom.getText().trim())));
     }
     if(txtYYYYMMTo.getText().trim().length()>0){
       sb.append(" and   a.yyyymm <=");
       sb.append(String.valueOf(Integer.parseInt(txtYYYYMMTo.getText().trim())));
     }
     //sb.append(")");
     sb.append(" and ");
     sb.append(" a.acc_code like '");
     sb.append(util.MiscFunc.Replace(((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).getText().trim(),"'","''"));
     sb.append((((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).getText().trim().length()>4)?"' ":"%'");
     sb.append(" order by a.yyyymm,a.acc_code");
     return sb.toString();
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(!isYYYYMMOK())return;
    try{
       QUERY_STRING=composeSQL();
       System.out.println(QUERY_STRING);
       TgrAccDataMaintainList  tgr=new TgrAccDataMaintainList();
       processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      database.datatype.Record rec = (new DbAccData()).getBlankRecord();
      DlgAccDataEdit dlg = new DlgAccDataEdit(util.PublicVariable.APP_FRAME,
                                              "ADD RECORD", true,
                                              rec, null);
      dlg.setSize(450, 480);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("ERROR WHILE ADDING NEW RECORD\nPLEASE CONTACT SYSTEM MANAGER",
                                             "ERROR IN ADDING NEW RECORD");
    }

  }
  void btnInqry_actionPerformed(ActionEvent e) {
    if(!isYYYYMMOK())return;
    try{
       QUERY_STRING=composeSQL();
       System.out.println(QUERY_STRING);
       TgrAccInquery  tgr=new TgrAccInquery();
       processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
