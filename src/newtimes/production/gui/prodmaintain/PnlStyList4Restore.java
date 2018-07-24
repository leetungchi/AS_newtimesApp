package newtimes.production.gui.prodmaintain;
import exgui.ultratable.*;
import database.datatype.Record;

public class PnlStyList4Restore extends PnlStyleList {
  protected boolean checked=false;
  public PnlStyList4Restore() {
    super();
    getLowerRightPanel().removeAll();
    getPanelContainsButtons().removeAll();
  }
  public void mouseClicked(java.awt.event.MouseEvent e){
  }
  public void mouseEntered(java.awt.event.MouseEvent e){

  }
  public void mouseExited(java.awt.event.MouseEvent e){

  }
  public void mousePressed(java.awt.event.MouseEvent e){

  }
  public void mouseReleased(java.awt.event.MouseEvent e){

  }

  public util.InsertionOrderedHashMap getHeadColumnMap(){
    /*
    UNIT_COLUMN_AT=5;
    CAT_DATA_COLUMN_AT=2;
    QTY_COLUMN_AT=3;
    STY_NO_CLUMN_AT=-1;*/
    MKR_DISCT_PC_AT=-1;
    BYR_DISCT_PC_AT=-1;
    MKR_DISCT_DZ_AT=-1;
    BYR_DISCT_DZ_AT=-1;
    MKR_DISCT_LUMPSUM_AT=-1;
    BYR_DISCT_LUMPSUM_AT=-1;
    BYR_COMM_PER_AT=-1;
    MKR_DISCT_PER_AT=-1; BARCODE_COLUMN_AT=-1;BUYER_LABEL_COLUMN_AT=-1;


   if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
     newtimes.production.gui.prodmaintain.PnlStyleList.UNIT_COLUMN_AT=7;
     newtimes.production.gui.prodmaintain.PnlStyleList.CAT_DATA_COLUMN_AT=4;
     newtimes.production.gui.prodmaintain.PnlStyleList.QTY_COLUMN_AT=5;
     newtimes.production.gui.prodmaintain.PnlStyleList.STY_NO_CLUMN_AT=3;
   }else{
      newtimes.production.gui.prodmaintain.PnlStyleList.UNIT_COLUMN_AT=6;
      newtimes.production.gui.prodmaintain.PnlStyleList.CAT_DATA_COLUMN_AT=3;
      newtimes.production.gui.prodmaintain.PnlStyleList.QTY_COLUMN_AT=4;
      newtimes.production.gui.prodmaintain.PnlStyleList.STY_NO_CLUMN_AT=-1;
   }

    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("Restore","record_delete_flag");//0
    iso.put(DISP_STY_STYLE,DB_STY_STYLE);//1
    iso.put(DISP_STY_PO,DB_STY_PO);//2
    if(STY_NO_CLUMN_AT!=-1){
      iso.put(DISP_STY_NO,DB_STY_NO);
    }
    iso.put(DISP_STY_QTA,DB_STY_QTA);//4
    iso.put(" QTY ",DB_STY_QTY);//5
    iso.put(DISP_STY_UNIT,DB_STY_UNIT);//6

    iso.put(DISP_BYR_DOC_PRX,DB_BYR_DOC_PRX);
    BYR_DOC_PRX_AT =iso.entrySet().size()-1;
    iso.put(DISP_BYR_ACT_PRX,DB_BYR_ACT_PRX);
    BYR_ACT_PRX_AT =iso.entrySet().size()-1;

    iso.put(DISP_MKR_DOC_PRX,DB_MKR_DOC_PRX);
    MKR_DOC_PRX_AT =iso.entrySet().size()-1;
    iso.put(DISP_MKR_ACT_PRX,DB_MKR_ACT_PRX);
    MKR_ACT_PRX_AT =iso.entrySet().size()-1;

    //iso.put(DISP_STY_CMT_RPX,DB_STY_CMT_PRX);


    try{
      if (util.PublicVariable.USER_RECORD.getInt("USR_TYPE") == newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS &&
          util.PublicVariable.OPERATTING_CENTER.equals("001")) {
        iso.put(DISP_STY_BUY_COMM, DB_STY_BUY_COMM);
        iso.put(DISP_STY_MKR_DISC, DB_STY_MKR_DISC);
        iso.put(DISP_STY_MKR_DSCT_PC, DB_STY_MKR_DSCT_PC);
        iso.put(DISP_STY_MKR_DSCT_DZ, DB_STY_MKR_DSCT_DZ);
        iso.put(DISP_STY_MKR_DSCT_LUMP_SUM, DB_STY_MKR_DSCT_LUMP_SUM);
      }
    }catch(Exception exp){
         exp.printStackTrace();
    }

    //STY_YY1, STY_YY2, STY_YY3
    /*
    iso.put(DISP_STY_YY1,DB_STY_YY1);
    iso.put(DISP_STY_YY2,DB_STY_YY2);
    iso.put(DISP_STY_YY3,DB_STY_YY3);
    iso.put(DISP_STY_YY4,DB_STY_YY4);
    iso.put(DISP_STY_CT_PRICE_TERM,DB_STY_CT_PRICE_TERM);
    iso.put(DISP_STY_CT_CURRENCY,DB_STY_CT_CURRENCY);
    */
    return iso;
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    Boolean blValue=(Boolean)value2update;
    try{
      if (blValue.booleanValue()) {
        rec.set("record_delete_flag", "1");
      }
      else {
        rec.set("record_delete_flag", "0");
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    checked=true;
    return rec;
  }
  public int getEachPageRowCount(){
    return 9999;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    //super.refineEditors(multiEditorJTableInSuper);
    multiEditorJTableInSuper.addCheckbox(0,"1");
    exgui.MultiClassTableModel mdl=
        (exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel();
    mdl.removeEditableColumn(DISP_STY_NO);
    mdl.removeEditableColumn(DISP_STY_PO);
    mdl.removeEditableColumn(DISP_STY_QTA);
    mdl.removeEditableColumn(DISP_STY_QTY);
    //STY_BUY_COMM, STY_MKR_DSCT_PER, STY_MKR_DSCT_PC,
    //STY_MKR_DSCT_DZ, STY_CMT_PRICE, , STY_YY4, STY_QTA_CAT
    try{
      if (util.PublicVariable.USER_RECORD.getInt("USR_TYPE") ==  newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
          && util.PublicVariable.OPERATTING_CENTER.equals("001")) {
        mdl.removeEditableColumn(DISP_STY_BUY_COMM);
        mdl.removeEditableColumn(DISP_STY_MKR_DISC);
        mdl.removeEditableColumn(DISP_STY_MKR_DSCT_PC);
        mdl.removeEditableColumn(DISP_STY_MKR_DSCT_DZ);
        mdl.removeEditableColumn(DISP_STY_MKR_DSCT_LUMP_SUM);
      }
    }catch(Exception e){
      e.printStackTrace();
    }

    mdl.removeEditableColumn(DISP_STY_CMT_RPX);
    mdl.removeEditableColumn(DISP_STY_FOB_RPX);
    mdl.removeEditableColumn(DISP_STY_UNIT);
    //STY_YY1, STY_YY2, STY_YY3
    /*
    mdl.removeEditableColumn(DISP_STY_YY1);
    mdl.removeEditableColumn(DISP_STY_YY2);
    mdl.removeEditableColumn(DISP_STY_YY3);
    mdl.removeEditableColumn(DISP_STY_YY4);
    mdl.removeEditableColumn(DISP_STY_CT_PRICE_TERM);
    mdl.removeEditableColumn(DISP_STY_CT_CURRENCY);
    */
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    dbHandler=new newtimes.production.process.prodmaintain.DB_StyleListHandler(true);
    return dbHandler;
  }

  public void doUpdate(){
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      java.util.Vector vct2restore=new java.util.Vector();
      for(int i=0;i<getJtable().getRowCount();i++){
        if (((Boolean)getJtable().getValueAt(i, 0)).booleanValue()) {
         Record rec2update=(Record)getDisplayingRecords().get(i);
         rec2update.set("record_delete_flag","1");
         vct2restore.add(rec2update);
        }
      }
      Record recProd = newtimes.preproduction.Constants.
          CURRENT_PREPROD_HEAD_RECORD;
      if (recProd.getInt("record_delete_flag") == 0||recProd.get("prod_sc_no")!=null) {
        //((newtimes.production.process.prodmaintain.DB_StyleListHandler)dbHandler).restoreStyles(super._records2Update);
        ((newtimes.production.process.prodmaintain.DB_StyleListHandler)dbHandler).restoreStyles(vct2restore);
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set(
            "record_delete_flag", "1");
         table_snapshot=util.MiscFunc.table2Text(getJtable());
        //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
        this.reload();
      }else {
        super.doUpdate();
      }
    }catch(Exception e){
       //throw e;
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"");
       exgui.verification.VerifyLib.showAlert("Error While Restore Style Records\nPlease Constact System Manager",
                                              "Error While Restore Style Records");
    }finally{
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
