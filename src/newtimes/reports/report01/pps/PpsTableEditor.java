package newtimes.reports.report01.pps;

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

public class PpsTableEditor extends PnlTableEditor {
  static final String CLOSE = "Close /\nUn-Close";
  static final String FTY = " \nFTY";
  static final String DIV = " \nDivision";
  static final String SEA = " \nSeason";
  static final String YEAR = " \nYear";
  static final String RANGE = " \nRange";
  static final String GRP = " \nGRP NO.";
  static final String PO = " \nPO";
  static final String STYLE = " \nStyle";
  static final String REJECT = " \nReject";
  static final String APRV = " \nAPRV";
  static final String TARGET = " \nTarget";
  static final String DEL = "Reconfirm\nDEL";
  static final String W1 = " \nW";
  static final String UPDATE = "Weekly\nUpdate";
  static final String W2 = " \nW";
  static InsertionOrderedHashMap iso = null;


  public PpsTableEditor() {
    super.firstPage();
    getJtable().setRowHeight(20);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(CLOSE, "STY_PPS_CLOSE");
      iso.put(FTY, "FTY");
      iso.put(DIV, "DIV");
      iso.put(SEA, "SEASON");
      iso.put(YEAR, "YEAR");
      iso.put(RANGE, "RANGE");
      iso.put(GRP, "GROUP_NO");
      iso.put(PO, "STY_PO");
      iso.put(STYLE, "STY_STYLE");
      iso.put(REJECT, "PPS_STATUS_REJECT_DATE");
      iso.put(APRV, "STY_PPS_APPROVAL_DATE");
      iso.put(TARGET, "LOCKIN_STYLE_PPS_TARGET_DATE");
      iso.put(DEL, "RECFM_DEL");
      iso.put(W1, "STY_RECFM_SHIP");
      iso.put(UPDATE, "UPDATE_DEL");
      iso.put(W2, "STY_UPDT_SHIP");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.addCheckbox(0, "");
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    PpsTableDataFactory detailSrc = PpsTableDataFactory.getInstance();
    return detailSrc;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt,rowCount,need2UpdateXntPage);
    PpsListGUI.setCheckRecord2JTable(rowStartAt);
  }
}