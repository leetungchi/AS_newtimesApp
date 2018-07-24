package newtimes.nthk_report;

import processhandler.commands.*;
import processhandler.*;


public class TgrListRptEtdCreateDate extends CommandTrigger {
  public TgrListRptEtdCreateDate() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       PnlMdfRptEtdAndCreateDate  pnl=new PnlMdfRptEtdAndCreateDate();
       pnl.setPreferredSize(new java.awt.Dimension(800,600));
       pnl.setBounds(0,0,800,600);
       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(pnl,null);
       jframe.validate();
       jframe.repaint();
       ctnCtl.recordProcess(this);
    }catch(Exception exp){
      exp.printStackTrace();
      throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }

}
