package newtimes.general_voucher.daily_voucher;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShowTraficFeeEditor implements IntfSubSystem{
  public ToShowTraficFeeEditor() {

  }
  public void doShowEditorDlg(){
        util.MiscFunc.showProcessingMessage();
        DlgTraficFeeEditor dlg=new  DlgTraficFeeEditor(util.PublicVariable.APP_FRAME,
        "Edit Trafice Fee(®È¶O½s¿è)",true);
        dlg.setSize(690,330);
        dlg.pnlTfkFeeEditor.setRecord(Constants.recSubSystem);
        dlg.pnlTfkFeeEditor.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.db4SubSystem);
        dlg.pnlTfkFeeEditor.record2Gui();
        util.MiscFunc.hideProcessingMessage();
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();

  }
}
