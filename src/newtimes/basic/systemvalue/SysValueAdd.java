package newtimes.basic.systemvalue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import newtimes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SysValueAdd extends JPanel {
  Frame1 frame;
  String titleName = "System Value Add";
  SysValueGUI gui = new SysValueGUI(titleName);

  public SysValueAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    gui.butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    gui.butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    gui.butnModify.setVisible(false);
    gui.butnDel.setVisible(false);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.add(gui, null);
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.systemvalue.SysValueQuery(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (gui.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("CENTER", gui.dbJCBXCen.getSelectedValue().toString());
        hm.put("IC_NAME", gui.txtIC.getText().trim().toUpperCase());
        hm.put("LOCAL_CURRENCY_NAME", gui.dbJCBXCrncy.getSelectedValue().toString());
        /*
        String exchange = gui.txtEx_1.getText().equals("") ? "0" : gui.txtEx_1.getText();
               exchange += gui.txtEx_2.getText().equals("") ? "" : ".";
               exchange += gui.txtEx_2.getText().equals("") ? ".0" : gui.txtEx_2.getText();
        String fha = gui.txtFHA_1.getText().equals("") ? "0" : gui.txtFHA_1.getText();
               fha += gui.txtFHA_2.getText().equals("") ? "" : ".";
               fha += gui.txtFHA_2.getText().equals("") ? ".0" : gui.txtFHA_2.getText();
        */
        hm.put("SHIP_CLOSE_B4", gui.dbShipCloseBefore.getSelectedValue());
        hm.put("EXCHANGE_RATE", gui.dbXchg.getSelectedValue());
        hm.put("FHA", gui.dbFHA.getSelectedValue());
        hm.put("CURRENT_YEAR",gui.dbCurrYear.getSelectedValue());
        hm.put("YEAR_RNG_BGN",gui.dbYearBgn.getSelectedValue());
        hm.put("YEAR_RNG_END",gui.dbYearEnd.getSelectedValue());
        hm.put("PLAN_DEL_BGN",gui.dbPlanDelBgn.getSelectedValue());
        hm.put("PLAN_DEL_END",gui.dbPlanDelEnd.getSelectedValue());
        hm.put("DELV_RNG_BGN",gui.dbDelvBgn.getSelectedValue());
        //System.out.println("text of gui.txtDelvRngBgn:"+gui.txtDelvRngBgn.getText());
        //System.out.println("value of gui.txtDelvRngBgn:"+gui.dbDelvBgn.getSelectedValue());
        hm.put("DELV_RNG_END",gui.dbDelvEnd.getSelectedValue());
        //TWD_XCHG_RATE, RMB_XCHG_RATE, HKD_XCHG_RATE
        hm.put("TWD_XCHG_RATE",gui.dbTwdChg.getSelectedValue());
        hm.put("RMB_XCHG_RATE",gui.dbRmbChg.getSelectedValue());
        hm.put("HKD_XCHG_RATE",gui.dbHkdChg.getSelectedValue());

        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.SYSTEM_VALUE_EJB.insertRecord(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.systemvalue.SysValueQuery(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }
}
