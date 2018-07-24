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
public class Pnl_NTHK_OutStanding
    extends AbsQryPanel implements Int_PNL_JINIT{
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

  public Pnl_NTHK_OutStanding() {
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

      etdDate = new DataBindTextWithChecker(txtEtdTo, "",
             null, 6,
             (Object2String)chkYearMon,
             (CellTxtEditorFormat)chkYearMon);

      txtETD.setToolTipText("YYYYMM");
      txtEtdTo.setToolTipText("YYYYMM");
      txtETD.setText("");
      txtEtdTo.setText("");

      /*
      Object chkDcm32 = CellFormat.getDoubleFormatAllowNull(5, 4);
      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.
          USER_RECORD,
          "select * from system_default_value where CENTER='" +
                                           (String)util.PublicVariable.
                                           USER_RECORD.get("USR_CEN_CODE") +
                                           "' and record_delete_flag=1", 1, 1);
      Record recSystem = (Record)vct.get(0);
      dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD",
                                             recSystem.get("TWD_XCHG_RATE"), 10,
                                             (Object2String)chkDcm32,
                                             (CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbTwdChg);
      dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD",
                                             recSystem.get("RMB_XCHG_RATE"), 10,
                                             (Object2String)chkDcm32,
                                             (CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbRmbChg);
      dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD",
                                             recSystem.get("HKD_XCHG_RATE"), 10,
                                             (Object2String)chkDcm32,
                                             (CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbHkdChg);*/
      reportName="NTHK_OUTST.rpt";
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
   /*
   if(txtETD.getText().trim().length()==0){
     java.util.Calendar cld=java.util.Calendar.getInstance();
     int year=cld.get(cld.YEAR);
     int month=cld.get(cld.MONTH)+1;
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_EN_YM",dateStr);
     cld.add(cld.MONTH,-5);
     year=cld.get(cld.YEAR);
     month=cld.get(cld.MONTH)+1;
     String dateStrOfLastYear=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_BE_YM",dateStrOfLastYear);
   }else{
     String txtString=txtETD.getText().trim();

     int year=Integer.parseInt(txtString.substring(0,4));
     int month=Integer.parseInt(txtString.substring(4,6));
     java.util.Calendar cld=java.util.Calendar.getInstance();
     cld.set(cld.YEAR,year);
     cld.set(cld.MONTH,month-1);
     cld.set(cld.DATE,0);
     hm.put("R_EN_YM",txtString);
     cld.add(cld.MONTH,-5);
     year=cld.get(cld.YEAR);
     month=cld.get(cld.MONTH)+1;
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("L_BE_YM",dateStr);
   }*/
    hm.put("P_TO_YM",txtEtdTo.getText().trim());
    hm.put("P_FM_YM",txtETD.getText().trim());


   hm.put("P_CENTER",((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());
   //hm.put("GP_TYPE",((exgui.ultratable.Wraper4tblCbx)cbxSortBy.getSelectedItem()).getValue());
   return hm;
 }
 public void jbInit() throws Exception {
    cbxCenter.setModel(new javax.swing.DefaultComboBoxModel(itemOfCenter));

    blueBkgWhiteCharLabel1.setText("NTHK OUTSTANDING ");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 20, 799, 30));
    this.setLayout(null);
    jLabel1.setToolTipText("");
    jLabel1.setText("DEL. (YYYYMM) FROM :");
    jLabel1.setBounds(new Rectangle(12, 66, 136, 23));
    txtETD.setToolTipText("YYYYMM");
    txtETD.setText("");
    txtETD.setBounds(new Rectangle(146, 66, 75, 24));
    jLabel2.setText("CENTER:");
    jLabel2.setBounds(new Rectangle(467, 66, 60, 24));
    cbxCenter.setBounds(new Rectangle(531, 66, 131, 25));
    btnQry.setBounds(new Rectangle(674, 66, 83, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    jLabel3.setText("TO");
    jLabel3.setBounds(new Rectangle(229, 68, 32, 22));
    txtEtdTo.setText("");
    txtEtdTo.setBounds(new Rectangle(261, 66, 75, 24));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(btnQry, null);
    this.add(jLabel2, null);
    this.add(cbxCenter, null);
    this.add(txtEtdTo, null);
    this.add(txtETD, null);
    this.add(jLabel3, null);
    genDataBindObj();

  }
  void btnQry_actionPerformed(ActionEvent e) {
    //check if format error
    if(txtETD.getText().trim().length()==0||txtEtdTo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input ETD DATE","Please Input ETD DATE");
      return;
    }
    if(txtETD.getText().trim().length()>0){
      if(txtETD.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("ETD DATE FORMAT IS :YYYYMM",
                                              "ETD DATE FORMAT IS :YYYYMM");
       return;
      }
      String dateStr=txtETD.getText().trim();
      int month=Integer.parseInt(dateStr.substring(dateStr.length()-2,dateStr.length()));
      if(month>12||month<1){
        exgui.verification.VerifyLib.showAlert("ETD DATE FORMAT IS :YYYYMM",
                                               "ETD DATE FORMAT IS :YYYYMM");
        return;
      }
    }
    if(txtEtdTo.getText().trim().length()>0){
      if(txtEtdTo.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("ETD DATE FORMAT IS :YYYYMM",
                                              "ETD DATE FORMAT IS :YYYYMM");
       return;
      }
      String dateStr=txtEtdTo.getText().trim();
      int month=Integer.parseInt(dateStr.substring(dateStr.length()-2,dateStr.length()));
      if(month>12||month<1){
        exgui.verification.VerifyLib.showAlert("ETD DATE FORMAT IS :YYYYMM",
                                               "ETD DATE FORMAT IS :YYYYMM");
        return;
      }
    }

    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
       "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";

  }
  JLabel jLabel3 = new JLabel();
  JTextField txtEtdTo = new JTextField();
}
