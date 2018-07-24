package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.*;
import processhandler.commands.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrToReportUnit extends CommandTrigger {
  public TgrToReportUnit() {
  }

  public void activateThisProcess()throws CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    //ctnCtl.recordProcess(this);
    newtimes.shipping.ShippingMenu.btnGotoInvIcReport(
      newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
  }
}
