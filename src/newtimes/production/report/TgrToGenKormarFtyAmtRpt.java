package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenKormarFtyAmtRpt extends CommandTrigger {
  public TgrToGenKormarFtyAmtRpt() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      doReport();
    }catch(Exception exp){
      exp.printStackTrace();
      throw new CommandException(exp.getMessage());
    }
  }
  protected void doReport()throws Exception{
       javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       PnlRptKormarkFtyAmount  pnl=new PnlRptKormarkFtyAmount();
       pnl.jbInit();
       processhandler.template.Properties.getSplitFrame().setPanel(
          pnl,
          tempDownPnl
        );
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
           setFunctionButtonStatus(
           false, false, false, false,false,false,false);
       processhandler.template.Properties.getSplitFrame().validate();
       processhandler.template.Properties.getSplitFrame().repaint();

       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());

       jframe.validate();
       jframe.repaint();
       pnl.JButtonQueryButtonAction(null);

  }
}
