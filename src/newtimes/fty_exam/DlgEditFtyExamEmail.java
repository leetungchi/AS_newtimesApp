package newtimes.fty_exam;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
import java.awt.event.*;
import exgui.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgEditFtyExamEmail extends JDialog {
  JPanel panel1 = new JPanel();
  PnlEmailList pnlParent=null;
  JButton btnOk = new JButton();
  JButton btnExit = new JButton();
  JButton btnDELETE = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  Record recEDIT;
  JTextField txtBuyerName = new JTextField();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtEmailAddList = new JTextArea();
  public DlgEditFtyExamEmail(Frame frame, String title, boolean modal,Record rec) {
    super(frame, title, modal);
    recEDIT=rec;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditFtyExamEmail() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    btnOk.setBounds(new Rectangle(93, 184, 121, 32));
    btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOk_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(446, 184, 121, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("Exit");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnDELETE.setText("DELETE");
    btnDELETE.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDELETE_actionPerformed(e);
      }
    });
    btnDELETE.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDELETE.setForeground(Color.red);
    btnDELETE.setBounds(new Rectangle(265, 184, 121, 32));
    whiteBkgBlueCharLabel1.setText("BUYER:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(68, 32, 98, 26));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(67, 72, 535, 26));
    whiteBkgBlueCharLabel2.setText("Email Addr(Connect by \";\" )");
    txtBuyerName.setText("");
    txtBuyerName.setBounds(new Rectangle(168, 31, 263, 30));
    jScrollPane1.setBounds(new Rectangle(67, 100, 537, 76));
    txtEmailAddList.setText("");
    getContentPane().add(panel1);
    Object vftxtSeqItem = exgui.verification.CellFormat.getOrdinaryField(1000);
    String addList=(recEDIT.get(2)==null)?"":recEDIT.get(2).toString();
    addList=util.MiscFunc.Replace(addList,"<br>","\n");
    addList=util.MiscFunc.Replace(addList.toLowerCase(),"<html><body>","");
    addList=util.MiscFunc.Replace(addList.toLowerCase(),"</body></html>","");
    new exgui.DataBindTextWithChecker(txtEmailAddList,
              "",
              addList, 1000,
              (exgui.Object2String)vftxtSeqItem,
              (exgui.ultratable.CellTxtEditorFormat)vftxtSeqItem);

    Object vftxtBuyerName = exgui.verification.CellFormat.getOrdinaryField(100);
    new exgui.DataBindTextWithChecker(txtBuyerName,
              "",
              recEDIT.get(3), 100,
              (exgui.Object2String)vftxtBuyerName,
              (exgui.ultratable.CellTxtEditorFormat)vftxtBuyerName);


    if(-1==recEDIT.getInt("record_delete_flag")){
      btnDELETE.setVisible(false);
    }
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(txtBuyerName, null);
    panel1.add(whiteBkgBlueCharLabel2, null);
    panel1.add(jScrollPane1, null);
    panel1.add(btnOk, null);
    panel1.add(btnExit, null);
    panel1.add(btnDELETE, null);
    jScrollPane1.getViewport().add(txtEmailAddList, null);

  }

  void btnExit_actionPerformed(ActionEvent e) {
     this.hide();
  }
  boolean gui2Record(){

    if(txtBuyerName.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assign Buyer Name","Please Select Buyer Name");
      return false;
    }
    if(txtBuyerName.getText().trim().length()>100){
      exgui.verification.VerifyLib.showAlert("Buyer Name is only 100 Characters","Buyer Name Too Long");
      return false;
    }

    if(txtEmailAddList.getText().trim().length()==0 ){
      exgui.verification.VerifyLib.showAlert("Please Assign Name","Please Input Name");
      return false;
     }

     recEDIT.set(3,txtBuyerName.getText().trim());
     recEDIT.set(2,txtEmailAddList.getText().trim());
     return true;
  }
  void btnOk_actionPerformed(ActionEvent e) {
     if(!gui2Record())return;
     try{
       recEDIT.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       recEDIT.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));
       handleRecord();

       pnlParent.pnlListFtyEmailPagePanel.reload();
       this.hide();
     }catch(Exception exp){
       exp.printStackTrace();
     }
  }
  void handleRecord()throws Exception{

    newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
        (newtimesejb.TPE_MIS.TpeMisFuncHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
        "newtimesejb.TPE_MIS.TpeMisFunc");

    newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
    java.util.HashMap hm=new java.util.HashMap();
    hm.put("TPEMISCFUNC_ACTION_CODE","HANDLE_FTY_EXAM_EMAIL");
    hm.put("RECORD",recEDIT);
    ejb.tpeMisFunc(hm);

  }
  void btnDELETE_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete ?",
                                                "Do You Sure ?",false) ){
        return;
    }
    try{
      recEDIT.set("record_delete_flag","0");
      recEDIT.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
      handleRecord();
      pnlParent.pnlListFtyEmailPagePanel.reload();
      this.hide();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
