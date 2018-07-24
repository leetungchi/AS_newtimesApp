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

public class PnlInvoice2Signe
    //extends JPanel {
    extends newtimes.production.report.AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
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
  boolean doingDB2Gui=false;
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  DataBindJCombobox dbCbxDep;
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtDatePointDate;
  public PnlInvoice2Signe() {
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
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"O.B.D.");
    blueBkgWhiteCharLabel1.setText("INVOICE RECEIVE LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 803, 28));
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 46, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(54, 48, 130, 22));
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(10, 77, 47, 21));
    cbxDep.setBounds(new Rectangle(53, 80, 130, 22));
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
    btnQry.setBounds(new Rectangle(585, 62, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new _btnQry_actionAdapter(this));
    this.setBackground(new Color(202, 202, 224));
    rdoByBuyer.setBackground(Color.white);
    rdoByBuyer.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoByBuyer.setSelected(true);
    rdoByBuyer.setText("BY BUYER");
    rdoByBuyer.setBounds(new Rectangle(490, 47, 91, 25));
    rdoByMaker.setBackground(Color.white);
    rdoByMaker.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoByMaker.setText("BY MAKER");
    rdoByMaker.setBounds(new Rectangle(490, 71, 91, 25));
    btnLock.setBounds(new Rectangle(679, 62, 80, 27));
    btnLock.setFont(new java.awt.Font("Dialog", 1, 11));
    btnLock.setForeground(Color.red);
    btnLock.setText("LOCK");
    btnLock.addActionListener(new PnlInvoice2Signe_btnLock_actionAdapter(this));
    this.add(blueBkgWhiteCharLabel1, null);
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(txtDateEnd, null);
    pnlDuriation.add(jLabel3, null);
    this.add(cbxCntr, null);
    this.add(cbxDep, null);
    this.add(jLabel1, null);
    this.add(pnlDuriation, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(rdoByBuyer, null);
    this.add(rdoByMaker, null);
    this.add(btnLock, null);
    this.add(btnQry, null);
    buttonGroup1.add(rdoByBuyer);
    buttonGroup1.add(rdoByMaker);
    genDataBindObj();

  }
  public void genDataBindObj() {
    doingDB2Gui=true;
    dataBindComps.clear();
    try{
      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "ALL", null);
        dataBindComps.add(DbJcbxcbxCntr);
      } else {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        dataBindComps.add(DbJcbxcbxCntr);
      }


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "OBD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "OBD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);


      doingDB2Gui=false;
      cbxCntr.getItemListeners()[0].itemStateChanged(null);
      reportName="INV_SIGN.RPT";
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public HashMap composeParameters(){
  HashMap hm = super.composeParameters();
  hm.put("DEPT",""+dbCbxDep.getSelectedValue()+"");
  Object dateBgn=dbTxtDateBgn.getSelectedValue();
  Object dateEnd=dbTxtDateEnd.getSelectedValue();
  if(dateBgn==null){
    hm.put("OBD_FM","DATE(2000,01,01)");
  }
  if(dateEnd==null){
    hm.put("OBD_TO","DATE(2099,12,31)");
  }
  if(rdoByBuyer.isSelected()){
    hm.put("BY_BUYER","BUYER");
  }else{
    hm.put("BY_BUYER","MAKER");
  }
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
              cbxDep, "DEPT",
              new Vector(),
              "DEP_NAME", "DEP_NAME",
              null,
              "ALL", "ALL");
        } else {
          //deps and "ALL"dep allow to add.
          Vector depVects =
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          dbCbxDep = null;
          if (depVects == null) {
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "DEPT",
                new Vector(),
                "DEP_NAME", "DEP_NAME",
                null,
                "ALL", "ALL");
          } else if (depVects.size() > 1) {
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "DEPT",
                depVects,
                "DEP_NAME", "DEP_NAME",
                null,
                "ALL", "ALL");
            //guis.add(DbJcbxcbxDep);
          } else {
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "DEPT",
                depVects,
                "DEP_NAME", "DEP_NAME",
                null,"ALL","ALL");
            //guis.add(DbJcbxcbxDep);
          }
       }

      } catch (Exception exp) {
        exp.printStackTrace();
      }

  }
 }

 protected void generateReport(java.util.HashMap paraHm,String reportName)throws Exception{
   try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer;
    newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,reportName,paraHm);
    viewer.setHasGroupTree(false);
    viewer.start();
    javax.swing.JPanel tempPanel=new javax.swing.JPanel();
    tempPanel.setLayout(new java.awt.BorderLayout());
    tempPanel.add(viewer);
    processhandler.template.Properties.getSplitFrame().setLowerPanel(tempPanel);
    processhandler.template.Properties.getSplitFrame().validate();
    processhandler.template.Properties.getSplitFrame().repaint();

  }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }

 }

  void btnQry_actionPerformed(ActionEvent e) {
     JButtonQueryButtonAction(e);
     try{
     }catch(Exception exp){

     }

  }
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoByBuyer = new JRadioButton();
  JRadioButton rdoByMaker = new JRadioButton();
  JButton btnLock = new JButton();

  void btnLock_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster  dbHandler=
         new newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster();
        dbHandler.updateShippingPrintStatus4Buyer();
        //exgui.verification.VerifyLib.showAlert("Update Buyer Printe OK","Update Buyer Printe OK");
        dbHandler.updateShippingPrintStatus4Maker();

        exgui.verification.VerifyLib.showAlert("Update Buyer/Maker Status OK","Status Update");

    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }


}
class _btnQry_actionAdapter implements java.awt.event.ActionListener {
  PnlInvoice2Signe adaptee;

  _btnQry_actionAdapter(PnlInvoice2Signe adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQry_actionPerformed(e);
  }
}

class PnlInvoice2Signe_btnLock_actionAdapter implements java.awt.event.ActionListener {
  PnlInvoice2Signe adaptee;

  PnlInvoice2Signe_btnLock_actionAdapter(PnlInvoice2Signe adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnLock_actionPerformed(e);
  }
}
