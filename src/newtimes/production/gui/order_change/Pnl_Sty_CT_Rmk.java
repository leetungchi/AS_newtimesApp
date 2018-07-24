package newtimes.production.gui.order_change;

import java.awt.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl_Sty_CT_Rmk extends Pnl_Sty_SC_Rmk {
  BorderLayout borderLayout1 = new BorderLayout();

  public Pnl_Sty_CT_Rmk() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected  void jbInit() throws Exception {
   this.removeAll();
   jPanel1.removeAll();
   btnCnfirmNext = new javax.swing.JButton();
   btnGetDefault = new javax.swing.JButton();
   this.setLayout(borderLayout1);
   btnCnfirmNext.setText("Finish,Confirm All Edit");
   btnCnfirmNext.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(ActionEvent e) {
       btnCnfirmNext_actionPerformed(e);
     }
   });
   btnGetDefault.setText("Get Default Remark From S/C Remarks");
   btnGetDefault.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(ActionEvent e) {
       btnGetDefault_actionPerformed(e);
     }
   });
   jPanel1.add(btnGetDefault, null);
   this.add(jPanel1, BorderLayout.SOUTH);
   jPanel1.add(btnCnfirmNext, null);
  }
 protected void btnCnfirmNext_actionPerformed(ActionEvent e){
   try{
     this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
     util.MiscFunc.showProcessingMessage();
     newtimes.production.process.order_change.tempDataCenter.
         tempStoredChangeStyleData.set(
         "sty_ct_up_rmrk", pnl2show.txtStyUpRMK.getText().trim());
     newtimes.production.process.order_change.tempDataCenter.
         tempStoredChangeStyleData.set(
         "sty_ct_down_rmrk", pnl2show.txtStyDownRMK.getText().trim());
     newtimes.production.process.order_change.ProxyQtyHdl handler=
         new newtimes.production.process.order_change.ProxyQtyHdl();
     handler.finalConfirmUpdate();
     //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
     processhandler.template.Properties.getCenteralControler().goBack();
  }catch(Exception exp){
      util.MiscFunc.hideProcessingMessage();
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail\nPlease Contact System Manager",
                                             "update Fail");
   }finally{
     util.MiscFunc.hideProcessingMessage();
     this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
   }
 }
 protected void btnGetDefault_actionPerformed(ActionEvent e){
   try{
     pnl2show.txtStyUpRMK.setText((String)
                                  newtimes.production.process.order_change.
                                  tempDataCenter.tempStoredChangeStyleData.get(
         "sty_sc_up_rmrk"));
    pnl2show.txtStyDownRMK.setText((String)
                                 newtimes.production.process.order_change.
                                 tempDataCenter.tempStoredChangeStyleData.get(
        "sty_sc_down_rmrk"));
   }catch(Exception exp){
      exp.printStackTrace();
   }
 }
}
