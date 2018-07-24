package newtimes.accounting;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenProfitShareListRpt extends CommandTrigger {
  public TgrToGenProfitShareListRpt() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
              newtimes.accounting.AcctFunsConsts.COMMAND_SET_ID);
       commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenProfitShareListRpt){
       try{
         ((AbleToGenProfitShareListRpt)commander).toGenProfitShareListRpt();
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
      throw new CommandException("commander is not able to genProfitDtlListRpt");
    }

  }

}
