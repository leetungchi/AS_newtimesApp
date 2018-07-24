package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgViewRpt extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JButton btnClose = new JButton();
  BorderLayout borderLayout2 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel reportPanel=null;
  public DlgViewRpt(Frame frame, String title,JPanel pnl, boolean modal) {
    super(frame, title, modal);
    try {
      reportPanel=pnl;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgViewRpt() {
    this(null, "",null, false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setText("CLOSE");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    jPanel1.setLayout(borderLayout2);
    getContentPane().add(panel1,  BorderLayout.CENTER);
    panel1.add(jPanel1,  BorderLayout.CENTER);
    jPanel1.add(jScrollPane1,  BorderLayout.CENTER);
    jScrollPane1.getViewport().add(reportPanel, null);
    panel1.add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(btnClose, null);
  }

  void btnClose_actionPerformed(ActionEvent e) {
    this.hide();
  }
}
