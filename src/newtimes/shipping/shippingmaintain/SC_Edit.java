package newtimes.shipping.shippingmaintain;

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

public class SC_Edit extends ScrollPaneGUI {
  Frame1 frame;
  private SC_EditFieldsGUI scEditGUI = new SC_EditFieldsGUI();
  private String usrType=null;

  public SC_Edit(Frame1 _frame) {
    frame = _frame;
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(scEditGUI);
    this.setTitleName(SC_EditFieldsGUI.titleName);
    this.set3Buttons();
    butnAddDetail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAddDetail_actionPerformed(e);
      }
    });
    butnSC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnSC_actionPerformed(e);
      }
    });
    scEditGUI.butnListShipDetail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnListShipDetail_actionPerformed(e);
      }
    });
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnSC.setEnabled(false);
    if (!usrType.equals("2") && !usrType.equals("6") && !usrType.equals("7")) {
      this.butnAddDetail.setEnabled(false);
      this.butnEdit.setEnabled(false);
      this.butnDelete.setEnabled(false);
    }
  }

  public void butnListShipDetail_actionPerformed(ActionEvent e) {
    try {
      frame.showPanel(new newtimes.shipping.shippingmaintain.ShipDetailList(frame));
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to S/C.");
    }
  }

  public void butnSC_actionPerformed(ActionEvent e) {
    try {

    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to S/C.");
    }
  }

  public void butnAddDetail_actionPerformed(ActionEvent e) {
    try {
      frame.showPanel(new newtimes.shipping.shippingmaintain.DetailAdd(frame));
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Add-Detail.");
    }
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
    int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
    if (result == 0) {
      java.util.HashMap hm = new java.util.HashMap();
      boolean isOk = false;
      try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        hm = scEditGUI.getDatas();
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        isOk = exgui2.CONST.SC_LIST_EJB.updateRecords(hm);
      } catch (Exception eEd) {
        isOk = false;
        eEd.printStackTrace();
        util.ExceptionLog.exp2File(eEd,
            "exception while attempt to Confirm Edit" + "hm:" + hm.toString());
      } finally {
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.shipping.shippingmaintain.SC_List(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  public void do_Exit() {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.shippingmaintain.SC_List(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

}
