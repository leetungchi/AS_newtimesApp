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

public class TgrOffshoreDebitNoteFunctionList extends CommandTrigger  {
  public TgrOffshoreDebitNoteFunctionList() {
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
  PnlFuncList pnl=new PnlFuncList();
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
     Constants.PNL4QRY=null;
     Constants.SQL4QRY=null;
     PnlQryOffshoreDebitNote.vctCountry=null;
     PnlQryOffshoreDebitNote.vctDep=null;
     addGui();
}


}
