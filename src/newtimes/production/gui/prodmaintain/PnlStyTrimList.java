package newtimes.production.gui.prodmaintain;

import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;

public class PnlStyTrimList extends PnlStyMiscList {
  public PnlStyTrimList() {
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put(DISP_STY_NO,DB_STY_NO);
    iso.put(DISP_STY_PO,DB_STY_PO);

    iso.put("PPK#","STY_TRIM_NO");
    iso.put("CONT#","STY_WEIGHT");
    iso.put("WO# BMS#","STY_HTG_NO1");
    iso.put("LOT#","STY_HTG_NO2");
    iso.put("SIZE GP","STY_HTG_NO3");
    iso.put("RETAIL PRX","STY_TRIM_PRICE");
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    hookInRefineEditor(multiEditorJTableInSuper);
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable iso=new Hashtable();
    iso.put("PPK#",exgui.verification.CellFormat.getOrdinaryField(15));
    iso.put("RETAIL PRX",exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3));
    iso.put("CONT#",exgui.verification.CellFormat.getOrdinaryField(15));
    iso.put("WO# BMS#",exgui.verification.CellFormat.getOrdinaryField(15));
    iso.put("LOT#",exgui.verification.CellFormat.getOrdinaryField(15));
    iso.put("SIZE GP",exgui.verification.CellFormat.getOrdinaryField(15));
    return iso;
  }

}
