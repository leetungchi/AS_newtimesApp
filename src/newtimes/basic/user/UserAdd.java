package newtimes.basic.user;

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
 * @version 1.0
 */

public class UserAdd extends JPanel {
  Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JButton butnExit = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JButton butnAdd = new JButton();
  private newtimes.basic.user.UserFieldsPanel userFieldsPanel =
      new newtimes.basic.user.UserFieldsPanel(frame, "NEW");
  JScrollPane jScrollPane1 = new JScrollPane();

  public UserAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setBorder(BorderFactory.createEtchedBorder());
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(302, 509, 80, 25));
    butnAdd.setBackground(Color.lightGray);
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  User Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setBorder(BorderFactory.createEtchedBorder());
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(421, 509, 80, 25));
    butnExit.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setDoubleBuffered(true);
    this.setActionMap(null);
    userFieldsPanel.setBounds(new Rectangle(7, 65, 778, 489));
    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.getViewport().setBackground(new Color(204, 204, 225));
    jScrollPane1.setAutoscrolls(true);
    jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setMinimumSize(new Dimension(24, 24));
    jScrollPane1.setBounds(new Rectangle(0, 66, 793, 435));
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(userFieldsPanel, null);
    this.add(jLabel1, null);
    this.add(textAreaStatus, null);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(jScrollPane1, null);
    userFieldsPanel.init_dbJCBXMagDF();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.user.UserSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (userFieldsPanel.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm = userFieldsPanel.setData2HashMap();
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.BASIC_BASE_EJB.insertUserfile(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.user.UserSearch(frame));
      }catch(java.rmi.RemoteException rexp){
        util.ExceptionLog.exp2File(rexp,"error,while attemp to insert user file");
        Throwable expCoz=rexp.getCause();
        if(expCoz instanceof javax.ejb.EJBException){
          expCoz=((javax.ejb.EJBException)expCoz).getCausedByException();
        }
        System.out.println(expCoz.getLocalizedMessage());
        if(expCoz instanceof java.sql.SQLException ){
          String string=expCoz.getLocalizedMessage();
          if(string.indexOf("ORA-00001: unique constraint")!=-1){
              exgui.verification.VerifyLib.showAlert(
                "Sorry,This User Code Is Already Used",
                "Error:Unique Constraint");
          }else{
            exgui.verification.VerifyLib.showAlert(
              "Server Side Exception\nPlease Contact System Manager\nError:"+string,
              "Server Side Error");
          }
        }else{
          exgui.verification.VerifyLib.showAlert(
           "I/O Connection Error\nPlease Contact System Manager",
           "Connection Error");
        }
      } catch (Exception eIn) {
        util.ExceptionLog.exp2File(eIn,"error,while attemp to insert user file");
        eIn.printStackTrace();
        util.ExceptionLog.exp2File(eIn, "HashMap:" + hm.toString());
        exgui.verification.VerifyLib.showAlert(
         "Unkwon Error,Please Contact System Manager",
         "Unkown Error");
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
