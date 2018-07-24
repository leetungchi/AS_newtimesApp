package newtimes;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.alee.laf.WebLookAndFeel;
import com.alee.managers.WebLafManagers;
import com.incors.plaf.alloy.AlloyLookAndFeel;

import ch.randelshofer.quaqua.QuaquaManager;

import org.violetlib.aqua.AquaLookAndFeel;


import java.awt.*;
import java.io.*;
import database.datatype.Record;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class NewtimesApp {
  private static String OS = System.getProperty("os.name").toLowerCase();	
  private boolean packFrame = false;  
  public static String VERSION = "2.1";
  static String conf_file_at;
  static  SplashScreen splasher= new SplashScreen();
  //Build:yyMMddHH
  public static final String BUILD_VER = "04072814";
  //public static int instanceCount=0;
  public static String JarFolderAt=null;
  public NewtimesApp() {
    Frame1 frame = new Frame1();
    EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();
    //final java.lang.ClassLoader myClassLoarder=this.getClass().getClassLoader();
    try{
     eq.invokeAndWait(new Runnable()
     {
      public void run(){
        newtimes.preproduction.process.AttributeFactory att=new
            newtimes.preproduction.process.AttributeFactory();
         //Thread.currentThread().setContextClassLoader(att.getClass().getClassLoader());
         Thread.currentThread().setContextClassLoader(weblogic.jndi.WLInitialContextFactory.class.getClassLoader());

       System.out.println("System ClassLoader is :"+ClassLoader.getSystemClassLoader().getClass().getName());
       System.out.println("Current ClassLoader is "+this.getClass().getClassLoader().getClass().getName());
       System.out.println("Parent of Current ClassLoader is "+this.getClass().getClassLoader().getParent().getClass().getName());



      }
    });
    }catch(Exception e){
      e.printStackTrace();
    }
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    if(screenSize.width==800 && screenSize.height==600){
      frame.setLocation(0,-20);
    }else
      frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setResizable(false);
    frame.setVisible(true);
    splasher.hide();
    SecurityManager sm=System.getSecurityManager();

    if(sm!=null){
      System.out.println("System security is "+sm.getClass().getName());
      Object objctx=sm.getSecurityContext();
      if(objctx!=null)System.out.println("System Security Context is is :"+objctx.toString());
    }
  }







  public static void main(String[] args) {
    try {
      
      java.text.DecimalFormat dfx=new java.text.DecimalFormat("#########0.00");
      System.out.println(dfx.format(123.235));

      java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      System.out.println("Before Set Time Sonze --client time "+System.currentTimeMillis()+"  "+df.format(new java.util.Date(System.currentTimeMillis())));
      java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Taipei"));



      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      exgui.UIHelper.setToScreenCenter(splasher);
      //splasher.setLocation((screenSize.width - 400) / -2,(screenSize.height - 200) / 2);
      splasher.setSize(new Dimension(400,200));
      splasher.setSize(400,200);
      splasher.show();
      if (OS.indexOf("mac") >= 0) {    	
    	  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
      } else {
         UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
      }   
 //     UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
      
  //    UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName () );
  //    WebLafManagers.initialize ();
      
  /*    
      if (OS.indexOf("win") >= 0) {
    	  System.out.println("O/S : "+OS);
    	  LookAndFeel.Alloy_LookAndFeel();
      } else if (OS.indexOf("mac") >= 0) {    	 
    	  System.out.println("O/S : "+OS);
    	  UIManager.setLookAndFeel("org.violetlib.aqua.AquaLookAndFeel");
      } else if (OS.indexOf("sunos") >= 0) {
    	  System.out.println("O/S : "+OS);
    	  LookAndFeel.Alloy_LookAndFeel();
      } else {
    	  System.out.println("O/S : Unix");
    	  LookAndFeel.Alloy_LookAndFeel();
      }
  */    
      //set Alloy Look-and-Feel\
  //    LookAndFeel.Alloy_LookAndFeel();
  //    UIManager.setLookAndFeel(new WebLookAndFeel ());
      //String AP_SERVER = "192.168.0.178";
      //String REPORT_SERVER = "192.168.0.178";

      //String AP_SERVER = "p.nttpe.com.tw";
      String REPORT_SERVER = "p.nttpe.com.tw";

      //String AP_SERVER = "172.16.17.178";
      //String REPORT_SERVER = "172.16.0.72,172.16.17.178";
    //as0 is 27
    //as2 is 25
    //as1 is 28
      //String AP_SERVER = "220.130.146.128";
       String AP_SERVER = "p.nttpe.com.tw";
      //String REPORT_SERVER = "as1.nttpe.com.tw,as.nttpe.com.tw,as0.nttpe.com.tw";
      //String AP_SERVER = "192.168.0.168";
      //String REPORT_SERVER = "192.168.0.168";

      //String AP_SERVER = null;
      //String REPORT_SERVER = null;

       //for NewtimesWS.jnlp
      //System.out.println("read from jnlp: ap server="+System.getProperty("AP_SERVER"));
      //System.out.println("read from jnlp: ap printer at="+System.getProperty("REPORT_SERVER"));


      /*
      System.out.println("D:\\ChagePrinterCPP\\Debug>ChagePrinterCPP.exe  \"SnagIt 8\"");
      java.lang.Runtime rt=java.lang.Runtime.getRuntime();
      rt.exec("D:\\ChagePrinterCPP\\Debug\\ChagePrinterCPP.exe  \"SnagIt 8\"");
      System.out.println("Should default printer changed ?");
      */
      if(System.getProperty("AP_SERVER")!=null)AP_SERVER=System.getProperty("AP_SERVER");
      if(System.getProperty("REPORT_SERVER")!=null)REPORT_SERVER=System.getProperty("REPORT_SERVER");

      String serverURL0=util.MiscFunc.split(AP_SERVER,",")[0];
      java.net.InetAddress inet = java.net.InetAddress.getByName(serverURL0);
      String ipAddress=inet.getHostAddress();
 /*     if(!ipAddress.startsWith("172.16")){
        //this connection is through internet
        //have to check jdk version
        String javaVer=System.getProperty("java.version");
        System.out.println(javaVer);
        if(!(javaVer.startsWith("1.4.1_")||javaVer.startsWith("1.4.0_"))){
          exgui.verification.VerifyLib.showAlert("For Internet Connecting User\nPlease Run This System By JRE 1.4.1_X",
                                                 "JRE version Not Allowed");
          //Exception exp=new Exception("JRE miss-match,running by "+javaVer);
          //util.ExceptionLog.exp2File(exp,"");
          System.exit(1);
        }
      } */



      //String REPORT_SERVER=System.getProperty("REPORT_SERVER");
      System.out.println("AP_SERVER:"+AP_SERVER);
      System.out.println("REPORT_SERVER:"+REPORT_SERVER);
      System.out.println("VERSION:"+VERSION);
     // System.out.println("Instance Count :"+instanceCount);
      util.PublicVariable.SERVER_URL = AP_SERVER;
      util.PublicVariable.REPORT_SERVER_AT = REPORT_SERVER;

      //------------------ log setting -----------------------------------------
      String urlPaths[] = util.MiscFunc.split(exgui.UIHelper.getFolderURL(
                          "images/newtimesClinetException.log").toString(),"/");
      for(int i=0;i<urlPaths.length;i++){
         System.out.println("url paths:"+urlPaths[i]);
      }

      String logDestLog="";
      for(int i=1;i<urlPaths.length-3;i++){
        if(urlPaths[i].startsWith(".")){
          logDestLog="/"+logDestLog;
          break;//for linux hidden directory...
        }
      }

      logDestLog+="newtimesClinetException.log";
      System.out.println("exception log set to :"+logDestLog);
 //   util.ExceptionLog.setLogPath(logDestLog);

      //-------------------- Defined EJBs -----------------------------------
      DefinesEJBs.setEJBs();

      //-------------------- Sticker Properties -----------------------------
      String STICKER_PATH = System.getProperty("STICKER_PATH");
      System.out.println("STICKER_PATH:"+STICKER_PATH);
      //exgui2.CONST.Sticker_EJB.setStickerProperties(STICKER_PATH);
      newtimesejb.TPE_MIS.TpeMisFuncHome tpeMisEjbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc tpeMisEjb=tpeMisEjbHome.create();
      java.util.HashMap hm=new java.util.HashMap();
      java.util.Date clientDate=new java.util.Date(System.currentTimeMillis());
      System.out.println("client time "+System.currentTimeMillis()+"  "+df.format(clientDate));
      hm.put("TPEMISCFUNC_ACTION_CODE","GET_SERVER_TIME_IN_MILLIS");
      long ServerTime=((Long)(tpeMisEjb.tpeMisFunc(hm).get("SERVER_TIME_IN_MILLIS"))).longValue();
      java.util.Date serverDate=new java.util.Date(ServerTime);
      System.out.println("Server time "+ServerTime+" "+df.format(serverDate));
      //if time diff between server and client,prompt user to adjust his/her pc
      util.PublicVariable.LISTEN_2_NEWTIMES_INCOMMING_MESSAGE=new newtimes.message.TopicMessenger();
      if(java.lang.Math.abs((serverDate.getTime()-clientDate.getTime()))> (5*3600*1000)){
        exgui.verification.VerifyLib.showAlert("Time Diff between Server Too Much\nPlease Check Your PC Date & Time",
                                               "Server & Client Date Diff too Much");
        Exception exp=new Exception("Client Time "+df.format(clientDate)+" Server Time "+df.format(serverDate));
        util.ExceptionLog.exp2File(exp,"");
        System.exit(1);
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    new NewtimesApp();
  }

  
}
