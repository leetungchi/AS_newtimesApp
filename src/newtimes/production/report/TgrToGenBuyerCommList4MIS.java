package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenBuyerCommList4MIS extends CommandTrigger {
  public TgrToGenBuyerCommList4MIS() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenBuyerCommList4MIS){
       try{
         ((AbleToGenBuyerCommList4MIS)commander).toGenBuyerCommList4MIS();
         //ctnCtl.recordProcess(this);
       }catch(CommandIncompleteException cie){
        throw cie;
       }catch(processhandler.commands.CommandException ce){
        throw ce;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to GenBuyerCommList4MIS");
    }

  }

}
