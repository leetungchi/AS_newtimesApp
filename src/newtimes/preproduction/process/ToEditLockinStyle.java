package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToEditLockinStyle extends ToInitUperAndDownPnl implements AbleToEditLockinStyle {
  public ToEditLockinStyle() {
  }
 public void toEditLockinStyle()throws Exception{
   //common process to set cursor...
   //javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
   //java.awt.Cursor ksr=jframe.getContentPane().getCursor();
   try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     //jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
     //specific process of doing this command.
     //setPreProdDisplayer();//set display preproduction head data to uper pannel.
     newtimes.preproduction.guis.PnlLknStyEditor    pnl=
         new newtimes.preproduction.guis.PnlLknStyEditor();
     pnl.setPreferredSize(
          new java.awt.Dimension(750,610)
          );
     toSetPanelUnderButtons(pnl);
     DB_LockinStyle db=DB_LockinStyle.getInstanceOfLckSty();
     pnl.setRecord(db.EDITING_LOCKIN_STYLE);
     pnl.setPagedDataFactory(db);
     pnl.record2Gui();
     processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
     processhandler.template.Properties.getSplitFrame().repaint();
     processhandler.template.Properties.getSplitFrame().setDividerLocation(0.3);
     //disable some buttons...
     if(db.EDITING_LOCKIN_STYLE.get(0)!=null){
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
           setFunctionButtonStatus(
           false, true, true, true, true, true);
     }else{
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
           setFunctionButtonStatus(
           false, true, true, true, false, true);
     }

     /*
     processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(true);
     processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
     processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(true);
     if(db.EDITING_LOCKIN_STYLE.get(0)!=null){
        processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(true);
     }else{
       processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
     }
     processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
     processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(true);
     */
   }finally{
          newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }
 }
}
