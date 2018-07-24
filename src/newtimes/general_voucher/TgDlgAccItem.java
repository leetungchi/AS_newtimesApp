package newtimes.general_voucher;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import processhandler.commands.*;
import processhandler.*;
import java.awt.*;


public class TgDlgAccItem extends CommandTrigger {
  public TgDlgAccItem() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    newtimes.general_voucher.DlgAccItem dlg=new newtimes.general_voucher.DlgAccItem(util.PublicVariable.APP_FRAME,"Accounting Items",true);
    dlg.setSize(400,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }

}
