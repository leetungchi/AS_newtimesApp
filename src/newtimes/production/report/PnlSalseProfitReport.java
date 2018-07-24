package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlSalseProfitReport
    extends  AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtYearMonthFrom = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtYearMonthTo = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtThisMonthTo = new JTextField();
  JTextField txtThisMonthFrom = new JTextField();
  JLabel jLabel4 = new JLabel();
  JPanel pnlDeps = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JComboBox cbxDep[] = new JComboBox[14];
  JLabel jLabel5 = new JLabel();
  JComboBox cbxManager = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JTextField txtHeadDiv = new JTextField();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoByBuyer = new JRadioButton();
  JRadioButton rdoByDepartment = new JRadioButton();
  JLabel jLabel7 = new JLabel();
  JButton btnQry = new JButton();
  JComboBox   cbxCenter=new JComboBox();
  JTextField txtTwdUsd=new JTextField();
  JTextField txtRmbUsd=new JTextField();
  JTextField txtHkdUsd=new JTextField();
  protected   DataBindJCombobox dbCbxCenter,dbCbxDep[],dbCbxManager,dbCbxProdType ;
  protected   DataBindTextWithChecker dbTxtEtdFrm,dbTxtEtdTo,dbTxtCurrFrm,dbTxtCurrTo,dbTwdChg,dbRmbChg,dbHkdChg;
  static int itemCount=14;
  JLabel jLabel8 = new JLabel();
  JComboBox cbxProdType = new JComboBox();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel9 = new JLabel();
  int indexCbxMng=0;
  JLabel jLabel10 = new JLabel();
  JComboBox cbxCnyBlk = new JComboBox(new String[]{"N","Y"});
  JLabel lblCbmD = new JLabel();
  JComboBox cbxCbmD = new JComboBox(new String[]{"NO","YES"});
  public PnlSalseProfitReport() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<itemCount;i++){
      cbxDep[i]=new JComboBox();
    }
    dbCbxDep=new exgui.DataBindJCombobox[itemCount];
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157));
    titledBorder1 = new TitledBorder(border1,"DEP.");
    blueBkgWhiteCharLabel1.setText("SALES PROFIT REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 6, 803, 25));
    this.setLayout(null);
    jLabel1.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel1.setText("YEAR TO MONTH OBD FROM");
    jLabel1.setBounds(new Rectangle(6, 41, 182, 20));
    txtYearMonthFrom.setText("");
    txtYearMonthFrom.setBounds(new Rectangle(188, 40, 76, 20));
    this.setBackground(new Color(202, 202, 225));
    jLabel2.setText("TO");
    jLabel2.setBounds(new Rectangle(272, 40, 33, 20));
    txtYearMonthTo.setBounds(new Rectangle(305, 40, 70, 20));
    txtYearMonthTo.setText("");
    jLabel3.setBounds(new Rectangle(271, 68, 33, 20));
    jLabel3.setText("TO");
    txtThisMonthTo.setText("");
    txtThisMonthTo.setBounds(new Rectangle(305, 67, 70, 20));
    txtThisMonthFrom.setBounds(new Rectangle(188, 67, 76, 20));
    txtThisMonthFrom.setText("");
    jLabel4.setBounds(new Rectangle(32, 65, 153, 20));
    jLabel4.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel4.setText("THIS MONTH OBD FROM");
    pnlDeps.setBackground(new Color(202, 202, 225));
    pnlDeps.setBorder(titledBorder1);
    pnlDeps.setBounds(new Rectangle(383, 38, 309, 175));
    java.awt.LayoutManager grdLayout=new java.awt.GridLayout(7,2);
    pnlDeps.setLayout(grdLayout);
    /*
    cbxDep[0].setBounds(new Rectangle(11, 18, 136, 24));
    cbxDep[1].setBounds(new Rectangle(167, 18, 136, 24));
    cbxDep[2].setBounds(new Rectangle(11, 50, 136, 24));
    cbxDep[3].setBounds(new Rectangle(166, 50, 136, 24));
    cbxDep[4].setBounds(new Rectangle(11, 82, 136, 24));
    cbxDep[9].setBounds(new Rectangle(164, 145, 136, 24));
    cbxDep[7].setBounds(new Rectangle(166, 113, 136, 24));
    cbxDep[8].setBounds(new Rectangle(11, 145, 136, 24));
    cbxDep[6].setBounds(new Rectangle(11, 113, 136, 24));
    cbxDep[5].setBounds(new Rectangle(166, 82, 136, 24));
    */
    jLabel5.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel5.setText("MANAGER");
    jLabel5.setBounds(new Rectangle(-4, 91, 72, 22));
    cbxManager.setBounds(new Rectangle(69, 92, 148, 23));
    jLabel6.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel6.setText("HEAD DIV");
    jLabel6.setBounds(new Rectangle(-24, 136, 87, 21));
    txtHeadDiv.setText("¦¨¦ç²Õ");
    txtHeadDiv.setBounds(new Rectangle(68, 136, 94, 25));
    rdoByBuyer.setBackground(new Color(202, 202, 225));
    rdoByBuyer.setSelected(true);
    rdoByBuyer.setText("BUYER");
    rdoByBuyer.setBounds(new Rectangle(45, 165, 77, 25));
    rdoByDepartment.setBounds(new Rectangle(45, 186, 107, 25));
    rdoByDepartment.setText("DEPARTMENT");
    rdoByDepartment.setBackground(new Color(202, 202, 225));
    rdoByDepartment.setSelected(true);
    jLabel7.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel7.setText("BY");
    jLabel7.setBounds(new Rectangle(4, 171, 33, 22));
    btnQry.setBounds(new Rectangle(698, 179, 92, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel8.setText("TYPE:");
    jLabel8.setBounds(new Rectangle(204, 162, 42, 21));
    cbxProdType.setBounds(new Rectangle(241, 162, 133, 25));
    slkBuyer.setBounds(new Rectangle(209, 190, 166, 22));
    jLabel9.setText("BUYER");
    jLabel9.setBounds(new Rectangle(154, 189, 57, 21));
    jLabel10.setText("<html><body>COUNTRY<br> BLOCK:</body></html>");
    jLabel10.setBounds(new Rectangle(258, 92, 61, 36));
    cbxCnyBlk.setBounds(new Rectangle(316, 94, 64, 20));
    lblCbmD.setText("COMBIN-D");
    lblCbmD.setBounds(new Rectangle(175, 133, 64, 23));
    cbxCbmD.setBounds(new Rectangle(239, 135, 134, 21));
    this.add(blueBkgWhiteCharLabel1, null);
    for(int i=0;i<itemCount;i++)pnlDeps.add(cbxDep[i], null);
    /*
    pnlDeps.add(cbxDep[0], null);
    pnlDeps.add(cbxDep[1], null);
    pnlDeps.add(cbxDep[2], null);
    pnlDeps.add(cbxDep[3], null);
    pnlDeps.add(cbxDep[4], null);
    pnlDeps.add(cbxDep[5], null);
    pnlDeps.add(cbxDep[6], null);
    pnlDeps.add(cbxDep[7], null);
    pnlDeps.add(cbxDep[8], null);
    pnlDeps.add(cbxDep[9], null);
    */
    buttonGroup1.add(rdoByBuyer);
    this.add(pnlDeps, null);
    buttonGroup1.add(rdoByDepartment);
    this.add(btnQry, null);
    this.add(jLabel1, null);
    this.add(jLabel4, null);
    this.add(txtYearMonthFrom, null);
    this.add(txtThisMonthFrom, null);
    this.add(jLabel3, null);
    this.add(jLabel2, null);
    this.add(txtYearMonthTo, null);
    this.add(txtThisMonthTo, null);
    this.add(jLabel9, null);
    this.add(slkBuyer, null);
    this.add(jLabel7, null);
    this.add(rdoByBuyer, null);
    this.add(rdoByDepartment, null);
    this.add(cbxManager, null);
    this.add(jLabel5, null);
    this.add(txtHeadDiv, null);
    this.add(jLabel6, null);
    this.add(jLabel8, null);
    this.add(cbxProdType, null);
    this.add(lblCbmD, null);
    this.add(cbxCbmD, null);
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    genDataBindObj();
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


      //mng_code,MNG_ABBR
      dbCbxManager =
          new exgui.DataBindJCombobox(
          cbxManager, "P_MANAGER",
          newtimes.preproduction.guis.tempProperties.tmpManagerRecs,
          "MNG_ABBR", "MNG_CODE", "ALL", "ALL", null);
      indexCbxMng=dataBindComps.size();
      dataBindComps.add(dbCbxManager);


      dbCbxProdType =
          new exgui.DataBindJCombobox(
          cbxProdType, "P_TYPE",
          newtimes.preproduction.guis.tempProperties.tmpProdType,
          "TYPE_NAME", "TYPE_CODE", "ALL", "ALL", null);
      dataBindComps.add(dbCbxProdType);


      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(dbCbxCenter);
     /*
      java.util.Vector depVects=
          (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
          dbCbxCenter.getSelectedValue());
      for(int i=0;i<itemCount;i++){
         dbCbxDep[i] =
            new exgui.DataBindJCombobox(
            cbxDep[i], "DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            null,
            " ", null);
      }*/


     Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
     Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD, "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1", 1, 1);
     database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
     dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbTwdChg);
     dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbRmbChg);
     dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbHkdChg);
      this.add(cbxCnyBlk, null);
      this.add(jLabel7, null);
      this.add(rdoByBuyer, null);
      this.add(rdoByDepartment, null);
      this.add(jLabel9, null);
      this.add(slkBuyer, null);
      this.add(jLabel6, null);
      this.add(txtHeadDiv, null);
      this.add(jLabel8, null);
      this.add(cbxProdType, null);
      this.add(jLabel10, null);
      this.add(jLabel9, null);
      this.add(jLabel9, null);
      this.add(slkBuyer, null);
      this.add(jLabel8, null);
      this.add(cbxProdType, null);
      this.add(lblCbmD, null);
      this.add(cbxCbmD, null);
      reportName ="profit_month.rpt";

      cbxCenter.addItemListener(new cbxCenterItemChanged());
      cbxCenter.getItemListeners()[0].itemStateChanged(null);
    }catch(Exception exp){
        exp.printStackTrace();
    }
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener {
    public void itemStateChanged(ItemEvent e) {
       udpateDepComboBox();
    }
  }
  protected void reGenMangers(){
    Vector vctMng=
        (Vector)newtimes.preproduction.guis.tempProperties.tmpHm_Managers4AllCenters.get(
        dbCbxCenter.getSelectedValue());
    if(vctMng==null)vctMng=new Vector();
    dbCbxManager =
        new exgui.DataBindJCombobox(
        cbxManager, "P_MANAGER",
        vctMng,
        "MNG_ABBR", "MNG_CODE", "ALL", "ALL", null);
    dataBindComps.set(indexCbxMng ,dbCbxManager);
  }

  protected void udpateDepComboBox(){
    Vector depVects=
        (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
        dbCbxCenter.getSelectedValue());
   reGenMangers();
    for(int i=0;i<itemCount;i++){
      dbCbxDep[i] =
          new exgui.DataBindJCombobox(
          cbxDep[i], "DEP",
          depVects,
          "DEP_NAME", "DEP_CODE",
          null,
          "ALL", null);
      //dataBindComps.add(dbCbxDep[i]);
    }
    String usingCenterCode=(String)dbCbxCenter.getSelectedValue();
     if(usingCenterCode==null || usingCenterCode.trim().length()==0)usingCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;
    slkBuyer.setSelectingCenter(usingCenterCode);

  }
  protected HashMap composeParameters(){
    HashMap hm=super.composeParameters();
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
    hm.put("SUB_HEAD","'"+txtHeadDiv.getText().trim()+"'");
    if(rdoByBuyer.isSelected()){
      hm.put("BUYER_DEP","'BUYER'");
    }else{
      hm.put("BUYER_DEP","'DEP'");
    }
    Object objBuyer=slkBuyer.getSelectedValue();
    if(objBuyer==null){
      hm.put("P_BUYER","ALL");
    }else{
     hm.put("P_BUYER",
            util.MiscFunc.Replace(((javax.swing.JTextField)slkBuyer.getGUIcomponent()).getText(),"'","''''")
            );
    }
    hm.put("CNY_BLK",cbxCnyBlk.getSelectedItem());
    hm.put("D_COMB",(cbxCbmD.getSelectedItem().equals("YES"))?"Y":"N");
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(null);
  }
}
