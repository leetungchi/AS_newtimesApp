package newtimes.accounting.debit_note_user;
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

public class TgrQryGui extends CommandTrigger {
  public TgrQryGui() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      if(Constants.USR_HANDLER_DB ==null)Constants.USR_HANDLER_DB=new DbDebitNoteUser();
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
      if(Constants.pnl2Qry ==null)Constants.pnl2Qry =new PnlQryUsr();
      Constants.pnl2Qry .setSize(800,600);
      jframe.getContentPane().add(Constants.pnl2Qry );
      jframe.repaint();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }
}
