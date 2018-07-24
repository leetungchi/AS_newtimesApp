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

public class DelMtrDtlListAbsPanel extends AbstractUltraTablePanel {
  private static String TT_RESTORE     = "RESTORE";
  private static String TT_MillName    = "Mill\nName";
  private static String TT_Mill_MTR_NO = "Mill\nMTR-NO";
  private static String TT_USD         = "USD";
  private static String TT_Local       = "Local";
  private static String TT_DupsMIN     = "DUPS\nMINQTY";
  private static String TT_DupsLEAD    = "DUPS\nLeadtime\n(days)";
  private static String TT_BulkMIN     = "BULK\nMINQTY";
  private static String TT_BulkLEAD    = "BULK\nLeadtime\n(days)";

  private MtrDtlDataFactory mtrDtlDataSrc = null;

  private newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_LIST= null;
  private newtimes.material.CONST.MTRDTL.EJB MTRDTL_EJB=null;
  private newtimes.material.CONST.COMMON COMMON=null;

  public DelMtrDtlListAbsPanel() {
    super();
    firstPage();
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      if(columnAt==0){
        String Column[] = getStoredRecordColumns();
        String value = value2update.toString();
        if(value.equals("true")){
          rec.set(Column[0], "1");
        }
        else if(value.equals("false")){
          rec.set(Column[0], "0");
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    finally{
      return rec;
    }
  }

  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
    headHm.put(TT_RESTORE,     COMMON.DELETE_FLAG);
    headHm.put(TT_MillName,    MTRDTL_EJB.BYMKR_BRIEF);
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
    multiEditorJTableInSuper.addCheckbox(0,"1");
  }
  protected int getEachPageRowCount() {
    return 8;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.mtrDtlDataSrc != null) return this.mtrDtlDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties(MTRDTL_LIST.DELELTED_CONDS);
    MtrDtlDataFactory _usrDataSrc = new MtrDtlDataFactory(hm);

    this.mtrDtlDataSrc = _usrDataSrc;
    return mtrDtlDataSrc;

  }

}