package newtimes.reports.report01.GmtPendLc;

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

public class GmtPendAbsPanel extends AbstractUltraTablePanel {
  private static String TT_USERNAME = "USER NAME";
  private static String TT_LISTNO   = "LIST NO";
  private static String TT_DATE     = "DATE";
  private static String TT_LCNO     = "LC NO";
  private ReportEJBs.RepGMTPendLC.GMTPendLc gmtPendLcEJB=
      (ReportEJBs.RepGMTPendLC.GMTPendLc)util.ApplicationProperites.getProperties("gmtPendLcEJB");
  private GmtPendDataFactory gmtPendDataSrc = null;
  private JPanel parent = null;
  private String userID = null;

  static Hashtable obj2StrConv=null;
  private void initData(){
    try{
      userID = (String)(util.PublicVariable.USER_RECORD.get("USR_CODE"));
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public GmtPendAbsPanel() {
    super();
    initData();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      String Column[]=getStoredRecordColumns();
      rec.set(Column[columnAt],value2update);
      rec.set("RECORD_MODIFY_USER", userID);
    }catch(Exception e){
      e.printStackTrace();
    }
    finally{
      return rec;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
    headHm.put(TT_USERNAME, "USER_NAME");
    headHm.put(TT_LISTNO,   "LIST_NO");
    headHm.put(TT_DATE,     "PRINT_DATE");
    headHm.put(TT_LCNO,     "LC_NO");
    return headHm;

  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try{
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  protected int getEachPageRowCount() {
    return 10;
  }
  protected Hashtable getObject2StringConvertor() {
    if(obj2StrConv==null){
      Object text20Field = exgui.verification.CellFormat.getOrdinaryField(20);
      obj2StrConv = new Hashtable();
      obj2StrConv.put(TT_LCNO,text20Field);
    }
    return obj2StrConv;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.gmtPendDataSrc != null) return this.gmtPendDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties("gmtPendSearchConds");
    this.gmtPendDataSrc = new GmtPendDataFactory(hm);
    return this.gmtPendDataSrc;

  }
  public void resetDataSoure(HashMap hm){
    this.dbHandler = new GmtPendDataFactory(hm);
  }


}