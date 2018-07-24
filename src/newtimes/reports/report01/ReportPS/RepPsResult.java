package newtimes.reports.report01.ReportPS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import newtimes.*;
import database.datatype.Record;
import newtimes.material.Util;
import newtimes.reports.report01.repMessage;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RepPsResult extends JPanel {
  Frame1 frame = null;
  JLabel jLabel1 = new JLabel();
  RepPsAbsPanel   resultPanel = new RepPsAbsPanel();
  JTable          resultTable = resultPanel.getJtable();
  JButton btnExit = new JButton();
  JButton btnPrint = new JButton();
  JButton btnConfirm = new JButton();
  String subTitle = null;

  public RepPsResult(Frame1 _frame) {
    this(_frame, "");
  }

  public RepPsResult(Frame1 _frame, String _subTitle) {
    frame = _frame;
    subTitle = _subTitle.equals("")?(""):("("+_subTitle+")");
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
    jLabel1.setText("      ============   PRODUCTION STATUS REPORT LIST "+subTitle+"  ============      ");
    jLabel1.setBounds(new Rectangle(39, 5, 706, 24));
    resultPanel.setBackground(new Color(204, 204, 225));
    resultPanel.setBounds(new Rectangle(2, 34, 790, 476));
    resultPanel.firstPage();

    btnExit.setBackground(Color.lightGray);
    btnExit.setBounds(new Rectangle(487, 528, 103, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExit.setForeground(Color.darkGray);
    btnExit.setBorder(BorderFactory.createEtchedBorder());
    btnExit.setText("Exit");
    btnExit.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
    btnPrint.setBackground(Color.lightGray);
    btnPrint.setBounds(new Rectangle(354, 528, 103, 25));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 13));
    btnPrint.setForeground(Color.darkGray);
    btnPrint.setBorder(BorderFactory.createEtchedBorder());
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setText("Print");
    btnConfirm.setText("Confirm Edit");
    btnConfirm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnConfirm_actionPerformed(e);
      }
    });
    btnConfirm.setBorder(BorderFactory.createEtchedBorder());
    btnConfirm.setForeground(Color.darkGray);
    btnConfirm.setFont(new java.awt.Font("Dialog", 1, 13));
    btnConfirm.setBounds(new Rectangle(221, 528, 103, 25));
    btnConfirm.setBackground(Color.lightGray);

    this.add(resultPanel, null);
    if(subTitle.toUpperCase().indexOf("RECOVER")==-1){
      this.add(btnPrint, null);
    }
    this.add(jLabel1, null);
    this.add(btnConfirm, null);
    this.add(btnExit, null);
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR);
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    /*
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties("RepPsSearchConds");
    RepPsSetup gui=new newtimes.reports.report01.ReportPS.RepPsSetup(frame,hm);
    util.ApplicationProperites.setProperties("RepPsSetup",gui);
    */
    PS_Report gui=new PS_Report(frame);
    frame.contentPane.removeAll();
    frame.contentPane.add(gui, null);
    gui.setBounds(0, 0, 750, 550);
    gui.repaint();
    gui.validate();
    frame.setCursor(tCur);
    gui.setCursor(tCur);
    this.setCursor(tCur);
    frame.repaint();
  }

  void btnConfirm_actionPerformed(ActionEvent e) {
      resultPanel.doUpdate();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    //frame.showPanel(new newtimes.reports.report01.ReportPS.RepPsSearch(frame));
    util.ApplicationProperites.removeProperites("RepPsSetup");
    frame.showPanel((RepPsSearch)util.ApplicationProperites.getProperties("RepPsSearchGUI"));
    this.setCursor(tCur);
  }

}
