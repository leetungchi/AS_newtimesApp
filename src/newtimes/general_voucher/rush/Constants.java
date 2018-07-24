package newtimes.general_voucher.rush;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Constants {
  static public Vector VCT_GV_ACC_COMPANY=null;
  static PnlQryAndMtnRush pnlQry=null;
  public Constants() {
  }
  public static void initCompanyList(){
    try{
     StringBuffer sb=new StringBuffer();
     sb.append("select substr(field_name,length(field_name),1) as cmp_code, ");
     sb.append("field_desc as cmp_name,");
     sb.append("substr(field_name,length(field_name),1)||'--'||field_desc  as comp_code_and_name ");
     sb.append(" from TPE_DATE_RANGE  ");
     sb.append("where record_delete_flag='1'  ");
     sb.append("and CEN_CODE='");sb.append(util.PublicVariable.OPERATTING_CENTER);sb.append("' ");
     sb.append("and FIELD_NAME LIKE 'GV_COMP_%' ");
      VCT_GV_ACC_COMPANY =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sb.toString(),1,9999);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error In Listing Companies\nPlease Contact System Manager",
                                             "Error In Listing Companies");
    }
  }


}
