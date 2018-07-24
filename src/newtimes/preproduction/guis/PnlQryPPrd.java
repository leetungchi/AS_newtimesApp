package newtimes.preproduction.guis;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import exgui2.*;
import newtimes.preproduction.buyermakerselect.*;
import java.util.Vector;
import exgui.*;
import java.awt.event.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryPPrd extends JPanel {
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  JLabel whiteBkgBlueCharLabel2 = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JTextField txtYear = new JTextField();
  int depCbxDBGUI_index=0;
  int divCbxDBGUI_index=0;
  int yearTxtDBGUI_index=0;
  int mngCbxDBGUI_index=0;

  JButton jbtnExtract = new JButton();
  JButton jbtnAddNew = new JButton();
  JButton jbtnEXIT = new JButton();
  //below comboboxes are declared as public,allow command object to initialize.
  JComboBox cbxCntr = new JComboBox();
  JComboBox cbxDep = new JComboBox();
  JComboBox cbxDiv = new JComboBox();
  JTextField txtGrp = new JTextField();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JComboBox cbxSzn = new JComboBox();
  java.util.List guis=new java.util.ArrayList();
  newtimesejb.preproduction.PreProductionHead prdHead;
  SelectSingleMaterialDetail slkMetrial = new SelectSingleMaterialDetail();
  JLabel whiteBkgBlueCharLabel5 = new JLabel();
  JTextField txtRange = new JTextField();
  JTextField txtProto = new JTextField();
  JLabel blueBkgWhiteCharLabel6 = new JLabel();
  JLabel lblPoNo = new JLabel();
  JTextField txtStyPo = new JTextField();
  JLabel lblSytleNo = new JLabel();
  JTextField txtStyStyle = new JTextField();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  exgui.DataBindJCombobox DbJcbxcbxDiv ;
  boolean doingDB2Gui=false;
  JComboBox cbxAuditStatus = new JComboBox(
      new String[]
      {"ALL","Editing","Wait Confirm","Confirmed","Rejected","Printed"}
      );
  JLabel lblAdtStats = new JLabel();
  JLabel lblMgrs = new JLabel();
  JComboBox cbxMgrs = new JComboBox();
  JLabel lblQryDirectPK = new JLabel();
  JTextField txtProdHeadPK = new JTextField();
  JTextField txtSCKeyWord = new JTextField();
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JLabel lblType = new JLabel();
  JComboBox cbxProdType = new JComboBox();
  JComboBox cbxQcCountry = new JComboBox();
  JLabel lblQcCountry = new JLabel();//for listing key
  DataBindJCombobox dbJcbxQcCountry,dbJcbxProdType;
  exgui.DataBindTextWithChecker  dbTxtYear;
  int index_of_cityCbx=0;
  Object defaultDepValue;
  public PnlQryPPrd() {
    try {
      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
         util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
         defaultDepValue=util.PublicVariable.USER_RECORD.get("usr_Dep_code");
      }else{
        defaultDepValue=null;
      }
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {

    setBackground(new java.awt.Color(204, 204, 225));
    this.setSize(new Dimension(800, 600));
    blueBkgWhiteCharLabel1.setText("Center");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(98, 34, 60, 19));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("Department");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(433, 33, 73, 18));
    blueBkgWhiteCharLabel2.setText("Division");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(97, 181, 44, 18));
    whiteBkgBlueCharLabel2.setText("Group");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(432, 181, 37, 18));
    blueBkgWhiteCharLabel3.setText("Season");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(96, 82, 52, 21));
    blueBkgWhiteCharLabel4.setText("Buyer"+
                                     ((util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("NTHK"))?" Code":"")
                                   );
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(98, 134, 86, 20));
    whiteBkgBlueCharLabel4.setText("Maker");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(435, 134, 55, 18));
    blueBkgWhiteCharLabel5.setText("Material No.");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(98, 226, 75, 21));
    jbtnExtract.setBounds(new Rectangle(73, 515, 129, 30));
    jbtnExtract.setFont(new java.awt.Font("Serif", 1, 11));
    jbtnExtract.setVerifyInputWhenFocusTarget(true);
    jbtnExtract.setText("EXTRACT");
    jbtnExtract.addActionListener(new PnlQryPPrd_jbtnExtract_actionAdapter(this));
    jbtnAddNew.setBounds(new Rectangle(322, 515, 91, 32));
    jbtnAddNew.setFont(new java.awt.Font("Serif", 1, 11));
    jbtnAddNew.setText("ADD NEW");
    jbtnAddNew.addActionListener(new PnlQryPPrd_jbtnAddNew_actionAdapter(this));
    jbtnEXIT.setText("EXIT");
    jbtnEXIT.addActionListener(new PnlQryPPrd_jbtnEXIT_actionAdapter(this));
    jbtnEXIT.setFont(new java.awt.Font("Serif", 1, 11));
    jbtnEXIT.setBounds(new Rectangle(623, 515, 91, 32));
    cbxCntr.setBounds(new Rectangle(188, 35, 130, 18));
    cbxDep.setBounds(new Rectangle(517, 34, 130, 18));
    cbxDiv.setBounds(new Rectangle(188, 181, 130, 20));
    txtGrp.setBounds(new Rectangle(514, 181, 130, 19));
    txtGrp.setText("jTextField1");
    txtGrp.setText("");
    slkBuyer.setBounds(new Rectangle(188, 134, 132, 20));
    slkMaker.setBounds(new Rectangle(514, 134, 130, 21));
    cbxSzn.setBounds(new Rectangle(188, 83, 132, 21));
    slkMetrial.setBounds(new Rectangle(188, 226, 131, 21));
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(433, 226, 76, 18));
    whiteBkgBlueCharLabel5.setText("Board RNG");
    whiteBkgBlueCharLabel5.setVerticalAlignment(SwingConstants.CENTER);
    txtRange.setText("");
    txtRange.setText("");
    txtRange.setBounds(new Rectangle(514, 226, 130, 20));
    txtProto.setBounds(new Rectangle(188, 274, 127, 22));
    txtProto.setText("");
    txtProto.setText("");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(98, 274, 54, 21));
    blueBkgWhiteCharLabel6.setText("Proto");
    lblPoNo.setVerticalAlignment(SwingConstants.CENTER);
    lblPoNo.setText("PO No.");
    lblPoNo.setBounds(new Rectangle(433, 274, 57, 18));
    txtStyPo.setBounds(new Rectangle(514, 274, 130, 22));
    txtStyPo.setText("");
    txtStyPo.setText("");
    lblSytleNo.setText("Style No");
    lblSytleNo.setBounds(new Rectangle(98, 319, 56, 21));
    txtStyStyle.setText("");
    txtStyStyle.setText("");
    txtStyStyle.setBounds(new Rectangle(188, 319, 128, 22));
    cbxAuditStatus.setBounds(new Rectangle(517, 385, 130, 20));
    lblAdtStats.setText("Audit Status");
    lblAdtStats.setBounds(new Rectangle(433, 385, 73, 22));
    lblMgrs.setBounds(new Rectangle(97, 401, 59, 21));
    lblMgrs.setText("Manager");
    cbxMgrs.setBounds(new Rectangle(188, 401, 132, 21));
    lblQryDirectPK.setText("<html><body>PRODUCTION<br> Ref. No.</body></html>");
    lblQryDirectPK.setBounds(new Rectangle(434, 305, 85, 48));
    txtProdHeadPK.setBounds(new Rectangle(514, 319, 130, 22));
    txtSCKeyWord.setText("");
    txtSCKeyWord.setBounds(new Rectangle(514, 438, 130, 21));
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(435, 438, 50, 18));
    whiteBkgBlueCharLabel6.setText("S/C No.");
    lblType.setText("TYPE");
    lblType.setBounds(new Rectangle(98, 368, 68, 23));
    cbxProdType.setBounds(new Rectangle(188, 368, 132, 20));
    cbxQcCountry.setBounds(new Rectangle(514, 368, 140, 20));
    lblQcCountry.setBounds(new Rectangle(437, 364, 68, 36));
    lblQcCountry.setText("<html><body>QC<br>Country</body></html>");
    txtYear.setBounds(new Rectangle(516, 82, 130, 21));
    txtYear.setText("jTextField1");
    txtYear.setText("");
    jLabel1.setText("Year");
    jLabel1.setBounds(new Rectangle(433, 81, 80, 24));
    lblCity.setText("CITY");
    lblCity.setBounds(new Rectangle(437, 401, 70, 22));
    cbxCity.setBounds(new Rectangle(514, 401, 140, 20));
    lblDest.setText("Destination");
    lblDest.setBounds(new Rectangle(96, 438, 78, 21));
    cbxDestination.setBounds(new Rectangle(188, 438, 168, 21));
    slkVender.setBounds(new Rectangle(322, 255, 132, 20));
    rdoAll.setBackground(new Color(204, 204, 225));
    rdoAll.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoAll.setSelected(true);
    rdoAll.setText("All");
    rdoAll.setBounds(new Rectangle(512, 461, 54, 26));
    rdoOnlySamle.setBounds(new Rectangle(574, 461, 99, 26));
    rdoOnlySamle.setText("Only Sample");
    rdoOnlySamle.setBackground(new Color(204, 204, 225));
    rdoOnlySamle.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpload.setBounds(new Rectangle(471, 515, 91, 32));
    btnUpload.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpload.setText("UPLOAD");
    btnUpload.addActionListener(new PnlQryPPrd_btnUpload_actionAdapter(this));
    txtBatchNo.setBounds(new Rectangle(516, 488, 130, 21));
    txtBatchNo.setText("");
    txtCust_Po.setBounds(new Rectangle(188, 488, 130, 21));
    txtCust_Po.setText("");
    lblBatchNo.setText("Batch #.");
    lblBatchNo.setBounds(new Rectangle(434, 489, 73, 18));
    lblCust_Po.setText("Cust P.O.");
    lblCust_Po.setBounds(new Rectangle(95, 489, 83, 18));
    this.add(txtYear, null);
    this.add(cbxCntr, null);
    this.add(slkMetrial, null);
    this.add(txtProto, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxDep, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(txtRange, null);
    this.add(lblPoNo, null);
    this.add(txtStyPo, null);
    this.add(cbxSzn, null);
    this.add(cbxDiv, null);
    this.add(txtGrp, null);
    this.add(slkBuyer, null);
    this.add(slkMaker, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(lblAdtStats, null);
    this.add(cbxAuditStatus, null);
    this.add(cbxProdType, null);
    this.add(lblType, null);
    this.add(lblSytleNo, null);
    this.add(txtProdHeadPK, null);
    this.add(txtStyStyle, null);
    this.add(lblQryDirectPK, null);
    this.add(cbxQcCountry, null);
    this.add(lblQcCountry, null);
    this.add(jLabel1, null);
    this.add(whiteBkgBlueCharLabel6, null);
    this.add(txtSCKeyWord, null);
    this.add(lblCity, null);
    this.add(cbxCity, null);
    this.add(lblMgrs, null);
    this.add(cbxMgrs, null);
    this.add(lblDest, null);
    this.add(cbxDestination, null);
    this.add(slkVender, null);
    this.add(rdoAll, null);
    this.add(rdoOnlySamle, null);
    this.add(jbtnEXIT, null);
    this.add(jbtnExtract, null);
    this.add(jbtnAddNew, null);
    /*
    if(util.PublicVariable.USER_RECORD.get(0).equals("PWWINGYEUNG")&&
       "PW".equals(util.PublicVariable.OPERATTING_CENTER)){
      this.add(btnUpload, null);
    }*/
    if(((String)((Record)newtimes.preproduction.guis.tempProperties.tmpDepartment.get(0)).get("DEP_NAME")).trim().indexOf("JANE WAN")!=-1||
       ((String)util.PublicVariable.USER_RECORD.get(0)).indexOf("ANTHONYLIU")!=-1||
       "DENNIS".equals(util.PublicVariable.USER_RECORD.get(0))){
      this.add(btnUpload, null);
    }

    if(util.PublicVariable.OPERATTING_CENTER.equals("001")||util.PublicVariable.OPERATTING_CENTER.equals("HKNB")){
      if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
        this.add(btnUpload, null);
      }else{
        lblBatchNo.setVisible(false);
        txtBatchNo.setVisible(false);
      }
    }else{
      lblBatchNo.setVisible(false);
      txtBatchNo.setVisible(false);
    }
    slkBuyer.init(prdHead.QRY_CONDITION_BUYER,null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init(prdHead.QRY_CONDITION_MAKER,null,slkBuyer.TYPE_MAKER,true);
    slkMetrial.setIniValue(prdHead.QRY_CONDITION_MATERIAL,null);
    guis.clear();
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxQcCountry.addItemListener(new cbxQcCountryChanged());
    lblAdtStats.setVisible(false);
    cbxAuditStatus.setVisible(false);
    //lblQryDirectPK.setVisible(false);
    //txtProdHeadPK.setVisible(false);
    try{
      int user_type=util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
      switch(user_type){
        case newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS:
        case newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS:
        case newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS:
        jbtnAddNew.setEnabled(false);
      }
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
    }

    if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
      if((util.PublicVariable.USER_RECORD.getInt(2)==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS)||
         (util.PublicVariable.USER_RECORD.getInt(2)==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS)
         ){
        if(!util.PublicVariable.USER_RECORD.get(0).equals("WIRENEYU")){
          jbtnAddNew.setEnabled(false);
        }
      }
    }


    if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
      slkVender.init("CT_VENDER", null, slkVender.TYPE_VENDOR, true);
      slkVender.setBounds(txtProto.getBounds());
      txtProto.setVisible(false);
      blueBkgWhiteCharLabel6.setText("Vendor");
    }else{
      blueBkgWhiteCharLabel6.setText("Proto");
      slkVender.setVisible(false);
    }
    btnGrpOnlSample.add(rdoAll);
    btnGrpOnlSample.add(rdoOnlySamle);
    this.add(lblBatchNo, null);
    this.add(lblCust_Po, null);
    this.add(txtBatchNo, null);
    this.add(txtCust_Po, null);
    if(!"001".equals(util.PublicVariable.OPERATTING_CENTER)){
       rdoAll.setVisible(false);
       rdoOnlySamle.setVisible(false);
    }

  }
  class cbxQcCountryChanged implements java.awt.event.ItemListener{
    public void itemStateChanged(ItemEvent e){
      if(doingDB2Gui)return;
      cbxCountry_itemStateChanged(e);
    }
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener{
    protected void updateManagerComboBox(){
      String descCenCode=DbJcbxcbxCntr.getSelectedValue().toString();
      util.PublicVariable.OPERATTING_CENTER=(String)DbJcbxcbxCntr.getSelectedValue();

      Vector destManager=(Vector)
          tempProperties.tmpHm_Managers4AllCenters.get(descCenCode);
      tempProperties.tmpManagerRecs.clear();
      tempProperties.tmpManagerRecs.addAll(destManager);
      exgui.DataBindJCombobox DbJcbxcbxMgrs =
          new exgui.DataBindJCombobox(
            cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
            destManager,
            "MNG_ABBR","MNG_CODE",null,"ALL",null);
      guis.set(mngCbxDBGUI_index,DbJcbxcbxMgrs);
      slkBuyer.setSelectingCenter(descCenCode);
      slkMaker.setSelectingCenter(descCenCode);

    }
    public void itemStateChanged(ItemEvent e){
      if(doingDB2Gui)return;
      util.PublicVariable.OPERATTING_CENTER=(String)DbJcbxcbxCntr.getSelectedValue();

      try{
        //find out the vector to add dbDeps.
        if (DbJcbxcbxCntr.getSelectedValue()==null) {
          //only the all dep is allow to add now.
          exgui.DataBindJCombobox DbJcbxcbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, prdHead.QRY_CONDITION_DEPARTMENT,
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              defaultDepValue,
              "ALL", null);
          if(depCbxDBGUI_index == guis.size()) {
            guis.add(DbJcbxcbxDep);
          }else{
            //just replace after display & change;
            guis.set(depCbxDBGUI_index,DbJcbxcbxDep);
          }
        }else {
          //deps and "ALL"dep allow to add.
          slkBuyer.setSelectingCenter((String)DbJcbxcbxCntr.getSelectedValue());
          slkMaker.setSelectingCenter((String)DbJcbxcbxCntr.getSelectedValue());
          slkBuyer.init(prdHead.QRY_CONDITION_BUYER,null,slkBuyer.TYPE_BUYER,true);
          slkMaker.init(prdHead.QRY_CONDITION_MAKER,null,slkBuyer.TYPE_MAKER,true);


          Vector depVects=
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          exgui.DataBindJCombobox DbJcbxcbxDep=null;

          if(depVects==null){
            DbJcbxcbxDep =
               new exgui.DataBindJCombobox(
               cbxDep, prdHead.QRY_CONDITION_DEPARTMENT,
               new Vector(),
               "DEP_NAME", "DEP_CODE",
               defaultDepValue,
               "ALL", null);
          }else if(depVects.size()>1){
             DbJcbxcbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, prdHead.QRY_CONDITION_DEPARTMENT,
                depVects,
                "DEP_NAME", "DEP_CODE",
                defaultDepValue,
                "ALL", null);
            //guis.add(DbJcbxcbxDep);
          }else{
            DbJcbxcbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, prdHead.QRY_CONDITION_DEPARTMENT,
                depVects,
                "DEP_NAME", "DEP_CODE",
                defaultDepValue);
            //guis.add(DbJcbxcbxDep);


          }

          if (depCbxDBGUI_index == guis.size()) {
             guis.add(DbJcbxcbxDep);
          }else{
            guis.set(depCbxDBGUI_index,DbJcbxcbxDep);
          }

          String loginCenCode=util.PublicVariable.OPERATTING_CENTER.toString();
          int loginLevel=util.PublicVariable.USER_RECORD.getInt(2);//level code
          //'NTHK','NTFE','NTD','NJ','CG','PW','AE','BW'
          if((loginCenCode.equals("NTHK")||
             loginCenCode.equals("NTFE")||
             loginCenCode.equals("NJ")||
             loginCenCode.equals("NTD")||
             loginCenCode.equals("CG")||
             loginCenCode.equals("PW")||
             loginCenCode.equals("AE")||
             loginCenCode.equals("BW")) &&
             (loginLevel==newtimesejb.preproduction.PreProductionHead.USER_TYPE_CEO||
              loginLevel==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS||
              loginLevel==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS)){
              updateManagerComboBox();
          }

        }
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }
  public void activate()throws Exception{
    doingDB2Gui=true;
    //use the ejb interface to generate the combobox for query.
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    guis.clear();
    if(tempProperties.tmpCenters.size()>1){
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, prdHead.QRY_CONDITION_CENTER,
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      guis.add(DbJcbxcbxCntr);
    }else{
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, prdHead.QRY_CONDITION_CENTER,
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      guis.add(DbJcbxcbxCntr);
    }
    depCbxDBGUI_index=guis.size();
    //occupy a position for cmobobox dep
    guis.add(new Vector());

    DbJcbxcbxDiv =
        new exgui.DataBindJCombobox(
          cbxDiv,prdHead.QRY_CONDITION_DIVISION,
          new Vector(),
          "DIV_NAME","DIV_CODE",null,"ALL",null);
    divCbxDBGUI_index=guis.size();//division need to change on chage of buyer.
    guis.add(DbJcbxcbxDiv);


    exgui.DataBindJCombobox DbJcbxcbxSzn =
        new exgui.DataBindJCombobox(
          cbxSzn,prdHead.QRY_CONDITION_SEASON,
          tempProperties.tmpSeason,
          "SEA_NAME","SEA_NAME",null,"ALL",null);
    guis.add(DbJcbxcbxSzn);

    if(util.PublicVariable.USER_RECORD.getInt("usr_type")==
       prdHead.USER_TYPE_DIRECTOR){
      exgui.DataBindJCombobox DbJcbxcbxMgrs =
          new exgui.DataBindJCombobox(
            cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
            tempProperties.tmpManagerRecs,
            "MNG_ABBR","MNG_CODE",null,"ALL",null);
      mngCbxDBGUI_index=guis.size();
      guis.add(DbJcbxcbxMgrs);
    }
    if(util.PublicVariable.USER_RECORD.getInt("usr_type")==
       prdHead.USER_TYPE_MANAGER){
      if(((String)util.PublicVariable.USER_RECORD.get("USR_MNG_MOD")).
         equalsIgnoreCase("y")){
        exgui.DataBindJCombobox DbJcbxcbxMgrs =
            new exgui.DataBindJCombobox(
              cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
              tempProperties.tmpManagerRecs,
              "MNG_ABBR","MNG_CODE",null,"ALL",null);
        mngCbxDBGUI_index=guis.size();
        guis.add(DbJcbxcbxMgrs);
      }else{
        exgui.DataBindJCombobox DbJcbxcbxMgrs =
            new exgui.DataBindJCombobox(
              cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
              tempProperties.tmpManagerRecs,
              "MNG_ABBR","MNG_CODE",
              util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"));
        mngCbxDBGUI_index=guis.size();
        guis.add(DbJcbxcbxMgrs);
      }
    }else  if(util.PublicVariable.USER_RECORD.getInt("usr_type")==
       prdHead.USER_TYPE_USERS){
      exgui.DataBindJCombobox DbJcbxcbxMgrs =
          new exgui.DataBindJCombobox(
            cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
            tempProperties.tmpManagerRecs,
            "MNG_ABBR","MNG_CODE",
            util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"),
            "None Manager","None Manager");
      mngCbxDBGUI_index=guis.size();
      guis.add(DbJcbxcbxMgrs);
    }else{
      exgui.DataBindJCombobox DbJcbxcbxMgrs =
          new exgui.DataBindJCombobox(
            cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
            tempProperties.tmpManagerRecs,
            "MNG_ABBR","MNG_CODE",null,"ALL",null);
      mngCbxDBGUI_index=guis.size();
      guis.add(DbJcbxcbxMgrs);
    }
    slkBuyer.setModifyNotifyTo(new ChangeBuyerHandler()) ;
    guis.add(slkBuyer);
    guis.add(slkMaker);
    guis.add(slkMetrial);

         Object objCnv=exgui.verification.CellFormat.getOrdinaryField(4);
         //default year is from system_default_value.
         database.datatype.Record recSysValue=newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD;
         //System.out.println("system default value is:"+recSysValue.toString());

    dbTxtYear=new  exgui.DataBindTextWithChecker(
              txtYear,prdHead.QRY_CONDITION_YEAR,
              null,4,
              (exgui.Object2String)objCnv,
              (exgui.ultratable.CellTxtEditorFormat)objCnv);
    yearTxtDBGUI_index=guis.size();
    guis.add(dbTxtYear);

    Object objCnv2=exgui.verification.CellFormat.getOrdinaryField(40);
    exgui.DataBindTextWithChecker dbTxtGrp=new  exgui.DataBindTextWithChecker(
              txtGrp,prdHead.QRY_CONDITION_GROUP,null,40,(exgui.Object2String)objCnv2,(exgui.ultratable.CellTxtEditorFormat)objCnv2);
    guis.add(dbTxtGrp);


    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      Object objCnvRange=exgui.verification.CellFormat.getOrdinaryField(40);
      whiteBkgBlueCharLabel5.setText("Board RNG");
      exgui.DataBindTextWithChecker dbTxtRange = new exgui.
          DataBindTextWithChecker(
          txtRange, prdHead.CONDITION_KEY_RANGE, null,
          40, (exgui.Object2String)objCnvRange,
          (exgui.ultratable.CellTxtEditorFormat)objCnvRange);
      guis.add(dbTxtRange);
    }else{
      Object objCnvRange=exgui.verification.CellFormat.getOrdinaryField(50);
      whiteBkgBlueCharLabel5.setText("Buyer Label");
      exgui.DataBindTextWithChecker dbTxtRange = new exgui.
          DataBindTextWithChecker(
          txtRange, "prodXN.prod_label", null,
          50, (exgui.Object2String)objCnvRange,
          (exgui.ultratable.CellTxtEditorFormat)objCnvRange);
      guis.add(dbTxtRange);


      /*
      whiteBkgBlueCharLabel5.setText("Cust. Po. No.");
      exgui.DataBindTextWithChecker dbTxtRange = new exgui.
          DataBindTextWithChecker(
          txtRange, "prodxn.prod_byr_sc_no", null,
          15, (exgui.Object2String)objCnvRange,
          (exgui.ultratable.CellTxtEditorFormat)objCnvRange);
      guis.add(dbTxtRange);*/
    }



    Object objCnvProto=exgui.verification.CellFormat.getOrdinaryField(40);
    exgui.DataBindTextWithChecker dbTxtProto=new  exgui.DataBindTextWithChecker(
              txtProto,prdHead.CONDITION_KEY_PROTO_NO,null,40,(exgui.Object2String)objCnvProto,(exgui.ultratable.CellTxtEditorFormat)objCnvProto);
    guis.add(dbTxtProto);

    Object objCnvStylePO=exgui.verification.CellFormat.getOrdinaryField(30);
    exgui.DataBindTextWithChecker dbTxtStlyePO=new  exgui.DataBindTextWithChecker(
              txtStyPo,prdHead.CONDITION_KEY_STY_PO,null,30,(exgui.Object2String)objCnvStylePO,(exgui.ultratable.CellTxtEditorFormat)objCnvStylePO);
    guis.add(dbTxtStlyePO);

    Object objCnvStyleSTYLE=exgui.verification.CellFormat.getOrdinaryField(25);
    exgui.DataBindTextWithChecker dbTxtStlyeSTYLE=new  exgui.DataBindTextWithChecker(
              txtStyStyle,prdHead.CONDITION_KEY_STY_STYLE,null,25,(exgui.Object2String)objCnvStyleSTYLE,(exgui.ultratable.CellTxtEditorFormat)objCnvStyleSTYLE);
    guis.add(dbTxtStlyeSTYLE);

    Object objCnvPROD_SC_NO=exgui.verification.CellFormat.getOrdinaryField(15);
    exgui.DataBindTextWithChecker dbTxtProdSC=new  exgui.DataBindTextWithChecker(
          txtSCKeyWord,prdHead.CONDITION_KEY_BGN_SC_NO,null,15,
          (exgui.Object2String)objCnvPROD_SC_NO,
          (exgui.ultratable.CellTxtEditorFormat)objCnvPROD_SC_NO);
     guis.add(dbTxtProdSC);


    Object objPRODHEADPK=exgui.verification.CellFormat.getIntVerifierAllowNull(10);
    exgui.DataBindTextWithChecker dbTxtProdHeadPK=new  exgui.DataBindTextWithChecker(
              txtProdHeadPK,
              prdHead.CONDITION_KEY_ONLY_PROD_HEAD_PK+
              ((util.PublicVariable.OPERATTING_CENTER.equals("001"))?">":""),
              null,10,
              (exgui.Object2String)objPRODHEADPK,
              (exgui.ultratable.CellTxtEditorFormat)objPRODHEADPK);
    guis.add(dbTxtProdHeadPK);

    dbJcbxQcCountry =
        new exgui.DataBindJCombobox(
          cbxQcCountry,prdHead.CONDITION_KEY_QC_COUNTRY,
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME","CNTY_NAME",null,"ALL",null);
    guis.add(dbJcbxQcCountry);

    dbJcbxProdType =
        new exgui.DataBindJCombobox(
          cbxProdType,prdHead.CONDITION_KEY_PROD_TYPE ,
          newtimes.preproduction.guis.tempProperties.tmpProdType,
          "TYPE_NAME","TYPE_CODE",null,"ALL",null);
    guis.add(dbJcbxProdType);
    index_of_cityCbx=guis.size();
    guis.add(null);
    doingDB2Gui=false;
    cbxCntr.getItemListeners()[0].itemStateChanged(null);
    cbxQcCountry.getItemListeners()[0].itemStateChanged(null);

    guis.add(new exgui.DataBindJCombobox(
                cbxDestination, "prodXN.prod_TGT_DEST",
                newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations(),
                "Dest_name","dest_name", null,"",null));//,20));

  }catch(Exception e){
    //e.printStackTrace();
    throw e;
  }finally{
    jframe.getContentPane().setCursor(ksr);
  }
}
void cbxCountry_itemStateChanged(ItemEvent e) {
try{
   if(!doingDB2Gui){
     //the last object is databinded combobox of city list

     guis.set(index_of_cityCbx,
             getCityComboboxByCountry(
             dbJcbxQcCountry.getSelectedValue(),
              cbxCity)
     );
   }
  }catch(Exception exp){
    exp.printStackTrace();
  }

}

protected exgui.DataBindJCombobox getCityComboboxByCountry(Object cntyName,
    JComboBox cbx)throws Exception{
    Vector citiesVct=null;;
    if(cntyName!=null){
       citiesVct=(Vector)tempProperties.tmpH_tbl_CntyCityMap.get(cntyName);
    }
    if(citiesVct==null)citiesVct=new Vector();
    cbx.removeAllItems();
    exgui.DataBindJCombobox DbJcbxcbxCity =
        new exgui.DataBindJCombobox(cbx,
                                    "a.PROD_CITY_NAME",
                                    citiesVct,
                                    "CITY_NAME","CITY_NAME",
                                    null,"NONE",null);
      DbJcbxcbxCity.toMustModify();
      return  DbJcbxcbxCity;

}

public class ChangeBuyerHandler
    implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
  public void changeBuyerMaker(Record buyerRecord){
    //recompose the division combobox of buyer.
    if(doingDB2Gui)return;
    try{
      //find out the vector to add dbDeps.
      if (buyerRecord==null) {
        //only the all dep is allow to add now.
        DbJcbxcbxDiv=new exgui.DataBindJCombobox(
            cbxDiv,
            prdHead.QRY_CONDITION_DIVISION,
            new Vector(),
            "DIV_NAME","DIV_CODE",
            null,"N/A",null);
        //cbxDiv.setUI(new exgui.WideComboBoxUI(160));

        if(divCbxDBGUI_index == guis.size()) {
          guis.add(DbJcbxcbxDiv);
        }else{
          //just replace after display & change;
          guis.set(divCbxDBGUI_index,DbJcbxcbxDiv);
        }

      }else {
        //deps and "ALL"dep allow to add.
        Vector dvsnRecords=
            (Vector)tempProperties.tmpHMap_BuyerDivison.get(
            buyerRecord.get(0).toString());
         DbJcbxcbxDiv=null;
        if(dvsnRecords==null){
          DbJcbxcbxDiv=new exgui.DataBindJCombobox(
              cbxDiv,
              prdHead.QRY_CONDITION_DIVISION,
              new Vector(),
              "DIV_NAME",
              "DIV_CODE",
              null,"N/A",null);
          //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
        }else {
          DbJcbxcbxDiv=new exgui.DataBindJCombobox(
              cbxDiv,
              prdHead.QRY_CONDITION_DIVISION,
              dvsnRecords,
              "DIV_NAME",
              "DIV_CODE",
             null,"N/A",null);
          //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
        }

        if (divCbxDBGUI_index == guis.size()) {
          guis.add(DbJcbxcbxDiv);
        }else{
          guis.set(divCbxDBGUI_index,DbJcbxcbxDiv);
        }
      }

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
}





  protected void updateCenterDepMap(java.util.Vector depRecords){
    tempProperties.tmpH_tbl_CenterDepMap.clear();
    String lastCenterName=null;
    for(int i=0;i<depRecords.size();i++){
      database.datatype.Record rec=(database.datatype.Record)depRecords.get(i);
      String xntCenName=(String)rec.get(4);
      if(tempProperties.tmpH_tbl_CenterDepMap.containsKey(xntCenName)){
        Vector tmpVct=(Vector)tempProperties.tmpH_tbl_CenterDepMap.get(xntCenName);
        tmpVct.add(rec);
      }else{
        Vector newVct=new Vector();
        newVct.add(rec);
        tempProperties.tmpH_tbl_CenterDepMap.put(xntCenName,newVct);
      }
    }
  }
  void jbtnExtract_actionPerformed(ActionEvent e) {
  //before entering next page,list query result,set the conditions to ejb to findout datas...
    java.util.HashMap conditions=new java.util.HashMap();

    for(int i=0;i<guis.size();i++){
       exgui.DataBindGUIObject  dbGUIOBJ=(exgui.DataBindGUIObject)guis.get(i);
       if(dbGUIOBJ instanceof exgui.DataBindTextWithChecker ){
         if(!((exgui.DataBindTextWithChecker)dbGUIOBJ).isValidx()) return;
         if(dbGUIOBJ instanceof exgui.SwingSingleSelection){
           Object value=((exgui.SwingSingleSelection)dbGUIOBJ).getSelectedValue();
           if(value!=null)conditions.put(dbGUIOBJ.getOrgRecField(),value);
         }
       }else{
         exgui.SwingSingleSelection slk=(exgui.SwingSingleSelection)dbGUIOBJ;
         if(slk.getSelectedValue()!=null){
           conditions.put(dbGUIOBJ.getOrgRecField(),slk.getSelectedValue());
         }
       }
    }
    if(cbxAuditStatus.getSelectedIndex()>0){
      conditions.put(prdHead.QRY_CONDITION_ADT_STATUS,
                     String.valueOf(cbxAuditStatus.getSelectedIndex()));
    }
    if(null!=slkVender.getSelectedValue()){
      conditions.put("CT_VENDER",slkVender.getSelectedValue().toString());
    }
    //handing all the conditions to Commnad set object,wait for querry result.
    if(rdoOnlySamle.isSelected()){
      conditions.put("a.PROD_IS_SAMPLE","Y");
    }
    if(txtBatchNo.getText().trim().length()>0){
      conditions.put("TPE_NB_BATCH_NO",txtBatchNo.getText().trim());
    }
//
    if(txtCust_Po.getText().trim().length()>0){
     conditions.put("CUST_PO",txtCust_Po.getText().trim());
   }
//

    newtimes.preproduction.process.PP_Maintain_CmdSet.qryConditions=conditions;
    util.ApplicationProperites.removeProperites(processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT);
    goCommand();
  }
  protected void goCommand(){
    try{
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.preproduction.process.TriggerPreprodList());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void jbtnEXIT_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrShowFuncList());

      //processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception ie){
      ie.printStackTrace();
    }
  }
  void  testToSwitchMode(){
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      newtimes.preproduction.Constants.swithToGeneralMode();
      return;
    }
    newtimes.preproduction.Constants.swithToNTHKMode();
    return;
   /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||
       util.PublicVariable.OPERATTING_CENTER.equals("NTFE")||
       util.PublicVariable.OPERATTING_CENTER.equals("CG")){
      newtimes.preproduction.Constants.swithToNTHKMode();
      return;
    }

   if(util.PublicVariable.USER_RECORD.get(0).toString().indexOf("ANTHONYLIU")!=-1){
     if (exgui.verification.VerifyLib.showConfirm(
         "User General Key In Mode or Fast Key In Mode ?\nY:For General Key In Mode,N:For Fast Key In Mode",
         "User or General Mode or Fast Key In Mode  ? ", true)
         ) {
       newtimes.preproduction.Constants.swithToGeneralMode();
     } else {
       newtimes.preproduction.Constants.swithToNTHKMode();
     }
     return;
   }
   newtimes.preproduction.Constants.swithToGeneralMode();*/
  }
  void jbtnAddNew_actionPerformed(ActionEvent e) {
     //assign a blank record to properties,call the command to execut...
     //ask to add production with color size or none color size.
     //TPE center ,is not allow to assigne s/c after po header is add,
     //if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
     testToSwitchMode();
     try{
       newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.setLength(0);
       newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.setLength(0);
       newtimes.preproduction.process.DB_Preprod db = newtimes.preproduction.
           process.DB_Preprod.getInstance();
       database.datatype.Record rec = db.getBlankRecord();
       //set default value of price term
       if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
         rec.set("PRODUCTION_SC_PRC_TRM", "CNF");
       }else{
         if(!"001".equals(util.PublicVariable.OPERATTING_CENTER)){
           rec.set("PRODUCTION_SC_PRC_TRM", "FOB");
         }
       }
       processhandler.template.Properties.getCenteralControler().
           setCurrentEditingMasterRecord(rec);
       processhandler.template.Properties.getCenteralControler().
           doCommandExecute(
           new newtimes.preproduction.process.TrggerEditAPreprod());
     }catch(Exception eii){
       eii.printStackTrace();
     }

  }
  JLabel jLabel1 = new JLabel();
  JLabel lblCity = new JLabel();
  JComboBox cbxCity = new JComboBox();
  JLabel lblDest = new JLabel();
  JComboBox cbxDestination = new JComboBox();
  SelectBuyerMaker slkVender = new SelectBuyerMaker();
  JRadioButton rdoAll = new JRadioButton();
  JRadioButton rdoOnlySamle = new JRadioButton();
  ButtonGroup btnGrpOnlSample = new ButtonGroup();
  JButton btnUpload = new JButton();
  JTextField txtBatchNo = new JTextField();
  JLabel lblBatchNo = new JLabel();

  JTextField txtCust_Po = new JTextField();
  JLabel lblCust_Po = new JLabel();

  void btnUpload_actionPerformed(ActionEvent e) {
    //test walmart format.
    /*
    try{
      java.io.File testFile=new java.io.File("G:\\WallMart\\WM_ColumnAdded.xls");
      java.io.BufferedInputStream   bis=new  java.io.BufferedInputStream(new java.io.FileInputStream(testFile));
      byte[] data2upload =new byte[bis.available()];
      bis.read(data2upload);
      bis.close();
      newtimesejb.excelhandler.WalMartUploadFacadeHome uploader=
          (newtimesejb.excelhandler.WalMartUploadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.excelhandler.WalMartUploadFacade");
      newtimesejb.excelhandler.WalMartUploadFacade ejbupload=uploader.create();
      ejbupload.uploadWarMart(data2upload,util.PublicVariable.USER_RECORD.get(0).toString());
      return;
    }catch(Exception exp){
      exp.printStackTrace();
    }
   */



     if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       DlgNbUploader dlgNbUpload=new  DlgNbUploader(util.PublicVariable.APP_FRAME,"Upload Excel Format",true);
       dlgNbUpload.setSize(560,345);
       exgui.UIHelper.setToScreenCenter(dlgNbUpload);
       dlgNbUpload.show();
       return;
     }
   class ThreadUpdateQtyDesc implements Runnable{
     newtimesejb.excelhandler.ExcelUploadHandler ejb2hndl;
     int stySeq;
     ThreadUpdateQtyDesc(newtimesejb.excelhandler.ExcelUploadHandler _hdl,
                         int _stySeq){
        ejb2hndl=_hdl;
        stySeq=_stySeq;
     }
     public void run(){
       try{
         ejb2hndl.refineQtyRec(stySeq,util.PublicVariable.USER_RECORD.get(0).toString());
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
       }
     }
   }
   class myFilter extends javax.swing.filechooser.FileFilter{
       public String ext;
       public String des;

       public boolean accept(java.io.File file){
           if(file != null) {
             if(file.isDirectory()) {
                return true;
             }
             String filename=file.getName();
             return filename.endsWith(ext);
           }
           return false;
       }
       public String getDescription(){
          return des;
      }

       public myFilter(String extension, String description) {
         if(extension!=null) ext=extension;
         if(description!=null) des=description;
       }

   }


    try{
      JFileChooser fc = new JFileChooser();
      fc.setDialogType(fc.OPEN_DIALOG);
      fc.setAcceptAllFileFilterUsed(false);
      fc.addChoosableFileFilter(new myFilter("xls","MS Excel file"));
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      int returnVal = fc.showDialog(this,
                                    "SELECT FILE");

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        util.MiscFunc.showProcessingMessage();
        java.io.File srcFile = fc.getSelectedFile();
          java.io.BufferedInputStream   bis=new
              java.io.BufferedInputStream(new java.io.FileInputStream(srcFile));
          byte[] data2upload =new byte[bis.available()];
          bis.read(data2upload);
          bis.close();

          if("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)){
            NTD_Upload.AeomcUploadFacadeHome uploader=
                (NTD_Upload.AeomcUploadFacadeHome)
                info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                "NTD_Upload.AeomcUploadFacade");
            NTD_Upload.AeomcUploadFacade ejbupload=uploader.create();
             util.MiscFunc.showProcessingMessage();
            String str=ejbupload.doUpload(data2upload,util.PublicVariable.USER_RECORD.get(0).toString());
            //write to file.
            String fileName=("c:\\"+String.valueOf(System.currentTimeMillis())+"_temp.html");
            java.io.File file=new java.io.File(fileName);
            java.io.FileWriter fw=new java.io.FileWriter(file);
            fw.write(str);
            fw.flush();
            fw.close();
            exgui.verification.VerifyLib.showPlanMsg("Upload OK","Upload OK");
            Runtime r = Runtime.getRuntime();
            Process win = r.exec("Explorer "+fileName);

            return;
          }


          if("HKNB".equals(util.PublicVariable.OPERATTING_CENTER)){
            newtimesejb.excelhandler.HkNbUploadFacadeHome uploader=
                (newtimesejb.excelhandler.HkNbUploadFacadeHome)
                info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                "newtimesejb.excelhandler.HkNbUploadFacade");
            newtimesejb.excelhandler.HkNbUploadFacade ejbupload=uploader.create();
             util.MiscFunc.showProcessingMessage();
            ejbupload.doUploadFile(data2upload,util.PublicVariable.USER_RECORD.get(0).toString());
            exgui.verification.VerifyLib.showPlanMsg("Upload OK","Upload OK");
            return;
          }



          newtimesejb.excelhandler.ExcelUploadHandlerHome uploader=
              (newtimesejb.excelhandler.ExcelUploadHandlerHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
              "newtimesejb.excelhandler.ExcelUploadHandler");
          newtimesejb.excelhandler.ExcelUploadHandler ejbupload=uploader.create();
          String timeStr=null;


          if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
            /*
            newtimesejb.excelhandler.ExcelUploadHandlerHome uploaderHome=
                (newtimesejb.excelhandler.ExcelUploadHandlerHome)
                info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                "newtimesejb.excelhandler.ExcelUploadHandler");
            newtimesejb.excelhandler.ExcelUploadHandler ejbupload2=uploaderHome.create();
            ejbupload2.refineQtyRec(timeStr,util.PublicVariable.USER_RECORD.get(0).toString());
            */
            /*
            Vector vctStyles=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
                "select sty_seq from Style where sty_img='"+timeStr+"'"
                ,1,99999
             );

             for(int i=0;i<vctStyles.size();i++){
                Record rec=(Record)vctStyles.get(i);
               newtimesejb.excelhandler.ExcelUploadHandlerHome uploaderHome=
                   (newtimesejb.excelhandler.ExcelUploadHandlerHome)
                   info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                   "newtimesejb.excelhandler.ExcelUploadHandler");
               newtimesejb.excelhandler.ExcelUploadHandler ejbupload2=uploaderHome.create();

               ejbupload2.refineQtyRec(rec.getInt(0),(String)util.PublicVariable.USER_RECORD.get(0));
             }
             */
          }else{
            timeStr=ejbupload.doUploadFileX(data2upload,util.PublicVariable.USER_RECORD.get(0).toString());
          }
          /*
          Vector vctStyles=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
              "select sty_seq from Style where sty_img='"+timeStr+"'"
              ,1,99999
           );
           for(int i=0;i<vctStyles.size();i++){
              Record rec=(Record)vctStyles.get(i);
              ThreadUpdateQtyDesc updatQtyDescFacade=new ThreadUpdateQtyDesc(ejbupload,rec.getInt(0));
              Thread testThread=new Thread(updatQtyDescFacade);
              testThread.start();
           }
           */
          exgui.verification.VerifyLib.showPlanMsg("Upload OK","Upload OK");
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Upload Failed!!\nPlease Contact System Manager",
                                             "Upload Failed!!");
    }finally{
      util.MiscFunc.hideProcessingMessage();

    }
  }
}

class PnlQryPPrd_jbtnExtract_actionAdapter implements java.awt.event.ActionListener {
  PnlQryPPrd adaptee;

  PnlQryPPrd_jbtnExtract_actionAdapter(PnlQryPPrd adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtnExtract_actionPerformed(e);
  }
}

class PnlQryPPrd_jbtnEXIT_actionAdapter implements java.awt.event.ActionListener {
  PnlQryPPrd adaptee;

  PnlQryPPrd_jbtnEXIT_actionAdapter(PnlQryPPrd adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtnEXIT_actionPerformed(e);
  }
}

class PnlQryPPrd_jbtnAddNew_actionAdapter implements java.awt.event.ActionListener {
  PnlQryPPrd adaptee;

  PnlQryPPrd_jbtnAddNew_actionAdapter(PnlQryPPrd adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtnAddNew_actionPerformed(e);
  }
}

class PnlQryPPrd_btnUpload_actionAdapter implements java.awt.event.ActionListener {
  PnlQryPPrd adaptee;

  PnlQryPPrd_btnUpload_actionAdapter(PnlQryPPrd adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnUpload_actionPerformed(e);
  }
}
