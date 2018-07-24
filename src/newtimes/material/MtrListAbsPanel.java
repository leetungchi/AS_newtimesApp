package newtimes.material;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;
import javax.swing.JPanel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MtrListAbsPanel extends AbstractUltraTablePanel {
  //Constants
  private newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH= null;
  private newtimes.material.CONST.MTR.EJB MTR_EJB=null;
  private newtimes.material.CONST.COMMON COMMON=null;

  private MtrListDataFactory mtrDataSrc = null;

  //Legend: TT=Table Title
  private static String TT_MTR_NO =      "    Material No     ";
  private static String TT_MILL_NO =     "    Mill No         ";
  private static String TT_MILL_NAME =   "    Mill Name       ";
  private static String TT_CREATE_USER = "    Create User     ";
  private static String TT_CREATE_DATE = "    Create Date     ";

  JPanel parent = null;
  public MtrListAbsPanel(JPanel parent) {
    super();
    //firstPage();
    getJtable().setRowHeight(20);
    this.parent = parent;
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(TT_MTR_NO, MTR_EJB.NO);
      headHm.put(TT_MILL_NO, MTR_EJB.MILL_NO);
      headHm.put(TT_MILL_NAME, MTR_EJB.MILL_NAME);
      headHm.put(TT_CREATE_USER, COMMON.CREATE_USER);
      headHm.put(TT_CREATE_DATE, COMMON.CREATE_DATE);
    return headHm;

  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 19;
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

  protected void goPage(int rowStartAt,int rowCount,boolean need2UpdateXntPage){
    super.goPage(rowStartAt,rowCount,need2UpdateXntPage);
    if(parent instanceof MaterialShort){
      ((MaterialShort)parent).adjustEditBtn();
    }
  }

}
