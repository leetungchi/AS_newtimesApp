package info_ejb;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class WeblogicServiceLocator {
  static private javax.naming.Context initContext=null;
  public WeblogicServiceLocator() {

  }
  /**
   * to lookup and create an ejb service in a weblogic server.
   * @param wblHostAt:just simplly the host name,no need to assign protocol(t3),use default port:7001
   * @param EJBbeanName:the return EJB remote object name,<br>
   *    according to this name,we will create a home named as EJBRemoteName+"Home"<br>
   *<font color=red>please note that,this EJBbeanName should be headed with full package path,such as "Newtimes.User.ChkUsrBean"</font>
   * @return EJBHome,the EJBHome object for client to create ejbremote interface
   * @throws Exception:may caused by remoted exception.
   */

   static public EJBHome locateServiceHome(String wblHostAt,String EJBRemoteName)throws Exception{
     //return locateServiceHome(wblHostAt,7001,EJBRemoteName);
     EJBHome returnHome=null;
     try{
       returnHome=locateServiceHome(wblHostAt,7001,EJBRemoteName);
     }catch(Exception exp){
       util.ExceptionLog.exp2File(exp,"server at"+wblHostAt+" ejbHomeName:"+EJBRemoteName);
       exp.printStackTrace();

     }
     if(returnHome!=null)return returnHome;
     try{
       returnHome=locateServiceHome(wblHostAt,7001,EJBRemoteName);
     }catch(Exception exp){
       util.ExceptionLog.exp2File(exp,"server at"+wblHostAt+" ejbHomeName:"+EJBRemoteName);
       exp.printStackTrace();

     }
     if(returnHome!=null)return returnHome;
     //final try
     returnHome=locateServiceHome(wblHostAt,7001,EJBRemoteName);
     return returnHome;
   }
  /**
   * to lookup and create an ejb service in a weblogic server.
   * @param wblHostAt.just simplly the host name,no need to assign port No. and protocol type(t3).
   * @param portNo,suggested value is 7001
   * @param EJBbeanName:the return EJB remote object name,<br>
   *    according to this name,we will create a home named as EJBRemoteName+"Home"<br>
   *   <font color=red>please note that,this EJBbeanName should be headed with full package path,such as "Newtimes.User.ChkUsrBean"</font>
   * @return EJBHome,the EJBHome object for client to create ejbremote interface
   * @throws Exception:may caused by remoted exception.
   */
 static public EJBHome  locateServiceHomeNewContext(String wblHostAt,int portNo,String EJBRemoteName)throws Exception{
   Context ctxInit=null;
     String urlStr = "t3://" + wblHostAt + ":" + portNo;
     Properties properties = new Properties();
     properties.put(Context.INITIAL_CONTEXT_FACTORY,
                    "weblogic.jndi.WLInitialContextFactory");
     properties.put(Context.PROVIDER_URL, urlStr);
     properties.put(Context.SECURITY_PRINCIPAL, "jndi_user");
     properties.put(Context.SECURITY_CREDENTIALS, "newtimes"); // password == null ? "" : password);
     ctxInit = new InitialContext(properties);
   //look up jndi name
   String[] getNamesOb = util.MiscFunc.split(EJBRemoteName, ".");
   Object ref = ctxInit.lookup(getNamesOb[getNamesOb.length - 1]);
   ClassLoader currLoader = Thread.currentThread().getContextClassLoader();
   Class remoteHomeClass = currLoader.loadClass(EJBRemoteName + "Home");
   return (javax.ejb.EJBHome)PortableRemoteObject.narrow(ref, remoteHomeClass);
 }
  static public EJBHome  locateServiceHome(String wblHostAt,int portNo,String EJBRemoteName)throws Exception{
      if(null==initContext){
         String urlStr="t3://"+wblHostAt+":"+portNo;

         Properties  properties = new Properties();
         properties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
         properties.put(Context.PROVIDER_URL, urlStr);
         properties.put(Context.SECURITY_PRINCIPAL, "jndi_user");
         properties.put(Context.SECURITY_CREDENTIALS,"newtimes");// password == null ? "" : password);

         initContext  =  new InitialContext(properties);
      }

    //look up jndi name
    String[] getNamesOb=util.MiscFunc.split(EJBRemoteName,".");
    Object ref = initContext.lookup(getNamesOb[getNamesOb.length-1]);
    ClassLoader currLoader=Thread.currentThread().getContextClassLoader();
    /*
    if(currLoader instanceof java.net.URLClassLoader ){
      java.net.URL[] urls=((java.net.URLClassLoader)currLoader).getURLs();
      for(int i=0;i<urls.length;i++){
        System.out.println(" URL :"+urls[i].getPath());
      }
    }*/
    Class remoteHomeClass= currLoader.loadClass(EJBRemoteName+"Home");
  //Class.forName(EJBRemoteName+"Home");
    //cast to Home interface
    //initContext.close();

    return (javax.ejb.EJBHome) PortableRemoteObject.narrow(ref, remoteHomeClass);

  }
  /*
  static private Context getInitialContext(String _url)throws Exception{
    //Thread.currentThread().setContextClassLoader(weblogic.jndi.WLInitialContextFactory.class.getClassLoader());
    String url=_url;
    Properties properties = null;
    try {
      properties = new Properties();
      properties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
      properties.put(Context.PROVIDER_URL, url);
      properties.put(Context.SECURITY_PRINCIPAL, "jndi_user");
      properties.put(Context.SECURITY_CREDENTIALS,"newtimes");// password == null ? "" : password);

      return new InitialContext(properties);
    }
    catch(Exception e) {
      util.ExceptionLog.exp2File(e,"exp while getIniCntx");
      throw e;
    }
  }*/
}
