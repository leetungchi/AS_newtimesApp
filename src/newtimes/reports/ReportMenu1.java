package newtimes.reports;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import newtimes.*;
//import newtimes.reports.report01.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ReportMenu1 extends JPanel {
  private Frame1 frame = null;
  private JLabel labelTitle = new JLabel();
  private JTextField textAreaStatus = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JButton btnGmtLC = new JButton();
  private JButton btnGmtPEND = new JButton();
  private JButton btnPPS = new JButton();
  private JButton btnQtaEm = new JButton();
  private JButton btnQtaCtrl = new JButton();
  private JButton btnSummary = new JButton();
  private JButton btnSweater = new JButton();
  private JButton btnGSP = new JButton();
  private JButton btnCMT = new JButton();
  JButton butnExit = new JButton();
  JButton butnLogout = new JButton();
  JButton btnFOB = new JButton();

  public ReportMenu1(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    labelTitle.setText("title");
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Report I Maintain  ============      ");
    jLabel1.setBounds(new Rectangle(117, 93, 566, 24));
    btnGmtLC.setBackground(Color.white);
    btnGmtLC.setBounds(new Rectangle(211, 140, 378, 23));
    btnGmtLC.setFont(new java.awt.Font("Dialog", 0, 12));
    btnGmtLC.setBorder(BorderFactory.createRaisedBevelBorder());
    btnGmtLC.setHorizontalAlignment(SwingConstants.LEFT);
    btnGmtLC.setText(" 1.  GMT L / C Require List Report");
    btnGmtLC.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnGmtLC_actionPerformed(e);
        }
      }
    );
    btnGmtPEND.setBackground(Color.white);
    btnGmtPEND.setBounds(new Rectangle(211, 170, 378, 23));
    btnGmtPEND.setFont(new java.awt.Font("Dialog", 0, 12));
    btnGmtPEND.setBorder(BorderFactory.createRaisedBevelBorder());
    btnGmtPEND.setHorizontalAlignment(SwingConstants.LEFT);
    btnGmtPEND.setText(" 2.  GMT Pending L / C Report");
    btnGmtPEND.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGmtPEND_actionPerformed(e);
      }
    });
    btnPPS.setBackground(Color.white);
    btnPPS.setBounds(new Rectangle(211, 198, 378, 23));
    btnPPS.setFont(new java.awt.Font("Dialog", 0, 12));
    btnPPS.setBorder(BorderFactory.createRaisedBevelBorder());
    btnPPS.setHorizontalAlignment(SwingConstants.LEFT);
    btnPPS.setText(" 4.  PPS Report");
    btnPPS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPPS_actionPerformed(e);
      }
    });
    btnQtaEm.setBackground(Color.white);
    btnQtaEm.setBounds(new Rectangle(211, 228, 378, 23));
    btnQtaEm.setFont(new java.awt.Font("Dialog", 0, 12));
    btnQtaEm.setBorder(BorderFactory.createRaisedBevelBorder());
    btnQtaEm.setHorizontalAlignment(SwingConstants.LEFT);
    btnQtaEm.setText(" 5.  Quota Embargo Alert Report");
    btnQtaEm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQtaEm_actionPerformed(e);
      }
    });
    btnQtaCtrl.setBackground(Color.white);
    btnQtaCtrl.setBounds(new Rectangle(211, 258, 378, 23));
    btnQtaCtrl.setFont(new java.awt.Font("Dialog", 0, 12));
    btnQtaCtrl.setBorder(BorderFactory.createRaisedBevelBorder());
    btnQtaCtrl.setHorizontalAlignment(SwingConstants.LEFT);
    btnQtaCtrl.setText(" 6.  Quota Control Input");
    btnQtaCtrl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQtaCtrl_actionPerformed(e);
      }
    });
    btnSummary.setBackground(Color.white);
    btnSummary.setBounds(new Rectangle(211, 288, 378, 23));
    btnSummary.setFont(new java.awt.Font("Dialog", 0, 12));
    btnSummary.setBorder(BorderFactory.createRaisedBevelBorder());
    btnSummary.setHorizontalAlignment(SwingConstants.LEFT);
    btnSummary.setText(" 7.  Summary Report");
    btnSummary.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSummary_actionPerformed(e);
      }
    });
    btnSweater.setBackground(Color.white);
    btnSweater.setBounds(new Rectangle(211, 318, 378, 23));
    btnSweater.setFont(new java.awt.Font("Dialog", 0, 12));
    btnSweater.setBorder(BorderFactory.createRaisedBevelBorder());
    btnSweater.setHorizontalAlignment(SwingConstants.LEFT);
    btnSweater.setText(" 8.  Sweater Alert Report");
    btnSweater.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSweater_actionPerformed(e);
      }
    });
    btnGSP.setBackground(Color.white);
    btnGSP.setBounds(new Rectangle(211, 348, 378, 23));
    btnGSP.setFont(new java.awt.Font("Dialog", 0, 12));
    btnGSP.setBorder(BorderFactory.createRaisedBevelBorder());
    btnGSP.setHorizontalAlignment(SwingConstants.LEFT);
    btnGSP.setText(" 9.  GSP Late Report");
    btnGSP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGSP_actionPerformed(e);
      }
    });
    btnCMT.setBackground(Color.white);
    btnCMT.setBounds(new Rectangle(211, 378, 378, 23));
    btnCMT.setFont(new java.awt.Font("Dialog", 0, 12));
    btnCMT.setBorder(BorderFactory.createRaisedBevelBorder());
    btnCMT.setHorizontalAlignment(SwingConstants.LEFT);
    btnCMT.setText(" 10. CMT List");
    btnCMT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCMT_actionPerformed(e);
      }
    });

    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,600);

//    butnExit.setBorder(BorderFactory.createEtchedBorder());
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(433, 496, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnLogout.setBackground(Color.lightGray);
    butnLogout.setBounds(new Rectangle(291, 496, 80, 25));
    butnLogout.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogout.setForeground(Color.darkGray);
    butnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogout_actionPerformed(e);
      }
    });
    butnLogout.setText("Logout");
    btnFOB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFOB_actionPerformed(e);
      }
    });
    btnFOB.setText(" 11. FOB List");
    btnFOB.setHorizontalAlignment(SwingConstants.LEFT);
    btnFOB.setBorder(BorderFactory.createRaisedBevelBorder());
    btnFOB.setFont(new java.awt.Font("Dialog", 0, 12));
    btnFOB.setBounds(new Rectangle(211, 409, 378, 23));
    btnFOB.setBackground(Color.white);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(btnGmtLC, null);
    this.add(btnGmtPEND, null);
    this.add(labelTitle, null);
    this.add(butnLogout, null);
    this.add(butnExit, null);
    this.add(btnPPS, null);
    this.add(btnQtaEm, null);
    this.add(btnQtaCtrl, null);
    this.add(btnSummary, null);
    this.add(btnSweater, null);
    this.add(btnGSP, null);
    this.add(btnCMT, null);
    this.add(btnFOB, null);
  }

  void btnGmtLC_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report01.GmtLcReq.GmtLcList(frame));
    this.setCursor(tCur);
  }

  void btnGmtPEND_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report01.GmtPendLc.GmtPendLcMain(frame));
    this.setCursor(tCur);
  }

  void btnPS_actionPerformed(ActionEvent e) {
    /*
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    newtimes.reports.report01.ReportPS.RepPsSearch gui=new newtimes.reports.report01.ReportPS.RepPsSearch(frame);
    //gui.PanelInstance=gui;
    util.ApplicationProperites.setProperties("RepPsSearchGUI",gui);
    frame.showPanel(gui);
    this.setCursor(tCur);
    */
  }

  void btnQtaEm_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report01.quotaalert.QuotaAlert(frame));
    this.setCursor(tCur);

  }

  void btnQtaCtrl_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report01.quotacontrol.QuotaCtrl_SF(frame));
    this.setCursor(tCur);
  }

  void btnSummary_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report01.summary.Summary(frame));
    this.setCursor(tCur);
  }

  void btnSweater_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    newtimes.reports.report01.Sweater_Alert.RepSweaterAlertCon gui=new newtimes.reports.report01.Sweater_Alert.RepSweaterAlertCon(frame);
    util.ApplicationProperites.setProperties("RepSweaterAlertCon",gui);
    frame.showPanel(gui);
    this.setCursor(tCur);
  }

  void btnGSP_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    newtimes.reports.report01.GSPLate.RepGspLateCon gui=new newtimes.reports.report01.GSPLate.RepGspLateCon(frame);
    util.ApplicationProperites.setProperties("RepGspLateCon",gui);
    frame.showPanel(gui);
    this.setCursor(tCur);
  }

  void btnCMT_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    newtimes.reports.report01.CMTList.RepCmtListCon gui=new newtimes.reports.report01.CMTList.RepCmtListCon(frame);
    util.ApplicationProperites.setProperties("RepCmtListCon",gui);
    frame.showPanel(gui);
    this.setCursor(tCur);
  }
  void butnExit_actionPerformed(ActionEvent e) {
    util.ApplicationProperites.removeProperites("RepPsSearchGUI");
    util.ApplicationProperites.removeProperites("RepSweaterAlertCon");
    util.ApplicationProperites.removeProperites("RepGspLateCon");
    util.ApplicationProperites.removeProperites("RepCmtListCon");
    frame.showPanel(new MainFunction(frame));
  }
  void butnLogout_actionPerformed(ActionEvent e) {
    frame.showPanel(new Login(frame));
  }

  void btnPPS_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report01.pps.PpsQuery(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void btnFOB_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report01.foblist.FobList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
