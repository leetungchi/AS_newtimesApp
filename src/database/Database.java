package database;
import java.sql.*;
import database.Encoder;
import util.*;
/**
 * Title: database object
 * Description:co-operate with transaction function,and also owns connection pool management.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author:john.cheng(Crazy John).
 * @version 1.0
 */
 /*
   to use the Re-Use Connection depend on the need of table Object,specially in transaction mode.
 */

public class Database {
  Connection con=null;
  Connection reUseConnection=null;
  private ConnectionPool conPool=null;
  Encoder encoder;
  protected boolean isProcessingTransaction=false;
  /**
   * @param url
   * @param id
   * @param passwd
   * @param driver
   * @param maxConnectionCount
   * @param SQLEncoder,for need of composing SQL
   */
  public Database(String url,String id,String passwd,String driver,int maxConnCount ,Encoder _encoder) {
   System.out.println("creating database object");
   encoder=_encoder;
   conPool=new ConnectionPool(url,driver,id,passwd,maxConnCount);
  }
  /**
   * get connection for sql qury.
   * @return connection,if trnasction on,the return connection is preserve one.
   */
  public Connection  getConnection(){
     try{
       if(isProcessingTransaction && reUseConnection!=null){
         if(reUseConnection.getAutoCommit()) reUseConnection.setAutoCommit(false);
         return reUseConnection;
       }
       if(isProcessingTransaction && reUseConnection==null){
         reUseConnection=conPool.getConnection();
         reUseConnection.setAutoCommit(false);
         return reUseConnection;
       }
       Connection con= conPool.getConnection();
       if(con==null) return null;
       con.setAutoCommit(true);
       return con;
     }catch(java.sql.SQLException sqe){
       util.ExceptionLog.exp2File(sqe,"exp while getConnection,maybe unable to setAutoCommit attribe");
       return null;
     }
  }
  /**
   * to free a connection while table class finish sql query process,return the dispatched connection
   * @param con_in the returned connection
   */
  public void freeConnection(Connection con_in){
     if(con_in!=null){
       if(isProcessingTransaction){
          reUseConnection=con_in;
       }else{
          if(conPool!=null) conPool.freeConnection(con_in);
       }
     }
  }
  /**
   * @return current databse using encoding system.
   */
  public Encoder getEncoder(){
  	  return encoder;
  }
  /**
   * @return current databse using encoding system.
   */
  public void setEncoder(Encoder enc){
  	 encoder=enc;
  }
  /**
   * generate string as the encode result.
   * @param value as stirng to encode,able to void "'" problem.
   */
  public String encode( String value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as boolean
   */
  public String encode( boolean value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as integer type
   */

  public String encode( int value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as long type
   */

  public String encode( long value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as float type
   */

  public String encode( float value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as double type
   */

  public String encode( double value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as java.sql.Data type
   */

  public String encode( Date value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as java.sql.Tims type
   */
  public String encode( Time value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as java.sql.TimeStamp
   */

  public String encode( Timestamp value ) {
    return encoder.encode(value);
  }
  /**
   * generate string as the encode result.
   * @param value as java.lang.Objct,prefers int,long,float,double,java.sql.Data,string.
   */

 public String encode(Object value){
   return encoder.encode(value);
 }
 /**
  * to turn on "transaction"  status of this database object
  * next time,to getconnection.will useing the preserved one.
  */
 public void setTransactionOn(){
   isProcessingTransaction =true;
 }
 /**
  * to turn off "transaction"  status of this database object
  * allow to off new connection if do getConnectin() again.
  * and allow "doCommitNow()" to close the connection need by setTransaciontOn()
  */
 public void setTransactionOff(){
   isProcessingTransaction =false;
   //return the stored connection
   freeConnection(reUseConnection);
   reUseConnection=null;
 }
 /**
  * to ask the database to "commit" command if all sql statements go well<br>
  * <font color=red><b>
  *  note:this command should be called after setTransactionOff()
  *  ,becase this command will also close the connection which is needed by transaction
  *  if setTransactionOff() is porformed,or,just keep this connection serve for transaction
  * </b></font><br>
  * @exception java.sql.SQLException
  */
 public void doCommitNow() throws java.sql.SQLException {
   reUseConnection.commit();
   if(!isProcessingTransaction){
     if(reUseConnection!=null){
      conPool.freeConnection(reUseConnection);
      reUseConnection=null;
     }
   }
 }
 /**
  * for  connection switching task
  * required by project "Wincell"
  * @param url
  * @param id
  * @param passwd
  * @param driver
  * @param maxConnectionCount
  * @param SQLEncoder,for need of composing SQL
  */
 public void switchConnection(String url,String id,String passwd,String driver,int maxConnCount ,Encoder _encoder) {
   conPool=null;
   encoder=null;
   System.gc();
   encoder=_encoder;
   conPool=new ConnectionPool(url,driver,id,passwd,maxConnCount);
  }

 /**
  * to call database do RollBack procee.
  * always by need of sqle exception.
  * @exception java.sql.SQLException
  */
 public void doRollBack() throws java.sql.SQLException {
   reUseConnection.rollback();
 }
  protected  void finalize() throws Throwable{
    conPool.finalize();
    conPool=null;
    super.finalize();
 }
}