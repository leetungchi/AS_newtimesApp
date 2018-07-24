package newtimes.accounting.local_voucher;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
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

public class DlgMkrInfor extends JDialog {
  JPanel panel1 = new JPanel();
  SelectBuyerMaker slkMkrSeq = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtInfor = new JTextArea();
  JButton btnUpdate = new JButton();
  JButton btnDelete = new JButton();
  JButton btnExit = new JButton();
  Record recEditing=null;
  public DlgMkrInfor(Frame frame, String title, boolean modal,Record _rec) {
    super(frame, title, modal);
    try {
      recEditing=_rec;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgMkrInfor() {
    this(null, "", false,null);
  }

  protected void jbInit() throws Exception {
    panel1.setLayout(null);
    slkMkrSeq.setBounds(new Rectangle(111, 30, 257, 27));
    blueBkgWhiteCharLabel1.setText("MAKER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(17, 30, 94, 27));
    jScrollPane1.setBounds(new Rectangle(18, 78, 352, 191));
    txtInfor.setText("");
    btnUpdate.setBounds(new Rectangle(26, 302, 108, 32));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("CONFIRM");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setBounds(new Rectangle(172, 302, 81, 32));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(302, 302, 81, 32));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(slkMkrSeq, null);
    panel1.add(jScrollPane1, null);
    panel1.add(btnUpdate, null);
    jScrollPane1.getViewport().add(txtInfor, null);
    panel1.add(btnDelete, null);
    panel1.add(btnExit, null);
    Object objOrgMkr=recEditing.get(0);
    slkMkrSeq.init("",objOrgMkr,slkMkrSeq.TYPE_MAKER ,true);
    Object objInfor=recEditing.get("LV_MKR_INFOR");
    txtInfor.setText((objInfor==null)?"":objInfor.toString());
    if(recEditing.getInt("record_delete_flag")==-1){
      btnDelete.setVisible(false);
    }else{
      slkMkrSeq.setEnabled(false);
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    recEditing=null;
    this.dispose();
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      //if in add mode,have to check maker already have dinfined...
      if(slkMkrSeq.getSelectedValue()==null){
        exgui.verification.VerifyLib.showAlert("Please Assigne Maker","Please Assigne Maker");
        return;
      }
      if(!btnDelete.isVisible()){
        util.MiscFunc.showProcessingMessage();
        java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from LOCAL_VOUCHER_MKR_INFOR where LV_MKR_SEQ="+slkMkrSeq.getSelectedValue().toString(),
         1,1);
         if(vct.size()>0){
           exgui.verification.VerifyLib.showAlert("Voucher Information Of This Maker Already Defined","Data Already Exists");
           return;
         }
        util.MiscFunc.hideProcessingMessage();
      }
      recEditing.set(0, slkMkrSeq.getSelectedValue());
      recEditing.set("LV_MKR_INFOR", txtInfor.getText());
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
     if(!exgui.verification.VerifyLib.showConfirm("Do you Sure To Delete ?","Do you Sure To Delete ?",false))return;
     try{
       recEditing.set("record_delete_flag", 0);
     }catch(Exception exp){
       exp.printStackTrace();
     }
     this.dispose();
  }
}
