package exgui.jsp;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class JspDateTriSelect implements JspInputObject{
  StringBuffer sbOutput=new StringBuffer();
  public JspDateTriSelect(String formName,String inputName,
                           int yearStart,int yearsAgo,
                           java.sql.Date date2Ini) {
     int yearIni=util.MiscFunc.getYear(date2Ini);
     int monIni=util.MiscFunc.getMonth(date2Ini);
     int dayIni=util.MiscFunc.getDay(date2Ini);
     int maxMonthDay=util.MiscFunc.getMonthMaxDays(date2Ini);
     String inputYearName=inputName+"_Year";
     String inputMonthName=inputName+"_Month";
     String inputDayName=inputName+"_Day";
     //----prepare for the select of year object.-----------------------
     sbOutput.append("<select name=\"");
     sbOutput.append(inputYearName);sbOutput.append("\" ");
     sbOutput.append("onChange=\"changedate(document."); sbOutput.append(formName);
     sbOutput.append(".");sbOutput.append(inputYearName);sbOutput.append(",");
     sbOutput.append("document.");sbOutput.append(formName);sbOutput.append(".");
     sbOutput.append(inputMonthName);sbOutput.append(",");
     sbOutput.append("document.");sbOutput.append(formName);sbOutput.append(".");
     sbOutput.append(inputDayName);sbOutput.append(")\";>\n");
     for(int i=yearStart;i<(yearStart-yearsAgo);i++){
        sbOutput.append("<option value=\"");
        sbOutput.append(i);sbOutput.append("\"");
        if(i==yearIni)sbOutput.append(" selected");
        sbOutput.append(">");sbOutput.append(i);sbOutput.append("</option>\n");
     }
     sbOutput.append("</select>¦~&nbsp;\n");
     //----prepare for the select of month object.-----------------------
     sbOutput.append("<select name=\"");
     sbOutput.append(inputMonthName);sbOutput.append("\" ");
     sbOutput.append("onChange=\"changedate(document."); sbOutput.append(formName);
     sbOutput.append(".");sbOutput.append(inputYearName);sbOutput.append(",");
     sbOutput.append("document.");sbOutput.append(formName);sbOutput.append(".");
     sbOutput.append(inputMonthName);sbOutput.append(",");
     sbOutput.append("document.");sbOutput.append(formName);sbOutput.append(".");
     sbOutput.append(inputDayName);sbOutput.append(")\";>\n");
     for(int i=1;i<13;i++){
        sbOutput.append("<option value=\"");
        sbOutput.append(i);sbOutput.append("\"");
        if(i==monIni)sbOutput.append(" selected");
        sbOutput.append(">");sbOutput.append(i);sbOutput.append("</option>\n");
     }
     sbOutput.append("</select>¤ë&nbsp;");
     //----prepare for the select of day object.-----------------------
     sbOutput.append("<select name=\"");
     sbOutput.append(inputDayName);sbOutput.append("\" ");
     sbOutput.append("onChange=\"changedate(document."); sbOutput.append(formName);
     sbOutput.append(".");sbOutput.append(inputYearName);sbOutput.append(",");
     sbOutput.append("document.");sbOutput.append(formName);sbOutput.append(".");
     sbOutput.append(inputMonthName);sbOutput.append(",");
     sbOutput.append("document.");sbOutput.append(formName);sbOutput.append(".");
     sbOutput.append(inputDayName);sbOutput.append(")\";>\n");
     for(int i=1;i<maxMonthDay;i++){
        sbOutput.append("<option value=\"");
        sbOutput.append(i);sbOutput.append("\"");
        if(i==monIni)sbOutput.append(" selected");
        sbOutput.append(">");sbOutput.append(i);sbOutput.append("</option>\n");
     }
     sbOutput.append("</select>¤é&nbsp;");
  }
  public String getCheckJavaScript(){
      StringBuffer sb=new StringBuffer();
      sb.append("function changedate(yearInput, monthInput, dateInput){\n");
      sb.append("      var NumOfDays;\n");
      sb.append("      year1 = yearInput[yearInput.selectedIndex].value;\n");
      sb.append("      yearAD = parseInt(year1);\n ");
      sb.append("      monthSelected = monthInput.selectedIndex;\n");
      sb.append("   if (monthSelected == 1) {\n");
      sb.append("         if (yearAD%400 == 0) {\n");
      sb.append("              NumOfDays = 29; \n");
      sb.append("		} else if ((yearAD%4 ==0)&&(yearAD%100 != 0)) { \n");
      sb.append("			NumOfDays = 29; \n");
      sb.append("		} else { \n");
      sb.append("			NumOfDays = 28;\n");
      sb.append("		}\n");
      sb.append("	} else if ( (monthSelected == 3)||(monthSelected == 5)||(monthSelected == 8)||(monthSelected == 10) ) {\n");
      sb.append("		NumOfDays = 30;\n");
      sb.append("	} else { // 31 days in a month\n");
      sb.append("		NumOfDays = 31;\n");
      sb.append("	}\n");
      sb.append("\n");
      sb.append("	if (dateInput.selectedIndex >= NumOfDays)\n");
      sb.append("		dateInput.selectedIndex = NumOfDays - 1;\n");
      sb.append("\n");
      sb.append("	dateInput.length = NumOfDays;\n");
      sb.append(" 	for (k = 0;k < 9; k++) {\n");
      sb.append(" 		dateInput.options[k].text=(k+1);\n");
      sb.append("		dateInput.options[k].value=(k+1);\n");
      sb.append("	}\n");
      sb.append("	for (k = 9;k < NumOfDays; k++) {\n");
      sb.append("		dateInput.options[k].text=k+1;\n");
      sb.append("		dateInput.options[k].value=k+1;\n");
      sb.append("	}\n");
      sb.append("\n");
      sb.append("}\n");
      return sb.toString();
  }
  public String getJspOutput(){
    return sbOutput.toString();
  }
}