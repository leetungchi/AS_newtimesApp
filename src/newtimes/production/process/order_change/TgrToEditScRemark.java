package newtimes.production.process.order_change;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToEditScRemark extends CommandTrigger {
  public TgrToEditScRemark() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditScRemark){
       try{
         ((AbleToEditScRemark)commander).toEditScRemark();
         //ctnCtl.recordProcess(this);
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to EditScRemark");
    }

  }

}
