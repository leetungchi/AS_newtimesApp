package newtimes.preproduction.guis;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import newtimes.preproduction.process.*;
import java.awt.Color;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPPSList extends PnlTableEditor {
  DB_PPSstatus myHandler=null;
  static String DISP_KLM_STY="Style NO";
  static String DISP_KLM_SENT_DATE="Sent Date";
  static String DISP_KLM_COMMENT="  comment  ";
  static String DISP_KLM_COMMENT_DATE="Comment\nDate";
  static String DISP_KLM_TGT_DATE="Target\nDate";
  static String DISP_KLM_EXPECTED_DATE="Expected\nDate";
  static String DISP_KLM_REMARK="   Remark   ";
  static InsertionOrderedHashMap iso=null;
  static Hashtable obj2cnv=null;
  public PnlPPSList() {
    getJtable().setRowHeight(60);
    setBackground(new Color(204, 204, 225));
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
      String columns[]=getStoredRecordColumns();
      rec.set(columns[columnAt],value2update);
    }catch(Exception e){
      e.printStackTrace();
    }
    return rec;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
   if(iso==null){
     iso=new InsertionOrderedHashMap();
     iso.put(DISP_KLM_STY,"PPS_STATUS_LOCKIN_STYLE_PK");
     iso.put(DISP_KLM_SENT_DATE,"PPS_STATUS_SEND_DATE");
     iso.put(DISP_KLM_COMMENT,"PPS_STATUS_COMMENT");
     iso.put(DISP_KLM_COMMENT_DATE,"PPS_STATUS_COMMENT_DATE");
     iso.put(DISP_KLM_TGT_DATE,"PPS_STATUS_TARGET_DATE");
     iso.put(DISP_KLM_EXPECTED_DATE,"PPS_STATUS_EXPECTED_DATE");
     iso.put(DISP_KLM_REMARK,"PPS_STATUS_REMARK");
   }
   return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   multiEditorJTableInSuper.addJComboBox(0,myHandler.USING_LOCKIN_STYLES,
                                         "LOCKIN_STYLE_NO","LOCKIN_STYLE_PK");
   multiEditorJTableInSuper.addTextAreaEditor(2,200);//for comment column
   multiEditorJTableInSuper.addTextAreaEditor(6,200);//for remark column
   multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 5;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    if(obj2cnv==null){
      obj2cnv=new Hashtable();
      obj2cnv.put(DISP_KLM_SENT_DATE,dateVfy);
      obj2cnv.put(DISP_KLM_COMMENT_DATE,dateVfy);
      obj2cnv.put(DISP_KLM_TGT_DATE,dateVfy);
      obj2cnv.put(DISP_KLM_EXPECTED_DATE,dateVfy);
    }
    return obj2cnv;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    DB_PPSstatus db=DB_PPSstatus.getInstanceOfPPSstatus();
    this.dbHandler=db;
    myHandler=db;
    return db;
  }

}