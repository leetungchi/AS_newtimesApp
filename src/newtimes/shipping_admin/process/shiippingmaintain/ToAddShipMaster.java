package newtimes.shipping_admin.process.shiippingmaintain;
public class ToAddShipMaster implements AbleToAddShipMaster{
  public ToAddShipMaster() {

  }
  public void toAddShipMaster(){
    int pageHieght=760+50;
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      newtimes.shipping_admin.ShippingAdmin_Const.strIsShipClosed=null;
      newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster pnl =null;
          if( util.PublicVariable.OPERATTING_CENTER.equals("001")||
              util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
             pnl=new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster();
           }else{
             if("BW".equals(util.PublicVariable.OPERATTING_CENTER)||
                "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
                "NTD".equals(util.PublicVariable.OPERATTING_CENTER)){
                if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
                  pnl = new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMasterPwBwLauren();
                }else{
                  pnl = new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMasterPWBW();
                }
             }else{
                pnl =new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMasterNTFE();
                pageHieght=1120;
             }
           }

      pnl.lblShipStaff.setVisible(false);
      pnl.txtShipStaffCode.setVisible(false);
      pnl.setPagedDataFactory(
          newtimes.shipping_admin.ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER
          );

      pnl.setRecord(
          newtimes.shipping_admin.ShippingAdmin_Const.
          SHIPPING_EDITING_HEAD_RECORD
          );

      //pnl.setBounds(0,0,770,680);
      //pnl.setBounds(0,0,770,581);
      //pnl.setBounds(0,0,770,720);
      pnl.setBounds(0,0,774,907+50);
      pnl.setEnableShipExtraPanel(false);

      pnl.lblTItleBar.setText("ADD SHIP MASTER BY S/C:"+
         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO"));

      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer();
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
      jframe.getContentPane().removeAll();
      pnlFunc.removalAddExtralButtons();
      pnlFunc.setButtons(true, false, true, true, false);
      //pnlFunc.setPreferredSize(new java.awt.Dimension(800,590));
      jframe.getContentPane().add(pnlFunc,null);
      pnlFunc.setEditPanel(pnl);
      pnl.record2Gui();
      //pnlFunc.validate();
      //pnlFunc.repaint();
      //pnl.setPreferredSize(new java.awt.Dimension(770, 580));
      pnl.setPreferredSize(new java.awt.Dimension(770, pageHieght));
      pnl.PnlShipExtra.setVisible(false);
      pnl.repaint();
      pnl.validate();
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
      jframe.repaint();
      jframe.validate();
      newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo=null;
    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
