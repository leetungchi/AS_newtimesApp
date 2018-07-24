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

public class DataBindJCombobox extends DataBindGUIObject implements SwingSingleSelection{
  JComboBox _jcbx=null;
  Vector _records=null;
  String pkField=null;
  String _iniString=null;
  String _iniStringValue=null;
  Object orgObj=null;
  boolean forcedChangedFlag=false;
  public DataBindJCombobox(JComboBox jcbx,Vector records,String showColumn,String matchColumn,Object select2value,String iniString,String iniStringValue) {
      super();
      HashMap hm=new HashMap();
      pkField=matchColumn;
      hm.put(matchColumn,select2value);
      ini(jcbx,records,showColumn,hm,iniString,iniStringValue);
      //if(jcbx.isEditable())
      //jcbx.setSelectedItem(select2value);
      orgObj = select2value;
  }
  public DataBindJCombobox(JComboBox jcbx,String fromCurrRecordField,Vector records,String showColumn,String matchColumn,Object select2value,String iniString,String iniStringValue) {
      super();
      HashMap hm=new HashMap();
      pkField=matchColumn;
      _match2RecField=fromCurrRecordField;
      hm.put(matchColumn,select2value);
      ini(jcbx,records,showColumn,hm,iniString,iniStringValue);
      //if(jcbx.isEditable())
      //jcbx.setSelectedItem(select2value);
      orgObj = select2value;
  }
  public DataBindJCombobox(JComboBox jcbx,Vector records,String showColumn,String matchColumn,Object select2value) {
      super();
      HashMap hm=new HashMap();
      pkField=matchColumn;
      hm.put(matchColumn,select2value);
      ini(jcbx,records,showColumn,hm,null,null);
      //if(jcbx.isEditable())
      //jcbx.setSelectedItem(select2value);
      orgObj = select2value;
  }
  public DataBindJCombobox(JComboBox jcbx,String fromCurrRecordField,Vector records,String showColumn,String matchColumn,Object select2value) {
      super();
      _match2RecField=fromCurrRecordField;
      pkField=matchColumn;
      HashMap hm=new HashMap();
      hm.put(matchColumn,select2value);
      ini(jcbx,records,showColumn,hm,null,null);
      //if(jcbx.isEditable())
        //jcbx.setSelectedItem(select2value);
        orgObj = select2value;
  }
  public DataBindJCombobox(JComboBox jcbx,String fromCurrRecordField,Vector records,String showColumn,HashMap hm) {
      super();
      _match2RecField=fromCurrRecordField;
      ini(jcbx,records,showColumn,hm,null,null);
      //orgObj = getSelectedValue();
  }
  protected void ini(JComboBox jcbx,Vector records,String showColumn,HashMap hm,String iniString,String iniStringValue) {
    jcbx.removeAllItems();
    UIHelper.Data2ComboBox(jcbx,records,showColumn,hm,iniString,iniStringValue );
    _iniString=iniString;
    _iniStringValue=iniStringValue;
    _jcbx=jcbx;_records=records;
    if(_records.size()>0 && pkField==null){
      Record rec=(Record)_records.get(0);
      pkField=(String)rec.getPk().get(0);
    }
  }
public Object getSelectedValue(){
    if(_jcbx.isEditable()){
      return _jcbx.getSelectedItem();
    }
    if(_jcbx.getSelectedIndex()==-1&& _jcbx.getItemCount()==0)return _iniStringValue;
    if(_jcbx.getSelectedIndex()==-1&& _jcbx.getItemCount()>0){
       _jcbx.setSelectedIndex(0);
     }
    if(_iniString !=null){
     if(_jcbx.getSelectedIndex()==0)
       return _iniStringValue;
      else
       return getObjByIndexRocords(_jcbx.getSelectedIndex()-1,pkField);
   }else{
     return UIHelper.ComboBox2Data(_jcbx,_records,pkField);
   }
  }
  protected Object getObjByIndexRocords(int selectedIndex,String pkField){
    try{
      if(_records==null ||_records.size()==0)return _iniStringValue;
      if(selectedIndex<0)selectedIndex=0;
      return  ((Record)_records.get(selectedIndex)).get(pkField);
    }catch(Exception e){
     e.printStackTrace();
     util.ExceptionLog.exp2File(e,"exp while getting stored object value in jcombobox");
     return null;
    }
  }
  public void toMustModify(){
    forcedChangedFlag=true;
  }
  public boolean isChanged(){
     //return true;//force to write to data,

     Object rtnObj=getSelectedValue();
     //if(orgObj==null) return rtnObj!=null;
     boolean changed= util.MiscFunc.isEqual(orgObj,rtnObj);  //!orgObj.equals(rtnObj);
     if(!changed){
       //if forcedChangedFlag is setup,means this column is force to update.
       if(forcedChangedFlag){
         forcedChangedFlag=false;
         return true;
       }
       return false;
     }else{
       forcedChangedFlag=false;
       return changed;
     }

  }
  public JComponent getGUIcomponent(){
    return _jcbx;
  }
}
