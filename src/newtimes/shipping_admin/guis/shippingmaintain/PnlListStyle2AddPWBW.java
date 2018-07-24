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
import java.awt.*;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListStyle2AddPWBW extends PnlTableEditor  {
  static final String BUYER="  Buyer  ";
  static final String FTY = "  Maker  ";
  //static final String DIV = "Division";
  //static final String SEA = "Season";
  //static final String YEAR = "Year";
  //static final String RANGE = "Range";
  static final String SC_NO = " S/C NO. ";
  static final String PRX_TERM="PRICE\nTERM";
  static final String GOODS_DEST="DESTI-\nNATION";
  static final String STYLE = "  Style  ";
  static final String PO = "  PO  ";
  static final String UNIT = "Unit";
  static final String O_QTY = "ORDER\nQTY";
  static final String S_QTY = "SHIP\nQTY";
  static final String B_QTY = "BALANCE\nQTY";
  static final String SHIP_DRUP_DEST="Drop\nDest";
  static final String CLOSE="QTY\nDtl.";
  static InsertionOrderedHashMap iso = null;
  static public int rowPosition=-1;
  public PnlListStyle2AddPWBW() {
    getJtable().setRowHeight(20);
    getJtable().addMouseListener(new myMouseListener());
    newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles.PAGE_BEGIN=0;
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  public void firstPage(){
    if(rowPosition>0){
      goPage(rowPosition,_rowCounts);
    }else{
      super.firstPage();
    }
  }
  public class CellRender extends JLabel
      implements javax.swing.table.TableCellRenderer{
      public CellRender(){
      super();
     setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
     setOpaque(true); /* it\u00B4s essential */
     setHorizontalAlignment(JLabel.CENTER);
  }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
        String text =" ... "; //(value==null)?"":value.toString();
        setBackground(new java.awt.Color(0xF0,0xF0,0xF0)); // Decides the color
        setText(text);
     return this;
    }
  }

  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(BUYER,"BUYER");//0
      iso.put(FTY, "FTY");//1
      iso.put(SC_NO, "SC_NO");//2

      //sb.append(",(select production.prod_sc_prc_trm from production where production.prod_head_pk=V_STYLE.PROD_HEAD_PK) as sc_price_term,");
      //sb.append("(select production.prod_tgt_dest from production where production.prod_head_pk=V_STYLE.PROD_HEAD_PK) as goods_dest ");

      iso.put(PRX_TERM,"sc_price_term");//3
      iso.put(GOODS_DEST,"goods_dest");//4
      iso.put(STYLE, "STYLE");//5
      //iso.put(PO, "PO");
      iso.put(PO, "CUST_PO");//6
      iso.put(UNIT, "UNIT");//7
      iso.put(O_QTY, "O_QTY");//8
      iso.put(S_QTY, "S_QTY");//9
      iso.put(B_QTY, "B_QTY");//10
      iso.put(SHIP_DRUP_DEST,"drup_shipment_dest");//11
      iso.put(CLOSE,"CLOSED");//12
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    this.getJtable().getColumnModel().getColumn(12).setCellRenderer(new CellRender());

  }
  public void makeTable(java.util.Vector vct){
    super.makeTable(vct);
    //set width of eacht column
    getJtable().getColumnModel().getColumn(0).setPreferredWidth(60); //BUYER
    getJtable().getColumnModel().getColumn(1).setPreferredWidth(60); //MAKER
    getJtable().getColumnModel().getColumn(3).setPreferredWidth(80); //SC_NO
    getJtable().getColumnModel().getColumn(3).setPreferredWidth(80); //PRICE TERM
    getJtable().getColumnModel().getColumn(4).setPreferredWidth(80); //DESTINATION

    getJtable().getColumnModel().getColumn(5).setPreferredWidth(75); //STYLE
    getJtable().getColumnModel().getColumn(6).setPreferredWidth(70); //PO
    getJtable().getColumnModel().getColumn(7).setPreferredWidth(40); //UNIT
    getJtable().getColumnModel().getColumn(8).setPreferredWidth(55); //Order Qty
    getJtable().getColumnModel().getColumn(9).setPreferredWidth(40); //Ship Qty
    getJtable().getColumnModel().getColumn(10).setPreferredWidth(50); //Balance Qty
    getJtable().getColumnModel().getColumn(11).setPreferredWidth(55); //CLOSE
    try{
      for (int i = 0; i < vct.size(); i++) {
        Record recTmp = (Record)vct.get(i);
        if (recTmp.getInt("sty_seq") ==
            newtimes.shipping_admin.ShippingAdmin_Const.
            EDIT_SHIP_STYLE_STYLE_INT_SEQ) {
          //System.out.print("row selected at:"+i);
          getJtable().changeSelection(i, 0, false, false);
          break;
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  public void genDetailWindow(){
    //util.MiscFunc.showProcessingMessage();
    //System.out.println("");
    try{
      //newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JDialog dlg = new newtimes.shipping_admin.guis.
          shippingmaintain.DlgShowPoQtyDlt(
          util.PublicVariable.APP_FRAME, "Color Price Break Down Detail", true);
      dlg.setSize(775, 336);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
      //util.MiscFunc.hideProcessingMessage();
    }finally{
      //newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  class myMouseListener extends java.awt.event.MouseAdapter{

    public void mouseClicked(java.awt.event.MouseEvent e){
      //find out the click row,and activate the edit new ship style record command.
     if(getJtable().getSelectedRow()==-1)return;

     Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
     try{
       if (rec.get("FTY") == null) {
         exgui.verification.VerifyLib.showAlert("Maker Not Assigned Yet\nPlease Assigne Maker Of Po Before Shipping",
                                                "Maker Not Assigned");
         return;
       }
     }catch(Exception exp){
       exp.printStackTrace();
     }
     System.out.println("record to add of org style is :"+rec.toString());
     rowPosition=_rowPosition;
     /*
     Variables in ShipAdmin_Const class
     public static int  EDIT_SHIP_STYLE_STYLE_INT_SEQ=0;
     public static int  EDIT_SHIP_STYLE_SC_INT_SEQ=0;
     public static int  EDIT_SHIP_STYLE_SEQ_INT=0;*/
      try {
       newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = - 1; //new record
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =rec.getInt("sty_seq");
         if(getJtable().getSelectedColumn()== getJtable().getColumnCount()-1){
           // click the "..." button
           genDetailWindow();
           return;
         }
         /*
         Record recSRN=
             newtimes.shipping_admin.ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER.getRecordByPk(
             newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);

        String ship_packing_mode=(String)recSRN.get(55);//ship_packing_mode,'S' means Shipping,'P' means Packing
        */

           //----------------------------------------------------------------
           //20060729,for those stupid user,always confuse current phase is to select to add,not to edit,
           //have to enter the "edit" mode if click row are the added row
           if(newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle!=null &&
              newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle.get(String.valueOf(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ))!=null){
             String destShipStyleSeq=(String)
                 newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle.get(
                 String.valueOf(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ));

             newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = Integer.parseInt(destShipStyleSeq);
               newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =
                       newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ;
                   //newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.CUST_PO=(String)rec.get("CUST_PO");
                   processhandler.template.Properties.getCenteralControler().doCommandExecute(
                         new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle(rec));
             return;
           }
           //------------------------------------------------------------------------
           PnlEditShipStyle.isEditingShipQty=true;
           //newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.CUST_PO=(String)rec.get("CUST_PO");
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
                 new newtimes.shipping_admin.process.shiippingmaintain.TgrToAddSty2Shipping());

      } catch (Exception exp) {
          exp.printStackTrace();
      }

    }
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    newtimes.shipping_admin.process.shiippingmaintain.DB_StyleList4Add handler=
        newtimes.shipping_admin.process.shiippingmaintain.DB_StyleList4Add.getInstance();
    dbHandler=handler;
    return handler;
  }

}
