package newtimes.shipping_admin.ShipPrxQty;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlGhostGui4AsnDtl extends PnlCplxShipStylePW{
  public PnlGhostGui4AsnDtl() {
    super();
  }
  public boolean isOverShip(){return false;}
  public boolean checkShipCommision(){return true;}
  public void doUpdate(boolean isAddNew)throws Exception{
    isGui2RecordOk=gui2Record();
    int orgPK=recToMapping.getInt(0);
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      try{

        //test if to update...
        if(orgPK>0){
          recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
          //recToMapping.set("SHIP_QTY_DESC",txtShipQtyDesc.getText());
        }
        //recToMapping=((newtimes.shipping_admin.process.shiippingmaintain.DB_ShipStyle)dbprc).updateRecord(recToMapping);
        //record2Gui();
        if(isOverShip()){
          return;
        }
        //pnlShipPrxQty.doUpdate();
        pnlShipPrxQty.getJtable().changeSelection(0,0,false,false);
        recToMapping=((PrxQtyHandler)pnlShipPrxQty.getPagedDataFactory()).finalUpdate();
        pnlShipPrxQty.ismodified=false;
        recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
        newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT=recToMapping.getInt(0);
        newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=recToMapping;

        if(isAddNew){

          updatePnlListStyles2AddHashMap(recToMapping);
          String asnNo=(String)newtimes.shipping_admin.process.shiippingmaintain.TgrToAddSty2Shipping.RECORD_SHIP_DETAIL_FROM_ASN.get("ASN_NO");
          String vendorinv_no=(String)newtimes.shipping_admin.process.shiippingmaintain.TgrToAddSty2Shipping.RECORD_SHIP_DETAIL_FROM_ASN.get("vendorinv_no");
          String keStr=recToMapping.get("Sty_seq").toString()+"||"+vendorinv_no+"||"+asnNo;
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS.put(
          keStr,String.valueOf(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT));
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED.remove(keStr);

        }else{
        }
        //recToMapping.getModifiedFields().clear();
        //doExit();
        /*
        if(isAddNew){
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
                 new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle());

        }*/
      }catch(Exception e){
        //e.printStackTrace();
        throw e;
      }finally{
        util.MiscFunc.hideProcessingMessage();
         newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
      util.MiscFunc.hideProcessingMessage();

  }

}
