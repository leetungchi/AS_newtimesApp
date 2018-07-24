package newtimes.accounting;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListFabCommInter extends exgui.ultratable.FuncAbstractUltraTablePanel  {
  exgui.ultratable.Wraper4tblCbx arr_FabCommKind[]=new exgui.ultratable.Wraper4tblCbx[5];
  exgui.ultratable.Wraper4tblCbx arr_FabCommType[]=new exgui.ultratable.Wraper4tblCbx[2];
  static String col_x="X";
  static String col_RefNo="RefNo";
  static String col_supplier="SUPPLIER";
  static String col_PI=" PI ";
  static String col_BuyerOdrNo="BUYER\nORDER NO";
  static String col_Description="DESCRIPTION";
  static String col_DelvDate="DEL.\nDate";
  static String col_Kind="KIND";
  static String col_Discount="DISCOUNT";
  static String col_PiRcvDate="PI\nRCV DATE";
  static String col_DiscountRcvDate="DISCOUNT\nRCV DATE";
  static String col_SC_NO=" S/C. NO ";
  static String col_PROD_REF="PROD NO";
  static String col_PI_QTY="PI\nQTY";
  static String col_PI_REMARK="PI\n   REMARK  ";

  public PnlListFabCommInter() {
     super();
     exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_1=
         new exgui.ultratable.Wraper4tblCbx("1"," % ");
     exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_2=
         new exgui.ultratable.Wraper4tblCbx("2","USD/UNIT");
     exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_3=
         new exgui.ultratable.Wraper4tblCbx("3","TWD/UNIT");

     exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_4=
         new exgui.ultratable.Wraper4tblCbx("4","RMB/UNIT");

     exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_5=
         new exgui.ultratable.Wraper4tblCbx("5","HKD/UNIT");


     arr_FabCommKind[0]=FAB_COMM_Kind_1;
     arr_FabCommKind[1]=FAB_COMM_Kind_2;
     arr_FabCommKind[2]=FAB_COMM_Kind_3;
     arr_FabCommKind[3]=FAB_COMM_Kind_4;
     arr_FabCommKind[4]=FAB_COMM_Kind_5;

     exgui.ultratable.Wraper4tblCbx FAB_COMM_Type_1=
         new exgui.ultratable.Wraper4tblCbx("FABRIC","FABRIC");
     arr_FabCommType[0]=FAB_COMM_Type_1;
     exgui.ultratable.Wraper4tblCbx FAB_COMM_Type_2=
         new exgui.ultratable.Wraper4tblCbx("TRIM","TRIM");
     arr_FabCommType[1]=FAB_COMM_Type_2;
     jbtn1st.setVisible(false);
     jbtnLast.setVisible(false);
     jbtnPrev.setVisible(false);
     jbtnNext.setVisible(false);
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headColum=new util.InsertionOrderedHashMap();
    headColum.put(col_x,"checkbox");
    headColum.put(col_SC_NO,"PROD_SC_NO");
     headColum.put(col_PROD_REF,"PROD_HEAD_PK");
    headColum.put(col_RefNo,"PROD_FABCOMM_REFNO");
    headColum.put(col_supplier,"FAB_COMM_SUPPLIER");
    headColum.put(col_PI,"FAB_COMM_PI");
    headColum.put(col_PI_QTY,"FAB_COMM_PI_QTY");
    headColum.put(col_BuyerOdrNo,"FAB_COMM_BYR_ODR_NO");
    headColum.put(col_Description,"FAB_COMM_DESC");
    headColum.put(col_DelvDate,"FAB_COMM_DEL");
    headColum.put(col_Kind,"FAB_COMM_DISCOUNT_KIND");
    headColum.put(col_Discount,"FAB_COMM_DISCOUNT");
    headColum.put(col_PiRcvDate,"FAB_COMM_PI_RCV");
    headColum.put(col_DiscountRcvDate,"FAB_COMM_DISCOUNT_RCV");
    headColum.put(col_PI_REMARK,"FAB_COMM_PI_REMARK");

    /*
    headColum.put("X","checkbox");
    headColum.put("RefNo","PROD_FABCOMM_REFNO");
    //headColum.put("UNIT","FAB_COMM_UNIT");
    headColum.put("SUPPLIER","FAB_COMM_SUPPLIER");
    headColum.put(" PI ","FAB_COMM_PI");
    headColum.put("BUYER\nORDER NO","FAB_COMM_BYR_ODR_NO");
    headColum.put("DESCRIPTION","FAB_COMM_DESC");
    headColum.put("DEL.\nDate","FAB_COMM_DEL");
    headColum.put("KIND","FAB_COMM_DISCOUNT_KIND");
    headColum.put("DISCOUNT","FAB_COMM_DISCOUNT");
    headColum.put("PI\nRCV DATE","FAB_COMM_PI_RCV");
    headColum.put("DISCOUNT\nRCV DATE","FAB_COMM_DISCOUNT_RCV");
    */
    return headColum;
  }
  protected void makeTable(Vector vct){
    super.makeTable(vct);
    //fill in the 6th column with co-responding string .
    for(int i=0;i<getJtable().getRowCount();i++){
       Object obj=getJtable().getValueAt(i,8+1);

      if(obj!=null && !obj.equals("")){
        int kind_id=Integer.parseInt(obj.toString());
        getJtable().setValueAt(arr_FabCommKind[kind_id-1],i,8+1);
      }
    }
    super.getJtable().getColumnModel().getColumn(0).setPreferredWidth(10);
    super.getJtable().getColumnModel().getColumn(5).setPreferredWidth(45);
    super.getJtable().getColumnModel().getColumn(6).setPreferredWidth(45);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    try{
      if(columnAt!=0)  rec.set(storedRecordColumn[columnAt], value2update);
       return rec;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    //column of check box
    java.util.Vector recUnits=newtimes.preproduction.guis.tempProperties.tmpUnits;
    multiEditorJTableInSuper.addCheckbox(0,"X");
    //multiEditorJTableInSuper.addJComboBox(2,recUnits,"UNIT","UNIT");
    //multiEditorJTableInSuper.addJComboBox(8,arr_FabCommKind,false);
    multiEditorJTableInSuper.addJComboBox(8+2,arr_FabCommKind,false);
    multiEditorJTableInSuper.setTextEditorVerifiers(klmObjKvtHt);
    multiEditorJTableInSuper.setAllColumnUnEdtiable();
    multiEditorJTableInSuper.setColumnEditable(col_PI);
    multiEditorJTableInSuper.setColumnEditable(col_PI_QTY);
    multiEditorJTableInSuper.setColumnEditable(col_PiRcvDate);
    multiEditorJTableInSuper.setColumnEditable(col_DiscountRcvDate);
    multiEditorJTableInSuper.setColumnEditable(col_x);
    multiEditorJTableInSuper.setColumnEditable(col_PI_REMARK);

  }

  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 999999;
  }
  protected Hashtable getObject2StringConvertor() {
    java.util.Hashtable ht=new java.util.Hashtable();

    Object vfyDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object vfy20Char=exgui.verification.CellFormat.getOrdinaryField(20);
    Object vfy10Char=exgui.verification.CellFormat.getOrdinaryField(15);
    Object vfy15Char=exgui.verification.CellFormat.getOrdinaryField(15);

    Object d73=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
    Object d52=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
    Object vfy100Char=exgui.verification.CellFormat.getOrdinaryField(100);

    ht.put(col_supplier,vfy20Char);
    ht.put(col_PI ,vfy10Char);
    ht.put(col_BuyerOdrNo,vfy15Char);
    ht.put(col_Description,vfy20Char);
    ht.put(col_DelvDate,vfyDate);
    ht.put(col_Discount,d73);

    ht.put(col_PI_QTY,d52);
    ht.put(col_PI_REMARK,vfy100Char);

    //ht.put("TYPE",new VfyFabCommType());
    ht.put(col_PiRcvDate,vfyDate);
    ht.put(col_DiscountRcvDate,vfyDate);

    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    Db_FabCommBalance dbhd=new Db_FabCommBalance();
    dbHandler=dbhd;
    return dbhd;
  }

}
