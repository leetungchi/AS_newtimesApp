package newtimes.nthk_accounting_enqry;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import java.util.*;
import newtimes.preproduction.guis.tempProperties;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryGui extends JPanel {
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  JLabel jLabel4 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JLabel jLabel5 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JComboBox cbxMgrs = new JComboBox();
  JLabel jLabel7 = new JLabel();
  JTextField txtStyStyle = new JTextField();
  JLabel jLabel9 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel10 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel11 = new JLabel();
  JTextField txtEtdFrom = new JTextField();
  JLabel jLabel12 = new JLabel();
  JTextField txtEtdTo = new JTextField();
  JLabel jLabel13 = new JLabel();
  newtimesejb.preproduction.PreProductionHead prdHead;
  boolean doingDB2Gui=false;
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  int depCbxDBGUI_index=0;
  int mngCbxDBGUI_index=0;
  java.util.List guis=new java.util.ArrayList();
  exgui.DataBindTextWithChecker dbTxtEtdFrom,dbTxtEtdTo;
  Object defaultDepValue=null;
  public PnlQryGui() {
    try {
      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
         util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
         defaultDepValue=util.PublicVariable.USER_RECORD.get("usr_Dep_code");
      }else{
        defaultDepValue=null;
      }

      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

protected  void jbInit() throws Exception {
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel1.setText("Newtimes Group Of Companies");
    jLabel1.setBounds(new Rectangle(274, 19, 236, 32));
    this.setLayout(null);
    jLabel2.setBounds(new Rectangle(263, 38, 259, 32));
    jLabel2.setText("ERP Systems (General Enquiry)");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel3.setBounds(new Rectangle(320, 60, 174, 32));
    jLabel3.setText("Shipping Total Enquiry");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 14));
    btnQry.setBounds(new Rectangle(139, 531, 135, 31));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setActionCommand("GO!!");
    btnQry.setText("Extract");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(571, 531, 135, 31));
    this.setBackground(new Color(202, 202, 224));
    jLabel4.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel4.setText("Center :");
    jLabel4.setBounds(new Rectangle(227, 87, 54, 25));
    cbxCntr.setBounds(new Rectangle(323, 87, 202, 22));
    jLabel5.setBounds(new Rectangle(227, 131, 54, 25));
    jLabel5.setText("Dept. :");
    jLabel5.setFont(new java.awt.Font("Dialog", 0, 13));
    cbxDep.setBounds(new Rectangle(323, 131, 202, 22));
    jLabel6.setBounds(new Rectangle(227, 175, 81, 25));
    jLabel6.setText("Manager :");
    jLabel6.setFont(new java.awt.Font("Dialog", 0, 13));
    cbxMgrs.setBounds(new Rectangle(323, 175, 202, 22));
    jLabel7.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel7.setText("STYLE# :");
    jLabel7.setBounds(new Rectangle(228, 262, 81, 25));
    txtStyStyle.setBounds(new Rectangle(324, 262, 202, 22));
    jLabel9.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel9.setText("Customer:");
    jLabel9.setBounds(new Rectangle(228, 350, 80, 22));
    slkBuyer.setBounds(new Rectangle(324, 350, 202, 22));
    jLabel10.setBounds(new Rectangle(227, 390, 75, 22));
    jLabel10.setText("Vendor :");
    jLabel10.setFont(new java.awt.Font("Dialog", 0, 13));
    slkMaker.setBounds(new Rectangle(324, 390, 202, 22));
    jLabel11.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel11.setText("<html><body>Delivery<br>ETD</body></html>");
    jLabel11.setBounds(new Rectangle(227, 429, 80, 38));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(335, 431, 77, 22));
    jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel12.setText("TO");
    jLabel12.setBounds(new Rectangle(414, 431, 34, 24));
    txtEtdTo.setText("");
    txtEtdTo.setBounds(new Rectangle(451, 431, 78, 24));
    jLabel13.setText("FROM");
    jLabel13.setBounds(new Rectangle(292, 431, 53, 24));
    jLabel14.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel14.setText("PO# :");
    jLabel14.setBounds(new Rectangle(228, 306, 81, 25));
    txtStyPo.setBounds(new Rectangle(324, 306, 202, 22));
    txtScNo.setBounds(new Rectangle(322, 218, 202, 22));
    jLabel15.setBounds(new Rectangle(226, 218, 81, 25));
    jLabel15.setText("S/C # :");
    jLabel15.setFont(new java.awt.Font("Dialog", 0, 13));
    lblShipFtyInv.setBounds(new Rectangle(208, 472, 94, 37));
    lblShipFtyInv.setText("<html><body>Facotry<br>Invoice</body></html>");
    lblShipFtyInv.setFont(new java.awt.Font("Dialog", 0, 13));
    txtShipFtyInv.setBounds(new Rectangle(304, 484, 242, 22));
    btnQty4StatusUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQty4StatusUpdate_actionPerformed(e);
      }
    });
    btnQty4StatusUpdate.setText("Approve/Cancel S/C");
    btnQty4StatusUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQty4StatusUpdate.setBounds(new Rectangle(346, 531, 154, 31));

    exgui.ultratable.Wraper4tblCbx wrap4SthipIvcType[]=new exgui.ultratable.Wraper4tblCbx[5];
    exgui.ultratable.Wraper4tblCbx typeNoCondition=new exgui.ultratable.Wraper4tblCbx();
    typeNoCondition.setString("") ;typeNoCondition.setValue(null); wrap4SthipIvcType[0]=typeNoCondition;

    exgui.ultratable.Wraper4tblCbx typeBlankCondition=new exgui.ultratable.Wraper4tblCbx();
    typeBlankCondition.setString("N/A") ;typeBlankCondition.setValue("BLANK"); wrap4SthipIvcType[1]=typeBlankCondition;

    exgui.ultratable.Wraper4tblCbx typeICCondition=new exgui.ultratable.Wraper4tblCbx();
    typeICCondition.setString("IC") ;typeICCondition.setValue("IC"); wrap4SthipIvcType[2]=typeICCondition;

    exgui.ultratable.Wraper4tblCbx typeINVCondition=new exgui.ultratable.Wraper4tblCbx();
    typeINVCondition.setString("INVOICE") ;typeINVCondition.setValue("INVOICE"); wrap4SthipIvcType[3]=typeINVCondition;

    exgui.ultratable.Wraper4tblCbx typeBothCondition=new exgui.ultratable.Wraper4tblCbx();
    typeBothCondition.setString("BOTH") ;typeBothCondition.setValue("BOTH"); wrap4SthipIvcType[4]=typeBothCondition;


    this.add(jLabel1, null);
    this.add(jLabel3, null);
    this.add(jLabel2, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
    this.add(btnQty4StatusUpdate, null);
    this.add(jLabel4, null);
    this.add(cbxCntr, null);
    this.add(jLabel5, null);
    this.add(cbxDep, null);
    this.add(jLabel6, null);
    this.add(cbxMgrs, null);
    this.add(jLabel15, null);
    this.add(txtScNo, null);
    this.add(jLabel7, null);
    this.add(txtStyStyle, null);
    this.add(jLabel14, null);
    this.add(txtStyPo, null);
    this.add(jLabel9, null);
    this.add(slkBuyer, null);
    this.add(jLabel10, null);
    this.add(slkMaker, null);
    this.add(jLabel11, null);
    this.add(jLabel13, null);
    this.add(txtEtdFrom, null);
    this.add(jLabel12, null);
    this.add(txtEtdTo, null);
    //only TPE user allow to query object by shipping's Factory Invoice.
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      this.add(lblShipFtyInv, null);
      this.add(txtShipFtyInv, null);
    }

    slkBuyer.init(prdHead.QRY_CONDITION_BUYER,null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init(prdHead.QRY_CONDITION_MAKER,null,slkBuyer.TYPE_MAKER,true);
    guis.clear();
    cbxCntr.addItemListener(new cbxCenterItemChanged());


    activate();
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener{
    protected void updateManagerComboBox(){
      String descCenCode=DbJcbxcbxCntr.getSelectedValue().toString();
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
      slkBuyer.init(prdHead.QRY_CONDITION_BUYER,null,slkBuyer.TYPE_BUYER,true);
      slkMaker.init(prdHead.QRY_CONDITION_MAKER,null,slkBuyer.TYPE_MAKER,true);
    }

    public void itemStateChanged(ItemEvent e){
      if(doingDB2Gui)return;
      try{
        util.PublicVariable.OPERATTING_CENTER=(String)DbJcbxcbxCntr.getSelectedValue();
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
          //also.we need to check manager vectors,manger vector also fallowed by center


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

  public void activate() throws Exception {
    doingDB2Gui = true;
    //use the ejb interface to generate the combobox for query.
    javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr = jframe.getContentPane().getCursor();
    try {
      //get all centers for all departments
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.
          WAIT_CURSOR));
      guis.clear();
      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, prdHead.QRY_CONDITION_CENTER,
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        guis.add(DbJcbxcbxCntr);
      } else {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, prdHead.QRY_CONDITION_CENTER,
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        guis.add(DbJcbxcbxCntr);
      }
      depCbxDBGUI_index = guis.size();
      //occupy a position for cmobobox dep
      guis.add(new Vector());
      if (util.PublicVariable.USER_RECORD.getInt("usr_type") ==
          prdHead.USER_TYPE_DIRECTOR) {
        exgui.DataBindJCombobox DbJcbxcbxMgrs =
            new exgui.DataBindJCombobox(
            cbxMgrs, prdHead.CONDITION_KEY_WITH_MANAGER,
            tempProperties.tmpManagerRecs,
            "MNG_ABBR", "MNG_CODE", null, "ALL", null);
        mngCbxDBGUI_index=guis.size();
        guis.add(DbJcbxcbxMgrs);
      }
      if (util.PublicVariable.USER_RECORD.getInt("usr_type") ==
          prdHead.USER_TYPE_MANAGER) {
        if (((String)util.PublicVariable.USER_RECORD.get("USR_MNG_MOD")).
            equalsIgnoreCase("y")) {
          exgui.DataBindJCombobox DbJcbxcbxMgrs =
              new exgui.DataBindJCombobox(
              cbxMgrs, prdHead.CONDITION_KEY_WITH_MANAGER,
              tempProperties.tmpManagerRecs,
              "MNG_ABBR", "MNG_CODE", null, "ALL", null);
           mngCbxDBGUI_index=guis.size();
          guis.add(DbJcbxcbxMgrs);
        } else {
          exgui.DataBindJCombobox DbJcbxcbxMgrs =
              new exgui.DataBindJCombobox(
              cbxMgrs, prdHead.CONDITION_KEY_WITH_MANAGER,
              tempProperties.tmpManagerRecs,
              "MNG_ABBR", "MNG_CODE",
              util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"));
          mngCbxDBGUI_index=guis.size();
          guis.add(DbJcbxcbxMgrs);
        }
      } else if (util.PublicVariable.USER_RECORD.getInt("usr_type") ==
                 prdHead.USER_TYPE_USERS) {
        exgui.DataBindJCombobox DbJcbxcbxMgrs =
            new exgui.DataBindJCombobox(
            cbxMgrs, prdHead.CONDITION_KEY_WITH_MANAGER,
            tempProperties.tmpManagerRecs,
            "MNG_ABBR", "MNG_CODE",
            util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"),
            "None Manager", "None Manager");
        mngCbxDBGUI_index=guis.size();
        guis.add(DbJcbxcbxMgrs);
      } else {
        exgui.DataBindJCombobox DbJcbxcbxMgrs =
            new exgui.DataBindJCombobox(
            cbxMgrs, prdHead.CONDITION_KEY_WITH_MANAGER,
            tempProperties.tmpManagerRecs,
            "MNG_ABBR", "MNG_CODE", null, "ALL", null);
        mngCbxDBGUI_index=guis.size();
        guis.add(DbJcbxcbxMgrs);
      }
      guis.add(slkBuyer);
      guis.add(slkMaker);


      Object objCnvStylePO = exgui.verification.CellFormat.getOrdinaryField(20);
      exgui.DataBindTextWithChecker dbTxtStlyePO = new exgui.
          DataBindTextWithChecker(
          txtStyPo, prdHead.CONDITION_KEY_STY_PO, null, 20,
          (exgui.Object2String)objCnvStylePO,
          (exgui.ultratable.CellTxtEditorFormat)objCnvStylePO);


      guis.add(dbTxtStlyePO);
      /*
      Object objCnvPdxnPO = exgui.verification.CellFormat.getOrdinaryField(15);
      exgui.DataBindTextWithChecker dbTxtProdPo = new exgui.
          DataBindTextWithChecker(
          txtBuyerSc,"prodxn.prod_byr_sc_no", null, 15,
          (exgui.Object2String)objCnvPdxnPO,
          (exgui.ultratable.CellTxtEditorFormat)objCnvPdxnPO);
      guis.add(dbTxtProdPo);
     */
      Object objCnvPdxnScNo = exgui.verification.CellFormat.getOrdinaryField(15);
      exgui.DataBindTextWithChecker dbTxtScNo = new exgui.
          DataBindTextWithChecker(
          txtScNo,prdHead.CONDITION_KEY_BGN_SC_NO, null, 15,
          (exgui.Object2String)objCnvPdxnScNo,
          (exgui.ultratable.CellTxtEditorFormat)objCnvPdxnScNo);
      guis.add(dbTxtScNo);



      Object objCnvStyleSTYLE = exgui.verification.CellFormat.getOrdinaryField(
          25);
      exgui.DataBindTextWithChecker dbTxtStlyeSTYLE = new exgui.
          DataBindTextWithChecker(
          txtStyStyle, prdHead.CONDITION_KEY_STY_STYLE, null, 25,
          (exgui.Object2String)objCnvStyleSTYLE,
          (exgui.ultratable.CellTxtEditorFormat)objCnvStyleSTYLE);
      guis.add(dbTxtStlyeSTYLE);

      Object objCnvShipFtyInv = exgui.verification.CellFormat.getOrdinaryField(
          25);
      exgui.DataBindTextWithChecker dbTxtShipFtyInv= new exgui.
          DataBindTextWithChecker(
          txtShipFtyInv, EnqDataEngin.CONDITION_KEY_SHIP_FTY_INV, null, 25,
          (exgui.Object2String)objCnvShipFtyInv,
          (exgui.ultratable.CellTxtEditorFormat)objCnvShipFtyInv);
      guis.add(dbTxtShipFtyInv);


      Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtEtdFrom=new exgui.DataBindTextWithChecker(txtEtdFrom,
                                  EnqDataEngin.CONDITION_KEY_ETD_FROM,
                                  null,
                                  10,
                                  (exgui.Object2String) dateVfy,
                                  (exgui.ultratable.CellTxtEditorFormat) dateVfy);


     dbTxtEtdTo = new exgui.DataBindTextWithChecker(txtEtdTo,
                                  EnqDataEngin.CONDITION_KEY_ETD_TO,
                                  null,
                                  10,
                                  (exgui.Object2String)dateVfy,
                                  (exgui.ultratable.CellTxtEditorFormat)dateVfy);


      doingDB2Gui = false;
      cbxCntr.getItemListeners()[0].itemStateChanged(null);

    } catch (Exception e) {
      //e.printStackTrace();
      throw e;
    } finally {
      jframe.getContentPane().setCursor(ksr);
    }
  }


  void btnExit_actionPerformed(ActionEvent e) {
    try{
      /*
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrShowFuncList());*/
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception ie){
      ie.printStackTrace();
    }

  }
  private String initSelectionCriteria(){
    //show Criteria of search
    int itemCount=0;
    StringBuffer sb=new StringBuffer();
    sb.append("<html><body>Criteria Of Searching:<br>");
    sb.append("Center :"+cbxCntr.getSelectedItem().toString());sb.append("   ");
    itemCount++;
    if(((exgui.SwingSingleSelection)guis.get(depCbxDBGUI_index)).getSelectedValue()!=null){
      sb.append("  , Department:");
      sb.append(cbxDep.getSelectedItem().toString());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }

    if(((exgui.SwingSingleSelection)guis.get(mngCbxDBGUI_index)).getSelectedValue()!=null){
      sb.append("   , Manager:");
      sb.append(cbxMgrs.getSelectedItem().toString());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }

    if(txtScNo.getText().trim().length()>0 ){
      sb.append("   , S/C# Begin With:");
      sb.append(txtScNo.getText().trim());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }

    if(txtStyStyle.getText().trim().length()>0 ){
      sb.append("   , Style# Begin With:");
      sb.append(txtStyStyle.getText().trim());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }
    /*
    if(txtBuyerSc.getText().trim().length()>0 ){
      sb.append(" , Cust Po# Begin With:");
      sb.append(txtBuyerSc.getText().trim());
      itemCount++;
    }*/
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }

    if(txtStyPo.getText().trim().length()>0 ){
      sb.append(" , Po# Begin With:");
      sb.append(txtStyPo.getText().trim());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }


    if(slkBuyer.getSelectedValue()!=null){
      sb.append("  , Customer :");
      sb.append(((javax.swing.JTextField)slkBuyer.getGUIcomponent()).getText());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }
    if(slkMaker.getSelectedValue()!=null){
      sb.append("  , Vendor :");
      sb.append(((javax.swing.JTextField)slkMaker.getGUIcomponent()).getText());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }

    if(txtEtdFrom.getText().trim().length()>0 ){
      sb.append(" , ETD Date From:");
      sb.append(txtEtdFrom.getText().trim());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }
    if(txtEtdTo.getText().trim().length()>0 ){
      sb.append(" , ETD Date To:");
      sb.append(txtEtdTo.getText().trim());
      itemCount++;
    }
    if(itemCount%4==0){
      sb.append("<br>");
    }else{
      sb.append("   ");
    }



    if(txtShipFtyInv.getText().trim().length()>0 ){
      sb.append(" , SHIP'S FACTORY INVOICE:");
      sb.append(txtShipFtyInv.getText().trim());
      itemCount++;
    }

   sb.append("</body></html>");
   return sb.toString();
  }
  void btnQry_actionPerformed(ActionEvent e) {
    try{

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
      /*if(dbTxtEtdFrom.getSelectedValue()!=null  && dbTxtEtdTo.getSelectedValue()!=null){
         java.util.Date[] dates=new java.util.Date[2];
         dates[0]=(java.util.Date)dbTxtEtdFrom.getSelectedValue();
         dates[1]=(java.util.Date)dbTxtEtdTo.getSelectedValue();
         conditions.put(EnqDataEngin.CONDITION_KEY_ETD_FROM_AND_TO,dates);
      }else{

      }*/
      if(dbTxtEtdFrom.getSelectedValue()!=null){
        conditions.put(EnqDataEngin.CONDITION_KEY_ETD_FROM,dbTxtEtdFrom.getSelectedValue());
      }
      if(dbTxtEtdTo.getSelectedValue()!=null){
        conditions.put(EnqDataEngin.CONDITION_KEY_ETD_TO,dbTxtEtdTo.getSelectedValue());
      }

      //EnqDataEngin.STATIC_CONDITIONS.clear();
      //EnqDataEngin.STATIC_CONDITIONS.putAll(conditions);


      EnqDataEngin.setReCondition(conditions);
      util.ApplicationProperites.setProperties(
      "newtimes.nthk_accounting_enqry.PnlListQryResult_TOP_RECORD_AT",
      new Integer(1));
     util.ApplicationProperites.setProperties(
      "newtimes.nthk_accounting_enqry.PnlListQryResultXCenter_TOP_RECORD_AT",
      new Integer(1));

      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.nthk_accounting_enqry.TgrListQryResult(initSelectionCriteria()));
      //processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception ie){
      ie.printStackTrace();
    }

  }
  JLabel jLabel14 = new JLabel();
  JTextField txtStyPo = new JTextField();
  JTextField txtScNo = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel lblShipFtyInv = new JLabel();
  JTextField txtShipFtyInv = new JTextField();
  JButton btnQty4StatusUpdate = new JButton();//new JComboBox();
  void btnQty4StatusUpdate_actionPerformed(ActionEvent e) {
    try{
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
      /*
      if(dbTxtEtdFrom.getSelectedValue()!=null  && dbTxtEtdTo.getSelectedValue()!=null){
         java.util.Date[] dates=new java.util.Date[2];
         dates[0]=(java.util.Date)dbTxtEtdFrom.getSelectedValue();
         dates[1]=(java.util.Date)dbTxtEtdTo.getSelectedValue();
         conditions.put(EnqDataEngin.CONDITION_KEY_ETD_FROM_AND_TO,dates);
      }else{
      }*/

      if(dbTxtEtdFrom.getSelectedValue()!=null){
        conditions.put(EnqDataEngin.CONDITION_KEY_ETD_FROM,dbTxtEtdFrom.getSelectedValue());
      }
      if(dbTxtEtdTo.getSelectedValue()!=null){
        conditions.put(EnqDataEngin.CONDITION_KEY_ETD_TO,dbTxtEtdTo.getSelectedValue());
      }

      EnqDataEngin.setReCondition(conditions);
      util.ApplicationProperites.setProperties(
      "newtimes.nthk_accounting_enqry.PnlListQryResult_TOP_RECORD_AT",
      new Integer(1));
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.nthk_accounting_enqry.TgrListQryResult4StatusNTFE(
            initSelectionCriteria()));
      }else{
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.nthk_accounting_enqry.TgrListQryResult4Status(
            initSelectionCriteria()));
      }
    }catch(Exception ie){
      ie.printStackTrace();
    }

  }
}
