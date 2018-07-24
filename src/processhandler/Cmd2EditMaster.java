package processhandler;
import processhandler.commands.*;

/**
 * <p>Title:TriggerClass,to enter into the "Edit Master Record" process </p>
 * <p>Description: Title:TriggerClass,to activate current process object to enter into the "Edit Master Record" process <br>
 *    Please  be aware of that current Command(Process) Object must implement the interface "AbleToEditMaster" before triggerring  this process.
 * </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company:meta.com.tw </p>
 * @author Crazy John.
 * @version 1.0
 */

public class Cmd2EditMaster extends CommandTrigger {
  public Cmd2EditMaster() {
  }
  public void activateThisProcess() throws CommandException {
   if(commander==null)
     throw new CommandException("commander is null");
   if(commander instanceof AbleToEditMaster){
      try{
        ((AbleToEditMaster)commander).toEditMaster();
      }catch(Exception e){
         e.printStackTrace();
         throw new CommandException(e.getMessage());
      }
      ctnCtl.recordProcess(this);
   }else{
     throw new CommandException("commander is not able to Edit Master data");
   }
  }
}