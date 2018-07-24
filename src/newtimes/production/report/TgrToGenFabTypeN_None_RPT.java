package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenFabTypeN_None_RPT extends CommandTrigger {
  public TgrToGenFabTypeN_None_RPT() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenFabTypeN_None_RPT){
       try{
         ((AbleToGenFabTypeN_None_RPT)commander).toGenFabTypeN_None_RPT();
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
      throw new CommandException("commander is not able to GenFabTypeN_None_RPT");
    }

  }

}
