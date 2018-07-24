package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToQryPoFtyInv extends CommandTrigger {
  public TgrToQryPoFtyInv() {

  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    if(newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo==null){
      newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo =
          new newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByPoFtyInv();
    }

    javax.swing.JPanel pnl=newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo;
    jframe.getContentPane().removeAll();
    jframe.getContentPane().add(pnl,null);
    pnl.setBounds(0, 0, 800, 600);
    pnl.repaint();
    pnl.validate();

  }

}
