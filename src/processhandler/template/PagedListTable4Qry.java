package processhandler.template;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.JTable;
import java.util.*;
import java.io.*;
public class PagedListTable4Qry extends AbstractUltraTablePanel  {
  protected InsertionOrderedHashMap aIOS;
  protected String chainedEditColumnNameString="Click To Edit";
  protected String chainedEditBtnColumnNameString=" . . . ";
  protected String[] arrEditColumnName;
  protected String[] arrEditButtonDisplayString;
  public final static String DELIMITER2CHAIN4BUTTON_COLUMN="|CHAIN_$$_CHAIN|";
  protected int orgColumnCount;
  protected GoPageNotify pageFileNotify=null;
  public PagedListTable4Qry(
      PagedDataFactory pagedDataFxy,
      int rowlength,util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor
    ) {
     super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
     toAddButtonFiled("Click To Edit"," . . . ");
  }
  public PagedListTable4Qry(
      PagedDataFactory pagedDataFxy,
      int rowlength,util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor,
      String btnClmTitleString,
      String btnTextString
    ) {
     super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
     if(btnClmTitleString==null||btnTextString==null){
       toAddButtonFiled("","");
     }else{
       toAddButtonFiled(btnClmTitleString, btnTextString);
     }
  }
  public void setHeadColumnMap(InsertionOrderedHashMap hm){
    orgColumnCount=hm.entrySet().size();
    super.setHeadColumnMap(hm);
  }
  public void toAddButtonFiled(String btnClmTitleString,String btnTextString){
    chainedEditColumnNameString=btnClmTitleString;
    chainedEditBtnColumnNameString=btnTextString;
    arrEditColumnName=util.MiscFunc.split(
                            chainedEditColumnNameString,
                            DELIMITER2CHAIN4BUTTON_COLUMN);
    arrEditButtonDisplayString=util.MiscFunc.split(
                            chainedEditBtnColumnNameString,
                            DELIMITER2CHAIN4BUTTON_COLUMN);
    orgColumnCount=tblHeadColumn.entrySet().size();
    for(int i=0;i<arrEditColumnName.length;i++){
      if(arrEditColumnName[0].length()==0)break;
      super.tblHeadColumn.put(arrEditColumnName[i],arrEditColumnName[i]);
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }

  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(super.tblHeadColumn!=null)return tblHeadColumn;
    return null;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    for(int i=0;i<arrEditColumnName.length;i++){
      if(arrEditColumnName[0].length()==0)return;
      multiEditorJTableInSuper.addButtons(orgColumnCount+i);
    }
  }
  protected int getEachPageRowCount() {
    return super._rowCounts;
  }
  protected Hashtable getObject2StringConvertor() {
    return klmObjKvtHt;
  }
  protected void makeTable(Vector vec){
    if(arrEditColumnName[0].length()==0){
      super.makeTable(vec);
      return;
    };
    for(int i=0;i<vec.size();i++){
      Record rec=(Record)vec.get(i);
      for(int j=0;j<arrEditColumnName.length;j++){
        rec.getFieldName().add(arrEditColumnName[j]);
        rec.getValueFields().add(arrEditButtonDisplayString[j]);
      }
    }
    super.makeTable(vec);
  }
  public void setGotopageNotifyer(GoPageNotify  notifiee){
    pageFileNotify=notifiee;
  }
  protected void goPage(int bgn,int rowcount){
    super.goPage(bgn,rowcount);
    if(pageFileNotify!=null)pageFileNotify.goPageNotify(bgn);
    /*
    getJtable().getColumnModel().getColumn(1).setHeaderRenderer(new myColumnHeadRenderer(getFont().getSize()*3));
    getJtable().getColumnModel().getColumn(2).setHeaderRenderer(new myColumnHeadRenderer(getFont().getSize()*5));
    getJtable().getColumnModel().getColumn(5).setHeaderRenderer(new myColumnHeadRenderer(20));
    getJtable().getColumnModel().getColumn(0).setHeaderRenderer(new myColumnHeadRenderer(5));
   */
   //getJtable().getColumnModel().getColumn(1).sizeWidthToFit();
   //getJtable().getColumnModel().getColumn(2).sizeWidthToFit();
   //getJtable().getColumnModel().getColumn(5).sizeWidthToFit();
   //getJtable().getColumnModel().getColumn(0).sizeWidthToFit();


  }


  protected PagedDataFactory getPagedDataFactory() {
    return this.dbHandler;
  }
  protected class myColumnHeadRenderer extends exgui.MultiLineHeaderRenderer{
    int preferedWidth;

    myColumnHeadRenderer(int width){
      super();
      preferedWidth=width;
    }

     public Component getTableCellRendererComponent(JTable table, Object value,
                     boolean isSelected, boolean hasFocus, int row, int column) {
      setFont(table.getFont());
      String str = (value == null) ? "" : value.toString();
      BufferedReader br = new BufferedReader(new StringReader(str));
      String line;
      int maxLength=0;
      Vector v = new Vector();
      try {
        while ((line = br.readLine()) != null) {
          v.addElement(line);
          if(line.length()>maxLength){
           maxLength=line.length();
          }
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      Dimension orgSize=this.getSize();
      int maxLengthWidth=(maxLength * table.getFont().getSize());
      //this.setSize(maxLengthWidth,(int)orgSize.getHeight());
      this.setSize(maxLengthWidth,(int)orgSize.getHeight());
      //table.getColumnModel().getColumn(column).setPreferredWidth(maxLengthWidth);
      table.getColumnModel().getColumn(column).setMinWidth(maxLengthWidth);
      table.getColumnModel().getColumn(column).setResizable(true);
      setListData(v);
      return this;
    }
  }
}
