package newtimes.shipping.styleclose;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class StyleCloseTableEditor extends PnlTableEditor implements exgui.ultratable.MakeTableNotify {
  StyleCloseDataFactoryAdapter listDataSrc = null;
  static final String CHECK = "CLOSE";
  static final String BUYER="BUYER";
  static final String FTY = "MAKER";
  static final String DIV = "Division";
  static final String SEA = "Season";
  static final String YEAR = "Year";
  static final String RANGE = "Range";
  static final String SC_NO = "    S/C NO.    ";
  static final String STYLE = "Style";
  static final String PO = "PO";
  static final String DEL_DATE="DEL.\nDate";
  static final String UNIT = "UNIT";
  static final String O_QTY = "Order\nQTY";
  static final String S_QTY = "Shipped\nQTY";
  static final String B_QTY = "Balance\nQTY";
  static final String UNSHIP_RATIO="UNSHIP\nRATIO";
  static final exgui.ultratable.Wraper4tblCbx[] CLOSE_STATUS_OBJECTS={
      new exgui.ultratable.Wraper4tblCbx("Y","CLOSE"),
      new exgui.ultratable.Wraper4tblCbx("N","NO CLOSE"),
      new exgui.ultratable.Wraper4tblCbx("B","ON BOARD")
  };
  static String[] CLOSE_STATUS={"Y","N","B"};
  static InsertionOrderedHashMap iso = null;
  javax.swing.JComboBox cbxTotalValue=new javax.swing.JComboBox(CLOSE_STATUS_OBJECTS);
  JButton btn2SelectAll=new JButton();
  JButton btn2SetDelDats=new JButton();
  javax.swing.JTextField  txtDelDate=new javax.swing.JTextField();
  static boolean CLOSE_EDITABLE=true;
  exgui.DataBindTextWithChecker dbTxtDate=null;
  javax.swing.JTextField  txtDelDateInCell;
  exgui.ultratable.CellTxtEditorFormat
  dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
  public StyleCloseTableEditor() {
    super.setMakeTableNotifier(this);
    super.firstPage();
    getJtable().setRowHeight(20);
    ((StyleCloseDataFactoryAdapter)dbHandler).hmUpdatedStatus=new java.util.HashMap();
    /*
    getJtable().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
              jTable_mouseReleased(e);
            }
          });*/

          btn2SelectAll.setBackground(Color.lightGray);
          btn2SelectAll.setFont(new java.awt.Font("Dialog", 1, 12));
          btn2SelectAll.setForeground(Color.black);
          btn2SelectAll.setText("<html><body>Set Selected<br>Row(s) To:</body></html>");

          btn2SetDelDats.setBackground(Color.lightGray);
          btn2SetDelDats.setFont(new java.awt.Font("Dialog", 1, 12));
          btn2SetDelDats.setForeground(Color.black);
          btn2SetDelDats.setText("<html><body>Set Selected<br>Row(s) To:</body></html>");

          dbTxtDate =
              new  exgui.DataBindTextWithChecker(txtDelDate,"",null,
              10,(exgui.Object2String)dateVfy,
               (exgui.ultratable.CellTxtEditorFormat)dateVfy);



          btn2SelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
              butnAll_actionPerformed(e);
            }
          });
          btn2SetDelDats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
              btn2SetDelDats_actionPerformed();
            }
          });
      txtDelDate.setPreferredSize(cbxTotalValue.getPreferredSize());
      getLowerRightPanel().add(btn2SetDelDats);
      getLowerRightPanel().add(txtDelDate);
      getLowerRightPanel().add(btn2SelectAll);
      getLowerRightPanel().add(cbxTotalValue);
  }
  public void MakingTable(java.util.Vector vct){
    getJtable().getColumnModel().getColumn(4).setPreferredWidth(48);//style-PO
    getJtable().getColumnModel().getColumn(6).setPreferredWidth(41);//style-unit
    getJtable().getColumnModel().getColumn(7).setPreferredWidth(53);//style-order qty
    getJtable().getColumnModel().getColumn(8).setPreferredWidth(60);//style-ship-qty
    getJtable().getColumnModel().getColumn(9).setPreferredWidth(54);//balance -qty
    getJtable().getColumnModel().getColumn(10).setPreferredWidth(51);//unship ratio
    getJtable().getColumnModel().getColumn(11).setPreferredWidth(44);//closed y/n/s (on shipping)
  }
  protected void btn2SetDelDats_actionPerformed(){
    try{
      if(!dbTxtDate.isValidx() || dbTxtDate.getSelectedValue()==null){
        exgui.verification.VerifyLib.showAlert("Please Input Deliver Date To Update","Please Input Deliver Date To Update");
        return;
      }
      java.util.HashMap hm = ((StyleCloseDataFactoryAdapter)getPagedDataFactory()).hmUpdateDelDate;
      java.util.Vector vct=getDisplayingRecords();
      int select_rows[]=getJtable().getSelectedRows();
      Object obj = dbTxtDate.getSelectedValue();
      for(int i=0;i<select_rows.length;i++){
        Record rec = (Record)vct.get(select_rows[i]);
        //getJtable().setValueAt(new Boolean(true), i, 11);
        //Object obj = getJtable().getValueAt(i, 11);
        getJtable().setValueAt(txtDelDate.getText(),select_rows[i], 5);
        hm.put(rec.get("sty_seq").toString(), obj);
      }
    }catch(Exception exp){
        exp.printStackTrace();
    }

  }
  public void butnAll_actionPerformed(ActionEvent e){
    try{
      java.util.HashMap hm = ((StyleCloseDataFactoryAdapter)getPagedDataFactory()).
          hmUpdatedStatus;
      java.util.Vector vct=getDisplayingRecords();
      exgui.ultratable.Wraper4tblCbx wrapObj=(exgui.ultratable.Wraper4tblCbx)cbxTotalValue.getSelectedItem();
      int select_rows[]=getJtable().getSelectedRows();
      for(int i=0;i<select_rows.length;i++){
        Record rec = (Record)vct.get(select_rows[i]);
        String strSeq = rec.get("sty_seq").toString();
        //getJtable().setValueAt(new Boolean(true), i, 11);
        //Object obj = getJtable().getValueAt(i, 11);
        getJtable().setValueAt(wrapObj.getValue(),select_rows[i], 11);
        Object obj = wrapObj.getValue();
        hm.put(strSeq, obj);
      }
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    //return null;
    if(columnAt==5){
      java.util.HashMap hm = ((StyleCloseDataFactoryAdapter)getPagedDataFactory()).hmUpdateDelDate;
      try{
        hm.put(rec.get("sty_seq").toString(), value2update);
      }catch(Exception exp){
         exp.printStackTrace();
      }
    }
    return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(BUYER ,"BUYER");
      iso.put(FTY, "FTY");
      //iso.put(DIV, "DIV");
      //iso.put(SEA, "SEA");
      //iso.put(YEAR, "YEAR");
      //iso.put(RANGE, "RANGE");
      iso.put(SC_NO, "SC_NO");
      iso.put(STYLE, "STYLE");
      iso.put(PO, "PO");
      iso.put(DEL_DATE,"final_delv_date");
      iso.put(UNIT, "UNIT");
      iso.put(O_QTY, "O_QTY");
      iso.put(S_QTY, "S_QTY");
      iso.put(B_QTY, "B_QTY");
      iso.put(UNSHIP_RATIO,"UNSHIP_RATIO");
      iso.put(CHECK, "STY_CLOSE");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected class CloseStatusItemListener  extends java.awt.event.MouseAdapter implements java.awt.event.ItemListener{
    public void itemStateChanged(java.awt.event.ItemEvent ie){
      doing();
    }
    public void doing(){
      //jTable_mouseReleased(null);
      try{
        //if(getJtable().getSelectedRow()==-1)return;
        java.util.HashMap hm = ((StyleCloseDataFactoryAdapter)
                                getPagedDataFactory()).hmUpdatedStatus;
        Record rec = (Record)getDisplayingRecords().get(getJtable().getEditingRow());
        String strSeq = rec.get("sty_seq").toString();

        javax.swing.JComboBox cbx=
        (javax.swing.JComboBox)
        ((javax.swing.DefaultCellEditor)getJtable().getColumnModel().getColumn(11).getCellEditor()).getComponent();


        hm.put(strSeq, cbx.getSelectedItem());
        getJtable().setValueAt(cbx.getSelectedItem(),getJtable().getEditingRow(),11);
        System.out.println("set key:" + strSeq + " ,value:" +getJtable().getValueAt(getJtable().getEditingRow(), 11)); //cbx.getSelectedItem());
        System.out.println("check value:" +
                           ((StyleCloseDataFactoryAdapter)getPagedDataFactory()).
                           hmUpdatedStatus.get(strSeq));
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    public void mouseClicked(java.awt.event.MouseEvent me){
      doing();
    }
  }
  protected class DelDateTxtFxListen extends  java.awt.event.FocusAdapter{
    public void focusLost(FocusEvent e) {
      try {
        String datestr = ((javax.swing.JTextField)e.getSource()).getText().trim();
        int row = getJtable().getSelectedRow();
        Record rec = (Record)getDisplayingRecords().get(row);
        if (datestr.length() == 0) {
          ((StyleCloseDataFactoryAdapter)getPagedDataFactory()).hmUpdateDelDate.
              put(
              rec.get("sty_seq").toString(), null);
        } else {
          ((StyleCloseDataFactoryAdapter)getPagedDataFactory()).hmUpdateDelDate.
              put(
              rec.get("sty_seq").toString(), dateVfy.cellStringToObject(datestr));
        }
       }catch(Exception exp){
         exp.printStackTrace();
       }
    }

  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    //multiEditorJTableInSuper.addCheckbox(11, "Y");
    multiEditorJTableInSuper.addJComboBox(11,CLOSE_STATUS,false);
    javax.swing.JComboBox cbx=
        (javax.swing.JComboBox)
        ((javax.swing.DefaultCellEditor)getJtable().getColumnModel().getColumn(11).getCellEditor()).getComponent();
    //cbx.addMouseListener(new CloseStatusItemListener());
    cbx.addItemListener(new CloseStatusItemListener());
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
     txtDelDateInCell=
        (javax.swing.JTextField)
        ((javax.swing.DefaultCellEditor)getJtable().getColumnModel().getColumn(5).getCellEditor()).getComponent();
    txtDelDateInCell.addFocusListener(new DelDateTxtFxListen());
    if(!CLOSE_EDITABLE){
      multiEditorJTableInSuper.setAllColumnUnEdtiable();
    }
  }
  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
     java.util.Hashtable ht=new java.util.Hashtable();
     ht.put(DEL_DATE,exgui.verification.CellFormat.getDateStringFormaterAllowNull());
     return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    StyleCloseDataFactoryAdapter detailSrc = StyleCloseDataFactoryAdapter.getInstance();
    return detailSrc;
  }
  void jTable_mouseReleased(MouseEvent e) {
    try {
      if(getJtable().getSelectedRow()==-1)return;
      if(getJtable().getEditingColumn()==11 ){
        java.util.HashMap hm=((StyleCloseDataFactoryAdapter)getPagedDataFactory()).hmUpdatedStatus;
        Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
        String strSeq=rec.get("sty_seq").toString();
        Object obj=getJtable().getValueAt(getJtable().getSelectedRow(),11);
        hm.put(strSeq,obj);
        System.out.println("set key:"+strSeq+" ,value:"+obj);
        System.out.println("check value:"+((StyleCloseDataFactoryAdapter)getPagedDataFactory()).hmUpdatedStatus.get(strSeq));
      }
    } catch (Exception eRow) {
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow, "");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
  public void makeTable(java.util.Vector vct){
     //find deliver date object to upate.
     java.util.HashMap hm = ((StyleCloseDataFactoryAdapter)getPagedDataFactory()).hmUpdateDelDate;
    try{
      for (int i = 0; i < vct.size(); i++) {
        Record rec = (Record)vct.get(i);
        if (hm.containsKey(rec.get("sty_seq").toString())) {
          ((Record)vct.get(i)).set("final_delv_date",
                                   hm.get(rec.get("sty_seq").toString()));
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
     super.makeTable(vct);
  }
  protected void goPage(int rowStartAt, int rowCount, boolean need2UpdateXntPage){
    try {
      //StyleCloseListGUI.setCheckRecord2JTable(rowStartAt);
      int col_sty_closeAt=0,col_sty_order_qty_at=0,col_sty_seq_at=0;
      super.goPage(rowStartAt, rowCount, need2UpdateXntPage);
      java.util.HashMap hm = ((StyleCloseDataFactoryAdapter)dbHandler).
          hmUpdatedStatus;
      java.util.Vector records = getDisplayingRecords();
      for (int i = 0; i < records.size(); i++) {
        Record rec = (Record)records.get(i);
        if(i==0){
          col_sty_seq_at=util.MiscFunc.getFieldIndexAtRecord(rec,"sty_seq");
          col_sty_closeAt=util.MiscFunc.getFieldIndexAtRecord(rec,"STY_CLOSE");
          col_sty_order_qty_at=util.MiscFunc.getFieldIndexAtRecord(rec,"O_QTY");
        }

        String seqKey = rec.get(col_sty_seq_at).toString();
        if (hm.containsKey(seqKey)) {
          /*
          Boolean isCheck = new Boolean(hm.get(seqKey).toString());
          getJtable().setValueAt(isCheck, i, 11);
          rec.set(col_sty_closeAt,(isCheck.booleanValue())?"Y":"N");
          */
         exgui.ultratable.Wraper4tblCbx objWrap=new exgui.ultratable.Wraper4tblCbx();
         objWrap.setString((String)hm.get(seqKey));objWrap.setValue(hm.get(seqKey));
         getJtable().setValueAt(objWrap, i, 11);
         rec.set(col_sty_closeAt,hm.get(seqKey));
        }
        Object ratio=rec.get(col_sty_order_qty_at);
        if(ratio==null || Float.parseFloat(ratio.toString())==0){
          getJtable().setValueAt("???", i, 10);
        }
      }

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
