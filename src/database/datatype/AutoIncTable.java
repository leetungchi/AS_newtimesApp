package database.datatype;
import java.util.Vector;
import java.util.HashMap;
import java.sql.*;
import database.Database;
/**
 * Title:AutoIncTable
 * Description: table with auto-increace column function.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author Crazy JOHN
 * @version 1.0
 */

public class AutoIncTable extends database.datatype.Table  implements database.datatype.AutoIncInterface{
  TableInterface iniTable=null;
  Table tbl4Counter=null;
  Table mainFunctionTable=null;
  CommonTable commontable=null;//just for insert process need.
  /**
   * this class pluse the auto-increamse column
   * if no table "inforich_com_tw_tables" ,will create that table by this class and insert a record (this table name,1) into it
   * and need to implements AutoIncInterface with method "insertRecord(record,returncolumn) return counter vale."
   * @param table ,class with table interface.
   */
  protected AutoIncTable(){
  }
  public AutoIncTable(TableInterface table) {
    iniTable=table;
    try{
       String iniPKString=iniTable.getPKColumns();
       String iniTableName=iniTable.getTableName();
       Database iniDb=iniTable.getDataBase();
     //System.out.println(iniTableName+"  creating common table object:pk name  is:"+iniPKString);
     //System.out.println("processing class is:"+iniTable.getClass().getName());
       commontable=new CommonTable(iniTableName,iniDb,iniPKString);
       pk=commontable.pk;
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"watch out,common table is null in AutoIncTable");
    }
    //find out database table named "inforich_tables_sn"
    //and the sn value in the row with this table name.
    try{
       tbl4Counter=new CommonTable("inforich_com_tw_tables",iniTable.getDataBase(),"tables");
    }catch(Exception e){
      //table creation fail while create table object,we need to create table for counter need
      util.ExceptionLog.exp2File(e,"fail while create table4counter,retry to create table:\"inforich_com_tw_tables\"");
      try{
      Database db=iniTable.getDataBase();
      Connection con=db.getConnection();
      boolean isAutoCommint=con.getAutoCommit();
      //con.setAutoCommit(true);
      Statement stm=con.createStatement();
      StringBuffer sb=new StringBuffer();
      sb.append("CREATE TABLE inforich_com_tw_tables");
      sb.append(" (tables varchar(255) NOT NULL PRIMARY KEY,");
      sb.append(" counter int NOT NULL DEFAULT 1)");
      stm.execute(sb.toString());
      //test if table is read by 5 times.
      for(int i=0;i<5;i++){
         if(ifHaveCounterTable(con)){
       //System.out.println("detecting coutner table.");
         //break;
         }
      }
      stm.close();
      //con.setAutoCommit(isAutoCommint);
      db.freeConnection(con);
      tbl4Counter=new CommonTable("inforich_com_tw_tables",iniTable.getDataBase(),"tables");
      }catch(Exception eII){
         util.ExceptionLog.exp2File(eII,"fail eve create inforich_com_tw_tables by sql,AutoInc table function abvord");
      }
    }
    Vector vctValue=new Vector();
    vctValue.add(iniTable.getTableName());
  //System.out.println("tbl4Counter is null ?"+(tbl4Counter==null));
    Record rec=null;
    try{
       rec=tbl4Counter.findRecordByPk(vctValue);
    }catch(Exception eIni){
      util.ExceptionLog.exp2File(eIni,"exp while AutiIncTable find a record");
    }
    if(rec==null){
     try{
       rec=tbl4Counter.newRecord();rec.set(0,iniTable.getTableName());
       tbl4Counter.insertRecord(rec);
      }catch(java.sql.SQLException jsS){
        util.ExceptionLog.exp2File(jsS,"exp while insert record into inforich_com_tw:"+jsS.getSQLState());
      }
    }
  }
  public String getPKColumns(){
    return iniTable.getPKColumns();
  }
  public Database getDataBase(){
    return iniTable.getDataBase();
  }
  public void setPKColumns(String pkStrings){
    iniTable.setPKColumns(pkStrings);
  }
  public String getTableName(){
    return iniTable.getTableName();
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

  public Vector findAll() {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findAll();
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues, int startRowPosition, int vectorLength) {
    /**@todo: implement this database.datatype.Table abstract method*/
    return iniTable.findRecordsByColumns(columnsAndValues,startRowPosition,vectorLength);
  }
  public  boolean isColumnReadOnly(String columnName) {
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
  public Record findRecordByPk(Vector PKvalues) throws java.sql.SQLException{
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
  /**
   * same as parent's insertRecord method,put have to increase the counter value.
   *@param record for insert;
   *@return int value for sequencial value of this row.
   *@exception java.sql.SQLException
   */
  public void insertRecord(Record record)throws java.sql.SQLException {
    long pkValue=getNextSn();
    if(pk.size()==1){
      String pkColumn=(String)pk.get(0);
      try{
      record.set(pkColumn,pkValue);
      }catch(Exception e){
        e.printStackTrace();
        throw new java.sql.SQLException("column:"+ pkColumn+ " not found in autoInc table"+tableName);
      }
    }
    System.out.println("#record:"+record.toString());
    commontable.insertRecord(record);
  }
  /**
   * this method is the really AutoIncInterface should equiped
   * to return a counter number after insert.
   * @param record ,the record to insert.
   * @param sn2ColumnName ,set the counter value to the column of this record.
   * @return long value as counter number value of this record
   * @exception java.sql.SQLException
   */
  public long insertRecord(Record record,String sn2ColumnName) throws Exception{
    long nextSn=getNextSn();
    if(sn2ColumnName!=null) record.set(sn2ColumnName,nextSn);
    commontable.insertRecord(record);
    return nextSn;
  }
  /**
   * to get next counter value as insert process need
   * @return long value for insertRecord process need.
   * @exception java.sql.SQLException.
   */
  protected synchronized long getNextSn()throws java.sql.SQLException{
     Vector vpk=new Vector();
     vpk.add(iniTable.getTableName());
     Record rec=tbl4Counter.findRecordByPk(vpk);
     long xntSn=Long.parseLong(rec.get(1).toString());
     rec.set(1,xntSn+1);
     tbl4Counter.updateRecord(rec);
     return xntSn;
  }
  /**
   * to detect if the counter table "inforich_com_tw_tables" exists or not
   * @param java.sql.Connection con the database connection for operation needs
   * @return if the counter table exists or not.
   */
 protected boolean ifHaveCounterTable(Connection con){
   try{
    ResultSet rs = con.getMetaData().getTables(null, null, "inforich_com_tw_tables", (new String[]{"TABLE"}));
    boolean result = rs.next();
    rs.close();
    return result;
   }catch(java.sql.SQLException jsse){
     return false;
   }
 }
 public void exeSQL(String sql) throws java.sql.SQLException {
   iniTable.exeSQL(sql);
 }
}