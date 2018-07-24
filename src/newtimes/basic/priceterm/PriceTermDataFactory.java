package newtimes.basic.priceterm;

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

public class PriceTermDataFactory implements PagedDataFactory {
//  private BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB basicMainEJB =
//  (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB)util.ApplicationProperites.getProperties("basicMainEJB");
  private java.util.HashMap hm4PT = null;

  public PriceTermDataFactory(java.util.HashMap hm) {
    hm4PT = hm;
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    Vector vDepData = exgui2.CONST.BASIC_MAIN_EJB.getPriceTermList(startPosition, rowCounts, hm4PT);
    return vDepData;
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