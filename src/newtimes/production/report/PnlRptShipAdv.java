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

public class PnlRptShipAdv
    //extends JPanel {
    extends QryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JButton btnQry = new JButton();
  DataBindJCombobox dbCbxSzn;
  JLabel lbl_bulk_sample = new JLabel("MERCHANDISER :");
  JComboBox bulk_sample = new JComboBox();
  JTextField[] txtSrn = new JTextField[20];
  JLabel jLabel2 = new JLabel();
   SelectBuyerMaker slkMaker = new SelectBuyerMaker();
    String srn_str ="";
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;

  public PnlRptShipAdv() {
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
    blueBkgWhiteCharLabel1.setText("SHIPPING ADVICE LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 5, 800, 31));
    this.setBackground(new Color(204, 204, 225));
    btnQry.setBounds(new Rectangle(690, 39, 83, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });

    jLabel2.setText("MAKER :");
    jLabel2.setBounds(new Rectangle(6, 38, 56, 24));



    slkMaker.setBounds(new Rectangle(61, 41, 160, 21));
     GridLayout gridLayout1 = new GridLayout();
     JPanel jPanel1 = new JPanel();
     JLabel jLabel1 = new JLabel();



    lbl_bulk_sample.setToolTipText("");
    lbl_bulk_sample.setText("MERCH. :");
    lbl_bulk_sample.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_bulk_sample.setBounds(new Rectangle(228, 42, 65, 17));
    bulk_sample.addItem("ALL");
    bulk_sample.addItem("AMIE HSIAO");
    bulk_sample.addItem("FELICIA HU");
    bulk_sample.addItem("FINNA YANG");
    bulk_sample.addItem("YALLENDA CHEN");
    bulk_sample.setBounds(new Rectangle(279, 41, 100, 20));;



    jPanel1.setBounds(new Rectangle(60, 70, 692, 85));
    gridLayout1.setColumns(5);
    gridLayout1.setRows(4);
    jPanel1.setLayout(gridLayout1);

    for (int i=0;i<20;i++) {
         txtSrn[i] = new JTextField();
         txtSrn[i].setSize(10,8);
         jPanel1.add((JTextField)txtSrn[i]);
    }

    jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel1.setForeground(Color.blue);
    jLabel1.setToolTipText("");
    jLabel1.setText("Invoice :");
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(3, 95, 51, 21));
    jLabel1.setVerifyInputWhenFocusTarget(true);
    jLabel1.setText("INV RANGE :");
    jLabel1.setBounds(new Rectangle(386, 42, 86, 22));
    jTextField1.setSelectionStart(12);
    jTextField1.setText("");
    jTextField1.setBounds(new Rectangle(472, 39, 99, 25));
    jTextField2.setToolTipText("");
    jTextField2.setBounds(new Rectangle(582, 40, 100, 23));

    jLabel3.setFont(new java.awt.Font("Dialog", 0, 13));
    jLabel3.setToolTipText("");
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel3.setText("-");
    jLabel3.setBounds(new Rectangle(571, 41, 12, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel2, null);
    this.add(slkMaker, null);
    this.add(jPanel1);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(lbl_bulk_sample, null);
    this.add(bulk_sample, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(jTextField2, null);
    this.add(jLabel3, null);
    this.add(btnQry, null);

    slkMaker.init("P_MAKER",new Integer(0),slkMaker.TYPE_MAKER,true);
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

      super.reportName="SHIP_ADV.rpt&firstgroupassheets=true";
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }

  protected java.util.HashMap composeParameters(){

 //   java.util.HashMap hm=super.composeParameters();
    java.util.HashMap hm = new java.util.HashMap();
    if (slkMaker.getSelectedValue() == null ) {
      hm.put("P_FTY", "0");
    } else {
      hm.put("P_FTY", slkMaker.getSelectedValue());
    }
    hm.put("P_USER",bulk_sample.getSelectedItem().toString());


    if (jTextField1.getText() == null) {
          hm.put("P_INV_FM","ZATW00000000");
    } else {
          hm.put("P_INV_FM",jTextField1.getText());
    }
    if (jTextField2.getText() == null) {
          hm.put("P_INV_TO","ZATWZZZZZZZZ");
    } else {
      hm.put("P_INV_TO", jTextField2.getText());
    }
    if (srn_str.equals("[]")) {
        srn_str="['ALL']";
    }
     hm.put("P_INV",srn_str);
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
/*
    if(null==slkMaker.getSelectedValue()){
      exgui.verification.VerifyLib.showAlert("Please Select Maker","Please Select Maker");
      return;
    }
  */
    srn_str ="";
     for (int i=0;i<20;i++) {
         if (txtSrn[i].getText() != null &&  txtSrn[i].getText().length() > 0 ) {
             srn_str=srn_str+",'"+txtSrn[i].getText()+"'";
         }
      }
   if (srn_str.equals("") && jTextField1.getText() == null && jTextField2.getText() == null) {
      exgui.verification.VerifyLib.showAlert("Please Input Invoice No !","Please Input Invoice No !");
      return;
   }
   srn_str="["+srn_str.replaceFirst(",","")+"]";

    String orgURL = newtimes.production.report.ReportCmdSet.myReportEngin.
        reportServerURL;

    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
      super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =orgURL;

  }
  JLabel jLabel1 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JTextField jTextField2 = new JTextField();
  JLabel jLabel3 = new JLabel();



}
