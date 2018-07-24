package newtimes.shipping_admin.process.shiippingmaintain;
import javax.swing.JPanel;
public class ToQryShipMaster implements AbleToQryShipMaster{
  public ToQryShipMaster() {

  }

  public void toQryShipMaster(){
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
    javax.swing.JPanel pnl=null;
    if(newtimes.shipping_admin.ShippingAdmin_Const.PNL_QRY_SHIPMASTER_CONDITIONS==null){
       newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode=
           util.PublicVariable.OPERATTING_CENTER;
       pnl = new newtimes.shipping_admin.guis.shippingmaintain.PnlQryShippingMaster();
       newtimes.shipping_admin.ShippingAdmin_Const.PNL_QRY_SHIPMASTER_CONDITIONS=pnl;
      try {
        ((newtimes.shipping_admin.guis.shippingmaintain.PnlQryShippingMaster)pnl).activate();
      } catch (Exception exp) {
        exp.printStackTrace();
      }
    }else{
      pnl=newtimes.shipping_admin.ShippingAdmin_Const.PNL_QRY_SHIPMASTER_CONDITIONS;
    }
    newtimes.shipping_admin.ShippingAdmin_Const.INIT_QRY_LAUREN_PO=null;
    newtimes.shipping_admin.ShippingAdmin_Const.INIT_QRY_LAUREN_FTY_INV=null;
    jframe.getContentPane().add(pnl, null);
    pnl.setBounds(0, 0, 800, 600);
    pnl.repaint();
    pnl.validate();
    newtimes.production.ProdMaintain_Properties.setNormalCursor();
    //jframe.validate();
    //jframe.repaint();
  }
}
