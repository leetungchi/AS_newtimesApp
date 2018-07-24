package newtimes.shipping_admin.process.shiippingmaintain;
import database.datatype.*;
import java.util.*;
import newtimes.shipping_admin.ShipPrxQty.Intf_get_Po_Ship_Qty_Pnl;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToAddStyle2Shipping4Asn {
  public ToAddStyle2Shipping4Asn() {
  }
  public void Add2Asn(){
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      processhandler.template.PnlFieldsEditor   pnl=new newtimes.shipping_admin.ShipPrxQty.PnlGhostGui4AsnDtl();
      DB_ShipStyle handler=new DB_ShipStyle(
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);
      Record initRec=handler.getRecordByPk(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT);
        initRec.set("ship_sty_size_column","");
      newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=initRec;
      pnl.setPagedDataFactory(handler);
      pnl.setRecord(initRec);
      pnl.setBounds(0,0,775,850);
      pnl.record2Gui();
      if(pnl instanceof newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW){
        //for pw center,have to use the last stored invoice description context
         ((newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW)pnl).txtShipStyleRemark.setText(
           (newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.memory_inv_desc_context==null)?"":
           newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.memory_inv_desc_context
         );
      }
      pnl.setPreferredSize(new java.awt.Dimension(750, 850));

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
           newtimes.shipping_admin.ShipPrxQty.PnlLIstShipPrxQty  pnlship=
               ((Intf_get_Po_Ship_Qty_Pnl)pnl).getShipQtyPnl();
           if(pnlship.getDisplayingRecords().size()==1){
             Record recAsn=(Record)vctAsnData.get(0);
             ((Record)pnlship.getDisplayingRecords().get(0)).set("QTY_TTL",recAsn.get("PACK_QTY"));
           }else{
             for (int i = 0; i < pnlship.getDisplayingRecords().size(); i++) {
                 Record recClrPrxQty=(Record)pnlship.getDisplayingRecords().get(i);
                 String colorName=(String)recClrPrxQty.get("PROD_COLOR_NAME");
                 ((Record)pnlship.getDisplayingRecords().get(i)).set("QTY_TTL",hmColorNameAndPackQty.get(colorName));
             }
           }

          pnl.repaint();
          pnl.validate();
         pnl.doAddNew();

    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
