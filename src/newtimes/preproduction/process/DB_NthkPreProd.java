package newtimes.preproduction.process;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_NthkPreProd extends DB_Preprod {
  protected static DB_Preprod instanceOfDB_NthkPreProd;
  public DB_NthkPreProd() {
    super();
    instanceOfDB_NthkPreProd=null;
  }
  public static DB_Preprod getInstance(){
    if(!initOK||instanceOfDB_NthkPreProd==null)instanceOfDB_NthkPreProd= new DB_NthkPreProd();
    return instanceOfDB_NthkPreProd;
  }
  public void deleteRecord(Record rec2delete)throws Exception{
    ejb.deleteNthkRecord(rec2delete);
  }
  public Record addRecord(Record rec2add) throws Exception{
    String userID=(String)util.PublicVariable.USER_RECORD.get("usr_code");
    rec2add.set("record_modify_user",userID);
    rec2add=ejb.handlePreproductionAndHead4NTHK(rec2add,tempMTR_V_Records);
    return rec2add;
  }
}
