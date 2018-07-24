package exgui.ultratable;
import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import database.datatype.Record;
import java.awt.*;
import exgui.ultratable.AbstractUltraTablePanel;
import exgui.ultratable.PagedDataFactory;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract  class FuncAbstractUltraTablePanel extends AbstractUltraTablePanel  {
  protected Object copiedColumns[]=null;
  protected String id4ApplicationProperties=null;//the index string for applicatoin properties to store/retrive copied object
  protected   FuncAbstractUltraTablePanel(){
    super();
    id4ApplicationProperties=this.getClass().getName();
  }
  protected  FuncAbstractUltraTablePanel(
      PagedDataFactory pagedDataFxy,
      int rowCounts,util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor
    ) {
     super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
  }
  public void doPast(){
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
 }

  public void doCopy(){
    if(getJtable().getSelectedRow()<0){
      exgui.verification.VerifyLib.showPlanMsg(
      "Please Select A Row To Copy","Please Select A Row");
      return;
    }
    int selectedRow=getJtable().getSelectedRow();
    if(_jTable1.getCellEditor()!=null)_jTable1.getCellEditor().cancelCellEditing();
    copiedColumns=new Object[getJtable().getColumnCount()];

    for(int i=0;i<copiedColumns.length;i++){
      copiedColumns[i]=
        getJtable().getValueAt(
        selectedRow,i
       );
    }
    try{
      util.ApplicationProperites.setProperties(
        id4ApplicationProperties,
        util.MiscFunc.deepCopy(copiedColumns)
      );
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  public void addRecord(){
    Cursor ksr=null;
    if(util.PublicVariable.APP_FRAME!=null){
     ksr=util.PublicVariable.APP_FRAME.getCursor();
     util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }
    try{
     util.MiscFunc.showProcessingMessage();
     if(!confirmUpdate()) return;
     dbHandler.addRecord(null);
     //ultraTable.reload();
     lastPage();
     //exgui.verification.VerifyLib.showPlanMsg("Add New Record OK!!","Add New Record OK!!");
    }catch(java.rmi.RemoteException re){
      re.printStackTrace();
      util.ExceptionLog.exp2File(re,"");
      util.MiscFunc.hideProcessingMessage();
     exgui.verification.VerifyLib.showAlert(
      "Connection Exception,please check server status."
      ,"java.rmi.RemoteException!!"
     );
    }catch(Exception eex){
      util.MiscFunc.hideProcessingMessage();
      util.ExceptionLog.exp2File(eex,"Excepitons of appending new record in "+this.getClass().getName());
      exgui.verification.VerifyLib.showAlert(
        "Excepitons while attemp to insert new record ",
        "Excepitons of appending new record"
      );
    }finally{
      util.MiscFunc.hideProcessingMessage();
      if(ksr!=null){
       util.PublicVariable.APP_FRAME.setCursor(ksr);
      }
    }
  }
  public String  getID4AppPropties(){
    return id4ApplicationProperties;
  }
  public void doDeleteRecord(){
    Vector vctRec=null;
    if(getJtable().getSelectedRow()<0){
      exgui.verification.VerifyLib.showPlanMsg(
       "Please select a row to delete","Please select a row"
      );
      return;
    }
    if (exgui.verification.VerifyLib.showConfirm(
        "Are you Sure to delete this  record(s) ?",
        "Are You Sure to delete ?")
        ) {
       vctRec=new Vector();
       int rowselected[]=getJtable().getSelectedRows();
       getJtable().changeSelection(0,0,false,false);
       for(int i=0;i<rowselected.length;i++){
         Record rec = (Record)getDisplayingRecords().get(rowselected[i] );
         vctRec.add(rec);
       }
      Cursor ksr=null;
      if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      }
      util.MiscFunc.showProcessingMessage();
      try{
          //((PanelColorLibWvn)ultraTable).getPagedDataFactory().deleteRecord(rec);
          for(int i=0;i<vctRec.size();i++){
            Record rec=(Record)vctRec.get(i);
            dbHandler.deleteRecord(rec);
          }
            reload();
            //exgui.verification.VerifyLib.showPlanMsg("Delete Record OK!!","Delete Record OK!!");
         }catch(Exception eex){
           util.MiscFunc.hideProcessingMessage();
           util.ExceptionLog.exp2File(eex,"Excepitons of deletting record in "+this.getClass().getName());
           exgui.verification.VerifyLib.showAlert(
             "Excepitons while deleting record",
             "Excepitons of deleting record"
           );
         }finally{
           util.MiscFunc.hideProcessingMessage();
           if(ksr!=null){
            util.PublicVariable.APP_FRAME.setCursor(ksr);
           }
         }
     }
  }
}
