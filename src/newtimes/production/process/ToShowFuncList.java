package newtimes.production.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToShowFuncList implements AbleToShowFuncList{
  public ToShowFuncList() {
  }
  public void toShowFuncList(){
    newtimes.production.gui.PnlFunList pnl=
        new newtimes.production.gui.PnlFunList();
    pnl.setSize(800,600);
    processhandler.template.Properties.getMainFrame().getContentPane().removeAll();
    processhandler.template.Properties.getMainFrame().getContentPane().add(pnl);
    pnl.repaint();
    processhandler.template.Properties.getMainFrame().validate();
    processhandler.template.Properties.getMainFrame().repaint();
  }
}
