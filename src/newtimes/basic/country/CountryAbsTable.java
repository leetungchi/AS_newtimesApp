package newtimes.basic.country;

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

public class CountryAbsTable extends AbstractUltraTablePanel {
  CountryDataFactory countryDataSrc = null;
  static final String CNTY_NAME = "Country Name                                          ";
  static final String CNTY_WEIGHT = "Weight";
  static final String CNTY_CODE="CODE";
  public CountryAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(CNTY_NAME, "CNTY_NAME");
      headHm.put(CNTY_WEIGHT, "CNTY_WEIGHT");
      headHm.put(CNTY_CODE,"CNTY_CODE");
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
    if(this.countryDataSrc != null) return this.countryDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    CountryDataFactory _countryDataSrc = new CountryDataFactory(hm);
    this.countryDataSrc = _countryDataSrc;
    return countryDataSrc;
  }
  public CountryDataFactory getMyPagedDataFxy(){
    return (CountryDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
