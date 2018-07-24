package newtimes.preproduction.process;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToEditPrePrdColorLib extends ToInitUperAndDownPnl implements
    AbleToEditPrePrdColorLib{
      String columns[]={ "CLIB_DYER","CLIB_MTRDTL_PK","CLIB_LOCK",
                        "CLIB_COLOR_CODE","CLIB_COLOR_NAME","CLIB_LABDIP_LAB_REF",
                        "CLIB_LABDIP_DUPS_CLR_APVL","CLIB_LABDIP_BULK_CLR_APVL",
                        "CLIB_DUPS_USD_PRX","CLIB_BULK_LOCAL_PRX",
                        "CLIB_DUPS_LD_ACT_APRV","CLIB_BULK_LD_ACT_APRV",
                        "CLIB_LD_ACT_SEND","CLIB_DUPS_LOT_ACT_SEND",
                        "CLIB_DUPS_LOT_ACT_APRV","CLIB_BULK_LOT_ACT_SEND",
                        "CLIB_BULK_LOT_ACT_APRV","CLIB_QNTY_NY1",
                        "CLIB_QNTY_NY2","CLIB_QNTY_BTL","CLIB_QNTY_CDA1",
                        "CLIB_QNTY_CDA2","CLIB_DEL_NY1",
                        "CLIB_DEL_NY2","CLIB_DEL_BTL",
                        "CLIB_REMARK","CLIB_PI_QTY",
                        "CLIB_SHIP_YIELD","CLIB_DUPS_FAB_QTY",
                        "CLIB_BULK_FAB_QTY"};

  public ToEditPrePrdColorLib() {

  }
  protected void copyColumns(Record recSrc,Record recDst)throws Exception{
     for(int i=0;i<columns.length;i++){
         String tgtKlm=columns[i];
         recDst.set("P"+tgtKlm,recSrc.get(tgtKlm));
     }
  }
  public void toEditPrePrdColorLib()throws Exception{
    //common process to set cursor...
    try{
     setPreProdDisplayer();
     DB_PreProdColorLib db=DB_PreProdColorLib.getInstance();
     if(newtimes.preproduction.Constants.SELECTED_ORG_COLOR_LIB_RECORD !=null){
       Record srcBlankRec=(Record)util.MiscFunc.deepCopy(newtimes.preproduction.Constants.SELECTED_ORG_COLOR_LIB_RECORD);
       Record dstBlankRec=db.getBlankRecord();
       copyColumns(srcBlankRec,dstBlankRec);
       db.editingRecord=dstBlankRec;
       newtimes.preproduction.Constants.SELECTED_ORG_COLOR_LIB_RECORD=null;
     }
      newtimes.preproduction.guis.PnlPreProdColorEditor    pnl=
          new newtimes.preproduction.guis.PnlPreProdColorEditor();
      pnl.setPagedDataFactory(db);
      pnl.setRecord(db.editingRecord);
      toSetPanelUnderButtons(pnl);
      pnl.record2Gui();
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.3);
      processhandler.template.Properties.getSplitFrame().repaint();

      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
        false,true,true,true,false,true);
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(true);
      */
    }finally{
      //jframe.getContentPane().setCursor(ksr);
    }

  }
}
