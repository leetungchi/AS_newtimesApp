package newtimes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.inet.viewer.*;
import com.inet.viewer.*;
public class ReportFrame extends JFrame {
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  MyReportDataSig myeng;
  JPanel pnlButtons = new JPanel();
  JPanel pnlCenter = new JPanel();
  JButton btn4JJ = new JButton();
  JButton btnSC = new JButton();
  BorderLayout borderLayout2 = new BorderLayout();
  //Construct the frame
  public ReportFrame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception  {
    this.setSize(new Dimension(750, 300));
    this.setTitle("Frame Title");
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    btn4JJ.setText("FabricReport");
    btn4JJ.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn4JJ_actionPerformed(e);
      }
    });
    btnSC.setText("SC REPORT");
    btnSC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSC_actionPerformed(e);
      }
    });
    pnlCenter.setLayout(borderLayout2);
    contentPane.add(pnlButtons,  BorderLayout.SOUTH);
    contentPane.add(pnlCenter, BorderLayout.CENTER);
    pnlButtons.add(btn4JJ, null);
    pnlButtons.add(btnSC, null);
  }
 public void setReport4Report2(){
   ReportViewerBean viewer=new ReportViewerBean();
   viewer.setHasGroupTree(false);
    if(myeng==null){
         myeng=new MyReportDataSig();
    }
   //java.sql.Date adate=util.MiscFunc.toDate235959(2003,12,5);
   myeng.setReportName("SC_DOC.rpt");
   //database.encoders.OracleEncoder orcEnc=new database.encoders.OracleEncoder();
   //myeng.setSQL("select * from V_REPORT4JJ  where 1=1 and ISSUE_DATE>"+orcEnc.encode(adate));
   myeng.setSQL("select * from V_ORDER_DOC where PROD_HEAD_PK=15");
   myeng.engineExecute();
   viewer.setReportData(myeng);
   viewer.start();
   pnlCenter.removeAll();
   pnlCenter.add(viewer);
 }
 public void setReport4JJ(){
   ReportViewerBean viewer=new ReportViewerBean();
   viewer.setHasGroupTree(false);
    if(myeng==null){
         myeng=new MyReportDataSig();
    }
   //java.sql.Date adate=util.MiscFunc.toDate235959(2003,12,5);
   myeng.setReportName("culp_prod.rpt");
   //database.encoders.OracleEncoder orcEnc=new database.encoders.OracleEncoder();
   //myeng.setSQL("select * from V_REPORT4JJ  where 1=1 and ISSUE_DATE>"+orcEnc.encode(adate));
   myeng.setSQL("select a.* from V_REPORT4JJ a  where  1=1 and Maker_name like 'TIA%'");
   myeng.engineExecute();
   viewer.setReportData(myeng);
   viewer.start();
   pnlCenter.removeAll();
   pnlCenter.add(viewer);
 }
  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      myeng=null;
      System.gc();//foce call beans's finalize process
      System.exit(0);
    }
  }
  class MyReportDataSig  implements com.inet.viewer.ReportDataSig {
    //API at:"file://D:\CrystalClear_Doc\Doc\apiSpec\com\inet\viewer\ReportDataSig.html"
    /**
     * We capture the changed report file so that we can set the same
     * file will be used for the export engine.
     **/
    newtimesejb.report3.Report3Facade ejb=null;
    MyReportDataSig(){
      try{
         newtimesejb.report3.Report3FacadeHome ejbhome=
             (newtimesejb.report3.Report3FacadeHome)
             info_ejb.WeblogicServiceLocator.locateServiceHome(
                 "p.nttpe.com.tw",
                "newtimesejb.report3.Report3Facade");
          ejb=ejbhome.create();
      }catch(Exception e){
        e.printStackTrace();
      }
    }
   /*
     byte[] getExportData(java.lang.String format, int page)
              This method returns export data of one page for the Java Viewer in the format specified by exportFormat.
     byte[] getGroupTree(int type, int requestID)
              Returns the group tree which can be send to the java viewer bean.
     int getPageCount()
              Returns the number of pages in the report.
     byte[] getPageData(int page)
              This method returns the binary data of one page for the Java Viewer.
     java.lang.String getReportName()
              When the viewer requests the report name again, it will inquire it via this method.
     void setReportName(java.lang.String name)
              Whenever the report name changes, the java viewer will pass down the new report name and the parameters it requires.
   */
     public void engineExecute(){
       try{
         System.out.println("calls execute");
         ejb.engineExecute();
       }catch(Exception e){
         e.printStackTrace();
       }
     }
     public void setSQL(String sql){
       try{
         System.out.println("setSQL");
         ejb.setSQL(sql);
       }catch(Exception e){
         e.printStackTrace();
       }
     }
     public int getExportCount(String str){
       return 0;
     }
     public  byte[] getExportData(java.lang.String format, int page)throws Exception{
       System.out.println("calles getExportData with format"+format);
      return ejb.getExportData(format,page);
     }
     public byte[] getGroupTree(int type, int requestID)throws Exception{
       System.out.println("calles gettree with type:"+type+",with requestID"+requestID);
       return ejb.getGroupTree(type,requestID);
     }
     public int getPageCount()throws Exception{
       System.out.println("calls getPageCount");
       return ejb.getPageCount();
     }
     public byte[] getPageData(int page)throws Exception{
       System.out.println("calls getPageData:"+page);
       return ejb.getPageData(page);
     }
     public String getReportName(){
       try{
         System.out.println("calls getReportName");
         return ejb.getReportName();
       }catch(Exception e){
         e.printStackTrace();
         return null;
       }
     }
     public void setReportName(String reportUrl){
       try{
         System.out.println("calls setPageName:"+reportUrl);
         ejb.setReportName(reportUrl);
       }catch(Exception e){
         e.printStackTrace();
       }
     }
     protected  void finalize() throws Throwable{
         ejb.remove();
         System.out.println("calls ejb remove");
    }
  }

  void btn4JJ_actionPerformed(ActionEvent e) {
    setReport4JJ();
  }

  void btnSC_actionPerformed(ActionEvent e) {
    setReport4Report2();
  }
}
