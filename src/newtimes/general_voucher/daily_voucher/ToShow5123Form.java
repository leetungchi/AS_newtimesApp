package newtimes.general_voucher.daily_voucher;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShow5123Form implements IntfSubSystem {
  public ToShow5123Form() {
  }
  public void doShowEditorDlg(){
    util.MiscFunc.showProcessingMessage();
    Dlg5123  dlg=new  Dlg5123(util.PublicVariable.APP_FRAME,
    "¶Äª÷¤ä¥X",true);
    dlg.setSize(580,185);
    dlg.pnledit.setRecord(Constants.recSubSystem);
    dlg.pnledit.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.db4SubSystem);
    dlg.pnledit.record2Gui();
    util.MiscFunc.hideProcessingMessage();
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.isInitGui=true;
    dlg.btnExit.grabFocus();
    dlg.isInitGui=false;
    dlg.show();

  }

}
