package newtimes.basic.systemvalue;

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

public class SysValueAbsTable extends AbstractUltraTablePanel {
  SysValueDataFactory sysDataSrc = null;
  static final String CENTER = "Center";
  static final String IC_NAME = "IC                            ";
  static final String LOCAL_CURRENCY_NAME = "Currency";
  static final String EXCHANGE_RATE = "Exchange";
  static final String FHA = "FHA";
  static final String SHIPCLOSEB4="     SHIP CLOSE      \nBEFORE";
  public SysValueAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(CENTER, "CEN_NAME");
      headHm.put(IC_NAME, "IC_NAME");
      headHm.put(LOCAL_CURRENCY_NAME, "LOCAL_CURRENCY_NAME");
      headHm.put(EXCHANGE_RATE, "EXCHANGE_RATE");
      headHm.put(FHA, "FHA");
      headHm.put(SHIPCLOSEB4, "SHIP_CLOSE_B4");
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
    if(this.sysDataSrc != null) return this.sysDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    SysValueDataFactory _sysDataSrc = new SysValueDataFactory(hm);
    this.sysDataSrc = _sysDataSrc;
    return sysDataSrc;
  }
  public SysValueDataFactory getMyPagedDataFxy(){
    return (SysValueDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
