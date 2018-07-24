package newtimes.preproduction.guis;
import processhandler.template.PnlListQryRslt;
import exgui.ultratable.*;
import newtimes.preproduction.process.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.ultratable.*;
import java.util.Vector;
import exgui.MultiClassTableModel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlColorLibList extends PnlListQryRslt implements processhandler.DataProcesser {
  DB_ColorLib myHandler;
  public PnlColorLibList(
              DB_ColorLib   pagedDataFxy,
              int rowCount,util.InsertionOrderedHashMap columnMapping,
              java.util.Hashtable object2StringConvertor
          ){
           super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
           myHandler=pagedDataFxy;
           setBackground(new java.awt.Color(204, 204, 225));
           this.pgTblList.setBackground(new java.awt.Color(204, 204, 225));

  }
  public void exitCurrentGui(){}
  public void gridTableMouseEventHandler(MouseEvent e) {
    util.ApplicationProperites.setProperties(
     this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));

     Cursor ksr=null;
     int recAt=getInsideJtable().getSelectedRow();
     if(recAt<0) return;
     System.out.println("qry list table click at row:"+recAt);
     int columnAt=getInsideJtable().getSelectedColumn();
     //clear all the selection..
     //getInsideJtable().clearSelection();
     System.out.println("qry list table click at colmn:"+columnAt);
     Record rec=(Record)myHandler.getUnJoinedRecords().get(recAt);  //pgTblList.getDisplayingRecords().get(recAt);
     myHandler.editingClibRecord=rec;
     //see if to enter to edit master Record or just display showing detail of clicked record.
     /*
     if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
     }
     */
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     try{
       if (columnAt == (getInsideJtable().getColumnCount() - 1)) {
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.preproduction.process.TgrEditAColorLib());

       }
       else {
         /*
         before adding detial data to tabbed pane of current,turn off the
         enable Flag of "stateChage" of split frame.
         and turn it on after adding 1st detial pane of detail data.
         */
         /*
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.preproduction.process.TgrListClibs());
         */
       }
     }catch(Exception cmdE){
        cmdE.printStackTrace();
        util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
     }finally{
       /*
       if(ksr!=null){
         util.PublicVariable.APP_FRAME.setCursor(ksr);
       }*/
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }
   }
  public void doExit() throws Exception{
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  public boolean isContextModified(){return false;}
  public void doAddNew(){
     try{
      DB_ColorLib.editingClibRecord=myHandler.getBlankRecord();
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.preproduction.process.TgrEditAColorLib());
     }catch(Exception e){
       e.printStackTrace();
     }
  }
  public void doUpdate(){

  }
  public void doCopy(){

  }
  public void doPaste(){

  }
  public void doPrint(){

  }
  public void doDelete(){
     if(getInsideJtable().getSelectedRow()<0){
       exgui.verification.VerifyLib.showAlert("Please Select A Row","Please Select A Row");
       return ;
     }
     if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete This Record","Are You Sure ?")) return;
     try{
       myHandler.deleteRecord(myHandler.editingClibRecord);
       pgTblList.reload();
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"Exception while delete record");
     }
  }
}
