package newtimes.offshoredebitnote;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrQryOffshoreDebitNote extends CommandTrigger  {
  public TgrQryOffshoreDebitNote() {
  }
  protected void addGui(){
  try{
  }catch(Exception exp){
    exp.printStackTrace();
    util.ExceptionLog.exp2File(exp,"");
  }
  javax.swing.JFrame jframe = processhandler.template.Properties.
      getMainFrame();
  jframe.getContentPane().removeAll();
  jframe.getContentPane().setCursor(new Cursor(
      Cursor.WAIT_CURSOR));
  PnlQryOffshoreDebitNote pnl=null;
  if(Constants.PNL4QRY!=null){
    pnl=(PnlQryOffshoreDebitNote)Constants.PNL4QRY;
  }else{
    pnl= new PnlQryOffshoreDebitNote();
    Constants.PNL4QRY=pnl;
  }
  pnl.setSize(800, 600);
  jframe.getContentPane().add(pnl);
  jframe.repaint();
  jframe.show();
  jframe.getContentPane().setCursor(new Cursor(
      Cursor.DEFAULT_CURSOR));

}
protected void activateThisProcess() throws processhandler.commands.CommandException {

  processhandler.template.Properties.getCenteralControler().
      setSystemCommander(
      newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
     commander = processhandler.template.Properties.getCenteralControler().
      getCurrentSystemCommand();
     ctnCtl.recordProcess(this); //store this node as "go back" required
     addGui();
}


}
