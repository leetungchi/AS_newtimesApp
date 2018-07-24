package newtimes.basic.chinese_area;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import javax.swing.*;
import database.datatype.Record;
import java.awt.event.*;
import java.awt.Cursor;
public class PnlListCityArea extends AbstractUltraTablePanel {
  JButton btnAdd=new JButton("ADD");
  JButton btnEdit=new JButton("EDIT");
  JButton btnDLT=new JButton("DELETE");
  JButton btnExit=new JButton("EXIT");

  public PnlListCityArea() {
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
     DlgEditAreaCity dlg=new DlgEditAreaCity(util.PublicVariable.APP_FRAME,"Add An Area",true,
                                             (DB_AreaDb)dbHandler,-1,this);
     dlg.setSize(370,390);
     exgui.UIHelper.setToScreenCenter(dlg);
     dlg.show();
  }
  void btnDLT_actionPerformed(ActionEvent e){
    if(getJtable().getSelectedRow()==-1){
      exgui.verification.VerifyLib.showPlanMsg("Please Select A Row To Delete","Please Select A Row");
      return;
    }
    try{
      if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete ?","Do You Sure?"))return;
      util.MiscFunc.showProcessingMessage();
      Record rec = (Record)getDisplayingRecords().get(getJtable().
          getSelectedRow());
      int pk = rec.getInt(0);
      Record rec2del = ((DB_AreaDb)dbHandler).findByPk(pk);
      ((DB_AreaDb)dbHandler).deleteRecord(rec2del);
      util.MiscFunc.hideProcessingMessage();
      reload();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Delete Fail!!","Delete Fail!!");
    }

  }
  void tableClick(){
    if(getJtable().getSelectedRow()==-1){
       exgui.verification.VerifyLib.showPlanMsg("Please Select A Row To Edit","Please Select A Row");
       return;
     }
    Record rec = (Record)getDisplayingRecords().get(getJtable().
        getSelectedRow());
    int pk = rec.getInt(0);
    DlgEditAreaCity dlg=new DlgEditAreaCity(util.PublicVariable.APP_FRAME,"Add An Area",true,
                                            (DB_AreaDb)dbHandler,pk,this);
    dlg.setSize(370,390);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    util.InsertionOrderedHashMap headColumn=new util.InsertionOrderedHashMap();
    headColumn.put("     Area Name      ","CHN_AREA_ENG_NAME");
    headColumn.put("     chinese Area Name  ","CHN_AREA_CHN_NAME");
    headColumn.put("                    Subordinate Cities                              ","CITY_NAME_LIST");
    return headColumn;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   return 9999;
  }
  protected Hashtable getObject2StringConvertor() {
    return new Hashtable();
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    dbHandler=new DB_AreaDb();
    return dbHandler;
  }

}
