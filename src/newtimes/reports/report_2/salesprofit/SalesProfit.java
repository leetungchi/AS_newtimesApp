package newtimes.reports.report_2.salesprofit;

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

public class SalesProfit extends ScrollPaneGUI {
  Frame1 frame;
  private SalesProfitGUI gui = null;
  private String titleName = "Sales & Profit Report";
  private boolean isViewer = false;
  private java.util.HashMap hmFields = new java.util.HashMap();

  public SalesProfit(Frame1 _frame) {
    frame = _frame;
    try {
      if(util.ApplicationProperites.getProperties("SalesProfitGUI")==null){
        gui = new SalesProfitGUI();
      }else{
        gui=(SalesProfitGUI)util.ApplicationProperites.getProperties("SalesProfitGUI");
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
      util.ApplicationProperites.removeProperites("SalesProfitGUI");
      frame.showPanel(new newtimes.reports.report_2.ReportMenu2(frame));
    } else {
      frame.showPanel(new newtimes.reports.report_2.salesprofit.SalesProfit(frame));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    if (this.checkFieldsData()) {
      try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        util.ApplicationProperites.setProperties("SalesProfitGUI",gui);
        this.butnPrint.setEnabled(false);
        isViewer = true;
        this.getFieldsData();
        switch (Integer.parseInt(hmFields.get("ORDER_BY").toString())) {
          case 1 :
            setScrollPaneGUI(new exgui2.ReportGenerate("PROFIT.rpt", this.setReportAgument()));
            break;
          case 2 :
            setScrollPaneGUI(new exgui2.ReportGenerate("PROFIT_DEPT.rpt", this.setReportAgument()));
            break;
          case 3 :
            setScrollPaneGUI(new exgui2.ReportGenerate("PROFIT_COUNTRY.rpt", this.setReportAgument()));
            break;
        }

      } catch (Exception eNot) {
        eNot.printStackTrace();
        util.ExceptionLog.exp2File(eNot,
                                   "error at attempt pressed Print button.");
      } finally {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  private String setReportAgument() {
    try {

      hmFields = util.MiscFunc.URLEncode(hmFields);
      StringBuffer sb = new StringBuffer();
      sb.append("&prompt0="+hmFields.get("CEN"));
      sb.append("&prompt1="+hmFields.get("DEP"));
      sb.append("&prompt2=");
      sb.append(hmFields.get("Y2M_FM")==null?"":hmFields.get("Y2M_FM"));
      sb.append("&prompt3=");
      sb.append(hmFields.get("Y2M_TO")==null?"":hmFields.get("Y2M_TO"));
      sb.append("&prompt4=");
      sb.append(hmFields.get("M_FM")==null?"":hmFields.get("M_FM"));
      sb.append("&prompt5=");
      sb.append(hmFields.get("M_TO")==null?"":hmFields.get("M_TO"));
      sb.append("&prompt6="+hmFields.get("MANAGER"));
      sb.append("&prompt7="+hmFields.get("BUYER"));
      sb.append("&prompt8="+hmFields.get("FTY"));
      sb.append("&prompt9="+hmFields.get("MEMO"));
      sb.append("&prompt10="+hmFields.get("ORDER_BY"));
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
        } else {
          depStr += "'" + dep[0] + "'";
          for (int y = 1; y < dep.length; y++) {
            if (!dep[y].toString().trim().equals("")) {
              depStr += ",'" + dep[y] + "'";
            }
          }
        }
      }
      hmFields.put("DEP", depStr);

      hmFields.put("MANAGER", gui.dbJCBXMag.getSelectedValue().equals("null")?"":gui.dbJCBXMag.getSelectedValue());
      hmFields.put("FTY", gui.popMaker.getSelectedMakerValue()==null?"":gui.popMaker.getSelectedMakerValue());
      hmFields.put("BUYER", gui.popBuyer.getSelectedMakerValue()==null?"":gui.popBuyer.getSelectedMakerValue());

      if (!gui.txtY2M_FM_Y.getText().trim().equals("")) {
        hmFields.put("Y2M_FM", gui.txtY2M_FM_Y.getText()+"/"+gui.txtY2M_FM_M.getText());
        hmFields.put("Y2M_TO", gui.txtY2M_TO_Y.getText()+"/"+gui.txtY2M_TO_M.getText());
      } else {
        hmFields.put("Y2M_FM", "");
        hmFields.put("Y2M_TO", "");
      }

      if (!gui.txtM_FM_Y.getText().trim().equals("")) {
        hmFields.put("M_FM", gui.txtM_FM_Y.getText()+"/"+gui.txtM_FM_M.getText());
        hmFields.put("M_TO", gui.txtM_TO_Y.getText()+"/"+gui.txtM_TO_M.getText());
      } else {
        hmFields.put("M_FM", "");
        hmFields.put("M_TO", "");
      }

      hmFields.put("MEMO", gui.txtAreaMemo.getText().trim());

      if (gui.rb_BC.isSelected()) {
        hmFields.put("ORDER_BY", "1"); // order by buyer country
      }
      if (gui.rb_DC.isSelected()) {
        hmFields.put("ORDER_BY", "2"); // order by department country
      }
      if (gui.rb_C.isSelected()) {
        hmFields.put("ORDER_BY", "3"); // order by country
      }
      System.out.println("#hmFields:"+hmFields.toString());
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt get fields data.\n"+hmFields.toString());
    } finally {
      return hmFields;
    }
  }

  boolean checkFieldsData() {
    boolean y2mFmNull = exgui2.Stuff.checkNull(frame, gui.txtY2M_FM_Y.getText(),
                                               "Year-to-Month can't be empty.");
    boolean y2mToNull = exgui2.Stuff.checkNull(frame, gui.txtY2M_TO_Y.getText(),
                                               "Year-to-Month can't be empty.");
    boolean mFmNull = exgui2.Stuff.checkNull(frame, gui.txtM_FM_M.getText(),
                                               "This-Month can't be empty.");
    boolean mToNull = exgui2.Stuff.checkNull(frame, gui.txtY2M_TO_Y.getText(),
                                               "This-Month can't be empty.");
    if (y2mFmNull && y2mToNull && mFmNull && mToNull) {
      return true;
    } else {
      return false;
    }
  }

}
