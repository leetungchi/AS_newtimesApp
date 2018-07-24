package newtimes.accounting.local_voucher;

import java.awt.*;
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

public class DlgEditLocalVoucher extends JDialog {
  JPanel panel1 = new JPanel();
  PlnEditLocalVoucher plnEditLocalVoucher = null;
  JPanel Pnl2PlaceButton = new JPanel();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  PnlQryLocalVoucher pnlParent;
  JButton btnDELETE = new JButton();
  public DlgEditLocalVoucher(Frame frame, String title, boolean modal ,database.datatype.Record rec2edit,PnlQryLocalVoucher _pnlParent) {
    super(frame, title, modal);
    try {
      plnEditLocalVoucher=new PlnEditLocalVoucher();
      plnEditLocalVoucher.setPagedDataFactory(null);
      plnEditLocalVoucher.setRecord(rec2edit);
      plnEditLocalVoucher.record2Gui();
      pnlParent=_pnlParent;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditLocalVoucher() {
    this(null, "", false,null,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    Pnl2PlaceButton.setLayout(null);
    btnUpdate.setBounds(new Rectangle(81, 8, 94, 27));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    Pnl2PlaceButton.setBounds(new Rectangle(-1, 442, 523, 50));
    plnEditLocalVoucher.setBounds(new Rectangle(-1, 1, 520, 450));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(381, 8, 94, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDELETE.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDELETE_actionPerformed(e);
      }
    });
    btnDELETE.setText("DELETE");
    btnDELETE.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDELETE.setForeground(Color.red);
    btnDELETE.setBounds(new Rectangle(237, 8, 94, 27));
    getContentPane().add(panel1);
    panel1.add(Pnl2PlaceButton, null);
    panel1.add(plnEditLocalVoucher, null);
    Pnl2PlaceButton.add(btnUpdate, null);
    Pnl2PlaceButton.add(btnExit, null);
    if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
       newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
       )
      //only mis allow to use it
    Pnl2PlaceButton.add(btnDELETE, null);
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    if(!plnEditLocalVoucher.gui2Record()) return;
    database.datatype.Record rec=plnEditLocalVoucher.editRec();
    try{
      rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
      util.MiscFunc.showProcessingMessage();
      newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
          (newtimesejb.debitNote.LocalVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.debitNote.LocalVoucherFacade");
      newtimesejb.debitNote.LocalVoucherFacade ejb=ejbHome.create();
      java.util.Vector vct=new java.util.Vector();
      vct.add(rec);
      ejb.updateLocalVoucher(vct);
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("UPDATE FAIL!!\nPlease Contact System Manager",
                                             "Update Fail!!");
      return;
    }
    pnlParent.pnl2list.doUpdateCurrentPage();
    pnlParent.pnl2list.reload();
    this.dispose();
  }

  void btnExit_actionPerformed(ActionEvent e) {
   if(plnEditLocalVoucher.isContextModified()){
   //if(true){
     if(!exgui.verification.VerifyLib.showConfirm("Context Modified,Do You Sure To Exit ?","Context Modified",false))return;
   }
   this.dispose();
  }
  void btnDELETE_actionPerformed(ActionEvent e) {
     if(!exgui.verification.VerifyLib.showConfirm("Do you sure to delete ?","Do you sure to delete ?",false)){
       return;
     }
     if(!plnEditLocalVoucher.gui2Record()) return;
     database.datatype.Record rec=plnEditLocalVoucher.editRec();
     try{
       rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       rec.set("record_delete_flag","0");
       util.MiscFunc.showProcessingMessage();
       newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
           (newtimesejb.debitNote.LocalVoucherFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.debitNote.LocalVoucherFacade");
       newtimesejb.debitNote.LocalVoucherFacade ejb=ejbHome.create();
       java.util.Vector vct=new java.util.Vector();
       vct.add(rec);
       ejb.updateLocalVoucher(vct);
       util.MiscFunc.hideProcessingMessage();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("UPDATE FAIL!!\nPlease Contact System Manager",
                                              "Update Fail!!");
       return;
     }
     pnlParent.pnl2list.doUpdateCurrentPage();
     pnlParent.pnl2list.reload();
     this.dispose();

  }
}
