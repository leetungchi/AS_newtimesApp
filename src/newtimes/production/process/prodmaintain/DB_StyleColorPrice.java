package newtimes.production.process.prodmaintain;
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

public class DB_StyleColorPrice extends PagedDataFactoryAdapter {
  public Vector UnitsData=null;
  public Vector SytlesAndPo=null;
  public Vector LicenseeData;
  public Vector ProdColors=null;
  protected boolean initOk=false;
  String modfUser=null;
  public DB_StyleColorPrice() {
    try{
       newtimesejb.production.StyleColorPriceFacadeHome ejbhome=
          (newtimesejb.production.StyleColorPriceFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.production.StyleColorPriceFacade");
       super.ejb=ejbhome.create();
       super.blankRecord=ejb.getBlankRecord();
       UnitsData=newtimes.preproduction.guis.tempProperties.tmpUnits;
     //((newtimesejb.production.StyleColorPriceFacade)ejb).getUnits();
       SytlesAndPo=((newtimesejb.production.StyleColorPriceFacade)ejb).getStylePOs(
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
          );
       ProdColors=((newtimesejb.production.StyleColorPriceFacade)ejb).getProdColors(
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
          );

       //PROD_BUYER
       Object objBuyer=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_BUYER");
       if(objBuyer!=null){
         LicenseeData=((newtimesejb.production.StyleColorPriceFacade)ejb).getLicensee(
              Integer.parseInt(objBuyer.toString()));
       }else{
         LicenseeData=new Vector();
       }
       blankRecord.set("record_create_user",
                       util.PublicVariable.USER_RECORD.get("usr_code"));
        modfUser=(String)util.PublicVariable.USER_RECORD.get("usr_code");
      //=====================================================================
       if(SytlesAndPo==null||SytlesAndPo.size()==0){
         exgui.verification.VerifyLib.showAlert(
            "Please Define Styles Before Define Color Prices",
            "Please Define Styles ");
         initOk=false;
         return;
       }
       blankRecord.set("PRI_STY_SEQ",((Record)SytlesAndPo.get(0)).get(0));
       //blankRecord.set("PRI_UNIT",((Record)UnitsData.get(0)).get(0)); because price_unit column is remove at 20030627
       if(ProdColors==null||ProdColors.size()==0){
         exgui.verification.VerifyLib.showAlert(
            "Please Define Product Colors Before Define Color Prices",
            "Please Define Product Colors");
         initOk=false;
         return;
       }

         //Record nullColorRec = (Record) util.MiscFunc.deepCopy(ProdColors.get(0));
         //nullColorRec.set("PROD_COLOR_NAME", "N/A");
         //nullColorRec.set("PROD_COLOR_PK", null);
         //ProdColors.add(0, nullColorRec);

        //blankRecord.set("PROD_COLOR_PK",((Record)ProdColors.get(0)).get(0));
        blankRecord.set("PROD_COLOR_PK",null);
       if(LicenseeData==null||LicenseeData.size()==0){
         exgui.verification.VerifyLib.showAlert(
            "Please Define Licensees Before Define Color Prices","Please Define Licensees");
         initOk=false;
         return;
       }
         Record nullLicenseeRec = (Record) util.MiscFunc.deepCopy(LicenseeData.
             get(0));
         nullLicenseeRec.set("BYMKR_SEQ", null);
         nullLicenseeRec.set("BYMKR_BRIEF", "N/A");
         LicenseeData.add(0, nullLicenseeRec);


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
         ((newtimesejb.production.StyleColorPriceFacade)ejb).getRecords(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
         ,bgn,rowcount);
  }
  public HashMap getDefaultFobPrx()throws newtimesejb.production.FirstFbkPrxIsZero,java.rmi.RemoteException,Exception {
    Record rec=newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD;
    HashMap hm=
        ((newtimesejb.production.StyleColorPriceFacade)ejb).getDftFobPrx(
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
         rec.getFloat("FHA")
        );
    return hm;

  }
}
