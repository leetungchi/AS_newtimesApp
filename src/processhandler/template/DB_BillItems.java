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

public class DB_BillItems extends DB_BillMaster{
  protected String txn_user=null;
  protected String txn_date=null;
  public DB_BillItems() {
    try {
      Database db = new Database("jdbc:oracle:thin:@127.0.0.1:1521:ORCL",
                                 "newtimes", "newtimes",
                                 "oracle.jdbc.driver.OracleDriver",
                                 10, new OracleEncoder());
      myTblIntf = new CommonTable("BILL_detail", db, "record_create_date");
      blankRecord = myTblIntf.newRecord();
      //blankRecord.set("paid",0);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception{
    String sql="select * from bill_detail";
      sql+=" where txn_date = '";
      sql+=txn_date;
      sql+="' and txn_user='"+txn_user+"'";
    Vector vct=myTblIntf.SQL2Records(
     sql,startPosition,rowCounts
    );
    if(vct==null) throw new java.sql.SQLException("Exception while "+sql +" executing");
    return vct;
  }
  public Record addRecord(Record rec2add) throws Exception{
    Record rec=getBlankRecord();
    rec.set("txn_user",txn_user);
    rec.set("txn_date",txn_date);
    rec.set("item","item");
    rec.set("qty",0);
    rec.set("record_create_user","test user");
    myTblIntf.insertRecord(rec) ;
    return rec2add;
  }
}