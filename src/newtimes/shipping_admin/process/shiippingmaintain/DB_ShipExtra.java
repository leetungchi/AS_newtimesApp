package newtimes.shipping_admin.process.shiippingmaintain;

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

public class DB_ShipExtra extends PagedDataFactoryAdapter {
   boolean initOK;
  public DB_ShipExtra() {
    try {
      ShippingAdmin.SRN_Style.ShipExtraFacadeHome  ejbHome =
          (ShippingAdmin.SRN_Style.ShipExtraFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingAdmin.SRN_Style.ShipExtraFacade");
      ejb = ejbHome.create();
      blankRecord = ejb.getBlankRecord();
      blankRecord.set("record_create_user",
                       util.PublicVariable.USER_RECORD.get("usr_code"));
      blankRecord.set("ship_no",
                      newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
      blankRecord.set("sign","+");
      blankRecord.set("extra",0);
      initOK = true;
    } catch (Exception e) {
      util.ExceptionLog.exp2File(e, "error in DB_ShipExtra");
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Server Side Connection Fail\nPlease Contact System Manager",
          "Connection Fail");
      initOK = false;
    }
  }
  public  boolean isInitOk() {return initOK; }
  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
    java.util.HashMap hm=new java.util.HashMap();
    hm.put("record_delete_flag","1");
    hm.put("ship_no",newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
    return ((ShippingAdmin.SRN_Style.ShipExtraFacade)ejb).getRecords(bgn,rowcount,hm);
  }
  public  Record getTotalNetAmt()throws Exception{
   return ((ShippingAdmin.SRN_Style.ShipExtraFacade)ejb).Total_Net_Amt(
      newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
  }
  public  Record getTotalNegoAmt()throws Exception{
   return ((ShippingAdmin.SRN_Style.ShipExtraFacade)ejb).Total_NEGO_Amt(
      newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
  }
  public void setExtraDesc2ShipRec(String data2Set)throws Exception{
     ((ShippingAdmin.SRN_Style.ShipExtraFacade)ejb).setShipExtraDesc(
      newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN,
      data2Set,
      (String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }

}
