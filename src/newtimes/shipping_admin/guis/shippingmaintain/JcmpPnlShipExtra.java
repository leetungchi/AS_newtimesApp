package newtimes.shipping_admin.guis.shippingmaintain;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import processhandler.template.PnlTableEditor;
import javax.swing.JLabel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class JcmpPnlShipExtra extends   PnlTableEditor {
  static final String SIGN = "Sign";
  static final String EXTRA = "Amount";
  static final String REMARK = "Remark                               ";
  static Hashtable obj2StrConv = null;
  static InsertionOrderedHashMap iso = null;
  public JcmpPnlShipExtra() {
    firstPage();
    jbtn1st.setVisible(false);
    jbtnLast.setVisible(false);
    jbtnNext.setVisible(false);
    jbtnPrev.setVisible(false);
    getJtable().setRowHeight(20);
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try {
      switch (columnAt) {
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
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set record data." +
                                 "\nRecord Data:" + rec.toString());
    }
    return rec;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(SIGN, "SIGN");
      iso.put(EXTRA, "EXTRA");
      iso.put(REMARK, "REMARK");
    }
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try {
      String[] sign = {"+","-","*","/"};
      multiEditorJTableInSuper.addJComboBox(0,sign,false);
      //multiEditorJTableInSuper.addJComboBoxEditable(0,sign,1);
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
 public boolean confirmUpdate() throws Exception{
    //test if 1st column larger than 1 char.
    javax.swing.JTable tbl=getJtable();
    for(int i=0;i<tbl.getRowCount();i++){
      String str=(String)tbl.getValueAt(i,0);
      Object paraValue=tbl.getValueAt(i,1);
      if(paraValue==null){
        exgui.verification.VerifyLib.showAlert("Amount CAN NOT BE Zero",
                                               "Amount CAN NOT BE Zero");
        return false;
      }else{
        float pF=Float.parseFloat(paraValue.toString());
        if(pF==0){
          exgui.verification.VerifyLib.showAlert("Amount CAN NOT BE Zero",
                                                 "Amount CAN NOT BE Zero");
          return false;
        }
      }
      if(str==null){
        exgui.verification.VerifyLib.showAlert("SIGN CAN NOT BE BLANK",
                                               "SIGN CAN NOT BE BLANK");
        return false;
      }else{
        if(str.length()==0){
          exgui.verification.VerifyLib.showAlert("SIGN CAN NOT BE BLANK",
                                                 "SIGN CAN NOT BE BLANK");
          return false;
        }
        if(str.length()>2){
          exgui.verification.VerifyLib.showAlert("Sign Is Only One Character",
                                                 "Sign Is Only One Character");
          return false;
        }

      }
    }
    return super.confirmUpdate();
  }
  public PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    if(super.dbHandler==null){
      dbHandler=new newtimes.shipping_admin.process.shiippingmaintain.DB_ShipExtra();
    }
    return dbHandler;
  }
 public void doPrint(){}
}
