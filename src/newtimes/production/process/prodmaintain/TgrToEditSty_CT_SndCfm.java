package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToEditSty_CT_SndCfm extends CommandTrigger {
  public TgrToEditSty_CT_SndCfm() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditSty_CT_SndCfm){
       try{
         ((AbleToEditSty_CT_SndCfm)commander).toEditSty_CT_SndCfm();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){
           throw cie;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to EditSty_CT_SndCfm");
    }

  }

}
