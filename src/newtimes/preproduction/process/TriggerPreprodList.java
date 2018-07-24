package newtimes.preproduction.process;
import processhandler.*;
import processhandler.commands.CommandException;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TriggerPreprodList extends CommandTrigger {
  public TriggerPreprodList() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof processhandler.commands.AbleToListQryResult){
       try{
         ((processhandler.commands.AbleToListQryResult)commander).toListQryResult();
         ctnCtl.recordProcess(this);
        }catch(processhandler.commands.CommandIncompleteException cme){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to generate GUI for Query");
    }

  }

}
