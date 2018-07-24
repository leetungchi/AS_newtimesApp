package newtimes.general_voucher.daily_voucher;

import processhandler.commands.*;
import processhandler.*;
import java.awt.*;

public class TgrEdit1102X0I3Rush extends CommandTrigger {
  public TgrEdit1102X0I3Rush() {
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
       Pnl1102X0I3RxTableEditor pnl = new Pnl1102X0I3RxTableEditor();
       try{
         pnl.jbInit();
       }catch(Exception exp){
         exp.printStackTrace();
       }
       pnl.pnlAddNew.setPagedDataFactory(pnl.db2Handle);
       pnl.pnlAddNew.setRecord(pnl.db2Handle.getBlankRecord());
       pnl.pnlAddNew.record2Gui();
       pnl.pnlListRush.firstPage();
       pnl.updateTotal();
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
      pnl.repaint();pnl.validate();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }



  }

}
