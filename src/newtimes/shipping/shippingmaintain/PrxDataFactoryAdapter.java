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

public class PrxDataFactoryAdapter extends PagedDataFactoryAdapter {
  private static PrxDataFactoryAdapter instanceOfMe = null;

  public PrxDataFactoryAdapter() {
    try{
      super.ejb = exgui2.CONST.SHIP_PRICE_EJB;
      System.out.println("activate : PrxDataFactoryAdapter()");
    }catch(Exception e){
      e.printStackTrace();
      exgui2.CONST.SHIP_PRICE_EJB = null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static PrxDataFactoryAdapter getInstance(){
    if(instanceOfMe == null){
      instanceOfMe = new PrxDataFactoryAdapter();
    }
    return instanceOfMe;
  }

  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    try {
      vRec = exgui2.CONST.SHIP_PRICE_EJB.getRecords(bgn, rowcount, AddDetailList.SHIP_STYLE_PK);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at get record source.\n"+"vector: "+vRec.toString());
    }
    return vRec;
  }
}
