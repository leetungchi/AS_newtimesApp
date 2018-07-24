package newtimes.production.gui.prodmaintain;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import javax.swing.JComboBox;
import java.awt.event.*;
import java.util.Vector;
import newtimes.production.process.prodmaintain.DB_StyleMisc;
abstract public class PnlStyMiscList extends FuncAbstractUltraTablePanel
   implements processhandler.DataProcesser {
  protected myListSelectionListener myRowSelectionHandler;
  boolean addSlkListenered=false;
  boolean  isRefinding=false;
  boolean isInitOk=false;
  static String DISP_STY_NO="STYLE NO";
  static String DB_STY_NO="STY_STYLE";
  static String DISP_STY_PO="PO";
  static String DB_STY_PO="STY_PO";
  protected String table_snapshot=null;
  public PnlStyMiscList() {
    super();
    super.setBackground(new java.awt.Color(204, 204, 225));
    //getJtable().addMouseMotionListener(new MyMouseListener());
    getJtable().addMouseMotionListener(
      newtimes.production.ProdMaintain_Properties.getJTableToolTipGenerator(getJtable(),1));
  }
  public void exitCurrentGui(){}
  public boolean isContextModified(){
    //exitCurrentGui();
    if(getJtable().isEditing()){
     Object obj= getJtable().getCellEditor().getCellEditorValue();
     int col=getJtable().getEditingColumn();
     int row=getJtable().getEditingRow();
     getJtable().setValueAt(obj,row,col);
     getJtable().getCellEditor().cancelCellEditing();
    }
    return !(util.MiscFunc.table2Text(getJtable()).equals(table_snapshot));
  }
  protected void hookInRefineEditor(MultiEditorJTable multiEditorJTableInSuper){
    if(!addSlkListenered){
     newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST=-1;//clear selection
     myRowSelectionHandler= new myListSelectionListener(multiEditorJTableInSuper.getJTable());
     multiEditorJTableInSuper.getJTable().getSelectionModel().addListSelectionListener(
           myRowSelectionHandler);
           myRowSelectionHandler.setUltraTable(this);
      addSlkListenered=true;
    }
   }
   protected void makeTable(Vector vct){
     super.makeTable(vct);
     table_snapshot=util.MiscFunc.table2Text(getJtable());

   }

   protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
     try{
       String columnName=storedRecordColumn[columnAt];
       rec.set(columnName,value2update);
       return rec;
     }catch(Exception e){
       e.printStackTrace();
       return null;
     }
   }
   protected PagedDataFactory getPagedDataFactory() {
     dbHandler=new DB_StyleMisc();
     return dbHandler;
   }
  public boolean isInitOK(){return ((DB_StyleMisc)dbHandler).isInitOK();}
  public void doDelete()throws Exception{}
  public void doAddNew()throws Exception{}
  public void doPrint(){}
  public void doExit()throws Exception{
    //processhandler.template.Properties.getCenteralControler().getDataProcesser().doExit();
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  public void doCopy(){
     super.doCopy();
  }
  public void doUpdate()throws Exception{
    try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     util.MiscFunc.showProcessingMessage();
     if(!super.confirmUpdate()) return;
     //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");
     this.reload();
     table_snapshot=util.MiscFunc.table2Text(getJtable());
    }catch(Exception e){
      util.MiscFunc.hideProcessingMessage();
      throw e;
    }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
     util.MiscFunc.hideProcessingMessage();
    }
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
   for(int i=0;i<copiedColumns.length;i++){
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

 protected int getEachPageRowCount() {
   /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   return 9999;
 }


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
            CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST = -1;
      }
      else {
        database.datatype.Record rec =
            (database.datatype.Record) parentPnl.getDisplayingRecords().get(
            editingTbl.getSelectedRow());
        newtimes.production.ProdMaintain_Properties.
            CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST =
            rec.getInt(0);
        newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD =rec;
      }
    }
  }

}
