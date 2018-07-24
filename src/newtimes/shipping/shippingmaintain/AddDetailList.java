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

public class AddDetailList extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Shipping Detail Add";
  private AddDetailListGUI fieldsGUI = new AddDetailListGUI();
  private JTable jTable = fieldsGUI.listTableEditor.getJtable();
  private String usrType = null;
  static int SHIP_SC_PK = 0;
  static int STYLE_SEQ = 0;
  static int SHIP_PRICE_PK = 0;
  static int SHIP_STYLE_PK = 0;

  public AddDetailList(Frame1 _frame) {
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
//    exgui2.GotoTarget.setGoHistory(this);
    this.setPanelWithButtons();
    this.setScrollPaneGUI(fieldsGUI);
    this.setTitleName(titleName);
    this.set3Buttons();
    butnSC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnSC_actionPerformed(e);
      }
    });
    jTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        jTable_mouseReleased(e);
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

  void jTable_mouseReleased(MouseEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      fieldsGUI.listTableEditor.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      /*
      int yes_no = exgui2.InfoMessage.Yes_No_Option(frame,
          "If You Want to Edit Shipping Detail Press Yes Button, or Not Press No Button.");
      */
      //if (yes_no == 0) {
        int getRow = jTable.getSelectedRow();
        java.util.Vector vDetail = fieldsGUI.listTableEditor.getDisplayingRecords();
        database.datatype.Record recDetail = (database.datatype.Record)vDetail.get(getRow);

        System.out.println("recDetail is :"+recDetail.toString());
        hm.put("recDetail", recDetail);
        if (MasterEdit.SRN_NO != null) {
          hm.put("SHIP_NO", MasterEdit.SRN_NO);
        } else {
          String SRN_NO = util.ApplicationProperites.getProperties("SRN_NO").toString();
          hm.put("SHIP_NO", SRN_NO);
        }
        hm.put("prodHeadPk", recDetail.get("PROD_HEAD_PK"));
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = 0;
        isOk = exgui2.CONST.SHIP_DETAIL_EJB.insertShipSC(hm); //insert SHIP_SC table.
        if (isOk == -1 || isOk == -2) {
          exgui2.Stuff.insertMessage(frame, isOk, "Error at Insert SHIP_SC Table.");
        } else {
          SHIP_SC_PK = isOk;
          STYLE_SEQ = Integer.parseInt(recDetail.get("STY_SEQ").toString());
          java.util.HashMap hmShipSty = new java.util.HashMap();
          hmShipSty.put("SHIP_SC_PK", String.valueOf(SHIP_SC_PK));
          hmShipSty.put("STY_SEQ", String.valueOf(STYLE_SEQ));
          hmShipSty.put("BUY_COMM", recDetail.get("STY_BUY_COMM"));
          hmShipSty.put("MKR_DSCT_PER", recDetail.get("STY_MKR_DSCT_PER"));
          hmShipSty.put("MKR_DSCT_PC", recDetail.get("STY_MKR_DSCT_PC"));
          hmShipSty.put("MKR_DSCT_DZ", recDetail.get("STY_MKR_DSCT_DZ"));
          hmShipSty.put("MKR_DSCT_LUMP_SUM", recDetail.get("STY_MKR_DSCT_LUMP_SUM"));
          hmShipSty.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
          isOk = exgui2.CONST.SHIP_STYLE_EJB.insertRecord(hmShipSty); //insert SHIP_STYLE table
          if (isOk == -1 || isOk == -2) {
            exgui2.InfoMessage.warningMessage(frame, "Error at Insert SHIP_STYLE Table.");
          } else {
            SHIP_STYLE_PK = isOk;
            hm.put("SHIP_STYLE_PK", String.valueOf(isOk));
            Shipping_Const.EDITING_SHIPING_STYLE_PK=isOk;
            Shipping_Const.EDITING_STHIPING_STYLE_QDR_QTY=(String)recDetail.get("STY_QTY_DESC");
            hm.put("from", "AddDetailList");
            util.ApplicationProperites.setProperties("recDetail", hm);
            frame.showPanel(new newtimes.shipping.shippingmaintain.ShipDetailEdit(frame));
            /*
            java.util.Vector vShipPrx =
                exgui2.CONST.SHIP_DETAIL_EJB.insertShipPrice(SHIP_STYLE_PK, STYLE_SEQ); //insert SHIP_PRICE table

            Shipping_Const.EDITING_SHIPING_STYLE_PK=isOk;
            if (vShipPrx != null) {
              int shipPrx = Integer.parseInt(vShipPrx.get(0).toString());
              this.SHIP_PRICE_PK = shipPrx;

              if (shipPrx == -1 || shipPrx == -2) {
                exgui2.InfoMessage.warningMessage(frame, "Error at Insert SHIP_PRICE Table.");
              } else {
                hm.put("SHIP_STYLE_PK", String.valueOf(isOk));
                Shipping_Const.EDITING_SHIPING_STYLE_PK=isOk;
                hm.put("from", "AddDetailList");
                util.ApplicationProperites.setProperties("recDetail", hm);
                frame.showPanel(new newtimes.shipping.shippingmaintain.ShipDetailEdit(frame));
              }
            } else {
              exgui2.InfoMessage.warningMessage(frame, "Error at Insert SHIP_PRICE Table.");
            }
            */
      }
        }
      //}
    } catch (Exception eRow) {
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow, "error at get record." + hm.toString());
    } finally {
      fieldsGUI.listTableEditor.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
    util.ApplicationProperites.removeProperites("recDetail");
    util.ApplicationProperites.removeProperites("getData");
//    exgui2.GotoTarget.removeLast();
//    exgui2.GotoTarget.removeLast();
//    frame.showPanel(exgui2.GotoTarget.getLast());
    frame.showPanel(new newtimes.shipping.shippingmaintain.DetailAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
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
}
