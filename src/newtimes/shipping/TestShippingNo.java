package newtimes.shipping;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TestShippingNo {
  public static java.util.HashMap keis=new java.util.HashMap();
  java.util.HashMap hm = new java.util.HashMap();
  public TestShippingNo() {
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
     util.ExceptionLog.setLogPath("c:\\testShipingNo.log");
     TestShippingNo testShippingNo = new TestShippingNo();
    }catch(Exception e){
      e.printStackTrace();
      System.exit(-1);
    }
  }
  class AExecuter implements Runnable {
    int myId;
    public AExecuter(int id) {
      myId = id;
    }

    public void run() {
      for (int i = 0; i < 1000; i++) {
        try {
          SeqNoFactory.Shipping.ShippingSeqNoFtyHome seqNoFty_ejb_home =
              (SeqNoFactory.Shipping.ShippingSeqNoFtyHome)info_ejb.
              WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
              SERVER_URL,
              "SeqNoFactory.Shipping.ShippingSeqNoFty");
          SeqNoFactory.Shipping.ShippingSeqNoFty seqNoFtyEJB =
              seqNoFty_ejb_home.create();

          hm = seqNoFtyEJB.getSeqNo("000");
          System.out.println("#hm:"+hm.toString());
          System.out.println(" id :" + myId + " seq no :" +hm.get("lastSeqNo"));
          if (keis.containsKey(myId + "_" + hm.get("lastSeqNo"))) {
            throw new Exception("Key " + myId + "_" +
                                hm.get("lastSeqNo") +
                                " dupplicated!!:");
          }
          keis.put(myId + "_" + hm.get("lastSeqNo"), null);
          Thread.sleep(100);
        } catch (java.io.InterruptedIOException ite) {

        } catch (Exception e) {
          e.printStackTrace();
        }

      }
      System.out.println(myId + " finish job");
    }
  }
}