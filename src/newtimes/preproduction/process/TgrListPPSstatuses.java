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

public class TgrListPPSstatuses extends CommandTrigger {
  public TgrListPPSstatuses() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
    );
  commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
    throw new CommandException("commander is null");
  if(commander instanceof AbleToListPPSstatuses ){
     try{
       ((AbleToListPPSstatuses)commander).toListPPSstatuses();
       //ctnCtl.recordProcess(this);
     }catch(processhandler.commands.CommandIncompleteException cme){
     }catch(Exception e){
        e.printStackTrace();
        throw new CommandException(e.getMessage());
     }
  }else{
    throw new CommandException("commander is not able to generate GUI for Show Color Lib List");
  }

  }

}
