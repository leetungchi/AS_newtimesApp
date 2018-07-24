package newtimes.preproduction.guis;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import newtimes.preproduction.process.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDupsStatusList extends processhandler.template.PnlTableEditor
{
  DB_DupsStatus myHandler;
  static String DISP_KLM_COLOR="COLOR";
  static String DISP_KLM_STYLE_NO="STYLE NO";
  static String DISP_KLM_SENT_QTY="Sent Qty";
  static String DISP_KLM_SENT_LOCATION="Sent Location";
  static String DISP_KLM_SENT_DATE="Sent Date";
  static String DISP_KLM_RJT_DATE="Reject Date";
  static String DISP_KLM_APVL_DATE="Approval\nDate";
  static String DISP_KLM_COMMENT="   Comment   ";
  static Hashtable obj2StrConv=null;
  static InsertionOrderedHashMap iso=null;
  public PnlDupsStatusList() {
    getJtable().setRowHeight(60);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
     String storedKlms[]=getStoredRecordColumns();
     rec.set(storedKlms[columnAt],value2update);
     rec.set("EDIT_MODE","E");
     return rec;
    }catch(Exception e){
      e.printStackTrace();
      return rec;
    }

  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
     if(iso==null){
      iso=new InsertionOrderedHashMap();
      iso.put(DISP_KLM_STYLE_NO,"DUPS_STATUS_LOCKIN_STYLE_PK");
      iso.put(DISP_KLM_COLOR,"DUPS_STATUS_COLOR");
      iso.put(DISP_KLM_SENT_QTY,"DUPS_STATUS_SENT_QTY");
      iso.put(DISP_KLM_SENT_LOCATION,"DUPS_STATUS_SENT_LOCATION");
      iso.put(DISP_KLM_SENT_DATE,"DUPS_STATUS_SENT_DATE");
      iso.put(DISP_KLM_RJT_DATE,"DUPS_STATUS_REJECTED_DATE");
      iso.put(DISP_KLM_APVL_DATE,"DUPS_STATUS_APPROVAL_DATE");
      iso.put(DISP_KLM_COMMENT,"DUPS_STATUS_COMMENT_RCVD");
     }
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    multiEditorJTableInSuper.addJComboBox(0,myHandler.lockinstyleRecords,
                                          "LOCKIN_STYLE_NO","LOCKIN_STYLE_PK"
                                         );
   multiEditorJTableInSuper.addJComboBox(1,myHandler.pclibRecords,
                                         "PCLIB_COLOR_NAME","PCLIB_SEQ");
   multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
   multiEditorJTableInSuper.addTextAreaEditor(7,200);
   multiEditorJTableInSuper.setTextEditorVerifiers(this.getObject2StringConvertor());
       ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(
      new myUnitEditablePolicy());
}
class myUnitEditablePolicy implements exgui.CellEditablePolicy{
  //to avoid chage unit after editting qty.
  public boolean isCellEditable(int row,int column){
    try{
      if (column != 1)
        return true;
      Record rec = (Record) getDisplayingRecords().get(row);
      if ( ( (String) rec.get("EDIT_MODE")).trim().equalsIgnoreCase("E")) {
         return false;
      }
      return true;
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }
}
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 5;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    if(obj2StrConv==null){
      obj2StrConv=new Hashtable();
      Object dateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      Object chr40Cnv=exgui.verification.CellFormat.getOrdinaryField(40);
      Object int3Cnv=exgui.verification.CellFormat.getIntVerifierAllowNull(3);
      //Object chr200Cnv=exgui.verification.CellFormat.getOrdinaryField(200);

      obj2StrConv.put(DISP_KLM_SENT_QTY,int3Cnv);
      obj2StrConv.put(DISP_KLM_SENT_LOCATION,chr40Cnv);
      obj2StrConv.put(DISP_KLM_SENT_DATE,dateCnv);
      obj2StrConv.put(DISP_KLM_RJT_DATE,dateCnv);
      obj2StrConv.put(DISP_KLM_APVL_DATE,dateCnv);
      //obj2StrConv.put(DISP_KLM_COMMENT,chr200Cnv);
    }
    return obj2StrConv;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    DB_DupsStatus myHandler =DB_DupsStatus.getInstanceOfDupsStatus();
    return myHandler;
  }
  public void doPrint(){
  }
}
