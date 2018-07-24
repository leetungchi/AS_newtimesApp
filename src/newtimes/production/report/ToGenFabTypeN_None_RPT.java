package newtimes.production.report;
import processhandler.commands.*;
public class ToGenFabTypeN_None_RPT implements AbleToGenFabTypeN_None_RPT{
  public ToGenFabTypeN_None_RPT() {

  }
  public void toGenFabTypeN_None_RPT() throws processhandler.commands.CommandException{
    while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
      try{
        Thread.currentThread().sleep(100);
      }catch(java.lang.InterruptedException ie){
      }
    }

    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       PnlFabTypeN_None_Rpt  pnl=new PnlFabTypeN_None_Rpt();
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
