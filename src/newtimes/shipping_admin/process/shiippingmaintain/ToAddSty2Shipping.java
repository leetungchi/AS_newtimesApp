package newtimes.shipping_admin.process.shiippingmaintain;
import database.datatype.Record;
import newtimes.shipping_admin.ShipPrxQty.*;
public class ToAddSty2Shipping implements AbleToAddSty2Shipping{
  public ToAddSty2Shipping() {

  }
  public void toAddSty2Shipping(){
    toAddSty2Shipping1115();
    /*
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
     toAddSty2Shipping1115();
     return;
    }

    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle  pnl=
          new newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle();
      jframe.getContentPane().removeAll();
      DB_ShipStyle handler=new DB_ShipStyle(
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);

      Record initRec=handler.getRecordByPk(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT);

      String sizeColumn=newtimes.shipping_admin.ShippingAdmin_Const.recnvDblCamaString(
       (String)initRec.get("_$org_sty_size_column"));
      initRec.set("_$org_sty_size_column",sizeColumn);
      newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=initRec;
      pnl.setPagedDataFactory(handler);
      pnl.setRecord(initRec);
      pnl.setBounds(0,0,775,700);
      //pnl.PnlShipExtra.setEnabled(true);

      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer();
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;

      //pnlFunc.setButtons(false, true, false, false, true);
      //pnlFunc.btnConfirm.setText("Confirm Edit Conmission");

      pnlFunc.setButtons(false,true, false, false, false);
      pnlFunc.btnConfirm.setText("Confirm Edit Commission");
      pnlFunc.removalAddExtralButtons();


      //pnlFunc.setPreferredSize(new java.awt.Dimension(800,590));
      jframe.getContentPane().add(pnlFunc,null);
      pnl.record2Gui();
      pnlFunc.setEditPanel(pnl);
      //pnlFunc.validate();
      //pnlFunc.repaint();
      pnl.setPreferredSize(new java.awt.Dimension(750, 850));
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
    }*/
  }
  protected processhandler.template.PnlFieldsEditor   getEditorPanel(){
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
       newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW pnl2return=
       new newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW();
      return pnl2return;
    }
    return new newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyleFE();
  }

  public void toAddSty2Shipping1115(){
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      processhandler.template.PnlFieldsEditor   pnl=getEditorPanel();
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


      pnlFunc.setButtons(true,false, false, false, false);
      pnlFunc.removalAddExtralButtons();
      if(util.PublicVariable.OPERATTING_CENTER.equals("BW")||
         util.PublicVariable.OPERATTING_CENTER.equals("PW")){

        pnlFunc.addTriggerButton("To Enquiry",
                                 new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());

        pnlFunc.addTriggerButton("PRINT SRN",
                                 new newtimes.shipping_admin.process.
                                 shiippingmaintain.TgrToReportUnit()
                                 );
      }


     /*
      pnlFunc.addTriggerButton("List Detail",
           new newtimes.shipping_admin.process.shiippingmaintain.TgrToListAddedStyles());
      */
      //pnlFunc.setPreferredSize(new java.awt.Dimension(800,590));
      jframe.getContentPane().add(pnlFunc,null);
      pnl.record2Gui();
      if(pnl instanceof newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW){
        //for pw center,have to use the last stored invoice description context
         ((newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW)pnl).txtShipStyleRemark.setText(
           (newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.memory_inv_desc_context==null)?"":
           newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.memory_inv_desc_context
         );
      }
      pnlFunc.setEditPanel(pnl);
      //pnlFunc.validate();
      //pnlFunc.repaint();
      pnl.setPreferredSize(new java.awt.Dimension(750, 850));
      pnl.repaint();
      pnl.validate();
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();

      if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
        Intf_get_Po_Ship_Qty_Pnl pnlToProcess=(Intf_get_Po_Ship_Qty_Pnl)pnl;
        int qtyRowCount=pnlToProcess.getPoQtyPnl().getJtable().getRowCount();
        int qtyColoumnAt=pnlToProcess.getPoQtyPnl().getJtable().getColumnCount()-1;
        int shipQtyColumnAt=pnlToProcess.getShipQtyPnl().getJtable().getColumnCount()-1;
        if(!newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
          for (int i = 0; i < qtyRowCount; i++) {
            Object objBalanceQty = pnlToProcess.getPoQtyPnl().getJtable().
                getValueAt(i, qtyColoumnAt);
            pnlToProcess.getShipQtyPnl().getJtable().setValueAt(objBalanceQty,
                i, shipQtyColumnAt);
          }
        }else{
          //get asn#,find out the color & pack qty to PO's color & qty
          String icDescription=(String)TgrToAddSty2Shipping.RECORD_SHIP_DETAIL_FROM_ASN.get("STY_SC_UP_RMRK");
         ((newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW)pnl).txtShipStyleRemark.setText(
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



        }

       /*
        int qtyRowCount=pnl.pnlPoQty.getJtable().getRowCount();
        int qtyColoumnAt=pnl.pnlPoQty.getJtable().getColumnCount()-1;
        int shipQtyColumnAt=pnl.pnlShipPrxQty.getJtable().getColumnCount()-1;
        for(int i=0;i<qtyRowCount;i++){
          Object objBalanceQty=pnl.pnlPoQty.getJtable().getValueAt(i,qtyColoumnAt);
          pnl.pnlShipPrxQty.getJtable().setValueAt(objBalanceQty,i,shipQtyColumnAt);
        }

        */
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
