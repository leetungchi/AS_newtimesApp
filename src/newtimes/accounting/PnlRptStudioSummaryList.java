package newtimes.accounting;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.util.*;
import newtimes.production.report.AbsQryPanel;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptStudioSummaryList
    //extends JPanel {
    extends AbsQryPanel{
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
  JButton btnQry = new JButton();
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;

  public PnlRptStudioSummaryList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

protected  void jbInit() throws Exception {

    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157)),"CREATE DATE");
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
    blueBkgWhiteCharLabel1.setText("STUDIO SUMMARY LIST");
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
    jLabel1.setText("PRINT INVOICE DATA:");
    jLabel1.setBounds(new Rectangle(341, 46, 115, 30));
    cbxPrintInvYN.setBounds(new Rectangle(460, 53, 156, 22));
    pnlCreateDate.add(lblDateEnd, null);
    pnlCreateDate.add(lblDateBgn, null);
    pnlCreateDate.add(txtDateFrom, null);
    pnlCreateDate.add(txtDateEnd, null);
    this.add(pnlCreateDate, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    this.add(jLabel1, null);
    this.add(cbxPrintInvYN, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();



      Object dateVfy = exgui.verification.CellFormat.
          getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateFrom, "P_CREATE_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_CREATE_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      super.reportName="ACC_STUDIO_BUYER.rpt";
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }

  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();

    if (dateBgn == null) {
      hm.put("P_CREATE_FM", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("P_CREATE_TO", "DATE(2099,12,31)");
    }
    hm.put("P_PRT_SRN",cbxPrintInvYN.getSelectedItem().toString().substring(0,1));
    return hm;
  }
  JLabel jLabel1 = new JLabel();
  JComboBox cbxPrintInvYN = new JComboBox(new String[]{"YES","NO"});

  void btnQry_actionPerformed(ActionEvent e) {
    String orgURL = newtimes.production.report.ReportCmdSet.myReportEngin.
        reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =orgURL;

  }

}
