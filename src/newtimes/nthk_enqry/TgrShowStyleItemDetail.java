package newtimes.nthk_enqry;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrShowStyleItemDetail  extends CommandTrigger{
  Record recStyle;
  public TgrShowStyleItemDetail(Record recStyle) {
    this.recStyle=recStyle;
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
    newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    newtimes.preproduction.guis.tempProperties.tmpCATData.clear();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    PnlItemDtl pnl=new PnlItemDtl();
    pnl.setSize(800,600);
    try{
      pnl.initByRecord(recStyle);
    }catch(Exception epx){
      epx.printStackTrace();
      util.ExceptionLog.exp2File(epx,"");
      exgui.verification.VerifyLib.showAlert("Error While Init-Style Detail GUI\nPlease Contact System Manager",
                                             "Error While Init-Style Detail GUI");
      throw new processhandler.commands.CommandIncompleteException();
    }
    jframe.getContentPane().add(pnl);
    jframe.repaint();
    jframe.show();
    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

  }

}
