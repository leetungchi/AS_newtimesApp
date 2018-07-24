package newtimes.reports.report01.quotacontrol;

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

public class QuotaTableEditor extends PnlTableEditor {
  static final String CNTY = "Country   ";
  static final String QTA_AREA = "Quota Area";
  static final String QTA_CAT = "Quota CAT";
  static final String PERCENT = "%";
  static final String REMARK = "Remark                    ";
  static InsertionOrderedHashMap iso = null;
  static Hashtable obj2StrConv = null;

  public QuotaTableEditor() {
    super.firstPage();
    getJtable().setRowHeight(20);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try {
      switch(columnAt) {
        case 0:
          rec.set("QTEM_CNTY_NAME", value2update);
          return rec;
        case 1:
          rec.set("QTEM_AREA", value2update);
          return rec;
        case 2:
          rec.set("QTEM_CAT", value2update);
          return rec;
        case 3:
          rec.set("QTEM_PERCENT", value2update);
          return rec;
      }
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set record data."+
                                 "\nRecord Data:"+rec.toString());
    }
    return rec;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(CNTY, "QTEM_CNTY_NAME");
      iso.put(QTA_AREA, "QTEM_AREA");
      iso.put(QTA_CAT, "QTEM_CAT");
      iso.put(PERCENT, "QTEM_PERCENT");
      iso.put(REMARK, "QTA_REMARK");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try {
      multiEditorJTableInSuper.addJComboBox(0, QuotaQueryGUI.vDataCnty, "CNTY_NAME", "CNTY_NAME");
      multiEditorJTableInSuper.addJComboBox(1, exgui2.Stuff.QUOTA_AREA, true);
      multiEditorJTableInSuper.addJComboBox(2, QuotaQueryGUI.vDataCat, "QTA_CAT", "QTA_CAT");
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set JComboBox.");
    }
  }
  protected int getEachPageRowCount() {
    return 10;
  }
  protected Hashtable getObject2StringConvertor() {
    try {
      obj2StrConv = new java.util.Hashtable();
      Object formatPercent = exgui.verification.CellFormat.getDoubleFormatAllowNull(3, 2);
      obj2StrConv.put(PERCENT, formatPercent);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at checked format type.");
    }
    return obj2StrConv;
  }
  protected PagedDataFactory getPagedDataFactory() {
    QuotaTableDataFactory detailSrc = QuotaTableDataFactory.getInstance();
    return detailSrc;
  }

  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt,rowCount,need2UpdateXntPage);
    setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
  }
}