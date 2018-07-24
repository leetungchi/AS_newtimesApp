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

public class PnlRptBrandBaseStatus
    //extends JPanel {
    extends AbsQryPanel {
  JTextField txtTo = new JTextField();
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtYYYYMMDD = new JTextField();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  JTextField txtScTo = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField txtScFrom = new JTextField();
  JTextField txtTo_ISU = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtYYYYMMDD_ISU = new JTextField();
  public PnlRptBrandBaseStatus() {
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
    btnQry.setBounds(new Rectangle(697, 62, 89, 25));
    txtYYYYMMDD.setBounds(new Rectangle(486, 34, 77, 24));
    //cbxCntr.addItemListener(new cbxCenterItemChanged());
    jLabel3.setBounds(new Rectangle(570, 34, 36, 26));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("To:");
    blueBkgWhiteCharLabel1.setText("BrandBase Status");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 2, 802, 30));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.black);
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setToolTipText("");
    jLabel1.setText("Delivery Date From:");
    jLabel1.setBounds(new Rectangle(367, 34, 118, 26));
    txtTo.setBounds(new Rectangle(603, 34, 77, 24));
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    txtScTo.setBounds(new Rectangle(225, 37, 124, 24));
    jLabel2.setBounds(new Rectangle(3, 37, 76, 26));
    jLabel2.setText("S/C From:");
    jLabel2.setForeground(Color.black);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("To:");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setBounds(new Rectangle(201, 36, 24, 26));
    txtScFrom.setBounds(new Rectangle(63, 37, 131, 24));
    txtTo_ISU.setBounds(new Rectangle(604, 63, 77, 24));
    jLabel5.setBounds(new Rectangle(338, 63, 148, 26));
    jLabel5.setText("Invoice Issue Date From:");
    jLabel5.setToolTipText("");
    jLabel5.setRequestFocusEnabled(true);
    jLabel5.setForeground(Color.black);
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setText("To:");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setBounds(new Rectangle(571, 63, 36, 26));
    txtYYYYMMDD_ISU.setBounds(new Rectangle(487, 63, 77, 24));
    this.add(btnQry, null);
    genDataBindObj();
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtYYYYMMDD, null);
    this.add(jLabel1, null);
    this.add(jLabel3, null);
    this.add(txtTo, null);
    this.add(jLabel4, null);
    this.add(jLabel2, null);
    this.add(txtScFrom, null);
    this.add(txtScTo, null);
    this.add(jLabel6, null);
    this.add(jLabel5, null);
    this.add(txtYYYYMMDD_ISU, null);
    this.add(txtTo_ISU, null);
  }
  public void genDataBindObj(){
    dataBindComps.clear();
    try {

      Object chkYearMon=CellFormat.getDateStringFormaterAllowNull();
     DataBindTextWithChecker yyyymmddDate = new DataBindTextWithChecker(txtYYYYMMDD, "P_DEL_FM",
                                             null, 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate);

     DataBindTextWithChecker yyyymmddDate2 = new DataBindTextWithChecker(txtTo, "P_DEL_TO",
                                             null, 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate2);


     DataBindTextWithChecker yyyymmddDateIsu = new DataBindTextWithChecker(txtYYYYMMDD_ISU, "P_ISSU_FM",
                                             null, 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDateIsu);

     DataBindTextWithChecker yyyymmddDate2Isu = new DataBindTextWithChecker(txtTo_ISU, "P_ISSU_TO",
                                             null, 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate2Isu);


     reportName="BRANDBASE.rpt";
    } catch (Exception exp) {

    }
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    if(txtYYYYMMDD.getText().trim().length()==0){
      hm.put("P_DEL_FM","DATE(2000,01,01)");
    }
    if(txtTo.getText().trim().length()==0){
      hm.put("P_DEL_TO","DATE(2099,12,31)");
    }
    if(txtYYYYMMDD_ISU.getText().trim().length()==0){
      hm.put("P_ISSU_FM",null);
    }
    if(txtTo_ISU.getText().trim().length()==0){
      hm.put("P_ISSU_TO",null);
    }


    String scFrom=txtScFrom.getText().trim().toUpperCase();
    String scTo=txtScTo.getText().trim().toUpperCase();
    hm.put("P_SC_FM",(scFrom.equals("")?"":scFrom));
    hm.put("P_SC_TO",(scTo.equals("")?"":scTo));

    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    String tmpUrl=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
     "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";
     super.JButtonQueryButtonAction(null);
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpUrl;
  }
}
