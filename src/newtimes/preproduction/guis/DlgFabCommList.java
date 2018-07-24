package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import exgui.ultratable.PagedDataFactory;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.awt.event.*;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgFabCommList extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  protected int myOperationStatus=0;
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  JPanel pnl2SetList = new JPanel();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel3 = new JPanel();
  JButton btnOK = new JButton();
  BorderLayout borderLayout3 = new BorderLayout();
  PagedDataFactory pgDataFxy=null;
  PnlFabCommList pnl2listFabComm=null;
  JButton btnAdd = new JButton();
  FlowLayout flowLayout1 = new FlowLayout();
  JButton btnDelete = new JButton();
  JButton btnUpdate = new JButton();
  JButton btnCopy = new JButton();
  JButton btnPast = new JButton();
  public DlgFabCommList(Frame frame, String title, boolean modal,PagedDataFactory pgFxy) {
    super(frame, title, modal);
    try {
      pgDataFxy=pgFxy;
      jbInit();
      pnl2listFabComm.firstPage();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public int getDialogStatus(){return myOperationStatus;}
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }

  public DlgFabCommList() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);

    jPanel1.setLayout(borderLayout2);
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setSelected(false);
    btnOK.setText("     EXIT    ");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    pnl2SetList.setLayout(borderLayout3);
    jPanel3.setDebugGraphicsOptions(0);
    jPanel3.setLayout(flowLayout1);
    util.InsertionOrderedHashMap headColum=new util.InsertionOrderedHashMap();
    //FAB_COMM_UNIT, FAB_COMM_SUPPLIER, FAB_COMM_PI, FAB_COMM_BYR_ODR_NO, FAB_COMM_DESC, FAB_COMM_DEL,
    //FAB_COMM_DISCOUNT_KIND, FAB_COMM_DISCOUNT, FAB_COMM_PI_RCV, FAB_COMM_DISCOUNT_RCV
    //headColum.put("TYPE¡¿","FAB_COMM_TYPE");
    headColum.put("UNIT¡¿","FAB_COMM_UNIT");
    headColum.put("SUPPLIER","FAB_COMM_SUPPLIER");
    //headColum.put("  PI  ","FAB_COMM_PI");
    headColum.put("BUYER\nORDER NO","FAB_COMM_BYR_ODR_NO");
    headColum.put("DESCRIPTION","FAB_COMM_DESC");
    headColum.put("DELIVERY\nDate","FAB_COMM_DEL");
    headColum.put("KIND¡¿","FAB_COMM_DISCOUNT_KIND");
    headColum.put("CURRENCY¡¿","FAB_COMM_CUR");
    headColum.put("DISCOUNT","FAB_COMM_DISCOUNT");
    //headColum.put("PI\nRECIVER DATE","FAB_COMM_PI_RCV");
    headColum.put("DISCOUNT\nRECIVE DATE","FAB_COMM_DISCOUNT_RCV");

    java.util.Hashtable ht=new java.util.Hashtable();
    Object vfy20Char=exgui.verification.CellFormat.getOrdinaryField(20);
    //Object vfy10Char=exgui.verification.CellFormat.getOrdinaryField(10);
    Object vfy15Char=exgui.verification.CellFormat.getOrdinaryField(15);
    Object vfyDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object d73=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
    ht.put("SUPPLIER",vfy20Char);
    //ht.put("  PI  ",vfy15Char);
    ht.put("BUYER\nORDER NO",vfy15Char);
    ht.put("DESCRIPTION",vfy20Char);
    ht.put("DELIVERY\nDate",vfyDate);
    ht.put("DISCOUNT",d73);
    //ht.put("TYPE",new VfyFabCommType());
    //ht.put("PI\nRECIVER DATE",vfyDate);
    ht.put("DISCOUNT\nRECIVE DATE",vfyDate);

    pnl2listFabComm=new PnlFabCommList(pgDataFxy,100,headColum,ht);
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("CONFIRM EDIT");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnCopy.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy.setText("COPY");
    btnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy_actionPerformed(e);
      }
    });
    btnPast.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPast.setText("PASTE");
    btnPast.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPast_actionPerformed(e);
      }
    });
    pnl2SetList.add(pnl2listFabComm,BorderLayout.CENTER);
    getContentPane().add(panel1);
    panel1.add(pnl2SetList, BorderLayout.CENTER);
    panel1.add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(jPanel2,  BorderLayout.CENTER);
    jPanel1.add(jPanel3,  BorderLayout.EAST);

    //if(newtimes.production.ProdMaintain_Properties.isProductionAuditConfirmedOrPrinted()){
    if(!newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        jPanel3.add(btnCopy, null);
        jPanel3.add(btnOK, null);
     }else{
       jPanel3.add(btnAdd, null);
       jPanel3.add(btnUpdate, null);
       jPanel3.add(btnCopy, null);
       jPanel3.add(btnPast, null);
       jPanel3.add(btnDelete, null);
       jPanel3.add(btnOK, null);
   }
  }

  void btnOK_actionPerformed(ActionEvent e) {
      myOperationStatus=STATUS_CLOSE_NORMALLY;
      dispose();
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    pnl2listFabComm.addRecord();
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    pnl2listFabComm.doDeleteRecord();
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      pnl2listFabComm.confirmUpdate();
      myOperationStatus=STATUS_CLOSE_NORMALLY;
      dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Update Fail!!\nPlease Contact System Manager","Update Fail!!");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  void btnCopy_actionPerformed(ActionEvent e) {
    pnl2listFabComm.doCopy();
  }

  void btnPast_actionPerformed(ActionEvent e) {
    pnl2listFabComm.doPast();
  }
}
class PnlFabCommList extends FuncAbstractUltraTablePanel {
  exgui.ultratable.Wraper4tblCbx arr_FabCommKind[]=new exgui.ultratable.Wraper4tblCbx[5];
  exgui.ultratable.Wraper4tblCbx arr_FabCommType[]=new exgui.ultratable.Wraper4tblCbx[2];
  protected  PnlFabCommList(
     PagedDataFactory pagedDataFxy,
     int rowCounts,util.InsertionOrderedHashMap columnMapping,
     java.util.Hashtable object2StringConvertor
   ) {
    //because the paged data factory can be dummy engin or ejb remote interface.so we need user to assign it.
    super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
    exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_1=
        new exgui.ultratable.Wraper4tblCbx("1"," % ");
    exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_2=
        new exgui.ultratable.Wraper4tblCbx("2","USD/UNIT");
    exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_3=
        new exgui.ultratable.Wraper4tblCbx("3","TWD/UNIT");
    exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_4=
        new exgui.ultratable.Wraper4tblCbx("4","RMB/UNIT");

    exgui.ultratable.Wraper4tblCbx FAB_COMM_Kind_5=
        new exgui.ultratable.Wraper4tblCbx("5","HKD/UNIT");

    arr_FabCommKind[0]=FAB_COMM_Kind_1;
    arr_FabCommKind[1]=FAB_COMM_Kind_2;
    arr_FabCommKind[2]=FAB_COMM_Kind_3;
    arr_FabCommKind[3]=FAB_COMM_Kind_4;
    arr_FabCommKind[4]=FAB_COMM_Kind_5;



    exgui.ultratable.Wraper4tblCbx FAB_COMM_Type_1=
        new exgui.ultratable.Wraper4tblCbx("FABRIC","FABRIC");
    arr_FabCommType[0]=FAB_COMM_Type_1;
    exgui.ultratable.Wraper4tblCbx FAB_COMM_Type_2=
        new exgui.ultratable.Wraper4tblCbx("TRIM","TRIM");
    arr_FabCommType[1]=FAB_COMM_Type_2;


  }
  protected void makeTable(Vector vct){
    super.makeTable(vct);
    //fill in the 6th column with co-responding string .
    for(int i=0;i<getJtable().getRowCount();i++){
      Object obj=getJtable().getValueAt(i,5);//PI removed @ 2009/04/18
      //Object obj=getJtable().getValueAt(i,7);
      if(obj!=null){
        int kind_id=Integer.parseInt(obj.toString());
        //getJtable().setValueAt(arr_FabCommKind[kind_id-1],i,7);
        getJtable().setValueAt(arr_FabCommKind[kind_id-1],i,5);
      }
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    try{
       rec.set(storedRecordColumn[columnAt], value2update);
       return rec;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return tblHeadColumn;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    //column of check box
    java.util.Vector recUnits=newtimes.preproduction.guis.tempProperties.tmpUnits;

    //multiEditorJTableInSuper.addJComboBox(0,arr_FabCommType,false);
    multiEditorJTableInSuper.addJComboBox(0,recUnits,"UNIT","UNIT");
    //PI removed
    multiEditorJTableInSuper.addJComboBox(5,arr_FabCommKind,false);
    //currency combox 20061211
    multiEditorJTableInSuper.addJComboBox(6,tempProperties.tmpCurrency,
                                          "CRNCY_NAME","CRNCY_NAME");//
   /*
    multiEditorJTableInSuper.addJComboBox(0,arr_FabCommType,false);
    multiEditorJTableInSuper.addJComboBox(1,recUnits,"UNIT","UNIT");
    multiEditorJTableInSuper.addJComboBox(7,arr_FabCommKind,false);
   */
    multiEditorJTableInSuper.setTextEditorVerifiers(klmObjKvtHt);
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return _rowCounts;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return klmObjKvtHt;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return dbHandler;
  }

}

