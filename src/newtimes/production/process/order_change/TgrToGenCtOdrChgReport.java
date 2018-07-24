package newtimes.production.process.order_change;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenCtOdrChgReport extends CommandTrigger {
  public TgrToGenCtOdrChgReport() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenCtOdrChgReport){
       try{
         ((AbleToGenCtOdrChgReport)commander).toGenCtOdrChgReport();
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
      throw new CommandException("commander is not able to GenCtOdrChgReport");
    }

  }

}
