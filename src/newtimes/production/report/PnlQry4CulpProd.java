package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
public class PnlQry4CulpProd extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtIssueFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtIssueTo = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField txtEtdhFrom = new JTextField();
  JTextField txtEtdTo = new JTextField();
  JLabel jLabel5 = new JLabel();
  JButton btnGenReport = new JButton();
  JLabel jLabel6 = new JLabel();
  JTextField txtPTTN_keyword = new JTextField();
  Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
  Object txtVfy=exgui.verification.CellFormat.getOrdinaryField(10);
  JTextField txtMillNO = new JTextField();
  JLabel lblDiv = new JLabel();
  JComboBox cbxDiv = new JComboBox();
  SelectBuyerMaker slkProdBuyer = new myBuyers();
  JLabel jLabel7 = new JLabel();

  exgui.DataBindJCombobox DbJcbxcbxDiv=null,dbcbxCenter=null;
  exgui.DataBindTextWithChecker   dbDateIssueFrom,dbDateIssueTo,
                                  dbDateEtdFrom,dbDateEtdEnd,
                                  dbWordMillNo,dbWordPttn,
                                  dbWordMtrNO,dbStyNo;
  ChangeBuyerHandler changeBuyerHandler;
  public PnlQry4CulpProd() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("QUERY FOR CULP REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-8, 0, 797, 23));
    this.setLayout(null);
    jLabel1.setText("KEY WORD OF MILLER:");
    jLabel1.setBounds(new Rectangle(14, 54, 154, 27));
    jLabel2.setText("ISSUE DATE FROM:");
    jLabel2.setBounds(new Rectangle(13, 87, 163, 22));
    txtIssueFrom.setText("");
    txtIssueFrom.setBounds(new Rectangle(163, 88, 79, 23));
    jLabel3.setText("TO");
    jLabel3.setBounds(new Rectangle(250, 88, 27, 23));
    txtIssueTo.setText("");
    txtIssueTo.setBounds(new Rectangle(279, 88, 84, 23));
    jLabel4.setBounds(new Rectangle(441, 87, 155, 22));
    jLabel4.setText("ETD DATE FROM:");
    txtEtdhFrom.setBounds(new Rectangle(603, 87, 71, 23));
    txtEtdhFrom.setText("");
    txtEtdTo.setBounds(new Rectangle(705, 87, 72, 23));
    txtEtdTo.setText("");
    jLabel5.setBounds(new Rectangle(676, 87, 27, 23));
    jLabel5.setText("TO");
    btnGenReport.setBounds(new Rectangle(347, 183, 84, 23));
    btnGenReport.setText("REPORT");
    btnGenReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGenReport_actionPerformed(e);
      }
    });
    jLabel6.setText("KEY WORD OF PTTN NAME:");
    jLabel6.setBounds(new Rectangle(440, 54, 158, 23));
    txtPTTN_keyword.setText("");
    txtPTTN_keyword.setBounds(new Rectangle(603, 54, 173, 25));
    txtMillNO.setText("");
    txtMillNO.setBounds(new Rectangle(163, 55, 197, 26));
    lblDiv.setText("DIVISION");
    lblDiv.setBounds(new Rectangle(14, 145, 95, 21));
    cbxDiv.setBounds(new Rectangle(163, 147, 198, 22));
    slkProdBuyer.setBounds(new Rectangle(163, 119, 199, 21));
    jLabel7.setText("Buyer");
    jLabel7.setBounds(new Rectangle(17, 116, 117, 21));
    lblStyle.setText("STYLE:");
    lblStyle.setBounds(new Rectangle(439, 155, 104, 20));
    txtStyle.setText("");
    txtStyle.setBounds(new Rectangle(603, 155, 183, 22));
    jLabel8.setText("Material No.");
    jLabel8.setBounds(new Rectangle(440, 124, 91, 19));
    txtMtrNo.setText("");
    txtMtrNo.setBounds(new Rectangle(603, 121, 182, 22));
    cbxCenter.setBounds(new Rectangle(163, 30, 199, 21));
    jLabel9.setText("CENTER");
    jLabel9.setBounds(new Rectangle(14, 30, 117, 22));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnGenReport, null);
    this.add(jLabel1, null);
    this.add(txtMillNO, null);
    this.add(jLabel6, null);
    this.add(txtPTTN_keyword, null);
    this.add(jLabel4, null);
    this.add(txtEtdhFrom, null);
    this.add(jLabel5, null);
    this.add(txtEtdTo, null);
    this.add(txtMtrNo, null);
    this.add(txtStyle, null);
    this.add(jLabel8, null);
    this.add(lblStyle, null);
    this.add(lblDiv, null);
    this.add(cbxDiv, null);
    this.add(jLabel7, null);
    this.add(slkProdBuyer, null);
    this.add(jLabel2, null);
    this.add(txtIssueFrom, null);
    this.add(jLabel3, null);
    this.add(txtIssueTo, null);
    this.add(cbxCenter, null);
    this.add(jLabel9, null);

    java.util.Vector vctCenters =
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select cen_code,cen_name from center where record_delete_flag=1",
        1, 999);
    dbcbxCenter = new exgui.DataBindJCombobox(
        cbxCenter, "", vctCenters, "cen_name", "cen_code",
        util.PublicVariable.OPERATTING_CENTER
        );


    changeBuyerHandler= new ChangeBuyerHandler();
    slkProdBuyer.init("prod_Buyer",null,slkProdBuyer.TYPE_BUYER,true);
    slkProdBuyer.setModifyNotifyTo(changeBuyerHandler);
    dbWordMtrNO=
           new  exgui.DataBindTextWithChecker(txtMtrNo,"MTR_NO",null,
           15,(exgui.Object2String)txtVfy,
            (exgui.ultratable.CellTxtEditorFormat)txtVfy);

    dbStyNo=
           new  exgui.DataBindTextWithChecker(txtStyle,"STY_STYLE",null,
           30,(exgui.Object2String)txtVfy,
            (exgui.ultratable.CellTxtEditorFormat)txtVfy);



  dbDateIssueFrom=
         new  exgui.DataBindTextWithChecker(txtIssueFrom,"issue_date>",null,
         10,(exgui.Object2String)dateVfy,
          (exgui.ultratable.CellTxtEditorFormat)dateVfy);
  dbDateIssueTo=
      new  exgui.DataBindTextWithChecker(txtIssueTo,"issue_date<",null,
      10,(exgui.Object2String)dateVfy,
       (exgui.ultratable.CellTxtEditorFormat)dateVfy);

    dbDateEtdFrom=
           new  exgui.DataBindTextWithChecker(txtEtdhFrom,"etd_date>",null,
           10,(exgui.Object2String)dateVfy,
            (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    dbDateEtdEnd=
        new  exgui.DataBindTextWithChecker(txtEtdTo,"etd_date<",null,
        10,(exgui.Object2String)dateVfy,
         (exgui.ultratable.CellTxtEditorFormat)dateVfy);


     dbWordMillNo=
         new  exgui.DataBindTextWithChecker(txtMillNO,"maker_name",null,
         10,(exgui.Object2String)txtVfy,
          (exgui.ultratable.CellTxtEditorFormat)txtVfy);

     dbWordPttn=
         new  exgui.DataBindTextWithChecker(txtPTTN_keyword,"pttn_name",null,
         10,(exgui.Object2String)txtVfy,
          (exgui.ultratable.CellTxtEditorFormat)txtVfy);
     changeBuyerHandler.changeBuyerMaker(null);//initialize
  }
  protected String toOracleDate(java.util.Date date){
    java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy,MM,dd");
    return "DATE("+df.format(date)+")";
  }
  class myBuyers extends newtimes.preproduction.buyermakerselect.SelectBuyerMaker{
    protected void btnDots_actionPerformed(java.awt.event.ActionEvent  ae){
      super.center_code=dbcbxCenter.getSelectedValue().toString();
      super.btnDots_actionPerformed(ae);
    }
  }
  void btnGenReport_actionPerformed(ActionEvent e) {
       //compose sql
    try{
      java.util.HashMap hm=new java.util.HashMap();
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       //assembly the production query condition for buyer-division condition
       //StringBuffer sbProdSql= new StringBuffer();
       hm.put("P_CENTER",dbcbxCenter.getSelectedValue());
       if(slkProdBuyer.getSelectedValue()!=null){
         hm.put("P_BUYER",util.MiscFunc.Replace(
                ((javax.swing.text.JTextComponent)slkProdBuyer.getGUIcomponent()).getText(),"'","''''"));
       }else{hm.put("P_BUYER",null);}

       if(DbJcbxcbxDiv.getSelectedValue()!=null){
         hm.put("P_DIV",DbJcbxcbxDiv.getSelectedValue());
       }else{hm.put("P_DIV",null);}

       if(dbWordMtrNO.getSelectedValue()!=null){
         hm.put("P_MTR_NO",dbWordMtrNO.getSelectedValue());
       }else{hm.put("P_MTR_NO",null);}

       if(dbStyNo.getSelectedValue()!=null){
         hm.put("P_STYLE", dbStyNo.getSelectedValue());
       }else{hm.put("P_STYLE",null);}

       String keyWord4MillNo=(String)dbWordMillNo.getSelectedValue();
       if(keyWord4MillNo!=null ){
         hm.put("P_MILL_NAME",keyWord4MillNo);
       }else{hm.put("P_MILL_NAME",null);}

       String keyWord4PttnName=(String)dbWordPttn.getSelectedValue();
       if(keyWord4PttnName!=null ){

         hm.put("P_PATT",
                keyWord4PttnName);
       }else{hm.put("P_PATT",null);}

       java.util.Date  objIssueFrom=
           (java.util.Date)dbDateIssueFrom.getSelectedValue();
      if(objIssueFrom!=null){
        hm.put("P_ISSU_B",toOracleDate(objIssueFrom));
      }else{hm.put("P_ISSU_B",null);}

      java.util.Date  objIssueEnd=
          (java.util.Date)dbDateIssueTo.getSelectedValue();
     if(objIssueEnd!=null){
        hm.put("P_ISSU_E",toOracleDate(objIssueEnd));
     }else{hm.put("P_ISSU_E",null);}

     java.util.Date  objETDFrom=
         (java.util.Date)dbDateEtdFrom.getSelectedValue();
    if(objETDFrom!=null){
      hm.put("P_ETD_B",toOracleDate(objETDFrom));
    }else{hm.put("P_ETD_B",null);}

    java.util.Date  objETDEnd=
        (java.util.Date)dbDateEtdEnd.getSelectedValue();
   if(objETDEnd!=null){
     hm.put("P_ETD_E",toOracleDate(objETDEnd));
   }else{hm.put("P_ETD_E",null);}

     //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt("fab_culp.rpt",null,hm);
     com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer; //new com.inet.viewer.ReportViewerBean();
     newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,"fab_culp.rpt",hm);
     viewer.setHasGroupTree(false);
     //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
     viewer.start();
     javax.swing.JPanel tempPanel=new javax.swing.JPanel();
     tempPanel.setLayout(new java.awt.BorderLayout());
     tempPanel.add(viewer);
     processhandler.template.Properties.getSplitFrame().setLowerPanel(tempPanel);
     processhandler.template.Properties.getSplitFrame().validate();
     processhandler.template.Properties.getSplitFrame().repaint();
   } catch(Exception exp){
      exp.printStackTrace();
   }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }
  }
  public int myGetYear(java.util.Date dateObj){
    java.sql.Date tmpDate=new java.sql.Date(dateObj.getTime());
    return util.MiscFunc.getYear(tmpDate);
  }
  public int myGetMonth(java.util.Date dateObj){
    java.sql.Date tmpDate=new java.sql.Date(dateObj.getTime());
    return util.MiscFunc.getMonth(tmpDate);
  }
  public int myGetDay(java.util.Date dateObj){
    java.sql.Date tmpDate=new java.sql.Date(dateObj.getTime());
    return util.MiscFunc.getDay(tmpDate);
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
              "PROD_BUYER_DIVISION",
              new Vector(),
              "DIV_NAME", "DIV_CODE",
              null, "", null);
        } else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords =
              (Vector)newtimes.preproduction.guis.tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
          DbJcbxcbxDiv = null;
          if (dvsnRecords == null) {
            DbJcbxcbxDiv = new exgui.DataBindJCombobox(
                cbxDiv,
                 "PROD_BUYER_DIVISION",
                new Vector(),
                "DIV_NAME",
                "DIV_CODE",
                null, "", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          } else {
            DbJcbxcbxDiv = new exgui.DataBindJCombobox(
                cbxDiv,
                "PROD_BUYER_DIVISION",
                dvsnRecords,
                "DIV_NAME",
                "DIV_CODE",
                null, "", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }

        }

      } catch (Exception exp) {
        exp.printStackTrace();
      }
    }
  }
  JLabel lblStyle = new JLabel();
  JTextField txtStyle = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField txtMtrNo = new JTextField();
  JComboBox cbxCenter = new JComboBox();
  JLabel jLabel9 = new JLabel();
}
