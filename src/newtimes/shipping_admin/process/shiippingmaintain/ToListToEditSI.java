package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.*;
public class ToListToEditSI implements AbleToListToEditSI{
  public ToListToEditSI() {

  }
  public void toListToEditSI() throws processhandler.commands.CommandException{
    try{
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
      iso.put("      S/C No.     ", "prod_sc_no");
      iso.put("  CENTER  ", "CEN_NAME");
      iso.put("  DEP.  ", "DEP_NAME");
      iso.put(" BUYER      ", "BUYER");
      iso.put(" MAKER      ", "MAKER");
      DB_ShipMaster dbShipMaster=new DB_ShipMaster();
      newtimes.shipping_admin.guis.shippingmaintain.PnlList4SiEdit  pnl =
          new newtimes.shipping_admin.guis.shippingmaintain.PnlList4SiEdit(
              dbShipMaster,20,iso,
              new java.util.Hashtable(),
              "Edit SI","  ... ");
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
      pnl.pgTblList.gotoRowPosition(pnl.PAGE_BEGIN);
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
