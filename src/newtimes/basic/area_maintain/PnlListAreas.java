package newtimes.basic.area_maintain;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import database.datatype.Record;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Cursor;
public class PnlListAreas extends FuncAbstractUltraTablePanel {
  static final String DISP_COLUMN_AREA_ENG_NAME="      Area Name     ";
  static final String DISP_COLUMN_AREA_CHN_NAME="      Area Chinese Name    ";
  static final String DISP_COLUMN_AREA_REMARK="        Remark                       ";
  JButton btnAdd=new JButton("ADD");
  JButton btnEdit=new JButton("EDIT");
  JButton btnDLT=new JButton("DELETE");
  JButton btnExit=new JButton("EXIT");

  public PnlListAreas() {
    super();
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
  }
  void btnExit_actionPerformed(ActionEvent e){
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("allData");
    newtimes.Frame1 frame=(newtimes.Frame1)processhandler.template.Properties.jframe;
    frame.showPanel(new newtimes.basic.MiscMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void btnAdd_actionPerformed(ActionEvent e){
    try{
      Record recblank = dbHandler.getBlankRecord();
      recblank.set(0, -1);
      DlgEditArea dlg = new DlgEditArea(util.PublicVariable.APP_FRAME,
                                        "Add An Area", true,
                                        recblank, this);
      dlg.setSize(400, 410);
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
    DlgEditArea dlg = new DlgEditArea(util.PublicVariable.APP_FRAME,
                                      "Edit An Area", true,
                                      rec, this);
    dlg.setSize(400,410);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      rec.set(storedRecordColumn[columnAt],value2update);
      return rec;
    }catch(Exception exp){
      exp.printStackTrace();
      return rec;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(DISP_COLUMN_AREA_ENG_NAME,"area_name");
    iso.put(DISP_COLUMN_AREA_CHN_NAME,"area_chn_name");
    iso.put(DISP_COLUMN_AREA_REMARK,"area_remark");
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
  }
  protected int getEachPageRowCount() {
      return 999;
  }
  protected Hashtable getObject2StringConvertor() {
    java.util.Hashtable ht=new java.util.Hashtable();
    //ht.put(DISP_COLUMN_AREA_ENG_NAME,exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(255));
    //ht.put(DISP_COLUMN_AREA_CHN_NAME,exgui.verification.CellFormat.getOrdinaryField(255));
    //ht.put(DISP_COLUMN_AREA_REMARK,exgui.verification.CellFormat.getOrdinaryField(255));
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    DB_AreaHandler handler=new DB_AreaHandler();
    dbHandler=handler;
    return dbHandler;
  }
  public PagedDataFactory getDbHandler(){
    return dbHandler;
  }
  public void deleteRow(Record rec2del){
    try{
      ((DB_AreaHandler)dbHandler).deleteRecord(rec2del);
    }catch(BasicMdlEJBs.ExcpAreaUsed exu){
      exgui.verification.VerifyLib.showPlanMsg("Sorry,"+exu.getMessage(),"Area Referenced");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Deleting Record","Error In Delete");
    }
  }
}
