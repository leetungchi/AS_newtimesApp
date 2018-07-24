package newtimes.material;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newtimes.*;
import newtimes.shipping.ScrollPaneGUI;
import java.util.HashSet;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FabricReport extends ScrollPaneGUI {
  Frame1 frame;
  Object[] mtrDtlPk;

  public FabricReport(Frame1 _frame, HashSet _MtrDtl_pkList) {
    frame = _frame;
    this.mtrDtlPk = _MtrDtl_pkList.toArray();
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(new JPanel());
    this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.setTitleName("Fabric Development Report");
    this.butnCopy.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.doFabricReport();
  }
  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.material.MtrDtlPrintList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  void doFabricReport() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      java.util.Vector vFields = this.getFieldsData();
        this.setScrollPaneGUI(new exgui2.ReportGenerate("MATERIAL_PATTERN.RPT",
            this.setReportAgument()));
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
          "error at attempt pressed Fabric Development Report button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  private String setReportAgument() {
    try {
      StringBuffer sbArg = new StringBuffer();
      if (this.mtrDtlPk.length > 1) {
        sbArg.append("&prompt0='0'");
        for (int i = 0; i < this.mtrDtlPk.length; i++) {
          sbArg.append(",'");
          sbArg.append(this.mtrDtlPk[i]);
          sbArg.append("'");
        }
      } else {
        if (this.mtrDtlPk.length == 1) {
          sbArg.append("&prompt0='" + this.mtrDtlPk[0] + "'");
        } else {
          sbArg.append("&prompt0=null");
        }
      }
      return sbArg.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  java.util.Vector getFieldsData() {
    try {
      java.util.Vector vec = new java.util.Vector();
//      for (int i = 0; i < gui.txtSrnNo.length; i++) {
//        String curTxt = gui.txtSrnNo[i].getText().trim();
//        if (!curTxt.equals("") && curTxt != null)
//          vec.add(curTxt);
//      }
      return vec;
    } catch(Exception eFD) {
      eFD.printStackTrace();
      util.ExceptionLog.exp2File(eFD, "error at get SRN NO");
      return null;
    }
  }
}