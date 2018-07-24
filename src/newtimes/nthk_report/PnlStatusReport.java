package newtimes.nthk_report;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import exgui.*;

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

public class PnlStatusReport
    extends AbsQryPanel implements Int_PNL_JINIT{
    //extends JPanel {
  JLabel lblToDate = new JLabel();
  JTextField txtFromDate = new JTextField();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JComboBox cbxCenter = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel lblDate = new JLabel();
  JLabel lblBuyer = new JLabel();
  JLabel lblDep = new JLabel();
  JLabel lblDep1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JButton btnReport = new JButton();
  JTextField txtToDate = new JTextField();
  exgui.DataBindJCombobox dbCbxDep,dbCbxCenter;
  boolean isGeneratingGui=false;
  exgui.DataBindTextWithChecker dbTxtFrom,dbTxtTo;
  static java.util.HashMap hmCenterCodeDepVector=null;
  static java.util.Vector vctCenter=null;

  public PnlStatusReport() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 public  void jbInit() throws Exception {
    //txtToDate.setText(year+"/12/31");
    txtToDate.setBounds(new Rectangle(682, 64, 100, 24));
    btnReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReport_actionPerformed(e);
      }
    });
    btnReport.setText("REPORT");
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setBounds(new Rectangle(677, 97, 102, 24));
    cbxDep.setBounds(new Rectangle(312, 64, 157, 21));
    lblDep1.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDep1.setText("CENTER:");
    lblDep1.setBounds(new Rectangle(10, 64, 65, 20));
    lblDep.setBounds(new Rectangle(233, 64, 91, 20));
    lblDep.setText("DEPARTMENT:");
    lblDep.setFont(new java.awt.Font("Dialog", 1, 11));
    lblBuyer.setFont(new java.awt.Font("Dialog", 1, 11));
    lblBuyer.setText("BUYER:");
    lblBuyer.setBounds(new Rectangle(10, 97, 91, 20));
    lblDate.setBounds(new Rectangle(484, 64, 77, 22));
    lblDate.setText("DEL From:");
    lblDate.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 15, 802, 35));
    blueBkgWhiteCharLabel1.setText("NTHK STATUS REPORT");
    cbxCenter.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCenter_itemStateChanged(e);
      }
    });
    cbxCenter.setBounds(new Rectangle(88, 64, 131, 21));
    slkBuyer.setBounds(new Rectangle(88, 97, 157, 20));
    //txtFromDate.setText(bgnDate);
    txtFromDate.setBounds(new Rectangle(555, 64, 100, 24));
    lblToDate.setFont(new java.awt.Font("Dialog", 1, 11));
    lblToDate.setText("TO");
    lblToDate.setBounds(new Rectangle(658, 64, 50, 22));
    this.setLayout(null);
    slkBuyer.init("P_BUYER", null, slkBuyer.TYPE_BUYER, true);
    this.add(lblToDate, null);
    this.add(txtFromDate, null);
    this.add(slkBuyer, null);
    this.add(cbxCenter, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblDate, null);
    this.add(lblBuyer, null);
    this.add(lblDep, null);
    this.add(lblDep1, null);
    this.add(cbxDep, null);
    this.add(btnReport, null);
    this.add(txtToDate, null);
    slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);


    genDataBindObj();
    reportName="NTHK_STATUS.rpt";
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
          cbxDep, "P_DEP",
          depVects,
          "DEP_NAME", "DEP_CODE",
          null,"ALL", "ALL");
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    //Object objYear=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
    //default from date is 1st day of current mount,
    //default end date is 1201

    dbTxtFrom=
       new exgui.DataBindTextWithChecker(txtFromDate, "P_DEL_FM",
                                         null,
                                         10, (exgui.Object2String)dateVfy,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)dateVfy);
    //txtFromDate.setText(bgnDate);
    dbTxtTo=
       new exgui.DataBindTextWithChecker(txtToDate, "P_DEL_TO",
                                        null,
                                        10, (exgui.Object2String)dateVfy,
                                        (exgui.ultratable.
                                         CellTxtEditorFormat)dateVfy);
    //txtToDate.setText(year+"/12/31");

    isGeneratingGui=false;

  }

  public java.util.HashMap  composeParameters()
  {
     /*
     java.util.HashMap hm=new java.util.HashMap();
     hm.put("P_CENTER",dbCbxCenter.getSelectedValue());
     hm.put("P_DEP",dbCbxDep.getSelectedValue());
     hm.put("P_DEL_FM",util.MiscFunc.Replace(txtFromDate.getText().trim(),"/",""));
     hm.put("P_DEL_TO",util.MiscFunc.Replace(txtToDate.getText().trim(),"/",""));
     hm.put("P_BUYER",(slkBuyer.getSelectedValue()==null)?"0":slkBuyer.getSelectedValue().toString());
     */
     java.util.HashMap hm=super.composeParameters();
     hm.put("P_BUYER",(slkBuyer.getSelectedValue()==null)?"0":slkBuyer.getSelectedValue().toString());
     hm.put("P_DEL_FM",(dbTxtFrom.getSelectedValue()==null)?super.convert2QueryPara(util.MiscFunc.toDate235959(2000,1,1)):
                                                            super.convert2QueryPara(dbTxtFrom.getSelectedValue()));
     hm.put("P_DEL_TO",(dbTxtTo.getSelectedValue()==null)?super.convert2QueryPara(util.MiscFunc.toDate235959(2099,12,31)):
                                                          super.convert2QueryPara(dbTxtTo.getSelectedValue()));

     return hm;
  }

  void btnReport_actionPerformed(ActionEvent e) {
    /*
    if(txtFromDate.getText().trim().length()<10){
      exgui.verification.VerifyLib.showAlert("Please Input DEL FROM DATE","Pleaes Input Date");
      return;
    }
    if(txtToDate.getText().trim().length()<10){
      exgui.verification.VerifyLib.showAlert("Please Input DEL END DATE","Pleaes Input Date");
      return;
    }*/
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
         cbxDep, "P_DEP",
         depVects,
         "DEP_NAME", "DEP_CODE",
         null,"ALL", "ALL");
    slkBuyer.setSelectingCenter(center);
    slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
    }
  }
}
