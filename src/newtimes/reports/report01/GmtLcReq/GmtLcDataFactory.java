package newtimes.reports.report01.GmtLcReq;

import exgui.ultratable.PagedDataFactory;
import java.util.Vector;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtLcDataFactory implements PagedDataFactory {
  private ReportEJBs.RepGMTLC.GMTLc gmtLcEJB=
      (ReportEJBs.RepGMTLC.GMTLc)util.ApplicationProperites.getProperties("gmtLcEJB");
  private java.util.HashMap condition = null;

  public GmtLcDataFactory(java.util.HashMap hm) {
    condition = hm;
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    return gmtLcEJB.getRecords(startPosition, rowCounts, condition);
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
    return gmtLcEJB.getBlankRecord();
  }
  public void updateRecords(Vector recs2update) throws Exception {
    gmtLcEJB.updateRecords(recs2update);
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}