package newtimes.general_voucher.daily_voucher;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShow5105xHCX implements IntfSubSystem {
  public ToShow5105xHCX() {
  }
  public void doShowEditorDlg(){
    util.MiscFunc.showProcessingMessage();
    Dlg5105xHCX  dlg=new  Dlg5105xHCX(util.PublicVariable.APP_FRAME,
    "¹B¶O©ú²Ó",true);
    dlg.setSize(560,425);
    //have to findout if have column to store vector of detail
    int i=Constants.recSubSystem.getFieldName().size()-1;
    String clmName=(String)Constants.recSubSystem.getFieldName().get(i);
    if(!clmName.equalsIgnoreCase("clm2StoreVector")){
      Constants.recSubSystem.getFieldName().add("clm2StoreVector");
      Constants.recSubSystem.getValueFields().add(null);
    }
    try{
      java.util.Vector vctDtl=(java.util.Vector)Constants.recSubSystem.get("clm2StoreVector");
      if(vctDtl==null){
        if(Constants.recSubSystem.get(0).toString().indexOf(".")==-1){
           vctDtl=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from VH_5105HCX_DTL where glb_seq="+String.valueOf(Constants.recSubSystem.getLong(0))+" order by dtl_seq",
            1,9999
          );
        }else{
          vctDtl=new java.util.Vector();
        }
      }

      for(int j=0;j<5;j++){
        database.datatype.Record recNew= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VH_5105HCX_DTL_tbl");
        vctDtl.add(recNew);
      }

      Constants.recSubSystem.set("clm2StoreVector",vctDtl);
      dlg.pnlEdit.vctDetail2Edit=vctDtl;
    }catch(Exception exp){
      exp.printStackTrace();
    }
    dlg.pnlEdit.setRecord(Constants.recSubSystem);
    dlg.pnlEdit.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.db4SubSystem);
    dlg.pnlEdit.jbInit();
    dlg.pnlEdit.record2Gui();
    util.MiscFunc.hideProcessingMessage();
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.btnExit.grabFocus();
    dlg.show();
  }

}
