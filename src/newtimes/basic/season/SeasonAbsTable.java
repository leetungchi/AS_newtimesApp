package newtimes.basic.season;

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

public class SeasonAbsTable extends AbstractUltraTablePanel {
  SeasonDataFactory seasonDataSrc = null;
  static final String SEA_WEIGHT = "Weight";
  static final String SEA_NAME = "Season Name                  ";
  //static final String SEA_YEAR = "Year";
  //static final String BYMKR_BRIEF = "Buyer              ";

  public SeasonAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(SEA_WEIGHT, "SEA_WEIGHT");
      headHm.put(SEA_NAME, "SEA_NAME");
      //headHm.put(SEA_YEAR, "SEA_YEAR");
      //headHm.put(BYMKR_BRIEF, "BYMKR_BRIEF");
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
    if(this.seasonDataSrc != null) return this.seasonDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    SeasonDataFactory _seasonDataSrc = new SeasonDataFactory(hm);
    this.seasonDataSrc = _seasonDataSrc;
    return seasonDataSrc;
  }
  public SeasonDataFactory getMyPagedDataFxy(){
    return (SeasonDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}