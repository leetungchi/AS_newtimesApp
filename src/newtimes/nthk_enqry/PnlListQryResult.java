package newtimes.nthk_enqry;
import processhandler.template.PnlListQryRslt;
import exgui.ultratable.*;
import newtimes.preproduction.process.DB_Preprod;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.ultratable.*;
import java.util.Vector;
import exgui.MultiClassTableModel;
import java.io.*;

import java.awt.*;
import javax.swing.JPanel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryResult extends PnlListQryRslt
    implements exgui.ultratable.MakeTableNotify{
    protected  EnqDataEngin myHander;
    public static int PAGE_BEGIN;
    boolean hasModifLogButton=false;;
    javax.swing.JButton btnExit=new javax.swing.JButton("EXIT");
  MyMouseActionListener axnListener=new MyMouseActionListener();
    public void MakingTable(java.util.Vector vct){
       if(vct==null)return;
    }
    class MyMouseActionListener implements java.awt.event.ActionListener {
      public void actionPerformed(ActionEvent e) {
        try{
          processhandler.template.Properties.getCenteralControler().goBack();
        }catch(Exception ie){
          ie.printStackTrace();
        }
      }
    }
    public PnlListQryResult(EnqDataEngin pagedDataFxy,
          int rowCount,util.InsertionOrderedHashMap columnMapping,
          java.util.Hashtable object2StringConvertor
      ){
       super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
       myHander=pagedDataFxy;
       this.removeAll();
       this.add(this.pgTblList,BorderLayout.CENTER);
       pgTblList.setMakeTableNotifier(this);
       this.MakingTable(null);
       pgTblList.getLowerRightPanel().add(btnExit);
       btnExit.addActionListener(axnListener);
    }
    public PnlListQryResult(EnqDataEngin pagedDataFxy,
         int rowCount,util.InsertionOrderedHashMap columnMapping,
         java.util.Hashtable object2StringConvertor,
         String titleStr1,String btnStr1
     ){
      super(pagedDataFxy,
            rowCount,
            columnMapping,
            object2StringConvertor,
            titleStr1,
            btnStr1
            );
      if(titleStr1.indexOf(processhandler.template.PagedListTable4Qry.DELIMITER2CHAIN4BUTTON_COLUMN)!=-1)
                   hasModifLogButton=true;

      myHander=pagedDataFxy;
      this.removeAll();
      this.add(this.pgTblList,BorderLayout.CENTER);
      pgTblList.setMakeTableNotifier(this);
      pgTblList.getLowerRightPanel().add(btnExit);
      this.MakingTable(null);
      btnExit.addActionListener(axnListener);
   }
   public void gridTableMouseEventHandler(MouseEvent e) {
     processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.WAIT_CURSOR));
     this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
     this.pgTblList.getJtable().setCursor(new Cursor(Cursor.WAIT_CURSOR));
     util.ApplicationProperites.setProperties(
         this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));
      int recAt=getInsideJtable().getSelectedRow();
      if(recAt<0) return;
      //System.out.println("qry list table click at row:"+recAt);
      int columnAt=getInsideJtable().getSelectedColumn();
      //clear all the selection..
      getInsideJtable().clearSelection();
      //see if to enter to edit master Record or just display showing detail of clicked record.
       java.awt.Container  myContaner=null;
       myContaner=processhandler.template.Properties.getMainFrame().getContentPane();
      try{
        //util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Record clickedRecord=(Record)pgTblList.getDisplayingRecords().get(recAt);

        if(columnAt == (getInsideJtable().getColumnCount() - 3) && hasModifLogButton){
         DlgScCtRptPrint dlg=new DlgScCtRptPrint(util.PublicVariable.APP_FRAME,
                                                 "REPORT SETTING",true,
                                                 clickedRecord);
         dlg.setSize(445,300);
         exgui.UIHelper.setToScreenCenter(dlg);
         dlg.show();
          //show the dialog to determ if DOC PRX or Act PRX
          //show the dialog of S/C Report

           /*
             javax.swing.JPanel pnl= reporthandler.genSCReportViewer(
                      reportName,
                      clickedRecord.getInt(37),//<---headding prod_head_pk in CT_INFOR
                      isDocPrice,
                      (String)clickedRecord.get(1)//<--SC NO
                      );

               newtimes.preproduction.guis.DlgViewRpt dlg =
                   new newtimes.preproduction.guis.DlgViewRpt(
                   util.PublicVariable.APP_FRAME,
                   "S/C report",pnl,true);
               dlg.setSize(700, 500);
               dlg.show();
                */

        }else if(columnAt == (getInsideJtable().getColumnCount() - 2) && hasModifLogButton ){

          String scNo=(String)clickedRecord.get("Sc_no");
          java.util.HashMap mp=new java.util.HashMap();
          mp.put("P_SC_NO",scNo);
            //newtimes.production.report.ReportCmdSet.myReportEngin.directCallEngine2Xqt(rpt_name,null,mp);
            //com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
            com.inet.viewer.ReportViewerBean viewer=new com.inet.viewer.ReportViewerBean();
            newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,"M_H.rpt",mp);
            viewer.setHasGroupTree(false);
            //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
            viewer.start();
            JPanel pnl=new JPanel();
            pnl.setLayout(new java.awt.BorderLayout());
            pnl.add(viewer);
            viewer.setHasExportButton(true);
            newtimes.preproduction.guis.DlgViewRpt dlg=new
                newtimes.preproduction.guis.DlgViewRpt(util.PublicVariable.APP_FRAME,
                                                       "MODIFICATION LOG OF "+scNo,pnl,true);
            dlg.setSize(700, 500);
            dlg.show();

        }else if (columnAt == (getInsideJtable().getColumnCount() - 1)) {
            //to edit ship head...
            PAGE_BEGIN=super.pgTblList._rowPosition;
            processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.nthk_enqry.TgrShowStyleItemDetail((Record)pgTblList.getDisplayingRecords().get(recAt)));
        }
      }catch(Exception cmdE){
         cmdE.printStackTrace();
         util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
      }finally{
         this.pgTblList.getJtable().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    }
    protected boolean getDocActPrxType(){
     CustomMessage myPrxDlg= new CustomMessage();
      JOptionPane.showOptionDialog(
          util.PublicVariable.APP_FRAME,
          myPrxDlg,
          "Please Select Price Type",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE,
          null,
          new String[] {"OK"},"OK");

       if(myPrxDlg.btnActPrx.isSelected())return false;
       return true;
    }


    class CustomMessage extends JPanel {
      JRadioButton btnDocPrx=new JRadioButton("DOC  PRICE",true);
      JRadioButton btnActPrx=new JRadioButton("ACT  PRICE");
       public CustomMessage() {
           super( new BorderLayout(0, 5) );
           add( new JLabel("Please Select Price Type"), BorderLayout.NORTH );
           JPanel subPanel = new JPanel();
           ButtonGroup group = new ButtonGroup();
           //subPanel.add( new JLabel("Your icon goes here") );
           group.add(btnDocPrx);
           subPanel.add( btnDocPrx );
           group.add(btnActPrx);
           subPanel.add( btnActPrx );
           add( subPanel, BorderLayout.CENTER );
       }

   }

}
