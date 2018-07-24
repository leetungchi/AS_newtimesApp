package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListPpClib4Restore extends ToInitUperAndDownPnl4Restore
 implements AbleToListPpClib4Restore{
  public ToListPpClib4Restore() {
  }
 public void toListPpClib4Restore()throws Exception{
   try{
     //jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
     //specific process of doing this command.
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     setPreProdDisplayer();//set display preproduction head data to uper pannel.
     DB_PreProdColorLib.preprodHeadSeq=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
     newtimes.preproduction.guis.PnlListPpClibs4Restore pnl=
         new newtimes.preproduction.guis.PnlListPpClibs4Restore();
     pnl.setPreferredSize(new java.awt.Dimension(150,150));
     processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
     processhandler.template.Properties.getSplitFrame().setDividerLocation(0.5);
     super.toSetPanelUnderButtons(pnl,"COLOR LIBS");
    // pnl.repaint();
     //disable some buttons...
     newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
         setFunctionButtonStatus(
         false, true, false, false, false,false);
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
