package util;
import java.io.*;
/**
 * <p>Title: SQL log Object</p>
 * <p>Description: to log update/insert sql statement into a file,
 * once the application is activate ,please assign log path with "setLogPath(xxxpath)"
 * </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: metak.com.tw</p>
 * @author crazy john
 * @version 1.0
 */

public class SqlLog  {
  protected static java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss ");
  protected static java.text.DateFormat dfYMD=new java.text.SimpleDateFormat("yyyyMMdd");
  protected static String logFileDirString=null;
  protected static String  lastLogDateString=null;
  protected static java.io.PrintWriter  logFile=null;
  public SqlLog() {
     super();
  }
  public static void setLogDirectory(String logDirectory)throws Exception{
    java.io.File fileDir=new java.io.File(logDirectory);
    if(!fileDir.isDirectory()) throw new Exception("setLogDirectory of SQLLog must for file directory");
    //continue with current log file.
    if(logDirectory.endsWith("/")||logDirectory.endsWith("\\")){
    }else{
      logDirectory+=File.separator;
    }
    logFileDirString=logDirectory;
    lastLogDateString= dfYMD.format(new java.sql.Date(System.currentTimeMillis()));
    logDirectory+=lastLogDateString;
    logDirectory+=".log";
    File fObj=new File(logDirectory);
    logFile=new PrintWriter(new FileOutputStream(logDirectory,true));
  }
  public static void writeLog(String userId ,String sql2log){
    java.sql.Date logAt=new java.sql.Date(System.currentTimeMillis());
    String currentDateString=dfYMD.format(logAt);
    if(!currentDateString.equals(lastLogDateString)){
      if(logFile!=null){
        logFile.close();
      }
      String dstLogFile=logFileDirString+currentDateString+".log";
      File fObj=new File(dstLogFile);
      try{
       logFile=new PrintWriter(new FileOutputStream(dstLogFile,true));
      }catch(Exception e){
        e.printStackTrace();
        util.ExceptionLog.exp2File(e,"exp while switching sql date.");
      }
      lastLogDateString=currentDateString;
    }
    logFile.print("[date]"+df.format(logAt));
    logFile.print("[user]"+userId);
    logFile.print("[SQL]");
    logFile.println(sql2log);
    logFile.flush();
  }
  protected void finalize() throws Throwable{
     if(logFile!=null) logFile.close();
  }
}