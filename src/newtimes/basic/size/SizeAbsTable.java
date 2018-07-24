package newtimes.basic.size;

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

public class SizeAbsTable extends AbstractUltraTablePanel {
  SizeDataFactory sizeDataSrc = null;
  static final String  SIZE_CODE = "SIZE CODE";
  static final String  SIZE1 = "1";
  static final String  SIZE2 = "2";
  static final String  SIZE3 = "3";
  static final String  SIZE4 = "4";
  static final String  SIZE5 = "5";
  static final String  SIZE6 = "6";
  static final String  SIZE7 = "7";
  static final String  SIZE8 = "8";
  static final String  SIZE9 = "9";
  static final String  SIZE10 = "10";
  static final String  SIZE11 = "11";
  static final String  SIZE12 = "12";
  static final String  SIZE13 = "13";
  static final String  SIZE14 = "14";
  static final String  SIZE15 = "15";
  static final String  SIZE16 = "16";
  static final String  SIZE17 = "17";
  static final String  SIZE18 = "18";
  static final String  SIZE19 = "19";
  static final String  SIZE20 = "20";
  static final String  SIZE21 = "21";
  static final String  SIZE22 = "22";
  static final String  SIZE23 = "23";
  static final String  SIZE24 = "24";

  public SizeAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(SIZE_CODE, "SIZE_CODE");
      headHm.put(SIZE1, "SIZE1");
      headHm.put(SIZE2, "SIZE2");
      headHm.put(SIZE3, "SIZE3");
      headHm.put(SIZE4, "SIZE4");
      headHm.put(SIZE5, "SIZE5");
      headHm.put(SIZE6, "SIZE6");
      headHm.put(SIZE7, "SIZE7");
      headHm.put(SIZE8, "SIZE8");
      headHm.put(SIZE9, "SIZE9");
      headHm.put(SIZE10, "SIZE10");
      headHm.put(SIZE11, "SIZE11");
      headHm.put(SIZE12, "SIZE12");
      headHm.put(SIZE13, "SIZE13");
      headHm.put(SIZE14, "SIZE14");
      headHm.put(SIZE15, "SIZE15");
      headHm.put(SIZE16, "SIZE16");
      headHm.put(SIZE17, "SIZE17");
      headHm.put(SIZE18, "SIZE18");
      headHm.put(SIZE19, "SIZE19");
      headHm.put(SIZE20, "SIZE20");
      headHm.put(SIZE21, "SIZE21");
      headHm.put(SIZE22, "SIZE22");
      headHm.put(SIZE23, "SIZE23");
      headHm.put(SIZE24, "SIZE24");
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
    if(this.sizeDataSrc != null) return this.sizeDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    SizeDataFactory _sizeDataSrc = new SizeDataFactory(hm);
    this.sizeDataSrc = _sizeDataSrc;
    return sizeDataSrc;
  }
  public SizeDataFactory getMyPagedDataFxy(){
    return (SizeDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}