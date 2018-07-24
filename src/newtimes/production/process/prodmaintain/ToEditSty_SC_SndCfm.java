package newtimes.production.process.prodmaintain;
import newtimes.preproduction.process.*;
import database.datatype.Record;
public class ToEditSty_SC_SndCfm
     extends ToInitUperAndDownPnl
    implements AbleToEditSty_SC_SndCfm{
  public ToEditSty_SC_SndCfm() {

  }
  public static boolean isDataReady()throws Exception{
    //test if production can be send confirmed.only at status
     boolean isTpeUser=
         ((String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE")).equalsIgnoreCase("001");
     Record prod_record =
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD;
     Record productionRecord=
       newtimes.production.process.prodmaintain.DB_ProdSC.getInstanceOfProdSCHandler().getRecordByPk(
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
     /*
     Object buyComm_to_fill=null;
     Object buyCommPc_to_fill=null;
     Object buyCommDz_to_fill=null;
     Object buyLumpSum_to_fill=null;
     java.util.Vector style2Update=(!isTpeUser)?null:(new java.util.Vector());
     */
     if(prod_record.get("PROD_CEN_CODE")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"Center\" for this production"
                                              ,
                                              "Column not assigned yet");
       return false;
     }
     if(prod_record.get("PROD_DEPTMENT")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"Department\" for this production",
                                              "Column not assigned yet");
       return false;
     }
     if(prod_record.get("PROD_MNG_CODE")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"Manager\" for this production",
                                              "Column not assigned yet");
       return false;
     }
     if(prod_record.get("PROD_BUYER")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"Buyer\" for this production",
                                              "Column not assigned yet");
       return false;
     }
     if(isTpeUser){
           Object objDiv=prod_record.get("PROD_BUYER_DIVISION");
           java.util.Vector vct=null;
           //BUY_COMM, BUY_COMM_PC, BUY_COMM_DZ, BUY_COMM_LUMP_SUM
           if(objDiv!=null){
             vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
              "select BUY_COMM, BUY_COMM_PC, BUY_COMM_DZ, BUY_COMM_LUMP_SUM from division where DIV_CODE='"+
              objDiv.toString() +"' and record_delete_flag=1",1,1);

           }else{
            Object objBuyerSeq= prod_record.get("PROD_BUYER");
             vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
              "select BUY_COMM, BUY_COMM_PC, BUY_COMM_DZ, BUY_COMM_LUMP_SUM from buyer_maker where BYMKR_SEQ='"+
               objBuyerSeq.toString() +"' and record_delete_flag=1",1,1);
           }
           /*
           Record rec=(Record)vct.get(0);
           buyComm_to_fill=rec.get(0);
           buyCommPc_to_fill=rec.get(1);
           buyCommDz_to_fill=rec.get(2);
           buyLumpSum_to_fill=rec.get(3);

           Object tmp=rec.get(0);
           buyComm_to_fill=(tmp==null)?0:(Float.parseFloat((tmp.toString().trim().length()==0)?"0":tmp.toString()));
           tmp=rec.get(1);
           buyCommPc_to_fill=(tmp==null)?0:(Float.parseFloat((tmp.toString().trim().length()==0)?"0":tmp.toString()));
           tmp=rec.get(2);
           buyCommDz_to_fill=(tmp==null)?0:(Float.parseFloat((tmp.toString().trim().length()==0)?"0":tmp.toString()));
           tmp=rec.get(3);
           buyLumpSum_to_fill=(tmp==null)?0:(Float.parseFloat((tmp.toString().trim().length()==0)?"0":tmp.toString()));
          */
     }
    Object prdType=productionRecord.get("PROD_TYPE");
    if(prdType.toString().equalsIgnoreCase("W")||
       prdType.toString().equalsIgnoreCase("K")||
       prdType.toString().equalsIgnoreCase("S")){
      if (prod_record.get("PROD_SEASON") == null) {
        exgui.verification.VerifyLib.showAlert(
            "Please Assign \"Season\" for this production",
            "Column not assigned yet");
        return false;
      }
      if (prod_record.get("PROD_YEAR") == null) {
        exgui.verification.VerifyLib.showAlert(
            "Please Assign \"Year\" for this production",
            "Column not assigned yet");
        return false;
      }
    }

     //as HK user's requirement,skip checking of maker and qc country.
     if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       if (prod_record.get("Prod_Maker") == null) {
         exgui.verification.VerifyLib.showAlert(
             "Please Assign \"MAKER\" for this production",
             "Column not assigned yet");
         return false;
       }

       if (productionRecord.get("PROD_QC_CNTY") == null) {
         exgui.verification.VerifyLib.showAlert(
             "Please Assign \"QC Country\" for this production",
             "Column not assigned yet");
         return false;
       }
     }

     if(productionRecord.get("PROD_PYT_TRM")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"Payment Term\" for this production",
                                              "Column not assigned yet");
       return false;
     }
     if(productionRecord.get("PROD_BRNCH_BRIEF")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"Branch\" for this production",
                                              "Column not assigned yet");
       return false;
     }
     if(productionRecord.get("PROD_SC_PRC_TRM")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"SC Price Term\" for this production",
                                              "Column not assigned yet");
       return false;
     }
     if(productionRecord.get("PROD_SC_DEST")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"SC Destination\" for this production",
                                              "Column not assigned yet");
       return false;
     }
     if(productionRecord.get("PROD_SC_CURRENCY")== null) {
       exgui.verification.VerifyLib.showAlert("Please Assign \"SC Currency\" for this production",
                                              "Column not assigned yet");
       return false;
     }

     //list all the style record,check one by one
     newtimes.production.process.prodmaintain.DB_StyleMisc stylesHdl
         =new newtimes.production.process.prodmaintain.DB_StyleMisc();
     java.util.Vector styleRecords=stylesHdl.getRecords(1,99999);
     if(styleRecords.size()==0){
       exgui.verification.VerifyLib.showAlert("There is not Styles To Send Confirm","NO Data To Confirm");
       return false;
     }
     for(int i=0;i<styleRecords.size();i++){
       Record recSty = (Record) styleRecords.get(i);
       //get STY_STYLE, STY_PO as title of this style record
       String sty_STYLE_String = (String) recSty.get("STY_STYLE");
       if(sty_STYLE_String==null){
         exgui.verification.VerifyLib.showAlert("\"Style\" is not assigned yet",
                                                "Column Not Assigned yet");
         return false;
       }
       String sty_PO_String = (recSty.get("STY_PO")==null)?"":recSty.get("STY_PO").toString();
       String sty_TITLE = "STYL:" + sty_STYLE_String + " PO:" + sty_PO_String;
       if(recSty.get("STY_CT_PRC_TRM")==null){
         exgui.verification.VerifyLib.showAlert("Please Assign \"C/T PRICE TERM\" for "+sty_TITLE,
                                                "Column Not Assigned yet");
         return false;
       }
       if(recSty.get("STY_CT_DEST")==null){
         exgui.verification.VerifyLib.showAlert("Please Assign \"C/T DESTINATION\" for "+sty_TITLE,
                                                "Column Not Assigned yet");
         return false;
       }

       if(recSty.get("STY_CT_CURRENCY")==null){
         exgui.verification.VerifyLib.showAlert("Please Assign \"C/T CURRENCY\" for "+sty_TITLE,
                                                "Column Not Assigned yet");
         return false;
       }
       Object objTtlOdrQty=recSty.get("sty_total_qty");//recSty.get("total_order_qty");
       float totlQdrQty=(objTtlOdrQty==null)?0:Float.parseFloat(objTtlOdrQty.toString());
       if(totlQdrQty<=0){
         exgui.verification.VerifyLib.showAlert("Please Assign \"Quantity\" for "+sty_TITLE,
                                                "Column Not Assigned yet");
         return false;
       }
       //Object prdType=productionRecord.get("PROD_TYPE");
       //String prdTypeStr=(prdType==null)?"":prdType.toString().toUpperCase().trim();
       /*
        (19)	3울1 (ORIG DEL(STYLE.STY_ORIG_DEL),RECFM DEL(STYLE. STY_RECFM_DEL),WEEKLY UPDT (STYLE. STY_UPDT)for product type is WEAVON,KNIT,SWEATER,ⓧⅵPRODUCTION TYPE쳂촑メ짨ぬ울�@)
        (20)	3 울 1 (ORIG WAY(STYLE.STY_ORIG_WAY),RECFM WAY(STYLE. STY_RECFM_SHIP), WEEKLY WAY(STYLE.STY_UPDT_SHIP),쪷첿)
        (21)	BUY-COMM (STYLE.STY_BUY_COMM)
        (22)	4울 1(MAKER DISCOUNT %(STYLE.STY_MKR_DSCT_PER, STYLE.STY_MKR_DSCT_PC, STYLE.STY_MKR_DSCT_DZ, STY_MKR_DSCT_LUMP_SUM))


       if(prdTypeStr.equals("W")||
          prdTypeStr.equals("K")||
          prdTypeStr.equals("S")){
       }*/
       if(recSty.get("STY_UPDT")==null &&
          recSty.get("STY_RECFM_DEL")==null &&
          recSty.get("STY_ORIG_DEL")==null){
         exgui.verification.VerifyLib.showAlert("Please Assign: \"Updated Date\" \n" +
                                                  "or \"Reconfirm Delivery Date\" \n"+
                                                  "or \"Orignal Delivery Date\" for "+sty_TITLE,
                                                "Column Not Assigned yet");
         return false;
       }
       //check maker delivery date. STY_MKR_DEL
       if(recSty.get("STY_MKR_DEL")==null){
         exgui.verification.VerifyLib.showAlert("Please Assign: \"Maker Delivery Date"+
                                                  " for "+sty_TITLE,
                                                "Column Not Assigned yet");
         return false;
       }

       if(recSty.get("STY_UPDT_SHIP")==null &&
          recSty.get("STY_RECFM_SHIP")==null &&
          recSty.get("STY_ORIG_WAY")==null){
         exgui.verification.VerifyLib.showAlert("Please Assign: \"Updated Shipping Method\"\n" +
                                                  "or \"Reconfirm Shipping Method\"\n"+
                                                  "or \"Orignal Shipping Method\" for "+sty_TITLE,
                                                "Column Not Assigned yet");
         return false;
       }
       if(recSty.get("STY_UNIT")==null){
         exgui.verification.VerifyLib.showAlert("Please Assign \"UNIT\" for "+sty_TITLE,
                                                "Column not assigned yet");
         return false;
       }
       /*
       if(isTpeUser){
           //Record rec2update=(Record)util.MiscFunc.deepCopy(recSty);
           //STY_BUY_COMM, STY_BUY_DSCT_PC, STY_BUY_DSCT_DZ, STY_BUY_DSCT_LUMP_SUM
           recSty.set("STY_BUY_COMM",buyComm_to_fill);
           recSty.set("STY_BUY_DSCT_PC",buyCommPc_to_fill);
           recSty.set("STY_BUY_DSCT_DZ",buyCommDz_to_fill);
           recSty.set("STY_BUY_DSCT_LUMP_SUM",buyLumpSum_to_fill);
           style2Update.add(recSty);
       }*/
     }
   //while ever thing check ok,make sure TPE user's styles' commission is co-responding to buyer & commission
    /*
    if(isTpeUser){
      stylesHdl.updateRecords(style2Update);
    }*/
   return true;
 }
 public void toEditSty_SC_SndCfm()throws processhandler.commands.CommandException,
                                         processhandler.commands.CommandIncompleteException{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      if(!isDataReady()) throw new processhandler.commands.CommandIncompleteException();
      newtimes.production.gui.prodmaintain.PnlSC_CT_SndCnfm  pnl =
          new newtimes.production.gui.prodmaintain.PnlSC_CT_SndCnfm(
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      StringBuffer sb=new StringBuffer();
      sb.append("=====  S/C DRAFT  ====");

      /*
      addLowerPanel(sb.toString(),pnl);
      super.setFunctionButtonStatus(false,false,false,false,false,false);
      }*/
      toSetPanelUnderButtons(pnl,sb.toString());
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, false, false, false,false,false);
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      */
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
    }catch(processhandler.commands.CommandIncompleteException cie){
      throw cie;
    }catch(Exception e){
      throw new processhandler.commands.CommandException(e.getMessage());
   }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }

  }
}
