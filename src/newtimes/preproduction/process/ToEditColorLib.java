package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToEditColorLib extends ToInitUperAndDownPnl implements AbleToEditColorLib {
  public ToEditColorLib() {

  }
  public void toEditAColorLibRecord()throws Exception{
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //setPreProdDisplayer();//set display preproduction head data to uper pannel.

      newtimes.preproduction.guis.PnlColorEditor   pnl=
          new newtimes.preproduction.guis.PnlColorEditor();
      //pnl.setPreferredSize(new java.awt.Dimension(800,400));
      pnl.setPagedDataFactory(DB_ColorLib.getInstance());
      pnl.setRecord(DB_ColorLib.editingClibRecord);
      //processhandler.template.Properties.getSplitFrame().setLowerPanel(pnl);
      toSetPanelUnderButtons(pnl);
      newtimes.preproduction.Constants.ButtonsWithTriggers.setPreferredSize(
           new java.awt.Dimension(850,700));
      pnl.record2Gui();
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, true, true, true, false, true);
     /*
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
      */
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.3);
      processhandler.template.Properties.getSplitFrame().repaint();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
