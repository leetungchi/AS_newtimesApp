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

public class SysValueEdit extends JPanel {
  Frame1 frame;
  String titleName = "System Value Edit";
  SysValueGUI gui = new SysValueGUI(titleName);
  static boolean isExit = false;
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  String _sysPK = null;
  public SysValueEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    gui.butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    gui.butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    gui.butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    gui.butnAdd.setVisible(false);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.add(gui, null);
    this.setData2Fields();
    if("001".equals(gui.dbJCBXCen.getSelectedValue())||"003".equals(gui.dbJCBXCen.getSelectedValue())){
      gui.add(gui.btnOtherTpeRange, null);
    }

  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.systemvalue.SysValueList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("SYSTEM_DEFAULT_VALUE_PK", this._sysPK);
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.SYSTEM_VALUE_EJB.deleteRecord(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.systemvalue.SysValueList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
  void butnModify_actionPerformed(ActionEvent e) {
    if(gui.checkFieldsData()){
      int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
      if (result == 0) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
          isExit = true;
          hm.clear();
          hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
          hm.put("CENTER", gui.dbJCBXCen.getSelectedValue().toString());
          hm.put("LOCAL_CURRENCY_NAME",
                 gui.dbJCBXCrncy.getSelectedValue().toString());
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
          hm.put("IC_NAME", gui.txtIC.getText().trim().toUpperCase());
          hm.put("SYSTEM_DEFAULT_VALUE_PK", this._sysPK);
          hm.put("CURRENT_YEAR", gui.dbCurrYear.getSelectedValue());
          hm.put("YEAR_RNG_BGN", gui.dbYearBgn.getSelectedValue());
          hm.put("YEAR_RNG_END", gui.dbYearEnd.getSelectedValue());
          hm.put("PLAN_DEL_BGN", gui.dbPlanDelBgn.getSelectedValue());
          hm.put("PLAN_DEL_END", gui.dbPlanDelEnd.getSelectedValue());
          hm.put("DELV_RNG_BGN", gui.dbDelvBgn.getSelectedValue());
          hm.put("DELV_RNG_END", gui.dbDelvEnd.getSelectedValue());
          hm.put("TWD_XCHG_RATE", gui.dbTwdChg.getSelectedValue());
          hm.put("RMB_XCHG_RATE", gui.dbRmbChg.getSelectedValue());
          hm.put("HKD_XCHG_RATE", gui.dbHkdChg.getSelectedValue());

          boolean isOk = exgui2.CONST.SYSTEM_VALUE_EJB.updateRecord(hm);
          if (isOk) {
            exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
            frame.showPanel(new newtimes.basic.systemvalue.SysValueList(frame));
          } else {
            exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
          }
        } catch (Exception eDel) {
          eDel.printStackTrace();
          util.ExceptionLog.exp2File(eDel,
                                     "error at modify data." + hm.toString());
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }
  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      this._sysPK = recDetail.get("SYSTEM_DEFAULT_VALUE_PK").toString();
      Object xchgRateData=recDetail.get("EXCHANGE_RATE");
      Object fhaData=recDetail.get("FHA");
      float xchgRate=(xchgRateData==null)?0:Float.parseFloat(xchgRateData.toString());
      float fha=(fhaData==null)?0:Float.parseFloat(fhaData.toString());
      String xchgString=(new java.text.DecimalFormat("####0.00")).format(xchgRate);
      String fhaString=(new java.text.DecimalFormat("####0.00")).format(fha);
      /*
      gui.txtEx_1.setText(exgui2.Stuff.splitString(xchgString,".").get(0).toString());
      gui.txtEx_2.setText(exgui2.Stuff.splitString(xchgString,".").get(1).toString());
      gui.txtFHA_1.setText(exgui2.Stuff.splitString(fhaString,".").get(0).toString());
      gui.txtFHA_2.setText(exgui2.Stuff.splitString(fhaString,".").get(1).toString());
      */
      gui.txtFHA.setText(fhaString);
      gui.txtXchg.setText(xchgString);
      gui.txtIC.setText(recDetail.get("IC_NAME")==null?"":recDetail.get("IC_NAME").toString());
      gui.cmboCen.setSelectedItem(recDetail.get("CEN_NAME")==null?"":recDetail.get("CEN_NAME").toString());
      gui.cmboCrncy.setSelectedItem(recDetail.get("LOCAL_CURRENCY_NAME")==null?"":recDetail.get("LOCAL_CURRENCY_NAME").toString());
      exgui.Object2String objInt4Cnv=
          exgui.verification.CellFormat.getIntVerifierAllowNull(4);
      exgui.Object2String dateBgn=
          new SysValueGUI.Date000000Conv();
      exgui.Object2String dateEnd=
          new SysValueGUI.Date235959Conv();
      Object twdChg=recDetail.get("TWD_XCHG_RATE");
      Object rmbChg=recDetail.get("RMB_XCHG_RATE");
      Object hkdChg=recDetail.get("HKD_XCHG_RATE");

      gui.txtCurrentYear.setText(objInt4Cnv.Obj2String(recDetail.get("current_year")));
      gui.txtYearRngBgn.setText(objInt4Cnv.Obj2String(recDetail.get("year_rng_bgn")));
      gui.txtYearRngEnd.setText(objInt4Cnv.Obj2String(recDetail.get("year_rng_end")));
      gui.txtPlanDelBgn.setText(dateBgn.Obj2String(recDetail.get("plan_del_bgn")));
      gui.txtPlanDelEnd.setText(dateEnd.Obj2String(recDetail.get("plan_del_End")));
      gui.txtDelvRngBgn.setText(dateBgn.Obj2String(recDetail.get("delv_rng_bgn")));
      gui.txtDelvRngEnd.setText(dateEnd.Obj2String(recDetail.get("delv_rng_end")));
      gui.txtTwdXchg.setText((twdChg==null)?"":twdChg.toString());
      gui.txtRmbXchg.setText((rmbChg==null)?"":rmbChg.toString());
      gui.txtHkdXchg.setText((hkdChg==null)?"":hkdChg.toString());
      gui.txtShipCloseB4.setText(dateBgn.Obj2String(recDetail.get("SHIP_CLOSE_B4")));

      /*
     Object objInt4Cnv=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
      gui.dbCurrYear =
          new  exgui.DataBindTextWithChecker(gui.txtCurrentYear,
                                       "current_year",
                                        recDetail.get("current_year"),
                                        4,
                                        (exgui.Object2String)objInt4Cnv,
                                        (exgui.ultratable.CellTxtEditorFormat)objInt4Cnv);

   SysValueGUI.Date000000Conv dateBgn=
       new SysValueGUI.Date000000Conv();
   SysValueGUI.Date235959Conv dateEnd=
       new SysValueGUI.Date235959Conv();


     gui.dbYearBgn =
         new exgui.DataBindTextWithChecker(gui.txtYearRngBgn,
                                           "year_rng_bgn",
                                           recDetail.get("year_rng_bgn"),
                                           4,
                                           (exgui.Object2String)objInt4Cnv,
                                           (exgui.ultratable.
                                            CellTxtEditorFormat)objInt4Cnv
                                           );
     gui.dbYearEnd =
         new exgui.DataBindTextWithChecker(gui.txtYearRngEnd,
                                           "year_rng_end",
                                           recDetail.get("year_rng_end"),
                                           4,
                                           (exgui.Object2String)objInt4Cnv,
                                           (exgui.ultratable.
                                            CellTxtEditorFormat)objInt4Cnv
                                           );

     gui.dbPlanDelBgn =
         new exgui.DataBindTextWithChecker(gui.txtPlanDelBgn,
                                           "plan_del_bgn",
                                           recDetail.get("plan_del_bgn"),
                                           10,
                                           (exgui.Object2String)dateBgn,
                                           (exgui.ultratable.
                                            CellTxtEditorFormat)dateBgn
                                           );

     gui.dbPlanDelEnd =
         new exgui.DataBindTextWithChecker(gui.txtPlanDelEnd,
                                           "plan_del_end",
                                           recDetail.get("plan_del_end"),
                                           10,
                                           (exgui.Object2String)dateEnd,
                                           (exgui.ultratable.
                                            CellTxtEditorFormat)dateEnd
                                           );


     gui.dbDelvBgn  =
         new exgui.DataBindTextWithChecker(gui.txtDelvRngBgn ,
                                           "delv_rng_bgn",
                                           recDetail.get("delv_rng_bgn"),
                                           10,
                                           (exgui.Object2String)dateBgn,
                                           (exgui.ultratable.
                                            CellTxtEditorFormat)dateBgn
                                           );

     gui.dbDelvEnd =
         new exgui.DataBindTextWithChecker(gui.txtDelvRngEnd,
                                           "delv_rng_end",
                                           recDetail.get("delv_rng_end"),
                                           10,
                                           (exgui.Object2String)dateEnd,
                                           (exgui.ultratable.
                                            CellTxtEditorFormat)dateEnd
                                           );
     */
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }
}
