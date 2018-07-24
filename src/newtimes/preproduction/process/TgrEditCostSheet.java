package newtimes.preproduction.process;
import processhandler.*;
import processhandler.commands.CommandException;
import processhandler.commands.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrEditCostSheet extends CommandTrigger {
  public TgrEditCostSheet() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditCostSheet   ){
       try{
         ((AbleToEditCostSheet)commander).toEditCostSheet();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cme){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to generate GUI for Show Color Lib List");
    }



  }

}
