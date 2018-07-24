package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgPrintBatchReport extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JButton btnExit = new JButton();
  JButton btnPrint = new JButton();
  JTextField txtBatchNo = new JTextField();
  JComboBox cbxDep = new JComboBox();
  exgui.DataBindJCombobox dbCbxDep;
  JLabel jLabel3 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  public DlgPrintBatchReport(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      dbCbxDep=
         new exgui.DataBindJCombobox(
              cbxDep,"",newtimes.preproduction.guis.tempProperties.tmpDepartment,
              "DEP_NAME","DEP_CODE","ALL","ALL","ALL");

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgPrintBatchReport() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("BATCH#");
    jLabel1.setBounds(new Rectangle(26, 31, 62, 25));
    jLabel2.setBounds(new Rectangle(26, 61, 62, 25));
    jLabel2.setText("DEPT.");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(45, 145, 87, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnPrint.setText("Report");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setBounds(new Rectangle(189, 145, 106, 26));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    txtBatchNo.setText("");
    txtBatchNo.setBounds(new Rectangle(86, 31, 145, 24));
    cbxDep.setBounds(new Rectangle(86, 61, 188, 24));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("MAKER");
    jLabel3.setBounds(new Rectangle(26, 96, 48, 25));
    slkMaker.setBounds(new Rectangle(85, 93, 188, 22));
    getContentPane().add(panel1);
    panel1.add(jLabel1, null);
    panel1.add(jLabel2, null);
    panel1.add(btnExit, null);
    panel1.add(btnPrint, null);
    panel1.add(txtBatchNo, null);
    panel1.add(cbxDep, null);
    panel1.add(jLabel3, null);
    panel1.add(slkMaker, null);
    slkMaker.init("P_MAKER",null,slkMaker.TYPE_MAKER,true);
  }

  void btnExit_actionPerformed(ActionEvent e) {
     this.hide();
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    try{
      if(txtBatchNo.getText().trim().length()<"07060003".length()){
        exgui.verification.VerifyLib.showAlert("BATCH# Too Short","BATCH# Too Short");
        return;
      }
      //show debit note report,
      com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.
          inet_report_viewer;
      String rpt_name = "DB_BATCH.rpt";
      java.util.HashMap hm = new java.util.HashMap();
      hm.put("P_BATCH", txtBatchNo.getText().trim());
      hm.put("P_DEP",dbCbxDep.getSelectedValue());
      Object objMaker=slkMaker.getSelectedValue();
      hm.put("P_MAKER",(objMaker==null)?"0":objMaker.toString());
      hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
      newtimes.production.report.ReportCmdSet.myReportEngin.
          setReportNameAndParas(viewer, rpt_name, hm);
      viewer.setHasGroupTree(false);
      //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
      viewer.start();
      JPanel pnl = new JPanel();
      pnl.setLayout(new java.awt.BorderLayout());
      pnl.add(viewer);
      /*
      javax.print.PrintService defaultPrinterService=javax.print.PrintServiceLookup.lookupDefaultPrintService();
      String defaultPrinterName=defaultPrinterService.getName();
      */
      newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
          guis.DlgViewRpt(
          processhandler.template.Properties.getMainFrame(),
          "DB/CR BATCH REPORT",
          pnl, true);
      dlg.setSize(700, 500);
      /*
      try{
        java.lang.Runtime rt=java.lang.Runtime.getRuntime();
        rt.exec("C:\\ChagePrinterCPP\\Debug\\ChagePrinterCPP.exe \""+"\\\\110\\NEC"+"\"");
      }catch(Exception exp){
        exp.printStackTrace();
      }*/
      dlg.show();
      /*
      try{
        java.lang.Runtime rt=java.lang.Runtime.getRuntime();
        rt.exec("C:\\ChagePrinterCPP\\Debug\\ChagePrinterCPP.exe \""+defaultPrinterName+"\"");
      }catch(Exception exp){
        exp.printStackTrace();
      }*/

    }catch(Exception exp){
      exp.printStackTrace();

    }


  }
}
