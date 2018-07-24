package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.CommandException;
import processhandler.*;
import javax.swing.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrToInitShipMasterByLatterSc extends CommandTrigger {
  newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster pnlMaster;
  public static int processing_prod_head_pk=0;
  public TgrToInitShipMasterByLatterSc(newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster pnl) {
    pnlMaster=pnl;
    processing_prod_head_pk=0;
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    String result=JOptionPane.showInputDialog(
     util.PublicVariable.APP_FRAME,
      "Please Input S/C:","Init BY Default Value",
      JOptionPane.QUESTION_MESSAGE);
    if(result==null)return;
    if(result.trim().length()==0){
      return;
    }
    if(result.trim().length()!="SATWJP500050".length()){
      exgui.verification.VerifyLib.showAlert("S/C Format Error",
                                             "S/C Format Error");
      return;
    }
    /* 2006/10/04
    if(!result.trim().substring(4,6).equalsIgnoreCase(pnlMaster.getProcessingRecord().get(0).toString().substring(4,6))){
      exgui.verification.VerifyLib.showAlert("S/C Dose not belong To Initialize Department Of This SRN",
                                             "S/C Department Mis-Match");
      return;
    }
    */
    String sc_no=util.MiscFunc.Replace(result.trim().toUpperCase(),"'","''");
    try{
      StringBuffer sbGetYear=new StringBuffer();

      sbGetYear.append("select a.PROD_YEAR,b.PROD_SC_PRC_TRM,b.PROD_PYT_TRM,b.PROD_SC_DEST ,");
      sbGetYear.append("b.prod_brnch_brief,b.prod_sc_prc_trm,b.prod_sc_dest,b.prod_tgt_dest ,");
      sbGetYear.append("a.prod_buyer_division,a.prod_season,a.prod_buyer,");
      sbGetYear.append("(select SHIP_RESPONSIBLE_BY from buyer_maker where a.prod_buyer=buyer_maker.BYMKR_SEQ) as SHIP_STAFF_CODE,");
      sbGetYear.append("a.prod_head_pk ");
      sbGetYear.append("from prod_head a,production b ");
      sbGetYear.append("where a.prod_head_pk=b.prod_head_pk ");
      sbGetYear.append("and b.prod_sc_no='");
      sbGetYear.append(sc_no);sbGetYear.append("' and b.record_delete_flag='1' and rownum=1");
      java.util.Vector vctGetProdHeadYear=
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sbGetYear.toString(),1,99999);
       if(vctGetProdHeadYear.size()>0){
         Record tmpProdHeadRec=(Record)vctGetProdHeadYear.get(0);
         pnlMaster.txtShip_Ic_Year.setText((tmpProdHeadRec.get(0)==null?"":tmpProdHeadRec.get(0).toString()));
         pnlMaster.getProcessingRecord().set("SHIP_PRC_TRM",tmpProdHeadRec.get(1));
         pnlMaster.getProcessingRecord().set("SHIP_PRX_TERM_DEST",tmpProdHeadRec.get(3));
         pnlMaster.getProcessingRecord().set("SHIP_PAYMENT_TERM",tmpProdHeadRec.get(2));

         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_agent,tmpProdHeadRec.get("prod_brnch_brief"));
         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_prc_trm,tmpProdHeadRec.get("prod_sc_prc_trm"));
         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_dest,tmpProdHeadRec.get("prod_sc_dest"));
         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_USA_port,tmpProdHeadRec.get("prod_tgt_dest"));
         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_ic_div,tmpProdHeadRec.get("prod_buyer_division"));
         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_ic_sea,tmpProdHeadRec.get("prod_season"));
         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_bill_to,tmpProdHeadRec.get("prod_buyer"));
         pnlMaster.getProcessingRecord().set(pnlMaster.COLUMN_INDEX_ship_ship_to,tmpProdHeadRec.get("prod_buyer"));
         pnlMaster.getProcessingRecord().set("SHIP_STAFF_CODE",tmpProdHeadRec.get("SHIP_STAFF_CODE"));
         processing_prod_head_pk=tmpProdHeadRec.getInt("prod_head_pk");
         pnlMaster.record2Gui();
         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setEditPanel(pnlMaster);

       }else{
         exgui.verification.VerifyLib.showAlert("No Such S/C","S/C# Not Found");
         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setEditPanel(pnlMaster);

       }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Server Side Error\nPlease Contact System Manger",
                                             "Server Side Error");
    }

  }
}
