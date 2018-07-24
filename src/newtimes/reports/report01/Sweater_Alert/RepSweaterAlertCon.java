package newtimes.reports.report01.Sweater_Alert;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import newtimes.*;
import database.datatype.Record;
import newtimes.material.Util;
import exgui2.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RepSweaterAlertCon extends JPanel {
  private Frame1 frame=null;

  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField tfYear = new JTextField();
  JComboBox cboCEN = new JComboBox();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JComboBox cboDep = new JComboBox();
  JLabel jLabel5 = new JLabel();
  JComboBox cboDIV = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JComboBox cboSEA = new JComboBox();
  JLabel jLabel8 = new JLabel();
  JComboBox cboCnty = new JComboBox();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JButton btnExit = new JButton();
  JButton btnPrint = new JButton();
  String days=null;

  private ReportEJBs.RepPsEJB.RepPS repPsEJB =
      (ReportEJBs.RepPsEJB.RepPS)util.ApplicationProperites.getProperties("repPsEJB");

  Vector cenList = null;
  Vector depList = null;
  Vector divList = null;
  Vector seaList = null;
  Vector cntyList = null;
  static String CEN = null;
  static String DEP = null;
  static String YEAR = null;
  static String DIV = null;
  static String FTY = null;
  static String SEASON = null;
  static String COUNTRY = null;
  static String INCLUDE_QTY = null;
  static String PS_CLOSE = null;
  ButtonGroup buttonGroup3 = new ButtonGroup();
  JLabel jLabel9 = new JLabel();
  JRadioButton rbtn30days = new JRadioButton();
  JRadioButton rbtn45days = new JRadioButton();

  public RepSweaterAlertCon(Frame1 _frame) {
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
    jLabel1.setText("      ============  SWEATER ALERT REPORT  ============      ");
    jLabel1.setBounds(new Rectangle(110, 25, 506, 24));

    jLabel2.setBounds(new Rectangle(223, 96, 59, 20));
    jLabel2.setText("CENTER:");
    jLabel2.setVerticalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(10,36,106));
    tfYear.setBorder(BorderFactory.createEtchedBorder());
    tfYear.setText("");
    tfYear.setBounds(new Rectangle(346, 171, 68, 22));
    cboCEN.setBorder(BorderFactory.createEtchedBorder());
    cboCEN.setBounds(new Rectangle(346, 96, 177, 22));
    cboCEN.setBackground(Color.WHITE);
    jLabel4.setBounds(new Rectangle(223, 171, 59, 20));
    jLabel4.setText("YEAR:");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("DEPARTMENT:");
    jLabel3.setBounds(new Rectangle(223, 134, 93, 20));
    cboDep.setBackground(Color.WHITE);
    cboDep.setBounds(new Rectangle(346, 134, 177, 22));
    cboDep.setBorder(BorderFactory.createEtchedBorder());
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("DIV:");
    jLabel5.setBounds(new Rectangle(223, 209, 59, 20));
    cboDIV.setBackground(Color.WHITE);
    cboDIV.setBounds(new Rectangle(346, 209, 177, 22));
    cboDIV.setBorder(BorderFactory.createEtchedBorder());
    jLabel6.setForeground(new Color(10,36,106));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("FTY:");
    jLabel6.setBounds(new Rectangle(223, 246, 59, 20));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("SEASON:");
    jLabel7.setBounds(new Rectangle(223, 284, 59, 20));
    cboSEA.setBackground(Color.WHITE);
    cboSEA.setBounds(new Rectangle(346, 284, 177, 22));
    cboSEA.setBorder(BorderFactory.createEtchedBorder());
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("COUNTRY:");
    jLabel8.setBounds(new Rectangle(223, 321, 59, 20));
    cboCnty.setBackground(Color.WHITE);
    cboCnty.setBounds(new Rectangle(346, 321, 177, 22));
    cboCnty.setBorder(BorderFactory.createEtchedBorder());
    btnExit.setBackground(Color.lightGray);
    btnExit.setBounds(new Rectangle(428, 434, 80, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExit.setForeground(Color.darkGray);
    btnExit.setBorder(BorderFactory.createEtchedBorder());
    btnExit.setText("Exit");
    btnExit.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
    btnPrint.setText("Print");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setBorder(BorderFactory.createEtchedBorder());
    btnPrint.setForeground(Color.darkGray);
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 13));
    btnPrint.setBounds(new Rectangle(282, 434, 80, 25));
    btnPrint.setBackground(Color.lightGray);
    jLabel9.setBounds(new Rectangle(223, 368, 120, 20));
    jLabel9.setText("DEL-DATE BETWEEN:");
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(false);
    rbtn30days.setBounds(new Rectangle(346, 365, 83, 26));
    rbtn30days.setText("30 DAYS");
    rbtn30days.setFocusPainted(true);
    rbtn30days.setSelected(true);
    rbtn30days.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtn30days.setBackground(new Color(204, 204, 225));
    rbtn45days.setBounds(new Rectangle(443, 365, 84, 26));
    rbtn45days.setText("45 DAYS");
    rbtn45days.setFocusPainted(true);
    rbtn45days.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtn45days.setBackground(new Color(204, 204, 225));
    popMaker.setBounds(new Rectangle(346, 248, 224, 20));
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(jLabel5, null);
    this.add(jLabel6, null);
    this.add(jLabel7, null);
    this.add(jLabel8, null);
    this.add(jLabel3, null);
    this.add(jLabel4, null);
    this.add(tfYear, null);
    this.add(cboCEN, null);
    this.add(cboDep, null);
    this.add(cboDIV, null);
    this.add(cboSEA, null);
    this.add(cboCnty, null);
    initAllCombo();
    buttonGroup1.add(rbtn30days);
    buttonGroup1.add(rbtn45days);
    this.add(btnPrint, null);
    this.add(btnExit, null);
    this.add(jLabel9, null);
    this.add(rbtn30days, null);
    this.add(rbtn45days, null);
    this.add(popMaker, null);
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      HashMap condHm = setConds();
      //String nonBlank = util.MiscFunc.Replace(cboOrderby.getSelectedItem().toString().trim()," ","");
      //this.ORDER_BY = nonBlank;
      frame.showPanel(new newtimes.reports.report01.Sweater_Alert.SweaterAlertReport(frame, condHm));
    } catch (Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot,
                                 "error at attempt pressed Print button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    frame.showPanel(new newtimes.reports.ReportMenu1(frame));
  }

  private void initAllCombo(){
    try{
      HashMap hm = repPsEJB.getAllButFTYComboData();
      cenList = (Vector)hm.get("CEN");
      depList = (Vector)hm.get("DEP");
      divList = (Vector)hm.get("DIV");
      seaList = (Vector)hm.get("SEA");
      cntyList = (Vector)hm.get("COUNTRY");
      Util.setComboValues(cboCEN, cenList, "CEN_NAME", true);
      Util.setComboValues(cboDep, depList, "DEP_NAME", true);
      Util.setComboValues(cboDIV, divList, "DIV_NAME", true);
      Util.setComboValues(cboSEA, seaList, "SEA_NAME", true);
      Util.setComboValues(cboCnty, cntyList, "CNTY_NAME", true);
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }

  private HashMap setConds(){
    HashMap hm = new HashMap();
    try{
      Object center = cboCEN.getSelectedItem();
      int index = cboDep.getSelectedIndex();
      Object depCode = (index == 0) ? ("") :
          ( (String) ( (Record) depList.get(index - 1)).get("DEP_CODE"));
      Object year = tfYear.getText();
      index = cboDIV.getSelectedIndex();
      Object divCode = (index == 0) ? ("") :
          ( (String) ( (Record) divList.get(index - 1)).get("DIV_CODE"));
      Object fty = popMaker.getSelectedMakerValue()==null?"":popMaker.getSelectedMakerValue();
      Object season = cboSEA.getSelectedItem();
      Object country = cboCnty.getSelectedItem();
      if(rbtn30days.isSelected()){
        this.days="30";
      }else if(rbtn45days.isSelected()){
        this.days="45";
      }

      hm.put("center", center);
      hm.put("depCode", depCode);
      hm.put("year", year);
      hm.put("divCode", divCode);
      hm.put("fty", fty);
      hm.put("season", season);
      hm.put("country", country);
      hm.put("days",this.days);

      hm=util.MiscFunc.URLEncode(hm);

      this.CEN = center.toString();
      this.DEP = depCode.toString();
      this.YEAR = year.toString().trim();
      this.DIV = divCode.toString();
      this.FTY = fty.toString();
      this.SEASON = season.toString();
      this.COUNTRY = country.toString();
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    finally{
      return hm;
    }
  }

}
