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

public class TgrToGenQryGui4Restore extends CommandTrigger {
  public TgrToGenQryGui4Restore() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenQryPreProdGUI){
       try{
         ((AbleToGenQryPreprod4Restore)commander).toGenQryPreprod4Restore();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cme){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to generate GUI for listing preprod deleted records");
    }
  }

}
