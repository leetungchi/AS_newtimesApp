package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListStyWash extends CommandTrigger {
  public TgrToListStyWash() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListStyWash){
       try{
         ((AbleToListStyWash)commander).toListStyWash();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ListStyWash");
    }

  }

}
