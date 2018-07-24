package newtimes.nthk_accounting_enqry;

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

public class DlgCancelReason extends JDialog {
  JPanel panel1 = new JPanel();
  boolean isNormallyClosed=true;
  BorderLayout borderLayout1 = new BorderLayout();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtReason = new JTextArea();
  JButton btnCls = new JButton();
  JButton btnOK = new JButton();
  public DlgCancelReason(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgCancelReason() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    this.getContentPane().setLayout(borderLayout1);
    blueBkgWhiteCharLabel1.setText("Cancellation Reason");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 31, 523, 34));
    jScrollPane1.setBounds(new Rectangle(44, 84, 422, 194));
    txtReason.setText("");
    btnCls.setBounds(new Rectangle(54, 324, 124, 36));
    btnCls.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCls.setActionCommand("CLOSE");
    btnCls.setText("CLOSE");
    btnCls.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCls_actionPerformed(e);
      }
    });
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnOK.setActionCommand("CLOSE");
    btnOK.setBounds(new Rectangle(364, 324, 124, 36));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    this.getContentPane().add(panel1, BorderLayout.CENTER);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtReason, null);
    panel1.add(btnCls, null);
    panel1.add(btnOK, null);
  }

  public void show(){
    isNormallyClosed=false;
    super.show();
  }
  void btnOK_actionPerformed(ActionEvent e) {
    if(txtReason.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Cancellation Reason",
                                             "Please Input Cancellation Reason");
      return;
    }
    isNormallyClosed=true;
    this.dispose();
  }

  void btnCls_actionPerformed(ActionEvent e) {
    isNormallyClosed=true;
    this.dispose();
  }
}
