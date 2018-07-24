package util;
import javax.swing.JFrame;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PublicVariable {
  public PublicVariable() {
  }
  public static javax.swing.JFrame APP_FRAME;
  public static exgui2.SplitFrame APP_SPLIT_FRAME;
  public static database.datatype.Record  USER_RECORD;
  public static String SERVER_URL;
  public static String REPORT_SERVER_AT;
  public static String JNDI_USER;
  public static String JNDI_PASSWD;
  public static com.inet.viewer.ReportViewerBean inet_report_viewer=new com.inet.viewer.ReportViewerBean();
  //public static com.inet.viewer.SwingReportViewer  inet_report_viewer=new com.inet.viewer.SwingReportViewer();
  public static newtimes.message.TopicMessenger  LISTEN_2_NEWTIMES_INCOMMING_MESSAGE;
  public static String OPERATTING_CENTER;
  //public static java.lang.ClassLoader INIT_CLASSLOADER=null;
  public static void setFrameLoginTime(JFrame jframe,String timeString){

  }

  public static void setFrameUnit(JFrame jframe,String userID){

  }
  public static void setFrameUser(JFrame jframe,String userID){

  }
  public static void setFrameStatus(JFrame jframe,String userID){

  }

}
