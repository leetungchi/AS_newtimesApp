package database.datatype;
import java.sql.*;
import database.Database;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class OracleAutoIncTable extends AutoIncTable {
  String _seqObj=null;
  public OracleAutoIncTable(TableInterface table) {
     IniProcess(table,null);
  }
  public OracleAutoIncTable(TableInterface table,String seqObj) {
    IniProcess(table,seqObj);
  }
  private void IniProcess (TableInterface table,String seqObj){
    iniTable=table;
    _seqObj=seqObj;
    try{
       String iniPKString=iniTable.getPKColumns();
       String iniTableName=iniTable.getTableName();
       Database iniDb=iniTable.getDataBase();
       this.db=iniTable.getDataBase();
       commontable=new CommonTable(iniTableName,iniDb,iniPKString);
       pk=commontable.pk;
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"watch out,common table is null in AutoIncTable");
      e.printStackTrace();
    }
  }
  public void setSEQ(String seqObj){_seqObj=seqObj;}
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
         rs=stm.executeQuery("select "+_seqObj+".nextval from dual");
         if(rs.next()){
            xntSn=(long)rs.getInt("nextval");
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
