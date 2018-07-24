package newtimes.bank;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Constants {
  public Constants() {
  }
  public static database.datatype.Record CURRENT_EDITING_BANK_HEAD_RECORD=null;
  public static database.datatype.Record CURRENT_EDITING_BANK_CHK_DTL_RECORD=null;
  public static final Vector vctCompany=new Vector();
  public static final Vector vctBank=new Vector();
  public static final java.util.HashMap HM_COMPANY_BANK_MAP=new java.util.HashMap();
  public static javax.swing.JPanel PNL4QRYHEAD=null,PNL4QRYBANKDTL=null;
  public static int BEGIN_POSITION_OF_BANK_HEAD_QRY=0;
  public static int BEGIN_POSITION_OF_BANK_CHK_DTL_QRY=0;
  //public final static HashMap hmCampyBank=new java.util.HashMap();
  static String sql=null;
  static Record blankBankRec=null;
  public static java.util.HashMap hmCheckDateMap=new java.util.HashMap();
  public static java.util.Vector VCT_PAYEE_ITEMS=null;
  public static java.util.Vector VCT_TYPE4USD=null;
  public static void updateBankCompanyData()throws Exception{
    java.util.Vector vctCompany=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
     util.PublicVariable.USER_RECORD,
     "select * from COMPANY4BANK",1,9999);
    Constants.vctCompany.clear();
    for(int i=0;i<vctCompany.size();i++){
       Constants.vctCompany.add(vctCompany.get(i));
    }


  java.util.Vector vctBanks=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
   util.PublicVariable.USER_RECORD,
   "select * from bank",1,9999);
    Constants.vctBank.clear();
    for(int i=0;i<vctBanks.size();i++){
      Constants.vctBank.add(vctBanks.get(i));
    }

  }
  public static void updateMapOfCampanyBank()throws Exception{
    HM_COMPANY_BANK_MAP.clear();
    if(sql==null){
      StringBuffer sb=new StringBuffer();
      sb.append("select a.comp_id,a.bank_id,b.BANK_NAME,a.CHK_DD ");
      sb.append("from bank_head a , bank b ") ;
      sb.append("where a.BANK_ID=b.BANK_CODE ");
      sb.append("order by comp_id");
      sql=sb.toString();
      blankBankRec=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("BANK_tbl");
    }
      java.util.Vector vctCompBank=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sql,1,999999);
      String lastStrCompId=null;
      Vector vct2Add=null;
      hmCheckDateMap.clear();
      for(int i=0;i<vctCompBank.size();i++){
        Record recTmp=(Record)vctCompBank.get(i);
        Record recBank=(Record)util.MiscFunc.deepCopy(blankBankRec);
        recBank.set(0,recTmp.get(1));
        recBank.set(1,recTmp.get(2));
          //System.out.println("key is "+recTmp.get(0)+"_"+recTmp.get(1));
          hmCheckDateMap.put(
           recTmp.get(0)+"_"+recTmp.get(1),
           recTmp.get(3)
          );
          //System.out.println("date is :"+hmCheckDateMap.get(recTmp.get(0)+"_"+recTmp.get(1)));
        if(!recTmp.get(0).equals(lastStrCompId)){
          lastStrCompId=recTmp.get(0).toString();
          vct2Add=new Vector();
          HM_COMPANY_BANK_MAP.put(lastStrCompId,vct2Add);
        }
        vct2Add.add(recBank);
      }
  }
}
