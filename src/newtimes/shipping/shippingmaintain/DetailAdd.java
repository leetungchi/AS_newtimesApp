package newtimes.shipping.shippingmaintain;

import java.awt.*;
import java.awt.event.*;
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

public class DetailAdd extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Shipping Detail Add";
  private DetailAddFieldsGUI gui = null;
  private String usrType = null;
  private int po = 0;
  private int style = 0;
  private String type = null;

  public DetailAdd(Frame1 _frame) {
    frame = _frame;
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if(util.ApplicationProperites.getProperties("DetailAddFieldsGUI")==null){
        gui = new DetailAddFieldsGUI();
      }else{
        gui=(DetailAddFieldsGUI)util.ApplicationProperites.getProperties("DetailAddFieldsGUI");
      }
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
//    exgui2.GotoTarget.setGoHistory(this);
    this.setPanelWithButtons();
    this.setScrollPaneGUI(gui);
    this.setTitleName(titleName);
    this.set3Buttons();
    butnSC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnSC_actionPerformed(e);
      }
    });
    gui.butnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtract_actionPerformed(e);
      }
    });
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
    this.butnAddDetail.setEnabled(false);
  }

  public void butnExtract_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.getDatas();
      util.ApplicationProperites.setProperties("DetailAddFieldsGUI",gui);
      if (this.type.equalsIgnoreCase("style")) {
        if (!gui.checkFieldsData()) {
//          exgui2.GotoTarget.removeLast();
          util.ApplicationProperites.removeProperites("DetailAddFieldsGUI");
          exgui2.InfoMessage.infoMessage(frame, "Please Input PO or Style.");
          frame.showPanel(new newtimes.shipping.shippingmaintain.DetailAdd(frame));
        } else {
          setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          frame.showPanel(new newtimes.shipping.shippingmaintain.AddDetailList(frame));
        }
      } else {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        frame.showPanel(new newtimes.shipping.shippingmaintain.AddDetailList(frame));
      }
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Edit.");
    } finally {
      this.type = null;
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void butnSC_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try {
      if (!usrType.equals("2") && !usrType.equals("6") && !usrType.equals("7")) {
       exgui2.InfoMessage.warningMessage(frame,"You Have No Authorizations.");
      } else {
        frame.showPanel(new newtimes.shipping.shippingmaintain.SC_List(frame));
      }
    } catch (Exception iie) {
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to S/C.");
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
//    exgui2.GotoTarget.removeLast();
    util.ApplicationProperites.removeProperites("DetailAddFieldsGUI");
//    frame.showPanel(exgui2.GotoTarget.getLast());
    frame.showPanel(new newtimes.shipping.shippingmaintain.MasterEdit(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  private void getDatas() {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      if (gui.rb_Prod.isSelected()) {
        this.type = "prod";
        hm.put("type", "prod");
        hm.put("PROD_CEN_CODE", gui.dbJCBXCen.getSelectedValue());
        hm.put("PROD_DEPTMENT",
               gui.dbJCBXDep==null?"null":gui.dbJCBXDep.getSelectedValue());
        hm.put("PROD_BUYER", gui.popBuyer.getSelectedBuyerValue());
        hm.put("PROD_MAKER", gui.popMaker.getSelectedMakerValue());
        hm.put("PROD_BUYER_DIVISION", gui.dbJCBXDiv.getSelectedValue());
        hm.put("PROD_SEASON", gui.dbJCBXSeason.getSelectedValue());
        hm.put("PROD_YEAR", gui.txtYear.getText().trim().equals("")?
               "null":gui.txtYear.getText().trim());
        hm.put("PROD_RANGE", gui.txtRange.getText().trim().equals("")?
               "null":gui.txtRange.getText().trim());
        for (int x = 1; x <= 5; x++)
          hm.put("scNo_" + x, gui.txtSC_NO[x-1].getText().trim().equals("")?
                 "null":gui.txtSC_NO[x-1].getText().trim());
      } else {
        this.type = "style";
        hm.put("type", "style");
        for (int y = 1; y <= 18; y++) {
          hm.put("po_" + y, gui.txtPO[y-1].getText().trim().equals("")?
                 "null":gui.txtPO[y-1].getText().trim());
          hm.put("sty_" + y, gui.txtStyle[y-1].getText().trim().equals("")?
                 "null":gui.txtStyle[y-1].getText().trim());
        }
      }
      util.ApplicationProperites.setProperties("getData", hm);
    } catch (Exception eGet) {
      eGet.printStackTrace();
      util.ExceptionLog.exp2File(eGet, "error at get fields data.\n"+
                                 "hm:"+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
}