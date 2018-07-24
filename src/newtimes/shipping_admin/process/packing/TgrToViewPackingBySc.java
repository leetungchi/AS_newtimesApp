package newtimes.shipping_admin.process.packing;
import processhandler.commands.*;
import processhandler.*;


public class TgrToViewPackingBySc extends CommandTrigger {
  public TgrToViewPackingBySc() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_PACKING_COMMAND
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToViewPackingBySc){
       try{
         ((AbleToViewPackingBySc)commander).toViewPackingBySc();
         //ctnCtl.recordProcess(this);
       }catch(CommandIncompleteException cie){
        throw cie;
       }catch(processhandler.commands.CommandException ce){
        throw ce;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ViewPackingBySc");
    }

  }

}
