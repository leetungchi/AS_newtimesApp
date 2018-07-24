package newtimes.preproduction.process;
public class ToListStyle2Restore
    extends ToInitUperAndDownPnl4Restore
    implements AbleToListStyle2Restore{
  public ToListStyle2Restore() {

  }
  public void toListStyle2Restore()throws Exception{
    try{
      util.ApplicationProperites.setProperties("PnlStyleList_beginRow_at",new Integer(0));
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      setPreProdDisplayer();
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlStyList4Restore  pnl=
          new newtimes.production.gui.prodmaintain.PnlStyList4Restore();
      pnl.setPreferredSize(
         new java.awt.Dimension(300,200)
       );
      super.toSetPanelUnderButtons(pnl,"Deleted Style Records");
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      pnl.firstPage();
      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
          false, true, false, false,false, false);

     /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      */
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
