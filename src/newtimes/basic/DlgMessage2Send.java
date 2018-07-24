package newtimes.basic;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

public class DlgMessage2Send extends JDialog {
  JPanel panel1 = new JPanel();
  public BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  public JTextArea txtMsg2Send = new JTextArea();
  public JButton btn2nd = new JButton();
  public JButton btnCancel = new JButton();

  public DlgMessage2Send(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgMessage2Send() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Please Input Text Message To Send Below:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(22, 8, 349, 27));
    jScrollPane1.setBounds(new Rectangle(22, 38, 349, 186));
    txtMsg2Send.setText("");
    btn2nd.setBounds(new Rectangle(27, 238, 95, 27));
    btn2nd.setText("OK");
    btn2nd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn2nd_actionPerformed(e);
      }
    });
    btnCancel.setBounds(new Rectangle(286, 238, 80, 28));
    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(jScrollPane1, null);
    panel1.add(btn2nd, null);
    panel1.add(btnCancel, null);
    jScrollPane1.getViewport().add(txtMsg2Send, null);
  }

  void btn2nd_actionPerformed(ActionEvent e) {
    String msg2Send=txtMsg2Send.getText();
    if(msg2Send.trim().length()==0)return;
    try{
      if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Send This Message To All Current Users?",
                                                  "Are You Sure ?"))return;
      msg2Send=
          (String)util.PublicVariable.USER_RECORD.get("usr_code")+" Send:\n"+msg2Send;
      util.PublicVariable.LISTEN_2_NEWTIMES_INCOMMING_MESSAGE.sendMessage(
          msg2Send);
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Sending Message,Pleas Check Application server",
                                             "JMS error");
    }

  }

  void btnCancel_actionPerformed(ActionEvent e) {
    this.dispose();
  }
}
