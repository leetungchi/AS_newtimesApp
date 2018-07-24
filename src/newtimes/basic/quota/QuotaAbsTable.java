package newtimes.basic.quota;

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

public class QuotaAbsTable extends AbstractUltraTablePanel {
  QuotaDataFactory qtaDataSrc = null;
  static final String  QTA_CAT = "Category";
  static final String  QTA_AREA = "Area-Code (U/C/E/I)";
  static final String  QTA_WEIGHT = "Weight";
  static final String  QTA_REMARK = "Remark                    ";

  public QuotaAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(QTA_CAT, "QTA_CAT");
      headHm.put(QTA_AREA, "QTA_AREA");
      headHm.put(QTA_WEIGHT, "QTA_WEIGHT");
      headHm.put(QTA_REMARK, "QTA_REMARK");
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
    if(this.qtaDataSrc != null) return this.qtaDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    QuotaDataFactory _qtaDataSrc = new QuotaDataFactory(hm);
    this.qtaDataSrc = _qtaDataSrc;
    return qtaDataSrc;
  }
  public QuotaDataFactory getMyPagedDataFxy(){
    return (QuotaDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}