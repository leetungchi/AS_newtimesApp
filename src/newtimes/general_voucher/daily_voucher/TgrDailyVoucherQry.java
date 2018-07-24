package newtimes.general_voucher.daily_voucher;
import processhandler.commands.*;
import processhandler.*;
import java.awt.*;

public class TgrDailyVoucherQry extends CommandTrigger {
  static public PnlQryDailyVoucher pnlQryGui=null;
  public TgrDailyVoucherQry() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
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
      if(null==pnlQryGui){
        pnlQryGui = new PnlQryDailyVoucher();
      }
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

      pnlQryGui.setSize(800, 600);
      jframe.getContentPane().add(pnlQryGui);

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
