package newtimes.production.process.order_change;
import processhandler.commands.*;
public class ToGenCtOdrChgReport implements AbleToGenCtOdrChgReport{
  public ToGenCtOdrChgReport() {

  }
  public void toGenCtOdrChgReport() throws processhandler.commands.CommandException{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      newtimes.production.gui.order_change.PnlReprotOdrChg  pnl=
          new newtimes.production.gui.order_change.PnlReprotOdrChg();
      pnl.setPreferredSize(new java.awt.Dimension(780,500));
      processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
      processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
      processhandler.template.Properties.getSplitFrame().repaint();
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, false,false,false,false,false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setText("CONFIRM EDIT");
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      jframe.getContentPane().removeAll();
      jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());
      jframe.validate();
      jframe.repaint();
      //activate server to save revice No and order change.
      //
      int _prodSeq= newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(0);
           //newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
       //newtimes.production.report.ReportCmdSet.myReportEngin.checkOk();
       java.util.HashMap mp=new java.util.HashMap();
       mp.put("PROD_PK",String.valueOf(_prodSeq));
       mp.put("prod_pk",String.valueOf(_prodSeq));
       mp.put("type","ct");

         com.inet.viewer.ReportViewerBean viewer=util.PublicVariable.inet_report_viewer;//=new com.inet.viewer.ReportViewerBean();
         newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,"order_change.rpt",mp);
         viewer.setHasGroupTree(false);
         //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
        viewer.start();
        pnl.setViewer(viewer);
      newtimes.production.report.ReportCmdSet.myReportEngin.saveOrderChangeRTF(
      _prodSeq,
      newtimes.production.gui.order_change.PnlInputSCNO.CURRENT_PRODCTION_REVICE_NO);
      System.out.println("order change saved.");

      //
    }catch(Exception e){
      e.printStackTrace();
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
