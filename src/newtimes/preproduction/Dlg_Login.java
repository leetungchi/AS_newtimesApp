package newtimes.preproduction;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Dlg_Login extends JDialog {
  JPanel panel1 = new JPanel();
  JButton jbtnLogin = new JButton();
  JButton exit = new JButton();
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JTextField txtUserID = new JTextField();
  JTextField txtPasswd = new JTextField();
  BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB ejb=null;
  static public final int STATUS_EXIT=0;
  static public final int STATUS_OK=1;
  static public final int STATUS_ERROR=2;
  int returnStatus=STATUS_EXIT;
  database.datatype.Record rec2return;
  public Dlg_Login(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public Dlg_Login() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jbtnLogin.setBounds(new Rectangle(41, 243, 71, 29));
    jbtnLogin.setText("LOGIN");
    jbtnLogin.addActionListener(new Dlg_Login_jbtnLogin_actionAdapter(this));
    exit.setBounds(new Rectangle(276, 243, 70, 29));
    exit.setText("EXIT");
    exit.addActionListener(new Dlg_Login_exit_actionAdapter(this));
    blueBkgWhiteCharLabel1.setText("USER ID");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(36, 52, 95, 32));
    whiteBkgBlueCharLabel1.setText("PASSWORD");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(36, 110, 92, 31));
    txtUserID.setText("");
    txtUserID.setBounds(new Rectangle(131, 52, 89, 32));
    txtUserID.addKeyListener(new Dlg_Login_txtUserID_keyAdapter(this));
    txtPasswd.setText("");
    txtPasswd.setBounds(new Rectangle(128, 110, 93, 31));
    this.addWindowListener(new Dlg_Login_this_windowAdapter(this));
    getContentPane().add(panel1);
    panel1.add(jbtnLogin, null);
    panel1.add(exit, null);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(txtUserID, null);
    panel1.add(txtPasswd, null);
  }
  public int getReturnCode  (){
    return returnStatus;
  }
  public database.datatype.Record getReturnedRecord(){
    return rec2return;
  }
  void jbtnLogin_actionPerformed(ActionEvent e) {
    try{
      String serverAt = util.PublicVariable.SERVER_URL;
      BasicMdlEJBs.BasicBaseEJB.BasicBaseEJBHome ejbHome =
          (BasicMdlEJBs.BasicBaseEJB.BasicBaseEJBHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          serverAt, "BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB");
      rec2return=ejbHome.create().getUserRecord(txtUserID.getText(),
        txtPasswd.getText());
      returnStatus=STATUS_OK;
      dispose();
    }catch(java.io.IOException ioe){
      ioe.printStackTrace();
      exgui.verification.VerifyLib.showPlanMsg("network exception!",
      "network exception!");
      returnStatus=STATUS_ERROR;
      return;
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showPlanMsg(
      "login fail,user id or password miss match",
      "login fail,user id or password miss match");
      returnStatus=STATUS_ERROR;
    }
  }

  void exit_actionPerformed(ActionEvent e) {
     returnStatus=STATUS_EXIT;
     this.dispose();
  }

  void this_windowClosing(WindowEvent e) {
     returnStatus=STATUS_EXIT;
  }

  void txtUserID_keyPressed(KeyEvent e) {
    System.out.println("key code is:"+e.getKeyCode());


  }

  void txtUserID_keyReleased(KeyEvent e) {
    //e.setKeyCode(0);
  }

  void txtUserID_keyTyped(KeyEvent e) {
    //e.setKeyCode(0);
   // e.consume();
  }

}

class Dlg_Login_jbtnLogin_actionAdapter implements java.awt.event.ActionListener {
  Dlg_Login adaptee;

  Dlg_Login_jbtnLogin_actionAdapter(Dlg_Login adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtnLogin_actionPerformed(e);
  }
}

class Dlg_Login_exit_actionAdapter implements java.awt.event.ActionListener {
  Dlg_Login adaptee;

  Dlg_Login_exit_actionAdapter(Dlg_Login adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}

class Dlg_Login_this_windowAdapter extends java.awt.event.WindowAdapter {
  Dlg_Login adaptee;

  Dlg_Login_this_windowAdapter(Dlg_Login adaptee) {
    this.adaptee = adaptee;
  }
  public void windowClosing(WindowEvent e) {
    adaptee.this_windowClosing(e);
  }
}

class Dlg_Login_txtUserID_keyAdapter extends java.awt.event.KeyAdapter {
  Dlg_Login adaptee;

  Dlg_Login_txtUserID_keyAdapter(Dlg_Login adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.txtUserID_keyPressed(e);
  }
  public void keyReleased(KeyEvent e) {
    adaptee.txtUserID_keyReleased(e);
  }
  public void keyTyped(KeyEvent e) {
    adaptee.txtUserID_keyTyped(e);
  }
}