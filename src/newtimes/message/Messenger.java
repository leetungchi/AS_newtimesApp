package newtimes.message;
import javax.jms.*;
import javax.jms.Queue;
import javax.naming.*;
import java.util.*;
import java.io.*;

public class Messenger implements MessageListener {
  protected QueueConnectionFactory jmsConnFactory = null;
  protected QueueConnection jmsConnection = null;
  protected Queue jmsQueue = null;
  protected QueueSession jmsSession = null;
  protected QueueSender jmsSender = null;
  protected QueueReceiver jmsReceiver = null;
  protected InitialContext jmsContext = null;
  public Messenger() {
    initJMS();
  }
  private void initJMS() {
      try {
        String hostName = util.PublicVariable.SERVER_URL;
        Hashtable env = new Hashtable();
        env.put(Context.PROVIDER_URL,
          "t3://" + hostName + ":7001");
        env.put(Context.INITIAL_CONTEXT_FACTORY,
          "weblogic.jndi.WLInitialContextFactory");
       env.put(Context.SECURITY_PRINCIPAL, "jndi_user" );
       env.put(Context.SECURITY_CREDENTIALS, "newtimes");

        jmsContext = new InitialContext(env);
        jmsConnFactory =(QueueConnectionFactory)
          jmsContext.lookup("weblogic.jndi.WLInitialContextFactory");
        jmsConnection = jmsConnFactory.createQueueConnection();
        jmsSession = jmsConnection.createQueueSession(false,
          Session.AUTO_ACKNOWLEDGE);
        jmsQueue =(Queue)jmsContext.lookup("jms.queue.TestQueue1");
        jmsConnection.start();
        jmsSender = jmsSession.createSender(jmsQueue);
        jmsReceiver = jmsSession.createReceiver(jmsQueue);
        jmsReceiver.setMessageListener(this);
      }
      catch(Exception e) {
        e.printStackTrace();
        System.out.println("Initialization failed");
      }
    }
  protected void finalize(){
    try{
      System.out.println("system closed");
      if (jmsConnection != null) {
        jmsConnection.stop();
        jmsConnection = null;
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public void sendMessage(String messageTxt)throws Exception{
    TextMessage message = jmsSession.createTextMessage();
    message.setText(messageTxt);
    jmsSender.send(message);
  }
  public void onMessage(Message msg){
       try {
        String messageContext= ((TextMessage)msg).getText();
        exgui.verification.VerifyLib.showPlanMsg(messageContext,"Newtimes EIP Server BroadCast");
       }
       catch(Exception e) {
         util.ExceptionLog.exp2File(e,"");
         e.printStackTrace();
       }

  }

}
