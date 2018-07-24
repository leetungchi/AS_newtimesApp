package newtimes.production.gui.prodmaintain;
import newtimes.production.gui.prodmaintain.PnlStyMiscList;
import newtimes.production.process.prodmaintain.DB_StyleMisc;
import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;
import java.util.Vector;

public class PnlStyWashList extends PnlStyMiscList {
  public PnlStyWashList() {
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put(DISP_STY_NO,DB_STY_NO);
    iso.put(DISP_STY_PO,DB_STY_PO);
    iso.put("  WASH MILL¡¿  ","STY_WASH_MILL");
    iso.put("  WASH PRICE ","STY_WASH_PRX");
    iso.put("    WASH REMARK     ","STY_WASH_RMRK");
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try{
       Vector vctWashMill=((DB_StyleMisc)dbHandler).getWashMiller();
       multiEditorJTableInSuper.addJComboBox(2,vctWashMill,"BYMKR_BRIEF","BYMKR_SEQ");
       multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
       multiEditorJTableInSuper.addTextAreaEditor(4,200);
       hookInRefineEditor(multiEditorJTableInSuper);
       getJtable().setRowHeight(50);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected Hashtable getObject2StringConvertor() {
     Hashtable ht=new Hashtable();
     Object prxVfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
     ht.put("WASH PRICE",prxVfy);
     return ht;
  }

}
