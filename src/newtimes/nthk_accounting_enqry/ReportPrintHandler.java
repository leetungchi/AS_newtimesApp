package newtimes.nthk_accounting_enqry;
import javax.swing.JPanel;
public class ReportPrintHandler {
  boolean isCtWithColorCodeName=false;
  String sc_no;
  boolean isDocPrx;
  newtimesejb.preproduction.PreProductionHead myEjb;
  boolean initOk;
  int prod_pk;
  //com.inet.viewer.ReportViewerBean viewer=util.PublicVariable.inet_report_viewer;
  public java.util.Vector  vctCtSeqVector;
  public ReportPrintHandler(String _sc_no) {
    try{
      vctCtSeqVector=null;
      sc_no=_sc_no;
      newtimesejb.preproduction.PreProductionHeadHome
          ejbHome =
          (newtimesejb.preproduction.PreProductionHeadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.preproduction.PreProductionHead"
          );
      myEjb=ejbHome.create();
      initOk=true;
    }catch(Exception exp){
      util.ExceptionLog.exp2File(exp,"exception in DB_ProdAudits");
      initOk=false;
      exgui.verification.VerifyLib.showAlert(
          "Server Connection Error\nPlease Notify System Manager",
          "EJB Create Exception");
    }

  }
  private void updatePrintStatus(int prod_pk,int currentPrintCount,int sc_rev_no,int ct_rev_no)throws Exception{
    myEjb.updatePrintStatus(
      prod_pk,
      (String) util.PublicVariable.USER_RECORD.get("usr_code"),
      currentPrintCount,
      sc_rev_no,ct_rev_no
      );
  }
  private void updateStyleColorSizeBreakDownRemark(boolean isSc,boolean isDocPrx,boolean _isCtWithColorCodeName){
    try{
    //for NONE-NTHK center,need to update the column "STY_CLR_PRX_BKD" to replace the style's down remark field
     if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       util.MiscFunc.showProcessingMessage();
       newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler.udpateColorSizeBreakDownRemark(
       sc_no,isSc,isDocPrx,_isCtWithColorCodeName) ;
     }
     return;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error in updating sytles's down remark\nPlease Notify System Manager",
                                             "Update Style down remark fail");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  private void updateStyleColorSizeBreakDownRemark(boolean isSc,boolean isDocPrx){
    updateStyleColorSizeBreakDownRemark(isSc,isDocPrx,false);
  }
  public java.util.Vector getCtRecords()throws Exception{
    StringBuffer sb=new StringBuffer();
    sb.append("select to_char(prod_ct_seq) as prod_ct_seq ,to_char(prod_head_pk) as prod_head_pk,");
    sb.append("(select production.prod_ct_revice_no from production where production.prod_head_pk=prod_ct_infor.prod_head_pk) as ct_rev_no ");
    sb.append(" from prod_ct_infor where record_delete_flag='1' and prod_sc_no='");
    sb.append(sc_no);
    sb.append("' order by prod_ct_seq");
    java.util.Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,sb.toString(),
        1, 99999);
    vctCtSeqVector=new java.util.Vector();
    vctCtSeqVector.addAll(vct);
    return vct;
    //return vct;
  }
  private String get_PK_List()throws Exception{
  StringBuffer sb=new StringBuffer();
  //java.util.Vector  vctCtSeqVector=getCtRecords();
   for(int i=0;i<vctCtSeqVector.size();i++){
     database.datatype.Record rec=(database.datatype.Record)vctCtSeqVector.get(i);
     if(i!=0)sb.append(",");
     sb.append(rec.get(1));
   }
   String string="["+sb.toString()+"]";
   return string;
 }
 public JPanel genCTReportViewerPanel(String rpt_name,boolean _isDocPrx,
                                    int ct_destProdPk,
                                    int pCtSeq,boolean isCtWithBuyerBreif,
                                    boolean isWithColorCode){
   try{
     com.inet.viewer.ReportViewerBean viewer=genCTReportViewer(rpt_name,_isDocPrx,
                                    ct_destProdPk,
                                    pCtSeq,isCtWithBuyerBreif,isWithColorCode);
     JPanel pnl=new JPanel();
     pnl.setLayout(new java.awt.BorderLayout());
     pnl.add(viewer);
     viewer.setHasExportButton(true);
     return pnl;
  }catch(Throwable ex) {
      ex.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
      return null;
  }finally{
    newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }
 }
 public  com.inet.viewer.ReportViewerBean genCTReportViewer(String rpt_name,boolean _isDocPrx,
                                    int ct_destProdPk,
                                    int pCtSeq,boolean isCtWithBuyerBreif,
                                    boolean isWithColorCode){
  try{
   if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
     updateStyleColorSizeBreakDownRemark(false, _isDocPrx, isWithColorCode);
   }
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    //get act c/t record by select index.
    prod_pk=ct_destProdPk;
    updatePrintStatus(prod_pk,-2,-1,-1);
    int destProdPk=ct_destProdPk;
      //newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_print_count");
    //int ct_rev_no=Integer.parseInt(txtCT_rev_no.getText().trim());
    int _prodSeq=destProdPk;
     //handler.updatePrintStatus(lastPrintCount,-1,ct_rev_no);

     //newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set("production_ct_revice_no",ct_rev_no);
     java.util.HashMap mp=new java.util.HashMap();
     mp.put("iprod_head_pk",String.valueOf(_prodSeq));
     mp.put("prod_pk",String.valueOf(_prodSeq));
     mp.put("prod_head_pk",String.valueOf(_prodSeq));
     mp.put("times",String.valueOf(-2));
     mp.put("P_CT_SEQ",String.valueOf(pCtSeq));

     if(isCtWithBuyerBreif){
       mp.put("PRT_BEF","Y");
     }else{
       mp.put("PRT_BEF","N");
     }
     if(_isDocPrx)
        mp.put("doc_act","1");
     else
        mp.put("doc_act","2");
       //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt(rpt_name,null,mp);
       com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
       newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,rpt_name,mp);
       viewer.setHasGroupTree(false);
       //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
       viewer.start();
      /*
      JPanel pnl=new JPanel();
      pnl.setLayout(new java.awt.BorderLayout());
      pnl.add(viewer);
      viewer.setHasExportButton(true);
      return pnl;
      */
     return viewer;
   }catch(Throwable ex) {
       ex.printStackTrace();
       exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
       return null;
   }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }

}

  public com.inet.viewer.ReportViewerBean genSCReportViewer(   String rpt_name,
                                     int _prod_pk,
                                     boolean _isDocPrx,
                                     String _sc_no){
    try{
      prod_pk=_prod_pk;
      isDocPrx=_isDocPrx;
      sc_no=_sc_no;
      if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        updateStyleColorSizeBreakDownRemark(true, isDocPrx);
      }
      newtimes.production.ProdMaintain_Properties.setWaitCursor();

       updatePrintStatus(prod_pk,-2,-1,-1);
       java.util.HashMap mp=new java.util.HashMap();
       //mp.put("prod_pk",String.valueOf(_prodSeq));
       //test if this record combined.
       mp.put("prod_pk",get_PK_List());
       mp.put("times","-2");
       if(isDocPrx) mp.put("doc_act","1"); else  mp.put("doc_act","2");
       com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
        newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,rpt_name,mp);
         viewer.setHasGroupTree(false);
        viewer.start();
        return viewer;
        /*
        JPanel pnl=new JPanel();
        pnl.setLayout(new java.awt.BorderLayout());
        pnl.add(viewer);
        viewer.setHasExportButton(true);
        return pnl;*/
     }catch(Throwable ex) {

         ex.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
         return null;
     }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }
  }
  public JPanel genSCReportViewerPanel(   String rpt_name,
                                     int _prod_pk,
                                     boolean _isDocPrx,
                                     String _sc_no){
    try{
      com.inet.viewer.ReportViewerBean viewer=genSCReportViewer( rpt_name,
                                           _prod_pk,
                                           _isDocPrx,
                                           _sc_no);
        JPanel pnl=new JPanel();
        pnl.setLayout(new java.awt.BorderLayout());
        pnl.add(viewer);
        viewer.setHasExportButton(true);
      return pnl;
     }catch(Throwable ex) {

         ex.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Report Server Error\nPlease Notify System Manager","Report Error");
         return null;
     }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }
  }

}
