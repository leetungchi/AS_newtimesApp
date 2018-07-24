package util;
import java.io.*;
/**
 * Title:Exception log function
 * Description:this class should be set up before other class
 *               ,need to set the destination file name for login exception message of DataDase Classes to use.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author Crazy John.
 * @version 1.0
 */

public class ExceptionLog {
  protected  static PrintWriter logFile=null;
  protected static java.io.OutputStream logFileOutStream=null;
  /**
   * set log file to folder of "images/newtimesClinetException.log" for webstart app formate
   * @throws Exception some authority of file access
   */
  public static void setLogPathToImageFolder() throws Exception {
    String urlPaths[]=util.MiscFunc.split(exgui.UIHelper.getFolderURL("images/newtimesClinetException.log").toString(),"/");
    for(int i=0;i<urlPaths.length;i++){
       System.out.println("url paths:"+urlPaths[i]);
    }

    String logDestLog="";
    for(int i=1;i<urlPaths.length-3;i++){
      if(urlPaths[i].startsWith(".")){
          break;//fro linux hidden directory...
      }
      logDestLog+=urlPaths[i]+"/";
    }
    if(System.getProperties().getProperty("file.separator").equals("/")){
     logDestLog="/"+logDestLog;
    }
    logDestLog+="newtimesClinetException.log";
    System.out.println("exception log set to :"+logDestLog);
    //logDestLog=util.MiscFunc.Replace(logDestLog,"/.","/./.");
    util.ExceptionLog.setLogPath(logDestLog);

  }
  /**
   * to generate a file for writing exceptions
   * @param filePath,the full path of exception file.
   */
  public static void setLogPath(String filePath) throws Exception {
    //this function should be called while system initialization
      logFile=new PrintWriter(new FileOutputStream(filePath,true));
  }
  public static void setLogURL(java.net.URL url) throws Exception{
    logFileOutStream=  url.openConnection().getOutputStream();
    logFile=new PrintWriter(logFileOutStream);
  }
  /**
   * to save exception print strack trace information into file.
   * @param exception to record,it should be helpful.
   * @param memo for this exception,you can pluse some runtime / design imforation.
   */
  public static void exp2File(Exception e,String memo){
     String timeString= new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.sql.Date(System.currentTimeMillis()));
     logFile.print(timeString + "---->");
     e.printStackTrace(logFile);
     logFile.println();
     logFile.println(memo);
     logFile.println();
     logFile.println();
     //logFile.close();
     logFile.flush();
  }
  protected void finalize() throws Throwable{
     if(logFile!=null) logFile.close();
  }
}