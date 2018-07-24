package newtimes.reports.report01.ReportPS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import newtimes.*;
import database.datatype.Record;
import newtimes.material.Util;
import newtimes.preproduction.buyermakerselect.*;
import newtimes.preproduction.guis.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RepPsSearch extends JPanel {
  private Frame1 frame=null;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField tfYear = new JTextField();
  JComboBox cboCEN = new JComboBox();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JComboBox cboDep = new JComboBox();
  exgui.DataBindJCombobox dbJCBXDep = null;
  JLabel jLabel5 = new JLabel();
  JComboBox cboDIV = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JComboBox cboSEA = new JComboBox();
  JLabel jLabel8 = new JLabel();
  JComboBox cboCnty = new JComboBox();
  JLabel jLabel10 = new JLabel();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoIncludeSC_IS_NULL = new JRadioButton();
  JRadioButton rdoExcludeSC_IS_NULL = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JButton btnExit = new JButton();
  JButton btnExtract = new JButton();
  JButton btnRecover = new JButton();
  //public static RepPsSearch PanelInstance=null;
  /*
  private ReportEJBs.RepPsEJB.RepPS repPsEJB =
      (ReportEJBs.RepPsEJB.RepPS)util.ApplicationProperites.getProperties("repPsEJB");
  */
  Vector cenList = null;
  Vector depList = null;
  Vector divList = null;
  Vector ftyList = null;
  Vector seaList = null;
  Vector cntyList = null;
  static String CEN = null;
  static String DEP = null;
  static String YEAR = null;
  static String DIV = null;
  static String FTY = null;
  static String SEASON = null;
  static String COUNTRY = null;
  static String INCLUDE_QTY = null;
  static String PS_CLOSE = null;
  String usrType = null;
  String usrCenCodeDf = null;
  JLabel jLabel9 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  exgui.DataBindJCombobox DbJcbxcbxCntr,DbJcbxcbxDiv,DbJcbxcbxSzn,DbJcboCnty;
  exgui.DataBindTextWithChecker dbTxtYear;
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();

  public RepPsSearch(Frame1 _frame) {
    frame = _frame;
    try {
      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }

      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,600);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============   Production Status Report Query  ============ " +
    "     ");
    jLabel1.setBounds(new Rectangle(110, 25, 506, 24));

    jLabel2.setBounds(new Rectangle(223, 96, 59, 20));
    jLabel2.setText("CENTER:");
    jLabel2.setVerticalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(10,36,106));
    tfYear.setBorder(BorderFactory.createEtchedBorder());
    tfYear.setText("");
    tfYear.setBounds(new Rectangle(345, 174, 68, 22));
    cboCEN.setBorder(BorderFactory.createEtchedBorder());
    cboCEN.setBounds(new Rectangle(345, 96, 177, 22));
    cboCEN.setBackground(Color.WHITE);
    jLabel4.setBounds(new Rectangle(223, 176, 59, 20));
    jLabel4.setText("YEAR:");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("DEPARTMENT:");
    jLabel3.setBounds(new Rectangle(223, 136, 93, 20));
    cboDep.setBackground(Color.WHITE);
    cboDep.setBounds(new Rectangle(345, 136, 177, 23));
    cboDep.setBorder(BorderFactory.createEtchedBorder());
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("DIV:");
    jLabel5.setBounds(new Rectangle(223, 201, 59, 20));
    cboDIV.setBackground(Color.WHITE);
    cboDIV.setBounds(new Rectangle(345, 201, 177, 22));
    cboDIV.setBorder(BorderFactory.createEtchedBorder());
    jLabel6.setForeground(new Color(10,36,106));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("MAKER:");
    jLabel6.setBounds(new Rectangle(223, 296, 59, 20));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("SEASON:");
    jLabel7.setBounds(new Rectangle(223, 216, 59, 20));
    cboSEA.setBackground(Color.WHITE);
    cboSEA.setBounds(new Rectangle(344, 214, 177, 22));
    cboSEA.setBorder(BorderFactory.createEtchedBorder());
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("COUNTRY:");
    jLabel8.setBounds(new Rectangle(223, 336, 59, 20));
    cboCnty.setBackground(Color.WHITE);
    cboCnty.setBounds(new Rectangle(345, 336, 177, 22));
    cboCnty.setBorder(BorderFactory.createEtchedBorder());
    jLabel10.setBounds(new Rectangle(223, 376, 161, 20));
    jLabel10.setText("EXCLUDE S/C IS BLANK");
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(new Color(10,36,106));
    rdoIncludeSC_IS_NULL.setBounds(new Rectangle(459, 376, 60, 18));
    rdoIncludeSC_IS_NULL.setText("NO");
    rdoIncludeSC_IS_NULL.setFont(new java.awt.Font("Dialog", 1, 12));
    rdoIncludeSC_IS_NULL.setBackground(new Color(204, 204, 225));
    rdoExcludeSC_IS_NULL.setFont(new java.awt.Font("Dialog", 1, 12));
    rdoExcludeSC_IS_NULL.setSelected(true);
    rdoExcludeSC_IS_NULL.setBackground(new Color(204, 204, 225));
    rdoExcludeSC_IS_NULL.setText("YES");
    rdoExcludeSC_IS_NULL.setBounds(new Rectangle(393, 376, 60, 18));
    btnExit.setBackground(Color.lightGray);
    btnExit.setBounds(new Rectangle(443, 449, 80, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExit.setForeground(Color.darkGray);
    btnExit.setBorder(BorderFactory.createEtchedBorder());
    btnExit.setText("Exit");
    btnExit.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
    btnExtract.setText("Extract");
    btnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExtract_actionPerformed(e);
      }
    });
    btnExtract.setBorder(BorderFactory.createEtchedBorder());
    btnExtract.setForeground(Color.darkGray);
    btnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExtract.setBounds(new Rectangle(222, 449, 80, 25));
    btnExtract.setBackground(Color.lightGray);
    btnRecover.setBackground(Color.lightGray);
    btnRecover.setBounds(new Rectangle(333, 449, 80, 25));
    btnRecover.setFont(new java.awt.Font("Dialog", 1, 13));
    btnRecover.setForeground(Color.darkGray);
    btnRecover.setBorder(BorderFactory.createEtchedBorder());
    btnRecover.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRecover_actionPerformed(e);
      }
    });
    btnRecover.setText("Recover");
    jLabel9.setBounds(new Rectangle(223, 256, 80, 20));
    jLabel9.setText("BUYER:");
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    slkBuyer.setBounds(new Rectangle(347, 253, 177, 23));
    slkMaker.setModifyNotifyTo(new ChangeBuyerHandler());
    slkMaker.setBounds(new Rectangle(346, 293, 177, 23));
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(cboCEN, null);
    this.add(cboDep, null);
    this.add(btnExtract, null);
    this.add(btnExit, null);
    this.add(btnRecover, null);
    this.add(jLabel10, null);
    this.add(rdoExcludeSC_IS_NULL, null);
    this.add(rdoIncludeSC_IS_NULL, null);
    this.add(jLabel8, null);
    this.add(cboCnty, null);
    this.add(jLabel7, null);
    this.add(cboSEA, null);
    this.add(jLabel6, null);
    this.add(jLabel4, null);
    this.add(tfYear, null);
    //this.add(jLabel5, null);
    //this.add(cboDIV, null);
    this.add(slkMaker,null);
    this.add(jLabel9, null);
    this.add(slkBuyer, null);
    buttonGroup2.add(rdoExcludeSC_IS_NULL);
    buttonGroup2.add(rdoIncludeSC_IS_NULL);
    cboCEN.addItemListener(new cbxCenterItemChanged());
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("",null,slkMaker.TYPE_MAKER,true);
    initAllCombo();
  }
  void btnExtract_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    HashMap hm = setConds();
    hm.put("psClose", "N");
    this.PS_CLOSE = "N";
    util.ApplicationProperites.setProperties("RepPsSearchConds", hm);
    util.ApplicationProperites.setProperties("RepPsFtyList", ftyList);
    frame.showPanel(new newtimes.reports.report01.ReportPS.RepPsResult(frame));
    this.setCursor(tCur);
  }
  void btnRecover_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    HashMap hm = setConds();
    hm.put("psClose", "Y");
    this.PS_CLOSE = "Y";
    util.ApplicationProperites.setProperties("RepPsSearchConds", hm);
    util.ApplicationProperites.setProperties("RepPsFtyList", ftyList);
    frame.showPanel(new newtimes.reports.report01.ReportPS.RepPsResult(frame, "Recover"));
    this.setCursor(tCur);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    newtimes.production.report.PnlReport3FunList pnl =new newtimes.production.report.PnlReport3FunList();
    pnl.setSize(800,600);
    jframe.getContentPane().add(pnl);
    jframe.repaint();
    jframe.show();
    newtimes.production.ProdMaintain_Properties.setNormalCursor();

    /*
    frame.showPanel(new newtimes.reports.ReportMenu1(frame));
    */
  }

  private void initAllCombo(){
    try{
    if(tempProperties.tmpCenters.size()>1){
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cboCEN, null,
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "ALL", null);
    }else{
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cboCEN,null,
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
    }

    DbJcbxcbxDiv =
        new exgui.DataBindJCombobox(
          cboDIV,null,
          new Vector(),
          "DIV_NAME","DIV_CODE",null,"ALL",null);


     DbJcbxcbxSzn =
        new exgui.DataBindJCombobox(
          cboSEA,null,
          tempProperties.tmpSeason,
          "SEA_NAME","SEA_NAME",null,"ALL",null);

    //slkBuyer.setModifyNotifyTo(new ChangeBuyerHandler()) ;
    Object objCnv=exgui.verification.CellFormat.getOrdinaryField(4);
    //default year is from system_default_value.
    database.datatype.Record recSysValue=newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD;
    //System.out.println("system default value is:"+recSysValue.toString());
    dbTxtYear=new  exgui.DataBindTextWithChecker(
             tfYear,null,
              recSysValue.get("current_year"),4,
              (exgui.Object2String)objCnv,
              (exgui.ultratable.CellTxtEditorFormat)objCnv);

    DbJcboCnty =
        new exgui.DataBindJCombobox(
          cboCnty,null,
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME","CNTY_NAME",null,"ALL",null);

    cboCEN.getItemListeners()[0].itemStateChanged(null);
      this.add(jLabel9, null);
      this.add(slkBuyer, null);
      this.add(jLabel6, null);
      this.add(slkMaker, null);
      this.add(jLabel9, null);
      this.add(slkBuyer, null);
      this.add(jLabel4, null);
      this.add(tfYear, null);
      this.add(jLabel7, null);
      this.add(cboSEA, null);
  }catch(Exception exp){
    exp.printStackTrace();
    //throws exp;
  }finally{

  }
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener{
    public void itemStateChanged(ItemEvent e){
      try{
        //find out the vector to add dbDeps.
        if(DbJcbxcbxCntr==null)return;
        if (DbJcbxcbxCntr.getSelectedValue()==null) {
          //only the all dep is allow to add now.
          dbJCBXDep =
              new exgui.DataBindJCombobox(
              cboDep, null,
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              (String) util.PublicVariable.USER_RECORD.get("usr_Dep_code"),
              "ALL", null);
        }else {
          //deps and "ALL"dep allow to add.
          Vector depVects=
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          dbJCBXDep=null;
          if(depVects==null){
            dbJCBXDep =
               new exgui.DataBindJCombobox(
               cboDep,null,
               new Vector(),
               "DEP_NAME", "DEP_CODE",
               (String)util.PublicVariable.USER_RECORD.get("usr_Dep_code"),
               "ALL", null);
          }else if(depVects.size()>1){
             dbJCBXDep =
                new exgui.DataBindJCombobox(
                cboDep, null,
                depVects,
                "DEP_NAME", "DEP_CODE",
                (String)util.PublicVariable.USER_RECORD.get("usr_Dep_code"),
                "ALL", null);
            //guis.add(DbJcbxcbxDep);
          }else{
            dbJCBXDep =
                new exgui.DataBindJCombobox(
                cboDep, null,
                depVects,
                "DEP_NAME", "DEP_CODE",
                (String)util.PublicVariable.USER_RECORD.get("usr_Dep_code"));
            //guis.add(DbJcbxcbxDep);
          }

        }

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }

  public class ChangeBuyerHandler
      implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record buyerRecord){
      //recompose the division combobox of buyer.
      try{
        //find out the vector to add dbDeps.
        if (buyerRecord==null) {
          //only the all dep is allow to add now.
          DbJcbxcbxDiv=new exgui.DataBindJCombobox(
              cboDIV,
              null,
              new Vector(),
              "DIV_NAME","DIV_CODE",
              null,"N/A",null);
          //cbxDiv.setUI(new exgui.WideComboBoxUI(160));


        }else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords=
              (Vector)tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
           DbJcbxcbxDiv=null;
          if(dvsnRecords==null){
            DbJcbxcbxDiv=new exgui.DataBindJCombobox(
                cboDIV,
                null,
                new Vector(),
                "DIV_NAME",
                "DIV_CODE",
                null,"N/A",null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }else {
            DbJcbxcbxDiv=new exgui.DataBindJCombobox(
                cboDIV,
                null,
                dvsnRecords,
                "DIV_NAME",
                "DIV_CODE",
               null,"N/A",null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }

        }

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }

  private HashMap setConds(){
    HashMap hm = new HashMap();
    try{
      hm.put("center", DbJcbxcbxCntr.getSelectedValue() );
      hm.put("depCode", dbJCBXDep.getSelectedValue() );
      hm.put("year", dbTxtYear.getSelectedValue());
      hm.put("divCode", DbJcbxcbxDiv.getSelectedValue());
      Object ftyObj = slkMaker.getSelectedValue();
      hm.put("fty",(ftyObj==null)?null:ftyObj.toString() );
      hm.put("season", DbJcbxcbxSzn.getSelectedValue() );
      hm.put("country", DbJcboCnty.getSelectedValue() );
      hm.put("EXCLUDE_SC_IS_NULL",(rdoExcludeSC_IS_NULL.isSelected())?"Y":"N");
      Object buyerObj=slkBuyer.getSelectedValue();
      hm.put("BUYER",(buyerObj==null)?null:buyerObj.toString());
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    finally{
      return hm;
    }
  }
}
