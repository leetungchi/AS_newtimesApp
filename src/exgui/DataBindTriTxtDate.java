package exgui;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.Toolkit;
import javax.swing.text.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DataBindTriTxtDate extends DataBindGUIObject  implements SwingSingleSelection {
  public JTextField _txtYear ,_txtMonth,_txtDay;
  protected java.sql.Date orgDate=null;
  public DataBindTriTxtDate(JTextField yearField,JTextField monthField,JTextField dayField,String originalRecordField) {
     super();
     iniProcess(yearField,monthField,dayField,originalRecordField );
  }
  public DataBindTriTxtDate(JTextField yearField,JTextField monthField,JTextField dayField,String originalRecordField,java.util.Date utilDate) {
     super();
     iniProcess(yearField,monthField,dayField,originalRecordField );
     if(utilDate!=null)
       setDate(new java.sql.Date(utilDate.getTime()));
  }
  public DataBindTriTxtDate(JTextField yearField,JTextField monthField,JTextField dayField,String originalRecordField,java.sql.Date date) {
     super();
     iniProcess(yearField,monthField,dayField,originalRecordField );
     setDate(date);
  }

  protected void iniProcess(JTextField yearField,JTextField monthField,JTextField dayField,String originalRecordField ){
     _match2RecField=originalRecordField;
     _txtYear=yearField;_txtMonth=monthField;_txtDay=dayField;
     _txtYear.setNextFocusableComponent(_txtMonth);
     _txtMonth.setNextFocusableComponent(_txtDay);
     _txtYear.setDocument(new LimitedStyledDocument(4));
     _txtMonth.setDocument(new LimitedStyledDocument(2));
     _txtDay.setDocument(new LimitedStyledDocument(2));
     _txtYear.setText("");_txtMonth.setText("");_txtDay.setText("");
  }
  public void setDate(java.util.Date utilDate){
    setDate(new java.sql.Date(utilDate.getTime()));
  }
  public void setDate(java.sql.Date date){
     if(date!=null){
       _txtYear.setText(String.valueOf(util.MiscFunc.getYear(date)));
       _txtMonth.setText(String.valueOf(util.MiscFunc.getMonth(date)));
       _txtDay.setText(String.valueOf(util.MiscFunc.getDay(date)));
     }
  }
  public JComponent getGUIcomponent() {
    /**@todo: implement this exgui.DataBindGUIObject abstract method*/
    return _txtYear;
  }
  public boolean isChanged() {
    /**@todo: implement this exgui.DataBindGUIObject abstract method*/
    if(orgDate==null){
      return !( getSelectedValue()==null);
    }
    return (!orgDate.equals(getSelectedValue()));
  }
  public Object getSelectedValue(){
     String yStr,mStr,dStr;
     yStr=_txtYear.getText().trim();
     mStr=_txtMonth.getText().trim();
     dStr=_txtDay.getText().trim();
     int yI=0; int mI=0;int dI=0;
     if(
        yStr.equals("") &&
        mStr.equals("") &&
        dStr.equals("")
      ) return null;
     try{
       if( Integer.parseInt(yStr)<0|| yStr.length()>4 ){
         exgui.verification.VerifyLib.showAllert("year format is error");
         _txtYear.grabFocus();
         return new Integer(-1);
       }
       yI=Integer.parseInt(yStr);
     }catch(Exception eY){
         exgui.verification.VerifyLib.showAllert("year format is error");
         _txtYear.grabFocus();
         return new Integer(-1);
     }

     try{
       if( Integer.parseInt(mStr)>12||Integer.parseInt(mStr)<1){
         exgui.verification.VerifyLib.showAllert("month format is error");
         _txtMonth.grabFocus();
         return new Integer(-1);
       }
       mI=Integer.parseInt(mStr);
     }catch(Exception eM){
         exgui.verification.VerifyLib.showAllert("month format is error");
         _txtMonth.grabFocus();
         return new Integer(-1);
     }
     try{
       dI=Integer.parseInt(dStr);
     }catch(Exception eD){
         exgui.verification.VerifyLib.showAllert("day format is error");
         _txtDay.grabFocus();
         return new Integer(-1);
     }
     if(mStr.length()==1) mStr="0"+mStr;
     if(dStr.length()==1) dStr="0"+dStr;
     if(!exgui.verification.VerifyLib.is8DgtDate(yStr+"/"+mStr+"/"+dStr)){
         exgui.verification.VerifyLib.showAllert("date format is error");
         _txtDay.grabFocus();
        return new Integer(-1);
     }
     return util.MiscFunc.toDate(yI,mI,dI);
  }
 public class LimitedStyledDocument extends DefaultStyledDocument {
    int maxCharacters;

    public LimitedStyledDocument(int maxChars) {
        maxCharacters = maxChars;
    }

    public void insertString(int offs, String str, AttributeSet a)
        throws BadLocationException {

        //This rejects the entire insertion if it would make
        //the contents too long. Another option would be
        //to truncate the inserted string so the contents
        //would be exactly maxCharacters in length.
        if(null==str)return;
        if ((getLength() + str.length()) <= maxCharacters)
            super.insertString(offs, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
}


}
