package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.*;
public class ToEdit_SI implements AbleToEdit_SI{
  public ToEdit_SI() {

  }
  public void toEdit_SI() throws processhandler.commands.CommandException{
    try{

      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      newtimes.shipping_admin.guis.shippingmaintain.PnlEditSi  pnl=
          new newtimes.shipping_admin.guis.shippingmaintain.PnlEditSi();
      jframe.getContentPane().removeAll();
      DB_ShipMaster handler=new DB_ShipMaster();
      pnl.setPagedDataFactory(handler);
      pnl.iniReadOnlyValue(newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD);
      database.datatype.Record iniRecord=
          handler.getSiRecord(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_SI_PK_INT);
      pnl.setRecord(iniRecord);
      pnl.setBounds(0,0,775,600);
      //pnl.PnlShipExtra.setEnabled(true);

      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer();
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;

      //pnlFunc.setButtons(false, true, false, false, true);
      //pnlFunc.btnConfirm.setText("Confirm Edit Conmission");

      pnlFunc.setButtons(false,true, false, false, false);
      //pnlFunc.btnConfirm.setText("Confirm Edit Commission");
      pnlFunc.removalAddExtralButtons();

      //pnlFunc.setPreferredSize(new java.awt.Dimension(800,590));
      jframe.getContentPane().add(pnlFunc,null);
      pnl.record2Gui();
      pnlFunc.setEditPanel(pnl);
      //pnlFunc.validate();
      //pnlFunc.repaint();
      pnl.setPreferredSize(new java.awt.Dimension(750,550));
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
