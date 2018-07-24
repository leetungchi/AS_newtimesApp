package newtimes.reports.report01.GmtPendLc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import database.datatype.Record;



/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtPendLcResult extends JPanel {
  GmtPendLcMain parent = null;
  GmtPendAbsPanel resultPanel = null;
  JTable          resultTable = null;
  JButton btnConfirm = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel labYear = new JLabel();
  JLabel labDep = new JLabel();

  public GmtPendLcResult(GmtPendLcMain _parent) {
    parent = _parent;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setText("YEAR:");
    jLabel1.setBounds(new Rectangle(87, 24, 42, 25));
    btnConfirm.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnConfirm_actionPerformed(e);
        }
      });
    btnConfirm.setText("Confirm Edit");
    btnConfirm.setBorder(BorderFactory.createEtchedBorder());
    btnConfirm.setForeground(Color.darkGray);
    btnConfirm.setFont(new java.awt.Font("Dialog", 1, 13));
    btnConfirm.setBounds(new Rectangle(349, 290, 103, 25));
    btnConfirm.setBackground(Color.lightGray);
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,330);
    //this.add(btnConfirm, null);
    jLabel2.setBounds(new Rectangle(40, 66, 89, 25));
    jLabel2.setText("DEPARTMENT:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(10,36,106));
    labYear.setBounds(new Rectangle(134, 24, 71, 25));
    labYear.setFont(new java.awt.Font("Dialog", 1, 12));
    labYear.setForeground(Color.black);
    labYear.setDoubleBuffered(false);
    labDep.setBounds(new Rectangle(134, 66, 100, 25));
    labDep.setFont(new java.awt.Font("Dialog", 1, 12));
    labDep.setText("");
//    this.add(labYear, null);
//    this.add(jLabel2, null);
//    this.add(labDep, null);
//    this.add(jLabel1, null);
  }
  void initDataTable(){
    resultPanel = new GmtPendAbsPanel();
    resultTable = resultPanel.getJtable();
    resultPanel.setBackground(new Color(204, 204, 225));
    resultPanel.setBounds(new Rectangle(250, 20, 380, 250 ));
    resultPanel.firstPage();

    this.add(resultPanel, null);
    this.add(btnConfirm, null);
    this.add(labYear, null);
    this.add(jLabel2, null);
    this.add(labDep, null);
    this.add(jLabel1, null);
  }

  void refreshDataTable(){
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties("gmtPendSearchConds");
    labYear.setText((String)hm.get("YEAR"));
    labDep.setText((String)hm.get("DEP_ITEM"));
    if(resultPanel==null){
      initDataTable();
    }
    else{
      resultPanel.resetDataSoure(hm);
    }
    resultPanel.reload();
    //resultPanel.repaint();
    resultPanel.validate();
  }

  void btnConfirm_actionPerformed(ActionEvent e) {
    if(resultPanel!=null){
      try{
        java.awt.Cursor tCur = parent.getCursor();
        parent.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        //modified by Chloe
        resultPanel.confirmUpdate();
        if (GmtPendDataFactory.isOk != null) {
          if (GmtPendDataFactory.isOk.equalsIgnoreCase("Update_Succeed")) {
            exgui2.InfoMessage.infoMessage(new JFrame(), "Modify Succeed.");
          } else {
            exgui2.InfoMessage.infoMessage(new JFrame(), "Modify Failed.");
          }
          resultPanel.reload();
        }

        parent.setCursor(tCur);
      } catch(Exception exp){
        exp.printStackTrace();
      } finally {
        GmtPendDataFactory.isOk = null;
      }
    }

  }
}
