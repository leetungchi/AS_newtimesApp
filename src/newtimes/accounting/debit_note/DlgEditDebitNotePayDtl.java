package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import database.datatype.Record;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgEditDebitNotePayDtl extends JDialog {
  JPanel panel1 = new JPanel();
  PnlEditDebitNotePayDtl pnlEditDebitNotePayDtl1 =null;
  JButton btnOK = new JButton();
  JButton btnDelete = new JButton();
  JButton btnExit = new JButton();
  Record recPayDtl;
  public DlgEditDebitNotePayDtl(Frame frame, String title, boolean modal,
                                DbDebitNotePayDtl db2Handle,Record _recPayDtl) {
    super(frame, title, modal);
    try {
      recPayDtl=_recPayDtl;
      pnlEditDebitNotePayDtl1= new PnlEditDebitNotePayDtl();
      pnlEditDebitNotePayDtl1.setPagedDataFactory(db2Handle);
      pnlEditDebitNotePayDtl1.setRecord(_recPayDtl);
      pnlEditDebitNotePayDtl1.record2Gui();

      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditDebitNotePayDtl() {
    this(null, "", false,null,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    panel1.setOpaque(true);
    pnlEditDebitNotePayDtl1.setBounds(new Rectangle(-1, 28, 586, 343));
    btnOK.setBounds(new Rectangle(69, 405, 111, 33));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setBounds(new Rectangle(233, 405, 111, 33));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(397, 405, 111, 33));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    getContentPane().add(panel1);
    panel1.add(pnlEditDebitNotePayDtl1, null);
    panel1.add(btnOK, null);
    panel1.add(btnDelete, null);
    panel1.add(btnExit, null);
    if(recPayDtl.getInt(0)<1)btnDelete.setVisible(false);
  }

  void btnOK_actionPerformed(ActionEvent e) {
    try{
      if(!pnlEditDebitNotePayDtl1.gui2Record())return;
      pnlEditDebitNotePayDtl1.doUpdate();
      dispose();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete ?","Are You Sure",false))return;
    pnlEditDebitNotePayDtl1.doDelete();
    dispose();
  }

  void btnExit_actionPerformed(ActionEvent e) {
     if(!btnDelete.isVisible()){
       dispose();
       return;
     }
     if(pnlEditDebitNotePayDtl1.isContextModified()){
       if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nDo You Sure To Exit ?","Context Mofified",false)){
         return;
       }
       dispose();
       return;
     }
     dispose();
  }
}
