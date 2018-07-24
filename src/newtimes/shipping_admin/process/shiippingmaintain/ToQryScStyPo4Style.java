package newtimes.shipping_admin.process.shiippingmaintain;
public class ToQryScStyPo4Style implements AbleToQryScStyPo4Style{
  public ToQryScStyPo4Style() {

  }
  public void toQryScStyPo4Style(){
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
      if (newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo == null) {
        if(!newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
          newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo =
              new newtimes.shipping_admin.guis.shippingmaintain.
              PnlQryStyles2AddByScPo();
        }else{
          /*
          if(null!=newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS){
            newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS.clear();
          }else{
            newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS=new java.util.HashMap();
          }
          if(null!=newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED){
            newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED.clear();
          }else{
            newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED=new java.util.HashMap();
          }
          */

          newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo =
              new newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByPoFtyInv();
        }
      }

    javax.swing.JPanel pnl=newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo;
    /*
    ((newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByScPo)pnl).initWithOrgSC();
    */
    jframe.getContentPane().removeAll();
    jframe.getContentPane().add(pnl,null);
    pnl.setBounds(0, 0, 800, 600);
    pnl.repaint();
    pnl.validate();

  }
}
