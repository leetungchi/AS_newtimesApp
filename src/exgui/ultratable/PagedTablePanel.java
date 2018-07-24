package exgui.ultratable;
import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class PagedTablePanel extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  BorderLayout borderLayout2 = new BorderLayout();
  protected JTable _jTable1 = new JTable();
  //protected JTable _jTable1=new JTableBindKeyStroke();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
  JButton jbtn1st = new JButton();
  JButton jbtnLast = new JButton();
  JButton jbtnNext = new JButton();
  JButton jbtnPrev = new JButton();
  protected java.util.Vector records2Display=null;
  protected PagedDataFactory dbHandler=null;
  protected util.InsertionOrderedHashMap tblHeadColumn=null;
  protected java.util.Hashtable klmObjKvtHt=null;
  protected Vector _displayingRecords=null;
  protected Vector _records2Update=new Vector();
  //static final int list4Undeleted=0;
  //static final int list4Deleted=1;
  public int _rowPosition=0;
  public int _rowCounts=30;
  private int _totalRecordCounts=0;
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  protected String[] storedRecordColumn=new String[0];
  public PagedTablePanel(
        PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
      ) {
        dbHandler=pagedDataFxy;
        _rowCounts=rowlength;
        _rowPosition=0;
        tblHeadColumn=columnMapping;
        klmObjKvtHt=object2StringConvertor;
        try {
          getInsertionOrderedHashMapValues(tblHeadColumn);
          jbInit();
          firstPage();
        }
        catch(Exception ex) {
          ex.printStackTrace();
        }
  }
  public PagedTablePanel() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setLayout(borderLayout1);
    jPanel2.setLayout(borderLayout2);
    jPanel1.setLayout(borderLayout3);
    jPanel3.setLayout(gridLayout1);
    gridLayout1.setColumns(4);
    gridLayout1.setHgap(10);
    gridLayout1.setVgap(10);

    jbtn1st.setBackground(Color.lightGray);
    jbtn1st.setFont(new java.awt.Font("Serif", 1, 12));
    jbtn1st.setAlignmentY((float) 0.0);
    jbtn1st.setMaximumSize(new Dimension(47, 10));
    jbtn1st.setMinimumSize(new Dimension(47, 10));
    jbtn1st.setPreferredSize(new Dimension(47, 10));
    jbtn1st.setMargin(new Insets(2, 10, 2, 14));
    //jbtn1st.setText("|¡ö");
    jbtn1st.setIcon(exgui.UIHelper.getIcon("first.gif"));
    jbtn1st.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        jbtn1st_keyPressed(e);
      }
    });
    jbtn1st.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        jbtn1st_mouseClicked(e);
      }
    });
    jbtnLast.setBackground(Color.lightGray);
    jbtnLast.setFont(new java.awt.Font("Serif", 1, 12));
    //jbtnLast.setText("¡÷|");
    jbtnLast.setIcon(exgui.UIHelper.getIcon("last.gif"));
    jbtnLast.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        jbtnLast_keyPressed(e);
      }
    });
    jbtnLast.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        jbtnLast_mousePressed(e);
      }
    });
    jbtnNext.setBackground(Color.lightGray);
    jbtnNext.setFont(new java.awt.Font("Serif", 1, 12));
    //jbtnNext.setText("¡÷");
    jbtnNext.setIcon(exgui.UIHelper.getIcon("next.gif"));
    jbtnNext.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        jbtnNext_keyPressed(e);
      }
    });
    jbtnNext.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        jbtnNext_mousePressed(e);
      }
    });
    jbtnPrev.setBackground(Color.lightGray);
    jbtnPrev.setFont(new java.awt.Font("Serif", 1, 12));
    //jbtnPrev.setText("¡ö");
    jbtnPrev.setIcon(exgui.UIHelper.getIcon("prev.gif"));
    jbtnPrev.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        jbtnPrev_keyPressed(e);
      }
    });
    jbtnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        jbtnPrev_mousePressed(e);
      }
    });
    borderLayout2.setHgap(10);
    borderLayout2.setVgap(15);
    borderLayout3.setVgap(20);
    borderLayout1.setVgap(5);
    jPanel3.setMinimumSize(new Dimension(234, 10));
    jPanel3.setOpaque(false);
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setOpaque(false);
    jPanel2.setBackground(new Color(204, 204, 225));
    this.setBackground(new Color(204, 204, 225));
    jPanel1.setBackground(new Color(204, 204, 225));
    jScrollPane1.getViewport().setBackground(new Color(204, 204, 225));
    this.add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(jPanel3, BorderLayout.WEST);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    this.add(jPanel2,  BorderLayout.CENTER);
    jPanel2.add(jScrollPane1,  BorderLayout.CENTER);
    jScrollPane1.getViewport().add(_jTable1, null);
    jPanel3.add(jbtn1st, null);
    jPanel3.add(jbtnPrev, null);
    jPanel3.add(jbtnNext, null);
    jPanel3.add(jbtnLast, null);
  }
  private void  getInsertionOrderedHashMapValues(util.InsertionOrderedHashMap isodHm){
    java.util.Iterator itr=isodHm.entrySet().iterator();
    java.util.ArrayList arrTemp=new java.util.ArrayList();
    while(itr.hasNext()){
      java.util.Map.Entry entry=(java.util.Map.Entry)itr.next();
      arrTemp.add((String)entry.getValue());
    }
    storedRecordColumn=(String[])arrTemp.toArray(new String[0]);
  }
  public void setHeadColumnMap(util.InsertionOrderedHashMap headColumnMap){
    tblHeadColumn=headColumnMap;
    getInsertionOrderedHashMapValues(tblHeadColumn);
  }
  public void setObj2StringConverter(java.util.Hashtable converterMaps){
    klmObjKvtHt =converterMaps;
  }
  public void setJTable(JTable jtable){
    _jTable1=jtable;
  }
  public JTable getJtable(){
   return _jTable1;
  }
  public void setDataOperator(PagedDataFactory pgdbfty){
    dbHandler=pgdbfty;
  }
  protected void makeTable(java.util.Vector records){
    exgui.DataBindJTable dbTbl=new exgui.DataBindJTable(
       _jTable1,records,tblHeadColumn,klmObjKvtHt);
  }
  public void disableAllPageButtons(){
    jbtn1st.setEnabled(false);
    jbtnPrev.setEnabled(false);
    jbtnNext.setEnabled(false);
    jbtnLast.setEnabled(false);
  }
  public void turnOnButtons(java.util.Vector records){
    disableAllPageButtons();
    _totalRecordCounts =0;
    if(records==null) return;
    if(records.size()==0) return;
    if(records.size()==1
       && _rowPosition%_rowCounts==0
       && _rowPosition!=0
       ){
         //consider to flip th last page,not only to display last row.
        _rowPosition=_rowPosition-_rowCounts+1;
        goPage(_rowPosition,_rowCounts);
       }
    database.datatype.Record tempRec=(database.datatype.Record)records.get(0);
    int totalRowCount= tempRec.orgTotalRecordsCount();
    if((_rowPosition+_rowCounts-1)==totalRowCount){
      jbtnNext.setEnabled(false);
      jbtnLast.setEnabled(false);
    }else if((_rowPosition+_rowCounts-1)<totalRowCount){
      jbtnNext.setEnabled(true);
      jbtnLast.setEnabled(true);
    }else{
      jbtnNext.setEnabled(false);
      jbtnLast.setEnabled(false);
    }
    if(_rowPosition>1){
      jbtn1st.setEnabled(true);
      jbtnPrev.setEnabled(true);
    }else{
      jbtn1st.setEnabled(false);
      jbtnPrev.setEnabled(false);
    }
    _totalRecordCounts=totalRowCount;
  }
  protected void updateModifiedRecord(){
        try{
          if(_records2Update==null) return;
          if(_records2Update.size()==0)return;
          dbHandler.updateRecords(_records2Update);
        }catch(Exception e){
          e.printStackTrace();
          util.ExceptionLog.exp2File(e,"exp while invoke datahandler to udpate records");
        }
        _records2Update.removeAllElements();
  }
  public void firstPage(){
    _rowPosition=1;
    goPage(_rowPosition,_rowCounts);
  }
  public void lastPage(){
    int pages=_totalRecordCounts/_rowCounts;
    _rowPosition=(pages*_rowCounts)+1;
    goPage(_rowPosition,_rowCounts);
  }
  public void nextPage(){
   _rowPosition+=_rowCounts;
   goPage(_rowPosition,_rowCounts);
  }
  public void previousePage(){
   _rowPosition-=_rowCounts;
   goPage(_rowPosition,_rowCounts);
  }
  protected void goPage(int rowStartAt,int rowCount){
    disableAllPageButtons();
    updateModifiedRecord();
    Cursor ksr=null;
    //newtimes.production.ProdMaintain_Properties.setWaitCursor();

    if(getParent()!=null){
       ksr=getParent().getCursor();
      getParent().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }

      try{
      if(rowStartAt<=0)rowStartAt=1;
       Vector recs=  dbHandler.getRecords(rowStartAt,rowCount);
       _displayingRecords =recs;
       makeTable(recs);
       turnOnButtons(recs) ;
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while to 1st page table");
      exgui.verification.VerifyLib.showPlanMsg(
       "Error in geting 1st page to table",
       "remote exception"
      );
    }finally{
      if(ksr!=null)  getParent().setCursor(ksr);
          //newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  public void reload(){
    goPage(_rowPosition,_rowCounts);
  }
  public void deleteRow(database.datatype.Record rec2Restore){
     try{
       dbHandler.deleteRecord(rec2Restore);
       reload();
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while deleteRecod in PagedTablPanel of StyeTable");
      exgui.verification.VerifyLib.showPlanMsg("server side exception while attemp to delete record","server side exception");
    }
  }
  public void restoreRow(database.datatype.Record rec2Restore){
     try{
       dbHandler.restoreRecord(rec2Restore);
       reload();
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while restore Recod in PagedTablPanel of StyeTable");
      exgui.verification.VerifyLib.showPlanMsg("server side exception while attemp to restore record","server side exception");
      //util.ExceptionLog.exp2File(e,"exp while restore in PagedTablPanel of StyeTable");
    }
  }

  void jbtn1st_mouseClicked(MouseEvent e) {
    if(jbtn1st.isEnabled()) firstPage();
  }

  void jbtn1st_keyPressed(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_ENTER){
      e.setKeyCode(0);
      jbtn1st_mouseClicked(null);
    }
  }

  void jbtnPrev_mousePressed(MouseEvent e) {
    if(jbtnPrev.isEnabled()) previousePage();
  }

  void jbtnPrev_keyPressed(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_ENTER){
      e.setKeyCode(0);
      jbtnPrev_mousePressed(null);
    }
  }

  void jbtnNext_mousePressed(MouseEvent e) {
    if(jbtnNext.isEnabled())nextPage();
  }

  void jbtnNext_keyPressed(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_ENTER){
      e.setKeyCode(0);
      jbtnNext_mousePressed(null);
    }
  }

  void jbtnLast_mousePressed(MouseEvent e) {
    if(jbtnLast.isEnabled())lastPage();
  }

  void jbtnLast_keyPressed(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_ENTER){
      e.setKeyCode(0);
      jbtnLast_mousePressed(null);
    }
  }
  public Vector getDisplayingRecords(){
    return _displayingRecords;
  }
  public void registRecord2UPdate(Record rec2update){
     _records2Update.add(rec2update);
  }
 public String[] getStoredRecordColumns(){
  return storedRecordColumn;
 }
}
