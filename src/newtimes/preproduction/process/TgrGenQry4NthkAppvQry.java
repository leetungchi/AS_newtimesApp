package newtimes.preproduction.process;
import processhandler.*;
import processhandler.commands.CommandException;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrGenQry4NthkAppvQry extends CommandTrigger {
  public TgrGenQry4NthkAppvQry() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
  processhandler.template.Properties.getCenteralControler().setSystemCommander(
      newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
      );
  commander = processhandler.template.Properties.getCenteralControler().
      getCurrentSystemCommand();

  if (commander == null)
    throw new CommandException("commander is null");
    try {
      doInitGui();
      ctnCtl.recordProcess(this);
    //} catch (processhandler.commands.CommandIncompleteException cme) {

    } catch (Exception e) {
      e.printStackTrace();
      throw new CommandException(e.getMessage());
    }


}
  protected void doInitGui() {
    javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
    jframe.setTitle("Approve PO.");
    jframe.getContentPane().removeAll();
    javax.swing.JPanel pnl =
        new newtimes.preproduction.guis.PnlQry4NthkAppvPo();
    pnl.setSize(new java.awt.Dimension(800, 600));
    jframe.getContentPane().add(pnl);
    processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
    jframe.repaint();
    jframe.show();

  }


}
