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

public class TgrEditProtoStatuses extends CommandTrigger {
  public TgrEditProtoStatuses() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
    );
  commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new processhandler.commands.CommandException("commander is null");
    if(commander instanceof AbleToEditProtoStatuses){
       try{
         ((AbleToEditProtoStatuses)commander).toEditProtoStatuses();
         //ctnCtl.recordProcess(this);
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
