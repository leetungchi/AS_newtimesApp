package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToEditSty_SC_SndCfm extends CommandTrigger {
  public TgrToEditSty_SC_SndCfm() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
    );
   commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditSty_SC_SndCfm){
       try{
         ((AbleToEditSty_SC_SndCfm)commander).toEditSty_SC_SndCfm();
       }catch(processhandler.commands.CommandIncompleteException cie){
         throw cie;
         //ctnCtl.recordProcess(this);
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to EditSty_SC_CT_SndCfm");
    }

  }

}
