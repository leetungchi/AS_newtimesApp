package newtimes.shipping_admin.process.packing;
import processhandler.commands.*;
public class ToListAddedStyles implements AbleToListAddedStyles{
  public ToListAddedStyles() {

  }
  public void toListAddedStyles() throws processhandler.commands.CommandException{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      newtimes.shipping_admin.guis.packing.PnlListAddedPckStyles    pnl=
          new newtimes.shipping_admin.guis.packing.PnlListAddedPckStyles();
      jframe.getContentPane().removeAll();
      pnl.setBounds(0,0,775,680);
      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer("Below Are Added Packing Styles");
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
      pnlFunc.setButtons(false, false, false, false, false);
      pnlFunc.removalAddExtralButtons();
      jframe.getContentPane().add(pnlFunc,null);
      pnlFunc.setEditPanel(pnl);
      //pnl.firstPage();
      pnl.setPreferredSize(new java.awt.Dimension(775, 400));
      pnl.repaint();
      pnl.validate();
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
      jframe.repaint();
      jframe.validate();
    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

}
