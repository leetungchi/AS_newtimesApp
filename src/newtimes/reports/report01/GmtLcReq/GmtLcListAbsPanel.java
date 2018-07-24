package newtimes.reports.report01.GmtLcReq;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtLcListAbsPanel extends AbstractUltraTablePanel {
  //Legend: TT=Table Title
  private static String TT_LISTNO = "LIST_NO";
  private static String TT_FTY = "FTY";
  private static String TT_DIV = "DIV";
  private static String TT_SEA = "SEA";
  private static String TT_YR  = "YR";
  private static String TT_RG  = "RG";
  private static String TT_PO  = "P.O.";
  private static String TT_STYLE = "STYLE";
  private static String TT_QTA = "QTA";
  private static String TT_QTY = "QTY";
  private static String TT_CMT = "CMT";
  private static String TT_FOB = "FOB";
  private static String TT_AMT = "AMOUNT";
  private static String TT_DEL = "DEL";

  private ReportEJBs.RepGMTLC.GMTLc gmtLcEJB=
      (ReportEJBs.RepGMTLC.GMTLc)util.ApplicationProperites.getProperties("gmtLcEJB");

  private GmtLcDataFactory gmtLcDataSrc = null;
  private JPanel parent = null;

  public GmtLcListAbsPanel(JPanel _parent) {
    super();
    parent = _parent;
  }

  public GmtLcListAbsPanel(JPanel _parent, HashMap hm) {
    this(_parent);
    GmtLcDataFactory _usrDataSrc = new GmtLcDataFactory(hm);
    this.dbHandler = _usrDataSrc;
  }


  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
    headHm.put(TT_LISTNO, "LIST_NO");
    headHm.put(TT_FTY, "FTY_BRIEF");
    headHm.put(TT_DIV, "DIV_NAME");
    headHm.put(TT_SEA, "PROD_SEASON");
    headHm.put(TT_YR, "PROD_YEAR");
    headHm.put(TT_RG, "PROD_RANGE");
    headHm.put(TT_PO, "STY_PO");
    headHm.put(TT_STYLE, "STY_STYLE");
    headHm.put(TT_QTA, "IQ");
    headHm.put(TT_QTY, "QTY_A");
    headHm.put(TT_CMT, "CMT_PRICE");
    headHm.put(TT_FOB, "ACT_C");
    headHm.put(TT_AMT, "AMOUNT_C");
    headHm.put(TT_DEL, "DEL_D");
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 10;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.gmtLcDataSrc != null) return this.gmtLcDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties("gmtLcSearchConds");
    GmtLcDataFactory _usrDataSrc = new GmtLcDataFactory(hm);

    this.gmtLcDataSrc = _usrDataSrc;
    return gmtLcDataSrc;
  }

  public void resetDataSoure(HashMap hm){
    GmtLcDataFactory _usrDataSrc = new GmtLcDataFactory(hm);
    this.dbHandler = _usrDataSrc;
  }

  protected void goPage(int rowStartAt,int rowCount,boolean need2UpdateXntPage){
    super.goPage(rowStartAt,rowCount,need2UpdateXntPage);
    if(parent instanceof GmtLcQueryCurrent){
      ((GmtLcQueryCurrent)parent).adjustCheckBoxGroup();
      this.getDisplayingRecords();
    }
  }


}