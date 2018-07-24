package newtimes.preproduction.guis;
import java.awt.event.*;
import database.datatype.*;
import java.awt.*;
import processhandler.template.PnlListQryRslt;
import newtimes.preproduction.process.*;
import exgui.ultratable.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlLknStyList extends PnlListQryRslt implements  processhandler.DataProcesser{
  DB_LockinStyle myHandler;
  public PnlLknStyList(DB_LockinStyle pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     pgTblList=new processhandler.template.PagedListTable4Qry(
        pagedDataFxy,rowCount,columnMapping,object2StringConvertor,
        "Edit Cost Sheet","Cost Sheet"
      );
     myHandler=pagedDataFxy;
     this.removeAll();
     this.add(this.pgTblList,BorderLayout.CENTER);
     setPagedTable();
     setBackground(new java.awt.Color(204, 204, 225));
     pgTblList.setBackground(new java.awt.Color(204, 204, 225));
     //pgTblList.firstPage();
  }
  public void exitCurrentGui(){}
  public void doExit() throws Exception{
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  public boolean isContextModified(){return false;}
  public void doAddNew(){
    try{
      //add new record of lockin style;
      myHandler.EDITING_LOCKIN_STYLE=myHandler.getBlankRecord();
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.preproduction.process.TgrToEditLockinStyle()
      );
    }catch(Exception ee ){
       ee.printStackTrace();
    }
  }
  public void doUpdate() {

  }
  public void doDelete() {
  }
  public void doCopy(){

  }
  public void doPaste(){

  }
  public void doPrint(){

  }
  public void gridTableMouseEventHandler(MouseEvent e) {

    util.ApplicationProperites.setProperties(
     this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));

     //Cursor ksr=null;
     int recAt=getInsideJtable().getSelectedRow();
     if(recAt<0) return;
     int columnAt=getInsideJtable().getSelectedColumn();
     //clear all the selection..
     //see if to enter to edit master Record or just display showing detail of clicked record.
     /*
     if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
     }
     */
     try{
       //newtimes.production.ProdMaintain_Properties.setWaitCursor();
       //this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
       if (columnAt == (getInsideJtable().getColumnCount() - 1)) {
         //to edit cost sheet...
         Record recClicked=(Record)this.pgTblList.getDisplayingRecords().get(recAt);
         try{
          DB_CostSheet dbCost=DB_CostSheet.getInstanceOfCostSheet();
          Record rec=dbCost.getRecordByPk(recClicked.getInt(0)); //pgTblList.getDisplayingRecords().get(recAt);
          dbCost.EDITING_COST_RECORD=rec;
         }catch(Exception er){
           er.printStackTrace();
           exgui.verification.VerifyLib.showAlert("Server Conection Failed","Server Conection Failed");
         }
         //coresponding to the clicked record.
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.preproduction.process.TgrEditCostSheet());

       }
       else {
         //goto editing lockin style panel..
         myHandler.EDITING_LOCKIN_STYLE=
             (Record)this.pgTblList.getDisplayingRecords().get(recAt);
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.preproduction.process.TgrToEditLockinStyle());

       }
     }catch(Exception cmdE){
        cmdE.printStackTrace();
        util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
     }finally{
         // this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }

   }

}
