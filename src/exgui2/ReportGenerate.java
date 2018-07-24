package exgui2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import com.inet.viewer.ReportViewerBean;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ReportGenerate extends JPanel {
  private String _reportFileName = null;
  private String _argString = null;

  public ReportGenerate() {
    try {
      jbInit();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public ReportGenerate(String reportFileName) {
    this._reportFileName = reportFileName;
    this._argString = null;
    try {
      jbInit();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public ReportGenerate(String reportFileName, String argString) {
    this._argString = argString;
    this._reportFileName = reportFileName;
    try {
      jbInit();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setReportViewer(this._reportFileName, this._argString);
  }

  public void setGenerateReport(String reportFileName) {
    this._reportFileName = reportFileName;
    this._argString = null;
  }

  public void setGenerateReport(String reportFileName, String argString) {
    this._argString = argString;
    this._reportFileName = reportFileName;
  }

  private void genReportViewer() {
    StringBuffer repSB = new StringBuffer();
    try{
      ReportViewerBean viewer = new ReportViewerBean();
      viewer.setHasGroupTree(false);
      repSB.append("http://");
      repSB.append(util.PublicVariable.REPORT_SERVER_AT);
      repSB.append("/crystal/TestServlet?report=");
      repSB.append(_reportFileName);
      if (_argString != null) {
        repSB.append(_argString);
      }
      System.out.println(repSB.toString());
      viewer.setReportName(repSB.toString());
      this.setSize(800,800);
      this.setLayout(new BorderLayout());
      this.add(viewer, null);
      viewer.setHasExportButton(true);
      viewer.start();
    } catch(Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, repSB.toString());
      exgui.verification.VerifyLib.showAlert(
          "Report Server Error\nPlease Notify System Manager", "Report Error");
    }
  }

  public void setReportViewer(String reportFileName, String argString) {
    try {
      this._argString = argString;
      this._reportFileName = reportFileName;
      this.genReportViewer();
    } finally {
      this._argString = null;
      this._reportFileName = null;
    }
  }

  public void setReportViewer(String reportFileName) {
    try {
      this._argString = null;
      this._reportFileName = reportFileName;
      this.genReportViewer();
    } finally {
      this._argString = null;
      this._reportFileName = null;
    }
  }
}
