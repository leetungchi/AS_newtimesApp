package newtimes.shipping.shippingmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class AddDetailListDataTableEditor extends PnlTableEditor {
  AddDetailListDataFactoryAdapter listDataSrc = null;
  static final String BUYER="Buyer";
  static final String FTY = "Maker";
  //static final String DIV = "Division";
  //static final String SEA = "Season";
  //static final String YEAR = "Year";
  //static final String RANGE = "Range";
  static final String SC_NO = "S/C NO. ";
  static final String STYLE = "Style";
  static final String PO = "PO";
  static final String UNIT = "Unit";
  static final String O_QTY = "O_QTY";
  static final String S_QTY = "S_QTY";
  static final String B_QTY = "B_QTY";
  static final String CLOSE="CLOSE";
  static InsertionOrderedHashMap iso = null;

  public AddDetailListDataTableEditor() {
    super.firstPage();
    getJtable().setRowHeight(20);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(BUYER,"BUYER");
      iso.put(FTY, "FTY");
      //iso.put(DIV, "DIV");
      //iso.put(SEA, "SEA");
      //iso.put(YEAR, "YEAR");
      //iso.put(RANGE, "RANGE");
      iso.put(SC_NO, "SC_NO");
      iso.put(STYLE, "STYLE");
      iso.put(PO, "PO");
      iso.put(UNIT, "UNIT");
      iso.put(O_QTY, "O_QTY");
      iso.put(S_QTY, "S_QTY");
      iso.put(B_QTY, "B_QTY");
      iso.put(CLOSE,"CLOSED");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
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
    AddDetailListDataFactoryAdapter detailSrc =
        AddDetailListDataFactoryAdapter.getInstance();
    return detailSrc;
  }
//  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
//    super.goPage(rowStartAt,rowCount,need2UpdateXntPage);
//    reload();
//  }
}
