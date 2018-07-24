package newtimes.accounting.debit_note_user;

import java.awt.*;
import exgui.*;
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

public class PnlQryUsr extends JPanel {
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtUsrCode = new JTextField();
  JTextField txtUsrEngName = new JTextField();
  JTextField txtUsrMdnName = new JTextField();
  JButton btnExit = new JButton();
  JButton btnAddNew = new JButton();
  JButton btnQryDebitNote = new JButton();
  public PnlQryUsr() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    whiteBkgBlueCharLabel1.setText("DEBIT NOTE USER MAITAIN  -- QUERY");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(-2, 30, 804, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setText("USER CODE:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(241, 130, 132, 27));
    whiteBkgBlueCharLabel2.setText("ENGLISH NAME:");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(241, 164, 132, 27));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(241, 198, 132, 27));
    blueBkgWhiteCharLabel2.setForeground(Color.black);
    blueBkgWhiteCharLabel2.setText("¤¤¤å¦WºÙ :");
    txtUsrCode.setText("");
    txtUsrCode.setBounds(new Rectangle(373, 130, 179, 27));
    txtUsrEngName.setBounds(new Rectangle(373, 164, 179, 27));
    txtUsrEngName.setText("");
    txtUsrMdnName.setText("");
    txtUsrMdnName.setBounds(new Rectangle(373, 198, 179, 27));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(634, 433, 100, 33));
    btnAddNew.setBounds(new Rectangle(143, 433, 100, 33));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("ADD NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnQryDebitNote.setText("Query");
    btnQryDebitNote.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryDebitNote_actionPerformed(e);
      }
    });
    btnQryDebitNote.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryDebitNote.setBounds(new Rectangle(387, 433, 100, 33));
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtUsrEngName, null);
    this.add(txtUsrCode, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtUsrMdnName, null);
    this.add(btnQryDebitNote, null);
    this.add(btnAddNew, null);
    this.add(btnExit, null);
  }
  protected void makeCondition(){
    Constants.HM_QRY_CONDITION.clear();
    if(txtUsrCode.getText().trim().length()>0){
      Constants.HM_QRY_CONDITION.put("USR_CODE",util.MiscFunc.Replace(txtUsrCode.getText().trim(),"'","''"));
    }
    if(txtUsrEngName.getText().trim().length()>0){
      Constants.HM_QRY_CONDITION.put("USR_ENG_NAME",util.MiscFunc.Replace(txtUsrEngName.getText().trim(),"'","''"));
    }
    if(txtUsrMdnName.getText().trim().length()>0){
      Constants.HM_QRY_CONDITION.put("USR_NAME",util.MiscFunc.Replace(txtUsrMdnName.getText().trim(),"'","''"));
    }

  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnAddNew_actionPerformed(ActionEvent e) {
    try{

      DlgDbCrUsr dlg = new
          DlgDbCrUsr(util.PublicVariable.APP_FRAME, "Add DEBIT NOTE USER", true, null,
                     Constants.USR_HANDLER_DB,
                     Constants.USR_HANDLER_DB.getBlankRecord());
      dlg.setSize(460,360);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnQryDebitNote_actionPerformed(ActionEvent e) {
    try{
      makeCondition();
      PnlLisDebitNoteUser.CURRENT_ROW_POSITION=1;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrListQryUsr()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

}
