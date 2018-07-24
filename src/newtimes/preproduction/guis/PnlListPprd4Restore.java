package newtimes.preproduction.guis;
import java.awt.*;
import processhandler.template.*;
import processhandler.template.PnlListQryRslt;
import newtimes.preproduction.process.*;
import javax.swing.JLabel;
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

public class PnlListPprd4Restore extends PnlListQryRslt {
  protected DB_PreprodHandler4Restore  myHander;
  public PnlListPprd4Restore(DB_PreprodHandler4Restore pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     //super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
     pgTblList=new PagedListTable4Qry(pagedDataFxy,
                                      rowCount,
                                      columnMapping,object2StringConvertor,
                                      null,null);
     myHander=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Please click the rows to restore data."),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     pgTblList.getJtable().addMouseListener(
        this
     );
     setBackground(new java.awt.Color(204, 204, 225));
     pgTblList.setBackground(new java.awt.Color(204, 204, 225));

     if(util.ApplicationProperites.getProperties(this.getClass().getName()+"_TOP_RECORD_AT")!=null){
        int xntRowStartAt=((Integer)util.ApplicationProperites.getProperties(this.getClass().getName()+"_TOP_RECORD_AT")).intValue();
        if(xntRowStartAt!=pgTblList._rowPosition){
         pgTblList._rowPosition=xntRowStartAt;

        }
     }
      pgTblList.reload();
  }
  public void gridTableMouseEventHandler(MouseEvent e) {

    util.ApplicationProperites.setProperties(
     this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));

     Cursor ksr=null;
     int recAt=getInsideJtable().getSelectedRow();
     if(recAt<0) return;
     int columnAt=getInsideJtable().getSelectedColumn();
     //clear all the selection..
     getInsideJtable().clearSelection();
     //see if to enter to edit master Record or just display showing detail of clicked record.
     /*
     if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
     }
     */
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     util.ApplicationProperites.setProperties(
        processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
      new Integer(getCurrentPageBeginPosition()));
     try{
       //before restoring color libs,we need to test if need to restore or not.
       Record clickedRecord=(Record)pgTblList.getDisplayingRecords().get(recAt);

         int finalPk=-1;
         Object ctInforObj=clickedRecord.get("prod_ct_seq");
         if(ctInforObj!=null && (!ctInforObj.toString().equals("1"))){
           //find out the heading record,switch to head record.
            finalPk=clickedRecord.getInt("prod_heading_pk");
         }else{
           finalPk=clickedRecord.getInt(0);
         }




       if(((String)clickedRecord.get("record_delete_flag")).equals("1") &&
          clickedRecord.getInt("DELeTE_color_count")<1 &&
          clickedRecord.getInt("DELeTE_style_count")<1
          ){
          exgui.verification.VerifyLib.showPlanMsg(
            "No Production Head or Color Libraries  To Restore",
            "No Data To Restore"
          );
          return ;
       }

       newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
       Record rec=(Record)myHander.findbyPk(finalPk);  //pgTblList.getDisplayingRecords().get(recAt);
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;
       processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(rec);
       if(ctInforObj==null){
         newtimes.preproduction.Constants.swithToGeneralMode();//there is no C/T infor ,it's normal process.
       }else{
         newtimes.preproduction.Constants.swithToNTHKMode();//there is has C/T infor ,it's C/T process.
       }


       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.preproduction.process.TgrToListStyle2Restore());

     }catch(Exception cmdE){
        cmdE.printStackTrace();
        util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
     }finally{
       /*
       if(ksr!=null){
         util.PublicVariable.APP_FRAME.setCursor(ksr);
       }
       */
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }
   }

}
