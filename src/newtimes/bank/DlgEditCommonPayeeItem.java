package newtimes.bank;

import java.awt.*;
import javax.swing.*;
import database.datatype.*;
import java.util.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgEditCommonPayeeItem extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnAdd = new JButton();
  JButton btnOK = new JButton();
  JButton btnDelete = new JButton();
   DummyDB4PayeeItem dbPayeeItemHandler;
   Pnl2ListPayeeItem pnl2List;

  public DlgEditCommonPayeeItem(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditCommonPayeeItem() {
    this(null, "", false);
  }
  class Pnl2ListPayeeItem extends exgui.ultratable.FuncAbstractUltraTablePanel {
    public Pnl2ListPayeeItem(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        super.getLowerRightPanel().removeAll();
        super.getPanelContainsButtons().removeAll();
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        System.out.println(storedRecordColumn[col] +" modified");
        rec.set(storedRecordColumn[col], obj);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
        return null;
      }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(klmObjKvtHt);
    }
    public void doUpdate()throws Exception{

    }
    public boolean updateModifiedRecord() throws Exception{
      return super.updateModifiedRecord();

    }
  }
  class DummyDB4PayeeItem extends exgui.ultratable.PagedDataFactoryAdapter{
    Vector vctData;
    newtimesejb.bank.BankFacade bankFacade;
    Vector vct2Delete=new Vector();
    DummyDB4PayeeItem(){
       try{
         newtimesejb.bank.BankFacadeHome ejbHome=
             (newtimesejb.bank.BankFacadeHome)
             info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
             "newtimesejb.bank.BankFacade");
         bankFacade=ejbHome.create();
         blankRecord= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("BANK_PAYEE_ITEM_tbl");
         blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
         blankRecord.set("record_delete_flag",-1);
         vctData=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                      "select * from BANK_PAYEE_ITEM",
                                                      1,99999);
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
       }
    }

    public Record addRecord(Record rec2add)throws Exception{
      vctData.add(rec2add);
      return rec2add;
    }
    public Vector getRecords(int btn,int row)throws Exception {
      return vctData;
    }
    public void updateRecords(Vector vct)throws Exception{
      for(int i=0;i<vct.size();i++){
        Record rec2update=(Record)vct.get(i);
        for(int j=0;j<vctData.size();j++){
          Record recOrg=(Record)vctData.get(j);
          if(recOrg.get(0).toString().equals(rec2update.get(0).toString())){
            recOrg.set(1,rec2update.get(1));
            vctData.set(j,recOrg);
          }
        }
      }
    }
    public void finalUpdate(Vector vct)throws Exception{
      bankFacade.handleCommonPayeeItem(vct);
    }
  }
  private void jbInit() throws Exception {
    dbPayeeItemHandler=new DummyDB4PayeeItem();
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("            項目名稱            ","ITEM_NAME");
    Hashtable ht=new Hashtable();
    Object char30Vfy=exgui.verification.CellFormat.getOrdinaryField(25);
    ht.put("            項目名稱            ",char30Vfy);
    pnl2List=new Pnl2ListPayeeItem(dbPayeeItemHandler,9999,iso,ht);

    panel1.setLayout(null);
    btnAdd.setBounds(new Rectangle(8, 335, 68, 31));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    pnl2List.setBounds(new Rectangle(28, 28, 180,272));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setBounds(new Rectangle(177, 334, 73, 31));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnDelete.setBounds(new Rectangle(84, 334, 84, 31));
    getContentPane().add(panel1);
    panel1.add(pnl2List, null);
    panel1.add(btnAdd, null);
    panel1.add(btnDelete, null);
    panel1.add(btnOK, null);
    pnl2List.firstPage();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnDelete_actionPerformed(ActionEvent e) {
      int rowIndex=pnl2List.getJtable().getSelectedRow();
      if(rowIndex<0){
        exgui.verification.VerifyLib.showAlert("Please Select A Row To Delete",
                                               "Please Select A Row To Delete");
        return;
      }
      try{
        pnl2List.updateModifiedRecord();
        Record rec2del=(Record)dbPayeeItemHandler.vctData.remove(rowIndex);
        rec2del.set(4,1);
        rec2del.set(1,null);
        dbPayeeItemHandler.vct2Delete.add(rec2del);
        pnl2List.reload();
      }catch(Exception exp){

        exp.printStackTrace();
      }
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
      pnl2List.updateModifiedRecord();
      Record recNew=dbPayeeItemHandler.getBlankRecord();
      recNew.set(0,String.valueOf(System.currentTimeMillis()));
      recNew.getModifiedFields().clear();
      dbPayeeItemHandler.vctData.add(recNew);
      pnl2List.reload();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnOK_actionPerformed(ActionEvent e) {
     //test data 2 update
     try{
       pnl2List.updateModifiedRecord();
     }catch(Exception exp){
       exp.printStackTrace();
     }
     Vector vct2update=new Vector();
     for( int i=0;i<dbPayeeItemHandler.vctData.size();i++){
       Record rec=(Record)dbPayeeItemHandler.vctData.get(i);
       if(rec.getModifiedFields().size()>0){
         if(rec.getInt(4)<0)rec.set(2,util.PublicVariable.USER_RECORD.get(0));//create user
         rec.set(8,util.PublicVariable.USER_RECORD.get(0));//modify user
         vct2update.add(rec);
       }
     }
     vct2update.addAll(dbPayeeItemHandler.vct2Delete);
     if(vct2update.size()>0){
       try{
         util.MiscFunc.showProcessingMessage();
         dbPayeeItemHandler.finalUpdate(vct2update);
         util.MiscFunc.hideProcessingMessage();
         this.dispose();
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
         exgui.verification.VerifyLib.showAlert("Update Failed !! \nPlease Contact System Manager",
                                                "Update Failed");
       }
     }else{
       this.dispose();
     }
  }
}
