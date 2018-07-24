package newtimes.preproduction.process;
import database.datatype.*;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_Proto extends DB_LabDipStts {
 static newtimesejb.preproduction.ProtoFacade xntMyEjb;
 static DB_Proto instanceOfMe;
 protected  DB_Proto() {
    try{
   newtimesejb.preproduction.ProtoFacadeHome   ejbhome=
       (newtimesejb.preproduction.ProtoFacadeHome)
       info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,
        "newtimesejb.preproduction.ProtoFacade"
        );
      xntMyEjb=ejbhome.create();
      super.ejb=xntMyEjb;
      super.blankRecord=ejb.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Server Connection Failed",
                                             "Server Connection Failed"
                                             );
      super.ejb=null;

  }
 }
 public static DB_Proto getProtoInstance(){
  if(instanceOfMe==null||xntMyEjb==null){
    instanceOfMe=new DB_Proto();
  }
  return instanceOfMe;
 }
 public Vector getRecords(int bgn,int rowCount)throws Exception{
   return xntMyEjb.getRecords(targetPreprodHeadPk,bgn,rowCount);
 }

 public Record getBlankRecord()throws Exception{
  Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
  Record recInClib=(Record)PREPROD_COLOR_LIBS.get(0);
  rec.set("PROTO_STATUS_COLOR",recInClib.get(0));
  rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
  java.sql.Date nowdate=new java.sql.Date(System.currentTimeMillis());
  rec.set("PROTO_STATUS_COMMENT_DATE",nowdate);
  return rec;
}


}