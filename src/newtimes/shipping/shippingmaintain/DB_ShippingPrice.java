package newtimes.shipping.shippingmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.*;
import database.datatype.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_ShippingPrice  extends PagedDataFactoryAdapter {
  public Vector UnitsData=null;
  public Vector SytlesAndPo=null;
  //public Vector LicenseeData;
  public Vector ProdColors=null;
  protected boolean initOk=false;
  String modfUser=null;
  java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  protected static int currentOperationPK=0;
  public DB_ShippingPrice() {
    try{
       ShippingMdlEJBs.ShippingPrice.ShippingPriceFacadeHome ejbhome=
          (ShippingMdlEJBs.ShippingPrice.ShippingPriceFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingMdlEJBs.ShippingPrice.ShippingPriceFacade");
       super.ejb=ejbhome.create();
       super.blankRecord=ejb.getBlankRecord();
       currentOperationPK=
           Shipping_Const.EDITING_SHIPING_STYLE_PK;
       ProdColors=((ShippingMdlEJBs.ShippingPrice.ShippingPriceFacade)ejb).getProdColors(
            currentOperationPK
          );

       blankRecord.set("record_create_user",
                       util.PublicVariable.USER_RECORD.get("usr_code"));
        modfUser=(String)util.PublicVariable.USER_RECORD.get("usr_code");
      //=====================================================================
      //column 1 is ship_style_pk
       blankRecord.set(1,currentOperationPK);
       //blankRecord.set("PRI_UNIT",((Record)UnitsData.get(0)).get(0)); because price_unit column is remove at 20030627
       if(ProdColors==null||ProdColors.size()==0){
         exgui.verification.VerifyLib.showAlert(
            "Please Define Product Colors and Style Quentity  Before Define Color Prices",
            "Please Define Product Colors in Styles");
         initOk=false;
         return;
       }
         Record nullColorRec = (Record) util.MiscFunc.deepCopy(ProdColors.get(0));
         nullColorRec.set("PROD_COLOR_NAME", "N/A");
         nullColorRec.set("PROD_COLOR_PK", null);
         ProdColors.add(0, nullColorRec);
        //blankRecord.set("PROD_COLOR_PK",((Record)ProdColors.get(0)).get(0));
         blankRecord.set("PROD_COLOR_PK",null);
       //blankRecord.set("PRI_LICENSEE_NAME",((Record)LicenseeData.get(0)).get(0));
       blankRecord.set("PRI_LICENSEE_NAME",null);
       //PRI_BYR_ACT_PRX, PRI_BYR_DOC_PRX, PRI_MKR_ACT_PRX, PRI_MKR_DOC_PRX
       blankRecord.set("PRI_BYR_ACT_PRX",0);
       blankRecord.set("PRI_BYR_DOC_PRX",0);
       blankRecord.set("PRI_MKR_ACT_PRX",0);
       blankRecord.set("PRI_MKR_DOC_PRX",0);
       initOk=true;
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Connection Fail\nPlease Contact System Manager","EJB Creation Exception");
      initOk=false;
    }
  }
  public void doDeleteRows(Vector records)throws Exception{
     for(int i=0;i<records.size();i++){
       ((Record)records.get(i)).set("record_delete_flag","0");
       ((Record)records.get(i)).set("record_modify_user",modfUser);
     }
     ejb.updateRecords(records);
  }
  public boolean isInitOk(){return initOk;}
  public java.util.Vector getRecords(int bgn,int rowcount) throws Exception{
     return
         ((ShippingMdlEJBs.ShippingPrice.ShippingPriceFacade)ejb).getRecords(
          currentOperationPK
         ,bgn,rowcount,(String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }

}
