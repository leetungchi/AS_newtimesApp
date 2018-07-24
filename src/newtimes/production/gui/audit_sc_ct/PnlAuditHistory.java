package newtimes.production.gui.audit_sc_ct;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.ultratable.*;
public class PnlAuditHistory extends JPanel {
  exgui.ultratable.AbstractUltraTablePanel   pnlPagedData = null;
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtRjtMrk = new JTextArea();
  JLabel jLabel1 = new JLabel();
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  public JButton btnReject = new JButton();
  public JButton btnConfirmOK = new JButton();
  newtimes.production.process.audit_sc_ct.DB_ProdAudits dbHandler;
  public PnlAuditHistory(exgui.ultratable.AbstractUltraTablePanel  historyList,
                         newtimes.production.process.audit_sc_ct.DB_ProdAudits _dbHandler) {
    try {
      pnlPagedData=historyList;
      dbHandler=_dbHandler;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(null);
    pnlPagedData.setBorder(BorderFactory.createEtchedBorder());
    pnlPagedData.setBounds(new Rectangle(52, 43, 478, 179));
    jScrollPane1.setBounds(new Rectangle(51, 255, 479, 116));
    txtRjtMrk.setText("");
    jLabel1.setFont(new java.awt.Font("SansSerif", 1, 11));
    jLabel1.setText("Reject Reson");
    jLabel1.setBounds(new Rectangle(51, 229, 109, 24));
    blueBkgWhiteCharLabel1.setText("Audit Status:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(52, 16, 198, 25));
    btnReject.setBounds(new Rectangle(134, 395, 97, 31));
    btnReject.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReject.setText("REJECT");
    btnReject.addActionListener(new PnlAuditHistory_btnReject_actionAdapter(this));
    btnConfirmOK.setBounds(new Rectangle(329, 395, 97, 31));
    btnConfirmOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnConfirmOK.setText("CONFIRM");
    btnConfirmOK.addActionListener(new PnlAuditHistory_btnConfirmOK_actionAdapter(this));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlPagedData, null);
    this.add(jLabel1, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtRjtMrk, null);
    this.add(btnReject, null);
    this.add(btnConfirmOK, null);
    blueBkgWhiteCharLabel1.setText(
       "Current Audit Status:"+
      PnlListPrdCnfm.prod_status_code[
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(
        "PROD_AUDIT_STATUS")
    ]);
  }

  void btnReject_actionPerformed(ActionEvent e) {
    try{
      if(txtRjtMrk.getText().length()>500){
        exgui.verification.VerifyLib.showAlert("REJECT RESION IS OVER THAN 500 CHARACTERS",
                                               "TEXT TOO LONG");
        return;
      }
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      util.MiscFunc.showProcessingMessage();
      dbHandler.update2Reject(txtRjtMrk.getText());
      //exgui.verification.VerifyLib.showPlanMsg("UPDATE OK","UPDATE OK");
      //back to list...
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      util.MiscFunc.hideProcessingMessage();
      exp.printStackTrace();
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  void btnConfirmOK_actionPerformed(ActionEvent e) {
    try{
      if(txtRjtMrk.getText().length()>500){
        exgui.verification.VerifyLib.showAlert("REJECT RESION IS OVER THAN 500 CHARACTERS",
                                               "TEXT TOO LONG");
        return;
      }
      util.MiscFunc.showProcessingMessage();
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      dbHandler.update2Confirm(txtRjtMrk.getText());
      //exgui.verification.VerifyLib.showPlanMsg("UPDATE OK","UPDATE OK");
      //back to list...
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      util.MiscFunc.hideProcessingMessage();
      exp.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}

class PnlAuditHistory_btnReject_actionAdapter implements java.awt.event.ActionListener {
  PnlAuditHistory adaptee;

  PnlAuditHistory_btnReject_actionAdapter(PnlAuditHistory adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnReject_actionPerformed(e);
  }
}

class PnlAuditHistory_btnConfirmOK_actionAdapter implements java.awt.event.ActionListener {
  PnlAuditHistory adaptee;

  PnlAuditHistory_btnConfirmOK_actionAdapter(PnlAuditHistory adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnConfirmOK_actionPerformed(e);
  }
}
