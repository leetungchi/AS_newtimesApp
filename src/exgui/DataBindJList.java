package exgui;
import javax.swing.*;
import java.util.Vector;
import java.util.HashMap;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DataBindJList extends DataBindGUIObject implements SwingMultiSelection {
  JList _jlist=null;
  Vector _records=null;
  String pkField=null;
  int orgSelectedInt[]=null;
  public DataBindJList(JList jlist,Vector records,String showColumn,String matchColumn,Object selectValue){
    super();
    HashMap hm=new HashMap();
    hm.put(matchColumn,selectValue);
    ini(jlist,records,showColumn,matchColumn,hm);
  }
  public DataBindJList(JList jlist,String fromCurrRecordField,Vector records,String showColumn,String matchColumn,Object selectValue){
    super();
    _match2RecField= fromCurrRecordField;
    HashMap hm=new HashMap();
    hm.put(matchColumn,selectValue);
    ini(jlist,records,showColumn,matchColumn,hm);
  }
  public DataBindJList(JList jlist,Vector records,String showColumn,HashMap hm){
    super();
    ini(jlist,records,showColumn,null,hm);
  }
  public DataBindJList(JList jlist,String fromCurrRecordField,Vector records,String showColumn,HashMap hm){
    super();
    _match2RecField= fromCurrRecordField;
    ini(jlist,records,showColumn,null,hm);
  }
  protected void ini(JList jlist,Vector records,String showColumn,String matchColumn,HashMap hm){
    if(records!=null||records.size()>0){
      UIHelper.Data2JList(jlist,records,showColumn,hm);
      _jlist=jlist;
      _records=records;
      if(matchColumn==null){
        pkField = (String)((Record)_records.get(0)).getPk().get(0);
      }else{
        pkField=matchColumn;
      }
      orgSelectedInt = _jlist.getSelectedIndices();
    }else{
      _jlist.removeAll();
      pkField=null;
      _records=null;
    }
  }
  public Object[] getSelectedValues(){
    if(pkField==null)return null;
    return UIHelper.Jlist2Data(_jlist,_records,pkField);
  }
  public boolean isChanged(){
    int xntInt[]=_jlist.getSelectedIndices();
    if(xntInt.length!=orgSelectedInt.length) return true;
    for(int i=0;i<xntInt.length;i++){
      if(xntInt[i]!=orgSelectedInt[i]) return true;
    }
    return false;
  }
  public JComponent getGUIcomponent(){
    return _jlist;
  }

}
