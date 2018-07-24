package newtimes.shipping_admin.process.packing;
import processhandler.commands.*;
import processhandler.*;
import newtimes.shipping_admin.guis.packing.*;
import database.datatype.Record;
public class TgrToEditPackingStyle extends CommandTrigger {
  //DB_ShipStylePacking dbObj = null;
  //PnlEditPacking4Style pnl = null;
  DB_PackingDirectQty dbObj=null;
  PnlEditPackingDirectQty pnl=null;
  public  static Record RECORD_SHIP_DETAIL;
  public TgrToEditPackingStyle(Record recShipStyle) {
    RECORD_SHIP_DETAIL=recShipStyle;
  }
  public void setPackingRecord(Record recShipStyle){
     dbObj=new DB_PackingDirectQty(recShipStyle);
     pnl=new PnlEditPackingDirectQty(dbObj);
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_PACKING_COMMAND
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToEditPackingStyle){
       try{
         toEditPackingStyle();
         //ctnCtl.recordProcess(this);
       }catch(CommandIncompleteException cie){

        throw cie;
       }catch(processhandler.commands.CommandException ce){
        throw ce;
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to EditPackingStyle");
    }

  }
  public void toEditPackingStyle() throws processhandler.commands.CommandException{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      //newtimes.shipping_admin.guis.packing.PnlDfnSty2Pack  pnl=
        //  new newtimes.shipping_admin.guis.packing.PnlDfnSty2Pack();
      jframe.getContentPane().removeAll();
      pnl.setBounds(0,0,775,680);
      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer("Please Select Styles To Add To Shipping");
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;

      //pnlFunc.setButtons(true, true, true, true, true);
      pnlFunc.removalAddExtralButtons();
      jframe.getContentPane().add(pnlFunc,null);
      pnlFunc.setEditPanel(pnl);
      pnl.firstPage();
      pnl.setPreferredSize(new java.awt.Dimension(775, 400));
      pnl.repaint();
      pnl.validate();
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
      jframe.repaint();
      jframe.validate();
      if(!newtimes.shipping_admin.ShippingAdmin_Const.isShipClosed(RECORD_SHIP_DETAIL)){
        pnlFunc.setButtons(true, true, true, true, true);
        //System.out.println("TRIGGER CALLED ");
        if(((DB_PackingDirectQty)dbObj).recShipStyle.getInt(0)<0 &&
           ((DB_PackingDirectQty)dbObj).recShipStyle.getInt(0)>-5000){
           if(newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnConfirm.isEnabled()){

             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnAdd.setEnabled(false);
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnDelete.setEnabled(false);
           }
        }else{
          //editing mode
          if(newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnConfirm.isEnabled()){
            //add new mode
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnAdd.setEnabled(true);
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnDelete.setEnabled(true);
          }

        }


      }else{
        pnlFunc.setButtons(false, false, false, false, false);
        pnl.btnDeleteThisShipStyle.setVisible(false);
        pnl.btnModifySizeColor.setVisible(false);
      }

    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }


}
