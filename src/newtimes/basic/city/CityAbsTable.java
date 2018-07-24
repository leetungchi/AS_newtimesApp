package newtimes.basic.city;

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

public class CityAbsTable extends AbstractUltraTablePanel {
  CityDataFactory cityDataSrc = null;
  static final String CNTY_NAME = "Country    ";
  static final String CITY_NAME = "City Name  ";
  static final String CITY_CHINESE_NAME = "Chinese\nName";
  static final String CITY_AREA_NAME="Area Name";
  static final String CITY_AREA_CHN_NAME="Area \nChinese Name";
  static final String CITY_SELECTABLE_CENTER="                                CENTER                               ";
  static public java.util.HashMap hmlistCenters=null;
  public CityAbsTable() {
    super();
    firstPage();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(CNTY_NAME, "CNTY_NAME");
      headHm.put(CITY_NAME, "CITY_NAME");
      headHm.put(CITY_CHINESE_NAME, "CITY_CHINESE_NAME");
      headHm.put(CITY_AREA_NAME, "AREA_NAME");
      headHm.put(CITY_AREA_CHN_NAME, "AREA_CHN_NAME");
      headHm.put(CITY_SELECTABLE_CENTER, "SELECTABLE_CENTER");
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    java.util.Hashtable ht= new java.util.Hashtable() ;
    ht.put(CITY_SELECTABLE_CENTER,new CenterStringConv());
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.cityDataSrc != null) return this.cityDataSrc;
    java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("allData");
    CityDataFactory _cityDataSrc = new CityDataFactory(hm);
    this.cityDataSrc = _cityDataSrc;
    return cityDataSrc;
  }
  public CityDataFactory getMyPagedDataFxy(){
    return (CityDataFactory)dbHandler;
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
