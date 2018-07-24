package exgui;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DataBindText extends DataBindGUIObject implements  SwingSingleSelection{
  protected Object _orgObj=null;
  protected javax.swing.text.JTextComponent _jtx;
  protected String orgText=null;
  public DataBindText(){}
  public DataBindText(javax.swing.text.JTextComponent jtx, String fromCurrRecordField,Object orgObj,int maxLength) {
    this.init(jtx,fromCurrRecordField,orgObj,maxLength);
  }
  protected void init(javax.swing.text.JTextComponent jtx, String fromCurrRecordField,Object orgObj,int maxLength){
    _orgObj=orgObj;
    _match2RecField=fromCurrRecordField;
    _jtx=jtx;
    _jtx.setDocument(new LimitedStyledDocument(maxLength));
    if(_orgObj!=null){
       _jtx.setText(_orgObj.toString());
       _jtx.setCaretPosition(0);
       orgText=_orgObj.toString();
    }else{
       _jtx.setText("");
       orgText="";
    }
  }
  public boolean isChanged() {
    if(_jtx==null) return true;
    if(!_jtx.getText().equals(orgText)) return true;
    return false;
  }
  public Object getSelectedValue(){
    return _jtx.getText();
  }
  public javax.swing.JComponent getGUIcomponent(){
    return _jtx;
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
