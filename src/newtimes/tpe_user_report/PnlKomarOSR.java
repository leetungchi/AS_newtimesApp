package newtimes.tpe_user_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;
import newtimes.preproduction.guis.*;
import newtimes.production.report.AbsQryPanel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlKomarOSR
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel lblTitle = new BlueBkgWhiteCharLabel();
  JComboBox cbxDiv = new JComboBox();
  JLabel lblBuyer = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel lblBuyer1 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel lblMaker = new JLabel();
  JComboBox cbxCountry = new JComboBox();
  JLabel lblCountry = new JLabel();
  JButton btnReport = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxDiv;
  int index_divCbx;
  boolean doingDB2Gui=false;
  public PnlKomarOSR() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    lblTitle.setText("KOMAR O.S.R");
    lblTitle.setBounds(new Rectangle(-5, 16, 810, 26));
    this.setLayout(null);
    cbxDiv.setBounds(new Rectangle(409, 53, 178, 21));
    lblBuyer.setFont(new java.awt.Font("Dialog", 1, 11));
    lblBuyer.setText("BUYER:");
    lblBuyer.setBounds(new Rectangle(10, 52, 56, 23));
    slkBuyer.setBounds(new Rectangle(67, 52, 163, 23));
    lblBuyer1.setBounds(new Rectangle(344, 53, 65, 23));
    lblBuyer1.setText("DIVISION:");
    lblBuyer1.setFont(new java.awt.Font("Dialog", 1, 11));
    slkMaker.setBounds(new Rectangle(67, 84, 163, 23));
    lblMaker.setBounds(new Rectangle(10, 84, 56, 23));
    lblMaker.setText("MAKER:");
    lblMaker.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCountry.setBounds(new Rectangle(409, 84, 178, 21));
    lblCountry.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCountry.setText("COUNTRY:");
    lblCountry.setBounds(new Rectangle(344, 84, 70, 23));
    btnReport.setBounds(new Rectangle(660, 69, 119, 26));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setText("REPORT");
    btnReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReport_actionPerformed(e);
      }
    });
    this.add(lblTitle, null);
    this.add(cbxDiv, null);
    this.add(lblBuyer, null);
    this.add(slkBuyer, null);
    this.add(lblBuyer1, null);
    this.add(slkMaker, null);
    this.add(lblMaker, null);
    this.add(cbxCountry, null);
    this.add(lblCountry, null);
    this.add(btnReport, null);
    cbxDiv.setUI(new exgui.WideComboBoxUI(200));

    genDataBindObj();
  }
  public void genDataBindObj(){
    doingDB2Gui=true;
    if(dataBindComps==null)dataBindComps=new java.util.ArrayList();
    dataBindComps.clear();
    DbJcbxcbxDiv=new exgui.DataBindJCombobox(
        cbxDiv,
        "P_DIVISION",
        new Vector(),
        "DIV_NAME",
        "DIV_CODE",
        null,"N/A","ALL");
     dataBindComps.add(DbJcbxcbxDiv);
     index_divCbx=0;
     slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
     slkMaker.init("P_MAKER",null,slkBuyer.TYPE_MAKER,true);
     slkBuyer.setModifyNotifyTo(new ChangeBuyerHandler());
     doingDB2Gui=false;

     exgui.DataBindJCombobox dbJcbxQcCountry =
         new exgui.DataBindJCombobox(
           cbxCountry,"P_COUNTRY",
           newtimes.preproduction.guis.tempProperties.tmpCountries,
           "CNTY_NAME","CNTY_NAME",null,"ALL","ALL");
     dataBindComps.add(dbJcbxQcCountry);

     reportName ="KO_OSR.rpt";
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
              "P_DIVISION",
              new Vector(),
              "DIV_NAME","DIV_CODE",
              null,"N/A","ALL");
          //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          dataBindComps.set(index_divCbx,DbJcbxcbxDiv);

        }else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords=
              (Vector)tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
           DbJcbxcbxDiv=null;
          if(dvsnRecords==null){
            DbJcbxcbxDiv=new exgui.DataBindJCombobox(
                cbxDiv,
                "P_DIVISION",
                new Vector(),
                "DIV_NAME",
                "DIV_CODE",
                null,"N/A","ALL");
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }else {
            DbJcbxcbxDiv=new exgui.DataBindJCombobox(
                cbxDiv,
                "P_DIVISION",
                dvsnRecords,
                "DIV_NAME",
                "DIV_CODE",
               null,"N/A","ALL");
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }
          dataBindComps.set(index_divCbx,DbJcbxcbxDiv);

        }

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }
  public HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    hm.put("P_BUYER",(slkBuyer.getSelectedValue()==null)?"0": slkBuyer.getSelectedValue().toString());
    hm.put("P_MAKER",(slkMaker.getSelectedValue()==null)?"0": slkMaker.getSelectedValue().toString());
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    return hm;
  }
  void btnReport_actionPerformed(ActionEvent e) {
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
}
