package exgui;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

  public class MultiClassTableModel extends DefaultTableModel{
    Vector _rowdatas=null;
    java.util.Hashtable   editableColumns=new java.util.Hashtable();
    CellEditablePolicy privateEditablePolicy=null;
    public MultiClassTableModel(Vector rowDatas,Vector columns){
      super(rowDatas,columns);
      _rowdatas=rowDatas;
    }
    public void setCellEditablePolicy(CellEditablePolicy myPolicy){
      privateEditablePolicy =myPolicy;
    }
    public void registEditableColumn(String columnName){
      editableColumns.put(columnName,new Boolean(true));
    }
    public void removeEditableColumn(String columnName){
     editableColumns.remove(columnName);
    }
    public void removeAllEditableColumn(){
     editableColumns.clear();
    }
    public void setValueAt(Object value,int row,int col){
      if(row<getRowCount() && col < getColumnCount()){
        super.setValueAt(value,row,col);
      }
    }
    public Object getValueAt(int row,int col){
      if(row==-1 || col==-1)return null;
      return super.getValueAt(row,col);
    }
    public boolean isCellEditable(int row,int column){
       if(getRowCount()==0){
         return false;
       }
        if(row==-1||column==-1)return false;
         if(editableColumns.containsKey(getColumnName(column))){
          if(privateEditablePolicy !=null){
            return privateEditablePolicy.isCellEditable(row,column);
          }else{
            return true;
          }
         }else{
            return false;
         }
    }
    public Class getColumnClass(int column){
      if(_rowdatas!=null && _rowdatas.size()>0){
        Vector _columnDatas=(Vector)_rowdatas.get(0);
        if(_columnDatas.size()>column){
         //System.out.println(_columnDatas.get(column).toString());
         if(_columnDatas.get(column)==null)return super.getColumnClass(column);
         //System.out.println("_columnDatas.get(column):"+_columnDatas.get(column).toString());
         return _columnDatas.get(column).getClass();
        }else{
        return super.getColumnClass(column);
        }
      }else{
       return super.getColumnClass(column);
      }
    }
  }
