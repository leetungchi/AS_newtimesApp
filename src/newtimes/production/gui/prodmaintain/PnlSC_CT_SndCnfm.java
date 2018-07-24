package newtimes.production.gui.prodmaintain;
import java.awt.*;
import javax.swing.*;
import com.inet.viewer.ReportViewerBean;
import java.awt.event.*;
import database.datatype.Record;
import java.util.Vector;
public class PnlSC_CT_SndCnfm extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  newtimes.production.process.prodmaintain.DB_StyleListHandler scHandler
      =new newtimes.production.process.prodmaintain.DB_StyleListHandler();
  Record directorRec=null;
  int _prodSeq;
  JPanel jPanel1 = new JPanel();
  public JButton btnSendConfirm = new JButton();
  public JComboBox cbxMgr2Cnfm = new JComboBox();
  exgui.DataBindJCombobox dbCbx4CnfmMgr;
  public PnlSC_CT_SndCnfm(int prodseq) {
    super();
    _prodSeq=prodseq;
    try {

      if((!util.PublicVariable.OPERATTING_CENTER.equals("001") &&
         !util.PublicVariable.OPERATTING_CENTER.equals("NTHK"))){
        String sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
        newtimes.preproduction.guis.PnlNthkOrderPrint.updateUploadQtyText(sc_no);
      }


      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
    genDraftReportViewer();
    //genProfitReportViewer();
  }
  protected void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jScrollPane1.setFont(new java.awt.Font("Dialog", 1, 11));
    jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSendConfirm.setText("SEND CONFIRM");
    this.add(jTabbedPane1,  BorderLayout.CENTER);
    jTabbedPane1.add(jScrollPane1,"S/C DRAFT");
    //jTabbedPane1.add(jScrollPane2,"S/C PROFIT");
    //jTabbedPane1.setBackgroundAt(0, Color.WHITE);
    //jTabbedPane1.setBackgroundAt(1, Color.YELLOW);
    this.add(jPanel1,  BorderLayout.SOUTH);
    jTabbedPane1.setSelectedIndex(0);
  }
  protected void genProfitReportViewer(){
    try{
      newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
      java.util.HashMap mp=new java.util.HashMap();
      mp.put("prod_pk",String.valueOf(_prodSeq));
        com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
        newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,"sc_profit.rpt",mp);
        viewer.setHasGroupTree(false);
        jScrollPane2.getViewport().add(viewer, null);
        viewer.setHasExportButton(true);
        viewer.start();
       } catch(Throwable ex) {
         ex.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
       }

  }

  protected void genDraftReportViewer(){
    try{
      newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
      java.util.HashMap mp=new java.util.HashMap();
      mp.put("prod_pk",String.valueOf(_prodSeq));
        //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt("SC_DOC_DRAFT.RPT",null,mp);
        com.inet.viewer.ReportViewerBean viewer=util.PublicVariable.inet_report_viewer;//new com.inet.viewer.ReportViewerBean();
        String reportFileName=
            (util.PublicVariable.OPERATTING_CENTER.equals("001"))?"sc_doc_draft.rpt":"LONG_draft.rpt";
        newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,reportFileName,mp);
        viewer.setHasGroupTree(false);
        //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
        jScrollPane1.getViewport().add(viewer, null);
        viewer.setHasExportButton(true);
        viewer.start();
       } catch(Throwable ex) {
         ex.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
       }

  }

}

