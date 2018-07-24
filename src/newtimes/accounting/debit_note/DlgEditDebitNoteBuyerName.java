package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgEditDebitNoteBuyerName extends JDialog {
  JPanel panel1 = new JPanel();
  PnlListDebitNoteBuyerName pnlParent=null;
  JButton btnOk = new JButton();
  JButton btnExit = new JButton();
  JButton btnDELETE = new JButton();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDbBymkrName = new JTextField();
  Record recEDIT;
  public DlgEditDebitNoteBuyerName(Frame frame, String title, boolean modal,Record rec) {
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

  public DlgEditDebitNoteBuyerName() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    btnOk.setBounds(new Rectangle(199, 179, 121, 32));
    btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOk_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(27, 179, 121, 32));
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
    btnDELETE.setBounds(new Rectangle(348, 179, 121, 32));
    slkBuyer.setBounds(new Rectangle(171, 65, 263, 28));
    whiteBkgBlueCharLabel1.setText("BUYER:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(71, 65, 98, 26));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(71, 118, 98, 26));
    whiteBkgBlueCharLabel2.setText("NAME");
    txtDbBymkrName.setText("");
    txtDbBymkrName.setBounds(new Rectangle(171, 119, 263, 26));
    getContentPane().add(panel1);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(slkBuyer, null);
    panel1.add(whiteBkgBlueCharLabel2, null);
    panel1.add(btnOk, null);
    panel1.add(btnExit, null);
    panel1.add(btnDELETE, null);
    panel1.add(txtDbBymkrName, null);
    slkBuyer.init("",recEDIT.get(1),slkBuyer.TYPE_BUYER,true);
    Object vftxtSeqItem = exgui.verification.CellFormat.getOrdinaryField(100);
    new exgui.DataBindTextWithChecker(txtDbBymkrName,
              "",
              recEDIT.get(0), 100,
              (exgui.Object2String)vftxtSeqItem,
              (exgui.ultratable.CellTxtEditorFormat)vftxtSeqItem);

    if(-1==recEDIT.getInt("record_delete_flag")){
      btnDELETE.setVisible(false);
    }

  }

  void btnExit_actionPerformed(ActionEvent e) {
     this.hide();
  }
  boolean gui2Record(){

    if(null==slkBuyer.getSelectedValue()){
      exgui.verification.VerifyLib.showAlert("Please Assign Buyer","Please Select Buyer");
      return false;
    }
    if(txtDbBymkrName.getText().trim().length()==0 ){
      exgui.verification.VerifyLib.showAlert("Please Assign Name","Please Input Name");
      return false;
     }
     //test if already have buyer-name in database
     try{
       StringBuffer sb=new StringBuffer();
       sb.append("select count(*) from DEBITNOTE_BYMKR_NAME where DBNT_BYMKR_NAME='");
       sb.append(util.MiscFunc.Replace(txtDbBymkrName.getText().trim().toUpperCase(),"'","''") );
       sb.append("'");
       java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,9999);
         Record recTest=(Record)vct.get(0);
       if ( -1 == recEDIT.getInt("record_delete_flag")) {
          if(recTest.getInt(0)>0){
            exgui.verification.VerifyLib.showAlert(txtDbBymkrName.getText().trim().toUpperCase()+" Already Defined",
                                                   "NAME EXISTS!!");
            return false;
          }
       }else{
         //compare org_name
         if(recTest.getInt(0)>0 &&
            !txtDbBymkrName.getText().trim().toUpperCase().equalsIgnoreCase((String)recEDIT.get(3))){
           exgui.verification.VerifyLib.showAlert(txtDbBymkrName.getText().trim().toUpperCase()+" Already Defined",
                                                  "NAME EXISTS!!");
           return false;
         }
       }

     }catch(Exception exp){
       exp.printStackTrace();
     }
     recEDIT.set(1,slkBuyer.getSelectedValue());
     recEDIT.set(0,txtDbBymkrName.getText().trim().toUpperCase());
     return true;
  }
  void btnOk_actionPerformed(ActionEvent e) {
     if(!gui2Record())return;
     try{
       recEDIT.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       recEDIT.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));
       handleRecord();

       pnlParent.pnlListBuyerName.reload();
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
    hm.put("TPEMISCFUNC_ACTION_CODE","HANDLE_DEBITNOTE_BYMKR_NAME");
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
      pnlParent.pnlListBuyerName.reload();
      this.hide();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
