package newtimes.reports.report01.GmtPendLc;

import exgui.ultratable.PagedDataFactory;
import java.util.Vector;
import database.datatype.Record;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtPendDataFactory implements PagedDataFactory {
  private ReportEJBs.RepGMTPendLC.GMTPendLc gmtPendLcEJB=
      (ReportEJBs.RepGMTPendLC.GMTPendLc)util.ApplicationProperites.getProperties("gmtPendLcEJB");
  private java.util.HashMap condition = null;
  static String isOk = null;

  public GmtPendDataFactory(java.util.HashMap hm) {
    condition = hm;
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    Vector vec= gmtPendLcEJB.getRecords(startPosition, rowCounts, condition);
    Vector newVec = new Vector();
    for(int i=0;i<vec.size();i++){
      Record rec=(Record)vec.get(i);
      rec.getFieldName().add("RECORD_MODIFY_USER");
      rec.getValueFields().add(null);
      newVec.add(rec);
    }
    return newVec;
  }
  public void deleteRecord(Record rec2delete) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method deleteRecord() not yet implemented.");
  }
  public void restoreRecord(Record rec2restore) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method restoreRecord() not yet implemented.");
  }
  public Record addRecord(Record rec2add) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method addRecord() not yet implemented.");
  }
  public Record getBlankRecord() throws Exception {
    return gmtPendLcEJB.getBlankRecord();
  }
  public void updateRecords(Vector recs2update) throws Exception {
    if (recs2update.isEmpty()) {
      this.isOk = null;
    } else {
      boolean isOk = gmtPendLcEJB.updateLCNO(recs2update);
      if (isOk) this.isOk = "Update_Succeed";
      else this.isOk = "Update_Failed";
    }
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}