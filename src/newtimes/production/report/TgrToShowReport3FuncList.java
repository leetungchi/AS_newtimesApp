package newtimes.production.report;
import processhandler.*;
import processhandler.commands.CommandException;

public class TgrToShowReport3FuncList extends CommandTrigger {
  private String usrType;
  private String usrDep;
  public TgrToShowReport3FuncList() {
         this.usrType=usrType;
         this.usrDep=usrDep;
  }
  public CommandTrigger getParentCmdTrigger(){
    return null;
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /*
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
       new newtimes.production.report.ReportCmdSet()
    );
    */
   processhandler.template.Properties.getCenteralControler().setSystemCommander(
          newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
         );
   commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToShowReport3FuncList ){
       try{
         ((AbleToShowReport3FuncList)commander).toShowReport3FuncList();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("Current Command set object is not able to show Function List for Report 3 UNIT");
    }
  }

}
