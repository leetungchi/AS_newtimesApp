package newtimes.message;
import javax.jms.*;
import javax.naming.*;
import java.util.*;
import java.io.*;

public class TopicMessenger  implements MessageListener {
  public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";
  public final static String JMS_FACTORY="weblogic.jms.ConnectionFactory";
  public final static String TOPIC="NewtimesTopic";
  protected TopicConnectionFactory tconFactory;
  protected TopicConnection tcon;
  protected TopicSession tsession;
  protected TopicPublisher tpublisher;
  protected Topic topic;
  protected TextMessage msg;
  protected TopicSubscriber tsubscriber;
  public TopicMessenger() {
     initJMS();
  }
  protected void initJMS() {
      try {
        String hostName = util.PublicVariable.SERVER_URL;
        Hashtable env = new Hashtable();
        //hostName="127.0.0.1";
        env.put(Context.PROVIDER_URL,
          "t3://" + hostName + ":7001");

        env.put(Context.INITIAL_CONTEXT_FACTORY,
          "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "jndi_user");
        env.put(Context.SECURITY_CREDENTIALS, "newtimes");
        javax.naming.Context ctx = new InitialContext(env);
        tconFactory = (TopicConnectionFactory) ctx.lookup(JMS_FACTORY);
        tcon = tconFactory.createTopicConnection();
        tsession = tcon.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
        topic = (Topic) ctx.lookup("NewtimesTopic");
        msg = tsession.createTextMessage();
        tsubscriber = tsession.createSubscriber(topic);
        tpublisher=tsession.createPublisher(topic);
        tsubscriber.setMessageListener(this);
        tcon.start();
        msg.acknowledge();
      }catch(Exception e) {
        e.printStackTrace();
        util.ExceptionLog.exp2File(e,"");
        exgui.verification.VerifyLib.showAlert(
          "Errro When Initializing Newtimes EIP Messeneger\nPlease Contact System Manager"
          ,"Error In Init-JMS");
        //System.out.println("Initialization failed");
      }
    }
    protected void finalize(){
      try{
        System.out.println("system closed");
        if (tcon  != null) {
          tcon.stop();
          tcon = null;
        }
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    public void sendMessage(String messageTxt)throws Exception{
      TextMessage message = tsession.createTextMessage();
      message.setText(messageTxt);
      tpublisher.publish(message);
    }

    public void onMessage(Message msg){
      String data;
         try {
           data=((TextMessage)msg).getText();

           newtimes.basic.DlgMessage2Send dlg=new newtimes.basic.DlgMessage2Send(util.PublicVariable.APP_FRAME,
                                                   "Incomming Message",false);
           dlg.setSize(new java.awt.Dimension(400,300));
           exgui.UIHelper.setToScreenCenter(dlg);
           java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
           dlg.blueBkgWhiteCharLabel1.setText("Incomming Message, Receive At:"+df.format(new java.sql.Date(System.currentTimeMillis())));
           dlg.txtMsg2Send.setText(data);
           dlg.txtMsg2Send.setEditable(false);
           dlg.btn2nd.setEnabled(false);
           dlg.btnCancel.setText("CLOSE");
           dlg.show();
         }
         catch(Exception e) {
           util.ExceptionLog.exp2File(e,"");
           exgui.verification.VerifyLib.showAlert("Error In Message Receiving\nPlease Contact System Manager",
                                                  "JMS Error");
           System.out.println("Failed to receive message");
         }

    }


}
