package newtimes.reports.report01.foblist;

import java.awt.*;
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

public class FobList extends ScrollPaneGUI {
  Frame1 frame;
  private FobListGUI gui = null;
  private String titleName = "FOB List";
  private boolean isViewer = false;
  private java.util.HashMap hmFields = new java.util.HashMap();

  public FobList(Frame1 _frame) {
    frame = _frame;
    try {
      if(util.ApplicationProperites.getProperties("FobListGUI")==null){
        gui = new FobListGUI();
      }else{
        gui=(FobListGUI)util.ApplicationProperites.getProperties("FobListGUI");
      }
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setPanelWithButtons();
    this.setScrollPaneGUI(gui);
    this.setTitleName(titleName);
    this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.butnCopy.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    if (!isViewer) {
      util.ApplicationProperites.removeProperites("FobListGUI");
      frame.showPanel(new newtimes.reports.ReportMenu1(frame));
    } else {
      frame.showPanel(new newtimes.reports.report01.foblist.FobList(
          frame));
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
    try {
      if(checkField()){
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        util.ApplicationProperites.setProperties("FobListGUI", gui);
        this.butnPrint.setEnabled(false);
        isViewer = true;
        this.getFieldsData();
        setScrollPaneGUI(new exgui2.ReportGenerate("FOB_LIST.rpt",
            this.setReportAgument()));
      }
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
                                 "error at attempt pressed Print button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  private String setReportAgument() {
    try {

      hmFields = util.MiscFunc.URLEncode(hmFields);
      StringBuffer sb = new StringBuffer();
      sb.append("&prompt0="+hmFields.get("CEN"));
      sb.append("&prompt1="+hmFields.get("DIV"));
      sb.append("&prompt2="+hmFields.get("YEAR"));
      sb.append("&prompt3="+hmFields.get("RANGE"));
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  java.util.HashMap getFieldsData() {
    try {
      hmFields.put("CEN", gui.dbJCBXCen.getSelectedValue().equals("null")?"":gui.dbJCBXCen.getSelectedValue());
      hmFields.put("DIV", gui.dbJCBXDiv.getSelectedValue().equals("null")?"":gui.dbJCBXDiv.getSelectedValue());
      hmFields.put("YEAR", gui.txtYear.getText().trim().equals("")?"":gui.txtYear.getText().trim());
      String RangeString="";
      JTextField[] txtRange = {gui.txtRange1,gui.txtRange2,gui.txtRange3,gui.txtRange4,gui.txtRange5,gui.txtRange6,gui.txtRange7,gui.txtRange8};
      for (int x = 0; x < txtRange.length; x++) {
        if(!txtRange[x].getText().trim().equals("") && (txtRange[x].getText().trim()!=null)){
          RangeString=RangeString + ((x==0)?"":",") + "'" + txtRange[x].getText().trim() + "'" ;
        }
      }
      hmFields.put("RANGE",RangeString);
      System.out.println("#hmFields:"+hmFields.toString());
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt get fields data.\n"+hmFields.toString());
    } finally {
      return hmFields;
    }
  }
  private boolean checkField(){
    if(!gui.txtYear.getText().trim().equals("")){
      if (exgui.verification.VerifyLib.isInteger(gui.txtYear,
          "The Year field must be integer!") == true) {
        return true;
      } else {
        gui.txtYear.grabFocus();
        return false;
      }
    }
    return true;
  }


}
