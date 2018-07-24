package newtimes.reports.report_2.outstandingqty;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newtimes.*;
import exgui2.SplitFrame;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class OutstandingQTY extends SplitFrame {
  Frame1 frame;
  private OutStandingQtyGUI gui = new OutStandingQtyGUI();
  private java.util.HashMap hmFields = new java.util.HashMap();

  public OutstandingQTY(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanel(gui, new JPanel());
    this.jScrollPane_Bottom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.setDividerLocation(0.30);
    this.butnCopy.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
  }

  public void butnPrint_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.getFieldsData();
      this.setLowerPanel(new exgui2.ReportGenerate("OUSTANDING_QTY.RPT", this.setReportAgument()));
    } catch(Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot, "error at attempt pressed Print button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void butnExit_actionPerformed(ActionEvent e) {
    try{
      frame.showPanel(new newtimes.reports.report_2.ReportMenu2(frame));
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

  private String setReportAgument() {
    try {
      StringBuffer sb = new StringBuffer();
      sb.append("&prompt0="+hmFields.get("FTY"));
      sb.append("&prompt1="+hmFields.get("DIV"));
      sb.append("&prompt2="+hmFields.get("CEN"));
      sb.append("&prompt3="+hmFields.get("DEP"));
      sb.append("&prompt4="+hmFields.get("SEASON"));
      return sb.toString();
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      hmFields.put("CEN",
                   gui.dbJCBXCen.getSelectedValue().equals("null") ? "" :
                   gui.dbJCBXCen.getSelectedValue());
      hmFields.put("DEP",
                   gui.dbJCBXDep == null ? "" :
                   gui.dbJCBXDep.getSelectedValue());
      hmFields.put("DIV",
                   gui.dbJCBXDiv.getSelectedValue().equals("null") ? "" :
                   gui.dbJCBXDiv.getSelectedValue());
      hmFields.put("SEASON",
                   gui.dbJCBXSeason.getSelectedValue().equals("null") ?
                   "" : gui.dbJCBXSeason.getSelectedValue());
      hmFields.put("FTY", gui.popMaker.getSelectedMakerValue()==null?"":gui.popMaker.getSelectedMakerValue());
      return hmFields;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}