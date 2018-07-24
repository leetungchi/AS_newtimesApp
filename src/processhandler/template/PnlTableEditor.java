package processhandler.template;
import processhandler.*;
import java.awt.*;
import javax.swing.JPanel;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract  class PnlTableEditor extends
   exgui.ultratable.FuncAbstractUltraTablePanel
   implements DataProcesser,javax.swing.event.TableModelListener{
     protected String table_snapshot = null;

 public PnlTableEditor(exgui.ultratable.PagedDataFactory pagedDataFxy,
   int rowCounts,util.InsertionOrderedHashMap columnMapping,
    java.util.Hashtable object2StringConvertor
    ){
    super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
 }

  public PnlTableEditor() {
    super();
    setBackground(new java.awt.Color(204, 204, 225));
    this.getJtable().getModel().addTableModelListener(this);
  }
  public void tableChanged(javax.swing.event.TableModelEvent e){
    System.out.println(" in PnlTableEditor ");
    System.out.println("cell value:"+getJtable().getValueAt(e.getFirstRow(),e.getColumn()));

    //super.getJtable().changeSelection(e.getFirstRow(),e.getColumn(),false,false);
  }

  protected void makeTable(Vector vct,boolean need2makeSnapShot){
   super.makeTable(vct);
   if(need2makeSnapShot)table_snapshot=util.MiscFunc.table2Text(getJtable());
  }
  protected void makeTable(Vector vct){
    makeTable(vct,true);
  }
  public void exitCurrentGui() {}

  public boolean isContextModified(){
    if(getJtable().isEditing()){
     Object obj= getJtable().getCellEditor().getCellEditorValue();
     int col=getJtable().getEditingColumn();
     int row=getJtable().getEditingRow();
     getJtable().setValueAt(obj,row,col);
     getJtable().getCellEditor().cancelCellEditing();
    }
    return !(util.MiscFunc.table2Text(getJtable()).equals(table_snapshot));
  }
  /**
   * @throws Exception the remote exception or other(ex:SQL Exception)
   */
  public void doUpdate() throws Exception{
    Cursor ksr=null;
    if(getParent()!=null){
      ksr=getParent().getCursor();
      getParent().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }
    try{
     util.MiscFunc.showProcessingMessage();
     if(!confirmUpdate()) return;
     table_snapshot=util.MiscFunc.table2Text(getJtable());
     //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");
    }catch(Exception e){
      util.MiscFunc.hideProcessingMessage();
      throw e;
    }finally{
      util.MiscFunc.hideProcessingMessage();
      if(ksr!=null)getParent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }

  /**
   * @throws Exception the remote exception or other(ex:SQL Exception)
   */
  public void doAddNew() throws Exception{
    //int column=getJtable().getSelectedColumn();
    //int row=getJtable().getSelectedRow();
    addRecord();
    //getJtable().changeSelection(row,column,false,false);
  }

  /**
   * @throws Exception the remote exception or other(ex:SQL Exception)
   */
  public void doDelete() throws Exception{
     doDeleteRecord();
  }
  /**
   * call to do trigger last command.
   * @throws Exception
   */
  public void doExit()throws Exception{
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  /**
   * allow gui to copy a record into system variables for past in future
   */
  public void doCopy(){
    super.doCopy();
  }
  /**
   * past current stored record into coresponding GUI
   */
  public void doPaste(){
     super.doPast();
  }
}
