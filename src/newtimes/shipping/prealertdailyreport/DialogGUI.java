package newtimes.shipping.prealertdailyreport;

import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DialogGUI extends JPanel {
  JButton butnDown = new JButton();
  JButton butnUp = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JButton butnLeft = new JButton();
  JButton butnRight = new JButton();
  JScrollPane jScrollPane2 = new JScrollPane();
  JButton butnExit = new JButton();
  JButton butnOk = new JButton();
  JList jList1 = new JList();
  JList jList2 = new JList();

  public DialogGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setSize(new Dimension(373, 306));
    jScrollPane1.setBounds(new Rectangle(14, 12, 116, 238));
    butnUp.setBounds(new Rectangle(319, 57, 38, 78));
    butnUp.setIcon(exgui.UIHelper.getIcon("up.gif"));
    butnDown.setBounds(new Rectangle(319, 135, 38, 78));
    butnDown.setIcon(exgui.UIHelper.getIcon("down.gif"));
    this.setLayout(null);
    butnLeft.setBounds(new Rectangle(141, 135, 38, 78));
    butnLeft.setIcon(exgui.UIHelper.getIcon("prev.gif"));
    butnRight.setBounds(new Rectangle(141, 57, 38, 78));
    butnRight.setIcon(exgui.UIHelper.getIcon("next.gif"));
    jScrollPane2.setBounds(new Rectangle(193, 12, 116, 238));
    this.setBackground(new Color(204, 204, 225));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(498, 486, 100, 25));
    butnExit.setMargin(new Insets(0, 0, 0, 0));
    butnExit.setText("Exit");
    butnExit.setBounds(new Rectangle(189, 264, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnOk.setForeground(Color.darkGray);
    butnOk.setFont(new java.awt.Font("Dialog", 1, 13));
    butnOk.setBounds(new Rectangle(443, 438, 80, 25));
    butnOk.setText("Ok");
    butnOk.setMargin(new Insets(0, 0, 0, 0));
    butnOk.setBounds(new Rectangle(95, 264, 80, 25));
    butnOk.setBackground(Color.lightGray);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(jList1, null);
    this.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(jList2, null);
    this.add(butnRight, null);
    this.add(butnLeft, null);
    this.add(butnUp, null);
    this.add(butnDown, null);
    this.add(butnOk, null);
    this.add(butnExit, null);
  }
}