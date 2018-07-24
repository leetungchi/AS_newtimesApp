package exgui.ultratable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Wraper4tblCbx implements java.io.Serializable{
  String toString;
  Object value;
  public Wraper4tblCbx(){}
  public Wraper4tblCbx(Object _value,String _toString) {
    toString=_toString;
    value=_value;
  }
  public void setValue(Object _value){value=_value;}
  public void setString(String _toString){toString=_toString;}
  public Object getValue(){return value;}
  public String toString(){return toString;}
  public boolean equals(Object obj2cmp){
    if(obj2cmp instanceof exgui.ultratable.Wraper4tblCbx){
      if(value==null && ((Wraper4tblCbx)obj2cmp).value==null) return true;
      if(value==null && ((Wraper4tblCbx)obj2cmp).value!=null) return false;
      if(value!=null && ((Wraper4tblCbx)obj2cmp).value==null) return false;

     return ((Wraper4tblCbx)obj2cmp).value.toString().trim().equalsIgnoreCase(
          value.toString().trim());
    }else{
      return super.equals(obj2cmp);
    }
  }
}