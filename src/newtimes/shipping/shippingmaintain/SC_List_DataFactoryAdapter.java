package newtimes.shipping.shippingmaintain;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SC_List_DataFactoryAdapter extends PagedDataFactoryAdapter {
  private static SC_List_DataFactoryAdapter instanceOfMe = null;

  public SC_List_DataFactoryAdapter() {
    try{
      super.ejb = exgui2.CONST.SC_LIST_EJB;
    }catch(Exception e){
      e.printStackTrace();
      exgui2.CONST.SC_LIST_EJB = null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static SC_List_DataFactoryAdapter getInstance(){
    if(instanceOfMe == null){
      instanceOfMe = new SC_List_DataFactoryAdapter();
    }
    return instanceOfMe;
  }

  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    java.util.HashMap hm = new java.util.HashMap();
    try {
      if (MasterEdit.SRN_NO != null) {
        hm.put("SHIP_NO", MasterEdit.SRN_NO);
        vRec = exgui2.CONST.SC_LIST_EJB.getRecords(bgn, rowcount, hm);
      } else {
        String SRN_NO = util.ApplicationProperites.getProperties("SRN_NO").toString();
        hm.put("SHIP_NO", SRN_NO);
        vRec = exgui2.CONST.SC_LIST_EJB.getRecords(bgn, rowcount, hm);
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at get record source.\n" + "vector: " + vRec.toString());
    }
    return vRec;
  }
}