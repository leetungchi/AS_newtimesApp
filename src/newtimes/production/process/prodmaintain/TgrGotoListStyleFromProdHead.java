package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;
import processhandler.commands.CommandIncompleteException;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrGotoListStyleFromProdHead extends TgrToListStyles{
  newtimes.preproduction.guis.PnlEditPPDHead pnl;
  public TgrGotoListStyleFromProdHead(newtimes.preproduction.guis.PnlEditPPDHead _pnl) {
    pnl=_pnl;
  }
 public void toRunCommand(Object inputCmd)throws CommandException,CommandIncompleteException{
    if(pnl!=null)pnl.setGotoStyle();
    super.toRunCommand(inputCmd);
 }
}
