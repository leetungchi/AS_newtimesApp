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

public class DB_LockinStyle extends PagedDataFactoryAdapter {
  static newtimesejb.preproduction.LockinStyleFacade myejb=null;
  static DB_LockinStyle instanceOfMe=null;
  static Vector units;
  public static int CURRENT_EDITING_PRODHEAD_SEQ;
  public static Record EDITING_LOCKIN_STYLE;
  protected DB_LockinStyle() {
    try{
      newtimesejb.preproduction.LockinStyleFacadeHome ejbHome=
          (newtimesejb.preproduction.LockinStyleFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.preproduction.LockinStyleFacade"
          );
      myejb=ejbHome.create();
      super.ejb=myejb;
      units=newtimes.preproduction.guis.tempProperties.tmpUnits;
    //((newtimesejb.preproduction.LockinStyleFacade)ejb).getUNITS();
      super.blankRecord=myejb.getBlankRecord();
    }catch(Exception e){
      myejb=null;
      super.ejb=null;
    }
  }
 public static DB_LockinStyle getInstanceOfLckSty(){
   if(instanceOfMe==null||myejb==null){
     instanceOfMe=new DB_LockinStyle();
   }
   return instanceOfMe;
 }
 public java.util.Vector getRecords(int bgn,int rowcount) throws Exception{
    return  myejb.getRecords(CURRENT_EDITING_PRODHEAD_SEQ,bgn,rowcount);
 }
 public static Vector getUNITS(){
   return units;
 }
 public Record getBlankRecord()throws Exception{
    Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
    rec.set("LOCKIN_STYLE_PROD_HEAD_PK",CURRENT_EDITING_PRODHEAD_SEQ);
    rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
    return rec;
 }
}
