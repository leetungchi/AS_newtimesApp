package newtimes.production.gui.prodmaintain;
import java.awt.*;
import javax.swing.*;
import com.inet.viewer.ReportViewerBean;
public class PnlFbcCutSmyP_View extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JScrollPane jScrollPaneHead = new JScrollPane();
  int _prodSeq;
  public PnlFbcCutSmyP_View(int prodseq) {
    super();
    _prodSeq=prodseq;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
    genReportViewer();
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jPanel1.setLayout(null);
    jScrollPaneHead.setBounds(new Rectangle(5, 12, 759, 560));
    this.add(jPanel1,  BorderLayout.CENTER);
    jPanel1.add(jScrollPaneHead, null);
  }
 protected void genReportViewer(){
   try{
       newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
       java.util.HashMap mp=new java.util.HashMap();
       mp.put("prod_pk",String.valueOf(_prodSeq));
       //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt("FABRIC_PO_SUMARRY_HEAD.RPT",null,mp);
       com.inet.viewer.ReportViewerBean viewer=util.PublicVariable.inet_report_viewer;//new com.inet.viewer.ReportViewerBean();
       newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,"fabric_po_sumarry_head.rpt",mp);
       viewer.setHasGroupTree(false);
       //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
       viewer.start();
       jScrollPaneHead.getViewport().add(viewer, null);
       viewer.setHasExportButton(true);
        /*
            ReportViewerBean viewer = new ReportViewerBean();
            viewer.setHasGroupTree(false);
            StringBuffer headRqSb=new StringBuffer();
            headRqSb.append("http://");
            headRqSb.append(util.PublicVariable.REPORT_SERVER_AT);
            headRqSb.append("/crystal/TestServlet?report=FABRIC_PO_SUMARRY_HEAD.RPT&prompt0=");
            headRqSb.append(_prodSeq);
            viewer.setReportName(headRqSb.toString());
            jScrollPaneHead.getViewport().add(viewer, null);
            viewer.setHasExportButton(true);
            viewer.start();
         */
      } catch(Throwable ex) {
        ex.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
      }

 }
}
