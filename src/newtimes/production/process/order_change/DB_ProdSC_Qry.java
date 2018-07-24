package newtimes.production.process.order_change;
import java.util.*;
import database.datatype.*;
import newtimes.production.process.audit_sc_ct.DB_ProdCnfm;

public class DB_ProdSC_Qry extends DB_ProdCnfm {
  String scNo;
  public DB_ProdSC_Qry(){
  }
  public Vector getRecord(String SC_NO)throws Exception{
    HashMap hm=new HashMap();
    hm.put(ourEJB.CONDITION_ON_SC_NO,SC_NO);
    return ourEJB.getRecords(hm,1,1);
  }
}