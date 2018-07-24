package newtimes.reports.report01.quotacontrol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newtimes.*;
import newtimes.shipping.ScrollPaneGUI;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QuotaCtrl_SF extends ScrollPaneGUI {
  Frame1 frame;
  private QuotaQueryGUI queryGui = new QuotaQueryGUI();
  private QuotaAddGUI addGui = new QuotaAddGUI();
  private QuotaTableEditor quotaTbl = null;
  private String actionButn = null;
  private boolean leave = false;
  static java.util.HashMap hm = new java.util.HashMap();

  public QuotaCtrl_SF(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanel(queryGui,  new JPanel());
    this.jScrollPane_Bottom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.setDividerLocation(0.3);
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
    queryGui.do_Add.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_Add_actionPerformed(e);
      }
    });
  }

  public void do_Copy() {
  }

  public void do_Delete() {
    try {
      quotaTbl.doDelete();
    } catch(Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, "error at attempt pressed Delete button.");
    }
  }

  public void do_Edit() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      if (actionButn.equalsIgnoreCase("add")) {
        int isOk = exgui2.CONST.QTA_EMBARGO_EJB.inserRecord(this.getFieldsData());
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.reports.report01.quotacontrol.QuotaCtrl_SF(frame));
      } else {
        quotaTbl.doUpdate();
      }
    } catch(Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, "error at attempt pressed Confirm Edit button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_Exit() {
    if (leave) {
      frame.showPanel(new newtimes.reports.report01.quotacontrol.QuotaCtrl_SF(frame));
    } else {
      frame.showPanel(new newtimes.reports.ReportMenu1(frame));
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
      actionButn = "extract";
      leave = true;

      hm.put("AREA", queryGui.cmboArea.getSelectedItem().equals("")?"null":queryGui.cmboArea.getSelectedItem());
      hm.put("CAT", queryGui.dbJCBXCat==null?"null":queryGui.dbJCBXCat.getSelectedValue());
      hm.put("CNTY", queryGui.dbJCBXCnty==null?"null":queryGui.dbJCBXCnty.getSelectedValue());

      this.butnEdit.setEnabled(true);
      this.butnDelete.setEnabled(true);
      this.jScrollPane_Bottom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      quotaTbl = new QuotaTableEditor();
      quotaTbl.setPreferredSize(new java.awt.Dimension(300,270));
      this.setLowerPanel(quotaTbl);
    } catch(Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, "error at attempt pressed Extract button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void do_Add_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      actionButn = "add";
      leave = true;
      this.butnEdit.setEnabled(true);
      this.isVisable(false);
      this.setLowerPanel(addGui);
    } catch (Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, "error at attempt pressed Extract button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void isVisable(boolean b) {
    if (b) {
      queryGui.cmboArea.setEnabled(true);
      queryGui.cmboCat.setEnabled(true);
      queryGui.cmboCnty.setEnabled(true);
      queryGui.do_Add.setEnabled(true);
      queryGui.do_Extract.setEnabled(true);
    } else {
      queryGui.cmboArea.setEnabled(false);
      queryGui.cmboCat.setEnabled(false);
      queryGui.cmboCnty.setEnabled(false);
      queryGui.do_Add.setEnabled(false);
      queryGui.do_Extract.setEnabled(false);
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      java.util.HashMap hmFields = new java.util.HashMap();
      hmFields.put("QTEM_CAT", addGui.dbJCBXCat.getSelectedValue());
      hmFields.put("QTEM_AREA", addGui.cmboArea.getSelectedItem());
      hmFields.put("QTEM_CNTY_NAME", addGui.dbJCBXCnty.getSelectedValue());
      hmFields.put("QTEM_PERCENT",
                   addGui.txtPercent.getText().trim().equals("") ? "0" :
                   addGui.txtPercent.getText().trim() + "." +
                   addGui.txtPercentDot.getText().trim());
      hmFields.put("create_user",
                   util.PublicVariable.USER_RECORD.get("USR_CODE"));
      return hmFields;
    } catch (Exception eG) {
      eG.printStackTrace();
      return null;
    }
  }
}
