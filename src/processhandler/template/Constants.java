package processhandler.template;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Constants {
  public static String CMD_INIT_APP_GUI=null;
  public static String CMD_PROC_TEMP1=null;
  public static String XNT_LIST_QRY_RESLUT_BGN_AT="XNT_LIST_QRY_RESLUT_BGN_AT";
  public static String RECORD_CURRENTLY_EDITTING="RECORD_CURRENTLY_EDITTING";
  public static String SELECTED_DETAIL_TAB_INDEX="SELECTED_DETAIL_TAB_INDEX";
  public static String SELECTED_DETAIL_TAB_COMPONENT="SELECTED_DETAIL_TAB_COMPONENT";
  public Constants() {
    CMD_INIT_APP_GUI=this.getClass().getName()+".CMD_INI_APP_GUI";
    CMD_PROC_TEMP1 =this.getClass().getName()+".CMD_PROC_TEMP1";
  }
}