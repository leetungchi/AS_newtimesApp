package processhandler;
import processhandler.commands.*;

/**
 * <p>Title:TriggerClass,to enter into the "Edit Detail Record" process </p>
 * <p>Description: Title:TriggerClass,to activate current process object to enter into the "Edit Detail Record" process <br>
 *    Please  be aware of that current Command(Process) Object must implement the interface "AbleToEditDetail" before triggerring  this process.
 * </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: metak.com.tw</p>
 * @author Crazy John.
 * @version 1.0
 */

public class CmdEditDetail extends CommandTrigger {
  public CmdEditDetail() {
  }
  public void activateThisProcess() throws CommandException {
   if(commander==null)
     throw new CommandException("commander is null");
   if(commander instanceof AbleToEditDetail){
      try{
        ((AbleToEditDetail)commander).toEditDetail();
      }catch(Exception e){
         e.printStackTrace();
         throw new CommandException(e.getMessage());
      }
      //ctnCtl.recordProcess(this);
   }else{
     throw new CommandException("commander is not able to generate GUI for Query");
   }
  }
}