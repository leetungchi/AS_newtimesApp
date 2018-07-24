package newtimes.production.process.order_change;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToInputSCNO extends CommandTrigger {
  public TgrToInputSCNO() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToInputSCNO){
       try{
         ((AbleToInputSCNO)commander).toInputSCNO();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to InputSCNO");
    }

  }

}
