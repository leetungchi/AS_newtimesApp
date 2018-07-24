package newtimes.preproduction.process;
import newtimes.preproduction.guis.*;
import processhandler.template.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CmdInit extends processhandler.template.CmdInit {
  public CmdInit() {
  }
  public void toSayHello(){
    //showing the first panel to main frame.
   javax.swing.JFrame jframe=util.PublicVariable.APP_FRAME;
   jframe.getContentPane().removeAll();
   PnlFuncList pnl =new PnlFuncList();
   pnl.setSize(800,600);
   jframe.getContentPane().add(pnl);
   jframe.repaint();
   jframe.show();
  }

}