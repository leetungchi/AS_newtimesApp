package newtimes.accounting.debit_note_user;

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

public class DlgDbCrUsr
    extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnExit = new JButton();
  JButton btnOK = new JButton();
  JButton btnDel = new JButton();
  PnlLisDebitNoteUser pnlListing;
  PnlEditDebitNoteUser pnlEditDebitNoteUser = new PnlEditDebitNoteUser();
  Record recEdit;
  public DlgDbCrUsr(Frame frame, String title, boolean modal,PnlLisDebitNoteUser pnllist,
                    DbDebitNoteUser db2Handler,Record rec2edit) {
    super(frame, title, modal);
    try {
      pnlListing=pnllist;
      pnlEditDebitNoteUser.setPagedDataFactory(db2Handler);
      pnlEditDebitNoteUser.setRecord(rec2edit);

      jbInit();
      pnlEditDebitNoteUser.record2Gui();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public DlgDbCrUsr() {
    this(null, "", false,null,null,null);
  }

  protected void jbInit() throws Exception {
    panel1.setLayout(null);
    panel1.setBackground(new Color(202, 202, 224));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(326, 278, 117, 33));
    btnOK.setBounds(new Rectangle(17, 278, 100, 33));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnDel.setText("DELETE");
    btnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDel_actionPerformed(e);
      }
    });
    btnDel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDel.setBounds(new Rectangle(172, 278, 100, 33));
    pnlEditDebitNoteUser.setBounds(new Rectangle(16, 22, 424, 248));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(panel1);

    panel1.add(btnOK, null);
    panel1.add(btnExit, null);
    panel1.add(pnlEditDebitNoteUser, null);
    //new record is not about to delete;
    if(pnlEditDebitNoteUser.recEditingRecord().getInt("record_delete_flag") != -1){
      panel1.add(btnDel, null);
    }
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if (pnlEditDebitNoteUser.recEditingRecord().getInt("record_delete_flag") == -1) {
        this.dispose();
        return;
      }
      if (pnlEditDebitNoteUser.isContextModified()) {
        if(!exgui.verification.VerifyLib.showConfirm("Context Modified,Do You Sure To Exit ?",
                                                     "Record Modified")){
          return;
        }
      }
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnOK_actionPerformed(ActionEvent e) {
    try{
      if (!pnlEditDebitNoteUser.gui2Record())return;
      pnlEditDebitNoteUser.doUpdateAndCheck();
      if (pnlListing != null)pnlListing.RefreshList();
      this.dispose();
    }catch(ExceptionUserCodeAlreadyExists expUsrCodeExists){

    }catch(Exception exp){

    }
  }
  void btnDel_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete ?",
                                                 "Do You Sure To Delete ?")){
      return;
    }
    pnlEditDebitNoteUser.doDelete();
    if(pnlListing!=null)pnlListing.RefreshList();
    this.dispose();
  }
}
