package newtimes.reports.report01.GmtPendLc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.HashMap;
import newtimes.*;
import newtimes.material.Util;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtPendLcMain extends JPanel {
  Frame1 frame=null;
  JLabel jLabel1 = new JLabel();
  JSplitPane jSplitPane1 = new JSplitPane();
  GmtPendLcSearch searchPane = new GmtPendLcSearch(this);
  JButton btnExit = new JButton();
  GmtPendLcResult resultPane = new GmtPendLcResult(this);

  public GmtPendLcMain(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,600);

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  GMT Pending L/C  ============      ");
    jLabel1.setBounds(new Rectangle(110, 25, 506, 24));

    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane1.setBounds(new Rectangle(0, 60, 800, 460));
    jSplitPane1.setDividerSize(5);
    jSplitPane1.setDividerLocation(130);
    jSplitPane1.setEnabled(false);
    btnExit.setBackground(Color.lightGray);
    btnExit.setBounds(new Rectangle(335, 545, 80, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExit.setForeground(Color.darkGray);
    btnExit.setBorder(BorderFactory.createEtchedBorder());
    btnExit.setText("Exit");
    btnExit.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
    jSplitPane1.add(searchPane,JSplitPane.TOP);
    jSplitPane1.add(resultPane,JSplitPane.BOTTOM);
    this.add(jLabel1, null);
    this.add(jSplitPane1, null);
    this.add(btnExit, null);
  }

  void btnExit_actionPerformed(ActionEvent e){
    frame.showPanel(new newtimes.reports.ReportMenu1(frame));
  }

  void refreshCurrQuery(){
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    resultPane.refreshDataTable();
    this.repaint();
    this.setCursor(tCur);
  }
}
