package newtimes.reports.report01.GSPLate;

import java.awt.*;
import javax.swing.*;
import newtimes.*;
import newtimes.shipping.ScrollPaneGUI;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GspLateReport extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "GSP Late Report";
  private java.util.HashMap condHm = new java.util.HashMap();

  public GspLateReport(Frame1 _frame, java.util.HashMap _hm) {
    frame = _frame;
    condHm = _hm;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(new exgui2.ReportGenerate("GSP_LATE.rpt", this.setReportAgument()));
    this.setTitleName(titleName);
    this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.butnCopy.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    frame.showPanel((RepGspLateCon)util.ApplicationProperites.getProperties("RepGspLateCon"));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      setScrollPaneGUI(new exgui2.ReportGenerate("GSP_LATE.rpt", this.setReportAgument()));
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
                                 "error at attempt pressed Print button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  private String setReportAgument() {
    try {
      StringBuffer sb = new StringBuffer();
      sb.append("");

      sb.append("&prompt0="+condHm.get("center"));
      sb.append("&prompt1="+condHm.get("depCode"));
      sb.append("&prompt2="+condHm.get("year"));
      sb.append("&prompt3="+condHm.get("divCode"));
      sb.append("&prompt4="+condHm.get("fty"));
      sb.append("&prompt5="+condHm.get("season"));
      sb.append("&prompt6="+condHm.get("country"));
      sb.append("&prompt7="+condHm.get("orderby"));
      sb.append("&prompt8="+condHm.get("quota"));
      System.out.println(sb.toString());
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}