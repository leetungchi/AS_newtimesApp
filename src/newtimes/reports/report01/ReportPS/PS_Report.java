package newtimes.reports.report01.ReportPS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PS_Report extends JPanel {
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JButton btnExit = new JButton();
  Frame1 frame = null;
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  FlowLayout flowLayout1 = new FlowLayout();

  public PS_Report(Frame1 _frame) {
    try{
    frame = _frame;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    /*
     cmopose hashmap
    */
    this.setSize(780,550);
    java.util.HashMap paraHm=
        (java.util.HashMap) util.ApplicationProperites.getProperties("RepPsSearchConds");
    Object objCenter= paraHm.get("center");
    Object objDep= paraHm.get("depCode");
    Object objYear= paraHm.get("year");
    Object objMaker= paraHm.get("fty");
    Object objSzn= paraHm.get("season");
    Object objCountry= paraHm.get("country");
    Object objXldScNull= paraHm.get("EXCLUDE_SC_IS_NULL");
    Object objBuyerSeq= paraHm.get("BUYER");
    java.util.HashMap hm=new java.util.HashMap();
    hm.put("PROD_CEN_CODE",(objCenter==null)?"ALL":objCenter.toString());
    hm.put("DEP_CODE",(objDep==null)?"ALL":objDep.toString());
    hm.put("YEAR",(objYear==null)?"ALL":objYear.toString());
    hm.put("MAKER_SEQ",(objMaker==null)?"ALL":objMaker.toString());

    hm.put("SEASON",(objSzn==null)?"ALL":objSzn.toString());
    hm.put("COUNTRY",(objCountry==null)?"ALL":objCountry.toString());
    hm.put("EXCLUDE_SC_NULL",(objXldScNull==null)?"Y":objXldScNull.toString());
    hm.put("BUYER_SEQ",(objBuyerSeq==null)?"ALL":objBuyerSeq.toString());



    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt("ps_report.rpt" ,null,hm);
    com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer; //new com.inet.viewer.ReportViewerBean();
    newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,"ps_report.rpt",hm);
    viewer.setHasGroupTree(false);
    //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
    viewer.start();
    this.setLayout(borderLayout2);
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jPanel1.setLayout(flowLayout1);
    jPanel3.setLayout(borderLayout3);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel1.setBackground(new Color(204, 204, 225));
    this.add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(btnExit, null);
    this.add(jPanel3,  BorderLayout.CENTER);
    jPanel3.add(viewer,  BorderLayout.CENTER);
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{

      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        frame.showPanel(new newtimes.reports.report01.ReportPS.RepPsResult(frame));
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      frame.contentPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
    catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
