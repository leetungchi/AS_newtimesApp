package newtimes.production.report;
import database.datatype.Record;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import java.util.*;
import newtimes.preproduction.guis.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryCrossSummaryQtyAmtPrt
    //extends JPanel {
    extends AbsQryPanel{
    static int COMBOBOX_COUNT=14;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JComboBox cbxDiv = new JComboBox();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel lblQcCountry = new JLabel();
  JComboBox cbxQcCountry = new JComboBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  JComboBox cbxDep[] = new JComboBox[COMBOBOX_COUNT];
  JPanel pnlDuriation = new JPanel();
  Border border1;
  TitledBorder titledBorder2;
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtDateBgn = new JTextField();
  JTextField txtDateEnd = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JRadioButton rdoPrintAmt = new JRadioButton();
  JRadioButton rdoPrintQty = new JRadioButton();
  JRadioButton rdoPrintAll = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoTypePending = new JRadioButton();
  JRadioButton rdoTypeShip = new JRadioButton();
  JRadioButton rdoTypeOdr = new JRadioButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  ButtonGroup rdoBtnGrpType = new ButtonGroup();
  ButtonGroup rdoBtnColumnBy = new ButtonGroup();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  ButtonGroup rdoGrpRowBy = new ButtonGroup();
  JRadioButton rdoRowByFTY = new JRadioButton();
  JRadioButton rdoRowByBuyer = new JRadioButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  JRadioButton rdoRowByCountry = new JRadioButton();
  JRadioButton rdoKbnMstCpmNo = new JRadioButton();
  JRadioButton rdoKbnMstCpmYes = new JRadioButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  ButtonGroup rdoGrpCombineMaserCompany = new ButtonGroup();
  ButtonGroup rdoGrpKbmDiv = new ButtonGroup();
  JRadioButton rdoKbnDivNo = new JRadioButton();
  JRadioButton rdoKbnDivYes = new JRadioButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel8 = new WhiteBkgBlueCharLabel();
  JRadioButton rdoXldScNo = new JRadioButton();
  JRadioButton rdoXldScYes = new JRadioButton();
  ButtonGroup rdoGrpXldSc = new ButtonGroup();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel9 = new WhiteBkgBlueCharLabel();
  JRadioButton rdoPcDzNo = new JRadioButton();
  JRadioButton rdoPcDzYes = new JRadioButton();
  ButtonGroup rdoGrpOnlyPcDz = new ButtonGroup();
  JButton btnReport = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  exgui.DataBindJCombobox DbJcbxcbxDiv ;
  DataBindJCombobox dbJcbxQcCountry,dbCbxDep[];
  exgui.DataBindTextWithChecker  dbTxtYear,dbTxtYearTo;
  boolean doingDB2Gui=false;
  int divCbxDBGUI_index=0;
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  JLabel jLabel4 = new JLabel();
  JComboBox cbxOffShoreCenter = new JComboBox();
  JComboBox cbxProdType = new JComboBox();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JComboBox cbxFontSize = new JComboBox(new String[]{"10","12","14"});
  JLabel lblManager = new JLabel();
  JComboBox cbxManager = new JComboBox();
  JTextField   txtTwdUsd=new JTextField();
  JTextField   txtRmbUsd=new JTextField();
  JTextField   txtHkdUsd=new JTextField();


  /*
  //------preserve for layout
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  //--------------------------------
  */
  JLabel lblStyle = new JLabel();
  JTextField txtStyle = new JTextField();
  JLabel lblPO = new JLabel();
  JTextField txtPO = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel10 = new WhiteBkgBlueCharLabel();
  JRadioButton rdoExSmpl_N = new JRadioButton();
  JRadioButton rdoExSmpl_Y = new JRadioButton();
  ButtonGroup buttonrdoExSmpl = new ButtonGroup();
  JLabel jLabel7 = new JLabel();
  JComboBox cbxRowTtl = new JComboBox(new String[]{"Yes","No"});
  public JRadioButton rdoRowByDest = new JRadioButton();
  JLabel jLabel8 = new JLabel();
  JTextField txtYearTo = new JTextField();
  JComboBox cbxColumnBy = new JComboBox(new String[]{"MONTH","YEAR(DEL,ETD)","SEASON","CREATE USER"});
  String[] strColumnByArr=new String[]{"M","Y","S","U"};

  public PnlQryCrossSummaryQtyAmtPrt() {
    try {
      //jbInit();
//      rdoRowByDest.setVisible(false);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    for(int i=0;i<COMBOBOX_COUNT;i++){
      cbxDep[i]=new JComboBox();
    }
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Departments");
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"DEL-DD OR ETD");
    blueBkgWhiteCharLabel1.setToolTipText("");
    blueBkgWhiteCharLabel1.setText("Summary-Quantity-Amount Report");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 1, 800, 24));
    this.setLayout(null);
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(209, 125, 55, 18));
    whiteBkgBlueCharLabel4.setText("Maker");
    jLabel1.setBounds(new Rectangle(204, 175, 71, 24));
    jLabel1.setText("Season Year");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(1, 28, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(211, 74, 40, 20));
    blueBkgWhiteCharLabel4.setText("Buyer");
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(47, 28, 117, 22));
    cbxDiv.setBounds(new Rectangle(261, 100, 142, 21));
    slkBuyer.setBounds(new Rectangle(261, 76, 142, 21));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(210, 100, 44, 18));
    blueBkgWhiteCharLabel2.setText("Division");
    txtYear.setText("");
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(281, 177, 37, 21));
    lblQcCountry.setText("Country");
    lblQcCountry.setBounds(new Rectangle(211, 149, 58, 23));
    cbxQcCountry.setBounds(new Rectangle(261, 149, 141, 21));
    slkMaker.setBounds(new Rectangle(261, 125, 142, 21));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(5, 49, 195, 185));
    //jPanel1.setLayout(null);
    java.awt.GridLayout gLayout=new java.awt.GridLayout(7,2);
    jPanel1.setLayout(gLayout);
    /*
    //-----------preserve for layout
    jLabel7.setText("jLabel7");
    jLabel7.setBounds(new Rectangle(7, 15, 142, 20));
    jLabel8.setBounds(new Rectangle(7, 39, 142, 20));
    jLabel8.setText("jLabel7");
    jLabel9.setBounds(new Rectangle(7, 63, 142, 20));
    jLabel9.setText("jLabel7");
    jLabel10.setBounds(new Rectangle(7, 88, 142, 20));
    jLabel10.setText("jLabel7");
    jLabel11.setBounds(new Rectangle(7, 112, 142, 20));
    jLabel11.setText("jLabel7");
    jLabel12.setBounds(new Rectangle(7, 136, 142, 20));
    jLabel12.setText("jLabel7");
    //-----------------------------
    */
    /*
    cbxDep[0].setBounds(new Rectangle(7, 15, 142, 15));
    cbxDep[1].setBounds(new Rectangle(7, 30, 142, 15));
    cbxDep[2].setBounds(new Rectangle(7, 45, 142, 15));
    cbxDep[3].setBounds(new Rectangle(7, 60, 142, 15));
    cbxDep[4].setBounds(new Rectangle(7, 75, 142, 15));
    cbxDep[5].setBounds(new Rectangle(7, 90, 142, 15));
    cbxDep[6].setBounds(new Rectangle(7, 105, 142, 15));
    cbxDep[7].setBounds(new Rectangle(7, 120, 142, 15));
    cbxDep[8].setBounds(new Rectangle(7, 135, 142, 15));
    */
    pnlDuriation.setBorder(titledBorder2);
    pnlDuriation.setBounds(new Rectangle(234, 206, 274, 46));
    pnlDuriation.setLayout(null);
    jLabel2.setText("FROM:");
    jLabel2.setBounds(new Rectangle(9, 17, 56, 21));
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(144, 16, 36, 24));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(56, 17, 81, 20));
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(179, 17, 87, 22));
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setText("PRINT:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(407, 26, 80, 18));
    rdoPrintAmt.setBackground(Color.white);
    rdoPrintAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPrintAmt.setText("AMT");
    rdoPrintAmt.setBounds(new Rectangle(487, 26, 95, 18));
    rdoPrintQty.setBackground(Color.white);
    rdoPrintQty.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPrintQty.setText("QTY");
    rdoPrintQty.setBounds(new Rectangle(581, 26, 92, 18));
    rdoPrintAll.setBackground(Color.white);
    rdoPrintAll.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPrintAll.setSelected(true);
    rdoPrintAll.setText("ALL");
    rdoPrintAll.setBounds(new Rectangle(673, 26, 112, 18));
    rdoTypePending.setBounds(new Rectangle(673, 53, 112, 18));
    rdoTypePending.setText("Pending");
    rdoTypePending.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoTypePending.setSelected(true);
    rdoTypePending.setBackground(Color.white);
    rdoTypeShip.setBounds(new Rectangle(581, 53, 92, 18));
    rdoTypeShip.setText("Ship");
    rdoTypeShip.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoTypeShip.setBackground(Color.white);
    rdoTypeOdr.setBounds(new Rectangle(487, 53, 95, 18));
    rdoTypeOdr.setText("Order");
    rdoTypeOdr.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoTypeOdr.setSelected(false);
    rdoTypeOdr.setBackground(Color.white);
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(407, 53, 81, 18));
    whiteBkgBlueCharLabel2.setText("STATUS:");
    whiteBkgBlueCharLabel2.setForeground(Color.blue);
    whiteBkgBlueCharLabel3.setForeground(Color.blue);
    whiteBkgBlueCharLabel3.setText("COLUMN BY:");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(407, 79, 90, 18));
    this.setBackground(new Color(202, 202, 225));
    rdoRowByFTY.setBounds(new Rectangle(541, 106, 55, 18));
    rdoRowByFTY.addItemListener(new PnlQryCrossSummaryQtyAmtPrt_rdoRowByFTY_itemAdapter(this));
    rdoRowByFTY.setText("FTY");
    rdoRowByFTY.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoRowByFTY.setBackground(Color.white);
    rdoRowByBuyer.setBounds(new Rectangle(475, 106, 69, 18));
    rdoRowByBuyer.addItemListener(new PnlQryCrossSummaryQtyAmtPrt_rdoRowByBuyer_itemAdapter(this));
    rdoRowByBuyer.setText("Buyer");
    rdoRowByBuyer.setSelected(true);
    rdoRowByBuyer.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoRowByBuyer.setBackground(Color.white);
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(407, 106, 71, 18));
    whiteBkgBlueCharLabel5.setText("ROW BY:");
    whiteBkgBlueCharLabel5.setForeground(Color.blue);
    rdoRowByCountry.setBackground(Color.white);
    rdoRowByCountry.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoRowByCountry.setText("Country");
    rdoRowByCountry.setBounds(new Rectangle(596, 106, 72, 18));
    rdoRowByCountry.addItemListener(new PnlQryCrossSummaryQtyAmtPrt_rdoRowByCountry_itemAdapter(this));
    rdoKbnMstCpmNo.setBounds(new Rectangle(700, 133, 86, 18));
    rdoKbnMstCpmNo.setText("NO");
    rdoKbnMstCpmNo.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoKbnMstCpmNo.setSelected(true);
    rdoKbnMstCpmNo.setBackground(Color.white);
    rdoKbnMstCpmYes.setBounds(new Rectangle(620, 133, 81, 18));
    rdoKbnMstCpmYes.setText("YES");
    rdoKbnMstCpmYes.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoKbnMstCpmYes.setSelected(false);
    rdoKbnMstCpmYes.setBackground(Color.white);
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(407, 133, 214, 18));
    whiteBkgBlueCharLabel6.setText("COMBINE MASTER COMPANY:");
    whiteBkgBlueCharLabel6.setForeground(Color.blue);
    rdoKbnDivNo.setBackground(Color.white);
    rdoKbnDivNo.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoKbnDivNo.setSelected(true);
    rdoKbnDivNo.setText("NO");
    rdoKbnDivNo.setBounds(new Rectangle(700, 160, 86, 18));
    rdoKbnDivYes.setBackground(Color.white);
    rdoKbnDivYes.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoKbnDivYes.setText("YES");
    rdoKbnDivYes.setBounds(new Rectangle(620, 160, 81, 18));
    whiteBkgBlueCharLabel7.setForeground(Color.blue);
    whiteBkgBlueCharLabel7.setText("COMBINE DIVISION:");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(407, 160, 215, 18));
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(518, 186, 162, 18));
    whiteBkgBlueCharLabel8.setText("EXCLUDE S/C=SPACE");
    whiteBkgBlueCharLabel8.setForeground(Color.blue);
    whiteBkgBlueCharLabel8.setToolTipText("");
    rdoXldScNo.setBounds(new Rectangle(736, 186, 50, 18));
    rdoXldScNo.setText("NO");
    rdoXldScNo.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoXldScNo.setSelected(true);
    rdoXldScNo.setBackground(Color.white);
    rdoXldScYes.setBounds(new Rectangle(678, 186, 58, 18));
    rdoXldScYes.setText("YES");
    rdoXldScYes.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoXldScYes.setBackground(Color.white);
    whiteBkgBlueCharLabel9.setForeground(Color.blue);
    whiteBkgBlueCharLabel9.setText("ONLY PC Or DZ:");
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(518, 213, 162, 18));
    rdoPcDzNo.setBackground(Color.white);
    rdoPcDzNo.setSelected(true);
    rdoPcDzNo.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPcDzNo.setText("NO");
    rdoPcDzNo.setBounds(new Rectangle(736, 213, 50, 18));
    rdoPcDzYes.setBackground(Color.white);
    rdoPcDzYes.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPcDzYes.setSelected(false);
    rdoPcDzYes.setText("YES");
    rdoPcDzYes.setBounds(new Rectangle(678, 213, 58, 18));
    btnReport.setBounds(new Rectangle(629, 262, 157, 28));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setText("REPORT");
    btnReport.addActionListener(new PnlQryCrossSummaryQtyAmtPrt_btnReport_actionAdapter(this));
    jLabel4.setText("<html><body>Offshore<br>Center</body></html>");
    jLabel4.setBounds(new Rectangle(204, 25, 59, 32));
    cbxOffShoreCenter.setBounds(new Rectangle(258, 28, 142, 21));


    cbxProdType.setBounds(new Rectangle(212, 265, 113, 22));
    jLabel5.setText("TYPE:");
    jLabel5.setBounds(new Rectangle(178, 262, 43, 25));
    jLabel6.setText("<html><body>FONT<br>SIZE:</body></html>");
    jLabel6.setBounds(new Rectangle(335, 257, 46, 30));
    cbxFontSize.setBounds(new Rectangle(377, 265, 50, 22));
    lblManager.setText("Manager:");
    lblManager.setBounds(new Rectangle(428, 262, 59, 26));
    cbxManager.setBounds(new Rectangle(477, 265, 146, 22));
    lblStyle.setText("STYLE");
    lblStyle.setBounds(new Rectangle(7, 237, 45, 18));
    txtStyle.setText("");
    txtStyle.setBounds(new Rectangle(50, 235, 121, 23));
    lblPO.setBounds(new Rectangle(8, 262, 45, 18));
    lblPO.setText("PO");
    txtPO.setBounds(new Rectangle(51, 260, 121, 23));
    txtPO.setText("");
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(518, 239, 162, 18));
    whiteBkgBlueCharLabel10.setText("EXCLUDE SAMPLE:");
    whiteBkgBlueCharLabel10.setForeground(Color.blue);
    rdoExSmpl_N.setBounds(new Rectangle(736, 239, 50, 18));
    rdoExSmpl_N.setText("NO");
    rdoExSmpl_N.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoExSmpl_N.setSelected(true);
    rdoExSmpl_N.setBackground(Color.white);
    rdoExSmpl_Y.setBounds(new Rectangle(678, 239, 58, 18));
    rdoExSmpl_Y.setText("YES");
    rdoExSmpl_Y.setSelected(false);
    rdoExSmpl_Y.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoExSmpl_Y.setBackground(Color.white);
    jLabel7.setText("Row Ttl:");
    jLabel7.setBounds(new Rectangle(379, 183, 51, 24));
    cbxRowTtl.setBounds(new Rectangle(428, 183, 86, 22));
    //rdoRowByMonth.addItemListener(new PnlQryCrossSummaryQtyAmtPrt_rdoRowByMonth_itemAdapter(this));
    rdoRowByDest.setBounds(new Rectangle(668, 106, 117, 18));
 //   rdoRowByDest.addActionListener(new PnlQryCrossSummaryQtyAmtPrt_rdoRowByMonth_actionAdapter(this));
    rdoRowByDest.setText("Destination");
    rdoRowByDest.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoRowByDest.setBackground(Color.white);
    jLabel8.setFont(new java.awt.Font("Dialog", 0, 11));
    jLabel8.setForeground(Color.black);
    jLabel8.setText("TO");
    jLabel8.setBounds(new Rectangle(322, 176, 21, 24));
    txtYearTo.setBounds(new Rectangle(338, 177, 37, 21));
    /*
    jPanel1.add(cbxDep[0], null);
    jPanel1.add(cbxDep[1], null);
    jPanel1.add(cbxDep[2], null);
    jPanel1.add(cbxDep[3], null);
    jPanel1.add(cbxDep[4], null);
    jPanel1.add(cbxDep[5], null);
    jPanel1.add(cbxDep[6], null);
    jPanel1.add(cbxDep[7], null);
    jPanel1.add(cbxDep[8], null);
    */
   for(int i=0;i<COMBOBOX_COUNT;i++){
      jPanel1.add(cbxDep[i]);
   }
   /*
   jPanel1.add(cbxDep[0]);
   jPanel1.add(cbxDep[1]);
   jPanel1.add(cbxDep[2]);
   jPanel1.add(cbxDep[3]);
   jPanel1.add(cbxDep[4]);
   jPanel1.add(cbxDep[5]);
   jPanel1.add(cbxDep[6]);
   jPanel1.add(cbxDep[7]);
   jPanel1.add(cbxDep[8]);
   */
    cbxColumnBy.setBounds(new Rectangle(499, 79, 167, 18));
    pnlDuriation.add(jLabel3, null);
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(txtDateEnd, null);
    this.add(cbxColumnBy, null);
    this.add(jLabel7, null);
    this.add(jLabel1, null);
    this.add(txtYear, null);
    this.add(txtYearTo, null);
    this.add(jLabel8, null);
    this.add(cbxRowTtl, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(lblQcCountry, null);
    this.add(cbxQcCountry, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(slkMaker, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxDiv, null);
    this.add(slkBuyer, null);
    this.add(jLabel4, null);
    this.add(cbxOffShoreCenter, null);
    slkBuyer.init(null, null, slkBuyer.TYPE_BUYER, true);
    slkMaker.init(null, null, slkBuyer.TYPE_MAKER, true);
    buttonGroup1.add(rdoPrintAmt);
    buttonGroup1.add(rdoPrintQty);
    buttonGroup1.add(rdoPrintAll);
    rdoBtnGrpType.add(rdoTypeOdr);
    rdoBtnGrpType.add(rdoTypeShip);
    rdoBtnGrpType.add(rdoTypePending);
    rdoGrpRowBy.add(rdoRowByBuyer);
    rdoGrpRowBy.add(rdoRowByFTY);
    rdoGrpRowBy.add(rdoRowByCountry);
    rdoGrpRowBy.add(rdoRowByDest);
    rdoGrpCombineMaserCompany.add(rdoKbnMstCpmYes);
    rdoGrpCombineMaserCompany.add(rdoKbnMstCpmNo);
    rdoGrpKbmDiv.add(rdoKbnDivYes);
    rdoGrpKbmDiv.add(rdoKbnDivNo);
    rdoGrpXldSc.add(rdoXldScNo);
    rdoGrpXldSc.add(rdoXldScYes);
    this.add(blueBkgWhiteCharLabel1, null);
    /*
    //---------preserve for layout-----
    jPanel1.add(jLabel7, null);
    jPanel1.add(jLabel8, null);
    jPanel1.add(jLabel9, null);
    jPanel1.add(jLabel10, null);
    jPanel1.add(jLabel11, null);
    jPanel1.add(jLabel12, null);
    //-----------------------------------
    */
    this.add(btnReport, null);
    this.add(jLabel5, null);
    this.add(cbxFontSize, null);
    this.add(lblManager, null);
    this.add(cbxProdType, null);
    rdoGrpOnlyPcDz.add(rdoPcDzYes);
    rdoGrpOnlyPcDz.add(rdoPcDzNo);
    this.add(cbxManager, null);
    this.add(jLabel6, null);
    this.add(jPanel1, null);

    slkBuyer.init(null,null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init(null,null,slkBuyer.TYPE_MAKER,true);
    slkBuyer.setModifyNotifyTo(new ChangeBuyerHandler());
    genDataBindObj();
    this.add(lblPO, null);
    this.add(txtPO, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(rdoPrintAmt, null);
    this.add(rdoPrintQty, null);
    this.add(rdoPrintAll, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(rdoTypeOdr, null);
    this.add(rdoTypeShip, null);
    this.add(rdoTypePending, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(rdoRowByBuyer, null);
    this.add(whiteBkgBlueCharLabel6, null);
    this.add(rdoKbnMstCpmYes, null);
    this.add(rdoKbnMstCpmNo, null);
    this.add(whiteBkgBlueCharLabel7, null);
    this.add(rdoKbnDivYes, null);
    this.add(rdoKbnDivNo, null);
    this.add(rdoXldScNo, null);
    this.add(rdoPcDzYes, null);
    this.add(rdoPcDzNo, null);
    this.add(rdoExSmpl_N, null);
    this.add(rdoExSmpl_Y, null);
    this.add(rdoXldScYes, null);
    this.add(whiteBkgBlueCharLabel9, null);
    this.add(whiteBkgBlueCharLabel10, null);
    this.add(whiteBkgBlueCharLabel8, null);
    this.add(rdoRowByFTY, null);
    this.add(rdoRowByCountry, null);
    this.add(rdoRowByDest, null);
    this.add(cbxCntr, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtStyle, null);
    this.add(lblStyle, null);
    this.add(pnlDuriation, null);
    buttonrdoExSmpl.add(rdoExSmpl_Y);
    buttonrdoExSmpl.add(rdoExSmpl_N);
    //rdoRowByMonth.setVisible(false);
  }
  public HashMap composeParameters(){
    HashMap hm = super.composeParameters();
    hm.put("P_BUYER",(slkBuyer.getSelectedValue()==null)?"0":slkBuyer.getSelectedValue().toString());
    hm.put("P_MAKER",(slkMaker.getSelectedValue()==null)?"0":slkMaker.getSelectedValue().toString());
    hm.put("P_TTL",cbxRowTtl.getSelectedItem().equals("Yes")?"'Y'":"'N'");
    StringBuffer sbDEP=new StringBuffer();
    for(int i=0;i<COMBOBOX_COUNT;i++){
      Object depObj=dbCbxDep[i].getSelectedValue();
      if(depObj!=null){
        if(sbDEP.length()>0)sbDEP.append(",");
        sbDEP.append("'");
        sbDEP.append(depObj);
        sbDEP.append("'");
      }
    }
    if(sbDEP.length()>0){
      hm.put("P_DEP","["+sbDEP.toString()+"]");
    }else{
      hm.put("P_DEP","['ALL']");
    }
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd=dbTxtDateEnd.getSelectedValue();
    if(dateBgn==null){
      hm.put("P_DEL_FM","DATE(2000,01,01)");
    }
    if(dateEnd==null){
      hm.put("P_DEL_TO","DATE(2099,12,31)");
    }
    if(rdoXldScYes.isSelected()){
      hm.put("P_EXC_SC","Y");
    }else{
      hm.put("P_EXC_SC","N");
    }
    //check redio boxes
    if(rdoRowByBuyer.isSelected()){
      hm.put("B_F_C","B");
    }else if(rdoRowByFTY.isSelected() ){
      hm.put("B_F_C","F");
    }else if(rdoRowByCountry.isSelected()){
      hm.put("B_F_C","C");

    }else if(rdoRowByDest.isSelected()){
      hm.put("B_F_C","D");
    }

    if(rdoKbnMstCpmYes.isSelected()){
      hm.put("MASTER_COMP","Y");
    }else{
      hm.put("MASTER_COMP","N");
    }

    if(rdoKbnDivYes.isSelected()){
      hm.put("SHOW_DIV","Y");
    }else{
      hm.put("SHOW_DIV","N");
    }
    /*
    if(rdoClmByMonth.isSelected()){
      hm.put("MON_SEA","M");
    }
    if(rdoClmByYear.isSelected()){
      hm.put("MON_SEA","Y");
    }
    if(rdoClmBySea.isSelected()){
      hm.put("MON_SEA","S");
    }
    */
     hm.put("MON_SEA",strColumnByArr[cbxColumnBy.getSelectedIndex()]);

    if(rdoPcDzYes.isSelected()){
      hm.put("ONLY_PC_DZ","Y");
    }else{
      hm.put("ONLY_PC_DZ","N");
    }
    //font size properties
    String pFont=(String)cbxFontSize.getSelectedItem();
    if(pFont==null)pFont="10";

    reportName="CROSS_OD"+pFont+".rpt&firstgroupassheets=false";
    if(rdoTypeOdr.isSelected()){
      hm.put("O_S_P","O");
    }else if(rdoTypeShip.isSelected() ){
       reportName="CROSS_SH"+pFont+".rpt&firstgroupassheets=false";
       hm.put("O_S_P","S");
    }else if(rdoTypePending.isSelected()){
      hm.put("O_S_P","P");
    }
    if(rdoPrintAmt.isSelected()){
      hm.put("PRINT_AMT","AMT");
    }else if(rdoPrintQty.isSelected() ){
       hm.put("PRINT_AMT","QTY");
    }else if(rdoPrintAll.isSelected()){
      hm.put("PRINT_AMT","ALL");
    }
    if(dbTxtYear.getSelectedValue()==null){
      hm.put("P_YEAR","2000");
    }
    if(dbTxtYearTo.getSelectedValue()==null){
      hm.put("P_YEAR_TO","2999");
    }


    hm.put("P_STYLE",(txtStyle.getText().trim().length()==0)?"ALL":txtStyle.getText().trim());
    hm.put("P_PO",(txtPO.getText().trim().length()==0)?"ALL":txtPO.getText().trim());
    hm.put("P_SAMPLE",rdoExSmpl_N.isSelected()?"N":"Y");
    return hm;
  }
  public void genDataBindObj() {
    doingDB2Gui=true;
    dataBindComps.clear();
    try{
      Vector offShoreCenters=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select CEN_CODE, CEN_NAME from center where record_delete_flag='1'",1,999);

    exgui.DataBindJCombobox  DbJcbxcbxOffShoreCntr =
        new exgui.DataBindJCombobox(
        cbxOffShoreCenter, "OFF_CENT",
        offShoreCenters,
        "CEN_NAME", "CEN_CODE",
        null, "ALL", null);
    dataBindComps.add(DbJcbxcbxOffShoreCntr);

    exgui.DataBindJCombobox  DbJcbxcbxManager =
        new exgui.DataBindJCombobox(
        cbxManager, "P_MANAGER",
         tempProperties.tmpManagerRecs,
        "MNG_ABBR", "MNG_CODE",
         null, "ALL", null);
    dataBindComps.add(DbJcbxcbxManager);

    exgui.DataBindJCombobox  DbJcbxcbxProdType =
        new exgui.DataBindJCombobox(
        cbxProdType, "P_T",
         tempProperties.tmpProdType,
        "TYPE_NAME", "TYPE_CODE",
         null, "ALL", null);
       dataBindComps.add(DbJcbxcbxProdType);
      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "ALL", null);
        dataBindComps.add(DbJcbxcbxCntr);
      } else {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        dataBindComps.add(DbJcbxcbxCntr);
      }

      DbJcbxcbxDiv =
          new exgui.DataBindJCombobox(
          cbxDiv, "P_DIV",
          new Vector(),
          "DIV_NAME", "DIV_NAME", "ALL", "ALL", null);
      divCbxDBGUI_index = dataBindComps.size(); //division need to change on chage of buyer.
      dataBindComps.add(DbJcbxcbxDiv);

      dbJcbxQcCountry =
          new exgui.DataBindJCombobox(
            cbxQcCountry,"P_COUNTRY",
            newtimes.preproduction.guis.tempProperties.tmpCountries,
            "CNTY_NAME","CNTY_NAME","ALL","ALL",null);
      dataBindComps.add(dbJcbxQcCountry);


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "P_DEL_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_DEL_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);

      Object objCnv=exgui.verification.CellFormat.getOrdinaryField(4);

      dbTxtYear = new exgui.DataBindTextWithChecker(
          txtYear, "P_YEAR",null, 4,
          (exgui.Object2String)objCnv,
          (exgui.ultratable.CellTxtEditorFormat)objCnv);
      dataBindComps.add(dbTxtYear);

      dbTxtYearTo = new exgui.DataBindTextWithChecker(
          txtYearTo, "P_YEAR_TO",null, 4,
          (exgui.Object2String)objCnv,
          (exgui.ultratable.CellTxtEditorFormat)objCnv);
      dataBindComps.add(dbTxtYearTo);


      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1",
        1, 1);
          Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
      database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
     exgui.DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbTwdChg);
     exgui.DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbRmbChg);
     exgui.DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      dataBindComps.add(dbHkdChg);


      doingDB2Gui=false;
      cbxCntr.getItemListeners()[0].itemStateChanged(null);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public class ChangeBuyerHandler
      implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record buyerRecord){
      //recompose the division combobox of buyer.
      if(doingDB2Gui)return;
      try{
        //find out the vector to add dbDeps.
        if (buyerRecord==null) {
          //only the all dep is allow to add now.
          DbJcbxcbxDiv=new exgui.DataBindJCombobox(
              cbxDiv,
              "P_DIV",
              new Vector(),
              "DIV_NAME","DIV_NAME",
              "ALL","ALL",null);
          //cbxDiv.setUI(new exgui.WideComboBoxUI(160));

          if(divCbxDBGUI_index == dataBindComps.size()) {
            dataBindComps.add(DbJcbxcbxDiv);
          }else{
            //just replace after display & change;
            dataBindComps.set(divCbxDBGUI_index,DbJcbxcbxDiv);
          }

        }else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords=
              (Vector)tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
           DbJcbxcbxDiv=null;
          if(dvsnRecords==null){
            DbJcbxcbxDiv=new exgui.DataBindJCombobox(
                cbxDiv,
                "P_DIV",
                new Vector(),
                "DIV_NAME",
                "DIV_NAME",
                "ALL","ALL",null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }else {
            DbJcbxcbxDiv=new exgui.DataBindJCombobox(
                cbxDiv,
                "P_DIV",
                dvsnRecords,
                "DIV_NAME",
                "DIV_NAME",
               "ALL","ALL",null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }

          if (divCbxDBGUI_index == dataBindComps.size()) {
            dataBindComps.add(DbJcbxcbxDiv);
          }else{
            dataBindComps.set(divCbxDBGUI_index,DbJcbxcbxDiv);
          }
        }

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }

  class cbxCenterItemChanged implements java.awt.event.ItemListener{
  public void itemStateChanged(ItemEvent e){
    if(doingDB2Gui)return;
    String usingCenterCode=(String)DbJcbxcbxCntr.getSelectedValue();
     if(usingCenterCode==null || usingCenterCode.trim().length()==0)usingCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;
    slkBuyer.setSelectingCenter(usingCenterCode);
    slkMaker.setSelectingCenter(usingCenterCode);

    if (dbCbxDep==null){
      dbCbxDep=new exgui.DataBindJCombobox[COMBOBOX_COUNT];
    }
    try{
      //find out the vector to add dbDeps.
      for (int i = 0; i < COMBOBOX_COUNT; i++) {
        if (DbJcbxcbxCntr.getSelectedValue() == null) {
          //only the all dep is allow to add now.
          dbCbxDep[i] =
              new exgui.DataBindJCombobox(
              cbxDep[i], null,
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              null,
              "", null);
        } else {
          //deps and "ALL"dep allow to add.
          Vector depVects =
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          dbCbxDep[i] = null;
          if (depVects == null) {
            dbCbxDep[i] =
                new exgui.DataBindJCombobox(
                cbxDep[i], null,
                new Vector(),
                "DEP_NAME", "DEP_CODE",
                null,
                "", null);
          } else if (depVects.size() > 1) {
            dbCbxDep[i] =
                new exgui.DataBindJCombobox(
                cbxDep[i], null,
                depVects,
                "DEP_NAME", "DEP_CODE",
                null,
                "", null);
            //guis.add(DbJcbxcbxDep);
          } else {
            dbCbxDep[i] =
                new exgui.DataBindJCombobox(
                cbxDep[i], null,
                depVects,
                "DEP_NAME", "DEP_CODE",
                null);
            //guis.add(DbJcbxcbxDep);
          }
       }
      }
      } catch (Exception exp) {
        exp.printStackTrace();
      }

  }
 }


  void btnReport_actionPerformed(ActionEvent e) {
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
     super.JButtonQueryButtonAction(null);
     newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }

  void rdoRowByFTY_itemStateChanged(ItemEvent e) {
    if(rdoRowByFTY.isSelected()){
      rdoKbnDivNo.setEnabled(false);
      rdoKbnDivYes.setEnabled(false);
      rdoKbnMstCpmNo.setEnabled(true);
      rdoKbnMstCpmYes.setEnabled(true);
      rdoKbnDivYes.setSelected(false);
      rdoKbnMstCpmNo.setSelected(true);
    }
  }
  void rdoRowByBuyer_itemStateChanged(ItemEvent e) {
    if(rdoRowByBuyer.isSelected()){
      rdoKbnDivNo.setEnabled(true);
      rdoKbnDivYes.setEnabled(true);
      rdoKbnMstCpmNo.setEnabled(true);
      rdoKbnMstCpmYes.setEnabled(true);
      rdoKbnDivYes.setSelected(false);
      rdoKbnMstCpmNo.setSelected(true);
    }
  }

  void rdoRowByCountry_itemStateChanged(ItemEvent e) {
    if(rdoRowByCountry.isSelected()){
      rdoKbnDivYes.setSelected(false);
      rdoKbnMstCpmNo.setSelected(true);
      rdoKbnDivNo.setEnabled(false);
      rdoKbnDivYes.setEnabled(false);
      rdoKbnMstCpmNo.setEnabled(false);
      rdoKbnMstCpmYes.setEnabled(false);
    }
  }



}

class PnlQryCrossSummaryQtyAmtPrt_rdoRowByBuyer_itemAdapter implements java.awt.event.ItemListener {
  PnlQryCrossSummaryQtyAmtPrt adaptee;

  PnlQryCrossSummaryQtyAmtPrt_rdoRowByBuyer_itemAdapter(PnlQryCrossSummaryQtyAmtPrt adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.rdoRowByBuyer_itemStateChanged(e);
  }
}

class PnlQryCrossSummaryQtyAmtPrt_btnReport_actionAdapter implements java.awt.event.ActionListener {
  PnlQryCrossSummaryQtyAmtPrt adaptee;

  PnlQryCrossSummaryQtyAmtPrt_btnReport_actionAdapter(PnlQryCrossSummaryQtyAmtPrt adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnReport_actionPerformed(e);
  }
}

class PnlQryCrossSummaryQtyAmtPrt_rdoRowByFTY_itemAdapter implements java.awt.event.ItemListener {
  PnlQryCrossSummaryQtyAmtPrt adaptee;

  PnlQryCrossSummaryQtyAmtPrt_rdoRowByFTY_itemAdapter(PnlQryCrossSummaryQtyAmtPrt adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.rdoRowByFTY_itemStateChanged(e);
  }
}

class PnlQryCrossSummaryQtyAmtPrt_rdoRowByCountry_itemAdapter implements java.awt.event.ItemListener {
  PnlQryCrossSummaryQtyAmtPrt adaptee;

  PnlQryCrossSummaryQtyAmtPrt_rdoRowByCountry_itemAdapter(PnlQryCrossSummaryQtyAmtPrt adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.rdoRowByCountry_itemStateChanged(e);
  }
}
/*
class PnlQryCrossSummaryQtyAmtPrt_rdoRowByMonth_actionAdapter implements java.awt.event.ActionListener {
  PnlQryCrossSummaryQtyAmtPrt adaptee;

  PnlQryCrossSummaryQtyAmtPrt_rdoRowByMonth_actionAdapter(PnlQryCrossSummaryQtyAmtPrt adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rdoRowByMonth_actionPerformed(e);
  }
}
*/
