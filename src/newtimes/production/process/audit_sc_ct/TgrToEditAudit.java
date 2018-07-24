package newtimes.production.process.audit_sc_ct;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToEditAudit extends CommandTrigger {
  public TgrToEditAudit() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditAudit){
       try{
         ((AbleToEditAudit)commander).toEditAudit();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to EditAudit");
    }

  }

}
