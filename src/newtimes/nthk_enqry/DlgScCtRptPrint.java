package newtimes.nthk_enqry;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgScCtRptPrint extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JRadioButton rdoFormSc = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoFormCt = new JRadioButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JRadioButton rdoActPrx = new JRadioButton();
  JRadioButton rdoDocPRx = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JLabel lblCtWithClrCode = new JLabel();
  JLabel lblCtWithBuyerName = new JLabel();
  JComboBox cbxCtColorCode = new JComboBox(new String[]{"YES","NO"});
  JComboBox cbxCtBuyerName = new JComboBox(new String[]{"YES","NO"});
  JButton btnOk = new JButton();
  JButton btnExit = new JButton();
  ReportPrintHandler reporthandler;
  JLabel lblCtSeq = new JLabel();
  JComboBox cbxCtSeq = new JComboBox();
  exgui.DataBindJCombobox dbCbxCtSeq;
  database.datatype.Record clickedRecord;
  String sc_no;
  String cen_no;
  JLabel lblForAndOnBehalfOf = new JLabel();
  JButton btnDirectPrint = new JButton();
  public DlgScCtRptPrint(Frame frame, String title, boolean modal,
                         database.datatype.Record recPo) {
    super(frame, title, modal);
    try {
      clickedRecord=recPo;
      reporthandler=new ReportPrintHandler((String)clickedRecord.get(1));
      jbInit();
      pack();
      iniCtSeqCombobox(reporthandler.getCtRecords(),clickedRecord.getInt(37));

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgScCtRptPrint() {
    this(null, "", false,null);
  }

  public void iniCtSeqCombobox(java.util.Vector vct,int _prod_pk)throws Exception{
    dbCbxCtSeq=new exgui.DataBindJCombobox(
                     cbxCtSeq,
                     "",
                     vct,
                     "PROD_CT_SEQ",
                     "PROD_HEAD_PK",
                     String.valueOf(_prod_pk));
  }

  protected void jbInit() throws Exception {
    panel1.setLayout(null);
    this.getContentPane().setLayout(borderLayout2);
    rdoFormSc.setBackground(Color.white);
    rdoFormSc.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoFormSc.setSelected(true);
    rdoFormSc.setText("S/C");
    rdoFormSc.setBounds(new Rectangle(156, 55, 101, 26));
    rdoFormSc.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rdoFormSc_itemStateChanged(e);
      }
    });
    rdoFormCt.setBounds(new Rectangle(256, 55, 101, 26));
    rdoFormCt.setText("C/T");
    rdoFormCt.setBackground(Color.white);
    rdoFormCt.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoFormCt.setSelected(false);
    jLabel1.setBackground(new Color(108, 108, 224));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.white);
    jLabel1.setOpaque(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel1.setText("FORM TYPE");
    jLabel1.setBounds(new Rectangle(33, 55, 123, 26));
    jLabel2.setBounds(new Rectangle(33, 92, 123, 26));
    jLabel2.setText("PRICE");
    jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setOpaque(true);
    jLabel2.setForeground(Color.white);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setBackground(new Color(108, 108, 224));
    rdoActPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoActPrx.setBackground(Color.white);
    rdoActPrx.setText("ACT PRX.");
    rdoActPrx.setBounds(new Rectangle(255, 92, 101, 26));
    rdoDocPRx.setBounds(new Rectangle(155, 92, 101, 26));
    rdoDocPRx.setText("DOC PRX.");
    rdoDocPRx.setSelected(true);
    rdoDocPRx.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDocPRx.setBackground(Color.white);
    lblCtWithClrCode.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCtWithClrCode.setText("C/T WITH COLOR CODE");
    lblCtWithClrCode.setBounds(new Rectangle(33, 129, 131, 26));
    lblCtWithBuyerName.setBounds(new Rectangle(33, 158, 128, 26));
    lblCtWithBuyerName.setText("C/T WITH BUYER NAME");
    lblCtWithBuyerName.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCtColorCode.setBounds(new Rectangle(163, 130, 65, 22));
    cbxCtBuyerName.setBounds(new Rectangle(163, 161, 67, 21));
    btnOk.setBounds(new Rectangle(49, 238, 112, 26));
    btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOk.setText("PRINT REPORT");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOk_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(333, 238, 70, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    lblCtSeq.setText("C/T SEQ:");
    lblCtSeq.setBounds(new Rectangle(244, 130, 62, 20));
    cbxCtSeq.setBounds(new Rectangle(296, 130, 63, 20));
    lblForAndOnBehalfOf.setFont(new java.awt.Font("Dialog", 1, 11));
    lblForAndOnBehalfOf.setText("(UNDER \" FOR AND ON BEHALF OF \")");
    lblForAndOnBehalfOf.setBounds(new Rectangle(34, 184, 230, 22));
    btnDirectPrint.setBounds(new Rectangle(202, 238, 111, 24));
    btnDirectPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDirectPrint.setForeground(Color.red);
    btnDirectPrint.setText("Direct Print");
    btnDirectPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDirectPrint_actionPerformed(e);
      }
    });
    getContentPane().add(panel1, BorderLayout.CENTER);
    buttonGroup1.add(rdoFormSc);
    buttonGroup1.add(rdoFormCt);
    panel1.add(jLabel1, null);
    panel1.add(rdoFormSc, null);
    panel1.add(rdoFormCt, null);
    panel1.add(jLabel2, null);
    panel1.add(rdoActPrx, null);
    panel1.add(rdoDocPRx, null);
    buttonGroup2.add(rdoDocPRx);
    buttonGroup2.add(rdoActPrx);
    panel1.add(cbxCtSeq, null);
    panel1.add(lblCtSeq, null);
    panel1.add(btnOk, null);
    panel1.add(btnExit, null);

    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      panel1.add(lblCtWithClrCode, null);
      panel1.add(cbxCtColorCode, null);
      panel1.add(cbxCtBuyerName, null);
      panel1.add(lblCtWithBuyerName, null);
      panel1.add(lblForAndOnBehalfOf, null);
    }
    String userId=(String)util.PublicVariable.USER_RECORD.get(0);
    if(userId.equals("NTERIC") ||
      (userId.length()>=10 &&
        userId.substring(userId.length()-10,userId.length()).equals("ANTHONYLIU"))){
       panel1.add(btnDirectPrint, null);
    }

    cbxCtSeq.setEnabled(false);
    cbxCtBuyerName.setEnabled(false);
    cbxCtColorCode.setEnabled(false);
  }
  public JPanel getScReport(){
    int prod_pk =clickedRecord.getInt(37);//<---headding prod_head_pk in CT_INFOR
    String sc_no=(String)clickedRecord.get(1);//<--SC NO
    boolean isDocPrice=rdoDocPRx.isSelected();
    String cen_code=(String)clickedRecord.get(36);
    boolean isNTHKCenter=cen_code.equals("NTHK");
    boolean isBWCenter=cen_code.equals("BW");
    boolean isTPECenter=cen_code.equals("001");
         String reportName=null;
         if(isTPECenter){
           reportName="SC_DOC.rpt";
         }else if(isNTHKCenter){
            reportName="HK_SC_DOC.rpt";
         }else if(isBWCenter){
           reportName="B_LONG_HK_SC_DOC.rpt";
         }else{
           reportName=  "LONG_HK_SC_DOC.rpt";
         }
    return reporthandler.genSCReportViewerPanel(reportName,prod_pk,isDocPrice,sc_no);
  }
  public JPanel getCtReport(){
    boolean isDocPrice=rdoDocPRx.isSelected();
    String cen_code=(String)clickedRecord.get(36);
    boolean isNTHKCenter=cen_code.equals("NTHK");
    boolean isBWCenter=cen_code.equals("BW");
    boolean isTPECenter=cen_code.equals("001");
         String reportName=null;

         if(isTPECenter){
           reportName="CT_DOC.rpt";
         }else if(isNTHKCenter){
            reportName="HK_CT_DOC.rpt";
         }else if(isBWCenter){
           reportName="B_LONG_HK_CT_DOC.rpt";
         }else{
           reportName=  "LONG_HK_CT_DOC.rpt";
         }
     int destProdPk=Integer.parseInt((String)dbCbxCtSeq.getSelectedValue());
     int p_ct_seq=Integer.parseInt(cbxCtSeq.getSelectedItem().toString());
     return reporthandler.genCTReportViewerPanel(reportName,isDocPrice,
                                            destProdPk,p_ct_seq,
                                            cbxCtBuyerName.getSelectedItem().equals("YES"),
                                            cbxCtColorCode.getSelectedItem().equals("YES"));
  }

  public com.inet.viewer.ReportViewerBean  getScReportViewer(){
    int prod_pk =clickedRecord.getInt(37);//<---headding prod_head_pk in CT_INFOR
    String sc_no=(String)clickedRecord.get(1);//<--SC NO
    boolean isDocPrice=rdoDocPRx.isSelected();
    String cen_code=(String)clickedRecord.get(36);
    boolean isNTHKCenter=cen_code.equals("NTHK");
    boolean isBWCenter=cen_code.equals("BW");
    boolean isTPECenter=cen_code.equals("001");
         String reportName=null;
         if(isTPECenter){
           reportName="SC_DOC.rpt";
         }else if(isNTHKCenter){
            reportName="HK_SC_DOC.rpt";
         }else if(isBWCenter){
           reportName="B_LONG_HK_SC_DOC.rpt";
         }else{
           reportName=  "LONG_HK_SC_DOC.rpt";
         }
    return reporthandler.genSCReportViewer(reportName,prod_pk,isDocPrice,sc_no);
  }
  public com.inet.viewer.ReportViewerBean getCtReportViewer(){
    boolean isDocPrice=rdoDocPRx.isSelected();
    String cen_code=(String)clickedRecord.get(36);
    boolean isNTHKCenter=cen_code.equals("NTHK");
    boolean isBWCenter=cen_code.equals("BW");
    boolean isTPECenter=cen_code.equals("001");
         String reportName=null;

         if(isTPECenter){
           reportName="CT_DOC.rpt";
         }else if(isNTHKCenter){
            reportName="HK_CT_DOC.rpt";
         }else if(isBWCenter){
           reportName="B_LONG_HK_CT_DOC.rpt";
         }else{
           reportName=  "LONG_HK_CT_DOC.rpt";
         }
     int destProdPk=Integer.parseInt((String)dbCbxCtSeq.getSelectedValue());
     int p_ct_seq=Integer.parseInt(cbxCtSeq.getSelectedItem().toString());
     return reporthandler.genCTReportViewer(reportName,isDocPrice,
                                            destProdPk,p_ct_seq,
                                            cbxCtBuyerName.getSelectedItem().equals("YES"),
                                            cbxCtColorCode.getSelectedItem().equals("YES"));
  }


  void btnOk_actionPerformed(ActionEvent e) {
     if(rdoFormSc.isSelected()){
       javax.swing.JPanel pnl=getScReport();
       newtimes.preproduction.guis.DlgViewRpt dlg =
           new newtimes.preproduction.guis.DlgViewRpt(
           util.PublicVariable.APP_FRAME,
           "S/C report",pnl,true);
       dlg.setSize(700, 500);
       dlg.show();
     }else{
       javax.swing.JPanel pnl=getCtReport();
       newtimes.preproduction.guis.DlgViewRpt dlg =
           new newtimes.preproduction.guis.DlgViewRpt(
           util.PublicVariable.APP_FRAME,
           "C/T report",pnl,true);
       dlg.setSize(700, 500);
       dlg.show();
     }
  }

  void btnExit_actionPerformed(ActionEvent e) {
   this.dispose();
  }

  void rdoFormSc_itemStateChanged(ItemEvent e) {
    cbxCtBuyerName.setEnabled(!rdoFormSc.isSelected());
    cbxCtColorCode.setEnabled(!rdoFormSc.isSelected());
    cbxCtSeq.setEnabled(!rdoFormSc.isSelected());
  }

  void btnDirectPrint_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      System.out.println("Begin VeiwerPrint....");
      com.inet.viewer.ReportViewerBean v1 =
          getScReportViewer();
      v1.printView(false);

      //if have ct more than one....
      int ct_item_count=cbxCtSeq.getItemCount();
      for(int i=0;i<ct_item_count;i++){
        cbxCtSeq.setSelectedIndex(i);
        com.inet.viewer.ReportViewerBean v2 =
            getCtReportViewer();
        v2.printView(false);
      }
      cbxCtSeq.setSelectedIndex(0);
      System.out.println("Print OK");
      this.dispose();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}
