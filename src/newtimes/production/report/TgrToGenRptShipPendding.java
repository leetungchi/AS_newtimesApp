package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenRptShipPendding extends CommandTrigger {
  public TgrToGenRptShipPendding() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenRptShipPendding){
       try{
         ((AbleToGenRptShipPendding)commander).toGenRptShipPendding();
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
      throw new CommandException("commander is not able to GenRptShipPendding");
    }

  }

}
