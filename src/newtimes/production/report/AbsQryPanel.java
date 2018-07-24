package newtimes.production.report;

import java.awt.*;
import javax.swing.JPanel;
import java.util.List;
import exgui.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

abstract public class AbsQryPanel extends JPanel {
protected java.util.List  dataBindComps=new java.util.ArrayList();
protected String reportName="";
protected java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy,MM,dd");
protected abstract void genDataBindObj();
 protected java.util.HashMap composeParameters(){
   java.util.HashMap hm=new java.util.HashMap();
   for(int i=0;i<dataBindComps.size();i++){
     exgui.SwingSingleSelection  slkObj=(exgui.SwingSingleSelection)dataBindComps.get(i);
     Object objPara=slkObj.getSelectedValue();
     String key=((DataBindGUIObject)slkObj).getOrgRecField();
     hm.put(key,convert2QueryPara(objPara));
   }
   return hm;
 }
 protected void JButtonQueryButtonAction(java.awt.event.ActionEvent e){
   try{
     java.util.HashMap hm=composeParameters();
     generateReport(hm,reportName);
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
   }
 }
 protected void generateReport(java.util.HashMap paraHm,String reportName)throws Exception{
   try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
   /*
    newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt(
     reportName ,null,paraHm);
   */
    com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer;
        //new com.inet.viewer.ReportViewerBean();
        //util.PublicVariable.inet_report_viewer;
  newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,reportName,paraHm);
  /*
   viewer.setReportName("http://rpt.nttpe.com.tw:9000/file:///d://rpt//"+reportName);
   java.util.Iterator itr=paraHm.keySet().iterator();
   while(itr.hasNext()){
     String keyObj=(String)itr.next();
     Object value=paraHm.get(keyObj);
     viewer.setReportParameter(keyObj,(value==null)?"":value.toString());
   }
   */

    viewer.setHasGroupTree(false);
    //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
    viewer.start();
    javax.swing.JPanel tempPanel=new javax.swing.JPanel();
    tempPanel.setLayout(new java.awt.BorderLayout());
    tempPanel.add(viewer);
    processhandler.template.Properties.getSplitFrame().setLowerPanel(tempPanel);
    processhandler.template.Properties.getSplitFrame().validate();
    processhandler.template.Properties.getSplitFrame().repaint();
  }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }

 }
 protected String convert2QueryPara(Object obj){
   if(obj==null) return "ALL";
   if(obj instanceof String) return convertString2QueryPara((String)obj);
   if(obj instanceof java.sql.Date) return convertDate2QueryPara((java.sql.Date)obj);
   if(obj instanceof java.util.Date){
     return convertDate2QueryPara(new java.sql.Date(((java.util.Date)obj).getTime()));
   }
   return convertString2QueryPara(obj.toString());
 }
 protected String convertString2QueryPara(String paraStr) {
   if(paraStr==null) return "";
   return ""+util.MiscFunc.Replace(paraStr,"'","''")+"";
 }
 protected String convertDate2QueryPara(java.sql.Date  paraDate) {
   if(paraDate==null)return "";
   /*
   int dateYear=util.MiscFunc.getYear(paraDate);
   int dateMon=util.MiscFunc.getMonth(paraDate);
   int dateDay=util.MiscFunc.getDay(paraDate);
   */
   String dateStr=df.format(paraDate);
   StringBuffer sb=new StringBuffer();
   sb.append("DATE(");
   sb.append(dateStr);
   sb.append(")");
   return sb.toString();
 }
}
