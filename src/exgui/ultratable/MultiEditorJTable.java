package exgui.ultratable;
import exgui.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.table.*;
import java.util.Hashtable;
import javax.swing.event.*;
import java.util.EventObject;
import javax.swing.text.*;
import java.util.Vector;
import java.util.HashMap;
import database.datatype.Record;
import exgui.ultratable.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MultiEditorJTable extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  private GroupableTableHeader _groupableTableHeader=null;
  protected String _datasInJcbx[]=new String[1];
  Object lastOrgObjectB4Editing;
  //JTable _jTable1 = new JTable();
  protected int _lastEditingColumn,_lastEditingRow;
  static boolean isChangingSelection=false;
  static Integer synchKey=new Integer(1);
  static char TAB_CHAR=(char)9;
  JTable _jTable1=new JTable(){

      protected JTableHeader createDefaultTableHeader() {
        return new GroupableTableHeader(columnModel);
      }

      public void changeSelection(final int row, final int column, boolean toggle, boolean extend){
                     if(isChangingSelection)return;
                     isChangingSelection=true;
                     if(mt.m_TxtCmp!=null){
                       //System.out.println("change Selection verifiing "+mt.m_Row +","+mt.m_Col+" value2varify:"+mt.m_Text);
                       synchronized(synchKey){
                         CellTxtEditorFormat objVfy =
                             (CellTxtEditorFormat)_txtEditorVarifiers.get(
                             getColumnName(mt.m_Col));
                         if (!objVfy.isFormatValid(mt.m_Text, mt.m_Row, mt.m_Col)) {
                           exgui.verification.VerifyLib.showAlert(objVfy.formatPromptMsg(),
                               "Formate Error");
                           clearSelection();
                           changeSelection(mt.m_Row, mt.m_Col, false, false);
                           editCellAt(mt.m_Row, mt.m_Col);
                           ((JComponent)_jTable1.getEditorComponent()).grabFocus();
                           ((JTextComponent)_jTable1.getEditorComponent()).selectAll();
                           isChangingSelection = false;
                           return;
                         } else {
                           //Object objValue=objVfy.cellStringToObject(mt.m_Text);
                           //System.out.println("set value " + mt.m_Text + " to " + mt.m_Row +"," + mt.m_Col);
                           if(mt.m_Row<getRowCount() && mt.m_Col < getColumnCount()){
                             setValueAt(mt.m_Text, mt.m_Row, mt.m_Col);
                           }
                         }
                       }
                     }

                     /*
                     if(_currentCellEditor!=null && _currentCellEditor instanceof JTextComponent ){
                       if (!isVaild(_lastEditingRow, _lastEditingColumn,
                                    ((JTextField)_currentCellEditor).getText())){
                         ((JTextComponent)_currentCellEditor).grabFocus();
                         ((JTextComponent)_currentCellEditor).selectAll();
                          isChangingSelection=false;
                          return;
                       }
                     }*/
                     synchronized(synchKey){
                       mt.m_TxtCmp = null;
                     }
                     _lastEditingColumn=column;
                     _lastEditingRow=row;
                      super.changeSelection(row, column, toggle, extend);
                      //System.out.println("change selection at row ,column="+row+","+column +" in MulitMedotrJTable");
                      if(isCellEditable(row,column)){
                        editCellAt(row,column);
                        _currentCellEditor = (JComponent)getEditorComponent();
                        if (_currentCellEditor != null && _currentCellEditor instanceof JTextComponent) {
                                 synchronized(synchKey){
                                   mt.m_Row =row;
                                   mt.m_Col=column;
                                   javax.swing.SwingUtilities.invokeLater(
                                     new Runnable () {
                                       public void run() {
                                         ((JTextComponent)_currentCellEditor).grabFocus();
                                         ((JTextComponent)_currentCellEditor).selectAll();
                                         if(getRowCount()>0){
                                          mt.m_TxtCmp=(JTextComponent)_currentCellEditor;
                                          Object obj=getValueAt(row,column);
                                          lastOrgObjectB4Editing=obj;
                                          mt.m_Text = (obj==null)?"":obj.toString();
                                         }
                                          //System.out.println("change Selection set to row: "+mt.m_Row +", col:"+mt.m_Col+" value:"+mt.m_Text);
                                       }
                                     }
                                   );

                                 }
                        }
                        if(_currentCellEditor != null && _currentCellEditor instanceof JComboBox){
                          final JComboBox jbcx=(JComboBox)_currentCellEditor;
                          jbcx.setLightWeightPopupEnabled(false);
                          jbcx.putClientProperty("JComboBox.lightweightKeyboardNavigation","Lightweight");
                          ((JComponent)jbcx.getEditor().getEditorComponent()).addKeyListener(
                            new KeyAdapter(){
                              public void keyPressed(KeyEvent e){
                                jcomboboxeditor_kv(e,jbcx);
                              }
                            }
                          );
                          jbcx.getEditor().selectAll();
                        }
                      }
                      isChangingSelection=false;
              }

  };
  /*
  JTable _jTable1=new JTableBindKeyStroke(){
      protected JTableHeader createDefaultTableHeader() {
        return new GroupableTableHeader(columnModel);
      }
  };*/


  protected Hashtable _txtEditorVarifiers;

  protected String _jComboboxSelectedString="";
  protected Object _storeTableModel[][]=new Object[1][1];
  protected RowColumn lastVerifiedField=new RowColumn(-1,-1);
  protected JComponent _currentCellEditor=null;
  protected String _currentStringInEditor=null;
  protected java.util.HashMap _lastDetectedModifiedFieldAndValue=null;
  protected boolean _processingTxtLostFocus=false;
  protected Hashtable _storeColumnPosition=new Hashtable();
  protected boolean _jtableInitating=false;
  protected boolean _lastTimeVarifyResult=true;
  protected java.util.Hashtable _definedColumnGrp=new java.util.Hashtable();
  protected java.util.Vector displayingRecords;
  protected util.InsertionOrderedHashMap orgDefinedTableHeadColumn;
  //protected exgui.MultiClassTableModel _mcTblMdl=null;
  //the moinitor thread to monitor the text object input.

   public class MonitorThread {
 //extends Thread{
    public int m_Row;
    public int m_Col;
    public String m_Text;
    public javax.swing.text.JTextComponent m_TxtCmp;
    /*
    public void run(){
        while (true) {
           if(!isChangingSelection){
            synchronized(synchKey){

              //if (m_TxtCmp != null) {
                //m_Text = m_TxtCmp.getText();
              //}
            }
          }try{
              Thread.currentThread().sleep(10);
            }catch(Exception exp){

            }
        }

    }*/
  }
  public MonitorThread mt;
  public MultiEditorJTable() {
    try {
      if(mt==null){
        mt = new MonitorThread();
        //mt.start();
      }
      mt.m_TxtCmp=null;
      _jTable1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
      _jTable1.setFocusTraversalKeysEnabled(false);
      //_jTable1.setSurrendersFocusOnKeystroke(true);
      //_jTable1.setSelectionMode(1);
      jbInit();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jScrollPane1.getViewport().setBackground(new Color(204, 204, 255));
    jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        jScrollPane1_keyReleased(e);
      }
    });

    _jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        _jTable1_mouseReleased(e);
      }
      public void mousePressed(MouseEvent e) {
        _jTable1_mousePressed(e);
      }
    });

     _jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        _jTable1_keyPressed(e);
      }
      public void keyReleased(KeyEvent e) {
        _jTable1_keyReleased(e);
      }
    });


    _jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent e) {
        _jTable1_propertyChange(e);
      }
    });
    this.add(jScrollPane1, BorderLayout.CENTER);
    _jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    jScrollPane1.getViewport().add(_jTable1, null);
  }
  public JScrollPane getTableLayingScrollPanel(){
    return jScrollPane1;
  }
  public java.util.HashMap getModifiedRowAndColumn(){
   return _lastDetectedModifiedFieldAndValue;
  }
  protected void removeAllColumnGrp(){
   _definedColumnGrp.clear();
  }
  public void setDisplayingRecords(java.util.Vector recs,util.InsertionOrderedHashMap storedTblHead){
    displayingRecords=recs;
    orgDefinedTableHeadColumn=storedTblHead;
  }
  public void setTableColumn2Grp(String GrpTitleName,int columnIndex){
    TableColumnModel cm = _jTable1.getColumnModel();
    if(_definedColumnGrp.containsKey(GrpTitleName)){
      ColumnGroup g_name = (ColumnGroup)_definedColumnGrp.get(GrpTitleName);
      g_name.add(cm.getColumn(columnIndex));
    }else{
      ColumnGroup g_name = new ColumnGroup(GrpTitleName);
      g_name.add(cm.getColumn(columnIndex));
      _definedColumnGrp.put(GrpTitleName,g_name);
    }
  }
  protected void addAllColumnGrp2TblHead(){
    //list all the stored column group defined in _definedColumnGrp
    if(_definedColumnGrp.size()>0){
     GroupableTableHeader header = (GroupableTableHeader)_jTable1.getTableHeader();
       java.util.Iterator itr= _definedColumnGrp.keySet().iterator();
       while(itr.hasNext()){
         String keyString=(String)itr.next();
         ColumnGroup klmGrp=(ColumnGroup)_definedColumnGrp.get(keyString);
         header.addColumnGroup(klmGrp);
       }
    }
  }
  protected boolean isEqual(Object orgValue,Object currentValue){
    if(orgValue==null && currentValue==null) return true;
    if(orgValue!=null && currentValue==null) return false;
    if(orgValue==null && currentValue!=null) return false;
    return orgValue.equals(currentValue);
  }
  public void addTextAreaEditor(int columnAt,int maxCharCount){
    addTextAreaEditor(columnAt,maxCharCount,0);
  }
  public void addTextAreaEditor(int columnAt,int maxCharCount,int wrapColumnAt){
    exgui.MultiClassTableModel  dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.registEditableColumn(_jTable1.getColumnName(columnAt));
     _jTable1.getColumnModel().getColumn(columnAt).setCellRenderer(
       new TextCellRenderer(_jTable1)
     );
     _jTable1.getColumnModel().getColumn(columnAt).setCellEditor(
       new ScrollCellEditor(maxCharCount,wrapColumnAt)
     );
  }

  public void addTextAreaEditor(int columnAt){
    addTextAreaEditor(columnAt,0,0);
  }
  protected void fixColumnPositionMapping(){
    java.util.Enumeration enu= _storeColumnPosition.keys();
    while(enu.hasMoreElements()){
     String addedColumn=(String)enu.nextElement();
     int desiredIndex=((Integer)_storeColumnPosition.get(addedColumn)).intValue();
     int xntIndex=getIndexByColumnName(addedColumn);
     if(desiredIndex!=xntIndex){
       _jTable1.moveColumn(xntIndex,desiredIndex);
     }
    }
  }
  protected int getIndexByColumnName(String columnName){
    for(int i=_jTable1.getColumnCount()-1;i>-1;i--){
      String storedKlmMane=_jTable1.getColumnName(i);
      if(storedKlmMane.equals(columnName)) return i;
    }
    return -1;
  }
  public void addRadioButtons(int columnAt,String itemArray[],boolean returnValueByIndex){
   String columnName=_jTable1.getColumnName(columnAt);
    exgui.MultiClassTableModel  dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.registEditableColumn(columnName);
    _jTable1.getColumn(columnName).setCellRenderer(
      new RadioButtonRenderer(itemArray,returnValueByIndex)
    );
    _jTable1.getColumn(columnName).setCellEditor(
      new RadioButtonEditor(new JCheckBox(),
                            new RadioButtonPanel(itemArray),itemArray,
                            returnValueByIndex
                            )
    );

  }
  /**
   * note, this method is just for displaying.for notification,please add listener to the contained jtable
   * @param columnAt the column  to put button at.
   */
  public void addButtons(int columnAt){
    //set the font of button to bold
    java.awt.Font xntFont=getFont();
    java.awt.Font btnFont;
    btnFont=new java.awt.Font(xntFont.getName(),
                                xntFont.getStyle()|Font.BOLD,
                                xntFont.getSize());
   exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
   dtm.registEditableColumn(_jTable1.getColumnName(columnAt));
   String columnName=_jTable1.getColumnName(columnAt);
   ButtonRenderer btnRdr=new ButtonRenderer();
   btnRdr.setFont(btnFont);
    _jTable1.getColumn(columnName).setCellRenderer(btnRdr);
    _jTable1.getColumn(columnName).setCellEditor(new ButtonEditor(new JCheckBox()));
  }
  public void addCheckbox(int columnAt,Object tgtTrueObj){
   try{
    String tblHeadColumnName=getJTable().getColumnName(columnAt);
    String columnNameInRecords=
        (String)orgDefinedTableHeadColumn.get(tblHeadColumnName);
    if(displayingRecords==null||displayingRecords.size()==0) return;
    Vector recs=displayingRecords;
    Boolean blns[]=new Boolean[recs.size()];
    //find out the clumn no in records of column name..
    Record rec=(Record)recs.get(0);
    int tgtcolumnAt=util.MiscFunc.getFieldIndexAtRecord(rec,columnNameInRecords);
    exgui.MultiClassTableModel  dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.registEditableColumn(tblHeadColumnName);
    for(int i=0;i<recs.size();i++){
      Record tmpRec=(Record)recs.get(i);
      Object valueObj=tmpRec.get(tgtcolumnAt);
      if(util.MiscFunc.isEqual(valueObj,tgtTrueObj)){
       dtm.setValueAt(new Boolean(true),i,columnAt);
      }else{
        dtm.setValueAt(new Boolean(false),i,columnAt);
      }
    }
    //addCheckbox(columnAt,tblHeadColumnName,blns);
    final JCheckBox jchk=new JCheckBox();
    DefaultCellEditor dce=new DefaultCellEditor(jchk);
    dce.setClickCountToStart(0);
    _jTable1.getColumnModel().getColumn(columnAt).setCellEditor(dce);
   }catch(Exception e){
     e.printStackTrace();
   }
  }
  public void addCheckbox(int ColumnAt,String columnName,Boolean values[]){
    exgui.MultiClassTableModel  dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.registEditableColumn(columnName);
    dtm.addColumn(columnName,values);
    int maxColat=dtm.getColumnCount()-1;
    _storeColumnPosition.put(columnName,new Integer(ColumnAt));
    _jTable1.moveColumn(maxColat,ColumnAt);
    fixColumnPositionMapping();
    final JCheckBox jchk=new JCheckBox();
    DefaultCellEditor dce=new DefaultCellEditor(jchk);
    dce.setClickCountToStart(0);
    _jTable1.getColumnModel().getColumn(ColumnAt).setCellEditor(dce);

  }
  public void addJComobBox(int columnAt,String columnName,String itemStringArray[],boolean editable,Vector rowDatas){
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.addColumn(columnName,rowDatas);
     int maxColat=dtm.getColumnCount()-1;
     _storeColumnPosition.put(columnName,new Integer(columnAt));
      _jTable1.moveColumn(maxColat,columnAt);
     fixColumnPositionMapping();
     addJComboBox(columnAt,itemStringArray,editable);
  }
  protected Wraper4tblCbx mapping2WrapperClass(HashMap mpToMap,Object value,Vector wapper4cbx)throws Exception{
    /*
    for(int i=0;i<wapper4cbx.size();i++){
      Wraper4tblCbx wraper=(Wraper4tblCbx)wapper4cbx.get(i);
      Object storeObj=wraper.getValue();
      if(isEqual(storeObj,value)){
        return (Wraper4tblCbx)util.MiscFunc.deepCopy(wraper);
      }
    }
    */
    Object tgt=mpToMap.get(value);
    if(tgt!=null)return (Wraper4tblCbx)util.MiscFunc.deepCopy(tgt);
    return (Wraper4tblCbx)wapper4cbx.lastElement();
  }

  public void addJComboBoxEditable(int columnAtTable,
                           Vector records2Select,String recordSlkDisplayColumn,
                           String recordSlkValueColumn,int maxlength
                           ){
    //====begin of making up the row datas of desired qta column.=============================
    Vector rec2display=displayingRecords;
    if(rec2display==null) return;
    Vector wrpClassList=new Vector();
    Wraper4tblCbx wrpArr[]=new Wraper4tblCbx[records2Select.size()];
    int columnFromDisplayingRecordsIndex=0;
    String DisplayColumnNameInJtableHead=getJTable().getColumnName(columnAtTable);
    String columnFromDisplayingRecords=
        (String)orgDefinedTableHeadColumn.get(DisplayColumnNameInJtableHead);
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    for(int i=0;i<rec2display.size();i++){
      try{
        if(i==0){
          int valueFldIndexInSlkVctRecs=util.MiscFunc.getFieldIndexAtRecord((Record)records2Select.get(0),
              recordSlkValueColumn);
          int showFldIndexInSlkVctRecs=util.MiscFunc.getFieldIndexAtRecord((Record)records2Select.get(0),
              recordSlkDisplayColumn);
           columnFromDisplayingRecordsIndex=util.MiscFunc.getFieldIndexAtRecord(
              (Record)rec2display.get(0),
              columnFromDisplayingRecords);

          for(int j=0;j<records2Select.size();j++){
            Record rec2slk=(Record)records2Select.get(j);
            Object value=rec2slk.get(valueFldIndexInSlkVctRecs);
            Object string=rec2slk.get(showFldIndexInSlkVctRecs);
            Wraper4tblCbx wrappObj=new Wraper4tblCbx();
            if(string==null)
              wrappObj.setString("");
             else
              wrappObj.setString(string.toString());
            wrappObj.setValue(value);
            wrpClassList.add(wrappObj);
            wrpArr[j]=wrappObj;
          }
        }
        Record tempRec=(Record)rec2display.get(i);
        Object valueObj=tempRec.get(columnFromDisplayingRecordsIndex);
        //rowValueData.add(mapping2WrapperClass(valueObj,wrpClassList));
        dtm.setValueAt(valueObj,i,columnAtTable);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    //add to jtable..
      addJComboBoxEditable(columnAtTable,wrpArr,maxlength);
  }


  public void addJComboBox(int columnAtTable,
                           Vector records2Select,String recordSlkDisplayColumn,
                           String recordSlkValueColumn
                           ){
    //====begin of making up the row datas of desired qta column.=============================
    Vector rec2display=displayingRecords;
    if(rec2display==null) return;
    Vector wrpClassList=new Vector();
    Wraper4tblCbx wrpArr[]=new Wraper4tblCbx[records2Select.size()];
    int columnFromDisplayingRecordsIndex=0;
    String DisplayColumnNameInJtableHead=getJTable().getColumnName(columnAtTable);
    String columnFromDisplayingRecords=
        (String)orgDefinedTableHeadColumn.get(DisplayColumnNameInJtableHead);
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    HashMap mpToMap=new HashMap();
    for(int i=0;i<rec2display.size();i++){
      try{
        if(i==0){
          int valueFldIndexInSlkVctRecs=util.MiscFunc.getFieldIndexAtRecord((Record)records2Select.get(0),
              recordSlkValueColumn);
          int showFldIndexInSlkVctRecs=util.MiscFunc.getFieldIndexAtRecord((Record)records2Select.get(0),
              recordSlkDisplayColumn);
           columnFromDisplayingRecordsIndex=util.MiscFunc.getFieldIndexAtRecord(
              (Record)rec2display.get(0),
              columnFromDisplayingRecords);

          for(int j=0;j<records2Select.size();j++){
            Record rec2slk=(Record)records2Select.get(j);
            Object value=rec2slk.get(valueFldIndexInSlkVctRecs);
            Object string=rec2slk.get(showFldIndexInSlkVctRecs);
            Wraper4tblCbx wrappObj=new Wraper4tblCbx();
            if(string==null)
              wrappObj.setString("");
             else
              wrappObj.setString(string.toString());
            wrappObj.setValue(value);
            wrpClassList.add(wrappObj);
            wrpArr[j]=wrappObj;
            mpToMap.put(value,wrappObj);
          }
        }
        Record tempRec=(Record)rec2display.get(i);
        Object valueObj=tempRec.get(columnFromDisplayingRecordsIndex);
        //rowValueData.add(mapping2WrapperClass(valueObj,wrpClassList));
        dtm.setValueAt(mapping2WrapperClass(mpToMap,valueObj,wrpClassList),i,columnAtTable);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    mpToMap=null;
    //add to jtable..
      addJComboBox(columnAtTable,wrpArr,false);
  }

  public void addJComboBoxEditable(
    int columnAt,Object valueArray[],int maxlength){
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.registEditableColumn(_jTable1.getColumnName(columnAt));
   final JComboBox jcbx=new JComboBox();


   javax.swing.text.JTextComponent txtComp=
      (javax.swing.text.JTextComponent)jcbx.getEditor().getEditorComponent();
   exgui.DataBindText tmpdbTxt=
       new exgui.DataBindText(txtComp,"",null,maxlength);
   javax.swing.DefaultComboBoxModel mdl=new javax.swing.DefaultComboBoxModel();
   jcbx.removeAllItems();
   for(int i=0;i<valueArray.length;i++){
     Object item=valueArray[i];
     mdl.addElement(item);
   }
   jcbx.setModel(mdl);
   jcbx.setEditable(true);
   DefaultCellEditor dce=new DefaultCellEditor(jcbx);
   dce.setClickCountToStart(0);
   _jTable1.getColumnModel().getColumn(columnAt).setCellEditor(dce);
  }


  public void addJComboBox(int columnAt,Object valueArray[],boolean editable){
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.registEditableColumn(_jTable1.getColumnName(columnAt));
   final JComboBox jcbx=new JComboBox();
   javax.swing.DefaultComboBoxModel mdl=new javax.swing.DefaultComboBoxModel();
   jcbx.removeAllItems();
   for(int i=0;i<valueArray.length;i++){
     Object item=valueArray[i];
     mdl.addElement(item);
   }
   jcbx.setModel(mdl);
   jcbx.setEditable(editable);
   DefaultCellEditor dce=new DefaultCellEditor(jcbx);
   dce.setClickCountToStart(0);
   _jTable1.getColumnModel().getColumn(columnAt).setCellEditor(dce);
  }

  public void addJComboBox(int columnAt,String stringArray[],boolean editable){
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)_jTable1.getModel();
    dtm.registEditableColumn(_jTable1.getColumnName(columnAt));
   final JComboBox jcbx=new JComboBox(stringArray);
   jcbx.setEditable(editable);
   DefaultCellEditor dce=new DefaultCellEditor(jcbx);
   dce.setClickCountToStart(0);
   _jTable1.getColumnModel().getColumn(columnAt).setCellEditor(dce);
  }
  protected void setMultiClassTableModel(exgui.MultiClassTableModel mtctmdl){
     //_mcTblMdl=mtctmdl;
  }
  protected void jComboBox1_focusGained(FocusEvent e,final JComboBox jbx){
    //System.out.println(" jComboBox1_focusGained ");
    ((JComponent)jbx.getEditor().getEditorComponent()).grabFocus();
  }
  public JTable getJTable(){
   return _jTable1;
  }
  public void storeTableModel(){
    _storeTableModel=null;
    int rowCount=_jTable1.getRowCount();
    int columnCount=_jTable1.getColumnCount();
    _storeTableModel=new Object[rowCount][columnCount];
    for(int i=0;i<rowCount;i++){
      for(int j=0;j<columnCount;j++){
               _storeTableModel[i][j]=_jTable1.getValueAt(i,j);
      }
    }
  }
  protected boolean isVaild(int row,int column,String value2Verify){

   if(row==-1 || column==-1){
     row=_lastEditingRow;
     column=_lastEditingColumn;
   }
   if(row==-1 || column==-1){
     return true;
   }
   if(!getJTable().isCellEditable(row,column))return true;
   CellTxtEditorFormat obj=(CellTxtEditorFormat)_txtEditorVarifiers.get(_jTable1.getColumnName(column));
   if(obj==null) return true;
   if(!obj.isFormatValid(value2Verify,row,column)){
     /*
     monitor thread take care of
     System.out.println("format error at: row="+row+" column="+column);
     lastVerifiedField._rowAt=-1;
     lastVerifiedField._columnAt =-1;
     exgui.verification.VerifyLib.showAllert(obj.formatPromptMsg());
     if(((JTextField)_jTable1.getEditorComponent())!=null){
       ((JTextField)_jTable1.getEditorComponent()).selectAll();
     }else{
       _jTable1.changeSelection(row,column,false,false);
       _jTable1.editCellAt(row,column);
       ((JTextField)_jTable1.getEditorComponent()).selectAll();
     }*/
     return false;
   }
   lastVerifiedField._rowAt=_lastEditingRow;
   lastVerifiedField._columnAt =_lastEditingColumn;
   return true;
  }
   void moveUpward(){
    //System.out.println("Calling moveDownward");
     _lastEditingRow=_jTable1.getEditingRow();
     _lastEditingColumn=_jTable1.getEditingColumn();
     _currentCellEditor=(JTextField)_jTable1.getEditorComponent();
     if(!isVaild(_lastEditingRow,_lastEditingColumn,((JTextField)_currentCellEditor).getText()))
        return;
     if(_lastEditingRow>0){
      _lastEditingRow--;
     }
     //_jTable1.editCellAt(_lastEditingRow,_lastEditingColumn);
     _currentCellEditor=(JComponent)_jTable1.getEditorComponent();
     _currentCellEditor.grabFocus();
  }
  void moveDownward(){
    //System.out.println("Calling moveDownward");
     _lastEditingRow=_jTable1.getEditingRow();
     _lastEditingColumn=_jTable1.getEditingColumn();
     _currentCellEditor=(JTextField)_jTable1.getEditorComponent();
     if(!isVaild(_lastEditingRow,_lastEditingColumn,((JTextField)_currentCellEditor).getText()))
        return;
     if(_lastEditingRow<_jTable1.getRowCount()){
      _lastEditingRow++;
     }
     //_jTable1.editCellAt(_lastEditingRow,_lastEditingColumn);
     _currentCellEditor=(JComponent)_jTable1.getEditorComponent();
     _currentCellEditor.grabFocus();
  }
  void jcomboboxeditor_kv(KeyEvent e,final JComboBox jbx){
    if(e.getKeyCode()==KeyEvent.VK_SPACE){
       //System.out.println("running at jcomboboxeditor_kv");
       ((JComponent)jbx.getEditor().getEditorComponent()).grabFocus();
     }
  }
  synchronized  void moveRight(){moveRight(false);}
  synchronized  void moveRight(boolean if2Ince){
      int targetRow=_jTable1.getSelectedRow();
      int targetColum=_jTable1.getSelectedColumn();
       /*
       if(_jTable1.getEditorComponent() instanceof JTextComponent){
         _currentCellEditor = (JTextField)_jTable1.getEditorComponent();
         if (!isVaild(_lastEditingRow , _lastEditingRow,
                      ((JTextField)_currentCellEditor).getText()))
           return;
       }*/
       //System.out.println("handling move right, row & column is "+targetRow+","+targetColum );
       if(if2Ince){
         if (targetColum < _jTable1.getColumnCount() - 1) {
           targetColum++;
         } else {
           if (targetColum == _jTable1.getColumnCount() - 1) {
             if (targetRow == _jTable1.getRowCount() - 1) {
               targetColum = 0;
               targetRow = 0;
             } else {
               targetColum = 0;
               ++targetRow;
             }
           }
         }
       }
       //return;

       _jTable1.changeSelection(targetRow,targetColum,false,false);
       //_currentCellEditor=(JComponent)((DefaultCellEditor)(_jTable1.getCellEditor(targetRow,targetColum))).getComponent()  ;
      if(_currentCellEditor instanceof JComboBox){
            final JComboBox jbcx=(JComboBox)_currentCellEditor;
            jbcx.setLightWeightPopupEnabled(false);
            jbcx.putClientProperty("JComboBox.lightweightKeyboardNavigation","Lightweight");
            ((JComponent)jbcx.getEditor().getEditorComponent()).addKeyListener(
              new KeyAdapter(){
                public void keyPressed(KeyEvent e){
                  jcomboboxeditor_kv(e,jbcx);
                }
              }
            );
            jbcx.getEditor().selectAll();
      }else{
        JComponent tmpCom=(JComponent)_jTable1.getEditorComponent();
        if(tmpCom!=null && tmpCom instanceof JTextComponent){
          ((JTextComponent)tmpCom).selectAll();
        }
      }
    }

synchronized   void moveLeft(){moveLeft(false);}
synchronized   void moveLeft(boolean if2Inc){
      int targetRow=_jTable1.getSelectedRow();
      int targetColum=_jTable1.getSelectedColumn();

     //_lastEditingRow=_jTable1.getSelectedRow();
     //_lastEditingColumn=_jTable1.getSelectedColumn();
     /*
     if(_jTable1.getEditorComponent() instanceof JTextComponent){
       _currentCellEditor = (JTextField)_jTable1.getEditorComponent();
       if (!isVaild(_lastEditingRow,_lastEditingColumn,
                    ((JTextField)_currentCellEditor).getText()))
         return;
     }*/
    /*
     _currentCellEditor=(JTextField)_jTable1.getEditorComponent();
     if(!isVaild(_lastEditingRow,_lastEditingColumn,((JTextField)_currentCellEditor).getText()))
        return;
      */
     //if(_lastEditingColumn==-1)
     //if(_lastEditingRow==-1)
    //System.out.println("handling move left, row & column is "+_lastEditingRow+","+_lastEditingColumn );
    if(if2Inc){
      if (targetColum > 0) {
        targetColum--;
      } else {
        if (targetRow > 0) {
          targetRow--;
          targetColum = 0;
        }
      }
    }
    //return;

     _jTable1.changeSelection(targetRow,targetColum,false,false);
     //_currentCellEditor=(JComponent)((DefaultCellEditor)(_jTable1.getCellEditor(targetRow,targetColum))).getComponent();
     if(_currentCellEditor instanceof JComboBox){
           final JComboBox jbcx=(JComboBox)_currentCellEditor;
           jbcx.setLightWeightPopupEnabled(false);
           jbcx.putClientProperty("JComboBox.lightweightKeyboardNavigation","Lightweight");
           ((JComponent)jbcx.getEditor().getEditorComponent()).addKeyListener(
             new KeyAdapter(){
               public void keyPressed(KeyEvent e){
                 jcomboboxeditor_kv(e,jbcx);
               }
             }
           );
           jbcx.getEditor().selectAll();
     }else{
       JComponent tmpCom=(JComponent)_jTable1.getEditorComponent();
       if(tmpCom!=null && tmpCom instanceof JTextComponent){
         ((JTextComponent)tmpCom).selectAll();
       }
     }
  }
  public void setAllColumnUnEdtiable(){
   MultiClassTableModel mt=(MultiClassTableModel)_jTable1.getModel();
   mt.removeAllEditableColumn();
  }
  public void setColumnEditable(String columnName){
   MultiClassTableModel mt=(MultiClassTableModel)_jTable1.getModel();
   mt.registEditableColumn(columnName);
  }
  public void setColumnUnEditable(String columnName){
   MultiClassTableModel mt=(MultiClassTableModel)_jTable1.getModel();
   mt.removeEditableColumn(columnName);
  }
  public void findNextEditor2EditAt(){
     _lastEditingRow=_jTable1.getEditingRow();
     _lastEditingColumn=_jTable1.getEditingColumn();
     _currentCellEditor=(JTextField)_jTable1.getEditorComponent();
     if(
       _lastEditingRow<_jTable1.getRowCount()-1 &&
       _lastEditingColumn==_jTable1.getRowCount()-1
     ){
       _lastEditingRow++;
       _lastEditingColumn=0;
     }else if(
       _lastEditingRow==_jTable1.getRowCount()-1 &&
       _lastEditingColumn==_jTable1.getRowCount()-1
     ){
       _lastEditingRow=0;
       _lastEditingColumn=0;
     }else {
       _lastEditingColumn++;
     }
     _jTable1.editCellAt(_lastEditingRow,_lastEditingColumn);
     _currentCellEditor=(JComponent)_jTable1.getEditorComponent();
     _currentCellEditor.grabFocus();
  }
   void keyPressEventHandler4TextArea(KeyEvent e){
    switch (e.getKeyCode()){
      case KeyEvent.VK_ENTER:
      {
        //e.setKeyCode(0);
        return;
      }
      case KeyEvent.VK_DOWN:
      {
        //else lost focu,to move to next row and same editing column
      }
      case KeyEvent.VK_UP:
      {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column

      }
      case KeyEvent.VK_RIGHT:
      {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column

      }
      case KeyEvent.VK_LEFT:
       {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column

       }
      case KeyEvent.VK_TAB:
      {
        //really lost focuse.to editing next column.

      }
    }
  }
   void keyReleaseEventHandler4TextArea(KeyEvent e){
    switch (e.getKeyCode()){
      case KeyEvent.VK_ENTER:
      {
        //e.setKeyCode(0);
        return;
      }
      case KeyEvent.VK_DOWN:
      {
        //else lost focu,to move to next row and same editing column
      }
      case KeyEvent.VK_UP:
      {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column

      }
      case KeyEvent.VK_RIGHT:
      {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column

      }
      case KeyEvent.VK_LEFT:
       {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column

       }
      case KeyEvent.VK_TAB:
      {
        //really lost focuse.to editing next column.

      }
    }
  }

  void keyPressEventHandler(KeyEvent e){
    //System.out.println("get key in keyPressEventHandler:"+e.getKeyCode());
    switch (e.getKeyCode()){
      case KeyEvent.VK_ENTER:
      {
        e.setKeyCode(0);
        return;
      }
      case KeyEvent.VK_DOWN:
      {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column
          e.setKeyCode(0);
          moveDownward();
          break;
      }
      case KeyEvent.VK_UP:
      {
        //depends.if jtext area,no need to care.
        //else lost focu,to move to next row and same editing column
          e.setKeyCode(0);
          moveUpward();
          break;
      }

      case KeyEvent.VK_TAB:
      {
        //really lost focuse.to editing next column.
         e.setKeyCode(0);
         findNextEditor2EditAt();
         break;
      }
      case KeyEvent.VK_RIGHT:
      {
          //e.setKeyCode(0);
          keyReleaseEventHandler(e);
          break;

      }
      case KeyEvent.VK_LEFT:
      {
          //e.setKeyCode(0);
          keyReleaseEventHandler(e);
          break;

      }

    }
  }
  void keyReleaseEventHandler(KeyEvent e){
    //System.out.println("get key in keyPressEventHandler:"+e.getKeyCode());
    switch (e.getKeyCode()){
      case KeyEvent.VK_RIGHT:
      {
        JTextField jtf=(JTextField)_currentCellEditor;
        if(jtf.getSelectionEnd()>=jtf.getText().length()){
          e.setKeyCode(0);
          moveRight();
          _currentCellEditor=(JComponent)_jTable1.getEditorComponent();
          if(_currentCellEditor!= null && _currentCellEditor instanceof JTextComponent){
            (_currentCellEditor).grabFocus();
            ((JTextComponent)_currentCellEditor).selectAll();
          }
          break;
        }
      }
      case KeyEvent.VK_LEFT:
      {
        JTextField jtf=(JTextField)_currentCellEditor;
        if(jtf.getSelectionEnd()==0){
          e.setKeyCode(0);
          moveLeft();
          _currentCellEditor=(JComponent)_jTable1.getEditorComponent();
          if(_currentCellEditor!= null && _currentCellEditor instanceof JTextComponent){
            (_currentCellEditor).grabFocus();
            ((JTextComponent)_currentCellEditor).selectAll();
          }
          break;
        }
      }
    }
  }

  /**
   * assign verifiers to column,key is displaying column name,and the values are CellTxtEditorFormat Objects
   * @param cellTxtEditorFormats
   */

  public void setTextEditorVerifiers(Hashtable cellTxtEditorFormats){
    exgui.MultiClassTableModel mctblMdl=(exgui.MultiClassTableModel)_jTable1.getModel();
    _txtEditorVarifiers=cellTxtEditorFormats;
    for(int i=0;i<_jTable1.getColumnCount();i++){
      String tgtColumName=_jTable1.getColumnName(i);
      Object ctef=cellTxtEditorFormats.get(tgtColumName);
     if(ctef!=null){
       mctblMdl.registEditableColumn(tgtColumName);
      final LengthLimitedJText tempEdt= new LengthLimitedJText((CellTxtEditorFormat)ctef);
      DefaultCellEditor dte=new DefaultCellEditor(tempEdt);
      dte.setClickCountToStart(0);
       _jTable1.getColumnModel().getColumn(i).setCellEditor(dte);
       tempEdt.addFocusListener(
        new FocusAdapter(){
          public void  focusLost(FocusEvent e){
            if(e.getID() ==e.FOCUS_LOST ){
             //System.out.println("processing tempEdt lost focus");
              verifyLengthLimitedJText(tempEdt);
            }
         }
        }
      );
     }
    }
  }
  //check modified field data is valid format or not.

  public boolean isTableOk(){
    //if(_processingTxtLostFocus) return false;
    _processingTxtLostFocus=true;
    _jTable1.editCellAt(-1,0);//force editor to lose focus
    HashMap hm=new HashMap();
    int rowCount=_jTable1.getRowCount();
    int clmCount=_jTable1.getColumnCount();
    for(int i=0;i<rowCount;i++){
     for(int j=0;j<clmCount;j++){
       if(!_jTable1.getModel().isCellEditable(i,j)) continue;
       Object storedValue=_storeTableModel[i][j];
       Object xntValue=_jTable1.getValueAt(i,j);
       if(!isEqual(storedValue,xntValue)){
         if(_txtEditorVarifiers!=null){
           Object kvtor= _txtEditorVarifiers.get(_jTable1.getColumnName(j));
           if(kvtor!=null){
              boolean resultOfCheck=true;
                resultOfCheck = ((CellTxtEditorFormat)kvtor).isFormatValid((xntValue==null)?null:xntValue.toString(), i, j);
                //resultOfCheck = ((CellTxtEditorFormat)kvtor).isFormatValid((String)xntValue, i, j);
                //System.out.println("check value:"+xntValue);
            if(!resultOfCheck){
                 //System.out.println("poping in isTableOk method");
                 //util.MiscFunc.hideProcessingMessage();
                 exgui.verification.VerifyLib.showAllert(((CellTxtEditorFormat)kvtor).formatPromptMsg());
                _jTable1.clearSelection();
                _jTable1.changeSelection(i,j,false,false);
                _jTable1.editCellAt(i,j);
                ((JComponent)_jTable1.getEditorComponent()).grabFocus();
                if(_jTable1.getEditorComponent() instanceof javax.swing.text.JTextComponent){
                  ((javax.swing.text.JTextComponent)_jTable1.getEditorComponent()).selectAll();
                }
                _lastDetectedModifiedFieldAndValue=null;
                _processingTxtLostFocus=false;
               return false;
            }
            xntValue=((CellTxtEditorFormat)kvtor).cellStringToObject((xntValue==null)?null:xntValue.toString());
            //xntValue=((CellTxtEditorFormat)kvtor).cellStringToObject((String)xntValue);
           }
         }
         hm.put(new RowColumn(i,j),xntValue);
       }
     }
    }
    _lastDetectedModifiedFieldAndValue=hm;
    //all fields had be validate
    _processingTxtLostFocus=false;
    return true;


  }

  protected void verifyLengthLimitedJText(LengthLimitedJText tempEdt){
       if(!_lastTimeVarifyResult) return;
       if(_processingTxtLostFocus) return;
       _processingTxtLostFocus=true;
       lastVerifiedField._rowAt=_lastEditingRow;
       lastVerifiedField._columnAt=_lastEditingColumn;
     if(!tempEdt._editorVerifiyer.isFormatValid(tempEdt.getText(),_lastEditingRow,_lastEditingColumn)){
       _lastTimeVarifyResult=false;
                  _jTable1.clearSelection();
                  _jTable1.changeSelection(lastVerifiedField._rowAt,
                         lastVerifiedField._columnAt,false,false);
                  _jTable1.editCellAt(lastVerifiedField._rowAt,lastVerifiedField._columnAt);
              if(_jTable1.getEditorComponent()!=null){
                  ((JComponent)_jTable1.getEditorComponent()).grabFocus();
       exgui.verification.VerifyLib.showAllert(tempEdt._editorVerifiyer.formatPromptMsg());
                  _jTable1.editCellAt(lastVerifiedField._rowAt,lastVerifiedField._columnAt);
                  ((JComponent)_jTable1.getEditorComponent()).grabFocus();
              }

       _processingTxtLostFocus=false;
       return ;
     }else{
       _lastTimeVarifyResult=true;
       lastVerifiedField._rowAt=-1;
       lastVerifiedField._columnAt=-1;
       _processingTxtLostFocus=false;
     }
  }

  class ComboBoxRenderer extends JLabel implements ListCellRenderer {
        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
        }

        public Component getListCellRendererComponent(
                                           JList list,
                                           Object value,
                                           int index,
                                           boolean isSelected,
                                           boolean cellHasFocus) {
            //jComboboxSelectedString="";
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
                //System.out.println(" index in render is:"+index);
                _jComboboxSelectedString=_datasInJcbx[index];
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
              setText(value.toString());
            return this;
        }
    }

 public class LengthLimitedJText extends JTextField{
      CellTxtEditorFormat _editorVerifiyer;
      public LengthLimitedJText(){
        super();
        /*
        InputMap im=getInputMap();
        //  Have the RIGHT key work the same as the tab key
        KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        KeyStroke arrowPlus = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
        im.put(arrowPlus, im.get(tab));
       //  Have the LEFT key work the same as the shift+tab key
        KeyStroke shiftTab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB,
                                                    KeyEvent.SHIFT_MASK);
        KeyStroke arrowMinus = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
        im.put(arrowMinus, im.get(shiftTab));
        setInputMap(WHEN_FOCUSED,im);*/
      }
      public LengthLimitedJText(CellTxtEditorFormat editorVerifiyer){
        super();
        _editorVerifiyer=editorVerifiyer;
        super.setDocument(
          new LimitedStyledDocument(editorVerifiyer.getMaxLength())
        );

        addFocusListener(
           new FocusAdapter(){
             public void focusLost(FocusEvent fe){
               _jtblKeyReleased2Move();
               if (!_lastTimeVarifyResult){
                 grabFocus();
               }
               return;
             }
           }
        );
        exgui.ultratable.KeyProcess keyProcessBy=
            editorVerifiyer.getKeyListener();
        if(keyProcessBy!=null)keyProcessBy.bind2TextComponent(this);

        addKeyListener(new KeyAdapter(){
          public void keyPressed(KeyEvent ke){
            if(ke.getKeyCode()==ke.VK_RIGHT){
              ke.setKeyChar(TAB_CHAR);
              ke.setKeyCode(ke.VK_TAB);
            }
            if(ke.getKeyCode()==ke.VK_LEFT){
              ke.setKeyChar(TAB_CHAR);
              ke.setKeyCode(ke.VK_TAB);
              ke.setModifiers( ke.SHIFT_DOWN_MASK| ke.getModifiersEx() );
            }
          }
        });

      }

  }
   public class LimitedStyledDocument extends DefaultStyledDocument {
      int maxCharacters;

      public LimitedStyledDocument(int maxChars) {
          maxCharacters = maxChars;
      }

      public void insertString(int offs, String str, AttributeSet a)
          throws BadLocationException {
          //This rejects the entire insertion if it would make
          //the contents too long. Another option would be
          //to truncate the inserted string so the contents
          //would be exactly maxCharacters in length.
          if(str==null)return;
          if ((getLength() + str.length()) <= maxCharacters)
              super.insertString(offs, str, a);
          else
              Toolkit.getDefaultToolkit().beep();
      }
  }
  /** radio button editor & it's cell renderor
   *   from website:http://www2.gol.com/users/tame/swing/examples/JTableExamples2.html
   **/
    // Cell base
  class RadioButtonPanel extends JPanel {
    JRadioButton[] buttons;
    String dataStored[];
    RadioButtonPanel(String[] str) {
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      buttons = new JRadioButton[str.length];
      dataStored=str;
      for (int i=0; i<buttons.length; i++) {
        buttons[i] = new JRadioButton(str[i]);
        buttons[i].setFocusPainted(false);
        add(buttons[i]);
      }
    }

    public void setSelectedIndex(int index) {
      for (int i=0;i<buttons.length;i++) {
        buttons[i].setSelected(i == index);
      }
    }

    public int getSelectedIndex() {
      for (int i=0; i<buttons.length; i++) {
        if (buttons[i].isSelected()) {
          return i;
        }
      }
      return -1;
    }

    public JRadioButton[] getButtons() {
      return buttons;
    }
  }



  class RadioButtonRenderer extends    RadioButtonPanel
                            implements TableCellRenderer {
    String dataStroed[];
    boolean isGetValueByIndex=false;
    RadioButtonRenderer(String[] strs,boolean _isRtnByIndex) {
      super(strs);
      dataStroed=strs;
      isGetValueByIndex=_isRtnByIndex;
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
       setSelectedIndex(0);
       if(!isGetValueByIndex){
         if(value==null){
         }else{
          for(int i=0;i<dataStored.length;i++){
            if(value.toString().equals(dataStored[i])){
             setSelectedIndex(i);
             break;
            }
          }
         }
       }else{
         if(value !=null){
          if (value instanceof Integer) {
            setSelectedIndex(((Integer)value).intValue());
          }else{
            setSelectedIndex(Integer.parseInt(value.toString()));
          }
         }
       }
      return this;
    }
  }



  class RadioButtonEditor extends    DefaultCellEditor
                          implements ItemListener {
    RadioButtonPanel panel;
    String dataStored[];
    boolean isRtnByIndex;
    public RadioButtonEditor(JCheckBox checkBox,
       RadioButtonPanel panel,
       String itemStringArray[],
       boolean _isRtnByIndex
       ) {
      super(checkBox);
      dataStored=itemStringArray;
      isRtnByIndex=_isRtnByIndex;
      this.panel = panel;
      ButtonGroup buttonGroup = new ButtonGroup();
      JRadioButton[] buttons  = panel.getButtons();
      for (int i=0; i<buttons.length; i++) {
        buttonGroup.add(buttons[i]);
        buttons[i].addItemListener(this);
      }
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
      panel.setSelectedIndex(0);
      if(!isRtnByIndex ){
        if(value==null){
        }else{
          for(int i=0;i<dataStored.length;i++){
            if(value.toString().equals(dataStored[i])){
             panel.setSelectedIndex(i);
             break;
            }
          }
        }
     }else{
        if(value!=null){
          if (value instanceof Integer) {
            panel.setSelectedIndex(((Integer)value).intValue());
          }else{
            panel.setSelectedIndex(Integer.parseInt(value.toString()));
          }
        }
      }
      return panel;
    }

    public Object getCellEditorValue() {
      //return   new Integer(panel.getSelectedIndex());
      if(isRtnByIndex)
         return   new Integer(panel.getSelectedIndex());
       else
         return dataStored[panel.getSelectedIndex()];
    }

    public void itemStateChanged(ItemEvent e) {
      super.fireEditingStopped();
    }
  }
 /**end of radio button cell rendor**/
 class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {

  CheckBoxRenderer() {
    setHorizontalAlignment(JLabel.CENTER);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
                         boolean isSelected, boolean hasFocus,
                          int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      //super.setBackground(table.getSelectionBackground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setSelected((value != null && ((Boolean)value).booleanValue()));
    return this;
  }
}

  public class TextCellRenderer extends JScrollPane implements TableCellRenderer {
    private Hashtable rowHeights = new Hashtable();
    private Color selBackground;
    private Color selForeground;
    private Color background;
    private Color foreground;
    private JTextArea jTextArea1=new JTextArea("",8,15);
    private JScrollPane outputPane=new JScrollPane();
    //jScrollPane1.getViewport().add(jTextArea1, null);

    public TextCellRenderer(JTable table) {
      super(
             JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
      );
      selBackground = table.getSelectionBackground();
      selForeground = table.getSelectionForeground();
      background = table.getBackground();
      foreground = table.getForeground();
    }

    public Component getTableCellRendererComponent(JTable table,
      Object value,
      boolean isSelected,
      boolean hasFocus,
      int row,
      int column) {
        jTextArea1.setLineWrap(true);
        if (isSelected) {
          jTextArea1.setBackground(selBackground);
          jTextArea1.setForeground(selForeground);
        }
        else {
          jTextArea1.setBackground(background);
          jTextArea1.setForeground(foreground);
        }

        if (value instanceof String) {
          jTextArea1.setText((String)value);
          }else
            jTextArea1.setText("");
            outputPane.getViewport().add(jTextArea1, null);
          return outputPane;//this;
    }

    /* THE FOLLOWING COPIED FROM javax.swing.table.DefaultTableCellRenderer.....
    *
    * The following methods are overridden as a performance measure to
    * to prune code-paths are often called in the case of renders
    * but which we know are unnecessary. Great care should be taken
    * when writing your own renderer to weigh the benefits and
    * drawbacks of overriding methods like these.
    */
    public void validate() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) { }
  }
  class  TextAreaWrapListener extends java.awt.event.KeyAdapter{
    JTextArea _txtCmp;
    int lineWrapCharCount=0;
    TextAreaWrapListener(JTextArea txtCmp,int wrapWordCount){
      _txtCmp=txtCmp;
      lineWrapCharCount=wrapWordCount;
    }

    public void keyReleased(KeyEvent ke) {
      try{
        if(ke.isActionKey())return;
        int caretPos=_txtCmp.getCaretPosition();
        int line = _txtCmp.getLineOfOffset(caretPos);
        //int maxLineCount=_txtCmp.getLineCount();
        //System.out.println("line is:"+line+",carte pos:"+caretPos+" total line count is:"+maxLineCount);
        //if(line<maxLineCount-1)return;//
        if((_txtCmp.getText().length()-1)==-1)return;
        String lastChar=_txtCmp.getText().substring(_txtCmp.getText().length()-1,_txtCmp.getText().length());
        while(lastChar.equals(" ")||lastChar.equals("\n")){
          if(line==(_txtCmp.getLineCount()-1))return;
          _txtCmp.getDocument().remove(_txtCmp.getText().length()-1,1);
          lastChar=_txtCmp.getText().substring(_txtCmp.getText().length()-1,_txtCmp.getText().length());
        }
       int lastReturnAt=_txtCmp.getText().lastIndexOf("\n");
       if(lastReturnAt==-1)lastReturnAt=0;
       String totalLastLine=_txtCmp.getText().substring(
                           lastReturnAt,_txtCmp.getText().length());
      int endBlankSpaceAt=totalLastLine.lastIndexOf(" ");

      //if(endBlankSpaceAt==-1)endBlankSpaceAt=0;
       //String lastString=_txtCmp.getText().substring(endBlankSpaceAt,_txtCmp.getText().length());
       //System.out.println("Last String Is:"+lastString);
       if(totalLastLine.length()>lineWrapCharCount){
         if(endBlankSpaceAt!=-1){
           endBlankSpaceAt=_txtCmp.getText().lastIndexOf(" ");
           _txtCmp.insert("\n", endBlankSpaceAt);
           _txtCmp.getDocument().remove(endBlankSpaceAt + 1, 1);
           lastReturnAt=_txtCmp.getText().lastIndexOf("\n");
           if(lastReturnAt==-1)lastReturnAt=0;
           totalLastLine=_txtCmp.getText().substring(
                               lastReturnAt,_txtCmp.getText().length());
         }
         line = _txtCmp.getLineCount()-1;

         if(totalLastLine.length()>=lineWrapCharCount){
          if(line>0)
            _txtCmp.insert("\n",_txtCmp.getText().length());
            else
            _txtCmp.insert("\n",_txtCmp.getText().length()-1);
         }
       }
      }catch(Exception exp){
        exp.printStackTrace();
      }

    }
  }

public  class ScrollCellEditor extends javax.swing.DefaultCellEditor   {
  javax.swing.JTextArea saveTextField =new JTextArea();
  javax.swing.JScrollPane _storedJScrollPane=new JScrollPane(
                                  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
   );

    // Event handler
    public class FocusEventHandler implements java.awt.event.FocusListener {
      public void focusGained(java.awt.event.FocusEvent e) {
        javax.swing.SwingUtilities.invokeLater(
          new Runnable () {
            public void run() {
               saveTextField.setSelectionStart(
                 saveTextField.getText().length()
               );
            }
          }
        );
      }
      public void focusLost(java.awt.event.FocusEvent e) {}
    }
    public ScrollCellEditor(int charCounts,int wrapColumnAt) {
           //super(null);
          super(new JTextField());
          //saveTextField.setLineWrap(true);
          //saveTextField.setWrapStyleWord(true);
          editorComponent=saveTextField;
          if(charCounts>0){
            saveTextField.setDocument(
             new LimitedStyledDocument(charCounts)
            );
          }
          saveTextField.addFocusListener(new FocusEventHandler()); // register event handler
          if(wrapColumnAt!=0){
            editorComponent.addKeyListener(
                new TextAreaWrapListener(
                                     (JTextArea)editorComponent,
                                     wrapColumnAt));
          }
    }

    public boolean shouldSelectCell(EventObject anEvent){
      return true;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                     boolean isSelected, int row, int column){
                     saveTextField.setText("");
                     Object obj =table.getValueAt(row,column);
                     if(obj !=null){
                       saveTextField.setText(table.getValueAt(row,column).toString());
                       saveTextField.setSelectionStart(0);
                     }
                     _storedJScrollPane.getViewport().add(saveTextField,null);
                     return _storedJScrollPane;

    }
    public Object getCellEditorValue(){
      return saveTextField.getText();
    }
  }
  void _jTable1_mouseReleased(MouseEvent e) {
     if(!_lastTimeVarifyResult){
        e.consume();
        return;
     }
  }
  void _jTable1_mousePressed(MouseEvent e) {
   //System.out.println(" get invalidate from mouse click event begin");
   if(_processingTxtLostFocus){
      e.consume();
      return;
   }
   if(!_lastTimeVarifyResult){
      e.consume();
      _jTable1.changeSelection(_lastEditingRow,_lastEditingColumn,false,false) ;
      _jTable1.editCellAt(_lastEditingRow,_lastEditingColumn);
      ((JComponent)_jTable1.getEditorComponent()).grabFocus();
      return;
   }
   if(_lastEditingRow!=-1 && _lastEditingColumn!=-1){
     if(!_jTable1.getModel().isCellEditable(_lastEditingRow,_lastEditingColumn))return;
       _processingTxtLostFocus=true;
           Object obj=null;
           if(_txtEditorVarifiers!=null){
             obj= _txtEditorVarifiers.get(_jTable1.getColumnName(_lastEditingColumn));
           }
           if(obj!=null){
             CellTxtEditorFormat _ctef=(CellTxtEditorFormat)obj;
             if(!_ctef.isFormatValid(
                (String)_jTable1.getValueAt(
                  _lastEditingRow,_lastEditingColumn
                  ),_lastEditingRow,_lastEditingColumn
                )){
                   _lastTimeVarifyResult=false;
                   e.consume();
                   exgui.verification.VerifyLib.showAllert(
                     _ctef.formatPromptMsg()
                   );
                   _jTable1.changeSelection(
                     _lastEditingRow,_lastEditingColumn,false,false
                   ) ;
                    _jTable1.editCellAt(_lastEditingRow,_lastEditingColumn);
                    return;
             }else{
              _lastTimeVarifyResult=true;
             }
           }
        _processingTxtLostFocus=false;
   }
    if(_lastTimeVarifyResult){
     //System.out.println("mouse clicked at :"+_jTable1.getSelectedRow() +","+_jTable1.getSelectedColumn());
     _lastEditingRow= _jTable1.getSelectedRow();
     _lastEditingColumn =_jTable1.getSelectedColumn();
     Object valueObj=_jTable1.getValueAt(_lastEditingRow,_lastEditingColumn);
     _jTable1.editCellAt(_lastEditingRow,_lastEditingColumn);
     _currentCellEditor= (JComponent)_jTable1.getEditorComponent();
     if(_currentCellEditor instanceof javax.swing.text.JTextComponent){
       ((JComponent)_currentCellEditor).grabFocus();
       if(valueObj!=null){
        //System.out.println("clicked value Object"+valueObj.toString());
        ((javax.swing.text.JTextComponent)_currentCellEditor).setText(valueObj.toString().trim());
       }
     }
     if(_currentCellEditor!=null)((JComponent)_currentCellEditor).grabFocus();
   }
  }

  void _jTable1_keyPressed(KeyEvent e) {
    //_lastEditingRow =_jTable1.getSelectedRow();
    //_lastEditingColumn =_jTable1.getSelectedColumn();
    //System.out.println("selected row and column ="+_lastEditingRow+","+_lastEditingColumn);
    //int editRow=_jTable1.getEditingRow();int editCol=_jTable1.getEditingColumn();
    //System.out.println("editing row and column ="+editRow+","+editCol);
    if(e.getKeyCode()==e.VK_ENTER){
      _jtblKeyReleased2Move();
      /*
      if (!_lastTimeVarifyResult){

      }*/
      return;
    }
    if(e.getKeyCode()==e.VK_TAB && e.isShiftDown() ){
      System.out.println("====moving left=======");
      moveLeft();
      return;
    }
    if(e.getKeyCode()==e.VK_TAB && (!e.isShiftDown()) ){

      System.out.println("====moving Right=======");
      moveRight();
      return;
    }

     if(e.getKeyCode()==KeyEvent.VK_SPACE){
      _lastEditingRow =_jTable1.getSelectedRow();
      _lastEditingColumn =_jTable1.getSelectedColumn();
      final Component jcop=_jTable1.getEditorComponent();
      if(jcop instanceof javax.swing.JComboBox){
           //System.out.println(" Top keyPressed in (jcop instanceof javax.swing.JComboBox) && (e.getKeyCode()==KeyEvent.VK_SPACE)");
           //e.setKeyCode(0);
          ((JComboBox)jcop).setLightWeightPopupEnabled(false);
          ((JComboBox)jcop).putClientProperty("JComboBox.lightweightKeyboardNavigation","Lightweight");
          ((JComboBox)jcop).grabFocus();
           return ;
      }
     }
     if(!e.isActionKey()){
      _lastEditingRow =_jTable1.getSelectedRow();
      _lastEditingColumn =_jTable1.getSelectedColumn();
      /*
      System.out.println("editing at:"+
       _lastEditingRow+":"+_lastEditingColumn
      );
      */
      TableCellEditor xlEdt=_jTable1.getCellEditor();
      Component jcop=_jTable1.getEditorComponent();
      if(xlEdt instanceof ScrollCellEditor ){
        ((ScrollCellEditor)xlEdt).saveTextField.grabFocus();
        return ;
      }
      if(jcop==null){
        if(!_jTable1.isCellEditable(_jTable1.getSelectedRow(),_jTable1.getSelectedColumn()) )return;
        _jTable1.editCellAt(
           _jTable1.getSelectedRow(),
           _jTable1.getSelectedColumn()
        );
          _jTable1_keyPressed(e);
          return;
      }
      if(jcop instanceof JTextField){
        _jTable1.editCellAt(
           _jTable1.getSelectedRow(),
           _jTable1.getSelectedColumn()
        );
       Object obj2Display=_jTable1.getValueAt(
         _jTable1.getSelectedRow(),
         _jTable1.getSelectedColumn()
           );
        if(obj2Display==null){
         ((JTextField)jcop).setText("");
        }else{
         ((JTextField)jcop).setText(obj2Display.toString());
         ((JComponent)jcop).grabFocus();
         //((JTextField)jcop).selectAll();<-----2004/01/29
        }
      }else if((jcop instanceof javax.swing.JComboBox) && (e.getKeyCode()==KeyEvent.VK_SPACE)){
           //System.out.println("Bottom keyPressed in (jcop instanceof javax.swing.JComboBox) && (e.getKeyCode()==KeyEvent.VK_SPACE)");
           e.setKeyCode(0);
          //jComboboxSelectedString="";
          ((JComboBox)jcop).setLightWeightPopupEnabled(false);
          ((JComboBox)jcop).putClientProperty("JComboBox.lightweightKeyboardNavigation","Lightweight");
           //if(e.getKeyCode()==KeyEvent.VK_SPACE)((JComboBox)jcop).showPopup();
          ((JComponent)((JComboBox)jcop).getEditor().getEditorComponent()).grabFocus();
          ((JComboBox)jcop).getEditor().selectAll();
        }

     }
  }

  void _jTable1_propertyChange(PropertyChangeEvent e) {}

  void jScrollPane1_keyReleased(KeyEvent e) {

  }
  synchronized void _jtblKeyReleased2Move(){
    //System.out.println("_jTable1_keyReleased processed"+e.getKeyCode());
     int movingRow=_jTable1.getSelectedRow();
     int movingCol=_jTable1.getSelectedColumn();
     /*
     System.out.println(
      "_jTable1_propertyChange :"+movingRow+","+movingCol+
      "    last editing at:"+_lastEditingRow+","+_lastEditingColumn
     );
     */
     if(movingCol<0 || movingRow<0 ) return;
     _processingTxtLostFocus=true;
     if(movingCol!=_lastEditingColumn || movingRow!=_lastEditingRow){
       Object obj=null;
       if(_txtEditorVarifiers!=null){
         if(_lastEditingColumn>=getJTable().getColumnCount()||_lastEditingColumn<0){
           _processingTxtLostFocus=false;
           return;
         }
         if(_lastEditingRow>=getJTable().getRowCount()||_lastEditingRow<0){
           _processingTxtLostFocus=false;
           return;
         }
          obj= _txtEditorVarifiers.get(_jTable1.getColumnName(_lastEditingColumn));
       }
       if(!_jTable1.getModel().isCellEditable(_lastEditingRow,_lastEditingColumn)) {
         _processingTxtLostFocus=false;
         return;
       }
       if(obj!=null){
         CellTxtEditorFormat _ctef=(CellTxtEditorFormat)obj;
         if(!_ctef.isFormatValid(
            (String)_jTable1.getValueAt(
              _lastEditingRow,_lastEditingColumn
              ),_lastEditingRow,_lastEditingColumn
            )){
               _lastTimeVarifyResult=false;

               exgui.verification.VerifyLib.showAllert(
                 _ctef.formatPromptMsg()
               );
               _jTable1.changeSelection(
                 _lastEditingRow,_lastEditingColumn,false,false
               ) ;
                _jTable1.editCellAt(_lastEditingRow,_lastEditingColumn);

         }else{
          _lastTimeVarifyResult=true;
         }

       }
       _processingTxtLostFocus=false;
     }

  }
  void _jTable1_keyReleased(KeyEvent e) {
    //System.out.println("_jTable1_keyReleased ,the last fucntion of this java ,called");
     if(e.getKeyCode()==KeyEvent.VK_ESCAPE ){
           mt.m_Text=
               (lastOrgObjectB4Editing==null)?"":lastOrgObjectB4Editing.toString();
     }else if(
            e.getKeyCode()==KeyEvent.VK_UP ||
            e.getKeyCode()==KeyEvent.VK_DOWN ||
            e.getKeyCode()==KeyEvent.VK_LEFT ||
            e.getKeyCode()==KeyEvent.VK_RIGHT ||
            e.getKeyCode()==KeyEvent.VK_ENTER
            //e.getKeyCode()==KeyEvent.VK_TAB
      ){
        _jtblKeyReleased2Move();
       }
  }

}
