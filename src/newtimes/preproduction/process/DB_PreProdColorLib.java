package newtimes.preproduction.process;
import java.util.Vector;
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

public class DB_PreProdColorLib extends PagedDataFactoryAdapter {
  static DB_PreProdColorLib instanceOfMe;
  static newtimesejb.preproduction.PreProd_ColorLib myEJB;
  static public int preprodHeadSeq=0;
  static public Record editingRecord;
  static public boolean isInit4Display=false;
  private DB_PreProdColorLib() {
    try{
      newtimesejb.preproduction.PreProd_ColorLibHome ejbHm=
         (newtimesejb.preproduction.PreProd_ColorLibHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,"newtimesejb.preproduction.PreProd_ColorLib");
       myEJB=ejbHm.create();
       super.ejb=myEJB;
       super.blankRecord=myEJB.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Server side connection fail\nPlease Nofity System Manager","Server side connection fail");
      myEJB=null;
      super.ejb=null;
    }
  }
  static public DB_PreProdColorLib getInstance(){
    if(instanceOfMe ==null||myEJB==null){
      instanceOfMe =new DB_PreProdColorLib();
    }
    return instanceOfMe;
  }
  public Record getBlankRecord()throws Exception{
    Record rec=super.getBlankRecord();
    rec.set("PCLIB_PROD_HEAD_PK",preprodHeadSeq );
    return rec;
  }
  public void restoreWithPreprodHead(Vector recs,Record preprodHead)throws Exception{
    myEJB.restoreWithHead(recs,preprodHead);
  }
  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
    //this function can be use as normal selection restore selection.
    if(!listforRestore()){
     return myEJB.getUnDeleteRec(preprodHeadSeq,bgn,rowcount);
    }else{
      return myEJB.getDeletedRec(preprodHeadSeq,bgn,rowcount);
    }
  }
  public void isInitialzing(boolean isInit){
    isInit4Display=isInit;
  }
  public void updateRecords(Vector rec2update)throws Exception{
    if(isInit4Display)return;//we don't need to update while going to 1st page for display.
    //to test if updating while restoring datas...
    Record preprodheadRec=
       DB_Preprod.getInstance().findbyPk(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
    //System.out.println("preprodheadRec is :"+preprodheadRec);
    if(((String)preprodheadRec.get("record_delete_flag")).equals("0")&&
        listforRestore()
       ){
      Object usrCODE =
          util.PublicVariable.USER_RECORD.get("usr_code");
      preprodheadRec.set("record_modify_user",usrCODE);
      if(rec2update.size()==0){
        DB_Preprod db=DB_Preprod.getInstance();
        db.restoreRecord(preprodheadRec);
        return;
      }
      int mdfUsrKlmAt=0;
      for(int i=0;i<rec2update.size();i++){
        if(i==0){
          mdfUsrKlmAt=util.MiscFunc.getFieldIndexAtRecord(
              (Record)rec2update.get(0),"record_modify_user");
        }
        Record rec=(Record)rec2update.get(i);
        rec.set(mdfUsrKlmAt,usrCODE);
      }

      restoreWithPreprodHead(rec2update,preprodheadRec);
    }else{
      //normal operation for update records.
      super.updateRecords(rec2update);
    }
  }
}