package newtimes.preproduction.process;
import database.datatype.Record;
import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_LabDipStts extends PagedDataFactoryAdapter {
  static DB_LabDipStts instanceOfMe;
  static newtimesejb.preproduction.LabDipFacade myEjb;
  static public Vector PREPROD_COLOR_LIBS;
  static int targetPreprodHeadPk;
  protected DB_LabDipStts() {
    try{
   newtimesejb.preproduction.LabDipFacadeHome  ejbhome=
       (newtimesejb.preproduction.LabDipFacadeHome)
       info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,
        "newtimesejb.preproduction.LabDipFacade"
        );
      myEjb=ejbhome.create();
      super.ejb=myEjb;
      super.blankRecord=ejb.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Server Connection Failed",
                                             "Server Connection Failed"
                                             );
      super.ejb=null;
    }
  }
 public Vector getRecords(int bgn,int rowCount)throws Exception{
   return myEjb.getRecords(targetPreprodHeadPk,bgn,rowCount);
 }
 public static DB_LabDipStts getLabDipSttsInstance(){
   if(instanceOfMe==null||myEjb==null){
     instanceOfMe=new DB_LabDipStts();
   }
   return instanceOfMe;
 }
 public static Vector getAvailableColorLibs(int preprodSeq)throws Exception{
   PREPROD_COLOR_LIBS= myEjb.getAvailablePreprodClibs(preprodSeq);
   targetPreprodHeadPk=preprodSeq;
   return PREPROD_COLOR_LIBS;
 }
 public Record getBlankRecord()throws Exception{
   Record rec=super.getBlankRecord();
   Record recInClib=(Record)PREPROD_COLOR_LIBS.get(0);
   rec.set("LAB_DIP_COLOR",recInClib.get(0));
   rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
   java.sql.Date nowdate=new java.sql.Date(System.currentTimeMillis());
   rec.set("LAB_DIP_COMMENT_DATE",nowdate);
   return rec;
 }

}