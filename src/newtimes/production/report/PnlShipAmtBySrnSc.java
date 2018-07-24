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

public class PnlShipAmtBySrnSc
    //extends JPanel {
    extends AbsQryPanel{
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCntr = new JComboBox();
  JButton btnQry = new JButton();
  JComboBox cbxDep = new JComboBox();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   DataBindJCombobox dbCbxDep;
   protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtCreateDateFrom,dbTxtCreateDateTo;
   boolean doingDB2Gui=false;
   int indexCbxDep=0;
   int indexCbxMng=0;
  public PnlShipAmtBySrnSc() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"ETD DATE");
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 43, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(10, 74, 47, 21));
    blueBkgWhiteCharLabel1.setText(" SHIP DETAIL BY SRN ");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 803, 28));
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(54, 45, 130, 19));
    btnQry.setBounds(new Rectangle(717, 91, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlShipAmtBySrnSc_btnQry_actionAdapter(this));
    cbxDep.setBounds(new Rectangle(53, 77, 186, 22));
    this.setBackground(new Color(202, 202, 224));
    pnlDELDate.setBackground(new Color(202, 202, 224));
    pnlDELDate.setBorder(titledBorder1);
    pnlDELDate.setDebugGraphicsOptions(0);
    pnlDELDate.setBounds(new Rectangle(537, 40, 247, 47));
    pnlDELDate.setLayout(null);
    jLabel2.setText("TO");
    jLabel2.setBounds(new Rectangle(139, 14, 27, 20));
    txtDelDDTo.setText("");
    txtDelDDTo.setBounds(new Rectangle(163, 14, 71, 23));
    txtDelDateFrom.setText("");
    txtDelDateFrom.setBounds(new Rectangle(66, 15, 71, 23));
    jLabel3.setText("FROM");
    jLabel3.setBounds(new Rectangle(7, 15, 54, 18));
    lblBuyer.setText("BUYER");
    lblBuyer.setBounds(new Rectangle(302, 43, 61, 26));
    slkBuyer.setBounds(new Rectangle(350, 46, 153, 24));
    lblYear.setText("YEAR");
    lblYear.setBounds(new Rectangle(192, 43, 42, 19));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(237, 43, 53, 21));
    jLabel5.setBounds(new Rectangle(616, 94, 27, 20));
    jLabel5.setText("TO");
    jLabel6.setBounds(new Rectangle(457, 82, 90, 26));
    jLabel6.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel6.setText("CREATE DATE");
    txtCreateDDTo.setBounds(new Rectangle(640, 94, 71, 23));
    txtCreateDDTo.setText("");
    txtCreateDateFrom.setBounds(new Rectangle(543, 94, 71, 23));
    txtCreateDateFrom.setText("");
    jLabel7.setText("FROM");
    jLabel7.setBounds(new Rectangle(494, 102, 47, 23));
    slkMaker.setBounds(new Rectangle(296, 79, 153, 24));
    lblBuyer1.setBounds(new Rectangle(248, 79, 54, 26));
    lblBuyer1.setText("MAKER");
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(jLabel1, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCntr, null);
    this.add(cbxDep, null);
    pnlDELDate.add(txtDelDateFrom, null);
    pnlDELDate.add(jLabel2, null);
    pnlDELDate.add(txtDelDDTo, null);
    pnlDELDate.add(jLabel3, null);
    this.add(lblBuyer, null);
    this.add(slkBuyer, null);
    this.add(lblBuyer1, null);
    this.add(slkMaker, null);
    this.add(btnQry, null);
    this.add(jLabel6, null);
    this.add(jLabel7, null);
    this.add(txtCreateDateFrom, null);
    this.add(jLabel5, null);
    this.add(txtCreateDDTo, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(pnlDELDate, null);
    genDataBindObj();
    reportName="HK_SHIP_SC_AMT.rpt";
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
    indexCbxDep =dataBindComps.size();
    dataBindComps.add(null);
    /*
    indexCbxMng=dataBindComps.size();
    dataBindComps.add(null);
    */
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
        new exgui.DataBindTextWithChecker(txtDelDDTo, "P_DEL_TO", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateEnd);

    dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtDelDateFrom, "P_DEL_FM", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateBgn);

    dbTxtCreateDateTo  =
        new exgui.DataBindTextWithChecker(txtCreateDDTo, "P_CRT_TO", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtCreateDateTo);

    dbTxtCreateDateFrom =
        new exgui.DataBindTextWithChecker(txtCreateDateFrom, "P_CRT_FM", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtCreateDateFrom);

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
   slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
   slkMaker.init("P_MAKER",null,slkBuyer.TYPE_MAKER,true);
   //dataBindComps.add(slkBuyer);
    doingDB2Gui=false;

    boolean isAllDep=true;
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
         util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
        isAllDep=false;
      }
    if(isAllDep){
      cbxCntr.getItemListeners()[0].itemStateChanged(null);
    }else{
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
       dataBindComps.set(indexCbxDep, dbCbxDep);

    }

   Object chkYear = exgui.verification.CellFormat.getIntVerifierAllowNull(4);
   exgui.DataBindTextWithChecker dbTxtYear =
       new DataBindTextWithChecker(txtYear,
                                   "P_YEAR",
                                   "", 4,
                                   (Object2String)chkYear,
                                   (exgui.ultratable.CellTxtEditorFormat)chkYear);

    dataBindComps.add(dbTxtYear);
  }catch(Exception exp){
    exp.printStackTrace();
  }
}
JTextField txtTwdUsd=new JTextField(),txtRmbUsd=new JTextField(),txtHkdUsd=new JTextField();

public HashMap composeParameters() {
  HashMap hm = super.composeParameters();
  //hm.put(dbCbxDep.getOrgRecField(), "'"+dbCbxDep.getSelectedValue()+"'");
  Object dateBgn = dbTxtDateBgn.getSelectedValue();
  Object dateTo = dbTxtDateEnd.getSelectedValue();
  Object creatFrom=dbTxtCreateDateFrom.getSelectedValue();
  Object creatTo=dbTxtCreateDateTo.getSelectedValue();
  if(null==creatFrom){hm.put(dbTxtCreateDateFrom.getOrgRecField(),"DATE(2000,01,01)");}
  if(null==creatTo){hm.put(dbTxtCreateDateTo.getOrgRecField(),"DATE(2099,12,31)");}

  if (dateTo == null) {
    hm.put("P_DEL_TO", "DATE(2099,12,31)");
  }
  if(dateBgn==null){
    hm.put("P_DEL_FM", "DATE(2004,07,01)");
  }


  Object objBuyer=slkBuyer.getSelectedValue();
  if(objBuyer==null){
    hm.put("P_BUYER", "0");
  }else{
    hm.put("P_BUYER", objBuyer.toString());
  }
  Object objMkr=slkMaker.getSelectedValue();
  if(objMkr==null){
    hm.put("P_MAKER", "0");
  }else{
    hm.put("P_MAKER", objMkr.toString());
  }


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
          "ALL", "NULL");
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
            "ALL", "NULL");
      } else if (depVects.size() > 1) {
        dbCbxDep =
            new exgui.DataBindJCombobox(
            cbxDep, "P_DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            "",
            "ALL", "NULL");
        //guis.add(DbJcbxcbxDep);
      } else {
        dbCbxDep =
            new exgui.DataBindJCombobox(
            cbxDep, "P_DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            "","ALL","NULL");
        //guis.add(DbJcbxcbxDep);
      }
    }
   dataBindComps.set(indexCbxDep,dbCbxDep);
   String centerCode=(String)DbJcbxcbxCntr.getSelectedValue();
   if(centerCode==null)centerCode=util.PublicVariable.OPERATTING_CENTER.toString();
   slkBuyer.setSelectingCenter(centerCode);
   slkMaker.setSelectingCenter(centerCode);
  } catch (Exception exp) {
    exp.printStackTrace();
  }
}
class cbxCenterItemChanged implements java.awt.event.ItemListener {
  public void itemStateChanged(ItemEvent e) {
     reGenDepartment();
  }
}

void btnQry_actionPerformed(ActionEvent e) {
  JButtonQueryButtonAction(e);
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;
  JPanel pnlDELDate = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtDelDDTo = new JTextField();
  JTextField txtDelDateFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel lblBuyer = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel lblYear = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtCreateDDTo = new JTextField();
  JTextField txtCreateDateFrom = new JTextField();
  JLabel jLabel7 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel lblBuyer1 = new JLabel();

}

class PnlShipAmtBySrnSc_btnQry_actionAdapter implements java.awt.event.
  ActionListener {
PnlShipAmtBySrnSc adaptee;

 PnlShipAmtBySrnSc_btnQry_actionAdapter(PnlShipAmtBySrnSc adaptee) {
  this.adaptee = adaptee;
}

 public void actionPerformed(ActionEvent e) {
   adaptee.btnQry_actionPerformed(e);
 }

}
