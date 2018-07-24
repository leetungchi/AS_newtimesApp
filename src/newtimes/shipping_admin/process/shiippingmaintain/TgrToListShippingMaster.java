package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListShippingMaster extends CommandTrigger {
  public TgrToListShippingMaster() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListShippingMaster){
       try{
         ((AbleToListShippingMaster)commander).toListShippingMaster();
         ctnCtl.recordProcess(this);
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to QryScStyPo4Style");
    }

  }

}
