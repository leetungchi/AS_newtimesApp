package processhandler.template;

import processhandler.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrGreetting extends CommandTrigger {
  public TgrGreetting() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander instanceof AbleToGreeting ){
      ((AbleToGreeting)commander).toSayHello();
      ctnCtl.recordProcess(this); //record me to support go back function;
    }else{
      throw
       new processhandler.commands.CommandException("command object not able to show greeting Message");
    }

  }
}