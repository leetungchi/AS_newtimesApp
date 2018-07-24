package newtimes.preproduction.guis;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import newtimes.preproduction.process.*;
import java.util.Vector;
import java.awt.Dimension;
import javax.swing.UIManager;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlLabDipList extends PnlTableEditor {
  DB_LabDipStts myProcessor;
  static String DISP_KLM_COLOR="  Color Name   ";
  static String DISP_KLM_SEND_DATE="Sent date";
  static String DISP_KLM_COMMENT="     Comment      ";
  static String DISP_KLM_COMMENT_DATE="Comment date";
  static String DISP_KLM_APPRVL_DATE="Approval Date";
  static String KLM_COLOR="LAB_DIP_COlOR";
  static String KLM_SEND_DATE="LAB_DIP_COLOR_SENT";
  static String KLM_COMMENT="LAB_DIP_COMMENT";
  static String KLM_COMMENT_DATE="LAB_DIP_COMMENT_DATE";
  static String KLM_APPRVL_DATE="LAB_DIP_APPROVAL_DATE";
  Vector clibDatas;
  public PnlLabDipList() {
    try{
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      getJtable().setRowHeight(60);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
     String storedKlms[]=getStoredRecordColumns();
     /*
     if(columnAt==0){
       rec.set("LAB_DIP_COLOR",value2update);
     }else{
       rec.set(storedKlms[columnAt-1],value2update);
     }
     */
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
    InsertionOrderedHashMap hm=new InsertionOrderedHashMap();
    hm.put(DISP_KLM_COLOR,KLM_COLOR);
    hm.put(DISP_KLM_SEND_DATE,KLM_SEND_DATE);
    hm.put(DISP_KLM_COMMENT,KLM_COMMENT);
    hm.put(DISP_KLM_COMMENT_DATE,KLM_COMMENT_DATE);
    hm.put(DISP_KLM_APPRVL_DATE,KLM_APPRVL_DATE);
    return hm;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/

    multiEditorJTableInSuper.addJComboBox(0,clibDatas,
                                           "PCLIB_COLOR_NAME",
                                           "PCLIB_sEQ");
     multiEditorJTableInSuper.addTextAreaEditor(2,200);
     //multiEditorJTableInSuper.addCheckbox(5,"delete flag","Record_delete_flaG","1");
     multiEditorJTableInSuper.setTextEditorVerifiers(this.getObject2StringConvertor());
         ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(
        new myUnitEditablePolicy());
  }
  class myUnitEditablePolicy implements exgui.CellEditablePolicy{
    //to avoid chage unit after editting qty.
    public boolean isCellEditable(int row,int column){
      try{
        if (column != 0)
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
    Object dateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object cmtCnv=exgui.verification.CellFormat.getOrdinaryField(200);
    java.util.Hashtable ht=new Hashtable();
    ht.put(DISP_KLM_APPRVL_DATE,dateCnv);
    ht.put(DISP_KLM_COMMENT_DATE,dateCnv);
    ht.put(DISP_KLM_SEND_DATE,dateCnv);
    //ht.put(DISP_KLM_COMMENT,cmtCnv);
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    myProcessor=DB_LabDipStts.getLabDipSttsInstance();
    this.clibDatas=myProcessor.PREPROD_COLOR_LIBS;//this attribute is update at each time call DB_LabDipsStts.getAvailableClibs(preprodHeadPK);
    this.dbHandler=myProcessor;
    return dbHandler;
  }

}