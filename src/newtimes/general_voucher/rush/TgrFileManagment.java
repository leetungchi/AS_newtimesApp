package newtimes.general_voucher.rush;
import processhandler.commands.*;
import processhandler.*;
import java.awt.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrFileManagment extends CommandTrigger {
  public TgrFileManagment() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

      if(newtimes.general_voucher.daily_voucher.Constants.VCT_GV_ACC_COMPANY==null)
        newtimes.general_voucher.daily_voucher.Constants.initCompanyList();
      if(newtimes.general_voucher.daily_voucher.Constants.hmCompanyAndAccCodeTwName==null)
        newtimes.general_voucher.daily_voucher.Constants.initAccCodeNameMap();

      processhandler.template.Properties.getCenteralControler().
          setSystemCommander(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
      commander = processhandler.template.Properties.getCenteralControler().
          getCurrentSystemCommand();
      ctnCtl.recordProcess(this); //store this node as "go back" required
      //wait if misc. attributions ready
      PnlFileManagment pnl=new PnlFileManagment();
      jframe.getContentPane().removeAll();
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
