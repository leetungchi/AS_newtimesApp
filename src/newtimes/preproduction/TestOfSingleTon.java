package newtimes.preproduction;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TestOfSingleTon {
  public static java.util.HashMap keis=new java.util.HashMap();
  public TestOfSingleTon() {
    AExecuter e1=new AExecuter(1);
    AExecuter e2=new AExecuter(2);
    AExecuter e3=new AExecuter(3);
    AExecuter e4=new AExecuter(4);
    AExecuter e5=new AExecuter(5);
    new Thread(e1).start();
    new Thread(e2).start();
    new Thread(e3).start();
    new Thread(e4).start();
    new Thread(e5).start();
  }
  public static void main(String[] args) {
    try{
     util.PublicVariable.SERVER_URL="127.0.0.1";
     util.ExceptionLog.setLogPath("c:\\testOfSinglten.log");
     TestOfSingleTon testOfSingleTon1 = new TestOfSingleTon();
    }catch(Exception e){
      e.printStackTrace();
      System.exit(-1);
    }
  }
  class AExecuter implements Runnable {
    int myId;
    public AExecuter(int id){
      myId=id;
    }
    public void run(){
      for (int i = 0; i < 1000; i++) {
        try {
          newtimesejb.singletons.FabricNoFactoryHome ejbhome =
              (newtimesejb.singletons.FabricNoFactoryHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.singletons.FabricNoFactory");
           newtimesejb.singletons.FabricNoFactory ejb = ejbhome.create();
           String keyId=String.valueOf(ejb.getFabricNo(myId));
           System.out.println(" id :"+myId+" get value:"+keyId);
           if(keis.containsKey(myId+"_"+keyId)){
             throw new Exception("Key "+myId+"_"+keyId+" dupplicated!!:");
           }
           keis.put(myId+"_"+keyId,null);
           Thread.sleep(100);
        }
        catch (java.io.InterruptedIOException ite) {

        }
        catch (Exception e) {
          e.printStackTrace();
        }

      }
       System.out.println(myId+" finish job");
    }
  }
}