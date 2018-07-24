package newtimes.tpe_user_report;
import processhandler.commands.*;
import processhandler.*;
import javax.swing.JPanel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrTpeUsrReportFunc extends CommandTrigger{
  private String dep;
  private String u_type;
  public TgrTpeUsrReportFunc(String dep,String u_type) {
         this.dep=dep;
         this.u_type=u_type;
  }
  public void activateThisProcess() throws processhandler.commands.CommandException{
   //commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
   processhandler.template.Properties.getCenteralControler().recordProcess(this);
  newtimes.production.ProdMaintain_Properties.setWaitCursor();
  javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
  jframe.getContentPane().removeAll();
  javax.swing.JPanel pnl=null;
  pnl=new PnlTpeUsrRptFun(dep,u_type);
  jframe.getContentPane().add(pnl, null);
  pnl.setBounds(0, 0, 800, 600);
  pnl.repaint();
  pnl.validate();
  newtimes.production.ProdMaintain_Properties.setNormalCursor();
  //jframe.validate();
  //jframe.repaint();
  }
}
