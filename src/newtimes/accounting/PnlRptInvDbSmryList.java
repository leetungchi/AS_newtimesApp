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

public class PnlRptInvDbSmryList
    //extends JPanel {
    extends AbsQryPanel{
  JTextField txtDateEnd = new JTextField();
  JLabel lblDateBgn = new JLabel();
  JTextField txtDateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlFTYDEL = new JPanel();
  JLabel lblDateEnd = new JLabel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JButton btnQry = new JButton();
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;

  public PnlRptInvDbSmryList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

protected  void jbInit() throws Exception {

    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157));
    titledBorder1 = new TitledBorder(border1,"O.B.D");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157));
    //pnlDeps.setLayout(null);
    txtDateEnd.setBounds(new Rectangle(207, 11, 96, 22));
    txtDateEnd.setText("");
    this.setLayout(null);
    lblDateBgn.setBounds(new Rectangle(9, 10, 57, 22));
    lblDateBgn.setText("FROM");
    lblDateBgn.setToolTipText("");
    txtDateFrom.setBounds(new Rectangle(49, 11, 100, 22));
    txtDateFrom.setText("");
    blueBkgWhiteCharLabel1.setText("INVOICE / DN SUMMARY LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 5, 800, 31));
    pnlFTYDEL.setBackground(new Color(202, 202, 225));
    pnlFTYDEL.setBorder(titledBorder1);
    pnlFTYDEL.setBounds(new Rectangle(14, 43, 319, 41));
    pnlFTYDEL.setLayout(null);
    lblDateEnd.setText("TO");
    lblDateEnd.setBounds(new Rectangle(166, 12, 47, 22));
    this.setBackground(new Color(204, 204, 225));
    btnQry.setBounds(new Rectangle(706, 88, 83, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel1.setText("DESTINATION :");
    jLabel1.setBounds(new Rectangle(402, 50, 102, 26));
    cbxDest.setBounds(new Rectangle(500, 50, 289, 25));
    jLabel2.setText("SAMPLE / BULK :");
    jLabel2.setBounds(new Rectangle(13, 88, 96, 26));
    cbxSmpBlk.setBounds(new Rectangle(120, 90, 145, 25));
    jLabel3.setBounds(new Rectangle(305, 90, 96, 26));
    jLabel3.setText("REPORT TYPE :");
    cbxReportType.setBounds(new Rectangle(412, 90, 145, 25));
    pnlFTYDEL.add(lblDateEnd, null);
    pnlFTYDEL.add(lblDateBgn, null);
    pnlFTYDEL.add(txtDateFrom, null);
    pnlFTYDEL.add(txtDateEnd, null);
    this.add(btnQry, null);
    this.add(pnlFTYDEL, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(cbxDest, null);
    this.add(jLabel2, null);
    this.add(cbxSmpBlk, null);
    this.add(jLabel3, null);
    this.add(cbxReportType, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();



      Object dateVfy = exgui.verification.CellFormat.
          getDateStringFormaterAllowNull();
      java.sql.Date now=new java.sql.Date( System.currentTimeMillis() );
      java.util.Calendar gcc=java.util.GregorianCalendar.getInstance();
      gcc.setTime(now);
      gcc.add(gcc.DATE,-7);
      java.sql.Date b4=new java.sql.Date(gcc.getTime().getTime());
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateFrom, "P_OBD_FM", b4,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_OBD_TO", now,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      super.reportName="ACC_DEST_DBNO.rpt";
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }

  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();

    if (dateBgn == null) {
      hm.put("P_OBD_FM", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("P_OBD_TO", "DATE(2099,12,31)");
    }
    hm.put("P_SMPL_BULK",cbxSmpBlk.getSelectedItem().toString().substring(0,1));
    String destStr=(String)cbxDest.getSelectedItem();
    hm.put("P_DEST",destStr);
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    String orgURL = newtimes.production.report.ReportCmdSet.myReportEngin.
        reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    if("EXCEL".equalsIgnoreCase(cbxReportType.getSelectedItem().toString())){
      super.reportName="ACC_DEST_DBNO.rpt";
    }else{
      super.reportName="ACC_DEST_DBNO_1.rpt";
    }
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =orgURL;

  }
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDest = new JComboBox(new String[]{
                                    "US/CANADA",
                                    "EMEA",
                                    "MEXICO",
                                    "SOUTH AFRICA",
                                    "AUSTRALIA",
                                    "NEW ZEALAND",
                                    "HONG KONG",
                                    "CHINA",
                                    "SINGAPORE",
                                    "JAPAN",
                                    "WARRIOR-GERMANY",
                                    "DISTRIBUTORS"
                    });
  JLabel jLabel2 = new JLabel();
  JComboBox cbxSmpBlk = new JComboBox(new String[]{"BULK","SAMPLE"});
  JLabel jLabel3 = new JLabel();
  JComboBox cbxReportType = new JComboBox(new String[]{"ORIGINAL","EXCEL"});

}
