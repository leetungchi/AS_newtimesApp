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

public class TgrEditBankChkDtl extends CommandTrigger{
  static DbBankCheckHandler dbHandler=null;
  public TgrEditBankChkDtl() {
  }
  protected void addGui(){
    javax.swing.JFrame jframe = processhandler.template.Properties.
        getMainFrame();
    jframe.getContentPane().removeAll();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.WAIT_CURSOR));
    PnlEditBankCheckDtl pnl=new PnlEditBankCheckDtl();
    pnl.setRecord(Constants.CURRENT_EDITING_BANK_CHK_DTL_RECORD);
    if(dbHandler==null)dbHandler=new DbBankCheckHandler();
    pnl.record2Gui();
    pnl.setPagedDataFactory(dbHandler);
    pnl.setSize(800, 600);
    jframe.getContentPane().add(pnl);
    jframe.repaint();
    jframe.show();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.DEFAULT_CURSOR));

    processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {

    processhandler.template.Properties.getCenteralControler().
        setSystemCommander(
        newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
       commander = processhandler.template.Properties.getCenteralControler().
        getCurrentSystemCommand();
       //ctnCtl.recordProcess(this); //store this node as "go back" required
       addGui();
  }
}
