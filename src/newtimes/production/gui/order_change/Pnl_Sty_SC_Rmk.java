package newtimes.production.gui.order_change;
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

public class Pnl_Sty_SC_Rmk extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  public JButton btnCnfirmNext =null;;
  public JButton btnGetDefault =null;
  newtimes.production.gui.prodmaintain.JCompPnlStylRemark   pnl2show;
  public Pnl_Sty_SC_Rmk() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void setStyleScRemarkPanel(
      newtimes.production.gui.prodmaintain.JCompPnlStylRemark  pnl){
    if(pnl2show!=null)this.remove(pnl2show);
    pnl2show=pnl;
    this.add(pnl2show,BorderLayout.CENTER);
  }
  protected void jbInit() throws Exception {
    btnCnfirmNext = new JButton();
    btnGetDefault = new JButton();
    this.setLayout(borderLayout1);
    btnCnfirmNext.setText("Next-->Edit C/T Remarks");
    btnCnfirmNext.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCnfirmNext_actionPerformed(e);
      }
    });
    btnGetDefault.setText(">Get Default Value");
    btnGetDefault.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGetDefault_actionPerformed(e);
      }
    });
    jPanel1.add(btnGetDefault, null);
    this.add(jPanel1, BorderLayout.SOUTH);
    jPanel1.add(btnCnfirmNext, null);
  }

protected  void btnGetDefault_actionPerformed(ActionEvent e) {
    try{
      pnl2show.doSet2Default();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Get Default SC remark data",
                                             "Error While Get Default SC remark data");
    }
  }

protected  void btnCnfirmNext_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.process.order_change.tempDataCenter.
          tempStoredChangeStyleData.set(
          "sty_sc_up_rmrk", pnl2show.txtStyUpRMK.getText().trim());
      newtimes.production.process.order_change.tempDataCenter.
          tempStoredChangeStyleData.set(
          "sty_sc_down_rmrk", pnl2show.txtStyDownRMK.getText().trim());
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.process.order_change.TgrToEditCtRemark());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
