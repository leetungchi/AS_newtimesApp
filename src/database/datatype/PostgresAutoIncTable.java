package database.datatype;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2003</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class PostgresAutoIncTable extends database.datatype.OracleAutoIncTable  {
  public PostgresAutoIncTable(TableInterface table) {
    super(table);
  }
  public PostgresAutoIncTable(TableInterface table,String seqObj) {
    super(table,seqObj);
  }
  protected  long getNextSn()throws java.sql.SQLException{
     //directly find the nextval from seq object
     long xntSn=0;
      if(_seqObj==null){
        throw new java.sql.SQLException("seq object must be assign before inserting record to table:"+this.tableName+" by inforich's OracleAUtoIncTable class");
      }
      Connection con=null;
      ResultSet rs=null;
      Statement stm=null;
       try{
         con =db.getConnection();
         stm=con.createStatement();
         //rs=stm.executeQuery("select "+_seqObj+".nextval from dual");
         rs=stm.executeQuery("select nextval('"+_seqObj+"') as max");
         if(rs.next()){
            xntSn=(long)rs.getInt("max");
         }else{
           throw new java.sql.SQLException("this is no seq "+ _seqObj +" in this database.");
         }
       }catch(Exception e){
          throw new java.sql.SQLException("this is other exception in getNextSn process for table "+this.iniTable.getTableName()+" seq obj is:"+this._seqObj);
       }finally{
         if(rs!=null) rs.close();
         if(stm!=null) stm.close();
         db.freeConnection(con);
       }
     return xntSn;
  }

}
