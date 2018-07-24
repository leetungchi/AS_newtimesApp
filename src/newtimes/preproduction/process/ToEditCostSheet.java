package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToEditCostSheet extends ToInitUperAndDownPnl implements AbleToEditCostSheet {
  public ToEditCostSheet() {
  }
  public void toEditCostSheet()throws Exception{
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //setPreProdDisplayer();//set display preproduction head data to uper pannel.
      newtimes.preproduction.guis.PnlCostSheet    pnl=
          new newtimes.preproduction.guis.PnlCostSheet();
      pnl.setPreferredSize(
           new java.awt.Dimension(750,600)
           );
      toSetPanelUnderButtons(pnl);
      DB_CostSheet db=DB_CostSheet.getInstanceOfCostSheet();
      pnl.setRecord(db.EDITING_COST_RECORD);
      pnl.setPagedDataFactory(db);
      pnl.record2Gui();
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      processhandler.template.Properties.getSplitFrame().repaint();
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.3);
      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, true, true, true, false, true);
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(true);
      */
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }

  }
}
