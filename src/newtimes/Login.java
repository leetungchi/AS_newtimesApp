package newtimes;

import java.awt.*;
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

public class Login extends JPanel {
  Frame1 frame;
  private JLabel labelTitle = new JLabel();
  private JLabel labelPass = new JLabel();
  private JLabel labelUser = new JLabel();
  private JTextField textFieldUserName = new JTextField();
  private JButton butnLogin = new JButton();
  private JButton butnExit = new JButton();
  private JTextField textAreaStatus = new JTextField();
  private JPasswordField pwdField = new JPasswordField();

  public Login(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    labelTitle.setText("title");
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelPass.setIcon(exgui.UIHelper.getIcon("icon02_1.gif"));
    labelPass.setBounds(new Rectangle(200, 260, 140, 25));
    labelPass.setDisplayedMnemonic('0');
    labelPass.setForeground(new Color(10,36,106));
    labelPass.setFont(new java.awt.Font("Dialog", 0, 20));
    labelPass.setBackground(Color.white);
    labelUser.setBackground(Color.white);
    labelUser.setFont(new java.awt.Font("Dialog", 0, 20));
    labelUser.setForeground(new Color(10,36,106));
    labelUser.setDisplayedMnemonic('0');
    labelUser.setBounds(new Rectangle(200, 200, 140, 25));
    labelUser.setIcon(exgui.UIHelper.getIcon("icon01_1.gif"));
    labelUser.setBounds(new Rectangle(223, 210, 140, 25));
    labelPass.setBounds(new Rectangle(223, 270, 140, 25));
    textFieldUserName.setCaretColor(Color.black);
    textFieldUserName.setText("");
    textFieldUserName.setBounds(new Rectangle(369, 210, 197, 26));
    butnLogin.setBackground(Color.lightGray);
    butnLogin.setBounds(new Rectangle(285, 385, 80, 25));
    butnLogin.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogin.setForeground(Color.darkGray);
    butnLogin.setText("Login");
    butnLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogin_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(418, 385, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    pwdField.setBounds(new Rectangle(369, 270, 197, 26));
    this.add(labelUser, null);
    this.add(textFieldUserName, null);
    this.add(labelPass, null);
    this.add(labelTitle, null);
    this.add(textAreaStatus, null);
    this.add(butnExit, null);
    this.add(butnLogin, null);
    this.add(pwdField, null);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    int isExit = exgui2.InfoMessage.Yes_No_Option(frame, "Do you want to exit this system ?");
    if (isExit == 0) {
      if(newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        if(newtimes.production.report.ReportCmdSet.myReportEngin!=null){
          try{
            newtimes.production.report.ReportCmdSet.myReportEngin.ejb.remove();
            System.out.println("ejb remove called");
          }catch(Exception exp){
            exp.printStackTrace();
          }
        }
      }
      System.exit(0);
    }
  }

  void butnLogin_actionPerformed(ActionEvent e) {
    database.datatype.Record usrRec = null;
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      usrRec = exgui2.CONST.BASIC_BASE_EJB.getUserRecord(textFieldUserName.getText(),
                                      String.copyValueOf(pwdField.getPassword()));
      if (usrRec == null) {
        throw new Exception();
      }
      if(util.PublicVariable.USER_RECORD==null){
        util.PublicVariable.USER_RECORD = usrRec;
      }else{
        java.util.List fields=usrRec.getFieldName();
        for(int i=0;i<fields.size();i++){
          util.PublicVariable.USER_RECORD.set(i,usrRec.get(i));
          newtimes.MainFunction.isCommandSetLoad=false;
        }
      }
      util.PublicVariable.OPERATTING_CENTER=(String)util.PublicVariable.USER_RECORD.get(4);
      //System.out.println("# USER_RECORD :"+util.PublicVariable.USER_RECORD.toString());

      frame.showPanel(new MainFunction(frame));
      Thread aThread=new Thread(new newtimes.preproduction.process.AttributeFactory());
      aThread.start();
    } catch (Exception butnEx) {
      int type = JOptionPane.ERROR_MESSAGE;
      JOptionPane.showMessageDialog(frame,
                                    "Login Failed.",
                                    "Error Message",
                                    type);
      butnEx.printStackTrace();
      util.ExceptionLog.exp2File(butnEx, "login failed. returnObj: "+ usrRec.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
}
