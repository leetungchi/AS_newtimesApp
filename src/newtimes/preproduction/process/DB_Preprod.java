package newtimes.preproduction.process;
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

public class DB_Preprod implements exgui.ultratable.PagedDataFactory {
  protected static DB_Preprod instanceOfMe;
  protected HashMap conditions=new HashMap();
  protected static newtimesejb.preproduction.PreProductionHead ejb;
  protected static boolean initOK;
  protected database.datatype.Record recBlank=null;
  protected Vector orgQryResult=null;
  protected Vector joinedQryResult=null;
  protected final boolean STATUS_RESTORE=true;
  protected final boolean STATUS_NORMAL=false;
  protected boolean opStatus;
  protected Vector tempMTR_V_Records=new Vector();
  protected DB_Preprod() {
    try{
      opStatus=STATUS_NORMAL;
      newtimesejb.preproduction.PreProductionHeadHome qryHm = (newtimesejb.
          preproduction.PreProductionHeadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.preproduction.PreProductionHead"
          );
      ejb = qryHm.create();
      /*
      //save to file to test if the stub is what we expected
          java.io.ObjectOutputStream oos = null;
         //java.io.ByteArrayOutputStream bos =    new java.io.ByteArrayOutputStream();
         java.io.FileOutputStream fos=new java.io.FileOutputStream("d:/PreProduction_stub.class");
         oos = new java.io.ObjectOutputStream(fos); // B
         oos.writeObject(ejb);   // C
         oos.flush();               // D
         fos.flush();
         fos.close();


         oos = null;
        //java.io.ByteArrayOutputStream bos =    new java.io.ByteArrayOutputStream();
         fos=new java.io.FileOutputStream("d:/PreProduction_HOME_stub.class");
        oos = new java.io.ObjectOutputStream(fos); // B
        oos.writeObject(qryHm);   // C
        oos.flush();               // D
        fos.flush();
        fos.close();
       */


      recBlank=ejb.getBlankRecord();
      recBlank.set("PROD_OFFSHORE_CENTER",
          util.PublicVariable.USER_RECORD.get("USR_CEN_CODE"));
      recBlank.set("PROD_YEAR",newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get("current_year"));
      initOK=true;
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "server conection fail.pleaes notify the system manager",
          "EJB creation fail");
      util.ExceptionLog.exp2File(e,"EJB creation fail");
      initOK=false;
    }
  }
  public static DB_Preprod getInstance(){
    if(!initOK||instanceOfMe==null)instanceOfMe= new DB_Preprod();
    return instanceOfMe;
  }
  public Vector listSimpleShippingData(int bgn,int rowcount)throws Exception{
    Vector vct=ejb.getShippingListOfAProdction(
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
      bgn,rowcount);
    return vct;
  }
  //this function should be called before insert/update a preprod/prodhead record.
  public void setMTR_V_Records(Vector records){
    tempMTR_V_Records=records;
  }
  public void setStatus(boolean isToRestore){
    opStatus=isToRestore;
  }
  public void setQueryConditions(java.util.HashMap _conditions){
     conditions=_conditions;
  }
  public Record findbyPk(int seq)throws Exception{
   return ejb.findByPk(seq);
  }
  public boolean listforRestore(){return opStatus;}
  public void updateRecords(Vector rec2update)throws Exception{
    for(int i=0;i<rec2update.size();i++){
      Record rec=(Record)rec2update.get(i);
      rec2update.set(i,addRecord(rec));
    }
  }
  public Record getBlankRecord(){
    try{
      Record recNewRec=(Record)util.MiscFunc.deepCopy(recBlank);
      recNewRec.set("PRODUCTION_byr_sc_issue",
                    new java.sql.Date(System.currentTimeMillis()));
      if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
        //s/c payment term is "T/T",Good Dest is "PANAMA",Term Dest. " Colon Free Zone"
        recNewRec.set("PRODUCTION_SC_DEST","COLON FREE ZONE");
        recNewRec.set("PRODUCTION_TGT_DEST","PANAMA");
        recNewRec.set("PRODUCTION_PYT_TRM","D/P AT SIGHT");//happy new year(2008),happy Taiwan
      }
      return recNewRec;
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"");
      return null;
    }
  }
  //this function should be called while listing material detail record to gui combobox.
  public Vector getCorespondingMtrlDtlRecords(int seq) throws Exception{
    tempMTR_V_Records.clear();
    tempMTR_V_Records.addAll(ejb.getMTR_V_Detail_Records(seq));
    return tempMTR_V_Records;
  }
  public Record addRecord(Record rec2add) throws Exception{
    String userID=(String)util.PublicVariable.USER_RECORD.get("usr_code");
    rec2add.set("record_modify_user",userID);
    rec2add=ejb.handlePreproductionAndHead(rec2add,tempMTR_V_Records);
    return rec2add;
  }
  public void deleteForFailureProductionDuplication(int new_prod_seq)throws Exception{
    ejb.deleteForDuplicationProcess(new_prod_seq,util.PublicVariable.USER_RECORD);
  }
  public void restoreRecord(Record rec2Restore)throws Exception{
    String userID=(String)util.PublicVariable.USER_RECORD.get("usr_code");
    rec2Restore.set("record_modify_user",userID);
    rec2Restore.set("record_delete_flag","1");
    ejb.restoreRecord(rec2Restore);
  }
  public void deleteRecord(Record rec2Del)throws Exception{
    String userID=(String)util.PublicVariable.USER_RECORD.get("usr_code");
    rec2Del.set("record_modify_user",userID);
    rec2Del.set("record_delete_flag","0");
    ejb.deleteRecord(rec2Del);
  }
  public Vector getRecords(int bgn,int len)throws Exception{
    //get attributes from ejb by this query....
     HashMap result=ejb.getRecordsWithJoinedData(conditions,bgn,len);
     orgQryResult=(Vector)result.get(ejb.RECORDS_QUERY_RESULT);
     java.util.HashMap hmProdHeadPkRec=null;
     boolean ifHaveCheckShipped=false;
     if(
      "001".equals(util.PublicVariable.OPERATTING_CENTER) &&
      (util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
       util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS)
        ){
         ifHaveCheckShipped=true;
     }
     StringBuffer sbListPk=new StringBuffer();
     //conbine datas
     for(int i=0;i<orgQryResult.size();i++){
       Record recTmp=(Record)orgQryResult.get(i);
       recTmp.getFieldName().add("DEP_YEAR_SEASON");
         Object objDep = recTmp.get("j_dep");
         Object objYear = recTmp.get("prod_year");
         Object objSea = recTmp.get("j_sea");
         String strDepYearSea = "";
         strDepYearSea += (objDep == null) ? " " : objDep.toString()+" ";
         strDepYearSea += (objYear == null) ? " " :objYear.toString()+" ";
         /*
         strDepYearSea += (objYear == null) ? " " :objYear.toString().substring(
                         objYear.toString().length()-2,objYear.toString().length()
                          )+" ";//2digit year required
         */
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
        if(ifHaveCheckShipped){
          if(sbListPk.length()>0)sbListPk.append(",");
          sbListPk.append(recTmp.get(0).toString());
          if(hmProdHeadPkRec==null)hmProdHeadPkRec=new java.util.HashMap();
          hmProdHeadPkRec.put(recTmp.get(0).toString(),String.valueOf(i));
          recTmp.getFieldName().add("PRODUCTION_AUDIT_STATUS");
          recTmp.getValueFields().add("-1");
        }

     }

     StringBuffer sql=new StringBuffer();
     sql.append("select ");
     sql.append("a.prod_head_pk ");
     sql.append("from style a ");
     sql.append("where ");
     sql.append("A.PROD_HEAD_PK in  (this_is_pk_list) ");
     sql.append("and  ");
     sql.append("(select count(*) from ship_style b  ");
     sql.append("where b.sty_seq=a.sty_seq  ");
     sql.append("and b.record_delete_flag='1'  ");
     sql.append("and a.record_delete_flag='1' )>0 ");
     sql.append("group by prod_head_pk ");
     if(sbListPk.length()>0){
       String sql2Run=util.MiscFunc.Replace(sql.toString() ,"this_is_pk_list",sbListPk.toString());
       Vector vctChkStatus=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sql2Run,
       1,999999);
       for(int i=0;i<vctChkStatus.size();i++){
         Record tmpChkAudit=(Record)vctChkStatus.get(i);
         Object vctIndex=hmProdHeadPkRec.get(tmpChkAudit.get(0).toString());
         if(vctIndex!=null){
           Record recOrg=(Record)orgQryResult.get(Integer.parseInt(vctIndex.toString()));
           recOrg.set("PRODUCTION_AUDIT_STATUS","7");
         }
       }
     }
     return orgQryResult;
  }
  public void setFabricCommisions(Vector vct,int prodSeq,String fabCmmRefNo)throws Exception{
    ((newtimesejb.preproduction.PreProductionHead)ejb).insertFabricCommisions(vct,prodSeq,fabCmmRefNo);
  }
  public Vector getUnJoinedRecords(){
    return orgQryResult;
  }
}
