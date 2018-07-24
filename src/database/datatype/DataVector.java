package database.datatype;

import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DataVector extends Vector  {
  protected java.util.List fieldsNameList=new java.util.ArrayList();
  public DataVector() {
    super();
  }
  public void setFieldName(java.util.List fields){
    fieldsNameList.clear();
    fieldsNameList.addAll(fields);
  }
  public Object[] toArray(){
    Object objArr[]=new Object[size()];
    for(int i=0;i<size();i++){
      objArr[i]=get(i);
    }
    return objArr;
  }
  public Object get(int i){
    Record rec=(Record)super.get(i);
    if(rec.getFieldName().size()==0) rec.getFieldName().addAll(fieldsNameList);
    return rec;
  }
}
