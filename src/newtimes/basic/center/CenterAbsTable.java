package newtimes.basic.center;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CenterAbsTable extends AbstractUltraTablePanel {
  CenterDataFactory cenDataSrc = null;
  static final String CEN_CODE = "Center Code ";
  static final String CEN_NAME = "Center Name                             ";
  static final String CEN_WEIGHT = "Weight ";
  static final String CEN_REMARK = "Remark ";

  public CenterAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(CEN_CODE, "CEN_CODE");
      headHm.put(CEN_NAME, "CEN_NAME");
      headHm.put(CEN_WEIGHT, "CEN_WEIGHT");
      headHm.put(CEN_REMARK, "CEN_REMARK");
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.cenDataSrc != null) return this.cenDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    CenterDataFactory _cenDataSrc = new CenterDataFactory(hm);
    this.cenDataSrc = _cenDataSrc;
    return cenDataSrc;
  }
  public CenterDataFactory getMyPagedDataFxy(){
    return (CenterDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
