package newtimes.shipping.prealertdailyreport;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newtimes.shipping.ScrollPaneGUI;
import newtimes.*;
import exgui2.CONST;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PreAlertDailyReport extends ScrollPaneGUI {
  Frame1 frame;
  boolean _isCenSelected = false;
  //private PreAlertDailyGUI gui = new PreAlertDailyGUI();
  private PreAlertDailyGUI gui = null;
  private String titleName = "Pre-Alert Daily Report";
  private exgui.DataBindJList dbJListDep = null;
  private exgui.DataBindJList dbJListCen = null;
  private exgui.DataBindJCombobox dbJCBXDiv = null;
  private exgui.DataBindJCombobox dbJCBXSeason = null;
  private exgui.DataBindJCombobox dbJCBXCnty = null;
  private String usrType = null;
  private String usrCenCodeDf = null;
  private boolean isViewer = false;
  private java.util.HashMap hmFields = new java.util.HashMap();

  public PreAlertDailyReport(Frame1 _frame) {
    frame = _frame;
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      if(util.ApplicationProperites.getProperties("PreAlertDailyGUI")==null){
        gui = new PreAlertDailyGUI();
      }else{
        gui=(PreAlertDailyGUI)util.ApplicationProperites.getProperties("PreAlertDailyGUI");
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
    this.butnCopy.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
//    if(util.ApplicationProperites.getProperties("PreAlertDailyGUI")==null){
      this.setCmboData();
//    }
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    if (!isViewer) {
      util.ApplicationProperites.removeProperites("PreAlertDailyGUI");
      frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
    } else {
      frame.showPanel(new newtimes.shipping.prealertdailyreport.PreAlertDailyReport(frame));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("PreAlertDailyGUI",gui);
      this.butnPrint.setEnabled(false);
      isViewer = true;
      this.getFieldsData();
      if (gui.rb_OptionNone.isSelected()) {
        this.setScrollPaneGUI(new exgui2.ReportGenerate("0606-SCR004.rpt",
            this.setReportAgument()));
      }
      if (gui.rb_OptionQTY.isSelected()) {
        this.setScrollPaneGUI(new exgui2.ReportGenerate("0606-SCR005.rpt",
            this.setReportAgument()));
      }
      if (gui.rb_OptionDetailQTY.isSelected()) {
        this.setScrollPaneGUI(new exgui2.ReportGenerate("0606-SCR006.rpt",
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
      StringBuffer sb = new StringBuffer();
      sb.append("&prompt0="+hmFields.get("SRN_NO_FM"));
      sb.append("&prompt1="+hmFields.get("SRN_NO_FM"));
      sb.append("&prompt2="+hmFields.get("CEN"));
      sb.append("&prompt3="+hmFields.get("DEP"));
      sb.append("&prompt4="+hmFields.get("FTY"));
      sb.append("&prompt5="+hmFields.get("BUYER"));
      sb.append("&prompt6="+hmFields.get("DIV"));
      sb.append("&prompt7="+hmFields.get("SEASON"));
      sb.append("&prompt8="+hmFields.get("YEAR"));
      sb.append("&prompt9="+hmFields.get("CNTY"));
      sb.append("&prompt10=");
      sb.append(hmFields.get("ETD_FM")==null?"":hmFields.get("ETD_FM"));
      sb.append("&prompt11=");
      sb.append(hmFields.get("ETD_TO")==null?"":hmFields.get("ETD_TO"));
      sb.append("&prompt12="+hmFields.get("PO"));
      sb.append("&prompt13="+hmFields.get("RANGE"));
      sb.append("&prompt14="+hmFields.get("SC_NO"));
      sb.append("&prompt15="+hmFields.get("STYLE"));
      sb.append("&prompt16="+hmFields.get("ORDER_BY"));
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataDep = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;
    java.util.Vector vDataCnty = null;

    try {
      vDataCen = CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJListCen = new exgui.DataBindJList(gui.listCen, vDataCen, "CEN_NAME",
                                           "CEN_CODE", recCen.get("CEN_CODE"));
      vDataSeason = CONST.BASIC_MAIN_EJB.getSeasonAll("SEA_NAME", "SEA_NAME");
      database.datatype.Record recSeason = (database.datatype.Record) vDataSeason.get(0);
      dbJCBXSeason = new exgui.DataBindJCombobox(
          gui.cmboSea, vDataSeason, "SEA_NAME", "SEA_NAME", recSeason.get("SEA_NAME"),"","null");
      vDataDiv = CONST.BASIC_MAIN_EJB.getDivisionAll("DIV_CODE,DIV_NAME", "DIV_NAME");
      database.datatype.Record recDiv = (database.datatype.Record) vDataDiv.get(0);
      dbJCBXDiv = new exgui.DataBindJCombobox(
          gui.cmboDiv, vDataDiv, "DIV_NAME", "DIV_CODE", recDiv.get("DIV_CODE"),"","null");
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(gui.cmboCNTY, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"),"","null");
      gui.cmboSea.setSelectedIndex(0);
      gui.cmboDiv.setSelectedIndex(0);
      gui.cmboCNTY.setSelectedIndex(0);

      if (usrType.equals("2") || usrType.equals("6") || usrType.equals("7")) {
        this._isCenSelected = true;
        vDataDep = CONST.BASIC_BASE_EJB.getDepartmentAll("DEP_CODE,DEP_NAME", "DEP_NAME");
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJListDep = new exgui.DataBindJList(gui.listDep, vDataDep, "DEP_NAME",
                                             "DEP_CODE", recDep.get("DEP_CODE"));
      } else {
        gui.listCen.setEnabled(false);
        gui.listCen.setSelectedValue(util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString(), true);
        this._isCenSelected = false;
        this.setDepItem("DEP_CEN_CODE = '"+util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString()+"'");
      }
    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at Department JComboBox.");
    }
  }

  void setDepItem(String whereClause) {
    java.util.Vector vDataDep = null;
    try {
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (vDataDep.size() > 0) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJListDep = new exgui.DataBindJList(gui.listDep, vDataDep, "DEP_NAME",
                                             "DEP_CODE", recDep.get("DEP_CODE"));
      } else {
        gui.listDep.removeAll();
      }
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD, "error at set Dep. items.\n"+"vector:"+vDataDep.toString());
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      hmFields.put("SRN_NO_FM", gui.txtSrnFm.getText().trim());
      hmFields.put("SRN_NO_TO", gui.txtSrnTo.getText().trim());

      Object[] cen = dbJListCen.getSelectedValues();
      Object[] dep = dbJListDep.getSelectedValues();
      String cenStr = "";
      String depStr = "";
      if (cen.length == 1) {
        cenStr += "'"+cen[0]+"'";
      } else {
        cenStr += "'"+cen[0]+"'";
        for (int x = 1; x < cen.length; x++) {
          if (!cen[x].toString().trim().equals("")) {
            cenStr += ",'" + cen[x] + "'";
          }
        }
      }
      if (dep.length == 1) {
        depStr += "'"+dep[0]+"'";
      } else {
        depStr += "'"+dep[0]+"'";
        for (int y = 1; y < dep.length; y++) {
          if (!dep[y].toString().trim().equals("")) {
            depStr += ",'" + dep[y] + "'";
          }
        }
      }
      hmFields.put("CEN", cenStr);
      hmFields.put("DEP", depStr);

      hmFields.put("CNTY", dbJCBXCnty.getSelectedValue().equals("null")?"":dbJCBXCnty.getSelectedValue());
      hmFields.put("DIV", dbJCBXDiv.getSelectedValue().equals("null")?"":dbJCBXDiv.getSelectedValue());
      hmFields.put("SEASON", dbJCBXSeason.getSelectedValue().equals("null")?"":dbJCBXSeason.getSelectedValue());
      hmFields.put("FTY", gui.popMaker.getSelectedMakerValue()==null?"":gui.popMaker.getSelectedMakerValue());
      hmFields.put("BUYER", gui.popBuyer.getSelectedMakerValue()==null?"":gui.popBuyer.getSelectedMakerValue());
      hmFields.put("YEAR", gui.txtYear.getText().trim());
      hmFields.put("RANGE", gui.txtRange.getText().trim());
      hmFields.put("SC_NO", gui.txtScNo.getText().trim());
      if (!gui.txtEtdFm_Y.getText().trim().equals("")) {
        hmFields.put("ETD_FM", gui.txtEtdFm_Y.getText()+"/"+gui.txtEtdFm_M.getText()+"/"+gui.txtEtdFm_D.getText());
        hmFields.put("ETD_TO", gui.txtEtdTo_Y.getText()+"/"+gui.txtEtdTo_M.getText()+"/"+gui.txtEtdTo_D.getText());
      } else {
        hmFields.put("ETD_FM", "");
        hmFields.put("ETD_TO", "");
      }

      String po = "'0'";
      String style = "'0'";
      for (int i = 0; i < gui.txtPO.length; i++) {
        if (!gui.txtPO[i].getText().trim().equals("")) {
          po += ",'"+gui.txtPO[i].getText().trim()+"'";
        }
        if (!gui.txtStyle[i].getText().trim().equals("")) {
          style += ",'"+gui.txtStyle[i].getText().trim()+"'";
        }
      }
      hmFields.put("PO", po.equals("'0'")?"":po);
      hmFields.put("STYLE", style.equals("'0'")?"":style);
      if (gui.rb_Order1.isSelected()) {
        hmFields.put("ORDER_BY", "1");
      } else {
        hmFields.put("ORDER_BY", "2");
      }
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      return hmFields;
    }
  }

}