package newtimes.shipping.shippingmaintain;

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

public class MasterExtraDataFactoryAdapter extends PagedDataFactoryAdapter {
  private static MasterExtraDataFactoryAdapter instanceOfMe = null;
  static String SRN_NO = null;

  public MasterExtraDataFactoryAdapter() {
    try{
      super.ejb  = exgui2.CONST.SHIP_MAIN_EJB;
      blankRecord = exgui2.CONST.SHIP_MAIN_EJB.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      exgui2.CONST.SHIP_MAIN_EJB=null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static MasterExtraDataFactoryAdapter getInstance(){
    if(instanceOfMe == null || exgui2.CONST.SHIP_MAIN_EJB == null){
      instanceOfMe = new MasterExtraDataFactoryAdapter();
    }
    return instanceOfMe;
  }

  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    try {
      if (MasterEdit.SRN_NO != null) {
        vRec = exgui2.CONST.SHIP_MAIN_EJB.getRecords(MasterEdit.SRN_NO, bgn, rowcount);
      } else {
        SRN_NO = util.ApplicationProperites.getProperties("SRN_NO").toString();
        vRec = exgui2.CONST.SHIP_MAIN_EJB.getRecords(SRN_NO, bgn, rowcount);
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at get record source.\n"+
                                 "vector: "+vRec.toString());
    }
    return vRec;
  }

  public database.datatype.Record getBlankRecord()throws Exception{
    Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
    rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
    rec.set("SHIP_NO", MasterEdit.SRN_NO);
    rec.set("SIGN", "+");
    rec.set("EXTRA", "0");
    return rec;
  }
}