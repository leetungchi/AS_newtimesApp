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

public abstract class AbstractUltraTablePanel extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
  protected JButton jbtn1st = new JButton();
  protected JButton jbtnLast = new JButton();
  protected JButton jbtnNext = new JButton();
  protected JButton jbtnPrev = new JButton();
  protected java.util.Vector records2Display = null;
  protected PagedDataFactory dbHandler;
  protected util.InsertionOrderedHashMap tblHeadColumn = null;
  protected java.util.Hashtable klmObjKvtHt = null;
  protected Vector _displayingRecords = null;
  protected Vector _records2Update = new Vector();

  //static final int list4Undeleted=0;
  //static final int list4Deleted=1;
  public int _rowPosition = 0;
  public int _rowCounts = 30;
  private int _totalRecordCounts = 0;
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  protected String[] storedRecordColumn = new String[0];
  MultiEditorJTable multiEditorJTable1 = new MultiEditorJTable();
  JTable _jTable1 = null;
  exgui.MultiClassTableModel _mcTblMdl = null;
  MakeTableNotify mktblNotify2;
  protected AbstractUltraTablePanel(
      PagedDataFactory pagedDataFxy,
      int rowlength, util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor
      ) {
    dbHandler = pagedDataFxy;
    _rowCounts = rowlength;
    _rowPosition = 0;
    tblHeadColumn = columnMapping;
    klmObjKvtHt = object2StringConvertor;
    try {
      getInsertionOrderedHashMapValues(tblHeadColumn);
      jbInit();
      //firstPage();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void setMakeTableNotifier(MakeTableNotify notify2) {
    mktblNotify2 = notify2;
  }

  protected void doInit() throws Exception {
    jbInit();
    dbHandler = getPagedDataFactory();
    _rowCounts = getEachPageRowCount();
    _rowPosition = 0;
    tblHeadColumn = getHeadColumnMap();
    klmObjKvtHt = getObject2StringConvertor();
    getInsertionOrderedHashMapValues(tblHeadColumn);
    //firstPage();
  }

  protected AbstractUltraTablePanel() {
    try {
      doInit();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout3);
    jPanel3.setLayout(gridLayout1);
    gridLayout1.setColumns(4);
    gridLayout1.setHgap(10);
    gridLayout1.setVgap(10);
    jbtn1st.setBackground(Color.lightGray);
    jbtn1st.setFont(new java.awt.Font("Serif", 1, 12));
    jbtn1st.setAlignmentY((float)0.0);
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
    borderLayout3.setVgap(20);
    borderLayout1.setVgap(5);
    jPanel3.setMinimumSize(new Dimension(234, 10));
    jPanel3.setOpaque(false);
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setOpaque(false);
    this.setBackground(new Color(204, 204, 225));
    jPanel1.setBackground(new Color(204, 204, 225));
    multiEditorJTable1.setBackground(new Color(204, 204, 255));
    this.add(jPanel1, BorderLayout.SOUTH);
    jPanel1.add(jPanel3, BorderLayout.WEST);
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    this.add(multiEditorJTable1, BorderLayout.CENTER);
    jPanel3.add(jbtn1st, null);
    jPanel3.add(jbtnPrev, null);
    jPanel3.add(jbtnNext, null);
    jPanel3.add(jbtnLast, null);
    _jTable1 = multiEditorJTable1.getJTable();
  }

  public JPanel getPanelContainsButtons() {return jPanel3; }

  public JPanel getPanelContainsJTabl() {return multiEditorJTable1; }

  public JPanel getLowerRightPanel() {return jPanel4; }

  protected void getInsertionOrderedHashMapValues(util.InsertionOrderedHashMap
                                                  isodHm) {
    if (isodHm == null) {
      return;
    }
    java.util.Iterator itr = isodHm.entrySet().iterator();
    java.util.ArrayList arrTemp = new java.util.ArrayList();
    while (itr.hasNext()) {
      java.util.Map.Entry entry = (java.util.Map.Entry)itr.next();
      arrTemp.add((String)entry.getValue());
    }
    storedRecordColumn = (String[])arrTemp.toArray(new String[0]);
  }

  public void setHeadColumnMap(util.InsertionOrderedHashMap headColumnMap) {
    tblHeadColumn = headColumnMap;
    getInsertionOrderedHashMapValues(tblHeadColumn);
  }

  public void setObj2StringConverter(java.util.Hashtable converterMaps) {
    klmObjKvtHt = converterMaps;
  }

  /*
     public void setJTable(JTable jtable){
    _jTable1=jtable;
     }
   */
  public JTable getJtable() {
    return _jTable1;
  }

  /*
     public void setDataOperator(PagedDataFactory pgdbfty){
    dbHandler=pgdbfty;
     }
   */
  protected void makeTable(java.util.Vector records) {
    exgui.DataBindJTable dbTbl = new exgui.DataBindJTable(
        _jTable1, records, tblHeadColumn, klmObjKvtHt);
    //before refine  multiEditorJTable1,clear all the previouse editable columns
    ((exgui.MultiClassTableModel)_jTable1.getModel()).removeAllEditableColumn();
    //use refinedEditor function in child class
    //create groupableTableHeader for group-column needs
    /*
         _jTable1.setTableHeader(
      new exgui.GroupableTableHeader(
      _jTable1.getColumnModel()
      )
         );
     */

    multiEditorJTable1.removeAllColumnGrp();
    multiEditorJTable1.setDisplayingRecords(records, tblHeadColumn);
    refineEditors(multiEditorJTable1); //call child to praper other editors;
    //reassign header if other field insert after "refineEditors"
    exgui.MultiLineHeaderRenderer renderer = new exgui.MultiLineHeaderRenderer();
    java.util.Enumeration enum_ = _jTable1.getColumnModel().getColumns();
    while (enum_.hasMoreElements()) {
      ((javax.swing.table.TableColumn)enum_.nextElement()).setHeaderRenderer(
          renderer);
    }
    multiEditorJTable1.getJTable().getTableHeader().setReorderingAllowed(false);
    multiEditorJTable1._storeColumnPosition.clear();
    multiEditorJTable1.storeTableModel();
    multiEditorJTable1.addAllColumnGrp2TblHead();
    //_mcTblMdl=(multiEditorJTable1)multiEditorJTable1.getJTable().getModel();
    if (mktblNotify2 != null) {
      mktblNotify2.MakingTable(records);
    }
  }

  public void disableAllPageButtons() {
    jbtn1st.setEnabled(false);
    jbtnPrev.setEnabled(false);
    jbtnNext.setEnabled(false);
    jbtnLast.setEnabled(false);
  }

  public void turnOnButtons(java.util.Vector records) {
    disableAllPageButtons();
    _totalRecordCounts = 0;
    if (records == null) {
      return;
    }
    if (records.size() == 0) {
      return;
    }

    if (records.size() == 1
        && _rowPosition % _rowCounts == 0
        && _rowPosition != 0
        ) {
      //consider to flip th last page,not only to display last row.
      _rowPosition = _rowPosition - _rowCounts + 1;
      goPage(_rowPosition, _rowCounts);
    }
    database.datatype.Record tempRec = (database.datatype.Record)records.get(0);
    int totalRowCount = tempRec.orgTotalRecordsCount();
    if ((_rowPosition + _rowCounts - 1) < totalRowCount) {
      jbtnNext.setEnabled(true);
      jbtnLast.setEnabled(true);
    } else {
      jbtnNext.setEnabled(false);
      jbtnLast.setEnabled(false);
    }
    if (_rowPosition > 1) {
      jbtn1st.setEnabled(true);
      jbtnPrev.setEnabled(true);
    } else {
      jbtn1st.setEnabled(false);
      jbtnPrev.setEnabled(false);
    }
    _totalRecordCounts = totalRowCount;
  }

  protected boolean updateModifiedRecord() throws Exception {
    if (!multiEditorJTable1.isTableOk()) {
      return false;
    }
    if (_records2Update == null) {
      return true;
    }
    //if(_records2Update.size()==0){
    _records2Update = kvtModifiedField2Records(
        multiEditorJTable1.getModifiedRowAndColumn()
        );
    //}
    /*
     remarked at 20030508,trigger the PagedDataFactory while update comand is invoked.
               //if(_records2Update.size()==0) return true;
     */
    dbHandler.updateRecords(_records2Update);
    _records2Update.removeAllElements();
    //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");
    return true;
  }

  public void firstPage() {
    if (!multiEditorJTable1.isTableOk()) {
      return;
    }
    _rowPosition = 1;
    goPage(_rowPosition, _rowCounts);
  }

  protected void lastPageWithoutUpdate() {
    if (!multiEditorJTable1.isTableOk()) {
      return;
    }
    int _orgTotalRecordCounts = _totalRecordCounts;
    int pages = 0;
    if (_totalRecordCounts % _rowCounts == 0) {
      pages = (_totalRecordCounts / _rowCounts) - 1;
    } else {
      pages = (_totalRecordCounts / _rowCounts);
    }
    _rowPosition = (pages * _rowCounts) + 1;
    goPage(_rowPosition, _rowCounts, false);
    //after gotolast paget,detected row count changed,need to do again.
    if (_totalRecordCounts != _orgTotalRecordCounts) {
      //lastPage();
      lastPageWithoutUpdate();
    }
  }

  //this funciton sometimes is need by "PanelDispather" class,to restore the status.
  public void gotoRowPosition(int rowPosition) {
    _rowPosition = rowPosition;
    goPage(_rowPosition, _rowCounts);
  }

  public void lastPage() {
    if (!multiEditorJTable1.isTableOk()) {
      return;
    }
    int _orgTotalRecordCounts = _totalRecordCounts;
    int pages = 0;
    if (_totalRecordCounts % _rowCounts == 0) {
      pages = (_totalRecordCounts / _rowCounts) - 1;
    } else {
      pages = (_totalRecordCounts / _rowCounts);
    }
    _rowPosition = (pages * _rowCounts) + 1;
    goPage(_rowPosition, _rowCounts);
    //after gotolast paget,detected row count changed,need to do again.
    if (_totalRecordCounts != _orgTotalRecordCounts) {
      lastPage();
    }
  }

  public void nextPage() {
    if (!multiEditorJTable1.isTableOk()) {
      return;
    }
    _rowPosition += _rowCounts;
    goPage(_rowPosition, _rowCounts);
  }

  public void previousePage() {
    if (!multiEditorJTable1.isTableOk()) {
      return;
    }
    _rowPosition -= _rowCounts;
    goPage(_rowPosition, _rowCounts);
  }

  public int getCurrentRowStartAtPosition() {
    return _rowPosition;
  }

  protected void goPage(int rowStartAt, int rowCount,
                        boolean need2UpdateXntPage) {
    _rowPosition = rowStartAt;
    _rowCounts = rowCount;
    disableAllPageButtons();
    /*
         Cursor ksr=null;
         if(getParent()!=null){
      ksr=getParent().getCursor();
      getParent().setCursor(new Cursor(Cursor.WAIT_CURSOR));
         }
     */
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    try {
      if (need2UpdateXntPage) {
        updateModifiedRecord();
      }
      if (rowStartAt <= 0) {
        rowStartAt = 1;
      }
      if (dbHandler == null) {
        dbHandler = getPagedDataFactory();
      }
      Vector recs = dbHandler.getRecords(rowStartAt, rowCount);
      /*
              if(rowStartAt==1) currentDestPage=1;
         else
              currentDestPage=(rowStartAt/rowCount)+1;
       */
      //System.out.println("currentDestPage="+currentDestPage);

      _displayingRecords = recs;
      makeTable(recs);
      turnOnButtons(recs);
      multiEditorJTable1._processingTxtLostFocus = false;
      multiEditorJTable1._lastTimeVarifyResult = true;
      multiEditorJTable1._lastEditingRow = -1;
      multiEditorJTable1._lastEditingColumn = -1;
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,
                                 "exp while to goto " + rowStartAt + "th record in table");
      exgui.verification.VerifyLib.showPlanMsg(
          "Error in goto " + rowStartAt + "th record in table",
          "remote exception"
          );
    } finally {
      //if(ksr!=null)getParent().setCursor(Cursor.getDefaultCursor());
      //newtimes.production.ProdMaintain_Properties.setNormalCursor();
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }

  protected void goPage(int rowStartAt, int rowCount) {
    goPage(rowStartAt, rowCount, true);
  }

  public boolean confirmUpdate() throws Exception {
    if (!multiEditorJTable1.isTableOk()) {
      return false;
    }
    return updateModifiedRecord();
  }

  public void reload() {
    Cursor ksr = getCursor();
    setCursor(new Cursor(Cursor.WAIT_CURSOR));
    try {
      if (_rowPosition <= 0) {
        _rowPosition = 1;
      }
      Vector recs = dbHandler.getRecords(_rowPosition, _rowCounts);
      ///==================recount position if delete the first  record of some paget.================================
      //System.out.println("ORG _rowPosition"+_rowPosition);
      if (recs.size() == 1
          && _rowPosition % _rowCounts == 0
          && _rowPosition != 1
          ) {
        //consider to flip th last page,not only to display last row.
        _rowPosition = _rowPosition - _rowCounts + 1;
        //System.out.println("fixed _rowPosition"+_rowPosition);
        recs = dbHandler.getRecords(_rowPosition, _rowCounts);
      }

      //===============================================================================================
      _displayingRecords = recs;
      makeTable(recs);
      turnOnButtons(recs);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "exp while reloading page table");
      exgui.verification.VerifyLib.showPlanMsg(
          "Error in reloading page to table",
          "remote exception"
          );
    } finally {
      setCursor(ksr);
    }
    //goPage(_rowPosition,_rowCounts);
  }

  public void deleteRow(database.datatype.Record rec2Restore) {
    Cursor ksr = getCursor();
    setCursor(new Cursor(Cursor.WAIT_CURSOR));
    try {
      int orgRecCountInXntPage = _displayingRecords.size();
      dbHandler.deleteRecord(rec2Restore);
      //flip to previous page if delete the only-one  record in current page.
      if (orgRecCountInXntPage == 1) {
        //lastPage();
        lastPageWithoutUpdate();
      } else {
        reload();
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,
          "exp while deleteRecod in PagedTablPanel of StyeTable");
      exgui.verification.VerifyLib.showPlanMsg(
          "server side exception while attemp to delete record",
          "server side exception");
    } finally {
      setCursor(ksr);
    }

  }

  public void restoreRow(database.datatype.Record rec2Restore) {
    Cursor ksr = getCursor();
    setCursor(new Cursor(Cursor.WAIT_CURSOR));
    try {
      dbHandler.restoreRecord(rec2Restore);
      reload();
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,
          "exp while restore Recod in PagedTablPanel of StyeTable");
      exgui.verification.VerifyLib.showPlanMsg(
          "server side exception while attemp to restore record",
          "server side exception");
      util.ExceptionLog.exp2File(e,
          "exp while restore in PagedTablPanel of StyeTable");
    } finally {
      setCursor(ksr);
    }
  }

  void jbtn1st_mouseClicked(MouseEvent e) {
    if (jbtn1st.isEnabled()) {
      firstPage();
    }
  }

  void jbtn1st_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      e.setKeyCode(0);
      jbtn1st_mouseClicked(null);
    }
  }

  void jbtnPrev_mousePressed(MouseEvent e) {
    if (jbtnPrev.isEnabled()) {
      previousePage();
    }
  }

  void jbtnPrev_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      e.setKeyCode(0);
      jbtnPrev_mousePressed(null);
    }
  }

  void jbtnNext_mousePressed(MouseEvent e) {
    if (jbtnNext.isEnabled()) {
      nextPage();
    }
  }

  void jbtnNext_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      e.setKeyCode(0);
      jbtnNext_mousePressed(null);
    }
  }

  void jbtnLast_mousePressed(MouseEvent e) {
    if (jbtnLast.isEnabled()) {
      lastPage();
    }
  }

  void jbtnLast_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      e.setKeyCode(0);
      jbtnLast_mousePressed(null);
    }
  }

  public Vector getDisplayingRecords() {
    return _displayingRecords;
  }

  /*
     protected  void registRecord2UPdate(Record rec2update){
     _records2Update.add(rec2update);
     }
   */
  public String[] getStoredRecordColumns() {
    return storedRecordColumn;
  }

  public MultiEditorJTable getMultiEditorJTable() {
    return multiEditorJTable1;
  }

  protected Vector kvtModifiedField2Records(HashMap rowAndColumnAndValue) {
    //get records vetor to parse latter.
    java.util.Vector displayingRecords = getDisplayingRecords();
    //java.util.Hashtable proccessedRecords=new java.util.Hashtable();
    java.util.TreeMap proccessedRecords = new java.util.TreeMap();
    //util.InsertionOrderedHashMap proccessedRecords=new util.InsertionOrderedHashMap();
    java.util.Iterator itr = rowAndColumnAndValue.keySet().iterator();
    while (itr.hasNext()) {
      //get key object
      exgui.ultratable.RowColumn rowAndcol =
          (exgui.ultratable.RowColumn)itr.next();
      Object value2update = rowAndColumnAndValue.get(rowAndcol);
      if (value2update instanceof Wraper4tblCbx) {
        value2update = ((Wraper4tblCbx)value2update).getValue();
      }
      //see if this record is process or not.
      Integer rowAt = new Integer(rowAndcol._rowAt);
      Object recObj = proccessedRecords.get(rowAt);
      //record is precces,retreive it from processed hashtable,and process again.
      if (recObj != null) {
        recObj = setObject2Record((Record)recObj, rowAndcol._columnAt,
                                  value2update);
        if (recObj != null) {
          proccessedRecords.put(rowAt, recObj);
        }
      } else {
        //this is newly record to update,retrieve it from
        Record rec = (Record)displayingRecords.get(rowAndcol._rowAt);
        rec = setObject2Record(rec, rowAndcol._columnAt, value2update);
        if (rec != null) {
          proccessedRecords.put(rowAt, rec);
        }
      }
    }
    //after all,make processed records to vector.
    java.util.Vector records2UpdateLatter = new java.util.Vector();
    java.util.Iterator itrMap = proccessedRecords.keySet().iterator();
    while (itrMap.hasNext()) {
      records2UpdateLatter.add(proccessedRecords.get(itrMap.next()));
    }

    /*java.util.Iterator  emu= proccessedRecords.entrySet().iterator();
         while(emu.hasNext()){
       records2UpdateLatter.add(proccessedRecords.get(emu.next()));
         }*/
    return records2UpdateLatter;
  }

  //remind child class to implement process of assign Editos.
  /**
   * force child class to add other Editors,shuch as :<br>
   * multiEditorJTableInSuper.addCheckbox(columnAt,columnName,Boolean values[]);<br>
   * multiEditorJTableInSuper.addJComboBox(columnAt,ItemStrings[],editablorNot);<br>
   * multiEditorJTableInSuper.addTextAreaEditor(columnAt,maxLength)<br>
   * multiEditorJTableInSuper.addTextAreaEditor(columnAt)<br>
   * or even to set editorverifier for desired column:<br>
   * multiEditorJTableInSuper.setTextEditorVerifiers(HashTabe columnAsKeyCellTxtEditorFormatAsValue)
   * @param multiEditorJTableInSuper
   */
  abstract protected void refineEditors(MultiEditorJTable
                                        multiEditorJTableInSuper);

  /**
   * force child to set value to udpate to record,the columnAt is modified field in jtable of display
   * @param rec--the record mapping to jtable's modified row.
   * @param columnAt --column position of modified cell
   * @param value2update--modified value to udpate
   * @return the record(usualy sourced as input paramenter--"rec") which had set value2udpate to correct field of record to return
   */
  abstract protected Record setObject2Record(Record rec, int columnAt,
                                             Object value2update);

  //force child to implement following methods.
  abstract protected PagedDataFactory getPagedDataFactory();

  abstract protected util.InsertionOrderedHashMap getHeadColumnMap();

  abstract protected java.util.Hashtable getObject2StringConvertor();

  abstract protected int getEachPageRowCount();

}
