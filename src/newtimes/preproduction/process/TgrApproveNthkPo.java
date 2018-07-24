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

public class TgrApproveNthkPo extends CommandTrigger {
  public TgrApproveNthkPo() {

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
      //ctnCtl.recordProcess(this);
      //} catch (processhandler.commands.CommandIncompleteException cme) {

      } catch (Exception e) {
        e.printStackTrace();
        throw new CommandException(e.getMessage());
      }


 }
 protected void doInitGui(){
   javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
   jframe.setTitle("PO LIST TO APPROVE.");
   jframe.getContentPane().removeAll();
   javax.swing.JPanel pnl=
       new newtimes.preproduction.guis.PnlApprove();
   pnl.setSize(new java.awt.Dimension(800,600));
   util.ApplicationProperites.removeProperites("newtimes.preproduction.guis.PnlListPprd4Restore"+"_TOP_RECORD_AT");
   util.ApplicationProperites.removeProperites("newtimes.preproduction.guis.PnlListQryPprod"+"_TOP_RECORD_AT");
   jframe.getContentPane().add(pnl);
   processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
   jframe.repaint();
   jframe.show();

 }
}
