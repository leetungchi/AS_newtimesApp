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

public class ShipDetailEditFromSC extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Shipping Detail Edit";
  private String usrType = null;
  java.util.HashMap hm = new java.util.HashMap();
  java.util.HashMap hmFrom =
      (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  database.datatype.Record recFrom = null;
  static boolean isShipQTY = false;
  static int SHIP_STYLE_PK = 0;
  static String STYLE_ORDER_QTY = null;
  static String SHIP_QTY = null;
  private ShipDetailEditGUIFromSC gui = new ShipDetailEditGUIFromSC();

  public ShipDetailEditFromSC(Frame1 _frame) {
    frame = _frame;
    try {
      hm = (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
//    exgui2.GotoTarget.setGoHistory(this);
    butnSC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnSC_actionPerformed(e);
      }
    });
    butnAddDetail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAddDetail_actionPerformed(e);
      }
    });
    gui.butn_QTY_New.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_QTY_New_actionPerformed(e);
      }
    });
    gui.butn_QTY_Edit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_QTY_Edit_actionPerformed(e);
      }
    });
    gui.butn_QTY_Delete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_QTY_Delete_actionPerformed(e);
      }
    });
    this.setPanelWithButtons();
    this.setScrollPaneGUI(gui);
    this.setTitleName(titleName);
    this.set3Buttons();
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnDelete.setEnabled(true);
    database.datatype.Record rec = (database.datatype.Record)hm.get("recDetail");
    SHIP_STYLE_PK = Integer.parseInt(rec.get("SHIP_STYLE_PK").toString());
    if (!usrType.equals("2") && !usrType.equals("6") && !usrType.equals("7")) {
      this.butnAddDetail.setEnabled(false);
      this.butnEdit.setEnabled(false);
      this.butnDelete.setEnabled(false);
    }
    this.setData2Fields();
    if (!usrType.equals("2")) {
      gui.txtBuy.setEditable(false);
      gui.txtBuy.setEnabled(false);
      gui.txtBuy_Dot.setEditable(false);
      gui.txtBuy_Dot.setEnabled(false);
      gui.txtMDPc.setEditable(false);
      gui.txtMDPc.setEnabled(false);
      gui.txtMDPc_Dot.setEditable(false);
      gui.txtMDPc_Dot.setEnabled(false);
      gui.txtMDLS.setEditable(false);
      gui.txtMDLS.setEnabled(false);
      gui.txtMDLS_Dot.setEditable(false);
      gui.txtMDLS_Dot.setEnabled(false);
      gui.txtMDPer.setEditable(false);
      gui.txtMDPer.setEnabled(false);
      gui.txtMDPer_Dot.setEditable(false);
      gui.txtMDPer_Dot.setEnabled(false);
      gui.txtMDD.setEditable(false);
      gui.txtMDD.setEnabled(false);
      gui.txtMDD_Dot.setEditable(false);
      gui.txtMDD_Dot.setEnabled(false);
    }
  }

  public void butnSC_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try {
      this.isShipQTY = false;
      frame.showPanel(new newtimes.shipping.shippingmaintain.SC_List(frame));
    } catch (Exception iie) {
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to S/C.");
    } finally {
      util.ApplicationProperites.removeProperites("recDetail");
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void butnAddDetail_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try {
      this.isShipQTY = false;
      frame.showPanel(new newtimes.shipping.shippingmaintain.DetailAdd(frame));
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Add-Detail.");
    } finally {
      util.ApplicationProperites.removeProperites("recDetail");
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_Copy() {
  }

  public void do_Delete() {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,
                          "Delete ?\nIinclude Extra Records Will Be Delete !!");
    if(result == 0){
      try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        boolean isOk = exgui2.CONST.SHIP_STYLE_EJB.deleteRecords(SHIP_STYLE_PK);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.shipping.shippingmaintain.ShipDetailList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel,
                                   "error at attempt pressed delete button.");
      } finally {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  public void do_Edit() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
      if (result == 0) {
        boolean isOk = exgui2.CONST.SHIP_STYLE_EJB.updateRecord(this.getData());
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
        }
      }
    } catch(Exception eE) {
      eE.printStackTrace();
      util.ExceptionLog.exp2File(eE, "error at attempt pressed confirm edit button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_Exit() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.isShipQTY = false;
      util.ApplicationProperites.removeProperites("recDetail");
    } catch(Exception eXit) {
      eXit.printStackTrace();
    } finally {
      frame.showPanel(new newtimes.shipping.shippingmaintain.ShipDetailList(frame));
      hmFrom = null;
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  private void setData2Fields() {
    JTextField[] txtFields = null;
    try {
      database.datatype.Record rec = (database.datatype.Record)hm.get("recDetail");
      STYLE_ORDER_QTY = rec.get("O_QTY")!=null?rec.get("O_QTY").toString():"";
      SHIP_QTY = rec.get("S_QTY")!=null?rec.get("S_QTY").toString():"";
      gui.txtStyQty.setText(STYLE_ORDER_QTY);
      gui.txtShipQTY.setText(SHIP_QTY);

      gui.txtFTY.setText(rec.get("FTY")!=null?rec.get("FTY").toString():"");
      gui.txtDiv.setText(rec.get("DIV")!=null?rec.get("DIV").toString():"");
      gui.txtSea.setText(rec.get("SEA")!=null?rec.get("SEA").toString():"");
      gui.txtScNo.setText(rec.get("SC_NO")!=null?rec.get("SC_NO").toString():"");
      gui.txtYear.setText(rec.get("YEAR")!=null?rec.get("YEAR").toString():"");
      gui.txtRange.setText(rec.get("RANGE")!=null?rec.get("RANGE").toString():"");
      gui.txtStyle.setText(rec.get("STYLE")!=null?rec.get("STYLE").toString():"");
      gui.txtPO.setText(rec.get("PO")!=null?rec.get("PO").toString():"");
      gui.txtUnit.setText(rec.get("UNIT")!=null?rec.get("UNIT").toString():"");
      gui.cmboPCB.setSelectedItem(rec.get("PBC") != null ?
                                  rec.get("PBC").toString() : "");
      java.util.Vector vBC = exgui2.Stuff.splitString(
          (rec.get("BUY_COMM") == null ? "0.00" :
           rec.get("BUY_COMM").toString()), ".");
      txtFields = new JTextField[] {gui.txtBuy, gui.txtBuy_Dot};
      exgui2.Stuff.setNo2Txt(txtFields, vBC);

      java.util.Vector vMDPer = exgui2.Stuff.splitString(
          (rec.get("MKR_DSCT_PER") == null ? "0.00" :
           rec.get("MKR_DSCT_PER").toString()), ".");
      txtFields = new JTextField[] {gui.txtMDPer, gui.txtMDPer_Dot};
      exgui2.Stuff.setNo2Txt(txtFields, vMDPer);

      java.util.Vector vMDPc = exgui2.Stuff.splitString(
          (rec.get("MKR_DSCT_PC") == null ? "0.00" :
           rec.get("MKR_DSCT_PC").toString()), ".");
      txtFields = new JTextField[] {gui.txtMDPc, gui.txtMDPc_Dot};
      exgui2.Stuff.setNo2Txt(txtFields, vMDPc);

      java.util.Vector vMDD = exgui2.Stuff.splitString(
          (rec.get("MKR_DSCT_DZ") == null ? "0.00" :
           rec.get("MKR_DSCT_DZ").toString()), ".");
      txtFields = new JTextField[] {gui.txtMDD, gui.txtMDD_Dot};
      exgui2.Stuff.setNo2Txt(txtFields, vMDD);

      java.util.Vector vMDLS = exgui2.Stuff.splitString(
          (rec.get("MKR_DSCT_LUMP_SUM") == null ? "0.00" :
           rec.get("MKR_DSCT_LUMP_SUM").toString()), ".");
      txtFields = new JTextField[] {gui.txtMDLS, gui.txtMDLS_Dot};
      exgui2.Stuff.setNo2Txt(txtFields, vMDLS);
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD,
        "error at set data to fields.\n"+hm.toString());
    }
  }

  private java.util.HashMap getData() {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      recFrom = (database.datatype.Record)hmFrom.get("recDetail");
      hm.put("SHIP_STYLE_PK", recFrom.get("SHIP_STYLE_PK"));
      hm.put("SHIP_SC_PK", String.valueOf(AddDetailList.SHIP_SC_PK));
      hm.put("STY_SEQ", String.valueOf(AddDetailList.STYLE_SEQ));
      hm.put("PBC", gui.cmboPCB.getSelectedItem());
      hm.put("BUY_COMM", (gui.txtBuy.getText().trim().equals("")?
             "0":gui.txtBuy.getText().trim())+"."+gui.txtBuy_Dot.getText().trim());
      hm.put("MKR_DSCT_PER", (gui.txtMDPer.getText().trim().equals("")?
             "0":gui.txtMDPer.getText().trim())+"."+gui.txtMDPer_Dot.getText().trim());
      hm.put("MKR_DSCT_PC", (gui.txtMDPc.getText().trim().equals("")?
             "0":gui.txtMDPc.getText().trim())+"."+gui.txtMDPc_Dot.getText().trim());
      hm.put("MKR_DSCT_DZ", (gui.txtMDD.getText().trim().equals("")?
             "0":gui.txtMDD.getText().trim())+"."+gui.txtMDD_Dot.getText().trim());
      hm.put("MKR_DSCT_LUMP_SUM", (gui.txtMDLS.getText().trim().equals("")?
             "0":gui.txtMDLS.getText().trim())+"."+gui.txtMDLS_Dot.getText().trim());
      hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
    } catch(Exception eData) {
      eData.printStackTrace();
      util.ExceptionLog.exp2File(eData, "error at get fields data.\nhm:"+hm.toString());
    } finally {
      return hm;
    }
  }

  private void doQtyTableButn (String actionButn) {
    try {
      gui.qtyTableEditorSC.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.isShipQTY = true;
      if (actionButn.equalsIgnoreCase("new")) {
        gui.qtyTableEditorSC.doAddNew();
      }
      if (actionButn.equalsIgnoreCase("save")) {
        gui.qtyTableEditorSC.doUpdate();
      }
      if (actionButn.equalsIgnoreCase("delete")) {
        gui.qtyTableEditorSC.doDelete();
      }
    } catch(Exception eNew) {
      eNew.printStackTrace();
      util.ExceptionLog.exp2File(eNew, "error at attempt pressed "+actionButn+" button.");
    } finally {
      gui.qtyTableEditorSC.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butn_QTY_New_actionPerformed(ActionEvent e) {
    this.doQtyTableButn("new");
  }

  void butn_QTY_Edit_actionPerformed(ActionEvent e) {
    this.doQtyTableButn("save");
  }

  void butn_QTY_Delete_actionPerformed(ActionEvent e) {
    this.doQtyTableButn("delete");
  }
}
