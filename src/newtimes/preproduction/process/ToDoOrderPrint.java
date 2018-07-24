package newtimes.preproduction.process;
import java.awt.Cursor;
public class ToDoOrderPrint extends ToInitUperAndDownPnl implements AbleToDoOrderPrint{
  public ToDoOrderPrint() {

  }
  public void toDoOrderPrint()throws Exception{
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      newtimes.preproduction.guis.PnlOrderPrint pnl=
          new newtimes.preproduction.guis.PnlOrderPrint();
      toSetPanelUnderButtons(pnl);
      //processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
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
    }finally{
      jframe.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }
}
