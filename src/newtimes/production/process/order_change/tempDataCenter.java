package newtimes.production.process.order_change;
import database.datatype.Record;
import java.util.*;
public class tempDataCenter {
  public static Record tempStoredChangeStyleData;
  public static Vector STORED_CHG_PRX_RECORDS;
  //to store jtable text data after udpate price
  //for qty to on-change to use.
  public static String str_arr_NEW_LXY_CLR_PRX_PRI_SEQ_data[];
  //character combined with "~|~"
  public static final String Splet4str_arr_NEW_PRI_SEQ_LXY_CLR_PRX_data="~|~";
  public static String orgQtyTable2Text="";
  public static Record ORIGINAL_STYLE_RECORD;
  public static Vector FinalChangedQtyRecords;
  public tempDataCenter() {
 }
}
