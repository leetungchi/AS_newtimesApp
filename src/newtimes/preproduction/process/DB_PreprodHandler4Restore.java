package newtimes.preproduction.process;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import database.datatype.*;
public class DB_PreprodHandler4Restore extends DB_Preprod {
 static protected DB_PreprodHandler4Restore instanceOfMe;
 newtimesejb.preproduction.Preprod4Restore myEjb;
  protected DB_PreprodHandler4Restore() {
    try{
      opStatus=STATUS_NORMAL;
      newtimesejb.preproduction.Preprod4RestoreHome  qryHm = (newtimesejb.
          preproduction.Preprod4RestoreHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.preproduction.Preprod4Restore"
          );
      myEjb = qryHm.create();
      recBlank=ejb.getBlankRecord();
      initOK=true;
      this.opStatus=this.STATUS_RESTORE;
    }catch(Exception e){
      exgui.verification.VerifyLib.showAlert(
          "server conection fail.pleaes notify the system manager",
          "EJB creation fail");
      util.ExceptionLog.exp2File(e,"EJB creation fail");
      initOK=false;
    }
  }
  public static DB_PreprodHandler4Restore getInstance4Restore(){
    if(!initOK||instanceOfMe==null)instanceOfMe= new DB_PreprodHandler4Restore();
    return instanceOfMe;
  }
  public Vector getRecords(int bgn,int len)throws Exception{
    //get attributes from ejb by this query....
   /*
    the initial sql for query is :
      select a.PROD_HEAD_PK,a.PROD_CEN_CODE,a.PROD_SEASON,a.PROD_DEPTMENT,a.PROD_YEAR,a.PROD_BUYER,
      a.PROD_BUYER_DIVISION,a.PROD_MAKER,a.PROD_GROUP,a.PROD_GROUP_NAME,a.PROD_RANGE
      ,b.*
      from prod_head a,preprod b
      where  a.PROD_HEAD_PK=b.PREPROD_PROD_PK and b.record_delete_flag='1'
    */
     HashMap result=myEjb.getRecordsWithJoinedData(conditions,bgn,len);
     orgQryResult=(Vector)result.get(ejb.RECORDS_QUERY_RESULT);
     for(int i=0;i<orgQryResult.size();i++){
       Record recTmp=(Record)orgQryResult.get(i);
       recTmp.getFieldName().add("DEP_YEAR_SEASON");
         Object objDep = recTmp.get("j_dep");
         Object objYear = recTmp.get("prod_year");
         Object objSea = recTmp.get("j_sea");
         String strDepYearSea = "";
         strDepYearSea += (objDep == null) ? " " : objDep.toString()+" ";
         strDepYearSea += (objYear == null) ? " " :objYear.toString().substring(
                         objYear.toString().length()-2,objYear.toString().length()
                          )+" ";//2digit year required
         strDepYearSea += (objSea == null) ? " " : objSea.toString();
       recTmp.getValueFields().add(strDepYearSea);
       recTmp.getFieldName().add("RANGE_SC_NO");
          Object objRng=recTmp.get("prod_range");
          Object objScNo=recTmp.get("sc_no");
          String range_Sc="";
          range_Sc+=(objRng==null)?" ":objRng.toString()+" ";
          range_Sc+=(objScNo==null)?" ":objScNo.toString();
       recTmp.getValueFields().add(range_Sc);
       recTmp.getFieldName().add("GroupDatas");
          Object objGrpNo=recTmp.get("prod_group");
          Object objGrpName=recTmp.get("prod_group_name");
          String grpDatas="";
            grpDatas+=(objGrpNo==null)?" ":objGrpNo.toString()+" ";
            grpDatas+=(objGrpName==null)?" ":objGrpName.toString();
        recTmp.getValueFields().add(grpDatas);
     }
     return orgQryResult;
  }

}
