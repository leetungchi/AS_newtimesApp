package newtimes.general_voucher.daily_voucher;
import processhandler.commands.*;
import processhandler.*;
import java.awt.*;

public class TgrShow1102x0I3RxFuncList extends CommandTrigger {
  static public Pnl1102X0I3RxFucList pnlFuncList=null;
  public TgrShow1102x0I3RxFuncList() {
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
      if(null==pnlFuncList){
        pnlFuncList = new Pnl1102X0I3RxFucList();
      }
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

      pnlFuncList.setSize(800, 600);
      jframe.getContentPane().add(pnlFuncList);

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
