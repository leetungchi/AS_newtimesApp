package newtimes.reports.report01.summary;

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

public class FTY extends AbstractDialog {
  private exgui.DataBindJList dbJListFTY = null;
  java.util.Vector vFTYName = null;

  public FTY(JFrame _frame, String _title, boolean _modal) {
    super(_frame, _title, _modal);
  }
  public java.util.Vector setShowingData() {
    java.util.Vector vFTY = null;
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      if (getListLetter().getSelectedValue().equals("All")) {
        vFTY = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType(
            "BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF", 2);
      } else {
        vFTY = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerByFirstLetter(
            getListLetter().getSelectedValue().toString(), "BYMKR_SEQ,BYMKR_BRIEF", "2");
      }
      if (!vFTY.isEmpty()) {
        database.datatype.Record recQTA = (database.datatype.Record)vFTY.get(0);
        dbJListFTY = new exgui.DataBindJList(getListData(), vFTY, "BYMKR_BRIEF",
                                             "BYMKR_BRIEF",
                                             recQTA.get("BYMKR_BRIEF"));
      } else {
        getListData().setListData(vFTY);
      }
    } catch(Exception eList) {
      eList.printStackTrace();
      util.ExceptionLog.exp2File(eList, "error at attempt FTY datas.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      return vFTY;
    }
  }
  public exgui.DataBindJList setShowListData() {
    return null;
  }
  public void actionApply() {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      vFTYName = getSelectedName();
    } catch(Exception eOk) {
      eOk.printStackTrace();
      util.ExceptionLog.exp2File(eOk, "FTY :"+vFTYName.toString());
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