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

public class JspRadioButton extends JspFormObj implements JspInputObject{
  public JspRadioButton(String formName,String inputName,Vector records,String showColumName,Object matchObj,int itmesCountInEachRow){
    super(records,showColumName);
    sbOutput.append("<input type=\"radiobutton\" name=\"");
    sbOutput.append(inputName);sbOutput.append("\"");
    headString=sbOutput.toString();
    sbOutput=new StringBuffer();
    try{
      int i=0;
      while(i<=records.size()){
        for(int j=0;j<itmesCountInEachRow;j++){
          sbOutput.append(headString);
          sbOutput.append(" value=\"");
          Record rec=(Record)records.get(i);
          String pkObj2String=rec.get(pkFieldPxn).toString();
          sbOutput.append(pkObj2String);
          sbOutput.append("\"");
          if(matchObj==null && i==0){
            sbOutput.append(" checked>");
          }else{
          if(pkObj2String.equalsIgnoreCase(matchObj.toString()))
            sbOutput.append(" checked>");
          }
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
}