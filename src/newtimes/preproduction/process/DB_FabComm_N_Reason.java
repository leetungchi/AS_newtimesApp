package newtimes.preproduction.process;
import database.datatype.Record;
import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_FabComm_N_Reason extends PagedDataFactoryAdapter {
  protected Record dummyRecord;
  boolean isDummy;
  int prodHeadPk=-1;
  public DB_FabComm_N_Reason(boolean _isDummy) {
    this();
    isDummy=_isDummy;
  }
  public DB_FabComm_N_Reason() {
    try{
      newtimesejb.preproduction.Prod_Comm_N_Reason_FacadHome  ejbHome =
          (newtimesejb.preproduction.Prod_Comm_N_Reason_FacadHome)info_ejb.
          WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.preproduction.Prod_Comm_N_Reason_Facad");
      super.ejb = ejbHome.create();
      super.blankRecord = ejb.getBlankRecord();
      isDummy=false;
      dummyRecord=getBlankRecord();
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Error While Connecting Server In DB_FabComm_N Facade\nPlease contact system manager"
                                              ,"Connection error");
    }
  }
  public Record  getRecordByPk(int prod_head_pk)throws Exception{
    if(isDummy){
      return  dummyRecord;
    }
    return ((newtimesejb.preproduction.Prod_Comm_N_Reason_Facad)ejb).findByIndex(prod_head_pk,
        (String)util.PublicVariable.USER_RECORD.get(0));
  }
  public void updateRecords(java.util.Vector vct)throws Exception{
    if(isDummy){
      Record rec=(Record)vct.get(0);
      for(int i=0;i<rec.getFieldName().size() ;i++){
        dummyRecord.set(i,rec.get(i));
      }
    }else{
      super.updateRecords(vct);
    }
  }
  public boolean isDummy(){return isDummy;}
  public void insertRecord(int prod_head_pk)throws Exception{
    if(!isDummy)return;
    Record rec2insert=(Record)util.MiscFunc.deepCopy(dummyRecord);
    rec2insert.set(0, prod_head_pk);
    rec2insert.set("record_create_user", (String)util.PublicVariable.USER_RECORD.get(0));
    rec2insert.set("record_delete_flag","1");
    ejb.insertRecord(rec2insert);
  }
}
