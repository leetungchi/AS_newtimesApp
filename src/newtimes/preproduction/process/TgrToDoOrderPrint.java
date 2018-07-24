package newtimes.preproduction.process;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToDoOrderPrint extends CommandTrigger {
  public TgrToDoOrderPrint() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
    newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
    );
   commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToDoOrderPrint){
       try{
         ((AbleToDoOrderPrint)commander).toDoOrderPrint();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cme){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to DoOrderPrint");
    }

  }

}
