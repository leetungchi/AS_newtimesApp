package newtimes.reports.report01.summary;

import java.util.Vector;
import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DIV extends AbstractDialog {
  private exgui.DataBindJList dbJListDIV = null;
  java.util.Vector vDIVName = null;

  public DIV(JFrame _frame, String _title, boolean _modal) {
    super(_frame, _title, _modal);
    removeListLetter();
  }
  public Vector setShowingData() {
    return null;
  }
  public exgui.DataBindJList setShowListData() {
    java.util.Vector vDIV = null;
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      vDIV = exgui2.CONST.BASIC_MAIN_EJB.getDivisionAll("DIV_CODE,DIV_NAME", "DIV_NAME");
      database.datatype.Record recQTA = (database.datatype.Record) vDIV.get(0);
      dbJListDIV = new exgui.DataBindJList(getListData(), vDIV, "DIV_NAME",
                                          "DIV_NAME", recQTA.get("DIV_NAME"));
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "DIV data:"+vDIV.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      return dbJListDIV;
    }
  }
  public void actionApply() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      vDIVName = getSelectedName();
    } catch(Exception eOk) {
      eOk.printStackTrace();
      util.ExceptionLog.exp2File(eOk, "DIV :"+vDIVName.toString());
    } finally {
      this.dispose();
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public int setLocation_X() {
    return 300;
  }

  public int setLocation_Y() {
    return 250;
  }

  public boolean setIsExit() {
    return isExit();
  }
}