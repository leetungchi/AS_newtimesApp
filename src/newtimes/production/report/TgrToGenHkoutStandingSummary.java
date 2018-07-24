package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenHkoutStandingSummary extends CommandTrigger {
  public TgrToGenHkoutStandingSummary() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try {

      doReport();
    } catch (Exception exp) {
      exp.printStackTrace();
      throw new CommandException(exp.getMessage());
    }
  }
  protected void doReport()throws Exception{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    try{
      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }


     newtimes.production.ProdMaintain_Properties.setWaitCursor();

      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }

      System.out.println("is report engine ok ? "+
                         newtimes.production.report.ReportCmdSet.myReportEngin.checkOk());
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       PnlHKOutStandingSumRpt  pnl=new PnlHKOutStandingSumRpt ();
       pnl.jbInit();
       processhandler.template.Properties.getSplitFrame().setPanel(
          pnl,
          tempDownPnl
        );
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.25);
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
           setFunctionButtonStatus(
           false, false, false, false,false,false,false);
       processhandler.template.Properties.getSplitFrame().validate();
       processhandler.template.Properties.getSplitFrame().repaint();

       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());

       jframe.validate();
       jframe.repaint();
     }catch(processhandler.commands.CommandException cexp){
       throw cexp;
   }catch(Exception exp){
      exp.printStackTrace();
      throw new processhandler.commands.CommandException("Error For report engin");
   }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }


  }
}
