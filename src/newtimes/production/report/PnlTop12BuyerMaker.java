package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlTop12BuyerMaker
     extends  AbsQryPanel{
     //extends JPanel {
  JTextField txtThisMonthTo = new JTextField();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JRadioButton rdoByBuyer = new JRadioButton();
  JTextField txtYearMonthTo = new JTextField();
  JTextField txtYearMonthFrom = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JRadioButton rdoByMaker = new JRadioButton();
  JTextField txtThisMonthFrom = new JTextField();
  JLabel jLabel5 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JButton btnQty = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  protected   DataBindJCombobox dbCbxCenter ;
  protected   DataBindTextWithChecker dbTxtEtdFrm,dbTxtEtdTo,dbTxtCurrFrm,dbTxtCurrTo,dbTwdChg,dbRmbChg,dbHkdChg;

  public PnlTop12BuyerMaker() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    txtThisMonthFrom.setText("");
    txtThisMonthFrom.setBounds(new Rectangle(219, 114, 76, 20));
    rdoByMaker.setSelected(true);
    rdoByMaker.setBackground(new Color(202, 202, 225));
    rdoByMaker.setText("MAKER");
    rdoByMaker.setBounds(new Rectangle(415, 48, 102, 22));
    jLabel7.setBounds(new Rectangle(255, 48, 67, 22));
    jLabel7.setText("BY");
    jLabel7.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel3.setText("TO");
    jLabel3.setBounds(new Rectangle(302, 114, 33, 20));
    jLabel1.setBounds(new Rectangle(11, 87, 205, 20));
    jLabel1.setText("YEAR TO MONTH OBD FROM");
    jLabel1.setHorizontalAlignment(SwingConstants.TRAILING);
    txtYearMonthFrom.setBounds(new Rectangle(218, 88, 76, 20));
    txtYearMonthFrom.setText("");
    txtYearMonthTo.setText("");
    txtYearMonthTo.setBounds(new Rectangle(335, 88, 70, 20));
    rdoByBuyer.setBounds(new Rectangle(324, 48, 77, 22));
    rdoByBuyer.setText("BUYER");
    rdoByBuyer.setSelected(true);
    rdoByBuyer.setBackground(new Color(202, 202, 225));
    jLabel2.setBounds(new Rectangle(302, 88, 33, 20));
    jLabel2.setText("TO");
    jLabel4.setText("THIS MONTH OBD FROM");
    jLabel4.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel4.setBounds(new Rectangle(45, 113, 173, 20));
    txtThisMonthTo.setBounds(new Rectangle(336, 114, 70, 20));
    txtThisMonthTo.setText("");
    this.setBackground(new Color(202, 202, 225));
    this.setLayout(null);
    jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel5.setText("CENTER");
    jLabel5.setBounds(new Rectangle(16, 48, 67, 21));
    cbxCenter.setBounds(new Rectangle(94, 47, 152, 23));
    btnQty.setBounds(new Rectangle(625, 113, 102, 23));
    btnQty.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQty.setText("QUERY");
    btnQty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQty_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel1.setText("BUYER MAKER TOP 12,15");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 8, 803, 27));
    txtTWD.setText("");
    txtTWD.setBounds(new Rectangle(527, 50, 52, 17));
    txtRMB.setBounds(new Rectangle(596, 48, 52, 17));
    txtRMB.setText("jTextField1");
    txtRMB.setText("");
    txtHKD.setBounds(new Rectangle(690, 52, 52, 17));
    txtHKD.setText("jTextField1");
    txtHKD.setText("");
    btnTop12.setBackground(Color.white);
    btnTop12.setSelected(true);
    btnTop12.setText("TOP 12");
    btnTop12.setBounds(new Rectangle(528, 50, 96, 18));
    btnTop50.setBounds(new Rectangle(624, 50, 96, 18));
    btnTop50.setText("TOP 50");
    btnTop50.setBackground(Color.white);
    this.add(jLabel1, null);
    this.add(jLabel5, null);
    this.add(cbxCenter, null);
    this.add(jLabel7, null);
    this.add(rdoByBuyer, null);
    this.add(rdoByMaker, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel4, null);
    this.add(txtYearMonthFrom, null);
    this.add(jLabel2, null);
    this.add(txtYearMonthTo, null);
    this.add(txtThisMonthFrom, null);
    this.add(jLabel3, null);
    this.add(txtThisMonthTo, null);
    this.add(btnQty, null);
    this.add(btnTop12, null);
    //this.add(txtTWD, null);
    //this.add(txtRMB, null);
    //this.add(txtHKD, null);
    buttonGroup1.add(rdoByBuyer);
    buttonGroup1.add(rdoByMaker);
    this.add(btnTop50, null);
    genDataBindObj();
    buttonGroup2.add(btnTop12);
    buttonGroup2.add(btnTop50);
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();
      Object dateVfy = exgui.verification.CellFormat.getDateStringFormater();
      Calendar cldObj=Calendar.getInstance();
      cldObj.set(cldObj.MONTH,cldObj.JANUARY);
      cldObj.set(cldObj.DATE,1);

      dbTxtEtdFrm =
          new exgui.DataBindTextWithChecker(txtYearMonthFrom, "P_ETD_FM",
                                            new java.sql.Date(cldObj.getTimeInMillis()),
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtEtdFrm);
      dbTxtEtdTo =
          new exgui.DataBindTextWithChecker(txtYearMonthTo, "P_ETD_TO",
                                            util.MiscFunc.toDate000000(
                                                util.MiscFunc.getYear(new java.sql.Date(System.currentTimeMillis()))
                                                ,12,31),
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtEtdTo);

      cldObj.setTimeInMillis(System.currentTimeMillis());
      cldObj.set(cldObj.DATE,1);
      dbTxtCurrFrm =
          new exgui.DataBindTextWithChecker(txtThisMonthFrom, "P_CURR_DATE",
                                            new java.sql.Date(cldObj.getTimeInMillis()),
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtCurrFrm);

      cldObj.set(cldObj.DATE,cldObj.getActualMaximum(cldObj.DAY_OF_MONTH));
      dbTxtCurrTo =
          new exgui.DataBindTextWithChecker(txtThisMonthTo, "P_CURR_DATE_EN",
                                            new java.sql.Date(cldObj.getTimeInMillis()),
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtCurrTo);



      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(dbCbxCenter);


     Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
     Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD, "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1", 1, 1);
     database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
     dbTwdChg = new DataBindTextWithChecker(txtTWD, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbTwdChg);
     dbRmbChg = new DataBindTextWithChecker(txtRMB, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbRmbChg);
     dbHkdChg = new DataBindTextWithChecker(txtHKD, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbHkdChg);
      reportName ="PROFIT_BUY_MKR53.rpt";

    }catch(Exception exp){
      exp.printStackTrace();

    }

  }
  JTextField txtTWD = new JTextField();
  JTextField txtRMB = new JTextField();
  JTextField txtHKD = new JTextField();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton btnTop12 = new JRadioButton();
  JRadioButton btnTop50 = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  protected HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    if(rdoByBuyer.isSelected()){
      hm.put("BUYER_MAKER","'BUYER'");
    }else{
      hm.put("BUYER_MAKER","'MAKER'");
    }
    if(btnTop12.isSelected()){
      reportName ="PROFIT_BUY_MKR53.rpt";
    }else{
      reportName ="PROFIT_BUY_MKR53_50.rpt";
    }
    return hm;
  }

  void btnQty_actionPerformed(ActionEvent e) {
    //org url is http://rpt.nttpe.com.tw:9000/?file:///d://rpt//
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
     super.JButtonQueryButtonAction(null);
     newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
}
