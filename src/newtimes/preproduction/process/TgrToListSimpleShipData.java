package newtimes.preproduction.process;
import processhandler.commands.*;
import processhandler.*;


public class TgrToListSimpleShipData extends CommandTrigger {
  public TgrToListSimpleShipData() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
    newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
    );
   commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListSimpleShipData){
       try{
         ((AbleToListSimpleShipData)commander).toListSimpleShipData();
         ctnCtl.recordProcess(this);
       }catch(CommandIncompleteException cie){
        throw cie;
       }catch(processhandler.commands.CommandException ce){
        throw ce;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ListSimpleShipData");
    }

  }

}
