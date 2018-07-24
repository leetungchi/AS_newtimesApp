package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToAddSty2Shipping extends CommandTrigger {
  public TgrToAddSty2Shipping() {
  }
  public static database.datatype.Record RECORD_SHIP_DETAIL_FROM_ASN=null;
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToAddSty2Shipping){
       try{
         ((AbleToAddSty2Shipping)commander).toAddSty2Shipping();
         ctnCtl.recordProcess(this);
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to AddSty2Shipping");
    }

  }

}
