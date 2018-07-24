package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;


public class TgrToGenReport4ProdDetailColors extends CommandTrigger {
  public TgrToGenReport4ProdDetailColors() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToGenReport4ProdDetailColors){
       try{
         ((AbleToGenReport4ProdDetailColors)commander).toGenReport4ProdDetailColors();
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
      throw new CommandException("commander is not able to GenReport4ProdDetailColors");
    }

  }

}
