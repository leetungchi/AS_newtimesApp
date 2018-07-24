package newtimes.shipping.styleclose;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class StyleCloseDataFactoryAdapter extends PagedDataFactoryAdapter {
  static java.util.HashMap hmQuery = null;
  private static StyleCloseDataFactoryAdapter instanceOfMe = null;
  public static java.util.HashMap  hmUpdatedStatus=new java.util.HashMap();
  public static java.util.HashMap hmUpdateDelDate=new java.util.HashMap();
  public StyleCloseDataFactoryAdapter() {
    try{
      //super.ejb = exgui2.CONST.STYLE_CLOSE_EJB;
      ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJBHome ejbHome=
          (ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJBHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJB");
      super.ejb=ejbHome.create();
      exgui2.CONST.STYLE_CLOSE_EJB=(ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJB)ejb;

    }catch(Exception e){
      e.printStackTrace();
      exgui2.CONST.STYLE_CLOSE_EJB = null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static StyleCloseDataFactoryAdapter getInstance(){
    /*
    if(instanceOfMe == null){
      instanceOfMe = new StyleCloseDataFactoryAdapter();
    }
    return instanceOfMe;*/
   return new StyleCloseDataFactoryAdapter();
  }
  public void updateCloseStatus()throws Exception{
      ((ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJB)ejb).updateStyleClose(hmUpdatedStatus,
                           (String)util.PublicVariable.USER_RECORD.get("USR_CODE"),hmUpdateDelDate);
      hmUpdatedStatus.clear();
      hmUpdateDelDate.clear();
  }
  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try {
      hmQuery =
        (java.util.HashMap)util.ApplicationProperites.getProperties("getData");
      if (hmQuery != null) {
        vRec =ejb.getRecords(bgn, rowcount, hmQuery);
        //vRec =exgui2.CONST.STYLE_CLOSE_EJB.getRecords(bgn, rowcount, hmQuery);
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at get record source.\n"+"vector: "+vRec.toString());
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
    return vRec;
  }
}
