package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
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

public class PnlExchangeRate
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JComboBox cbxBase = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCurrency = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField txtFrom = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtTo = new JTextField();
  JButton btnQry = new JButton();
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  exgui.DataBindJCombobox DbJcbxcbxCntr,dbCbxCurrencyBase,dbCbxCurrencyCur;

  public PnlExchangeRate() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("EXCHANGE RATE LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 11, 803, 32));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("CENTER");
    jLabel1.setBounds(new Rectangle(11, 50, 58, 24));
    cbxCenter.setBounds(new Rectangle(65, 50, 117, 22));
    cbxBase.setBounds(new Rectangle(259, 50, 117, 22));
    jLabel2.setBounds(new Rectangle(191, 50, 72, 24));
    jLabel2.setText("BASE");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCurrency.setBounds(new Rectangle(259, 81, 117, 22));
    jLabel3.setBounds(new Rectangle(183, 81, 80, 24));
    jLabel3.setText("CURRENCY");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("FROM");
    jLabel4.setBounds(new Rectangle(387, 50, 54, 24));
    txtFrom.setText("");
    txtFrom.setBounds(new Rectangle(428, 50, 72, 22));
    jLabel5.setBounds(new Rectangle(517, 50, 54, 24));
    jLabel5.setText("TO");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    txtTo.setBounds(new Rectangle(558, 50, 72, 22));
    txtTo.setText("");
    btnQry.setBounds(new Rectangle(679, 81, 99, 26));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(cbxCenter, null);
    this.add(jLabel2, null);
    this.add(cbxBase, null);
    this.add(cbxCurrency, null);
    this.add(jLabel3, null);
    this.add(jLabel4, null);
    this.add(txtFrom, null);
    this.add(jLabel5, null);
    this.add(txtTo, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
  public void genDataBindObj() {
    dataBindComps.clear();
    try{
      if (newtimes.preproduction.guis.tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCenter, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "'ALL'", null);
        dataBindComps.add(DbJcbxcbxCntr);
      } else {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCenter, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        dataBindComps.add(DbJcbxcbxCntr);
      }


      dbCbxCurrencyBase =
          new exgui.DataBindJCombobox(
          cbxBase, "P_BASE",
          tempProperties.tmpCurrency,
          "CRNCY_NAME", "CRNCY_NAME",
          "USD");
      dataBindComps.add(dbCbxCurrencyBase);

      dbCbxCurrencyCur =
          new exgui.DataBindJCombobox(
          cbxCurrency, "P_CURRENCY",
          tempProperties.tmpCurrency,
          "CRNCY_NAME", "CRNCY_NAME",
          "TWD");
      dataBindComps.add(dbCbxCurrencyCur);


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtFrom, "P_DD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtTo, "P_DD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      super.reportName="EXRATE_DET.rpt";
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }


  public java.util.HashMap  composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    if(null==dbTxtDateBgn.getSelectedValue()){
      hm.put(dbTxtDateBgn.getOrgRecField(),super.convert2QueryPara(util.MiscFunc.toDate(2000,01,01)));
      //super.convert2QueryPara(dbDelDateFrom.getSelectedValue()==null?util.MiscFunc.toDate(2000,01,01)
    }
    if(null==dbTxtDateEnd.getSelectedValue()){
      hm.put(dbTxtDateBgn.getOrgRecField(),super.convert2QueryPara(util.MiscFunc.toDate(2099,12,31)));
    }
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    super.JButtonQueryButtonAction(e);
  }
}
