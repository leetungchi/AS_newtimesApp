package newtimes.production.process.prodmaintain;
public class ToListFabricCutSummaryDtl
    extends ToCheck4FabricProc
    implements AbleToListFabricCutSummaryDtl{
  public ToListFabricCutSummaryDtl() {

  }
  public void toListFabricCutSummaryDtl()throws Exception{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      newtimes.production.gui.prodmaintain.PnlFbcCutSmyDtlP_View  pnl =
          new newtimes.production.gui.prodmaintain.PnlFbcCutSmyDtlP_View(
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      StringBuffer sb=new StringBuffer();
      sb.append("=====  Fabric PO Cuts/yileds Summary Detail List  ====");
      addLowerPanel(sb.toString(),
                    pnl);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      super.setFunctionButtonStatus(false,false,false,false,false,false);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
   }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }


  }

}
