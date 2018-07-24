package newtimes.reports.report01.GmtLcReq;

import java.awt.*;
import javax.swing.*;
import newtimes.shipping.ScrollPaneGUI;
import newtimes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @Chloe
 * @version 1.0
 */

public class GmtLcQueryReport extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "GMT L/C Require List";

  public GmtLcQueryReport(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(new exgui2.ReportGenerate("0702-SCR002.RPT",
            "&prompt0="+GmtLcQueryResult.listNo));
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
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      frame.showPanel(new newtimes.reports.report01.GmtLcReq.GmtLcList(frame));
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
                                 "error at attempt pressed Exit button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }
}