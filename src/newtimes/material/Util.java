package newtimes.material;

import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.util.Vector;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Util {
  private Util() {
  }
  /**
   * <p><B>(This function is for public use)</B></p>
   * @param RecList      : Vector of Record,  use this data to initialize JComboBox;
   * @param ColName      : Column(Field) Name, use this to specify values of this column of ReList
   * @param emptyAllowed : boolean, specify default EMPTY entry in the combo box.
   * @see                : database.datatype.Record
   * <p><B>Description:</B><BR>
   *   Say we had a Record called "rec", and it has 4 field : "NAME", "ADDR", "PHONE", "ETC"<BR>
   *    RecList is the Vector of the "rec"<BR>
   *   ColName can be either "NAME", "ADDR", "PHONE",  or "ETC".<BR>
   *<BR>
   *   if you write following code:<BR>
   *     <B>setComboValues(myComboBox, RecList, "NAME", true); </B><BR>
   *   then myCombobox will be filled with the values of "NAME" field of RecList,<BR>
   *   and first entry is empty.
   *   if you write this:<BR>
   *     <B>setComboValues(myComboBox, RecList, "NAME", false); </B><BR>
   *   then myCombobox will be filled with the values of "NAME" field of RecList,<BR>
   *   and there is no empty entry.
   * </p>
   */
  public static void setComboValues(JComboBox cbo, Vector RecList, String ColName, boolean emptyAllowed){
    if(cbo==null || RecList==null || ColName==null || ColName.equals("")) return;
    cbo.removeAllItems();
    try{
      if(emptyAllowed){
        cbo.addItem(new String(""));
      }
      for (int i = 0; i < RecList.size(); i++) {
        Record rec = (Record) RecList.get(i);
        cbo.addItem(rec.get(ColName));
      }
    }
    catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at Util.setComboValues()");
    }
  }

  /**
   * <p><B>(This function is for inner use, not for public )</B></p>
   * @param RecList : Vector of Record;
   * @param ColName : Column(Field) Name, use this to specify values of this column of ReList
   * @param Filter  : filter string(case ignored)
   * @return        : the Vector of the Records which match the filtering condition.
   * @see           : database.datatype.Record
   * <p><B>Description:</B><BR>
   *   Say we had a Record which is called "rec", <BR>
   *    and it has 4 fields : "NAME", "ADDR", "PHONE", "ETC"<BR>
   *    RecList is the Vector of the "rec"<BR>
   *   ColName can be either "NAME", "ADDR", "PHONE",  or "ETC".<BR>
   *<BR>
   *   if you do this:<BR>
   *     <B>Vector myVector = getSubRecList(RecList, "NAME", "A");</B><BR>
   *   then you will get myVector , and the value of "NAME" field of myVector<BR>
   *   will all begin with "A" or "a".<BR>
   *   So, if you write following code:<BR>
   *     <B>Vector myVector = getSubRecList(RecList, "ADDR", "BL");</B><BR>
   *   then you will get myVector ,and the values of "ADDR" field of myVector<BR>
   *   will all begin with "BL" or "bl" or "Bl" or "bL"<BR>
   * </p>
   */
  public static Vector getSubRecList(Vector RecList, String ColName, String Filter){
    if(Filter==null || Filter.equals("")) return RecList;
    Vector subList = new Vector();
    try{
      java.util.regex.Pattern p=
        java.util.regex.Pattern.compile(Filter.toLowerCase()+".*");

      for(int i=0; i<RecList.size(); i++){
        Record rec = (Record)RecList.get(i);
        String itemStr = ((String)rec.get(ColName)).trim();
        if((p.matcher(itemStr.toLowerCase()).matches())){
          subList.add(rec);
        }
      }
    }
    catch(java.util.regex.PatternSyntaxException pe){
      pe.printStackTrace();
      util.ExceptionLog.exp2File(pe, "unacceptable pattern string at Util.getSubRecList()");
    }
    catch(Exception e ){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at Util.getSubRecList()");
    }
    finally{
      return subList;
    }
  }

  public static boolean IsNumberKey(KeyEvent ke){
    char KeyChar=ke.getKeyChar();
    switch(KeyChar){
      case '0':case '1':case '2':case '3':case '4':
      case '5':case '6':case '7':case '8':case '9':
      case '\b':
        return true;
      default:
        return false;
    }
  }

  public static void filterNumInput(KeyEvent ke, String InputStr, int maxInput){
    //System.out.println(String.valueOf(ke.getKeyCode()));
    if(!String.valueOf(ke.getKeyChar()).equals(String.valueOf('\b'))){
      if (!IsNumberKey(ke))
        ke.consume();
      else if (InputStr.trim().length() == maxInput)
        ke.consume();
    }
  }

  //add by Chloe 2004.01.06
  public static void filterNumInput(KeyEvent ke, String InputStr){
    //System.out.println(String.valueOf(ke.getKeyCode()));
    if(!String.valueOf(ke.getKeyChar()).equals(String.valueOf('\b'))){
      if (!IsNumberKey(ke))
        ke.consume();
    }
  }

  public static void CheckInputLength(KeyEvent ke, String InputStr, int maxInput){
    //System.out.println(String.valueOf(ke.getKeyCode()));
    if(InputStr.trim().length()==maxInput && (ke.getKeyCode() != KeyEvent.VK_BACK_SPACE)){
      ke.consume();
      Toolkit.getDefaultToolkit().beep();
    }
  }

  public static void SearchMill(JComboBox cboMill, String pattern,
                                Vector oriList, Vector resultList,
                                boolean defaultEmpty)
  {
    newtimes.material.CONST.BYMK.EJB BYMK_EJB = null;
    pattern = pattern.trim();
    boolean isFirstEntryEmpty = false;
    if(pattern.equals("")){
      resultList = oriList;
      isFirstEntryEmpty = defaultEmpty;
    }else{
      resultList = Util.getSubRecList(oriList, BYMK_EJB.NAME, pattern);
      isFirstEntryEmpty = defaultEmpty;
    }
    Util.setComboValues(cboMill, resultList, BYMK_EJB.NAME,isFirstEntryEmpty);
  }



}