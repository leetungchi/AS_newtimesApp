package newtimes.material;

import exgui.ultratable.PagedDataFactory;
import java.util.Vector;
import database.datatype.Record;

/**
 * <p>Title: MtrListDataFactory(for Material List)</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Mos
 * @version 1.0
 */

public class MtrListDataFactory implements PagedDataFactory {
  private java.util.HashMap condition = null;

  public MtrListDataFactory(java.util.HashMap hm) {
    condition = hm;
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    return exgui2.CONST.Material_EJB.getRecords(startPosition, rowCounts, condition);
  }
  public void deleteRecord(Record rec2delete) throws Exception {
    exgui2.CONST.Material_EJB.deleteRecord(rec2delete);
  }
  public void restoreRecord(Record rec2restore) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method restoreRecord() not yet implemented.");
  }
  public Record addRecord(Record rec2add) throws Exception {
    exgui2.CONST.Material_EJB.insertRecord(rec2add);
    return rec2add;
  }
  public Record getBlankRecord() throws Exception {
    return exgui2.CONST.Material_EJB.getBlankRecord();
  }
  public void updateRecords(Vector recs2update) throws Exception {
    exgui2.CONST.Material_EJB.updateRecords(recs2update);
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}