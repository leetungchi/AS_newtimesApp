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

public class DelMtrListAbsPanel extends AbstractUltraTablePanel {
  private newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH= null;
  private newtimes.material.CONST.MTR.EJB MTR_EJB=null;
  private newtimes.material.CONST.COMMON COMMON=null;

  private MtrListDataFactory mtrDataSrc = null;

  //Legend: TT=Table Title
  private static String TT_MTR_NO = "MTR-NO";
  private static String TT_CREATE_USER = "Create User";
  private static String TT_CREATE_DATE = "Create Date";
  private static String TT_MTR_DEL_FLAG = "Master Deleted";
  private static String TT_DTL_DEL_FLAG = "Detail Deleted";

  public DelMtrListAbsPanel() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(TT_MTR_NO, MTR_EJB.NO);
      headHm.put(TT_CREATE_USER, COMMON.CREATE_USER);
      headHm.put(TT_CREATE_DATE, COMMON.CREATE_DATE);
      headHm.put(TT_MTR_DEL_FLAG, COMMON.DELETE_FLAG);
      headHm.put(TT_DTL_DEL_FLAG, MTR_EJB.DTL_DEL_CNT);
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.addCheckbox(3,"0");
    //multiEditorJTableInSuper.addCheckbox(4,"0");
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.mtrDataSrc != null) return this.mtrDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS);
    MtrListDataFactory _usrDataSrc = new MtrListDataFactory(hm);

    this.mtrDataSrc = _usrDataSrc;
    return mtrDataSrc;

  }

}