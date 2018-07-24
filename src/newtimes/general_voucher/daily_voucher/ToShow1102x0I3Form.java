package newtimes.general_voucher.daily_voucher;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShow1102x0I3Form implements IntfSubSystem {
  String acc_code="";
  public ToShow1102x0I3Form() {
  }

  public void doShowEditorDlg(){
    util.MiscFunc.showProcessingMessage();
    Dlg2011xOI3  dlg=new  Dlg2011xOI3(util.PublicVariable.APP_FRAME,
         "Banking Voucher Detail",true);

   dlg.setSize(560,535);
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
           "select * from VH_1102X0I3_DTL where glb_seq="+String.valueOf(Constants.recSubSystem.getLong(0))+" order by dtl_seq",
           1,9999
         );
       }else{
         vctDtl=new java.util.Vector();
       }
     }
     for(int j=0;j<10;j++){
       database.datatype.Record recNew= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VH_1102X0I3_DTL_tbl");
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
   dlg.update2UsdAmt();
   util.MiscFunc.hideProcessingMessage();
   exgui.UIHelper.setToScreenCenter(dlg);
   dlg.btnExit.grabFocus();
   dlg.show();


   /*
    dlg.setSize(530,360);
    dlg.pnledit.setRecord(Constants.recSubSystem);
    dlg.pnledit.setPagedDataFactory(Constants.Pnl_Tbl2EditDailyVoucher.db4SubSystem);
    dlg.pnledit.record2Gui();
    util.MiscFunc.hideProcessingMessage();
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.btnCancel.grabFocus();
    dlg.show();
    */

  }

}
