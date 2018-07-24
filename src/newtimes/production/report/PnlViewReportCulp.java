package newtimes.production.report;
import com.inet.viewer.ReportViewerBean;
import java.awt.*;
import javax.swing.JPanel;

public class PnlViewReportCulp extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  StringBuffer sqlSb=null;
  public PnlViewReportCulp() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    this.removeAll();
    ReportViewerBean viewer =util.PublicVariable.inet_report_viewer; //new ReportViewerBean();
    viewer.setHasGroupTree(false);
    StringBuffer headRqSb=new StringBuffer();
    headRqSb.append("http://");
    headRqSb.append(util.PublicVariable.REPORT_SERVER_AT);
    headRqSb.append("/crystal/TestServlet?report=SC_DOC.RPT&prompt0=");
    //headRqSb.append(_prodSeq);
    headRqSb.append("&promptOnRefresh=0&cmd=rfsh");
    viewer.setReportName(headRqSb.toString());

    //jScrollPane1.getViewport().add(viewer, null);
    this.add(viewer);
    viewer.setHasExportButton(true);
    viewer.start();
  }
}
