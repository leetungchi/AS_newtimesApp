package newtimes.accounting.local_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
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

public class PnlRptDbntDdtList
     //extends JPanel {
     extends newtimes.production.report.AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JButton btnQry = new JButton();
  boolean doingDB2Gui=false;
  JLabel lblChkNo=new JLabel();
  JTextField txtChkNo=new JTextField();
  public PnlRptDbntDdtList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    border1 = BorderFactory.createEmptyBorder();
    titledBorder1 = new TitledBorder(border1,"DEL DD");
    border2 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"O.B.D.");
    blueBkgWhiteCharLabel1.setText("DEBIT NOTE DEDUCT LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 803, 28));
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(704, 48, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    lblChkNo.setFont(new java.awt.Font("Dialog", 1, 11));
    lblChkNo.setText("CHECK NO");
    lblChkNo.setBounds(new Rectangle(15, 50, 69, 26));
    txtChkNo.setBounds(new Rectangle(88, 50, 149, 28));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    this.add(lblChkNo, null);
    this.add(txtChkNo, null);
    genDataBindObj();

  }
  public void genDataBindObj() {
    doingDB2Gui=true;
    dataBindComps.clear();
    try{
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public HashMap composeParameters(){
  HashMap hm = super.composeParameters();
  hm.put("P_CHK_NO",txtChkNo.getText().trim().toUpperCase());
  return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(txtChkNo.getText().trim().length()<10){
      exgui.verification.VerifyLib.showAlert("Please Input Check #","Please Input Check #");
      return;
    }
    super.reportName="DB_CHK_LIST.rpt";
    String tmpUrl=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
     "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";
     super.JButtonQueryButtonAction(null);
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpUrl;

  }


}
