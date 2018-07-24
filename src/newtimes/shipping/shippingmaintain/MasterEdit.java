package newtimes.shipping.shippingmaintain;

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

public class MasterEdit extends ScrollPaneGUI {
  Frame1 frame;
  private String titleName = "Shipping Master Edit";
  private MasterFieldsGUI fieldsGUI = new MasterFieldsGUI();
  static String SRN_NO = null;
  private JTextField[] txtFields = null;
  private String usrType = null;

  public MasterEdit() {
  }

  public MasterEdit(Frame1 _frame) {
    frame = _frame;
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public MasterEdit(Frame1 _frame, String _SRN_NO) {
    frame = _frame;
    SRN_NO = _SRN_NO;
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
    this.setScrollPaneGUI(fieldsGUI);
    this.setTitleName(titleName);
    this.set3Buttons();
    fieldsGUI.isVisible_SrnNoAndExtra(true);
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
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.setDatas2Fields();
    this.checkID();
  }

  void checkID () {
    try {
      if (!usrType.equals("2") && !usrType.equals("6") && !usrType.equals("7")) {
        this.butnEdit.setEnabled(false);
        this.butnDelete.setEnabled(false);
        this.butnAddDetail.setEnabled(false);
        //this.butnSC.setEnabled(false);
      }
    } catch (Exception eID) {
      eID.printStackTrace();
      util.ExceptionLog.exp2File(eID, "error at check user type.");
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
    int result = exgui2.InfoMessage.Yes_No_Option(frame,
                          "Delete ?\nIinclude Extra Records Will Be Delete !!");
    if(result == 0){
      try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        boolean isOk = exgui2.CONST.SHIP_MAIN_EJB.deleteRecord(SRN_NO);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.shipping.shippingmaintain.MasterSearch(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      } catch (Exception eD) {
        eD.printStackTrace();
        util.ExceptionLog.exp2File(eD, "exception while attempt to Delete.");
      } finally {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  public void do_Edit() {
    if (fieldsGUI.checkFieldsData()) {
      int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
      if (result == 0) {
        java.util.HashMap hm = new java.util.HashMap();
        boolean isOk = false;
        try {
          setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          hm = fieldsGUI.getDatas();
          hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
          isOk = exgui2.CONST.SHIP_MAIN_EJB.updateRecord(hm);
        } catch (Exception eEd) {
          isOk = false;
          eEd.printStackTrace();
          util.ExceptionLog.exp2File(eEd,
                                     "exception while attempt to Confirm Edit" +
                                     "hm:" + hm.toString());
        } finally {
          if (isOk) {
            exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          } else {
            exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
          }
        }
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_Exit() {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("SRN_NO");
    util.ApplicationProperites.removeProperites("v");
    this.SRN_NO = null;
    frame.showPanel(new newtimes.shipping.shippingmaintain.MasterSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  private void setDatas2Fields() {
    java.util.Vector v = null;
    database.datatype.Record rec = null;
    try {
      if (util.ApplicationProperites.getProperties("v") == null) {
        v = (java.util.Vector) exgui2.CONST.SHIP_MAIN_EJB.getRecords(this.SRN_NO);
      } else {
        v = (java.util.Vector) util.ApplicationProperites.getProperties("v");
      }
      rec = (database.datatype.Record)v.get(0);
      //System.out.println("#rec:"+rec.toString());
      fieldsGUI.txtSrnNo.setText(rec.get("SHIP_NO")!=null?rec.get("SHIP_NO").toString():"");
      fieldsGUI.txtAgent.setText(rec.get("SHIP_AGENT")!=null?rec.get("SHIP_AGENT").toString():"");
      fieldsGUI.txtAreaVessel.setText(rec.get("SHIP_VESSEL")!=null?rec.get("SHIP_VESSEL").toString():"");
      fieldsGUI.txtAttn.setText(rec.get("SHIP_ATTN")!=null?rec.get("SHIP_ATTN").toString():"");
      fieldsGUI.txtFLT.setText(rec.get("SHIP_FLT_NO")!=null?rec.get("SHIP_FLT_NO").toString():"");
      fieldsGUI.txtFrom.setText(rec.get("SHIP_FM")!=null?rec.get("SHIP_FM").toString():"");
      fieldsGUI.txtHAWB.setText(rec.get("SHIP_HAWB")!=null?rec.get("SHIP_HAWB").toString():"");
      fieldsGUI.txtInv.setText(rec.get("SHIP_FTY_INV")!=null?rec.get("SHIP_FTY_INV").toString():"");
      fieldsGUI.txtLC.setText(rec.get("SHIP_LC_NO")!=null?rec.get("SHIP_LC_NO").toString():"");
      fieldsGUI.txtMAWB.setText(rec.get("SHIP_MAWB")!=null?rec.get("SHIP_MAWB").toString():"");
      fieldsGUI.txtPort.setText(rec.get("SHIP_USA_PORT")!=null?rec.get("SHIP_USA_PORT").toString():"");
      fieldsGUI.txtTo.setText(rec.get("SHIP_TO")!=null?rec.get("SHIP_TO").toString():"");
      fieldsGUI.txtVia.setText(rec.get("SHIP_VIA")!=null?rec.get("SHIP_VIA").toString():"");
      fieldsGUI.txtYear.setText(rec.get("SHIP_DATE")!=null?rec.get("SHIP_DATE").toString().substring(0,4):"");
      fieldsGUI.txtMonth.setText(rec.get("SHIP_DATE")!=null?rec.get("SHIP_DATE").toString().substring(5,7):"");
      fieldsGUI.txtDay.setText(rec.get("SHIP_DATE")!=null?rec.get("SHIP_DATE").toString().substring(8,10):"");
      fieldsGUI.txtDes.setText(rec.get("SHIP_DEST")!=null?rec.get("SHIP_DEST").toString():"");
      fieldsGUI.txtCuft.setText(rec.get("SHIP_DIM_CUFT")!=null?rec.get("SHIP_DIM_CUFT").toString():"");
      fieldsGUI.txtDimUnit.setText(rec.get("SHIP_DIM_WT_UNIT")!=null?rec.get("SHIP_DIM_WT_UNIT").toString():"");
      fieldsGUI.txtNetUnit.setText(rec.get("SHIP_NET_WT_UNIT")!=null?rec.get("SHIP_NET_WT_UNIT").toString():"");
      fieldsGUI.txtGrossUnit.setText(rec.get("SHIP_GROSS_WT_UNIT")!=null?rec.get("SHIP_GROSS_WT_UNIT").toString():"");
      fieldsGUI.txtNetNetUnit.setText(rec.get("SHIP_NET_NET_WT_UNIT")!=null?rec.get("SHIP_NET_NET_WT_UNIT").toString():"");

      fieldsGUI.txtETA_Y.setText(rec.get("SHIP_ETA_DATE")!=null?rec.get("SHIP_ETA_DATE").toString().substring(0,4):"");
      fieldsGUI.txtETA_M.setText(rec.get("SHIP_ETA_DATE")!=null?rec.get("SHIP_ETA_DATE").toString().substring(5,7):"");
      fieldsGUI.txtETA_D.setText(rec.get("SHIP_ETA_DATE")!=null?rec.get("SHIP_ETA_DATE").toString().substring(8,10):"");

      fieldsGUI.txtETD_Y.setText(rec.get("SHIP_ETD_DATE")!=null?rec.get("SHIP_ETD_DATE").toString().substring(0,4):"");
      fieldsGUI.txtETD_M.setText(rec.get("SHIP_ETD_DATE")!=null?rec.get("SHIP_ETD_DATE").toString().substring(5,7):"");
      fieldsGUI.txtETD_D.setText(rec.get("SHIP_ETD_DATE")!=null?rec.get("SHIP_ETD_DATE").toString().substring(8,10):"");

      fieldsGUI.txtIC_Y.setText(rec.get("SHIP_IC_DATE")!=null?rec.get("SHIP_IC_DATE").toString().substring(0,4):"");
      fieldsGUI.txtIC_M.setText(rec.get("SHIP_IC_DATE")!=null?rec.get("SHIP_IC_DATE").toString().substring(5,7):"");
      fieldsGUI.txtIC_D.setText(rec.get("SHIP_IC_DATE")!=null?rec.get("SHIP_IC_DATE").toString().substring(8,10):"");

      java.util.Vector vDimCTN = exgui2.Stuff.splitString(rec.get("SHIP_DIM_CTN").toString(),".");
      txtFields = new JTextField[] {fieldsGUI.txtDimentCTN, fieldsGUI.txtDimentCTN_2};
      exgui2.Stuff.setNo2Txt(txtFields, vDimCTN);

      java.util.Vector vDimWT = exgui2.Stuff.splitString(rec.get("SHIP_DIM_WT").toString(),".");
      txtFields = new JTextField[] {fieldsGUI.txtDimnetWT, fieldsGUI.txtDimnetWT_2};
      exgui2.Stuff.setNo2Txt(txtFields, vDimWT);

      java.util.Vector vGrossWT = exgui2.Stuff.splitString(rec.get("SHIP_GROSS_WT").toString(),".");
      txtFields = new JTextField[] {fieldsGUI.txtGrossWT, fieldsGUI.txtGrossWT_2};
      exgui2.Stuff.setNo2Txt(txtFields, vGrossWT);

      java.util.Vector vNetWT = exgui2.Stuff.splitString(rec.get("SHIP_NET_WT").toString(),".");
      txtFields = new JTextField[] {fieldsGUI.txtNetWT, fieldsGUI.txtNetWT_2};
      exgui2.Stuff.setNo2Txt(txtFields, vNetWT);

      java.util.Vector vNetNetWT = exgui2.Stuff.splitString(rec.get("SHIP_NET_NET_WT")==null?"0.00":rec.get("SHIP_NET_NET_WT").toString(),".");
      txtFields = new JTextField[] {fieldsGUI.txtNetNet, fieldsGUI.txtNetNetDot};
      exgui2.Stuff.setNo2Txt(txtFields, vNetNetWT);

      Object[][] rb = {{fieldsGUI.rb_GOH, rec.get("SHIP_GF")},{fieldsGUI.rb_FLAT, rec.get("SHIP_GF")}};
      Object[] initValues = {"G", "F"};
      exgui2.Stuff.getRadioButtonValues(rb, initValues);

      fieldsGUI.cmboCnty.setSelectedItem(rec.get("SHIP_CNTY_ORIG")!=null?rec.get("SHIP_CNTY_ORIG").toString():"");
      fieldsGUI.cmboDiv.setSelectedItem(rec.get("SHIP_IC_DIV")!=null?rec.get("SHIP_IC_DIV").toString():"");
      fieldsGUI.cmboEx.setSelectedItem(rec.get("SHIP_ETD_EX")!=null?rec.get("SHIP_ETD_EX").toString():"");
      fieldsGUI.cmboTo.setSelectedItem(rec.get("SHIP_ETA_TO")!=null?rec.get("SHIP_ETA_TO").toString():"");
      fieldsGUI.cmboSeason.setSelectedItem(rec.get("SHIP_IC_SEA")!=null?rec.get("SHIP_IC_SEA").toString():"");
      fieldsGUI.cmboOceanAir.setSelectedItem(rec.get("SHIP_OCEAN_AIR")!=null?rec.get("SHIP_OCEAN_AIR").toString():"");
      fieldsGUI.cmboExpFowr.setSelectedItem(rec.get("FORWARDER")!=null?rec.get("FORWARDER").toString():"");
      fieldsGUI.cmboBill.setSelectedItem(rec.get("BILL_TO")!=null?rec.get("BILL_TO").toString():"");
      fieldsGUI.cmboShip.setSelectedItem(rec.get("SHIP_TO_1")!=null?rec.get("SHIP_TO_1").toString():"");
      fieldsGUI.cmboPrxTerm.setSelectedItem(rec.get("SHIP_PRC_TRM")!=null?rec.get("SHIP_PRC_TRM").toString():"");
      fieldsGUI.cmboExpAgent.setSelectedItem(rec.get("EXP_AGENT")!=null?rec.get("EXP_AGENT").toString():"");
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields.\n"+
                                 "Record:"+rec.toString());
    }
  }
}
