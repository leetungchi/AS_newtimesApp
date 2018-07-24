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

public class PnlEditPackingDirectQty extends PnlTableEditor
    implements javax.swing.event.TableModelListener{
  static newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster dbShipMaster;
  Record recShipMaster=null;
  protected HashMap backupedSizeQty=new HashMap();
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
  protected static String COLUMN_CTN_BGN="CTN\nBGN",COLUMN_CTN_END="CTN\nEND", COLUMN_PRICE_COLOR="COLOR      ";
  protected static String COLUMN_CTN_NNTWT="NetNet\nWt.",COLUMN_CTN_NET_WT="NET\nWt.",COLUMN_CTN_GROSSWT="Gross\nWt.";
  protected static String COLUMN_CTN_MEAS="MEAS.",COLUMN_CTN_MEAS_UNIT="UNIT ",COLUMN_CTN_CBM="CBM",COLUMN_CTN_GRP="GRP";

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
  protected int CTN_GRP_COLUMNAT=0;

  static String MEAS_UNITS[]={"INCH","CM"};
  static String WT_UNITS[]={"KG","LB"};
  protected String lastUpdatedShipStyleRemark="";
  PnlShowShipStyleTempData pnlShipStyleHead=new PnlShowShipStyleTempData();
  public JButton btnModifySizeColor=new JButton("Change Size Definitions");
  int TOTAL_COLUMNAT=0;
  public JButton btnDeleteThisShipStyle=new JButton("DELETE THIS SHIP STYLE");
  boolean isProcessingAllDeleted=false;
   IntFormatKeyListener keyadp = new IntFormatKeyListener();
   DecFormatKeyListener decKeyAdp=new DecFormatKeyListener();
   CbxListen cbxListen=new CbxListen();
   java.util.HashMap  hmTbl2backup=null;
   String orgPackingType="";
   boolean isStyleRemarkChanged;
   exgui.ultratable.MultiEditorJTable multiEditorJTableToNotify;
  public PnlEditPackingDirectQty(newtimes.shipping_admin.process.packing.DB_PackingDirectQty packingEngin) {
    super(null,0,null,null);
    super.dbHandler=packingEngin;
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);

    //if(newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnConfirm.isEnabled()){
      super.getLowerRightPanel().add(btnModifySizeColor);
      btnModifySizeColor.addMouseListener(new ClickProdColorSizeChange());

      super.getLowerRightPanel().add(btnDeleteThisShipStyle);
      btnDeleteThisShipStyle.addMouseListener(new ClickToDeleteShipStyle());
    //}


    pnlShipStyleHead.setPreferredSize(new java.awt.Dimension(660,145));
    super.add(pnlShipStyleHead,java.awt.BorderLayout.NORTH);
    java.awt.FlowLayout flout=new java.awt.FlowLayout();
    super.getLowerRightPanel().setLayout(flout);
    cartonVct=((DB_PackingDirectQty)dbHandler).Cartons;
    colorVct=((DB_PackingDirectQty)dbHandler).ProdColors;
    formatter=new java.text.DecimalFormat("#######.##");
    Dzformatter=new java.text.DecimalFormat("######0.00");
    try{
      pnlShipStyleHead.lblSCNO.setText((String)
         ((DB_PackingDirectQty)dbHandler).recOrgStyle.get("sty_sc_no"));
      pnlShipStyleHead.lblStyleItem.setText((String)
         ((DB_PackingDirectQty)dbHandler).recOrgStyle.get("sty_style"));
      pnlShipStyleHead.txtShipStylePackingRemark.setText((String)
          ((DB_PackingDirectQty)dbHandler).recShipStyle.get("ship_style_packing_rmrk"));
      lastUpdatedShipStyleRemark=pnlShipStyleHead.txtShipStylePackingRemark.getText();
      pnlShipStyleHead.lblSRN.setText(
          getOrgSrnString(((DB_PackingDirectQty)dbHandler).recShipStyle));
      super.doInit();
      isProcessingAllDeleted=false;
      if(dbShipMaster==null){
        dbShipMaster = new
            newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster();
      }
     recShipMaster=dbShipMaster.getRecordByPk(pnlShipStyleHead.lblSRN.getText());
     orgPackingType=(String)recShipMaster.get("ship_gf");
     orgPackingType=(orgPackingType==null)?"":orgPackingType;
     pnlShipStyleHead.txtPackingType.setText(orgPackingType);

    }catch(Exception exp){
      exp.printStackTrace();

    }

  }

  public class INTQTY_VFY implements exgui.ultratable.CellTxtEditorFormat ,exgui.Object2String{
    int _maxLength=0;
    Object myIntVfy=null;
    public  INTQTY_VFY(int maxLength){
       _maxLength=maxLength;
        myIntVfy= exgui.verification.CellFormat.getIntVerifierAllowNull(7);

    }
    public int getMaxLength(){return _maxLength;}
    public String formatPromptMsg(){return "String Must be numeric";}

    public KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)myIntVfy).getKeyListener();
    }
    protected synchronized void sumTheRow(int row){
      System.out.println("calles sumTheRow,row at:"+row);
      int total=0;
      for(int i=3;i<TOTAL_COLUMNAT;i++){
        Object obj=getJtable().getValueAt(row,i);
        //System.out.println("obj in cell:"+row+","+i+" is:"+((obj==null)?"0":obj.toString()));
        if(obj!=null && obj.toString().trim().length()!=0) total+=Integer.parseInt(obj.toString());
      }
      getJtable().setValueAt(new Integer(total),row,TOTAL_COLUMNAT);
    }
    public boolean isFormatValid(String inStr,int row,int column){
       if(!((exgui.ultratable.CellTxtEditorFormat)myIntVfy).isFormatValid(inStr,row,column))return false;
       getJtable().setValueAt(inStr,row,column);
       sumTheRow(row);
       return true;
    };
     public Object cellStringToObject(String String2kvt){
       return ((exgui.ultratable.CellTxtEditorFormat)myIntVfy).cellStringToObject(String2kvt);
     }
    public String Obj2String(Object obj){
       return ((exgui.Object2String)myIntVfy).Obj2String(obj);
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
    //test if ship_style_pk >0 existed
    //System.out.println("TESTING ((DB_PackingDirectQty)dbHandler).recShipStyle ======"+((DB_PackingDirectQty)dbHandler).recShipStyle);
    //makeTablebackup();

     //add new mode
    if(((DB_PackingDirectQty)dbHandler).recShipStyle.getInt(0)<0 &&
       ((DB_PackingDirectQty)dbHandler).recShipStyle.getInt(0)>-5000){
       if(newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnConfirm.isEnabled()){

         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnAdd.setEnabled(false);
         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnDelete.setEnabled(false);
       }
    }else{
      //editing mode
      if(newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnConfirm.isEnabled()){
        //add new mode
        newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnAdd.setEnabled(true);
        newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnDelete.setEnabled(true);
      }

    }
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
       ((DB_PackingDirectQty)dbHandler).deleteShipStyle(((DB_PackingDirectQty)dbHandler).recShipStyle);
       isProcessingAllDeleted=true;
       doExit();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
     }
   }
  }
  public boolean isContextModified(){
    //if(isStyleRemarkChanged)return true;
    if(!newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.btnConfirm.isEnabled())return false;
    if(isProcessingAllDeleted)return false;
    return super.isContextModified();
  }

  protected class ClickProdColorSizeChange extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      Record shipStyle = ((DB_PackingDirectQty)dbHandler).recShipStyle;
      Record orgStyRec = ((DB_PackingDirectQty)dbHandler).recOrgStyle;
      try {
        newtimes.shipping_admin.guis.packing.DlgProdColorAndSizeDef dlg =
            new newtimes.shipping_admin.guis.packing.DlgProdColorAndSizeDef(
            util.PublicVariable.APP_FRAME,
            "Define The Size  For PACKING",
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
              if(getJtable().getRowCount()>0) ((DB_PackingDirectQty)dbHandler).clearAllCartons();
              shipStyle.set("ship_sty_size_column",sizecolumn);
              if(shipStyle.getInt(0)>0){
                  newtimes.shipping_admin.process.shiippingmaintain.DB_ShipStyle shipStyHandler=new
                     newtimes.shipping_admin.process.shiippingmaintain.DB_ShipStyle(shipStyle.getInt(0));
                  shipStyHandler.updateRecord(shipStyle);
              }
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
     if(((DB_PackingDirectQty) dbHandler).appendRowIndex==0)return;
     int endColmn=
           (isOnlyOneEditingCell)?
           (priceColumnAt+1):
           (importHeadColumn.length+priceColumnAt);
     //if(endColmn==1)endColmn=0;
     try{
       //for (int i = 0; i < rowcount; i++) {
       int endrow=((DB_PackingDirectQty) dbHandler).appendRowIndex;
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
  private void updateShipRemarkAndPackingType()throws Exception{
    isStyleRemarkChanged=false;
    if(!lastUpdatedShipStyleRemark.equals(pnlShipStyleHead.txtShipStylePackingRemark.getText())){
      ((DB_PackingDirectQty) dbHandler).recShipStyle.set("ship_style_packing_rmrk",
          pnlShipStyleHead.txtShipStylePackingRemark.getText());
      lastUpdatedShipStyleRemark=pnlShipStyleHead.txtShipStylePackingRemark.getText();
      isStyleRemarkChanged=true;
    }
    if(!pnlShipStyleHead.txtPackingType.getText().trim().equalsIgnoreCase(
         orgPackingType)){
        //do update process
         recShipMaster.set("ship_gf",pnlShipStyleHead.txtPackingType.getText().trim());
         Vector vct=new Vector();
         vct.add(recShipMaster);
         dbShipMaster.updateRecords(vct);
         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.set("ship_gf",
             pnlShipStyleHead.txtPackingType.getText().trim());
         orgPackingType=pnlShipStyleHead.txtPackingType.getText().trim();
      }
  }
  public void doPreUpdate()throws UnreadyToUpdate ,Exception{
    if(!super.confirmUpdate()) throw new UnreadyToUpdate();

      if(!lastUpdatedShipStyleRemark.equals(pnlShipStyleHead.txtShipStylePackingRemark.getText())){
        ((DB_PackingDirectQty) dbHandler).recShipStyle.set("ship_style_packing_rmrk",
            pnlShipStyleHead.txtShipStylePackingRemark.getText());
        lastUpdatedShipStyleRemark=pnlShipStyleHead.txtShipStylePackingRemark.getText();
      }
      super.doUpdate(); //save the ship_price & carton to update.
      getJtable().editCellAt(-1,0);
      /*filter the null-ship-price pk row before update*/

      Vector vctPrxCtn2update=new Vector();
      Vector storedPrxCtnVct=((DB_PackingDirectQty) dbHandler).vct2updateTempStay;
      int pkColumAt=-1;
      for(int i=0;i<storedPrxCtnVct.size();i++){
        Record rec=(Record)storedPrxCtnVct.get(i);
        if(pkColumAt==-1)pkColumAt=util.MiscFunc.getFieldIndexAtRecord(rec,"@@CTN_PK");
        Object obkPk=rec.get(pkColumAt);
        if(obkPk==null || Integer.parseInt(obkPk.toString())<0) continue;
        //rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
        vctPrxCtn2update.add(rec);
      }
      ((DB_PackingDirectQty) dbHandler).vct2updateTempStay.clear();
      ((DB_PackingDirectQty) dbHandler).vct2updateTempStay.addAll(vctPrxCtn2update);
       Vector vct =getData2Update();//getData2Update();
         //remove the row if total value is zero.
        ((DB_PackingDirectQty) dbHandler).updatePriceCartonQty(vct);
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
    return ((DB_PackingDirectQty)dbHandler).isDBHandlerInitOK();
  }
  public void check999()throws UnreadyToUpdate{
    //boolean isSureGreaterThan999=false;
    getJtable().editCellAt(-1,-1);
    for(int i=0;i<getJtable().getRowCount();i++){
        Object objBgnCtn=getJtable().getValueAt(i,0);
        Object objEndCtn=getJtable().getValueAt(i,1);
        int initCtnBgn=(objBgnCtn==null||objBgnCtn.toString().trim().length()==0)?0:Integer.parseInt(objBgnCtn.toString());
        int initEndBgn=(objEndCtn==null||objEndCtn.toString().trim().length()==0)?0:Integer.parseInt(objEndCtn.toString());
        if(initCtnBgn>99999||initEndBgn>99999){
          exgui.verification.VerifyLib.showAlert("Carton#  Can Not Greater Than 99999",
                                                 "Carton# Too Large");
          throw new UnreadyToUpdate();
          /*
          if (exgui.verification.VerifyLib.showConfirm(
              "Carton#  greater Than 99999,Do you sure ?",
              "Carton# Greatern Than 99999 ", false)) {
             //isSureGreaterThan999 = true;
             return;
          }else{
            throw new UnreadyToUpdate();
          }*/

        }
   }
  }
  protected void checkBgnCtnEndCtn()throws UnreadyToUpdate{
    getJtable().editCellAt(-1,-1);
    boolean isSureGreaterThan999=false;
     for(int i=0;i<getJtable().getRowCount();i++){
         Object objBgnCtn=getJtable().getValueAt(i,0);
         Object objEndCtn=getJtable().getValueAt(i,1);
         int initCtnBgn=(objBgnCtn==null||objBgnCtn.toString().trim().length()==0)?0:Integer.parseInt(objBgnCtn.toString());
         int initEndBgn=(objEndCtn==null||objEndCtn.toString().trim().length()==0)?0:Integer.parseInt(objEndCtn.toString());
         if((!isSureGreaterThan999) && (initCtnBgn>99999||initEndBgn>99999)){
           exgui.verification.VerifyLib.showAlert("Carton#  greater Than 99999",
                                                  "Carton# Too Large");
           getJtable().changeSelection(i,1,false,false);
           getJtable().editCellAt(i,1);
           ((javax.swing.JComponent)getJtable().getEditorComponent()).grabFocus();
           ((javax.swing.text.JTextComponent)getJtable().getEditorComponent()).selectAll();

           throw new UnreadyToUpdate();
           /*
           if(exgui.verification.VerifyLib.showConfirm("Carton#  greater Than 99999,Do you sure ?",
                                                       "Carton# Greatern Than 99999 ",false)){

             isSureGreaterThan999=true;

           }else{
             getJtable().changeSelection(i,1,false,false);
             getJtable().editCellAt(i,1);
             ((javax.swing.JComponent)getJtable().getEditorComponent()).grabFocus();
             ((javax.swing.text.JTextComponent)getJtable().getEditorComponent()).selectAll();
             //((javax.swing.JComponent)getJtable() ).grabFocus();
             throw new UnreadyToUpdate();
           }*/
         }

         if((objBgnCtn==null||objBgnCtn.toString().trim().length()==0) && (objEndCtn==null||objEndCtn.toString().trim().length()==0)) continue;
         if((objEndCtn!=null&& objEndCtn.toString().trim().length()>0)){
           int ctnBgn=Integer.parseInt(objBgnCtn.toString());
           int ctnEnd=Integer.parseInt(objEndCtn.toString());
           if(ctnBgn>ctnEnd){
             exgui.verification.VerifyLib.showAlert(
             "Begin Carton Can Not Greater Than End Carton",
            "Begin Carton Can Not Greater Than End Carton"
             );
             getJtable().changeSelection(i,1,false,false);
             getJtable().editCellAt(i,1);
             ((javax.swing.JComponent)getJtable().getEditorComponent()).grabFocus();
             ((javax.swing.text.JTextComponent)getJtable().getEditorComponent()).selectAll();
             //((javax.swing.JComponent)getJtable() ).grabFocus();
             throw new UnreadyToUpdate();
           }

         }
     }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      String columnName=storedRecordColumn[columnAt];
      rec.set(columnName,value2update);
      if(rec.getInt("packing_qty_pk")<0){
        int index=((rec.getInt("packing_qty_pk"))*-1)-1;
        ((Record)getDisplayingRecords().get(index)).set(columnName,value2update);
      }
      /*
      if(((DB_PackingDirectQty) dbHandler).isDisplayingDummyRows){
        int index=((rec.getInt("packing_qty_pk"))*-1)-1;
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
      iso.put(COLUMN_PRICE_COLOR,"@@COLOR_NAME");
      priceColumnAt=2;
      String sizeColumns=
          (String)((DB_PackingDirectQty)dbHandler).recShipStyle.get("SHIP_STY_SIZE_COLUMN");
       if(sizeColumns==null)sizeColumns="";
       //----------for future to compare----------
       orgCammaedColumnsDefString=sizeColumns;
       //System.out.println("orgCammaedColumnsDefString phase 1 is:"+orgCammaedColumnsDefString);
       //----------for future to compare----------
       importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
       if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
         importHeadColumn=new String[]{};
         isOnlyOneEditingCell=true;
       }else{
           if(importHeadColumn.length>14){
             String[] backupColumns=new String[14];
             for(int ij=0;ij<14;ij++)backupColumns[ij]=importHeadColumn[ij];
             importHeadColumn=backupColumns;
           }
       }
        if(!isOnlyOneEditingCell){//if(importHeadColumn.length>0){
         for(int i=0;i<importHeadColumn.length;i++){
           iso.put(importHeadColumn[i],"qty_"+String.valueOf(i));
         }
       }else{
         iso.put("QTY","QTY_0");
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
       CTN_GRP_COLUMNAT=iso.size();
       iso.put(COLUMN_CTN_GRP,"@@GRP");
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
   // if(licenseeColorsPrice==null) licenseeColorsPrice=((DB_PackingDirectQty)dbHandler).getClrLxyPrxs();
   DB_PackingDirectQty mydbHandler=(DB_PackingDirectQty)dbHandler;
   //unitsRecords=mydbHandler.UnitsData;
   Vector colorRecords=mydbHandler.ProdColors;
    try{
      isRefinding=true;
       //add the color combobox into the row editor
       //multiEditorJTableInSuper.addJComboBox(2,colorRecords,"prod_color_name","PROD_COLOR_PK");
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
      multiEditorJTableToNotify=multiEditorJTableInSuper;
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
    HashMap tempHm=((DB_PackingDirectQty)dbHandler).getPriSeqMapPrx();
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
      Object objCtnVfy=new IntVfyTestCartonNo();
      //Object objIntVfy = new MyIntVfy();//exgui.verification.CellFormat.getIntVerifierAllowNull(3);
      Object objChar20=exgui.verification.CellFormat.getOrdinaryField(20);
      Object objFltVfy=new MyFloatVfy();//exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
      Object objWeightVfy=new MyWeightVfy();
      Object objChar30=exgui.verification.CellFormat.getOrdinaryField(30);
      Object objChar2Char=exgui.verification.CellFormat.getOrdinaryField(2);

      ht.put(COLUMN_PRICE_COLOR,objChar30);
      ht.put(COLUMN_CTN_BGN,objCtnVfy);
      ht.put(COLUMN_CTN_END,objCtnVfy);


      //ht.put(COLUMN_CTN_NET_WT,objIntVfy);
      //ht.put(COLUMN_CTN_GROSSWT,objIntVfy);
      //ht.put(COLUMN_CTN_NNTWT,objIntVfy);

      ht.put(COLUMN_CTN_NET_WT,objWeightVfy);
      ht.put(COLUMN_CTN_GROSSWT,objWeightVfy);
      ht.put(COLUMN_CTN_NNTWT,objWeightVfy);


      ht.put(COLUMN_CTN_CBM,objChar20);
      ht.put(COLUMN_CTN_GRP,objChar2Char);


      ht.put(COLUMN_CTN_MEAS_L,objFltVfy);
      ht.put(COLUMN_CTN_MEAS_W,objFltVfy);
      ht.put(COLUMN_CTN_MEAS_H,objFltVfy);



       String sizeColumns=
           (String)((DB_PackingDirectQty)dbHandler).recShipStyle.get("SHIP_STY_SIZE_COLUMN");
       if(sizeColumns==null)sizeColumns="";
       importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
      if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
       importHeadColumn=new String[]{};
       isOnlyOneEditingCell=true;
      }else{
        if(importHeadColumn.length>14){
          String[] backupColumns=new String[14];
          for(int ij=0;ij<14;ij++)backupColumns[ij]=importHeadColumn[ij];
          importHeadColumn=backupColumns;
        }
      }

      if(importHeadColumn.length==0){
        Object myIntVfy= exgui.verification.CellFormat.getIntVerifierAllowNull(7); //new myfldVfyObj(7,2);
         ht.put("QTY",myIntVfy);
         isOnlyOneEditingCell=true;
      }else{
        isOnlyOneEditingCell=false;
        Object myIntVfy= new INTQTY_VFY(7);
        for(int i=0;i<importHeadColumn.length;i++){
          ht.put(importHeadColumn[i],myIntVfy);
        }
      }
      return ht;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected PagedDataFactory getPagedDataFactory() {
    //dbHandler=new DB_PackingDirectQty();
    //licenseeColorsPrice=((DB_PackingDirectQty)dbHandler).getClrLxyPrxs();
    return dbHandler;
  }
 public Vector getData2UpdateForAdd(){
   return getData2Update(((DB_PackingDirectQty)dbHandler).appendRowIndex,getJtable().getRowCount());
 }
 public Vector getData2Update(){
   return getData2Update(0,((DB_PackingDirectQty)dbHandler).appendRowIndex);
 }
 public Vector getData2Update(int rowBegin,int rowEnd){
   //depends on Color/Licencee will display or not.
   javax.swing.JTable _jtbl=getJtable();
   Vector ouptVct=new Vector();
   int rowcount=rowEnd;//((DB_PackingDirectQty)dbHandler).appendRowIndex;
   try{
     determPricColPosition();
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
       Record recOrgShow=(Record)getDisplayingRecords().get(i);
       Record rec=(Record)util.MiscFunc.deepCopy(((DB_PackingDirectQty)dbHandler).BLANK_ORG_QTY_RECORD);
       rec.set("ship_style_pk",recOrgShow.get("ship_style_pk"));
       rec.set("PACKING_QTY_PK",recOrgShow.get("PACKING_QTY_PK"));
       rec.getModifiedFields().clear();
       boolean ismodified=false;
       for (int j = 0; j < endColmn-priceColumnAt; j++) {
         //System.out.println("get record from "+String.valueOf(i) + "_" +String.valueOf(j));
         rec.set("record_modify_user",modifyUser);
         Object qtyObj = _jtbl.getValueAt(i, j + priceColumnAt + 1).toString();
         String storedPosKey=String.valueOf(i)+","+String.valueOf( j + priceColumnAt + 1);
         Object orgQtyObj=hmTbl2backup.get(storedPosKey);
         if(hmTbl2backup.containsKey(storedPosKey) && util.MiscFunc.isEqual(qtyObj,orgQtyObj))continue;
         rec.set("qty_"+String.valueOf(j),qtyObj);
         if(isOnlyOneEditingCell)rec.set("qty_total",qtyObj );
         ismodified=true;
       }

       if(ismodified){
         //sum the modified row
         if(!isOnlyOneEditingCell){
           int total = 0;
           for (int j = 0; j < endColmn - priceColumnAt; j++) {
             Object qtyObj = _jtbl.getValueAt(i, j + priceColumnAt + 1).
                 toString();
             if (qtyObj != null && qtyObj.toString().trim().length() > 0) {
               total += Integer.parseInt(qtyObj.toString());
             }
           }
           rec.set("qty_total", total);
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
 public void doExit()throws Exception{
   if(!newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.isEnabled()){
     processhandler.template.Properties.getCenteralControler().goBack();
     return;
   }

   updateShipRemarkAndPackingType();
   check999();
   if(isContextModified()||isStyleRemarkChanged){
     //altomatically update it if context change,don't have to notify
     try{
       checkBgnCtnEndCtn();
       if(!getMultiEditorJTable().isTableOk()) throw new UnreadyToUpdate();
       if(isOverShip()){
         throw new UnreadyToUpdate();
       }

       util.MiscFunc.showProcessingMessage();
       super.kvtModifiedField2Records(getMultiEditorJTable().getModifiedRowAndColumn());
       if(((DB_PackingDirectQty)dbHandler).appendRowIndex>0){
         addMultiRows();
         doPreUpdate();
       }else{
         addMultiRows();
       }
       isProcessingAllDeleted=true;
       super.doExit();
     }catch(UnreadyToUpdate utue){
        //stop processing.
     }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }
   }else{
     super.doExit();
   }

 }
 public void doPaste(){
  //System.out.println(" retrieve copy key is:"+id4ApplicationProperties+"_"+newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
  Object storedObj=util.ApplicationProperites.getProperties(
   id4ApplicationProperties+"_"+((DB_PackingDirectQty)dbHandler).recShipStyle.getInt(0)
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
      //skip carton No to past.
      for (int i = 2; i < copiedColumns.length; i++) {
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
       id4ApplicationProperties+"_"+((DB_PackingDirectQty)dbHandler).recShipStyle.getInt(0) ,
       util.MiscFunc.deepCopy(copiedColumns)
     );
   }catch(Exception e){
      e.printStackTrace();
   }
 }


 public void doDelete()throws Exception{
   try{
     checkBgnCtnEndCtn();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    updateShipRemarkAndPackingType();
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
    Record rec2Kill=(Record)getDisplayingRecords().get(selectRow[i]);
    rec2Kill.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
    vct2delete.add(rec2Kill);
    //vct2delete.add(getDisplayingRecords().get(selectRow[i]));
  }
  ((DB_PackingDirectQty) dbHandler).deleteRecords(vct2delete);
  //exgui.verification.VerifyLib.showPlanMsg("Delete OK", "Delete OK");
  //((DB_PackingDirectQty) dbHandler).force2regetCartonRecords();
  this.goPage(1, 99999, false);
  ((DB_PackingDirectQty) dbHandler).udpateQtyTbl2Text(
   newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(
        getJtable(),priceColumnAt)
   );

  /*
  ((DB_PackingDirectQty) dbHandler).udpateQtyTbl2Text(
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
     if ((((DB_PackingDirectQty)dbHandler).recShipStyle.getInt("SHIP_STY_QTY_TYPE") & 0x01) !=0) {
        //with licensee column
        pri_col_begn++;
     }
     if ((((DB_PackingDirectQty)dbHandler).recShipStyle.getInt("SHIP_STY_QTY_TYPE") & 0x04) !=0) {
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
 protected boolean isOverShip()throws Exception{
   StringBuffer sb=new StringBuffer();
   sb.append("select b.SHIP_NO,a.SHIP_STY_TOTAL_QTY,c.STY_TOTAL_QTY from ship_style a,ship_sc b,style c ");
   sb.append("where a.SHIP_SC_PK=b.ship_sc_pk ");
   sb.append("and a.sty_seq=c.sty_seq ");
   sb.append("and a.sty_seq=");
   Record orgStyRec = ((DB_PackingDirectQty)dbHandler).recOrgStyle;
   sb.append(orgStyRec.getInt(0));
   if(((DB_PackingDirectQty)dbHandler).ship_style_pk>0){
    sb.append(" and a.ship_style_pk <> ");
    sb.append(((DB_PackingDirectQty)dbHandler).ship_style_pk);
   }
   Vector vct=
       exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
       sb.toString(),1,99999
      );
   //if(vct.size()==0)return false;
   Object objStyleTotalQty=orgStyRec.get(124);
   float styQty=Float.parseFloat((objStyleTotalQty==null)?"0":objStyleTotalQty.toString());
   float shipQty=0;
   boolean isDzUnit=orgStyRec.get(106).toString().toUpperCase().startsWith("DZ");
   StringBuffer shipQtyString=new StringBuffer();
     for (int i = 0; i < vct.size(); i++) {
       Record recShipQtyData = (Record)vct.get(i);
       float xShipQty = Float.parseFloat((recShipQtyData.get(1) == null) ? "0" :
                                         recShipQtyData.get(1).toString());
        if(xShipQty==0)continue;
       shipQtyString.append("\n");
       shipQtyString.append("SRN:");
       shipQtyString.append((String)recShipQtyData.get(0));
       shipQtyString.append(" SHIP QTY:");
       shipQtyString.append(xShipQty);
       shipQty += xShipQty;
     }
   for(int i=0;i<getJtable().getRowCount();i++){
     Object totalObj=getJtable().getValueAt(i,TOTAL_COLUMNAT);
     //System.out.println(" total Object at row "+i+" is:"+totalObj.toString());
     Object objBgnCtn=getJtable().getValueAt(i,0),objEndCtn=getJtable().getValueAt(i,1);

     int bgnCtn=Integer.parseInt((objBgnCtn==null||objBgnCtn.toString().trim().length()==0)?"0":objBgnCtn.toString());
     int endCtn=Integer.parseInt((objEndCtn==null||objEndCtn.toString().trim().length()==0)?"0":objEndCtn.toString());
     float totalOfCurrentStyle=((totalObj==null||totalObj.toString().trim().length()==0)?0:Float.parseFloat(totalObj.toString()));
     shipQty+=(((endCtn-bgnCtn+1)*totalOfCurrentStyle)/((isDzUnit)?12:1));
   }
   if(shipQty>styQty*1.05){
     String msg="Order Qty:"+styQty;
         msg+=shipQtyString.toString();
     boolean result=
         exgui.verification.VerifyLib.showConfirm("Warnning,OVERSHIP\n"+msg+"\nContinue Or Not ?",
                                                  "Over Ship",false);
     return (!result);

   }
   return false;
 }
 public void doAddNew()throws Exception{
   try{
     checkBgnCtnEndCtn();
     util.MiscFunc.showProcessingMessage();
     updateShipRemarkAndPackingType();
     if (getJtable().getRowCount() > 0) {
       //doPreUpdate();//may throw the UnreadyToUpdate.
       this.doUpdate();
     }
      //int presurededSize=getJtable().getRowCount();
     ((DB_PackingDirectQty)dbHandler).is2Append=true;
     this.goPage(1,99999);
     //((DB_PackingDirectQty)dbHandler).appendRowIndex=presurededSize;
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
   getJtable().editCellAt(-1,0);
   getData2UpdateForAdd();
   Vector orgRecords=getDisplayingRecords();
   int bgnIndex=((DB_PackingDirectQty)dbHandler).appendRowIndex;
   Vector data2add=new Vector();
   /*
   int endColmn=
         (isOnlyOneEditingCell)?
         (priceColumnAt+1):
         (importHeadColumn.length+priceColumnAt);
   */
   for(int i=bgnIndex;i<getJtable().getRowCount();i++){
     Object obj1=getJtable().getValueAt(i,0);
     Object obj2=getJtable().getValueAt(i,1);
     //if no carton definition,skip it.
     if((obj1==null||obj1.toString().trim().length()==0) && (obj2==null||obj2.toString().trim().length()==0)){
     }else{
           Record orgBlankShipPrxQtyCtnRec=(Record)orgRecords.get(i);
           data2add.add(orgBlankShipPrxQtyCtnRec);
     }
   }
    //if(data2add.size()>0) ((DB_PackingDirectQty) dbHandler).addRecords(data2add);
    ((DB_PackingDirectQty) dbHandler).addRecords(data2add);
 }
 public void doUpdate() throws Exception{
   try{
       checkBgnCtnEndCtn();
       if(!getMultiEditorJTable().isTableOk()) throw new UnreadyToUpdate();
       updateShipRemarkAndPackingType();
       util.MiscFunc.showProcessingMessage();
       if(isOverShip()){
         throw new UnreadyToUpdate();
       }
       super.kvtModifiedField2Records(getMultiEditorJTable().getModifiedRowAndColumn());
       if(((DB_PackingDirectQty)dbHandler).appendRowIndex>0){
         addMultiRows();
         doPreUpdate();
       }else{
         addMultiRows();
       }
       //doPreUpdate();
       //newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setButtons(true,true,true,true,true);
       ((DB_PackingDirectQty)dbHandler).is2Append=false;
       this.goPage(1,99999);
       //((DB_PackingDirectQty)dbHandler).appendRowIndex=getJtable().getRowCount();
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
   getJtable().getColumnModel().getColumn(CTN_GRP_COLUMNAT).setPreferredWidth(30);

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
         (String)((DB_PackingDirectQty)dbHandler).recOrgStyle.get("STY_SIZE_COLUMN");
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
           totalQtyValue+=fltValue;
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
                hzTotal[j]=hzTotal[j]+qtyValue;
            backupedSizeQty.put(String.valueOf(j)+"_"+String.valueOf(i),objValue);
           }
           theEndTotal+=hzTotal[j];

           getJtable().setValueAt(
              formatter.format(hzTotal[j]),j,extendColumnEndAt);//set to end of the row.
         }
       }
   }catch(Exception e){
     e.printStackTrace();
   }

   initializing=false;
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
   javax.swing.text.JTextComponent  jtf=//myTextComponent;
     (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
    myTextComponent=jtf;

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
   updateToMonitor();
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
   protected String tomask="0123456789-.";
   protected void updateToMonitor(){
      myTextComponent.validate();
      multiEditorJTableToNotify.mt.m_TxtCmp=myTextComponent;
      multiEditorJTableToNotify.mt.m_Text=myTextComponent.getText();
       /*
       java.awt.Container parentCon=myTextComponent.getParent();
       while(parentCon!=null){
         if(parentCon instanceof exgui.ultratable.MultiEditorJTable){
           myTextComponent.validate();
            ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text=
                myTextComponent.getText();
            System.out.println(" update to ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text :"+myTextComponent.getText());
            break;
         }
         System.out.println("keep lookup parent ,current parent is "+parentCon.getClass().getName());
         parentCon=parentCon.getParent();
       }*/
   }

   public void keyPressed(java.awt.event.KeyEvent e){
     //System.out.println("Press get key Code:"+e.getKeyCode());
     javax.swing.text.JTextComponent  jtf=//myTextComponent;
       (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
      myTextComponent=jtf;

     if(e.isActionKey())return;
     if(e.getKeyCode()==e.VK_BACK_SPACE){
       //cause key release will handle it
       e.consume();
         /*
          javax.swing.ActionMap map =  myTextComponent.getActionMap();
          javax.swing.Action action = (javax.swing.Action)map.get(
            javax.swing.text.DefaultEditorKit.deletePrevCharAction);
          action.actionPerformed( null );
        e.consume();*/
     }
   }
   public void keyReleased(java.awt.event.KeyEvent e){
     javax.swing.text.JTextComponent  jtf=//myTextComponent;
       (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
      myTextComponent=jtf;

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
      updateToMonitor();
     if((edtRow!=-1) && (edtRow!=getJtable().getRowCount()-1) &&
        (edtCol==Wt_GW_COLUMNAT || edtCol==Wt_NetNetWt_COLUMNAT|| edtCol==Wt_NW_COLUMNAT )){
       for (int i = edtRow + 1; i < getJtable().getRowCount(); i++) {
       //for (int i = edtRow; i < getJtable().getRowCount(); i++) {
         getJtable().setValueAt(jtf.getText().trim(), i, edtCol);
       }
     }

   }
   public void keyTyped(java.awt.event.KeyEvent e){
     javax.swing.text.JTextComponent  jtf=//myTextComponent;
       (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
      myTextComponent=jtf;

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
     //updateToMonitor();

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
public class IntVfyTestCartonNo extends INTQTY_VFY{
  String myWarnningMsg="String Should Be Integer";
  public IntVfyTestCartonNo(){
    super(7);
  }
  public String formatPromptMsg(){

    return myWarnningMsg;
  }
   public boolean isFormatValid(String inStr,int row,int column){
     boolean orgResult=((exgui.ultratable.CellTxtEditorFormat)myIntVfy).isFormatValid(inStr,row,column);
     return orgResult;
     /*
     if(!orgResult){
       myWarnningMsg="String Should Be Integer";
       return orgResult;
     }
     if(column==0)return orgResult;
     Object objBgnCtn=getJtable().getValueAt(row,0);
     Object objEndCtn=getJtable().getValueAt(row,1);
     int BgnCtn=(objBgnCtn==null||objBgnCtn.toString().trim().length()==0)?0:Integer.parseInt(objBgnCtn.toString());
     int EndCtn=(objEndCtn==null||objEndCtn.toString().trim().length()==0)?0:Integer.parseInt(objEndCtn.toString());
     if(!(BgnCtn<=EndCtn)){
       myWarnningMsg="Beging Carton Can\'t Greater Than End Carton";
       return false;
     }
     getJtable().setValueAt(inStr,row,column);
     return true;*/
   }
}
public class MyWeightVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
 Object orgFvyObj = exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
  public int getMaxLength(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
  }

  public exgui.ultratable.KeyProcess getKeyListener(){
    return keyadp;
  }

  public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
  public boolean isFormatValid(String inStr,int row,int column){
    boolean orgResult=((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
    //if(!orgResult)return orgResult;
    //compare bgn and end carton,end carton can not less then bgn carton
    return orgResult;
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

