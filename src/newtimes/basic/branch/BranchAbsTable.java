package newtimes.basic.branch;

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

public class BranchAbsTable extends AbstractUltraTablePanel {
  BranchDataFactory branchDataSrc = null;
  static final String BRNCH_BRIEF = "Branch Brief       ";
  static final String BRNCH_NAME = "Branch Name                              ";
  static final String BRNCH_CENTERS="            CENTERS               ";
  static public java.util.HashMap hmlistCenters=null;
  public BranchAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(BRNCH_BRIEF, "BRNCH_BRIEF");
      headHm.put(BRNCH_NAME, "BRNCH_NAME");
      headHm.put(BRNCH_CENTERS, "BRNCH_CEN_CODE");
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
     java.util.Hashtable ht=new java.util.Hashtable();
     ht.put(BRNCH_CENTERS,new CenterStringConv());
     return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.branchDataSrc != null) return this.branchDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    BranchDataFactory _branchDataSrc = new BranchDataFactory(hm);
    this.branchDataSrc = _branchDataSrc;
    return branchDataSrc;
  }
  public BranchDataFactory getMyPagedDataFxy(){
    return (BranchDataFactory)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  class CenterStringConv implements exgui.Object2String{
   public  String Obj2String(Object obj){
     if(obj==null)return "";
     String str[]=util.MiscFunc.split(obj.toString(),",,");
     StringBuffer sb=new StringBuffer();
     for(int i=0;i<str.length;i++){
       if(sb.length()>0)sb.append(",");
       sb.append(hmlistCenters.get(util.MiscFunc.Replace(str[i],",","")));
     }
     return sb.toString();
    }
  }

  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
  }
}
