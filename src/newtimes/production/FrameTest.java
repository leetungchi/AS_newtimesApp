package newtimes.production;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newtimes.production.gui.prodmaintain.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FrameTest extends JFrame {
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  PnlDlgShiftSizes pnlDlgShiftSizes1 = new PnlDlgShiftSizes();

  //Construct the frame
  public FrameTest() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception  {

    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Frame Title");
    contentPane.add(pnlDlgShiftSizes1, BorderLayout.WEST);
  }
  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }
}