package newtimes.basic.center;

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

public class CenterDataFactory implements PagedDataFactory {
//  private BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB basicEJB =
//    (BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB)util.ApplicationProperites.getProperties("basicEJB");
  private java.util.HashMap hm4Cen = null;

  public CenterDataFactory(java.util.HashMap hm) {
    hm4Cen = hm;
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    Vector vCenData = exgui2.CONST.BASIC_BASE_EJB.getCenterList(startPosition, rowCounts, hm4Cen);
    return vCenData;
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
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method getBlankRecord() not yet implemented.");
  }
  public void updateRecords(Vector recs2update) throws Exception {
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}