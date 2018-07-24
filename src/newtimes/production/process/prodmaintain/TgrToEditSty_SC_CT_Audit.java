package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToEditSty_SC_CT_Audit extends CommandTrigger {
  public TgrToEditSty_SC_CT_Audit() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditSty_SC_CT_Audit){
       try{
         ((AbleToEditSty_SC_CT_Audit)commander).toEditSty_SC_CT_Audit();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){
          throw cie;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to EditSty_SC_CT_Audit");
    }

  }

}
