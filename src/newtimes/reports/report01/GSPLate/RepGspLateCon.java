package newtimes.reports.report01.GSPLate;

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

public class RepGspLateCon extends JPanel {
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
  exgui.DataBindJCombobox dbJCBXDep = null;
  JLabel jLabel5 = new JLabel();
  JComboBox cboDIV = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JComboBox cboSEA = new JComboBox();
  JLabel jLabel8 = new JLabel();
  JComboBox cboCnty = new JComboBox();
  JLabel jLabel10 = new JLabel();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rbtnOrderByFty = new JRadioButton();
  JRadioButton rbtnOrderByDiv = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JButton btnExit = new JButton();
  JButton btnPrint = new JButton();
  String OrderBy=null;
  String Quota=null;

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
  String usrType = null;
  String usrCenCodeDf = null;
  JLabel lblQuota = new JLabel();
  ButtonGroup buttonGroup3 = new ButtonGroup();
  JRadioButton rbtnUSA = new JRadioButton();
  JRadioButton rbtnCDA = new JRadioButton();
  JRadioButton rbtnALL = new JRadioButton();

  public RepGspLateCon(Frame1 _frame) {
    frame = _frame;
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
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
    jLabel1.setText("      ============  GSP LATE REPORT  ============      ");
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
    jLabel10.setBounds(new Rectangle(223, 376, 117, 20));
    jLabel10.setText("ORDER BY:");
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(new Color(10,36,106));
    rbtnOrderByFty.setBounds(new Rectangle(346, 403, 270, 18));
    rbtnOrderByFty.setText("(1) FTY    (2) SEASON    (3) YEAR    (4) DIV");
    rbtnOrderByFty.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtnOrderByFty.setBackground(new Color(204, 204, 225));
    rbtnOrderByDiv.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtnOrderByDiv.setSelected(true);
    rbtnOrderByDiv.setBackground(new Color(204, 204, 225));
    rbtnOrderByDiv.setText("(1) DIV    (2) SEASON    (3) YEAR    (4) FTY");
    rbtnOrderByDiv.setBounds(new Rectangle(346, 376, 268, 18));
    btnExit.setBackground(Color.lightGray);
    btnExit.setBounds(new Rectangle(427, 516, 80, 25));
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
    btnPrint.setBounds(new Rectangle(281, 516, 80, 25));
    btnPrint.setBackground(Color.lightGray);
    lblQuota.setFont(new java.awt.Font("Dialog", 1, 12));
    lblQuota.setForeground(new Color(10,36,106));
    lblQuota.setText("QUOTA SELECT:");
    lblQuota.setBounds(new Rectangle(222, 440, 112, 25));
    rbtnUSA.setBackground(new Color(204, 204, 225));
    rbtnUSA.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtnUSA.setFocusPainted(true);
    rbtnUSA.setText("USA");
    rbtnUSA.setBounds(new Rectangle(345, 439, 59, 26));
    rbtnCDA.setBounds(new Rectangle(411, 439, 57, 26));
    rbtnCDA.setText("CDA");
    rbtnCDA.setBackground(new Color(204, 204, 225));
    rbtnCDA.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtnALL.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtnALL.setBackground(new Color(204, 204, 225));
    rbtnALL.setText("ALL");
    rbtnALL.setSelected(true);
    rbtnALL.setBounds(new Rectangle(477, 439, 72, 26));
    popMaker.setBounds(new Rectangle(346, 245, 224, 22));
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
    this.add(rbtnOrderByDiv, null);
    this.add(jLabel10, null);
    buttonGroup2.add(rbtnOrderByDiv);
    buttonGroup2.add(rbtnOrderByFty);
    initAllCombo();
    buttonGroup3.add(rbtnUSA);
    this.add(lblQuota, null);
    this.add(rbtnUSA, null);
    this.add(rbtnCDA, null);
    this.add(rbtnALL, null);
    this.add(btnPrint, null);
    this.add(btnExit, null);
    this.add(rbtnOrderByFty, null);
    this.add(popMaker, null);
    buttonGroup3.add(rbtnCDA);
    buttonGroup3.add(rbtnALL);
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      HashMap condHm = setConds();
      //String nonBlank = util.MiscFunc.Replace(cboOrderby.getSelectedItem().toString().trim()," ","");
      //this.ORDER_BY = nonBlank;
      frame.showPanel(new newtimes.reports.report01.GSPLate.GspLateReport(frame, condHm));
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
    java.util.Vector vDataCen = null;
    java.util.Vector vDataDep = null;
    try{
      HashMap hm = repPsEJB.getAllButFTYComboData();
      cenList = (Vector)hm.get("CEN");
      depList = (Vector)hm.get("DEP");
      divList = (Vector)hm.get("DIV");
      seaList = (Vector)hm.get("SEA");
      cntyList = (Vector)hm.get("COUNTRY");
      Util.setComboValues(cboCEN, cenList, "CEN_NAME", true);
      if (usrType.equals("2")) {
        vDataDep = CONST.BASIC_BASE_EJB.getDepartmentAll("DEP_CODE,DEP_NAME", "DEP_NAME");
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJCBXDep = new exgui.DataBindJCombobox(cboDep, vDataDep, "DEP_NAME",
                                             "DEP_CODE", recDep.get("DEP_CODE"));
      }else{
        cboCEN.setSelectedItem(util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString());
        if(util.PublicVariable.USER_RECORD.get("USR_CEN_MOD").toString().equals("N")){
          cboCEN.setEnabled(false);
        }
        vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", "DEP_CEN_CODE = '"+usrCenCodeDf+"'", "DEP_NAME");
        if (vDataDep.size() > 0) {
          database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
          dbJCBXDep = new exgui.DataBindJCombobox(cboDep, vDataDep, "DEP_NAME",
                                               "DEP_CODE", recDep.get("DEP_CODE"));
        } else {
          Util.setComboValues(cboDep, vDataDep, "DEP_NAME", true);
          //jScrollPane3.getViewport().add(listDep, null);
        }
        cboDep.setSelectedItem(util.PublicVariable.USER_RECORD.get("USR_DEP_CODE_DF").toString());
        if(util.PublicVariable.USER_RECORD.get("USR_DEP_MOD").toString().equals("N")){
          cboDep.setEnabled(false);
        }
      }
      //Util.setComboValues(cboDep, depList, "DEP_NAME", true);
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
      this.OrderBy = rbtnOrderByDiv.isSelected() ? "DIV" : "FTY";
      if(rbtnUSA.isSelected()){
        this.Quota="USA";
      }else if(rbtnCDA.isSelected()){
        this.Quota="CDA";
      }else{
        this.Quota="ALL";
      }

      hm.put("center", center);
      hm.put("depCode", depCode);
      hm.put("year", year);
      hm.put("divCode", divCode);
      hm.put("fty", fty);
      hm.put("season", season);
      hm.put("country", country);
      hm.put("orderby",this.OrderBy);
      hm.put("quota",this.Quota);

      hm=util.MiscFunc.URLEncode(hm);
      //use URLEncoder to encoding String and avoid error when passing URL to servlet
/*
      java.util.Set keys=hm.keySet();
      java.util.Iterator iter=keys.iterator();
      while(iter.hasNext()){
        String nextName=(String) iter.next();
        String value=java.net.URLEncoder.encode((String)hm.get(nextName));
        hm.put(nextName,value);
      }
*/
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
