package newtimes.production.report;


import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import newtimes.preproduction.guis.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlProfitSaleAmtRpt
    //extends JPanel {
    extends newtimes.production.report.AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JLabel jLabel3 = new JLabel();
  JTextField txtDateBgn = new JTextField();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JButton btnQry = new JButton();
  boolean doingDB2Gui=false;
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  protected   JComboBox cbxDep[];
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  DataBindJCombobox dbCbxDep[];
  JTextField   txtTwdUsd=new JTextField();
  JTextField   txtRmbUsd=new JTextField();
  JTextField   txtHkdUsd=new JTextField();
  static public boolean isProfitRpt=false;
  static int itemCount=12;
  JPanel jPanel1 = new JPanel();
  /*
  JComboBox cbxDep0= new JComboBox();
  JComboBox cbxDep1= new JComboBox();
  JComboBox cbxDep2 = new JComboBox();
  JComboBox cbxDep3 = new JComboBox();
  JComboBox cbxDep4 = new JComboBox();
  JComboBox cbxDep5 = new JComboBox();
  JComboBox cbxDep6 = new JComboBox();
  JComboBox cbxDep7 = new JComboBox();
  JComboBox cbxDep8 = new JComboBox();
  JComboBox cbxDep9 = new JComboBox();
  JComboBox cbxDep10 = new JComboBox();
  JComboBox cbxDep11 = new JComboBox();
  */
  Border border3;
  TitledBorder titledBorder3;
  public PnlProfitSaleAmtRpt() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
   cbxDep=new JComboBox[itemCount];
   dbCbxDep=new exgui.DataBindJCombobox[itemCount];

   for(int i=0;i<itemCount;i++)cbxDep[i]=new JComboBox();
    border1 = BorderFactory.createEmptyBorder();
    titledBorder1 = new TitledBorder(border1,"DEL DD");
    border2 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"ETD-DATE");
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder3 = new TitledBorder(border3,"DEP.");
    blueBkgWhiteCharLabel1.setText("PRINT FAB COMM BY NONE PI RCV DATE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 2, 803, 28));
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(2, 38, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(47, 34, 130, 22));
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(52, 41, 87, 22));
    jLabel2.setText("FROM:");
    jLabel2.setBounds(new Rectangle(8, 19, 56, 21));
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder2);
    pnlDuriation.setBounds(new Rectangle(5, 55, 147, 78));
    pnlDuriation.setLayout(null);
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(16, 41, 36, 24));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(52, 19, 87, 20));
    btnQry.setBounds(new Rectangle(716, 74, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlProfitSaleAmtRpt_btnQry_actionAdapter(this));
    this.setBackground(new Color(202, 202, 224));
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setBorder(titledBorder3);
    jPanel1.setBounds(new Rectangle(183, 30, 526, 101));
    jPanel1.setLayout(null);
    cbxDep[0].setBounds(new Rectangle(6, 14, 123, 20));
    cbxDep[1].setBounds(new Rectangle(135, 14, 123, 20));
    cbxDep[2].setBounds(new Rectangle(265, 14, 123, 20));
    cbxDep[3].setBounds(new Rectangle(394, 14, 123, 20));
    cbxDep[4].setBounds(new Rectangle(135, 44, 123, 20));
    cbxDep[5].setBounds(new Rectangle(394, 44, 123, 20));
    cbxDep[6].setBounds(new Rectangle(6, 44, 123, 20));
    cbxDep[7].setBounds(new Rectangle(265, 44, 123, 20));
    cbxDep[8].setBounds(new Rectangle(265, 70, 123, 20));
    cbxDep[9].setBounds(new Rectangle(135, 70, 123, 20));
    cbxDep[10].setBounds(new Rectangle(6, 70, 123, 20));
    cbxDep[11].setBounds(new Rectangle(394, 70, 123, 20));

    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(jLabel3, null);
    pnlDuriation.add(txtDateEnd, null);
    for(int i=0;i<itemCount;i++)jPanel1.add(cbxDep[i], null);
    /*
    jPanel1.add(cbxDep6, null);
    jPanel1.add(cbxDep0, null);
    jPanel1.add(cbxDep1, null);
    jPanel1.add(cbxDep2, null);
    jPanel1.add(cbxDep3, null);
    jPanel1.add(cbxDep5, null);
    jPanel1.add(cbxDep7, null);
    jPanel1.add(cbxDep4, null);
    jPanel1.add(cbxDep8, null);
    jPanel1.add(cbxDep9, null);
    jPanel1.add(cbxDep10, null);
    jPanel1.add(cbxDep11, null);
    */
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(pnlDuriation, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    genDataBindObj();
    if(isProfitRpt){
      blueBkgWhiteCharLabel1.setText("PROFIT AMOUNT CHART");
    }else{
      blueBkgWhiteCharLabel1.setText("SALES AMOUNT CHART");
    }
    //reportName="FAB_NONE_PI.RPT";
  }
  public void genDataBindObj() {
    doingDB2Gui=true;
    dataBindComps.clear();
    try{
      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "ALL", null);
        dataBindComps.add(DbJcbxcbxCntr);
      } else {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        dataBindComps.add(DbJcbxcbxCntr);
      }


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "P_ETD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_ETD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);

      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1",
        1, 1);
          Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
      database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
     exgui.DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbTwdChg);
     exgui.DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbRmbChg);
     exgui.DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbHkdChg);


      doingDB2Gui=false;
      cbxCntr.getItemListeners()[0].itemStateChanged(null);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public HashMap composeParameters(){
  HashMap hm = super.composeParameters();
  //hm.put(dbCbxDep.getOrgRecField(),dbCbxDep.getSelectedValue());
  StringBuffer sbDEP=new StringBuffer();
  for(int i=0;i<itemCount;i++){
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

  Object dateBgn=dbTxtDateBgn.getSelectedValue();
  Object dateEnd=dbTxtDateEnd.getSelectedValue();
  if(dateBgn==null){
    hm.put("P_ETD_FM","DATE(2000,01,01)");
  }
  if(dateEnd==null){
    hm.put("P_ETD_TO","DATE(2099,12,31)");
  }
  return hm;
}

  class cbxCenterItemChanged implements java.awt.event.ItemListener{
  public void itemStateChanged(ItemEvent e){
     if(doingDB2Gui)return;
    udpateDepComboBox();
  }
 }
 protected void udpateDepComboBox(){
   Vector depVects=
       (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
       DbJcbxcbxCntr.getSelectedValue());
   boolean haveAllDep=true;
   if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
    util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
    haveAllDep=false;
   }

   for(int i=0;i<itemCount;i++){
     dbCbxDep[i] =
         (haveAllDep)?
         new exgui.DataBindJCombobox(
         cbxDep[i], "DEP",
         depVects,
         "DEP_NAME", "DEP_CODE",
         null,
         "ALL", null):
        new exgui.DataBindJCombobox(
        cbxDep[i], "DEP",
        depVects,
        "DEP_NAME", "DEP_CODE",
        null);

     //dataBindComps.add(dbCbxDep[i]);

   }
   String usingCenterCode=(String)DbJcbxcbxCntr.getSelectedValue();
    if(usingCenterCode==null || usingCenterCode.trim().length()==0)usingCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;


 }

  void btnQry_actionPerformed(ActionEvent e) {
    if(isProfitRpt)
       reportName="PROFIT_CHART.rpt&firstgroupassheets=false";
      else
       reportName="SALES_CHART.rpt&firstgroupassheets=false";

    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(e);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }

}

class PnlProfitSaleAmtRpt_btnQry_actionAdapter implements java.awt.event.ActionListener {
  PnlProfitSaleAmtRpt adaptee;

  PnlProfitSaleAmtRpt_btnQry_actionAdapter(PnlProfitSaleAmtRpt adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQry_actionPerformed(e);
  }
}
