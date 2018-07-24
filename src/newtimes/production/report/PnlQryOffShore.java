package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.event.*;
import database.datatype.Record;
public class PnlQryOffShore
    extends AbsQryPanel {
    //extends JPanel{
  String mng_valid = "SANDY CHAN,JOHNNY CHANG,SOPHIE CHEN,PATTY HU,LYDIA WANG,AILLEN CHIANG";
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel lblCenter = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JLabel lblCountry = new JLabel();
  JComboBox cbxCountry = new JComboBox();
  JLabel lblType = new JLabel();
  JComboBox cbxProdType = new JComboBox();
  JLabel lblDateEnd = new JLabel();
  JTextField txtDateEnd = new JTextField();
  JButton btnGenReport = new JButton();
  DataBindJCombobox dbCbxCenter,dbCbxCountry,dbCbxProdType,dbCbxExcludeDep,dbCbxDep,dbCbxArea,dbCbxManager;
  DataBindTextWithChecker dbTxtDateEnd;
  DataBindTextWithChecker dbTxtDateBgn;
  boolean isJbinitNow=false;
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JLabel lblXldSC = new JLabel();
  JRadioButton rdoIncludeSC_is_null = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoExcludeScIsNull = new JRadioButton();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxArea = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JComboBox cbxExcludeDep = new JComboBox();
  JLabel jLabel4 = new JLabel();
  JRadioButton rdoDisableScDelDate_Y = new JRadioButton();
  JRadioButton rdoDisableScDelDate_N = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JLabel jLabel5 = new JLabel();
  JComboBox cbxMng = new JComboBox();
  JCheckBox chkCbxKnitWoven = new JCheckBox();
  JCheckBox chkCbxHomeFabric = new JCheckBox();
  int indexCbxMng=0;
  int indexCbxDep=0;
  int indexCbxExcludeDep=0;
  JLabel lblBuyer = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JComboBox cbxWithOffshore = new JComboBox(new String[]{"Yes","No"});
  JLabel lblType1 = new JLabel();
  JCheckBox chkCbxCombineNBdep = new JCheckBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel lblBuyer1 = new JLabel();
  JTextField txtDateBe = new JTextField();
  JLabel lblDateEnd1 = new JLabel();
  JRadioButton rdoIncludeSC_is_all = new JRadioButton();
  JLabel jLabel6 = new JLabel();
  JComboBox ShowSCcbx = new JComboBox();
  JCheckBox jCheckBox1 = new JCheckBox();

  public PnlQryOffShore() {
    try {
      jbInit();
      rdoIncludeSC_is_all.setSelected(true);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    isJbinitNow=true;
    blueBkgWhiteCharLabel1.setText("QUERY FOR 75 DAYS WORK-SHEET BY FTY/DEP/BUYER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 0, 800, 18));
    setBackground(new Color(204, 204, 225));
    this.setLayout(null);
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(9, 25, 82, 21));
    cbxCenter.setBounds(new Rectangle(69, 25, 83, 21));
    cbxCenter.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCenter_itemStateChanged(e);
      }
    });
    lblCountry.setText("COUNTRY");
    lblCountry.setBounds(new Rectangle(4, 67, 78, 22));
    cbxCountry.setBounds(new Rectangle(69, 67, 126, 22));
    cbxCountry.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCountry_itemStateChanged(e);
      }
    });
    lblType.setRequestFocusEnabled(true);
    lblType.setText("TYPE");
    lblType.setBounds(new Rectangle(616, 24, 53, 21));
    cbxProdType.setBounds(new Rectangle(654, 24, 124, 21));
    lblDateEnd.setBounds(new Rectangle(595, 50, 88, 22));
    lblDateEnd.setText("DEL-DD From :");
    txtDateEnd.setBounds(new Rectangle(686, 72, 96, 22));
    txtDateEnd.setText("");
    btnGenReport.setBounds(new Rectangle(696, 141, 88, 26));
    btnGenReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGenReport.setText("REPORT");
    btnGenReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGenReport_actionPerformed(e);
      }
    });
    cbxDep.setBounds(new Rectangle(249, 25, 124, 21));
    cbxDep.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxDep_itemStateChanged(e);
      }
    });
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(204, 25, 51, 21));
    lblXldSC.setBackground(Color.white);
    lblXldSC.setOpaque(true);
    lblXldSC.setToolTipText("");
    lblXldSC.setText(" S/C NO");
    lblXldSC.setBounds(new Rectangle(491, 95, 223, 18));
    rdoIncludeSC_is_null.setBackground(Color.white);
    rdoIncludeSC_is_null.setActionCommand("YES");

    rdoIncludeSC_is_null.setText("Not SPACE");
    rdoIncludeSC_is_null.setBounds(new Rectangle(547, 111, 101, 18));
    rdoExcludeScIsNull.setBounds(new Rectangle(646, 111, 67, 18));
    rdoExcludeScIsNull.setBackground(Color.white);
    rdoExcludeScIsNull.setActionCommand("SPACE");
    rdoExcludeScIsNull.setText("SPACE");
//    rdoExcludeScIsNull.setSelected(true);
    jLabel2.setText("AREA");
    jLabel2.setBounds(new Rectangle(7, 103, 67, 20));
    cbxArea.setBounds(new Rectangle(69, 103, 126, 21));
    jLabel3.setBounds(new Rectangle(393, 24, 93, 21));
    jLabel3.setText("EXCLUDE DEP.");
    cbxExcludeDep.setBounds(new Rectangle(485, 24, 124, 21));
    jLabel4.setBackground(Color.white);
    jLabel4.setOpaque(true);
    jLabel4.setText("DISABLE S/C DEL DATE:");
    jLabel4.setBounds(new Rectangle(491, 128, 165, 18));
    rdoDisableScDelDate_Y.setBackground(Color.white);
    rdoDisableScDelDate_Y.setText("YES");
    rdoDisableScDelDate_Y.setBounds(new Rectangle(491, 144, 58, 20));
    rdoDisableScDelDate_N.setBounds(new Rectangle(549, 144, 107, 20));
    rdoDisableScDelDate_N.setText("NO");
    rdoDisableScDelDate_N.setBackground(Color.white);
    rdoDisableScDelDate_N.setSelected(true);
    jLabel5.setText("MANAGER");
    jLabel5.setBounds(new Rectangle(204, 69, 70, 24));
    cbxMng.setBounds(new Rectangle(266, 67, 121, 22));
    chkCbxKnitWoven.setBackground(new Color(204, 204, 225));
    chkCbxKnitWoven.setFont(new java.awt.Font("Dialog", 1, 11));
    chkCbxKnitWoven.setText("KNIT & WOVEN");
    chkCbxKnitWoven.setBounds(new Rectangle(394, 58, 108, 20));
    chkCbxKnitWoven.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        chkCbxKnitWoven_itemStateChanged(e);
      }
    });
    chkCbxHomeFabric.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        chkCbxKnitWoven_itemStateChanged(e);
      }
    });

    chkCbxHomeFabric.setBackground(new Color(202, 202, 224));
    chkCbxHomeFabric.setFont(new java.awt.Font("Dialog", 1, 11));
    chkCbxHomeFabric.setText("HomeFurnishing & Fabric");
    chkCbxHomeFabric.setBounds(new Rectangle(394, 75, 193, 14));
    lblBuyer.setText("BUYER");
    lblBuyer.setBounds(new Rectangle(8, 139, 56, 23));
    slkBuyer.setBounds(new Rectangle(69, 139, 164, 22));
    cbxWithOffshore.setBounds(new Rectangle(356, 103, 111, 21));
    lblType1.setBounds(new Rectangle(200, 103, 171, 21));
    lblType1.setText("INCLUDE OFFSHORE DATA");
    lblType1.setRequestFocusEnabled(true);
    chkCbxCombineNBdep.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        chkCbxCombineNBdep_itemStateChanged(e);
      }
    });
    chkCbxCombineNBdep.setBounds(new Rectangle(204, 44, 187, 20));
    chkCbxCombineNBdep.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        chkCbxCombineNBdep_stateChanged(e);
      }
    });
    chkCbxCombineNBdep.setText("Combine NB Departments");
    chkCbxCombineNBdep.setFont(new java.awt.Font("Dialog", 1, 11));
    chkCbxCombineNBdep.setBackground(new Color(204, 204, 225));
    lblBuyer1.setBounds(new Rectangle(256, 137, 53, 23));
    lblBuyer1.setText("MAKER");
    slkMaker.setBounds(new Rectangle(311, 139, 164, 22));
    txtDateBe.setText("");
    txtDateBe.setBounds(new Rectangle(686, 49, 96, 22));
    lblDateEnd1.setToolTipText("");
    lblDateEnd1.setText("                  To :");
    lblDateEnd1.setBounds(new Rectangle(594, 72, 88, 22));
    rdoIncludeSC_is_all.setBounds(new Rectangle(491, 111, 58, 18));
    rdoIncludeSC_is_all.setText("ALL");
    rdoIncludeSC_is_all.setActionCommand("ALL");
    rdoIncludeSC_is_all.setSelected(false);
    rdoIncludeSC_is_all.setBackground(Color.white);
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setForeground(Color.black);
    jLabel6.setRequestFocusEnabled(true);
    jLabel6.setText("Show S/C No :");
    jLabel6.setBounds(new Rectangle(491, 169, 87, 21));
    ShowSCcbx.setBounds(new Rectangle(571, 170, 82, 20));
    ShowSCcbx.addItem("YES");
    ShowSCcbx.addItem("NO");
    ShowSCcbx.setSelectedItem("YES");
    jCheckBox1.setText("Exclude This Maker");
    jCheckBox1.setBounds(new Rectangle(314, 164, 159, 20));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCenter, null);
    this.add(lblCenter, null);
    this.add(cbxProdType, null);
    this.add(lblType, null);
    this.add(txtDateEnd, null);
    this.add(lblDateEnd, null);
    this.add(lblCountry, null);
    this.add(cbxCountry, null);
    this.add(jLabel1, null);
    this.add(cbxDep, null);
    this.add(jLabel2, null);
    this.add(btnGenReport, null);
    this.add(rdoIncludeSC_is_null, null);
    this.add(rdoExcludeScIsNull, null);
    this.add(cbxCenter, null);
    this.add(cbxDep, null);
    this.add(cbxProdType, null);
    this.add(cbxExcludeDep, null);
    this.add(jLabel3, null);
    this.add(lblType, null);
    this.add(jLabel1, null);
    this.add(lblCenter, null);
    this.add(lblCountry, null);
    this.add(cbxCountry, null);
    this.add(lblDateEnd, null);
    this.add(txtDateEnd, null);
    this.add(cbxArea, null);
    this.add(jLabel2, null);
    this.add(lblXldSC, null);
    this.add(rdoIncludeSC_is_null, null);
    this.add(rdoExcludeScIsNull, null);
    this.add(btnGenReport, null);



    genDataBindObj();
    buttonGroup1.add(rdoExcludeScIsNull);
    buttonGroup1.add(rdoIncludeSC_is_null);
    buttonGroup1.add(rdoIncludeSC_is_all);
    this.add(btnGenReport, null);
    this.add(jLabel2, null);
    this.add(cbxArea, null);
    this.add(rdoIncludeSC_is_null, null);
    this.add(lblXldSC, null);
    this.add(rdoExcludeScIsNull, null);
    this.add(jLabel4, null);
    this.add(rdoDisableScDelDate_Y, null);
    this.add(rdoDisableScDelDate_N, null);
    buttonGroup2.add(rdoDisableScDelDate_Y);
    buttonGroup2.add(rdoDisableScDelDate_N);
    this.add(chkCbxHomeFabric, null);
    this.add(slkBuyer, null);
    this.add(lblDateEnd1, null);


  }
  protected void genDataBindObj(){
    try{
    dataBindComps.clear();

     //default date of begin date is mid of previous month,
     java.sql.Date bgnDate =java.sql.Date.valueOf("2000-01-01");
     //default date of end date is max day of next month
    java.sql.Date nowDate=new java.sql.Date(System.currentTimeMillis());
    /*
    java.util.Calendar cdlNext=java.util.Calendar.getInstance();
    cdlNext.add(cdlNext.MONTH,1);//set to next date
    int maxOfMonth=cdlNext.getMaximum(cdlNext.DAY_OF_MONTH);
    cdlNext.set(cdlNext.DATE,maxOfMonth);
    java.sql.Date endDate=new java.sql.Date(cdlNext.getTimeInMillis()); //new java.sql.Date(time4EndOfNextMonth);//find out the max days of next month
    */
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormater();

    dbTxtDateBgn =
        new  exgui.DataBindTextWithChecker(txtDateBe,"P_DEL_BG",bgnDate,
        10,(exgui.Object2String)dateVfy,
         (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateBgn);

    dbTxtDateEnd =
        new  exgui.DataBindTextWithChecker(txtDateEnd,"DATE_EN",nowDate,
        10,(exgui.Object2String)dateVfy,
         (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateEnd);

    dbCbxCountry =
        new exgui.DataBindJCombobox(
          cbxCountry ,"COUNTRY",
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME","CNTY_NAME","ALL","ALL","ALL");
    dataBindComps.add(dbCbxCountry);

    Vector mng_show = getValidMng();

/*
    dbCbxManager =
        new exgui.DataBindJCombobox(
          cbxMng ,"MANAGER",
          newtimes.preproduction.guis.tempProperties.tmpManagerRecs,
          "MNG_ABBR","MNG_ABBR","ALL","ALL","ALL");
 */
    dbCbxManager =
        new exgui.DataBindJCombobox(
          cbxMng ,"MANAGER",
          mng_show,
          "MNG_ABBR","MNG_ABBR","ALL","ALL","ALL");

    indexCbxMng=dataBindComps.size();


    dataBindComps.add(dbCbxManager);


    dbCbxProdType =
        new exgui.DataBindJCombobox(
          cbxProdType,"TYPE",
          newtimes.preproduction.guis.tempProperties.tmpProdType,
          "TYPE_NAME","TYPE_CODE","W");
    dataBindComps.add(dbCbxProdType);

     dbCbxCenter =
          new exgui.DataBindJCombobox(
          cbxCenter, "CENTER",
         newtimes.preproduction.guis.tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
     dataBindComps.add(dbCbxCenter);

     Vector depVects=
         (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
         dbCbxCenter.getSelectedValue());
        boolean haveAllDep=true;
        if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
         util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
         haveAllDep=false;
        }
        dbCbxDep =
            (haveAllDep)?
           new exgui.DataBindJCombobox(
           cbxDep, "DEP",
           depVects,
           "DEP_NAME", "DEP_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_Dep_code"),
           "ALL", "ALL"):
            new exgui.DataBindJCombobox(
            cbxDep, "DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_Dep_code"));

        indexCbxDep=dataBindComps.size();
        dataBindComps.add(dbCbxDep);

        dbCbxExcludeDep =
           new exgui.DataBindJCombobox(
           cbxExcludeDep, "EXC_DEP",
           depVects,
           "DEP_NAME", "DEP_CODE",null
           ,"NONE","NONE");
            indexCbxExcludeDep=dataBindComps.size();
            dataBindComps.add(dbCbxExcludeDep);

      this.add(lblCenter, null);
      this.add(cbxCenter, null);
      this.add(jLabel1, null);
      this.add(cbxDep, null);
      this.add(jLabel3, null);
      this.add(cbxExcludeDep, null);
      this.add(lblType, null);
      this.add(cbxProdType, null);
      this.add(jLabel2, null);
      this.add(lblCenter, null);
      this.add(cbxCenter, null);
      this.add(jLabel1, null);
      this.add(cbxDep, null);
      this.add(jLabel3, null);
      this.add(cbxExcludeDep, null);
      this.add(lblType, null);
      this.add(cbxProdType, null);
      this.add(lblCountry, null);
      this.add(cbxCountry, null);
      this.add(lblDateEnd, null);
      this.add(txtDateEnd, null);
      this.add(cbxArea, null);
      this.add(lblXldSC, null);
      this.add(rdoIncludeSC_is_null, null);
      this.add(rdoExcludeScIsNull, null);
      this.add(btnGenReport, null);
      this.add(btnGenReport, null);
      this.add(lblCountry, null);
      this.add(jLabel2, null);
      this.add(jLabel4, null);
      this.add(jLabel4, null);
      this.add(rdoDisableScDelDate_Y, null);
      this.add(rdoDisableScDelDate_N, null);
      this.add(txtDateEnd, null);
      this.add(lblCountry, null);
      this.add(cbxCountry, null);
      this.add(cbxArea, null);
      this.add(lblDateEnd, null);
      this.add(cbxCenter, null);
      this.add(lblCenter, null);
      this.add(jLabel3, null);
      this.add(lblType, null);
      this.add(cbxProdType, null);
      this.add(cbxExcludeDep, null);
      this.add(jLabel1, null);
      this.add(cbxDep, null);
      this.add(jLabel2, null);
      this.add(cbxArea, null);
      this.add(lblBuyer, null);
      this.add(txtDateEnd, null);
      this.add(lblCountry, null);
      this.add(cbxCountry, null);
      this.add(cbxMng, null);
      this.add(chkCbxHomeFabric, null);
      this.add(lblDateEnd, null);
      this.add(jLabel2, null);
      this.add(cbxArea, null);
      this.add(chkCbxKnitWoven, null);
      this.add(lblType1, null);
      this.add(cbxWithOffshore, null);
      this.add(rdoIncludeSC_is_null, null);
      this.add(lblXldSC, null);
      this.add(rdoExcludeScIsNull, null);
      this.add(btnGenReport, null);
      this.add(lblBuyer1, null);
      this.add(slkMaker, null);
      this.add(lblDateEnd, null);
      this.add(txtDateEnd, null);
      this.add(cbxExcludeDep, null);
      this.add(lblCenter, null);
      this.add(cbxCenter, null);
      this.add(jLabel1, null);
      this.add(cbxDep, null);
      this.add(jLabel3, null);
      this.add(lblType, null);
      this.add(cbxProdType, null);
      this.add(jLabel5, null);
      this.add(chkCbxCombineNBdep, null);
      this.add(txtDateEnd, null);
      this.add(txtDateBe, null);
      this.add(jLabel6, null);
      this.add(rdoIncludeSC_is_all, null);
      this.add(ShowSCcbx, null);
      this.add(jCheckBox1, null);
      this.add(rdoExcludeScIsNull, null);
      this.add(rdoDisableScDelDate_N, null);
      this.add(rdoDisableScDelDate_Y, null);
      this.add(rdoIncludeSC_is_null, null);
      this.add(rdoExcludeScIsNull, null);
      this.add(lblDateEnd1, null);
      this.add(txtDateEnd, null);
      this.add(lblDateEnd, null);
      this.add(chkCbxHomeFabric, null);
      this.add(lblDateEnd, null);
      this.add(txtDateEnd, null);
      this.add(lblDateEnd, null);
      this.add(txtDateEnd, null);
      this.add(slkBuyer, null);
      slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
      slkMaker.init("", null, slkMaker.TYPE_MAKER, true);
     reportName ="QC_OFS.rpt";
     isJbinitNow=false;
     if(haveAllDep) cbxCenter_itemStateChanged(null);
      //cbxDep_itemStateChanged(null);
     cbxCountry_itemStateChanged(null);



    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm= super.composeParameters();
    //middle date is 1st day of middle date between bgn & end date.
    //find out the last month,previous mounth,,-3 month 01,
    java.util.Calendar cldPreMonth=java.util.Calendar.getInstance();
    cldPreMonth.setTime((java.util.Date)dbTxtDateEnd.getSelectedValue());
    cldPreMonth.add(cldPreMonth.MONTH,-1);
    cldPreMonth.set(cldPreMonth.DATE,1);
    java.sql.Date MdL2_DATE=new java.sql.Date(cldPreMonth.getTimeInMillis());
    hm.put("DATE_MDL2",super.convertDate2QueryPara(MdL2_DATE));

    cldPreMonth.add(cldPreMonth.MONTH,-1);
    java.sql.Date MdL_DATE=new java.sql.Date(cldPreMonth.getTimeInMillis());
    hm.put("DATE_MDL",super.convertDate2QueryPara(MdL_DATE));

    cldPreMonth.add(cldPreMonth.MONTH,-1);
    java.sql.Date BE_DATE=new java.sql.Date(cldPreMonth.getTimeInMillis());
    hm.put("DATE_BE",super.convertDate2QueryPara(BE_DATE));


    if(rdoIncludeSC_is_null.isSelected()){
      hm.put("SC_NO","Y");
    } else if (rdoIncludeSC_is_all.isSelected()) {
       hm.put("SC_NO","A");
    }
    else{
      hm.put("SC_NO","N");
    }
    if (ShowSCcbx.getSelectedItem() == "YES" ) {
         hm.put("P_SHOW_SC","Y");
    } else {
         hm.put("P_SHOW_SC","N");
    };

    if(dbCbxArea.getSelectedValue()==null){
      hm.put("ARR","0");
    }else{
      hm.put("ARR",dbCbxArea.getSelectedValue().toString());
    }
    if(rdoDisableScDelDate_Y.isSelected()){
      hm.put("SHOW_SC_DEL","Y");
    }else{
      hm.put("SHOW_SC_DEL","N");
    }
    if(chkCbxKnitWoven.isSelected()){
      hm.put("KNIT_WOVEN","Y");
      hm.put("TYPE","ALL");
    }else{
      hm.put("KNIT_WOVEN","N");
    }
    if(chkCbxHomeFabric.isSelected()){
      hm.put("HOME_FABRIC","Y");
      hm.put("TYPE","ALL");
    }else{
      hm.put("HOME_FABRIC","N");
    }
    if(slkBuyer.getSelectedValue()==null){
      hm.put("P_BUYER","0");
    }else{
      hm.put("P_BUYER",slkBuyer.getSelectedValue().toString());
    }
    if(slkMaker.getSelectedValue()==null){
      hm.put("P_MAKER","0");
    }else{
      hm.put("P_MAKER",slkMaker.getSelectedValue().toString());
    }

    hm.put("P_OFS",cbxWithOffshore.getSelectedItem().toString().substring(0,1));
    hm.put("P_COMBINED_NB",chkCbxCombineNBdep.isSelected()?"Y":"N");
     if (jCheckBox1.isSelected() ) {
       hm.put("P_EXCLUDE","1");
     } else {
        hm.put("P_EXCLUDE","0");
     }
    return hm;
  }
  void btnGenReport_actionPerformed(ActionEvent e) {
     //check if any field is empty,End date can not before than Begin date.
     JButtonQueryButtonAction(e);
  }
  protected void reGenMangers(){
    if (isJbinitNow)return;
    Vector vctMng= getValidMng();
/*   Vector vctMng= (Vector)newtimes.preproduction.guis.tempProperties.tmpHm_Managers4AllCenters.get(
        dbCbxCenter.getSelectedValue());
    if(vctMng==null){
    	vctMng=newtimes.preproduction.guis.tempProperties.tmpManagerRecs;
    } */
    dbCbxManager =
        new exgui.DataBindJCombobox(
          cbxMng ,"MANAGER",vctMng,
          "MNG_ABBR","MNG_ABBR","ALL","ALL","ALL");

    dataBindComps.set(indexCbxMng,dbCbxManager);
  }

  void cbxCountry_itemStateChanged(ItemEvent e) {
    if(isJbinitNow)return;

    Object countryObj = dbCbxCountry.getSelectedValue();
    Vector areaVects=null;
    try {
      if (countryObj.toString().toString().equalsIgnoreCase("ALL")) {
        areaVects = new Vector();
      }else{
        StringBuffer sb=new StringBuffer();
        sb.append("select * from world_area a where a.AREA_PK in ");
        sb.append("(select c.CITY_AREA_PK from city c where c.CITY_CNTY_NAME ='");
        sb.append(util.MiscFunc.Replace(countryObj.toString(),"'","''"));
        sb.append("' and c.record_delete_flag=1) and a.record_delete_flag=1");
        areaVects = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sb.toString(), 1, 9999);
      }
      dbCbxArea =
          new exgui.DataBindJCombobox(
          cbxArea, "ARR",
          areaVects,
          "AREA_NAME", "AREA_PK",
          null,
          "ALL", null);

  }catch(Exception exp){
      exp.printStackTrace();

  }

}

  void cbxDep_itemStateChanged(ItemEvent e) {
    if(isJbinitNow)return;
    if(dbCbxDep.getSelectedValue().equals("ALL")){
      cbxExcludeDep.setEnabled(true);
      cbxExcludeDep.setSelectedIndex(0);
    }else{
      cbxExcludeDep.setSelectedIndex(0);
      cbxExcludeDep.setEnabled(false);
    }
  }

  void chkCbxKnitWoven_itemStateChanged(ItemEvent e) {
    if(chkCbxKnitWoven.isSelected()||chkCbxHomeFabric.isSelected()){
      cbxProdType.setEnabled(false);
    }else{
      cbxProdType.setEnabled(true);
    }
  }

  void cbxCenter_itemStateChanged(ItemEvent e) {
    if(isJbinitNow)return;
    Vector depVects=
        (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
        dbCbxCenter.getSelectedValue());

    dbCbxDep =
       new exgui.DataBindJCombobox(
       cbxDep, "DEP",
       depVects,
       "DEP_NAME", "DEP_CODE",
       null,
       "ALL", "ALL");
    dataBindComps.set(indexCbxDep,dbCbxDep);

    dbCbxExcludeDep =
       new exgui.DataBindJCombobox(
       cbxExcludeDep, "EXC_DEP",
       depVects,
       "DEP_NAME", "DEP_CODE",null
       ,"NONE","NONE");
    dataBindComps.set(indexCbxExcludeDep,dbCbxExcludeDep);


    slkBuyer.setSelectingCenter((String)dbCbxCenter.getSelectedValue());
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("", null, slkMaker.TYPE_MAKER, true);
    cbxDep_itemStateChanged(null);
    reGenMangers();
  }
  void chkCbxCombineNBdep_itemStateChanged(ItemEvent e) {
    if(chkCbxCombineNBdep.isSelected()){
      cbxDep.setEnabled(false);
    }else{
      cbxDep.setEnabled(true);
    }
  }

  void chkCbxCombineNBdep_stateChanged(ChangeEvent e) {

  }
  Vector getValidMng() {
    Vector mng_show = new Vector();
    try {
      for (int i = 0;
           i < newtimes.preproduction.guis.tempProperties.tmpManagerRecs.size();
           i++) {
        Record mng_rec = (Record)newtimes.preproduction.guis.tempProperties.
            tmpManagerRecs.get(i);
        if (mng_valid.indexOf(mng_rec.get("MNG_ABBR").toString()) >= 0) {
          mng_show.add(mng_rec);
        }
      }
      return mng_show;
    }

    catch(Exception e) {
        return null;
    }
  }
}
