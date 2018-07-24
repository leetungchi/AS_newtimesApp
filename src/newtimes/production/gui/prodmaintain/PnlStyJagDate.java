package newtimes.production.gui.prodmaintain;

import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;

public class PnlStyJagDate extends PnlStyMiscList {
  public PnlStyJagDate() {
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    //STY_CMMTRCVD_ACT,
    //STY_PGSPMFG_ACTW, STY_PGSPMFG_ACTZ,
    //STY_PGSPMFG_CMPLT,
    //STY_PGSPXJAG_ACT, STY_PGSPXJAG_TARGET,
    //STY_PPGMTAPR_ACT, STY_PPGMTJAG_ACT,
     //STY_PPGMTXMF_ACT,
    //STY_PPGMTXMF_EXP25, STY_PPGMTXMF_EXPW, STY_PPGMTXMF_TARGET
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put(DISP_STY_NO,DB_STY_NO);
    iso.put(DISP_STY_PO,DB_STY_PO);
    //for PGSPXJAG
    iso.put("TARGET ","STY_PGSPXJAG_TARGET");
    iso.put("ACTUAL ","STY_PGSPXJAG_ACT");
    //for PGSPMFG
    iso.put("ACTUAL-Z","STY_PGSPMFG_ACTZ");
    iso.put("ACTUAL-W","STY_PGSPMFG_ACTW");
    iso.put("COMPLETE","STY_PGSPMFG_CMPLT");
    //PPGMTXMF
    iso.put("TARGET","STY_PPGMTXMF_TARGET");
    iso.put("EXP-25","STY_PPGMTXMF_EXP25");
    iso.put("EXP-W","STY_PPGMTXMF_EXPW");
    iso.put("ACTUAL","STY_PPGMTXMF_ACT");
    //PPGMTJAGACTUAL
    iso.put("PPGMTJAG\nACTUAL","STY_PPGMTJAG_ACT");
    iso.put("PPGMTAPR\nACTUA","STY_PPGMTAPR_ACT");
    iso.put("CMMTRCVD\nACTUAL","STY_CMMTRCVD_ACT");
    return iso;

  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.setTableColumn2Grp("PGSPXJAG",2);
    multiEditorJTableInSuper.setTableColumn2Grp("PGSPXJAG",3);
    multiEditorJTableInSuper.setTableColumn2Grp("PGSPMFG",4);
    multiEditorJTableInSuper.setTableColumn2Grp("PGSPMFG",5);
    multiEditorJTableInSuper.setTableColumn2Grp("PGSPMFG",6);
    multiEditorJTableInSuper.setTableColumn2Grp("PPGMTXMF",7);
    multiEditorJTableInSuper.setTableColumn2Grp("PPGMTXMF",8);
    multiEditorJTableInSuper.setTableColumn2Grp("PPGMTXMF",9);
    multiEditorJTableInSuper.setTableColumn2Grp("PPGMTXMF",10);
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    hookInRefineEditor(multiEditorJTableInSuper);
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable iso=new Hashtable();
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    iso.put("TARGET ",dateVfy);
    iso.put("ACTUAL ",dateVfy);
    //for PGSPMFG
    iso.put("ACTUAL-Z",dateVfy);
    iso.put("ACTUAL-W",dateVfy);
    iso.put("COMPLETE",dateVfy);
    //PPGMTXMF
    iso.put("TARGET",dateVfy);
    iso.put("EXP-25",dateVfy);
    iso.put("EXP-W",dateVfy);
    iso.put("ACTUAL",dateVfy);
    //PPGMTJAGACTUAL
    iso.put("PPGMTJAG\nACTUAL",dateVfy);
    iso.put("PPGMTAPR\nACTUA",dateVfy);
    iso.put("CMMTRCVD\nACTUAL",dateVfy);
    return iso;
  }

}