package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListFabricCutSummaryDtl extends CommandTrigger {
  public TgrToListFabricCutSummaryDtl() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListFabricCutSummaryDtl){
       try{
         ((AbleToListFabricCutSummaryDtl)commander).toListFabricCutSummaryDtl();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ListFabricCutSummaryDtl");
    }

  }

}
