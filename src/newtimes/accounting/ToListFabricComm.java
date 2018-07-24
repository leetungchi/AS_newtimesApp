package newtimes.accounting;
import processhandler.commands.*;
public class ToListFabricComm implements AbleToListFabricComm{
  public ToListFabricComm() {

  }
  public void toListFabricComm() throws processhandler.commands.CommandException{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    /*
    while (!newtimes.preproduction.process.AttributeFactory.
           isAllAccsAttribReady()) {
      try {
        Thread.currentThread().sleep(100);
      } catch (java.lang.InterruptedException ie) {
      }
    }
    */
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    javax.swing.JPanel pnl=null;
    pnl=new PnlListFabComm();
    jframe.getContentPane().add(pnl, null);
    pnl.setBounds(0, 0, 800, 600);
    pnl.repaint();
    pnl.validate();
    newtimes.production.ProdMaintain_Properties.setNormalCursor();
    //jframe.validate();
    //jframe.repaint();
  }
}
