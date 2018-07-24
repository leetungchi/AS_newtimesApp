package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToEdit_SC_Head extends CommandTrigger {
  public TgrToEdit_SC_Head() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
         );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEdit_SC_Head){
       try{
         ((AbleToEdit_SC_Head)commander).toEdit_SC_Head();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to Edit_SC_Head");
    }

  }

}
