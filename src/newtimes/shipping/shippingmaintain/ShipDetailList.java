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

public class ShipDetailList extends ScrollPaneGUI {
  static Frame1 frame;
  private ShipDetailListGUI sdlGUI = new ShipDetailListGUI();
  private String titleName = "Ship Detail List";
  private JTable jTable = sdlGUI.listTableEditor.getJtable();
  private String usrType=null;
  static int SHIP_STYLE_PK = 0;

  public ShipDetailList(Frame1 _frame) {
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
    this.setScrollPaneGUI(sdlGUI);
    this.setTitleName(titleName);
    this.set3Buttons();
    butnAddDetail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAddDetail_actionPerformed(e);
      }
    });
    jTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        jTable_mouseReleased(e);
      }
    });
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
    this.butnSC.setEnabled(false);
    if (!usrType.equals("2") && !usrType.equals("6") && !usrType.equals("7")) {
      this.butnAddDetail.setEnabled(false);
    }
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

  void jTable_mouseReleased(MouseEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      sdlGUI.listTableEditor.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      int getRow = jTable.getSelectedRow();
      java.util.Vector vDetail = sdlGUI.listTableEditor.getDisplayingRecords();
      database.datatype.Record recDetail = (database.datatype.Record) vDetail.get(getRow);
      System.out.println("recDetail is :"+recDetail.toString());
      this.SHIP_STYLE_PK = Integer.parseInt(recDetail.get("SHIP_STYLE_PK").toString());
      Shipping_Const.EDITING_SHIPING_STYLE_PK= SHIP_STYLE_PK;
      Shipping_Const.EDITING_STHIPING_STYLE_QDR_QTY=(String)recDetail.get("STY_QTY_DESC");
      hm.put("recDetail", recDetail);
      hm.put("from", "ShipDetailList");
      util.ApplicationProperites.setProperties("recDetail", hm);
      QtyTableEditorFromSC qtyTableEditorSC = new QtyTableEditorFromSC();
      if (QtyDataFactoryAdapterFromSC.convRecords != null) {
        frame.showPanel(new newtimes.shipping.shippingmaintain.ShipDetailEditFromSC(
            frame));
      }
    } catch (Exception eRow) {
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow, "error at get record." + hm.toString());
    } finally {
      sdlGUI.listTableEditor.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("scDetail");
    frame.showPanel(new newtimes.shipping.shippingmaintain.SC_Edit(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }
}
