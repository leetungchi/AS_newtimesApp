package newtimes.production.report;
import processhandler.commands.CommandException;
import processhandler.*;
import processhandler.commands.*;

public class TgrToGenRptQCOffShore extends CommandTrigger {
  public TgrToGenRptQCOffShore() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenRptQCOffShore){
       try{
         ((AbleToGenRptQCOffShore)commander).toGenRptQCOffShore();
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
      throw new CommandException("commander is not able to GenRptQCOffShore");
    }

  }

}
