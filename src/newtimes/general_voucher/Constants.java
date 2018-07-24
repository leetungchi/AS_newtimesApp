package newtimes.general_voucher;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import database.datatype.Record;
import java.util.*;
public class Constants {
  public  static Hashtable HT_ACC_ITEM=null;
  public  static Hashtable HT_ACC_COMPANY=null;
  public  static PnlAccDataMaintainQry PNL_ACC_MAINTAIN_QRY;
  public static String COMPAY_TOOL_TIPS=null;
  public static Vector VCT_ACC_ITEM=null;
  public Constants() {
  }
 public static String getCompayToolTips(){
    if(COMPAY_TOOL_TIPS!=null)return COMPAY_TOOL_TIPS;
    StringBuffer sb=new StringBuffer();
    java.util.Iterator  itr=Constants.HT_ACC_COMPANY.keySet().iterator()   ;
    while(itr.hasNext()){
      if(sb.length()>0){sb.append("<br>");}
      String key=(String)itr.next();
      //System.out.println("KEY is  "+key);
      database.datatype.Record rec=(database.datatype.Record)Constants.HT_ACC_COMPANY.get(key);
      //System.out.println("rec is "+rec.toString());
      sb.append(key.substring(key.length()-1,key.length()));
      sb.append(":");
      sb.append((rec.get(11)==null)?"N/A":rec.get(11).toString());
    }

    COMPAY_TOOL_TIPS= "<html><body>"+sb.toString()+"</body></html>";
    return COMPAY_TOOL_TIPS;
  }
  public static String getBalanceSQL(String gv_acc_item_as_code,
                              String gv_acc_data_as_code,
                              String as_field_name ){
    StringBuffer sb=new StringBuffer();
    sb.append("decode ((select ####b####.d_c from gv_acc_item ####b#### where substr(####a####.ACC_CODE,1,4)=####b####.item_code),");
    sb.append("'C',(nvl(####a####.INIT_AMT,0)+nvl(####a####.C_AMT,0)-nvl(####a####.D_AMT,0)),");
    sb.append("'D',(nvl(####a####.INIT_AMT,0)-nvl(####a####.C_AMT,0)+nvl(####a####.D_AMT,0)),");
    sb.append("-9999)");
    sb.append(" as ");
    sb.append(as_field_name);
    String afterReplaceAccItem=util.MiscFunc.Replace(sb.toString(),"####b####",gv_acc_item_as_code,false);
    afterReplaceAccItem=util.MiscFunc.Replace(afterReplaceAccItem,"####a####",gv_acc_data_as_code,false);
    return afterReplaceAccItem;
  }
  public static void initMaps(){
    COMPAY_TOOL_TIPS=null;
    try{
      util.MiscFunc.showProcessingMessage();
      if(null==HT_ACC_ITEM){
       VCT_ACC_ITEM=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from GV_ACC_ITEM where record_delete_flag='1'",1,999);
         HT_ACC_ITEM=new Hashtable();
        for(int i=0;i<VCT_ACC_ITEM.size();i++){
           Record recAccItem=(Record)VCT_ACC_ITEM.get(i);
          HT_ACC_ITEM.put(recAccItem.get(1),recAccItem);
        }
      }

      if(null==HT_ACC_COMPANY){
        Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from TPE_DATE_RANGE where record_delete_flag='1' and CEN_CODE='"+ util.PublicVariable.OPERATTING_CENTER + "' and FIELD_NAME LIKE 'GV_COMP_%' ",1,999);
         HT_ACC_COMPANY=new Hashtable();
        for(int i=0;i<vct.size();i++){
           Record recAccComp=(Record)vct.get(i);
          HT_ACC_COMPANY.put(recAccComp.get(0),recAccComp);
        }
      }


    }catch(Exception exp){
      exp.printStackTrace() ;
      util.ExceptionLog.exp2File(exp,"");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}
