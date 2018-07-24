package newtimes.preproduction.process;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToDoNthkOrderPrint extends ToDoOrderPrint {
  public ToDoNthkOrderPrint() {

  }
  public void toDoOrderPrint()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      newtimes.preproduction.Constants.swithToNTHKMode();
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      newtimes.preproduction.process.ToInitUperAndDownPnl.setPreProdDisplayer();
      newtimes.preproduction.guis.PnlNthkOrderPrint pnl=
          new newtimes.preproduction.guis.PnlNthkOrderPrint();
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.addLowerPanel(" ORDER PRINT",pnl);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
      pnl.setPreferredSize(
         new java.awt.Dimension(300,200)
       );
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
          false,false,false,false,false,false);
      processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Head",
        new newtimes.preproduction.process.TrggerEditAPreprod());

    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }


}
