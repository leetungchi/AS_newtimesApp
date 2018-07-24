package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_PlanQuota extends PagedDataFactoryAdapter {
  static DB_PlanQuota instanceOfMe=null;
  protected DB_PlanQuota() {
    try{
      newtimesejb.production.PlanQuotaFacadeHome  ejbHome=
          (newtimesejb.production.PlanQuotaFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,"newtimesejb.production.PlanQuotaFacade");
      super.ejb=ejbHome.create();
      super.blankRecord=ejb.getBlankRecord();
      //blankRecord.getFieldName().add("cat_data");
      //blankRecord.getFieldName().add(null);
      //System.out.println("org blankRecord is:"+blankRecord.toString());
      blankRecord.set("record_delete_flag","1");
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "EJB Creation Exception,please notify System manager","EJB Creation Exception"
      );
     instanceOfMe=null;
    }
  }
 public static DB_PlanQuota getInstanceOfPlanQuotaHandler(){
   if(instanceOfMe==null){
     instanceOfMe=new DB_PlanQuota();
   }
   return instanceOfMe;
 }
 public Record getBlankRecord()throws Exception{
   Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
   rec.set("plan_prod_head_pk",
                   newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);

   return rec;
 }
 public void updateRecords(java.util.Vector recs)throws Exception{
   ((newtimesejb.production.PlanQuotaFacade)ejb).updateRecords(
        recs,
        (String)util.PublicVariable.USER_RECORD.get("USR_CODE")
        );
 }
 public void updatePlanQuta(java.util.Hashtable cat_area_Qty)throws Exception{
   ((newtimesejb.production.PlanQuotaFacade)ejb).updatePlanQuota(
         cat_area_Qty,newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
         (String)util.PublicVariable.USER_RECORD.get("usr_code")
        );
 }
 public java.util.Vector getCatArea2Select()throws Exception{
  return ((newtimesejb.production.PlanQuotaFacade)ejb).getPlanQuotas2Select();
 }
 public java.util.Vector getRecords(int i1,int i2)throws Exception{
   //there is no need to flip pages
   //we just need 15 rows as maximun editable range.
  java.util.Vector orgRecords= ((newtimesejb.production.PlanQuotaFacade)ejb).getPlanQuotas(
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
        );
  int appendCount=15-orgRecords.size();
  database.datatype.Record rec=getBlankRecord();
  //System.out.println("org blank rec="+rec.toString());
  //rec.set(0,null);rec.set(1,null);
  for(int i=0;i<appendCount;i++){
    database.datatype.Record newRec=
         (database.datatype.Record)util.MiscFunc.deepCopy(rec);
    orgRecords.add(newRec);
  }
  return orgRecords;
 }
}
