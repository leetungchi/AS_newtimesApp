package newtimes.production.gui.prodmaintain;

import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;
import java.util.Vector;
import newtimes.production.process.prodmaintain.DB_StyleMisc;
public class PnlStySewingShop extends PnlStyMiscList {
  //Group 1:orginal
  static String DISP_STY_ORG_DLV="DELIVERY";
  static String DB_STY_ORG_DLV="STY_ORIG_DEL";
  static String DISP_STY_ORG_WAY="W";
  static String DB_STY_ORG_WAY="STY_ORIG_WAY";
  //Group 2:Reconfirm
  static String DISP_STY_RCFM_DLV="DELIVERY ";
  static String DB_STY_RCFM_DLV="STY_RECFM_DEL";
  static String DISP_STY_RCFM_SHIP="W ";
  static String DB_STY_RCFM_SHIP="STY_RECFM_SHIP";
  //Group 3:Weekly updated
  static String DISP_STY_WKLY_DLV=" DELIVERY";
  static String DB_STY_WKLY_DLV="STY_UPDT";
  static String DISP_STY_WKLY_SHIP=" W";
  static String DB_STY_WLKY_SHIP="STY_UPDT_SHIP";
  //Group 4:Off Shore
  static String DISP_STY_OFSHR_DLV="DELIVERY  ";
  static String DB_STY_OFSHR_DLV="STY_OFF_SHORE";
  static String DISP_STY_OFSHR_SHIP="W  ";
  static String DB_STY_OFSHR_SHIP="STY_OFF_SHORE_SHIP";

  public PnlStySewingShop() {
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put(DISP_STY_NO,DB_STY_NO);
    iso.put(DISP_STY_PO,DB_STY_PO);
    //Group 1:orginal
    iso.put(DISP_STY_ORG_DLV,DB_STY_ORG_DLV);
    iso.put(DISP_STY_ORG_WAY,DB_STY_ORG_WAY);
    //Group 2:Reconfirm
    iso.put(DISP_STY_RCFM_DLV,DB_STY_RCFM_DLV);
    iso.put(DISP_STY_RCFM_SHIP,DB_STY_RCFM_SHIP);
    //Group 3:Weekly updated
    iso.put(DISP_STY_WKLY_DLV,DB_STY_WKLY_DLV);
    iso.put(DISP_STY_WKLY_SHIP,DB_STY_WLKY_SHIP);
    //Group 4:Off Shore
    iso.put(DISP_STY_OFSHR_DLV,DB_STY_OFSHR_DLV);
    iso.put(DISP_STY_OFSHR_SHIP,DB_STY_OFSHR_SHIP);
    iso.put("    I    ¡¿","STY_SEWING1");
    iso.put("    II   ¡¿","STY_SEWING2");
    iso.put("    III  ¡¿","STY_SEWING3");
    iso.put("    IV   ¡¿","STY_SEWING4");
    iso.put("    V    ¡¿","STY_SEWING5");
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    try{
      Vector vctSw=((DB_StyleMisc)dbHandler).getSewingShops();
      multiEditorJTableInSuper.setTableColumn2Grp("ORIGINAL",2);
      multiEditorJTableInSuper.setTableColumn2Grp("ORIGINAL",3);
      multiEditorJTableInSuper.setTableColumn2Grp("RECONFIRM",4);
      multiEditorJTableInSuper.setTableColumn2Grp("RECONFIRM",5);
      multiEditorJTableInSuper.setTableColumn2Grp("WEEKLY UPDATED",6);
      multiEditorJTableInSuper.setTableColumn2Grp("WEEKLY UPDATED",7);
      multiEditorJTableInSuper.setTableColumn2Grp("OFF SHORE",8);
      multiEditorJTableInSuper.setTableColumn2Grp("OFF SHORE",9);
      multiEditorJTableInSuper.addJComboBox(10,vctSw,"BYMKR_BRIEF","BYMKR_SEQ");
      multiEditorJTableInSuper.addJComboBox(11,vctSw,"BYMKR_BRIEF","BYMKR_SEQ");
      multiEditorJTableInSuper.addJComboBox(12,vctSw,"BYMKR_BRIEF","BYMKR_SEQ");
      multiEditorJTableInSuper.addJComboBox(13,vctSw,"BYMKR_BRIEF","BYMKR_SEQ");
      multiEditorJTableInSuper.addJComboBox(14,vctSw,"BYMKR_BRIEF","BYMKR_SEQ");
      multiEditorJTableInSuper.setTableColumn2Grp("SEWING SHOP FACTORY",10);
      multiEditorJTableInSuper.setTableColumn2Grp("SEWING SHOP FACTORY",11);
      multiEditorJTableInSuper.setTableColumn2Grp("SEWING SHOP FACTORY",12);
      multiEditorJTableInSuper.setTableColumn2Grp("SEWING SHOP FACTORY",13);
      multiEditorJTableInSuper.setTableColumn2Grp("SEWING SHOP FACTORY",14);
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
      multiEditorJTableInSuper.setColumnUnEditable(DISP_STY_ORG_DLV);
      multiEditorJTableInSuper.setColumnUnEditable(DISP_STY_RCFM_DLV);
      multiEditorJTableInSuper.setColumnUnEditable(DISP_STY_WKLY_DLV);
      multiEditorJTableInSuper.setColumnUnEditable(DISP_STY_OFSHR_DLV);

      hookInRefineEditor(multiEditorJTableInSuper);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable iso=new Hashtable();
    //Group 1:orginal
    Object dateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    iso.put(DISP_STY_ORG_DLV,dateCnv);
    //Group 2:Reconfirm
    iso.put(DISP_STY_RCFM_DLV,dateCnv);
    //Group 3:Weekly updated
    iso.put(DISP_STY_WKLY_DLV,dateCnv);
    //Group 4:Off Shore
    iso.put(DISP_STY_OFSHR_DLV,dateCnv);
    return iso;
  }

}
