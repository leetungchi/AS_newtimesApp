package newtimes.accounting;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.util.*;
import newtimes.production.report.AbsQryPanel;
import newtimes.production.report.QryPanel;

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

public class PnlRptInvDbnoDdk
 //   extends JPanel {
    extends AbsQryPanel{
  JLabel lblSeason = new JLabel();
  JComboBox cbxSeason = new JComboBox();
  JTextField txtDateEnd = new JTextField();
  JLabel lblDateBgn = new JLabel();
  JTextField txtDateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlCreateDate = new JPanel();
  JLabel lblDateEnd = new JLabel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JLabel lblYear = new JLabel();
  JTextField txYear = new JTextField();
  JButton btnQry = new JButton();
  DataBindJCombobox dbCbxSzn;
  JLabel lbl_payed = new JLabel("By : ");
  JComboBox by_payed = new JComboBox();
  JLabel lbl_bulk_sample = new JLabel("BULK/SAMPLE");
  JComboBox bulk_sample = new JComboBox();
  JLabel lbl_only_detail = new JLabel("SHOW STYLE & PO#");
  JComboBox only_detail = new JComboBox();

  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;

  public PnlRptInvDbnoDdk() {
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
    txtDateEnd.setBounds(new Rectangle(206, 18, 96, 22));
    txtDateEnd.setText("");
    this.setLayout(null);
    lblDateBgn.setBounds(new Rectangle(8, 17, 57, 22));
    lblDateBgn.setText("FROM");
    lblDateBgn.setToolTipText("");
    txtDateFrom.setBounds(new Rectangle(48, 18, 100, 22));
    txtDateFrom.setText("");
    blueBkgWhiteCharLabel1.setText("INVOICE DEBITNOTE DDK LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 5, 800, 31));
    pnlCreateDate.setBackground(new Color(202, 202, 225));
    pnlCreateDate.setBorder(titledBorder1);
    pnlCreateDate.setBounds(new Rectangle(14, 36, 319, 48));
    pnlCreateDate.setLayout(null);
    lblDateEnd.setText("TO");
    lblDateEnd.setBounds(new Rectangle(165, 19, 47, 22));
    this.setBackground(new Color(204, 204, 225));
    btnQry.setBounds(new Rectangle(706, 53, 83, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel1.setText("BUYER :");
    jLabel1.setBounds(new Rectangle(334, 48, 50, 30));
    slkBuyer.setBounds(new Rectangle(380, 51, 164, 25));

    jLabel2.setText("MAKER :");
    jLabel2.setBounds(new Rectangle(551, 82, 56, 30));
    slkMaker.setBounds(new Rectangle(600, 83, 160, 21));

    lblSeason.setBounds(new Rectangle(14, 107, 70, 17));
    lblSeason.setText("SEASON");
    cbxSeason.setBounds(new Rectangle(75, 105, 126, 20));

    lblYear.setBounds(new Rectangle(14, 87, 70, 17));;
    lblYear.setText("YEAR");
    txYear.setBounds(new Rectangle(75, 85, 126, 20));

    lbl_bulk_sample.setBounds(new Rectangle(250, 87, 130, 17));
    bulk_sample.addItem("ALL");
    bulk_sample.addItem("BULK");
    bulk_sample.addItem("SAMPLE");
    bulk_sample.setBounds(new Rectangle(400, 83, 100, 20));;

    lbl_payed.setBounds(new Rectangle(551, 107, 56, 17));
    by_payed.addItem("ALL");
    by_payed.addItem("BALANCE");
    by_payed.addItem("PAYED");
    by_payed.setSelectedItem("ALL");
    by_payed.setBounds(new Rectangle(600, 107, 100, 17));;


    lbl_only_detail.setBounds(new Rectangle(250, 105, 130, 17));;
    only_detail.addItem("NO");
    only_detail.addItem("YES");
    only_detail.setBounds(new Rectangle(400, 105, 100, 20));;

    jLabel3.setText("Form :");
    jLabel3.setBounds(new Rectangle(546, 52, 43, 23));
    jFormCbx.setBounds(new Rectangle(580, 52, 94, 23));
    jFormCbx.addItem("BUYER");
    jFormCbx.addItem("MAKER");
    jFormCbx.setSelectedItem("BUYER");
    pnlCreateDate.add(lblDateEnd, null);
    pnlCreateDate.add(lblDateBgn, null);
    pnlCreateDate.add(txtDateFrom, null);
    pnlCreateDate.add(txtDateEnd, null);
    this.add(pnlCreateDate, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    this.add(jLabel2, null);
    this.add(slkMaker, null);
    this.add(lblSeason,null);
    this.add(cbxSeason,null);
    this.add( lblYear,null);
    this.add( txYear,null);
    this.add( lbl_bulk_sample,null);
    this.add(bulk_sample,null);
    this.add(lbl_payed,null);
    this.add(by_payed,null);
    this.add( lbl_only_detail,null);
    this.add(only_detail,null);
    this.add(jLabel1, null);
    this.add(slkBuyer, null);
    this.add(jLabel3, null);
    this.add(jFormCbx, null);
    slkBuyer.init("P_BUYER",new Integer(11990),slkBuyer.TYPE_BUYER,true);
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
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateFrom, "P_ETD_FM", dFrom,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_ETD_TO", dEnd,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);

      Vector seasons = newtimes.preproduction.guis.tempProperties.tmpSeason;
      dbCbxSzn= new exgui.DataBindJCombobox(
          cbxSeason,"P_SEASON",
         seasons,"SEA_NAME","SEA_NAME","ALL","ALL",null);
 /*     dbCbxSzn= new exgui.DataBindJCombobox(
        cbxSeason,"P_SEASON",
       seasons,"SEA_NAME","SEA_NAME",null,null,null); */

      dataBindComps.add(dbCbxSzn);

//     if (jFormCbx.getSelectedItem().toString()== "BUYER") {
//         super.reportName = "INV_DBNO_DEDU.rpt";
//     } else {
//         super.reportName = "INV_DBNO_DEDU_M.rpt";
//     }

     }catch(Exception exp){
       exp.printStackTrace();
    }
  }

  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();

    if (dateBgn == null) {
      hm.put("P_ETD_FM", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("P_ETD_FM", "DATE(2099,12,31)");
    }
    hm.put("P_BUYER",slkBuyer.getSelectedValue());
    hm.put("P_MAKER",slkMaker.getSelectedValue());
    if (txYear.getText().length() == 0 )
    {
        hm.put("P_YEAR", "ALL");
    }
    else
    {
      hm.put("P_YEAR", txYear.getText());
    }
    hm.put("P_SEASON", cbxSeason.getSelectedItem().toString());

    if (bulk_sample.getSelectedItem().toString() == "BULK")
    {
      hm.put("P_BULK_SMP", "N");
    }
    else
    {
      if ( bulk_sample.getSelectedItem().toString() == "ALL")
      {
        hm.put("P_BULK_SMP", "ALL");
      }
      else
      {
        hm.put("P_BULK_SMP", "Y");
      }
    }
    if (by_payed.getSelectedItem().toString() == "PAYED")
   {
     hm.put("P_PAYED", "P");
   }
   else if (by_payed.getSelectedItem().toString() == "ALL") {
     hm.put("P_PAYED", "A");
   }
   else {
       hm.put("P_PAYED", "B");
   }

    if ( only_detail.getSelectedItem().toString() == "NO" )
    {
      hm.put("P_DETAIL", "N");
    }
    else
    {
      hm.put("P_DETAIL", "Y");
    }


    return hm;
  }
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel3 = new JLabel();
  JComboBox jFormCbx = new JComboBox();

  void btnQry_actionPerformed(ActionEvent e) {
    if(null==slkBuyer.getSelectedValue()){
      exgui.verification.VerifyLib.showAlert("Please Select Buyer","Please Select Buyer");
      return;
    }
    if (jFormCbx.getSelectedItem().toString()== "BUYER") {
         super.reportName = "INV_DBNO_DEDU.rpt";
     } else {
         super.reportName = "INV_DBNO_DEDU_M.rpt";
     }

    String orgURL = newtimes.production.report.ReportCmdSet.myReportEngin.
        reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =orgURL;

  }

}
