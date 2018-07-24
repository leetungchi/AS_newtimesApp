package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrToGenPnlBatchUpdateRemarks  extends CommandTrigger {
  public TgrToGenPnlBatchUpdateRemarks() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
     processhandler.template.Properties.getCenteralControler().recordProcess(this);
     toGen_TPE_MIS_FUNC();
  }
  protected void toGen_TPE_MIS_FUNC(){
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    PnlBatchUpdateRemarks   pnl =new PnlBatchUpdateRemarks();
    pnl.setSize(800,600);
    jframe.getContentPane().add(pnl);
    jframe.repaint();
    jframe.show();

  }
}
