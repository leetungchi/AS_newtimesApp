package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToEditStyCtDesc extends CommandTrigger {
  public TgrToEditStyCtDesc() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditStyCtDesc){
       try{
         ((AbleToEditStyCtDesc)commander).toEditStyCtDesc();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to EditStyCtDesc");
    }

  }

}
