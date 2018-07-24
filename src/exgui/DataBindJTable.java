package exgui;
import javax.swing.*;
import database.datatype.Record;
import java.util.*;
import javax.swing.table.*;
import util.InsertionOrderedHashMap;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DataBindJTable extends javax.swing.JComponent  {
  protected JTable _jtbl;
  protected Vector _records;
  public DataBindJTable(JTable jtable,Vector records,Hashtable colMapToObj2StirngKvtr) {
    super();
    iniProc(jtable,records,null,colMapToObj2StirngKvtr);
  }
  public DataBindJTable(JTable jtable,Vector records ,InsertionOrderedHashMap columNameMapping,Hashtable colMapToObj2StirngKvtr) {
    super();
    iniProc(jtable,records,columNameMapping,colMapToObj2StirngKvtr);
  }
  protected void iniProc(JTable jtable,Vector records,InsertionOrderedHashMap columNameMapping,Hashtable colMapToObj2StirngKvtr){
    _jtbl=jtable;
    //data vector is string produced by colMapToObj2StirngKvtr.Obj2String,
    //or directly Object.toString() in record if colMapToObj2StirngKvtr.Obj2String is not fund.
    //_jtbl.setModel();
    _records=records;
    iniTableModel(columNameMapping,colMapToObj2StirngKvtr);
    MultiLineHeaderRenderer renderer = new MultiLineHeaderRenderer();
    Enumeration enum_ = _jtbl.getColumnModel().getColumns();
    while (enum_.hasMoreElements()) {
      ((TableColumn)enum_.nextElement()).setHeaderRenderer(renderer);
    }
  }
  protected void iniTableModel(InsertionOrderedHashMap columMapping,Hashtable ObjInRecKvtMapping){
    Vector columnNameVector=new Vector();
    Vector rowDataVct=new Vector();
    Vector columnAtWhichField_Vct=new Vector();
    if(_records.size()==0){
      //just make table head.
      Set set=columMapping.entrySet();
      Iterator itr=columMapping.entrySet().iterator();
      while(itr.hasNext()){
         Map.Entry entry=(Map.Entry)itr.next();
         String keyName=(String)entry.getKey();
         columnNameVector.add(keyName);
      }

      //DefaultTableModel dm =     new DefaultTableModel(rowDataVct,columnNameVector);
      MultiClassTableModel dm=new MultiClassTableModel(rowDataVct,columnNameVector);
      _jtbl.setModel(dm);
      return;
    }
    ArrayList arrStr=((Record)_records.get(0)).getFieldName();
    //first is to prepare the head column nane.
    if(columMapping==null){
       for(int i=0;i<arrStr.size();i++){
         columnNameVector.add((String)arrStr.get(i));
         columnAtWhichField_Vct.add(new Integer(i));
       }

    }else{
      Set set=columMapping.entrySet();
      Iterator itr=columMapping.entrySet().iterator();
      while(itr.hasNext()){
         Map.Entry entry=(Map.Entry)itr.next();
         String keyName=(String)entry.getKey();
         columnNameVector.add(keyName);
         columnAtWhichField_Vct.add(new Integer(getColNameAt(arrStr,(String)entry.getValue())));
      }
    }

    //after column name is prepared,preparing data vector.
    int colAtInt=0;
    for(int i=0;i<_records.size();i++){
        Record rec=(Record)_records.get(i);
        Vector columnDataVct=new Vector();
        for(int j=0;j<columnAtWhichField_Vct.size();j++){
          colAtInt=((Integer)columnAtWhichField_Vct.get(j)).intValue();
          if(colAtInt==-1){
             columnDataVct.add("erro column name match!!");
          }else{
             Object2String convertor=null;
             if(ObjInRecKvtMapping!=null){
                if(ObjInRecKvtMapping.get((String)columnNameVector.get(j)) instanceof Object2String){
                  convertor= (Object2String)ObjInRecKvtMapping.get((String)columnNameVector.get(j));
                }
               }
               if(convertor==null)
                 columnDataVct.add(rec.get(colAtInt));
               else{
                 String cellStr = convertor.Obj2String(rec.get(colAtInt));
                 columnDataVct.add((cellStr==null)?"" :cellStr.trim());
               }
             }

        }
      rowDataVct.add(columnDataVct);
    }

    //finally set to table model
    //DefaultTableModel dm = new DefaultTableModel(rowDataVct,columnNameVector);
    MultiClassTableModel dm=new MultiClassTableModel(rowDataVct,columnNameVector);
    _jtbl.setModel(dm);
  }
  private int getColNameAt(ArrayList fieldNames,String String2Search){
     if(String2Search==null) return -1;
     for(int i=0;i<fieldNames.size();i++){
      String storedFieldName=((String)fieldNames.get(i)).trim();
      if(storedFieldName.equalsIgnoreCase(String2Search)) return i;
     }
     return -1;
  }
}
