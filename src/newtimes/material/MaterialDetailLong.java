package newtimes.material;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import java.math.BigDecimal;
import newtimes.*;
import database.datatype.Record;
import exgui2.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MaterialDetailLong extends JPanel  implements CommonFunc{
  private final newtimes.material.CONST.MTR.EJB MTR_EJB = null;
  private final newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH = null;
  private final newtimes.material.CONST.BYMK.EJB BYMK_EJB = null;
  private final newtimes.material.CONST.MTRDTL.EJB MTRDTL_EJB=null;
  private final newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_COND=null;
  private final newtimes.material.CONST.PRICE_TERM.EJB PRCTRM_EJB=null;
  private final newtimes.material.CONST.CITY.EJB CITY_EJB=null;
  private final newtimes.material.CONST.COMMON COMMON = null;
  private Record CurrUser = util.PublicVariable.USER_RECORD;
  static int yes_no = 0;
  JLabel jLabel1 = new JLabel();
  JLabel jTextField1 = new JLabel();
  JLabel jTextField2 = new JLabel();
  JLabel jTextField3 = new JLabel();
  JLabel jTextField4 = new JLabel();
  JLabel jTextField5 = new JLabel();
  JLabel jTextField6 = new JLabel();
  JLabel jTextField8 = new JLabel();
  JLabel jTextField9 = new JLabel();
  JLabel jTextField10 = new JLabel();
  JLabel jTextField11 = new JLabel();
  JLabel jTextField12 = new JLabel();
  JLabel jTextField13 = new JLabel();
  JLabel jTextField14 = new JLabel();
  JLabel jTextField15 = new JLabel();
  JLabel jTextField16 = new JLabel();
  JLabel jTextField17 = new JLabel();
  JLabel jTextField18 = new JLabel();
  JLabel jTextField19 = new JLabel();
  JLabel jTextField20 = new JLabel();
  JLabel jTextField21 = new JLabel();
  JLabel jTextField22 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField tfMill_MtrNo = new JTextField();
  JTextField tfDupsMIN = new JTextField();
  JTextField tfBulkMIN = new JTextField();
  JTextField tfBulkLEAD = new JTextField();
  JTextField tfDupsLEAD = new JTextField();
  JTextField tfCommDate1 = new JTextField();
  JTextField tfCommDate2 = new JTextField();
  JTextField tfCommYard2 = new JTextField();
  JTextField tfCommYard1 = new JTextField();
  JTextField tfCommPerson1 = new JTextField();
  JTextField tfCommPerson2 = new JTextField();
  JTextField tfRemark = new JTextField();
  JComboBox cboTerm = new JComboBox();
  JComboBox cboDest = new JComboBox();
  JPanel jPanel1 = new JPanel();

  JTextField[] tfGroup = new JTextField[22];
  JComboBox[] cboGroup = new JComboBox[5];

  private Vector PrctermList = null;
  private Vector CityList    = null;

  private Record currRecord = null;
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  private GetBuyerMaker dlgMill = new GetBuyerMaker(23);
  JLabel jTextField7 = new JLabel();
  //JTextField tfCurny = new JTextField();
  JComboBox cboCurny=new JComboBox();
  exgui.DataBindJCombobox dbCbxCurrency;
  exgui.DataBindJCombobox  dbCbxUsdUnit,dbCbxLocalUnit;
  exgui.DataBindTextWithChecker dbTxttfMill_MtrNo,dbTxttxtPrxUSD,dbTxttxtPrxLocal;
  exgui.DataBindTextWithChecker dbTxttfDupsMIN,dbTxttfBulkMIN,dbTxttfBulkLEAD,dbTxttfDupsLEAD;
  exgui.DataBindTextWithChecker dbTxttfCommDate1,
                                dbTxttfCommDate2,dbTxttfCommYard2,dbTxttfCommYard1,
                                dbTxttfCommPerson1,dbTxttfCommPerson2,
                                dbTxttfRemark,dbTxttxtCnfmUsd,dbTxttxtCnfmLocal;
  boolean fieldsInited=false;
  public MaterialDetailLong() {
    try {
      currRecord=null;
      jbInit();
      initAllFields();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public MaterialDetailLong(Frame1 _frame, Record rec) {
    //this();
    try {
      currRecord = rec;
      jbInit();
      initAllFields();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

  }

  void jbInit() throws Exception {
    CONST.detailPageFlag = true;
    this.setMaxLength();
    this.setLayout(gridBagLayout1);
    this.setBackground(new Color(204, 204, 225));
    this.setSize(new Dimension(773, 481));
    jPanel1.setBackground(new Color(204, 204, 225));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(Color.white);
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    jTextField1.setText(" Mill :");
    jTextField1.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField1.setBounds(new Rectangle(13, 58, 136, 23));
    jTextField2.setBounds(new Rectangle(390, 58, 136, 23));
    jTextField2.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField2.setText(" Mill\'s MTR-NO :");
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setRequestFocusEnabled(true);
    jTextField2.setOpaque(true);
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField3.setBounds(new Rectangle(13, 92, 136, 23));
    jTextField3.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField3.setText(" USD :");
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    //jTextField3.setCaretColor(Color.black);
    jTextField3.setOpaque(true);
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setEnabled(true);
    jTextField4.setBounds(new Rectangle(232, 93, 38, 21));
    jTextField4.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField4.setText(" Unit :");
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField5.setBounds(new Rectangle(13, 126, 136, 23));
    jTextField5.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField5.setText(" Local :");
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setRequestFocusEnabled(true);
    jTextField5.setOpaque(true);
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField6.setBounds(new Rectangle(232, 125, 38, 23));
    jTextField6.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField6.setText(" Unit :");
    jTextField6.setForeground(Color.white);
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField8.setBounds(new Rectangle(390, 92, 136, 23));
    jTextField8.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField8.setText(" CNFM USD :");
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField9.setBounds(new Rectangle(390, 126, 136, 23));
    jTextField9.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField9.setText(" Term :");
    jTextField9.setForeground(Color.white);
    jTextField9.setBorder(null);
    jTextField9.setOpaque(true);
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField10.setBounds(new Rectangle(390, 194, 136, 23));
    jTextField10.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField10.setText(" CNFM Local :");
    jTextField10.setForeground(Color.white);
    jTextField10.setBorder(null);
    jTextField10.setOpaque(true);
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField11.setBounds(new Rectangle(390, 160, 136, 23));
    jTextField11.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField11.setText(" DEST :");
    jTextField11.setForeground(new Color(10,36,106));
    jTextField11.setBorder(null);
    jTextField11.setOpaque(true);
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField12.setBounds(new Rectangle(13, 228, 136, 23));
    jTextField12.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField12.setText(" DUPS MIN QTY :");
    jTextField12.setForeground(new Color(10,36,106));
    jTextField12.setBorder(null);
    jTextField12.setOpaque(true);
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setBackground(new Color(143, 143, 188));
    jTextField13.setBounds(new Rectangle(390, 228, 136, 23));
    jTextField13.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField13.setText("DUPS Lead Time :");
    jTextField13.setForeground(new Color(10,36,106));
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField14.setBounds(new Rectangle(13, 262, 136, 23));
    jTextField14.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField14.setText(" Bulk MIN QTY :");
    jTextField14.setForeground(Color.white);
    jTextField14.setBorder(null);
    jTextField14.setToolTipText("");
    jTextField14.setOpaque(true);
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setBackground(new Color(143, 143, 188));
    jTextField15.setBounds(new Rectangle(390, 262, 136, 23));
    jTextField15.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField15.setText("Bulk Lead Time:");
    jTextField15.setForeground(Color.white);
    jTextField15.setBorder(null);
    jTextField15.setOpaque(true);
    jTextField15.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField15.setBackground(new Color(143, 143, 188));
    jTextField16.setBounds(new Rectangle(13, 296, 136, 23));
    jTextField16.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField16.setText(" Commited Date-1 :");
    jTextField16.setForeground(new Color(10,36,106));
    jTextField16.setBorder(null);
    jTextField16.setOpaque(true);
    jTextField16.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField16.setBackground(new Color(143, 143, 188));
    jTextField17.setBounds(new Rectangle(390, 296, 136, 23));
    jTextField17.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField17.setText(" Commited Yard-1 :");
    jTextField17.setForeground(new Color(10,36,106));
    jTextField17.setBorder(null);
    jTextField17.setOpaque(true);
    jTextField17.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField17.setBackground(new Color(143, 143, 188));
    jTextField18.setBounds(new Rectangle(13, 330, 136, 23));
    jTextField18.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField18.setText(" Confirm Person-1 :");
    jTextField18.setForeground(Color.white);
    jTextField18.setBorder(null);
    jTextField18.setOpaque(true);
    jTextField18.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField18.setBackground(new Color(143, 143, 188));
    jTextField19.setBounds(new Rectangle(13, 364, 136, 23));
    jTextField19.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField19.setText(" Commited Date-2 :");
    jTextField19.setForeground(new Color(10,36,106));
    jTextField19.setBorder(null);
    jTextField19.setOpaque(true);
    //jTextField19.setSelectionStart(4);
    jTextField19.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField19.setBackground(new Color(143, 143, 188));
    jTextField20.setBounds(new Rectangle(390, 364, 136, 23));
    jTextField20.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField20.setText(" Commited Yard-2 :");
    jTextField20.setForeground(new Color(10,36,106));
    jTextField20.setBorder(null);
    jTextField20.setOpaque(true);
    jTextField20.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField20.setBackground(new Color(143, 143, 188));
    jTextField21.setBounds(new Rectangle(13, 398, 136, 23));
    jTextField21.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField21.setText(" Confirm Person-2 :");
    jTextField21.setForeground(Color.white);
    jTextField21.setBorder(null);
    jTextField21.setOpaque(true);
    jTextField21.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField21.setBackground(new Color(143, 143, 188));
    jTextField22.setBounds(new Rectangle(13, 430, 136, 23));
    jTextField22.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField22.setText(" Detail Remark :");
    jTextField22.setForeground(new Color(10,36,106));
    jTextField22.setBorder(null);
    jTextField22.setOpaque(true);
    jTextField22.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField22.setBackground(new Color(143, 143, 188));

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("   ============  Material Detail ============   ");
    jLabel1.setBounds(new Rectangle(104, 13, 566, 24));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setMinimumSize(new Dimension(78, 18));
    jLabel2.setText("(YYYY/MM/DD)");
    jLabel2.setBounds(new Rectangle(234, 296, 85, 22));
    jLabel3.setBounds(new Rectangle(234, 364, 85, 22));
    jLabel3.setText("(YYYY/MM/DD)");
    jLabel3.setMinimumSize(new Dimension(78, 18));
    jLabel3.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    tfMill_MtrNo.setFont(new java.awt.Font("Dialog", 0, 12));
    tfMill_MtrNo.setBounds(new Rectangle(527, 58, 209, 23));
    tfDupsMIN.setBounds(new Rectangle(150, 228, 209, 23));
    tfDupsMIN.setFont(new java.awt.Font("Dialog", 0, 12));
    tfDupsMIN.setText("");
    tfDupsMIN.setHorizontalAlignment(SwingConstants.TRAILING);
    tfBulkMIN.setHorizontalAlignment(SwingConstants.TRAILING);
    tfBulkMIN.setText("");
    tfBulkMIN.setFont(new java.awt.Font("Dialog", 0, 12));
    tfBulkMIN.setBounds(new Rectangle(150, 262, 209, 23));
    tfBulkLEAD.setBounds(new Rectangle(527, 262, 131, 23));
    tfBulkLEAD.setFont(new java.awt.Font("Dialog", 0, 12));
    tfBulkLEAD.setText("");
    tfBulkLEAD.setHorizontalAlignment(SwingConstants.TRAILING);
    tfDupsLEAD.setHorizontalAlignment(SwingConstants.TRAILING);
    tfDupsLEAD.setText("");
    tfDupsLEAD.setFont(new java.awt.Font("Dialog", 0, 12));
    tfDupsLEAD.setBounds(new Rectangle(527, 228, 131, 23));
    tfCommDate1.setBounds(new Rectangle(150, 296, 79, 23));
    tfCommDate1.setFont(new java.awt.Font("Dialog", 0, 12));
    tfCommDate1.setText("");
    tfCommDate2.setText("");
    tfCommDate2.setFont(new java.awt.Font("Dialog", 0, 12));
    tfCommDate2.setBounds(new Rectangle(150, 364, 79, 23));
    tfCommYard2.setBounds(new Rectangle(527, 364, 209, 23));
    tfCommYard2.setFont(new java.awt.Font("Dialog", 0, 12));
    tfCommYard2.setText("");
    tfCommYard2.setHorizontalAlignment(SwingConstants.TRAILING);
    tfCommYard1.setHorizontalAlignment(SwingConstants.TRAILING);
    tfCommYard1.setFont(new java.awt.Font("Dialog", 0, 12));
    tfCommYard1.setBounds(new Rectangle(527, 296, 209, 23));
    tfCommPerson1.setBounds(new Rectangle(150, 330, 585, 23));
    tfCommPerson1.setFont(new java.awt.Font("Dialog", 0, 12));
    tfCommPerson1.setText("");
    tfCommPerson2.setText("");
    tfCommPerson2.setFont(new java.awt.Font("Dialog", 0, 12));
    tfCommPerson2.setBounds(new Rectangle(150, 398, 585, 23));
    tfRemark.setBounds(new Rectangle(150, 430, 585, 23));
    tfRemark.setFont(new java.awt.Font("Dialog", 0, 12));
    tfRemark.setText("");
    cboTerm.setBounds(new Rectangle(527, 126, 209, 23));
    cboTerm.setBackground(Color.WHITE);
    cboDest.setBounds(new Rectangle(527, 160, 209, 23));
    cboDest.setBackground(Color.WHITE);
    jPanel1.setLayout(null);
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setOpaque(true);
    jTextField7.setRequestFocusEnabled(true);
    jTextField7.setBorder(null);
    jTextField7.setForeground(new Color(10,36,106));
    jTextField7.setText("Local Currency :");
    jTextField7.setHorizontalAlignment(SwingConstants.LEADING);
    jTextField7.setBounds(new Rectangle(13, 159, 136, 23));
    cboCurny.setBounds(new Rectangle(150, 159, 209, 23));
    cboCurny.setBackground(Color.WHITE);
    //jComboBox1.setBounds(new Rectangle(301, 93, 69, 21));
    //jComboBox1.setBounds(new Rectangle(299, 126, 72, 23));
    cbxUsdUnit.setBounds(new Rectangle(270, 93, 89, 21));
    cbxLocalUnit.setBounds(new Rectangle(270, 125, 87, 23));
    txtPrxUSD.setBounds(new Rectangle(150, 92, 74, 23));
    txtPrxLocal.setText("");
    txtPrxLocal.setBounds(new Rectangle(151, 125, 73, 23));
    txtCnfmUsd.setText("");
    txtCnfmUsd.setBounds(new Rectangle(527, 91, 208, 23));
    txtCnfmLocal.setBounds(new Rectangle(529, 193, 209, 23));
    slkChzMiller.setBounds(new Rectangle(150, 58, 163, 23));
    btnAddMill.setBounds(new Rectangle(318, 59, 40, 21));
    btnAddMill.setFont(new java.awt.Font("Dialog", 1, 16));
    btnAddMill.setForeground(Color.orange);
    btnAddMill.setToolTipText("Add New Mill To Select");
    btnAddMill.setHorizontalAlignment(SwingConstants.CENTER);
    btnAddMill.setHorizontalTextPosition(SwingConstants.TRAILING);
    btnAddMill.setText("*");
    btnAddMill.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnAddMill.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    btnAddMill.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddMill_actionPerformed(e);
      }
    });
    jTextField110.setBackground(new Color(143, 143, 188));
    jTextField110.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField110.setOpaque(true);
    jTextField110.setBorder(null);
    jTextField110.setForeground(new Color(10,36,106));
    jTextField110.setText("Days");
    jTextField110.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField110.setBounds(new Rectangle(659, 228, 81, 23));
    jTextField111.setBackground(new Color(143, 143, 188));
    jTextField111.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField111.setOpaque(true);
    jTextField111.setBorder(null);
    jTextField111.setForeground(Color.white);
    jTextField111.setText("Days");
    jTextField111.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField111.setHorizontalTextPosition(SwingConstants.CENTER);
    jTextField111.setBounds(new Rectangle(659, 262, 81, 23));
    jPanel1.add(jLabel1, null);
    jPanel1.add(jTextField8, null);
    jPanel1.add(jTextField3, null);
    jPanel1.add(jTextField1, null);
    jPanel1.add(jTextField5, null);
    jPanel1.add(jTextField2, null);
    jPanel1.add(tfMill_MtrNo, null);
    jPanel1.add(tfCommPerson2, null);
    jPanel1.add(jTextField12, null);
    jPanel1.add(tfDupsMIN, null);
    jPanel1.add(jTextField13, null);
    jPanel1.add(tfDupsLEAD, null);
    jPanel1.add(jTextField14, null);
    jPanel1.add(tfBulkMIN, null);
    jPanel1.add(jTextField15, null);
    jPanel1.add(tfBulkLEAD, null);
    jPanel1.add(jTextField16, null);
    jPanel1.add(tfCommDate1, null);
    jPanel1.add(jTextField17, null);
    jPanel1.add(tfCommYard1, null);
    jPanel1.add(jTextField18, null);
    jPanel1.add(tfCommPerson1, null);
    jPanel1.add(jTextField19, null);
    jPanel1.add(tfCommDate2, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jTextField20, null);
    jPanel1.add(tfCommYard2, null);
    jPanel1.add(jTextField21, null);
    jPanel1.add(jTextField9, null);
    jPanel1.add(cboTerm, null);
    jPanel1.add(jTextField22, null);
    jPanel1.add(tfRemark, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jTextField11, null);
    jPanel1.add(jTextField10, null);
    jPanel1.add(cboDest, null);
    jPanel1.add(jTextField7, null);
    jPanel1.add(cboCurny, null);
    jPanel1.add(txtPrxUSD, null);
    jPanel1.add(jTextField4, null);
    jPanel1.add(cbxUsdUnit, null);
    jPanel1.add(jTextField6, null);
    jPanel1.add(cbxLocalUnit, null);
    jPanel1.add(txtPrxLocal, null);
    jPanel1.add(txtCnfmLocal, null);
    jPanel1.add(txtCnfmUsd, null);
    jPanel1.add(slkChzMiller, null);
    jPanel1.add(btnAddMill, null);
    jPanel1.add(jTextField110, null);
    jPanel1.add(jTextField111, null);
    //jPanel1.add(jComboBox1, null);
    this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3, 4, 4, 0), 768, 473));
    //jPanel1.add(jComboBox1, null);

    initActionListener();
    initAllComboBox(currRecord);
    initGroupField();
  }
  private void initGroupField(){
    tfGroup[0]  = this.tfBulkLEAD;
    tfGroup[1]  = this.tfBulkMIN;
    tfGroup[2]  = this.txtCnfmLocal;
    tfGroup[4]  = this.txtCnfmUsd;
    tfGroup[6]  = this.tfCommDate1;
    tfGroup[7]  = this.tfCommDate2;
    tfGroup[8]  = this.tfCommPerson1;
    tfGroup[9]  = this.tfCommPerson2;
    tfGroup[10] = this.tfCommYard1;
    tfGroup[11] = this.tfCommYard2;
    tfGroup[12] = this.tfDupsLEAD;
    tfGroup[13] = this.tfDupsMIN;
    //tfGroup[14] = this.tfLocal_UNIT;
    tfGroup[15] = this.txtPrxLocal;
    //tfGroup[16] = this.tfLocal2;
    tfGroup[17] = this.tfRemark;
    //tfGroup[18] = this.tfUSD_Unit;
    tfGroup[19] = this.txtPrxUSD;
    //tfGroup[20] = this.tfUSD2;
    tfGroup[21] = this.tfMill_MtrNo;
    //tfGroup[22] = this.tfCurny;

    cboGroup[0] = this.cboTerm;
    cboGroup[1] = this.cboDest;
    cboGroup[2]=this.cboCurny;
    cboGroup[3]=this.cbxUsdUnit;
    cboGroup[4]=this.cbxLocalUnit;
  }

  private void initActionListener(){
  }
  private void initAllComboBox(Record rec){
    if(fieldsInited)return;
    fieldsInited=true;
    try{
      PrctermList = exgui2.CONST.Material_Dtl_EJB.getAllPrcterm();
      Util.setComboValues(cboTerm, PrctermList, PRCTRM_EJB.PRC_TRM ,true);
      CityList = exgui2.CONST.Material_Dtl_EJB.getAllCity();
      //Util.setComboValues(cboDest, CityList, CITY_EJB.NAME ,true);
     exgui.DataBindJCombobox dbDest2chz=new exgui.DataBindJCombobox(
             cboDest, MTRDTL_EJB.PRX_DEST, newtimes.material.MaterialMenu.Destination4Mtrl, "Dest_name",
             "dest_name",null);


      java.util.Vector vctUnit=newtimes.preproduction.guis.tempProperties.tmpUnits;
      if(rec==null){
        dbCbxUsdUnit=new exgui.DataBindJCombobox(
             cbxUsdUnit,
             MTRDTL_EJB.UNIT_USD,
             vctUnit,
             "UNIT","UNIT",
             null,
             "",null);

         dbCbxLocalUnit=new exgui.DataBindJCombobox(
              cbxLocalUnit,
              MTRDTL_EJB.UNIT_LOCAL,
              vctUnit,
              "UNIT","UNIT",
              null,
              "",null);

        dbCbxCurrency=
            new exgui.DataBindJCombobox(
             cboCurny,
             MTRDTL_EJB.CURRENCY_LOCAL,
             newtimes.preproduction.guis.tempProperties.tmpCurrency,
             "CRNCY_NAME","CRNCY_NAME",
             null,
             "",null);
      }else{
          dbCbxCurrency =
              new exgui.DataBindJCombobox(
              cboCurny,
              MTRDTL_EJB.CURRENCY_LOCAL,
              newtimes.preproduction.guis.tempProperties.tmpCurrency,
              "CRNCY_NAME", "CRNCY_NAME",
              rec.get(MTRDTL_EJB.CURRENCY_LOCAL),
              "", null);

            dbCbxUsdUnit=new exgui.DataBindJCombobox(
                 cbxUsdUnit,
                 MTRDTL_EJB.UNIT_USD,
                 vctUnit,
                 "UNIT","UNIT",
                 rec.get(MTRDTL_EJB.UNIT_USD),
                 "",null);

             dbCbxLocalUnit=new exgui.DataBindJCombobox(
                  cbxLocalUnit,
                  MTRDTL_EJB.UNIT_LOCAL,
                  vctUnit,
                  "UNIT","UNIT",
                  rec.get(MTRDTL_EJB.UNIT_LOCAL),
                  "",null);

      }
    }
    catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at MaterialSearch.initAllComboBox()");
    }
  }

  private void initAllFields(){
    try{
      Object MILL_NO=null,PRX_USD=null,PRX_LOCAL=null,CNFM_PRX_USD=null,
          CNFM_PRX_LOCAL=null,DUPS_MINQTY=null;
      Object DUPS_LEADTIME=null,BULK_MINQTY=null,BULK_LEADTIME=null,
          COMMITED_YARD1=null,COMMITED_YARD2=null;
      Object CONFIRM_PERSON1=null,CONFIRM_PERSON2=null,
          COMMITED_DATE1=null,COMMITED_DATE2=null,GEN_REMARK=null;
      if (currRecord != null) {
        MILL_NO=currRecord.get(MTRDTL_EJB.MILL_NO);
        PRX_USD=currRecord.get(MTRDTL_EJB.PRX_USD);
        PRX_LOCAL=currRecord.get(MTRDTL_EJB.PRX_LOCAL);
        CNFM_PRX_USD=currRecord.get(MTRDTL_EJB.CNFM_PRX_USD);
        CNFM_PRX_LOCAL=currRecord.get(MTRDTL_EJB.CNFM_PRX_LOCAL);
        DUPS_MINQTY=currRecord.get(MTRDTL_EJB.DUPS_MINQTY);
        DUPS_LEADTIME=currRecord.get(MTRDTL_EJB.DUPS_LEADTIME);
        BULK_MINQTY=currRecord.get(MTRDTL_EJB.BULK_MINQTY);
        BULK_LEADTIME=currRecord.get(MTRDTL_EJB.BULK_LEADTIME);
        COMMITED_YARD1=currRecord.get(MTRDTL_EJB.COMMITED_YARD1);
        COMMITED_YARD2=(currRecord.get(MTRDTL_EJB.COMMITED_YARD2));
        CONFIRM_PERSON1=(currRecord.get(MTRDTL_EJB.CONFIRM_PERSON1));
        CONFIRM_PERSON2=currRecord.get(MTRDTL_EJB.CONFIRM_PERSON2);
        java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
        df.setLenient(false);
        COMMITED_DATE1=(currRecord.get(MTRDTL_EJB.COMMITED_DATE1));
        COMMITED_DATE2=(currRecord.get(MTRDTL_EJB.COMMITED_DATE2));
        if(currRecord.get(MTRDTL_EJB.BYMKR_BRIEF)!=null)
           slkChzMiller.init("",currRecord.get(MTRDTL_EJB.BYMKR_SEQ),
                             slkChzMiller.TYPE_FABRIC_MILL,true);
         else
           slkChzMiller.init("",null,
                             slkChzMiller.TYPE_FABRIC_MILL,true);
                  //popMill.setText(currRecord.get(MTRDTL_EJB.BYMKR_BRIEF).toString());
        if(currRecord.get(MTRDTL_EJB.PRX_PRCTERM)!=null)
          cboTerm.setSelectedItem(currRecord.get(MTRDTL_EJB.PRX_PRCTERM));
        if(currRecord.get(MTRDTL_EJB.PRX_DEST)!=null)
          cboDest.setSelectedItem(currRecord.get(MTRDTL_EJB.PRX_DEST));
        if(currRecord.get(MTRDTL_EJB.CURRENCY_LOCAL)!=null)
          cboCurny.setSelectedItem(currRecord.get(MTRDTL_EJB.CURRENCY_LOCAL));
        GEN_REMARK=currRecord.get(MTRDTL_EJB.GEN_REMARK);
      }else{
        slkChzMiller.init("",null,slkChzMiller.TYPE_FABRIC_MILL,true);
      }
      Object vftfMill_MtrNo=exgui.verification.CellFormat.getOrdinaryField(18);
      dbTxttfMill_MtrNo=new exgui.DataBindTextWithChecker(tfMill_MtrNo,
                                            "MTRDTL_MILL_NO",
                                             MILL_NO,
                                            18,(exgui.Object2String)vftfMill_MtrNo,
                                            (exgui.ultratable.CellTxtEditorFormat)
                                            vftfMill_MtrNo);


       Object vftxtPrxUSD=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
        dbTxttxtPrxUSD= new exgui.DataBindTextWithChecker(txtPrxUSD,
                                           "MTRDTL_PRX_USD",
                                           PRX_USD,8,
                                           (exgui.Object2String)vftxtPrxUSD,
                                           (exgui.ultratable.CellTxtEditorFormat)vftxtPrxUSD);

       Object vftxtPrxLocal=
           exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
       dbTxttxtPrxLocal= new exgui.DataBindTextWithChecker(txtPrxLocal,
                             "MTRDTL_PRX_LOCAL",
                               PRX_LOCAL,11,
                               (exgui.Object2String)vftxtPrxLocal,
                               (exgui.ultratable.CellTxtEditorFormat)vftxtPrxLocal);


       Object vftfDupsMIN=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
       dbTxttfDupsMIN= new exgui.DataBindTextWithChecker(
               tfDupsMIN,"MTRDTL_DUPS_MINQTY",
                DUPS_MINQTY,10,
               (exgui.Object2String)vftfDupsMIN,
               (exgui.ultratable.CellTxtEditorFormat)vftfDupsMIN);

       Object vftfBulkMIN=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
        dbTxttfBulkMIN= new exgui.DataBindTextWithChecker(
           tfBulkMIN,"MTRDTL_BULK_MINQTY",
            BULK_MINQTY,10,
            (exgui.Object2String)
            vftfBulkMIN,(exgui.ultratable.CellTxtEditorFormat)vftfBulkMIN);

       Object vftfBulkLEAD=exgui.verification.CellFormat.getIntVerifierAllowNull(3);
         dbTxttfBulkLEAD=
             new exgui.DataBindTextWithChecker(
               tfBulkLEAD,
              "MTRDTL_BULK_LEAD_TIME",
              BULK_LEADTIME,3,
             (exgui.Object2String)vftfBulkLEAD,
             (exgui.ultratable.CellTxtEditorFormat)vftfBulkLEAD);

       Object vftfDupsLEAD=exgui.verification.CellFormat.getIntVerifierAllowNull(3);
        dbTxttfDupsLEAD=  new exgui.DataBindTextWithChecker(
              tfDupsLEAD,
              "MTRDTL_DUPS_LEAD_TIME",
              DUPS_LEADTIME,3,
              (exgui.Object2String)vftfDupsLEAD,
              (exgui.ultratable.CellTxtEditorFormat)vftfDupsLEAD);

       Object vftfCommDate1=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dbTxttfCommDate1 =new exgui.DataBindTextWithChecker(tfCommDate1,
         "MTRDTL_COMMITED_DATE1",
         COMMITED_DATE1,10,
         (exgui.Object2String)vftfCommDate1,
         (exgui.ultratable.CellTxtEditorFormat)vftfCommDate1);

     dbTxttfCommDate2 =new exgui.DataBindTextWithChecker(tfCommDate2,
       "MTRDTL_COMMITED_DATE2",
       COMMITED_DATE2,10,
       (exgui.Object2String)vftfCommDate1,
       (exgui.ultratable.CellTxtEditorFormat)vftfCommDate1);


       Object vftfCommYard2=exgui.verification.CellFormat.getIntVerifierAllowNull(15);
        dbTxttfCommYard2= new exgui.DataBindTextWithChecker(
          tfCommYard2,
          "MTRDTL_COMMITED_YARD2",
          COMMITED_YARD2,15,
          (exgui.Object2String)vftfCommYard2,
          (exgui.ultratable.CellTxtEditorFormat)vftfCommYard2);

        dbTxttfCommYard1= new exgui.DataBindTextWithChecker(
          tfCommYard1,
          "MTRDTL_COMMITED_YARD1",
          COMMITED_YARD1,15,
          (exgui.Object2String)vftfCommYard2,
          (exgui.ultratable.CellTxtEditorFormat)vftfCommYard2);


       Object vftfCommPerson1=exgui.verification.CellFormat.getOrdinaryField(60);

       dbTxttfCommPerson1= new exgui.DataBindTextWithChecker(
            tfCommPerson1,"MTRDTL_CONFIRM_PERSON1",
             CONFIRM_PERSON1,60,
            (exgui.Object2String)vftfCommPerson1,
            (exgui.ultratable.CellTxtEditorFormat)vftfCommPerson1);
         dbTxttfCommPerson2= new exgui.DataBindTextWithChecker(
              tfCommPerson2,"MTRDTL_CONFIRM_PERSON2",
               CONFIRM_PERSON2,60,
              (exgui.Object2String)vftfCommPerson1,
              (exgui.ultratable.CellTxtEditorFormat)vftfCommPerson1);



       Object vftfRemark=exgui.verification.CellFormat.getOrdinaryField(200);
       dbTxttfRemark= new exgui.DataBindTextWithChecker(
         tfRemark,"MTRDTL_GEN_REMARK",
         GEN_REMARK,200,
         (exgui.Object2String)vftfRemark,
         (exgui.ultratable.CellTxtEditorFormat)vftfRemark);

       Object vftxtCnfmUsd=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
        dbTxttxtCnfmUsd=new exgui.DataBindTextWithChecker(
              txtCnfmUsd,
              "MTRDTL_CNFM_PRX_USD",
              CNFM_PRX_USD,
              11,(exgui.Object2String)vftxtCnfmUsd,
              (exgui.ultratable.CellTxtEditorFormat)vftxtCnfmUsd);

       Object vftxtCnfmLocal=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
        dbTxttxtCnfmLocal=
            new exgui.DataBindTextWithChecker(
            txtCnfmLocal,
            "MTRDTL_CNFM_PRX_LOCAL",CNFM_PRX_LOCAL,
            11,(exgui.Object2String)vftxtCnfmLocal,
            (exgui.ultratable.CellTxtEditorFormat)vftxtCnfmLocal);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }



//******************************************************************
//******************************************************************
  private void SaveMtrDtlRec(){
    try{
      Object entry = null;
      String mtrNo=null;
      if(currRecord==null){
        HashMap mtrdtlCond = (HashMap) util.ApplicationProperites.getProperties(
            MTRDTL_COND.CONDITIONS);
        entry = mtrdtlCond.get(MTR_SEARCH.MTR_NO);
        mtrNo = (entry == null) ? ("") : ( (String) entry);
      }
      else{
        entry = currRecord.get(MTRDTL_EJB.MTR_NO);
        mtrNo = (entry==null)?(""):((String)entry);
      }

      if(mtrNo!=null && !mtrNo.equals("")){
        Record rec = exgui2.CONST.Material_Dtl_EJB.getBlankRecord();
        rec.set(MTRDTL_EJB.MTR_NO, mtrNo);
        //rec.set(MTRDTL_EJB.BYMKR_SEQ, popMill.getSelectedFabricMillValue());
        rec.set(MTRDTL_EJB.BYMKR_SEQ, slkChzMiller.getSelectedValue());
        rec.set(MTRDTL_EJB.MILL_NO,         dbTxttfMill_MtrNo.getSelectedValue());
        rec.set(MTRDTL_EJB.PRX_USD,         dbTxttxtPrxUSD.getSelectedValue());
        rec.set(MTRDTL_EJB.UNIT_USD,        dbCbxUsdUnit.getSelectedValue());
        rec.set(MTRDTL_EJB.PRX_PRCTERM,     cboTerm.getSelectedItem());
        rec.set(MTRDTL_EJB.PRX_DEST,        cboDest.getSelectedItem());
        rec.set(MTRDTL_EJB.PRX_LOCAL,       dbTxttxtPrxLocal.getSelectedValue());
        rec.set(MTRDTL_EJB.UNIT_LOCAL,      dbCbxLocalUnit.getSelectedValue());
        rec.set(MTRDTL_EJB.CNFM_PRX_USD,    dbTxttxtCnfmUsd.getSelectedValue());
        rec.set(MTRDTL_EJB.CNFM_PRX_LOCAL,  dbTxttxtCnfmLocal.getSelectedValue());
        rec.set(MTRDTL_EJB.DUPS_MINQTY,     dbTxttfDupsMIN.getSelectedValue());
        rec.set(MTRDTL_EJB.DUPS_LEADTIME,   dbTxttfDupsLEAD.getSelectedValue());
        rec.set(MTRDTL_EJB.BULK_MINQTY,     dbTxttfBulkMIN.getSelectedValue());
        rec.set(MTRDTL_EJB.BULK_LEADTIME,   dbTxttfBulkLEAD.getSelectedValue());
        rec.set(MTRDTL_EJB.GEN_REMARK,      dbTxttfRemark.getSelectedValue());
        rec.set(MTRDTL_EJB.CONFIRM_PERSON1, dbTxttfCommPerson1.getSelectedValue());
        rec.set(MTRDTL_EJB.CONFIRM_PERSON2, dbTxttfCommPerson2.getSelectedValue());
        rec.set(MTRDTL_EJB.COMMITED_YARD1,  dbTxttfCommYard1.getSelectedValue());
        rec.set(MTRDTL_EJB.COMMITED_YARD2,  dbTxttfCommYard2.getSelectedValue());
        /*
        rec.set(MTRDTL_EJB.CURRENCY_LOCAL, tfCurny.getText());
        */
        rec.set(MTRDTL_EJB.CURRENCY_LOCAL, dbCbxCurrency.getSelectedValue());
        /*
        java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
        df.setLenient(false);
        String dateTxt1 = tfCommDate1.getText();
        String dateTxt2 = tfCommDate2.getText();
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        if(!dateTxt1.equals("")){
          try{
            date1 = df.parse(dateTxt1);
          }
          catch(java.text.ParseException pe){
            mtrWarnDialog warning =
              new mtrWarnDialog(null, "Date Error", "Date Format error!", true);
            tfCommDate1.requestFocus();
            return;
          }
        }
        if(!dateTxt2.equals("")){
          try{
            date2 = df.parse(dateTxt2);
          }
          catch(java.text.ParseException pe){
            mtrWarnDialog warning =
              new mtrWarnDialog(null, "Date Error", "Date Format error!", true);
            tfCommDate2.requestFocus();
            return;

          }
        }
        */
        rec.set(MTRDTL_EJB.COMMITED_DATE1, dbTxttfCommDate1.getSelectedValue());
        rec.set(MTRDTL_EJB.COMMITED_DATE2, dbTxttfCommDate2.getSelectedValue());

        if(currRecord==null){
          rec.set(COMMON.CREATE_USER, CurrUser.get("USR_CODE"));
          rec.set(COMMON.DELETE_FLAG, "1");
          rec.set(COMMON.MODIFY_USER, CurrUser.get("USR_CODE"));
          //if is JJ deport,need to check Mill MTR No and Mill Name exists or not.
          if(util.PublicVariable.USER_RECORD.get(5).equals("TPJ06") ){
            StringBuffer sb=new StringBuffer();
            sb.append("select MTRDTL_PK from MATERIAL_DETAIL where MTRDTL_MILL_NO=");
            String mtrNoObj=tfMill_MtrNo.getText().trim();
            if(mtrNoObj.length()==0){
              sb.append(" is null ");
            }else{
              sb.append("'");
              sb.append(util.MiscFunc.Replace(mtrNoObj,"'","''"));
              sb.append("'");
            }
            sb.append(" and MTRDTL_BYMKR_SEQ=");sb.append(slkChzMiller.getSelectedValue());
            sb.append(" and record_delete_flag='1'");
            Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                            sb.toString(),1,9999);
            if(vct.size()>0){
              exgui.verification.VerifyLib.showAlert("Mill Name And Mill Mtr No Already Defined",
                                                     "Mill Name And Mill Mtr No Already Defined");
              return;
            }
          }
          exgui2.CONST.Material_Dtl_EJB.insertRecord(rec);
          /*
          yes_no = exgui2.InfoMessage.Yes_No_Option(new JFrame(),
            "Insert Succeed.\nDo you want to edit new records ?");
          */
          String message="Insert Succeed.\nDo you want to edit new records ?";
          int optionType=javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
          int messageType=javax.swing.JOptionPane.QUESTION_MESSAGE;
          String btnCaption[]={"YES","NO","TO SEARCH PAGE"};
          yes_no=javax.swing.JOptionPane.showOptionDialog(
           util.PublicVariable.APP_FRAME,
           message,"Option",optionType,messageType,null,btnCaption,btnCaption[1]
           );


          //if (yes_no == 0) {
          if(yes_no==javax.swing.JOptionPane.YES_OPTION){
            for (int i = 0; i < tfGroup.length; i++) {
              if(tfGroup[i]!=null)tfGroup[i].setText("");
            }
            initAllComboBox(rec);
          }if(yes_no==javax.swing.JOptionPane.CANCEL_OPTION){
            java.awt.Cursor tCur = this.getCursor();
            this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;
            CONST.HIST.insertState(CONST.HIST.MENU,frame);
            frame.showPanel(new newtimes.material.MaterialSearch(frame,1));
            this.setCursor(tCur);
          }
        }else{

          rec.set(COMMON.DELETE_USER, CurrUser.get("USR_CODE"));
          rec.set(MTRDTL_EJB.PK, currRecord.get(MTRDTL_EJB.PK));

          if(util.PublicVariable.USER_RECORD.get(5).equals("TPJ06") ){
            StringBuffer sb=new StringBuffer();
            sb.append("select MTRDTL_PK from MATERIAL_DETAIL where MTRDTL_MILL_NO=");
            String mtrNoObj=tfMill_MtrNo.getText().trim();
            if(mtrNoObj.length()==0){
              sb.append(" is null ");
            }else{
              sb.append("'");
              sb.append(util.MiscFunc.Replace(mtrNoObj,"'","''"));
              sb.append("'");
            }
            sb.append(" and MTRDTL_BYMKR_SEQ=");sb.append(slkChzMiller.getSelectedValue());
            sb.append(" and record_delete_flag='1' and MTRDTL_PK <>");sb.append(currRecord.get(MTRDTL_EJB.PK).toString());
            Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                            sb.toString(),1,9999);
            if(vct.size()>0){
              exgui.verification.VerifyLib.showAlert("Mill Name And Mill Mtr No Already Defined",
                                                     "Mill Name And Mill Mtr No Already Defined");
              return;
            }
          }

          util.MiscFunc.showProcessingMessage();
          exgui2.CONST.Material_Dtl_EJB.updateRecord(rec);
          mtrWarnDialog message =
              new mtrWarnDialog(null, "Save", "Record(s) Saved!", true);
          util.MiscFunc.hideProcessingMessage();

        }
      }
      else{
        mtrWarnDialog warning =
              new mtrWarnDialog(null, "Error", "Data Error!", true);
      }

    }
    catch(Exception e){
      util.MiscFunc.hideProcessingMessage();
      e.printStackTrace();
      mtrWarnDialog message =
              new mtrWarnDialog(null, "Error", "Exception occured!", true);
    }
  }

  private String getNumber(JTextField first, JTextField second){
    String upperDigit = first.getText();
      if(upperDigit.equals("")) upperDigit = "0";

    String lowerDigit = second.getText();
      if(lowerDigit.equals("")) lowerDigit = "0";

     return upperDigit+"."+lowerDigit;
  }

  private void NumberToTextField(String Num, JTextField first, JTextField second){
    String digits[] = Num.split("[.]");
    if(digits.length==1){
      first.setText(digits[0]);
      second.setText("0");
    }
    else if(digits.length>1){
      first.setText(digits[0]);
      second.setText(digits[1]);
    }
    else{
      first.setText("0");
      second.setText("0");
    }


  }
  //Functions of CommonFunc interface
  public void RecSave(){
    //before saving,JJ department have to check duplication of MIll name Mill Mtr No.
    String MillName=(slkChzMiller.getSelectedValue()==null)?"":slkChzMiller.getSelectedValue().toString();
    String MillMtrNo=tfMill_MtrNo.getText().trim();
    //add mode,need to check
    java.awt.Cursor tCur = this.getParent().getCursor();
    this.getParent().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    SaveMtrDtlRec();
    this.getParent().setCursor(tCur);
  }

  public void PrevStep(){
  }

  public void RecDelete(){
    try{
      util.MiscFunc.showProcessingMessage();
      Object entry = null;
      BigDecimal PK =null;
      if(currRecord!=null){

        entry = currRecord.get(MTRDTL_EJB.PK);
        PK    = (entry==null)?(new BigDecimal("")):((BigDecimal)entry);

        Record rec = exgui2.CONST.Material_Dtl_EJB.getBlankRecord();
        rec.set(MTRDTL_EJB.PK, PK);
        rec.set(COMMON.DELETE_FLAG, "0");
        rec.set(COMMON.DELETE_USER, CurrUser.get("USR_CODE"));
        rec.set(COMMON.MODIFY_USER, CurrUser.get("USR_CODE"));

        exgui2.CONST.Material_Dtl_EJB.deleteRecord(rec);
        mtrWarnDialog message =
              new mtrWarnDialog(null, "Delete", "Record deleted!!", true);
      }
    }
    catch(Exception e){
      e.printStackTrace();
      mtrWarnDialog message =
              new mtrWarnDialog(null, "Delete", "Record delete Error!!", true);
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  public void RecCopy(){
    try{
      HashMap hm = new HashMap();
      for (int i = 0; i < tfGroup.length; i++) {
        String id = "tf" + i;
        if(tfGroup[i]!=null){
          String value = new String(tfGroup[i].getText());
          hm.put(id, value);
        }
      }
      for (int i = 0; i < cboGroup.length; i++) {
        String id = "cbo" + i;
        Integer index = new Integer(cboGroup[i].getSelectedIndex());
        hm.put(id, index);
      }
      hm.put("copyMaterialDetail_miller_seq",slkChzMiller.getSelectedValue());
      util.ApplicationProperites.setProperties("copyMaterialDetail", hm);
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public void RecPaste(){
    try{
      Object entry = util.ApplicationProperites.getProperties("copyMaterialDetail");
      if(entry!=null){
        HashMap hm = (HashMap)entry;
        for(int i=0; i<tfGroup.length; i++){
          String id = "tf"+i;
          if(tfGroup[i]!=null)tfGroup[i].setText((String)hm.get(id));
        }
        for(int i=0; i<cboGroup.length; i++){
          String id = "cbo"+i;
          int index = ((Integer)hm.get(id)).intValue();
          cboGroup[i].setSelectedIndex(index);
        }
        slkChzMiller.init("",hm.get("copyMaterialDetail_miller_seq"),
                          slkChzMiller.TYPE_FABRIC_MILL,true);
        this.validate();
      }
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  //Add by Chloe 2003.09.25
  void setMaxLength(){
    exgui.DataBindText tx = null;
    //tx = new exgui.DataBindText(tfUSD_Unit,null,"",2);
    //tx = new exgui.DataBindText(tfLocal_UNIT,null,"",2);
  }
  JComboBox cbxUsdUnit = new JComboBox();
  JComboBox cbxLocalUnit = new JComboBox();
  JTextField txtPrxUSD = new JTextField();
  JTextField txtCnfmLocal = new JTextField();
  JTextField txtPrxLocal = new JTextField();
  JTextField txtCnfmUsd = new JTextField();
  SelectBuyerMaker slkChzMiller = new SelectBuyerMaker();
  JButton btnAddMill = new JButton();
  JLabel jTextField110 = new JLabel();
  JLabel jTextField111 = new JLabel();

  void btnAddMill_actionPerformed(ActionEvent e) {
    DlgAddMill dlg=new DlgAddMill(util.PublicVariable.APP_FRAME,"ADD A MILL",true);
    dlg.setSize(420,320);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
}
