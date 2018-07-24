package newtimes.basic.quota;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QuotaEdit extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton butnExit = new JButton();
  private JButton butnModify = new JButton();
  private JTextField txtWeight = new JTextField();
  private JLabel jTextField2 = new JLabel();
  private JTextField txtRemark = new JTextField();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JTextField txtCat = new JTextField();
  private JLabel jTextField4 = new JLabel();
  private JComboBox cmboArea = new JComboBox();
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private String _oldCat = null;
  private String _oldArea = null;
  static boolean isExit = false;
  JButton btnDelete = new JButton();

  public QuotaEdit(Frame1 _frame) {
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
    butnModify.setBackground(Color.lightGray);
    butnModify.setBounds(new Rectangle(368, 478, 130, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setText("Confirm Modify");
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(508, 478, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Quota Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    txtWeight.setBounds(new Rectangle(335, 180, 271, 23));
    jTextField2.setBounds(new Rectangle(178, 143, 155, 23));
    jTextField2.setText(" * Area-Code ( U / C / E / I ) :");
    //jTextField2.setEditable(false);
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    jTextField2.setForeground(Color.white);
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    txtRemark.setText("");
    txtRemark.setBounds(new Rectangle(335, 216, 271, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setText(" * Category :");
    jTextField5.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField3.setBounds(new Rectangle(178, 180, 155, 23));
    jTextField3.setText(" Weight :");
    //jTextField3.setEditable(false);
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    txtCat.setBounds(new Rectangle(335, 107, 271, 23));
    jTextField4.setBounds(new Rectangle(178, 216, 155, 23));
    jTextField4.setText(" Remark :");
    //jTextField4.setEditable(false);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    jTextField4.setForeground(Color.white);
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    cmboArea.setBounds(new Rectangle(335, 143, 271, 23));
    cmboArea.setBackground(Color.white);
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setForeground(Color.darkGray);
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 13));
    btnDelete.setBounds(new Rectangle(227, 477, 131, 25));
    btnDelete.setBackground(Color.lightGray);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(txtWeight, null);
    this.add(jTextField5, null);
    this.add(txtCat, null);
    this.add(jTextField2, null);
    this.add(jTextField3, null);
    this.add(jTextField4, null);
    this.add(txtRemark, null);
    this.add(cmboArea, null);
    this.add(btnDelete, null);
    this.add(butnModify, null);
    this.add(butnExit, null);
    exgui2.Stuff.getQuotaAreaCode4JComboBox(cmboArea);
    this.setData2Fields();
  }

  void butnModify_actionPerformed(ActionEvent e) {
    if (this.checkFieldsData()) {
      int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
      if (result == 0) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
          isExit = true;
          hm.clear();
          database.datatype.Record recDetail = (database.datatype.Record) hm.get("recDetail");
          hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
          hm.put("cat_update", txtCat.getText().trim().toUpperCase());
          hm.put("cat_delete", this._oldCat);
          hm.put("area_update", exgui2.Stuff.getQuotaAreaCodeValue4JComboBox(cmboArea));
          hm.put("area_delete", this._oldArea);
          hm.put("QTA_WEIGHT", txtWeight.getText().trim().toUpperCase());
          hm.put("QTA_REMARK", txtRemark.getText());
          int isOk = exgui2.CONST.BASIC_MAIN_EJB.updateQuota(hm);
          if (exgui2.Stuff.updateMessage(frame, isOk)) {
            frame.showPanel(new newtimes.basic.quota.QuotaLit(frame));
          }
        } catch (Exception eDel) {
          eDel.printStackTrace();
          util.ExceptionLog.exp2File(eDel,"error at modify data." + hm.toString());
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.quota.QuotaLit(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtCat.getText(),"Quota Category can't be empty.");
    boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),"Quota Weight must be less than 999");
    if (nameNull && chkInt) { return true; }
    else { return false; }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      this._oldCat = recDetail.get("QTA_CAT")==null?"":recDetail.get("QTA_CAT").toString().trim();
      this._oldArea = recDetail.get("QTA_AREA")==null?"":recDetail.get("QTA_AREA").toString().trim();
      txtCat.setText(this._oldCat);
      cmboArea.setSelectedItem(this._oldArea);
      txtWeight.setText(recDetail.get("QTA_WEIGHT")==null?"":recDetail.get("QTA_WEIGHT").toString());
      txtRemark.setText(recDetail.get("QTA_REMARK")==null?"":recDetail.get("QTA_REMARK").toString());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtCat,null,"",10);
    tx = new exgui.DataBindText(txtWeight,null,"",3);
    tx = new exgui.DataBindText(txtRemark,null,"",30);
  }
  void btnDelete_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame, "DELETE ?");
    if (result != 0) return;
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    java.util.Vector vctpk=new java.util.Vector();

    try{
      vctpk.add(_oldCat);
      vctpk.add(_oldArea);
      exgui2.CONST.BASIC_MAIN_EJB.deleteFunction("quota_tbl", vctpk,
                                                 (String)util.PublicVariable.
                                                 USER_RECORD.get("usr_code"));
      frame.showPanel(new newtimes.basic.quota.QuotaLit(frame));
    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Delete Fail,Please Contact System Manager","DELETE FAIL");
      util.ExceptionLog.exp2File(exp,"delete fail");
      exp.printStackTrace();
    }finally{
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
}
