package newtimes.production.process.prodmaintain;
import newtimes.preproduction.process.*;
public class ToListPlanQuota extends ToInitUperAndDownPnl implements AbleToListPlanQuota{
  public ToListPlanQuota() {

  }
  public void toListPlanQuota()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlListPlanQta  pnl=
          new newtimes.production.gui.prodmaintain.PnlListPlanQta();
      pnl.setPreferredSize(
         new java.awt.Dimension(150,150)
       );
      toSetPanelUnderButtons(pnl,"PLAN QUOTA");
      pnl.firstPage();
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
      processhandler.template.Properties.getSplitFrame().repaint();
      jframe.validate();jframe.repaint();
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false,true, false, false,false,false);
       /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      */
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }

}
