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

public class PnlTopMngOutStandingRpt
    //extends JPanel {
    extends AbsQryPanel  implements Int_PNL_JINIT{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtYYYYMMDD = new JTextField();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JButton btnQry = new JButton();
  exgui.ultratable.Wraper4tblCbx[] itemOfCenter=new exgui.ultratable.Wraper4tblCbx[3];
  DataBindTextWithChecker yyyymmddDate;
  public PnlTopMngOutStandingRpt() {
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

 public void jbInit() throws Exception {
    cbxCenter.setModel(new javax.swing.DefaultComboBoxModel(itemOfCenter));
    blueBkgWhiteCharLabel1.setText("Top Management Report By OutStanding");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 13, 801, 30));
    this.setLayout(null);
    jLabel1.setText("YYYYMM");
    jLabel1.setBounds(new Rectangle(3, 59, 75, 26));
    txtYYYYMMDD.setText("");
    txtYYYYMMDD.setBounds(new Rectangle(83, 59, 133, 26));
    jLabel2.setText("CENTER");
    jLabel2.setBounds(new Rectangle(324, 59, 74, 26));
    cbxCenter.setBounds(new Rectangle(401, 59, 150, 26));
    btnQry.setBounds(new Rectangle(677, 62, 105, 22));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(txtYYYYMMDD, null);
    this.add(jLabel2, null);
    this.add(cbxCenter, null);
    this.add(btnQry, null);

    exgui.ultratable.Wraper4tblCbx obj2select=new exgui.ultratable.Wraper4tblCbx();
    obj2select.setString(util.PublicVariable.OPERATTING_CENTER);
    obj2select.setValue(util.PublicVariable.OPERATTING_CENTER);
    cbxCenter.setSelectedItem(obj2select);
    genDataBindObj();
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=new java.util.HashMap();
    /*
    Object objDate=yyyymmddDate.getSelectedValue();
    int yyyy,mm,dd;
    if(objDate==null){
       java.sql.Date now=new java.sql.Date(System.currentTimeMillis());
       yyyy=util.MiscFunc.getYear(now);
       mm=util.MiscFunc.getMonth(now);
       dd=util.MiscFunc.getDay(now);
       hm.put("P_YMD1",convertDate2QueryPara((java.sql.Date)now));
       java.util.Date  endOfYear=util.MiscFunc.toDate000000(yyyy,12,31);
       hm.put("P_YMD3",convertDate2QueryPara(new java.sql.Date(endOfYear.getTime())));
    }else{
      java.sql.Date ddd=new java.sql.Date(((java.util.Date)objDate).getTime());
      yyyy=util.MiscFunc.getYear(ddd);
      mm=util.MiscFunc.getMonth(ddd);
      dd=util.MiscFunc.getDay(ddd);
      hm.put("P_YMD1",convertDate2QueryPara(ddd));
      java.util.Date  endOfYear=util.MiscFunc.toDate000000(yyyy,12,31);
      hm.put("P_YMD3",convertDate2QueryPara(new java.sql.Date(endOfYear.getTime())));
    }
    */
   if(txtYYYYMMDD.getText().trim().length()==0){
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
     String txtString=txtYYYYMMDD.getText().trim();
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


    hm.put("P_CENTER",
           ((exgui.ultratable.Wraper4tblCbx)cbxCenter.getSelectedItem()).getValue());
    return hm;

  }
  public void genDataBindObj(){
    try{
      dataBindComps.clear();
      /*
      Object chkYearMon=CellFormat.getDateStringFormaterAllowNull();
      yyyymmddDate = new DataBindTextWithChecker(txtYYYYMMDD, "",
                                             new java.sql.Date(System.currentTimeMillis()), 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);

      txtYYYYMMDD.setToolTipText("YYYYMM");*/
      Object chkYearMon=CellFormat.getIntVerifierAllowNull(6);
      DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtYYYYMMDD, "",
                                             null, 6,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);

      txtYYYYMMDD.setToolTipText("YYYYMM");


    } catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(txtYYYYMMDD.getText().trim().length()>0){
      if (txtYYYYMMDD.getText().trim().length() < 6) {
        exgui.verification.VerifyLib.showAlert("DATE FORMAT IS :YYYYMM",
                                               "DATE FORMAT IS :YYYYMM");
        return;
      }
    }
    if(cbxCenter.getSelectedItem().toString().equals("NTFE")){
      reportName="NTFE_TOPOUTST.rpt";
    }else{
      reportName="HK_TOPOUTST.rpt";

    }
    super.JButtonQueryButtonAction(null);

  }


}
