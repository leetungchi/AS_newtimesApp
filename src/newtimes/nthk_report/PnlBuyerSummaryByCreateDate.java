package newtimes.nthk_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import newtimes.preproduction.guis.*;
import newtimes.preproduction.buyermakerselect.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlBuyerSummaryByCreateDate
    //extends JPanel {
    extends AbsQryPanel implements Int_PNL_JINIT{
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JTextField txtTo = new JTextField();
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel3 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JTextField txtYYYYMMDD = new JTextField();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  public PnlBuyerSummaryByCreateDate() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public void  jbInit() throws Exception {
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setFocusPainted(true);
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setBounds(new Rectangle(697, 66, 89, 25));
    txtYYYYMMDD.setBounds(new Rectangle(488, 65, 77, 24));
    //cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(60, 66, 130, 22));
    jLabel3.setBounds(new Rectangle(572, 64, 36, 26));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("To:");
    blueBkgWhiteCharLabel1.setText("BUYER SUMMARY BY CREATE DATE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 21, 802, 30));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.black);
    jLabel1.setText("Create Date From:");
    jLabel1.setBounds(new Rectangle(359, 64, 129, 26));
    txtTo.setBounds(new Rectangle(605, 65, 77, 24));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(3, 66, 60, 19));
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel3.setText("Center");
    this.setLayout(null);
    this.add(txtTo, null);
    this.add(jLabel3, null);
    this.add(cbxCntr, null);
    this.add(txtYYYYMMDD, null);
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(jLabel1, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
    dataBindComps.clear();
    try {

      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
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
      Object chkYearMon=CellFormat.getDateStringFormaterAllowNull();
     DataBindTextWithChecker yyyymmddDate = new DataBindTextWithChecker(txtYYYYMMDD, "P_CREATE_FM",
                                             new java.sql.Date(System.currentTimeMillis()), 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate);

     DataBindTextWithChecker yyyymmddDate2 = new DataBindTextWithChecker(txtTo, "P_CREATE_TO",
                                             new java.sql.Date(System.currentTimeMillis()), 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate2);
     reportName="NTFE_ORD_SUM.rpt";
    } catch (Exception exp) {

    }
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    if(txtYYYYMMDD.getText().trim().length()==0){
      hm.put("P_CREATE_FM","DATE(2000,01,01)");
    }
    if(txtTo.getText().trim().length()==0){
      hm.put("P_CREATE_TO","DATE(2099,12,31)");
    }

    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }
}
