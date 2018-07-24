package newtimes.accounting;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
import java.awt.event.*;
import BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB;
import database.datatype.Record;
import exgui.BlueBkgWhiteCharLabel;
import exgui.DataBindTextWithChecker;
import exgui.Object2String;
import exgui.ultratable.CellTxtEditorFormat;
import exgui.verification.CellFormat;
import exgui2.CONST;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlProfitShareList
    //extends JPanel {
    extends newtimes.production.report.AbsQryPanel{
 protected int itemCount=14;
 protected BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
 protected   JLabel lblCountry = new JLabel();
 protected   JComboBox cbxCenter = new JComboBox();
 protected   JLabel lblCenter = new JLabel();
 protected   JComboBox cbxCountry = new JComboBox();
  protected  JPanel pnlDeps = new JPanel();
 protected   TitledBorder titledBorder1;

  protected  JPanel pnlBuyers = new JPanel();
 protected   TitledBorder titledBorder2;
 protected   JPanel pnlMakers = new JPanel();

 protected   JComboBox cbxDep[]=null;
 protected   SelectBuyerMaker buyers[]=null;
 protected   SelectBuyerMaker makers[]=null;

 protected   Border border1;
 protected   TitledBorder titledBorder3;
 protected   JLabel lblDDFrom = new JLabel();
 protected   JTextField txtDelFrom = new JTextField();
 protected   JLabel lblYear2 = new JLabel();
 protected   JTextField txtDelTo = new JTextField();
 protected   JButton btnQry = new JButton();
 protected   JTextField txtTwdUsd=new JTextField();
 protected   JTextField txtHkdUsd=new JTextField();
 protected   JTextField txtRmbUsd=new JTextField();
 protected   DataBindJCombobox dbCbxCenter,dbCbxCountry,dbCbxDep[],dbCbxSzn,dbCbxProdType,dbCbxDivision,dbCbxMng;
 protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTwdChg,dbHkdChg,dbRmbChg;
 /*
 SelectBuyerMaker buyers0=new SelectBuyerMaker();
 SelectBuyerMaker buyers1=new SelectBuyerMaker();
 SelectBuyerMaker buyers2=new SelectBuyerMaker();

 SelectBuyerMaker makers0=new SelectBuyerMaker();
 SelectBuyerMaker makers1=new SelectBuyerMaker();
 SelectBuyerMaker makers2=new SelectBuyerMaker();

JComboBox cbxDep0=new JComboBox();
JComboBox cbxDep1=new JComboBox();
JComboBox cbxDep2=new JComboBox();
JComboBox cbxDep3=new JComboBox();
JComboBox cbxDep4=new JComboBox();
JComboBox cbxDep5=new JComboBox();
JComboBox cbxDep6=new JComboBox();
JComboBox cbxDep7=new JComboBox();
JComboBox cbxDep8=new JComboBox();
JComboBox cbxDep9=new JComboBox();
*/

 int indexOfMng=0;
 static public boolean IS_WITH_RCV_AMT;
  public PnlProfitShareList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {

      buyers=new SelectBuyerMaker[3];
      makers=new SelectBuyerMaker[3];
      cbxDep=new JComboBox[itemCount];
      dbCbxDep=new exgui.DataBindJCombobox[itemCount];

    for(int i=0;i<itemCount;i++){
      cbxDep[i]=new JComboBox();
    }
    for( int i=0;i<3;i++){
      buyers[i]=new SelectBuyerMaker();
      buyers[i].init("",null,buyers[0].TYPE_BUYER,true);
      makers[i]=new SelectBuyerMaker();
      makers[i].init("",null,makers[0].TYPE_MAKER,true);
    }

    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157)),"DEPARTMENTS");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"MAKERS");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157));
    titledBorder3 = new TitledBorder(border1,"BUYERS");
    setBackground(new Color(204, 204, 225));
    if(IS_WITH_RCV_AMT){
      blueBkgWhiteCharLabel1.setText("PROFIT SHARE LIST WITH RCV AMOUNT");
    }else{
      blueBkgWhiteCharLabel1.setText("PROFIT SHARE LIST");
    }
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 3, 800, 25));
    this.setLayout(null);
    lblCountry.setText("COUNTRY");
    lblCountry.setBounds(new Rectangle(268, 30, 78, 17));
    cbxCenter.setBounds(new Rectangle(116, 30, 126, 22));
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(33, 30, 82, 19));
    cbxCountry.setBounds(new Rectangle(343, 30, 124, 20));
    pnlDeps.setBackground(new Color(204, 204, 225));
    pnlDeps.setBorder(titledBorder1);
    pnlDeps.setBounds(new Rectangle(15, 55, 323, 215));
    /*
    pnlDeps.setLayout(null);
    cbxDep[5].setBounds(new Rectangle(12, 156, 126, 22));
    cbxDep[4].setBounds(new Rectangle(12, 129, 126, 22));
    cbxDep[3].setBounds(new Rectangle(12, 102, 126, 22));
    cbxDep[2].setBounds(new Rectangle(12, 75, 126, 22));
    cbxDep[1].setBounds(new Rectangle(12, 48, 126, 22));
    cbxDep[0].setBounds(new Rectangle(12, 21, 126, 22));
    */
    pnlBuyers.setBackground(new Color(204, 204, 225));
    pnlBuyers.setBorder(titledBorder3);
    pnlBuyers.setBounds(new Rectangle(347, 59, 175, 103));
    pnlBuyers.setLayout(null);
   /*
   buyers0.setBounds(new Rectangle(6, 17, 160, 18));
   buyers1.setBounds(new Rectangle(6, 48, 160, 18));
   buyers2.setBounds(new Rectangle(6, 79, 160, 18));
   */
   buyers[0].setBounds(new Rectangle(6, 17, 160, 18));
   buyers[1].setBounds(new Rectangle(6, 48, 160, 18));
   buyers[2].setBounds(new Rectangle(6, 79, 160, 18));

    /*
   makers0.setBounds(new Rectangle(6, 17, 160, 24));
   makers1.setBounds(new Rectangle(6, 49, 160, 18));
   makers2.setBounds(new Rectangle(6, 75, 160, 23));
   */
   makers[0].setBounds(new Rectangle(6, 17, 160, 24));
   makers[1].setBounds(new Rectangle(6, 49, 160, 18));
   makers[2].setBounds(new Rectangle(6, 75, 160, 23));


    pnlMakers.setLayout(null);
    pnlMakers.setBounds(new Rectangle(347, 166, 175, 103));
    pnlMakers.setBorder(titledBorder2);
    pnlMakers.setBackground(new Color(204, 204, 225));

    lblDDFrom.setBounds(new Rectangle(568, 91, 85, 21));
    lblDDFrom.setText("O.B.D FROM:");
    txtDelFrom.setBounds(new Rectangle(648, 94, 71, 21));
    txtDelFrom.setText("");
    lblYear2.setBounds(new Rectangle(606, 121, 37, 20));
    lblYear2.setText("TO:");
    txtDelTo.setBounds(new Rectangle(648, 118, 71, 21));
    txtDelTo.setText("");
    btnQry.setBounds(new Rectangle(558, 226, 91, 30));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    lblUnship.setBounds(new Rectangle(536, 109, 224, 28));
    lblUnship.setText("UNSHIP:");
    lblReportType.setText("REPORT TYPE :");
    lblReportType.setBounds(new Rectangle(546, 138, 124, 19));
    cbxReportType.setBounds(new Rectangle(563, 157, 188, 22));
    lblCountry1.setBounds(new Rectangle(537, 33, 78, 17));
    lblCountry1.setText("Manager");
    cbxMng.setBounds(new Rectangle(623, 34, 158, 20));
    jLabel1.setText("Offshore Center");
    jLabel1.setBounds(new Rectangle(533, 60, 93, 23));
    cbxOffCenter.setBounds(new Rectangle(623, 65, 158, 20));

    pnlDeps.setLayout(new java.awt.GridLayout(7,2));
    for(int i=0;i<itemCount;i++){
      pnlDeps.add(cbxDep[i]);
    }

    /*
    pnlDeps.add(cbxDep0, null);
    pnlDeps.add(cbxDep1, null);
    pnlDeps.add(cbxDep2, null);
    pnlDeps.add(cbxDep3, null);
    pnlDeps.add(cbxDep4, null);
    pnlDeps.add(cbxDep5, null);
    pnlDeps.add(cbxDep6, null);
    pnlDeps.add(cbxDep7, null);
    pnlDeps.add(cbxDep8, null);
    pnlDeps.add(cbxDep9, null);
    */
    chkCbxExcludeSample.setBackground(new Color(204, 204, 225));
    chkCbxExcludeSample.setFont(new java.awt.Font("Dialog", 1, 11));
    chkCbxExcludeSample.setText("EXCLUDE SAMPLE");
    chkCbxExcludeSample.setBounds(new Rectangle(553, 187, 157, 23));
    pnlBuyers.add(buyers[2], null);
    pnlBuyers.add(buyers[1], null);
    pnlBuyers.add(buyers[0], null);
    pnlMakers.add(makers[0], null);
    pnlMakers.add(makers[2], null);
    pnlMakers.add(makers[1], null);

    /*
    pnlBuyers.add(buyers0, null);
    pnlBuyers.add(buyers1, null);
    pnlBuyers.add(buyers2, null);
    pnlMakers.add(makers2, null);
    pnlMakers.add(makers1, null);
    pnlMakers.add(makers0, null);
    */


    this.add(pnlDeps, null);
    this.add(pnlBuyers, null);
    this.add(pnlMakers, null);
    this.add(btnQry, null);
    this.add(lblDDFrom, null);
    this.add(txtDelFrom, null);
    this.add(lblYear2, null);
    this.add(txtDelTo, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblCenter, null);
    this.add(cbxCenter, null);
    this.add(lblCountry, null);
    this.add(cbxCountry, null);
    this.add(cbxReportType, null);
    //this.add(lblUnship, null);
    if(IS_WITH_RCV_AMT){
      lblReportType.setVisible(false);
      cbxReportType.setVisible(false);
      chkCbxExcludeSample.setVisible(false);
    }
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();
      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDelFrom, "P_ETD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDelTo, "P_ETD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);


      dbCbxCountry =
          new exgui.DataBindJCombobox(
          cbxCountry, "P_COUNTRY",
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME", "CNTY_NAME", "ALL", "ALL", null);
      dataBindComps.add(dbCbxCountry);


      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(dbCbxCenter);

    dataBindComps.add(new exgui.DataBindJCombobox(
      cbxOffCenter, "P_OFF_CEN",
       newtimes.preproduction.guis.tempProperties.tmpOffShores,
       "CEN_NAME", "CEN_CODE",
       null,"ALL","ALL"));


    /*
      Vector depVects=
          (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
          dbCbxCenter.getSelectedValue());
      for(int i=0;i<itemCount;i++){
         dbCbxDep[i] =
            new exgui.DataBindJCombobox(
            cbxDep[i], "DEP",
            depVects,
            "DEP_NAME", "DEP_NAME",
            null,
            " ", null);
      }*/
     indexOfMng=dataBindComps.size();
     dataBindComps.add(null);


     Object chkDcm32 = CellFormat.getDoubleFormatAllowNull(5, 4);
     Vector vct = CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD, "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1", 1, 1);
     Record recSystem = (Record)vct.get(0);
     dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbTwdChg);
     dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbRmbChg);
     dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbHkdChg);
      this.add(lblDDFrom, null);
      this.add(txtDelFrom, null);
      this.add(lblYear2, null);
      this.add(txtDelTo, null);
      this.add(cbxReportType, null);
      this.add(lblCountry1, null);
      this.add(cbxMng, null);
      this.add(jLabel1, null);
      this.add(cbxOffCenter, null);
      this.add(lblDDFrom, null);
      this.add(txtDelFrom, null);
      this.add(lblYear2, null);
      this.add(txtDelTo, null);
      this.add(lblReportType, null);
      this.add(chkCbxExcludeSample, null);
      this.add(pnlBuyers, null);
      this.add(pnlMakers, null);
      this.add(pnlBuyers, null);
      this.add(lblCenter, null);
      this.add(cbxCenter, null);
      this.add(lblCountry, null);
      this.add(cbxCountry, null);
      this.add(cbxReportType, null);
      reportName ="profit_share.rpt";

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
  protected void setManagerCombobox(String cenCode){
    Vector vctMng=(Vector)
        newtimes.preproduction.guis.tempProperties.tmpHm_Managers4AllCenters.get(
       cenCode);
   dbCbxMng=
       new exgui.DataBindJCombobox(
        cbxMng, "P_MANAGER",
        vctMng ,
        "MNG_ABBR", "MNG_CODE",
        "ALL","ALL","ALL");
     dataBindComps.set(indexOfMng,dbCbxMng);

  }
  protected void udpateDepComboBox(){
    Vector depVects=
        (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
        dbCbxCenter.getSelectedValue());
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
     if(usingCenterCode==null || usingCenterCode.trim().length()==0) usingCenterCode=util.PublicVariable.OPERATTING_CENTER;

    for( int i=0;i<buyers.length;i++){
      buyers[i].setSelectingCenter(usingCenterCode);
      makers[i].setSelectingCenter(usingCenterCode);
    }
    setManagerCombobox(usingCenterCode);
  }

  protected java.util.HashMap composeParameters(){
    HashMap hm = super.composeParameters();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<3;i++){
      Object buyObj=buyers[i].getSelectedValue();
      if(buyObj!=null){
        if(sb.length()>0)sb.append(",");
        sb.append("'");
        sb.append(util.MiscFunc.Replace(((javax.swing.JTextField)buyers[i].getGUIcomponent()).getText(),"'","''''") );
        sb.append("'");
      }
    }
    if(sb.length()>0){
      hm.put("P_BUYER","["+sb.toString()+"]");
    }else{
      hm.put("P_BUYER","['ALL']");
    }

    StringBuffer sb2=new StringBuffer();
    for(int i=0;i<3;i++){
      Object makObj=makers[i].getSelectedValue();
      if(makObj!=null){
        if(sb2.length()>0)sb2.append(",");
        sb2.append("'");
        sb2.append(util.MiscFunc.Replace(
        ((javax.swing.JTextField)makers[i].getGUIcomponent()).getText(),"'","''''"));
        sb2.append("'");
      }
    }
    if(sb2.length()>0){
      hm.put("P_MAKER","["+sb2.toString()+"]");
    }else{
      hm.put("P_MAKER","['ALL']");
    }

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
    if(!IS_WITH_RCV_AMT){
      hm.put("P_EX_SAMPLE",chkCbxExcludeSample.isSelected()?"Y":"N");
    }
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    //check if any field is empty,End date can not before than Begin date.
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd=dbTxtDateEnd.getSelectedValue();

    if((dateBgn!=null && dateEnd!=null)  && ((java.util.Date)dateBgn).after((java.util.Date)dateEnd)){
      exgui.verification.VerifyLib.showAlert("\"End Date\" Can Not Before \"Begin Date\"",
                                             "\"End Date\" Can Not Before \"Begin Date\"");
      return;
    }
    if(!IS_WITH_RCV_AMT){
      if (cbxReportType.getSelectedIndex() == 0) {
        reportName = "profit_share.rpt";
      } else {
        reportName = "profit_share_simp.rpt";
      }
    }else{
       reportName = "profit_share_acc.rpt";
    }
    JButtonQueryButtonAction(e);

  }
  ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();
  JLabel lblUnship = new JLabel();
  JLabel lblReportType = new JLabel();
  JComboBox cbxReportType = new JComboBox(new String[]{"ALL COLUMN","SIMPLE COLUMN"});
  JLabel lblCountry1 = new JLabel();
  JComboBox cbxMng = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxOffCenter = new JComboBox();
  JCheckBox chkCbxExcludeSample = new JCheckBox();

}
