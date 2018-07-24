package newtimes.basic.ashworth_unit;
import exgui.ultratable.*;
import database.datatype.Record;
public class PageListAshMakerRemark extends exgui.ultratable.AbstractUltraTablePanel {
  javax.swing.JButton btnExit=new javax.swing.JButton("EXIT");
  public PageListAshMakerRemark(
        PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
      ) {
       super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
       super.getJtable().addMouseListener(new AxtTblListener());
       super.getLowerRightPanel().add(btnExit);
       btnExit.addMouseListener(new AxtExitListener());
       super._rowPosition=TgrListQryMkrRmk.rowStartPosition;
       getJtable().setRowHeight(50);
       super.reload();
  }
  public void doPrint(){
  }
  public int getEachPageRowCount(){return _rowCounts;}
  public java.util.Hashtable getObject2StringConvertor() {return this.klmObjKvtHt;}
  public util.InsertionOrderedHashMap getHeadColumnMap(){return this.tblHeadColumn;}
  public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return this.dbHandler ;}
  public Record setObject2Record(Record rec,int colAt,Object obj){return null;}
  public void refineEditors(exgui.ultratable.MultiEditorJTable me){}
  class AxtExitListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      try {
        processhandler.template.Properties.getCenteralControler().goBack();
      } catch (Exception eP) {
        eP.printStackTrace();
      }
    }
  }
 class AxtTblListener extends java.awt.event.MouseAdapter{
   public void mouseClicked(java.awt.event.MouseEvent me){
     if(getJtable().getSelectedRow()!=-1){
       database.datatype.Record rec=
           (database.datatype.Record)getDisplayingRecords().get(getJtable().getSelectedRow());
       TgrListQryMkrRmk.rowStartPosition=_rowPosition;//prepare for next comback;
       try {
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.basic.ashworth_unit.TgrAshMkrRmkModify(rec)
         );
       } catch (Exception eP) {
         eP.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Error In Goto Edit Page Of Maker Remark Maintain page",
                                                "Error In Goto Edit Page Of Maker Remark Maintain page");
       }
     }
   }
 }
}
