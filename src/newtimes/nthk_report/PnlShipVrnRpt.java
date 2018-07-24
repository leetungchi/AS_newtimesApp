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

public class PnlShipVrnRpt
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtETD = new JTextField();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JComboBox cbxSortBy = new JComboBox();
  JButton btnQry = new JButton();
  JTextField txtTwdUsd=new JTextField();
  JTextField txtRmbUsd=new JTextField();
  JTextField txtHkdUsd=new JTextField();
  exgui.ultratable.Wraper4tblCbx[] itemOfCenter=new exgui.ultratable.Wraper4tblCbx[3];
  exgui.ultratable.Wraper4tblCbx[] itemOfSortBy=new exgui.ultratable.Wraper4tblCbx[4];

  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTwdChg,dbHkdChg,dbRmbChg;

  public PnlShipVrnRpt() {
    try {

        itemOfCenter[0]=new exgui.ultratable.Wraper4tblCbx();
        itemOfCenter[1]=new exgui.ultratable.Wraper4tblCbx();
        itemOfCenter[2]=new exgui.ultratable.Wraper4tblCbx();

        /*itemOfCenter[0].setValue("NTFE");itemOfCenter[0].setString("NTFE");
        itemOfCenter[1].setValue("NTD");itemOfCenter[1].setString("NTD");
        itemOfCenter[2].setValue("NTHK");itemOfCenter[2].setString("NTHK");*/

        itemOfCenter[1].setValue("NTFE");itemOfCenter[1].setString("NTFE");
        itemOfCenter[2].setValue("NTD");itemOfCenter[2].setString("NTD");
        itemOfCenter[0].setValue("NTHK");itemOfCenter[0].setString("NTHK");

        itemOfSortBy[0]=new exgui.ultratable.Wraper4tblCbx();
        itemOfSortBy[1]=new exgui.ultratable.Wraper4tblCbx();
        itemOfSortBy[2]=new exgui.ultratable.Wraper4tblCbx();
        itemOfSortBy[3]=new exgui.ultratable.Wraper4tblCbx();

        itemOfSortBy[0].setValue("A");itemOfSortBy[0].setString("COUNTRY");
        itemOfSortBy[1].setValue("B");itemOfSortBy[1].setString("CUSTOMER");
        itemOfSortBy[2].setValue("C");itemOfSortBy[2].setString("FACTORY");
        itemOfSortBy[3].setValue("D");itemOfSortBy[3].setString("DEPARTMENT");

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

      /*
      Object chkDcm32 = CellFormat.getDoubleFormatAllowNull(5, 4);
      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.
          USER_RECORD,
          "select * from system_default_value where CENTER='" +
                                           util.PublicVariable.OPERATTING_CENTER +
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
     int days=cld.getActualMaximum(cld.DAY_OF_MONTH);
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_YMD1",dateStr+"01");
     hm.put("P_YMD2",dateStr+days);
     hm.put("P_YMD3",year+"1231");
     hm.put("R_YYYYMM",dateStr);
     String dateStrOfLastYear=String.valueOf(year-1)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("L_YYYYMM",dateStrOfLastYear);
   }else{
     String txtString=txtETD.getText().trim();
     int year=Integer.parseInt(txtString.substring(0,4));
     int month=Integer.parseInt(txtString.substring(4,6));
     java.util.Date  destDate=util.MiscFunc.toDate235959(year,month,1);
     java.util.Calendar cld=java.util.Calendar.getInstance();
     cld.setTime(destDate);
     int days=cld.getActualMaximum(cld.DAY_OF_MONTH);
     hm.put("R_YYYYMM",txtString);
     hm.put("P_YMD1",txtString+"01");
     hm.put("P_YMD2",txtString+days);
     hm.put("P_YMD3",year+"1231");
     String dateStr=String.valueOf(year-1)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("L_YYYYMM",dateStr);
   }




   hm.put("P_CENTER",((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());
   hm.put("GP_TYPE",((exgui.ultratable.Wraper4tblCbx)cbxSortBy.getSelectedItem()).getValue());


   newtimes.nthk_report.TgrNthkMisReports.setExchangeRate(hm,
                  (String)((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());

   return hm;
 }
 protected void jbInit() throws Exception {
    cbxCenter.setModel(new javax.swing.DefaultComboBoxModel(itemOfCenter));
    cbxSortBy.setModel(new javax.swing.DefaultComboBoxModel(itemOfSortBy));

    blueBkgWhiteCharLabel1.setText("SHIPMENT VARIANCE REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 20, 799, 30));
    this.setLayout(null);
    jLabel1.setText("REPORT(YYYYMM) :");
    jLabel1.setBounds(new Rectangle(12, 66, 119, 23));
    txtETD.setToolTipText("YYYYMM");
    txtETD.setText("");
    txtETD.setBounds(new Rectangle(144, 65, 118, 24));
    jLabel2.setText("CENTER:");
    jLabel2.setBounds(new Rectangle(301, 65, 60, 24));
    cbxCenter.setBounds(new Rectangle(365, 64, 131, 25));
    jLabel3.setBounds(new Rectangle(527, 68, 68, 24));
    jLabel3.setText("SORT BY:");
    cbxSortBy.setBounds(new Rectangle(599, 67, 131, 25));
    btnQry.setBounds(new Rectangle(641, 115, 83, 25));
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
    this.add(jLabel3, null);
    this.add(cbxSortBy, null);
    this.add(btnQry, null);
    exgui.ultratable.Wraper4tblCbx obj2select=new exgui.ultratable.Wraper4tblCbx();
    obj2select.setString(util.PublicVariable.OPERATTING_CENTER);
    obj2select.setValue(util.PublicVariable.OPERATTING_CENTER);
    cbxCenter.setSelectedItem(obj2select);
    genDataBindObj();

  }
 protected void setReportName(){
   if(cbxCenter.getSelectedItem().toString().equals("NTFE")){
     reportName = "NTFE_SHIP_VAR.rpt";
   }else{
     reportName = "HK_SHIP_VAR.rpt";
   }
 }
 protected void btnQry_actionPerformed(ActionEvent e) {
    //check if format error
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
    if(((exgui.ultratable.Wraper4tblCbx)cbxSortBy.getSelectedItem()).getValue().equals("C")){
      if(cbxCenter.getSelectedItem().toString().equals("NTFE")){
        String orgURL = newtimes.production.report.ReportCmdSet.myReportEngin.
            reportServerURL;
        newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =
            "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
        reportName = "NTFE_SHIP_VAR_FTY.rpt";
        super.JButtonQueryButtonAction(null);
        newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =orgURL;
      }else{
        setReportName();
        super.JButtonQueryButtonAction(null);
      }
    }else{
      setReportName();
      super.JButtonQueryButtonAction(null);
    }

  }
}
