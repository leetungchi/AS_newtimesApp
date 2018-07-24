package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import exgui.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPsListByFty
    //extends JPanel {
    extends AbsQryPanel{
  JComboBox cbxCenter = new JComboBox();
  JLabel lblCenter = new JLabel();
  JComboBox cbxMng = new JComboBox();
  JLabel jLabel5 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JPanel pnlDeps = new JPanel();
  TitledBorder titledBorder1;
  JComboBox cbxDep[] = new JComboBox[6];
  JButton btnQry = new JButton();
  JPanel pnlFTYDEL = new JPanel();
  Border border1;
  TitledBorder titledBorder2;
  JTextField txtDateEnd = new JTextField();
  JLabel lblDateBgn = new JLabel();
  JTextField txtDateFrom = new JTextField();
  JLabel lblDateEnd = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  exgui.DataBindJCombobox dbCbxDep[]=new exgui.DataBindJCombobox[6];
  exgui.DataBindJCombobox dbCbxCenter,dbCbxManager,dbCbxCountry,dbCbxProdType;
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  int indexCbxMng=0;
  public PnlPsListByFty() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
   slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
   slkMaker.init("",null,slkMaker.TYPE_MAKER,true);
   for(int i=0;i<6;i++){
       cbxDep[i] = new JComboBox();
   }
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"DEPARTMENTS");
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"FTY DEL DATE");
    jLabel5.setBounds(new Rectangle(241, 42, 70, 24));
    jLabel5.setText("MANAGER");
    cbxMng.setBounds(new Rectangle(306, 44, 145, 22));
    lblCenter.setBounds(new Rectangle(40, 42, 82, 21));
    lblCenter.setText("CENTER");
    cbxCenter.setBounds(new Rectangle(100, 42, 83, 21));
    this.setLayout(null);
    slkBuyer.setBounds(new Rectangle(592, 65, 143, 21));
    slkMaker.setBounds(new Rectangle(592, 99, 143, 21));
    jLabel2.setText("BUYER:");
    jLabel2.setBounds(new Rectangle(519, 65, 65, 19));
    jLabel3.setText("MAKER:");
    jLabel3.setBounds(new Rectangle(522, 98, 65, 21));
    pnlDeps.setBackground(new Color(204, 204, 225));
    pnlDeps.setBorder(titledBorder1);
    pnlDeps.setBounds(new Rectangle(39, 111, 392, 131));
    pnlDeps.setLayout(null);
    cbxDep[0].setBounds(new Rectangle(18, 29, 124, 21));
    cbxDep[1].setBounds(new Rectangle(18, 68, 124, 21));
    cbxDep[2].setBounds(new Rectangle(18, 106, 124, 21));
    cbxDep[3].setBounds(new Rectangle(213, 29, 124, 21));
    cbxDep[4].setBounds(new Rectangle(213, 68, 124, 21));
    cbxDep[5].setBounds(new Rectangle(213, 106, 124, 21));
    btnQry.setBounds(new Rectangle(574, 216, 116, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    pnlFTYDEL.setBackground(new Color(202, 202, 225));
    pnlFTYDEL.setBorder(titledBorder2);
    pnlFTYDEL.setBounds(new Rectangle(445, 131, 319, 59));
    pnlFTYDEL.setLayout(null);
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(215, 23, 96, 22));
    lblDateBgn.setBounds(new Rectangle(17, 21, 57, 22));
    lblDateBgn.setText("FROM");
    lblDateBgn.setToolTipText("");
    txtDateFrom.setBounds(new Rectangle(57, 22, 100, 22));
    txtDateFrom.setText("");
    lblDateEnd.setText("TO");
    lblDateEnd.setBounds(new Rectangle(174, 23, 47, 22));
    this.setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("P.S. LIST BY FACTORY");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 8, 800, 31));
    cbxProdType.setBounds(new Rectangle(306, 74, 124, 21));
    lblType.setRequestFocusEnabled(true);
    lblType.setText("TYPE");
    lblType.setBounds(new Rectangle(268, 74, 53, 21));
    lblCountry.setText("COUNTRY");
    lblCountry.setBounds(new Rectangle(35, 75, 78, 22));
    cbxCountry.setBounds(new Rectangle(100, 75, 126, 22));
    cbxCountry.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCountry_itemStateChanged(e);
      }
    });
    pnlDeps.add(cbxDep[0], null);
    pnlDeps.add(cbxDep[1], null);
    pnlDeps.add(cbxDep[2], null);
    pnlDeps.add(cbxDep[3], null);
    pnlDeps.add(cbxDep[4], null);
    pnlDeps.add(cbxDep[5], null);
    this.add(pnlFTYDEL, null);
    this.add(jLabel2, null);
    this.add(slkBuyer, null);
    this.add(jLabel3, null);
    this.add(slkMaker, null);
    this.add(pnlDeps, null);
    pnlFTYDEL.add(lblDateBgn, null);
    pnlFTYDEL.add(txtDateFrom, null);
    pnlFTYDEL.add(lblDateEnd, null);
    pnlFTYDEL.add(txtDateEnd, null);
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblCenter, null);
    this.add(cbxCenter, null);
    this.add(jLabel5, null);
    this.add(lblType, null);
    this.add(cbxProdType, null);
    this.add(lblCountry, null);
    this.add(cbxCountry, null);
    this.add(cbxMng, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();
       Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new  exgui.DataBindTextWithChecker(txtDateFrom,"P_DEL_FM",null,
          10,(exgui.Object2String)dateVfy,
           (exgui.ultratable.CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new  exgui.DataBindTextWithChecker(txtDateEnd,"P_DEL_TO",null,
          10,(exgui.Object2String)dateVfy,
           (exgui.ultratable.CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);



      dbCbxManager =
          new exgui.DataBindJCombobox(
            cbxMng ,"P_MANAGER",
            newtimes.preproduction.guis.tempProperties.tmpManagerRecs,
            "MNG_ABBR","MNG_CODE","ALL","ALL","ALL");
      indexCbxMng=dataBindComps.size();
      dataBindComps.add(dbCbxManager);

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
      for(int i=0;i<6;i++){
        dbCbxDep[i] =
            new exgui.DataBindJCombobox(
            cbxDep[i], "DEP",
            depVects,
            "DEP_NAME", "DEP_NAME",
            null,
            "ALL", null);
        //dataBindComps.add(dbCbxDep[i]);
      }*/


      dbCbxCountry =
          new exgui.DataBindJCombobox(
            cbxCountry ,"P_COUNTRY",
            newtimes.preproduction.guis.tempProperties.tmpCountries,
            "CNTY_NAME","CNTY_NAME","ALL","ALL","ALL");
      dataBindComps.add(dbCbxCountry);


      dbCbxProdType =
          new exgui.DataBindJCombobox(
            cbxProdType,"P_TYPE",
            newtimes.preproduction.guis.tempProperties.tmpProdType,
            "TYPE_NAME","TYPE_CODE","W");
      dataBindComps.add(dbCbxProdType);

      super.reportName="PS_FTY_LST.RPT";
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
        if(vctMng==null)vctMng=newtimes.preproduction.guis.tempProperties.tmpManagerRecs;
    if(vctMng==null)vctMng=new Vector();
    dbCbxManager =
        new exgui.DataBindJCombobox(
          cbxMng ,"P_MANAGER",
          vctMng,
          "MNG_ABBR","MNG_CODE","ALL","ALL","ALL");
    dataBindComps.set(indexCbxMng ,dbCbxManager);


  }

  protected void udpateDepComboBox(){
    Vector depVects=
        (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
        dbCbxCenter.getSelectedValue());
    String usingCenterCode=(String)dbCbxCenter.getSelectedValue();
     if(usingCenterCode==null || usingCenterCode.trim().length()==0)usingCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;
    slkBuyer.setSelectingCenter(usingCenterCode);
    slkMaker.setSelectingCenter(usingCenterCode);
    reGenMangers();
    boolean haveAllDep=true;
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
     util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
     haveAllDep=false;
    }

    for(int i=0;i<6;i++){
      dbCbxDep[i] =
          (haveAllDep)?
          new exgui.DataBindJCombobox(
          cbxDep[i], "DEP",
          depVects,
          "DEP_NAME", "DEP_NAME",
          null,
          "ALL", null):
          new exgui.DataBindJCombobox(
          cbxDep[i], "DEP",
          depVects,
          "DEP_NAME", "DEP_NAME",
          null);
      //dataBindComps.add(dbCbxDep[i]);
    }
  }
  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();
    if(slkBuyer.getSelectedValue()!=null){
      hm.put("P_BUYER",
             util.MiscFunc.Replace(
             ((javax.swing.JTextField)slkBuyer.getGUIcomponent()).getText(),"'","''''"));
    }
    if(slkMaker.getSelectedValue()!=null){
      hm.put("P_MAKER",
             util.MiscFunc.Replace(
             ((javax.swing.JTextField)slkMaker.getGUIcomponent()).getText(),"'","''''")
             );
    }

    if (dateBgn == null) {
      hm.put("P_DEL_FM", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("P_DEL_TO", "DATE(2099,12,31)");
    }
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<6;i++){
      Object obj=dbCbxDep[i].getSelectedValue();
      if(obj!=null){
        if(sb.length()>0)sb.append(",");
        sb.append("'");sb.append(obj);sb.append("'");
      }
    }
    if(sb.length()>0){
      hm.put("P_DEP","["+sb.toString()+"]");
    }else{
      hm.put("P_DEP","['ALL']");
    }
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }
  JComboBox cbxProdType = new JComboBox();
  JLabel lblType = new JLabel();
  JLabel lblCountry = new JLabel();
  JComboBox cbxCountry = new JComboBox();
  void cbxCountry_itemStateChanged(ItemEvent e) {

  }

}
