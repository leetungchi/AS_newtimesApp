package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenTop12BuyerMakerList extends CommandTrigger {
  public TgrToGenTop12BuyerMakerList() {
  }

  protected void activateThisProcess() throws processhandler.commands.CommandException {
    doPrinter();
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    /*
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenTop12BuyerMakerList){
       try{
         ((AbleToGenTop12BuyerMakerList)commander).toGenTop12BuyerMakerList();
         //ctnCtl.recordProcess(this);
       }catch(CommandIncompleteException cie){
        throw cie;
       }catch(processhandler.commands.CommandException ce){
        throw ce;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to GenTop12BuyerMakerList");
    }
   */
  }
  protected void doPrinter()throws processhandler.commands.CommandException {
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
       PnlTop12BuyerMaker  pnl=new PnlTop12BuyerMaker();
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
