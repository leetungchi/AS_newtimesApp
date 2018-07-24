package newtimes.general_voucher.daily_voucher;

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

public class TgrEditDailyVoucher extends CommandTrigger {
  static java.util.Date INIT_DATE=null;
  static String INIT_VH_NO=null;
  public TgrEditDailyVoucher() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      util.MiscFunc.showProcessingMessage();
      processhandler.template.Properties.getCenteralControler().
          setSystemCommander(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
      commander = processhandler.template.Properties.getCenteralControler().
          getCurrentSystemCommand();
      ctnCtl.recordProcess(this); //store this node as "go back" required
      //wait if misc. attributions ready
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      PnlEditDailyVoucher pnl=new PnlEditDailyVoucher(INIT_VH_NO,INIT_DATE);
      jframe.getContentPane().removeAll();
      pnl.setSize(800, 600);
      jframe.getContentPane().add(pnl);
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
      util.MiscFunc.hideProcessingMessage();
    }



  }

}
