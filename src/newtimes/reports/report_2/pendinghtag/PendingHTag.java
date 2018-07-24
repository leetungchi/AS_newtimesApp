package newtimes.reports.report_2.pendinghtag;

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

public class PendingHTag extends ScrollPaneGUI {
  Frame1 frame;
  private PendingHTagGUI gui = null;
  private String titleName = "Pending H' Tag 45 Days List";
  private boolean isViewer = false;
  private java.util.HashMap hmFields = new java.util.HashMap();

  public PendingHTag(Frame1 _frame) {
    frame = _frame;
    try {
      if(util.ApplicationProperites.getProperties("PendingHTagGUI")==null){
        gui = new PendingHTagGUI();
      }else{
        gui=(PendingHTagGUI)util.ApplicationProperites.getProperties("PendingHTagGUI");
      }
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(gui);
    this.setTitleName(titleName);
    this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.butnCopy.setEnabled(false);
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
    if (!isViewer) {
      util.ApplicationProperites.removeProperites("PendingHTagGUI");
      frame.showPanel(new newtimes.reports.report_2.ReportMenu2(frame));
    } else {
      frame.showPanel(new newtimes.reports.report_2.pendinghtag.PendingHTag(
          frame));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    try {
      if(check_txtYear()){
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        util.ApplicationProperites.setProperties("PendingHTagGUI", gui);
        this.butnPrint.setEnabled(false);
        isViewer = true;
        this.getFieldsData();
        setScrollPaneGUI(new exgui2.ReportGenerate("PENDING_HANG_TAG.rpt",
            this.setReportAgument()));
      }

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

      hmFields = util.MiscFunc.URLEncode(hmFields);
      StringBuffer sb = new StringBuffer();
      sb.append("&prompt0="+hmFields.get("CEN"));
      sb.append("&prompt1="+hmFields.get("DEP"));
      sb.append("&prompt2="+hmFields.get("YEAR"));
      sb.append("&prompt3="+hmFields.get("DIV"));
      sb.append("&prompt4="+hmFields.get("FTY"));
      sb.append("&prompt5="+hmFields.get("SEASON"));
      System.out.println("#sb:"+sb.toString());
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      hmFields.put("CEN", gui.dbJCBXCen.getSelectedValue().equals("null")?"":gui.dbJCBXCen.getSelectedValue());
      hmFields.put("DEP", gui.dbJCBXDep.getSelectedValue().equals("null")?"":gui.dbJCBXDep.getSelectedValue());
      hmFields.put("DIV", gui.dbJCBXDiv.getSelectedValue().equals("null")?"":gui.dbJCBXDiv.getSelectedValue());
      hmFields.put("SEASON", gui.dbJCBXSeason.getSelectedValue().equals("null")?"":gui.dbJCBXSeason.getSelectedValue());
      hmFields.put("FTY", gui.popMaker.getSelectedMakerValue()==null?"":gui.popMaker.getSelectedMakerValue().toString());
      hmFields.put("YEAR", gui.txtYear.getText().trim().equals("")?"":gui.txtYear.getText().trim());

      System.out.println("#hmFields:"+hmFields.toString());
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt get fields data.\n"+hmFields.toString());
    } finally {
      return hmFields;
    }
  }

  private boolean check_txtYear(){
    if (!gui.txtYear.getText().trim().equals("")) {
      if (exgui.verification.VerifyLib.isInteger(gui.txtYear,
          "The Year field must be integer!") == true) {
        return true;
      } else {
        gui.txtYear.grabFocus();
        return false;
      }
    } else {
      return true;
    }
  }

}
