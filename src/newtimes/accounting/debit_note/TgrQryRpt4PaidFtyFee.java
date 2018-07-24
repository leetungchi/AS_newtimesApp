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

public class TgrQryRpt4PaidFtyFee extends CommandTrigger {
  public TgrQryRpt4PaidFtyFee() {
  }

  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));

      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(10);
        }catch(java.lang.InterruptedException ie){
        }
      }
      processhandler.template.Properties.getCenteralControler().
          setSystemCommander(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);

      commander = processhandler.template.Properties.getCenteralControler().
          getCurrentSystemCommand();
      ctnCtl.recordProcess(this); //store this node as "go back" required
      //wait if misc. attributions ready
      PnlQryReport4PaidFtyFee pnl=new PnlQryReport4PaidFtyFee();
      pnl.setSize(new java.awt.Dimension(800,600));
      jframe.getContentPane().removeAll();
      jframe.getContentPane().add(pnl);
      jframe.repaint();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }
}
