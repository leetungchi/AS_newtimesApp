package processhandler;
import processhandler.commands.*;

/**
 * <p>Title:TriggerClass,to enter into the "showing Query GUI" process </p>
 * <p>Description: Title:TriggerClass,to activate current process object to enter into the "Showing Query GUI" process <br>
 *    Please  be aware of that current Command(Process) Object must implement the interface "AbleToGenQryGUI" before triggerring  this process.
 * </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: metak.com.tw</p>
 * @author Crazy John
 * @version 1.0
 */
public class Cmd2QryGUI extends CommandTrigger {
  public Cmd2QryGUI() {
  }
  public void activateThisProcess() throws CommandException {
   if(commander==null)
     throw new CommandException("commander is null");
   if(commander instanceof AbleToGenQryGUI ){
      try{
        ((AbleToGenQryGUI)commander).toGenQryGUI();
      }catch(Exception e){
         e.printStackTrace();
         throw new CommandException(e.getMessage());
      }
      ctnCtl.recordProcess(this);
   }else{
     throw new CommandException("commander is not able to generate GUI for Query");
   }
  }

}