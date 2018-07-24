package exgui.ultratable ;
import database.datatype.Record ;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.*;
import util.*;
/**
 * <p>Title: NEWTIMES ERP SYS</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: NEO-TEC</p>
 * @author not attributable
 * @version 1.0
 */

public class DataBindComboboxTable  extends exgui.DataBindGUIObject implements exgui.SwingSingleSelection{
  protected Object value;
  protected boolean isValueChanged = true;
  protected Record recSelectValue;
  protected JTextField txtInput = new JTextField();
  protected javax.swing.JPopupMenu popout = new javax.swing.JPopupMenu();
  protected Vector vctdata;
  protected Panel2List pnl;

  //util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
  protected String orgHeaderString[] = null;
  protected int recFieldIndex[] = null;
  protected util.InsertionOrderedHashMap headColums;

  protected int width, hight;
  protected int currentSortColumnAt = 0;
  protected boolean isKeyPressing = false;
  protected Object value2Return;
  protected String column2Show;
  protected String column2Value;
  protected int valueColumnAt;
  protected Compartor sorter = new Compartor();
  protected java.awt.Component jcompTestFucos;
  protected java.awt.event.KeyAdapter keyAdpt=
  new java.awt.event.KeyAdapter(){
    public void keyReleased(java.awt.event.KeyEvent ke){
      txtInput_keyReleased(ke);
    }
    public void keyPressed(java.awt.event.KeyEvent ke){
      ke.consume();
    }
  };
  public DataBindComboboxTable(){
    java.awt.BorderLayout bordlayout=new java.awt.BorderLayout();
    this.setLayout(bordlayout);
    this.add(txtInput,bordlayout.CENTER);
    txtInput.setName("txtInput");

  }
  /**
   *
   * @param _vctdata Vector
   * @param _headColums InsertionOrderedHashMap
   * @param _width int
   * @param _hight int
   * @param showColumn String
   * @param matchColumn String
   * @param select2value Object
   */
  public void init(String columnNameFromRecord,
                               Vector _vctdata,
                               InsertionOrderedHashMap _headColums,
                               int _width,int _hight ,
                               String valueColumName,
                               String showColumn,
                               Object select2value
                               ) {
    _match2RecField=columnNameFromRecord;
    column2Show=showColumn;
    column2Value=valueColumName;
    width=_width;
    hight=_hight;
    vctdata=_vctdata;
    headColums=_headColums;
    jbinit();
    value2Return=select2value;
    //find out the table row to select.
    Vector vct=pnl.getDisplayingRecords();
    String orgValue=(select2value==null)?"":select2value.toString();

    int i=0;
    isKeyPressing=true;
    for(i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      Object objRowValue=rec.get(valueColumnAt);
      String strObjValue=( objRowValue==null)?"":objRowValue.toString();
      if(strObjValue.equalsIgnoreCase(orgValue)){

        pnl.getJtable().changeSelection(i,currentSortColumnAt,false,false);
        Object objTxt=rec.get(recFieldIndex[currentSortColumnAt]);
        txtInput.setText((objTxt==null)?"":objTxt.toString());
        txtInput.setCaretPosition(txtInput.getText().length());
        break;
      }
    }
    if(i==vct.size()){
      pnl.getJtable().changeSelection(-1,currentSortColumnAt,false,false);
      txtInput.setText("");
      value2Return=null;
      txtInput.setCaretPosition(txtInput.getText().length());
    }
    isKeyPressing=false;
    txtInput.addKeyListener(keyAdpt);
  }
  public boolean isValidx(){
    return true;
  }
  public boolean isChanged(){
    return isValueChanged;
  }
  public Object getSelectedValue(){
    //return (txtInput.getText().trim().length()==0)?null:value2Return;
    if(txtInput.getText().trim().length()==0)return null;
    if(pnl.getJtable().getSelectedRow()==-1)return null;
    Record rec=(Record)pnl.getDisplayingRecords().get(pnl.getJtable().getSelectedRow());
    try{
      return rec.get(column2Value);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      return null;
    }
  }
  public javax.swing.JComponent getGUIcomponent(){
    return txtInput;
  }

  class FocusOfMe extends java.awt.event.FocusAdapter{
    public void focusGained(java.awt.event.FocusEvent  fe){
      System.out.println("focus graind "+((java.awt.Component)fe.getSource()));
      //txtInput.removeKeyListener(keyAdpt);
      //txtInput.addKeyListener(keyAdpt);
    }
    public void focusLost(java.awt.event.FocusEvent fe){
      //jcompTestFucos=fe.getOppositeComponent();
      System.out.println("Focus Lost OppositeComponent is:"+jcompTestFucos);
      System.out.println("focus lost "+((java.awt.Component)fe.getSource()));
      //txtInput.removeKeyListener(keyAdpt);
    }
  }
  public void jbinit(){
    /*
    java.awt.BorderLayout bordlayout=new java.awt.BorderLayout();
    java.awt.BorderLayout bordlayout2=new java.awt.BorderLayout();
    this.setLayout(bordlayout);
    this.add(txtInput,bordlayout.CENTER);
    */
    FocusOfMe focusTo=new FocusOfMe();
    txtInput.addFocusListener(focusTo);

     java.awt.BorderLayout bordlayout2=new java.awt.BorderLayout();
    java.util.Iterator  itr=headColums.entrySet().iterator();
    java.util.List arrName=new java.util.ArrayList();
    while(itr.hasNext()){
      java.util.Map.Entry entry=(java.util.Map.Entry)itr.next();
      arrName.add(entry.getKey());
    }
    orgHeaderString=(String[])arrName.toArray(new String[]{});

    if(vctdata!=null && vctdata.size()>0){
      Record recTmp=(Record)vctdata.get(0);
      recFieldIndex=new int[orgHeaderString.length];
      for(int i=0;i<orgHeaderString.length;i++){
        String recFieldName=(String)headColums.get(orgHeaderString[i]);
        recFieldIndex[i]=util.MiscFunc.getFieldIndexAtRecord(recTmp,recFieldName);
        //System.out.println("recFieldName="+recFieldName+", colum2 show is :"+column2Show);
        if(recFieldName.equalsIgnoreCase(column2Show)){
          currentSortColumnAt=i;
        }
        if(recFieldName.equalsIgnoreCase(column2Value)){
          valueColumnAt=i;
        }
      }
    }
    sortRecords(currentSortColumnAt);
    pnl=new Panel2List(new DataModel(),99999,headColums,new Hashtable());
    pnl.firstPage();
    pnl.getPanelContainsButtons().removeAll();
    pnl.remove(pnl.getPanelContainsButtons());
    pnl.remove(pnl.getLowerRightPanel());
    //pnl.getJtable().setPreferredSize(new java.awt.Dimension(width,hight));
    pnl.setPreferredSize(new java.awt.Dimension(width,hight));


    JTableHeader tblHeader=pnl.getJtable().getTableHeader();
    tblHeader.addMouseListener(new MouseClickOnHeader());
    pnl.getJtable().getColumnModel().getColumn(currentSortColumnAt).setHeaderValue(orgHeaderString[currentSortColumnAt]+" "+"¡¶");


    SelectionListener slkListen=new SelectionListener(pnl.getJtable());
    pnl.getJtable().getSelectionModel().addListSelectionListener(slkListen);
    pnl.getJtable().getColumnModel().getSelectionModel().addListSelectionListener(slkListen);

    popout.setLayout(bordlayout2);
    //javax.swing.JLabel labelTEst=new javax.swing.JLabel("Test");
    popout.add(pnl,bordlayout2.CENTER);
    popout.setFocusTraversalKeysEnabled(true);
    popout.setFocusable(false);
    pnl.setFocusable(false);
    pnl.getJtable().setFocusable(false);
    //popout.setLightWeightPopupEnabled(false);
    /*
    Thread focThread =new Thread(new FocusMonitorThread());
    focThread.start();
    */
    //popout.setLightWeightPopupEnabled(true);
    /*
    txtInput.addKeyListener(
       new java.awt.event.KeyAdapter(){
         public void keyReleased(java.awt.event.KeyEvent ke){
           txtInput_keyReleased(ke);
         }
       }
    );*/
    //popout.setLocation((int)this.getLocation().getX(),(int)this.getLocation().getY()+this.getHeight());
  }
  protected void sortRecords(int headColumnIndexClicked){

    sorter.field2compare= recFieldIndex[headColumnIndexClicked];
    //System.out.println("header clicked");
    java.util.List list=new java.util.ArrayList(vctdata);
    java.util.Collections.sort(list,sorter);
    vctdata.clear();
    vctdata.addAll(list);

  }
  class MouseClickOnHeader extends java.awt.event.MouseAdapter{


    public void mouseClicked(java.awt.event.MouseEvent me){
       int vColIndex = pnl.getJtable().getColumnModel().getColumnIndexAtX(me.getX());
       if(-1==vColIndex)return;
       currentSortColumnAt=vColIndex;
       sortRecords(currentSortColumnAt);
       pnl.reload();
       txtInput.setText("");
       for(int i=0;i<pnl.getJtable().getColumnCount();i++){
             //¡¶
         if(i==vColIndex){
              pnl.getJtable().getColumnModel().getColumn(i).setHeaderValue(orgHeaderString[i]+"¡¶");
         }else{
           pnl.getJtable().getColumnModel().getColumn(i).setHeaderValue(orgHeaderString[i]);
         }
       }


    }
  }

  protected class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public void makeTable(Vector vct){
      super.makeTable(vct);
    }
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
         return null;
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){



    }
  }

  class Compartor implements java.util.Comparator{
    int field2compare=0;
    String strOrg;
    String strDest;
    public int compare(Object rec1,Object rec2){

       Object objOrg=((database.datatype.Record)rec1).get(field2compare);
       strOrg=(objOrg==null)?"":objOrg.toString();
       Object objDest=((database.datatype.Record)rec2).get(field2compare);
       strDest=(objDest==null)?"":objDest.toString();
       return strOrg.compareTo(strDest);

     }
  }
  class FocusMonitorThread implements Runnable{
      public void run(){
        while(true){
          try{
           if(popout.isVisible() && !txtInput.isFocusOwner()){
           //if(popout.isShowing()){
             txtInput.grabFocus();
             //txtInput.setCaretPosition(txtInput.getText().length());
           }
           Thread.currentThread().sleep(10);
          }catch (java.lang.InterruptedException ieexp){
          }catch(Exception exp){
            exp.printStackTrace();
          }
        }
      }
  }
  class DataModel implements  exgui.ultratable.PagedDataFactory{
    public Vector  getRecords(int startPosition,int rowCounts)throws Exception{
      return vctdata;
    }
    public void deleteRecord(Record rec2delete)throws Exception{}
    public void restoreRecord(Record rec2restore)throws Exception{}
    public Record addRecord(Record rec2add)throws Exception{return null;}
    public Record getBlankRecord()throws Exception{return null;}
    public void updateRecords(Vector recs2update)throws Exception{}
    public boolean listforRestore(){return false;}

  }

 protected void txtInput_keyReleased(java.awt.event.KeyEvent e) {
    int rowAt=pnl.getJtable().getSelectedRow();
    if(e.getKeyCode() ==e.VK_ESCAPE ){
      if( popout.isVisible())  popout.setVisible(false);
      this.getParent().requestFocus();
      txtInput.grabFocus();
      e.consume();
      return;
    }
    if(e.getKeyCode() ==e.VK_UP || e.getKeyCode() ==e.VK_DOWN){
      if(e.getKeyCode() ==e.VK_UP ){
        if( popout.isVisible()){
          if (rowAt > -1)rowAt--;
        }
      }else{
        if(!popout.isVisible()){
          popout.show(this,0,txtInput.getHeight()+2);
          txtInput.grabFocus();
          e.consume();
          return;
        }
        if(rowAt!=pnl.getJtable().getRowCount()-1)++rowAt;
      }

      pnl.getJtable().changeSelection(rowAt,currentSortColumnAt,false,false);
      txtInput.grabFocus();
      e.consume();
      return;
    }
    if(popout.isVisible() && e.getKeyCode()==e.VK_ENTER){
      //while press enter,means clear selection;
      if(txtInput.getText().trim().length()==0){
        txtInput.setText("");
        popout.setVisible(false);
         javax.swing.SwingUtilities.invokeLater(
             new Runnable() {
                  public void run() {
                      txtInput.grabFocus();
                  }
              });

        e.consume();
        return;
      }
      value2Return=((Record)pnl.getDisplayingRecords().get(rowAt)).get(0);
      Object objValue = pnl.getJtable().getValueAt(rowAt, currentSortColumnAt);
      txtInput.setText((objValue==null)?"":objValue.toString());
      popout.setVisible(false);
      //txtInput.setCaretPosition(txtInput.getText().length());

      javax.swing.SwingUtilities.invokeLater(
          new Runnable() {
               public void run() {
                   txtInput.grabFocus();
               }
           });
      e.consume();
      //txtInput.removeKeyListener(keyAdpt);
      return;
    }
    if(!popout.isVisible() && !e.isActionKey() ){
      popout.show(this,0,txtInput.getHeight());
      txtInput.grabFocus();
      e.consume();
    }

    isKeyPressing=true;
    for(int i=0;i<pnl.getJtable().getRowCount();i++){
      Object objValue=pnl.getJtable().getValueAt(i,currentSortColumnAt);
      if(objValue==null)objValue="";
      if(objValue.toString().trim().startsWith(txtInput.getText())){
        pnl.getJtable().changeSelection(i,currentSortColumnAt,false,false);
        break;
      }
    }
    e.consume();
    isKeyPressing=false;
  }
  class SelectionListener implements javax.swing.event.ListSelectionListener {
     JTable table;

     // It is necessary to keep the table since it is not possible
     // to determine the table from the event's source
     SelectionListener(JTable table) {
         this.table = table;
     }
     public void valueChanged(javax.swing.event.ListSelectionEvent e) {
         // If cell selection is enabled, both row and column change events are fired
         if (e.getSource() == table.getSelectionModel()
               && table.getRowSelectionAllowed()) {
             // Column selection changed
             int first = e.getFirstIndex();
             int last = e.getLastIndex();
         } else if (e.getSource() == table.getColumnModel().getSelectionModel()
                && table.getColumnSelectionAllowed() ){
             // Row selection changed
             int first = e.getFirstIndex();
             int last = e.getLastIndex();
         }

         if (e.getValueIsAdjusting()) {
             // The mouse button has not yet been released
         }
         //System.out.println("valueChanged called");
         if(!isKeyPressing){
           int rowAt = table.getSelectedRow();
           if(rowAt<0||rowAt>=table.getRowCount())return;
           value2Return=((Record)pnl.getDisplayingRecords().get(rowAt)).get(valueColumnAt);
           if(rowAt==-1 || rowAt > table.getRowCount()-1) return;
           Object objValue = table.getValueAt(rowAt, currentSortColumnAt);
           txtInput.setText((objValue == null)?"":objValue.toString());
           /*
           javax.swing.SwingUtilities.invokeLater(
               new Runnable() {
                    public void run() {
                        txtInput.grabFocus();
                    }
                });
            */
         }

     }
 }

}

