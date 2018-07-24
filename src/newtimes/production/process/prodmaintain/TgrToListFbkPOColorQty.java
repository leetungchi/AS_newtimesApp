package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListFbkPOColorQty extends CommandTrigger {
  public TgrToListFbkPOColorQty() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListFbkPOColorQty){
         ((AbleToListFbkPOColorQty)commander).toListFbkPOColorQty();
    }

  }

}
