package newtimes.preproduction.process;
import newtimes.preproduction.guis.*;
import java.util.Vector;
import database.datatype.Record;
import java.awt.Cursor;
public class AttributeFactory implements Runnable{
  private static boolean isCurrencyReady;
  private static boolean isAllDataReady;
  private static boolean isReportEJBReady;
  public AttributeFactory() {
    initValue();
    //isCurrencyReady=false;
    //isAllDataReady=false;
    //isReportEJBReady=false;
  }
  public static boolean isCurrencyDataReady(){return isCurrencyReady;}
  public static  synchronized boolean isAllAccsAttribReady(){

        return isAllDataReady;

  }
  public static boolean isReportEJBReady(){return isReportEJBReady;}
  public static void getNthkCetnersManagers()throws Exception{
    String centerList="('NTHK','NTFE','NTD','NJ','CG','PW','AE','BW')";
    java.util.Vector vctCenters=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from center where record_delete_flag='1' and cen_code in "+centerList,
      1,9999);
    tempProperties.tmpCenters.clear();
    for(int i=0;i<vctCenters.size();i++){
      tempProperties.tmpCenters.add(vctCenters.get(i));
    }
    //selec manager hash map
    java.util.Vector vctManagers=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from manager where record_delete_flag='1' and mng_cen_code in "+centerList+
      " order by mng_cen_code",
      1,9999);
     String lastKey="";
     Vector currentVct=null;
     for(int i=0;i<vctManagers.size();i++){
       Record rec=(Record)vctManagers.get(i);
       String mng_cen_code=(String)rec.get("mng_cen_code");
       if(!lastKey.equals(mng_cen_code)){
         if(currentVct!=null)tempProperties.tmpHm_Managers4AllCenters.put(lastKey,currentVct);
         currentVct=new Vector();
         currentVct.add(rec);
         lastKey=new String(mng_cen_code);
       }else{
         currentVct.add(rec);
       }
     }
   // do not forget last manager reocrd
     tempProperties.tmpHm_Managers4AllCenters.put(lastKey,currentVct);

  }
  protected static void updateCenterDepMap(java.util.Vector depRecords){
    tempProperties.tmpH_tbl_CenterDepMap.clear();
    for(int i=0;i<depRecords.size();i++){
      database.datatype.Record rec=(database.datatype.Record)depRecords.get(i);
      String xntCenName=(String)rec.get(4);
      if(tempProperties.tmpH_tbl_CenterDepMap.containsKey(xntCenName)){
        Vector tmpVct=(Vector)tempProperties.tmpH_tbl_CenterDepMap.get(xntCenName);
        tmpVct.add(rec);
      }else{
        Vector newVct=new Vector();
        newVct.add(rec);
        tempProperties.tmpH_tbl_CenterDepMap.put(xntCenName,newVct);
      }
    }
  }
  protected static void updateBuyerDivisionMap(java.util.Vector divRecords){
     tempProperties.tmpHMap_BuyerDivison.clear();
     Object buyerSeq=null;
     for(int i=0;i<divRecords.size();i++){
       database.datatype.Record rec=(database.datatype.Record)divRecords.get(i);
       buyerSeq=rec.get(2);//"DIV_BYMKR_SEQ"
       if(buyerSeq==null)continue;
       buyerSeq=buyerSeq.toString();
       if(tempProperties.tmpHMap_BuyerDivison.containsKey(buyerSeq)){
          Vector divRecsToStore=(Vector)tempProperties.tmpHMap_BuyerDivison.get(buyerSeq);
          divRecsToStore.add(rec);
       }else{
          Vector newVec=new Vector();
          newVec.add(rec);
          tempProperties.tmpHMap_BuyerDivison.put(buyerSeq,newVec);
       }
     }
  }
  private synchronized void initValue (){
    isCurrencyReady=false;
    isAllDataReady=false;
    isReportEJBReady=false;
  }
  public void run(){
    try{
      initValue();
      newtimes.preproduction.Constants.Org_PREPROD_COMMAND_SET=
      new newtimes.preproduction.process.PP_Maintain_CmdSet();
      generateAttribute();
    }catch(Exception e){
      //isAllDataReady=true;
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"Exception while gethering acccessory attributes");
      exgui.verification.VerifyLib.showAlert(
      "Exception While Get Accessory Attribution\nPlease Contact System Manager"
      ,"Exception While Get Accessory Attribution");
      System.exit(0);
    }
  }
  public  void generateAttribute()throws Exception{
    newtimes.production.report.ReportCmdSet.myReportEngin=
        new newtimes.production.report.ReportProxyEngine();
    isReportEJBReady=true;
    newtimesejb.preproduction.QueryHome qryHm=(newtimesejb.preproduction.QueryHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
        "newtimesejb.preproduction.Query"
        );
    newtimesejb.preproduction.Query qryEjb=qryHm.create();
    java.util.Hashtable ht=qryEjb.getQryKdsnMap(
            util.PublicVariable.USER_RECORD
          );
    //initial the combobox with vectors.
    tempProperties.tmpCurrency.clear();
    tempProperties.tmpCurrency.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_CURRENCY));
    isCurrencyReady=true;

    tempProperties.tmpCountries.clear();
    tempProperties.tmpCountries.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_COUNTRIES));


    tempProperties.tmpCenters.clear();
    database.datatype.DataVector centers=(database.datatype.DataVector)ht.get(qryEjb.KEY_CENTERS);
    Record recOrgCenter=(Record)centers.get(0);
    System.out.println(recOrgCenter.toString());
    tempProperties.tmpCenters.addAll(centers);

    for(int i=0;i<tempProperties.tmpCenters.size();i++){
      Object obj=tempProperties.tmpCenters.get(i);
      if(obj instanceof Record){
        System.out.println("Center object,type as record, is="+((Record)obj).toString());
      }else{
        System.out.println("Center object,type IS NOT RECORD, is="+obj.toString());
      }
    }

    Vector vctDepartments=(database.datatype.DataVector)ht.get(qryEjb.KEY_DEPARTMENTS);

    tempProperties.tmpOffShores.clear();
    tempProperties.tmpOffShores.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_OFFSHORE_CENTERS));

    //update tempProperties.tmpH_tbl_CenterDepMap;
    updateCenterDepMap(vctDepartments);

    tempProperties.tmpDepartment.removeAllElements();
    tempProperties.tmpDepartment.addAll((Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
                                         util.PublicVariable.OPERATTING_CENTER));
    /*
    for(int i=0;i<tempProperties.tmpDepartment.size();i++){
      Object obj=tempProperties.tmpDepartment.get(i);
      if(obj instanceof Record){
        System.out.println("department object,type as record, is="+((Record)obj).toString());
      }else{
        System.out.println("department object,type IS NOT RECORD, is="+obj.toString());
      }
    }*/



    tempProperties.tmpDivision.clear();
    tempProperties.tmpDivision.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_DIVISION));
    updateBuyerDivisionMap(tempProperties.tmpDivision);

    tempProperties.tmpQtaCtg.clear();
    tempProperties.tmpQtaCtg.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_QUOTA_CATEGORY));

    tempProperties.tmpSeason.clear();
    tempProperties.tmpSeason.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_SEASON));

    tempProperties.tmpProdType.clear();
    //Vector vct=(Vector)ht.get(qryEjb.KEY_PRODUCT_TYPES);
    /*
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      System.out.println("prod type is :"+rec.toString());
    }*/

    //System.out.println("----------------XXXXXXXXXX--------------------");
    tempProperties.tmpProdType.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_PRODUCT_TYPES));
    /*
    for(int i=0;i<tempProperties.tmpProdType.size();i++){
      Record rec=(Record)tempProperties.tmpProdType.get(i);
      System.out.println("prod type is :"+rec.toString());
    }*/

    tempProperties.tmpManagerRecs.clear();
    tempProperties.tmpManagerRecs.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_USER_MANAGERS4PROD_EDIT));

    tempProperties.tmpPriceTerm.clear();
    tempProperties.tmpPriceTerm.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_PROD_PRICE_TERM));

    tempProperties.tmpPaymentTerms.clear();
    tempProperties.tmpPaymentTerms.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_PROD_PAYMENT_TERM));

    tempProperties.tmpUnits.clear();
    tempProperties.tmpUnits.addAll((database.datatype.DataVector)ht.get(qryEjb.KEY_UNITS));
    newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD=(database.datatype.Record)
          ht.get(qryEjb.KEY_SYSTEM_DEFAULT_VALUE_RECORD);
    //tempProperties.tmpH_tbl_CntyCityMap.clear();
    //tempProperties.tmpH_tbl_CntyCityMap.putAll((java.util.Hashtable)ht.get(qryEjb.KEY_VECTOR_MAP_OF_CITIES));
    //newtimes.preproduction.process.GetCities.getCityMap(qryEjb,null);

    newtimes.preproduction.guis.tempProperties.tmpH_tbl_CntyCityMap.clear();

    java.util.Hashtable hm= qryEjb.getCntyCities(
     ","+(String)util.PublicVariable.OPERATTING_CENTER+","
     );
    newtimes.preproduction.guis.tempProperties.tmpH_tbl_CntyCityMap.putAll(hm);
    /*
    Vector vctCnty=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,"select CNTY_NAME from country order by CNTY_NAME",
      1,9999);
    String centerCode=","+(String)util.PublicVariable.OPERATTING_CENTER+",";
    for(int i=0;i<vctCnty.size();i++){
      database.datatype.Record rec=(database.datatype.Record)vctCnty.get(i);
      String strCnty=(String)rec.get(0);
      Vector vctCities=qryEjb.getCityOfCountry(strCnty,centerCode);
      newtimes.preproduction.guis.tempProperties.tmpH_tbl_CntyCityMap.put(strCnty,vctCities);
    }*/



    tempProperties.tmpDepartment.clear();
    tempProperties.tmpDepartment.addAll((Vector)
                                        tempProperties.tmpH_tbl_CenterDepMap.get(
                                        util.PublicVariable.USER_RECORD.get("usr_cen_code").toString()));
   //make NBF code records

    database.datatype.Record rec=(database.datatype.Record)util.MiscFunc.deepCopy(tempProperties.tmpCurrency.get(0));
    rec.getFieldName().clear();
    rec.getValueFields().clear();

    database.datatype.Record rec2Dup4YesNoNull=
        (database.datatype.Record)util.MiscFunc.deepCopy(rec);

    if(tempProperties.tmpNBFcode.size()==0){
      for (int i = 0; i < 3; i++) {
        database.datatype.Record rec2input = (database.datatype.Record)util.
            MiscFunc.deepCopy(rec);
        rec2input.getFieldName().add("NBF");
        if (i == 0) {
          rec2input.getValueFields().add("N");
        } else if (i == 1) {
          rec2input.getValueFields().add("B");
        } else {
          rec2input.getValueFields().add("F");
        }
        tempProperties.tmpNBFcode.add(rec2input);
      }
    }
    //compose the NTHK's subgroup code vector
    if(newtimes.preproduction.guis.tempProperties.tmpHkSubGrp4Update.size()==0 &&
       util.PublicVariable.OPERATTING_CENTER.equals("NTHK") ){
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       "select * from HK_SUB_GRP",1,9999);
      newtimes.preproduction.guis.tempProperties.tmpHkSubGrp4Update.addAll(vct);
      Vector vct4SubGrp=new Vector();
      for(int i=0;i<vct.size();i++){
        Record recSubGrp=(Record)vct.get(i);
        if(recSubGrp.getInt("RECORD_DELETE_FLAG")==1){
          vct4SubGrp.add(util.MiscFunc.deepCopy(recSubGrp));
        }
      }
      newtimes.preproduction.guis.tempProperties.tmpHkSubGrp.addAll(vct4SubGrp);
    }
    if(tempProperties.tmpYesNoNull.size() ==0){
      for (int i = 0; i < 2; i++) {
        database.datatype.Record rec2input =
            (database.datatype.Record)util.MiscFunc.deepCopy(rec2Dup4YesNoNull);
        rec2input.getFieldName().add("YES_NO_NULL");
        if (i == 0) {
          rec2input.getValueFields().add("Y");
        } else if (i == 1) {
          rec2input.getValueFields().add("N");
        } else {
          rec2input.getValueFields().add(null);
        }
        tempProperties.tmpYesNoNull.add(rec2input);
      }
    }

    //also,prepare the ship mode list.
    java.util.Vector vctShipMode=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from ship_modes",1,99999);

   newtimes.preproduction.guis.tempProperties.tempShipModes.clear();
    for(int i=0;i<vctShipMode.size();i++){
        newtimes.preproduction.guis.tempProperties.tempShipModes.add(vctShipMode.get(i));
    }
    //for accouting and shipping in NTHK centers,have to prepare the mangager map and centers
    String loginCenCode=util.PublicVariable.OPERATTING_CENTER.toString();
    int loginLevel=util.PublicVariable.USER_RECORD.getInt(2);//level code
    //'NTHK','NTFE','NTD','NJ','CG','PW','AE','BW'

    if(loginLevel==newtimesejb.preproduction.PreProductionHead.USER_TYPE_CEO){
        getNthkCetnersManagers();
    }else{
      tempProperties.tmpHm_Managers4AllCenters.put(util.PublicVariable.OPERATTING_CENTER,
                                                   tempProperties.tmpManagerRecs);
    }
    //tempProperties.tmpHm_Managers4AllCenters.put(util.PublicVariable.OPERATTING_CENTER,tempProperties.tmpManagerRecs);

    isAllDataReady=true;
    System.out.println("isAllDataReady=true");
  }
}
