package newtimes.bank;

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

public class DlgChangCheckDate extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtChkDD = new JTextField();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  DbBankHead dbBankHand;
  PnlListBankHead pnl2List;
  public DlgChangCheckDate(Frame frame, String title, boolean modal,DbBankHead _dbBankHand,PnlListBankHead _pnl2List) {
    super(frame, title, modal);
    try {
      dbBankHand=_dbBankHand;
      pnl2List=_pnl2List;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgChangCheckDate() {
    this(null, "", false,null,null);
  }
  exgui.DataBindTextWithChecker dbTxtChkDD;
  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("CHK-DD");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(5, 24, 150, 27));
    txtChkDD.setText("");
    txtChkDD.setBounds(new Rectangle(155, 24, 151, 27));
    btnUpdate.setBounds(new Rectangle(62, 68, 93, 30));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(237, 68, 100, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(txtChkDD, null);
    panel1.add(btnUpdate, null);
    panel1.add(btnExit, null);
    Object vftxtChkDD=RocDateFormator.getRocDateFormat();
     dbTxtChkDD=  new exgui.DataBindTextWithChecker(
         txtChkDD,"CHK_DD",
         null,9,
         (exgui.Object2String)vftxtChkDD,
         (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);


  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
     if(dbTxtChkDD.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Input CHK DD","Pleas Input CHK DD");
       return;
     }
     if(!exgui.verification.VerifyLib.showConfirm("確定要修改全部的CHECK DATE嗎?","確定要修改全部的CHECK DATE嗎?"))return;
     try{
       util.MiscFunc.showProcessingMessage();
        String usrCode=(String)util.PublicVariable.USER_RECORD.get(0);
        java.util.Vector vct2update=new java.util.Vector();
       for(int i=0;i<pnl2List.getDisplayingRecords().size();i++){
         database.datatype.Record rec=(database.datatype.Record)pnl2List.getDisplayingRecords().get(i);
         rec.set(12,usrCode);//record modify user
         rec.set(5,dbTxtChkDD.getSelectedValue());
         vct2update.add(rec);
       }
       dbBankHand.updateRecords(vct2update);
       util.MiscFunc.hideProcessingMessage();
       exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
       if(pnl2List!=null)pnl2List.reload();
       dispose();

     }catch(Exception exp){
      exp.printStackTrace()       ;
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("修改失敗,請洽MIS部門","UPDATE FAILED!!");
     }
  }
}
