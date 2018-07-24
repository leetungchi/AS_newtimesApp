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

public class TgrQryBankHead extends CommandTrigger{
  public TgrQryBankHead() {

  }
  protected void addGui(){
    javax.swing.JFrame jframe = processhandler.template.Properties.
        getMainFrame();
    jframe.getContentPane().removeAll();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.WAIT_CURSOR));
    PnlQryBankHead pnl=null;
    if(Constants.PNL4QRYHEAD==null){
       pnl=new PnlQryBankHead();
       Constants.PNL4QRYHEAD=pnl;
    }else{
      pnl=(PnlQryBankHead)Constants.PNL4QRYHEAD;
    }
    pnl.setSize(800, 600);
    jframe.getContentPane().add(pnl);
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
       ctnCtl.recordProcess(this); //store this node as "go back" required
       addGui();
  }

}
