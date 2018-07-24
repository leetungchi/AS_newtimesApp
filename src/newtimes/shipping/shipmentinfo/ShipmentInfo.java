package newtimes.shipping.shipmentinfo;

import java.awt.*;
import java.awt.event.*;
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

public class ShipmentInfo extends ScrollPaneGUI {
  Frame1 frame;
  private ShipmentInfoGUI fieldsGUI =null;
  private String titleName = "Shipment Information";
  static java.util.HashMap hmFields = new java.util.HashMap();

  public ShipmentInfo(Frame1 _frame) {
    frame = _frame;
    try {
      if(util.ApplicationProperites.getProperties("ShipmentInfoGUI")==null){
        fieldsGUI = new ShipmentInfoGUI();
      }else{
        fieldsGUI = (ShipmentInfoGUI)util.ApplicationProperites.getProperties("ShipmentInfoGUI");
      }
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(fieldsGUI);
    this.setTitleName(titleName);
    fieldsGUI.do_ShipInfo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_ShipInfo_actionPerformed(e);
      }
    });
    fieldsGUI.do_PrintUnShip.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_PrintUnShip_actionPerformed(e);
      }
    });
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
  }

  public void do_ShipInfo_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.getFieldsData();
      util.ApplicationProperites.setProperties("ShipmentInfoGUI",fieldsGUI);
      frame.showPanel(new newtimes.shipping.shipmentinfo.InterOffice(frame, this.setReportAgument()));
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Ship-Info.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    util.ApplicationProperites.removeProperites("ShipmentInfoGUI");
    frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  void do_PrintUnShip_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.getFieldsData();
      util.ApplicationProperites.setProperties("ShipmentInfoGUI",fieldsGUI);
      frame.showPanel(new newtimes.shipping.shipmentinfo.UnShipped(frame, this.setReportAgument()));
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Ship-Info.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      hmFields.put("CEN", fieldsGUI.dbJCBXCen.getSelectedValue().equals("null")?"":fieldsGUI.dbJCBXCen.getSelectedValue());
      hmFields.put("DEP", fieldsGUI.dbJCBXDep==null?"":fieldsGUI.dbJCBXDep.getSelectedValue());
      hmFields.put("CNTY", fieldsGUI.dbJCBXCnty.getSelectedValue().equals("null")?"":fieldsGUI.dbJCBXCnty.getSelectedValue());
      hmFields.put("DIV", fieldsGUI.dbJCBXDiv.getSelectedValue().equals("null")?"":fieldsGUI.dbJCBXDiv.getSelectedValue());
      hmFields.put("SEASON", fieldsGUI.dbJCBXSeason.getSelectedValue().equals("null")?"":fieldsGUI.dbJCBXSeason.getSelectedValue());
      hmFields.put("FTY", fieldsGUI.popMaker.getSelectedMakerValue());
      hmFields.put("YEAR", fieldsGUI.txtYear.getText().trim().equals("")?"":fieldsGUI.txtYear.getText().trim());
      hmFields.put("RANGE", fieldsGUI.txtRng.getText().trim().equals("")?"":fieldsGUI.txtRng.getText().trim());
      hmFields.put("PO", fieldsGUI.txtPO.getText().trim().equals("")?"":fieldsGUI.txtPO.getText().trim());
      hmFields.put("SHIP_METHOD",fieldsGUI.CmbShipMethod.getSelectedItem().toString().equals("")?"":fieldsGUI.CmbShipMethod.getSelectedItem().toString());
      //hmFields.put("SHIP_METHOD", fieldsGUI.txtShipWay.getText().trim().equals("")?"":fieldsGUI.txtShipWay.getText().trim());
      if (!fieldsGUI.txtETDFm_Y.getText().trim().equals("")) {
        hmFields.put("ETD_FM", fieldsGUI.txtETDFm_Y.getText()+"/"+fieldsGUI.txtETDFm_M.getText()+"/"+fieldsGUI.txtETDFm_D.getText());
        hmFields.put("ETD_TO", fieldsGUI.txtETDTo_Y.getText()+"/"+fieldsGUI.txtETDTo_M.getText()+"/"+fieldsGUI.txtETDTo_D.getText());
      } else {
        hmFields.put("ETD_FM", "");
        hmFields.put("ETD_TO", "");
      }
      if (!fieldsGUI.txtDelFm_Y.getText().trim().equals("")) {
        hmFields.put("DEL_FM", fieldsGUI.txtDelFm_Y.getText()+"/"+fieldsGUI.txtDelFm_M.getText()+"/"+fieldsGUI.txtDelFm_D.getText());
        hmFields.put("DEL_TO", fieldsGUI.txtDelTo_Y.getText()+"/"+fieldsGUI.txtDelTo_M.getText()+"/"+fieldsGUI.txtDelTo_D.getText());
      } else {
        hmFields.put("DEL_FM", "");
        hmFields.put("DEL_TO", "");

      }
      hmFields.put("B_QTY", fieldsGUI.isChk_Yes ? "Y" : "");
      if (fieldsGUI.isChk_None == false) {
        Object[] qta = fieldsGUI.listQTA.getSelectedValues();
        StringBuffer qtaStr = new StringBuffer();
        if (qta.length == 1) {
          qtaStr.append("'"+qta[0]+"'");
        } else {
          for (int i = 0; i < qta.length; i++) {
            if (i == qta.length-1) {//last array
              qtaStr.append("'"+qta[i]+"'");
            } else {
              qtaStr.append("'" + qta[i] + "',");
            }
          }
        }
        hmFields.put("QTA", qtaStr.toString());
      } else {
        hmFields.put("QTA", "");
      }
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt get fields data.\n"+hmFields.toString());
    } finally {
      return hmFields;
    }
  }

  String setReportAgument() {
    try {
      /*viewer.setReportName(
      "http://172.16.0.24/crystal/TestServlet?report=" +
      reportFile.getText()+
      "&prompt0=2003/06/12&prompt1=2003/06/12&prompt2=002&prompt3=TPJ03
      &prompt4=5059&prompt5=JON&prompt6=SUMMER&prompt7=2003&prompt8=
      &prompt9=&prompt10=2003/6/24&prompt11=2003/6/24&prompt12=
      &prompt13=HH1111&prompt14=&prompt15=Y");*/

      System.out.println("#hmFields:"+hmFields.toString());
      StringBuffer sb = new StringBuffer();
      sb.append("&prompt0=");
      sb.append(hmFields.get("DEL_FM")==null?"":hmFields.get("DEL_FM"));
      sb.append("&prompt1=");
      sb.append(hmFields.get("DEL_TO")==null?"":hmFields.get("DEL_TO"));
      sb.append("&prompt2="+hmFields.get("CEN"));
      sb.append("&prompt3="+(hmFields.get("DEP").equals("null")?"":hmFields.get("DEP")));
      sb.append("&prompt4=");
      sb.append(hmFields.get("FTY")==null?"":hmFields.get("FTY"));
      sb.append("&prompt5="+hmFields.get("DIV"));
      sb.append("&prompt6="+hmFields.get("SEASON"));
      sb.append("&prompt7="+hmFields.get("YEAR"));
      sb.append("&prompt8="+hmFields.get("CNTY"));
      sb.append("&prompt9="+hmFields.get("QTA"));
      sb.append("&prompt10=");
      sb.append(hmFields.get("ETD_FM")==null?"":hmFields.get("ETD_FM"));
      sb.append("&prompt11=");
      sb.append(hmFields.get("ETD_TO")==null?"":hmFields.get("ETD_TO"));
      sb.append("&prompt12="+hmFields.get("SHIP_METHOD"));
      sb.append("&prompt13="+hmFields.get("PO"));
      sb.append("&prompt14="+hmFields.get("RANGE"));
      sb.append("&prompt15="+hmFields.get("B_QTY"));
      return sb.toString();
    } catch(Exception eRep) {
      eRep.printStackTrace();
      return null;
    }
  }
}