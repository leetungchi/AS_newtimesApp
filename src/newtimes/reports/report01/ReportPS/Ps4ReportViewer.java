package newtimes.reports.report01.ReportPS;

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

public class Ps4ReportViewer extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Production Status Report  List";
  private java.util.HashMap condHm = new java.util.HashMap();

  public Ps4ReportViewer(Frame1 _frame, java.util.HashMap _hm) {
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
    this.setScrollPaneGUI(new exgui2.ReportGenerate("0704-SCR004.RPT", this.setReportAgument()));
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
    //frame.showPanel(new newtimes.reports.report01.ReportPS.RepPsSetup(frame, condHm));
    frame.showPanel((RepPsSetup)util.ApplicationProperites.getProperties("RepPsSetup"));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      setScrollPaneGUI(new exgui2.ReportGenerate("0704-SCR004.RPT", this.setReportAgument()));
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
      sb.append("&prompt0="+RepPsSearch.CEN);
      sb.append("&prompt1="+RepPsSearch.DEP);
      sb.append("&prompt2="+RepPsSearch.YEAR);
      sb.append("&prompt3="+RepPsSearch.DIV);
      sb.append("&prompt4="+RepPsSearch.FTY);
      sb.append("&prompt5="+RepPsSearch.SEASON);
      sb.append("&prompt6="+RepPsSearch.COUNTRY);
      sb.append("&prompt7="+RepPsSearch.INCLUDE_QTY);
      sb.append("&prompt8="+RepPsSetup.CANADA);
      sb.append("&prompt9="+RepPsSetup.ORDER_BY);
      sb.append("&prompt10="+RepPsSearch.PS_CLOSE);
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
