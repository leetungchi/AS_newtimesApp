package newtimes.production.report;

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
import newtimes.preproduction.guis.tempProperties;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNTHK_DTL_Sc_No
    //extends JPanel {
    extends AbsQryPanel{
 protected int itemCount=5;
 protected BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
 protected   JLabel lblCountry = new JLabel();
 protected   JComboBox cbxCenter = new JComboBox();
 protected   JLabel lblCenter = new JLabel();
 protected   JComboBox cbxCountry = new JComboBox();
 protected   JLabel lblSeason = new JLabel();
 protected   JComboBox cbxSeason = new JComboBox();
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
 protected   JLabel lblYear = new JLabel();
  protected  JTextField txtYear = new JTextField();
 protected   JLabel lblDDFrom = new JLabel();
 protected   JTextField txtDelFrom = new JTextField();
 protected   JLabel lblYear2 = new JLabel();
 protected   JTextField txtDelTo = new JTextField();
 protected   JButton btnQry = new JButton();
 protected   JTextField txtTwdUsd=new JTextField();
 protected   JTextField txtHkdUsd=new JTextField();
 protected   JTextField txtRmbUsd=new JTextField();
 protected   DataBindJCombobox dbCbxCenter,dbCbxCountry,dbCbxDep[],dbCbxSzn,dbCbxProdType,dbCbxManager ;
 protected   DataBindJCombobox dbCbxDivision;
 protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTwdChg,dbHkdChg,dbRmbChg,dbTxtScFm,dbTxtScTo;
 protected boolean doingDB2Gui=false;
 newtimesejb.preproduction.PreProductionHead prdHead;
 int divCbxDBGUI_index=0,indexCbxMng=0;;
 ChangeBuyerHandler buyerChangeListener=new ChangeBuyerHandler();
 cbxCenterItemChanged myCenterListener=new cbxCenterItemChanged();

  public PnlNTHK_DTL_Sc_No() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public class ChangeBuyerHandler
      implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record buyerRecord){
      //recompose the division combobox of buyer.
      //filter if buyer object select over than 1 item
      int buyerCount=0;
      if(doingDB2Gui)return;
      try{
        for(int i=0;i<buyers.length;i++){
           if(((javax.swing.JTextField)buyers[i].getGUIcomponent()).getText().trim().length()>0){
             ++buyerCount;
             if(buyerCount>1){
               dbCbxDivision=new exgui.DataBindJCombobox(
                   cbxDivision,
                   "P_DIV",
                   new Vector(),
                  "DIV_NAME", "DIV_CODE", "ALL", "ALL", null);
                  dataBindComps.set(divCbxDBGUI_index,dbCbxDivision);
                  return;
             }
           }
        }


        //find out the vector to add dbDeps.
        if (buyerRecord==null) {
          //only the all dep is allow to add now.
          dbCbxDivision=new exgui.DataBindJCombobox(
              cbxDivision,
              "P_DIV",
              new Vector(),
             "DIV_NAME", "DIV_CODE", "ALL", "ALL", null);
          //cbxDiv.setUI(new exgui.WideComboBoxUI(160));

          if(divCbxDBGUI_index == dataBindComps.size()) {
            dataBindComps.add(dbCbxDivision);
          }else{
            //just replace after display & change;
            dataBindComps.set(divCbxDBGUI_index,dbCbxDivision);
          }

        }else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords=
              (Vector)tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
           dbCbxDivision=null;
          if(dvsnRecords==null){
            dbCbxDivision=new exgui.DataBindJCombobox(
                cbxDivision,
                "P_DIV",
                new Vector(),
                "DIV_NAME", "DIV_CODE", "ALL", "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }else {
            dbCbxDivision=new exgui.DataBindJCombobox(
                cbxDivision,
                "P_DIV",
                dvsnRecords,
                "DIV_NAME", "DIV_CODE", "ALL", "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }

          if (divCbxDBGUI_index == dataBindComps.size()) {
            dataBindComps.add(dbCbxDivision);
          }else{
            dataBindComps.set(divCbxDBGUI_index,dbCbxDivision);
          }
        }

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }

 protected void jbInit() throws Exception {
      buyers=new SelectBuyerMaker[itemCount];
      makers=new SelectBuyerMaker[itemCount];
      cbxDep=new JComboBox[itemCount];
      dbCbxDep=new exgui.DataBindJCombobox[itemCount];

    for(int i=0;i<itemCount;i++){
      buyers[i]=new SelectBuyerMaker();
      buyers[i].init("",null,buyers[0].TYPE_BUYER,true);
      buyers[i].setModifyNotifyTo(buyerChangeListener);
      makers[i]=new SelectBuyerMaker();
      makers[i].init("",null,makers[0].TYPE_MAKER,true);
      cbxDep[i]=new JComboBox();
    }
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157)),"DEPARTMENTS");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"MAKERS");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157));
    titledBorder3 = new TitledBorder(border1,"BUYERS");
    setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("DETAIL BY SC NUMBER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 0, 800, 18));
    this.setLayout(null);
    lblCountry.setText("COUNTRY");
    lblCountry.setBounds(new Rectangle(266, 31, 78, 17));
    cbxCenter.setBounds(new Rectangle(114, 31, 126, 22));
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(31, 31, 82, 19));
    cbxCountry.setBounds(new Rectangle(341, 30, 124, 20));
    lblSeason.setBounds(new Rectangle(29, 54, 70, 17));
    lblSeason.setText("SEASON");
    cbxSeason.setBounds(new Rectangle(114, 54, 126, 20));
    pnlDeps.setBackground(new Color(204, 204, 225));
    pnlDeps.setBorder(titledBorder1);
    pnlDeps.setBounds(new Rectangle(15, 79, 155, 193));
    pnlDeps.setLayout(null);
    cbxDep[4].setBounds(new Rectangle(12, 129, 126, 22));
    cbxDep[2].setBounds(new Rectangle(12, 75, 126, 22));
    cbxDep[3].setBounds(new Rectangle(12, 102, 126, 22));
    cbxDep[1].setBounds(new Rectangle(12, 48, 126, 22));
    cbxDep[0].setBounds(new Rectangle(12, 21, 126, 22));
    pnlBuyers.setBackground(new Color(204, 204, 225));
    pnlBuyers.setBorder(titledBorder3);
    pnlBuyers.setBounds(new Rectangle(177, 79, 175, 193));
    pnlBuyers.setLayout(null);
    buyers[0].setBounds(new Rectangle(8, 24, 160, 18));
    buyers[1].setBounds(new Rectangle(8, 51, 160, 18));
    buyers[3].setBounds(new Rectangle(8, 104, 160, 18));
    buyers[4].setBounds(new Rectangle(8, 131, 160, 18));
    buyers[2].setBounds(new Rectangle(8, 78, 160, 18));

    makers[2].setBounds(new Rectangle(9, 78, 160, 18));
    makers[4].setBounds(new Rectangle(9, 133, 160, 18));
    makers[1].setBounds(new Rectangle(9, 51, 160, 18));
    makers[0].setBounds(new Rectangle(9, 23, 160, 18));
    pnlMakers.setLayout(null);
    pnlMakers.setBounds(new Rectangle(358, 79, 175, 193));
    pnlMakers.setBorder(titledBorder2);
    pnlMakers.setBackground(new Color(204, 204, 225));
    makers[3].setBounds(new Rectangle(9, 106, 160, 18));
    lblYear.setText("YEAR:");
    lblYear.setBounds(new Rectangle(263, 53, 55, 20));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(341, 53, 124, 21));
    lblDDFrom.setBounds(new Rectangle(472, 26, 72, 21));
    lblDDFrom.setText("DEL. FROM:");
    txtDelFrom.setBounds(new Rectangle(544, 26, 71, 21));
    txtDelFrom.setText("");
    lblYear2.setBounds(new Rectangle(625, 26, 37, 20));
    lblYear2.setText("TO:");
    txtDelTo.setBounds(new Rectangle(678, 26, 71, 21));
    txtDelTo.setText("");
    btnQry.setBounds(new Rectangle(666, 204, 91, 30));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    lblUnship.setBounds(new Rectangle(536, 109, 224, 28));
    lblUnship.setText("UNSHIP:");
    lblDivision.setText("DIVISION");
    lblDivision.setBounds(new Rectangle(540, 116, 60, 22));
    cbxDivision.setBounds(new Rectangle(604, 116, 150, 22));
    lblProdType.setText("TYPE");
    lblProdType.setBounds(new Rectangle(542, 147, 55, 21));
    cbxProdType.setBounds(new Rectangle(604, 147, 150, 22));
    jLabel1.setText("MANAGER:");
    jLabel1.setBounds(new Rectangle(535, 172, 71, 22));
    cbxManager.setBounds(new Rectangle(604, 174, 150, 22));
    rdoBuyer.setBackground(new Color(202, 202, 224));
    rdoBuyer.setSelected(true);
    rdoBuyer.setText("Buyer");
    rdoBuyer.setBounds(new Rectangle(535, 80, 71, 22));
    rdoMaker.setBounds(new Rectangle(612, 80, 71, 22));
    rdoMaker.setText("Maker");
    rdoMaker.setBackground(new Color(202, 202, 224));
    rdoMaker.setSelected(true);
    txtScTo.setText("");
    txtScTo.setBounds(new Rectangle(677, 51, 71, 21));
    lblDDFrom1.setText("S/C# FROM:");
    lblDDFrom1.setBounds(new Rectangle(471, 51, 72, 21));
    lblYear3.setText("TO:");
    lblYear3.setBounds(new Rectangle(624, 51, 37, 20));
    txtScFm.setText("");
    txtScFm.setBounds(new Rectangle(543, 51, 71, 21));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCenter, null);
    pnlDeps.add(cbxDep[0], null);
    pnlDeps.add(cbxDep[1], null);
    pnlDeps.add(cbxDep[2], null);
    pnlDeps.add(cbxDep[3], null);
    pnlDeps.add(cbxDep[4], null);
    this.add(lblCenter, null);
    pnlBuyers.add(buyers[4], null);
    pnlBuyers.add(buyers[3], null);
    pnlBuyers.add(buyers[2], null);
    pnlBuyers.add(buyers[1], null);
    pnlBuyers.add(buyers[0], null);
    pnlMakers.add(makers[0], null);
    pnlMakers.add(makers[4], null);
    pnlMakers.add(makers[3], null);
    pnlMakers.add(makers[2], null);
    pnlMakers.add(makers[1], null);



    this.add(cbxSeason, null);
    this.add(lblSeason, null);
    this.add(pnlDeps, null);
    this.add(pnlBuyers, null);
    this.add(pnlMakers, null);
    this.add(txtDelTo, null);
    this.add(lblDivision, null);
    this.add(cbxDivision, null);
    this.add(cbxProdType, null);
    this.add(lblProdType, null);
    this.add(btnQry, null);
    this.add(lblCountry, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(cbxCountry, null);
    this.add(lblDDFrom, null);
    this.add(txtDelFrom, null);
    this.add(lblYear2, null);
    this.add(jLabel1, null);
    this.add(cbxManager, null);
    this.add(rdoBuyer, null);
    this.add(rdoMaker, null);
    this.add(lblDDFrom1, null);
    this.add(txtScFm, null);
    this.add(lblYear3, null);
    this.add(txtScTo, null);
    //this.add(lblUnship, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      doingDB2Gui=true;
      dataBindComps.clear();

      Object scVfy = exgui.verification.CellFormat.getOrdinaryField(20);
      dbTxtScFm  =
          new exgui.DataBindTextWithChecker(txtScFm, "P_SC_FM", null,
                                            20, (exgui.Object2String)scVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)scVfy);
      dataBindComps.add(dbTxtScFm);

      dbTxtScTo =
          new exgui.DataBindTextWithChecker(txtScTo, "P_SC_TO", null,
                                            20, (exgui.Object2String)scVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)scVfy);
      dataBindComps.add(dbTxtScTo);


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDelFrom, "P_DEL_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDelTo, "P_DEL_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);

      dbCbxProdType =
          new exgui.DataBindJCombobox(
          cbxProdType, "P_TYPE",
          newtimes.preproduction.guis.tempProperties.tmpProdType,
          "TYPE_NAME", "TYPE_CODE", "ALL", "ALL", null);
      dataBindComps.add(dbCbxProdType);
      /*
      Vector vctMng=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select mng_code,mng_name from manager where MNG_CEN_CODE="+
      (String)util.PublicVariable.OPERATTING_CENTER,1,999);  */
      //mng_code,MNG_ABBR
      dbCbxManager =
          new exgui.DataBindJCombobox(
          cbxManager, "P_MANAGER",
          newtimes.preproduction.guis.tempProperties.tmpManagerRecs,
          "MNG_ABBR", "MNG_CODE", "ALL", "ALL", null);
      indexCbxMng=dataBindComps.size();
      dataBindComps.add(dbCbxManager);


      Vector vctDivs=new Vector();
          /*
          =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,"select Div_code,div_name from division where record_delete_flag='1' order by div_name ",1,99999);*/
      divCbxDBGUI_index=  dataBindComps.size();
      dbCbxDivision =
          new exgui.DataBindJCombobox(
          cbxDivision, "P_DIV",
          vctDivs,
          "DIV_NAME", "DIV_CODE", "ALL", "ALL", null);
      dataBindComps.add(dbCbxDivision);

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

      Vector seasons=newtimes.preproduction.guis.tempProperties.tmpSeason;
      dbCbxSzn= new exgui.DataBindJCombobox(
          cbxSeason,"P_SEASON",
          seasons,"SEA_NAME","SEA_NAME",null,"ALL",null);
      dataBindComps.add(dbCbxSzn);

        Object objCnv=exgui.verification.CellFormat.getOrdinaryField(4);
      exgui.DataBindTextWithChecker  dbTxtYear=new  exgui.DataBindTextWithChecker(
                txtYear,"P_YEAR",
                null,4,
                (exgui.Object2String)objCnv,
                (exgui.ultratable.CellTxtEditorFormat)objCnv);
     dataBindComps.add(dbTxtYear);

     Object chkDcm32 = CellFormat.getDoubleFormatAllowNull(5, 4);
     Vector vct = CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD, "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1", 1, 1);
     Record recSystem = (Record)vct.get(0);
     dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbTwdChg);
     dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbRmbChg);
     dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbHkdChg);
     reportName = "hk_prod_sc.rpt";
     doingDB2Gui=false;
     cbxCenter.removeItemListener(myCenterListener);
     cbxCenter.addItemListener(myCenterListener);
     myCenterListener.itemStateChanged(null);
     buttonGroup1.add(rdoBuyer);
     buttonGroup1.add(rdoMaker);

    }catch(Exception exp){
      exp.printStackTrace();

    }
  }
protected void reGenMangers(){
  if (doingDB2Gui)return;
  Vector vctMng=
      (Vector)newtimes.preproduction.guis.tempProperties.tmpHm_Managers4AllCenters.get(
      dbCbxCenter.getSelectedValue());
  if(vctMng==null)vctMng=newtimes.preproduction.guis.tempProperties.tmpManagerRecs;

       dbCbxManager=new exgui.DataBindJCombobox(
        cbxManager, "P_MANAGER",
        newtimes.preproduction.guis.tempProperties.tmpManagerRecs,
        "MNG_ABBR", "MNG_CODE", "ALL", "ALL", null);

      dataBindComps.set(indexCbxMng,dbCbxManager);

}

  protected void recreateDeplist(){
    Vector depVects =
        (Vector)newtimes.preproduction.guis.tempProperties.
        tmpH_tbl_CenterDepMap.get(
        dbCbxCenter.getSelectedValue());
    boolean isAllDep=true;
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
         util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
        isAllDep=false;
      }

    for(int i=0;i<itemCount;i++){
       dbCbxDep[i] =
           (isAllDep)?
          new exgui.DataBindJCombobox(
          cbxDep[i], "DEP",
          depVects,
          "DEP_NAME", "DEP_NAME",
          null,
          " ", null):
          new exgui.DataBindJCombobox(
          cbxDep[i], "DEP",
          depVects,
          "DEP_NAME", "DEP_NAME",
          null);


    }
    for(int i=0;i<itemCount;i++){
      //buyers[i]=new SelectBuyerMaker();
      buyers[i].init("",null,buyers[0].TYPE_BUYER,true);
      buyers[i].setModifyNotifyTo(buyerChangeListener);
      buyers[i].setSelectingCenter((String)dbCbxCenter.getSelectedValue());
      //makers[i]=new SelectBuyerMaker();
      makers[i].init("",null,makers[0].TYPE_MAKER,true);
      makers[i].setSelectingCenter((String)dbCbxCenter.getSelectedValue());
    }


  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener{
    public void itemStateChanged(ItemEvent e){
      String usingCenterCode=(String)dbCbxCenter.getSelectedValue();
       if(usingCenterCode==null || usingCenterCode.trim().length()==0){
             usingCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;
       }

      for( int i=0;i<buyers.length;i++){
        buyers[i].setSelectingCenter(usingCenterCode);
        makers[i].setSelectingCenter(usingCenterCode);
      }
      recreateDeplist();
      reGenMangers();
    }
  }


  protected java.util.HashMap composeParameters(){
    HashMap hm = super.composeParameters();
    /*
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<itemCount;i++){
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
    for(int i=0;i<itemCount;i++){
      Object makObj=makers[i].getSelectedValue();
      if(makObj!=null){
        if(sb2.length()>0)sb2.append(",");
        sb2.append("'");
        sb2.append(util.MiscFunc.Replace(((javax.swing.JTextField)makers[i].getGUIcomponent()).getText(),"'","''''") );
        sb2.append("'");
      }
    }
    if(sb2.length()>0){
      hm.put("P_MAKER","["+sb2.toString()+"]");
    }else{
      hm.put("P_MAKER","['ALL']");
    }
    */

   StringBuffer sbBuyer=new StringBuffer();
   StringBuffer sbMaker=new StringBuffer();

   for(int i=0;i<itemCount;i++){
     Object buyerObj=buyers[i].getSelectedValue();
     Object makerObj=makers[i].getSelectedValue();
     if(buyerObj!=null){
       if(sbBuyer.length()>0)sbBuyer.append(",");
       sbBuyer.append(buyerObj.toString());
     }
     if(makerObj!=null){
       if(sbMaker.length()>0)sbMaker.append(",");
       sbMaker.append(makerObj.toString());
     }
   }
   if(sbBuyer.length()>0){
     hm.put("P_BYR","["+sbBuyer.toString()+"]");
   }else{
     hm.put("P_BYR","[0]");
   }
   if(sbMaker.length()>0){
     hm.put("P_MKR","["+sbMaker.toString()+"]");
   }else{
     hm.put("P_MKR","[0]");
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
      hm.put("P_DEL_FM","DATE(2000,01,01)");
    }
    if(dateEnd==null){
      hm.put("P_DEL_TO","DATE(2099,12,31)");
    }
    if(rdoBuyer.isSelected()){
      hm.put("BUYER_MAKER","BUYER");
    }else{
      hm.put("BUYER_MAKER","MAKER");
    }
    /*
    if(rdoXcldSCNULL.isSelected()){
      hm.put("EXC_SC","Y");
    }else{
      hm.put("EXC_SC","N");
    }
    if(rdoUnshipYes.isSelected()){
      hm.put("UNSHIP","Y");
    }else{
      hm.put("UNSHIP","N");
    }*/
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
  JLabel lblDivision = new JLabel();
  JComboBox cbxDivision = new JComboBox();
  JLabel lblProdType = new JLabel();
  JComboBox cbxProdType = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxManager = new JComboBox();
  JRadioButton rdoBuyer = new JRadioButton();
  JRadioButton rdoMaker = new JRadioButton();
  JTextField txtScTo = new JTextField();
  JLabel lblDDFrom1 = new JLabel();
  JLabel lblYear3 = new JLabel();
  JTextField txtScFm = new JTextField();
}
