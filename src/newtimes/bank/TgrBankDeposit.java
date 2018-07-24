package newtimes.bank;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

import processhandler.commands.*;
import processhandler.*;
import java.awt.*;

public class TgrBankDeposit extends CommandTrigger {
  public TgrBankDeposit() {
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
      PnlBankDeposit pnl=new PnlBankDeposit();
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      pnl.setSize(800, 600);
      jframe.getContentPane().add(pnl);

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
