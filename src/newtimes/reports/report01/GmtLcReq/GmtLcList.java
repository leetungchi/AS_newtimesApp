package newtimes.reports.report01.GmtLcReq;

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

public class GmtLcList extends JPanel {
  Frame1 frame=null;
  JLabel jLabel1 = new JLabel();
  JButton btnExit = new JButton();
  GmtLcSearch searchPane = new GmtLcSearch(this);

  private final newtimes.material.CONST.MTR.EJB MTR_EJB = null;
  private final newtimes.material.CONST.DIV.EJB DIV_EJB = null;
  private final newtimes.material.CONST.BYMK.EJB BYMK_EJB = null;
  private final newtimes.material.CONST.SEASON.EJB SEA_EJB = null;

  private MaterialMdlEJBs.MaterialEJB.MtrEJB materialEJB =
    (MaterialMdlEJBs.MaterialEJB.MtrEJB)util.ApplicationProperites.getProperties("materialEJB");

  private Vector MillList    = null;//vector of Records of table Mill?????
  private Vector DivList     = null;
  private Vector SeaList     = null;
  private Vector subMillList = null;
  JSplitPane jSplitPane1 = new JSplitPane();
  GmtLcQuery queryPane = null; // Modify by Chloe


  public GmtLcList(Frame1 _frame) {
    frame = _frame;
    try{
      queryPane = new GmtLcQuery(this, frame); // Modify by Chloe
      jbInit();
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }

  // Add by Chloe
  public GmtLcList() {
    try{
      jbInit();
    }
    catch(Exception exp){
      exp.printStackTrace();
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
    jLabel1.setText("      ============  GMT L/C Require List  ============      ");
    jLabel1.setBounds(new Rectangle(110, 25, 506, 24));


    btnExit.setBackground(Color.lightGray);
    btnExit.setBounds(new Rectangle(355, 547, 80, 22));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExit.setForeground(Color.darkGray);
    btnExit.setBorder(BorderFactory.createEtchedBorder());
    btnExit.setText("Exit");
    btnExit.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      }
    );

    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane1.setBounds(new Rectangle(0, 60, 800, 485));
    jSplitPane1.setDividerSize(5);
    jSplitPane1.setDividerLocation(130);
    jSplitPane1.setEnabled(false);
    jSplitPane1.add(searchPane,JSplitPane.TOP);
    jSplitPane1.add(queryPane,JSplitPane.BOTTOM);
    this.add(btnExit, null);
    this.add(jLabel1, null);
    this.add(jSplitPane1, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    frame.showPanel(new newtimes.reports.ReportMenu1(frame));
  }

  void refreshCurrQuery(){
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    queryPane.refreshCurrQuery();
    this.repaint();
    this.setCursor(tCur);
  }
}
