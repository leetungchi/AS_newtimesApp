package newtimes.shipping.shippingmaintain;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: Shipping Maintain</p>
 * <p>Description:<br>
 * This program is portal will edit or add new shipping.<br>
 * Press "Add New" button will to MasterAdd.java.<br>
 * Press "Extract" button will to MasterEdit.java.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Chloe H.
 * @version 1.0
 */

public class MasterSearch extends JPanel {
  Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JButton butnModify = new JButton();
  private JButton butnAdd = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextField3 = new JTextField();
  private JButton butnExit = new JButton();
  private JTextField txtSrnNo = new JTextField();
  private String usrCenCode = null;
  private String usrType = null;

  public MasterSearch(Frame1 _frame) {
    frame = _frame;
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setAuth();
    txtSrnNo.setBounds(new Rectangle(378, 105, 271, 23));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(479, 495, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jTextField3.setBounds(new Rectangle(146, 105, 230, 23));
    jTextField3.setText(" For Modify / Delete SRN No. :");
    jTextField3.setBorder(null);
    jTextField3.setEditable(false);
    jTextField3.setForeground(Color.white);
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setEnabled(true);
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Shipping Maintain  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setText("Add New");
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(274, 495, 100, 25));
    butnAdd.setBackground(Color.lightGray);
    butnModify.setText("Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setForeground(Color.darkGray);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setBounds(new Rectangle(387, 495, 80, 25));
    butnModify.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.add(butnExit, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField3, null);
    this.add(butnModify, null);
    this.add(butnAdd, null);
    this.add(txtSrnNo, null);
  }
  void butnModify_actionPerformed(ActionEvent e) {
    try {
      if (!txtSrnNo.getText().trim().equals("")) {
        String user_center=util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
        String user_dept=util.PublicVariable.USER_RECORD.get("USR_DEP_CODE_DF").toString();
        String mod_dept=util.PublicVariable.USER_RECORD.get("USR_DEP_MOD").toString();
        boolean authStatus=false;
        // verify Auth (String ship_no,String center,String Dept,String mod_dept,String usertype)
        if(!usrType.equals("7")){
          authStatus = (boolean)exgui2.CONST.SHIP_MAIN_EJB.VerifyAuth(
              txtSrnNo.getText().trim(), user_center, user_dept, mod_dept,
              usrType);
          if(!authStatus){
            exgui.verification.VerifyLib.showAlert("No Such SRN No.",
                "No Such SRN No.");
             return;
          }
        }
        if(authStatus || usrType.equals("7")){
          //verify is ok or usertype=7 abroad users
          setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          java.util.Vector v = (java.util.Vector)exgui2.CONST.SHIP_MAIN_EJB.
              getRecords(txtSrnNo.getText().trim());
          if (v.size() == 0) {
            exgui2.InfoMessage.infoMessage(frame, "No this SRN No.");
          } else {
            util.ApplicationProperites.setProperties("v", v);
            util.ApplicationProperites.setProperties("SRN_NO",
                txtSrnNo.getText().trim());
            frame.showPanel(new newtimes.shipping.shippingmaintain.MasterEdit(
                frame,
                txtSrnNo.getText().trim()));
          }
        }else{
          //verify is not ok
          exgui2.InfoMessage.warningMessage(frame, "You Have No Authorizations.");
        }
      } else {
        exgui2.InfoMessage.warningMessage(frame, "Please input SRN No.");
      }
    } catch (Exception eM) {
      eM.printStackTrace();
      util.ExceptionLog.exp2File(eM, "error at pressed Modify button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.setProperties("SRN_NO", "");
    frame.showPanel(new newtimes.shipping.shippingmaintain.MasterAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void setAuth() {
    try {
      if (usrType.equals("3") || usrType.equals("4") || usrType.equals("5")) {
        butnAdd.setEnabled(false);
        butnModify.setEnabled(true);
      } else {
//        butnModify.setEnabled(false);
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,"error at check authorization.\nuser type:"+usrType);
    }
  }
}
