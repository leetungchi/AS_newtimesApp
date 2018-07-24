package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import newtimes.production.process.prodmaintain.DB_FrabricPO;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFbkPOList extends processhandler.template.PnlTableEditor{
  myListSelectionListener myRowSelectHandler;
  public PnlFbkPOList(){
    super();
    getJtable().setRowHeight(50);
    getJtable().addMouseMotionListener(
          newtimes.production.ProdMaintain_Properties.getJTableToolTipGenerator(getJtable(),0)
          );
  }
   public void doDelete(){
      //check if fabric po is reference by and style--20060609
      int rows[]=getJtable().getSelectedRows();
      try{
        for (int i = 0; i < rows.length; i++) {
          database.datatype.Record rec =
              (database.datatype.Record)getDisplayingRecords().get(rows[i]);
          if (rec.getInt("use_count_0") > 0||
              rec.getInt("use_count_1") > 0||
              rec.getInt("use_count_2") > 0||
              rec.getInt("use_count_3") > 0||
              rec.getInt("use_count_4") > 0||
              rec.getInt("use_count_5") > 0) {
            String fabPoName=(String)getJtable().getValueAt(rows[i],0);
            exgui.verification.VerifyLib.showAlert("FAB PO:"+fabPoName+" IS Refenece by Style\nPlease check Style Data Before you Delete It",
                                                   "Data Referenced");
            return;
          }
        }
        super.doDelete();
      }catch(Exception exp){
        exp.printStackTrace();
      }
   }
    public int getEachPageRowCount() {return 5;}
    public Hashtable getObject2StringConvertor(){
      java.util.Hashtable iso=new Hashtable();
      Object dateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      Object char1Cnv=exgui.verification.CellFormat.getOrdinaryField(1);
      Object char20Cnv=exgui.verification.CellFormat.getOrdinaryField(20);
      Object char10Cnv=exgui.verification.CellFormat.getOrdinaryField(20);
      iso.put("FAB\nPO",char10Cnv);
      iso.put("FAB QTY\n(Unit=Yard)",exgui.verification.CellFormat.getIntVerifierAllowNull(7));
      iso.put("FAB\nPRICE",exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3));
      iso.put("FAB\nDEL",dateCnv);
      iso.put("WAY",char1Cnv);
      iso.put("ETD",dateCnv);
      iso.put("ETA",dateCnv);
      iso.put("IN FTY",dateCnv);
      iso.put("PI DATE",dateCnv);
      iso.put("FAB L/C",char20Cnv);
      iso.put("OPEN\nDATE",dateCnv);
      Object objtxtVfy=exgui.verification.CellFormat.getOrdinaryField(1750);
      iso.put("    CONTENT    ",objtxtVfy);
      return iso;
    }
    public util.InsertionOrderedHashMap getHeadColumnMap(){
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      //FAB_PO, FAB_QTY, FAB_PRICE, FAB_DEL, FAB_ETD, FAB_ETA, FAB_IN_FTY, FAB_PI_DATE, FAB_LC, FAB_OPEN_DATE
      iso.put("FAB\nPO","FAB_PO");iso.put("FAB QTY\n(Unit=Yard)","FAB_QTY");
      iso.put("FAB\nPRICE","FAB_PRICE");iso.put("FAB\nDEL","FAB_DEL");
      iso.put("WAY","FAB_WAY");iso.put("ETD","FAB_ETD");
      iso.put("ETA","FAB_ETA");iso.put("IN FTY","FAB_IN_FTY");
      iso.put("PI DATE","FAB_PI_DATE");iso.put("FAB L/C","FAB_LC");
      iso.put("OPEN\nDATE","FAB_OPEN_DATE");
      iso.put("    CONTENT    ","FAB_CONTENT");
      return iso;
    }
    public void doPaste(){
     Object storedObj=util.ApplicationProperites.getProperties(
       id4ApplicationProperties
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
     //style & po no need to copy
     for(int i=1;i<copiedColumns.length;i++){
       for(int j=0;j<selectedRow.length;j++){
         if (getJtable().isCellEditable(selectedRow[j], i)) {
           getJtable().setValueAt(
               copiedColumns[i],
               selectedRow[j], i
               );
         }
       }
     }
   }


    public void doAddNew() throws Exception{
     //super.addRecord();
     //pop out the sub panel.allow user to add 20 record by bacth
     DlgBchAddFrabicPO  dlg2add=new DlgBchAddFrabicPO (
         processhandler.template.Properties.getMainFrame(),
         "Add Fabric PO",true,
         (newtimes.production.process.prodmaintain.DB_FrabricPO)dbHandler);
     dlg2add.setSize(400,350);
     dlg2add.show();
     if(dlg2add.getOperationStatus()==dlg2add.STATUS_CLOSE_CANCEL||
        dlg2add.getOperationStatus()==dlg2add.STATUS_OPERATING)return;
     this.doUpdate();
     this.goPage(_rowPosition,_rowCounts);
   }
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){
      super.dbHandler= new DB_FrabricPO();
      return dbHandler;
    }
    public database.datatype.Record setObject2Record(database.datatype.Record rec,int columnat,Object obj2put){
      try{
        String tgtClm=storedRecordColumn[columnat];
        rec.set(tgtClm,obj2put);
        return rec;
      }catch(Exception e){
        e.printStackTrace();
        return null;
      }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable multiEditorJTableInSuper){
       multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
       multiEditorJTableInSuper.addTextAreaEditor(11,1750);
       if(myRowSelectHandler==null){
         myRowSelectHandler=new myListSelectionListener(this.getJtable());
         myRowSelectHandler.setUltraTable(this);
         newtimes.production.ProdMaintain_Properties.
            CURRENT_SELECTED_FABRIC_PO_SEQ_IN_FABRIC_PO_LIST =-1;
         this.getJtable().getSelectionModel().addListSelectionListener(myRowSelectHandler);
       }
    }
    public void doPrint(){}

    public class myListSelectionListener
        implements
        javax.swing.event.ListSelectionListener {
      javax.swing.JTable editingTbl = null;
      exgui.ultratable.AbstractUltraTablePanel parentPnl = null;
      public myListSelectionListener(javax.swing.JTable _jtbl) {
        editingTbl = _jtbl;
      }

      public void setUltraTable(exgui.ultratable.AbstractUltraTablePanel
                                _parentPnl) {
        parentPnl = _parentPnl;
      }

      public void valueChanged(javax.swing.event.ListSelectionEvent e) {
        //System.out.println("selected row No is:"+editingTbl.getSelectedRow());
        if (editingTbl.getSelectedRow() == -1) {
          newtimes.production.ProdMaintain_Properties.
              CURRENT_SELECTED_FABRIC_PO_SEQ_IN_FABRIC_PO_LIST =-1;

        }
        else {
          database.datatype.Record rec =
              (database.datatype.Record) parentPnl.getDisplayingRecords().get(
              editingTbl.getSelectedRow());
          newtimes.production.ProdMaintain_Properties.EDITING_FABRIC_PO_RECORD=rec;
          newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_FABRIC_PO_SEQ_IN_FABRIC_PO_LIST =
              rec.getInt(0);
        }
        util.ApplicationProperites.setProperties("PnlFbkPOList_beginRow_at",
                                                 new Integer(parentPnl.
            _rowPosition));
      }
    }

  }

