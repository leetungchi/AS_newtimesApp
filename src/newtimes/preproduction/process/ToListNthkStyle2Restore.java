package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListNthkStyle2Restore extends ToListStyle2Restore {
  public ToListNthkStyle2Restore() {
  }
  public void toListStyle2Restore()throws Exception{
    try{
      util.ApplicationProperites.setProperties("PnlStyleList_beginRow_at",new Integer(0));
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      setPreProdDisplayer();
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlNthkStyList4Restore  pnl=
          new newtimes.production.gui.prodmaintain.PnlNthkStyList4Restore();
      pnl.setPreferredSize(
         new java.awt.Dimension(300,200)
       );
      super.toSetPanelUnderButtons(pnl,"Deleted Style Records");
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      pnl.firstPage();
      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
          false, true, false, false,false, false);

    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }


}
