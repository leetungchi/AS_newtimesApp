package newtimes.basic.division;

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

public class DivisionAbsTable extends AbstractUltraTablePanel {
  DivisionDataFactory divDataSrc = null;
  static final String DIV_CODE = "Code";
  static final String DIV_NAME = "Division Name               ";
  static final String BYMKR_BRIEF = "Buyer              ";
  static final String DIV_WEIGHT = "Weight";
  static final String DIV_COMM = "   COMMISSION   ";

  public DivisionAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(DIV_CODE, "DIV_CODE");
      headHm.put(DIV_NAME, "DIV_NAME");
      headHm.put(BYMKR_BRIEF, "BYMKR_BRIEF");
      headHm.put(DIV_WEIGHT, "DIV_WEIGHT");
      headHm.put(DIV_COMM, "buy_comm");
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
    if(this.divDataSrc != null) return this.divDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    DivisionDataFactory _divDataSrc = new DivisionDataFactory(hm);
    this.divDataSrc = _divDataSrc;
    return divDataSrc;
  }
  public DivisionDataFactory getMyPagedDataFxy(){
    return (DivisionDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
