package newtimes.production.process.audit_sc_ct;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
public class DB_ProdAudits extends PagedDataFactoryAdapter {
  newtimesejb.preproduction.PreProductionHead myEjb;
  boolean initOk=false;
  public DB_ProdAudits() {
    try{
      newtimesejb.preproduction.PreProductionHeadHome
          ejbHome =
          (newtimesejb.preproduction.PreProductionHeadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.preproduction.PreProductionHead"
          );
      myEjb=ejbHome.create();
      initOk=true;
    }catch(Exception exp){
      util.ExceptionLog.exp2File(exp,"exception in DB_ProdAudits");
      initOk=false;
      exgui.verification.VerifyLib.showAlert(
          "Server Connection Error\nPlease Notify System Manager",
          "EJB Create Exception");
    }
  }

  public boolean isInitOk(){return initOk;}
  public java.util.Vector getRecords(int bgn,int rowCount)throws Exception{
     //PROD_STATE_PK, PROD_HEAD_PK, PS_STATE, PS_STATE_DATE, PROD_AUDIT_RMRK
     java.util.Vector history=myEjb.getAuditHistory(
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
     database.datatype.Record rec=
      (database.datatype.Record)history.get(0);
      rec.set(3,
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
        "record_create_date"));
     return history;
  }
  public void update2Editing()throws Exception{
    update2AuditStatus(myEjb.AUDIT_STATUS_EDITING,"");
  }
  public void update2Confirmed()throws Exception{
    update2AuditStatus(myEjb.AUDIT_STATUS_CONFIRMED,"");
  }

  public void update2Confirm(String stateRemark)throws Exception{
    update2AuditStatus(myEjb.AUDIT_STATUS_CONFIRMED,stateRemark);
  }
  public void update2Reject(String stateRemark)throws Exception{
    update2AuditStatus(myEjb.AUDIT_STATUS_REJECTED,stateRemark);
  }
  public void cancelSC_No(String remark)throws Exception{
    myEjb.cancel_SC_NO(
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
      (String) util.PublicVariable.USER_RECORD.get("usr_code"),remark);
  }
  public void combineProdHead(String sc_no)throws Exception{
    myEjb.updateAudit(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
                             myEjb.AUDIT_STATUS_COMBINE,sc_no,
                             (String) util.PublicVariable.USER_RECORD.get("usr_code"));
  }
  public Record getRecordByPk(int pk) throws Exception{
    return myEjb.findByPk(pk);
  }
  public newtimesejb.preproduction.PreProductionHead getEJB(){
    return myEjb;
  }
  public void updatePrintStatus(int currentPrintCount,int sc_rev_no,int ct_rev_no)throws Exception{
    if(currentPrintCount>-2){
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set(
          "production_print_count", currentPrintCount);
    }
    myEjb.updatePrintStatus(
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
      (String) util.PublicVariable.USER_RECORD.get("usr_code"),
      currentPrintCount,
      sc_rev_no,ct_rev_no
      );
  }
  public String[] getSeriesSC(int dupfromProdSeq,int count,String subGrpCode)throws Exception{
    return myEjb.getSeriesScNo(dupfromProdSeq,util.PublicVariable.USER_RECORD.get(0).toString(),count,
                               subGrpCode);
  }
  protected void update2AuditStatus(int status,String stateRemark)throws Exception{
    try{
      myEjb.updateAudit(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
          status,
          stateRemark,
          (String) util.PublicVariable.USER_RECORD.get("usr_code"));
    }catch(Exception e){
      exgui.verification.VerifyLib.showAlert(
          "Server Side Connection Error\nPlease Contect System Manager",
          "Exception while update Audit Status");
      throw e;
    }

  }
}
