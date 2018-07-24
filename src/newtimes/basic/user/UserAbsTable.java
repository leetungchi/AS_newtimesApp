package newtimes.basic.user;

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

public class UserAbsTable extends AbstractUltraTablePanel {
  UserDataFactory usrDataSrc = null;
  static final String CEN_NAME = "Center";
  static final String DEP_CODE = "Dep.\nCode";
  static final String DEP_NAME = "Dep.     ";
  static final String MNG_CODE = "Manager\nCode";
  static final String MNG_ABBR = "Manager   ";
  static final String USR_CODE = "User\nCode     ";
  static final String USR_NAME = "User     ";
  static final String Comm_Disc_RW_AUTH="COMM\nDISCT";

  public UserAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(CEN_NAME, "CEN_NAME");
      headHm.put(DEP_CODE, "DEP_CODE");
      headHm.put(DEP_NAME, "DEP_NAME");
      headHm.put(MNG_CODE, "MNG_CODE");
      headHm.put(MNG_ABBR, "MNG_ABBR");
      headHm.put(USR_CODE, "USR_CODE");
      headHm.put(USR_NAME, "USR_NAME");
      headHm.put(Comm_Disc_RW_AUTH, "EDIT_BYMKR_COMM_DISCOUNT");
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
    if(this.usrDataSrc != null) return this.usrDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    UserDataFactory _usrDataSrc = new UserDataFactory(hm);
    this.usrDataSrc = _usrDataSrc;
    return usrDataSrc;
  }
  public UserDataFactory getMyPagedDataFxy(){
    return (UserDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
