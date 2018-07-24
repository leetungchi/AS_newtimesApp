package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.*;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_ProdColorHandler extends PagedDataFactoryAdapter {
  java.util.Vector orgRecords=null;
  public java.util.Vector preprod_colors=null;
  java.util.HashMap conditions=new java.util.HashMap();
  public int minusedSeq=-1;
  public DB_ProdColorHandler(int prodHeadPK) {
    try{
      newtimesejb.production.ProductionColorFacadeHome ejbHome=
          (newtimesejb.production.ProductionColorFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.production.ProductionColorFacade"
            );
      ejb=ejbHome.create();
      conditions.put("record_delete_flag","1");
      conditions.put("PROD_HEAD_PK",new Integer(prodHeadPK));
      preprod_colors=
          ((newtimesejb.production.ProductionColorFacade)ejb).getPreprodColors(prodHeadPK);
      blankRecord=ejb.getBlankRecord();
      blankRecord.set("PROD_HEAD_PK",prodHeadPK);
      blankRecord.set("record_create_user",
                       util.PublicVariable.USER_RECORD.get("usr_code"));
       blankRecord.set("record_modify_user",
                        util.PublicVariable.USER_RECORD.get("usr_code"));

      orgRecords=ejb.getRecords(1,99999,conditions);
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"ejb create fail");
      exgui.verification.VerifyLib.showAlert("Server Side Error","EJB Create Fail");
    }
  }
  public void addRecords(Vector records)throws Exception{
    ((newtimesejb.production.ProductionColorFacade)ejb).addRecords(records);
  }
  public Record addRecord(Record rec2add)throws Exception {
    Record rec2Return=(Record)util.MiscFunc.deepCopy(blankRecord);
    rec2Return.set(0,String.valueOf(minusedSeq));
    --minusedSeq;
    orgRecords.add(rec2Return);
    return rec2Return;
  }
  public void confirmedUpdate2CallRemote()throws Exception{
    //review the records to udpate...
    for(int i=0;i<orgRecords.size();i++){
      Record rec=(Record)orgRecords.get(i);
       /*
        for imported record,prod_pk is always negtive
        if ( rec.getInt(0) < 1) {
          rec.set(0, null);
        }

      */
    }
    ejb.updateRecords(orgRecords);
    orgRecords=ejb.getRecords(1,99999,conditions);
  }
  public void updateRecords(Vector rec2update)throws Exception{
    for(int i=0;i<rec2update.size();i++){
      Record rec2updateAt=(Record)rec2update.get(i);
      int recIndex=getRecordIndex(rec2updateAt);
      if(recIndex<0) throw new Exception("No Such Record in Prod_color record collections");
      orgRecords.setElementAt(rec2updateAt,recIndex);
    }
  }
  public Vector getRecords(int start,int rowCount)throws Exception{
    return orgRecords;
  }
  public void deleteRecord(Record rec2Delete) throws Exception{
     super.deleteRecord(rec2Delete);//call the database to remove from entity..
     //also,remove from current vector..
     orgRecords.remove(getRecordIndex(rec2Delete));
  }
  protected int getRecordIndex(Record rec2Find){
    for(int i=0;i<orgRecords.size();i++){
      Record xntRec=(Record)orgRecords.get(i);
      if(xntRec.get(0).toString().equals(rec2Find.get(0).toString())){
        return i;
      }
    }
    return -1;
  }
}
