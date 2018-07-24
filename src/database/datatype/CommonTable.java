package database.datatype;
import java.sql.*;
import java.util.*;
import util.*;
import database.*;
//import oracle.jdbc.rowset.OracleCachedRowSet;
/**
 * Title:CommonTable
 * Description:the concret class of Table class,implements all the function of TableInterface.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author John.Cheng.
 * @version 1.0
 */

public class CommonTable extends Table {
  /**
   * the basic Table class.
   * may support transaction if some tables using same Database object.
   * @param _tableName table name
   * @param _db database
   * @param _pkFieldName as pk field name, input value is "column1,column2,column3...."
   * @exception Exception while table not fund or not.
   */
  Record blankRecord=null;
  public CommonTable(String _tableName,Database _db,String _pkFieldName) throws Exception{
     //System.out.println("inptu pkfieldname value is:"+_pkFieldName);
     Vector _pkFieldsName=new Vector();
     StringTokenizer st=new StringTokenizer(_pkFieldName,",");
     while(st.hasMoreTokens()){
       _pkFieldsName.add(st.nextToken());
     }

     try{
       if((_pkFieldName==null) || (_pkFieldsName.size()==0)){
         //System.out.println("!!!!!!!!!!!pk fiels is not exist in common table!!!!!!!!!!!!!");
         throw new Exception("table object without pk field assigment in contructing table Object:\""+_tableName +"\"");
       }
       super.db =_db;
       super.tableName=_tableName;
       super.pk =_pkFieldsName;
       Connection con=db.getConnection();
       Statement stm=con.createStatement();
       ResultSet rs=stm.executeQuery("select * from "+tableName+" where 1<>1");
       ResultSetMetaData rsmd=rs.getMetaData();
       for(int i=0;i<rsmd.getColumnCount();i++){
          columns.add(rsmd.getColumnName(i+1));
          if(rsmd.isReadOnly(i+1))
             columnReadOnly.put(rsmd.getColumnName(i+1),new Integer("1"));
          else if(!rsmd.isReadOnly(i+1))
             columnReadOnly.put(rsmd.getColumnName(i+1),new Integer("-1"));
       }
       rs.close();stm.close();rs=null;stm=null;System.gc();
       db.freeConnection(con);
     }catch(java.sql.SQLException se){
        se.printStackTrace();
        util.ExceptionLog.exp2File(se,"Exception while creating common  table object:"+tableName);
        throw se;
     }

  }
  public void setPKColumns(String pkColumnsList){
    Vector _pkFieldsName=new Vector();
     StringTokenizer st=new StringTokenizer(pkColumnsList,",");
     while(st.hasMoreTokens()){
       _pkFieldsName.add(st.nextToken());
     }
     pk=_pkFieldsName;
  }
  public String getTableName(){
    return tableName;
  }
  public Database getDataBase(){
     return db;
  }
  public Vector getColumns(){
     return columns;
  }
  public boolean isColumnReadOnly(String fieldName){
    if(columnReadOnly.get(fieldName).toString().equals("-1")) return false;
    return true;
  }
  public void exeSQL(String sql) throws java.sql.SQLException {
    Connection con=null;
    boolean getConnectioned=false;
    try{
      con=db.getConnection();
      getConnectioned=true;
      Statement stm=con.createStatement();
      stm.execute(sql);
      stm=null;
      db.freeConnection(con);
      getConnectioned=false;
      con=null;
    }catch(java.sql.SQLException sqe ){
      if((con!=null) && getConnectioned){
         db.freeConnection(con);
         getConnectioned=false;
      }
      throw sqe;
    }finally{
      if((con!=null) && getConnectioned){
         db.freeConnection(con);
         getConnectioned=false;
      }
    }
  }
  protected boolean chkReady4Update(Record rec) throws java.sql.SQLException {
    //test if the record is duplicate or not existed in this table.
    if(rec.tableName==null)
      throw new java.sql.SQLException("record is not updateable:"+rec.toString());
    if(!rec.tableName.equalsIgnoreCase(this.tableName))
      throw new java.sql.SQLException("reocrd is not belong to this table,should belong to "+rec.tableName);
     //get pk field...
    Vector vct2Read=new Vector();
    try{
      for(int i=0;i<pk.size();i++){
        vct2Read.add(rec.get((String)pk.get(i)));
      }
      Record recChkTest=findRecordByPk(vct2Read);
      //check if the time stamp field is same as source record object
      /*
      if(rec.getDate("record_modify_date").equals(recChkTest.getDate("record_modify_date")))
        throws java.sql.SQLException("rocord you read is stalled,please re-read to check need modify or not");
      */
      //return (recChkTest!=null);
      if(recChkTest!=null)
         return true;
         else
         throw new RecordNotFoundException("record :"+rec.toString()+" not found");
    }catch(DuplicateKeyException eDup){
      throw eDup;
    }catch(RecordNotFoundException eRNF){
      throw eRNF;
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"getException while check if ready for update");
      return false;
    }
  }
  protected boolean chkReady4Insert(Record rec)throws java.sql.SQLException {
    //test if the record is duplicate or not existed in this table.
    if(rec.tableName==null)
      throw new java.sql.SQLException("record is not updateable:"+rec.toString());
    if(!rec.tableName.equalsIgnoreCase(this.tableName))
      throw new java.sql.SQLException("reocrd is not belong to this table,should belong to"+rec.tableName);
     //get pk field...
    Vector vct2Read=new Vector();

    try{
      for(int i=0;i<pk.size();i++){
        vct2Read.add(rec.get((String)pk.get(i)));
      }
      Record recChkTest=findRecordByPk(vct2Read);
      if(recChkTest!=null){
         throw new DuplicateKeyException("the record to insert while be duplicate:"+rec.toString());
       }
      return true;
     }catch(DuplicateKeyException eDk){
       throw eDk;
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"unknowen exception");
       return false;
     }

 }
  public void updateRecord(Record rec) throws java.sql.SQLException {
    StringBuffer sbSQL=new StringBuffer();
    //if(!chkReady4Update(rec)) throw new java.sql.SQLException("record is not ready for update:"+rec.toString());
    Connection con=null;
    boolean getConnectioned=false;
    try{
      StringBuffer sb=new StringBuffer();
      //Vector fields=rec.modifiedFields;
      rec.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));
      ArrayList fields=rec.modifiedFields;
      boolean toDo=false;
      for(int i=0;i<fields.size();i++){
        String searchFieldName=(String)(rec.getFieldName().get((Integer.parseInt(rec.modifiedFields.get(i).toString()))));
        if(!isColumnReadOnly(searchFieldName)){
          if(toDo) sb.append(",");
          sb.append(searchFieldName);sb.append("=");
          sb.append(db.encode(rec.get(searchFieldName)));
          toDo=true;
        }
      }
      if(toDo){
        sbSQL.append("update ");sbSQL.append(tableName);sbSQL.append(" set ");
        sbSQL.append(sb.toString());
        sbSQL.append( " where " );
        sbSQL.append(pkColumn2String(rec));
        System.out.println("sql of common table for update is:"+sbSQL.toString());
        con=db.getConnection();
        getConnectioned=true;
        Statement stm=con.createStatement();
        //boolean result=stm.execute(sbSQL.toString());
        stm.executeUpdate(sbSQL.toString());
        stm.close();db.freeConnection(con);
        getConnectioned=false;
        sb=null;stm=null;System.gc();
        rec.dbProcessed =true;
        rec.modifiedFields =new ArrayList();
        util.SqlLog.writeLog((String)rec.get("record_modify_user"),sbSQL.toString());
        sbSQL=null;
        //find out the modified column in rec objct
        //return result;
      }
      //return false;
    }catch(java.sql.SQLException sqlE ){
      if((con!=null)&& getConnectioned){
        db.freeConnection(con);
        getConnectioned=false;
       }
      sqlE.printStackTrace();
      util.ExceptionLog.exp2File(sqlE,"exception while update in table"+tableName+"; sql is:"+sbSQL.toString());
      throw sqlE;
    }catch(Exception e){
      if((con!=null) && getConnectioned){
        db.freeConnection(con);
        getConnectioned=false;
       }
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exception while update in table"+tableName+"; sql is:"+sbSQL.toString());
       throw new java.sql.SQLException("exp while update ");
    }
  }
  public void insertRecord(Record rec) throws java.sql.SQLException {
    StringBuffer sbSQL=new StringBuffer();
    //if(!chkReady4Insert(rec)) return;
    //if(!chkReady4Insert(rec)) throw new java.sql.SQLException("record is not ready to insert!! record is:"+rec.toString());
    boolean getConnectioned=false;
    Connection con=null;
    try{
      StringBuffer sb=new StringBuffer();
      //Vector fields=rec.modifiedFields;
      java.sql.Date createDate=new java.sql.Date(System.currentTimeMillis());
      rec.set("record_modify_date",createDate);
      rec.set("record_create_date",createDate);
      ArrayList fields=rec.modifiedFields;
      Vector insValues=new Vector();
      Vector insFields=new Vector();
      boolean toDo=false;
      for(int i=0;i<fields.size();i++){
        String searchFieldName=(String)(rec.getFieldName().get((Integer.parseInt(rec.modifiedFields.get(i).toString()))));
        if(!isColumnReadOnly(searchFieldName)){
          insFields.add(searchFieldName);
          insValues.add(db.encode(rec.get(searchFieldName)));
          toDo=true;
        }
      }
      if(toDo){
        sbSQL.append("insert into ");sbSQL.append(tableName);sbSQL.append("( ");
        for(int i=0;i<insFields.size();i++){
          sbSQL.append((String)insFields.get(i));
          sb.append(insValues.get(i));
          if(i<insFields.size()-1){
             sbSQL.append(",");
             sb.append(",");
          }
        }
        sbSQL.append(") values (");sbSQL.append(sb.toString());sbSQL.append(")");
        System.out.println("sql of common table for update is:"+sbSQL.toString());
        con=db.getConnection();
        getConnectioned=true;
        Statement stm=con.createStatement();
        //boolean result=stm.execute(sbSQL.toString());
        stm.executeUpdate(sbSQL.toString());
        stm.close();db.freeConnection(con);
        getConnectioned=false;
        sb=null;stm=null;System.gc();
        rec.modifiedFields =new ArrayList();
        rec.dbProcessed =true;
        util.SqlLog.writeLog((String)rec.get("record_create_user"),sbSQL.toString());
        sbSQL=null;
        //find out the modified column in rec objct
        //return result;
      }
      //return false;
    }catch(java.sql.SQLException sqlE ){
      if((con!=null) && getConnectioned){
        db.freeConnection(con);
        getConnectioned=false;
       }
      sqlE.printStackTrace();
      util.ExceptionLog.exp2File(sqlE,"exception while insert in table"+tableName+"; sql is:"+sbSQL.toString());
      throw sqlE;
    }catch(Exception e){
      if((con!=null)&&getConnectioned){
        db.freeConnection(con);
        getConnectioned=false;
       }
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exception while update in table"+tableName+"; sql is:"+sbSQL.toString());
      throw new java.sql.SQLException("exp while update ");
    }

  }

  public void deleteRecord(Record rec) throws java.sql.SQLException {
    Connection con=null;
    boolean getConnectioned=false;
    try{
      StringBuffer sb=new StringBuffer();
      sb.append("delete from ");sb.append(tableName);
      sb.append(" where ");sb.append(pkColumn2String(rec));
      con=db.getConnection();
      getConnectioned=true;
      Statement stm=con.createStatement();
      //boolean result=stm.execute(sb.toString());
      stm.executeUpdate(sb.toString());
      stm.close();stm=null;System.gc();
      db.freeConnection(con);
      getConnectioned=false;
      //return result;
      util.SqlLog.writeLog((String)rec.get("record_delete_user"),sb.toString());
    }catch(Exception e){
      if((con!=null)&& getConnectioned){
        db.freeConnection(con);
        getConnectioned=false;
      }
      util.ExceptionLog.exp2File(e,"exp while table:"+tableName+"deletting record");
      //return false;
      throw (java.sql.SQLException)e;
    }
  }
  public Record newRecord(){
    if(blankRecord==null){
     CommonRecord rec= new CommonRecord(tableName);
     for(int i=0;i<columns.size();i++){
      rec.fieldName.add(columns.get(i));
      rec.fieldValue.add(null);
     }
     rec.pk=pk;
      rec.dbProcessed=false;
      try{
        blankRecord = (Record) util.MiscFunc.deepCopy(rec);
      }catch(Exception epx){
        util.ExceptionLog.exp2File(epx,"");
        blankRecord=null;
        return rec;
      }
    }
    //return rec;
    return blankRecord;
  }
  public Vector findRecordsByCondition(String whereString){
     return findRecordsByCondition(whereString,1,-1);
  }
  public  Vector findRecordsByCondition(String whereString,int startRowPosition,int vectorLength){
     StringBuffer sb=new StringBuffer();
     sb.append("select * from ");
     sb.append(tableName);
     if(whereString!=null && whereString.trim().length()>1){
       sb.append(" where  ");
       sb.append(whereString);
     }
     //sb.append(whereString);
     return SQL2Records(tableName,sb.toString(),startRowPosition,vectorLength);
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues){
    return  findRecordsByColumns(columnsAndValues,1,-1);
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues,String orderByColumnName,boolean descOrNot){
     return findRecordsByColumns(columnsAndValues,1,-1,orderByColumnName,descOrNot);
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues,int startRowPosition,int vectorLength){
    return findRecordsByColumns(columnsAndValues,startRowPosition,vectorLength,null,false);
  }
  public Vector findRecordsByColumns(HashMap columnsAndValues,int startRowPosition,int vectorLength,String orderByColumnName,boolean descOrNot){
    StringBuffer sb=new StringBuffer();
    sb.append("select * from ");sb.append(tableName);sb.append(" where ");
    sb.append(linkColumnAndValue(columnsAndValues));
    if(orderByColumnName!=null){
      sb.append(" order by ");sb.append(orderByColumnName);
      if(descOrNot) sb.append(" desc ");
    }
    return SQL2Records(tableName,sb.toString(),startRowPosition,vectorLength);
  }
  public Record findRecordByPk(Vector PKvalues) throws java.sql.SQLException{
     HashMap hm=new HashMap();
     for(int i=0;i<pk.size();i++)
       hm.put(pk.get(i),PKvalues.get(i));
     Vector resultVct=findRecordsByColumns(hm);
     if(resultVct.size()==1) return (Record)resultVct.get(0);
     if(resultVct.size()>1)
        throw new DuplicateKeyException("duplication records appeard in find record process record object is "+((Record)resultVct.get(0)).toString());
        //throw new java.sql.SQLException("duplication records appeard in find record process record object is "+((Record)resultVct.get(0)).toString());

     return null;
  }
  public Vector findAll(){
  //System.out.println(this.db.toString());
    return findAll(1,-1);
  }
  public Vector findAll(int startRowPosition,int vectorLength){
     return findAll(startRowPosition,vectorLength,null,false);
  }
  public Vector findAll(String orderByColumnName,boolean DescOrNot){
      return findAll(1,-1,orderByColumnName,DescOrNot);
  }
  public Vector findAll(int startRowPosition,int vectorLength,String orderByColumnName,boolean DescOrNot){
     StringBuffer sb=new StringBuffer();
     sb.append("select * from ");sb.append(tableName);
     if(orderByColumnName!=null){
       sb.append(" order by ");
       sb.append(orderByColumnName);
       if(DescOrNot) sb.append(" desc ");
     }
     return SQL2Records(tableName,sb.toString(),startRowPosition,vectorLength);
  }
  public Vector SQL2Records(String sql){
    return SQL2Records(sql,1,-1);
  }
  public int getRowCount(ResultSet rs)throws  Exception{
    /*
    OracleCachedRowSet ocrs = new OracleCachedRowSet();
    ocrs.populate(rs);
    ocrs.last();
    Get the row position which is also the number of rows in the Cached RowSet.
   return  ocrs.getRow();
  */
  return 0;
  }
  private Vector SQL2Records(String tableName,String sql,int startAt,int vctLength){
     boolean getConnectioned=false;
     Connection con=null;
     try{
       con=db.getConnection();
       if(con==null){
          db.freeConnection(con);
          return null;
       }
       getConnectioned=true;
       Statement stm=null;
       stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
       ResultSet rs=stm.executeQuery(sql);
       System.out.println("final sql is:"+sql);
       int totalRowCount=0;
       if(startAt==1 &&
          (vctLength==999||
           vctLength==9999||
           vctLength==99999||
           vctLength==999999||
           vctLength==99999999||
           vctLength==999999999)){
         System.out.println("direct get total row count as :"+vctLength);
         totalRowCount=vctLength;
       }else{
         totalRowCount=getRowCount(sql);
         //totalRowCount=getRowCount(rs);
       }
       Vector outputVct= ResultSet2Records(tableName,rs,startAt,vctLength,totalRowCount);
       rs.close();
       //if(ocrs!=null)ocrs.close();
       stm.close();
       rs=null;stm=null;System.gc();

       db.freeConnection(con);
       getConnectioned=false;
       return outputVct;
     }catch(java.sql.SQLException sqe){
        if((con!=null) && getConnectioned){
          db.freeConnection(con);
          getConnectioned=false;
        }
        util.ExceptionLog.exp2File(sqe,"the sql to generate reccord is:"+sql);
        return null;
     }catch(Exception e){
         if((con!=null) && getConnectioned){
           db.freeConnection(con);
           getConnectioned=false;
         }
         util.ExceptionLog.exp2File(e,"the sql to generate reccord is:"+sql);
         e.printStackTrace();
         return null;
     }
  }
  public Vector SQL2Records(String sql,int startAt,int vctLength){
    return SQL2Records(null,sql,startAt,vctLength);
  }
  protected String pkColumn2String(Record rec){
     StringBuffer sbSQL=new StringBuffer();
     try{
      for(int i=0;i<pk.size();i++){
        sbSQL.append((String)pk.get(i));
        sbSQL.append("=");
        sbSQL.append(db.encode(rec.get((String)pk.get(i))));
        if(i!=pk.size()-1) sbSQL.append(" and ");
      }
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp in pkColumn2String,table is: "+tableName);
     }
     return sbSQL.toString();
  }

   protected Vector ResultSet2Records(ResultSet rs,int totalRowCount){
      return ResultSet2Records(rs,1,-1,totalRowCount);
   }
   /**
    * the shortcut of getting resultset from sql
    * required by project :wincell
    * @param string,SQL string to exeute
    * @return java.sql.ResultSet
    * @exception ,the java.sql.sqlException
    */
   public ResultSet getResultsetBySql(String sqlString) throws Exception{
      Connection con=null;
      boolean getConnectioned=false;
       try{
         con=db.getConnection();
         getConnectioned=true;
         Statement stm=con.createStatement();
         ResultSet rs=stm.executeQuery(sqlString);
         db.freeConnection(con);
         getConnectioned=false;
         return rs;
       }catch(Exception e){
         if(con!=null && getConnectioned) db.freeConnection(con);
         throw e;
       }
   }
   private int getRowCount(String sql)throws Exception {
     Connection con=null;
     try{
       con=db.getConnection();
       Statement stm=con.createStatement();
       ResultSet rs=stm.executeQuery("select count(*) as row_counts from("+sql+")");
       rs.next();
       int value2Return=rs.getInt(1);
       stm.close();
       return value2Return;
     }catch(Exception e){
       e.printStackTrace();
       throw e;
     }finally{
       if(con!=null)db.freeConnection(con);
     }
   }
   private  Vector ResultSet2Records(String tableName,ResultSet rs,
                                     int startAt,
                                     int vctLength,
                                     int totalRowCount){
     try{
         //Vector outVct=new Vector();
         DataVector outVct=new DataVector();
         ResultSetMetaData rsmd=rs.getMetaData();
         int columnCount=rsmd.getColumnCount();
         boolean ctrlLength=false;
         if(vctLength>0) ctrlLength=true;
         int xntLength=0;
         if(rs.next()){
           //find out max records even without paging function
           //rs.last();
           //int orgRowCount=rs.getRow();
           int orgRowCount=totalRowCount;
           if(startAt>orgRowCount) startAt=orgRowCount;
           rs.absolute(startAt);
           CommonRecord cRec=new CommonRecord(tableName);
           cRec.pk=pk;
           cRec.orgRecordCount=orgRowCount;
           CommonRecord  rec2dup=null;
           do{
             xntLength++;
             if(ctrlLength && xntLength>vctLength) break;
             //Record cRec=newRecord();
             if(rec2dup==null){
               rec2dup=(CommonRecord)util.MiscFunc.deepCopy(cRec);
               for(int i=0;i<columnCount;i++){
                     rec2dup.fieldName.add(rsmd.getColumnLabel(i+1));
                     rec2dup.fieldValue.add(null);
               }
             }
             CommonRecord rec2add=(CommonRecord)util.MiscFunc.deepCopy(rec2dup);
             outVct.setFieldName(rec2add.fieldName);
             for(int i=0;i<columnCount;i++){
               //rec2add.set(i,rs.getObject(i+1));
               rec2add.set_withoutCheck(i,rs.getObject(i+1));
             }
             //rec2add.modifiedFields.clear();
             outVct.add(rec2add);
           }while(rs.next());
         }
         return outVct;}
     catch(Exception e){
       util.ExceptionLog.exp2File(e,"exp while convert resultset to record vector");
       e.printStackTrace();
       return null;
     }
   }
   protected Vector ResultSet2Records(ResultSet rs,int startAt,int vctLength,int totalRowCount){
     return ResultSet2Records(null,rs,startAt,vctLength, totalRowCount);
   }
  /**
   * @param columns
   * @return SQL string  as (1=1) and ( a=234) and (c=123413) and (k is null).....
   */
  protected String linkColumnAndValue(HashMap columns){
    try{
        java.util.Set set= columns.entrySet();
        java.util.Iterator  iterator=set.iterator();
        StringBuffer sb=new StringBuffer();
        boolean haveDoen=false;
        sb.append("( 1 = 1 )");
        while(iterator.hasNext()){
           sb.append(" and ");
           Map.Entry me=(Map.Entry)iterator.next();
           sb.append("(");
           sb.append(me.getKey());
           if(me.getValue()==null ){
             sb.append(" is null ");
           }else if(me.getValue().getClass()==Class.forName("java.lang.String")){
             sb.append(" like ");
             sb.append(db.encode(me.getValue()));
           }else{
              sb.append( "=" );
              sb.append(db.encode(me.getValue()));
           }
           sb.append(")");
        }
        return sb.toString();
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"class not found exp while in linkColumnAndValue method,table name is"+tableName);
    }
    return null;
  }
}
