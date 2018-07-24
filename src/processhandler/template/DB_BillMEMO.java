package processhandler.template;
import database.datatype.*;
import database.*;
import database.encoders.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_BillMEMO extends DB_BillMaster {
  public DB_BillMEMO() {
    try{
    Database db = new Database("jdbc:oracle:thin:@127.0.0.1:1521:ORCL",
                               "newtimes", "newtimes",
                               "oracle.jdbc.driver.OracleDriver",
                               10, new OracleEncoder());
    myTblIntf = new CommonTable("BILL_MEMO", db, "TXN_DATE");
    blankRecord=myTblIntf.newRecord();
    //blankRecord.set("paid",0);
  }catch(Exception e){
     e.printStackTrace();
  }
 }
 public Vector getRecords(int startPosition, int rowCounts) throws Exception{
   String sql="select * from bill_memo";
   if(keywordFromQryGUI.trim().length()!=0){
     sql+=" where txn_date = '";
     sql+=keywordFromQryGUI;
     sql+="'";
   }
   Vector vct=myTblIntf.SQL2Records(
    sql,startPosition,rowCounts
   );
   if(vct==null) throw new java.sql.SQLException("Exception while "+sql +" executing");
   return vct;
 }
 public void updateRecords(Vector records)throws Exception{
   Record rec=(Record)records.get(0);
   if(rec.get("record_create_date")==null){
     java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
     rec.set("record_create_date",date);
     rec.set("record_create_user","test user");
     myTblIntf.insertRecord(rec);
   }else{
     rec.set("record_modify_user","test user");
     myTblIntf.updateRecord(rec);
   }
 }
}