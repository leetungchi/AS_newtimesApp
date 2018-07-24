package newtimes.shipping.shippingmaintain;

import java.awt.*;
import java.awt.event.*;
import newtimes.*;
import newtimes.shipping.ScrollPaneGUI;

/**
 * <p>Title: </p>
 * <p>Description: This function moved into the MasterAdd and MasterEdit functions.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class IC_Edit extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Inspection Certificate";
  private IC_FieldsGUI icGUI = new IC_FieldsGUI();

  public IC_Edit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    exgui2.GotoTarget.setGoHistory(this);
    this.setPanelWithButtons();
    this.setScrollPaneGUI(icGUI);
    this.setTitleName(titleName);
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
  }

  public void do_Exit() {
    exgui2.GotoTarget.removeLast();
    frame.showPanel(exgui2.GotoTarget.getLast());
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }
}