package exgui.jsp;
import database.datatype.Record;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class JspFormObj implements JspInputObject {
  java.util.ArrayList arrFields=null;
  int showColumnPxn=0;
  int pkFieldPxn=0;
  StringBuffer sbOutput=new StringBuffer();
  String headString=null;
  String pkField=null;
 protected JspFormObj(Vector records,String showColumn){
   arrFields=((Record)records.get(0)).getFieldName();
   showColumnPxn=getFieldPosition(showColumn);
   pkField=(String)((Record)records.get(0)).getPk().get(0);
   pkFieldPxn=getFieldPosition(pkField);
 }
 protected int getFieldPosition(String String2Cmp){
  for(int i=0;i<arrFields.size();i++){
    String xFld=(String)arrFields.get(i);
    if(xFld.equalsIgnoreCase(String2Cmp)) return i;
  }
  return -1;
 }
  public String getCheckJavaScript(){
     return null;
  }
  public String getJspOutput(){
    return sbOutput.toString();
  }

}