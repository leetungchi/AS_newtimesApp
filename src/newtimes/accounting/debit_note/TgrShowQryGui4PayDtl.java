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

public class TgrShowQryGui4PayDtl extends CommandTrigger {
  public TgrShowQryGui4PayDtl() {
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
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));

      if(Constans.PNL2QUERY_PAY_DETAIL==null){
        while (!newtimes.preproduction.process.AttributeFactory.
               isAllAccsAttribReady()) {
          try {
            Thread.currentThread().sleep(100);
          } catch (java.lang.InterruptedException ie) {
          }
        }
         Constans.PNL2QUERY_PAY_DETAIL = new PnlQryDebitNotePayDtl();

      }
      Constans.PNL2QUERY_PAY_DETAIL.setSize(800, 600);
      jframe.getContentPane().add(Constans.PNL2QUERY_PAY_DETAIL);

      /*
      PnlTest pnl=new PnlTest();
      pnl.setSize(800, 600);
      jframe.getContentPane().add(pnl);
      */
      jframe.repaint();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }
}
