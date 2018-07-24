package newtimes.production.gui.order_change;
import java.awt.*;
import javax.swing.*;
import com.inet.viewer.ReportViewerBean;
public class PnlReprotOdrChg extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  boolean initOk=false;
  public PnlReprotOdrChg() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    this.add(jScrollPane1, BorderLayout.CENTER);
  }
  public boolean isInitOk(){return initOk;}
  public void setViewer(com.inet.viewer.ReportViewerBean viewer){
    jScrollPane1.getViewport().add(viewer, null);
  }
  public void generateReport(int _prodSeq){
    try{
      ReportViewerBean viewer =util.PublicVariable.inet_report_viewer; //new ReportViewerBean();
      viewer.setHasGroupTree(false);
      StringBuffer headRqSb=new StringBuffer();
      headRqSb.append("http://");
      headRqSb.append(util.PublicVariable.REPORT_SERVER_AT);
      /*
        http://172.16.0.24/crystal/TestServlet?report=ORDER_CHANGE.RPT&prompt0=1
       */
      headRqSb.append("/crystal/TestServlet?report=ORDER_CHANGE.RPT&prompt0=");
      headRqSb.append(_prodSeq);
      viewer.setReportName(headRqSb.toString());
      jScrollPane1.getViewport().add(viewer, null);
      viewer.setHasExportButton(true);
      viewer.start();
      initOk=true;
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Error While Generating Report",
          "Report Error");
      initOk=false;
    }
  }
}
