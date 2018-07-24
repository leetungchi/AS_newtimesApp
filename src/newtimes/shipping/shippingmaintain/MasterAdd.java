package newtimes.shipping.shippingmaintain;

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

public class MasterAdd extends newtimes.shipping.ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Shipping Master Add";
  private MasterFieldsGUI fieldsGUI = new MasterFieldsGUI();

  public MasterAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    exgui2.GotoTarget.setGoHistory(this);
    this.setScrollPaneGUI(fieldsGUI);
    this.setTitleName(titleName);
    this.set3Buttons();
    fieldsGUI.isVisible_SrnNoAndExtra(false);
    butnIC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnIC_actionPerformed(e);
      }
    });
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
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnDelete.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnAddDetail.setEnabled(false);
    this.butnSC.setEnabled(false);
    this.setSystemDate();
  }

  public void butnIC_actionPerformed(ActionEvent e) {
    try {
      frame.showPanel(new newtimes.shipping.shippingmaintain.IC_Edit(frame));
    } catch (Exception iie) {
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to I/C.");
    }
  }

  public void butnSC_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try {
      frame.showPanel(new newtimes.shipping.shippingmaintain.SC_List(frame));
    } catch (Exception iie) {
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to S/C.");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void butnAddDetail_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try {
      frame.showPanel(new newtimes.shipping.shippingmaintain.DetailAdd(frame));
    } catch (Exception iie) {
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to Add-Detail.");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("SRN_NO");
    util.ApplicationProperites.removeProperites("v");
    frame.showPanel(new newtimes.shipping.shippingmaintain.MasterSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_New() {
    if (fieldsGUI.txtScNo.getText().trim().equals("")) {
      exgui2.InfoMessage.infoMessage(frame, "Please Input SC NO.");
    } else {
      if (fieldsGUI.checkFieldsData()) {
        java.util.HashMap hm = new java.util.HashMap();
        try {
          setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          hm = fieldsGUI.getDatas();
          hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
          java.util.HashMap hmIn = exgui2.CONST.SHIP_MAIN_EJB.insertRecord(hm);
          if (hmIn == null) {
            exgui2.InfoMessage.infoMessage(frame, "SC No. error.");
          } else {
            //System.out.println("#hmIn:" + hmIn.toString());
            int isOk = Integer.parseInt(hmIn.get("isOk").toString());
            if (exgui2.Stuff.insertMessage(frame, isOk)) {
              frame.showPanel(new newtimes.shipping.shippingmaintain.MasterEdit(
                  frame, hmIn.get("SHIP_NO").toString()));
            }
          }
        } catch (Exception eNew) {
          eNew.printStackTrace();
          util.ExceptionLog.exp2File(eNew,
              "error at insert data when pressed new record button.\n" +
              "hashMap datas:" + hm.toString());
        }
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  void setSystemDate () {
    try {
      fieldsGUI.txtYear.setText(exgui2.Stuff.System_Year.toString());
      fieldsGUI.txtMonth.setText(exgui2.Stuff.System_Month.toString());
      fieldsGUI.txtDay.setText(exgui2.Stuff.System_Day.toString());
      fieldsGUI.txtETA_Y.setText(exgui2.Stuff.System_Year.toString());
      fieldsGUI.txtETA_M.setText(exgui2.Stuff.System_Month.toString());
      fieldsGUI.txtETA_D.setText(exgui2.Stuff.System_Day.toString());
      fieldsGUI.txtETD_Y.setText(exgui2.Stuff.System_Year.toString());
      fieldsGUI.txtETD_M.setText(exgui2.Stuff.System_Month.toString());
      fieldsGUI.txtETD_D.setText(exgui2.Stuff.System_Day.toString());
      fieldsGUI.txtIC_Y.setText(exgui2.Stuff.System_Year.toString());
      fieldsGUI.txtIC_M.setText(exgui2.Stuff.System_Month.toString());
      fieldsGUI.txtIC_D.setText(exgui2.Stuff.System_Day.toString());
    } catch (Exception eDate) {
      eDate.printStackTrace();
      util.ExceptionLog.exp2File(eDate, "error at set System date to fields.");
    }
  }
}
