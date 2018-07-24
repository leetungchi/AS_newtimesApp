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

public class PnlOutStandingByMonthBuyer
    //extends JPanel {
    extends AbsQryPanel implements Int_PNL_JINIT{
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtYYYYMMDD = new JTextField();
  DataBindTextWithChecker yyyymmddDate;
  JButton btnQry = new JButton();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JComboBox cbxDep = new JComboBox();
  boolean doingDB2Gui=false;
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   DataBindJCombobox dbCbxDep;
  int indexCbxDep;
  JLabel jLabel3 = new JLabel();
  JTextField txtTo = new JTextField();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel4 = new JLabel();
  public PnlOutStandingByMonthBuyer() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

public  void jbInit() throws Exception {
    txtYYYYMMDD.setToolTipText("YYYYMM");
    txtYYYYMMDD.setBounds(new Rectangle(482, 57, 77, 24));
    txtYYYYMMDD.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(FocusEvent e) {
        txtYYYYMMDD_focusLost(e);
      }
    });
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 14, 802, 30));
    blueBkgWhiteCharLabel1.setText("OutStanding By Month ,Buyer");
    jLabel1.setBounds(new Rectangle(449, 56, 36, 26));
    jLabel1.setText("From:");
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(691, 58, 89, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setFocusPainted(true);
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel3.setText("Center");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 58, 60, 19));
    jLabel2.setBounds(new Rectangle(192, 58, 47, 21));
    jLabel2.setText("DEP.");
    cbxCntr.setBounds(new Rectangle(54, 58, 130, 22));
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxDep.setBounds(new Rectangle(235, 58, 204, 22));
    jLabel3.setText("To:");
    jLabel3.setBounds(new Rectangle(566, 56, 36, 26));
    txtTo.setBounds(new Rectangle(599, 57, 77, 24));
    txtTo.setToolTipText("YYYYMM");
    slkBuyer.setBounds(new Rectangle(235, 84, 204, 20));
    jLabel4.setText("BUYER");
    jLabel4.setBounds(new Rectangle(177, 84, 53, 17));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(jLabel2, null);
    this.add(cbxDep, null);
    this.add(btnQry, null);
    this.add(jLabel1, null);
    this.add(txtYYYYMMDD, null);
    this.add(jLabel3, null);
    this.add(txtTo, null);
    this.add(slkBuyer, null);
    this.add(jLabel4, null);
    reportName="HK_GRPOUTST.rpt";

    genDataBindObj();
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener {
  public void itemStateChanged(ItemEvent e) {
     reGenDepartment();
   }
 }

  public void genDataBindObj(){
    doingDB2Gui=true;
    dataBindComps.clear();
    try{

      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
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
      slkBuyer.setSelectingCenter((String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      slkBuyer.init("P_BUYER",null,null,slkBuyer.TYPE_BUYER,true);

      indexCbxDep =dataBindComps.size();
      dataBindComps.add(null);

      Object chkYearMon=CellFormat.getDateStringFormaterAllowNull();
      yyyymmddDate = new DataBindTextWithChecker(txtYYYYMMDD, "P_YMD1",
                                             new java.sql.Date(System.currentTimeMillis()), 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate);

     java.sql.Date now=new java.sql.Date(System.currentTimeMillis());
     int yyyy=util.MiscFunc.getYear(now);
     int mm=util.MiscFunc.getMonth(now);
     int dd=util.MiscFunc.getDay(now);

     java.util.Date  endOfYear=util.MiscFunc.toDate000000(yyyy,12,31);

     DataBindTextWithChecker yyyymmddDate2 = new DataBindTextWithChecker(txtTo, "P_YMD3",
                                         new java.sql.Date(endOfYear.getTime()), 10,
                                         (Object2String)chkYearMon,
                                         (CellTxtEditorFormat)chkYearMon);

     dataBindComps.add(yyyymmddDate2);
      txtYYYYMMDD.setToolTipText("YYYYMM");

      doingDB2Gui=false;

      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
           util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
          Vector depVects =
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          dbCbxDep = null;
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "P_DEP",
                depVects,
                "DEP_NAME", "DEP_CODE",
                "");

          dataBindComps.set(indexCbxDep,dbCbxDep);
        }else{
          cbxCntr.getItemListeners()[0].itemStateChanged(null);
        }

      //cbxCntr.getItemListeners()[0].itemStateChanged(null);

    } catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public java.util.HashMap composeParameters(){
   java.util.HashMap hm=super.composeParameters();
   Object objBuyer=slkBuyer.getSelectedValue();
   hm.put("P_BUYER",(objBuyer==null)?"0":objBuyer.toString());
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
   //hm.put("GP_TYPE",((exgui.ultratable.Wraper4tblCbx)cbxSortBy.getSelectedItem()).getValue());
   return hm;

 }

  protected void reGenDepartment(){
    if (doingDB2Gui)return;
    try {
      //find out the vector to add dbDeps.
      if (DbJcbxcbxCntr.getSelectedValue() == null) {
        //only the all dep is allow to add now.
        dbCbxDep =
            new exgui.DataBindJCombobox(
            cbxDep, "P_DEP",
            new Vector(),
            "DEP_NAME", "DEP_CODE",
            "",
            "ALL", "ALL");
      } else {
        //deps and "ALL"dep allow to add.
        Vector depVects =
            (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
            DbJcbxcbxCntr.getSelectedValue());
        dbCbxDep = null;
        if (depVects == null) {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              "",
              "ALL", "ALL");
        } else if (depVects.size() > 1) {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              "",
              "ALL", "ALL");
          //guis.add(DbJcbxcbxDep);
        } else {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              "","ALL","ALL");
          //guis.add(DbJcbxcbxDep);
        }
      }

     dataBindComps.set(indexCbxDep,dbCbxDep);
     String centerCode=(String)DbJcbxcbxCntr.getSelectedValue();
     slkBuyer.setSelectingCenter(centerCode);
     slkBuyer.init("P_BUYER",null,null,slkBuyer.TYPE_BUYER,true);

     if(centerCode==null)centerCode=util.PublicVariable.OPERATTING_CENTER.toString();
    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {

      if(txtYYYYMMDD.getText().trim().length()==0||txtTo.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Date","Please Input Date");
        return;
      }
      super.JButtonQueryButtonAction(null);

  }

  void txtYYYYMMDD_focusLost(FocusEvent e) {
    if(txtYYYYMMDD.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please input Date","Please Input Date");
      txtYYYYMMDD.grabFocus();
      return;
    }
    String yearEnd=txtYYYYMMDD.getText().trim().substring(0,4)+"/12/31";
    txtTo.setText(yearEnd);
  }

}
