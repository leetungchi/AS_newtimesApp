package newtimes;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FrameLessWindow extends Window {
  JList jList1 = new JList(new String[]{"test 1","Test 2","Test 3"});

  public FrameLessWindow() {
    super(new Frame());
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception{
    this.setLayout(new java.awt.BorderLayout());
    this.setSize(new Dimension(260, 200));
    this.setVisible(false);
    jList1.setVisible(true);

    //this.setVisible(true);
    //jLabel1.setIcon(new ImageIcon(exgui.UIHelper.getFolderURL("images/start_up.gif")));
    //jLabel1.setIcon(new ImageIcon("D:/diamond.gif"));
    this.add(jList1, BorderLayout.CENTER);
  }

}
