package newtimes.reports.report_2.ppssenddelay;

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

public class PpsSendDelay extends ScrollPaneGUI {
  Frame1 frame;
  private PpsSendDelayGUI gui = null;
  private String titleName = "PPS Send Delay";
  private boolean isViewer = false;
  private java.util.HashMap hmFields = new java.util.HashMap();

  public PpsSendDelay(Frame1 _frame) {
    frame = _frame;
    try {
      if(util.ApplicationProperites.getProperties("PpsSendDelayGUI")==null){
        gui = new PpsSendDelayGUI();
      }else{
        gui=(PpsSendDelayGUI)util.ApplicationProperites.getProperties("PpsSendDelayGUI");
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
      util.ApplicationProperites.removeProperites("PpsSendDelayGUI");
      frame.showPanel(new newtimes.reports.report_2.ReportMenu2(frame));
    } else {
      frame.showPanel(new newtimes.reports.report_2.ppssenddelay.PpsSendDelay(
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
        util.ApplicationProperites.setProperties("PpsSendDelayGUI", gui);
        this.butnPrint.setEnabled(false);
        isViewer = true;
        this.getFieldsData();
        setScrollPaneGUI(new exgui2.ReportGenerate("PPS_NOT_YET_RCVD.rpt",
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
      sb.append("&prompt6="+hmFields.get("CNTRY"));
      sb.append("&prompt7="+hmFields.get("QTY_FLAG"));
      sb.append("&prompt8="+hmFields.get("CANADA_QUOTA_FLAG"));
      sb.append("&prompt9="+hmFields.get("DAYS"));
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
      hmFields.put("CNTRY", gui.dbJCBXCnty.getSelectedValue().equals("null")?"":gui.dbJCBXCnty.getSelectedValue());
      hmFields.put("QTY_FLAG", gui.rbExcOdr_Y.isSelected()?"Y":"N");
      hmFields.put("CANADA_QUOTA_FLAG", gui.rbExcCn_Y.isSelected()?"Y":"N");
      hmFields.put("DAYS", gui.rbRCVD_10.isSelected()?"10":"20");

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
