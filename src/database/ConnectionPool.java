package database;
import java.sql.*;
import util.ExceptionLog;
/**
 * Title:connection pool class
 * Description:connetion pooling machenism
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author:John.Cheng(Crazy John)
 * @version 1.0
 */
/**
 * the idle connection with be close if free for 20 mins.
 * and also checking if the connection supports "ResultSet.TYPE_SCROLL_SENSITIVE" coursor type.
 * because we need connection able to scroll for table class to use.
 * the returned connection is just set to be "free",provide to next request to use.
 *
 * @param url the url of jdbc source connection
 * @param driver the driver name for connect to class.forName(....),to generat driver class by name
 * @param id,is login id for database
 * @param loginPasswd ,needs for database login
 * @param connectionCount ,the maximume conection to maintain.
 */

public class ConnectionPool {
  private Connection conns[];
  private boolean isFree[];
  private long lastFreeTime[];
  String dbURL;
  String dbDriver;
  String dbLoginID;
  String dbPasswd;
  java.util.Timer timer=null;
  int maxConnectionCount=0;
  //private boolean connsStatus[]=new boolean[1024];
  public ConnectionPool(String url,
                        String driver,
                        String id,
                        String loginPasswd,
                        int connectionCount) {
     dbURL=url;dbLoginID=id; dbPasswd=loginPasswd;
     dbDriver=driver;maxConnectionCount=connectionCount;
     conns=new Connection[maxConnectionCount];
     isFree=new boolean[maxConnectionCount];
     lastFreeTime=new long[maxConnectionCount];
     timer=new java.util.Timer(true);
     timer.schedule(new releaser(),0,20000);
     /*
     for(int i=0;i<connectionCount;i++){
        try{
         Class.forName(dbDriver);
         conns[i]=DriverManager.getConnection(dbURL,dbLoginID,dbPasswd);
        }catch(Exception e){
          e.printStackTrace();
        }
        isFree[i]=true;
        lastFreeTime[i]=System.currentTimeMillis();
     }*/
  }
 /**
  * get a connection.if no connection available.create by new connection
  * if null,exception.
  * @return java.sql.Connection.
  */
 protected synchronized Connection getConnection(){
  //check if any connection is free now,just offer it
  for(int i=0;i<maxConnectionCount;i++){
    if((conns[i]!=null) && isFree[i]){
      try{
        //test if connection is alive or now.
        Statement stm=conns[i].createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        isFree[i]=false;
        System.out.println("useing connectin No."+Integer.toString(i));
        return conns[i];
      }catch(Exception e){
        util.ExceptionLog.exp2File(e,"statement creation err in connection.");
        conns[i]=null;//the folowing processs will re-create connection if need
      }
    }

    if(conns[i]==null){
       try{
         Class.forName(dbDriver);
         conns[i]=DriverManager.getConnection(dbURL,dbLoginID,dbPasswd);
         //test if connection is work
         Statement stm=conns[i].createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
       }catch(Exception e){
         util.ExceptionLog.exp2File(e,"while create connection in connection pool");
         conns[i]=null;
         return null;
       }
         isFree[i]=false;
        System.out.println("creatting connection No."+Integer.toString(i));
         return conns[i];
    }
  }
  return null;

 }
 /**
  * set the "Free" status on but not to close,space to latter to use.
  * @param the returned connection from Database object
  */
 protected void freeConnection(Connection con){
     if(con!=null){
       System.out.println("returned connection to string"+con.toString());
       for(int i=0;i<maxConnectionCount;i++){
          //if(con.toString().equals(conns[i].toString())){
          //compare by referance
          if(conns[i]==null){
            isFree[i]=true;
            continue;
          }
        //System.out.println("connection"+Integer.toString(i) +"to string"+conns[i].toString() );
          if(con.toString().equals(conns[i].toString())){
            System.out.println("freeing connection "+Integer.toString(i));
            isFree[i]=true;
            lastFreeTime[i]=System.currentTimeMillis();
            continue;
          }
       }
     }
 }
 /**
  * if system close,we also need to close our connection.
  */
 protected void finalize() throws Throwable{
  try{
   //System.out.println("closing connection pool now");
     for(int i=0;i<maxConnectionCount;i++ ){
       if(conns[i]!=null){
         if(!conns[i].isClosed()) conns[i].close();
       }
     }
     if(timer!=null){
      timer.cancel();
      timer=null;
     }
   }catch(Exception e){
     util.ExceptionLog.exp2File(e,"exp while finalize in connection pool");
   }finally{
     super.finalize();
   }
  }
  class releaser extends java.util.TimerTask {
    public void run(){
     //System.out.println("running timer in connection pool");
      for(int i=0;i<maxConnectionCount;i++){
        if((conns[i]!=null)&& isFree[i]){
         //if connection is not in use for 2 min,close it
         //System.out.println("last free time of connection "+Integer.toString(i)+" is "+new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(lastFreeTime[i])));
         if(System.currentTimeMillis()-lastFreeTime[i] > 2000*60){
           System.out.println("Timer closing connection No."+Integer.toString(i));
           try{
             if(!conns[i].isClosed())conns[i].close();
             conns[i]=null;
           }catch(java.sql.SQLException sqe){
             conns[i]=null;
             for(int j=0;j<maxConnectionCount;j++)conns[j]=null;
             util.ExceptionLog.exp2File(sqe,"sqlexp while timer closing connection"+Integer.toString(i));
             break;
           }catch(Exception e){
             util.ExceptionLog.exp2File(e,"unknown exp while timer closing connection"+Integer.toString(i));
             continue;
           }
         }
        }
      }
    }
  }
}