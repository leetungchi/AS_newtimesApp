package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.util.*;
import newtimes.production.report.AbsQryPanel;


import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlTpRptCommInv
//    extends JPanel {
    extends QryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JButton btnQry = new JButton();
  DataBindJCombobox dbCbxSzn;
  JTextField[] txtSrn = new JTextField[20];
    String srn_str ="";
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;

  public PnlTpRptCommInv() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

protected  void jbInit() throws Exception {

    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157)),"ETD DATE");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157));
    //pnlDeps.setLayout(null);
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setToolTipText("");
    blueBkgWhiteCharLabel1.setText("COMMERCIAL  INVOICE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 5, 800, 31));
    this.setBackground(new Color(204, 204, 225));
    btnQry.setBounds(new Rectangle(465, 71, 83, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
     JLabel jLabel1 = new JLabel();


    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel1.setForeground(Color.black);
    jLabel1.setToolTipText("");
    jLabel1.setText("Invoice :");
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(3, 95, 51, 21));
    jLabel1.setVerifyInputWhenFocusTarget(true);
    jLabel1.setText("INVOICE NO :");
    jLabel1.setBounds(new Rectangle(260, 73, 102, 22));
    jTextField1.setSelectionStart(12);
    jTextField1.setText("");
    jTextField1.setBounds(new Rectangle(340, 71, 115, 25));

    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(btnQry, null);
    this.add(jLabel1, null);

    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();

      java.util.Calendar cld=java.util.Calendar.getInstance();
      java.util.Date dFrom = new java.util.Date();
      int curr_year = dFrom.getYear()+1900;
      cld.set(curr_year,Calendar.JANUARY,1);

       dFrom=cld.getTime();


//      cld.set(cld.DATE,cld.getActualMaximum(cld.DAY_OF_YEAR));
      cld.set(curr_year,Calendar.DECEMBER,31);

      java.util.Date dEnd=cld.getTime();


      Object dateVfy = exgui.verification.CellFormat.
          getDateStringFormaterAllowNull();




      Vector seasons = newtimes.preproduction.guis.tempProperties.tmpSeason;

 /*     dbCbxSzn= new exgui.DataBindJCombobox(
        cbxSeason,"P_SEASON",
       seasons,"SEA_NAME","SEA_NAME",null,null,null); */

      dataBindComps.add(dbCbxSzn);

      super.reportName="TP_COMM_INV.rpt";
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }

  protected java.util.HashMap composeParameters(){

 //   java.util.HashMap hm=super.composeParameters();
    java.util.HashMap hm = new java.util.HashMap();
          hm.put("P_SHIP_NO",jTextField1.getText());

    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
/*
    if(null==slkMaker.getSelectedValue()){
      exgui.verification.VerifyLib.showAlert("Please Select Maker","Please Select Maker");
      return;
    }
  */

   if (jTextField1.getText() == null ) {
      exgui.verification.VerifyLib.showAlert("Please Input Invoice No !","Please Input Invoice No !");
      return;
   }

    String orgURL = newtimes.production.report.ReportCmdSet.myReportEngin.
        reportServerURL;

    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
      super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =orgURL;

  }
  JLabel jLabel1 = new JLabel();
  JTextField jTextField1 = new JTextField();



}
