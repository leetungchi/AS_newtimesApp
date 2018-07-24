package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import exgui.*;
import java.awt.event.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;

import java.awt.*;
import javax.swing.JPanel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl3YearSalesRpt
    //extends JPanel {
    extends AbsQryPanel{

  JPanel pnlDeps = new JPanel();
  JComboBox cbxDep[] = new JComboBox[14];
  /*
  JComboBox cbxDep0=new JComboBox();
  JComboBox cbxDep1=new JComboBox();
  JComboBox cbxDep2=new JComboBox();
  JComboBox cbxDep3=new JComboBox();
  JComboBox cbxDep4=new JComboBox();
  JComboBox cbxDep5=new JComboBox();
  JComboBox cbxDep6 = new JComboBox();
  JComboBox cbxDep7 = new JComboBox();
  JComboBox cbxDep8 = new JComboBox();
  JComboBox cbxDep9 = new JComboBox();
  JComboBox cbxDep11 = new JComboBox();
  JComboBox cbxDep13 = new JComboBox();
  JComboBox cbxDep12 = new JComboBox();
  JComboBox cbxDep10 = new JComboBox();
  */


  Border border1;
  TitledBorder titledBorder1;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtTitle = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtMonth = new JTextField();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox dbCbxDep[]=new exgui.DataBindJCombobox[14];
  protected   DataBindTextWithChecker dbTwdChg,dbRmbChg,dbHkdChg;
  JTextField txtTwdUsd=new JTextField();
  JTextField txtRmbUsd=new JTextField();
  JTextField txtHkdUsd=new JTextField();

  public Pnl3YearSalesRpt() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157));
    titledBorder1 = new TitledBorder(border1,"Department");
    pnlDeps.setBackground(new Color(204, 204, 225));
    pnlDeps.setBorder(titledBorder1);
    pnlDeps.setBounds(new Rectangle(11, 53, 778, 82));
    pnlDeps.setLayout(null);
    this.setLayout(null);
    this.setBackground(new Color(204, 204, 225));



    for( int i=0;i<14;i++) cbxDep[i]=new JComboBox();

    cbxDep[0].setBounds(new Rectangle(5, 18, 104, 21));
    cbxDep[1].setBounds(new Rectangle(5, 48, 104, 21));
    cbxDep[2].setBounds(new Rectangle(216, 19, 104, 21));
    cbxDep[3].setBounds(new Rectangle(110, 19, 104, 21));
    cbxDep[4].setBounds(new Rectangle(111, 47, 104, 21));
    cbxDep[5].setBounds(new Rectangle(321, 18, 104, 21));
    cbxDep[6].setBounds(new Rectangle(216, 49, 104, 21));
    cbxDep[7].setBounds(new Rectangle(321, 48, 104, 21));
    cbxDep[8].setBounds(new Rectangle(426, 18, 104, 21));
    cbxDep[9].setBounds(new Rectangle(426, 47, 104, 21));
    cbxDep[10].setBounds(new Rectangle(540, 18, 104, 21));
    cbxDep[11].setBounds(new Rectangle(540, 48, 104, 21));
    cbxDep[13].setBounds(new Rectangle(645, 47, 104, 21));
    cbxDep[12].setBounds(new Rectangle(645, 18, 104, 21));


    blueBkgWhiteCharLabel1.setText("3 YEAR SALES LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 12, 816, 37));

    whiteBkgBlueCharLabel1.setText("TITLE");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(13, 137, 130, 21));
    txtTitle.setText("");
    txtTitle.setBounds(new Rectangle(143, 137, 364, 21));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("YYYY");
    jLabel1.setBounds(new Rectangle(513, 136, 42, 22));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(546, 136, 39, 26));
    jLabel2.setBounds(new Rectangle(590, 136, 26, 22));
    jLabel2.setText("MM");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    txtMonth.setText("");
    txtMonth.setBounds(new Rectangle(611, 136, 36, 26));
    btnQry.setBounds(new Rectangle(654, 135, 142, 26));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPROT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    /*
    pnlDeps.add(cbxDep1, null);
    pnlDeps.add(cbxDep0, null);
    pnlDeps.add(cbxDep4, null);
    pnlDeps.add(cbxDep3, null);
    pnlDeps.add(cbxDep2, null);
    pnlDeps.add(cbxDep6, null);
    pnlDeps.add(cbxDep5, null);
    pnlDeps.add(cbxDep7, null);
    pnlDeps.add(cbxDep9, null);
    pnlDeps.add(cbxDep8, null);
    pnlDeps.add(cbxDep11, null);
    pnlDeps.add(cbxDep13, null);
    pnlDeps.add(cbxDep12, null);
    pnlDeps.add(cbxDep10, null);
     */
    for(int i=0;i<14;i++)pnlDeps.add(cbxDep[i],null);

    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtTitle, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlDeps, null);
    this.add(jLabel1, null);
    this.add(txtYear, null);
    this.add(jLabel2, null);
    this.add(btnQry, null);
    this.add(txtMonth, null);
    reportName="PROFIT_MONTH_CHART.rpt&firstgroupassheets=false";
    genDataBindObj();
  }
  public void genDataBindObj(){
    try{
      dataBindComps.clear();
      Vector depVects =
          (Vector)newtimes.preproduction.guis.tempProperties.
          tmpH_tbl_CenterDepMap.get(
          util.PublicVariable.OPERATTING_CENTER);
      for (int i = 0; i < 14; i++) {
        dbCbxDep[i] =
            new exgui.DataBindJCombobox(
            cbxDep[i], "DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            null,
            "ALL", null);
        //dataBindComps.add(dbCbxDep[i]);
      }
      java.util.GregorianCalendar gg = new java.util.GregorianCalendar();
      int year = gg.get(gg.YEAR);
      int month = gg.get(gg.MONTH) + 1;
      txtYear.setText(String.valueOf(year));
      txtMonth.setText(String.valueOf(month));
      Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);

      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.
          USER_RECORD,
          "select * from system_default_value where CENTER='" +
                                           (String)util.PublicVariable.
                                           USER_RECORD.get("USR_CEN_CODE") +
                                           "' and record_delete_flag=1", 1, 1);
      database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
      dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD",
                                             recSystem.get("TWD_XCHG_RATE"), 10,
                                             (Object2String)chkDcm32,
                                             (exgui.ultratable.
                                              CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbTwdChg);
      dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD",
                                             recSystem.get("RMB_XCHG_RATE"), 10,
                                             (Object2String)chkDcm32,
                                             (exgui.ultratable.
                                              CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbRmbChg);
      dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD",
                                             recSystem.get("HKD_XCHG_RATE"), 10,
                                             (Object2String)chkDcm32,
                                             (exgui.ultratable.
                                              CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbHkdChg);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    StringBuffer sbDEP=new StringBuffer();
    for(int i=0;i<14;i++){
      Object depObj=dbCbxDep[i].getSelectedValue();
      if(depObj!=null){
        if(sbDEP.length()>0)sbDEP.append(",");
        sbDEP.append("'");
        sbDEP.append(depObj);
        sbDEP.append("'");
      }
    }
    if(sbDEP.length()>0){
      hm.put("P_DEP","["+sbDEP.toString()+"]");
    }else{
      hm.put("P_DEP","['ALL']");
    }
    int year=Integer.parseInt(txtYear.getText().trim());
    int month=Integer.parseInt(txtMonth.getText().trim());
    hm.put("R_YEAR",String.valueOf(year));
    --year;
    hm.put("L_YEAR",String.valueOf(year));
    --year;
    hm.put("LL_YEAR",String.valueOf(year));
    hm.put("R_MONTH",String.valueOf(month));
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    hm.put("P_TITLE",(txtTitle.getText().trim().length()==0)?" ":txtTitle.getText().trim());

    return hm;
  }
  public boolean checkYYMM(){
    if(txtYear.getText().trim().length()!=4){
      exgui.verification.VerifyLib.showAlert("Please Input 4-Digit Year Number",
                                             "Please Input 4-Digit Year Number");
      return false;
    }

    if(txtMonth.getText().trim().length()>2||txtMonth.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input 2-Digit Month Number",
                                             "Please Input 2-Digit Month Number");
      return false;
    }
    try{
      int year=Integer.parseInt(txtYear.getText().trim());

    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Please Input 4-Digit Year Number",
                                             "Please Input 4-Digit Year Number");
      return false;
    }

    try{
      int month=Integer.parseInt(txtMonth.getText().trim());
      if(month<0 || month>12){
        exgui.verification.VerifyLib.showAlert("Month Should Between 1~12",
                                               "Month Should Between 1~12");

        return false;
      }
    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Please Input 2-Digit Month Number",
                                             "Please Input 2-Digit Month Number");
      return false;
    }

    return true;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(!checkYYMM())return;
      String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
      newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
     super.JButtonQueryButtonAction(e);
     newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
}
