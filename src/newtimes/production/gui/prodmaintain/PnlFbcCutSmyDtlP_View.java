package newtimes.production.gui.prodmaintain;
import com.inet.viewer.ReportViewerBean;
public class PnlFbcCutSmyDtlP_View extends PnlFbcCutSmyP_View {
  public PnlFbcCutSmyDtlP_View(int prodseq) {
    super(prodseq);
  }
  protected void genReportViewer(){
    try{
             StringBuffer headRqSb=new StringBuffer();
             ReportViewerBean viewerDtl =util.PublicVariable.inet_report_viewer; //new ReportViewerBean();
             viewerDtl.setHasGroupTree(false);
             headRqSb=new StringBuffer();
             headRqSb.append("http://");
             headRqSb.append(util.PublicVariable.REPORT_SERVER_AT);
             headRqSb.append("/crystal/TestServlet?report=FABRIC_PO_SUMARRY.RPT&prompt0=");
             headRqSb.append(_prodSeq);
             viewerDtl.setReportName(headRqSb.toString());
             jScrollPaneHead.getViewport().add(viewerDtl, null);
             viewerDtl.setHasExportButton(true);
             viewerDtl.start();
       } catch(Throwable ex) {
         ex.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
       }

  }

}
