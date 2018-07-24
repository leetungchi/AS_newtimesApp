package database;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */
import java.sql.Connection;

public class DatabaseX extends Database {
  private javax.sql.DataSource ds=null;
  public DatabaseX(javax.sql.DataSource _ds,Encoder enc) {
     super(null,null,null,null,0,null);
     ds=_ds;
     encoder =enc;
  }
  public Connection getConnection(){
     Connection conp=null;
     try{
      conp= ds.getConnection();
      //always set autoCommit to false for ejb container to rollback.
      if(conp.getAutoCommit()==true)conp.setAutoCommit(false);
      return conp;
     }catch(java.sql.SQLException sqle){
      util.ExceptionLog.exp2File(sqle,"creating connection");
      return null;
     }
  }
  public void freeConnection(Connection con_in){
    try{
     con_in.close();
    }catch(java.sql.SQLException sqlExpR){
     util.ExceptionLog.exp2File(sqlExpR,"free connection");
    }
 }
}