package newtimes.accounting;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import database.datatype.Record;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
import newtimes.preproduction.guis.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlShipAmtBySRN
     //extends JPanel {
     extends newtimes.production.report.AbsQryPanel{
  JComboBox cbxDiv = new JComboBox();
  SelectBuyerMaker slkProdBuyer = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel7 = new JLabel();
  JLabel lblDiv = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JComboBox cbxCntr = new JComboBox();
  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtDateBgn = new JTextField();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnQuery = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxDiv=null,DbJcbxcbxCntr=null;
  ChangeBuyerHandler changeBuyerHandler;
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  boolean doingDB2Gui=false;
  static int RUSEEL_BUER_SEQ=79;
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  SelectBuyerMaker slkProdMaker = new SelectBuyerMaker();
  JLabel jLabel8 = new JLabel();
  int indexDepCbx=0;
  int indexDivCbx=0;
  public PnlShipAmtBySRN() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder1 = new TitledBorder(border1,"ETD DATE");
    lblDiv.setBounds(new Rectangle(179, 64, 69, 21));
    lblDiv.setHorizontalAlignment(SwingConstants.CENTER);
    lblDiv.setHorizontalTextPosition(SwingConstants.CENTER);
    lblDiv.setText("DIVISION");
    jLabel7.setBounds(new Rectangle(177, 33, 50, 21));
    jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel7.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel7.setText("Buyer");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 1, 797, 23));
    blueBkgWhiteCharLabel1.setText("STATEMENT OF TOTAL COMMISSION");

    slkProdBuyer.setBounds(new Rectangle(221, 33, 188, 21));
    cbxDiv.setBounds(new Rectangle(241, 63, 172, 22));
    this.setLayout(null);
    changeBuyerHandler= new ChangeBuyerHandler();
    slkProdBuyer.setModifyNotifyTo(changeBuyerHandler);

    blueBkgWhiteCharLabel3.setBounds(new Rectangle(1, 33, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder1);
    pnlDuriation.setBounds(new Rectangle(422, 29, 322, 37));
    pnlDuriation.setLayout(null);
    //cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(45, 33, 130, 22));
    cbxCntr.addItemListener(new PnlShipAmtBySRN_cbxCntr_itemAdapter(this));
    this.setBackground(new Color(202, 202, 224));
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(223, 11, 87, 22));
    jLabel2.setText("FROM:");
    jLabel2.setBounds(new Rectangle(50, 11, 56, 21));
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(190, 11, 36, 24));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(94, 11, 87, 20));
    btnQuery.setBounds(new Rectangle(672, 66, 105, 27));
    btnQuery.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQuery.setText("QUERY");
    btnQuery.addActionListener(new PnlShipAmtBySRN_btnQuery_actionAdapter(this));
    blueBkgWhiteCharLabel4.setText("Dep.");
    blueBkgWhiteCharLabel4.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(7, 62, 37, 19));
    cbxDep.setBounds(new Rectangle(47, 62, 130, 22));
    slkProdMaker.setModifyNotifyTo(changeBuyerHandler);
    slkProdMaker.setBounds(new Rectangle(455, 66, 188, 21));
    jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel8.setText("Maker");
    jLabel8.setBounds(new Rectangle(409, 66, 52, 21));
    pnlDuriation.add(jLabel3, null);
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(txtDateEnd, null);
    this.add(lblDiv, null);
    this.add(cbxDiv, null);
    this.add(slkProdMaker, null);
    this.add(jLabel8, null);
    this.add(cbxDep, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(btnQuery, null);
    this.add(pnlDuriation, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(jLabel7, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(slkProdBuyer, null);
    slkProdBuyer.init("P_BUYER", null, slkProdMaker.TYPE_BUYER, true);
     slkProdMaker.init("P_MAKER", null, slkProdMaker.TYPE_MAKER, true);

    genDataBindObj();
  }
  public void genDataBindObj() {

    doingDB2Gui=true;
    dataBindComps.clear();
    try{

      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "ALL", null);
        dataBindComps.add(DbJcbxcbxCntr);
      } else {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        dataBindComps.add(DbJcbxcbxCntr);
      }

   indexDepCbx=dataBindComps.size();
   exgui.DataBindJCombobox   DbJcbxcbxDep =
          new exgui.DataBindJCombobox(
          cbxDep, "P_DEP",
          tempProperties.tmpDepartment,
          "DEP_NAME", "DEP_CODE",
          "", "ALL", null);
      dataBindComps.add(DbJcbxcbxDep);



      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "P_ETD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_ETD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      indexDivCbx=dataBindComps.size();
      Vector vctDivs=new Vector();
      DbJcbxcbxDiv = new exgui.DataBindJCombobox(
          cbxDiv,
          "P_DIV",
          vctDivs,
          "DIV_NAME", "DIV_CODE",
          null, "", null);
          dataBindComps.add(DbJcbxcbxDiv);

      Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1",
        1, 1);
        JTextField txtTwdUsd=new JTextField();
        JTextField txtRmbUsd=new JTextField();
        JTextField txtHkdUsd=new JTextField();
      database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
     exgui.DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbTwdChg);
     exgui.DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbRmbChg);
     exgui.DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbHkdChg);



      reportName="SHIP_AMT.rpt";

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }


  public class ChangeBuyerHandler
      implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record buyerRecord) {
      //recompose the division combobox of buyer.
      try {
        //find out the vector to add dbDeps.
        if (buyerRecord == null) {
          //only the all dep is allow to add now.
          DbJcbxcbxDiv = new exgui.DataBindJCombobox(
              cbxDiv,
              "P_DIV",
              new Vector(),
              "DIV_NAME", "DIV_CODE",
              null, "", null);
          dataBindComps.set(indexDivCbx, DbJcbxcbxDiv);
        } else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords =
              (Vector)newtimes.preproduction.guis.tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
          DbJcbxcbxDiv = null;
          if (dvsnRecords == null) {
            DbJcbxcbxDiv = new exgui.DataBindJCombobox(
                cbxDiv,
                 "P_DIV",
                new Vector(),
                "DIV_NAME",
                "DIV_CODE",
                null, "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
            dataBindComps.set(indexDivCbx, DbJcbxcbxDiv);
          } else {
            DbJcbxcbxDiv = new exgui.DataBindJCombobox(
                cbxDiv,
                "P_DIV",
                dvsnRecords,
                "DIV_NAME",
                "DIV_CODE",
                null, "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
            dataBindComps.set(indexDivCbx, DbJcbxcbxDiv);
          }

        }

      } catch (Exception exp) {
        exp.printStackTrace();
      }
    }
  }
  public HashMap composeParameters(){
     HashMap hm = super.composeParameters();
     Object objBuyer=slkProdBuyer.getSelectedValue();
     Object objMaker=slkProdMaker.getSelectedValue();
     if(objBuyer==null){
       hm.put("P_BUYER","0");
     }else{
       hm.put("P_BUYER",objBuyer.toString());
     }

     if(objMaker==null){
       hm.put("P_MAKER","0");
     }else{
       hm.put("P_MAKER",objMaker.toString());
     }


     Object objDiv =DbJcbxcbxDiv.getSelectedValue();
     if(objDiv==null)
       hm.put("P_DIV","ALL");
     else
       hm.put("P_DIV",objDiv.toString());

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
  void btnQuery_actionPerformed(ActionEvent e) {

    String orgURL = newtimes.production.report.ReportCmdSet.myReportEngin.
        reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(e);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =orgURL;
  }

  void cbxCntr_itemStateChanged(ItemEvent e) {
     if(!doingDB2Gui){
       try{
         String usingCenterCode=(String)DbJcbxcbxCntr.getSelectedValue();
         Vector depVects=
             (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
             usingCenterCode);

         exgui.DataBindJCombobox DbJcbxcbxDep =
             new exgui.DataBindJCombobox(
             cbxDep, "P_DEP",
             depVects,
             "DEP_NAME", "DEP_CODE",
             "", "ALL", null);
         dataBindComps.set(indexDepCbx,DbJcbxcbxDep);

         slkProdBuyer.setSelectingCenter(usingCenterCode);
         slkProdMaker.setSelectingCenter(usingCenterCode);
         changeBuyerHandler.changeBuyerMaker(null);

       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
       }

     }
  }


}


class PnlShipAmtBySRN_btnQuery_actionAdapter implements java.awt.event.ActionListener {
  PnlShipAmtBySRN adaptee;

  PnlShipAmtBySRN_btnQuery_actionAdapter(PnlShipAmtBySRN adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQuery_actionPerformed(e);
  }
}

class PnlShipAmtBySRN_cbxCntr_itemAdapter implements java.awt.event.ItemListener {
  PnlShipAmtBySRN adaptee;

  PnlShipAmtBySRN_cbxCntr_itemAdapter(PnlShipAmtBySRN adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxCntr_itemStateChanged(e);
  }
}
