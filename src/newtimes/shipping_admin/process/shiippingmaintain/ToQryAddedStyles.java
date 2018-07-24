package newtimes.shipping_admin.process.shiippingmaintain;
public class ToQryAddedStyles implements AbleToQryAddedStyles{
  public ToQryAddedStyles() {

  }
  public void toQryAddedStyles(){
    //javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    exgui2.SplitFrame spfrm=processhandler.template.Properties.getSplitFrame();
    newtimes.shipping_admin.guis.shippingmaintain.PnlListStyles2Edit pnl=
    new newtimes.shipping_admin.guis.shippingmaintain.PnlListStyles2Edit();
    //jframe.getContentPane().removeAll();
    //jframe.getContentPane().add(pnl,null);
    pnl.setBounds(0, 0, 800, 600);
    pnl.repaint();
    pnl.validate();
    spfrm.setUpperPanel(pnl);


  }
}
