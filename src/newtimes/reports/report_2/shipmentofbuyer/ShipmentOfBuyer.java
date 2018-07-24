package newtimes.reports.report_2.shipmentofbuyer;

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

public class ShipmentOfBuyer extends ScrollPaneGUI {
  Frame1 frame;
  private ShipmentOfBuyerGUI gui = null;
  private String titleName = "Shipment of Buyer by Country / FTY";
  private boolean isViewer = false;
  private java.util.HashMap hmFields = new java.util.HashMap();

  public ShipmentOfBuyer(Frame1 _frame) {
    frame = _frame;
    try {
      if(util.ApplicationProperites.getProperties("ShipmentOfBuyerGUI")==null){
        gui = new ShipmentOfBuyerGUI();
      }else{
        gui=(ShipmentOfBuyerGUI)util.ApplicationProperites.getProperties("ShipmentOfBuyerGUI");
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
      util.ApplicationProperites.removeProperites("ShipmentOfBuyerGUI");
      frame.showPanel(new newtimes.reports.report_2.ReportMenu2(frame));
    } else {
      frame.showPanel(new newtimes.reports.report_2.shipmentofbuyer.ShipmentOfBuyer(
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
        util.ApplicationProperites.setProperties("ShipmentOfBuyerGUI", gui);
        this.butnPrint.setEnabled(false);
        isViewer = true;
        this.getFieldsData();
        setScrollPaneGUI(new exgui2.ReportGenerate("SHIPMENT_REPORT.RPT",
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
      sb.append("&prompt3="+hmFields.get("BUYER"));
      sb.append("&prompt4="+hmFields.get("BUYER_NAME"));
      sb.append("&prompt5="+hmFields.get("MEMO"));
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

      String depStr = "";
      if (gui.dbJListDep != null) {
        Object[] dep = gui.dbJListDep.getSelectedValues();
        if (dep.length == 1) {
          depStr += "'" + dep[0] + "'";
        } else if (dep.length > 1) {
          depStr += "'" + dep[0] + "'";
          for (int y = 1; y < dep.length; y++) {
            if (!dep[y].toString().trim().equals("")) {
              depStr += ",'" + dep[y] + "'";
            }
          }
        }
      }
      hmFields.put("DEP", depStr);

      hmFields.put("BUYER", gui.popBuyer.getSelectedBuyerValue()==null?"":gui.popBuyer.getSelectedBuyerValue().toString());
      hmFields.put("BUYER_NAME", gui.popBuyer.getText()==null?"":gui.popBuyer.getText().toString().trim());
      hmFields.put("YEAR", gui.txtYear.getText().trim());
      hmFields.put("MEMO", gui.txtAreaMemo.getText().trim());
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
