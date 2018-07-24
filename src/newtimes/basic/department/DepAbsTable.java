package newtimes.basic.department;

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

public class DepAbsTable extends AbstractUltraTablePanel {
  DepDataFactory depDataSrc = null;
  static final String CEN_NAME = "Center   ";
  static final String DEP_CODE = "Code ";
  static final String DEP_NAME = "Name             ";
  static final String DEP_ABBR = "Abbr  ";
  static final String DEP_DIRECTOR = "Director     ";
  static final String dep_allow_switch_user="Allow Switch Create user";

  public DepAbsTable() {
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
      headHm.put(DEP_CODE, "DEP_CODE");
      headHm.put(DEP_NAME, "DEP_NAME");
      headHm.put(DEP_ABBR, "DEP_ABBR");
      headHm.put(DEP_DIRECTOR, "DIRECTOR");
      //headHm.put(dep_allow_switch_user, "ALLOW_SWITCH_USER");
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
    if(this.depDataSrc != null) return this.depDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    DepDataFactory _depDataSrc = new DepDataFactory(hm);
    this.depDataSrc = _depDataSrc;
    return depDataSrc;
  }
  public DepDataFactory getMyPagedDataFxy(){
    return (DepDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
