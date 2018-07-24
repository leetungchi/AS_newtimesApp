package newtimes.production.process.prodmaintain;
public class ToListFbkCutYldSummary
    extends ToCheck4FabricProc
    implements AbleToListFbkCutYldSummary{
  public ToListFbkCutYldSummary() {

  }
  public void toListFbkCutYldSummary()throws Exception{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     try{
       newtimes.production.gui.prodmaintain.PnlFbcCutSmyP_View  pnl =
           new newtimes.production.gui.prodmaintain.PnlFbcCutSmyP_View(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
       StringBuffer sb=new StringBuffer();
       sb.append("=====  Fabric PO Cuts/yileds Summary List  ====");
       addLowerPanel(sb.toString(),
                     pnl);
       super.setFunctionButtonStatus(false,false,false,false,false,false);
       processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
