package newtimes.basic.systemvalue;

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

public class PnlOtherDateRange extends JPanel {
  JPanel pnlAdd = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtName = new JTextField();
  JTextField txtFrom = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtTo = new JTextField();
  JLabel jLabel3 = new JLabel();
  JButton btnAdd = new JButton();
  JButton btnExit = new JButton();
  BorderLayout borderLayout1 = new BorderLayout();
  TempDbHandler tmpHandler=new TempDbHandler();
  Pnl2ListOtherRange pnl2List=null;
  Object chk20Char=exgui.verification.CellFormat.getOrdinaryField(20);
  Object chk100Char=exgui.verification.CellFormat.getOrdinaryField(100);
  javax.swing.JDialog dlg2contain;
  JButton btnUpdate=new JButton("UPDATE");
  String cenCode;
  public PnlOtherDateRange(String _cenCode) {
    try {
      cenCode=_cenCode;
      jbInit();
      pnl2List.getPanelContainsButtons().removeAll();
      pnl2List.getLowerRightPanel().add(btnUpdate);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void setContainDialog(javax.swing.JDialog dlg){
    dlg2contain=dlg;
  }
  void jbInit() throws Exception {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("   FIELD NAME   ","FIELD_NAME");
    iso.put("   FROM    ","RANGE_FROM");
    iso.put("   TO      ","RANGE_TO");
    iso.put("     FILED DESCRIPTION   ","FIELD_DESC");

    java.util.Hashtable ht=new java.util.Hashtable();
    //ht.put("FIELD NAME","FIELD_NAME");
    ht.put("   FROM    ",chk20Char);
    ht.put("   TO      ",chk20Char);
    ht.put("     FILED DESCRIPTION   ",chk100Char);


   pnl2List=new Pnl2ListOtherRange(tmpHandler,99999,iso,ht);

    this.setLayout(null);
    //pnl2List.setBorder(BorderFactory.createEtchedBorder());
    pnl2List.setBounds(new Rectangle(8, 24, 506, 227));
    //pnl2List.setLayout(borderLayout1);
    pnlAdd.setBorder(BorderFactory.createEtchedBorder());
    pnlAdd.setBounds(new Rectangle(8, 262, 505, 42));
    pnlAdd.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("NAME:");
    jLabel1.setBounds(new Rectangle(7, 10, 45, 23));
    txtName.setText("");
    txtName.setBounds(new Rectangle(42, 10, 65, 23));
    txtFrom.setText("");
    txtFrom.setBounds(new Rectangle(159, 10, 65, 23));
    txtFrom.setText("jTextField1");
    jLabel2.setBounds(new Rectangle(124, 10, 45, 23));
    jLabel2.setText("FROM:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    txtTo.setBounds(new Rectangle(252, 10, 65, 23));
    txtTo.setText("jTextField1");
    txtTo.setText("");
    jLabel3.setBounds(new Rectangle(231, 10, 45, 23));
    jLabel3.setText("TO:");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setBounds(new Rectangle(325, 6, 62, 30));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUPdate_actionPerformed(e);
      }
    });

    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setBounds(new Rectangle(409, 6, 92, 30));
    this.add(pnl2List, null);
    this.add(pnlAdd, null);
    pnlAdd.add(jLabel1, null);
    pnlAdd.add(txtName, null);
    pnlAdd.add(jLabel3, null);
    pnlAdd.add(jLabel2, null);
    pnlAdd.add(txtFrom, null);
    pnlAdd.add(txtTo, null);
    pnlAdd.add(btnAdd, null);
    pnlAdd.add(btnExit, null);
    new exgui.DataBindTextWithChecker(txtName, "",
                                       "", 20,
                                       (exgui.Object2String)chk20Char,
                                       (exgui.ultratable.CellTxtEditorFormat)
                                       chk20Char);

     new exgui.DataBindTextWithChecker(txtFrom, "",
                                        "", 20,
                                        (exgui.Object2String)chk20Char,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        chk20Char);
      new exgui.DataBindTextWithChecker(txtTo, "",
                                         "", 20,
                                         (exgui.Object2String)chk20Char,
                                         (exgui.ultratable.CellTxtEditorFormat)
                                         chk20Char);
    pnl2List.firstPage();
  }
  class Pnl2ListOtherRange extends exgui.ultratable.FuncAbstractUltraTablePanel{
    public Pnl2ListOtherRange(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        rec.set(storedRecordColumn[col], obj);
        //hmDDKRecords.put(rec.get(0),rec);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
        return null;
      }
    }
    public void doUpdate()throws Exception{
      super.updateModifiedRecord();
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable  me){
       me.setTextEditorVerifiers(klmObjKvtHt);
    }
  }
  class TempDbHandler extends exgui.ultratable.PagedDataFactoryAdapter{
    newtimesejb.TPE_MIS.TpeMisFunc ejbTpeMis=null;
    TempDbHandler(){
      try{
        newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc");
        ejbTpeMis=ejbHome.create();
        blankRecord =exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("TPE_DATE_RANGE_tbl");
        blankRecord.set("record_delete_flag","-1");
        blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
        blankRecord.set("CEN_CODE",cenCode);
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error While Connect to Server",
                                               "Remote Error");
      }
    }
    public void updateRecords(Vector vct)throws Exception{
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_TPE_DATE_RANGE");
      hm.put("TPE_DATE_RANGE_RECORDS",vct);
      ejbTpeMis.tpeMisFunc(hm);
    }
    public Vector getRecords(int bgn,int count)throws Exception{
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       "select * from tpe_date_range where record_delete_flag='1' and cen_code='"+cenCode+"'"
       ,1,9999
      );
      return vct;
    }
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    String str2add=txtName.getText().trim().toUpperCase();
    if("".equals(str2add))return;
     for(int i=0;i<pnl2List.getJtable().getRowCount();i++){
       String str=
           (String)pnl2List.getJtable().getValueAt(i,0);
       if(str.equals(str2add)){
         exgui.verification.VerifyLib.showAlert("\""+str2add+"\" Already Exist!!",
                                                "Record exists");
         return;
       }
     }
     try{
       Record rec2add = tmpHandler.getBlankRecord();
       rec2add.set(0, str2add);
       rec2add.set(1, txtFrom.getText().trim());
       rec2add.set(2, txtTo.getText().trim());
       rec2add.set(10,cenCode);
       Vector vct=new Vector();
       vct.add(rec2add);
       tmpHandler.updateRecords(vct);
       pnl2List.reload();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Insert Fail!!\nPlease Contact System Manager",
                                              "Insert Fail");
     }

  }

 void btnUPdate_actionPerformed(ActionEvent e) {
   try{
     pnl2List.doUpdate();
     exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     exgui.verification.VerifyLib.showAlert("Error While Update Records","Update Fail");
   }
}

  void btnExit_actionPerformed(ActionEvent e) {
      dlg2contain.hide();
  }
}
