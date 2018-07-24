package processhandler.template;
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

public class CmdInit  implements AbleToGreeting{
  public CmdInit() {
  }
  public void toSayHello(){
    //showing the first panel to main frame.
   javax.swing.JFrame jframe=Properties.getMainFrame();
   jframe.getContentPane().removeAll();
   PnlWelcome pnl=new PnlWelcome();
   pnl.setSize(500,300);
   jframe.getContentPane().add(pnl);
   jframe.repaint();
  }
}