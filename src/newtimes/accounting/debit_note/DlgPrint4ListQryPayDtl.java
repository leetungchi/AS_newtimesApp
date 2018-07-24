package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgPrint4ListQryPayDtl extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtTo = new JTextField();
  JTextField txtFrom = new JTextField();
  JTextField txtFeeDtl = new JTextField();
  /*
  JCheckBox chks[0] = new JCheckBox();
  JCheckBox chks[1] = new JCheckBox();
  JCheckBox chks[2] = new JCheckBox();
  JCheckBox chks[5] = new JCheckBox();
  JCheckBox chks[4] = new JCheckBox();
  JCheckBox chks[3] = new JCheckBox();
  */
  JCheckBox chks[] = new JCheckBox[6];
  JLabel jLabel1 = new JLabel();
  JComboBox cbxFullOffAmt = new JComboBox(new String[]{"FULL AMT","OFF AMT"});
  JButton btnPrint = new JButton();
  JButton btnExit = new JButton();
  String paydtlseq[];
  String report_paras[]={"AMT (USD)","AMT (TWD)","發票號碼","傳票號碼","D/B NO.","REMARK"};
  public DlgPrint4ListQryPayDtl(Frame frame, String title, boolean modal,String[] seq2print) {
    super(frame, title, modal);
    paydtlseq=seq2print;
    try {
      jbInit();
      pack();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgPrint4ListQryPayDtl() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    for(int i=0;i<6;i++)chks[i]=new JCheckBox();
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("報表選項");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 15, 570, 27));
    txtTo.setToolTipText("TO資訊");
    txtTo.setText("TO :");
    txtTo.setBounds(new Rectangle(9, 51, 265, 25));
    txtFrom.setBounds(new Rectangle(300, 51, 265, 25));
    txtFrom.setToolTipText("FROM 資訊");
    txtFrom.setVerifyInputWhenFocusTarget(true);
    txtFrom.setText("FM : 新麟 會計部");
    txtFeeDtl.setBounds(new Rectangle(9, 86, 265, 25));
    txtFeeDtl.setText("應付貴公司 樣品費 明細如下");
    txtFeeDtl.setToolTipText("應付貴公司 樣品費 明細如下");
    chks[0].setFont(new java.awt.Font("Dialog", 1, 11));
    chks[0].setText("USD AMT");
    chks[0].setBounds(new Rectangle(12, 125, 97, 21));
    chks[1].setBounds(new Rectangle(201, 124, 97, 21));
    chks[1].setText("TWD AMT");
    chks[1].setFont(new java.awt.Font("Dialog", 1, 11));
    chks[2].setBounds(new Rectangle(390, 124, 97, 21));
    chks[2].setText("發票號碼");
    chks[2].setFont(new java.awt.Font("Dialog", 0, 12));
    chks[4].setFont(new java.awt.Font("Dialog", 1, 11));
    chks[4].setText("D/B NO.");
    chks[4].setBounds(new Rectangle(201, 155, 97, 21));
    chks[5].setFont(new java.awt.Font("Dialog", 1, 11));
    chks[5].setText("REMARK");
    chks[5].setBounds(new Rectangle(390, 155, 97, 21));
    chks[3].setBounds(new Rectangle(12, 156, 97, 21));
    chks[3].setText("傳票號碼");
    chks[3].setFont(new java.awt.Font("Dialog", 0, 12));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("FULL/OFF AMT");
    jLabel1.setBounds(new Rectangle(8, 188, 99, 22));
    cbxFullOffAmt.setBounds(new Rectangle(101, 188, 105, 21));
    btnPrint.setBounds(new Rectangle(208, 239, 109, 30));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("PRINT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(410, 239, 109, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(txtTo, null);
    panel1.add(txtFrom, null);
    panel1.add(txtFeeDtl, null);
    panel1.add(chks[0], null);
    panel1.add(chks[1], null);
    panel1.add(chks[2], null);
    panel1.add(chks[4], null);
    panel1.add(chks[5], null);
    panel1.add(chks[3], null);
    panel1.add(jLabel1, null);
    panel1.add(cbxFullOffAmt, null);
    panel1.add(btnPrint, null);
    panel1.add(btnExit, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    java.util.HashMap hmPara=new java.util.HashMap();
    StringBuffer sbSeq=new StringBuffer();
    sbSeq.append("[");
   for(int i=0;i<paydtlseq.length;i++){
     if(i>0)sbSeq.append(",");
     //sbSeq.append("'");
     sbSeq.append(paydtlseq[i]);
     //sbSeq.append("'");
   }
   sbSeq.append("]");
   System.out.println("seq list "+sbSeq.toString());
   hmPara.put("P_DB_SEQ",sbSeq.toString());
   hmPara.put("P_FM",txtFrom.getText().trim());
   hmPara.put("P_TO",txtTo.getText().trim());
   hmPara.put("P_TITLE",txtFeeDtl.getText().trim());
   hmPara.put("P_FULL_OFF",
              "FULL AMT".equals(cbxFullOffAmt.getSelectedItem())?"FULL":"OFF");
   int paraCount=1;
   //copse paras of check boxes
   for(int i=0;i<6;i++){
     if(chks[i].isSelected()){
       hmPara.put("P_"+String.valueOf(paraCount),report_paras[i]);
       paraCount++;
     }
   }
   for(int i=paraCount;i<=6;i++){
     hmPara.put("P_"+String.valueOf(i),"");
   }
   this.dispose();
   hmPara.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
   com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.inet_report_viewer;
   String rpt_name = "DB_PAY_DTL.RPT";
   try{
     newtimes.production.report.ReportCmdSet.myReportEngin.
         setReportNameAndParas(viewer, rpt_name, hmPara);
     viewer.setHasGroupTree(false);
     //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
     viewer.start();
     JPanel pnl = new JPanel();
     pnl.setLayout(new java.awt.BorderLayout());
     pnl.add(viewer);

     newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
         guis.DlgViewRpt(
         processhandler.template.Properties.getMainFrame(),
         "報表選項報告",
         pnl, true);
     dlg.setSize(700, 500);
     dlg.show();
   }catch(Exception exp){
     exp.printStackTrace();
   }

  }
}
