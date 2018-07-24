package newtimes.production.process.order_change;
import java.util.*;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
public class Proxy_PriceList extends
    newtimes.production.process.prodmaintain.DB_StyleColorPrice {
    newtimesejb.production.PriceListChgFacade prxEJB;
   public Vector tempPriceRecords;
  public Proxy_PriceList() {
     super();
     if(!super.isInitOk())return;
     try{
       newtimesejb.production.PriceListChgFacadeHome ejbHome=
           (newtimesejb.production.PriceListChgFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,
           "newtimesejb.production.PriceListChgFacade");
        prxEJB=ejbHome.create();
        initOk=true;
     }catch(Exception e){
       e.printStackTrace();
       initOk=false;
       exgui.verification.VerifyLib.showAlert(
       "Server Side Error\nPlease Contact System Manager",
       "EJB Creation Exception");
     }
  }

  public Vector getRecords(int bgn,int rowcount)throws Exception{
    Vector vct= prxEJB.getRecords(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
          newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData.getInt(0),
          bgn,rowcount);
          Record styRec=
              newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData;
     Object CMTPRX=styRec.get("STY_CMT_PRICE");
     String modifyUser=(String)util.PublicVariable.USER_RECORD.get("usr_code");
     for(int i=0;i<vct.size();i++){
       Record rec=(Record)vct.get(i);
       rec.getFieldName().add("CMT_PRICE");
       rec.getValueFields().add(CMTPRX);
       rec.set("record_modify_user",modifyUser);
     }
     tempPriceRecords=
      (Vector)util.MiscFunc.deepCopy(vct);
    return vct;
  }
  public void  updateRecords(Vector vct2update)throws Exception{
    //record data,save to temp data.
    if(vct2update==null||vct2update.size()==0)return;
    HashMap storedPrxRecs=new HashMap();
    for(int i=0;i<vct2update.size();i++){
      Record rec=(Record)vct2update.get(i);
      storedPrxRecs.put(String.valueOf(rec.getInt(0)),rec);
    }

    for(int i=0;i<tempPriceRecords.size();i++){
      Record orgPrxRec=(Record)tempPriceRecords.get(i);
      Record storePrxRec=(Record)storedPrxRecs.get(
          String.valueOf(orgPrxRec.getInt(0)));
      //System.out.println("storePrxRec="+storePrxRec);
      if(storePrxRec!=null){
        tempPriceRecords.set(i,storePrxRec);
      }
    }
    newtimes.production.process.order_change.tempDataCenter.STORED_CHG_PRX_RECORDS=
        tempPriceRecords;
  }
}
