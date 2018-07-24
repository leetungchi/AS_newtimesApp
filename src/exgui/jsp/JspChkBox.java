package exgui.jsp;
import database.datatype.*;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class JspChkBox extends JspFormObj implements JspInputObject{
  public JspChkBox(String formName,String inputName,Vector records,String showColumName,Vector objs,int itmesCountInEachRow) {
    super(records,showColumName);
    sbOutput.append("<input type=\"checkbox\" name=\"");
    sbOutput.append(inputName);sbOutput.append("\"");
    headString=sbOutput.toString();
    sbOutput=new StringBuffer();
    try{
       Vector _objs=(Vector)util.MiscFunc.deepCopy(objs);
      int i=0;
      while(i<=records.size()){
        for(int j=0;j<itmesCountInEachRow;j++){
          sbOutput.append(headString);
          sbOutput.append(" value=\"");
          Record rec=(Record)records.get(i);
          sbOutput.append(rec.get(pkFieldPxn).toString());
          sbOutput.append("\"");
          if(isChecked(rec,_objs))sbOutput.append(" checked>");
          sbOutput.append(rec.get(showColumnPxn).toString());
          i++;
          if(i>records.size()) break;
          sbOutput.append("&nbsp;");
        }
        sbOutput.append("<br></br>");
        sbOutput.append("\n");
      }
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while combine records to jsp chekbox :"+formName+"."+inputName);
    }
  }
  public String getCheckJavaScript(){
    //at least ,select one object...or left it into submit handler.
    return null;
  }
  public String getJspOutput(){
    return sbOutput.toString();
  }
 protected boolean isChecked(Record rec,Vector objs){
    if(objs==null) return false;
    java.util.HashMap hm=new java.util.HashMap();
    boolean reslut=false;
    for(int i=0;i<objs.size();i++){
     hm.put(pkField,objs.get(i));
     if(util.MiscFunc.isHashMapInRecod(rec,hm)){
       objs.remove(i);
       reslut=true;
       break;
       //remove the object in vector,to speed up next matches
     }
    }
   return reslut;
 }
}