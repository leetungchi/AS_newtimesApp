package newtimes.shipping_admin.process.shiippingmaintain;

import processhandler.commands.CommandException;
import processhandler.*;
import database.datatype.Record;
import newtimes.shipping_admin.ShipPrxQty.*;
public class TgrAddShipStyle4Lauren extends CommandTrigger {
  public TgrAddShipStyle4Lauren() {
  }
  //public static database.datatype.Record RECORD_SHIP_DETAIL_FROM_ASN=null;
  protected processhandler.template.PnlFieldsEditor   getEditorPanel(){
    return new PnlCplxShipStyle4Lauren();
  }

  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND
      );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    ctnCtl.recordProcess(this);
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      processhandler.template.PnlFieldsEditor   pnl=getEditorPanel();
      jframe.getContentPane().removeAll();
      DB_ShipStyle handler=new DB_ShipStyle(
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);

      Record initRec=handler.getRecordByPk(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT);
      initRec.set("ship_sty_size_column","");
      newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=initRec;
      pnl.setPagedDataFactory(handler);
      pnl.setRecord(initRec);
      pnl.setBounds(0,0,775,850);
      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer();
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;


      pnlFunc.setButtons(true,false, false, false, false);
      pnlFunc.removalAddExtralButtons();
      jframe.getContentPane().add(pnlFunc,null);
      pnl.record2Gui();
      pnlFunc.setEditPanel(pnl);
      pnl.setPreferredSize(new java.awt.Dimension(750, 850));
      pnl.repaint();
      pnl.validate();
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
        Intf_get_Po_Ship_Qty_Pnl pnlToProcess=(Intf_get_Po_Ship_Qty_Pnl)pnl;
        int shipQtyColumnAt=pnlToProcess.getShipQtyPnl().getJtable().getColumnCount()-1;
          //get asn#,find out the color & pack qty to PO's color & qty
          String icDescription=(String)TgrToAddSty2Shipping.RECORD_SHIP_DETAIL_FROM_ASN.get("STY_SC_UP_RMRK");
         ((newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyle4Lauren)pnl).txtShipStyleRemark.setText(
            icDescription
         );
          String asnNo=(String)TgrToAddSty2Shipping.RECORD_SHIP_DETAIL_FROM_ASN.get("ASN_NO");
          StringBuffer sb=new StringBuffer();
          sb.append("select * from ASN_UPLOAD where sty_seq=");
          sb.append(String.valueOf(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ));
          sb.append(" and asn_no='");
          sb.append(util.MiscFunc.Replace(asnNo,"'","''"));
          sb.append("'");

          java.util.Vector vctAsnData=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
            sb.toString(),1,99999);
             java.util.HashMap hmColorNameAndPackQty=new java.util.HashMap();
             for(int i=0;i<vctAsnData.size();i++){
                 Record recAsn=(Record)vctAsnData.get(i);
                 String colorDesc=(String)recAsn.get("COLOR_DESC");
                 Object objPackQty=recAsn.get("PACK_QTY");
                 hmColorNameAndPackQty.put(colorDesc,(objPackQty==null)?"0":objPackQty.toString());
             }

          if(pnlToProcess.getShipQtyPnl().getJtable().getRowCount()==1){
            Record recAsn=(Record)vctAsnData.get(0);
            pnlToProcess.getShipQtyPnl().getJtable().setValueAt(recAsn.get("PACK_QTY"),
                0, shipQtyColumnAt);
          }else{
            for(int i=0;i<pnlToProcess.getShipQtyPnl().getJtable().getRowCount();i++){
              exgui.ultratable.Wraper4tblCbx cbxObj=(exgui.ultratable.Wraper4tblCbx)pnlToProcess.getShipQtyPnl().getJtable().getValueAt(i,0);
              String colorName=cbxObj.toString();
              if(hmColorNameAndPackQty.containsKey(colorName)){
                pnlToProcess.getShipQtyPnl().getJtable().setValueAt(hmColorNameAndPackQty.get(colorName),i,shipQtyColumnAt);
              }else{
              }
            }

          }
      jframe.repaint();
      jframe.validate();

    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }

}
