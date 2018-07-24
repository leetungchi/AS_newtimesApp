package newtimes.accounting.debit_note;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrEditDebitNoteHead extends CommandTrigger {
  public TgrEditDebitNoteHead() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      processhandler.template.Properties.getCenteralControler().
          setSystemCommander(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
      commander = processhandler.template.Properties.getCenteralControler().
          getCurrentSystemCommand();
      ctnCtl.recordProcess(this); //store this node as "go back" required
      //wait if misc. attributions ready
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setCursor(new Cursor(
          Cursor.WAIT_CURSOR));

      while (!newtimes.preproduction.process.AttributeFactory.
             isAllAccsAttribReady()) {
        try {
          Thread.currentThread().sleep(100);
        } catch (java.lang.InterruptedException ie) {
        }
      }
      PnlEditDebitNoteHead pnl=new PnlEditDebitNoteHead();
      pnl.setSize(800, 600);
      pnl.record2Gui();
      jframe.getContentPane().add(pnl);
      jframe.repaint();
      jframe.show();
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }
}