package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import java.awt.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
import java.util.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptTravelFeeChk
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JButton btnQry = new JButton();

  public PnlRptTravelFeeChk() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("旅費核對表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 3, 807, 26));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setText("傳票日期");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 38, 98, 24));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(109, 38, 96, 24));
    txtDateTo.setBounds(new Rectangle(245, 38, 96, 24));
    txtDateTo.setText("2009/12/31");
    txtDateTo.setText("");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(204, 38, 41, 24));
    whiteBkgBlueCharLabel2.setText("~");
    whiteBkgBlueCharLabel2.setForeground(Color.blue);
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 14));
    btnQry.setBounds(new Rectangle(629, 38, 109, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(btnQry, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtDateFrom, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtDateTo, null);
    this.add(blueBkgWhiteCharLabel1, null);
    genDataBindObj();
  }
  public  HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    int year=util.MiscFunc.getYear(new java.sql.Date(System.currentTimeMillis()));
    if(txtDateFrom.getText().trim().length()==0){
      hm.put("P_DATE_FM","DATE("+String.valueOf(year)+",01,01)");
    }
    if(txtDateTo.getText().trim().length()==0){
      hm.put("P_DATE_TO","DATE("+String.valueOf(year)+",12,31)");
    }
    return hm;
  }

  public void genDataBindObj(){
    try{
      dataBindComps.clear();
      Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormater();

     exgui.DataBindTextWithChecker dbTxtPayDateFrom= new exgui.DataBindTextWithChecker(txtDateFrom,
                              "P_DATE_FM",
                              null, 10,
                              (exgui.Object2String)vftxtChkDD,
                              (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
      dataBindComps.add(dbTxtPayDateFrom);

      exgui.DataBindTextWithChecker dbTxtPayDateTo= new exgui.DataBindTextWithChecker(txtDateTo,
                         "P_DATE_TO", null, 10,
                         (exgui.Object2String)vftxtChkDD,
                         (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
       dataBindComps.add(dbTxtPayDateTo);
       reportName="ACC_CHECK_TRV.rpt";
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {
   String tmpUrl=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
   newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
       "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
 super.JButtonQueryButtonAction(null);
  newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpUrl;

  }
}
