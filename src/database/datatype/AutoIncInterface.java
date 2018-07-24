package database.datatype;

/**
 * 20011219
 *
 *
 * Title:Interface with assign autoIncrease column
 * Description:able to get sequence value after insert.always for master to detail function.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author Crazy John(John.Cheng)
 * @version 1.0
 */

public interface AutoIncInterface extends TableInterface{
 /**
  * to insert record and return the counter (sequntially increaced integer)
  * @param record the record to insert;
  * @param sn2ColumnName the column name which the sequntially increaced integer should insert into
  * @return the sequecial value.
  * @exception if exception accourse in sql qeury
  */
 public long insertRecord(Record record,String sn2ColumnName)throws Exception ;
}