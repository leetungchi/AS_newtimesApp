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
public class Pnl_NTHK_SHIPPINGByMonth
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

  public Pnl_NTHK_SHIPPINGByMonth() {
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


      java.util.Calendar cld=java.util.Calendar.getInstance();
      int year=cld.get(cld.YEAR);
      int month=cld.get(cld.MONTH)+1;

      DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtETD, "",
                                             String.valueOf(year)+"01", 6,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);

      txtETD.setToolTipText("YYYYMM");


      DataBindTextWithChecker etdDateTo = new DataBindTextWithChecker(txtETDTo, "",
                                             String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month), 6,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);

      txtETDTo.setToolTipText("YYYYMM");


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
      dataBindComps.add(dbHkdChg);
      reportName="HK_MONTH_SUM.rpt";
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
 protected HashMap composeParameters(){
   HashMap hm=super.composeParameters();

   if(txtETD.getText().trim().length()==0){
     java.util.Calendar cld=java.util.Calendar.getInstance();
     int year=cld.get(cld.YEAR);
     //int month=cld.get(cld.MONTH)+1;
     String dateStr=String.valueOf(year)+"01";
     hm.put("P_CU_YM",dateStr);
     hm.put("P_LS_YM",String.valueOf(year-1)+"01");
   }else{
     String txtString=txtETD.getText().trim();
     int year=Integer.parseInt(txtString.substring(0,4));
     int month=Integer.parseInt(txtString.substring(4,6));
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_CU_YM",dateStr);
     hm.put("P_LS_YM",String.valueOf(year-1)+((month<10)?"0":"")+String.valueOf(month));
   }

   if(txtETDTo.getText().trim().length()==0){
     java.util.Calendar cld=java.util.Calendar.getInstance();
     int year=cld.get(cld.YEAR);
     int month=cld.get(cld.MONTH)+1;
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_CU_EN_YM",dateStr);
     hm.put("P_LS_EN_YM",String.valueOf(year-1)+((month<10)?"0":"")+String.valueOf(month));
   }else{
     String txtString=txtETDTo.getText().trim();
     int year=Integer.parseInt(txtString.substring(0,4));
     int month=Integer.parseInt(txtString.substring(4,6));
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_CU_EN_YM",dateStr);
     hm.put("P_LS_EN_YM",String.valueOf(year-1)+((month<10)?"0":"")+String.valueOf(month));
   }



   hm.put("P_CENTER",((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());
   //hm.put("GP_TYPE",((exgui.ultratable.Wraper4tblCbx)cbxSortBy.getSelectedItem()).getValue());
   return hm;
 }
 public void jbInit() throws Exception {
    cbxCenter.setModel(new javax.swing.DefaultComboBoxModel(itemOfCenter));

    blueBkgWhiteCharLabel1.setText("NTHK SHIPPING AMOUNT ");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 20, 799, 30));
    this.setLayout(null);
    jLabel1.setText("FROM ETD (YYYYMM) :");
    jLabel1.setBounds(new Rectangle(35, 64, 156, 23));
    txtETD.setToolTipText("YYYYMM");
    txtETD.setText("");
    txtETD.setBounds(new Rectangle(180, 63, 149, 24));
    jLabel2.setText("CENTER:");
    jLabel2.setBounds(new Rectangle(433, 64, 60, 24));
    cbxCenter.setBounds(new Rectangle(497, 63, 131, 25));
    btnQry.setBounds(new Rectangle(674, 70, 83, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    txtETDTo.setToolTipText("YYYYMM");
    txtETDTo.setBounds(new Rectangle(180, 97, 149, 24));
    jLabel3.setBounds(new Rectangle(35, 98, 156, 23));
    jLabel3.setText("TO   ETD (YYYYMM) :");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    this.add(jLabel2, null);
    this.add(cbxCenter, null);
    this.add(jLabel1, null);
    this.add(txtETD, null);
    this.add(txtETDTo, null);
    this.add(jLabel3, null);
    genDataBindObj();

  }
  void btnQry_actionPerformed(ActionEvent e) {
    //check if format error
    if(txtETD.getText().trim().length()>0){
      if(txtETD.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("ETD DATE FORMAT IS :YYYYMM",
                                              "ETD DATE FORMAT IS :YYYYMM");
       return;
      }
    }
    if(txtETDTo.getText().trim().length()>0){
      if(txtETDTo.getText().trim().length()<6){
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
  JTextField txtETDTo = new JTextField();
  JLabel jLabel3 = new JLabel();
}
