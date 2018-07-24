package newtimes.reports.report01.quotaalert;

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

public class QuotaAlert extends ScrollPaneGUI {
  Frame1 frame;
  private QuotaAlertGUI gui = null;
  private String titleName = "Quota Embargo Alert Report";
  private boolean isViewer = false;
  private boolean isValid = false;
  private java.util.HashMap hmFields = new java.util.HashMap();

  public QuotaAlert(Frame1 _frame) {
    frame = _frame;
    try {
      if(util.ApplicationProperites.getProperties("QuotaAlertGUI")==null){
        gui = new QuotaAlertGUI();
      }else{
        gui=(QuotaAlertGUI)util.ApplicationProperites.getProperties("QuotaAlertGUI");
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
      util.ApplicationProperites.removeProperites("QuotaAlertGUI");
      frame.showPanel(new newtimes.reports.ReportMenu1(frame));
    } else {
      frame.showPanel(new newtimes.reports.report01.quotaalert.QuotaAlert(
          frame));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    try {
      if(check_tfOver()){
        if(check_txtYear()){
          setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          util.ApplicationProperites.setProperties("QuotaAlertGUI", gui);
          this.butnPrint.setEnabled(false);
          isViewer = true;
          this.getFieldsData();
          setScrollPaneGUI(new exgui2.ReportGenerate("QUOTA_EMBARGO.rpt",
              this.setReportAgument()));
        }
      }
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
                                 "error at attempt pressed Print button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  private boolean check_tfOver(){
    if (!gui.tfOver.getText().trim().equals("")) {
      if (exgui.verification.VerifyLib.isFloat(gui.tfOver,
                                               "% Over field must be numeric!") == true) {
        return true;
      } else {
        gui.tfOver.grabFocus();
        return false;
      }
    } else {
      return true;
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

  private String setReportAgument() {
    try {

      hmFields = util.MiscFunc.URLEncode(hmFields);
      StringBuffer sb = new StringBuffer();
      sb.append("&prompt0="+hmFields.get("CEN"));
      sb.append("&prompt1="+hmFields.get("YEAR"));
      sb.append("&prompt2="+hmFields.get("COUNTRY"));
      sb.append("&prompt3="+hmFields.get("QTA_CAT"));
      sb.append("&prompt4="+hmFields.get("QTA_AREA"));
      sb.append("&prompt5="+hmFields.get("QTA_PERCENT"));
      sb.append("&prompt6="+hmFields.get("BUYER"));
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      hmFields.put("CEN", gui.dbJCBXCen.getSelectedValue().equals("null")?"":gui.dbJCBXCen.getSelectedValue());
      hmFields.put("BUYER", gui.popBuyer.getSelectedBuyerValue()==null?"":gui.popBuyer.getSelectedBuyerValue().toString());
      hmFields.put("YEAR", gui.txtYear.getText().trim().equals("")?"":gui.txtYear.getText().trim());
      hmFields.put("QTA_PERCENT", gui.tfOver.getText().trim().equals("")?"":gui.tfOver.getText().trim());
      hmFields.put("QTA_CAT", gui.dbJCBXQCat.getSelectedValue().equals("null")?"":gui.dbJCBXQCat.getSelectedValue());
      hmFields.put("QTA_AREA",gui.cmboQArea.getSelectedItem().toString());
      hmFields.put("COUNTRY", gui.dbJCBXCountry.getSelectedValue().equals("null")?"":gui.dbJCBXCountry.getSelectedValue());
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt get fields data.\n"+hmFields.toString());
    } finally {
      return hmFields;
    }
  }
}
