package newtimes.nthk_report;

import processhandler.commands.*;
import processhandler.*;


public class TgrShipVrnRpt extends CommandTrigger {
  public TgrShipVrnRpt() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       PnlShipVrnRpt   pnl=new PnlShipVrnRpt();
       pnl.jbInit();
       processhandler.template.Properties.getSplitFrame().setPanel(
          pnl,
          tempDownPnl
        );
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.35);
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
