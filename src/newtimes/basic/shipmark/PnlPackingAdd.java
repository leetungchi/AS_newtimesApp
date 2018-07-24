package newtimes.basic.shipmark;

public class PnlPackingAdd extends PnlPackingEdit {
  public PnlPackingAdd() {
    super();
    blueBkgWhiteCharLabel1.setText("ADD PACKING MARK");
    btnDelete.setVisible(false);
  }
  void btnOK_actionPerformed(java.awt.event.ActionEvent e) {
  try{
    genData();
    db_handler.addRecord(rec);
    exgui.verification.VerifyLib.showPlanMsg("Insert OK","Insert OK");
    btnEXIT_actionPerformed(null);
  }catch(Exception exp){
    exp.printStackTrace();
    util.ExceptionLog.exp2File(exp,"");
    exgui.verification.VerifyLib.showAlert("Insert Fail!!\nPlease Contact System Manager",
                                           "Insert Fail");
  }

 }
 void btnEXIT_actionPerformed(java.awt.event.ActionEvent e) {
   PnlQryPacking pnl=new PnlQryPacking();
   ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(pnl);
 }
}
