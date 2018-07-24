package processhandler;
import processhandler.commands.*;

/**
 * <p>Title: Super trigger class of process switching control</p>
 * <p>Description:this super trigger is only for CenterContral object to re-trigger last command(process) </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: meta.com.tw</p>
 * @author Crazy John.
 * @version 1.0
 */

public class TriggerGoBack extends CommandTrigger {
  public TriggerGoBack() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.commands.CommandType abstract method*/
    if(commander==null) throw new processhandler.commands.CommandException("please set commander before execute going back command");
    if(commander instanceof AbleToGoBack ){
      try{
      ((AbleToGoBack)commander).toGoBack();
      }catch(Exception e){
         e.printStackTrace();
         processhandler.commands.CommandException exp= new processhandler.commands.CommandException(e.getMessage());
      }
    }else{
      throw new processhandler.commands.CommandException("current command object does not support ");
    }
  }

}