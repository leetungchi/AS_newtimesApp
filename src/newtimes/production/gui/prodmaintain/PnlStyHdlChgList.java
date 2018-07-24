package newtimes.production.gui.prodmaintain;

import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;

public class PnlStyHdlChgList extends PnlStyMiscList {
  public PnlStyHdlChgList() {
  }
  public void exitCurrentGui(){}
  protected InsertionOrderedHashMap getHeadColumnMap() {
     /*
      (19)	HANDLING CHARGE I FEE: STY_MAK_EXTRA1_REMK
      (20)	HANDLING CHARGE I REMARK: STY_MAK_EXTRA1_CHG
      (21)	HANDLING CHARGE II FEE: STY_MAK_EXTRA2_REMK
      (22)	HANDLING CHARGE II REMARK: STY_MAK_EXTRA2_CHG
      (23)	HANDLING CHARGE III FEE: STY_MAK_EXTRA3_REMK
      (24)	HANDLING CHARGE III REMARK: STY_MAK_EXTRA3_CHG
      */
     InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
     iso.put(DISP_STY_NO,DB_STY_NO);
     iso.put(DISP_STY_PO,DB_STY_PO);
     iso.put("FEE ","STY_MAK_EXTRA1_CHG");
     iso.put("REMARK   ","STY_MAK_EXTRA1_REMK");
     iso.put(" FEE","STY_MAK_EXTRA2_CHG");
     iso.put(" REMARK  ","STY_MAK_EXTRA2_REMK");
     iso.put("FEE","STY_MAK_EXTRA3_CHG");
     iso.put("REMARK  ","STY_MAK_EXTRA3_REMK");
     return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.setTableColumn2Grp("HANDLING CHARGE I",2);
    multiEditorJTableInSuper.setTableColumn2Grp("HANDLING CHARGE I",3);
    multiEditorJTableInSuper.setTableColumn2Grp("HANDLING CHARGE II",4);
    multiEditorJTableInSuper.setTableColumn2Grp("HANDLING CHARGE II",5);
    multiEditorJTableInSuper.setTableColumn2Grp("HANDLING CHARGE III",6);
    multiEditorJTableInSuper.setTableColumn2Grp("HANDLING CHARGE III",7);
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    multiEditorJTableInSuper.addTextAreaEditor(3,50);
    multiEditorJTableInSuper.addTextAreaEditor(5,50);
    multiEditorJTableInSuper.addTextAreaEditor(7,50);
    hookInRefineEditor(multiEditorJTableInSuper);
    getJtable().setRowHeight(50);
  }
  protected Hashtable getObject2StringConvertor() {
   Hashtable ht=new Hashtable();
   Object chg73=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
   Object rmk=exgui.verification.CellFormat.getOrdinaryField(50);
   ht.put("FEE ",chg73);
   ht.put("REMARK   ",rmk);
   ht.put(" FEE",chg73);
   ht.put(" REMARK  ",rmk);
   ht.put("FEE",chg73);
   ht.put("REMARK  ",rmk);
   return ht;
  }

}
