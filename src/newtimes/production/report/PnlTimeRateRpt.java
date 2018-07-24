package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
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

public class PnlTimeRateRpt
    //extends JPanel {
    extends AbsQryPanel{
  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JLabel jLabel3 = new JLabel();
  JTextField txtDateBgn = new JTextField();
  TitledBorder titledBorder1;
  JComboBox cbxDiv = new JComboBox();
  SelectBuyerMaker slkProdBuyer = new myBuyers();
  JLabel jLabel7 = new JLabel();
  JLabel lblDiv = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxSzn = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel4 = new JLabel();
  JPanel pnlProdTypes = new JPanel();
  TitledBorder titledBorder2;
  Border border1;
  TitledBorder titledBorder3;
  JComboBox cbxProdType[] = new JComboBox[6];
  //JComboBox cbxProdType1 = new JComboBox();
  //JComboBox cbxProdType2 = new JComboBox();
  //JComboBox cbxProdType3 = new JComboBox();
  //JComboBox cbxProdType4 = new JComboBox();
  //JComboBox cbxProdType5 = new JComboBox();
  JButton btnQry = new JButton();
   ChangeBuyerHandler changeBuyerHandler;
  exgui.DataBindJCombobox dbCbxDivision=null,dbcbxCenter=null,dbCbxSzn=null,dbCbxQcCuntry=null;
  exgui.DataBindJCombobox dbCbxProdType[]=new exgui.DataBindJCombobox[6];
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtProdYear;
  boolean doingDB2Gui;
  int divCbxDBGUI_index;
  JLabel jLabel5 = new JLabel();
  JComboBox cbxCountry = new JComboBox();
  public PnlTimeRateRpt() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
   changeBuyerHandler=new ChangeBuyerHandler();
   for(int i=0;i<6;i++){
     cbxProdType[i]=new JComboBox();
   }
    titledBorder2 = new TitledBorder("");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder3 = new TitledBorder(border1,"PRODUCTION TYPE");
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(39, 58, 123, 20));
    jLabel4.setText("YEAR");
    jLabel4.setBounds(new Rectangle(4, 58, 48, 18));
    pnlProdTypes.setBackground(new Color(202, 202, 224));
    pnlProdTypes.setBorder(titledBorder3);
    pnlProdTypes.setBounds(new Rectangle(11, 79, 527, 107));
    pnlProdTypes.setLayout(null);
    cbxProdType[0].setBounds(new Rectangle(11, 20, 149, 23));
    cbxProdType[1].setBounds(new Rectangle(182, 20, 149, 23));
    cbxProdType[2].setBounds(new Rectangle(353, 20, 149, 23));
    cbxProdType[3].setBounds(new Rectangle(11, 61, 149, 23));
    cbxProdType[4].setBounds(new Rectangle(182, 61, 149, 23));
    cbxProdType[5].setBounds(new Rectangle(353, 61, 149, 23));
    btnQry.setBounds(new Rectangle(602, 161, 140, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel5.setBounds(new Rectangle(379, 31, 71, 19));
    jLabel5.setText("COUNTRY");
    cbxCountry.setBounds(new Rectangle(442, 31, 138, 22));
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(jLabel3, null);
    pnlDuriation.add(txtDateEnd, null);
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"On Board Date");
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder1);
    pnlDuriation.setBounds(new Rectangle(597, 77, 152, 78));
    pnlDuriation.setLayout(null);
    jLabel2.setText("FROM:");
    jLabel2.setBounds(new Rectangle(8, 19, 56, 21));
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(52, 42, 87, 22));
    this.setBackground(new Color(202, 202, 224));
    this.setForeground(Color.black);
    this.setLayout(null);
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(19, 42, 36, 24));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(52, 19, 87, 20));
    cbxDiv.setBounds(new Rectangle(231, 31, 131, 22));
    slkProdBuyer.setBounds(new Rectangle(39, 31, 123, 21));
    jLabel7.setText("Buyer");
    jLabel7.setBounds(new Rectangle(5, 31, 45, 21));
    lblDiv.setText("DIVISION");
    lblDiv.setBounds(new Rectangle(179, 31, 66, 21));
    blueBkgWhiteCharLabel1.setText("ON TIME RATE REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 0, 803, 25));
    cbxSzn.setBounds(new Rectangle(231, 58, 129, 22));
    jLabel1.setText("SEASON");
    jLabel1.setBounds(new Rectangle(178, 58, 71, 19));
    this.add(pnlProdTypes, null);
    this.add(pnlDuriation, null);
    pnlProdTypes.add(cbxProdType[0], null);
    pnlProdTypes.add(cbxProdType[1], null);
    pnlProdTypes.add(cbxProdType[2], null);
    pnlProdTypes.add(cbxProdType[3], null);
    pnlProdTypes.add(cbxProdType[4], null);
    pnlProdTypes.add(cbxProdType[5], null);
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel7, null);
    this.add(slkProdBuyer, null);
    this.add(lblDiv, null);
    this.add(cbxDiv, null);
    this.add(jLabel4, null);
    this.add(txtYear, null);
    this.add(jLabel1, null);
    this.add(cbxSzn, null);
    this.add(cbxCountry, null);
    this.add(jLabel5, null);
    //slkProdBuyer.init("prod_Buyer", null, slkProdBuyer.TYPE_BUYER, true);
    genDataBindObj();
    super.reportName="time_rate.rpt";
  }


  public HashMap composeParameters() {
    HashMap hm = super.composeParameters();
    Object objBuyerCode=slkProdBuyer.getSelectedValue();
    hm.put(slkProdBuyer.getOrgRecField(),(objBuyerCode==null)?"ALL":objBuyerCode.toString());
    //test if prod type.
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<6;i++){
      Object objProdType=dbCbxProdType[i].getSelectedValue();
      if(objProdType!=null){
        if(sb.length()>0)sb.append(",");
        sb.append("'");sb.append(objProdType.toString());sb.append("'");
      }
    }
    if(sb.length()>0){
      hm.put("TYPE","["+sb.toString()+"]");
    }else{
      hm.put("TYPE","['ALL']");
    }

    Object dateBgn = dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();
    if (dateBgn == null) {
      hm.put("OBD_FM", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("OBD_TO", "DATE(2099,12,31)");
    }
    return hm;
}

  public void genDataBindObj() {
    doingDB2Gui=true;
    dataBindComps.clear();
    slkProdBuyer.init("BUYER",null,slkProdBuyer.TYPE_BUYER,true);
    slkProdBuyer.setModifyNotifyTo(changeBuyerHandler);
    dataBindComps.add(slkProdBuyer);
    try{
      for(int i=0;i<6;i++){
        dbCbxProdType[i]=
            new exgui.DataBindJCombobox(cbxProdType[i] ,
                                        "",
                                        tempProperties.tmpProdType,
                                        "TYPE_NAME",
                                        "TYPE_CODE",
                                        "","",null);
      }
      java.util.Calendar cld=java.util.Calendar.getInstance();
      cld.set(cld.MONTH,cld.JANUARY);
      cld.set(cld.DATE,1);
      java.util.Date dFrom=cld.getTime();
      cld.set(cld.MONTH,cld.DECEMBER);
      cld.set(cld.DATE,31);
      java.util.Date dEnd=cld.getTime();
      //default end date is end day of currecnt mount
      Object yearVfy = exgui.verification.CellFormat.getIntVerifierAllowNull(4);

      dbTxtProdYear  =
          new exgui.DataBindTextWithChecker(txtYear, "YEAR", null,
                                            4, (exgui.Object2String)yearVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)yearVfy);
      dataBindComps.add(dbTxtProdYear);

      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "OBD_FM", dFrom,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "OBD_TO", dEnd,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      Vector vctSzn=tempProperties.tmpSeason;
      dbCbxSzn =
          new exgui.DataBindJCombobox(
          cbxSzn, "SEASON",
          vctSzn,
          "SEA_NAME", "SEA_NAME", "ALL", "ALL", null);
      dataBindComps.add(dbCbxSzn);

      dbCbxQcCuntry =
          new exgui.DataBindJCombobox(
          cbxCountry, "QC_COUNTRY",
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME", "CNTY_NAME", "ALL", "ALL", null);
      dataBindComps.add(dbCbxQcCuntry);



      divCbxDBGUI_index=  dataBindComps.size();
      Vector vctDivs=new Vector();
      dbCbxDivision =
          new exgui.DataBindJCombobox(
          cbxDiv, "DIV",
          vctDivs,
          "DIV_NAME", "DIV_CODE", "ALL", "ALL", null);
      dataBindComps.add(dbCbxDivision);


      doingDB2Gui=false;
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  class myBuyers extends newtimes.preproduction.buyermakerselect.SelectBuyerMaker{
    protected void btnDots_actionPerformed(java.awt.event.ActionEvent  ae){
      super.center_code=util.PublicVariable.OPERATTING_CENTER.toString();
      super.btnDots_actionPerformed(ae);
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
          dbCbxDivision = new exgui.DataBindJCombobox(
              cbxDiv,
              "DIV",
              new Vector(),
              "DIV_NAME", "DIV_CODE",
              "ALL", "ALL", null);
        } else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords =
              (Vector)newtimes.preproduction.guis.tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
          dbCbxDivision = null;
          if (dvsnRecords == null) {
            dbCbxDivision = new exgui.DataBindJCombobox(
                cbxDiv,
                 "DIV",
                new Vector(),
                "DIV_NAME",
                "DIV_CODE",
                "ALL", "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          } else {
            dbCbxDivision = new exgui.DataBindJCombobox(
                cbxDiv,
                "DIV",
                dvsnRecords,
                "DIV_NAME",
                "DIV_CODE",
                "ALL", "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));

          }

        }
        dataBindComps.set(divCbxDBGUI_index,dbCbxDivision);
      } catch (Exception exp) {
        exp.printStackTrace();
      }
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(slkProdBuyer.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Select A Buyer","Please Select A Buyer");
      return ;
    }
    super.JButtonQueryButtonAction(null);
  }

}
