package newtimes.general_voucher.daily_voucher;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShowTeleComFeeEditor implements IntfSubSystem {
  public ToShowTeleComFeeEditor() {
  }
  public void doShowEditorDlg(){
    util.MiscFunc.showProcessingMessage();
    DlgTeleComFeeEditor  dlg=new  DlgTeleComFeeEditor(util.PublicVariable.APP_FRAME,
    "¶l¹q¶O½s¿è",true);
    dlg.setSize(666,190);
    dlg.pnl2edit.setRecord(Constants.recSubSystem);
    dlg.pnl2edit.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.db4SubSystem);
    dlg.pnl2edit.record2Gui();
    util.MiscFunc.hideProcessingMessage();
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }

}
