package newtimes.production.process.prodmaintain;
import processhandler.commands.*;
import processhandler.*;


public class TgrToListNthkCtInfor extends CommandTrigger {
  public TgrToListNthkCtInfor() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
      if(commander instanceof AbleToListNthkCtInfor){
       try{
         ((AbleToListNthkCtInfor)commander).toListNthkCtInfor();
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
      throw new CommandException("commander is not able to ListNthkCtInfor");
    }

  }

}
