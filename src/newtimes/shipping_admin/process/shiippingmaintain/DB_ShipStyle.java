package newtimes.shipping_admin.process.shiippingmaintain;

import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_ShipStyle extends PagedDataFactoryAdapter {
  protected int _ship_org_style_seq;
  boolean initOK=false;
  public DB_ShipStyle(int ship_org_style_seq) {
    try{
      _ship_org_style_seq = ship_org_style_seq;
      ShippingAdmin.SRN_Style.ShipStyleFacadeHome ejbHome =
          (ShippingAdmin.SRN_Style.ShipStyleFacadeHome)info_ejb.
          WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingAdmin.SRN_Style.ShipStyleFacade");
      super.ejb = ejbHome.create();
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"");
      initOK=false;
    }

  }
 public boolean isInitOK(){return initOK;}
 public Record updateRecord(Record rec)throws Exception{
   return ((ShippingAdmin.SRN_Style.ShipStyleFacade)ejb).updateComplexShipRecord(rec);
 }
 public Record getRecordByPk(int pk)throws Exception{
     Record rec=((ShippingAdmin.SRN_Style.ShipStyleFacade)ejb).genShipStyleRecord(pk,_ship_org_style_seq);
     if(pk<0){
       //rec.set(1, _ship_sc_pk);//SHIP_SC_PK,need to be find out from server.
       rec.set(0,pk);
       rec.set(2,_ship_org_style_seq);
       rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
       rec.set("record_delete_flag","1");
       rec.set("record_create_date",new java.sql.Date(System.currentTimeMillis()));
       //assigne SRN No for SHIP SC table to test.
       String strRec2Str=rec.toString();
       if(strRec2Str.toUpperCase().indexOf("|_$ORG_SHIP_NO=")!=-1){
         rec.set("_$ORG_SHIP_NO",
                 newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
       }else{
         rec.getFieldName().add("_$ORG_SHIP_NO");
         rec.getValueFields().add(
          newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
       }
     }
     return rec;
 }
}
