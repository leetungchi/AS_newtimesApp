package newtimes.general_voucher.daily_voucher;

import processhandler.commands.*;
import processhandler.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrOpExpReport extends CommandTrigger{
  public TgrOpExpReport() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }

    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       PnlRpt_OpExp  pnl=new PnlRpt_OpExp();
       pnl.jbInit();
       processhandler.template.Properties.getSplitFrame().setPanel(
          pnl,
          tempDownPnl
        );
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.20);
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
           setFunctionButtonStatus(
           false, false, false, false,false,false,false);
       processhandler.template.Properties.getSplitFrame().validate();
       processhandler.template.Properties.getSplitFrame().repaint();

       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());

       jframe.validate();
       jframe.repaint();
    }catch(Exception exp){
      exp.printStackTrace();
      throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }


}
