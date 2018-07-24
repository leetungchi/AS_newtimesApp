package processhandler.template;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class pnlEditBillItems extends PnlTableEditor {
  protected static final String COLUMN_DATE="Transection at";
  protected static final String COLUMN_BUYER="Client Name";
  protected static final String COLUMN_QUENTITY="quentity";
  protected static final String COLUMN_ITEM_NAME="object";
  java.text.SimpleDateFormat sd=new java.text.SimpleDateFormat("yyyyy.MMMMM.dd  hh:mm aaa");
  public pnlEditBillItems() {
    Record rec=
      Properties.getCenteralControler().getCurrentEditingMasterRecord();
    dbHandler=new DB_BillItems();
    try{
      ((DB_BillItems) dbHandler).txn_date = (String) rec.get("txn_date");
      ((DB_BillItems) dbHandler).txn_user = (String) rec.get("txn_user");
      setPreferredSize(new java.awt.Dimension(550,200));
      firstPage();
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
      if (columnAt == 2) {
        rec.set("item", value2update);
      }
      if (columnAt == 3) {
        rec.set("qty", value2update);
      }
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put(COLUMN_BUYER,"txn_user");
    iso.put(COLUMN_DATE,"txn_date" );
    iso.put(COLUMN_ITEM_NAME,"item");
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    String itemCountArr[]={"-1","0","1","2","3"};
    java.util.Vector rowDatasVct=new java.util.Vector();
    try {
      for (int i = 0; i < getDisplayingRecords().size(); i++) {
        Record rec = (Record) getDisplayingRecords().get(i);
        rowDatasVct.add(rec.get("qty"));
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    multiEditorJTableInSuper.addJComobBox(3,
    COLUMN_QUENTITY,itemCountArr,true,rowDatasVct);
    Hashtable kvHt=new Hashtable();
    kvHt.put(COLUMN_ITEM_NAME,exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(5));
    multiEditorJTableInSuper.setTextEditorVerifiers(kvHt);
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 5;
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    Hashtable ht=new Hashtable();
    ht.put(COLUMN_DATE,new txnStr2Date());
    return ht;
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
  }
  class txnStr2Date implements exgui.Object2String{
   public String Obj2String(Object obj2cnv){
     java.sql.Date buyDate=new java.sql.Date(Long.parseLong((String)obj2cnv));
     return sd.format(buyDate);
   }
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return dbHandler;
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
  }
  public void doPrint()throws Exception{
    throw new Exception("printing function is not implemented yet");
  }
}