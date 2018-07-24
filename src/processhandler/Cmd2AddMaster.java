package processhandler;
import processhandler.commands.*;
/**
 * <p>Title:TriggerClass,to enter into the "Add Master Record" process </p>
 * <p>Description: Title:TriggerClass,to activate current process object to enter into the "Add Master Record" process <br>
 *    Please  be aware of that current Command(Process) Object must implement the interface "AbleToAddMaster" before triggerring  this process.
 * </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: meta.com.tw</p>
 * @author Crazy John.
 * @version 1.0
 */

public class Cmd2AddMaster extends CommandTrigger {
  public Cmd2AddMaster() {
  }
  public void activateThisProcess() throws CommandException {
   if(commander==null)
     throw new CommandException("commander is null");
   if(commander instanceof AbleToAddMaster){
      try{
        ((AbleToAddMaster)commander).toAddMaster();
      }catch(Exception e){
         e.printStackTrace();
         throw new CommandException(e.getMessage());
      }finally{

      }
      //record for further need...
      ctnCtl.recordProcess(this);
   }else{
     throw new CommandException("commander is not able to Add Master");
   }
  }
}