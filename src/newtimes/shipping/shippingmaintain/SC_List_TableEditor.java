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

public class SC_List_TableEditor extends PnlTableEditor {
  SC_List_DataFactoryAdapter scListDataSrc = null;
  static final String FTY = "FTY       ";
  static final String DIV = "Division        ";
  static final String SEA = "Season ";
  static final String YEAR = "Year";
  static final String RANGE = "Range";
  static final String SC_NO = "S/C NO.     ";
  static InsertionOrderedHashMap iso = null;

  public SC_List_TableEditor() {
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
      iso.put(FTY, "FTY");
      iso.put(DIV, "DIV");
      iso.put(SEA, "SEA");
      iso.put(YEAR, "YEAR");
      iso.put(RANGE, "RANGE");
      iso.put(SC_NO, "SC_NO");
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
    SC_List_DataFactoryAdapter detailSrc =
            SC_List_DataFactoryAdapter.getInstance();
    return detailSrc;
  }
}