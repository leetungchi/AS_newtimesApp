package newtimes.shipping_admin.process.shiippingmaintain;
public class ToListStyle2Add implements AbleToListStyle2Add{
  public ToListStyle2Add() {

  }
  public void toListStyle2Add(){
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      processhandler.template.PnlTableEditor pnl=null;
          if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
            pnl= new newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn();
          }else if(util.PublicVariable.OPERATTING_CENTER.equals("BW")||
             util.PublicVariable.OPERATTING_CENTER.equals("PW")||
             util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
           pnl= new newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddPWBW();
          }else{
            pnl= new newtimes.shipping_admin.guis.shippingmaintain.PnlListStyles2Add();
          }

      jframe.getContentPane().removeAll();
      pnl.setBounds(0,0,775,680);

      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer("Please Select Styles To Add To Shipping");
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
      if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
        pnlFunc.setButtons(true, false, false, false, false);
      }else{
        pnlFunc.setButtons(false, false, false, false, false);
      }

      pnlFunc.removalAddExtralButtons();
      if(util.PublicVariable.OPERATTING_CENTER.equals("BW")||
         util.PublicVariable.OPERATTING_CENTER.equals("PW")){

        pnlFunc.addTriggerButton("To Enquiry",
                         new newtimes.shipping_admin.process.
                         shiippingmaintain.TgrToQryShipMaster());
        pnlFunc.addTriggerButton("PRINT SRN",
                         new newtimes.shipping_admin.process.
                         shiippingmaintain.TgrToReportUnit()
                         );

      }

      jframe.getContentPane().add(pnlFunc,null);
      pnlFunc.setEditPanel(pnl);
      pnl.firstPage();
      //pnlFunc.validate();
      //pnlFunc.repaint();
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
