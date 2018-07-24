package database.datatype;
import java.util.*;
import database.*;
/**
 * Title:TableInterface
 * Description:this interface incldue main function of table object
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author:Crazy John(John Cheng)
 * @version 1.0
 */

public interface TableInterface {
  /**
   * @return the uesing Database object in this table object
   */
  public Database getDataBase();
  /**
   *@return the table name
   */
  public String getTableName();
  /**
   * to see if a column is readyonly in a table object(such as "counter column" in MS Access database)
   * @param columnName to find
   * @return if the column is ready only or not.
   */
  public boolean isColumnReadOnly(String columnName);
  /**
   * @return columns' name  of this table in vector
   */
   public  Vector getColumns();
  /**
   *to determ the pk column name,for findBYpk to use.
   * @param pkColumnsName ,can be combined by ",",such as "c1,c2,c3"
   */
  public void setPKColumns(String pkColumns);
   /**
   * same as setPKColumns"(String pkColumns)"
   * but store pk columns in vector.
   * @param pkColumnsName.
   */
  public void setPKColumns(Vector pkColumnsName);
  /**
   * @return pk columns string ,such as "pk1,pk2..."
   */
  public String getPKColumns();
  /**
   * @param rec --record for updateRecord Process
   * @exception java.sql.SQLException
   */
  public  void updateRecord(Record rec) throws java.sql.SQLException ;
  /**
   * @param rec record for insertRecord Process
   * @exception java.sql.SQLException
   */
  public  void insertRecord(Record rec) throws java.sql.SQLException ;
  /**
   * @param rec record for updateRecord Process
   * @exception java.sql.SQLException
   */
  public  void deleteRecord(Record rec) throws java.sql.SQLException ;
  /**
   * @return a blank record but with column names stored inside.
   */
  public  Record newRecord();
  /**
   * to get vector of record from this table by whereString condition.
   * @param whereString
   * @return vector after query result,if null,means exception while quering.
   */
  public  Vector findRecordsByCondition(String whereString);
  /**
   * same as findRecordsByCondition(String whereString),but limite with begin row and row length.
   * @param whereString String for find by
   * @param StartRowPosition int
   * @param vectorLength int.
   * @return vector with records,null while exception in qeury.
   */
  public  Vector findRecordsByCondition(String whereString,int startRowPosition,int vectorLength);

  /**
   * @param columnsAndValues ,for this parameter,please put column name as key and the condition-value as value
   *                 ,latter will be composed "col1=value1 and col2=value2 and col3=value3"
   * @return Vector with records,null while exception in qeury.
   */
  public  Vector findRecordsByColumns(HashMap columnsAndValues);
  /**
   * same as findRecordsByColumns(HashMap columnsAndValues),and able to sort by column
   * @param columnsAndValues :contans key and value for "and" condition.
   * @param orderByColumnName,the column name for order by
   * @param descOrNot ,to " desc " or not
   * @return Vector contains sorted record,if null means exception caused while query.
   */
  public  Vector findRecordsByColumns(HashMap columnsAndValues,String orderByColumnName,boolean descOrNot);
  /**
   * @param properties contains column name and value for search .
   * @param startRowPosition ,the start row position.
   * @param vectorLength ,the maxlength for return vector.
   * @return vector with records,null while exception in qeury.
   */
  public  Vector findRecordsByColumns(HashMap columnsAndValues,int startRowPosition,int vectorLength);

  /**
   * @param properties contains column name and value for search ,such as put("colum1","1"),means " column1 = 1"
   * @param startRowPosition
   * @param vectorLength to limit the maxsize of returned vector.
   * @param orderByColumnName,the column name for order by
   * @descOrNot ,to pluse " desc " at end of the query or not
   * @return vector with sorted records,null while exception in qeury.
   */
  public  Vector findRecordsByColumns(HashMap columnsAndValues,int startRowPosition,int vectorLength,String orderByColumnName,boolean descOrNot);
  /**
   * to get a record according the PK columns and values,by sequecially input value according the sequence of pk column
   *@param PKvalues : the vector contanins values according to sequence of pk columns
   *@return a reord ,or null means  exception while querying.
   */
  public  Record findRecordByPk(Vector PKvalues) throws java.sql.SQLException;
  /**
   *to get a record pk value equals to parameter--"value",also,can be composed by ","
   *@param value ,value for "pk" to find.
   *@return record if any record pk columns contains value
   */
  public  Record findRecordByPk(String value) throws java.sql.SQLException;
  /**
   *to get a record pk value equals to parameter--"value"
   *@param value ,value for "pk" to find.
   *@return record if any record pk columns contains value
   */
  public  Record findRecordByPk(int value) throws java.sql.SQLException;

  /**
   *to get a record pk value equals to parameter--"value"
   *@param value ,value for "pk" to find.
   *@return record if any record pk columns contains value
   */
  public  Record findRecordByPk(long value) throws java.sql.SQLException;

  /**
   * @return all recrods of this table;
   */

  public  Vector findAll();
    /**
     * @return some records for paged findAll
     * @param startRowPosition int
     * @param returnVectorLength int
     * @return vector
     */
  public  Vector findAll(int startRowPosition,int vectorLength);
  /**
   * @param orderByColumnName
   * @param descOrNot
   * @return all recrods of this table,but sorted
   */
  public  Vector findAll(String orderByColumnName,boolean DescOrNot);
    /**
     * @param StartRowPosition int
     * @param returnVectorLength int
     * @param orderByColumnName
     * @param DescOrNot
     * @return some records for paged findAll
     */
  public  Vector findAll(int startRowPosition,int vectorLength,String orderByColumnName,boolean DescOrNot);
     /**
      * @param sql is resultset wait for conversion as findby function's need.
      * @return vector ,if null means exception in while query.
      */
  public  Vector SQL2Records(String sql);
   /**
    * allow client class get records object(stored in vector) with specified start row postion and row counts
    * @param sql--sql to generate sql
    * @param startAt--row start at position
    * @param vctLength--row count
    * @return records stored in vector.
    */
  public Vector SQL2Records(String sql,int startAt,int vctLength);

     /**
      * to run sql statement by this table object
      * @param sql--sql statement to run
      * @throws SQLException
      */
  public void exeSQL(String sql) throws java.sql.SQLException ;
}