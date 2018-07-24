package database.datatype;
import java.sql.*;
import java.util.Vector;
import java.util.HashMap;
import database.Database;
/**
 * Title:Tree Node table class
 * Description:the table with tree structure column.(should contains id and parent_id column)
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author Crazy.John(check in at 1943)
 * @version 1.0
 */

public class TreeTable extends Table implements database.datatype.TreeTableInterface  {
  TableInterface iniTable=null;
  String idColumnName=null;
  String parentColumnName=null;
  Object rootValue=null;Object idleValue=null;
  /**
   * @param table ,with TableInterface Object
   * @param _idColumnName which is regarded as id of the each tree node record
   * @param _parentColumnName which is regarded as souce id of the parent of each tree node record
   * @param _rootValue,for tree seach need.to look up if a node is top of all  tree node or not
   * @param _idleValue ,if set idleValue to  record's parent Column,means this tree node is now  as un-categoried status.
   */
  public TreeTable(TableInterface table,String _idColumnName,String _parentColumnName,Object _rootValue,Object _idleValue) throws Exception{
     //iniTable=table;
     idColumnName=_idColumnName;parentColumnName=_parentColumnName;
     rootValue=_rootValue;idleValue=_idleValue;
     if(idColumnName==null || idColumnName.trim().equals("")) throw new Exception("exp in contructing Treetabe,id column name can not be null or blank");
     if(parentColumnName==null || parentColumnName.trim().equals("")) throw new Exception("exp in contructing Treetabe,parent column name can not be null or blank");
     if(rootValue==idleValue) throw new Exception("exp in contructing Treetabe,root value equals to idle value");
     if(idColumnName.equals(parentColumnName)) throw new Exception("exp in contructing Treetabe,id column name can not be qual as parent column name");
     //commonTable=new CommonTable(table.getTableName(),table.getDataBase(),table.getPKColumns());
     iniTable=table;
  }
  public Object getRootValue(){
    return rootValue;
  }
  public Object getIdleValue(){
    return idleValue;
  }
  public String getIdColumnName(){
    return idColumnName;
  }
  public String getParentColumnName(){
    return parentColumnName;
  }
  public Database getDataBase(){
    return iniTable.getDataBase();
  }
  public String getPKColumns(){
    return iniTable.getPKColumns();
  }
  public Vector SQL2Records(String sql) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.SQL2Records(sql);
  }
  public Vector SQL2Records(String sql,int rowAt,int rowCount) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.SQL2Records(sql,rowAt,rowCount);
  }

  public Vector getColumns() {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.getColumns();
  }
  public Vector findAll(int startRowPosition, int vectorLength, String orderByColumnName, boolean DescOrNot) {
    /**@todo: implement this database.datatype.Table abstract method*/
   return iniTable.findAll(startRowPosition,vectorLength,orderByColumnName,DescOrNot);
  }
  public void setPKColumns(String pkcolumns){
    iniTable.setPKColumns(pkcolumns);
  }
  public Vector findAll() {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findAll();
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues, int startRowPosition, int vectorLength) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findRecordsByColumns(columnsAndValues,startRowPosition,vectorLength);
  }
  public boolean isColumnReadOnly(String columnName) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.isColumnReadOnly(columnName);
  }
  public Vector findAll(int startRowPosition, int vectorLength) {
    /**@todo: implement this database.datatype.Table abstract method*/
     return iniTable.findAll(startRowPosition, vectorLength);
  }
  public Vector findRecordsByCondition(String whereString, int startRowPosition, int vectorLength) {
    /**@todo: implement this database.datatype.Table abstract method*/
   return  findRecordsByCondition(whereString,startRowPosition,vectorLength);
  }
  public void updateRecord(Record rec) throws java.sql.SQLException {
    /**@todo: implement this database.datatype.Table abstract method*/
    iniTable.updateRecord(rec);
  }
  public Record newRecord() {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.newRecord();
  }
  public Vector findRecordsByCondition(String whereString) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findRecordsByCondition(whereString);
  }
  public void deleteRecord(Record rec) throws java.sql.SQLException {
    /**@todo: implement this database.datatype.Table abstract method*/
     iniTable.deleteRecord(rec);
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues, int startRowPosition, int vectorLength, String orderByColumnName, boolean descOrNot) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findRecordsByColumns(columnsAndValues,startRowPosition,vectorLength,orderByColumnName,descOrNot);
  }
  public Record findRecordByPk(Vector PKvalues) throws java.sql.SQLException {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findRecordByPk(PKvalues);
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues, String orderByColumnName, boolean descOrNot) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findRecordsByColumns(columnsAndValues,orderByColumnName,descOrNot);
  }
  public Vector findAll(String orderByColumnName, boolean DescOrNot) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return findAll(orderByColumnName,DescOrNot);
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findRecordsByColumns(columnsAndValues);
  }
  public void insertRecord(Record record)throws java.sql.SQLException{
      iniTable.insertRecord(record);
  }
  public Vector getParentes(Record record) throws Exception{
    Vector parents= new Vector();
    Record currentNode;
    currentNode=record;
    while(!currentNode.get(idColumnName).toString().equals(rootValue.toString())){
       HashMap hm=new HashMap();hm.put(idColumnName,currentNode.get(parentColumnName));
       Vector vct=iniTable.findRecordsByColumns(hm);
       if(vct!=null && vct.size()==1){
           currentNode=(Record)vct.get(0);
       }else{
          if(parents.size()>0) return parents;
          //something wrong with database.
          throw new Exception("exp while process lookup parent in tree table,table is:"+iniTable.getTableName());
       }
       parents.add(currentNode);
    }
    return parents;
  }
  public Vector getCurChilds(Record record)throws Exception{
      HashMap hm=new HashMap();
      hm.put(parentColumnName,record.get(idColumnName));
      return iniTable.findRecordsByColumns(hm,idColumnName,false);
  }
  public Vector getAllChilds(Record record) throws Exception {
     Vector iniV=new Vector();
     return getLoopChilds(getCurChilds(record),iniV);
  }
  private Vector getLoopChilds(Vector lastget,Vector accu)throws Exception {
    if((lastget==null)||(lastget.size()==0)) return lastget;
    /*=====================================================*/
    Vector v1=new Vector();
    do{
     v1=new Vector();
     for(int i=0;i<lastget.size();i++){
        accu.add((Record)lastget.get(i));
        Vector v2=getCurChilds((Record)lastget.get(i));
        for(int k=0;k<v2.size();k++){
          v1.add(v2.get(k));
        }
     }
     lastget=v1;
      //if(v1!=null && v1.size() >0) break;
         //getLoopChilds(lastget,accu);
    }while(v1!=null && v1.size() >0);
    return accu;
  }
  public void exeSQL(String sql) throws java.sql.SQLException {
    iniTable.exeSQL(sql);
  }
  public String getTableName(){
    return iniTable.getTableName();
  }
}