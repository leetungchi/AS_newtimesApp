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

public class QTA extends AbstractDialog {
  private exgui.DataBindJList dbJListQTA = null;
  java.util.Vector vQTAName = null;

  public QTA(JFrame _frame, String _title, boolean _modal) {
    super(_frame, _title, _modal);
    removeListLetter();
  }
  public Vector setShowingData() {
    return null;
  }
  public exgui.DataBindJList setShowListData() {
    java.util.Vector vQTA = null;
    try {
      vQTA = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("(QTA_CAT || QTA_AREA) QTA_CAT","QTA_CAT");
      database.datatype.Record recQTA = (database.datatype.Record) vQTA.get(0);
      dbJListQTA = new exgui.DataBindJList(getListData(), vQTA, "QTA_CAT",
                                          "QTA_CAT", recQTA.get("QTA_CAT"));
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "QTA data:"+vQTA.toString());
    } finally {
      return dbJListQTA;
    }
  }
  public void actionApply() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      vQTAName = getSelectedName();
    } catch(Exception eOk) {
      eOk.printStackTrace();
      util.ExceptionLog.exp2File(eOk, "DIV :"+vQTAName.toString());
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