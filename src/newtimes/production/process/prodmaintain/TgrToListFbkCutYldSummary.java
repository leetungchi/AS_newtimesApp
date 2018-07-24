package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListFbkCutYldSummary extends CommandTrigger {
  public TgrToListFbkCutYldSummary() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListFbkCutYldSummary){
       try{
         ((AbleToListFbkCutYldSummary)commander).toListFbkCutYldSummary();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ListFbkCutYldSummary");
    }

  }

}
