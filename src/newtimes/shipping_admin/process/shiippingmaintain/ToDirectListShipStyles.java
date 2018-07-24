package newtimes.shipping_admin.process.shiippingmaintain;
import processhandler.commands.*;
import database.datatype.Record;
import exgui.*;
import exgui.ultratable.*;
import processhandler.template.*;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.util.*;
public class ToDirectListShipStyles implements AbleToDirectListShipStyles{
  protected HashMap conditions;
  static protected util.InsertionOrderedHashMap columnNameMap=null;
  static final String BUYER="Buyer"  ;
  static final String FTY = "Maker";
  static final String SC_NO = "S/C NO.";
  static final String STYLE = "Style";
  static final String PO = "PO";
  static final String UNIT = "Unit";
  static final String O_QTY = "Order\nQty";
  static final String S_QTY = "Ship\nQty";
  static public int PAGE_BEGIN=0;
  public util.InsertionOrderedHashMap getHeadColumns(){
  try{
    return (util.InsertionOrderedHashMap)util.MiscFunc.deepCopy(columnNameMap);
  }catch(Exception e){
    e.printStackTrace();
    return null;
  }
 }

  public ToDirectListShipStyles() {
    columnNameMap=new util.InsertionOrderedHashMap();
    columnNameMap.put("SRN","ship_no");
    columnNameMap.put(BUYER,"BUYER");
    columnNameMap.put(FTY, "maker");
    columnNameMap.put(SC_NO, "SC_NO");
    columnNameMap.put(STYLE, "sty_STYLE");
    columnNameMap.put(PO, "sty_PO");
    columnNameMap.put(UNIT, "sty_UNIT");
    columnNameMap.put(O_QTY, "order_qty");
    columnNameMap.put(S_QTY, "shipped_qty");
    columnNameMap.put("BUYER\nCOMMISION","buy_comm_str");
    columnNameMap.put("MAKER\nDISCOUNT","maker_disc_str");
  }
  public void toDirectListShipStyles() {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
        new newtimes.shipping_admin.PnlBaseContainer();
         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
      pnlFunc.setButtons(false, false,false, false, false);
      pnlFunc.removalAddExtralButtons();
      /*
      newtimes.shipping_admin.guis.shippingmaintain.PnlListQryAddedStyles  pnl =
          new newtimes.shipping_admin.guis.shippingmaintain.PnlListQryAddedStyles();
      */

      InnerPnlListQryAddedStyles pnl=new InnerPnlListQryAddedStyles(
           new newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster(),
           14,getHeadColumns(),new java.util.Hashtable(),
           "View\nShipping","...",
           "View\nPacking","...");


      jframe.getContentPane().removeAll();
      //pnl.setBounds(0, 0, 775, 850);
      jframe.getContentPane().removeAll();
      pnl.setBounds(0, 0, 775, 500);
      pnl.setPreferredSize(new java.awt.Dimension(775, 500));
      //pnl.reload();
      //pnl.repaint();
      //pnl.validate();
      pnlFunc.setEditPanel(pnl);
      jframe.getContentPane().add(pnlFunc, null);
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
      jframe.repaint();
      jframe.validate();
      pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  public class InnerPnlListQryAddedStyles extends processhandler.template.PnlListQryRslt
   implements  exgui.ultratable.MakeTableNotify {
   PagedDataFactory    myHandler;
  public InnerPnlListQryAddedStyles(PagedDataFactory pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
     this.removeAll();
     this.add(this.pgTblList,BorderLayout.CENTER);
     myHandler=pagedDataFxy;
     this.pgTblList.setMakeTableNotifier(this);

  }
  public InnerPnlListQryAddedStyles(PagedDataFactory pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String titleStr1,String btnStr1,
        String titleStr2,String btnStr2
    ){
     super(pagedDataFxy,
           rowCount,
           columnMapping,
           object2StringConvertor,
           titleStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+titleStr2,
           btnStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+btnStr2
           );
     myHandler=pagedDataFxy;
     this.removeAll();
     //this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     add(this.pgTblList,BorderLayout.CENTER);
     this.pgTblList.setMakeTableNotifier(this);

  }
  public void MakingTable(Vector vct){
  setColumnWidth();
}
protected void setColumnWidth(){
  getInsideJtable().getColumnModel().getColumn(0).setPreferredWidth(93); //SRN
  getInsideJtable().getColumnModel().getColumn(1).setPreferredWidth(67); //buyer
  getInsideJtable().getColumnModel().getColumn(2).setPreferredWidth(67); //maker
  getInsideJtable().getColumnModel().getColumn(3).setPreferredWidth(92); //SC
 getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(68); //style
 getInsideJtable().getColumnModel().getColumn(5).setPreferredWidth(46); //po
 getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(23); //unit
 getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(40); //order qty
 getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(44); //ship qty
 getInsideJtable().getColumnModel().getColumn(9).setPreferredWidth(63); //buyer comm
 getInsideJtable().getColumnModel().getColumn(10).setPreferredWidth(57); //maker discount
 getInsideJtable().getColumnModel().getColumn(11).setPreferredWidth(55); //view ship ...
 getInsideJtable().getColumnModel().getColumn(12).setPreferredWidth(50); //view packing ...
}

  protected void setPagedTable(){
   //flip page to system properties.--Constants.XNT_LIST_QRY_RESLUT_BGN_AT;
  // System.out.println("current properties name or top_record_at"+this.getClass().getName()+"_TOP_RECORD_AT");
   int topRecAt=1;
   if(util.ApplicationProperites.getProperties(
       this.getClass().getName()+"_TOP_RECORD_AT")!=null){
     topRecAt = (
         (Integer) util.ApplicationProperites.getProperties(
         this.getClass().getName()+"_TOP_RECORD_AT")).intValue();
    // System.out.println("pgTblList._rowPosition restored ,valuse is:" + topRecAt);
    }
    if(PAGE_BEGIN==0){
      topRecAt=1;
    }
    super.setPagedTable();
    setColumnWidth();
  }
  protected void ini4NextPage(Record rec)throws Exception{
    util.ApplicationProperites.setProperties(
        this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));
       PAGE_BEGIN=pgTblList._rowPosition;
      newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = rec.getInt("ship_style_pk");//editing function
        newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =rec.getInt("sty_seq");
  }
  public void gridTableMouseEventHandler(MouseEvent e) {
    //find out the click row,and activate the edit new ship style record command.
    util.ApplicationProperites.setProperties(
      "newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles$InnerPnlListAddedStyles_TOP_RECORD_AT",
     new Integer(1));

   if(pgTblList.getJtable().getSelectedRow()==-1)return;
   Record rec=(Record)pgTblList.getDisplayingRecords().get(pgTblList.getJtable().getSelectedRow());
   int columnAt=pgTblList.getJtable().getSelectedColumn();
    try {
     if(columnAt==pgTblList.getJtable().getColumnCount()-2){
       String ship_packing_mode=(String)rec.get("ship_packing_mode");
       if(ship_packing_mode!=null && ship_packing_mode.equals("S")){
         newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle.isEditingShipQty=true;
       }else{
         newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle.isEditingShipQty=false;
       }
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
           ini4NextPage(rec);
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle(rec));
     }else  if(columnAt==pgTblList.getJtable().getColumnCount()-1){
        //if this ship record is
        String ship_packing_mode=(String)rec.get("ship_packing_mode");
       if(ship_packing_mode!=null && ship_packing_mode.equals("S")){
         exgui.verification.VerifyLib.showAlert("Sorry,This Record is Shipping Style,No Packing Data",
                                                "Sorry,No Packing Data For This Ship Style");
         return;
       }
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
         ini4NextPage(rec);
         processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_PACKING_COMMAND
         );
         Record recShipStyle=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select * from ship_style where ship_style_pk="+rec.getInt("ship_style_pk"),1,1).get(0);
          newtimes.shipping_admin.process.packing.TgrToEditPackingStyle tgr=
                  new newtimes.shipping_admin.process.packing.TgrToEditPackingStyle(rec);
          tgr.setPackingRecord(recShipStyle);
          processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
     }
    } catch (Exception exp) {
        exp.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
   }
}

}
