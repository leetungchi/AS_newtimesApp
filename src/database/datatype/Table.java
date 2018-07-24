package database.datatype;
import java.sql.*;
import database.*;
import util.*;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
/**
 * Title:Abstract Table class.
 * Description:this class just implements some TableInterface methold,others, let the concret child class to do.
 * Copyright:    Copyright (c) 2001
 * Company:  inforich.com.tw
 * @author :Crazy John
 * @version 1.0
 */

public abstract class Table implements TableInterface{
  String tableName;
  Vector pk=new Vector();
  Vector columns=new Vector();
  Hashtable columnReadOnly=new Hashtable();
  Database db;//for transaction usage.
  /**
   * @param pkColumnsName is vector stored the column name,for findByPk to use
   */
  public void setPKColumns(Vector pkColumnsName){
    pk=pkColumnsName;
  }
  public Record findRecordByPk(long value) throws java.sql.SQLException{
    Vector v1=new Vector();
    v1.add(new Long(value));
    return findRecordByPk(v1);
  }
  public Record findRecordByPk(int value)throws java.sql.SQLException{
    Vector v1=new Vector();
    v1.add(new Integer(value));
    return findRecordByPk(v1);
  }
  public Record findRecordByPk(String value) throws java.sql.SQLException{
    Vector v1=new Vector();
     StringTokenizer st=new StringTokenizer(value,",");
     while(st.hasMoreTokens()){
       v1.add(st.nextToken());
     }
    v1.add(value);
    return findRecordByPk(v1);
  }
  /**
   * @return pk columns string ,such as "pk1,pk2..."
   */
  public String getPKColumns(){
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<pk.size();i++){
       sb.append((String)pk.get(i));
       if(i<(pk.size()-1)) sb.append(",");
    }
   return sb.toString();
  }

}