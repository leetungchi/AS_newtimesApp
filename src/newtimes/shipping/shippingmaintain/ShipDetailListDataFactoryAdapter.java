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

public class ShipDetailListDataFactoryAdapter extends PagedDataFactoryAdapter {
  private static ShipDetailListDataFactoryAdapter instanceOfMe = null;

  public ShipDetailListDataFactoryAdapter() {
    try{
      super.ejb = exgui2.CONST.SHIP_DETAIL_EJB;
    }catch(Exception e){
      e.printStackTrace();
      exgui2.CONST.SHIP_DETAIL_EJB = null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static ShipDetailListDataFactoryAdapter getInstance(){
    if(instanceOfMe == null){
      instanceOfMe = new ShipDetailListDataFactoryAdapter();
    }
    return instanceOfMe;
  }

  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    try {
      vRec = exgui2.CONST.SHIP_DETAIL_EJB.getRecords4SC(bgn, rowcount, SC_EditFieldsGUI.recDetail);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at get record source.\n"+"vector: "+vRec.toString());
    }
    return vRec;
  }
}