package newtimes.production.gui.prodmaintain;

import processhandler.template.PnlListQryRslt;
import exgui.ultratable.PagedDataFactory;
import database.datatype.Record;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListStyleFiles extends PnlListQryRslt
  implements processhandler.DataProcesser {
  PagedDataFactory dbHandler;
  public PnlListStyleFiles(
      PagedDataFactory pagedDataFxy,
      int rowCount,util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor,
      String titleColum1,String btnText1){
    super(pagedDataFxy,
          rowCount,
          columnMapping,
          object2StringConvertor,
          titleColum1,btnText1);
    dbHandler=pagedDataFxy;
 }
  public static String getFileNameExtend(String fileName){
    String tmpStr[]=util.MiscFunc.split(fileName.toLowerCase(),".");
    String endWith=tmpStr[tmpStr.length-1];
    return endWith;
  }
   public void gridTableMouseEventHandler(java.awt.event.MouseEvent evt){
     int colum=pgTblList.getJtable().getSelectedColumn();
     int row=pgTblList.getJtable().getSelectedRow();
     if(row==-1)return;
     if(colum==(pgTblList.getJtable().getColumnCount()-1)){
       //show the dialog
       DlgStyleFileUpload dlg=new DlgStyleFileUpload(
        util.PublicVariable.APP_FRAME,"EDIT Upload",true);
       dlg.setSize(550,430);
       try{
         newtimes.production.ProdMaintain_Properties.setWaitCursor();
         util.MiscFunc.showProcessingMessage();
         setCursor(new Cursor(Cursor.WAIT_CURSOR));
         Record rec =
             ((newtimes.production.process.prodmaintain.DB_StyUpload)dbHandler).
             getRecordByPk(
             ((Record)pgTblList.getDisplayingRecords().get(row)).getInt(0));
         String fileName=(String)rec.get("sty_file_name");
         byte[] data=
             (byte[])rec.get(newtimesejb.production.StyleUploadFacade.PSUDO_COLUMN_FILES_DATA);
          if(fileName.toLowerCase().endsWith("pdf")){
            dlg.setPDFdata2View(fileName,data);
          }else{
            dlg.setImagData2View(fileName,data);
          }
          newtimes.production.ProdMaintain_Properties.setNormalCursor();
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          dlg.setRemarkText((String)rec.get("sty_file_rmk"));
          util.MiscFunc.hideProcessingMessage();
          dlg.show();
          if(dlg.getDialogStatus()==dlg.STATUS_CLOSE_NORMALLY){
             //user pressed "Confirm key"
             rec.set("sty_file_rmk",dlg.getRemarkText());
             rec.set(newtimesejb.production.StyleUploadFacade.PSUDO_COLUMN_FILES_DATA,
                     dlg.getCurrentFileData());
             //test if file name is different from original
             String newFileName=dlg.getCurrentFileName();
             String headName=String.valueOf(rec.getInt(0));
             String destFileName=headName+"."+this.getFileNameExtend(newFileName);
             rec.set("sty_file_name",destFileName);
             util.MiscFunc.showProcessingMessage();
             newtimes.production.ProdMaintain_Properties.setWaitCursor();
             ((newtimes.production.process.prodmaintain.DB_StyUpload)dbHandler).updateRecord(rec);
             pgTblList.reload();
             /*
             exgui.verification.VerifyLib.showPlanMsg("UPDATE OK",
                                                      "UPDATE OK");
             */
          }
       }catch(Exception exp){
         util.MiscFunc.hideProcessingMessage();
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"error in editing style file");
         exgui.verification.VerifyLib.showAlert(
          "Error In Viewing Uploaded File",
           "Error In Viewing Uploaded File");
       }finally{
         if(dlg!=null){
           dlg.data2upload=null;
           dlg=null;
           System.gc();
         }
         util.MiscFunc.hideProcessingMessage();
         setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         newtimes.production.ProdMaintain_Properties.setNormalCursor();
       }
     }
   }
   public void exitCurrentGui(){}
   public void doAddNew(){
     //show the dialog
     DlgStyleFileUpload dlg=new DlgStyleFileUpload(
      util.PublicVariable.APP_FRAME,"Add Style Upload Media",true);
     dlg.setSize(550,430);
     try{
       Record rec =
           ((newtimes.production.process.prodmaintain.DB_StyUpload)dbHandler).getBlankRecord();
        dlg.show();
        if(dlg.getDialogStatus()==dlg.STATUS_CLOSE_NORMALLY){

           //user pressed "Confirm key"
           rec.set("sty_file_rmk",dlg.getRemarkText());
           rec.set(newtimesejb.production.StyleUploadFacade.PSUDO_COLUMN_FILES_DATA,
                   dlg.getCurrentFileData());
           //test if file name is different from original
           String newFileName=dlg.getCurrentFileName();
           //String headName=String.valueOf(rec.getInt(0));
           //String destFileName=headName+"."+this.getFileNameExtend(newFileName);
           rec.set("sty_file_name",this.getFileNameExtend(newFileName));
           newtimes.production.ProdMaintain_Properties.setWaitCursor();
           util.MiscFunc.showProcessingMessage();
           ((newtimes.production.process.prodmaintain.DB_StyUpload)dbHandler).addRecord(rec);
           pgTblList.reload();
           /*
           exgui.verification.VerifyLib.showPlanMsg("ADD OK",
                                                    "ADD OK");
           */
        }
     }catch(Exception exp){
       exp.printStackTrace();
       util.MiscFunc.hideProcessingMessage();
       util.ExceptionLog.exp2File(exp,"error in Add style upload file");
       exgui.verification.VerifyLib.showAlert(
        "Error In Add Style Media File",
         "Error In Add Style Media File");
     }finally{
       if(dlg!=null){
         dlg.data2upload=null;
         dlg=null;
         System.gc();
       }
       util.MiscFunc.hideProcessingMessage();
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }
   }
   public void doActivate(){
     pgTblList.firstPage();
   }
   public void doCopy(){}
   public void doDelete(){
     int row=pgTblList.getJtable().getSelectedRow();
     if(row==-1){
       exgui.verification.VerifyLib.showPlanMsg(
       "Please Select A Row To Delete",
       "Please Select A Row");
        return;
     }
     if(exgui.verification.VerifyLib.showConfirm(
      "Are You Sure To Delete?","Are You Sure?")){
        try{
          newtimes.production.ProdMaintain_Properties.setWaitCursor();
          util.MiscFunc.showProcessingMessage();
          Record rec =
              (Record)pgTblList.getDisplayingRecords().get(row);
          rec.set("record_delete_user",
                  util.PublicVariable.USER_RECORD.get("USR_CODE"));
          dbHandler.deleteRecord(rec);
          this.pgTblList.reload();
          /*
          exgui.verification.VerifyLib.showPlanMsg("Delete OK",
                                                   "Delete OK");
          */
        }catch(Exception exp){
          exp.printStackTrace();
          util.MiscFunc.hideProcessingMessage();
          util.ExceptionLog.exp2File(exp,"error in delete record");
          exgui.verification.VerifyLib.showAlert(
          "Server Side Error,Please Contact System Manager",
          "Delete Fail!");
        }finally{
          util.MiscFunc.hideProcessingMessage();
          newtimes.production.ProdMaintain_Properties.setNormalCursor();
        }
     }


   }
   public void doExit()throws Exception{
     processhandler.template.Properties.getCenteralControler().goBack();
   }
   public void doPaste(){}
   public void doPrint(){}
   public void doUpdate(){}
   public boolean isContextModified(){return false;}
}
