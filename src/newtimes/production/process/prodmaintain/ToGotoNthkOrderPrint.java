package newtimes.production.process.prodmaintain;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToGotoNthkOrderPrint extends ToGotoOderPrint {
  public ToGotoNthkOrderPrint() {
  }
  public void toGotoOderPrint() throws processhandler.commands.CommandException{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //prepare the upper panel of production head.
      newtimes.preproduction.process.ToInitUperAndDownPnl.setPreProdDisplayer();

      newtimes.preproduction.guis.PnlNthkOrderPrint  pnl=
          new newtimes.preproduction.guis.PnlNthkOrderPrint();
      super.addLowerPanel("ORDER PRINT",pnl);
      //processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
      processhandler.template.Properties.getSplitFrame().repaint();
      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
        false,false,false,false,false,false);
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      */
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Head",
        new newtimes.preproduction.process.TrggerEditAPreprod());

    }finally{
      jframe.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }



  }


}
