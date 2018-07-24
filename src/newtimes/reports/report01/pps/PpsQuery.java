package newtimes.reports.report01.pps;

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

public class PpsQuery extends ScrollPaneGUI {
  Frame1 frame;
  static String titleName = "PPS Close";
  private PpsQueryGUI queryGui = null;
  static java.util.HashMap hmFields = new java.util.HashMap();
  boolean goQuery = false;
  static String styPpsClose = null;

  public PpsQuery(Frame1 _frame) {
    frame = _frame;
    try {
      queryGui = new PpsQueryGUI();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(queryGui);
    this.setTitleName(titleName);

    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);

    queryGui.do_Extract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_Extract_actionPerformed(e);
      }
    });

    queryGui.do_Recover.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_Recover_actionPerformed(e);
      }
    });
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
    try {
      int result = exgui2.InfoMessage.Yes_No_Option(new JFrame(),"Modify ?");
      if(result == 0){
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (this.styPpsClose.equalsIgnoreCase("Close")) {
          PpsListGUI.vStySeq.add(0, "Y");
        } else {
          PpsListGUI.vStySeq.add(0, "N");
        }
        PpsListGUI.vStySeq.add(1, PpsListGUI.USR_NAME);
        if (PpsListGUI.vStySeq.size() > 1) {
          boolean isOk = exgui2.CONST.PPS_EJB.updatePpsClose(PpsListGUI.vStySeq);
          if (isOk) {
            exgui2.InfoMessage.infoMessage(new JFrame(), "Modify Succeed.");
          } else {
            exgui2.InfoMessage.warningMessage(new JFrame(), "Modify Failed.");
          }
        } else {
          exgui2.InfoMessage.infoMessage(new JFrame(), "No Any Records Selected.");
        }
        PpsListGUI.vStySeq.removeAllElements();
        PpsListGUI.vPool.removeAllElements();
        PpsListGUI.vec.removeAllElements();
        PpsListGUI.tableEditor.reload();
      }
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt pressed Confirm Edit button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_Exit() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      if (this.goQuery) {
        frame.showPanel(new newtimes.reports.report01.pps.PpsQuery(frame));
      } else {
        frame.showPanel(new newtimes.reports.ReportMenu1(frame));
        util.ApplicationProperites.removeProperites("PpsQueryGUI");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  void do_Extract_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("PpsQueryGUI",queryGui);
      this.setJTableDatas("extract");
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Extract.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void do_Recover_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("PpsQueryGUI",queryGui);
      this.setJTableDatas("recover");
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Recover.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      hmFields.put("CEN", queryGui.dbJCBXCen==null?"null":queryGui.dbJCBXCen.getSelectedValue());
      hmFields.put("DEP", queryGui.dbJCBXDep==null?"null":queryGui.dbJCBXDep.getSelectedValue());
      hmFields.put("CNTY", queryGui.dbJCBXCnty==null?"null":queryGui.dbJCBXCnty.getSelectedValue());
      hmFields.put("DIV", queryGui.dbJCBXDiv==null?"null":queryGui.dbJCBXDiv.getSelectedValue());
      hmFields.put("SEASON", queryGui.dbJCBXSeason==null?"null":queryGui.dbJCBXSeason.getSelectedValue());
      hmFields.put("FTY", queryGui.popMaker.getSelectedMakerValue());
      hmFields.put("YEAR", queryGui.txtYear.getText().trim().equals("")?"null":queryGui.txtYear.getText().trim());
      hmFields.put("INCLUDE_QTY", queryGui.rb_Y.isSelected() ? "null" : "N");
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt get fields data.\n"+hmFields.toString());
    } finally {
      return hmFields;
    }
  }

  void setJTableDatas(String butnAction) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.getFieldsData();
      if (butnAction.equalsIgnoreCase("extract")) {
        styPpsClose = "Close";
        hmFields.put("STY_PPS_CLOSE", "N");
      } else {
        styPpsClose = "Un-Close";
        hmFields.put("STY_PPS_CLOSE", "Y");
      }
      this.goQuery = true;
      PpsListGUI.vStySeq.removeAllElements();
      PpsListGUI.vPool.removeAllElements();
      PpsListGUI.vec.removeAllElements();
      PpsTableEditor listTableEditor = new PpsTableEditor();
      PpsListGUI listGUI = new PpsListGUI(listTableEditor);
      this.setScrollPaneGUI(listGUI);
      this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      this.butnEdit.setEnabled(true);
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Edit.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
}