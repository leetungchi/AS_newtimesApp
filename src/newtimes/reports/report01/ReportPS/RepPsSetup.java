package newtimes.reports.report01.ReportPS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import newtimes.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RepPsSetup extends JPanel {
  Frame1 frame = null;
  HashMap condHm = null;
  JLabel jLabel1 = new JLabel();
  JButton btnExit = new JButton();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JRadioButton rbtCanadaYES = new JRadioButton();
  JRadioButton rbtCanadaNO = new JRadioButton();
  JComboBox cboOrderby = new JComboBox();
  JButton btnExit1 = new JButton();
  JButton btnPrint = new JButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  static String CANADA = null;
  static String ORDER_BY = null;

  public RepPsSetup(Frame1 _frame, HashMap _hm) {
    frame = _frame;
    condHm = _hm;
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
    jLabel1.setText("      ============   PS Report List Setup  ============      ");
    jLabel1.setBounds(new Rectangle(110, 25, 506, 24));

    jLabel2.setBounds(new Rectangle(189, 96, 103, 20));
    jLabel2.setText("PRINT CANADA?");
    jLabel2.setVerticalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setRequestFocusEnabled(true);
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setVerticalAlignment(SwingConstants.CENTER);
    jLabel3.setText("ORDER BY:");
    jLabel3.setBounds(new Rectangle(189, 138, 103, 20));
    rbtCanadaYES.setBackground(new Color(204, 204, 225));
    rbtCanadaYES.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtCanadaYES.setSelected(true);
    rbtCanadaYES.setText("YES");
    rbtCanadaYES.setBounds(new Rectangle(306, 94, 59, 23));
    rbtCanadaNO.setBounds(new Rectangle(376, 94, 59, 23));
    rbtCanadaNO.setText("NO");
    rbtCanadaNO.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtCanadaNO.setVerifyInputWhenFocusTarget(true);
    rbtCanadaNO.setBackground(new Color(204, 204, 225));
    cboOrderby.setBorder(BorderFactory.createEtchedBorder());
    cboOrderby.setBounds(new Rectangle(264, 138, 249, 22));
    cboOrderby.setBackground(Color.white);
    btnExit1.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnExit1_actionPerformed(e);
        }
      });
    btnExit1.setText("Exit");
    btnExit1.setBorder(BorderFactory.createEtchedBorder());
    btnExit1.setForeground(Color.darkGray);
    btnExit1.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExit1.setBounds(new Rectangle(370, 253, 103, 25));
    btnExit1.setBackground(Color.lightGray);
    btnPrint.setText("Print");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setBorder(BorderFactory.createEtchedBorder());
    btnPrint.setForeground(Color.darkGray);
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 13));
    btnPrint.setBounds(new Rectangle(237, 253, 103, 25));
    btnPrint.setBackground(Color.lightGray);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(rbtCanadaYES, null);
    this.add(rbtCanadaNO, null);
    this.add(cboOrderby, null);
    this.add(btnExit1, null);
    this.add(btnPrint, null);
    buttonGroup1.add(rbtCanadaYES);
    buttonGroup1.add(rbtCanadaNO);
    initCombobox();
  }

  private void initCombobox(){
    cboOrderby.addItem("");
    cboOrderby.addItem("DIV, SEASON, YEAR, GROUP_NAME, FTY");
    cboOrderby.addItem("DIV, FTY, SEASON, YEAR");
    cboOrderby.addItem("FTY, SEASON, YEAR, GROUP_NAME, DIV");
    cboOrderby.addItem("FTY, DIV, SEASON, YEAR");
    cboOrderby.addItem("SEASON, YEAR, DIV, FTY");
    cboOrderby.addItem("SEASON, YEAR, FTY, DIV");
    cboOrderby.addItem("BUYER, FTY (NON JOHNS)");
    cboOrderby.addItem("FTY, BUYER (NON JOHNS)");
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.CANADA = rbtCanadaYES.isSelected() ? "U" : null;
      String nonBlank = util.MiscFunc.Replace(cboOrderby.getSelectedItem().toString().trim()," ","");
      this.ORDER_BY = nonBlank;
      frame.showPanel(new newtimes.reports.report01.ReportPS.Ps4ReportViewer(frame, condHm));
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
                                 "error at attempt pressed Print button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void btnExit1_actionPerformed(ActionEvent e) {
    try{
      java.awt.Cursor tCur = this.getCursor();
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      String psClose = (String) condHm.get("psClose");
      if(psClose.equals("N"))
        frame.showPanel(new newtimes.reports.report01.ReportPS.RepPsResult(frame));
      else if(psClose.equals("Y"))
        frame.showPanel(new newtimes.reports.report01.ReportPS.RepPsResult(frame, "Recover"));

      this.setCursor(tCur);
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
