package newtimes.preproduction.process;

public class GetCities {
  public GetCities() {
  }
  public static void getCityMap(newtimesejb.preproduction.Query ejb,
                           java.util.Vector countries
                           )throws Exception{
     newtimes.preproduction.guis.tempProperties.tmpH_tbl_CntyCityMap.clear();
     java.util.Hashtable hm= ejb.getCntyCities(
      ","+(String)util.PublicVariable.OPERATTING_CENTER+","
      );
     newtimes.preproduction.guis.tempProperties.tmpH_tbl_CntyCityMap.putAll(hm);

   /*
    ejb.getCntyCities(countries);
    java.util.List  runnableList=new java.util.ArrayList();
    for(int i=0;i<countries.size();i++){
      database.datatype.Record rec=
          (database.datatype.Record)countries.get(i);
      runnableList.add(new ToRun(ejb,(String)rec.get(0)));
    }
    SynchRequestor.addAndRunThread(runnableList);
    */
  }
}
/*
class ToRun implements Runnable{
  newtimesejb.preproduction.Query _ejb;
  String country_name;
  ToRun(newtimesejb.preproduction.Query ejb,String countryName){
    _ejb=ejb;
    country_name=countryName;
  }
  public void run(){
    try{
      //System.out.println("reqesting city of "+country_name+" begin");
     java.util.Vector vct=_ejb.getCityOfCountry(country_name,","+
                                                (String)util.PublicVariable.OPERATTING_CENTER+",");
     if(vct!=null){
       newtimes.preproduction.guis.tempProperties.tmpH_tbl_CntyCityMap.put(
             country_name,vct);
     }
     //System.out.println("reqesting city of "+country_name+" END");
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}*/

