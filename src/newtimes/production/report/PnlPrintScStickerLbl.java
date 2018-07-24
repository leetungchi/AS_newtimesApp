package newtimes.production.report;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;

import java.awt.*;
import javax.swing.JPanel;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPrintScStickerLbl
     //extends JPanel {
      extends AbsQryPanel{
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCntr = new JComboBox();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   protected   DataBindTextWithChecker dbTxtScBgn,dbTxtScEnd;
   boolean doingDB2Gui=false;
   int indexCbxDep=0;
   int indexCbxMng=0;
  public PnlPrintScStickerLbl() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"S/C# ");
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(4, 54, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    blueBkgWhiteCharLabel1.setText("PRINT S/C STICKE LABELS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 803, 28));
    cbxCntr.setBounds(new Rectangle(42, 56, 147, 22));
    btnQry.setBounds(new Rectangle(685, 51, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("PRINT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    pnlDELDate.setBackground(new Color(202, 202, 224));
    pnlDELDate.setBorder(titledBorder1);
    pnlDELDate.setDebugGraphicsOptions(0);
    pnlDELDate.setBounds(new Rectangle(190, 42, 449, 47));
    pnlDELDate.setLayout(null);
    jLabel2.setText("TO");
    jLabel2.setBounds(new Rectangle(236, 16, 27, 20));
    txtScTo.setText("");
    txtScTo.setBounds(new Rectangle(290, 15, 135, 23));
    txtScFrom.setText("");
    txtScFrom.setBounds(new Rectangle(66, 15, 135, 23));
    jLabel3.setText("FROM");
    jLabel3.setBounds(new Rectangle(11, 15, 54, 18));
    pnlSCs.setLayout(null);
    pnlSCs.setBounds(new Rectangle(1, 83, 735, 77));
    pnlSCs.setDebugGraphicsOptions(0);
    pnlSCs.setBorder(titledBorder1);
    pnlSCs.setBackground(new Color(202, 202, 224));
    scs1.setText("");
    scs1.setBounds(new Rectangle(7, 18, 117, 24));
    scs2.setText("");
    scs2.setBounds(new Rectangle(126, 19, 117, 24));
    scs3.setText("");
    scs3.setBounds(new Rectangle(245, 19, 117, 24));
    scs4.setText("");
    scs4.setBounds(new Rectangle(364, 19, 117, 24));
    scs5.setText("");
    scs5.setBounds(new Rectangle(484, 19, 117, 24));
    scs6.setText("");
    scs6.setBounds(new Rectangle(604, 19, 117, 24));
    scs7.setText("");
    scs7.setBounds(new Rectangle(7, 45, 117, 24));
    scs9.setText("");
    scs9.setBounds(new Rectangle(245, 45, 117, 24));
    scs8.setText("");
    scs8.setBounds(new Rectangle(126, 45, 117, 24));
    scs10.setText("");
    scs10.setBounds(new Rectangle(364, 45, 117, 24));
    scs12.setText("");
    scs12.setBounds(new Rectangle(605, 45, 117, 24));
    scs11.setText("");
    scs11.setBounds(new Rectangle(485, 45, 117, 24));
    this.add(blueBkgWhiteCharLabel1, null);
    pnlDELDate.add(txtScFrom, null);
    pnlDELDate.add(jLabel3, null);
    pnlDELDate.add(txtScTo, null);
    pnlDELDate.add(jLabel2, null);
    this.add(btnQry, null);
    this.add(cbxCntr, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(pnlDELDate, null);
    this.add(pnlSCs, null);
    pnlSCs.add(scs2, null);
    pnlSCs.add(scs4, null);
    pnlSCs.add(scs5, null);
    pnlSCs.add(scs1, null);
    pnlSCs.add(scs3, null);
    pnlSCs.add(scs6, null);
    pnlSCs.add(scs12, null);
    pnlSCs.add(scs11, null);
    pnlSCs.add(scs10, null);
    pnlSCs.add(scs9, null);
    pnlSCs.add(scs8, null);
    pnlSCs.add(scs7, null);
    genDataBindObj();
    reportName="PROD_LABEL.rpt";
}
public void genDataBindObj() {
  doingDB2Gui=true;
  dataBindComps.clear();
  try{

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
    java.sql.Date now=null;//new java.sql.Date(System.currentTimeMillis());
    Object scRangeVfy = exgui.verification.CellFormat.getOrdinaryField(20);
    dbTxtScBgn=
        new exgui.DataBindTextWithChecker(txtScFrom, "P_SC_NO_FN", now,
                                          20, (exgui.Object2String)scRangeVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)scRangeVfy);
    dataBindComps.add(dbTxtScBgn);

    dbTxtScEnd =
        new exgui.DataBindTextWithChecker(txtScTo, "P_SC_NO_TO", now,
                                          20, (exgui.Object2String)scRangeVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)scRangeVfy);
    dataBindComps.add(dbTxtScEnd);


    doingDB2Gui=false;
  }catch(Exception exp){
    exp.printStackTrace();
  }
}
JTextField txtTwdUsd=new JTextField(),txtRmbUsd=new JTextField(),txtHkdUsd=new JTextField();

public HashMap composeParameters() {
  HashMap hm = super.composeParameters();
  String p_scs="[";
  if (scs1.getText().length() > 0 ) { p_scs=p_scs+"'"+scs1.getText()+"',"; }
  if (scs2.getText().length() > 0 ) { p_scs=p_scs+"'"+scs2.getText()+"',"; }
  if (scs3.getText().length() > 0 ) { p_scs=p_scs+"'"+scs3.getText()+"',"; }
  if (scs4.getText().length() > 0 ) { p_scs=p_scs+"'"+scs4.getText()+"',"; }
  if (scs5.getText().length() > 0 ) { p_scs=p_scs+"'"+scs5.getText()+"',"; }
  if (scs6.getText().length() > 0 ) { p_scs=p_scs+"'"+scs6.getText()+"',"; }
  if (scs7.getText().length() > 0 ) { p_scs=p_scs+"'"+scs7.getText()+"',"; }
  if (scs8.getText().length() > 0 ) { p_scs=p_scs+"'"+scs8.getText()+"',"; }
  if (scs9.getText().length() > 0 ) { p_scs=p_scs+"'"+scs9.getText()+"',"; }
  if (scs10.getText().length() > 0 ) { p_scs=p_scs+"'"+scs10.getText()+"',"; }
  if (scs11.getText().length() > 0 ) { p_scs=p_scs+"'"+scs11.getText()+"',"; }
  if (scs12.getText().length() > 0 ) { p_scs=p_scs+"'"+scs12.getText()+"',"; }
  p_scs=p_scs+"]";
  if (p_scs.equals("[]")) {
      p_scs="['ALL']";
  }
  hm.put("P_SCS",p_scs);

  return hm;
}

void btnQry_actionPerformed(ActionEvent e) {
//     if(txtScFrom.getText().trim().length() ==0){
//       exgui.verification.VerifyLib.showAlert("Please Input Begin SC#","Please Input Begin S/C");
//       return;
//     }
//     if(txtScTo.getText().trim().length()==0){
//       exgui.verification.VerifyLib.showAlert("Please Input End SC#","Please Input End S/C");
//       return;
//     }
     String prtSever=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
      "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
     super.JButtonQueryButtonAction(null);
      newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=prtSever;
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;
  JPanel pnlDELDate = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtScTo = new JTextField();
  JTextField txtScFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JPanel pnlSCs = new JPanel();
  JTextField scs1 = new JTextField();
  JTextField scs2 = new JTextField();
  JTextField scs3 = new JTextField();
  JTextField scs4 = new JTextField();
  JTextField scs5 = new JTextField();
  JTextField scs6 = new JTextField();
  JTextField scs7 = new JTextField();
  JTextField scs9 = new JTextField();
  JTextField scs8 = new JTextField();
  JTextField scs10 = new JTextField();
  JTextField scs12 = new JTextField();
  JTextField scs11 = new JTextField();


}

