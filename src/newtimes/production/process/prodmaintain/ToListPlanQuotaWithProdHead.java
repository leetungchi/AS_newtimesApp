package newtimes.production.process.prodmaintain;
import newtimes.preproduction.process.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListPlanQuotaWithProdHead extends ToInitUperAndDownPnl  implements AbleToListPlanQuotaWithProdHead{
  public ToListPlanQuotaWithProdHead() {
  }
  public void toListPlanQuotaWithProdHead()throws Exception{
    try{
     javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
      //specific process of doing this command.
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      newtimes.preproduction.process.ToInitUperAndDownPnl.setPreProdDisplayer();
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
          false, true, false, false,false,false);
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
