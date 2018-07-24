package newtimes.production.process.prodmaintain;

import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListColorPcixBoard extends CommandTrigger {
  public TgrToListColorPcixBoard() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
         );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListColorPcixAndBoard){
       try{
         ((AbleToListColorPcixAndBoard)commander).toListColorPcixAndBoard();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ListProdColors");
    }

  }

}

