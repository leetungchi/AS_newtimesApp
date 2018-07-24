package newtimes.shipping_admin.guis.packing;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;
import newtimes.shipping_admin.process.packing.*;
import java.util.Vector;
import javax.swing.JTable;
import java.awt.Cursor;
import newtimes.shipping_admin.process.packing.*;
import javax.swing.JButton;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditPacking4Style extends PnlTableEditor
    implements javax.swing.event.TableModelListener{
  protected HashMap backupedSizeQty=new HashMap();
  protected String testUnit=null;
  protected String getDoubleCammaHeasColumn[]=null;
  protected boolean initializing=false;
  protected boolean _tableProcessingChange=false;
  protected boolean _isTblValid=false;
  protected int priceColumnAt=5;
  protected Cursor ksr=null;
  protected boolean isOnlyOneEditingCell=false;
  protected Vector cartonVct=null;
  protected Vector licenseeVct=null;
  protected Vector colorVct=null;
  boolean isRefinding=false;
  Vector licenseeColorsPrice=null;
  int handler2remove_count=0;
  java.text.DecimalFormat formatter = null;//new java.text.DecimalFormat("######.###");
  java.text.DecimalFormat Dzformatter = null;//new java.text.DecimalFormat("######.###");
  protected int orgSizeType=0;
  protected String orgCammaedColumnsDefString=null;
  protected String importHeadColumn[]=null;
  protected static String COLUMN_CTN_BGN="CTN\nBGN",COLUMN_CTN_END="CTN\nEND", COLUMN_PRICE_COLOR="COLOR ¡¿";
  protected static String COLUMN_CTN_NNTWT="NetNet\nWt.",COLUMN_CTN_NET_WT="NET\nWt.",COLUMN_CTN_GROSSWT="Gross\nWt.";
  protected static String COLUMN_CTN_MEAS="MEAS.",COLUMN_CTN_MEAS_UNIT="UNIT ",COLUMN_CTN_CBM="CBM";
  protected static String COLUMN_CTN_MEAS_W=" W ",COLUMN_CTN_MEAS_L=" L ",COLUMN_CTN_MEAS_H=" H ";
  protected static String COLUMN_CTN_WT_UNIT=" UNIT";
  protected int wt_unit_columnAt=0;
  protected int mea_unit_columnAt=0;

  protected int MEAS_L_COLUMNAT=0;
  protected int MEAS_W_COLUMNAT=0;
  protected int MEAS_H_COLUMNAT=0;

  protected int Wt_GW_COLUMNAT=0;
  protected int Wt_NW_COLUMNAT=0;
  protected int Wt_NetNetWt_COLUMNAT=0;

  static String MEAS_UNITS[]={"INCH","CM"};
  static String WT_UNITS[]={"KG","LB"};
  protected String lastUpdatedShipStyleRemark="";
  PnlShowShipStyleTempData pnlShipStyleHead=new PnlShowShipStyleTempData();
  JButton btnModifySizeColor=new JButton("Add Color & Change Size Def.");
  int TOTAL_COLUMNAT=0;
  JButton btnDeleteThisShipStyle=new JButton("DELETE THIS SHIP STYLE");
  boolean isProcessingAllDeleted=false;
   IntFormatKeyListener keyadp = new IntFormatKeyListener();
   DecFormatKeyListener decKeyAdp=new DecFormatKeyListener();
   CbxListen cbxListen=new CbxListen();
   java.util.HashMap  hmTbl2backup=null;
  public PnlEditPacking4Style(newtimes.shipping_admin.process.packing.DB_ShipStylePacking packingEngin) {
    super(null,0,null,null);
    super.dbHandler=packingEngin;
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    if(!newtimes.shipping_admin.ShippingAdmin_Const.isShipClosed()){
      super.getLowerRightPanel().add(btnModifySizeColor);
      btnModifySizeColor.addMouseListener(new ClickProdColorSizeChange());

      super.getLowerRightPanel().add(btnDeleteThisShipStyle);
      btnDeleteThisShipStyle.addMouseListener(new ClickToDeleteShipStyle());
    }


    pnlShipStyleHead.setPreferredSize(new java.awt.Dimension(660,145));
    super.add(pnlShipStyleHead,java.awt.BorderLayout.NORTH);
    java.awt.FlowLayout flout=new java.awt.FlowLayout();
    super.getLowerRightPanel().setLayout(flout);
    cartonVct=((DB_ShipStylePacking)dbHandler).Cartons;
    colorVct=((DB_ShipStylePacking)dbHandler).ProdColors;
    formatter=new java.text.DecimalFormat("#######.##");
    Dzformatter=new java.text.DecimalFormat("######0.00");
    try{
      pnlShipStyleHead.lblSCNO.setText((String)
         ((DB_ShipStylePacking)dbHandler).recOrgStyle.get("sty_sc_no"));
      pnlShipStyleHead.lblStyleItem.setText((String)
         ((DB_ShipStylePacking)dbHandler).recOrgStyle.get("sty_style"));
      pnlShipStyleHead.txtShipStylePackingRemark.setText((String)
          ((DB_ShipStylePacking)dbHandler).recShipStyle.get("ship_style_packing_rmrk"));
      pnlShipStyleHead.lblSRN.setText(
          getOrgSrnString(((DB_ShipStylePacking)dbHandler).recShipStyle));
      super.doInit();
      isProcessingAllDeleted=false;

    }catch(Exception exp){
      exp.printStackTrace();

    }

  }
  protected void goPage( int bgn,int rowcount){
    super.goPage(bgn,rowcount);
    if(cbxListen==null)cbxListen=new CbxListen();
    getJtable().editCellAt(0,wt_unit_columnAt);
    ((javax.swing.JComboBox)getJtable().getEditorComponent()).addItemListener(cbxListen);
    getJtable().editCellAt(0,mea_unit_columnAt);
    ((javax.swing.JComboBox)getJtable().getEditorComponent()).addItemListener(cbxListen);
    getJtable().editCellAt(-1,-1);
    //makeTablebackup();
  }
  protected class CbxListen implements java.awt.event.ItemListener  {
    public void itemStateChanged(java.awt.event.ItemEvent  ie){
      //System.out.println("jcombobox changed");
      int edtRow=getJtable().getEditingRow();
      int edtCol=getJtable().getEditingColumn();
      javax.swing.JComboBox jtf=(javax.swing.JComboBox)getJtable().getEditorComponent();
      if((edtRow!=-1) && (edtRow!=getJtable().getRowCount()-1) &&
         (edtCol==wt_unit_columnAt || edtCol==mea_unit_columnAt)){
        for (int i = edtRow + 1; i < getJtable().getRowCount(); i++) {
          getJtable().setValueAt(jtf.getSelectedItem(), i, edtCol);
        }
      }

    }
  }

  protected class ClickToDeleteShipStyle extends java.awt.event.MouseAdapter{
   public void mouseClicked(java.awt.event.MouseEvent me){
     if(!exgui.verification.VerifyLib.showConfirm("Do You Really Want To Delete This Ship Style And Cartons ?",
                                                  "Warnning,Delete All The Cartons And This Ship Style")){
       return ;
     }
     try{
       ((DB_ShipStylePacking)dbHandler).deleteShipStyle(((DB_ShipStylePacking)dbHandler).recShipStyle);
       isProcessingAllDeleted=true;
       doExit();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
     }
   }
  }
  public boolean isContextModified(){
    if(!newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnConfirm.isEnabled())return false;
    if(isProcessingAllDeleted)return false;
    return super.isContextModified();
  }

  protected class ClickProdColorSizeChange extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      Record shipStyle = ((DB_ShipStylePacking)dbHandler).recShipStyle;
      Record orgStyRec = ((DB_ShipStylePacking)dbHandler).recOrgStyle;
      try {
        newtimes.shipping_admin.guis.packing.DlgProdColorAndSizeDef dlg =
            new newtimes.shipping_admin.guis.packing.DlgProdColorAndSizeDef(
            util.PublicVariable.APP_FRAME,
            "Define The Size And Colors For PACKING",
            true, (String)shipStyle.get("ship_Sty_size_column"),
            orgStyRec.getInt(1),getJtable()
            );
        dlg.setSize(666, 400);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();
        if (dlg.getOperationStatus() == dlg.STATUS_CLOSE_CANCEL ||
            dlg.getOperationStatus() == dlg.STATUS_OPERATING) {
          return;
        }else{
            String sizecolumn=dlg.finalSizeListString;
            if(sizecolumn==null||sizecolumn.trim().length()==0)sizecolumn="";
            String orgSizeString=(String)shipStyle.get("ship_sty_size_column");
            if(orgSizeString==null)orgSizeString="";
            if(!orgSizeString.trim().equalsIgnoreCase(sizecolumn.trim())){
              if(getJtable().getRowCount()>0) ((DB_ShipStylePacking)dbHandler).clearAllCartons();
              shipStyle.set("ship_sty_size_column",sizecolumn);
              //show gui again.
              newtimes.shipping_admin.process.packing.TgrToEditPackingStyle tgr=
                  new newtimes.shipping_admin.process.packing.TgrToEditPackingStyle(shipStyle);
              tgr.setPackingRecord(shipStyle);
              processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
            }
            if(dlg.isColorChanged){
              doUpdate();
              newtimes.shipping_admin.process.packing.TgrToEditPackingStyle tgr=
                  new newtimes.shipping_admin.process.packing.TgrToEditPackingStyle(shipStyle);
              tgr.setPackingRecord(shipStyle);
              processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
            }
        }
      } catch (Exception exp) {
          exp.printStackTrace();
      }
    }

  }
  protected void makeTablebackup(){
     if(hmTbl2backup==null)hmTbl2backup=new HashMap();
     hmTbl2backup.clear();
     if(((DB_ShipStylePacking) dbHandler).appendRowIndex==0)return;
     int endColmn=
           (isOnlyOneEditingCell)?
           (priceColumnAt+1):
           (importHeadColumn.length+priceColumnAt);
     //if(endColmn==1)endColmn=0;
     try{
       //for (int i = 0; i < rowcount; i++) {
       int endrow=((DB_ShipStylePacking) dbHandler).appendRowIndex;
       for (int i = 0; i < endrow; i++) {
         for (int j = 0; j < endColmn - priceColumnAt; j++) {
           //System.out.println("get record from "+String.valueOf(i) + "_" +String.valueOf(j));
           Object qtyObj = getJtable().getValueAt(i, j + priceColumnAt + 1).toString();
           hmTbl2backup.put(String.valueOf(i)+","+String.valueOf( j + priceColumnAt + 1),qtyObj);
         }
       }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public void doPreUpdate()throws UnreadyToUpdate ,Exception{
    if(!super.confirmUpdate()) throw new UnreadyToUpdate();

      if(!lastUpdatedShipStyleRemark.trim().toUpperCase().equals(pnlShipStyleHead.txtShipStylePackingRemark.getText().toUpperCase().trim())){
        ((DB_ShipStylePacking) dbHandler).recShipStyle.set("ship_style_packing_rmrk",
            pnlShipStyleHead.txtShipStylePackingRemark.getText());
        lastUpdatedShipStyleRemark=pnlShipStyleHead.txtShipStylePackingRemark.getText();
      }
      super.doUpdate(); //save the ship_price & carton to update.
      getJtable().editCellAt(-1,0);
      /*filter the null-ship-price pk row before update*/

      Vector vctPrxCtn2update=new Vector();
      Vector storedPrxCtnVct=((DB_ShipStylePacking) dbHandler).vct2updateTempStay;
      int pkColumAt=-1;
      for(int i=0;i<storedPrxCtnVct.size();i++){
        Record rec=(Record)storedPrxCtnVct.get(i);
        if(pkColumAt==-1)pkColumAt=util.MiscFunc.getFieldIndexAtRecord(rec,"@@CTN_PK");
        Object obkPk=rec.get(pkColumAt);
        if(obkPk==null || obkPk.toString().equals("-1")) continue;
        vctPrxCtn2update.add(rec);
      }
      ((DB_ShipStylePacking) dbHandler).vct2updateTempStay.clear();
      ((DB_ShipStylePacking) dbHandler).vct2updateTempStay.addAll(vctPrxCtn2update);
      /*
       ---NOTE,For DataVector class,onlye "get(int)" function provides fields(column) name compeletement,not support subList
      if(((DB_ShipStylePacking)dbHandler).appendRowIndex!=getJtable().getRowCount()){
        java.util.List data2removae=((DB_ShipStylePacking) dbHandler).vct2updateTempStay.subList(
        ((DB_ShipStylePacking)dbHandler).appendRowIndex,getJtable().getRowCount());
        ((DB_ShipStylePacking) dbHandler).vct2updateTempStay.removeAll(data2removae);
      }*/
       Vector vct =getData2Update();//getData2Update();
         //remove the row if total value is zero.
        ((DB_ShipStylePacking) dbHandler).updatePriceCartonQty(vct);
  }
  public static String getOrgSrnString(Record shipStyRec)throws Exception{
    if(shipStyRec.getInt(0)<1)return (String)shipStyRec.get("ship_no");
    StringBuffer sb=new StringBuffer("select a.ship_no from shipping a ,ship_sc b,ship_style c ");
    sb.append("where a.ship_no =b.SHIP_NO ");
    sb.append("and b.SHIP_SC_PK=c.SHIP_SC_PK ");
    sb.append("and c.ship_style_pk=");
    sb.append(String.valueOf(shipStyRec.getInt(0)));
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,1);
    if(vct==null || vct.size()==0)throw new Exception(sb.toString());
    Record rec=(Record)vct.get(0);
    return (String)rec.get(0);
  }
  public boolean isIniOK(){
    return ((DB_ShipStylePacking)dbHandler).isDBHandlerInitOK();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      String columnName=storedRecordColumn[columnAt];
      rec.set(columnName,value2update);
      if(rec.getInt("ship_price_pk")<0){
        int index=((rec.getInt("ship_price_pk"))*-1)-1;
        ((Record)getDisplayingRecords().get(index)).set(columnName,value2update);
      }
      /*
      if(((DB_ShipStylePacking) dbHandler).isDisplayingDummyRows){
        int index=((rec.getInt("ship_price_pk"))*-1)-1;
        ((Record)getDisplayingRecords().get(index)).set(columnName,value2update);
      }*/
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(dbHandler==null)return null;
    try{
      InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
      iso.put(COLUMN_CTN_BGN,"@@BGN_CTN");
      iso.put(COLUMN_CTN_END,"@@END_CTN");
      iso.put(COLUMN_PRICE_COLOR,"$$PROD_COLOR_PK");
      priceColumnAt=2;
      String sizeColumns=
          (String)((DB_ShipStylePacking)dbHandler).recShipStyle.get("SHIP_STY_SIZE_COLUMN");
       if(sizeColumns==null)sizeColumns="";
       //----------for future to compare----------
       orgCammaedColumnsDefString=sizeColumns;
       //System.out.println("orgCammaedColumnsDefString phase 1 is:"+orgCammaedColumnsDefString);
       //----------for future to compare----------
       importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
       if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
         importHeadColumn=new String[]{};
         isOnlyOneEditingCell=true;
       }
        if(!isOnlyOneEditingCell){//if(importHeadColumn.length>0){
         for(int i=0;i<importHeadColumn.length;i++){
           iso.put(importHeadColumn[i],"##"+importHeadColumn[i]);
         }
       }else{
         iso.put("QTY","_TOTAL_VALUE");
       }
       if(!isOnlyOneEditingCell){
         TOTAL_COLUMNAT = iso.size();
         iso.put("TOTAL\nQTY", "_TOTAL_VALUE");
       }

       //MEAS_W, MEAS_L, MEAS_H, WT_UNIT
       Wt_NW_COLUMNAT=iso.size();
       iso.put(COLUMN_CTN_NET_WT,"@@NET_WT");
       Wt_GW_COLUMNAT=iso.size();
       iso.put(COLUMN_CTN_GROSSWT,"@@GROSS_WT");
       Wt_NetNetWt_COLUMNAT=iso.size();
       iso.put(COLUMN_CTN_NNTWT,"@@NNW");

       wt_unit_columnAt=iso.size();
       iso.put(COLUMN_CTN_WT_UNIT,"@@WT_UNIT");
       //iso.put(COLUMN_CTN_MEAS,"@@MEAS");

       MEAS_L_COLUMNAT=iso.size();
       iso.put(COLUMN_CTN_MEAS_L,"@@MEAS_L");
       MEAS_W_COLUMNAT=iso.size();
       iso.put(COLUMN_CTN_MEAS_W,"@@MEAS_W");
       MEAS_H_COLUMNAT=iso.size();
       iso.put(COLUMN_CTN_MEAS_H,"@@MEAS_H");

       mea_unit_columnAt=iso.size();
       iso.put(COLUMN_CTN_MEAS_UNIT,"@@MEAS_UNIT");
       iso.put(COLUMN_CTN_CBM,"@@CBM");


       return iso;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }

  }

  public void doPrint() throws java.lang.Exception {
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    initializing=true;
   // if(licenseeColorsPrice==null) licenseeColorsPrice=((DB_ShipStylePacking)dbHandler).getClrLxyPrxs();
   DB_ShipStylePacking mydbHandler=(DB_ShipStylePacking)dbHandler;
   //unitsRecords=mydbHandler.UnitsData;
   Vector colorRecords=mydbHandler.ProdColors;
    try{
      isRefinding=true;
       //add the color combobox into the row editor
       multiEditorJTableInSuper.addJComboBox(2,colorRecords,"prod_color_name","PROD_COLOR_PK");
       //designe the column group
       if(!isOnlyOneEditingCell){
         for(int i=0;i<importHeadColumn.length;i++){
            multiEditorJTableInSuper.setTableColumn2Grp("SIZE", i+1+priceColumnAt);
         }
       }
       multiEditorJTableInSuper.setTableColumn2Grp("  MEAS.",MEAS_L_COLUMNAT);
       multiEditorJTableInSuper.setTableColumn2Grp("  MEAS.",MEAS_W_COLUMNAT);
       multiEditorJTableInSuper.setTableColumn2Grp("  MEAS.",MEAS_H_COLUMNAT);

       //multiEditorJTableInSuper.setTableColumn2Grp("   WEIGHT",Wt_GW_COLUMNAT);
       //multiEditorJTableInSuper.setTableColumn2Grp("   WEIGHT",Wt_NW_COLUMNAT);
       //multiEditorJTableInSuper.setTableColumn2Grp("   WEIGHT",Wt_NetNetWt_COLUMNAT);
       java.util.Hashtable ht=getObject2StringConvertor();
       multiEditorJTableInSuper.setTextEditorVerifiers(ht);



       //put into unit column to select
       multiEditorJTableInSuper.addJComboBox(wt_unit_columnAt,WT_UNITS,false);
       multiEditorJTableInSuper.addJComboBox(mea_unit_columnAt,MEAS_UNITS,false);

      isRefinding=false;
    }catch(Exception e){
      e.printStackTrace();
    }
    initializing=false;
  }
  public void tableChanged(javax.swing.event.TableModelEvent te){
    int row=te.getFirstRow();
    int col=te.getColumn();
    System.out.println("fire value is:"+getJtable().getValueAt(row,col));
    return;
    /*
    if(te.getColumn()!=0)return;
    if(initializing)return;
    int row=te.getFirstRow();
    int col=te.getColumn();*/
    //System.out.println("obj in row,col is "+getJtable().getValueAt(row,col).getClass().getName());
   /*
    if(getJtable().getValueAt(row,col) instanceof exgui.ultratable.Wraper4tblCbx){
    exgui.ultratable.Wraper4tblCbx valueObj=
        (exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(row,col);
    Integer intObj=new Integer(valueObj.getValue().toString());
    HashMap tempHm=((DB_ShipStylePacking)dbHandler).getPriSeqMapPrx();
    getJtable().setValueAt(tempHm.get(intObj.toString()).toString(),row,1);
   }
   */
  }

  protected int getEachPageRowCount() {
    return 99999;
  }

  protected Hashtable getObject2StringConvertor() {
    Hashtable ht=new Hashtable();
    if(dbHandler==null)return ht;
    try{
      Object objIntVfy = new MyIntVfy();//exgui.verification.CellFormat.getIntVerifierAllowNull(3);
      Object objChar20=exgui.verification.CellFormat.getOrdinaryField(20);
      Object objFltVfy=new MyFloatVfy();//exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
      ht.put(COLUMN_CTN_BGN,objIntVfy);
      ht.put(COLUMN_CTN_END,objIntVfy);

      ht.put(COLUMN_CTN_NET_WT,objIntVfy);
      ht.put(COLUMN_CTN_GROSSWT,objIntVfy);
      ht.put(COLUMN_CTN_NNTWT,objIntVfy);
      //ht.put(COLUMN_CTN_MEAS,objChar20);

      ht.put(COLUMN_CTN_CBM,objChar20);

      ht.put(COLUMN_CTN_MEAS_L,objFltVfy);
      ht.put(COLUMN_CTN_MEAS_W,objFltVfy);
      ht.put(COLUMN_CTN_MEAS_H,objFltVfy);



       String sizeColumns=
           (String)((DB_ShipStylePacking)dbHandler).recShipStyle.get("SHIP_STY_SIZE_COLUMN");
       if(sizeColumns==null)sizeColumns="";
       importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
      if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
       importHeadColumn=new String[]{};
       isOnlyOneEditingCell=true;
      }
      //to test if with sizes column or not.
      //Object fltVfy=new MyFormatAllowNull(7,2);
          //exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
      Object myDzVfy=new myfldVfyObj(7,2);
      if(importHeadColumn.length==0){
         ht.put("QTY",myDzVfy);
         isOnlyOneEditingCell=true;
         //ht.put("TOTAL",fltVfy);
      }else{
        isOnlyOneEditingCell=false;
        for(int i=0;i<importHeadColumn.length;i++){
          ht.put(importHeadColumn[i],myDzVfy);
        }
      }
      return ht;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected PagedDataFactory getPagedDataFactory() {
    //dbHandler=new DB_ShipStylePacking();
    //licenseeColorsPrice=((DB_ShipStylePacking)dbHandler).getClrLxyPrxs();
    return dbHandler;
  }
 public Vector getData2UpdateForAdd(){
   return getData2Update(((DB_ShipStylePacking)dbHandler).appendRowIndex,getJtable().getRowCount());
 }
 public Vector getData2Update(){
   return getData2Update(0,((DB_ShipStylePacking)dbHandler).appendRowIndex);
 }
 public Vector getData2Update(int rowBegin,int rowEnd){
   HashMap mappedRecordInCell=((DB_ShipStylePacking)dbHandler).getMappedRec2TblCell();
   //depends on Color/Licencee will display or not.
   javax.swing.JTable _jtbl=getJtable();
   Vector ouptVct=new Vector();
   myfldVfyObj tmpVfyObj=new myfldVfyObj(7,2);
   int rowcount=rowEnd;//((DB_ShipStylePacking)dbHandler).appendRowIndex;
      //getJtable().getRowCount();
       //((DB_ShipStylePacking)dbHandler).appendRowIndex;
   //int endColmn=(getJtable().getColumnCount()-1)-priceColumnAt;
   try{
     determPricColPosition();
      /*
      if((((DB_ShipStylePacking)dbHandler).recOrgStyle.getInt("STY_QTY_TYPE")&0x01) == 1){
         priceColumnAt=5;//with licensee
      }else{
        priceColumnAt=4;//without licensee column
      }
      */
   }catch(Exception exp){
     exp.printStackTrace();
   }

   int endColmn=
         (isOnlyOneEditingCell)?
         (priceColumnAt+1):
         (importHeadColumn.length+priceColumnAt);
   //if(endColmn==1)endColmn=0;
   try{
     String modifyUser=(String)util.PublicVariable.USER_RECORD.get("usr_code");
     //for (int i = 0; i < rowcount; i++) {
     for (int i = rowBegin; i < rowcount; i++) {
       for (int j = 0; j < endColmn-priceColumnAt; j++) {
         //System.out.println("get record from "+String.valueOf(i) + "_" +String.valueOf(j));
         Record rec = (Record) mappedRecordInCell.get(String.valueOf(i) + "_" +
             String.valueOf(j));
         rec.set("record_modify_user",modifyUser);
      Object qtyObj = _jtbl.getValueAt(i, j + priceColumnAt + 1).toString();
      String storedPosKey=String.valueOf(i)+","+String.valueOf( j + priceColumnAt + 1);
      Object orgQtyObj=hmTbl2backup.get(storedPosKey);
      if(hmTbl2backup.containsKey(storedPosKey) && util.MiscFunc.isEqual(qtyObj,orgQtyObj))continue;
         if (qtyObj != null && (!qtyObj.toString().trim().equals(""))) {
           String qtyValue = qtyObj.toString();
           if (!tmpVfyObj.isFormatValid(qtyValue, i, j + priceColumnAt + 1)) {
             exgui.verification.VerifyLib.showAlert(tmpVfyObj.formatPromptMsg()
                 , "Data Format Error");
             _jtbl.editCellAt(i, j + priceColumnAt + 1);
             return new Vector();
           }
           ((DB_ShipStylePacking)dbHandler).Dz2Record(rec, qtyObj.toString());
         }
         else {
           ((DB_ShipStylePacking)dbHandler).Dz2Record(rec, 0);
         }

         ouptVct.add(rec);
       }
     }
   }catch(Exception e){
     e.printStackTrace();
     return new Vector();
   }
   return ouptVct;
 }

 public void doPaste(){
  //System.out.println(" retrieve copy key is:"+id4ApplicationProperties+"_"+newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
  Object storedObj=util.ApplicationProperites.getProperties(
   id4ApplicationProperties+"_"+((DB_ShipStylePacking)dbHandler).recShipStyle.getInt(0)
  );
    if(storedObj==null){
      exgui.verification.VerifyLib.showPlanMsg(
      "No Copied Data To Paste","No Copied Data To Paste");
      return;
    }
    if(getJtable().getSelectedRow()<0){
      exgui.verification.VerifyLib.showPlanMsg(
      "Please Select A Row To Paste Copied Data","Please Select A Row");
      return;
    }
    int selectedRow[]=getJtable().getSelectedRows();
    if(super.getJtable().getCellEditor()!=null)
      super.getJtable().getCellEditor().cancelCellEditing();
    copiedColumns=(Object[])storedObj;
    for(int j=0;j<selectedRow.length;j++){
      for (int i = 0; i < copiedColumns.length; i++) {
        if(getJtable().getModel().isCellEditable(selectedRow[j],i)){
          getJtable().setValueAt(
              copiedColumns[i],
              selectedRow[j], i
              );
        }
      }
    }

  sumEveryColumn();
}
 public void doCopy(){
   if(getJtable().getSelectedRow()<0){
     exgui.verification.VerifyLib.showPlanMsg(
     "Please Select A Row To Copy","Please Select A Row");
     return;
   }
   int selectedRow=getJtable().getSelectedRow();
   if(getJtable().getCellEditor()!=null)getJtable().getCellEditor().cancelCellEditing();
   copiedColumns=new Object[getJtable().getColumnCount()];
   for(int i=0;i<copiedColumns.length;i++){
     copiedColumns[i]=
       getJtable().getValueAt(
       selectedRow,i
      );
   }
   try{
     util.ApplicationProperites.setProperties(
       id4ApplicationProperties+"_"+((DB_ShipStylePacking)dbHandler).recShipStyle.getInt(0) ,
       util.MiscFunc.deepCopy(copiedColumns)
     );
   }catch(Exception e){
      e.printStackTrace();
   }
 }


 public void doDelete()throws Exception{
   try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
     int selectRow[] =
      getJtable().getSelectedRows();
  if (selectRow.length < 0) {
    exgui.verification.VerifyLib.showPlanMsg(
        "Please Select A Row To Delete", "Please Select A Row");
    return;
  }
  if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete This Record?","Are You Sure ?")){
    return;
  }
  util.MiscFunc.showProcessingMessage();
  if (getJtable().getRowCount() > 0) {
    //Vector vct = getData2Update();
    //if (vct.size() == 0)  return; //no data to update,mabe cell is wrong..
    this.doUpdate();
  }
  Vector vct2delete=new Vector();
  for(int i=0;i<selectRow.length;i++){
    vct2delete.add(getDisplayingRecords().get(selectRow[i]));
  }
  ((DB_ShipStylePacking) dbHandler).deleteRecords(vct2delete);
  //exgui.verification.VerifyLib.showPlanMsg("Delete OK", "Delete OK");
  //((DB_ShipStylePacking) dbHandler).force2regetCartonRecords();
  this.goPage(1, 99999, false);
  ((DB_ShipStylePacking) dbHandler).udpateQtyTbl2Text(
   newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(
        getJtable(),priceColumnAt)
   );

  /*
  ((DB_ShipStylePacking) dbHandler).udpateQtyTbl2Text(
   newtimes.production.ProdMaintain_Properties.table2Text(getJtable()));*/

  //find out the data to delete...
   }catch(UnreadyToUpdate utu){
     return;
   }catch(Exception exp){
     throw exp;
   }finally{
     util.MiscFunc.hideProcessingMessage();
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }
 }
 protected void determPricColPosition(){
   try{
     /*
     int pri_col_begn = 0;
     if ((((DB_ShipStylePacking)dbHandler).recShipStyle.getInt("SHIP_STY_QTY_TYPE") & 0x01) !=0) {
        //with licensee column
        pri_col_begn++;
     }
     if ((((DB_ShipStylePacking)dbHandler).recShipStyle.getInt("SHIP_STY_QTY_TYPE") & 0x04) !=0) {
        //with color
        pri_col_begn++;
     }
    priceColumnAt=pri_col_begn+3;
     */
    priceColumnAt=2;
   }catch(Exception exp){
     exp.printStackTrace();
   }
 }
 public void doAddNew()throws Exception{
   try{
     util.MiscFunc.showProcessingMessage();
     if (getJtable().getRowCount() > 0) {
       //doPreUpdate();//may throw the UnreadyToUpdate.
       this.doUpdate();
     }
      //int presurededSize=getJtable().getRowCount();
     ((DB_ShipStylePacking)dbHandler).is2Append=true;
     this.goPage(1,99999);
     //((DB_ShipStylePacking)dbHandler).appendRowIndex=presurededSize;
     //newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setButtons(false,true,true,true,false);
   }catch(UnreadyToUpdate utu){
     return;
   }catch(Exception exp){
     throw exp;
   }finally{
     util.MiscFunc.hideProcessingMessage();
   }
 }
 protected synchronized void minusHandler2removeCount(){
   --handler2remove_count;
 }
 protected synchronized void addHandler2removeCount(){
   ++handler2remove_count;
 }
 protected synchronized int  getHandler2removeCount(){
   return handler2remove_count;
 }
 public void setToRemoveData(Vector vct,int bgnat,int count,String byUser,
                             int DELETE_USER_AT,int DELETE_FLAG_AT)throws Exception{
    addHandler2removeCount();
    Thread aThread=new Thread(
      new handler2remove(vct,bgnat,count,byUser,DELETE_USER_AT,DELETE_FLAG_AT));
    aThread.start();
 }
 class handler2remove implements Runnable{
   Vector vct;
   int bgnat,count,DELETE_FLAG_AT,DELETE_USER_AT;
   String byUser;
   handler2remove(Vector _vct,int _bgnat,int _count,String _byUser,
                             int _DELETE_USER_AT,int _DELETE_FLAG_AT){
      vct=_vct;
      bgnat=_bgnat;
      count=_count;
      byUser=_byUser;
      DELETE_FLAG_AT=_DELETE_FLAG_AT;
      DELETE_USER_AT=_DELETE_USER_AT;
   }
   public void run(){
     for(int i=bgnat;i<bgnat+count;i++){
       ((Record)vct.get(i)).set(DELETE_FLAG_AT,-1);
       ((Record)vct.get(i)).set(DELETE_USER_AT,byUser);
      }
     minusHandler2removeCount();
   }
 }
 class UnreadyToUpdate extends Exception{

 }
 protected void addMultiRows()throws Exception{
   newtimes.production.ProdMaintain_Properties.setWaitCursor();
   util.MiscFunc.showProcessingMessage();
   HashMap mappedRecordInCell=((DB_ShipStylePacking)dbHandler).getMappedRec2TblCell();
   getJtable().editCellAt(-1,0);
   getData2UpdateForAdd();
   Vector orgRecords=getDisplayingRecords();
   int bgnIndex=((DB_ShipStylePacking)dbHandler).appendRowIndex;
   Vector data2add=new Vector();
   int endColmn=
         (isOnlyOneEditingCell)?
         (priceColumnAt+1):
         (importHeadColumn.length+priceColumnAt);

   for(int i=bgnIndex;i<getJtable().getRowCount();i++){
     Object obj1=getJtable().getValueAt(i,0);
     Object obj2=getJtable().getValueAt(i,1);
     //if no carton definition,skip it.
     if((obj1==null||obj1.toString().trim().length()==0) && (obj2==null||obj2.toString().trim().length()==0)){
     }else{
           Record orgBlankShipPrxQtyCtnRec=(Record)orgRecords.get(i);
          if(isOnlyOneEditingCell){
             Record recQty = (Record)mappedRecordInCell.get(String.valueOf(i) +"_" + String.valueOf(0));
            orgBlankShipPrxQtyCtnRec.set("_TOTAL_VALUE",recQty);
          }else{
            for (int j = 0; j < endColmn - priceColumnAt; j++) {
              Record recQty = (Record)mappedRecordInCell.get(String.valueOf(i) +"_" + String.valueOf(j));
              orgBlankShipPrxQtyCtnRec.set("##"+importHeadColumn[j],recQty);
            }
          }
          data2add.add(orgBlankShipPrxQtyCtnRec);
     }
   }
    if(data2add.size()>0) ((DB_ShipStylePacking) dbHandler).addRecords(data2add);
 }
 public void doUpdate() throws Exception{
   try{
       if(!getMultiEditorJTable().isTableOk()) throw new UnreadyToUpdate();
       util.MiscFunc.showProcessingMessage();
       super.kvtModifiedField2Records(getMultiEditorJTable().getModifiedRowAndColumn());
       if(((DB_ShipStylePacking)dbHandler).appendRowIndex>0){
         addMultiRows();
         doPreUpdate();
       }else{
         addMultiRows();
       }
       //doPreUpdate();
       //newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setButtons(true,true,true,true,true);
       ((DB_ShipStylePacking)dbHandler).is2Append=false;
       this.goPage(1,99999);
       //((DB_ShipStylePacking)dbHandler).appendRowIndex=getJtable().getRowCount();
       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setButtons(true,true,true,true,true);
       return;
   }catch(UnreadyToUpdate utu){
     return;
   }finally{
     util.MiscFunc.hideProcessingMessage();
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }
 }
 protected void adjColumWidth(){
   getJtable().getColumnModel().getColumn(0).setPreferredWidth(35); //CTN BGN
   getJtable().getColumnModel().getColumn(1).setPreferredWidth(30); //CTN END
   getJtable().getColumnModel().getColumn(2).setPreferredWidth(65); //CTN BGN
   if(isOnlyOneEditingCell){
     getJtable().getColumnModel().getColumn(3).setPreferredWidth(48); //TOTAL QTY,but only one size
   }else{
     for(int i=3;i<TOTAL_COLUMNAT;i++){
       getJtable().getColumnModel().getColumn(i).setPreferredWidth(30);//set to every size colum with
     }
     getJtable().getColumnModel().getColumn(TOTAL_COLUMNAT).setPreferredWidth(48); //TOTAL QTY,but only one size
   }
   getJtable().getColumnModel().getColumn(Wt_NW_COLUMNAT).setPreferredWidth(30);
   getJtable().getColumnModel().getColumn(Wt_GW_COLUMNAT).setPreferredWidth(40);
   getJtable().getColumnModel().getColumn(Wt_NetNetWt_COLUMNAT).setPreferredWidth(41);
   getJtable().getColumnModel().getColumn(wt_unit_columnAt).setPreferredWidth(40);
   getJtable().getColumnModel().getColumn(mea_unit_columnAt).setPreferredWidth(40);

   getJtable().getColumnModel().getColumn(MEAS_H_COLUMNAT).setPreferredWidth(30);
   getJtable().getColumnModel().getColumn(MEAS_L_COLUMNAT).setPreferredWidth(30);
   getJtable().getColumnModel().getColumn(MEAS_W_COLUMNAT).setPreferredWidth(30);

   //multiEditorJTableInSuper.setTableColumn2Grp("   WEIGHT",Wt_GW_COLUMNAT);
   //multiEditorJTableInSuper.setTableColumn2Grp("   WEIGHT",Wt_NW_COLUMNAT);
   //multiEditorJTableInSuper.setTableColumn2Grp("   WEIGHT",Wt_NetNetWt_COLUMNAT);

 }
 protected void makeTable(Vector vct){
   initializing=true;
   super.makeTable(vct,false);
   sumEveryColumn();
   initializing=false;
   table_snapshot=util.MiscFunc.table2Text(getJtable());
   adjColumWidth();
   makeTablebackup();
 }

 protected synchronized void sumEveryColumn(){
   initializing=true;
   backupedSizeQty.clear();
   if(getDisplayingRecords().size()<1)return;
   try{
     /*
      String sizeColumns=
         (String)((DB_ShipStylePacking)dbHandler).recOrgStyle.get("STY_SIZE_COLUMN");
     if(sizeColumns==null)sizeColumns="";
      importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
     */
    if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
     importHeadColumn=new String[]{};
     isOnlyOneEditingCell=true;
    }

       if(importHeadColumn.length==0){
         isOnlyOneEditingCell=true;
         float totalQtyValue=0;
         for(int i=0;i<(getJtable().getRowCount()-1);i++){
          Object qtyObj=getJtable().getValueAt(i,TOTAL_COLUMNAT);
           backupedSizeQty.put(
              String.valueOf(i)+"_"+String.valueOf(0),
              qtyObj);
           float fltValue=MyFloatPars(qtyObj);
           if(isDzUnit()){
             totalQtyValue=((DB_ShipStylePacking)dbHandler).addDzValue(totalQtyValue,fltValue);
           }else{
             totalQtyValue+=fltValue;
           }
         }
       }else{
         //find out column name of extends column
         isOnlyOneEditingCell=false;
         int extendColumnBgnAt=0;
         int extendColumnEndAt=TOTAL_COLUMNAT;
         /*
         for(int i=0;i<getJtable().getColumnCount()-1;i++){
           String headColumnName=getJtable().getColumnName(i);
           if(headColumnName.equals(importHeadColumn[0])){
             extendColumnBgnAt=i;
             break;
           }
         }*/
         extendColumnBgnAt=priceColumnAt+1;
         float hzTotal[]=new float[getJtable().getRowCount()];
         backupedSizeQty.clear();
         float theEndTotal=0;
         for(int j=0;j<getJtable().getRowCount();j++){
           for(int i=extendColumnBgnAt;i<extendColumnEndAt;i++){
                Object objValue=
                    getJtable().getValueAt(j,i);
                float qtyValue=MyFloatPars(objValue);
                if(isDzUnit()){
                  hzTotal[j]=
                      ((DB_ShipStylePacking)dbHandler).addDzValue(hzTotal[j],qtyValue);
                }else{
                  hzTotal[j]=hzTotal[j]+qtyValue;
                }
            backupedSizeQty.put(String.valueOf(j)+"_"+String.valueOf(i),objValue);
           }
           if(isDzUnit()){
             theEndTotal=((DB_ShipStylePacking)dbHandler).addDzValue(theEndTotal,hzTotal[j]);
           }else{
             theEndTotal+=hzTotal[j];
           }
           getJtable().setValueAt(
              formatter.format(hzTotal[j]),j,extendColumnEndAt);//set to end of the row.
         }
       }
   }catch(Exception e){
     e.printStackTrace();
   }

   initializing=false;
 }
 protected boolean isDzUnit(){
   try{
     if(testUnit==null){
       testUnit=(String)
       ((DB_ShipStylePacking)dbHandler).recOrgStyle.get("STY_UNIT");
     }
     return  testUnit.toLowerCase().trim().startsWith("dz");
   }catch(Exception e){
     e.printStackTrace();
     return false;
   }
 }

protected synchronized boolean modifiedYYvalue(String str,int row,int column ){
   if(initializing)return true;
   if(!getJtable().isCellEditable(row,column))return true;
  //find out the last sumned row & column of YY1,
  try{
   float newQty=MyFloatPars(str);
   Object objOrgQty=
      backupedSizeQty.get(String.valueOf(row)+"_"+String.valueOf(column));
      backupedSizeQty.put(String.valueOf(row)+"_"+String.valueOf(column),str);
   float orgFloat=MyFloatPars(objOrgQty);
    if(!isOnlyOneEditingCell){
      //with size
      Object orgHtotalObj=getJtable().getValueAt(row,TOTAL_COLUMNAT);
      float  orgHtotal=MyFloatPars(orgHtotalObj);
      if(isDzUnit()){
        orgHtotal=((DB_ShipStylePacking)dbHandler).minusDzValue(orgHtotal,orgFloat);
        orgHtotal=((DB_ShipStylePacking)dbHandler).addDzValue(orgHtotal,newQty);
      }else{
        orgHtotal-=orgFloat;
        orgHtotal+=newQty;
      }
      getJtable().setValueAt(
          formatter.format(orgHtotal),
          row,TOTAL_COLUMNAT);
    }else{
       //no size.
       //directly sum all the value of each quentity column .
       if(isDzUnit()){
         int rowcount=getJtable().getRowCount();
         int colcount=TOTAL_COLUMNAT;
         for(int i=0;i<rowcount;i++){
           Object orgObjStr=getJtable().getValueAt(i,colcount);
           if(orgObjStr!=null){
             String objStr=orgObjStr.toString();
             float qtyValue=
                 (objStr.trim().length()==0)?0:Float.parseFloat(objStr);
           }
         }
       }else{
       }
    }
    if(Float.parseFloat(str)==0)
      getJtable().setValueAt("",row,column);
    else
      getJtable().setValueAt(str,row,column);
     return true;
  }catch(Exception e){
    e.printStackTrace();
    return false;
  }
 }


 protected class myCellEditablePolicy implements exgui.CellEditablePolicy{
   public boolean isCellEditable(int row,int column){
     if(isOnlyOneEditingCell)return true;
     if(column==TOTAL_COLUMNAT)return false;
     return true;
     /*
     if(isOnlyOneEditingCell){
       if(row==(getJtable().getRowCount()-1)){
         return false;
       }
     }else{
       if ((row == (getJtable().getRowCount() - 1)) ||
           (column == (getJtable().getColumnCount() - 1))) {
           return false;
       }
     }
     return true;*/
   }
 }

protected class FormaterPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
  Object orgFvyObj=null;
  public FormaterPrx(){
    orgFvyObj=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
  }
  public exgui.ultratable.KeyProcess getKeyListener(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
  }

  public int getMaxLength(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
  }
  public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
  public boolean isFormatValid(String inStr,int row,int column){
    if(inStr==null||inStr.trim().length()==0)return true;
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
  }
  public String Obj2String(Object obj2kvt){
    if(obj2kvt==null)return "";
    if(Float.parseFloat(obj2kvt.toString())==0)return "";
    return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
  }
   public Object cellStringToObject(String String2kvt){
     if(String2kvt==null)return new Float(0);
     if(String2kvt.trim().equals(""))return new Float(0);
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
   }
}
 class DecFormatKeyListener extends IntFormatKeyListener{
 DecFormatKeyListener(){
   tomask="0123456789-.";
 }
 public void keyReleased(java.awt.event.KeyEvent e){
   if(e.isActionKey())return;
   if(e.getKeyCode()==e.VK_BACK_SPACE){
        javax.swing.ActionMap map =  myTextComponent.getActionMap();
        javax.swing.Action action = (javax.swing.Action)map.get(
          javax.swing.text.DefaultEditorKit.deletePrevCharAction);
        action.actionPerformed( null );
      e.consume();
   }
   //show to other text fields
   int edtRow=getJtable().getEditingRow();
   int edtCol=getJtable().getEditingColumn();
   javax.swing.text.JTextComponent  jtf=//myTextComponent;
    (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
   if((edtRow!=-1) && (edtRow!=getJtable().getRowCount()-1) &&
      (edtCol==MEAS_L_COLUMNAT || edtCol==MEAS_W_COLUMNAT|| edtCol==MEAS_H_COLUMNAT )){
     String destCBM=null;
     for (int i = edtRow + 1; i < getJtable().getRowCount(); i++) {
       getJtable().setValueAt(jtf.getText().trim(), i, edtCol);
       Object objValMeasL=getJtable().getValueAt(i,MEAS_L_COLUMNAT);
       Object objValMeasW=getJtable().getValueAt(i,MEAS_W_COLUMNAT);
       Object objValMeasH=getJtable().getValueAt(i,MEAS_H_COLUMNAT);
       if(objValMeasL!=null && objValMeasL.toString().trim().length()>0
          && objValMeasW!=null && objValMeasW.toString().trim().length()>0
          && objValMeasH!=null && objValMeasH.toString().trim().length()>0 ){
         destCBM=objValMeasL.toString()+"x"+objValMeasW.toString()+"x"+objValMeasH.toString();
         getJtable().setValueAt(destCBM,i,mea_unit_columnAt+1);
       }
     }
     if(destCBM!=null)getJtable().setValueAt(destCBM,edtRow,mea_unit_columnAt+1);
   }
 }
}

 class IntFormatKeyListener extends java.awt.event.KeyAdapter
    implements exgui.ultratable.KeyProcess{
   protected javax.swing.text.JTextComponent myTextComponent=null;
   protected String tomask="0123456789-";
   public void keyPressed(java.awt.event.KeyEvent e){
     //System.out.println("Press get key Code:"+e.getKeyCode());
     if(e.isActionKey())return;
     if(e.getKeyCode()==e.VK_BACK_SPACE){
          javax.swing.ActionMap map =  myTextComponent.getActionMap();
          javax.swing.Action action = (javax.swing.Action)map.get(
            javax.swing.text.DefaultEditorKit.deletePrevCharAction);
          action.actionPerformed( null );
        e.consume();
     }
   }
   public void keyReleased(java.awt.event.KeyEvent e){
     if(e.isActionKey())return;
     if(e.getKeyCode()==e.VK_BACK_SPACE){
          javax.swing.ActionMap map =  myTextComponent.getActionMap();
          javax.swing.Action action = (javax.swing.Action)map.get(
            javax.swing.text.DefaultEditorKit.deletePrevCharAction);
          action.actionPerformed( null );
        e.consume();
     }
     //show to other text fields
     int edtRow=getJtable().getEditingRow();
     int edtCol=getJtable().getEditingColumn();
     javax.swing.text.JTextComponent  jtf=//myTextComponent;
       (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
     if((edtRow!=-1) && (edtRow!=getJtable().getRowCount()-1) &&
        (edtCol==Wt_GW_COLUMNAT || edtCol==Wt_NetNetWt_COLUMNAT|| edtCol==Wt_NW_COLUMNAT )){
       for (int i = edtRow + 1; i < getJtable().getRowCount(); i++) {
         getJtable().setValueAt(jtf.getText().trim(), i, edtCol);
       }
     }

   }
   public void keyTyped(java.awt.event.KeyEvent e){
     System.out.println("Type get key char:"+e.getKeyChar());
     if(e.isActionKey())return;
     if(e.getKeyCode()==e.VK_BACK_SPACE)return;
     if(e.getKeyCode()==e.VK_DELETE)return;
     if(e.getKeyChar()=='-'&&
        myTextComponent.getCaretPosition()!=0){
       // "-" is only allow to be showen at first character
       e.consume();
       return;
     }
     String myCharStr=String.valueOf(e.getKeyChar());
     if(tomask.indexOf(myCharStr)==-1){
       java.awt.Toolkit.getDefaultToolkit().beep();
       e.consume();
     }

   }
   public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp){
     myTextComponent=txtcmp;
     myTextComponent.addKeyListener(this);
   }
}

 public class MyFloatVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
  Object orgFvyObj = exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
   public int getMaxLength(){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
   }

   public exgui.ultratable.KeyProcess getKeyListener(){
     return decKeyAdp;
   }

   public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
   public boolean isFormatValid(String inStr,int row,int column){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
   }
   public String Obj2String(Object obj2kvt){
     return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
   }
    public Object cellStringToObject(String String2kvt){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
    }

 }


public class MyIntVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
 Object orgFvyObj = exgui.verification.CellFormat.getIntVerifierAllowNull(3);
  public int getMaxLength(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
  }

  public exgui.ultratable.KeyProcess getKeyListener(){
    return keyadp;
  }

  public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
  public boolean isFormatValid(String inStr,int row,int column){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
  }
  public String Obj2String(Object obj2kvt){
    return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
  }
   public Object cellStringToObject(String String2kvt){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
   }

}
public class VfyFOBPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
  Object orgFvyObj=null;
  public VfyFOBPrx(){
    orgFvyObj=new FormaterPrx();
  }
  public int getMaxLength(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
  }

  public exgui.ultratable.KeyProcess getKeyListener(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
  }

  public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
  public boolean isFormatValid(String inStr,int row,int column){
    if(!getJtable().isCellEditable(row,column))return true;
    boolean isVld= ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
    if(!isVld)return isVld;



    //test if have to modify the remain 3 column.
    for(int i=priceColumnAt-2;i<priceColumnAt+1;i++){
      Object value=getJtable().getValueAt(row,i);
      if(value==null||
         value.toString().trim().length()==0||
         value.toString().trim().equals("0")){
        getJtable().setValueAt(inStr,row,i);
      }
    }
    return isVld;
  }
  public String Obj2String(Object obj2kvt){
    return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
  }
   public Object cellStringToObject(String String2kvt){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
   }

 }

protected class myfldVfyObj implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{

   int _maxLength=0;
   int _intDigitLength=0,_floatDigitLength=0;
   String headString,tailString;
   String orgWarnningMsg="String must be in float format,such as 12345.91";
   String warnningMsg=null;
   public myfldVfyObj(int intDigitLength,int floatDigitLength){
     _maxLength=intDigitLength+floatDigitLength+1;//include "." character
     _intDigitLength=intDigitLength;
     _floatDigitLength=floatDigitLength;
     String totalString="##############################################";
     headString=totalString.substring(0,_intDigitLength);
     tailString=totalString.substring(0,_floatDigitLength);
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return
         ((exgui.ultratable.CellTxtEditorFormat)exgui.verification.CellFormat.getDoubleFormat(
          _intDigitLength,_floatDigitLength)).getKeyListener();
   }

   public int getMaxLength(){return _maxLength ;}
   public String formatPromptMsg(){return warnningMsg;}
   public boolean isFormatValid(String org_inStr,int row,int column){
          String inStr=org_inStr;
          if(column<=priceColumnAt)return true;
          if(inStr==null){
             inStr="0.0";
          }
          if(inStr.trim().length()==0) inStr="0.0";
            try {
             warnningMsg=orgWarnningMsg;
             if(inStr.indexOf(".")==-1 && inStr.length()>_intDigitLength) return false;
             if(inStr.indexOf(".")==(inStr.length()-1))return false;
             if(inStr.indexOf(".")==0)return false;
             if(inStr!=null && inStr.indexOf(".")!=-1){
               String arrDgs[]=util.MiscFunc.SplitByStringTokenizer(inStr,".");
               if(arrDgs[0].length()>_intDigitLength) return false;
               //Double d = new Double(((Number)formatter.parse((String)inStr)).doubleValue());
                  if(isDzUnit()){
                    //.08->1 .16->2 .25->3 .33->4 .41->5 .50->6 .58->7 .66->8 .75->9 .83->10 .91->11
                    Object value=getJtable().getValueAt(row,column);
                    if(value!=null){
                      //Double dx=new Double(value.toString());//test if throws Exception;
                      float xntFloatValue=MyFloatPars(value);
                      String DecPartOfValue=util.MiscFunc.split(Dzformatter.format(xntFloatValue),".")[1];
                      if(!((DB_ShipStylePacking)dbHandler).DecToDozeMapping.containsKey(DecPartOfValue)){
                        warnningMsg="The Number of Size Qty after the Decimal Point should be one of fallowing :\n"+
                        "00,08,16,25,33,41,50.58,66,75,83,91";
                        return false;
                      }
                      return( modifiedYYvalue(inStr,row,column));
                      //return true;
                    }
                    return ( modifiedYYvalue(inStr,row,column));
                  }
               return (modifiedYYvalue(inStr,row,column));
             }else{
               if(exgui.verification.VerifyLib.isInteger(inStr)){
                 return(modifiedYYvalue(inStr,row,column));
               }else{
                 return false;
               }
             }
           } catch (Exception ex) {
             //ex.printStackTrace();
             return false;
           }
   }
   public String Obj2String(Object obj2kvt){
      if(obj2kvt==null) return "";
      if(obj2kvt instanceof Float){
          if(((Float)obj2kvt).floatValue()==0)return "";
         String value= formatter.format(obj2kvt);
         return value;
      }
      if(obj2kvt instanceof Double){
          if(((Double)obj2kvt).doubleValue()==0)return "";
         String value= formatter.format(obj2kvt);
         return value;
       }else{
        String value=obj2kvt.toString();
         return value;
      }
   }
    public Object cellStringToObject(String String2kvt){
       if(String2kvt==null) return new Float(0);
       if(String2kvt.trim().length()==0) return new Float(0);
           try {
             Float d = new Float(
               ((Number)formatter.parse((String)String2kvt)).floatValue());
             return d;
           } catch (java.text.ParseException ex) {
             return new Float(0);
           }
    }
   }
  float MyFloatPars(Object obj2parse)throws Exception {
    if(obj2parse==null)return 0;
    if(obj2parse.toString().trim().length()==0)return 0;
    try{
      return Float.parseFloat(obj2parse.toString());
    }catch(Exception e){
      e.printStackTrace();
      return 0;
    }
  }
 }

