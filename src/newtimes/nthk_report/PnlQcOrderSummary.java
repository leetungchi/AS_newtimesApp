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
import newtimes.preproduction.guis.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQcOrderSummary
    extends AbsQryPanel implements Int_PNL_JINIT{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxDep = new JComboBox();
  JLabel lblDep = new JLabel();
  JTextField txtFromDate = new JTextField();
  JLabel lblDate = new JLabel();
  JButton btnReport = new JButton();
  exgui.DataBindJCombobox dbCbxDep,dbCbxCenter;
  JTextField txtToDate = new JTextField();
  JLabel lblToDate = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel lblBuyer = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  exgui.DataBindTextWithChecker dbTxtFrom,dbTxtTo;
  JLabel lblMaker = new JLabel();
  JLabel lblDep1 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  boolean isGeneratingGui=false;
  static java.util.HashMap hmCenterCodeDepVector=null;
  static java.util.Vector vctCenter=null;
  public PnlQcOrderSummary() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 public void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("QC ORDER SUMMARY");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 20, 802, 35));
    this.setLayout(null);
    cbxDep.setBounds(new Rectangle(311, 69, 157, 21));
    lblDep.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDep.setText("DEPARTMENT:");
    lblDep.setBounds(new Rectangle(232, 69, 91, 20));
    txtFromDate.setText("");
    txtFromDate.setBounds(new Rectangle(554, 69, 100, 24));
    lblDate.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDate.setText("DEL From:");
    lblDate.setBounds(new Rectangle(483, 69, 77, 22));
    btnReport.setBounds(new Rectangle(676, 102, 102, 24));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setText("REPORT");
    btnReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReport_actionPerformed(e);
      }
    });
    txtToDate.setBounds(new Rectangle(681, 69, 100, 24));
    txtToDate.setText("");
    lblToDate.setBounds(new Rectangle(657, 69, 50, 22));
    lblToDate.setText("TO");
    lblToDate.setFont(new java.awt.Font("Dialog", 1, 11));
    slkBuyer.setBounds(new Rectangle(87, 102, 157, 20));
    lblBuyer.setBounds(new Rectangle(9, 102, 91, 20));
    lblBuyer.setText("BUYER:");
    lblBuyer.setFont(new java.awt.Font("Dialog", 1, 11));
    slkMaker.setBounds(new Rectangle(332, 102, 164, 20));
    lblMaker.setFont(new java.awt.Font("Dialog", 1, 11));
    lblMaker.setText("MAKER:");
    lblMaker.setBounds(new Rectangle(260, 102, 91, 20));
    lblDep1.setBounds(new Rectangle(9, 69, 65, 20));
    lblDep1.setText("CENTER:");
    lblDep1.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCenter.setBounds(new Rectangle(87, 69, 131, 21));
    cbxCenter.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCenter_itemStateChanged(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(slkBuyer, null);
    this.add(lblBuyer, null);
    this.add(slkMaker, null);
    this.add(lblMaker, null);
    this.add(btnReport, null);
    this.add(lblDep, null);
    this.add(cbxDep, null);
    this.add(lblDate, null);
    this.add(txtFromDate, null);
    this.add(lblToDate, null);
    this.add(txtToDate, null);
    this.add(lblDep1, null);
    this.add(cbxCenter, null);
    slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("P_MAKER",null,slkBuyer.TYPE_MAKER,true);


    genDataBindObj();
    reportName="HK_QC_SUM.rpt";
  }
  protected static void updateCenterDepMap(java.util.Vector depRecords){
    hmCenterCodeDepVector.clear();
    for(int i=0;i<depRecords.size();i++){
      database.datatype.Record rec=(database.datatype.Record)depRecords.get(i);
      String xntCenName=(String)rec.get(4);
      if(hmCenterCodeDepVector.containsKey(xntCenName)){
        Vector tmpVct=(Vector)hmCenterCodeDepVector.get(xntCenName);
        tmpVct.add(rec);
      }else{
        Vector newVct=new Vector();
        newVct.add(rec);
        hmCenterCodeDepVector.put(xntCenName,newVct);
      }
    }
  }

  protected String[] listFrom(int bgnMonth){
    String monlist[]=new String[12];
    int i=bgnMonth;
    int index=0;
    for(;index<12;index++){
      int value=(i+index)%12;
      if(value==0)value=12;
      monlist[index]=(value<10)?"0"+String.valueOf(value):String.valueOf(value);
    }
    return monlist;
  }
  public void genDataBindObj(){
    try{
      if (hmCenterCodeDepVector == null) {
        vctCenter = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from center where record_delete_flag='1'",
            1, 99999);
        hmCenterCodeDepVector = new java.util.HashMap();
        Vector vctDeps = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from department order by dep_cen_code "
            , 1, 999999);
        updateCenterDepMap(vctDeps);
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

    isGeneratingGui=true;

    dbCbxCenter =
       new exgui.DataBindJCombobox(
       cbxCenter, "P_CENTER",
       vctCenter,
       "CEN_NAME", "CEN_CODE",
       util.PublicVariable.OPERATTING_CENTER);

    java.util.Vector depVects=
        newtimes.preproduction.guis.tempProperties.tmpDepartment;
       dbCbxDep =
          new exgui.DataBindJCombobox(
          cbxDep, "P_DEPT",
          depVects,
          "DEP_NAME", "DEP_CODE",
          null,"ALL", "ALL");
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    //Object objYear=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
    //default from date is 1st day of current mount,
    //default end date is 1201
    java.sql.Date currDate=new java.sql.Date(System.currentTimeMillis());
    int year=util.MiscFunc.getYear(currDate);
    int month=util.MiscFunc.getMonth(currDate);
    String bgnDate=String.valueOf(year)+"/"+
        ((month<10)?"0"+String.valueOf(month):String.valueOf(month))+"/01";

    dbTxtFrom=
       new exgui.DataBindTextWithChecker(txtFromDate, "P_DATE_FROM",
                                         null,
                                         10, (exgui.Object2String)dateVfy,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)dateVfy);
    txtFromDate.setText(bgnDate);
    dbTxtTo=
       new exgui.DataBindTextWithChecker(txtToDate, "P_DATE_TO",
                                        null,
                                        10, (exgui.Object2String)dateVfy,
                                        (exgui.ultratable.
                                         CellTxtEditorFormat)dateVfy);
    txtToDate.setText(year+"/12/31");

    isGeneratingGui=false;

  }

  public java.util.HashMap  composeParameters()
  {
     java.util.HashMap hm=new java.util.HashMap();
     hm.put("P_CENTER",dbCbxCenter.getSelectedValue());
     hm.put("P_DEPT",dbCbxDep.getSelectedValue());
     hm.put("P_DEL_FM",util.MiscFunc.Replace(txtFromDate.getText().trim(),"/",""));
     hm.put("P_DEL_TO",util.MiscFunc.Replace(txtToDate.getText().trim(),"/",""));
     hm.put("P_BUYER",(slkBuyer.getSelectedValue()==null)?"0":slkBuyer.getSelectedValue().toString());
     hm.put("P_MAKER",(slkMaker.getSelectedValue()==null)?"0":slkMaker.getSelectedValue().toString());
     String testStr[]=util.MiscFunc.split(txtFromDate.getText().trim(),"/");
     int fromMon=Integer.parseInt(testStr[1]);
     String listMonth[]=listFrom(fromMon);
     for(int i=0;i<listMonth.length;i++){
       hm.put("P_M"+((i+1<10)?"0"+String.valueOf(i+1):String.valueOf(i+1)),listMonth[i]);
     }
     return hm;
  }

  void btnReport_actionPerformed(ActionEvent e) {
    if(txtFromDate.getText().trim().length()<10){
      exgui.verification.VerifyLib.showAlert("Please Input DEL FROM DATE","Pleaes Input Date");
      return;
    }
    if(txtToDate.getText().trim().length()<10){
      exgui.verification.VerifyLib.showAlert("Please Input DEL END DATE","Pleaes Input Date");
      return;
    }
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
    "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
       "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";


  }

  void cbxCenter_itemStateChanged(ItemEvent e) {
    if(!isGeneratingGui){
      String center=(String)dbCbxCenter.getSelectedValue();
      Vector depVects=(Vector)hmCenterCodeDepVector.get(center);
      if(depVects==null)depVects=new Vector();
      dbCbxDep =
         new exgui.DataBindJCombobox(
         cbxDep, "P_DEPT",
         depVects,
         "DEP_NAME", "DEP_CODE",
         null,"ALL", "ALL");
    slkBuyer.setSelectingCenter(center);
    slkMaker.setSelectingCenter(center);
    slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("P_MAKER",null,slkBuyer.TYPE_MAKER,true);
    }
  }

}
