package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import exgui.*;
import java.awt.event.*;
import newtimes.preproduction.process.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPpClibList extends processhandler.template.PnlListQryRslt
  implements processhandler.DataProcesser
  {
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JLabel lbl2Add = new JLabel();
  JLabel lblToDtl = new JLabel();
  DB_PreProdColorLib myHandler;
  public PnlPpClibList(DB_PreProdColorLib pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor,
           "Click To Edit","   ...");
     myHandler=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Material Color Edit Unit."),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     setBackground(new java.awt.Color(204, 204, 225));
     pgTblList.setBackground(new java.awt.Color(204, 204, 225));
     this.setPreferredSize(new Dimension(600,300));
     pgTblList.setPreferredSize(new Dimension(600,150));
     //pgTblList.firstPage();
  }
  public void exitCurrentGui(){}
  public void doAddNew(){
    try{
      newtimes.preproduction.process.DB_PreProdColorLib.editingRecord=
          newtimes.preproduction.process.DB_PreProdColorLib.getInstance().getBlankRecord();
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.preproduction.process.TgrEditPrePrdColorLib()
      );
    }catch(Exception ee ){
       ee.printStackTrace();
    }
  }
  public void doUpdate() {

  }
  public void doExit(){

  }
  public boolean isContextModified(){return false;}
  public void doDelete() {
    if(pgTblList.getJtable().getSelectedRow()<0){
      exgui.verification.VerifyLib.showPlanMsg("Please Select A Record To Delete","Please Select A Record");
      return;
    }else{
      if(exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete This Record ?",
                                                  "Are You Sure To Delete This Record ?")){
        int rowAt=pgTblList.getJtable().getSelectedRow();
        Record recClicked=(Record)this.pgTblList.getDisplayingRecords().get(rowAt);
        try{
         Record rec=myHandler.getRecordByPk(recClicked.getInt(0)); //pgTblList.getDisplayingRecords().get(recAt);
         myHandler.deleteRecord(rec);
        }catch(Exception er){
          er.printStackTrace();
          exgui.verification.VerifyLib.showAlert("Server Conection Failed","Server Conection Failed");
        }
        pgTblList.reload();
      }
    }
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

     Cursor ksr=null;
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

     //newtimes.production.ProdMaintain_Properties.setWaitCursor();
     try{
       if (columnAt == (getInsideJtable().getColumnCount() - 1)) {
         this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
         Record recClicked=(Record)this.pgTblList.getDisplayingRecords().get(recAt);
         Object millNo=recClicked.get("j_mill_no");
         if(millNo!=null){
           newtimes.preproduction.Constants.TEMP_MILL_MTRL_NO=millNo.toString();
         }else{
           newtimes.preproduction.Constants.TEMP_MILL_MTRL_NO="";
         }

         try{
          Record rec=myHandler.getRecordByPk(recClicked.getInt(0)); //pgTblList.getDisplayingRecords().get(recAt);
          myHandler.editingRecord=rec;
         }catch(Exception er){
           er.printStackTrace();
           exgui.verification.VerifyLib.showAlert("Server Conection Failed","Server Conection Failed");
         }
         //coresponding to the clicked record.
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.preproduction.process.TgrEditPrePrdColorLib());

       }
       else {
         //wait for delete ...
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
}


