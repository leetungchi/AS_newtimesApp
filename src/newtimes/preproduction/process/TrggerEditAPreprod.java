package newtimes.preproduction.process;

import processhandler.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TrggerEditAPreprod extends CommandTrigger {
  public TrggerEditAPreprod() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
    );
   commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new processhandler.commands.CommandException("commander is null");
    if(commander instanceof AbleToEditPreprodHead){
       try{
         ((AbleToEditPreprodHead)commander).toEditPreprodHead();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cme){
       }catch(Exception e){
          e.printStackTrace();
          throw new processhandler.commands.CommandException(e.getMessage());
       }
    }else{
      throw new processhandler.commands.CommandException("commander is not able to generate GUI for EditAPreprodHEad");
    }

  }

}
