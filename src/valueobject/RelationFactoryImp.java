package valueobject;
import database.*;
import database.datatype.*;
import java.util.*;
import java.sql.*;
/**
 * <p>Title: the implementator of RelationFactory interface.</p>
 * <p>Description: the implementator of RelationFactory interface,while creating this class</p>
 * you must check if you have  a table based on the following table schema:
 * create table relation_reg(
 *   this_class_name char(500),this_obj_pk char(500),
 *   container_class_name char(500),container_obj_pk char(500),
 *   container_pkfield char(500),
 *   pkfield char(500)
 * )
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class RelationFactoryImp implements RelationFactory {
  protected TableInterface _table;
  protected Encoder _enc;
  protected Hashtable usedTable=new Hashtable();
  private int createTableCount=0;
  private int reuseTableCount=0;
  private int threadCount=0;
  public RelationFactoryImp(TableInterface table) {
    _table=table;
    _enc=_table.getDataBase().getEncoder();
  }
  protected TableInterface getTable(Record rec) throws Exception{
     TableInterface tbl=(TableInterface)usedTable.get(rec.getSrcTableName());
     if(tbl!=null){
       reuseTableCount++;
       System.out.println("reuseing table:"+rec.getSrcTableName()+" reuse time:"+reuseTableCount);
       return tbl;
     }
     tbl=new CommonTable(rec.getSrcTableName(),_table.getDataBase(),pk2Field(rec.getPk()));
     usedTable.put(rec.getSrcTableName(),tbl);
     createTableCount++;
     System.out.println("create--"+rec.getSrcTableName()+"--create table count ="+createTableCount);
     return tbl;
  }
  protected TableInterface getTable(String tblName,String pkfield)throws Exception{
    TableInterface tbl=(TableInterface)usedTable.get(tblName);
    if(tbl!=null){
       reuseTableCount++;
       System.out.println("reuseing table:"+tblName+":"+reuseTableCount);
       return tbl;
    }
    tbl=new CommonTable(tblName,_table.getDataBase(),pkfield);
    usedTable.put(tblName,tbl);
     createTableCount++;
     System.out.println("create-->"+tblName+"--create table count ="+createTableCount);
    return tbl;
  }
  public void bindRelation(Record containerObj ,Record obj2bind) throws Exception{
      //b4 binding,check if already contains each other.
      if(contain(getComposedObject(obj2bind),containerObj))
        throw new Exception("recusive exception,child record contains parent record");

      //insert the relation into database.
     StringBuffer sb=new StringBuffer();
     sb.append("insert into relation_reg");
     sb.append("(this_class_name,this_obj_pk,container_class_name,container_obj_pk,container_pkfield,this_pkfield)");
     sb.append(" values ");
     sb.append("('");sb.append(obj2bind.getSrcTableName());sb.append("',");
     sb.append(_enc.encode(pk2String(obj2bind)));sb.append(",'");
     sb.append(containerObj.getSrcTableName());sb.append("',");
     sb.append(_enc.encode(pk2String(containerObj)));sb.append(",");
     sb.append(_enc.encode(pk2Field(containerObj.getPk())));sb.append(",");
     sb.append(_enc.encode(pk2Field(obj2bind.getPk())));
     sb.append(")");
     System.out.println("bind relation sql is :"+sb.toString());
     _table.exeSQL(sb.toString());
  }
  public void unbindRelation(Record containerObj,Record obj2Unbind)throws Exception{
     //also,we need to delete the sub tree of obj2Unbind.
     deleteRegTable(containerObj,obj2Unbind);
     deleteTree(getComposedObject(obj2Unbind));
  }
  protected void deleteRegTable(Record containerObj,Record obj2Unbind)throws Exception{
     //delete relation record
     StringBuffer sb=new StringBuffer();
     sb.append("delete from relation_reg where ");
     sb.append(" this_class_name ='");sb.append(obj2Unbind.getSrcTableName());sb.append("'");
     sb.append(" and ");
     sb.append(" this_obj_pk =");
     sb.append(_enc.encode(pk2String(obj2Unbind)));
     sb.append(" and container_class_name='");
     sb.append(containerObj.getSrcTableName());sb.append("' and container_obj_pk =");
     sb.append(_enc.encode(pk2String(containerObj)));
     System.out.println("unbind relation sql is:"+sb.toString());
     _table.exeSQL(sb.toString());
  }
    public void deleteTree(ValueObjectInterface obj2Kill) throws Exception{
     Record rec=obj2Kill.getRecord();
     Vector atts=obj2Kill.getComponents();
     for(int i=0;i<atts.size();i++){
          if(atts.get(i) instanceof database.datatype.Record){
          deleteRegTable(rec,(Record)atts.get(i));
          killRealRecord((Record)atts.get(i));
       }else{
          deleteRegTable(rec,((ValueObjectInterface)atts.get(i)).getRecord());
          deleteTree((ValueObjectInterface)atts.get(i));
       }
     }
     killRealRecord(rec);
  }
  protected void killRealRecord(Record rec)throws Exception{
     //TableInterface tempTable=new CommonTable(rec.getSrcTableName(),_table.getDataBase(),pk2Field(rec.getPk()));
     TableInterface tempTable=getTable(rec);
     tempTable.deleteRecord(rec);
  }
  public ValueObjectInterface getCurChildComposedObject(Record rec)throws Exception{
     ValueObjectImp valueobjectimp=new ValueObjectImp(rec);
     Vector childObj=getChild(rec);//get child record objects
     for(int i=0;i<childObj.size();i++){
       Record recTmp=(Record)childObj.get(i);
       if(hasChild(recTmp.getSrcTableName(),pk2String(recTmp)))
          childObj.set(i,new ValueObjectImp(recTmp));//insert the fake valueobject,latter to request to fullfill
      //new Thread(new RecordThread(childObj,i,(Record)childObj.get(i),i)).start();
     }
    /*
     while(getThreadCount()>0){
       Thread.yield();
       System.out.println("------------------waiting RecordThread to finish--------------");
     };
     */
     valueobjectimp.attributes=childObj;
     return valueobjectimp;
  }
  synchronized int getThreadCount(){
    return threadCount;
  }
  class RecordThread implements java.lang.Runnable {
    Vector recVct;
    int eleAt;
    Record _rec;
    int myNumber=0;
    protected RecordThread(Vector vct2put,int i,Record rec,int no){
      recVct=vct2put;eleAt=i;
      _rec=rec;
      myNumber=no;
    }
    synchronized void pluseCount(){
      threadCount++;
    }
    synchronized void minuseCount(){
      threadCount--;
    }

    public void run(){
      pluseCount();
      System.out.println("============================thread No."+myNumber+" begin" );
        try{
         if(hasChild(_rec.getSrcTableName(),pk2String(_rec)))
         recVct.set(eleAt,new ValueObjectImp(_rec));
        }catch(Exception e){
          e.printStackTrace();
        }
      minuseCount();
      System.out.println("================================thread No."+myNumber+" Ends" );
    }
  }
  protected boolean hasChild(String tableName,String pk2value)throws Exception{
     boolean Result=false;
     StringBuffer sb=new StringBuffer();
     sb.append("select count(*) asGetCount from ");
     sb.append(_table.getTableName());
     sb.append(" where container_class_name= ?");
     //sb.append(" where container_class_name= '");
     //sb.append(tableName);
     //sb.append("' and container_obj_pk=");
     //sb.append(_enc.encode(pk2value));
     sb.append(" and container_obj_pk=?");
     Database db=_table.getDataBase();
     Connection con=db.getConnection();
     PreparedStatement pstm=con.prepareStatement(sb.toString());
     pstm.setString(1,tableName);
     pstm.setString(2,pk2value);
     Statement stm=con.createStatement();
     //ResultSet rs=stm.executeQuery(sb.toString());
     ResultSet rs=pstm.executeQuery();
     rs.next(); if(rs.getInt(1)>0) Result=true;
     rs.close();
     //stm.close();
     pstm.close();
     db.freeConnection(con);
     return Result;
  }
  public ValueObjectInterface getComposedObject(Record valueObjRec)throws Exception{
     //compose the value object recursively,
     //since every value object is composed by record and its attatched(related) records
     ValueObjectImp valueobjectimp=new ValueObjectImp(valueObjRec);
     valueobjectimp.attributes=getChild(valueObjRec);
     for(int i=0;i<valueobjectimp.attributes.size();i++){
       ValueObjectInterface tempvalueobject=getComposedObject((Record)valueobjectimp.attributes.get(i));
       if(tempvalueobject.getComponents().size()>0)
          valueobjectimp.attributes.set(i,tempvalueobject);
        else
          valueobjectimp.attributes.set(i,tempvalueobject.getRecord());
     }
     return valueobjectimp;
  }
  protected Vector getChild(Record rec)throws Exception {
       StringBuffer sb=new StringBuffer();
       sb.append("container_class_name='");
       sb.append(rec.getSrcTableName());
       sb.append("'");
       sb.append(" and ");
       sb.append("container_obj_pk=");
       sb.append(_enc.encode(pk2String(rec)));
       Vector records=_table.findRecordsByCondition(sb.toString());
       Vector tgtVct=new Vector();
       if(records!=null){
        for(int i=0;i<records.size();i++){
         Record tempRec=(Record)records.get(i);
         TableInterface tempTable=getTable((String)tempRec.get("this_class_name"),(String)tempRec.get("this_pkfield"));//new CommonTable((String)tempRec.get("this_class_name"),_table.getDataBase(),(String)tempRec.get("this_pkfield"));
         Vector resultVct=tempTable.findRecordsByCondition((String)tempRec.get("this_obj_pk"));
         //TableInterface tempTable=getTable((String)tempRec.get(0),(String)tempRec.get(6));
         //Vector resultVct=tempTable.findRecordsByCondition((String)tempRec.get(1));

         if(resultVct!=null)tgtVct.addAll(resultVct);
         }
       }
      return tgtVct;
  }

  /**
   * to find out the parent nodes(Record,stored in vector) which contains this tree.
   * @param valueObj--current object.
   * @return vector,the last element is the top node of parent,and the 1st elements is the parent node of parametered value object
   * @throws Exception--null exception or exceptions caused by sub processes.
   */

  public Vector getContainersRecordChain(Record valueObj)throws Exception{
       //frind out container class from relation registration table.
       Record tempRec=valueObj;
       String thisClassName=tempRec.getSrcTableName();
       String thisObjPk=pk2String(tempRec);
       Vector tgtVct=new Vector();
       Vector tempVct=new Vector();
       do{
         StringBuffer sqlsb=new StringBuffer();
         sqlsb.append("this_class_name='");
         sqlsb.append(thisClassName);
         sqlsb.append("' and this_obj_pk=");
         sqlsb.append(_enc.encode(thisObjPk));
         tempVct=_table.findRecordsByCondition(sqlsb.toString());
         if(tempVct==null) return null;
         if(tempVct.size()==0) break;
         tempRec=(Record)tempVct.get(0);
         /*
         tgtVct.add(
           (Record)
           ((getTable((String)tempRec.get(2),(String)tempRec.get(7))
           .findRecordsByCondition((String)tempRec.get(3))).get(0))
         );
          */
         tgtVct.add(
           (Record)
           ((getTable((String)tempRec.get("container_class_name"),(String)tempRec.get("container_pkfield"))
           .findRecordsByCondition((String)tempRec.get("container_obj_pk"))).get(0))
         );
           /*
           (Record)
           (new CommonTable(
           (String)tempRec.get("container_class_name"),_table.getDataBase(),(String)tempRec.get("container_pkfield")
           ).findRecordsByCondition((String)tempRec.get("container_obj_pk"))).get(0)
           */

         thisClassName=(String)tempRec.get("container_class_name");
         thisObjPk=(String)tempRec.get("container_obj_pk");
         /*
         thisClassName=(String)tempRec.get(2);
         thisObjPk=(String)tempRec.get(3);
          */
       }while(tempVct.size()>0);
       return tgtVct;
  }
  /**
   * to test if record is contained in valueobject
   * @param valueObj,the matrix to find
   * @param rec2compare .the object to compare.
   * @return if valueObject have the node which contains the record to find.
   * @throws Exception--null exception or sql exception from other sub process.
   */
  public boolean contain(ValueObjectInterface valueObj,Record rec2compare)throws Exception {
      String pk2string2cmp=rec2compare.getSrcTableName()+"||"+ pk2String(rec2compare);
      Vector components=valueObj.getComponents();
      boolean cmpResult=false;
      if((valueObj.getRecord().getSrcTableName()+"||"+ pk2String(valueObj.getRecord())).equals(pk2string2cmp)){
         return true;
      }
      for(int i=0;i<components.size();i++){
        if(components.get(i) instanceof database.datatype.Record ){
          Record tempRec=(Record)components.get(i);
          cmpResult= pk2string2cmp.equals(tempRec.getSrcTableName()+"||"+pk2String(tempRec));
          if(cmpResult) break;
        }else if(components.get(i) instanceof valueobject.ValueObjectInterface ){
          cmpResult= contain((ValueObjectInterface)components.get(i),rec2compare);
          if(cmpResult) break;
        }
      }
      return cmpResult;
  }
  /**
   * to findout the valueobjectinterface which contains a record object<br>
   * @param valueObj--object to search<br>
   * @param rec2find--record to find out.<br>
   * @return ValueObjectInterface,which is the sub tree of the parameter--valueObj contains the recod,if null,means not find in this tree object.
   * @throws Exception--sql exception or null exception.<br>
   */
  public ValueObjectInterface getContainObj(ValueObjectInterface valueObj,Record rec2find )throws Exception{
       if(recordCompare(valueObj.getRecord(),rec2find)) return valueObj;
       Vector attribs=valueObj.getComponents();
       for(int i=0;i<attribs.size();i++){
         if(attribs.get(i) instanceof database.datatype.Record ){
           if(recordCompare((Record)attribs.get(i),rec2find)) return valueObj;
         }else{
           ValueObjectInterface tempObj=getContainObj((ValueObjectInterface)attribs.get(i),rec2find);
           if(tempObj!=null) return tempObj;
         }
       }
       return null;
  }
  /**
   * assume table name is an attribue name,we also can find out the record under this object.
   * @param tableName--the table name to find.
   * @param valueobj--the valueobjectinterface object to search
   * @return Records in vector,which's source table name is parametered as tablename
   * @throws Exception--sql exception.or null exception
   */
  public Vector getRecordsByTableName(ValueObjectInterface valueobj,String tableName)throws Exception{
    Vector tgtVct=new Vector();
    if(valueobj.getRecord().getSrcTableName().equalsIgnoreCase(tableName)) tgtVct.add(valueobj.getRecord());
    Vector attrib=valueobj.getComponents();
    for(int i=0;i<attrib.size();i++){
      if(attrib.get(i) instanceof database.datatype.Record){
        if(((Record)attrib.get(i)).getSrcTableName().equalsIgnoreCase(tableName)) tgtVct.add(valueobj.getRecord());
      }else{
        tgtVct.addAll(getRecordsByTableName((ValueObjectInterface)attrib.get(i),tableName));
      }
    }
    return tgtVct;
  }
  protected Vector getPKField2Value(Record rec){
     Vector pkVct=rec.getPk();
     Vector toValue=new Vector();
     try{
       for(int i=0;i<pkVct.size();i++)
          toValue.add(rec.get((String)pkVct.get(i)));
     }catch(Exception ei){
       ei.printStackTrace();
       util.ExceptionLog.exp2File(ei,"exp while getPKField2Value");
     }
     return toValue;
  }
  protected String pk2Field(Vector pk){
     StringBuffer sb=new StringBuffer();
     for(int i=0;i<pk.size();i++){
        sb.append((String)pk.get(i));
        if(i<pk.size()-1)sb.append(",");
     }
     return sb.toString();
  }
  protected String pk2String(Record rec){
     Vector pkVct=rec.getPk();
     StringBuffer sb=new StringBuffer();
     for(int i=0;i<pkVct.size();i++){
        try{
          String fieldName=(String)pkVct.get(i);
          sb.append("(");
          sb.append(fieldName);
          sb.append(" = ");
          sb.append(_enc.encode(rec.get(fieldName)));
          sb.append(")");
          if(i<(pkVct.size()-1)) sb.append(" and ");
        }catch(Exception eof){
          util.ExceptionLog.exp2File(eof,"exp while RelationFactoryImplementator generate pk2string");
          break;
        }
     }
     return sb.toString();
  }
  protected boolean recordCompare(Record src,Record dest){
    return (src.getSrcTableName()+"||"+pk2String(src)).equals(dest.getSrcTableName()+"||"+pk2String(dest));
  }
}