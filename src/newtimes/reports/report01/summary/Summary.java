package newtimes.reports.report01.summary;

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

public class Summary extends ScrollPaneGUI {
  Frame1 frame;
  private SummaryGUI gui = null;
  private String titleName = "Summary Report";
  private boolean isViewer = false;
  private java.util.HashMap hmFields = new java.util.HashMap();
  static int x = 0;
  static int y = 0;
  private java.util.HashMap set =
      (java.util.HashMap)util.ApplicationProperites.getProperties("set");
  private DIV divDlg = new DIV(frame, "DIV", true);
  private FTY ftyDlg = new FTY(new JFrame(), "FTY", true);
  private QTA qtaDlg = new QTA(frame, "QTA", true);

  public Summary(Frame1 _frame) {
    frame = _frame;
    try {
      gui = new SummaryGUI();
      if (set != null)
        this.setData2Field();
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
    gui.butnQTA.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnQTA_actionPerformed(e);
      }
    });
    gui.butnDIV.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDIV_actionPerformed(e);
      }
    });
    gui.butnFTY.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnFTY_actionPerformed(e);
      }
    });
  }
  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    if (!isViewer) {
      util.ApplicationProperites.removeProperites("SummaryGUI");
      util.ApplicationProperites.removeProperites("set");
      frame.showPanel(new newtimes.reports.ReportMenu1(frame));
    } else {
      frame.showPanel(new newtimes.reports.report01.summary.Summary(frame));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      if (this.chkRowCloumn() && gui.check_txtYear() && gui.checkFieldsData()) {
        util.ApplicationProperites.setProperties("SummaryGUI", gui);
        this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.
            VERTICAL_SCROLLBAR_AS_NEEDED);
        this.butnPrint.setEnabled(false);
        isViewer = true;
        this.getFieldsData();
        setScrollPaneGUI(new exgui2.ReportGenerate("SUMMARY_ORDER.rpt",
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
      sb.append("&prompt2="+hmFields.get("FTY"));
      sb.append("&prompt3="+hmFields.get("DIV"));
      sb.append("&prompt4="+hmFields.get("SEASON"));
      sb.append("&prompt5="+hmFields.get("YEAR"));
      sb.append("&prompt6="+hmFields.get("DATE_FM"));
      sb.append("&prompt7="+hmFields.get("DATE_TO"));
      sb.append("&prompt8="+hmFields.get("CNTRY"));
      sb.append("&prompt9="+hmFields.get("QTA"));
      sb.append("&prompt10="+hmFields.get("TYPE"));
      sb.append("&prompt11="+hmFields.get("ROW"));
      sb.append("&prompt12="+hmFields.get("COLUMN"));
      sb.append("&prompt13="+hmFields.get("Col_String"));
      sb.append("&prompt14="+"12");
      sb.append("&prompt15="+hmFields.get("CONTENT"));

      //System.out.println("#sb:"+sb.toString());
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
      hmFields.put("QTA", gui.dbJCBXQTA.getSelectedValue().equals("null")?"":gui.dbJCBXQTA.getSelectedValue());
      hmFields.put("DATE_FM", gui.txtFm_Y.getText().equals("")?
                   "":gui.txtFm_Y.getText()+"/"+gui.txtFm_M.getText()+"/"+gui.txtFm_D.getText());
      hmFields.put("DATE_TO", gui.txtTo_Y.getText().equals("")?
                   "":gui.txtTo_Y.getText()+"/"+gui.txtTo_M.getText()+"/"+gui.txtTo_D.getText());

      // Report Type
      String type = null;
      if (gui.r_Plan.isSelected()) type = "PLAN"; //Plan
      if (gui.r_Order.isSelected()) type = "ORDER";//Order
      if (gui.r_Ship.isSelected()) type = "SHIP"; //Ship
      hmFields.put("TYPE", type);

      // Content
      String display = null;
      if (gui.chkBxQTY.isSelected()) display = "QTY";
      if (gui.chkBxAMT.isSelected()) display = "AMT";
      hmFields.put("CONTENT", display == null ? "ALL":display);

      // Row
      String row = null;
      JRadioButton[] rRow = {gui.rRow_QTA, gui.rRow_DIV, gui.rRow_FTY,
                             gui.rRow_SEA, gui.rRow_Year, gui.rRow_Date,
                             gui.rRow_Cntry};
      for (int i = 0 ; i < rRow.length ; i++) {
        if (rRow[i].isSelected())
          row = rRow[i].getActionCommand();
      }
      hmFields.put("ROW", row);

      // Column
      String col = null;
      JRadioButton[] rCol = {gui.rCol_QTA, gui.rCol_DIV, gui.rCol_FTY,
                             gui.rCol_SEA, gui.rCol_Year, gui.rCol_Date,
                             gui.rCol_Cntry};
      for (int j = 0 ; j < rCol.length ; j++) {
        if (rCol[j].isSelected())
          col = rCol[j].getActionCommand();
      }
      hmFields.put("COLUMN", col);

      // Column String
      String colStr = "";
      JTextArea[] txtArea = {gui.txtAreaQTA, gui.txtAreaDIV, gui.txtAreaFTY};
      JRadioButton[] rSel = {gui.r_QTA, gui.r_DIV, gui.r_FTY};
      for (int k = 0 ; k < 3 ; k++) {
        if (rCol[k].isSelected()) {
          if (rSel[k].isSelected()) {
            colStr = "";
          } else {
            colStr = txtArea[k].getText();
          }
        }
      }
      hmFields.put("Col_String", colStr);

      java.util.HashMap hmSetFields = new java.util.HashMap();
      hmSetFields.put("cen_name", gui.cmboCen.getSelectedItem());
      hmSetFields.put("dep_name", gui.cmboDep.getSelectedItem());
      hmSetFields.put("sea_name", gui.cmboSea.getSelectedItem());
      hmSetFields.put("date_fm_y", gui.txtFm_Y.getText());
      hmSetFields.put("date_fm_m", gui.txtFm_M.getText());
      hmSetFields.put("date_fm_d", gui.txtFm_D.getText());
      hmSetFields.put("date_to_y", gui.txtTo_Y.getText());
      hmSetFields.put("date_to_m", gui.txtTo_M.getText());
      hmSetFields.put("date_to_d", gui.txtTo_D.getText());
      hmSetFields.put("cntry_name", gui.cmboCntry.getSelectedItem());
      hmSetFields.put("fty_name", gui.popMaker.getText());
      hmSetFields.put("div_name", gui.cmboDiv.getSelectedItem());
      hmSetFields.put("qta", gui.cmboQTA.getSelectedItem());
      hmSetFields.put("year", gui.txtYear.getText());
      hmSetFields.put("type", type);
      hmSetFields.put("content", display == null ? "ALL":display);
      hmSetFields.put("row", row);
      hmSetFields.put("col", col);
      hmSetFields.put("colStr", colStr);
      util.ApplicationProperites.setProperties("set",hmSetFields);
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt get fields data.\n"+hmFields.toString());
    } finally {
      return hmFields;
    }
  }

  void butnQTA_actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if (cmd.equals("...")) {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      qtaDlg.show();

      //get QTA values
      if (qtaDlg.vQTAName != null) {
        try {
          if (!qtaDlg.setIsExit()) {
            StringBuffer sbQTA = new StringBuffer();
            for (int i = 0; i < qtaDlg.vQTAName.size(); i++) {
              sbQTA.append(qtaDlg.vQTAName.get(i));
              sbQTA.append(qtaDlg.vQTAName.size() - 1 == i ? "" : ",");
            }
            gui.txtAreaQTA.setText(sbQTA.toString());
          }
        } catch (Exception eQTA) {
          eQTA.printStackTrace();
          util.ExceptionLog.exp2File(eQTA, "error at get QTA values.");
        }
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnDIV_actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if (cmd.equals("...")) {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      divDlg.show();

      //get DIV values
      if (divDlg.vDIVName != null) {
        try {
          if (!divDlg.setIsExit()) {
            StringBuffer sbDIV = new StringBuffer();
            for (int i = 0; i < divDlg.vDIVName.size(); i++) {
              sbDIV.append(divDlg.vDIVName.get(i));
              sbDIV.append(divDlg.vDIVName.size() - 1 == i ? "" : ",");
            }
            gui.txtAreaDIV.setText(sbDIV.toString());
          }
        } catch (Exception eDIV) {
          eDIV.printStackTrace();
          util.ExceptionLog.exp2File(eDIV, "error at get DIV values.");
        }
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnFTY_actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if (cmd.equals("...")) {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      ftyDlg.show();

      //get FTY values
      if (ftyDlg.vFTYName != null) {
        try {
          if (!ftyDlg.setIsExit()) {
            StringBuffer sbFTY = new StringBuffer();
            for (int i = 0; i < ftyDlg.vFTYName.size(); i++) {
              sbFTY.append(ftyDlg.vFTYName.get(i));
              sbFTY.append(ftyDlg.vFTYName.size() - 1 == i ? "" : ",");
            }
            gui.txtAreaFTY.setText(sbFTY.toString());
          }
        } catch (Exception eDIV) {
          eDIV.printStackTrace();
          util.ExceptionLog.exp2File(eDIV, "error at get FTY values.");
        }
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setData2Field() {
    try {
      gui.cmboCen.setSelectedItem(set.get("cen_name"));
      gui.cmboDep.setSelectedItem(set.get("dep_name"));
      gui.cmboSea.setSelectedItem(set.get("sea_name"));
      gui.txtFm_Y.setText(set.get("date_fm_y").toString());
      gui.txtFm_M.setText(set.get("date_fm_m").toString());
      gui.txtFm_D.setText(set.get("date_fm_d").toString());
      gui.txtTo_Y.setText(set.get("date_to_y").toString());
      gui.txtTo_M.setText(set.get("date_to_m").toString());
      gui.txtTo_D.setText(set.get("date_to_d").toString());
      gui.cmboCntry.setSelectedItem(set.get("cntry_name"));
      gui.popMaker.setText(set.get("fty_name")==null?"":set.get("fty_name").toString());
      gui.txtYear.setText(set.get("year").toString());
      gui.cmboQTA.setSelectedItem(set.get("qta"));
      gui.cmboDiv.setSelectedItem(set.get("div_name"));

      // Report Type
      if (set.get("type").equals("PLAN")) gui.r_Plan.setSelected(true);
      if (set.get("type").equals("ORDER")) gui.r_Order.setSelected(true);
      if (set.get("type").equals("SHIP")) gui.r_Ship.setSelected(true);

      // Content
      if (set.get("content").equals("ALL")) {
        gui.chkBxQTY.setSelected(true);
        gui.chkBxAMT.setSelected(true);
      }
      if (set.get("content").equals("QTY")) gui.chkBxQTY.setSelected(true);
      if (set.get("content").equals("AMT")) gui.chkBxAMT.setSelected(true);

      // Row
      JRadioButton[] rRow = {gui.rRow_QTA, gui.rRow_DIV, gui.rRow_FTY,
                             gui.rRow_SEA, gui.rRow_Year, gui.rRow_Date,
                             gui.rRow_Cntry};
      for (int i = 0 ; i < rRow.length ; i++) {
        if (rRow[i].getActionCommand().equalsIgnoreCase(set.get("row").toString())) {
          rRow[i].setSelected(true);
          break;
        }
      }

      // COLUMN
      JRadioButton[] rCol = {gui.rCol_QTA, gui.rCol_DIV, gui.rCol_FTY,
                             gui.rCol_SEA, gui.rCol_Year, gui.rCol_Date,
                             gui.rCol_Cntry};
      JRadioButton[] r = {gui.r_Sel_QTA, gui.r_Sel_DIV, gui.r_Sel_FTY};
      JTextArea[] txtArea = {gui.txtAreaQTA, gui.txtAreaDIV, gui.txtAreaFTY};
      JRadioButton[] rSel = {gui.r_QTA, gui.r_DIV, gui.r_FTY};
      for (int i = 0 ; i < rRow.length ; i++) {
        if (rCol[i].getActionCommand().equalsIgnoreCase(set.get("col").toString())) {
          rCol[i].setSelected(true);
          break;
        }
      }

      for (int k = 0 ; k < 3 ; k++) {
        if (rCol[k].isSelected()) {
          if (!set.get("colStr").equals("")) {
            r[k].setSelected(true);
            txtArea[k].setText(set.get("colStr").toString());
          } else {
            rSel[k].setSelected(true);
          }
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  boolean chkRowCloumn() {
    boolean chk = true;
    try {
      JRadioButton[] rRow = {gui.rRow_QTA, gui.rRow_DIV, gui.rRow_FTY,
                             gui.rRow_SEA, gui.rRow_Year, gui.rRow_Date,
                             gui.rRow_Cntry};
      JRadioButton[] rCol = {gui.rCol_QTA, gui.rCol_DIV, gui.rCol_FTY,
                             gui.rCol_SEA, gui.rCol_Year, gui.rCol_Date,
                             gui.rCol_Cntry};
      JRadioButton[] r = {gui.r_Sel_QTA, gui.r_Sel_DIV, gui.r_Sel_FTY};
      JTextArea[] txtArea = {gui.txtAreaQTA, gui.txtAreaDIV, gui.txtAreaFTY};
      String row = null;
      String col = null;

      for (int i = 0; i < rRow.length; i++) {
        if (rRow[i].isSelected())
          row = rRow[i].getActionCommand();
        if (rCol[i].isSelected())
          col = rCol[i].getActionCommand();
      }
      if (row.equalsIgnoreCase(col)) {
        exgui2.InfoMessage.warningMessage(frame,
            "\"Row\" and \"Column\" are Must Different.");
        chk = false;
      } else {
        for (int j = 0; j < r.length; j++) {
          if (r[j].isSelected()) {
            switch (j) {
              case 0:
                if (qtaDlg.vQTAName == null || qtaDlg.vQTAName.isEmpty() ||
                    qtaDlg.vQTAName.size() > 12) {
                  exgui2.InfoMessage.warningMessage(frame,
                      "Select QTA Must between 1~12 Items.");
                  chk = false;
                } else {
                  chk = true;
                }
                break;
              case 1:
                if (divDlg.vDIVName == null && divDlg.vDIVName.isEmpty() &&
                    divDlg.vDIVName.size() > 12) {
                  exgui2.InfoMessage.warningMessage(frame,
                      "Select DIV Must between 1~12 Items.");
                  chk = false;
                } else {
                  chk = true;
                }
                break;
              case 2:
                if (ftyDlg.vFTYName == null && ftyDlg.vFTYName.isEmpty() &&
                    ftyDlg.vFTYName.size() > 12) {
                  exgui2.InfoMessage.warningMessage(frame,
                      "Select FTY Must between 1~12 Items.");
                  chk = false;
                } else {
                  chk = true;
                }
                break;
            }
          }
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return chk;
  }
}
