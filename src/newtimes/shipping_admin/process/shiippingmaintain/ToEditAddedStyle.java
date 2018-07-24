package newtimes.shipping_admin.process.shiippingmaintain;
import database.datatype.Record;
public class ToEditAddedStyle implements AbleToEditAddedStyle{
  public ToEditAddedStyle() {

  }
  public void toEditAddedStyle1115(){
    try{

      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();

      processhandler.template.PnlFieldsEditor  pnl=getEditorPanel();
      jframe.getContentPane().removeAll();
      DB_ShipStyle handler=new DB_ShipStyle(
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);

      Record initRec=handler.getRecordByPk(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT);
       //sizeColumn="";
      //initRec.set("ship_sty_size_column",sizeColumn);

      if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
        initRec.set("ship_sty_size_column","");
      }
      newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=initRec;
      pnl.setPagedDataFactory(handler);
      pnl.setRecord(initRec);
      pnl.setBounds(0,0,775,850);
      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer();
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;

      String centerCode=util.PublicVariable.OPERATTING_CENTER;
      pnlFunc.removalAddExtralButtons();
      if(!centerCode.equals("NTHK") && !centerCode.equals("001")){

        pnlFunc.addTriggerButton("To Enquiry",
                                 new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());

        pnlFunc.addTriggerButton("PRINT SRN",
                                 new newtimes.shipping_admin.process.
                                 shiippingmaintain.TgrToReportUnit()
                                 );
      }


      jframe.getContentPane().add(pnlFunc,null);

      pnl.record2Gui();
      pnlFunc.setEditPanel(pnl);
      pnl.setPreferredSize(new java.awt.Dimension(750, 700));
      pnl.repaint();
      pnl.validate();
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
      jframe.repaint();
      jframe.validate();
      if(!newtimes.shipping_admin.ShippingAdmin_Const.isShipClosed(TgrToEditAddedStyle.RECORD_SHIP_DETAIL)){
        //pnlFunc.setButtons(true, true, true, true, true);
        pnlFunc.setButtons(false,true, false, false, true);

      }else{
        pnlFunc.setButtons(false, false, false, false, false);
        ((newtimes.shipping_admin.ShipPrxQty.Intf_get_Po_Ship_Qty_Pnl)pnl).getShipQtyPnl().btnAdd.setVisible(false);
        ((newtimes.shipping_admin.ShipPrxQty.Intf_get_Po_Ship_Qty_Pnl)pnl).getShipQtyPnl().btnDel.setVisible(false);

      }

    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  protected processhandler.template.PnlFieldsEditor  getEditorPanel(){
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
      return new newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyleFE();
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      return new newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyle();
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      return new newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyleNthk();
    }

    if(util.PublicVariable.OPERATTING_CENTER.equals("PW")||util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
      return new newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW();
    }
    return new newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyleFE();
  }

  public void toEditAddedStyle(){
    toEditAddedStyle1115();
    /*
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       toEditAddedStyle1115();
       return;
    }
   try{

     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     javax.swing.JFrame jframe = processhandler.template.Properties.
         getMainFrame();
     newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle pnl =
         new newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle();
     jframe.getContentPane().removeAll();
     DB_ShipStyle handler = new DB_ShipStyle(
         newtimes.shipping_admin.ShippingAdmin_Const.
         EDIT_SHIP_STYLE_STYLE_INT_SEQ);

     Record initRec = handler.getRecordByPk(newtimes.shipping_admin.
                                            ShippingAdmin_Const.
                                            EDIT_SHIP_STYLE_SEQ_INT);
     String sizeColumn=newtimes.shipping_admin.ShippingAdmin_Const.recnvDblCamaString(
      (String)initRec.get("_$org_sty_size_column"));
     initRec.set("_$org_sty_size_column",sizeColumn);

     newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD =
         initRec;
     pnl.setPagedDataFactory(handler);
     pnl.setRecord(initRec);
     pnl.setBounds(0, 0, 775, 850);
     newtimes.shipping_admin.PnlBaseContainer pnlFunc =
         new newtimes.shipping_admin.PnlBaseContainer();
     newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL = pnlFunc;

     String centerCode=util.PublicVariable.OPERATTING_CENTER.toString();
     pnlFunc.setButtons(false, true, false, false, true);
     if(!centerCode.equals("NTFE")){
       pnlFunc.btnConfirm.setText("Confirm Edit Commission");
     }
     pnlFunc.removalAddExtralButtons();

     if(!centerCode.equals("NTHK") && !centerCode.equals("001")){
       pnlFunc.addTriggerButton("PRINT SRN",
                                new newtimes.shipping_admin.process.
                                shiippingmaintain.TgrToReportUnit()
                                );
     }


     jframe.getContentPane().add(pnlFunc, null);
     pnl.record2Gui();
     pnlFunc.setEditPanel(pnl);
     pnl.setPreferredSize(new java.awt.Dimension(750, 850));
     pnl.repaint();
     pnl.validate();
     pnlFunc.setBounds(0, 0, 790, 580);
     pnlFunc.repaint();
     pnlFunc.validate();
     jframe.repaint();
     jframe.validate();
   }catch(Exception exp){
     exp.printStackTrace();
   }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }*/
  }
}
