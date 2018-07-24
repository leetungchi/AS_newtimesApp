package newtimes.material;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MtrDtlListAbsPanel extends AbstractUltraTablePanel {
  private static String TT_MillName    = "Mill Name";
  private static String TT_Mill_MTR_NO = "Mill\nMTR-NO";
  private static String TT_USD         = "USD";
  private static String TT_Local       = "Local";
  private static String TT_DupsMIN     = "DUPS\nMINQTY";
  private static String TT_DupsLEAD    = "DUPS\nLeadtime\n(days)";
  private static String TT_BulkMIN     = "BULK\nMINQTY";
  private static String TT_BulkLEAD    = "BULK\nLeadtime\n(days)";

  private newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_LIST= null;
  private newtimes.material.CONST.MTRDTL.EJB MTRDTL_EJB=null;
  private newtimes.material.CONST.COMMON COMMON=null;
  private MtrDtlDataFactory mtrDtlDataSrc = null;
  static int hmNull = 0;

  public MtrDtlListAbsPanel() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
    headHm.put(TT_MillName,    MTRDTL_EJB.BYMKR_BRIEF);//modified by Chloe
    headHm.put(TT_Mill_MTR_NO, MTRDTL_EJB.MILL_NO);
    headHm.put(TT_USD,         MTRDTL_EJB.PRX_USD);
    headHm.put(TT_Local,       MTRDTL_EJB.PRX_LOCAL);
    headHm.put(TT_DupsMIN,     MTRDTL_EJB.DUPS_MINQTY);
    headHm.put(TT_DupsLEAD,    MTRDTL_EJB.DUPS_LEADTIME);
    headHm.put(TT_BulkMIN,     MTRDTL_EJB.BULK_MINQTY);
    headHm.put(TT_BulkLEAD,    MTRDTL_EJB.BULK_LEADTIME);
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 14;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.mtrDtlDataSrc != null) return this.mtrDtlDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties(MTRDTL_LIST.CONDITIONS);
    this.hmNull = hm == null ? 1 : 2;
    MtrDtlDataFactory _usrDataSrc = new MtrDtlDataFactory(hm);

    this.mtrDtlDataSrc = _usrDataSrc;
    return mtrDtlDataSrc;
  }
  //add by Chloe
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}