package newtimes.nthk_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class PnlTopMngReport
    extends AbsQryPanel  implements Int_PNL_JINIT{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtETD = new JTextField();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JButton btnQry = new JButton();
  JTextField txtTwdUsd=new JTextField();
  JTextField txtRmbUsd=new JTextField();
  JTextField txtHkdUsd=new JTextField();
  exgui.ultratable.Wraper4tblCbx[] itemOfCenter=new exgui.ultratable.Wraper4tblCbx[3];
  //exgui.ultratable.Wraper4tblCbx[] itemOfSortBy=new exgui.ultratable.Wraper4tblCbx[4];

  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTwdChg,dbHkdChg,dbRmbChg;
  String yyyyMM=null;
  public PnlTopMngReport() {
    try {

        itemOfCenter[0]=new exgui.ultratable.Wraper4tblCbx();
        itemOfCenter[1]=new exgui.ultratable.Wraper4tblCbx();
        itemOfCenter[2]=new exgui.ultratable.Wraper4tblCbx();
        itemOfCenter[0].setValue("NTHK");itemOfCenter[0].setString("NTHK");
        itemOfCenter[1].setValue("NTFE");itemOfCenter[1].setString("NTFE");
        itemOfCenter[2].setValue("NTD");itemOfCenter[2].setString("NTD");

      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected  void genDataBindObj(){
    try{
      dataBindComps.clear();
      Object chkYearMon=CellFormat.getIntVerifierAllowNull(6);
      DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtETD, "",
                                             null, 6,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);

      txtETD.setToolTipText("YYYYMM");

      if(util.PublicVariable.OPERATTING_CENTER.endsWith("NTFE")){
        reportName = "NTFE_OUTST_CHINA.rpt";
      }else{
        reportName = "NTHK_OUTST_CHINA.rpt";
      }
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }

 protected HashMap composeParameters(){
   HashMap hm=super.composeParameters();
   /*
   if(txtETD.getText().trim().length()==0){
     java.util.Calendar cld=java.util.Calendar.getInstance();
     int year=cld.get(cld.YEAR);
     int month=cld.get(cld.MONTH)+1;
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("L_YYYYMM",dateStr);
   }else{
     hm.put("L_YYYYMM",txtETD.getText().trim());
   }*/

   if(txtETD.getText().trim().length()==0){
     java.util.Calendar cld=java.util.Calendar.getInstance();
     int year=cld.get(cld.YEAR);
     int month=cld.get(cld.MONTH)+1;
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_YM",dateStr);
     yyyyMM=dateStr;
   }else{
     String txtString=txtETD.getText().trim();
     int year=Integer.parseInt(txtString.substring(0,4));
     int month=Integer.parseInt(txtString.substring(4,6));
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_YM",dateStr);
     yyyyMM=dateStr;
   }
   hm.put("P_CENTER",((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());
   newtimes.nthk_report.TgrNthkMisReports.setExchangeRate(hm,
                  (String)((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());
   //hm.put("GP_TYPE",((exgui.ultratable.Wraper4tblCbx)cbxSortBy.getSelectedItem()).getValue());
   return hm;
 }
 public void jbInit() throws Exception {
    cbxCenter.setModel(new javax.swing.DefaultComboBoxModel(itemOfCenter));

    blueBkgWhiteCharLabel1.setText("TOP MANAGEMENT REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 20, 799, 30));
    this.setLayout(null);
    jLabel1.setText("REPORT (YYYYMM) :");
    jLabel1.setBounds(new Rectangle(12, 66, 125, 23));
    txtETD.setToolTipText("YYYYMM");
    txtETD.setText("");
    txtETD.setBounds(new Rectangle(154, 65, 108, 24));
    jLabel2.setText("CENTER:");
    jLabel2.setBounds(new Rectangle(301, 65, 60, 24));
    cbxCenter.setBounds(new Rectangle(365, 64, 131, 25));
    btnQry.setBounds(new Rectangle(674, 70, 83, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(txtETD, null);
    this.add(jLabel2, null);
    this.add(cbxCenter, null);
    this.add(btnQry, null);

    exgui.ultratable.Wraper4tblCbx obj2select=new exgui.ultratable.Wraper4tblCbx();
    obj2select.setString(util.PublicVariable.OPERATTING_CENTER);
    obj2select.setValue(util.PublicVariable.OPERATTING_CENTER);
    cbxCenter.setSelectedItem(obj2select);

    genDataBindObj();
  }
  void btnQry_actionPerformed(ActionEvent e) {
    //check if format error
    if(txtETD.getText().trim().length()>0){
      if(txtETD.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("REPORT DATE FORMAT IS :YYYYMM",
                                              "REPORT DATE FORMAT IS :YYYYMM");
       return;
      }
    }
    if(cbxCenter.getSelectedItem().toString().equals("NTHK")){
      reportName="RHK_NTSHIP.rpt";
    }else if(cbxCenter.getSelectedItem().toString().equals("NTFE")){
      reportName="NTFE_NTSHIP.rpt";
    }else{
      reportName="RHK_NJSHIP.rpt";
    }
    super.JButtonQueryButtonAction(null);
  }
}
