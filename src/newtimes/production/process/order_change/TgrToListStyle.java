package newtimes.production.process.order_change;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListStyle extends CommandTrigger {
  public TgrToListStyle() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListStyle){
       try{
         ((AbleToListStyle)commander).toListStyle();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ListStyle");
    }

  }

}
