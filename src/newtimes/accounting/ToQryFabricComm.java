package newtimes.accounting;
import processhandler.commands.*;
public class ToQryFabricComm implements AbleToQryFabricComm{
  public ToQryFabricComm() {

  }
  public void toQryFabricComm() throws processhandler.commands.CommandException{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();

    while (!newtimes.preproduction.process.AttributeFactory.
           isAllAccsAttribReady()) {
      try {
        Thread.currentThread().sleep(100);
      } catch (java.lang.InterruptedException ie) {
      }
    }

    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    if(AcctFunsConsts.PNL_QRY_FAB_COMMS==null){
      AcctFunsConsts.PNL_QRY_FAB_COMMS=new PnlQryFabComm();
    }
    javax.swing.JPanel pnl= AcctFunsConsts.PNL_QRY_FAB_COMMS;
    jframe.getContentPane().add(pnl, null);
    pnl.setBounds(0, 0, 800, 600);
    pnl.repaint();
    pnl.validate();
    newtimes.production.ProdMaintain_Properties.setNormalCursor();
    //jframe.validate();
    //jframe.repaint();
  }
}
