package newtimes.shipping.shippingmaintain;

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

public class AddDetailListDataFactoryAdapter extends PagedDataFactoryAdapter {
  private static AddDetailListDataFactoryAdapter instanceOfMe = null;

  public AddDetailListDataFactoryAdapter() {
    try{
      super.ejb = exgui2.CONST.SHIP_DETAIL_EJB;
    }catch(Exception e){
      e.printStackTrace();
      exgui2.CONST.SHIP_DETAIL_EJB = null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static AddDetailListDataFactoryAdapter getInstance(){
    if(instanceOfMe == null){
      instanceOfMe = new AddDetailListDataFactoryAdapter();
    }
    return instanceOfMe;
  }

  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    try {
      java.util.HashMap hm =
        (java.util.HashMap)util.ApplicationProperites.getProperties("getData");
      if (MasterEdit.SRN_NO != null) {
        hm.put("SHIP_NO", MasterEdit.SRN_NO);
        vRec = exgui2.CONST.SHIP_DETAIL_EJB.getRecords(bgn, rowcount, hm);
      } else {
        String SRN_NO = util.ApplicationProperites.getProperties("SRN_NO").toString();
        hm.put("SHIP_NO", SRN_NO);
        vRec = exgui2.CONST.SHIP_DETAIL_EJB.getRecords(bgn, rowcount, hm);
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at get record source.\n"+"vector: "+vRec.toString());
    }
    return vRec;
  }
}