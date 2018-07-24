package newtimes.preproduction.process;
import newtimes.preproduction.guis.PnlFuncList;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShowFuncList implements AbleToShowFuncList {
  public ToShowFuncList() {
  }
  public void toShowFuncList()throws Exception{
    //showing the first panel to main frame.
    util.PublicVariable.OPERATTING_CENTER=(String)util.PublicVariable.USER_RECORD.get(4);
    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    newtimes.preproduction.guis.tempProperties.tmpCATData.clear();
   javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
   jframe.getContentPane().removeAll();
   PnlFuncList pnl =new PnlFuncList();
   pnl.setSize(800,600);
   jframe.getContentPane().add(pnl);
   jframe.repaint();
   jframe.show();
   util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
}
