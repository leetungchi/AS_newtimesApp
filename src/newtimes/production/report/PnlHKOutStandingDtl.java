package newtimes.production.report;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;

import java.awt.*;
import javax.swing.JPanel;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlHKOutStandingDtl
    //extends JPanel {
    extends AbsQryPanel{
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCntr = new JComboBox();
  JButton btnQry = new JButton();
  JComboBox cbxDep = new JComboBox();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   DataBindJCombobox dbCbxDep,dbCbxMng;
   protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
   boolean doingDB2Gui=false;
   int indexCbxDep=0;
   int indexCbxMng=0;
  public PnlHKOutStandingDtl() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"DEL DD");
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(13, 29, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(13, 60, 47, 21));
    blueBkgWhiteCharLabel1.setText("HK OUTSTANDING DETAIL REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 0, 805, 21));
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(57, 31, 130, 22));
    btnQry.setBounds(new Rectangle(705, 48, 83, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlHKOutStandingDtl_btnQry_actionAdapter(this));
    cbxDep.setBounds(new Rectangle(56, 63, 204, 22));
    this.setBackground(new Color(202, 202, 224));
    cbxManager.setBounds(new Rectangle(314, 29, 152, 24));
    lblManager.setText("Manager");
    lblManager.setBounds(new Rectangle(266, 27, 54, 25));
    pnlDELDate.setBackground(new Color(202, 202, 224));
    pnlDELDate.setBorder(titledBorder1);
    pnlDELDate.setBounds(new Rectangle(478, 26, 151, 69));
    pnlDELDate.setLayout(null);
    jLabel2.setText("TO");
    jLabel2.setBounds(new Rectangle(18, 36, 27, 20));
    txtDelDDTo.setText("");
    txtDelDDTo.setBounds(new Rectangle(66, 41, 71, 23));
    txtDelDateFrom.setText("");
    txtDelDateFrom.setBounds(new Rectangle(66, 14, 71, 23));
    jLabel3.setText("FROM");
    jLabel3.setBounds(new Rectangle(11, 15, 54, 18));
    lblBuyer.setText("BUYER");
    lblBuyer.setBounds(new Rectangle(266, 60, 61, 26));
    slkBuyer.setBounds(new Rectangle(314, 63, 153, 24));
    jLabel5.setText("SHOW TOTAL:");
    jLabel5.setBounds(new Rectangle(630, 32, 89, 21));
    rdoDtlY.setBackground(new Color(202, 202, 224));
    rdoDtlY.setText("YES");
    rdoDtlY.setBounds(new Rectangle(630, 48, 61, 15));
    rdoDtlN.setBackground(new Color(202, 202, 224));
    rdoDtlN.setSelected(true);
    rdoDtlN.setText("NO");
    rdoDtlN.setBounds(new Rectangle(630, 65, 64, 15));
    btnScAmt.setBounds(new Rectangle(658, 81, 130, 27));
    btnScAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnScAmt.setText("BY S/C AMOUNT.");
    btnScAmt.addActionListener(new PnlHKOutStandingDtl_btnScAmt_actionAdapter(this));
    slkMaker.setBounds(new Rectangle(314, 100, 153, 24));
    lblBuyer1.setBounds(new Rectangle(266, 97, 61, 26));
    lblBuyer1.setText("MAKER");
    jLabel6.setText("BY:");
    jLabel6.setBounds(new Rectangle(480, 96, 52, 24));
    cbxByBuyerMaker.setBounds(new Rectangle(502, 100, 124, 22));
    pnlDELDate.add(jLabel2, null);
    pnlDELDate.add(txtDelDateFrom, null);
    pnlDELDate.add(txtDelDDTo, null);
    pnlDELDate.add(jLabel3, null);
    this.add(jLabel1, null);
    this.add(cbxDep, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(lblManager, null);
    this.add(cbxManager, null);
    this.add(lblBuyer, null);
    this.add(slkBuyer, null);
    this.add(lblBuyer1, null);
    this.add(slkMaker, null);
    this.add(jLabel6, null);
    this.add(cbxByBuyerMaker, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    this.add(jLabel5, null);
    if(util.PublicVariable.USER_RECORD.get(0).equals("NTERIC")){
      this.add(btnScAmt, null);
    }

    this.add(rdoDtlN, null);
    this.add(rdoDtlY, null);
    reportName="HK_OUTSTDTL.rpt";
    buttonGroup1.add(rdoDtlY);
    buttonGroup1.add(rdoDtlN);
    this.add(pnlDELDate, null);
    genDataBindObj();
}
public void genDataBindObj() {
  doingDB2Gui=true;
  dataBindComps.clear();
  try{

    if (tempProperties.tmpCenters.size() > 1) {
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, "CENTER_CODE",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(DbJcbxcbxCntr);
    } else {
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, "CENTER_CODE",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(DbJcbxcbxCntr);
    }
    indexCbxDep =dataBindComps.size();
    dataBindComps.add(null);
    indexCbxMng=dataBindComps.size();
    dataBindComps.add(null);
    //default begin datae is first day of current mount
    /*
    java.util.Calendar cld=java.util.Calendar.getInstance();
    cld.set(cld.DATE,1);
    java.util.Date dFrom=cld.getTime();
    cld.set(cld.DATE,cld.getActualMaximum(cld.DAY_OF_MONTH));
    */
    //default end date is end day of currecnt mount
    java.sql.Date now=null;//new java.sql.Date(System.currentTimeMillis());
    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateEnd =
        new exgui.DataBindTextWithChecker(txtDelDDTo, "ENT_DATE", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateEnd);
    dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtDelDateFrom, "FROM_DATE", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);


    dataBindComps.add(dbTxtDateBgn);

    Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
    Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1",
      1, 1);
    database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
   exgui.DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbTwdChg);
   exgui.DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbRmbChg);
   exgui.DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbHkdChg);
   slkBuyer.init("BUYER",null,slkBuyer.TYPE_BUYER,true);
   slkMaker.init("MAKER",null,slkBuyer.TYPE_MAKER,true);
   //dataBindComps.add(slkBuyer);
    doingDB2Gui=false;
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
         util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
        Vector depVects =
            (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
            DbJcbxcbxCntr.getSelectedValue());
        dbCbxDep = null;
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              "");

        dataBindComps.set(indexCbxDep,dbCbxDep);
        reGenMangers();
      }else{
        cbxCntr.getItemListeners()[0].itemStateChanged(null);
      }
  }catch(Exception exp){
    exp.printStackTrace();
  }
}
JTextField txtTwdUsd=new JTextField(),txtRmbUsd=new JTextField(),txtHkdUsd=new JTextField();

public HashMap composeParameters() {
  HashMap hm = super.composeParameters();
  //hm.put(dbCbxDep.getOrgRecField(), "'"+dbCbxDep.getSelectedValue()+"'");
  if(rdoDtlY.isSelected()){
    hm.put("P_SHOW_TTL","Y");
  }else{
    hm.put("P_SHOW_TTL","N");
  }
  Object dateBgn = dbTxtDateBgn.getSelectedValue();
  Object dateTo = dbTxtDateEnd.getSelectedValue();
  if (dateTo == null) {
    hm.put("ENT_DATE", "DATE(2099,12,31)");
  }
  if(dateBgn==null){
    hm.put("FROM_DATE", "DATE(2004,07,01)");
  }
  Object objBuyer=slkBuyer.getSelectedValue();
  if(objBuyer==null){
    hm.put("BUYER", "0");
  }else{
    hm.put("BUYER", objBuyer.toString());
  }
  Object objMaker=slkMaker.getSelectedValue();
  hm.put("MAKER",(objMaker==null)?"0":objMaker.toString());
  hm.put("P_B_M",cbxByBuyerMaker.getSelectedItem().toString().substring(0,1));
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
          cbxDep, "DEP",
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
            cbxDep, "DEP",
            new Vector(),
            "DEP_NAME", "DEP_CODE",
            "",
            "ALL", "ALL");
      } else if (depVects.size() > 1) {
        dbCbxDep =
            new exgui.DataBindJCombobox(
            cbxDep, "DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            "",
            "ALL", "ALL");
        //guis.add(DbJcbxcbxDep);
      } else {
        dbCbxDep =
            new exgui.DataBindJCombobox(
            cbxDep, "DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            "","ALL","ALL");
        //guis.add(DbJcbxcbxDep);
      }
    }
   dataBindComps.set(indexCbxDep,dbCbxDep);
   String centerCode=(String)DbJcbxcbxCntr.getSelectedValue();
   if(centerCode==null)centerCode=util.PublicVariable.OPERATTING_CENTER.toString();
   slkBuyer.setSelectingCenter(centerCode);
  } catch (Exception exp) {
    exp.printStackTrace();
  }
}
protected void reGenMangers(){
  if (doingDB2Gui)return;
  Vector vctMng=
      (Vector)newtimes.preproduction.guis.tempProperties.tmpHm_Managers4AllCenters.get(
      DbJcbxcbxCntr.getSelectedValue());
  if(vctMng==null)vctMng=newtimes.preproduction.guis.tempProperties.tmpManagerRecs;
 dbCbxMng= new exgui.DataBindJCombobox(
  cbxManager, "MNG_CODE",
  vctMng,
  "MNG_ABBR", "MNG_CODE",
  "ALL","ALL","ALL");
  dataBindComps.set(indexCbxMng,dbCbxMng);

}
class cbxCenterItemChanged implements java.awt.event.ItemListener {
  public void itemStateChanged(ItemEvent e) {
     reGenDepartment();
     reGenMangers();
  }
}

void btnQry_actionPerformed(ActionEvent e) {
  reportName="HK_OUTSTDTL.rpt";
  JButtonQueryButtonAction(e);
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;
  JComboBox cbxManager = new JComboBox();
  JLabel lblManager = new JLabel();
  JPanel pnlDELDate = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtDelDDTo = new JTextField();
  JTextField txtDelDateFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel lblBuyer = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel5 = new JLabel();
  JRadioButton rdoDtlY = new JRadioButton();
  JRadioButton rdoDtlN = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JButton btnScAmt = new JButton();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel lblBuyer1 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JComboBox cbxByBuyerMaker = new JComboBox(new String[]{"BUYER","MAKER"});

  void btnScAmt_actionPerformed(ActionEvent e) {
    reportName="HK_OUTSTDTL_SCAMT.rpt";
    JButtonQueryButtonAction(e);
  }

}

class PnlHKOutStandingDtl_btnQry_actionAdapter implements java.awt.event.
  ActionListener {
PnlHKOutStandingDtl adaptee;

 PnlHKOutStandingDtl_btnQry_actionAdapter(PnlHKOutStandingDtl adaptee) {
  this.adaptee = adaptee;
}

 public void actionPerformed(ActionEvent e) {
   adaptee.btnQry_actionPerformed(e);
 }

}

class PnlHKOutStandingDtl_btnScAmt_actionAdapter implements java.awt.event.ActionListener {
  PnlHKOutStandingDtl adaptee;

  PnlHKOutStandingDtl_btnScAmt_actionAdapter(PnlHKOutStandingDtl adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnScAmt_actionPerformed(e);
  }
}
