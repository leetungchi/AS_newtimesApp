package newtimes.shipping_admin.guis.shippingmaintain;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
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

public class PnlListStyles2Edit  extends PnlTableEditor  {
  static final String BUYER="   Buyer"  ;
  static final String FTY = "  Maker  ";
  static final String SC_NO = "    S/C NO.    ";
  static final String STYLE = "   Style  ";
  static final String PO = "  PO   ";
  static final String UNIT = "Unit";
  static final String O_QTY = "Order\nQty";
  static final String S_QTY = "Ship\nQty";
  //static InsertionOrderedHashMap iso = null;
  public javax.swing.JButton btnGetQty=new javax.swing.JButton("GET Shipped/Order QTY");
  public PnlListStyles2Edit() {
     getJtable().setRowHeight(20);
    getJtable().addMouseListener(new myMouseListener());
    getLowerRightPanel().add(btnGetQty);
    btnGetQty.addMouseListener(
       new java.awt.event.MouseAdapter(){
          public void mouseClicked(java.awt.event.MouseEvent me){
            toShowWithQty();
          }
       }
     );

  }




  protected void toShowWithQty(){
    try{
      HashMap hm = (HashMap)util.MiscFunc.deepCopy(newtimes.shipping_admin.
          ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION);
      newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.put("WITH_SHIP_QTY_ORDER_QTY", new Boolean(true));
      reload();
      newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.clear();
      newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.putAll(hm);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }


  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso=null;
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(BUYER,"BUYER");
      iso.put(FTY, "maker");
      iso.put(SC_NO, "SC_NO");
      iso.put(STYLE, "sty_STYLE");
      iso.put(PO, "sty_PO");
      iso.put(UNIT, "sty_UNIT");
      if (newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.
          containsKey("WITH_SHIP_QTY_ORDER_QTY")) {
        iso.put(O_QTY, "order_qty");
        iso.put(S_QTY, "shipped_qty");
      }
      iso.put("BUYER\nCOMMISION","buy_comm_str");
      iso.put("MAKER\nDISCOUNT","maker_disc_str");
    }
    return iso;
  }
  public void doAddNew(){
    try{
      if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
        if(null!=newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS){
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS.clear();
        }else{
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS=new java.util.HashMap();
        }
        if(null!=newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED){
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED.clear();
        }else{
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED=new java.util.HashMap();
        }

        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryPoFtyInv()
            );
      }else{
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.shipping_admin.process.shiippingmaintain.
            TgrToQryScStyPo4Style()
            );
      }

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Activating \"Add New Shipping Style\"\nPlease Contact System Manager",
                                             "Error in Add New Style");

    }
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
    newtimes.shipping_admin.process.shiippingmaintain.DB_AddedShipStyle  handler=
       new newtimes.shipping_admin.process.shiippingmaintain.DB_AddedShipStyle();
    dbHandler=handler;
    return handler;
  }
}
