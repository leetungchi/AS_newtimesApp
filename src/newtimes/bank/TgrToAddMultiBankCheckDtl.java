package newtimes.bank;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrToAddMultiBankCheckDtl extends CommandTrigger {
  public TgrToAddMultiBankCheckDtl()  {
  }
  protected void addGui(){
    javax.swing.JFrame jframe = processhandler.template.Properties.
        getMainFrame();
    jframe.getContentPane().removeAll();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.WAIT_CURSOR));
    PnlMultiAddBankDtl pnl=new PnlMultiAddBankDtl();
    pnl.getJtable().setRowHeight(27);
    pnl.setSize(800, 540);
    jframe.getContentPane().add(pnl);
    pnl.firstPage();
    jframe.repaint();
    jframe.show();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.DEFAULT_CURSOR));


  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
     processhandler.template.Properties.getCenteralControler().
         setSystemCommander(
         newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
        commander = processhandler.template.Properties.getCenteralControler().
         getCurrentSystemCommand();
        addGui();
   }

}
