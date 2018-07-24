package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;
import javax.swing.*;
import java.awt.*;

public class TgrListClaim extends CommandTrigger {
  public TgrListClaim() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
         );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
       try{
         toListClaim();
       }catch(processhandler.commands.CommandIncompleteException cie){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }

  }
  public void toListClaim()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlClaim pnl=
          new newtimes.production.gui.prodmaintain.PnlClaim();
      pnl.setPreferredSize(
         new java.awt.Dimension(780,385)
       );
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.addLowerPanel("Claim Form",pnl);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
      processhandler.template.Properties.getSplitFrame().jSplitPane.setDividerSize(0);
      processhandler.template.Properties.getSplitFrame().repaint();
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(false,true,false,false,false,false);
      }else{
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(false,false,true,false,false,false);
      }
      jframe.validate();jframe.repaint();
      pnl.firstPage();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
