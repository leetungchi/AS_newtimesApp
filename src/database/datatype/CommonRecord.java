package database.datatype;
/**
 * Title:CommonRecord ,for table class to gernerate.
 * Description:concrete classs of Record class.
 * Copyright:    Copyright (c) 2001
 * Company:      inforich.com.tw
 * @author       Crazy John
 * @version 1.0
 */

public class CommonRecord extends Record {
  protected int orgRecordCount;
  //do not allow other object to new,just allow by DataBase package to operate.
  protected CommonRecord(String _tableName) {
    super();
    tableName=_tableName;
  }
  public Object get(int fieldIndex){
    return fieldValue.get(fieldIndex);
  }
  public Object get(String findFieldName) throws Exception {
    int fieldAt=getFieldAt(findFieldName.trim());
    if(fieldAt==-1) throw new Exception("field: \""+ findFieldName+"\" not found");
    return fieldValue.get(fieldAt);
  }
  protected void set_withoutCheck(int fieldIndex,Object oIn){
    fieldValue.set(fieldIndex,oIn);
  }
 public void set(int fieldIndex,Object oIn){
   //fieldValue.setElementAt(oIn,fieldIndex);
   fieldValue.set(fieldIndex,oIn);
   if(!modifiedFields.contains(new Integer(fieldIndex)))
       modifiedFields.add(new Integer(fieldIndex));
   dbProcessed=false;
 }
 public void set(String findFieldName,Object oIn) throws Exception{
   int fieldAt=getFieldAt(findFieldName);
   if(fieldAt==-1) throw new Exception("field :\""+ findFieldName+"\" not found");
   set(fieldAt,oIn);
 }
 public int orgTotalRecordsCount(){
  return orgRecordCount;
 }
}
