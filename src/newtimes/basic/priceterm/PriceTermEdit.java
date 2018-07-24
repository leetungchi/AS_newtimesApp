package newtimes.basic.priceterm;

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

public class PriceTermEdit extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JButton butnExit = new JButton();
  private JTextField txtPriceTerm = new JTextField();
  private JButton butnModify = new JButton();
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private String _oldPT = null;
  static boolean isExit = false;
  JButton btnDELETE = new JButton();
  public PriceTermEdit(Frame1 _frame) {
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
    butnModify.setBounds(new Rectangle(285, 479, 131, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setText("Confirm Modify");
    txtPriceTerm.setBounds(new Rectangle(335, 107, 271, 23));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(429, 479, 80, 25));
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
    jTextField1.setText(" * Price Term :");
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Price Term Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    btnDELETE.setText("DELETE");
    btnDELETE.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDELETE_actionPerformed(e);
      }
    });
    btnDELETE.setForeground(Color.darkGray);
    btnDELETE.setFont(new java.awt.Font("Dialog", 1, 13));
    btnDELETE.setBounds(new Rectangle(134, 479, 131, 25));
    btnDELETE.setBackground(Color.lightGray);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(txtPriceTerm, null);
    this.add(butnExit, null);
    this.add(butnModify, null);
    this.add(btnDELETE, null);
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
          hm.put("priceterm_update", txtPriceTerm.getText().trim().toUpperCase());
          hm.put("priceterm_delete", this._oldPT);
          int isOk = exgui2.CONST.BASIC_MAIN_EJB.updatePriceTerm(hm);
          if (exgui2.Stuff.updateMessage(frame, isOk))
            frame.showPanel(new newtimes.basic.priceterm.PriceTermList(frame));
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
    frame.showPanel(new newtimes.basic.priceterm.PriceTermList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtPriceTerm,null,"",7);
  }

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtPriceTerm.getText(),"Price Term can't be empty.");
    if (nameNull) { return true; }
    else { return false; }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      this._oldPT = recDetail.get("PRC_TRM")==null?"":recDetail.get("PRC_TRM").toString();
      txtPriceTerm.setText(this._oldPT);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }
  void btnDELETE_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame, "DELETE ?");
    if (result != 0) return;
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    java.util.Vector vctpk=new java.util.Vector();
    database.datatype.Record recDetail = (database.datatype.Record)hm.get("recDetail");
    try{
      vctpk.add(recDetail.get("PRC_TRM"));
      exgui2.CONST.BASIC_MAIN_EJB.deleteFunction("price_term_tbl", vctpk,
                                                 (String)util.PublicVariable.
                                                 USER_RECORD.get("usr_code"));
      frame.showPanel(new newtimes.basic.priceterm.PriceTermList(frame));
    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Delete Fail,Please Contact System Manager","DELETE FAIL");
      util.ExceptionLog.exp2File(exp,"delete fail");
      exp.printStackTrace();
    }finally{
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }


  }
}
