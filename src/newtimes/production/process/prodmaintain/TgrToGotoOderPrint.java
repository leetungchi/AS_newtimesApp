package newtimes.production.process.prodmaintain;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGotoOderPrint extends CommandTrigger {
  public TgrToGotoOderPrint() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGotoOderPrint){
       try{
         ((AbleToGotoOderPrint)commander).toGotoOderPrint();
         ctnCtl.recordProcess(this);
       }catch(CommandIncompleteException cie){
        throw cie;
       }catch(processhandler.commands.CommandException ce){
        throw ce;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to GotoOderPrint");
    }

  }

}
