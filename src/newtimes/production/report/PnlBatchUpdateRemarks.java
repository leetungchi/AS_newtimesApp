package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import jxl.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlBatchUpdateRemarks extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JPanel pnlBatchUpdate1styUpProdEndRmrk = new JPanel();
  TitledBorder titledBorder3;
  Border border3;
  TitledBorder titledBorder4;
  Border border4;
  TitledBorder titledBorder5;
  Border border5;
  TitledBorder titledBorder6;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtBatchNo4StyUpProdEndRmrk = new JTextField();
  JPanel pnlProdRefNolis = new JPanel();
  Border border6;
  TitledBorder titledBorder7;
  MyTextField txtProdHeadPk[]=new MyTextField[18];
  /*
  JTextField txtProdHeadPk0 = new JTextField();
  JTextField txtProdHeadPk1 = new JTextField();
  JTextField txtProdHeadPk2 = new JTextField();
  JTextField txtProdHeadPk3 = new JTextField();
  JTextField txtProdHeadPk4 = new JTextField();
  JTextField txtProdHeadPk5 = new JTextField();
  JTextField txtProdHeadPk6 = new JTextField();
  JTextField txtProdHeadPk7 = new JTextField();
  JTextField txtProdHeadPk8 = new JTextField();
  JTextField txtProdHeadPk9 = new JTextField();
  JTextField txtProdHeadPk10 = new JTextField();
  JTextField txtProdHeadPk11 = new JTextField();
  JTextField txtProdHeadPk12 = new JTextField();
  JTextField txtProdHeadPk13 = new JTextField();
  JTextField txtProdHeadPk14 = new JTextField();
  JTextField txtProdHeadPk15 = new JTextField();
  JTextField txtProdHeadPk16 = new JTextField();
  JTextField txtProdHeadPk17 = new JTextField();
  */
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtRemarkData = new JTextArea();
  JButton btnGenProdHeadStyDownRmrk = new JButton();
  JButton btnUpdate2ProdEndRmrk = new JButton();
  JButton btnUpdate1stStyleUpRemark = new JButton();
  JPanel pnlUpdateByUpload = new JPanel();
  Border border7;
  TitledBorder titledBorder8;
  JPanel jPanel1 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtType2RefNo0 = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtType2StyStyle0 = new JTextField();
  JTextField txtType2StyPo0 = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextArea txtStyleUpRemark0 = new JTextArea();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel7 = new JLabel();
  JTextField txtType2StyStyle1 = new JTextField();
  JTextArea txtStyleUpRemark1 = new JTextArea();
  JLabel jLabel8 = new JLabel();
  JTextField txtType2RefNo1 = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  JTextField txtType2StyPo1 = new JTextField();
  JScrollPane jScrollPane3 = new JScrollPane();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextArea txtStyleUpRemark2 = new JTextArea();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  JLabel jLabel11 = new JLabel();
  JTextField txtType2RefNo2 = new JTextField();
  JTextField txtType2StyPo2 = new JTextField();
  JPanel jPanel3 = new JPanel();
  JTextField txtType2StyStyle2 = new JTextField();
  JLabel jLabel12 = new JLabel();
  JScrollPane jScrollPane4 = new JScrollPane();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel15 = new JLabel();
  JTextField txtType2StyStyle3 = new JTextField();
  JTextArea txtStyleUpRemark3 = new JTextArea();
  JLabel jLabel16 = new JLabel();
  JTextField txtType2RefNo3 = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  JTextField txtType2StyPo3 = new JTextField();
  JScrollPane jScrollPane5 = new JScrollPane();
  JLabel jLabel17 = new JLabel();
  JButton btnUpdateStyleUpRemark = new JButton();
  JButton btnExit = new JButton();
  JComboBox cbxReports = new JComboBox();
  JButton btnReports = new JButton();
  JButton btnUpdateStyleUpRemark1 = new JButton();
  JButton btnModifyDestPlanDlv = new JButton();
  JButton btnBatchGetSc = new JButton();
  JButton btnClearAllRefNo = new JButton();

  public PnlBatchUpdateRemarks() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setBackground(new Color(202, 202, 224));
    for(int i=0;i<18;i++){
      txtProdHeadPk[i] = new MyTextField();
      txtProdHeadPk[i].indexInArr=i;
    }
    pnlProdRefNolis.setLayout(new java.awt.GridLayout(3,6));
    border1 = BorderFactory.createEmptyBorder();
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"BATCH GET REMARK(PROD HEAD REMARK & STYE DOWN REMARK)");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border2,"BATCH UPDATE 1st Style Up & End Remark");
    titledBorder3 = new TitledBorder("");
    border3 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"1st step ,input  Ref No or Batch No");
    border4 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder5 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"Prod Head End Remark");
    border5 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder6 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"REMARK CONTEXT");
    border6 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder7 = new TitledBorder(border6,"Prod Ref No");
    border7 = BorderFactory.createEmptyBorder();
    titledBorder8 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"Update Style's UP-REMARK");
    blueBkgWhiteCharLabel1.setText("BATCH UPDATE REMARK AND DESCRIPTION");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 2, 805, 28));
    this.setLayout(null);
    titledBorder1.setTitleFont(new java.awt.Font("Dialog", 1, 12));
    titledBorder2.setTitleFont(new java.awt.Font("Dialog", 1, 12));
    pnlBatchUpdate1styUpProdEndRmrk.setBorder(titledBorder4);
    pnlBatchUpdate1styUpProdEndRmrk.setBounds(new Rectangle(5, 31, 532, 135));
    pnlBatchUpdate1styUpProdEndRmrk.setLayout(null);
    blueBkgWhiteCharLabel2.setText("Batch #");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(299, 12, 80, 21));
    txtBatchNo4StyUpProdEndRmrk.setText("");
    txtBatchNo4StyUpProdEndRmrk.setBounds(new Rectangle(379, 11, 132, 21));
    pnlProdRefNolis.setBorder(titledBorder7);
    pnlProdRefNolis.setBounds(new Rectangle(10, 30, 509, 98));
    //pnlProdRefNolis.setLayout(null);
    txtProdHeadPk[0].setText("");
    //txtProdHeadPk[0].setBounds(new Rectangle(8, 14, 73, 25));
    //txtProdHeadPk[1].setBounds(new Rectangle(90, 14, 73, 25));
    txtProdHeadPk[1].setText("");
    //txtProdHeadPk[2].setBounds(new Rectangle(172, 14, 73, 25));
    txtProdHeadPk[2].setText("");
    //txtProdHeadPk[3].setBounds(new Rectangle(254, 14, 73, 25));
    txtProdHeadPk[3].setText("");
    //txtProdHeadPk[4].setBounds(new Rectangle(336, 14, 73, 25));
    txtProdHeadPk[4].setText("");
    //txtProdHeadPk[5].setBounds(new Rectangle(418, 14, 73, 25));
    txtProdHeadPk[5].setText("");
    txtProdHeadPk[6].setText("");
    //txtProdHeadPk[6].setBounds(new Rectangle(90, 41, 73, 25));
    txtProdHeadPk[7].setText("");
    //txtProdHeadPk[7].setBounds(new Rectangle(336, 41, 73, 25));
    txtProdHeadPk[8].setText("");
    //txtProdHeadPk[8].setBounds(new Rectangle(254, 41, 73, 25));
    txtProdHeadPk[9].setText("");
    //txtProdHeadPk[9].setBounds(new Rectangle(418, 41, 73, 25));
    //txtProdHeadPk[10].setBounds(new Rectangle(8, 41, 73, 25));
    txtProdHeadPk[10].setText("");
    txtProdHeadPk[11].setText("");
    //txtProdHeadPk[11].setBounds(new Rectangle(172, 41, 73, 25));
    //txtProdHeadPk[12].setBounds(new Rectangle(254, 68, 73, 25));
    txtProdHeadPk[12].setText("");
    //txtProdHeadPk[13].setBounds(new Rectangle(172, 68, 73, 25));
    txtProdHeadPk[13].setText("");
    //txtProdHeadPk[14].setBounds(new Rectangle(90, 68, 73, 25));
    txtProdHeadPk[14].setText("");
    //txtProdHeadPk[15].setBounds(new Rectangle(418, 68, 73, 25));
    txtProdHeadPk[15].setText("");
    //txtProdHeadPk[16].setBounds(new Rectangle(336, 68, 73, 25));
    txtProdHeadPk[16].setText("");
    txtProdHeadPk[17].setText("");
    //txtProdHeadPk[17].setBounds(new Rectangle(8, 68, 73, 25));
    jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12));
    jLabel1.setForeground(Color.red);
    jLabel1.setText("V");
    jLabel1.setBounds(new Rectangle(253, 168, 20, 17));
    blueBkgWhiteCharLabel3.setText("REMARK TEXT CONTEXT");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(9, 167, 227, 20));
    jScrollPane1.setBounds(new Rectangle(8, 188, 354, 69));
    txtRemarkData.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtRemarkData.setText("");
    btnGenProdHeadStyDownRmrk.setBounds(new Rectangle(562, 82, 178, 42));
    btnGenProdHeadStyDownRmrk.setFont(new java.awt.Font("Dialog", 0, 12));
    btnGenProdHeadStyDownRmrk.setActionCommand("<html><body>GENERATE<br>PROD HEAD & STYLE DOWN (QTY-COLOR)<br>DESCRIPTOIN</body></html>");
    btnGenProdHeadStyDownRmrk.setText("GET DESCRIPTION");
    btnGenProdHeadStyDownRmrk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGenProdHeadStyDownRmrk_actionPerformed(e);
      }
    });
    btnUpdate2ProdEndRmrk.setBounds(new Rectangle(365, 172, 234, 37));
    btnUpdate2ProdEndRmrk.setText("UPDATE TO END REMARK");
    btnUpdate2ProdEndRmrk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate2ProdEndRmrk_actionPerformed(e);
      }
    });
    btnUpdate1stStyleUpRemark.setText("UPDATE TO 1st Style Up REMARK");
    btnUpdate1stStyleUpRemark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate1stStyleUpRemark_actionPerformed(e);
      }
    });
    btnUpdate1stStyleUpRemark.setBounds(new Rectangle(367, 218, 232, 37));
    pnlUpdateByUpload.setBackground(new Color(255, 255, 210));
    pnlUpdateByUpload.setBorder(titledBorder8);
    pnlUpdateByUpload.setBounds(new Rectangle(2, 267, 791, 304));
    pnlUpdateByUpload.setLayout(null);
    jPanel1.setBackground(new Color(184, 223, 217));
    jPanel1.setForeground(Color.black);
    jPanel1.setBounds(new Rectangle(7, 17, 389, 112));
    jPanel1.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("REF#:");
    jLabel2.setBounds(new Rectangle(6, 2, 38, 23));
    txtType2RefNo0.setText("");
    txtType2RefNo0.setBounds(new Rectangle(39, 2, 83, 23));
    jLabel3.setBounds(new Rectangle(126, 2, 53, 23));
    jLabel3.setText("STYLE#:");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    txtType2StyStyle0.setBounds(new Rectangle(173, 2, 83, 23));
    txtType2StyStyle0.setText("");
    txtType2StyPo0.setText("");
    txtType2StyPo0.setBounds(new Rectangle(299, 2, 83, 23));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("PO#:");
    jLabel4.setBounds(new Rectangle(264, 2, 36, 23));
    txtStyleUpRemark0.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtStyleUpRemark0.setText("");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(5, 28, 227, 20));
    blueBkgWhiteCharLabel4.setText("REMARK TEXT CONTEXT");
    jScrollPane2.setBounds(new Rectangle(4, 49, 354, 56));
    jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12));
    jLabel5.setForeground(Color.red);
    jLabel5.setText("V");
    jLabel5.setBounds(new Rectangle(249, 29, 20, 17));
    jLabel6.setBounds(new Rectangle(259, 2, 31, 23));
    jLabel6.setText("PO#:");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel2.setLayout(null);
    jPanel2.setBounds(new Rectangle(405, 17, 379, 111));
    jPanel2.setForeground(Color.black);
    jPanel2.setBackground(new Color(210, 164, 190));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel7.setText("REF#:");
    jLabel7.setBounds(new Rectangle(6, 2, 38, 23));
    txtType2StyStyle1.setBounds(new Rectangle(173, 2, 83, 23));
    txtType2StyStyle1.setText("");
    txtStyleUpRemark1.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtStyleUpRemark1.setText("");
    jLabel8.setBounds(new Rectangle(126, 2, 53, 23));
    jLabel8.setText("STYLE#:");
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    txtType2RefNo1.setText("");
    txtType2RefNo1.setBounds(new Rectangle(39, 2, 83, 23));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(5, 28, 227, 20));
    blueBkgWhiteCharLabel5.setBackground(Color.white);
    blueBkgWhiteCharLabel5.setForeground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel5.setText("REMARK TEXT CONTEXT");
    txtType2StyPo1.setText("");
    txtType2StyPo1.setBounds(new Rectangle(287, 3, 83, 23));
    jScrollPane3.setBounds(new Rectangle(4, 49, 354, 53));
    jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12));
    jLabel9.setForeground(Color.red);
    jLabel9.setText("V");
    jLabel9.setBounds(new Rectangle(249, 29, 20, 17));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel10.setText("STYLE#:");
    jLabel10.setBounds(new Rectangle(124, 2, 55, 23));
    txtStyleUpRemark2.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtStyleUpRemark2.setText("");
    blueBkgWhiteCharLabel6.setText("REMARK TEXT CONTEXT");
    blueBkgWhiteCharLabel6.setForeground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel6.setBackground(Color.white);
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(5, 28, 227, 20));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel11.setText("PO#:");
    jLabel11.setBounds(new Rectangle(259, 2, 31, 23));
    txtType2RefNo2.setBounds(new Rectangle(39, 2, 83, 23));
    txtType2RefNo2.setText("");
    txtType2StyPo2.setBounds(new Rectangle(287, 3, 83, 23));
    txtType2StyPo2.setText("");
    jPanel3.setBackground(new Color(210, 230, 138));
    jPanel3.setForeground(Color.black);
    jPanel3.setBounds(new Rectangle(7, 131, 389, 117));
    jPanel3.setLayout(null);
    txtType2StyStyle2.setBounds(new Rectangle(173, 2, 83, 23));
    txtType2StyStyle2.setText("");
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel12.setText("REF#:");
    jLabel12.setBounds(new Rectangle(6, 2, 38, 23));
    jScrollPane4.setBounds(new Rectangle(4, 49, 354, 59));
    jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12));
    jLabel13.setForeground(Color.red);
    jLabel13.setText("V");
    jLabel13.setBounds(new Rectangle(249, 29, 20, 17));
    jLabel14.setBounds(new Rectangle(269, 2, 36, 23));
    jLabel14.setText("PO#:");
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(405, 129, 379, 112));
    jPanel4.setForeground(Color.black);
    jPanel4.setBackground(new Color(184, 223, 217));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel15.setText("REF#:");
    jLabel15.setBounds(new Rectangle(6, 2, 38, 23));
    txtType2StyStyle3.setBounds(new Rectangle(173, 2, 83, 23));
    txtType2StyStyle3.setText("");

    jLabel16.setBounds(new Rectangle(126, 2, 53, 23));
    jLabel16.setText("STYLE#:");
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 11));
    txtType2RefNo3.setText("");
    txtType2RefNo3.setBounds(new Rectangle(39, 2, 83, 23));
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(5, 28, 227, 20));
    blueBkgWhiteCharLabel7.setText("REMARK TEXT CONTEXT");
    txtType2StyPo3.setText("");
    txtType2StyPo3.setBounds(new Rectangle(299, 2, 76, 23));
    jScrollPane5.setBounds(new Rectangle(4, 49, 354, 56));
    jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12));
    jLabel17.setForeground(Color.red);
    jLabel17.setText("V");
    jLabel17.setBounds(new Rectangle(249, 29, 20, 17));
    btnUpdateStyleUpRemark.setBounds(new Rectangle(533, 254, 207, 34));
    btnUpdateStyleUpRemark.setFont(new java.awt.Font("Dialog", 0, 12));
    btnUpdateStyleUpRemark.setText("UPDATE STYLE UP REMARK");
    btnUpdateStyleUpRemark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdateStyleUpRemark_actionPerformed(e);
      }
    });
    txtStyleUpRemark3.setFont(new java.awt.Font("DialogInput", 0, 12));
    btnExit.setBounds(new Rectangle(561, 37, 104, 38));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 16));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    cbxReports.setBounds(new Rectangle(541, 136, 164, 26));
    btnReports.setBounds(new Rectangle(705, 135, 77, 26));
    btnReports.setFont(new java.awt.Font("Dialog", 1, 12));
    btnReports.setText("PRINT!!");
    btnReports.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReports_actionPerformed(e);
      }
    });
    btnUpdateStyleUpRemark1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdateStyleUpRemark1_actionPerformed(e);
      }
    });
    btnUpdateStyleUpRemark1.setText("<html><body>UPDATE STYLE UP REMARK<br>By Upload</body></html>");
    btnUpdateStyleUpRemark1.setFont(new java.awt.Font("Dialog", 0, 12));
    btnUpdateStyleUpRemark1.setBounds(new Rectangle(114, 253, 211, 44));
    btnModifyDestPlanDlv.setBounds(new Rectangle(603, 172, 184, 37));
    btnModifyDestPlanDlv.setText("Batch Modify Destination");
    btnModifyDestPlanDlv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnModifyDestPlanDlv_actionPerformed(e);
      }
    });
    btnBatchGetSc.setBounds(new Rectangle(603, 218, 184, 37));
    btnBatchGetSc.setText("GET S/C#");
    btnBatchGetSc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBatchGetSc_actionPerformed(e);
      }
    });
    btnClearAllRefNo.setBounds(new Rectangle(184, 13, 111, 21));
    btnClearAllRefNo.setText("CLEAR ALL");
    btnClearAllRefNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClearAllRefNo_actionPerformed(e);
      }
    });
    jPanel1.add(jLabel2, null);
    jPanel1.add(txtType2RefNo0, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(txtType2StyStyle0, null);
    jPanel1.add(blueBkgWhiteCharLabel4, null);
    jPanel1.add(jScrollPane2, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(txtType2StyPo0, null);
    jPanel1.add(jLabel4, null);
    pnlUpdateByUpload.add(jPanel3, null);
    pnlUpdateByUpload.add(jPanel2, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(txtType2RefNo1, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(txtType2StyStyle1, null);
    jPanel2.add(blueBkgWhiteCharLabel5, null);
    jPanel2.add(jScrollPane3, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(txtType2StyPo1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(jLabel1, null);
    jScrollPane3.getViewport().add(txtStyleUpRemark1, null);
    jScrollPane2.getViewport().add(txtStyleUpRemark0, null);
    pnlProdRefNolis.add(txtProdHeadPk[0], null);
    pnlProdRefNolis.add(txtProdHeadPk[1], null);
    pnlProdRefNolis.add(txtProdHeadPk[2], null);
    pnlProdRefNolis.add(txtProdHeadPk[3], null);
    pnlProdRefNolis.add(txtProdHeadPk[4], null);
    pnlProdRefNolis.add(txtProdHeadPk[5], null);
    pnlProdRefNolis.add(txtProdHeadPk[6], null);
    pnlProdRefNolis.add(txtProdHeadPk[7], null);
    pnlProdRefNolis.add(txtProdHeadPk[8], null);
    pnlProdRefNolis.add(txtProdHeadPk[9], null);
    pnlProdRefNolis.add(txtProdHeadPk[10], null);
    pnlProdRefNolis.add(txtProdHeadPk[11], null);
    pnlProdRefNolis.add(txtProdHeadPk[12], null);
    pnlProdRefNolis.add(txtProdHeadPk[13], null);
    pnlProdRefNolis.add(txtProdHeadPk[14], null);
    pnlProdRefNolis.add(txtProdHeadPk[15], null);
    pnlProdRefNolis.add(txtProdHeadPk[16], null);
    pnlProdRefNolis.add(txtProdHeadPk[17], null);
    pnlBatchUpdate1styUpProdEndRmrk.add(pnlProdRefNolis, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlBatchUpdate1styUpProdEndRmrk, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtRemarkData, null);
    this.add(pnlUpdateByUpload, null);
    pnlBatchUpdate1styUpProdEndRmrk.add(blueBkgWhiteCharLabel2, null);
    pnlBatchUpdate1styUpProdEndRmrk.add(txtBatchNo4StyUpProdEndRmrk, null);
    pnlBatchUpdate1styUpProdEndRmrk.add(btnClearAllRefNo, null);
    pnlUpdateByUpload.add(jPanel1, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(txtType2RefNo1, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(txtType2StyStyle1, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(txtType2StyPo1, null);
    jPanel3.add(jLabel12, null);
    jPanel3.add(txtType2RefNo2, null);
    jPanel3.add(jLabel10, null);
    jPanel3.add(txtType2StyStyle2, null);
    jPanel3.add(jLabel11, null);
    jPanel3.add(txtType2StyPo2, null);
    jPanel3.add(blueBkgWhiteCharLabel6, null);
    jPanel3.add(jScrollPane4, null);
    jPanel3.add(jLabel13, null);
    pnlUpdateByUpload.add(jPanel4, null);
    jPanel4.add(jLabel15, null);
    jPanel4.add(txtType2RefNo3, null);
    jPanel4.add(jLabel16, null);
    jPanel4.add(txtType2StyStyle3, null);
    jPanel4.add(blueBkgWhiteCharLabel7, null);
    jPanel4.add(jScrollPane5, null);
    jScrollPane5.getViewport().add(txtStyleUpRemark3, null);
    jPanel4.add(jLabel17, null);
    jPanel4.add(txtType2StyPo3, null);
    jPanel4.add(jLabel14, null);
    pnlUpdateByUpload.add(btnUpdateStyleUpRemark, null);
    pnlUpdateByUpload.add(btnUpdateStyleUpRemark1, null);
    this.add(btnUpdate1stStyleUpRemark, null);
    this.add(btnUpdate2ProdEndRmrk, null);
    this.add(btnExit, null);
    this.add(btnGenProdHeadStyDownRmrk, null);
    this.add(cbxReports, null);
    this.add(btnReports, null);
    this.add(btnModifyDestPlanDlv, null);
    this.add(btnBatchGetSc, null);

    jScrollPane4.getViewport().add(txtStyleUpRemark2, null);
    jPanel3.add(jLabel12, null);
    jPanel3.add(txtType2RefNo2, null);
    jPanel3.add(jLabel10, null);
    jPanel3.add(txtType2StyStyle2, null);
    jPanel3.add(jLabel11, null);
    jPanel3.add(txtType2StyPo2, null);

    Object chkDcm32 = exgui.verification.CellFormat.getIntVerifierAllowNull(20);
       for(int i=0;i<18;i++){
         exgui.DataBindTextWithChecker xfvytxt =
           new exgui.DataBindTextWithChecker(txtProdHeadPk[i],null,null,10,
                                            (exgui.Object2String)chkDcm32,
                                            (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
        }
        exgui.DataBindTextWithChecker xfvytxtPk0 =
          new exgui.DataBindTextWithChecker(txtType2RefNo0,null,null,10,
                                           (exgui.Object2String)chkDcm32,
                                           (exgui.ultratable.CellTxtEditorFormat)chkDcm32);

     exgui.DataBindTextWithChecker xfvytxtPk1 =
       new exgui.DataBindTextWithChecker(txtType2RefNo1,null,null,10,
                                        (exgui.Object2String)chkDcm32,
                                        (exgui.ultratable.CellTxtEditorFormat)chkDcm32);

  exgui.DataBindTextWithChecker xfvytxtPk2 =
    new exgui.DataBindTextWithChecker(txtType2RefNo2,null,null,10,
                                     (exgui.Object2String)chkDcm32,
                                     (exgui.ultratable.CellTxtEditorFormat)chkDcm32);

    exgui.DataBindTextWithChecker xfvytxtPk3 =
      new exgui.DataBindTextWithChecker(txtType2RefNo3,null,null,10,
                                       (exgui.Object2String)chkDcm32,
                                       (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
     exgui.ultratable.Wraper4tblCbx wper[]=new exgui.ultratable.Wraper4tblCbx[6];
      for(int i=0;i<6;i++){
        wper[i] = new exgui.ultratable.Wraper4tblCbx();
      }
     wper[0].setString("DRAFT");wper[0].setValue("SC_DOC_DRAFT.rpt");
     wper[1].setString("PROFIT");wper[1].setValue("SC_PROFIT.rpt");
     wper[2].setString("CT REF");wper[2].setValue("CT_DOC_REF.rpt");
     wper[3].setString("S/C");wper[3].setValue("SC_DOC.rpt");
     wper[4].setString("C/T");wper[4].setValue("CT_DOC.rpt");
     wper[5].setString("Q.C");wper[5].setValue("CT_DOC_REF_QC.rpt");
     javax.swing.ComboBoxModel cbxmdl=new javax.swing.DefaultComboBoxModel(wper);
     cbxReports.setModel(cbxmdl);
  }
  class MyTextField
      extends JTextField
     implements java.awt.event.FocusListener
     {
    int indexInArr;
    MyTextField(){
       super();
       this.addFocusListener(this);
    }
    public void focusGained(java.awt.event.FocusEvent fe){
      //if current cell is blank ,find out the "next" prod-ref-pk
      if(indexInArr!=0 && this.getText().trim().length()==0){
        //search last text field's prod head pk
        for(int i=indexInArr-1;i>-1;i--){
          String prodHeadPkStr=txtProdHeadPk[i].getText().trim();
          if(prodHeadPkStr.length()>0){
            int prodheadpk=Integer.parseInt(prodHeadPkStr);
            this.setText(String.valueOf(prodheadpk+1));
            break;
          }
        }
      }
    }
    public void focusLost(java.awt.event.FocusEvent fe){

    }
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  boolean ifHaveProdHeadPkOrBatchNo(){
    if(txtBatchNo4StyUpProdEndRmrk.getText().trim().length()>0)return true;
   for(int i=0;i<18;i++){
      if(txtProdHeadPk[i].getText().trim().length()>0)return true;
   }
   return false;
  }
  void btnGenProdHeadStyDownRmrk_actionPerformed(ActionEvent e) {
     try{
       if(!ifHaveProdHeadPkOrBatchNo()){
         exgui.verification.VerifyLib.showAlert("Please Input Prod Ref No Or Batch No",
                                                "Please Input Prod Ref No Or Batch No");
         return;
       }
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                  "newtimesejb.TPE_MIS.TpeMisFunc");
         newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
         java.util.HashMap hmparam=new java.util.HashMap();
         hmparam.put("TPEMISCFUNC_ACTION_CODE","BATCH_GET_REMARK");
         hmparam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
         StringBuffer sb=new StringBuffer();
         for(int i=0;i<18;i++){
           String pk=txtProdHeadPk[i].getText().trim();
           if(pk.length()>0){
              if(sb.length()>0)sb.append(",");
              sb.append(pk);
           }
         }
         hmparam.put("prod_head_pk_list",sb.length()>0?sb.toString():null);
         hmparam.put("batch_no",(txtBatchNo4StyUpProdEndRmrk.getText().trim().length()==0)?null:
                     txtBatchNo4StyUpProdEndRmrk.getText().trim());
         util.MiscFunc.showProcessingMessage();
         java.util.HashMap hm=ejb.tpeMisFunc(hmparam);
         exgui.verification.VerifyLib.showPlanMsg((String)hm.get("MSG"),"RESULT");
     }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
         exgui.verification.VerifyLib.showAlert("ERROR!! Please Contact System Manager",
                                                "ERROR!! Please Contact System Manager");
     }
  }

  void btnUpdate2ProdEndRmrk_actionPerformed(ActionEvent e) {
    try{
      if(!ifHaveProdHeadPkOrBatchNo()){
        exgui.verification.VerifyLib.showAlert("Please Input Prod Ref No Or Batch No",
                                               "Please Input Prod Ref No Or Batch No");
        return;
      }
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                 "newtimesejb.TPE_MIS.TpeMisFunc");
        newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
        java.util.HashMap hmparam=new java.util.HashMap();
        hmparam.put("TPEMISCFUNC_ACTION_CODE","BATCH_UPDATE_PROD_END_REMARK");
        hmparam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<18;i++){
          String pk=txtProdHeadPk[i].getText().trim();
          if(pk.length()>0){
             if(sb.length()>0)sb.append(",");
             sb.append(pk);
          }
        }
        hmparam.put("prod_head_pk_list",sb.length()>0?sb.toString():null);
        hmparam.put("batch_no",(txtBatchNo4StyUpProdEndRmrk.getText().trim().length()==0)?null:
                    txtBatchNo4StyUpProdEndRmrk.getText().trim());
        hmparam.put("remark",txtRemarkData.getText().trim());
        util.MiscFunc.showProcessingMessage();
        java.util.HashMap hm=ejb.tpeMisFunc(hmparam);
        exgui.verification.VerifyLib.showPlanMsg((String)hm.get("MSG"),"RESULT");
    }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("ERROR!! Please Contact System Manager",
                                               "ERROR!! Please Contact System Manager");
    }

  }

  void btnUpdate1stStyleUpRemark_actionPerformed(ActionEvent e) {
    try{
      if(!ifHaveProdHeadPkOrBatchNo()){
        exgui.verification.VerifyLib.showAlert("Please Input Prod Ref No Or Batch No",
                                               "Please Input Prod Ref No Or Batch No");
        return;
      }
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                 "newtimesejb.TPE_MIS.TpeMisFunc");
        newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
        java.util.HashMap hmparam=new java.util.HashMap();
        hmparam.put("TPEMISCFUNC_ACTION_CODE","BATCH_UPDATE_1ST_STY_UP_REMARK");
        hmparam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<18;i++){
          String pk=txtProdHeadPk[i].getText().trim();
          if(pk.length()>0){
             if(sb.length()>0)sb.append(",");
             sb.append(pk);
          }
        }
        hmparam.put("prod_head_pk_list",sb.length()>0?sb.toString():null);
        hmparam.put("batch_no",(txtBatchNo4StyUpProdEndRmrk.getText().trim().length()==0)?null:
                    txtBatchNo4StyUpProdEndRmrk.getText().trim());
        hmparam.put("remark",txtRemarkData.getText().trim());
        util.MiscFunc.showProcessingMessage();
        java.util.HashMap hm=ejb.tpeMisFunc(hmparam);
        exgui.verification.VerifyLib.showPlanMsg((String)hm.get("MSG"),"RESULT");
    }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("ERROR!! Please Contact System Manager",
                                               "ERROR!! Please Contact System Manager");
    }

  }
  /**
   * test and gnereate the sql statement to update styles' up remark
   * @param txtProdPk JTextField
   * @param txtStyStyle JTextField
   * @param txtStyPo JTextField
   * @param sb StringBuffer
   * @return String,if null,means error occurs,if "" means by pass it
   */
  String generateUpdateStatement(JTextField txtProdPk,
                                    JTextField txtStyStyle,
                                    JTextField txtStyPo,
                                    JTextArea txtRemark2Update){
    //test before process ,pls chk if prod-pk is for TPE,and style & PO exists.
    StringBuffer sql=new StringBuffer();
    if(txtProdPk.getText().trim().length()==0
       && txtStyStyle.getText().trim().length()==0
        && txtStyPo.getText().trim().length()==0
        && txtRemark2Update.getText().trim().length()==0){
       return "";//by pass it.but just skip it,not error
    }
    if(txtProdPk.getText().trim().length()==0
       && (txtStyStyle.getText().trim().length()>0||
           txtStyPo.getText().trim().length()>0||
           txtRemark2Update.getText().trim().length()>0)){
        exgui.verification.VerifyLib.showAlert("Please Input Prod-Ref#",
                                               "Please Input Prod-Ref#");
        txtProdPk.grabFocus();
      return null;
    }
    //test if prod head is not tpe center.and also,test if style & po matchs the query.
    sql.append("select ");
    sql.append("a.sty_seq, ");
    sql.append("b.prod_cen_code ");
    sql.append("from style a,prod_head b ");
    sql.append("where a.prod_head_pk=b.prod_head_pk ");
    sql.append("and  a.record_delete_flag='1' ");
    sql.append("and a.prod_head_pk=");sql.append(txtProdPk.getText().trim());sql.append(" ");
    String styStyle=txtStyStyle.getText().trim();
    if(styStyle.length()>0){
      sql.append("and a.sty_style='");
      sql.append(util.MiscFunc.Replace(styStyle.toUpperCase(),"'","''"));
      sql.append("' ");
    }
    String styPo=txtStyPo.getText().trim();
    if(styPo.length()>0){
      sql.append("and a.sty_po='");
      sql.append(util.MiscFunc.Replace(styPo.toUpperCase(),"'","''"));
      sql.append("' ");
    }
    //test if is TPE record
    java.util.Vector vctTest=null;
    try{
      vctTest = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql.toString(), 1, 9999999
          );
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Testing Query Condition\nPlease Contact System Manager",
                                             "Error While Testing Query Condition");
      return null;
    }
    if(vctTest.size()==0){
      StringBuffer msg=new StringBuffer();
      msg.append("REF#:");
      msg.append(txtProdPk.getText().trim()) ;
      if(styStyle.length()>0){
        msg.append(" & STYLE# :");
        msg.append(styStyle.toUpperCase());
      }
      if(styPo.length()>0){
        msg.append(" & PO# :");
        msg.append(styPo.toUpperCase());
      }
      msg.append(" 條件之下無查詢結果");
      exgui.verification.VerifyLib.showAlert(
        msg.toString(),"NO Such Condition"
      );
      return null;
    }
    database.datatype.Record recX=(database.datatype.Record)vctTest.get(0);
    if(!"001".equals(recX.get(1))){
      StringBuffer msg=new StringBuffer();
      msg.append("REF#:");
      msg.append(txtProdPk.getText().trim()) ;
      if(styStyle.length()>0){
        msg.append(" & STYLE# :");
        msg.append(styStyle.toUpperCase());
      }
      if(styPo.length()>0){
        msg.append(" & PO# :");
        msg.append(styPo.toUpperCase());
      }
      msg.append(" 非台北訂單");
      exgui.verification.VerifyLib.showAlert(
        msg.toString(),"This PO Doese Not Belong to TPE Center"
      );
      return null;
    }
    StringBuffer sb=new StringBuffer();
    sb.append("update style set sty_sc_up_rmrk='");
    sb.append(util.MiscFunc.Replace(util.MiscFunc.Replace(txtRemark2Update.getText().trim(),"'","''"),"\t","       ",false));
    sb.append("',##123456THIS_IS_USER_FIELD123456###,##123456THIS_IS_MODIFY_DATE_FIELD123456## ");
    sb.append("where sty_seq in (");
    for(int i=0;i<vctTest.size();i++){
      database.datatype.Record rec=(database.datatype.Record)vctTest.get(i);
      if(i>0)sb.append(",");
      sb.append(rec.get(0).toString());
    }
    sb.append(")");
    return sb.toString();
  }
  void btnUpdateStyleUpRemark_actionPerformed(ActionEvent e) {
    java.util.List sqls=new java.util.ArrayList();
    String result=generateUpdateStatement(txtType2RefNo0,txtType2StyStyle0,txtType2StyPo0,txtStyleUpRemark0);
    if(result==null){
      return;
    }
    if(!"".equals(result)){
      sqls.add(result);
    }
    String result2=generateUpdateStatement(txtType2RefNo1,txtType2StyStyle1,txtType2StyPo1,txtStyleUpRemark1);
    if(null==result2){
      return;
    }
    if(!"".equals(result2)){
      sqls.add(result2);
    }

    String result3=generateUpdateStatement(txtType2RefNo2,txtType2StyStyle2,txtType2StyPo2,txtStyleUpRemark2);
    if(null==result3){
      return;
    }
    if(!"".equals(result3)){
      sqls.add(result3);
    }

    String result4=generateUpdateStatement(txtType2RefNo3,txtType2StyStyle3,txtType2StyPo3,txtStyleUpRemark3);
    if(null==result4){
      return;
    }
    if(!"".equals(result4)){
      sqls.add(result4);
    }
    if(sqls.size()==0){
      exgui.verification.VerifyLib.showAlert("No target PO to update","No target PO to update");
      return;
    }
    try{
    //call ejb to update
    newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
        (newtimesejb.TPE_MIS.TpeMisFuncHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                               "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
      java.util.HashMap hmparam=new java.util.HashMap();
      hmparam.put("TPEMISCFUNC_ACTION_CODE","BATCH_UPDATE_STY_UP_REMARK_QUARTETE");
      hmparam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
      hmparam.put("sqls",sqls);
      util.MiscFunc.showProcessingMessage();
      java.util.HashMap hm=ejb.tpeMisFunc(hmparam);
      exgui.verification.VerifyLib.showPlanMsg((String)hm.get("MSG"),"RESULT");
  }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Connection ERROR!! Please Contact System Manager",
                                             "ERROR!! Please Contact System Manager");
  }



  }

  void btnReports_actionPerformed(ActionEvent e) {
    if(!ifHaveProdHeadPkOrBatchNo()){
      exgui.verification.VerifyLib.showAlert("Please Input Prod Ref No Or Batch No",
                                             "Please Input Prod Ref No Or Batch No");
      return;
    }
    StringBuffer sb=new StringBuffer();

    for(int i=0;i<18;i++){
      String pk=txtProdHeadPk[i].getText().trim();
      if(pk.length()>0){
         if(sb.length()>0)sb.append(",");
         sb.append(pk);
      }
    }

     String reportName=(String)((exgui.ultratable.Wraper4tblCbx)cbxReports.getSelectedItem()).getValue();
     util.MiscFunc.showProcessingMessage();
    if(sb.length()>0){
      //test if pro-head pk are tpe's center.
      String msg=checkIfTpeCenter(sb.toString(),false);
      if(null==msg) return;
    }else{
      //search from batch NO .
      String result=chkBatchNoAndGenProdHeadPkList(util.MiscFunc.Replace(txtBatchNo4StyUpProdEndRmrk.getText().trim(),"'","''"));
      if(null==result)return;
      sb.append(result);
    }


    try{
      String pkList[]=util.MiscFunc.split(sb.toString(),",");

      //if is sc report,,have to add []
      for(int i=0;i<pkList.length;i++){
        com.inet.viewer.ReportViewerBean viewer = new com.inet.viewer.ReportViewerBean();
        java.util.HashMap paraHm = new java.util.HashMap();
        paraHm.put("TIMES","1");
        paraHm.put("DOC_ACT","1");
        String pkObj=null;
        if(reportName.equalsIgnoreCase("SC_DOC.rpt")){
          pkObj="["+pkList[i]+"]";
        }else{
          pkObj=pkList[i];
        }
        paraHm.put("PROD_PK",pkObj);paraHm.put("iProd_HEAD_PK",pkObj);
        String reportServerURL="http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";
        viewer.setReportName(reportServerURL+reportName);

        //get random as prameter for refresh
        java.util.Iterator itr=paraHm.keySet().iterator();
        while(itr.hasNext()){
          String keyObj=(String)itr.next();
          Object value=paraHm.get(keyObj);
          viewer.setReportParameter(keyObj,(value==null)?"":value.toString());
        }
        viewer.printView(false);
        viewer.closeCurrentView();
        viewer=null;
        System.gc();
      }

      exgui.verification.VerifyLib.showPlanMsg("Print OK","Print OK");

       /*
       exgui.verification.VerifyLib.showPlanMsg("Print Job already Sent to printer ",
                                                "Print Job already Sent to Printer");
       */
      //viewer.start();
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Error While set param to reportviewer,plese chk",
                                              "Error While set param to reportviewer");

    }

    /*
    hmparam.put("prod_head_pk_list",sb.length()>0?sb.toString():null);
    hmparam.put("batch_no",(txtBatchNo4StyUpProdEndRmrk.getText().trim().length()==0)?null:
                txtBatchNo4StyUpProdEndRmrk.getText().trim());
    */
  }

  void btnUpdateStyleUpRemark1_actionPerformed(ActionEvent e) {
     java.io.File file2Proc=showFileChooser();
     if(null==file2Proc)return;
     javax.swing.JTextField txtProdHead4Excel=new javax.swing.JTextField();
     javax.swing.JTextField txtStyle4Excel=new javax.swing.JTextField();
     javax.swing.JTextField txtPo4Excel=new javax.swing.JTextField();
     javax.swing.JTextArea txtRemark4Excel=new javax.swing.JTextArea();
     java.util.List sqls=new java.util.ArrayList();
     try{
      Workbook workbook =Workbook.getWorkbook(file2Proc);
       Sheet sheet = workbook.getSheet(0);
       for (int i = 1; i < sheet.getRows(); i++) {
         Cell[] cells = sheet.getRow(i);
         if (null == cells[0].getContents() ||
             "".equalsIgnoreCase(cells[0].getContents().trim()))continue;
           String prodPk=cells[0].getContents();
           txtProdHead4Excel.setText(prodPk==null?"":prodPk);
           String styStyle=cells[1].getContents();
           txtStyle4Excel.setText(styStyle==null?"":styStyle);
           String styPo=cells[2].getContents();
           txtPo4Excel.setText(styPo==null?"":styPo);
           StringBuffer remark=new StringBuffer();
           for(int j=3;j<6;j++){
             if(j>=cells.length)break;
             String remarkLine = cells[j].getContents();
             if(null!=remarkLine && remarkLine.trim().length()>0){
               if(remark.length()>0)remark.append("\n");
               remark.append(remarkLine);
             }
           }
           txtRemark4Excel.setText(remark.toString());
           String result=generateUpdateStatement(txtProdHead4Excel,txtStyle4Excel,txtPo4Excel,txtRemark4Excel);
           if(result==null) {
             workbook.close();
             return;
           }
           if(!"".equals(result.trim())){
             sqls.add(result);
           }
       }
       workbook.close();
       if(sqls.size()==0){
         exgui.verification.VerifyLib.showAlert("No Data To Upload",
                                                "No Data To Upload");
       }
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                  "newtimesejb.TPE_MIS.TpeMisFunc");
         newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
         java.util.HashMap hmparam=new java.util.HashMap();
         hmparam.put("TPEMISCFUNC_ACTION_CODE","BATCH_UPDATE_STY_UP_REMARK_QUARTETE");
         hmparam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
         hmparam.put("sqls",sqls);
         util.MiscFunc.showProcessingMessage();
         java.util.HashMap hm=ejb.tpeMisFunc(hmparam);
         exgui.verification.VerifyLib.showPlanMsg((String)hm.get("MSG"),"RESULT");

     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Error While processing Excel file\nPlease Contact System Manager",
                                              "Error While processing Excel file");
     }finally{

       txtProdHead4Excel=null;
       txtStyle4Excel=null;
       txtPo4Excel=null;
       txtRemark4Excel=null;
     }


  }
  class myFilter extends javax.swing.filechooser.FileFilter{
     public String ext;
     public String des;

     public boolean accept(java.io.File file){
         if(file != null) {
           if(file.isDirectory()) {
              return true;
           }
           String filename=file.getName();
           return filename.endsWith(ext);
         }
         return false;
     }
     public String getDescription(){
        return des;
    }

     public myFilter(String extension, String description) {
       if(extension!=null) ext=extension;
       if(description!=null) des=description;
     }

  }
  java.io.File  showFileChooser(){
    JFileChooser fc = new JFileChooser();
    fc.setDialogType(fc.OPEN_DIALOG);
    fc.setAcceptAllFileFilterUsed(false);
    fc.addChoosableFileFilter(new myFilter("xls","EXCEL FILE"));
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    int returnVal = fc.showDialog(this, "SELECT FILE");
    if (returnVal == JFileChooser.APPROVE_OPTION) {
     java.io.File srcFile = fc.getSelectedFile();
     if(!srcFile.exists())return null;
      return srcFile;
    }
    return null;
  }
  static String chkBatchNoAndGenProdHeadPkList(String batchNo){
    StringBuffer sql=new StringBuffer();
    sql.append("select prod_head_pk from TPE_NB_BATCH_NO where batch_no  = '");
    sql.append(batchNo);
    sql.append("' order by prod_head_pk ");
    StringBuffer sb=new StringBuffer();
    try{
      java.util.Vector vctTest = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql.toString(), 1, 99999
          );
       if(vctTest.size()==0){
         exgui.verification.VerifyLib.showAlert("BATCH#"+batchNo+" not found"
                                                ,"BATCH# NOT FONT");
         return null;
       }else{
           sb=new StringBuffer();
           for(int i=0;i<vctTest.size();i++){
             database.datatype.Record rec=(database.datatype.Record)vctTest.get(i);
             if(sb.length()>0)sb.append(",");
             sb.append(rec.get(0).toString());
           }
           return sb.toString();
       }
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Checking Batch No",
                                             "Error While Checking Batch No");
      return null;
    }

  }
  /**
   * chk if prod head pk (113241,13412,...,xxx,xxxx,) are tpe center or now.
   * @param prodHeadPkCamaList String
   * @return String,if "" means ok, if null ,means invailid or error
   */
  static String checkIfTpeCenter(String prodHeadPkCamaList,boolean chkSc){
    StringBuffer sql=new StringBuffer();
    sql.append("select a.prod_head_pk,a.prod_cen_code from prod_head a,production b where   a.prod_head_pk=b.prod_head_pk ");
    sql.append("and a.prod_head_pk in (");
    sql.append(prodHeadPkCamaList);
    sql.append(") and ( ");
    sql.append(" a.prod_cen_code <> '001'");
    if(chkSc){
       sql.append(" or ");
       sql.append(" b.prod_sc_no is not null ");
    }
    sql.append(" )");
    try{
      java.util.Vector vctTestCen = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql.toString(), 1, 99999);
      if(vctTestCen.size()>0){
        StringBuffer msg=new StringBuffer();
        for(int i=0;i<vctTestCen.size();i++){
          database.datatype.Record rec=(database.datatype.Record)vctTestCen.get(i);
          if(msg.length()>0)msg.append(",");
          msg.append(rec.get(0).toString());
        }
        exgui.verification.VerifyLib.showAlert("REF #"+msg.toString()+" 非台北訂單 "+((chkSc)?"或已有S/C#":"")   ,
                                               "REF #"+msg.toString()+" 非台北訂單"+((chkSc)?"或已有S/C#":""));
        return null;
      }
      return "";
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Checking Center Of REF NO\nPlease Contact System Manager",
                                             "Error While Checking Center Of REF NO");
      return null;
    }

  }
  void btnModifyDestPlanDlv_actionPerformed(ActionEvent e) {
    if(!ifHaveProdHeadPkOrBatchNo()){
      exgui.verification.VerifyLib.showAlert("Please Input Prod Ref No Or Batch No",
                                             "Please Input Prod Ref No Or Batch No");
      return;
    }
    // if have prod head pk,list it
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<18;i++){
      String pk=txtProdHeadPk[i].getText().trim();
      if(pk.length()>0){
         if(sb.length()>0)sb.append(",");
         sb.append(pk);
      }
    }
    //tets if is TPE center
    if(sb.length()>0){
       if(null==checkIfTpeCenter(sb.toString(),false))return;
    }
    if(sb.length()==0){
      String batchNo = txtBatchNo4StyUpProdEndRmrk.getText().trim();
      batchNo = util.MiscFunc.Replace(batchNo, "'", "''");
      String result=chkBatchNoAndGenProdHeadPkList(batchNo);
      if(null==result)return;
      sb.append(result);
    }
      //call the dialgbox to show.
      DlgModifyProdsDestPlanDlv dlg=new
          DlgModifyProdsDestPlanDlv(util.PublicVariable.APP_FRAME,"MODIFY DEST & PLAN DLV",
                                    sb.toString(),true);
          dlg.setSize(800,520);
          exgui.UIHelper.setToScreenCenter(dlg);
          dlg.setPanel2List();
          dlg.show();
          util.MiscFunc.showProcessingMessage();
          util.MiscFunc.hideProcessingMessage();
  }

  void btnBatchGetSc_actionPerformed(ActionEvent e) {
    if(!ifHaveProdHeadPkOrBatchNo()){
      exgui.verification.VerifyLib.showAlert("Please Input Prod Ref No Or Batch No",
                                             "Please Input Prod Ref No Or Batch No");
      return;
    }

    //test prod head pk have s/c# or not.
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<18;i++){
      String pk=txtProdHeadPk[i].getText().trim();
      if(pk.length()>0){
         if(sb.length()>0)sb.append(",");
         sb.append(pk);
      }
    }
    if(sb.length()>0){
      if (null == checkIfTpeCenter(sb.toString(), true))return;
    }else{
      String batchNo = txtBatchNo4StyUpProdEndRmrk.getText().trim();
      batchNo = util.MiscFunc.Replace(batchNo, "'", "''");
      String result=chkBatchNoAndGenProdHeadPkList(batchNo);
      if(null==result)return;
      sb.append(result);
    }

    try{
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome =
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb = ejbHome.create();
      java.util.HashMap hmparam = new java.util.HashMap();
      hmparam.put("TPEMISCFUNC_ACTION_CODE","BATCH_GET_SC_NO");
      hmparam.put("user_code", util.PublicVariable.USER_RECORD.get(0));
      hmparam.put("prod_head_pk_list", sb.toString());
      util.MiscFunc.showProcessingMessage();
      ejb.tpeMisFunc(hmparam);
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showPlanMsg("S/C# Generated","S/C# Generated");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Batch Get S/C#\nPlease Contact System Manager",
                                             "Error While Batch Get S/C#");
    }

  }

  void btnClearAllRefNo_actionPerformed(ActionEvent e) {
     for(int i=0;i<txtProdHeadPk.length;i++)txtProdHeadPk[i].setText("");
  }

}
