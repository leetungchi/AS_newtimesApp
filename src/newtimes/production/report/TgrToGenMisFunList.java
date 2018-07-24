package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenMisFunList extends CommandTrigger {
  public TgrToGenMisFunList() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenMisFunList){
       try{
         ((AbleToGenMisFunList)commander).toGenMisFunList();
         ctnCtl.recordProcess(this);
       }catch(CommandIncompleteException cie){
        throw cie;
       }catch(processhandler.commands.CommandException ce){
        throw ce;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to GenMisFunList");
    }

  }

}
