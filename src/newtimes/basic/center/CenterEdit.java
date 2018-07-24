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

public class CenterEdit extends JPanel {
  Frame1 frame;
  private JButton butnDel = new JButton();
  private JTextField txtWeight = new JTextField();
  private JTextField txtCenName = new JTextField();
  private JButton butnModify = new JButton();
  private JTextField txtCenCode = new JTextField();
  private JButton butnExit = new JButton();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField6 = new JLabel();
  private JLabel jTextField9 = new JLabel();
  private JLabel jTextField7 = new JLabel();
  private JLabel jTextField8 = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField13 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField14 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JTextField txtChkDfYear = new JTextField();
  private JTextField txtChkObdTo = new JTextField();
  private JTextField txtChkObdFrom = new JTextField();
  private JLabel jLabel6 = new JLabel();
  private JTextField txtChkOdTo = new JTextField();
  private JTextField txtChkPlanTo = new JTextField();
  private JTextField txtChkOdFrom = new JTextField();
  private JTextField txtChkPlanFrom = new JTextField();
  private JTextField txtChkDfMonth = new JTextField();
  private JTextField txtRemark = new JTextField();
  private java.util.HashMap hm =
      (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  JTextField txtNo = new JTextField();
  JLabel jTextField10 = new JLabel();
  JTextField txtPrefix = new JTextField();
  JLabel jTextField11 = new JLabel();
  static boolean isExit = false;
  exgui.DataBindTextWithChecker
     dbChkPlanFrom,dbChkPlanTo,dbChkOdFrom,dbChkOdTo,
     dbChkObdFrom,dbChkObdTo,dbChkYear,dbChkMonth;

  public CenterEdit(Frame1 _frame) {
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
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Center Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setText(" * Center Code :");
    jTextField1.setBounds(new Rectangle(82, 88, 155, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setText(" * Center Name :");
    jTextField2.setBounds(new Rectangle(82, 124, 155, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setText(" Weight :");
    jTextField3.setBounds(new Rectangle(82, 159, 155, 23));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(471, 489, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    txtCenCode.setBounds(new Rectangle(239, 88, 155, 23));
    txtCenCode.setEnabled(false);
    txtCenCode.setEditable(false);
    butnModify.setBackground(Color.lightGray);
    butnModify.setBounds(new Rectangle(229, 489, 130, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    txtCenName.setBounds(new Rectangle(239, 124, 155, 23));
    txtWeight.setBounds(new Rectangle(239, 159, 155, 23));
    txtRemark.setBounds(new Rectangle(239, 383, 430, 23));
    butnDel.setBackground(Color.lightGray);
    butnDel.setBounds(new Rectangle(375, 489, 80, 25));
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setForeground(Color.darkGray);
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    //jTextField6.setEditable(false);
    jTextField6.setText(" Check OD Delivery From :");
    jTextField6.setBounds(new Rectangle(82, 270, 155, 23));
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setBorder(null);
    jTextField9.setOpaque(true);
   // jTextField9.setEditable(false);
    jTextField9.setText(" Check OBD To :");
    jTextField9.setBounds(new Rectangle(413, 306, 155, 23));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(new Color(10,36,106));
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    //jTextField7.setEditable(false);
    jTextField7.setText(" Check OD Delivery To :");
    jTextField7.setBounds(new Rectangle(413, 270, 155, 23));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(Color.white);
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    //jTextField8.setEditable(false);
    jTextField8.setText(" Check OBD From :");
    jTextField8.setBounds(new Rectangle(82, 306, 155, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setText(" Check Plan To :");
    jTextField5.setBounds(new Rectangle(413, 233, 155, 23));
    jTextField13.setBounds(new Rectangle(82, 343, 155, 23));
    jTextField13.setText(" Check Entry DF Year :");
    //jTextField13.setCaretColor(Color.white);
    //jTextField13.setEditable(false);
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    jTextField13.setForeground(new Color(10,36,106));
    jTextField13.setFont(new java.awt.Font("SansSerif", 1, 12));
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setText(" Check Plan From :");
    jTextField4.setBounds(new Rectangle(82, 233, 155, 23));
    jTextField14.setBounds(new Rectangle(413, 343, 155, 23));
    jTextField14.setText(" Check Entry DF Month :");
    jTextField14.setBorder(null);
    jTextField14.setOpaque(true);
    //jTextField14.setEditable(false);
    jTextField14.setForeground(new Color(10,36,106));
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setBackground(new Color(143, 143, 188));
    jLabel5.setBounds(new Rectangle(614, 343, 51, 23));
    jLabel5.setText("(Month)");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setForeground(new Color(10,36,106));
    txtChkDfYear.setText("");
    txtChkDfYear.setBounds(new Rectangle(239, 343, 54, 23));
    txtChkObdTo.setText("");
    txtChkObdTo.setBounds(new Rectangle(570, 306, 103, 23));
    txtChkObdFrom.setText("");
    txtChkObdFrom.setBounds(new Rectangle(239, 306, 86, 23));
    jLabel6.setForeground(new Color(10,36,106));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("(Year)");
    jLabel6.setBounds(new Rectangle(300, 343, 51, 23));
    txtChkOdTo.setText("");
    txtChkOdTo.setBounds(new Rectangle(570, 270, 103, 23));
    txtChkPlanTo.setText("");
    txtChkPlanTo.setBounds(new Rectangle(570, 233, 102, 23));
    txtChkOdFrom.setText("");
    txtChkOdFrom.setBounds(new Rectangle(239, 270, 85, 23));
    txtChkPlanFrom.setBounds(new Rectangle(239, 233, 86, 23));
    txtChkPlanFrom.setText("");
    txtChkPlanFrom.setSelectionEnd(4);
    txtChkDfMonth.setBounds(new Rectangle(570, 343, 37, 23));
    txtNo.setEnabled(false);
    txtNo.setEditable(false);
    txtNo.setBounds(new Rectangle(570, 124, 155, 23));
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(Color.white);
    //jTextField10.setEditable(false);
    jTextField10.setBorder(null);
    jTextField10.setOpaque(true);
    jTextField10.setText(" * Center NO. Code :");
    jTextField10.setBounds(new Rectangle(413, 124, 155, 23));
    txtPrefix.setEnabled(false);
    txtPrefix.setEditable(false);
    txtPrefix.setBounds(new Rectangle(570, 88, 155, 23));
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(new Color(10,36,106));
    //jTextField11.setEditable(false);
    jTextField11.setBorder(null);
    jTextField11.setOpaque(true);
    jTextField11.setText(" * Center Prefix :");
    jTextField11.setBounds(new Rectangle(413, 88, 155, 23));
    jLabel2.setText("yyyy/mm/dd");
    jLabel2.setBounds(new Rectangle(332, 233, 65, 22));
    jLabel3.setBounds(new Rectangle(332, 271, 65, 22));
    jLabel3.setText("yyyy/mm/dd");
    jLabel4.setBounds(new Rectangle(332, 306, 65, 22));
    jLabel4.setText("yyyy/mm/dd");
    jLabel7.setText("yyyy/mm/dd");
    jLabel7.setBounds(new Rectangle(677, 306, 65, 22));
    jLabel8.setBounds(new Rectangle(677, 233, 65, 22));
    jLabel8.setText("yyyy/mm/dd");
    jLabel9.setText("yyyy/mm/dd");
    jLabel9.setBounds(new Rectangle(677, 271, 65, 22));
    jTextField12.setBounds(new Rectangle(82, 383, 155, 23));
    jTextField12.setText("Remark :");
    jTextField12.setOpaque(true);
    jTextField12.setBorder(null);
    jTextField12.setForeground(Color.white);
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setBackground(new Color(143, 143, 188));
    this.add(textAreaStatus, null);
    this.add(butnModify, null);
    this.add(butnDel, null);
    this.add(butnExit, null);
    this.add(jLabel1, null);
    this.add(jTextField3, null);
    this.add(jTextField11, null);
    this.add(txtPrefix, null);
    this.add(jTextField10, null);
    this.add(txtNo, null);
    this.add(jTextField5, null);
    this.add(jTextField7, null);
    this.add(txtChkOdTo, null);
    this.add(jTextField9, null);
    this.add(txtChkObdTo, null);
    this.add(jTextField14, null);
    this.add(txtChkDfMonth, null);
    this.add(txtChkPlanTo, null);
    this.add(jLabel5, null);
    this.add(jTextField13, null);
    this.add(jTextField1, null);
    this.add(txtChkOdFrom, null);
    this.add(txtChkDfYear, null);
    this.add(jTextField6, null);
    this.add(jTextField8, null);
    this.add(jLabel6, null);
    this.add(txtCenCode, null);
    this.add(txtCenName, null);
    this.add(txtWeight, null);
    this.add(jTextField2, null);
    this.add(jTextField4, null);
    this.add(txtChkObdFrom, null);
    this.add(txtChkPlanFrom, null);
    this.add(txtRemark, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(jLabel4, null);
    this.add(jLabel7, null);
    this.add(jLabel8, null);
    this.add(jLabel9, null);
    this.add(jTextField12, null);
    this.setData2Fields();
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.center.CenterList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("cen_code", txtCenCode.getText());
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_BASE_EJB.deleteCenter(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.center.CenterList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
     }catch(BasicMdlEJBs.ExcpDltReferedByUser  edUser){
       exgui.verification.VerifyLib.showPlanMsg("Sorry,This Record Is Referenced In Some User(s)",
                                                "Record Referenced");

     }catch(BasicMdlEJBs.ExcpDltReferedByProdution edProdUsed){
      exgui.verification.VerifyLib.showPlanMsg("Sorry,This Record Is Referenced In Some Production(s)",
                                               "Record Referenced");
     }catch(java.rmi.RemoteException re){
      re.printStackTrace();
      util.ExceptionLog.exp2File(re,"");
      exgui.verification.VerifyLib.showAlert("Connection Or Server Side Error\nPlease Contact System Manager",
                                             "Remote Exception");
     }catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
     }finally{
       setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
     }
    }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      txtPrefix.setText(recDetail.get("CEN_PREFIX")==null?"":recDetail.get("CEN_PREFIX").toString());
      txtNo.setText(recDetail.get("CEN_NUMCODE")==null?"":recDetail.get("CEN_NUMCODE").toString());
      txtCenCode.setText(recDetail.get("cen_code")==null?"":recDetail.get("cen_code").toString());
      txtCenName.setText(recDetail.get("cen_name")==null?"":recDetail.get("cen_name").toString());
      txtWeight.setText(recDetail.get("CEN_WEIGHT")==null?"":recDetail.get("CEN_WEIGHT").toString());
      txtRemark.setText(recDetail.get("CEN_REMARK")==null?"":recDetail.get("CEN_REMARK").toString());

      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull(); ;


      dbChkPlanFrom=new exgui.DataBindTextWithChecker(txtChkPlanFrom,
          "CEN_CHKDD_PLAN_FM",recDetail.get("CEN_CHKDD_PLAN_FM"), 10,
          (exgui.Object2String)dateVfy,
          (exgui.ultratable.CellTxtEditorFormat)dateVfy);

      dbChkPlanTo=new exgui.DataBindTextWithChecker(txtChkPlanTo,
          "CEN_CHKDD_PLAN_TO",recDetail.get("CEN_CHKDD_PLAN_TO"), 10,
          (exgui.Object2String)dateVfy,
          (exgui.ultratable.CellTxtEditorFormat)dateVfy);


      dbChkOdFrom=new exgui.DataBindTextWithChecker(txtChkOdFrom,
          "CEN_CHKDD_OD_DEL_FM",recDetail.get("CEN_CHKDD_OD_DEL_FM"), 10,
          (exgui.Object2String)dateVfy,
          (exgui.ultratable.CellTxtEditorFormat)dateVfy);


      dbChkOdTo=new exgui.DataBindTextWithChecker(txtChkOdTo,
          "CEN_CHKDD_OD_DEL_TO",recDetail.get("CEN_CHKDD_OD_DEL_TO"), 10,
          (exgui.Object2String)dateVfy,
          (exgui.ultratable.CellTxtEditorFormat)dateVfy);


      dbChkObdFrom=new exgui.DataBindTextWithChecker(txtChkObdFrom,
          "CEN_CHKDD_OBD_FM",recDetail.get("CEN_CHKDD_OBD_FM"), 10,
          (exgui.Object2String)dateVfy,
          (exgui.ultratable.CellTxtEditorFormat)dateVfy);

      dbChkObdTo=new exgui.DataBindTextWithChecker(txtChkObdTo,
          "CEN_CHKDD_OBD_TO",recDetail.get("CEN_CHKDD_OBD_TO"), 10,
          (exgui.Object2String)dateVfy,
          (exgui.ultratable.CellTxtEditorFormat)dateVfy);
      //txtChkDfYear.setText(recDetail.get("CEN_CHKDD_ENTRY_DF_YY")==null?"":recDetail.get("CEN_CHKDD_ENTRY_DF_YY").toString());
      //txtChkDfMonth.setText(recDetail.get("CEN_CHKDD_ENTRY_DF_MM")==null?"":recDetail.get("CEN_CHKDD_ENTRY_DF_MM").toString());
      Object Int4chk=exgui.verification.CellFormat.getIntVerifier(4);
      Object Int2chk=exgui.verification.CellFormat.getIntVerifier(2);

      dbChkYear=new exgui.DataBindTextWithChecker(txtChkDfYear,
          "CEN_CHKDD_ENTRY_DF_YY",recDetail.get("CEN_CHKDD_ENTRY_DF_YY"), 4,
          (exgui.Object2String)Int4chk,
          (exgui.ultratable.CellTxtEditorFormat)Int4chk);

      dbChkMonth=new exgui.DataBindTextWithChecker(txtChkDfMonth,
          "CEN_CHKDD_ENTRY_DF_MM",recDetail.get("CEN_CHKDD_ENTRY_DF_MM"), 2,
          (exgui.Object2String)Int2chk,
          (exgui.ultratable.CellTxtEditorFormat)Int2chk);

    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+
                                 recDetail.toString());
    }
  }

  boolean checkFieldsData() {
      boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),
                                                 "Center Weight must be less than 999");
      boolean nameNull = exgui2.Stuff.checkNull(frame,txtCenName.getText(),"Center Name can't be empty.");
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
      if(chkInt && nameNull) {
        return true;
      } else {return false;}
    }

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if(result == 0){
      if (this.checkFieldsData()) {
        java.util.HashMap hm = new java.util.HashMap();
        try {
          setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          isExit = true;
          hm.put("CEN_CODE", txtCenCode.getText().trim().toUpperCase());
          hm.put("CEN_NAME", txtCenName.getText().trim().toUpperCase());
          hm.put("CEN_WEIGHT", txtWeight.getText().equals("") ? "1" : txtWeight.getText().trim().toUpperCase());
          hm.put("CEN_CHKDD_PLAN_FM",dbChkPlanFrom.getSelectedValue());
          hm.put("CEN_CHKDD_PLAN_TO",dbChkPlanTo.getSelectedValue());
          hm.put("CEN_CHKDD_OD_DEL_FM",dbChkOdFrom.getSelectedValue());
          hm.put("CEN_CHKDD_OD_DEL_TO",dbChkOdTo.getSelectedValue());
          hm.put("CEN_CHKDD_OBD_FM",dbChkObdFrom.getSelectedValue());
          hm.put("CEN_CHKDD_OBD_TO",dbChkObdTo.getSelectedValue());
          hm.put("CEN_CHKDD_ENTRY_DF_YY", txtChkDfYear.getText().trim());
          hm.put("CEN_CHKDD_ENTRY_DF_MM", txtChkDfMonth.getText().trim());
          hm.put("CEN_PREFIX", txtPrefix.getText().trim().toUpperCase());
          hm.put("CEN_REMARK", txtRemark.getText().trim().toUpperCase());
          hm.put("CEN_NUMCODE", txtNo.getText().trim().toUpperCase());
          hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));

          boolean isOk = exgui2.CONST.BASIC_BASE_EJB.updateCenter(hm);
          if (isOk) {
            exgui2.InfoMessage.infoMessage(frame, "Update Succeed.");
            frame.showPanel(new newtimes.basic.center.CenterList(frame));
          }
          else {
            exgui2.InfoMessage.warningMessage(frame, "Update Failed.");
          }
        }
        catch (Exception eAdd) {
          eAdd.printStackTrace();
          util.ExceptionLog.exp2File(eAdd,
                                     "error at update data." + hm.toString());
        }finally{
          setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
      }

    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtPrefix,null,"",2);
    tx = new exgui.DataBindText(txtNo,null,"",1);
    tx = new exgui.DataBindText(txtCenCode,null,"",5);
    tx = new exgui.DataBindText(txtCenName,null,"",12);
    tx = new exgui.DataBindText(txtWeight,null,"",3);
    tx = new exgui.DataBindText(txtRemark,null,"",50);
    //tx = new exgui.DataBindText(txtChkDfYear,null,"",4);
    //tx = new exgui.DataBindText(txtChkDfMonth,null,"",2);
  }
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jTextField12 = new JLabel();

}
