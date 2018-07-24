package newtimes.basic.currency;

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

public class CurrencyEdit extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JButton butnExit = new JButton();
  private JTextField txtCurrency = new JTextField();
  private JButton butnModify = new JButton();
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private String _oldCrncy = null;
  static boolean isExit = false;
  JLabel jTextField2 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaDesc = new JTextArea();
  JButton btnDelete = new JButton();

  public CurrencyEdit(Frame1 _frame) {
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
    butnModify.setBounds(new Rectangle(312, 479, 131, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.setActionCommand("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setText("Confirm Modify");
    txtCurrency.setBounds(new Rectangle(335, 107, 271, 23));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(469, 479, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    //jTextField1.setEditable(false);
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    jTextField1.setText(" * Currency :");
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Currency Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setText(" Description :");
    jTextField2.setBounds(new Rectangle(178, 148, 155, 98));
    jScrollPane1.setBounds(new Rectangle(335, 148, 271, 98));
    txtAreaDesc.setToolTipText("");
    txtAreaDesc.setLineWrap(true);
    btnDelete.setBackground(Color.lightGray);
    btnDelete.setBounds(new Rectangle(175, 479, 110, 24));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.darkGray);
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(txtCurrency, null);
    this.add(jTextField2, null);
    this.add(jScrollPane1, null);
    this.add(butnModify, null);
    this.add(btnDelete, null);
    this.add(butnExit, null);
    jScrollPane1.getViewport().add(txtAreaDesc, null);
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
          hm.put("CRNCY_DESC", txtAreaDesc.getText().trim());
          hm.put("currency_update", txtCurrency.getText().trim().toUpperCase());
          hm.put("currency_delete", this._oldCrncy);
          int isOk = exgui2.CONST.BASIC_MAIN_EJB.updateCurrency(hm);
          if (exgui2.Stuff.updateMessage(frame, isOk))
            frame.showPanel(new newtimes.basic.currency.CurrencyList(frame));
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
    frame.showPanel(new newtimes.basic.currency.CurrencyList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtCurrency,null,"",3);
    tx = new exgui.DataBindText(txtAreaDesc,null,"",100);
  }

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtCurrency.getText(),"Currency can't be empty.");
    if (nameNull) { return true; }
    else { return false; }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      this._oldCrncy = recDetail.get("CRNCY_NAME")==null?"":recDetail.get("CRNCY_NAME").toString();
      txtCurrency.setText(this._oldCrncy);
      txtAreaDesc.setText(recDetail.get("CRNCY_DESC")==null?"":recDetail.get("CRNCY_DESC").toString());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }
  void btnDelete_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame, "DELETE ?");
    if (result != 0) return;
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    java.util.Vector vctpk=new java.util.Vector();
    database.datatype.Record recDetail = (database.datatype.Record)hm.get("recDetail");
    try{
      vctpk.add(recDetail.get("CRNCY_NAME"));
      exgui2.CONST.BASIC_MAIN_EJB.deleteFunction("currency_tbl", vctpk,
                                                 (String)util.PublicVariable.
                                                 USER_RECORD.get("usr_code"));
      frame.showPanel(new newtimes.basic.currency.CurrencyList(frame));
    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Delete Fail,Please Contact System Manager","DELETE FAIL");
      util.ExceptionLog.exp2File(exp,"delete fail");
      exp.printStackTrace();
    }finally{
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

  }
}
