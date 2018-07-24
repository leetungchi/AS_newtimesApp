package newtimes;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * SplashScreen is the splash screen used at program start up while the
 * application is loading, and the database connection being established.
 * In the constructor for the Application class of the project (in this case
 * CliffhangerApplication), show this frame before instantiating any other
 * class. Once the main form of the application is shown, hide and dispose
 * the splash screen.
 */
public class SplashScreen extends Window {
  JLabel jLabel1 = new JLabel();
  JLabel jLabelDWN = new JLabel();
  public SplashScreen() {
    super(new Frame());
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method generated and maintained by JBuilder designer to initialize control
   * properties.
   *
   * @throws Exception exception
   */
  private void jbInit() throws Exception{
    this.setSize(new Dimension(400, 200));
    this.setVisible(false);
    //this.setVisible(true);
    jLabel1.setDoubleBuffered(true);
    jLabel1.setPreferredSize(new Dimension(400,190));
    jLabelDWN.setDoubleBuffered(true);
    jLabelDWN.setPreferredSize(new Dimension(400,10));
    jLabelDWN.setOpaque(true);
    jLabel1.setIcon(new ImageIcon(exgui.UIHelper.getFolderURL("images/start_up.gif")));
    jLabelDWN.setIcon(new ImageIcon(exgui.UIHelper.getFolderURL("images/start_dn.gif")));
    //jLabel1.setIcon(new ImageIcon("D:/diamond.gif"));
    this.add(jLabel1, BorderLayout.CENTER);
    this.add(jLabelDWN, BorderLayout.SOUTH);
  }
}
