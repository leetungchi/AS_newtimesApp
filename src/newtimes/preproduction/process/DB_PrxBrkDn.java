package newtimes.preproduction.process;
import database.datatype.Record;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_PrxBrkDn extends DB_LabDipStts {
  static DB_PrxBrkDn instanceOfMe=null;
  static newtimesejb.preproduction.PriceBreakDownFacade xntEjb=null;
  protected DB_PrxBrkDn() {
    try{
   newtimesejb.preproduction.PriceBreakDownFacadeHome    ejbhome=
       (newtimesejb.preproduction.PriceBreakDownFacadeHome)
       info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,
        "newtimesejb.preproduction.PriceBreakDownFacade"
        );
      xntEjb=ejbhome.create();
      super.ejb=xntEjb;
      super.blankRecord=ejb.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Server Connection Failed",
                                             "Server Connection Failed"
                                             );
      xntEjb=null;
      super.ejb=null;

    }

  }
  public static DB_PrxBrkDn getInstanceOfPrxBrkdn(){
    if(instanceOfMe==null || xntEjb==null){
      instanceOfMe=new DB_PrxBrkDn();
    }
    return instanceOfMe;
  }
  public Record getBlankRecord() throws Exception{
     Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
     rec.set("PRICE_BREAKDOWN_UNIT_CURRENCY",
             newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(
             "LOCAL_CURRENCY_NAME"));//use system currency as default value.
     rec.set("PRICE_BREAKDOWN_IS_PROTO","Y");
     rec.set("PRICE_BREAKDOWN_IS_LOCKIN","Y");
     Record recInClib=(Record)PREPROD_COLOR_LIBS.get(0);
     rec.set("PRICE_BREAKDOWN_CLIB_SEQ",recInClib.get(0));
     rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
     return rec;
  }
  public Vector getRecords(int bgn,int rowCount)throws Exception{
     return xntEjb.getRecords(targetPreprodHeadPk,bgn,rowCount );
  }
}