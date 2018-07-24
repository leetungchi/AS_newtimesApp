package newtimes.basic.shipmark;

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

public class ShipmarkAbsTable extends AbstractUltraTablePanel {
  ShipmarkDataFactory shmkDataSrc = null;
  static final String SHIP_MARK_SEQ="No.";
  static final String BYMKR_BRIEF = "Buyer Brief";
  static final String BYMKR_NAME = "Buyer Name   ";
  static final String BYMKR_CHINESE_BRIEF = "Chinese Brief";
  static final String BYMKR_MASTER_COMPANY = "Master Company";
  static final String CNTY_NAME = "Country";

  public ShipmarkAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(SHIP_MARK_SEQ, "SHIPMARK_PK");
      headHm.put(BYMKR_BRIEF, "BYMKR_BRIEF");
      headHm.put(BYMKR_NAME, "BYMKR_NAME");
      headHm.put(BYMKR_CHINESE_BRIEF, "BYMKR_CHINESE_BRIEF");
      //headHm.put(BYMKR_MASTER_COMPANY, "BYMKR_MASTER_COMPANY");
      headHm.put(BYMKR_MASTER_COMPANY,"Master_Company");
      headHm.put(CNTY_NAME, "CNTY_NAME");
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 21;//20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.shmkDataSrc != null) return this.shmkDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    ShipmarkDataFactory _shmkDataSrc = new ShipmarkDataFactory(hm);
    this.shmkDataSrc = _shmkDataSrc;
    return shmkDataSrc;
  }
  public ShipmarkDataFactory getMyPagedDataFxy(){
    return (ShipmarkDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
