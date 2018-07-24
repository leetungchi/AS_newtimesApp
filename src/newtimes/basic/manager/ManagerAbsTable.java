package newtimes.basic.manager;

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

public class ManagerAbsTable extends AbstractUltraTablePanel {
  ManagerDataFactory magDataSrc = null;
  static final String CEN_NAME = "Center       ";
  static final String DEP_NAME = "Department        ";
  static final String MNG_CODE = "Manager Code  ";
  static final String MNG_ABBR = "Manager      ";

  public ManagerAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(CEN_NAME, "CEN_NAME");
      headHm.put(DEP_NAME, "DEP_NAME");
      headHm.put(MNG_CODE, "MNG_CODE");
      headHm.put(MNG_ABBR, "MNG_ABBR");
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
    if(this.magDataSrc != null) return this.magDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    ManagerDataFactory _magDataSrc = new ManagerDataFactory(hm);
    this.magDataSrc = _magDataSrc;
    return magDataSrc;
  }
  public ManagerDataFactory getMyPagedDataFxy(){
    return (ManagerDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}