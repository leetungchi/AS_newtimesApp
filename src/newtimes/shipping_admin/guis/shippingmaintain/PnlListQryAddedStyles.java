package newtimes.shipping_admin.guis.shippingmaintain;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryAddedStyles extends PnlTableEditor  {
  static final String BUYER="   Buyer"  ;
  static final String FTY = "  Maker  ";
  static final String SC_NO = "    S/C NO.    ";
  static final String STYLE = "   Style  ";
  static final String PO = "  PO   ";
  static final String UNIT = "Unit";
  static final String O_QTY = "Order\nQty";
  static final String S_QTY = "Ship\nQty";
  //static InsertionOrderedHashMap iso = null;
  public static int START_ROW_POSITION;


  public PnlListQryAddedStyles() {
     getJtable().setRowHeight(20);
     getJtable().addMouseListener(new myMouseListener());
     //this.goPage(START_ROW_POSITION,getEachPageRowCount());

  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected void goPage(int bgn,int rowcount){
    super.goPage(bgn,rowcount);
    START_ROW_POSITION=bgn;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      //iso = new InsertionOrderedHashMap();
      if(iso==null){
        iso=new InsertionOrderedHashMap();
        iso.put("       SRN       ", "ship_no");
        iso.put(BUYER, "BUYER");
        iso.put(FTY, "maker");
        iso.put(SC_NO, "SC_NO");
        iso.put(STYLE, "sty_STYLE");
        if(util.PublicVariable.OPERATTING_CENTER.equals("PW")||
           util.PublicVariable.OPERATTING_CENTER.equals("BW")||
           util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
          iso.put(PO, "sty_PO");
        }else{
          iso.put(PO, "CUST_PO");
        }
        iso.put(UNIT, "sty_UNIT");
        if (newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.
            containsKey("WITH_SHIP_QTY_ORDER_QTY")) {
          iso.put(O_QTY, "order_qty");
          iso.put(S_QTY, "shipped_qty");
        }
        iso.put("BUYER\nCOMMISION", "buy_comm_str");
        iso.put("MAKER\nDISCOUNT", "maker_disc_str");
      }
      return iso;
  }
  public void doAddNew(){
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  class myMouseListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent e){
      //find out the click row,and activate the edit new ship style record command.
     if(getJtable().getSelectedRow()==-1)return;
     Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
      try {

        String SRN=(String)rec.get("SHIP_NO");
        if(newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN==null||
           (!newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN.equalsIgnoreCase(SRN))
           ){
          Record srnRecord =
              ((newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster)
               dbHandler).getRecordByPk(SRN);
          newtimes.shipping_admin.ShippingAdmin_Const.
              SHIPPING_EDITING_HEAD_RECORD = srnRecord;
          newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN =
              SRN;
        }
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = rec.getInt("ship_style_pk");//editing function
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =rec.getInt("sty_seq");
         //trigger event
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle(rec));
      } catch (Exception exp) {
          exp.printStackTrace();
      }

    }
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster  handler=
       new newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster();
    dbHandler=handler;
    return handler;
  }

}
