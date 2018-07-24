package newtimes.general_voucher.daily_voucher;
import java.util.*;
import database.datatype.*;
public class Constants {
  static public HashMap hmCompanyAndAccCodeTwName=null;
  static public String NO_SUCH_ACCOUNT_CODE="無此會計科目名稱";
  static public Vector VCT_GV_ACC_COMPANY=null;
  static public Vector VCT_STAFF=null;
  static exgui.ultratable.PagedDataFactory db2Handle=null;
  static database.datatype.Record  recSubSystem=null;
  static public Vector COMMON_TERMS=null;//from table "VH_CMN_TERM,the commonly used words to select

  //sometimes,inner objct edited,have to update to other columns of outter panel
  static PnlEditDailyVoucher Pnl_EditDaily_Voucher=null;
  //this reference is to keep for the Dialog to "back-update"
  static PnlTbl2EditDailyVoucher  Pnl_Tbl2EditDailyVoucher=null;
  static Hashtable HT_STAFF_ID_REC=null;

  public Constants() {
  }
  public static void adjFloat(final javax.swing.JTextField fld){
    String amt=fld.getText().trim();
    if(amt.trim().endsWith(".")){
      amt=amt.substring(0,amt.length()-1);
      fld.setText(amt);
    }
  }
  public static void initStaffVector(){
    try{
      VCT_STAFF=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       "select * from debitnote_user where cen_code='"+util.PublicVariable.OPERATTING_CENTER+"' order by USR_CODE"
       ,1,9999
       );
       HT_STAFF_ID_REC=new Hashtable();
       for(int i=0;i<VCT_STAFF.size();i++){
         Record recStaff=(Record)VCT_STAFF.get(i);
         HT_STAFF_ID_REC.put(recStaff.get(0),recStaff);
       }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error In listing staff records",
                                             "Error In listing staff records");
    }
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
  public static void initAccCodeNameMap(){
    try{
      newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome=
          (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.DailyVoucherFacade");
        newtimesejb.dailyVoucher.DailyVoucherFacade ejb=ejbHome.create();
        hmCompanyAndAccCodeTwName=ejb.getAccCodeMap((String)util.PublicVariable.USER_RECORD.get(0));
      /*
      StringBuffer sb=new StringBuffer();
      sb.append("select * from GV_ACC_DATA where comp is not null and ");
      sb.append(" CEN_CODE='");sb.append(util.PublicVariable.OPERATTING_CENTER);sb.append("'");
      sb.append(" and yyyymm is null  or yyyymm=999999");
      sb.append(" order by comp ");
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,sb.toString(),1,9999
       );
       hmCompanyAndAccCodeTwName=new HashMap();
       for(int i=0;i<vct.size();i++){
         //get name and zhTW name for mapping latter.
         Record rec=(Record)vct.get(i);
         String compCode=(String)rec.get(2);
         if(null==compCode)continue;
         HashMap hmSubMap=(HashMap)hmCompanyAndAccCodeTwName.get(compCode);
         if(null==hmSubMap)hmSubMap=new HashMap();
         hmSubMap.put(rec.get(4),rec.get(6));//acc code is key,REC-DESC is value.
         hmCompanyAndAccCodeTwName.put(compCode,hmSubMap);
       }
      */
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Error While Get Acc Code And Name Map\nPlease Contact System Manager"
                                              ,"Error While Get Acc Code And Name Map") ;
    }
  }

}
