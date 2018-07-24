package newtimes.basic.center;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 2.0
 */

public class CenterAdd extends JPanel {
  Frame1 frame;
  private JLabel jTextField14 = new JLabel();
  private JLabel jTextField13 = new JLabel();
  private JButton butnAdd = new JButton();
  private JTextField txtWeight = new JTextField();
  private JTextField txtCenName = new JTextField();
  private JTextField txtCenCode = new JTextField();
  private JButton butnExit = new JButton();
  private JTextField txtChkDfMonth = new JTextField();
  private JTextField txtChkDfYear = new JTextField();
  private JLabel jTextField9 = new JLabel();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jTextField8 = new JLabel();
  private JLabel jTextField7 = new JLabel();
  private JLabel jTextField6 = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JTextField txtChkPlanFrom = new JTextField();
  private JTextField txtChkPlanTo = new JTextField();
  private JTextField txtChkOdFrom = new JTextField();
  private JTextField txtChkOdTo = new JTextField();
  private JTextField txtChkObdFrom = new JTextField();
  private JTextField txtChkObdTo = new JTextField();
//  private BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB basicEJB =
//    (BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB)util.ApplicationProperites.getProperties("basicEJB");
  JLabel jTextField10 = new JLabel();
  JTextField txtPrefix = new JTextField();
  JLabel jTextField11 = new JLabel();
  JTextField txtNo = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  exgui.DataBindTextWithChecker
      dbChkPlanFrom,dbChkPlanTo,dbChkOdFrom,dbChkOdTo,
      dbChkObdFrom,dbChkObdTo,dbChkYear,dbChkMonth;

  public CenterAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Center Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextField1.setBounds(new Rectangle(80, 89, 155, 23));
    jTextField1.setText(" * Center Code :");
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(80, 124, 155, 23));
    jTextField2.setText(" * Center Name :");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setForeground(Color.white);
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField3.setBounds(new Rectangle(80, 159, 155, 23));
    jTextField3.setText(" Weight :");
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setText(" Check Plan From :");
    jTextField4.setBounds(new Rectangle(80, 222, 155, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setText(" Check Plan To :");
    jTextField5.setBounds(new Rectangle(412, 222, 155, 23));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    //jTextField6.setEditable(false);
    jTextField6.setText(" Check OD Delivery From :");
    jTextField6.setBounds(new Rectangle(80, 256, 155, 23));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(new Color(10,36,106));
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    //jTextField7.setEditable(false);
    jTextField7.setText(" Check OD Delivery To :");
    jTextField7.setBounds(new Rectangle(412, 256, 155, 23));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(Color.white);
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    //jTextField8.setEditable(false);
    jTextField8.setText(" Check OBD From :");
    jTextField8.setBounds(new Rectangle(80, 291, 155, 23));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setBorder(null);
    jTextField9.setOpaque(true);
    //jTextField9.setEditable(false);
    jTextField9.setText(" Check OBD To :");
    jTextField9.setBounds(new Rectangle(412, 291, 155, 23));
    txtChkDfYear.setBounds(new Rectangle(237, 326, 54, 23));
    txtChkDfYear.setText("");
    txtChkDfMonth.setBounds(new Rectangle(569, 326, 37, 23));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(405, 481, 80, 25));
    butnExit.setBackground(Color.lightGray);
    txtCenCode.setBounds(new Rectangle(237, 89, 155, 23));
    txtCenName.setBounds(new Rectangle(237, 124, 155, 23));
    txtWeight.setBounds(new Rectangle(237, 159, 155, 23));
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(311, 481, 80, 25));
    butnAdd.setBackground(Color.lightGray);
    jTextField13.setBounds(new Rectangle(80, 326, 155, 23));
    jTextField13.setText(" Check Entry DF Year :");
    //jTextField13.setCaretColor(Color.white);
    //jTextField13.setEditable(false);
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    jTextField13.setForeground(new Color(10,36,106));
    jTextField13.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField14.setBounds(new Rectangle(412, 326, 155, 23));
    jTextField14.setText(" Check Entry DF Month :");
    jTextField14.setBorder(null);
    jTextField14.setOpaque(true);
    //jTextField14.setEditable(false);
    jTextField14.setForeground(new Color(10,36,106));
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel3.setBounds(new Rectangle(299, 326, 51, 23));
    jLabel3.setText("( Year )");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setForeground(new Color(10,36,106));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("( Month )");
    jLabel4.setBounds(new Rectangle(614, 326, 51, 23));
    txtChkPlanFrom.setSelectionEnd(4);
    txtChkPlanFrom.setText("");
    txtChkPlanFrom.setBounds(new Rectangle(237, 222, 105, 23));
    txtChkPlanTo.setBounds(new Rectangle(569, 222, 103, 23));
    txtChkPlanTo.setText("");
    txtChkOdFrom.setBounds(new Rectangle(237, 256, 105, 23));
    txtChkOdFrom.setText("");
    txtChkOdTo.setBounds(new Rectangle(569, 256, 103, 23));
    txtChkOdTo.setText("");
    txtChkObdFrom.setBounds(new Rectangle(237, 291, 105, 23));
    txtChkObdFrom.setText("");
    txtChkObdTo.setBounds(new Rectangle(569, 291, 103, 23));
    txtChkObdTo.setText("");
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(Color.white);
    //jTextField10.setEditable(false);
    jTextField10.setBorder(null);
    jTextField10.setOpaque(true);
    jTextField10.setText(" * Center NO. Code :");
    jTextField10.setBounds(new Rectangle(412, 124, 155, 23));
    txtPrefix.setBounds(new Rectangle(569, 89, 155, 23));
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(new Color(10,36,106));
    //jTextField11.setEditable(false);
    jTextField11.setBorder(null);
    jTextField11.setOpaque(true);
    jTextField11.setText(" * Center Prefix :");
    jTextField11.setBounds(new Rectangle(412, 89, 155, 23));
    txtNo.setBounds(new Rectangle(569, 124, 155, 23));
    jLabel2.setText("yyyy/mm/dd");
    jLabel2.setBounds(new Rectangle(345, 221, 65, 22));
    jLabel5.setBounds(new Rectangle(345, 260, 67, 22));
    jLabel5.setText("yyyy/mm/dd");
    jLabel6.setBounds(new Rectangle(344, 293, 69, 22));
    jLabel6.setText("yyyy/mm/dd");
    jLabel7.setBounds(new Rectangle(679, 223, 65, 22));
    jLabel7.setText("yyyy/mm/dd");
    jLabel8.setBounds(new Rectangle(678, 259, 65, 22));
    jLabel8.setText("yyyy/mm/dd");
    jLabel9.setBounds(new Rectangle(679, 291, 65, 22));
    jLabel9.setText("yyyy/mm/dd");
//    txtRemark.setText(recDetail.get("CEN_REMARK")==null?"":recDetail.get("CEN_REMARK").toString());
    txtRemark.setBounds(new Rectangle(238, 365, 430, 23));
    jTextField12.setBounds(new Rectangle(81, 365, 155, 23));
    jTextField12.setText("Remark :");
    jTextField12.setOpaque(true);
    jTextField12.setBorder(null);
    jTextField12.setForeground(Color.white);
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setBackground(new Color(143, 143, 188));
    this.add(jLabel1, null);
    this.add(textAreaStatus, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    this.add(txtCenCode, null);
    this.add(jTextField11, null);
    this.add(txtPrefix, null);
    this.add(jTextField10, null);
    this.add(txtNo, null);
    this.add(jTextField5, null);
    this.add(txtChkPlanTo, null);
    this.add(jTextField7, null);
    this.add(txtChkOdTo, null);
    this.add(jTextField9, null);
    this.add(txtChkObdTo, null);
    this.add(jTextField14, null);
    this.add(txtChkDfMonth, null);
    this.add(txtChkPlanFrom, null);
    this.add(txtChkOdFrom, null);
    this.add(txtChkObdFrom, null);
    this.add(jTextField6, null);
    this.add(jTextField8, null);
    this.add(jTextField13, null);
    this.add(txtChkDfYear, null);
    this.add(jLabel3, null);
    this.add(jTextField1, null);
    this.add(txtWeight, null);
    this.add(txtCenName, null);
    this.add(jTextField3, null);
    this.add(jTextField2, null);
    this.add(jTextField4, null);
    this.add(jLabel4, null);
    this.add(jLabel2, null);
    this.add(jLabel5, null);
    this.add(jLabel6, null);
    this.add(jLabel8, null);
    this.add(jLabel9, null);
    this.add(jLabel7, null);
    this.add(txtRemark, null);
    this.add(jTextField12, null);
    this.setSystemDate();
  }

  void setSystemDate() {
    //txtChkPlanFromY.setText(exgui2.Stuff.System_Year.toString());
    //txtChkPlanFromM.setText(exgui2.Stuff.System_Month.toString());
    //txtChkPlanFromD.setText(exgui2.Stuff.System_Day.toString());
    java.sql.Date nowDate=new java.sql.Date(System.currentTimeMillis());
    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbChkPlanFrom=new exgui.DataBindTextWithChecker(txtChkPlanFrom,
        "",nowDate, 10,
        (exgui.Object2String)dateVfy,
        (exgui.ultratable.CellTxtEditorFormat)dateVfy);

    dbChkPlanTo=new exgui.DataBindTextWithChecker(txtChkPlanTo,
        "",nowDate, 10,
        (exgui.Object2String)dateVfy,
        (exgui.ultratable.CellTxtEditorFormat)dateVfy);


    dbChkOdFrom=new exgui.DataBindTextWithChecker(txtChkOdFrom,
        "",nowDate, 10,
        (exgui.Object2String)dateVfy,
        (exgui.ultratable.CellTxtEditorFormat)dateVfy);


    dbChkOdTo=new exgui.DataBindTextWithChecker(txtChkOdTo,
        "",nowDate, 10,
        (exgui.Object2String)dateVfy,
        (exgui.ultratable.CellTxtEditorFormat)dateVfy);


    dbChkObdFrom=new exgui.DataBindTextWithChecker(txtChkObdFrom,
        "",nowDate, 10,
        (exgui.Object2String)dateVfy,
        (exgui.ultratable.CellTxtEditorFormat)dateVfy);

    dbChkObdTo=new exgui.DataBindTextWithChecker(txtChkObdTo,
        "",nowDate, 10,
        (exgui.Object2String)dateVfy,
        (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    Object Int4chk=exgui.verification.CellFormat.getIntVerifier(4);
    Object Int2chk=exgui.verification.CellFormat.getIntVerifier(2);

    dbChkYear=new exgui.DataBindTextWithChecker(txtChkDfYear,
        "",exgui2.Stuff.System_Year, 4,
        (exgui.Object2String)Int4chk,
        (exgui.ultratable.CellTxtEditorFormat)Int4chk);

    dbChkMonth=new exgui.DataBindTextWithChecker(txtChkDfMonth,
        "",exgui2.Stuff.System_Month, 2,
        (exgui.Object2String)Int2chk,
        (exgui.ultratable.CellTxtEditorFormat)Int2chk);

  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.center.CenterList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  boolean checkFieldsData() {
    boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),"Center Weight must be less than 999");
    boolean codeNull = exgui2.Stuff.checkNull(frame,txtCenCode.getText(),"Center Code can't be empty.");
    boolean nameNull = exgui2.Stuff.checkNull(frame,txtCenName.getText(),"Center Name can't be empty.");
    boolean prefixNull = exgui2.Stuff.checkNull(frame,txtPrefix.getText(),"Center Prefix can't be empty.");
    boolean numNull = exgui2.Stuff.checkNull(frame,txtNo.getText(),"Center NO. Code can't be empty.");
    if(!dbChkPlanFrom.isValidx())return false;
    if(!dbChkPlanTo.isValidx())return false;
    if(!dbChkOdFrom.isValidx())return false;
    if(!dbChkOdTo.isValidx())return false;
    if(!dbChkObdFrom.isValidx())return false;
    if(!dbChkObdTo.isValidx())return false;
    if(dbChkYear.getSelectedValue()!=null){
      int yearValue=Integer.parseInt(txtChkDfYear.getText());
      if(yearValue<0){
        exgui.verification.VerifyLib.showAlert("Year should be greater than zero","year value Error");
        txtChkDfYear.grabFocus();
        return false;
      }
    }
    if(dbChkMonth.getSelectedValue()!=null){
      int monthValue=Integer.parseInt(txtChkDfMonth.getText());
      if(monthValue<1 || monthValue>12){
        exgui.verification.VerifyLib.showAlert("Month value should between 1 to 12","Month value Error");
        txtChkDfMonth.grabFocus();
        return false;
      }
    }

    if(chkInt && codeNull && nameNull && prefixNull && numNull) {
      return true;
    } else {return false;}
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    if (this.checkFieldsData()) {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("CEN_CODE", txtCenCode.getText().trim().toUpperCase());
        hm.put("CEN_NAME", txtCenName.getText());
        hm.put("CEN_WEIGHT", txtWeight.getText().equals("") ? "1" : txtWeight.getText());
        hm.put("CEN_CHKDD_PLAN_FM",dbChkPlanFrom.getSelectedValue());
        hm.put("CEN_CHKDD_PLAN_TO",dbChkPlanTo.getSelectedValue());
        hm.put("CEN_CHKDD_OD_DEL_FM",dbChkOdFrom.getSelectedValue());
        hm.put("CEN_CHKDD_OD_DEL_TO",dbChkOdTo.getSelectedValue());
        hm.put("CEN_CHKDD_OBD_FM",dbChkObdFrom.getSelectedValue());
        hm.put("CEN_CHKDD_OBD_TO",dbChkObdTo.getSelectedValue());
        hm.put("CEN_CHKDD_ENTRY_DF_YY", txtChkDfYear.getText());
        hm.put("CEN_CHKDD_ENTRY_DF_MM", txtChkDfMonth.getText());
        hm.put("CEN_PREFIX", txtPrefix.getText().trim().toUpperCase());
        hm.put("CEN_REMARK", txtRemark.getText().trim().toUpperCase());
        hm.put("CEN_NUMCODE", txtNo.getText().toUpperCase());
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.BASIC_BASE_EJB.insertCenter(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.center.CenterList(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString());
      }finally{
         setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtCenCode,null,"",5);
    tx = new exgui.DataBindText(txtCenName,null,"",12);
    tx = new exgui.DataBindText(txtPrefix,null,"",2);
    tx = new exgui.DataBindText(txtNo,null,"",1);
    tx = new exgui.DataBindText(txtWeight,null,"",3);


    //tx = new exgui.DataBindText(txtChkDfYear,null,"",4);
    //tx = new exgui.DataBindText(txtChkDfMonth,null,"",2);
  }
  JTextField txtRemark = new JTextField();
  JLabel jTextField12 = new JLabel();
}
