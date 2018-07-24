package newtimes.accounting;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
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

public class PnlQryFabNonePi
    //extends JPanel {
    extends newtimes.production.report.AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();

  JLabel lblSeason = new JLabel();
  JComboBox cbxSeason = new JComboBox();
  JLabel lblYear = new JLabel();
  JTextField txYear = new JTextField();

  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JComboBox cbxCntr = new JComboBox();

  JLabel jLabel1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JLabel jLabel3 = new JLabel();
  JTextField txtDateBgn = new JTextField();

  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JButton btnQry = new JButton();
  String usr[] =new String[]{"ALL"};
  JComboBox ucbx = new JComboBox(usr);
  JLabel ulbl = new JLabel("NONE P/I RCV :");
  DataBindJCombobox dbCbxSzn;
  JLabel LabelUser = new JLabel();
  java.util.List listUsrName=new java.util.ArrayList();
  exgui.ultratable.Wraper4tblCbx[] depUsers=
           (exgui.ultratable.Wraper4tblCbx[]) listUsrName.toArray(new exgui.ultratable.Wraper4tblCbx[0]);
  JComboBox cbxUserCode=new JComboBox();
  boolean doingDB2Gui=false;

  exgui.DataBindJCombobox DbJcbxcbxCntr;

  DataBindJCombobox dbCbxDep;
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtDatePointDate;
  public PnlQryFabNonePi() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    border1 = BorderFactory.createEmptyBorder();
    titledBorder1 = new TitledBorder(border1,"DEL DD");
    border2 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border2,"DEL-DATE");
    blueBkgWhiteCharLabel1.setText("PRINT FAB COMM BY NONE PI RCV DATE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 803, 28));
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 46, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(54, 48, 130, 22));
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(10, 77, 47, 21));
    cbxDep.setBounds(new Rectangle(53, 80, 130, 22));
    cbxDep.addItemListener(new PnlQryFabNonePi_cbxDep_itemAdapter(this));
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(187, 19, 87, 22));
    jLabel2.setText("FROM:");
    jLabel2.setBounds(new Rectangle(8, 19, 56, 21));
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder2);
    pnlDuriation.setBounds(new Rectangle(190, 48, 286, 53));
    pnlDuriation.setLayout(null);
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(154, 19, 36, 24));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(52, 19, 87, 20));
    btnQry.setBounds(new Rectangle(693, 59, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    ucbx.setBounds(new Rectangle(576, 59, 100, 24));
    ulbl.setBounds(new Rectangle(479, 59, 109, 23));
    btnQry.addActionListener(new PnlQryFabNonePi_btnQry_actionAdapter(this));
    this.setBackground(new Color(202, 202, 224));
    jLabel4.setText("P/I RCV :");
    jLabel4.setBounds(new Rectangle(479, 48, 65, 40));
    txtPointDate.setBounds(new Rectangle(546, 61, 107, 21));
    this.add(blueBkgWhiteCharLabel1, null);
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(txtDateEnd, null);
    pnlDuriation.add(jLabel3, null);
//    this.add(jLabel4, null);
//    this.add(txtPointDate, null);
    lblSeason.setBounds(new Rectangle(200, 107, 70, 17));
   lblSeason.setText("SEASON");
   cbxSeason.setBounds(new Rectangle(260, 105, 126, 20));

   lblYear.setBounds(new Rectangle(14, 107, 70, 17));;
   lblYear.setText("YEAR :");
   txYear.setBounds(new Rectangle(55, 105, 126, 20));


   LabelUser.setText("USER :");
   LabelUser.setBounds(new Rectangle(450, 107, 70, 17));
   cbxUserCode.setBounds(new Rectangle(510, 105, 126, 20));

    this.add(cbxCntr, null);
    this.add(cbxDep, null);
    this.add(jLabel1, null);
    this.add(pnlDuriation, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(btnQry, null);
    this.add(ucbx);
    this.add(ulbl);
    this.add(lblSeason);
    this.add(cbxSeason);
    this.add(lblYear);
    this.add(txYear);
    this.add(LabelUser);
    this.add(cbxUserCode);
    genDataBindObj();
    reportName="FAB_NONE_PI.RPT";
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


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "P_DEL_BE", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_DEL_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      dbTxtDatePointDate =
          new exgui.DataBindTextWithChecker(txtPointDate, "POINT_DATE", new java.sql.Date(System.currentTimeMillis()),
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDatePointDate);
      Vector seasons = newtimes.preproduction.guis.tempProperties.tmpSeason;
      dbCbxSzn= new exgui.DataBindJCombobox(
        cbxSeason,"P_SEASON",
       seasons,"SEA_NAME","SEA_NAME","ALL","ALL",null);

 //      cbxUserCode = new JComboBox(depUsers);
      Vector vct=
       exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select usr_code from userfile where usr_cen_code='001'" +
              " and record_delete_flag='1' order by usr_code",
              1, 9999);
       cbxUserCode.addItem("ALL");
        for(int i=0;i<vct.size();i++){
          database.datatype.Record rec=(database.datatype.Record)vct.get(i);
          cbxUserCode.addItem(rec.get(0));
        }



      doingDB2Gui=false;
      cbxCntr.getItemListeners()[0].itemStateChanged(null);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public HashMap composeParameters(){
  HashMap hm = super.composeParameters();
  hm.put(dbCbxDep.getOrgRecField(),dbCbxDep.getSelectedValue());
  Object dateBgn=dbTxtDateBgn.getSelectedValue();
  Object dateEnd=dbTxtDateEnd.getSelectedValue();
  Object dateCmp=dbTxtDatePointDate.getSelectedValue();
  if(dateCmp==null){
    hm.put("POINT_DATE",
           convertDate2QueryPara(
            new java.sql.Date(System.currentTimeMillis()
            )));
  }
  if(dateBgn==null){
    hm.put("P_DEL_BE","DATE(2000,01,01)");
  }
  if(dateEnd==null){
    hm.put("P_DEL_TO","DATE(2099,12,31)");
  }
  hm.put("P_USER",ucbx.getSelectedItem().toString());
  if (txYear.getText().length() == 0 )
   {
       hm.put("P_YEAR", "ALL");
   }
   else
   {
     hm.put("P_YEAR", txYear.getText());
   }
   hm.put("P_SEASON", cbxSeason.getSelectedItem().toString());
   hm.put("P_USER_CODE", cbxUserCode.getSelectedItem().toString());

  return hm;
}

  class cbxCenterItemChanged implements java.awt.event.ItemListener{
  public void itemStateChanged(ItemEvent e){
     if(doingDB2Gui)return;
    try{
      //find out the vector to add dbDeps.
        if (DbJcbxcbxCntr.getSelectedValue() == null) {
          //only the all dep is allow to add now.
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              null,
              "", "ALL");
        } else {
          //deps and "ALL"dep allow to add.
          Vector depVects =
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          dbCbxDep = null;
          if (depVects == null) {
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "P_DEP",
                new Vector(),
                "DEP_NAME", "DEP_CODE",
                null,
                "", "ALL");
          } else if (depVects.size() > 1) {
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "P_DEP",
                depVects,
                "DEP_NAME", "DEP_CODE",
                null,
                "", "ALL");
            //guis.add(DbJcbxcbxDep);
          } else {
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "P_DEP",
                depVects,
                "DEP_NAME", "DEP_CODE",
                null);
            //guis.add(DbJcbxcbxDep);
          }
       }

      } catch (Exception exp) {
        exp.printStackTrace();
      }

  }
 }

  void btnQry_actionPerformed(ActionEvent e) {
    String prtSever=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
    "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
     JButtonQueryButtonAction(e);
      newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=prtSever;
  }
  JLabel jLabel4 = new JLabel();
  JTextField txtPointDate = new JTextField();

  void cbxDep_itemStateChanged(ItemEvent e) {

    if (cbxDep.getSelectedItem().toString().length() < 1 )
    {
         ucbx.removeAllItems();
         ucbx.addItem("YES");
          ucbx.addItem("NO");
    }

    else
    {
 //      System.out.println(dbCbxDep.getSelectedValue());
      java.util.HashMap para_hm = new java.util.HashMap();
      para_hm.put("cen_code", "001");
      para_hm.put("dep_code", dbCbxDep.getSelectedValue());
      para_hm.put("mng_code", "null");
      try {
        java.util.Vector user_list = exgui2.CONST.BASIC_BASE_EJB.getUserList(1,
            999, para_hm);
//        ucbx.removeAllItems();
//        ucbx.addItem("ALL");
        for (int u_idx = 0; u_idx < user_list.size(); u_idx++) {
          String[] cbx_tmp = user_list.get(u_idx).toString().split("\\|");
          String[] cbx_usr = cbx_tmp[6].split("=");
//          ucbx.addItem(cbx_usr[1]);
        }
      } catch (Exception ue) {
      }
    }
   }

}

class PnlQryFabNonePi_btnQry_actionAdapter implements java.awt.event.ActionListener {
  PnlQryFabNonePi adaptee;

  PnlQryFabNonePi_btnQry_actionAdapter(PnlQryFabNonePi adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQry_actionPerformed(e);
  }
}

class PnlQryFabNonePi_cbxDep_itemAdapter implements java.awt.event.ItemListener {
  PnlQryFabNonePi adaptee;

  PnlQryFabNonePi_cbxDep_itemAdapter(PnlQryFabNonePi adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxDep_itemStateChanged(e);
  }
}
