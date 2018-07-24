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

public class DataBindChkBox extends DataBindGUIObject implements SwingMultiSelection{
  JCheckBox _jcbx[]=null;
  Vector _records=null;
  String pkField=null;
  Object orgChkValues[]=null;
  public DataBindChkBox(JPanel jpanel,Vector records,String showColumn,String matchColumn,Object obj2find) {
   super();
   HashMap hm=new HashMap();
   hm.put(matchColumn,obj2find);
   ini(jpanel,records,showColumn,hm);
  }
  public DataBindChkBox(JPanel jpanel,String fromCurrRecordField,Vector records,String showColumn,String matchColumn,Object obj2find) {
   super();
   _match2RecField= fromCurrRecordField;
   HashMap hm=new HashMap();
   hm.put(matchColumn,obj2find);
   ini(jpanel,records,showColumn,hm);
  }
  public DataBindChkBox(JPanel jpanel,Vector records,String showColumn,HashMap hm) {
    super();
    ini(jpanel,records,showColumn,hm);
  }
  public DataBindChkBox(JPanel jpanel,String fromCurrRecordField,Vector records,String showColumn,HashMap hm) {
    super();
    _match2RecField= fromCurrRecordField;
    ini(jpanel,records,showColumn,hm);
  }
  protected void ini(JPanel jpanel,Vector records,String showColumn,HashMap hm){
   _jcbx=UIHelper.Data2ChkBox(jpanel,records,showColumn,hm);
   _records =records;
   pkField=(String)((Record)_records.get(0)).getPk().get(0);
   orgChkValues=getSelectedValues();
  }
  public Object[] getSelectedValues(){
   return UIHelper.ChkBox2Data(_jcbx,_records,pkField);
  }
  public boolean isChanged(){
    Object tgtObj[]=getSelectedValues();
    if(orgChkValues.length!=tgtObj.length) return true;
    for(int i=0;i<orgChkValues.length;i++){
      Object obj=orgChkValues[i];
      if(!obj.equals(tgtObj[i])) return true;
    }
    return false;
  }
  public JComponent getGUIcomponent(){
    return _jcbx[0];
  }
}
