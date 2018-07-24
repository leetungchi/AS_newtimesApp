package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.*;
import processhandler.*;


public class TgrToDirectListShipStyles extends CommandTrigger {
  public TgrToDirectListShipStyles() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToDirectListShipStyles){
       try{
         ((AbleToDirectListShipStyles)commander).toDirectListShipStyles();
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
      throw new CommandException("commander is not able to DirectyListStyles");
    }

  }

}
