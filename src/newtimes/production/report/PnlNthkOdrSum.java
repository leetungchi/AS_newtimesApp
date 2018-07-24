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

public class PnlNthkOdrSum
    //extends JPanel {
    extends AbsQryPanel{
 protected int itemCount=5;
 protected BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
 protected   JComboBox cbxCenter = new JComboBox();
 protected   JLabel lblCenter = new JLabel();
 protected   JLabel lblSeason = new JLabel();
 protected   JComboBox cbxSeason = new JComboBox();
 protected   TitledBorder titledBorder1;
  protected   JComboBox cbxDep=null;
 protected   TitledBorder titledBorder2;
 protected   SelectBuyerMaker buyers=null;
 protected   SelectBuyerMaker makers=null;
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
 protected   DataBindJCombobox dbCbxCenter,dbCbxCountry,dbCbxDep,dbCbxSzn,dbCbxProdType,dbCbxManager ;
 protected   DataBindJCombobox dbCbxDivision;
 protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTwdChg,dbHkdChg,dbRmbChg;
 protected boolean doingDB2Gui=false;
 newtimesejb.preproduction.PreProductionHead prdHead;
 int divCbxDBGUI_index=0,indexCbxMng;

 ChangeBuyerHandler buyerChangeListener=new ChangeBuyerHandler();
  public PnlNthkOdrSum() {
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
           if(((javax.swing.JTextField)buyers.getGUIcomponent()).getText().trim().length()>0){
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

      //dbCbxDep=new exgui.DataBindJCombobox[itemCount];
      buyers=new SelectBuyerMaker();
      buyers.init("",null,buyers.TYPE_BUYER,true);
      buyers.setModifyNotifyTo(buyerChangeListener);
      makers=new SelectBuyerMaker();
      makers.init("",null,makers.TYPE_MAKER,true);

      cbxDep=new JComboBox();

    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157)),"DEPARTMENTS");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"MAKERS");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157));
    titledBorder3 = new TitledBorder(border1,"BUYERS");
    setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("Order Detail By PO");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 0, 800, 18));
    this.setLayout(null);
    cbxCenter.setBounds(new Rectangle(114, 31, 126, 22));
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(31, 31, 82, 19));
    lblSeason.setBounds(new Rectangle(255, 59, 70, 17));
    lblSeason.setText("SEASON");
    cbxSeason.setBounds(new Rectangle(340, 59, 126, 20));

    cbxDep.setBounds(new Rectangle(340, 31, 126, 22));


    buyers.setBounds(new Rectangle(66, 83, 154, 21));

    makers.setBounds(new Rectangle(66, 116, 154, 21));

    lblYear.setText("YEAR:");
    lblYear.setBounds(new Rectangle(35, 54, 55, 20));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(114, 54, 126, 21));
    lblDDFrom.setBounds(new Rectangle(478, 30, 72, 21));
    lblDDFrom.setText("DEL. FROM:");
    txtDelFrom.setBounds(new Rectangle(550, 30, 71, 21));
    txtDelFrom.setText("");
    lblYear2.setBounds(new Rectangle(628, 30, 37, 20));
    lblYear2.setText("TO:");
    txtDelTo.setBounds(new Rectangle(658, 30, 71, 21));
    txtDelTo.setText("");
    btnQry.setBounds(new Rectangle(683, 79, 91, 30));
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
    lblDivision.setBounds(new Rectangle(230, 83, 60, 22));
    cbxDivision.setBounds(new Rectangle(312, 85, 154, 21));
    jLabel1.setText("MANAGER:");
    jLabel1.setBounds(new Rectangle(481, 54, 71, 22));
    cbxManager.setBounds(new Rectangle(550, 54, 206, 22));
    lblDep.setText("DEPARTMENT");
    lblDep.setBounds(new Rectangle(255, 31, 80, 21));
    lblBuyer.setText("BUYER");
    lblBuyer.setBounds(new Rectangle(20, 83, 56, 19));
    lblMaker.setText("MAKER");
    lblMaker.setBounds(new Rectangle(16, 116, 60, 20));
    lblCustLabel.setText("Cust Label");
    lblCustLabel.setBounds(new Rectangle(231, 116, 70, 23));
    txtCustLbl.setText("");
    txtCustLbl.setBounds(new Rectangle(312, 116, 154, 21));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCenter, null);
    this.add(lblCenter, null);



    this.add(cbxSeason, null);
    this.add(lblSeason, null);
    this.add(txtDelTo, null);
    this.add(lblDivision, null);
    this.add(btnQry, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(lblDDFrom, null);
    this.add(txtDelFrom, null);
    this.add(lblYear2, null);
    //this.add(lblUnship, null);

    this.add(lblBuyer, null);
    this.add(buyers, null);
    this.add(lblDivision, null);
    this.add(cbxDivision, null);
    this.add(lblMaker, null);
    this.add(makers, null);
    this.add(jLabel1, null);
    this.add(cbxManager, null);
    this.add(txtCustLbl, null);
    this.add(cbxDivision, null);
    this.add(lblDep,null);
    this.add(cbxDep,null);
    this.add(lblCustLabel,null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      doingDB2Gui=true;
      dataBindComps.clear();
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



      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(dbCbxCenter);

      Vector seasons=newtimes.preproduction.guis.tempProperties.tmpSeason;
      dbCbxSzn= new exgui.DataBindJCombobox(
          cbxSeason,"P_SEASON",
          seasons,"SEA_NAME","SEA_NAME","ALL","ALL",null);
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

     Object vftxtBuyerLabel = exgui.verification.CellFormat.getOrdinaryField(
       50);
    dataBindComps.add(new exgui.DataBindTextWithChecker(txtCustLbl,
       "P_LABEL", null, 50,
                     (exgui.Object2String) vftxtBuyerLabel,
                     (exgui.ultratable.CellTxtEditorFormat) vftxtBuyerLabel)
                     );

       reportName = "ord_sum.rpt";

     doingDB2Gui=false;
     cbxCenter.addItemListener(new cbxCenterItemChanged());
     cbxCenter.getItemListeners()[0].itemStateChanged(null);
   }catch(Exception exp){
      exp.printStackTrace();
   }
 }
 class cbxCenterItemChanged implements java.awt.event.ItemListener {
   public void itemStateChanged(ItemEvent e) {
     if(doingDB2Gui)return;
      udpateDepComboBox();
   }
 }
 protected void reGenMangers(){
   Vector vctMng=
       (Vector)newtimes.preproduction.guis.tempProperties.tmpHm_Managers4AllCenters.get(
       dbCbxCenter.getSelectedValue());
   if(vctMng==null){
           //vctMng=new Vector();
           vctMng=newtimes.preproduction.guis.tempProperties.tmpManagerRecs;
   }
   dbCbxManager =
       new exgui.DataBindJCombobox(
       cbxManager, "P_MANAGER",
       vctMng,
       "MNG_ABBR", "MNG_CODE", "ALL", "ALL", null);
    //indexCbxMng=dataBindComps.size();
    dataBindComps.set(indexCbxMng,dbCbxManager);
 }

 protected void udpateDepComboBox(){
   boolean haveAllDep=true;
   if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
    util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
    haveAllDep=false;
   }
   if(!haveAllDep){
     Vector depVects=
         (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
         dbCbxCenter.getSelectedValue());
     reGenMangers();
       dbCbxDep =
           new exgui.DataBindJCombobox(
           cbxDep, "P_DEP",
           depVects,
           "DEP_NAME", "DEP_CODE",
           "ALL");
     return;
   }

   Vector depVects=
       (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
       dbCbxCenter.getSelectedValue());
   reGenMangers();
     dbCbxDep =
         new exgui.DataBindJCombobox(
         cbxDep, "P_DEP",
         depVects,
         "DEP_NAME", "DEP_CODE",
         "ALL",
         "ALL", null);
     //dataBindComps.add(dbCbxDep[i]);

   String usingCenterCode=(String)dbCbxCenter.getSelectedValue();
    if(usingCenterCode==null || usingCenterCode.trim().length()==0)usingCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;

     buyers.setSelectingCenter(usingCenterCode);
     makers.setSelectingCenter(usingCenterCode);

 }

  protected java.util.HashMap composeParameters(){
    HashMap hm = super.composeParameters();
      Object buyObj=buyers.getSelectedValue();
      hm.put("P_BUYER",((buyObj==null)?"0":buyObj.toString()));
      Object makObj=makers.getSelectedValue();
      hm.put("P_MAKER",((makObj==null)?"0":makObj.toString()));
    if(txtYear.getText().trim().length()==0){
      hm.put("P_YEAR","ALL");
    }
    if(txtCustLbl.getText().trim().length()==0){
      hm.put("P_LABEL","ALL");
    }
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd=dbTxtDateEnd.getSelectedValue();
    if(dateBgn==null){
      hm.put("P_DEL_FM","DATE(2000,01,01)");
    }
    if(dateEnd==null){
      hm.put("P_DEL_TO","DATE(2099,12,31)");
    }
    hm.put("P_DEP",(dbCbxDep.getSelectedValue()==null)?"ALL":(String)dbCbxDep.getSelectedValue());
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
  JLabel jLabel1 = new JLabel();
  JComboBox cbxManager = new JComboBox();
  JLabel lblDep = new JLabel();
  JLabel lblBuyer = new JLabel();
  JLabel lblMaker = new JLabel();
  JLabel lblCustLabel = new JLabel();
  JTextField txtCustLbl = new JTextField();
}
