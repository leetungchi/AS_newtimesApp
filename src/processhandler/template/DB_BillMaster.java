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

public class DB_BillMaster implements exgui.ultratable.PagedDataFactory  {
    TableInterface myTblIntf=null;
    protected String BuyerName="";
    protected String BuyerTimeString="";
    protected int isPaid=0;
    protected Record rec2Update=null;
    protected Record copiedRecord=null;
    protected Record blankRecord=null;
    String keywordFromQryGUI=null;
     /*
       methods of  PagedDataFactory
       for the function of "LIST Queried Master record "
      */
     public DB_BillMaster(){
       try{
         Database db = new Database("jdbc:oracle:thin:@127.0.0.1:1521:ORCL",
                                    "newtimes", "newtimes",
                                    "oracle.jdbc.driver.OracleDriver",
                                    10, new OracleEncoder());
         myTblIntf = new CommonTable("BILL_MASTER", db, "TXN_DATE");
         blankRecord=myTblIntf.newRecord();
         blankRecord.set("paid",0);
       }catch(Exception e){
          e.printStackTrace();
       }
     }
     public void setKeyWord(String keyword){
       keywordFromQryGUI=keyword;
     }
     public Vector getRecords(int startPosition, int rowCounts) throws Exception{
       String sql="select * from bill_master";
       if(keywordFromQryGUI.trim().length()!=0){
         sql+=" where txn_user like '%";
         sql+=keywordFromQryGUI;
         sql+="%'";
       }
       Vector vct=myTblIntf.SQL2Records(
        sql,startPosition,rowCounts
       );
       if(vct==null) throw new java.sql.SQLException("Exception while "+sql +" executing");
       return vct;
     }
     //this function is not supposed to be used
     public void deleteRecord(Record rec2delete) throws Exception{
       rec2delete.set("record_delete_user","test user");
       myTblIntf.deleteRecord(rec2delete);
     }
     public void restoreRecord(Record rec2restore) throws Exception{
        return;
     }
     public Record addRecord(Record rec2add) throws Exception{
       rec2add.set("record_create_user","test user");
       myTblIntf.insertRecord(rec2add) ;
       return rec2add;
     }
     public Record getBlankRecord() throws Exception{
        return (Record)util.MiscFunc.deepCopy(blankRecord);
     }
     public void updateRecords(Vector recs2update) throws Exception{
        for(int i=0;i<recs2update.size();i++){
           Record tmpRec=(Record)recs2update.get(i);
           if(tmpRec.get("record_create_date")==null){
             java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
             tmpRec.set("record_create_date",date);
             tmpRec.set("record_create_user","test user");
             tmpRec.set("txn_date",Long.toString(date.getTime()));
             myTblIntf.insertRecord(tmpRec);
           }else{
             tmpRec.set("record_modify_user","test user");
             myTblIntf.updateRecord(tmpRec);
           }
        }
     }
      public boolean listforRestore(){
        return false;
     }
}
