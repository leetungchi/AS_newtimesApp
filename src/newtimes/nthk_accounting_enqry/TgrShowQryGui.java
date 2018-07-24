package newtimes.nthk_accounting_enqry;
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

public class TgrShowQryGui extends CommandTrigger {
  public TgrShowQryGui() {
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
      PnlQryGui pnl =null;
      if(EnqryConstants.STORED_PNL_4_QRY ==null){
          pnl = new PnlQryGui();
          EnqryConstants.STORED_PNL_4_QRY=pnl;
      }else{
         pnl=(PnlQryGui)EnqryConstants.STORED_PNL_4_QRY;
      }
      //test if user is manager or higher,should shows the button to change status
      pnl.btnQty4StatusUpdate.setVisible(false);
      if(!(util.PublicVariable.OPERATTING_CENTER.equals("001")||util.PublicVariable.OPERATTING_CENTER.equals("NTHK"))){
        if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_DIRECTOR ||
           util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER||
           util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
          pnl.btnQty4StatusUpdate.setVisible(true);
        }
      }
      pnl.setSize(800, 600);
      jframe.getContentPane().add(pnl);
      jframe.repaint();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }
}
