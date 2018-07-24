package newtimes.shipping.shippingmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MasterExtraTableEditor extends PnlTableEditor {
  MasterExtraDataFactoryAdapter extDataSrc = null;
  static final String SIGN = "Sign";
  static final String EXTRA = "Amount";
  static final String REMARK = "Remark                               ";
  static Hashtable obj2StrConv = null;
  static InsertionOrderedHashMap iso = null;

  public MasterExtraTableEditor() {
    super.firstPage();
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    getJtable().setRowHeight(20);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try {
      switch(columnAt) {
        case 0:
          rec.set("SIGN", value2update);
          return rec;
        case 1:
          rec.set("EXTRA", value2update);
          return rec;
        case 2:
          rec.set("REMARK", value2update);
          return rec;
      }
    } catch(Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set record data."+
                                 "\nRecord Data:"+rec.toString());
    }
    return rec;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(SIGN, "SIGN");
      iso.put(EXTRA, "EXTRA");
      iso.put(REMARK, "REMARK");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try {
      String[] sign = {"+","-"};
      multiEditorJTableInSuper.addJComboBox(0,sign,true);
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set JComboBox.");
    }
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    try {
      obj2StrConv = new java.util.Hashtable();
//      if(obj2StrConv == null){
        Object formatExtra = exgui.verification.CellFormat.getDoubleFormatAllowNull(7, 2);
        Object formatRmk = exgui.verification.CellFormat.getOrdinaryField(200);
        obj2StrConv.put(EXTRA, formatExtra);
        obj2StrConv.put(REMARK, formatRmk);
//      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at checked format type.");
    }
    return obj2StrConv;
  }
  protected PagedDataFactory getPagedDataFactory() {
    MasterExtraDataFactoryAdapter extDataSrc = MasterExtraDataFactoryAdapter.getInstance();
    return extDataSrc;
  }
}