package newtimes.shipping.shipmentinfo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class InterOfficeGUI extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();

  public InterOfficeGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTabbedPane1.setBackground(new Color(212, 208, 200));
    jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        jTabbedPane1_stateChanged(e);
      }
    });
    jPanel1.setBackground(new Color(212, 208, 200));
    jPanel1.setLayout(borderLayout2);
    jPanel2.setBackground(new Color(212, 208, 200));
    jPanel2.setLayout(borderLayout3);
    this.add(jTabbedPane1, BorderLayout.CENTER);
    jTabbedPane1.add(jPanel1,  "Print All");
    jPanel1.add(jScrollPane1, BorderLayout.CENTER);
    jTabbedPane1.add(jPanel2,  "Print BLNC QTY > 0");
    jPanel2.add(jScrollPane2, BorderLayout.CENTER);
  }

  void jTabbedPane1_stateChanged(ChangeEvent e) {
    switch (jTabbedPane1.getSelectedIndex()) {
      case 0 : //Print All
        jScrollPane1.getViewport().add(
            new exgui2.ReportGenerate("0605-SCR002.rpt", null));
        break;
      case 1 : //Print BLNC QTY > 0
        jScrollPane1.getViewport().add(
            new exgui2.ReportGenerate("0605-SCR002.rpt", null));
        break;
    }
  }
}