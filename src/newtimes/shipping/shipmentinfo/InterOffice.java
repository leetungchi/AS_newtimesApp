package newtimes.shipping.shipmentinfo;

import java.awt.*;
import javax.swing.*;
import newtimes.shipping.ScrollPaneGUI;
import newtimes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class InterOffice extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Inter-Office Shipping Information";
  private String reportAgument = null;

  public InterOffice(Frame1 _frame, String _reportAgument) {
    frame = _frame;
    reportAgument = _reportAgument;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setTitleName(titleName);
    this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
    this.genReport();
    jScrollPane1.getViewport().add(
        new exgui2.ReportGenerate("0605-SCR002.rpt", reportAgument));
  }

  private void genReport() {
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    frame.showPanel(new newtimes.shipping.shipmentinfo.ShipmentInfo(frame));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }
}