package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenShipInvList extends CommandTrigger {
  public TgrToGenShipInvList() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenShipInvList){
       try{
         ((AbleToGenShipInvList)commander).toGenShipInvList();
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
      throw new CommandException("commander is not able to GenShipInvList");
    }

  }

}
