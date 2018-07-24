package newtimes.shipping_admin.process.shiippingmaintain;
public class ToListShippingMaster implements AbleToListShippingMaster{
  public ToListShippingMaster() {

  }
  public void toListShippingMaster() throws processhandler.commands.CommandException{
    try{
      util.ApplicationProperites.setProperties(
        "newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles$InnerPnlListAddedStyles_TOP_RECORD_AT",
       new Integer(1));

      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
        new newtimes.shipping_admin.PnlBaseContainer();
    newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
    pnlFunc.setButtons(false, false,false, false, false);
    pnlFunc.removalAddExtralButtons();
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("       SRN      ", "SHIP_NO");
      iso.put("  ETD  \n  Date  ", "SHIP_ETD_DATE");
      iso.put("    S/C No.    ", "prod_sc_no");
      iso.put("  CENTER  ", "CEN_NAME");
      iso.put("  DEP.  ", "DEP_NAME");
      iso.put(" BUYER      ", "BUYER");
      iso.put(" MAKER      ", "MAKER");
      DB_ShipMaster dbShipMaster=new DB_ShipMaster();
      dbShipMaster.is2ShowForDirectHeadUse=true;
      newtimes.shipping_admin.guis.shippingmaintain.PnlListShipMasters  pnl =
          new newtimes.shipping_admin.guis.shippingmaintain.PnlListShipMasters(
              dbShipMaster,14,iso,
              new java.util.Hashtable(),
              "Edit\nShip-Styles","  ... ",
              "Edit\nShipping Head Data"," ... ");
      jframe.getContentPane().removeAll();
      pnl.setBounds(0, 0, 775, 500);
      pnl.setPreferredSize(new java.awt.Dimension(775, 500));
      //pnl.reload();
      //pnl.repaint();
      //pnl.validate();
      pnlFunc.setEditPanel(pnl);
      jframe.getContentPane().add(pnlFunc, null);
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
      //pnl.pgTblList.gotoRowPosition(pnl.PAGE_BEGIN);
      jframe.repaint();
      jframe.validate();
      pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
 }
}
