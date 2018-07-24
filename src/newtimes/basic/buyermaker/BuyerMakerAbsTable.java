package newtimes.basic.buyermaker;

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

public class BuyerMakerAbsTable extends AbstractUltraTablePanel {
  BuyerMakerDataFactory bmDataSrc = null;
  static final String BYMKR_TYPE = "Type";
  static final String BYMKR_BRIEF = "      Brief         ";
  static final String BYMKR_NAME = "              Name                  ";
  static final String BYMKR_CHINESE_BRIEF = "Chinese\nBrief";
  static final String BYMKR_MASTER_COMPANY = "       Master  \n  Co.     ";
  static final String BYMKR_CNTY_CODE = " Country  ";
  static final String BYMKR_COMM="  COMMISSION  ";
  static final String BYMKR_CENTERS="               CENTER            ";
  static public java.util.HashMap  hmlistCenters=null;
  public BuyerMakerAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      //headHm.put(BYMKR_TYPE, "TYPE");
      headHm.put(BYMKR_BRIEF, "BYMKR_BRIEF");
      headHm.put(BYMKR_NAME, "BYMKR_NAME");
      headHm.put(BYMKR_CHINESE_BRIEF, "BYMKR_CHINESE_BRIEF");
      headHm.put(BYMKR_MASTER_COMPANY, "MASTER_CO");
      headHm.put(BYMKR_CNTY_CODE, "BYMKR_CNTY_CODE");
      headHm.put(BYMKR_COMM, "BUY_COMM");
      headHm.put(BYMKR_CENTERS,"selectable_center");
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
     ht.put(BYMKR_CENTERS,new CenterStringConv());
     return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.bmDataSrc != null) return this.bmDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    BuyerMakerDataFactory _bmDataSrc = new BuyerMakerDataFactory(hm);
    this.bmDataSrc = _bmDataSrc;
    return bmDataSrc;
  }
  public BuyerMakerAbsTable getMyPagedDataFxy(){
    return (BuyerMakerAbsTable)dbHandler;
  }
  public PagedDataFactory getDataHandler(){
    return super.dbHandler;
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
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

}
