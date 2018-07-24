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

public class DB_DupsStatus extends PagedDataFactoryAdapter {
  static newtimesejb.preproduction.DupsStatusFacade myEjb=null;
  static DB_DupsStatus instanceOfMe=null;
  static int CURRENT_EDITING_PREPRODHEAD_PK=0;
  public static Vector pclibRecords;
  public static Vector lockinstyleRecords;
  protected  DB_DupsStatus() {
    try{
      newtimesejb.preproduction.DupsStatusFacadeHome ejbhome=
          (newtimesejb.preproduction.DupsStatusFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,
             "newtimesejb.preproduction.DupsStatusFacade"
           );
      myEjb=ejbhome.create();
      super.ejb=myEjb;
      blankRecord=myEjb.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      myEjb=null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed",
          "Server side Connection Failed"
      );
    }
  }
  public static DB_DupsStatus getInstanceOfDupsStatus(){
    if(instanceOfMe==null || myEjb==null){
      instanceOfMe=new DB_DupsStatus();
    }
    return instanceOfMe;
  }
  public static void setProdHeadKP(int prodHeadPk)throws Exception{
    CURRENT_EDITING_PREPRODHEAD_PK= prodHeadPk;
    pclibRecords=myEjb.getAvailablePClibs(prodHeadPk);
    lockinstyleRecords=myEjb.getAvailableStyles(prodHeadPk);
  }
  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception {
   return myEjb.getRecords(CURRENT_EDITING_PREPRODHEAD_PK,bgn,rowcount);
  }
  public database.datatype.Record getBlankRecord()throws Exception{
    Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
    rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
    rec.set("DUPS_STATUS_LOCKIN_STYLE_PK",((Record)lockinstyleRecords.get(0)).get(0));
    rec.set("DUPS_STATUS_COLOR",((Record)pclibRecords.get(0)).get(0));
    return rec;
  }
}