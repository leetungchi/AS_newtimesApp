package newtimes.basic.totoal_endpage_remark;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import javax.swing.*;
import java.awt.event.*;
public class PnlListTotalEndPageRemarks extends AbstractUltraTablePanel {
  JButton btnAdd=new JButton("ADD");
  JButton btnEdit=new JButton("EDIT");
  JButton btnDLT=new JButton("DELETE");
  JButton btnExit=new JButton("EXIT");
  static String ONLY_ONE_COLUMN="                                           Contex Of Total End Page Remark                                 ";
  public PnlListTotalEndPageRemarks() {
    super();
    try {
      btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
      btnEdit.setFont(new java.awt.Font("Dialog", 1, 11));
      btnDLT.setFont(new java.awt.Font("Dialog", 1, 11));
      btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
      btnAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnAdd_actionPerformed(e);
        }
      });
      btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
      btnDLT.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnDLT_actionPerformed(e);
        }
      });

      btnEdit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          tableClick();
        }
      });

      getLowerRightPanel().add(btnAdd,null);
      getLowerRightPanel().add(btnEdit,null);
      getLowerRightPanel().add(btnDLT,null);
      getLowerRightPanel().add(btnExit,null);
      setBounds(new java.awt.Rectangle(10, 75, 772, 449));
      getJtable().setRowHeight(60);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void btnExit_actionPerformed(ActionEvent e){
    setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("allData");
    newtimes.Frame1 frame=(newtimes.Frame1)processhandler.template.Properties.jframe;
    frame.showPanel(new newtimes.basic.MiscMenu(frame));
    setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
  }
  void btnAdd_actionPerformed(ActionEvent e){
    try{
      Record recblank = dbHandler.getBlankRecord();
      recblank.set(0,null);
      DlgEditRemark  dlg = new DlgEditRemark(
                           util.PublicVariable.APP_FRAME,
                           "Add Remark Of Total End Page", true,
                            (DB_TotalEndPage)dbHandler,
                           this,recblank);
      dlg.setSize(430, 300);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnDLT_actionPerformed(ActionEvent e){
    if(getJtable().getSelectedRow()==-1){
      exgui.verification.VerifyLib.showPlanMsg("Please Select A Row To Delete","Please Select A Row");
      return;
    }
      if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete ?","Do You Sure?"))return;
      util.MiscFunc.showProcessingMessage();
      Record rec = (Record)getDisplayingRecords().get(getJtable().
          getSelectedRow());
      this.deleteRow(rec);
      util.MiscFunc.hideProcessingMessage();
      this.reload();
  }
  void tableClick(){
    if(getJtable().getSelectedRow()==-1){
       exgui.verification.VerifyLib.showPlanMsg("Please Select A Row To Edit","Please Select A Row");
       return;
     }
    Record rec = (Record)getDisplayingRecords().get(getJtable().
        getSelectedRow());
    DlgEditRemark dlg =
        new DlgEditRemark(util.PublicVariable.APP_FRAME,
                          "Edit Remark Of Total End Remark",
                          true,(DB_TotalEndPage)dbHandler,this,rec);
    dlg.setSize(430,300);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    return null;
    /*
    try{
      rec.set(storedRecordColumn[columnAt],value2update);
      return rec;
    }catch(Exception exp){
      exp.printStackTrace();
      return rec;
    }
    */
  }

  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(ONLY_ONE_COLUMN,"TER_REMARK");
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.addTextAreaEditor(0,500);//for style remark
    //((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeAllEditableColumn();
  }
  protected int getEachPageRowCount() {
    return 10;
  }
  protected Hashtable getObject2StringConvertor() {
    java.util.Hashtable ht=new  Hashtable();
    //ht.put(ONLY_ONE_COLUMN,exgui.verification.CellFormat.getOrdinaryField(500));
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    dbHandler=new DB_TotalEndPage().getInstance();
    return dbHandler;
  }

}
