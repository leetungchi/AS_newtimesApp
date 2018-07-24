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
public class Pnl_NTHK_OutStandingByArea
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

  public Pnl_NTHK_OutStandingByArea() {
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
      String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
      DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtETD, "",
                                             dateStr, 6,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);

      txtETD.setToolTipText("YYYYMM");


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
      //reportName="NTHK_OUTST_CHINA.rpt";
      reportName="NTHK_OUTST_AREA.rpt";
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
 protected HashMap composeParameters(){
   HashMap hm=super.composeParameters();
   int year,month;
   if(txtETD.getText().trim().length()==0){
     java.util.Calendar cld=java.util.Calendar.getInstance();
     year=cld.get(cld.YEAR);
     month=cld.get(cld.MONTH)+1;
   }else{
     String txtString=txtETD.getText().trim();
     year=Integer.parseInt(txtString.substring(0,4));
     month=Integer.parseInt(txtString.substring(4,6));
   }
   String  L_To_dateString=String.valueOf(year-1)+((month<10)?"0":"")+String.valueOf(month);
   String  R_To_dateString=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);

   String  L_From_dateString=String.valueOf(year-1)+"01";
   String  R_From_dateString=String.valueOf(year)+"01";
   hm.put("L_FM_YYYYMM",L_From_dateString);
   hm.put("R_FM_YYYYMM",R_From_dateString);
   hm.put("L_TO_YYYYMM",L_To_dateString);
   hm.put("R_TO_YYYYMM",R_To_dateString);
   hm.put("O_YEAR",String.valueOf(year));

   hm.put("P_CENTER",((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());
   //hm.put("GP_TYPE",((exgui.ultratable.Wraper4tblCbx)cbxSortBy.getSelectedItem()).getValue());
   return hm;
 }
 public void jbInit() throws Exception {
    cbxCenter.setModel(new javax.swing.DefaultComboBoxModel(itemOfCenter));

    blueBkgWhiteCharLabel1.setText("NTHK OUTSTANDING BY AREA ");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 20, 799, 30));
    this.setLayout(null);
    jLabel1.setText("DEL. (YYYYMM) :");
    jLabel1.setBounds(new Rectangle(12, 66, 112, 23));
    txtETD.setToolTipText("YYYY");
    txtETD.setText("");
    txtETD.setBounds(new Rectangle(135, 65, 127, 24));
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
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
       "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";

  }
}
