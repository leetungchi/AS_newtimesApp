package newtimes.general_voucher.daily_voucher;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShowTicketFeeEditor implements IntfSubSystem{
  public ToShowTicketFeeEditor() {
  }
  public void doShowEditorDlg(){
    util.MiscFunc.showProcessingMessage();
    DlgTktFeeEditor  dlg=new  DlgTktFeeEditor(util.PublicVariable.APP_FRAME,
    "¾÷²¼½s¿è",true);
    dlg.setSize(700,320);
    dlg.pnl22Eidt.setRecord(Constants.recSubSystem);
    dlg.pnl22Eidt.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.db4SubSystem);
    dlg.pnl22Eidt.record2Gui();
    util.MiscFunc.hideProcessingMessage();
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }

}
