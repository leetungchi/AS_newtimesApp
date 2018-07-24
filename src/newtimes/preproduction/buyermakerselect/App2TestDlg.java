package newtimes.preproduction.buyermakerselect;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class App2TestDlg {
  boolean packFrame = false;

  //Construct the application
  public App2TestDlg() {
    FrmTestDlg frame = new FrmTestDlg();
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
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
    frame.beginMapping();
  }
  //Main method
  public static void main(String[] args) {
    try {
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      util.PublicVariable.SERVER_URL="localhost";
      util.ExceptionLog.setLogPathToImageFolder();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new App2TestDlg();
  }
}