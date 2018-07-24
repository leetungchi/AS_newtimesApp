package newtimes.accounting.local_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgSrnHeadBasicFields extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  PnlSrnHeadBasicFields pnlSrnHeadBasicFields1 =null;
  Record recShipHead=null;
  public DlgSrnHeadBasicFields(Frame frame, String title, boolean modal,Record recShipHRead) {
    super(frame, title, modal);
    try {
      recShipHead=recShipHRead;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgSrnHeadBasicFields() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    pnlSrnHeadBasicFields1=new PnlSrnHeadBasicFields();
    pnlSrnHeadBasicFields1.setRecord(recShipHead);
    pnlSrnHeadBasicFields1.record2Gui();
    panel1.setLayout(null);
    btnUpdate.setBounds(new Rectangle(115, 427, 82, 31));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(342, 427, 82, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    pnlSrnHeadBasicFields1.setBounds(new Rectangle(10, 10, 495, 410));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnUpdate, null);
    panel1.add(btnExit, null);
    panel1.add(pnlSrnHeadBasicFields1, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }
  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      pnlSrnHeadBasicFields1.update();
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("ERROR WHILE UPDATE SRN BASIC FIELDS\nPlease Contact System Manager",
                                             "Update Failed");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}
