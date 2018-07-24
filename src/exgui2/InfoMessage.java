package exgui2;

import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class InfoMessage {
  private static String title = "Message Dialog";

  public InfoMessage() {
  }

  public static void infoMessage(JFrame frame, String msg) {
    util.MiscFunc.hideProcessingMessage();
    int type = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, msg, title, type);
  }

  public static void warningMessage(JFrame frame, String msg) {
        util.MiscFunc.hideProcessingMessage();
    int type = JOptionPane.WARNING_MESSAGE;
    JOptionPane.showMessageDialog(frame, msg, title, type);
  }

  public static int Yes_No_Option(JFrame frame,String msg){
        util.MiscFunc.hideProcessingMessage();
    int optionType = JOptionPane.YES_NO_OPTION;
    int msgType = JOptionPane.WARNING_MESSAGE;
    int result = JOptionPane.showConfirmDialog(
        frame, msg, title, optionType, msgType);
    return result;
  }
}
