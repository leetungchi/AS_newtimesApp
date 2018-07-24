package newtimes.material;

import java.util.HashMap;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import javax.swing.JPanel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PrintListAbsPanel extends AbstractUltraTablePanel {
  static Hashtable obj2StrConv=null;

  private static String TT_MTR_NO      = "    MTR-NO     ";
  private static String TT_MillName    = "    MILL         \nName  ";
  private static String TT_Mill_MTR_NO = "    MILL         \nMTR-NO";
  private static String TT_USD         = " USD ";
  private static String TT_Local       = " Local ";
  private static String TT_Finish      = " Finish  ";
  private static String TT_Content     = "      Content        ";
  private static String TT_Construct   = "    Construct   ";

  protected newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH= null;
  private newtimes.material.CONST.MTR.EJB MTR_EJB=null;
  private newtimes.material.CONST.MTRDTL.EJB STICKER_EJB=null;
  private newtimes.material.CONST.COMMON COMMON=null;
  private PrintListDataFactory StickerDataSrc = null;

  JPanel parent = null;
  public PrintListAbsPanel(JPanel parent) {
    super();
    firstPage();
    this.parent = parent;
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
    headHm.put(TT_MTR_NO,      STICKER_EJB.MTR_NO);
    headHm.put(TT_MillName,    STICKER_EJB.BYMKR_NAME);
    headHm.put(TT_Mill_MTR_NO, STICKER_EJB.MILL_NO);
    headHm.put(TT_USD,         STICKER_EJB.PRX_USD);
    headHm.put(TT_Local,       STICKER_EJB.PRX_LOCAL);
    headHm.put(TT_Finish,      MTR_EJB.FINISH);
    headHm.put(TT_Content,     MTR_EJB.CONTENT);
    headHm.put(TT_Construct,   MTR_EJB.CONSTRUCTION);
    return headHm;

  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.StickerDataSrc != null) return this.StickerDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS);
    PrintListDataFactory _StickerDataSrc = new PrintListDataFactory(hm);

    this.StickerDataSrc = _StickerDataSrc;
    return _StickerDataSrc;
  }
  public void reload(){
    super.reload();
    if(parent instanceof MtrDtlPrintList){
      ((MtrDtlPrintList)parent).refreshCheck();
    }
  }
  protected void goPage(int rowStartAt,int rowCount,boolean need2UpdateXntPage){
    super.goPage(rowStartAt,rowCount,need2UpdateXntPage);
    if(parent instanceof MtrDtlPrintList){
      ((MtrDtlPrintList)parent).refreshCheck();
    }
  }


}
