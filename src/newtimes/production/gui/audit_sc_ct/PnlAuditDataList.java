package newtimes.production.gui.audit_sc_ct;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import newtimes.production.process.audit_sc_ct.*;
public class PnlAuditDataList extends PnlTableEditor {
  public PnlAuditDataList() {
    jbtn1st.setVisible(false);
    jbtnLast.setVisible(false);
    jbtnNext.setVisible(false);
    jbtnPrev.setVisible(false);
    getJtable().setRowHeight(70);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap iso=
        new util.InsertionOrderedHashMap();
    //PROD_STATE_PK, PROD_HEAD_PK, PS_STATE, PS_STATE_DATE, PROD_AUDIT_RMRK
    iso.put("Status","PS_STATE");
    iso.put("Status\nDate","PS_STATE_DATE");
    iso.put("  Status Remark      ","PROD_AUDIT_RMRK");
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    multiEditorJTableInSuper.addTextAreaEditor(2,500);
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 999;
  }
  protected Hashtable getObject2StringConvertor() {
    Object psName=
        new ProdStatusConv();
    Object dateCnv=
        exgui.verification.CellFormat.getDateStringFormater();
    java.util.Hashtable convs=
        new java.util.Hashtable();
    convs.put("Status",psName);
    convs.put("Status\nDate",dateCnv);
    return convs;
  }
  public boolean isInitOK(){
     if(dbHandler==null)return false;
     return ((DB_ProdAudits)dbHandler).isInitOk(); }
  protected PagedDataFactory getPagedDataFactory() {
    DB_ProdAudits _dbHandler=new DB_ProdAudits();
    dbHandler=_dbHandler;
    return dbHandler;
  }
  public  DB_ProdAudits getAuditDbHanlder(){
    return (DB_ProdAudits)dbHandler;
  }
  public class ProdStatusConv implements exgui.Object2String,exgui.ultratable.CellTxtEditorFormat {
    public String Obj2String(Object valueObj){
      if(valueObj==null) return "N/A";
      return newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm.prod_status_code[Integer.parseInt(valueObj.toString())];
    }
    public Object cellStringToObject(String str){
      return null;
    }
    public exgui.ultratable.KeyProcess getKeyListener(){
      return null;
    }
    public int getMaxLength(){return 20;}
    public boolean isFormatValid(String str,int row,int col){return true;}
    public String formatPromptMsg(){
      return null;
    }
  }

}
