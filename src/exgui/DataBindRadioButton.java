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

public class DataBindRadioButton extends DataBindGUIObject  implements SwingSingleSelection{
  Vector _records;
  JRadioButton _jrbtn[];
  String pkField;
  Object orgObj=null;
  public DataBindRadioButton(JPanel jpanel,ButtonGroup btnGrp,Vector records,String showColumn,String matchColumn,Object obj2find){
    HashMap hm=new HashMap();
    hm.put(matchColumn ,obj2find );
    pkField=matchColumn;
    ini(jpanel,btnGrp,records,showColumn,hm);
  }
  public DataBindRadioButton(JPanel jpanel,ButtonGroup btnGrp,String fromCurrRecordField,Vector records,String showColumn,String matchColumn,Object obj2find){
    HashMap hm=new HashMap();
    _match2RecField=fromCurrRecordField;
    hm.put(matchColumn ,obj2find );
    pkField=matchColumn;
    ini(jpanel,btnGrp,records,showColumn,hm);
  }
  public DataBindRadioButton(JPanel jpanel,ButtonGroup btnGrp,Vector records,String showColumn,HashMap hm){
    ini(jpanel,btnGrp,records,showColumn,hm);
  }
  public DataBindRadioButton(JPanel jpanel,ButtonGroup btnGrp,String fromCurrRecordField,Vector records,String showColumn,HashMap hm){
    _match2RecField=fromCurrRecordField;
    ini(jpanel,btnGrp,records,showColumn,hm);
  }
  protected void ini(JPanel jpanel,ButtonGroup btnGrp,Vector records,String showColumn,HashMap hm){
    _jrbtn=UIHelper.Data2GrpButton(jpanel,btnGrp,records,showColumn,hm);
    _records=records;
    if(pkField==null)pkField=(String)((Record)_records.get(0)).getPk().get(0);
    orgObj=getSelectedValue();
  }
  public Object getSelectedValue(){
    return UIHelper.RadioButtons2Data(_jrbtn,_records,pkField);
  }
  public boolean isChanged(){
     Object rtnObj=getSelectedValue();
     if(orgObj==null) return rtnObj!=null;
     return !orgObj.equals(rtnObj);
  }
    public JComponent getGUIcomponent(){
    return _jrbtn[0];
  }

}
