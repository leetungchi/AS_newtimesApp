package exgui;
import java.util.Vector;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DataBindEditableJCombobox extends DataBindJCombobox {
  protected int contentLengthLimit=0;
  public DataBindEditableJCombobox(JComboBox jcbx,
                                   Vector records,
                                   String showColumn,
                                   String matchColumn,
                                   Object select2value,
                                   String iniString,
                                   String iniStringValue,
                                   int maxlength) {
    super(jcbx,
          records,
          showColumn,
          matchColumn,
          select2value,
          iniString,
          iniStringValue);
    setMaxLength(maxlength,select2value);

  }
  public DataBindEditableJCombobox(JComboBox jcbx,
                                   String fromCurrRecordField,
                                   Vector records,
                                   String showColumn,
                                   String matchColumn,
                                   Object select2value,
                                   String iniString,
                                   String iniStringValue,
                                   int maxlength) {
    super(jcbx,
          fromCurrRecordField,
          records,
          showColumn,
          matchColumn,
          select2value,
          iniString,
          iniStringValue);
    _jcbx.setSelectedItem(select2value);
    setMaxLength(maxlength,select2value);

  }
  public DataBindEditableJCombobox(JComboBox jcbx,
                                   Vector records,
                                   String showColumn,
                                   String matchColumn,
                                   Object select2value,
                                   int maxlength) {
    super(jcbx,
          records,
          showColumn,
          matchColumn,
          select2value);
    _jcbx.setSelectedItem(select2value);
    setMaxLength(maxlength,select2value);
  }
  public DataBindEditableJCombobox(JComboBox jcbx,
                                   String fromCurrRecordField,
                                   Vector records,
                                   String showColumn,
                                   String matchColumn,
                                   Object select2value,
                                   int maxlength) {
    super(jcbx,
          fromCurrRecordField,
          records,
          showColumn,
          matchColumn,
          select2value);
    _jcbx.setSelectedItem(select2value);
    setMaxLength(maxlength,select2value);
  }
  protected void setMaxLength(int maxLength,Object select2value){
    javax.swing.text.JTextComponent txtcmp= ((javax.swing.text.JTextComponent)_jcbx.getEditor().getEditorComponent());
    txtcmp.setDocument(new LimitedStyledDocument(maxLength));
    txtcmp.setText((select2value==null)?"":select2value.toString());
    contentLengthLimit=maxLength;
  }
  public boolean isValidx(){
    Object obj=this.getSelectedValue();
    if(obj!=null){
      if(obj.toString().trim().getBytes().length>contentLengthLimit)
        return false;
    }
    return true;
  }
  public class LimitedStyledDocument extends DefaultStyledDocument {
     int maxCharacters;

     public LimitedStyledDocument(int maxChars) {
         maxCharacters = maxChars;
     }

     public void insertString(int offs, String str, AttributeSet a)
         throws BadLocationException {
         if(null==str)return;
         //This rejects the entire insertion if it would make
         //the contents too long. Another option would be
         //to truncate the inserted string so the contents
         //would be exactly maxCharacters in length.
         if ((getLength() + str.length()) <= maxCharacters)
             super.insertString(offs, str, a);
         else
             Toolkit.getDefaultToolkit().beep();
     }
  }
}
