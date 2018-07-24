package newtimes.production.gui.prodmaintain;
import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;
import java.util.Vector;
import newtimes.production.process.prodmaintain.DB_StyleMisc;
public class PnlStyOthersList extends PnlStyMiscList {
  //STY_EXPORT_AGENT, STY_EXPORT_FORWARDER, STY_MILL_COUNTRY_REMARK, STY_MILL_SUPPLIER
  static String DISP_STY_RMK="    STYLE REMARK    ";
  static String CLM_STY_RMK="STY_RMRK";
  static String DISP_BILL_TO="BILL TO";
  static String CLM_BILL_TO="STY_BILL_TO";
  static String DISP_SHIP_TO="SHIP TO";
  static String CLM_SHIP_TO="STY_SHIP_TO";
  static String DISP_MILL_SPLYR="MILL SPPLIER";
  static String CLM_MILL_SPLYR="STY_MILL_SUPPLIER";
  static String DISP_MILL_CNTY_RMK="MILL\nCOUNTRY     \nREMARK";
  static String CLM_MILL_CNTY_RMK="STY_MILL_COUNTRY_REMARK";
  //STY_EXPORT_AGENT, STY_EXPORT_FORWARDER
  static String DISP_XPT_AGNT="EXPORT\nAGENT";
  static String DISP_XPT_FWDR="EXPORT\nFOWARDER";
  static String CLM_XPT_AGNT="STY_EXPORT_AGENT";
  static String CLM_XPT_FWDR="STY_EXPORT_FORWARDER";
  static String DISP_STY_CT_CURRENCY="CT\nCurrency¡¿  ";
  static String DISP_STY_CT_PRICE_TERM="CT\nPrice Term¡¿   ";
  static String DB_STY_CT_CURRENCY="STY_CT_CURRENCY";
  static String DB_STY_CT_PRICE_TERM="STY_CT_PRC_TRM";
  static String DB_STY_CT_DEST="STY_CT_DEST";
  static String DISP_STY_CT_DEST="CT\nPort¡¿     ";


  public PnlStyOthersList() {
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso = new InsertionOrderedHashMap();
    iso.put(DISP_STY_NO, DB_STY_NO);//0
    iso.put(DISP_STY_PO, DB_STY_PO);//1
    iso.put(DISP_STY_CT_PRICE_TERM,DB_STY_CT_PRICE_TERM);//2
    iso.put(DISP_STY_CT_DEST,DB_STY_CT_DEST);//3
    iso.put(DISP_STY_CT_CURRENCY,DB_STY_CT_CURRENCY);//4
    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      iso.put("   INITIAL PO#    ", CLM_STY_RMK);//5
    }else{
      iso.put(DISP_STY_RMK, CLM_STY_RMK);//5
    }
*/
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try{
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
 //     multiEditorJTableInSuper.addTextAreaEditor(4,200);//for style remark
      multiEditorJTableInSuper.addJComboBox(2,
         newtimes.preproduction.guis.tempProperties.tmpPriceTerm
         ,"PRC_TRM","PRC_TRM");
      java.util.Vector dests=
          newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations();
      if(dests.size()>0){
        database.datatype.Record rec=
            (database.datatype.Record)
            util.MiscFunc.deepCopy(dests.get(0));
        rec.set(0,null);
        rec.set(1,"");
        dests.add(rec);
      }
      /*multiEditorJTableInSuper.addJComboBoxEditable(3,
         dests,"dest_name","dest_name",20);*/
     multiEditorJTableInSuper.addJComboBox(3,
        dests,"dest_name","dest_name");


      multiEditorJTableInSuper.addJComboBox(4,
         newtimes.preproduction.guis.tempProperties.tmpCurrency
         ,"CRNCY_NAME","CRNCY_NAME");
       /*
       if(newtimes.production.ProdMaintain_Properties.
          isProductionAuditConfirmedOrPrinted()){
         exgui.MultiClassTableModel mdl=(exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel();
         mdl.removeEditableColumn(DISP_STY_CT_PRICE_TERM);
         mdl.removeEditableColumn(DISP_STY_CT_CURRENCY);
         mdl.removeEditableColumn(DISP_STY_CT_DEST);
        }*/
      getJtable().setRowHeight(50);

      hookInRefineEditor(multiEditorJTableInSuper);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected Hashtable getObject2StringConvertor() {
     Hashtable ht=new Hashtable();
     /*
     Object char20Cnv=
         exgui.verification.CellFormat.getOrdinaryField(20);
     ht.put(DISP_STY_CT_DEST,char20Cnv);
     */
     return ht;
  }

}
