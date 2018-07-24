package newtimes.production.report;
import java.util.HashMap;
public class ReportProxyEngine implements com.inet.viewer.ReportDataSig {
    //API at:"file://D:\CrystalClear_Doc\Doc\apiSpec\com\inet\viewer\ReportDataSig.html"
    /**
     * We capture the changed report file so that we can set the same
     * file will be used for the export engine.
     **/
   public  newtimesejb.report3.Report3Facade ejb=null;
   public long lastCallTime=0L;
   public long SESSION_TIMEOUT_SEC=300000000L;//5 minute
   protected String storedSQL;
   protected java.util.HashMap promptHm;
   protected String pureReportFileName;
   public static String reportServerURL="http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";
  public ReportProxyEngine() {
    try{
      createReportEJB();
      lastCallTime=System.currentTimeMillis();
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"Exception whlie attemp to creat report engine proxy");
      exgui.verification.VerifyLib.showAlert(
      "EJB Exception While creating Report Server Object\n"+
      "Please Contact System Manager",
      "Report3Mdl creat Error");
    }
  }
  /**
   * direct set properties of report engins,and calls execute of report to generate report data
   * @param pureRptName String
   * @param sql String
   * @param prmptHm HashMap
   * @throws Exception
   */
  public void directCallEngine2Xqt(
              String pureRptName,
              String sql,
              HashMap prmptHm) throws Exception{
      this.storedSQL=sql;
      this.pureReportFileName=pureRptName;
      this.promptHm=prmptHm;
      checkOk();
      ejb.setReportName(pureRptName);
      System.out.println("report name is:"+pureRptName);
      //if(prmptHm!=null)ejb.setPromptProperty(prmptHm);
      ejb.setPromptProperty(prmptHm);
      System.out.println("sql is :"+sql);
      ejb.setSQL(sql);
      ejb.engineExecute();
     lastCallTime=System.currentTimeMillis();
  }
  public boolean checkOk()throws Exception{
    try{
      boolean ok=ejb.isOk();//the value is always true,
      //remote interface always throws remote exception ,such as NoObjectFound....
      return true;
    }catch(java.rmi.RemoteException re){
      try{
        createReportEJB();
        return ejb.isOk();
      }catch(Exception e){
        exgui.verification.VerifyLib.showAlert(
        "Report Remote Engine crate Fail!!\nPlease Notify System Manager",
        "EJB Create Fail");
        throw e;
      }
    }
     /*
     long xntTime=System.currentTimeMillis();
     if(xntTime-lastCallTime>=SESSION_TIMEOUT_SEC){
       try{
         ejb.remove();
       }catch(java.rmi.RemoteException remoteExp){
       }catch(javax.ejb.RemoveException re){
       }
       createReportEJB();
     }
     */
  }
  private void createReportEJB()throws Exception{
    newtimesejb.report3.Report3FacadeHome ejbhome=
        (newtimesejb.report3.Report3FacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.REPORT_SERVER_AT,
            "newtimesejb.report3.Report3Facade");
        ejb=ejbhome.create();
  }
  public void engineExecute(){
    try{
      System.out.println("calls execute");
      ejb.engineExecute();
      lastCallTime=System.currentTimeMillis();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public int getExportCount(String str){
    return 0;

  }
  public void setSQL(String sql){
    try{
      System.out.println("setSQL");
      ejb.setSQL(sql);
      lastCallTime=System.currentTimeMillis();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public  byte[] getExportData(java.lang.String format, int page)throws Exception{
    System.out.println("calles getExportData with format"+format);
    lastCallTime=System.currentTimeMillis();
   return ejb.getExportData(format,page);
  }
  public byte[] getGroupTree(int type, int requestID)throws Exception{
    System.out.println("calles gettree with type:"+type+",with requestID"+requestID);
    lastCallTime=System.currentTimeMillis();
    return ejb.getGroupTree(type,requestID);
  }
  public int getPageCount()throws Exception{
    System.out.println("calls getPageCount");
    lastCallTime=System.currentTimeMillis();
    return ejb.getPageCount();
  }
  public byte[] getPageData(int page)throws Exception{
    System.out.println("calls getPageData:"+page);
    lastCallTime=System.currentTimeMillis();
    return ejb.getPageData(page);
  }
  public String getReportName(){
    try{
      System.out.println("calls getReportName");
      lastCallTime=System.currentTimeMillis();
      return ejb.getReportName();
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public void setReportName(String reportUrl){
    try{
      System.out.println("calls setPageName:"+reportUrl);
      lastCallTime=System.currentTimeMillis();
      if(reportUrl.indexOf("?&")==-1){
        pureReportFileName=reportUrl;
        checkOk();
      }
      ejb.setReportName(reportUrl);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public static void setReportNameAndParas(com.inet.viewer.ReportViewerBean viewer, String reportName,java.util.HashMap paraHm)throws Exception{
    viewer.setReportName(reportServerURL+reportName);

    //get random as prameter for refresh
    java.util.Iterator itr=paraHm.keySet().iterator();
    while(itr.hasNext()){
      String keyObj=(String)itr.next();
      Object value=paraHm.get(keyObj);
      viewer.setReportParameter(keyObj,(value==null)?"":value.toString());
    }


  }
  public void setPromptHashMap(java.util.HashMap hm){
    try{
      System.out.println("calls set hashmap for prompt");
      lastCallTime=System.currentTimeMillis();
      ejb.setPromptProperty(hm);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public String saveOrderChangeRTF(int prod_seq,int version_no)throws Exception{
     return    ejb.save2rtf4OdrChg(prod_seq,version_no,
                        (String)util.PublicVariable.USER_RECORD.get("USR_CODE"));
  }
  protected  void finalize() throws Throwable{
      ejb.remove();
      System.out.println("calls ejb remove");
 }
}
