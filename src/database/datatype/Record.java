package database.datatype;
import java.util.*;
import java.text.SimpleDateFormat;
import util.*;
/**
 * Title:Record class
 * Description:the Abstract Record class,defines some method and attribues of a record object
 *             the Parameter "Object" for getter and setter prefers:Integer,String,Long,Fload,Double,java.sql.Date,TimeStamp.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author John.Cheng.
 * @version 1.0
 */
public abstract class Record implements java.io.Serializable {
  boolean dbProcessed=false;//if the joined record,is not allow update.
  /*
  Vector fieldName=new Vector();
  Vector fieldValue=new Vector();
  Vector modifiedFields=new Vector();
  */

  protected  ArrayList fieldName=new ArrayList();
  protected ArrayList fieldValue=new ArrayList();
  protected ArrayList modifiedFields=new ArrayList();
  protected String tableName=null;
  protected Vector pk=null;//pk field should be assign from Factory(Talble Object.)
  /**
   * @return columns names in vector
   */

  public ArrayList getFieldName(){
    return fieldName;
  }
  public ArrayList getValueFields(){
    return fieldValue;
  }
  /*
  public Vector getFieldName(){
    return fieldName;
  }
  */
  /**
   * get Object from fields(i)
   * @param fieldIndex
   * @return Object in the column.
   */
   public abstract Object get(int fieldIndex);
   /**
    * get integer value from the sepcified column
    * @param feidIndex
    * @return value of the sepcified column
    */
   public int getInt(int fieldIndex){
     return Integer.parseInt(get(fieldIndex).toString());
   }
   /**
    * allow client class to check if this record is process by our Databas Object
    * @return if this record is processed by our db modules
    */
   public boolean isProcessed(){
     return dbProcessed;
   }
   /**
    * get float value from the sepcified column
    * @param feidIndex
    * @return value of the sepcified column
    */
   public float getFloat(int fieldIndex){
     return Float.parseFloat(get(fieldIndex).toString());
   }
   /**
    * get double value from the sepcified column
    * @param feidIndex
    * @return value of the sepcified column
    */
   public double getDouble(int fieldIndex){
     return Double.parseDouble(get(fieldIndex).toString());
   }
   /**
    * get long value from the sepcified column
    * @param feidIndex
    * @return value of the sepcified column
    */
   public long getLong(int fieldIndex){
     return Long.parseLong(get(fieldIndex).toString());
   }
  /**
   * to get Object from specifeid filed Name
   * @param fieldName to look into
   * @return Object
   * @exception if the column name is not fund in this record.
   */
  public abstract Object get(String findFieldName) throws Exception ;
  /**
   * to get Integer from specifeid filed Name
   * @param fieldName to look into
   * @return Object
   * @exception if the column name is not fund in this record.
   */
  public int getInt(String findFieldName) throws Exception{
    return Integer.parseInt(get(findFieldName).toString());
  }
  /**
   * to get float value from specifeid filed Name
   * @param fieldName to look into
   * @return Object
   * @exception if the column name is not fund in this record
   */
  public float getFloat(String findFieldName) throws Exception{
    return Float.parseFloat(get(findFieldName).toString());
  }
  public java.sql.Date getDate(String findFieldName) throws Exception{
      SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return new java.sql.Date(sm.parse(get(findFieldName).toString()).getTime());

  }
  public java.sql.Date getDate(int fieldIndex) throws Exception{
    SimpleDateFormat sm= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return new java.sql.Date(sm.parse(get(fieldIndex).toString()).getTime());
  }
  /**
   * to get Double value from specifeid filed Name
   * @param fieldName to look into
   * @return Object
   * @exception if the column name is not fund in this record
   */
  public double getDouble(String findFieldName) throws Exception{
    return Double.parseDouble(get(findFieldName).toString());
  }
  /**
   * to get long value from specifeid filed Name
   * @param fieldName to look into
   * @return Object
   * @exception if the column name is not fund in this record
   */

  public long getLong(String findFieldName) throws Exception{
    return Long.parseLong(get(findFieldName).toString());
  }

 /**
  * to set value into a field(column)
  * the value
  * @param fieldIndex
  * @param oIn the Object to set in,but Object type preferes:Integer,java.sql.Date,
  * String,Float,Double.
  */
 public abstract void set(int fieldIndex,Object oIn);

 /**
  * to set an Integer value to a column
  * @param fieldIndex
  * @param value is integer
  */
 public void set(int fieldIndex,int value){
    set(fieldIndex,new Integer(value));
 }
 /**
  * to set a double value to a column
  * @param fieldIndex
  * @param value is double
  */
   public void set(int fieldIndex,double value){
    set(fieldIndex,new Double(value));
 }

 /**
  * to set a float value to a column
  * @param fieldIndex
  * @param value is float
  */
   public  void set(int fieldIndex,float value){
    set(fieldIndex,new Float(value));
 }

 /**
  * to enable to set date object into column
  * @param fieldIndex
  * @param date
  */
 /*
 public void set(int fieldIndex,java.sql.Date date){
    set(fieldIndex,date);
 }
 */

 /**
  * to set long value to a column
  * @param fieldIndex
  * @param value is long value
  */
  public void set(int fieldIndex,long value){
   set(fieldIndex,new Long(value));
 }

 /**
  * @param findfieldtoSet
  * @param integer is value
  */
 public void set(String findFieldName,int value) throws Exception{
   set(findFieldName,new Integer(value));
 }
 /**
  * @param findfieldtoSet
  * @param value is double type
  */
 public void set(String findFieldName,double value) throws Exception{
   set(findFieldName,new Double(value));
 }
 /**
  * @param findfieldtoSet
  * @param value is instance of float
  */
 public void set(String findFieldName,float value) throws Exception {
   set(findFieldName,new Float(value));
 }
 /**
  * @param findfieldtoSet
  * @param value is instance of long
  */
 public void set(String findFieldName,long value) throws Exception {
   set(findFieldName,new Long(value));
 }
 /*
 public void set(String findFieldName,java.sql.Date date) throws Exception {
   set(findFieldName,date);
 }
 */
 /**
  *@param filedName to set
  *@param Object to Input
  */
 public abstract void set(String findFieldName,Object oIn) throws Exception;
 /**
  * @param findFieldName
  * @return index of Filed,-1 means not found
  *
  */
 protected int getFieldAt(String destFieldName){
  //return fieldName.indexOf(destFieldName);
    for(int i=0;i<fieldName.size();i++){
     if(((String)fieldName.get(i)).toLowerCase().equals(destFieldName.toLowerCase()))
       return i;
   }
   return -1;
 }
 /**
  * to allow client to get pk field for special need.
  * @return vector contains the pk fields
  */
 public Vector getPk(){
   return this.pk;
 }
 /**
  * required by Steven Cheng.since records are included in Vector,we have to
  * know the records count even select by paged condition.
  * @return the rows count without paging curson condition for current query.
  */
 public abstract int orgTotalRecordsCount();
 public String toString(){
    StringBuffer sb=new StringBuffer();
    sb.append("record src tbl is:");
    sb.append(tableName);
    sb.append(";data contents are:");
    for(int i=0;i<fieldName.size();i++){
      sb.append(fieldName.get(i));
      sb.append("=");
      if(get(i)==null)
        sb.append("null");
        else
        sb.append(get(i).toString());
      //sb.append(get(i).toString());
      if(i!=(fieldName.size()-1))sb.append("|");
    }
    return sb.toString();
 }
 /**
  * methold to get the source table name of this record object
  * @return tablename which generating this record object
  */
 public String getSrcTableName(){
   return tableName;
 }
 public List getModifiedFields(){
   return modifiedFields;
 }
}
