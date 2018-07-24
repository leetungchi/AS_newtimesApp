package newtimes.shipping_admin.process.shiippingmaintain;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import java.util.*;
public class DB_StyleList4Add extends PagedDataFactoryAdapter {
  boolean initOK;
  static private DB_StyleList4Add myInstance=null;
  public DB_StyleList4Add() {
    try {
      ShippingAdmin.SRN_Style.ShipHeadFacadeHome ejbHome =
          (ShippingAdmin.SRN_Style.ShipHeadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingAdmin.SRN_Style.ShipHeadFacade");
      ejb = ejbHome.create();
      blankRecord = ejb.getBlankRecord();
      initOK = true;
    } catch (Exception e) {
      util.ExceptionLog.exp2File(e, "error in DB_StyleListAd");
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Server Side Connection Fail\nPlease Contact System Manager",
          "Connection Fail");
      initOK = false;
    }
  }
  public static DB_StyleList4Add getInstance(){
    if(myInstance==null){
      myInstance=new DB_StyleList4Add();
      return myInstance;
    }
    return myInstance;
  }
  public  boolean isInitOk() {return initOK; }
  public  Vector getRecords(int bgn,int rowcount)throws Exception{
    //condition hash map is designed by PnlQryStyles2AddByScPo

    HashMap hm=newtimes.shipping_admin.ShippingAdmin_Const.HM_CONDITION_QRY_STYLES;
    hm.put("OPERATION_CENTER",util.PublicVariable.OPERATTING_CENTER);
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
      hm.put("OFFSHORE",newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER);
      Vector vct=((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).getStyles2Add(1,9999999,hm);
      return vct;
    }
    Vector vct=((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).getStyles2Add(bgn,rowcount,hm);
    if(null!=hm.get("IS_ASN_MODE") && hm.get("IS_ASN_MODE").toString().equals("TRUE")){
      java.util.Vector vct2Return=new Vector();
     for(int i=0;i<vct.size();i++){
       database.datatype.Record rec=(database.datatype.Record)vct.get(i);
       String keStr = rec.get("STY_SEQ").toString() +"||"+rec.get("vendorinv_no").toString()+ "||" +(String)rec.get("ASN_NO");
       if(!newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS.containsKey(keStr)){
         vct2Return.add(rec);
       }
     }
     return vct2Return;
    }

    //if(hm.containsKey())
    return vct;
  }
}
