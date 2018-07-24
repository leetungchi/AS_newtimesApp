package newtimes.shipping.invoice;

import java.awt.*;
import java.awt.event.*;
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

public class Invoice extends ScrollPaneGUI {
  Frame1 frame;
  private InvoiceGUI gui = new InvoiceGUI();

  public Invoice(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanel(gui,  new JPanel());
    this.jScrollPane_Bottom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.setDividerLocation(0.20);
    gui.do_Print.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_Print_actionPerformed(e);
      }
    });
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
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
    frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  void do_Print_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      java.util.Vector vFields = this.getFieldsData();
      if (vFields != null && vFields.size() > 0) {
        this.setLowerPanel(new exgui2.ReportGenerate("COMMERCIAL_INVOICE.RPT",
            this.setReportAgument()));
      } else {
        exgui2.InfoMessage.infoMessage(frame, "Please Input SRN N0.");
      }
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
          "error at attempt pressed Print for Not Final button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  private String setReportAgument() {
    try {
      StringBuffer sbArg = new StringBuffer();
      java.util.Vector vecFields = this.getFieldsData();
      if (vecFields.size() == 1) {
        sbArg.append("&prompt0="+vecFields.get(0));
      }
      return sbArg.toString();
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  java.util.Vector getFieldsData() {
    try {
      java.util.Vector vec = new java.util.Vector();
      for (int i = 0; i < gui.txtSrnNo.length; i++) {
        String curTxt = gui.txtSrnNo[i].getText().trim();
        if (!curTxt.equals("") && curTxt != null)
          vec.add(curTxt);
      }
      return vec;
    } catch(Exception eFD) {
      eFD.printStackTrace();
      util.ExceptionLog.exp2File(eFD, "error at get SRN NO");
      return null;
    }
  }
}