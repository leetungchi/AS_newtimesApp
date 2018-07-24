package newtimes.preproduction.process;

import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.Vector;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_PPSstatus extends PagedDataFactoryAdapter {
  static int CURRENT_EDITING_PREPRODSEQ;
  public static Vector USING_LOCKIN_STYLES;
  static newtimesejb.preproduction.PPS_Facade myEJB;
  static DB_PPSstatus instanceOfMe;
  protected DB_PPSstatus() {
    try{
      newtimesejb.preproduction.PPS_FacadeHome ejbhome=
          (newtimesejb.preproduction.PPS_FacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,
             "newtimesejb.preproduction.PPS_Facade"
           );
      myEJB=ejbhome.create();
      super.ejb=myEJB;
      blankRecord=myEJB.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      myEJB=null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed",
          "Server side Connection Failed"
      );
    }

  }
  public static DB_PPSstatus getInstanceOfPPSstatus(){
    if(instanceOfMe==null || myEJB==null){
      instanceOfMe=new DB_PPSstatus();
    }
    return instanceOfMe;
  }
  public static void setPreProdHeadPK(int preprodHeadPK)throws Exception{
    CURRENT_EDITING_PREPRODSEQ=preprodHeadPK;
    USING_LOCKIN_STYLES=myEJB.getAvailableStyles(preprodHeadPK);
  }
 public Vector getRecords(int bgn,int rowcount)throws Exception{
   return myEJB.getRecords(CURRENT_EDITING_PREPRODSEQ,bgn,rowcount);
 }
 public Record getBlankRecord()throws Exception{
   Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
   java.sql.Date nowdate=new java.sql.Date(System.currentTimeMillis());
   rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
   rec.set("PPS_STATUS_LOCKIN_STYLE_PK",
           ((Record)USING_LOCKIN_STYLES.get(0)).get(0)
           );
   rec.set("PPS_STATUS_COMMENT_DATE",nowdate);
   return rec;
 }
}