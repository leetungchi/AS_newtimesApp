package newtimes.general_voucher.daily_voucher;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShow1112Form implements IntfSubSystem{
  public ToShow1112Form() {

  }
  public void doShowEditorDlg(){
        util.MiscFunc.showProcessingMessage();
        int row=Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getSelectedRow();
        String accCode=(String)Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getValueAt(row
             ,Constants.Pnl_Tbl2EditDailyVoucher.ACC_CODE_COLUMN_AT);
         String title=null;
         if(accCode.startsWith("1112"))
           title="¶i¶µµ|ÃB½s¿è";
           else
            title="¾P¶µµ|ÃB½s¿è";

        //get prev acc code if blank.
        try{
          if (null == Constants.recSubSystem.get("PREV_ACC_NAME")||
              Constants.recSubSystem.get("PREV_ACC_NAME").toString().trim().length()==0) {
            if(row!=0){
              for (int i = row-1; i > -1; i--) {
                String accName = (String)Constants.Pnl_Tbl2EditDailyVoucher.
                    getJtable().getValueAt(i,Constants.Pnl_Tbl2EditDailyVoucher.ACC_TW_NAME_COLUMN_AT);
                 if(accName.indexOf("-")!=-1){
                   accName = accName.substring(0, accName.indexOf("-"));
                 }
                if(accName!=null && accName.trim().length()>0){
                  Constants.recSubSystem.set("PREV_ACC_NAME",accName);
                  break;
                }
              }
            }
          }
        }catch(Exception exp){
          exp.printStackTrace();
        }
        /*
        Dlg1112 dlg = new Dlg1112(util.PublicVariable.APP_FRAME, title, true);
        dlg.setSize(700, 245);
        dlg.titleLabel.setText(title);
        dlg.pnledit.setRecord(Constants.recSubSystem);
        dlg.pnledit.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.
                                        db4SubSystem);
        dlg.pnledit.record2Gui();
        util.MiscFunc.hideProcessingMessage();
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();
        */

        if(accCode.startsWith("1112")){
          Dlg1112 dlg = new Dlg1112(util.PublicVariable.APP_FRAME, title, true);
          dlg.setSize(700, 245);
          dlg.titleLabel.setText(title);
          dlg.pnledit.setRecord(Constants.recSubSystem);
          dlg.pnledit.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.
                                          db4SubSystem);
          dlg.pnledit.record2Gui();
          util.MiscFunc.hideProcessingMessage();
          exgui.UIHelper.setToScreenCenter(dlg);
          dlg.show();
        }else{
          Dlg2108 dlg = new Dlg2108(util.PublicVariable.APP_FRAME, title, true);
          dlg.setSize(700, 245);
          dlg.titleLabel.setText(title);
          dlg.pnledit.setRecord(Constants.recSubSystem);
          dlg.pnledit.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.
                                          db4SubSystem);
          dlg.pnledit.record2Gui();
          util.MiscFunc.hideProcessingMessage();
          exgui.UIHelper.setToScreenCenter(dlg);
          dlg.show();
        }
  }
}
