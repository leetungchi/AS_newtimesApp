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

public class JspSelect extends JspFormObj implements JspInputObject {
  public JspSelect(String formName,String inputName,Vector records,String showColumName,Object matchObj){
    super(records,showColumName);
    sbOutput.append("<select name=\"");
    sbOutput.append(inputName);sbOutput.append("\">\n");
    headString=sbOutput.toString();
    sbOutput=new StringBuffer();
    sbOutput.append(headString);
    try{
        for(int j=0;j<records.size();j++){
          sbOutput.append("<option ");
          sbOutput.append(" value=\"");
          Record rec=(Record)records.get(j);
          String pkObj2String=rec.get(pkFieldPxn).toString();
          sbOutput.append(pkObj2String);
          sbOutput.append("\"");
          if(matchObj!=null && pkObj2String.equalsIgnoreCase(matchObj.toString())){
            sbOutput.append(" selected");
          }
          sbOutput.append(">");
          sbOutput.append(rec.get(showColumnPxn).toString());
          sbOutput.append("</option>");
          sbOutput.append("\n");
        }
        sbOutput.append("</select>");
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while combine records to jsp chekbox :"+formName+"."+inputName);
    }
  }
}