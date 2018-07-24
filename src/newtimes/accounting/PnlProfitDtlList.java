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

public class PnlProfitDtlList
    //extends JPanel {
    extends newtimes.production.report.AbsQryPanel{
 protected int itemCount=6;
 protected BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
 protected   JLabel lblCountry = new JLabel();
 protected   JComboBox cbxCenter = new JComboBox();
 protected   JLabel lblCenter = new JLabel();
 protected   JComboBox cbxCountry = new JComboBox();
  protected  JPanel pnlDeps = new JPanel();
 protected   TitledBorder titledBorder1;
 protected   JComboBox cbxDep[]=null;
  protected  JPanel pnlBuyers = new JPanel();
 protected   TitledBorder titledBorder2;
 protected   JPanel pnlMakers = new JPanel();
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
 protected   DataBindJCombobox dbCbxCenter,dbCbxCountry,dbCbxDep[],dbCbxSzn,dbCbxProdType,dbCbxDivision ;
 protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTwdChg,dbHkdChg,dbRmbChg;

  public PnlProfitDtlList() {
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
    blueBkgWhiteCharLabel1.setText("PROFIT DETAIL LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 3, 800, 25));
    this.setLayout(null);
    lblCountry.setText("COUNTRY");
    lblCountry.setBounds(new Rectangle(265, 53, 78, 17));
    cbxCenter.setBounds(new Rectangle(113, 53, 126, 22));
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(30, 53, 82, 19));
    cbxCountry.setBounds(new Rectangle(340, 52, 124, 20));
    pnlDeps.setBackground(new Color(204, 204, 225));
    pnlDeps.setBorder(titledBorder1);
    pnlDeps.setBounds(new Rectangle(15, 79, 155, 193));
    pnlDeps.setLayout(null);
    cbxDep[5].setBounds(new Rectangle(12, 156, 126, 22));
    cbxDep[4].setBounds(new Rectangle(12, 129, 126, 22));
    cbxDep[3].setBounds(new Rectangle(12, 102, 126, 22));
    cbxDep[2].setBounds(new Rectangle(12, 75, 126, 22));
    cbxDep[1].setBounds(new Rectangle(12, 48, 126, 22));
    cbxDep[0].setBounds(new Rectangle(12, 21, 126, 22));

    pnlBuyers.setBackground(new Color(204, 204, 225));
    pnlBuyers.setBorder(titledBorder3);
    pnlBuyers.setBounds(new Rectangle(177, 79, 175, 193));
    pnlBuyers.setLayout(null);
    buyers[0].setBounds(new Rectangle(8, 24, 160, 18));
    //buyers[1].setBounds(new Rectangle(8, 51, 160, 18));
    buyers[1].setBounds(new Rectangle(8, 78, 160, 18));
    //buyers[3].setBounds(new Rectangle(8, 104, 160, 18));
    buyers[2].setBounds(new Rectangle(8, 131, 160, 18));


    makers[0].setBounds(new Rectangle(9, 23, 160, 18));
    //makers[1].setBounds(new Rectangle(9, 51, 160, 18));
    makers[1].setBounds(new Rectangle(9, 78, 160, 18));
    //makers[3].setBounds(new Rectangle(9, 106, 160, 18));
    makers[2].setBounds(new Rectangle(9, 133, 160, 18));

    pnlMakers.setLayout(null);
    pnlMakers.setBounds(new Rectangle(358, 79, 175, 193));
    pnlMakers.setBorder(titledBorder2);
    pnlMakers.setBackground(new Color(204, 204, 225));

    lblDDFrom.setBounds(new Rectangle(568, 89, 85, 21));
    lblDDFrom.setText("O.B.D FROM:");
    txtDelFrom.setBounds(new Rectangle(648, 92, 71, 21));
    txtDelFrom.setText("");
    lblYear2.setBounds(new Rectangle(606, 129, 37, 20));
    lblYear2.setText("TO:");
    txtDelTo.setBounds(new Rectangle(648, 126, 71, 21));
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
    pnlDeps.add(cbxDep[0], null);
    pnlDeps.add(cbxDep[1], null);
    pnlDeps.add(cbxDep[2], null);
    pnlDeps.add(cbxDep[3], null);
    pnlDeps.add(cbxDep[4], null);
    //pnlBuyers.add(buyers[4], null);
    //pnlBuyers.add(buyers[3], null);
    pnlBuyers.add(buyers[2], null);
    pnlBuyers.add(buyers[1], null);
    pnlBuyers.add(buyers[0], null);
    pnlMakers.add(makers[0], null);
    //pnlMakers.add(makers[4], null);
    //pnlMakers.add(makers[3], null);
    pnlMakers.add(makers[2], null);
    pnlMakers.add(makers[1], null);



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
    //this.add(lblUnship, null);

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



     Object chkDcm32 = CellFormat.getDoubleFormatAllowNull(5, 4);
     Vector vct = CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD, "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1", 1, 1);
     Record recSystem = (Record)vct.get(0);
     dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbTwdChg);
     dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbRmbChg);
     dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbHkdChg);
      reportName ="profit_detail.rpt";

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

  protected void udpateDepComboBox(){
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
          "ALL", null);
      //dataBindComps.add(dbCbxDep[i]);
    }
    String usingCenterCode=(String)dbCbxCenter.getSelectedValue();
     if(usingCenterCode==null || usingCenterCode.trim().length()==0)usingCenterCode=util.PublicVariable.OPERATTING_CENTER;

    for( int i=0;i<buyers.length;i++){
      buyers[i].setSelectingCenter(usingCenterCode);
      makers[i].setSelectingCenter(usingCenterCode);
    }

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
    JButtonQueryButtonAction(e);
  }
  ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();
  JLabel lblUnship = new JLabel();

}
