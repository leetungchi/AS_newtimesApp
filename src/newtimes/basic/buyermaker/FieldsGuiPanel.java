package newtimes.basic.buyermaker;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FieldsGuiPanel extends JPanel {
  Frame1 frame;
  JPanel jPanel1 = new JPanel();
  JRadioButton rb_Y = new JRadioButton();
  JRadioButton rb_N = new JRadioButton();
  JTextField txtPerson = new JTextField();
  JTextField txtWeb = new JTextField();
  JTextField txtEmail = new JTextField();
  JTextField txtBrief = new JTextField();
  JComboBox cmboCnty = new JComboBox();
  JRadioButton jRadioButton2 = new JRadioButton();
  JTextField txtBenef = new JTextField();
  JComboBox cmboCat = new JComboBox();
  //JTextField txtDes = new JTextField();
  JComboBox cmboDest = new JComboBox();
  JTextField txtBoss = new JTextField();
  JTextField txtName = new JTextField();
  JTextField txtSewingCode = new JTextField();
  JTextField txtWarehouse = new JTextField();
  exgui.DataBindJCombobox dbJCBXCnty = null;
  exgui.DataBindJCombobox dbJCBXQuota = null;
  exgui.DataBindJCombobox dbJCBXLic = null;
  exgui.DataBindJCombobox dbJCBXMasCo = null;
  exgui.DataBindJCombobox dbJCBXCity = null;
  exgui.DataBindJCombobox dbJCBXPay = null;
  exgui.DataBindJCombobox dbJCBXPrice = null,dbJCBXdests=null;
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JTextField txtChBrief = new JTextField();
  JTextField txtOld = new JTextField();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaAudit = new JTextArea();
  JComboBox cmboCity = new JComboBox();
  JComboBox cmboPay = new JComboBox();
  JComboBox cmboPrice = new JComboBox();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JTextField txtAddr1 = new JTextField();
  JTextField txtAddr2 = new JTextField();
  JTextField txtAddr4 = new JTextField();
  JTextField txtAddr3 = new JTextField();
  JTextField txt2ndAddr4 = new JTextField();
  JTextField txt2ndAddr2 = new JTextField();
  JTextField txt2ndAddr1 = new JTextField();
  JTextField txt2ndAddr3 = new JTextField();
  JTextField txtTel1 = new JTextField();
  JTextField txtTel2 = new JTextField();
  JTextField txtFax2 = new JTextField();
  JTextField txtFax1 = new JTextField();
  DataBindTextWithChecker dbBuyerComm,dbBuyerCommPc,dbBuyerCommDz,dbBuyerCommLumpSum,dbShipBuyerComm;
  DataBindTextWithChecker dbMakerDiscount;
  DataBindTextWithChecker dbMakerDiscountPC;
  DataBindTextWithChecker dbMakerDiscountDZ;
  DataBindTextWithChecker dbMakerLumpSum;
  DataBindTextWithChecker db4Behalf,dbShipStaffCode,dbHKCODE;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel9 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel10 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel11 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel13 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel14 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel15 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel18 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel19 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel110 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel20 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel21 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel22 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel23 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel24 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel25 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel26 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel27 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel28 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel29 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel210 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel214 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel215 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel216 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel217 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel218 = new BlueBkgWhiteCharLabel();
  SelectBuyerMaker slkChzBuyer = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel111 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea txt4Behalf = new JTextArea();

  JCheckBox chkBoxBymrkType_Buyer = new JCheckBox();
  JCheckBox chkBoxBymrkType_Maker = new JCheckBox();
  JCheckBox chkBoxBymrkType_FabricMill = new JCheckBox();
  JCheckBox chkBoxBymrkType_WashMill = new JCheckBox();
  JCheckBox chkBoxBymrkType_SewingShop = new JCheckBox();
  JCheckBox chkBoxBymrkType_Licensee = new JCheckBox();
  JCheckBox chkBoxBymrkType_Shipping = new JCheckBox();
  public static String BYMKR_BUYER_TYPE=",1,";
  public static String BYMKR_MAKER_TYPE=",2,";
  public static String BYMKR_FABRIC_MILL_TYPE=",3,";
  public static String BYMKR_WASH_MILL_TYPE=",4,";
  public static String BYMKR_SWEING_SHOP_TYPE=",5,";
  public static String BYMKR_LICENSEE_TYPE=",6,";
  public static String BYMKR_SHIPPING_TYPE=",7,";
  public static String BYMKR_OTHER_TYPE=",8,";
  //MESSERS, SUPPLIER, MANUFACTURER & CONSIGNEE
  public static String BYMKR_MESSERS_TYPE=",9,";
  public static String BYMKR_SUPPLIER_TYPE=",10,";
  public static String BYMKR_MANUFACTURER_TYPE=",11,";
  public static String BYMKR_CONSIGNEE_TYPE=",12,";
  public static String BYMKR_VENDOR_TYPE=",13,";

  JCheckBox chkBoxBymrkType_Others = new JCheckBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel219 = new BlueBkgWhiteCharLabel();
  JTextField txtShipStaffUsrCode = new JTextField();
  JPanel pnlMakerDisct = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JTextField txtMakerDiscount = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel213 = new BlueBkgWhiteCharLabel();
  JTextField txtMakerDiscountPC = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel16 = new BlueBkgWhiteCharLabel();
  JTextField txtMkrLumpSum = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel212 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel17 = new BlueBkgWhiteCharLabel();
  JTextField txtMakerDiscountDZ = new JTextField();
  JPanel pnlBuyerComm = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel112 = new BlueBkgWhiteCharLabel();
  JTextField txtBuyerCommLumpSum = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2110 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2111 = new BlueBkgWhiteCharLabel();
  JTextField txtBuyerCommPC = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel113 = new BlueBkgWhiteCharLabel();
  JTextField txtBuyerCommDz = new JTextField();
  Border border2;
  TitledBorder titledBorder2;
  JTextField txtBuyerComm = new JTextField();
  JTextField txtShipBuyerComm = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2112 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane4Centers = new JScrollPane();
  public static JPanel pnlCenters;
  GridLayout gridLayout1 = new GridLayout();
  public static java.util.HashMap hmSelectableCenter=null,hmSeqJChkCbxCenterMap2Code=null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel12 = new BlueBkgWhiteCharLabel();
  public static JCheckBox chkCbxCenters[];
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2113 = new BlueBkgWhiteCharLabel();
  JTextField txtBYMKR_HK_CODE = new JTextField();
  JTextField txtNameFullName2 = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel211 = new BlueBkgWhiteCharLabel();
  JCheckBox chkBoxBymrkType_MESSERS = new JCheckBox();
  JCheckBox chkBoxBymrkType_SUPPLIER = new JCheckBox();
  JCheckBox chkBoxBymrkType_MANUFACTURER = new JCheckBox();
  JCheckBox chkBoxBymrkType_CONSIGNEE = new JCheckBox();
  JCheckBox chkBoxBymrkType_Vendor = new JCheckBox();
  public FieldsGuiPanel(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void makeCenterSelections(String str){
     if(str==null)str="";
      try{
        if(hmSelectableCenter==null){

          pnlCenters.removeAll();
             java.util.Vector centers=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select CEN_CODE, CEN_NAME from center where record_delete_flag='1' order by cen_name",
             1,99999);
           hmSelectableCenter=new java.util.HashMap();
           hmSeqJChkCbxCenterMap2Code=new java.util.HashMap();
           chkCbxCenters=new JCheckBox[centers.size()];
           gridLayout1=new GridLayout(centers.size(),1);
           pnlCenters.setLayout(gridLayout1);
            for(int i=0;i<centers.size();i++){
             database.datatype.Record recCenter=
                 (database.datatype.Record)centers.get(i);
             chkCbxCenters[i]=new JCheckBox();
             chkCbxCenters[i].setText((String)recCenter.get(1));
             hmSelectableCenter.put((String)recCenter.get(0),chkCbxCenters[i]);
             hmSeqJChkCbxCenterMap2Code.put(String.valueOf(i),(String)recCenter.get(0));
             pnlCenters.add(chkCbxCenters[i]);
           }

           java.util.Iterator itr=hmSelectableCenter.keySet().iterator();
           while(itr.hasNext()){
             String key=(String)itr.next();
             JCheckBox chkCbx=(JCheckBox)hmSelectableCenter.get(key);
             if(str.indexOf(","+key+",")!=-1){
               chkCbx.setSelected(true);
             }else{
               chkCbx.setSelected(false);
             }
           }

        }else{
          java.util.Iterator itr=hmSelectableCenter.keySet().iterator();
          while(itr.hasNext()){
            String key=(String)itr.next();
            JCheckBox chkCbx=(JCheckBox)hmSelectableCenter.get(key);
            if(str.indexOf(","+key+",")!=-1){
              chkCbx.setSelected(true);
            }else{
              chkCbx.setSelected(false);
            }
          }
        }
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error While Generating Centers List\nPlease Contatc System Manager",
                                               "Error At Server Side");
      }
  }
  void jbInit() throws Exception {
    if(pnlCenters==null)pnlCenters=new JPanel();
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"Maker Discount");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border2,"Buyer Commision");
    this.setMaxLength();
    this.setLayout(null);
    this.setSize(new Dimension(770, 1066));
    this.setBackground(new Color(204, 204, 225));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setBounds(new Rectangle(0, 1, 770, 1064));
    rb_Y.setBounds(new Rectangle(168, 857, 96, 23));
    rb_Y.setText("Yes");
    rb_Y.setHorizontalAlignment(SwingConstants.CENTER);
    rb_Y.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_Y.setForeground(Color.darkGray);
    rb_Y.setBackground(Color.white);
    txtPerson.setBounds(new Rectangle(548, 592, 209, 23));
    txtWeb.setBounds(new Rectangle(550, 623, 209, 23));
    txtEmail.setBounds(new Rectangle(167, 623, 209, 23));
    txtBrief.setBounds(new Rectangle(143, 4, 130, 23));
    /*
    txtDiscount1.setBounds(new Rectangle(145, 609, 80, 44));
    txtDiscount1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtDiscount1_keyTyped(e);
      }
    });
    txtDiscount1.setHorizontalAlignment(SwingConstants.RIGHT);
    txtDiscount1.setText("000");
    txtDiscount1.setToolTipText("");
    */
    cmboCnty.setBounds(new Rectangle(543, 826, 209, 23));
    rb_N.setBounds(new Rectangle(264, 857, 105, 23));
    rb_N.setText("No");
    rb_N.setSelected(true);
    rb_N.setHorizontalAlignment(SwingConstants.CENTER);
    rb_N.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_N.setForeground(Color.darkGray);
    rb_N.setBackground(Color.white);
    txtBenef.setBounds(new Rectangle(165, 721, 344, 23));
    txtBenef.setFont(new java.awt.Font("MS Sans Serif", 0, 11));
    cmboCat.setBounds(new Rectangle(167, 826, 204, 23));
    /*
    cmboType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cmboType_itemStateChanged(e);
      }
    });
    */
    cmboDest.setBounds(new Rectangle(549, 692, 209, 23));
    txtBoss.setBounds(new Rectangle(167, 592, 209, 23));
    /*
    txtCommision1.setToolTipText("");
    txtCommision1.setText("000");
    txtCommision1.setHorizontalAlignment(SwingConstants.RIGHT);
    txtCommision1.setBounds(new Rectangle(552, 600, 32, 23));
    txtCommision1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCommision1_keyTyped(e);
      }
    });
    txtName.setBounds(new Rectangle(168, 83, 594, 23));
    cmboMasCo.setBounds(new Rectangle(552, 726, 209, 23));
    txtCommision1_1.setText("00");
    txtCommision1_1.setBounds(new Rectangle(586, 589, 61, 27));
    txtCommision1_1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        txtCommision1_1_keyTyped(e);
      }
    });
    */

    txtSewingCode.setBounds(new Rectangle(144, 68, 131, 22));
    txtWarehouse.setBounds(new Rectangle(168, 658, 209, 23));
    cmboCat.setBackground(Color.white);
    cmboCnty.setBackground(Color.white);
    txtChBrief.setBounds(new Rectangle(144, 36, 130, 23));
    txtOld.setBackground(Color.white);
    txtOld.setForeground(new Color(10,36,106));
    txtOld.setBounds(new Rectangle(382, 505, 155, 23));
    txtOld.setBounds(new Rectangle(164, 751, 209, 23));
    jScrollPane1.setBounds(new Rectangle(168, 882, 595, 56));
    txtAreaAudit.setText("");
    txtAreaAudit.setLineWrap(true);
    cmboCity.setBackground(Color.white);
    cmboCity.setBounds(new Rectangle(544, 857, 209, 23));
    cmboPay.setBounds(new Rectangle(549, 658, 209, 23));
    cmboPrice.setBounds(new Rectangle(167, 692, 209, 23));
    cmboPay.setBackground(Color.white);
    cmboPay.setEditable(true);
    cmboPrice.setBackground(Color.white);
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Mailling Address "));
    jPanel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setLayout(null);
    jPanel2.setBounds(new Rectangle(12, 192, 543, 143));
    jPanel3.setBounds(new Rectangle(14, 335, 543, 155));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Factory Address "));
    jPanel4.setBorder(BorderFactory.createTitledBorder(" TEL "));
    jPanel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(10, 489, 365, 94));
    jPanel5.setBounds(new Rectangle(395, 489, 365, 94));
    jPanel5.setLayout(null);
    jPanel5.setBackground(new Color(204, 204, 225));
    jPanel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel5.setBorder(BorderFactory.createTitledBorder(" FAX "));
    txtAddr1.setBounds(new Rectangle(144, 26, 393, 23));
    txtAddr2.setBounds(new Rectangle(144, 55, 393, 23));
    txtAddr4.setBounds(new Rectangle(144, 113, 393, 23));
    txtAddr3.setBounds(new Rectangle(144, 84, 393, 23));
    txt2ndAddr4.setBounds(new Rectangle(144, 114, 394, 23));
    txt2ndAddr2.setBounds(new Rectangle(144, 56, 394, 23));
    txt2ndAddr1.setBounds(new Rectangle(144, 27, 394, 23));
    txt2ndAddr3.setBounds(new Rectangle(144, 85, 394, 23));
    txtTel1.setBounds(new Rectangle(140, 25, 212, 23));
    txtTel2.setBounds(new Rectangle(140, 54, 212, 23));
    txtFax2.setBounds(new Rectangle(140, 55, 212, 23));
    txtFax1.setBounds(new Rectangle(140, 26, 212, 23));
    blueBkgWhiteCharLabel1.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel1.setText("*Type:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(17, 95, 56, 57));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(16, 4, 127, 23));
    blueBkgWhiteCharLabel2.setText("*Brief:");
    blueBkgWhiteCharLabel2.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel3.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel3.setText("Chiese Brief");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(16, 36, 128, 23));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(16, 68, 128, 23));
    blueBkgWhiteCharLabel4.setText("Sewing Shop Code");
    blueBkgWhiteCharLabel4.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel5.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel5.setText("Address2");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(10, 55, 130, 23));
    blueBkgWhiteCharLabel6.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel6.setText("Address4:");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(11, 111, 131, 23));
    blueBkgWhiteCharLabel7.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel7.setText("Address 2 :");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(12, 56, 131, 23));
    blueBkgWhiteCharLabel8.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel8.setText("Address 4:");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(12, 115, 131, 23));
    blueBkgWhiteCharLabel9.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel9.setText("TEL 2:");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(12, 55, 125, 23));
    blueBkgWhiteCharLabel10.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel10.setText("FAX 2:");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(12, 56, 125, 23));
    blueBkgWhiteCharLabel11.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel11.setText("Email:");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(12, 623, 154, 23));
    blueBkgWhiteCharLabel13.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel13.setText(" Beneficiary :");
    blueBkgWhiteCharLabel13.setBounds(new Rectangle(12, 721, 154, 23));
    blueBkgWhiteCharLabel14.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel14.setText(" Trading Category :");
    blueBkgWhiteCharLabel14.setBounds(new Rectangle(12, 825, 154, 23));
    blueBkgWhiteCharLabel15.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel15.setText(" Compliance Audit :");
    blueBkgWhiteCharLabel15.setBounds(new Rectangle(12, 885, 154, 54));
    blueBkgWhiteCharLabel18.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel18.setText(" Country :");
    blueBkgWhiteCharLabel18.setBounds(new Rectangle(394, 826, 147, 23));
    blueBkgWhiteCharLabel19.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel19.setText("Payterm:");
    blueBkgWhiteCharLabel19.setBounds(new Rectangle(394, 658, 153, 23));
    blueBkgWhiteCharLabel110.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel110.setText("Web site:");
    blueBkgWhiteCharLabel110.setBounds(new Rectangle(394, 623, 153, 23));
    blueBkgWhiteCharLabel20.setText("*Full Name:");
    blueBkgWhiteCharLabel20.setBounds(new Rectangle(275, 4, 120, 22));
    blueBkgWhiteCharLabel21.setBounds(new Rectangle(10, 26, 131, 22));
    blueBkgWhiteCharLabel21.setText("Address 1:");
    blueBkgWhiteCharLabel22.setBounds(new Rectangle(11, 84, 128, 22));
    blueBkgWhiteCharLabel22.setText("Address 3:");
    blueBkgWhiteCharLabel23.setBounds(new Rectangle(12, 28, 131, 22));
    blueBkgWhiteCharLabel23.setText("Address1:");
    blueBkgWhiteCharLabel24.setBounds(new Rectangle(12, 87, 131, 22));
    blueBkgWhiteCharLabel24.setText("Address3:");
    blueBkgWhiteCharLabel25.setBounds(new Rectangle(12, 25, 125, 22));
    blueBkgWhiteCharLabel25.setText("TEL1:");
    blueBkgWhiteCharLabel26.setBounds(new Rectangle(12, 592, 154, 22));
    blueBkgWhiteCharLabel26.setText("BOSS:");
    blueBkgWhiteCharLabel27.setBounds(new Rectangle(12, 658, 154, 22));
    blueBkgWhiteCharLabel27.setText("Ware House:");
    blueBkgWhiteCharLabel28.setBounds(new Rectangle(12, 693, 154, 22));
    blueBkgWhiteCharLabel28.setText("PriceTerm:");
    blueBkgWhiteCharLabel29.setBounds(new Rectangle(12, 751, 152, 22));
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      blueBkgWhiteCharLabel29.setText("Insurance Date:");
    }else{
      blueBkgWhiteCharLabel29.setText("MANUFACTURER ID:");
    }

    blueBkgWhiteCharLabel210.setBounds(new Rectangle(12, 857, 154, 22));
    blueBkgWhiteCharLabel210.setText("Check-DIV:");
    blueBkgWhiteCharLabel214.setBounds(new Rectangle(394, 857, 147, 22));
    blueBkgWhiteCharLabel214.setText("City:");
    blueBkgWhiteCharLabel215.setBounds(new Rectangle(12, 779, 154, 42));
    blueBkgWhiteCharLabel215.setText("<html><body>Master Company:<br>(blank means \'\'SELF\'\')</body></html>");
    blueBkgWhiteCharLabel216.setBounds(new Rectangle(394, 693, 153, 22));
    blueBkgWhiteCharLabel216.setText("Destination:");
    blueBkgWhiteCharLabel217.setText("Contact Person:");
    blueBkgWhiteCharLabel217.setBounds(new Rectangle(394, 592, 153, 22));
    blueBkgWhiteCharLabel218.setText("FAX1:");
    blueBkgWhiteCharLabel218.setBounds(new Rectangle(11, 25, 127, 22));
    txtName.setBounds(new Rectangle(395, 4, 370, 23));
    slkChzBuyer.setBounds(new Rectangle(166, 779, 210, 21));
    blueBkgWhiteCharLabel111.setBounds(new Rectangle(394, 753, 147, 61));
    blueBkgWhiteCharLabel111.setText("For and Behalf");
    blueBkgWhiteCharLabel111.setForeground(new Color(10,36,106));
    jScrollPane2.setBounds(new Rectangle(544, 753, 213, 60));
    chkBoxBymrkType_Buyer.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_Buyer.setText("BUYER");
    chkBoxBymrkType_Buyer.setBounds(new Rectangle(74, 98, 86, 13));
    chkBoxBymrkType_Maker.setBounds(new Rectangle(181, 98, 86, 13));
    chkBoxBymrkType_Maker.setText("MAKER");
    chkBoxBymrkType_Maker.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_FabricMill.setBounds(new Rectangle(271, 98, 112, 13));
    chkBoxBymrkType_FabricMill.setText("FABRIC MILL");
    chkBoxBymrkType_FabricMill.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_WashMill.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_WashMill.setText("WASH MILL");
    chkBoxBymrkType_WashMill.setBounds(new Rectangle(385, 98, 112, 13));
    chkBoxBymrkType_SewingShop.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_SewingShop.setText("SEWING SHOP");
    chkBoxBymrkType_SewingShop.setBounds(new Rectangle(501, 98, 112, 13));
    chkBoxBymrkType_Licensee.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_Licensee.setText("LICENSEE");
    chkBoxBymrkType_Licensee.setBounds(new Rectangle(649, 97, 110, 16));
    chkBoxBymrkType_Shipping.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_Shipping.setText("SHIPPING");
    chkBoxBymrkType_Shipping.setBounds(new Rectangle(74, 117, 89, 16));
    chkBoxBymrkType_Others.setBounds(new Rectangle(181, 120, 84, 13));
    chkBoxBymrkType_Others.setText("OTHERS");
    chkBoxBymrkType_Others.setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel219.setText("SHIPPING STAFF CODE:");
    blueBkgWhiteCharLabel219.setBounds(new Rectangle(395, 1037, 155, 22));
    txtShipStaffUsrCode.setText("");
    txtShipStaffUsrCode.setBounds(new Rectangle(549, 1036, 193, 23));
    pnlMakerDisct.setBackground(new Color(202, 202, 225));
    pnlMakerDisct.setBorder(titledBorder1);
    pnlMakerDisct.setBounds(new Rectangle(382, 942, 387, 83));
    pnlMakerDisct.setLayout(null);
    txtMakerDiscount.setBounds(new Rectangle(45, 21, 68, 23));
    blueBkgWhiteCharLabel213.setBounds(new Rectangle(13, 21, 32, 23));
    blueBkgWhiteCharLabel213.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel213.setText(" % :");
    txtMakerDiscountPC.setBounds(new Rectangle(214, 20, 92, 23));
    blueBkgWhiteCharLabel16.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel16.setText(" PC:");
    blueBkgWhiteCharLabel16.setBounds(new Rectangle(161, 20, 52, 23));
    txtMkrLumpSum.setBounds(new Rectangle(264, 51, 118, 23));
    blueBkgWhiteCharLabel212.setBounds(new Rectangle(161, 51, 104, 23));
    blueBkgWhiteCharLabel212.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel212.setText(" Lump Sum:");
    blueBkgWhiteCharLabel17.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel17.setText(" DZ:");
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(13, 51, 56, 23));
    txtMakerDiscountDZ.setBounds(new Rectangle(69, 51, 68, 23));
    pnlBuyerComm.setLayout(null);
    pnlBuyerComm.setBounds(new Rectangle(5, 941, 373, 116));
    pnlBuyerComm.setBorder(titledBorder2);
    pnlBuyerComm.setBackground(new Color(202, 202, 225));
    blueBkgWhiteCharLabel112.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel112.setText(" DZ:");
    blueBkgWhiteCharLabel112.setBounds(new Rectangle(11, 49, 56, 23));
    txtBuyerCommLumpSum.setBounds(new Rectangle(251, 54, 114, 23));
    blueBkgWhiteCharLabel2110.setBounds(new Rectangle(13, 21, 32, 23));
    blueBkgWhiteCharLabel2110.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel2110.setText(" % :");
    blueBkgWhiteCharLabel2111.setBounds(new Rectangle(148, 53, 104, 23));
    blueBkgWhiteCharLabel2111.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel2111.setText(" Lump Sum:");
    txtBuyerCommPC.setBounds(new Rectangle(201, 21, 92, 23));
    blueBkgWhiteCharLabel113.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel113.setText(" PC:");
    blueBkgWhiteCharLabel113.setBounds(new Rectangle(148, 21, 54, 23));
    txtBuyerCommDz.setBounds(new Rectangle(67, 49, 68, 23));
    txtBuyerComm.setBounds(new Rectangle(45, 21, 67, 23));
    txtShipBuyerComm.setBounds(new Rectangle(174, 86, 67, 23));
    blueBkgWhiteCharLabel2112.setText(" SHIP BUYER COMM.(%) :");
    blueBkgWhiteCharLabel2112.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel2112.setBounds(new Rectangle(10, 85, 164, 23));
    jScrollPane4Centers.setBounds(new Rectangle(557, 219, 192, 267));
    //pnlCenters.setLayout(gridLayout1);
    pnlCenters.setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(557, 197, 192, 23));
    blueBkgWhiteCharLabel12.setText("ENABEL SELECT CENTER");
    blueBkgWhiteCharLabel12.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel2113.setText("ISO Date:");
    blueBkgWhiteCharLabel2113.setBounds(new Rectangle(511, 720, 96, 22));
    txtBYMKR_HK_CODE.setBounds(new Rectangle(610, 719, 140, 24));
    txtNameFullName2.setBounds(new Rectangle(395, 29, 370, 23));
    blueBkgWhiteCharLabel211.setBounds(new Rectangle(275, 29, 120, 22));
    blueBkgWhiteCharLabel211.setText("*Full Name 2.:");
    chkBoxBymrkType_MESSERS.setBounds(new Rectangle(271, 120, 86, 13));
    chkBoxBymrkType_MESSERS.setText("MESSERS");
    chkBoxBymrkType_MESSERS.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_SUPPLIER.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_SUPPLIER.setText("SUPPLIER");
    chkBoxBymrkType_SUPPLIER.setBounds(new Rectangle(385, 120, 106, 13));
    chkBoxBymrkType_MANUFACTURER.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_MANUFACTURER.setText("MANUFACTURER ");
    chkBoxBymrkType_MANUFACTURER.setBounds(new Rectangle(501, 120, 135, 13));
    chkBoxBymrkType_CONSIGNEE.setBounds(new Rectangle(649, 119, 112, 13));
    chkBoxBymrkType_CONSIGNEE.setText("CONSIGNEE");
    chkBoxBymrkType_CONSIGNEE.setBackground(new Color(204, 204, 225));
    chkBoxBymrkType_Vendor.setBounds(new Rectangle(74, 139, 89, 16));
    chkBoxBymrkType_Vendor.setText("VENDOR");
    chkBoxBymrkType_Vendor.setBackground(new Color(204, 204, 225));
    pnlBuyerComm.add(blueBkgWhiteCharLabel2110, null);
    pnlBuyerComm.add(txtBuyerComm, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel113, null);
    pnlBuyerComm.add(txtBuyerCommPC, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel112, null);
    pnlBuyerComm.add(txtBuyerCommDz, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel2111, null);
    pnlBuyerComm.add(txtBuyerCommLumpSum, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel2112, null);
    pnlBuyerComm.add(txtShipBuyerComm, null);
    jPanel1.add(jScrollPane1, null);
    jPanel1.add(blueBkgWhiteCharLabel215, null);
    jPanel1.add(blueBkgWhiteCharLabel210, null);
    jPanel1.add(rb_Y, null);
    jPanel1.add(rb_N, null);
    jPanel1.add(blueBkgWhiteCharLabel214, null);
    jPanel1.add(cmboCity, null);
    jPanel1.add(blueBkgWhiteCharLabel14, null);
    jPanel1.add(cmboCat, null);
    jPanel1.add(blueBkgWhiteCharLabel18, null);
    jPanel1.add(cmboCnty, null);
    jPanel1.add(slkChzBuyer, null);
    jPanel1.add(blueBkgWhiteCharLabel29, null);
    jPanel1.add(txtOld, null);
    jPanel1.add(blueBkgWhiteCharLabel111, null);
    jPanel1.add(jScrollPane2, null);
    jPanel1.add(blueBkgWhiteCharLabel13, null);
    jPanel1.add(txtBenef, null);
    jPanel1.add(blueBkgWhiteCharLabel2113, null);
    jPanel1.add(txtBYMKR_HK_CODE, null);
    jPanel1.add(blueBkgWhiteCharLabel27, null);
    jPanel1.add(blueBkgWhiteCharLabel28, null);
    jPanel1.add(cmboPrice, null);
    jPanel1.add(blueBkgWhiteCharLabel216, null);
    jPanel1.add(cmboDest, null);
    jPanel1.add(txtWarehouse, null);
    jPanel1.add(blueBkgWhiteCharLabel19, null);
    jPanel1.add(cmboPay, null);
    jPanel1.add(blueBkgWhiteCharLabel26, null);
    jPanel1.add(blueBkgWhiteCharLabel11, null);
    jPanel1.add(txtEmail, null);
    jPanel1.add(txtBoss, null);
    jPanel1.add(blueBkgWhiteCharLabel217, null);
    jPanel1.add(txtPerson, null);
    jPanel1.add(blueBkgWhiteCharLabel110, null);
    jPanel1.add(txtWeb, null);
    jPanel1.add(jPanel4, null);
    jScrollPane2.getViewport().add(txt4Behalf, null);
    jScrollPane1.getViewport().add(txtAreaAudit, null);
    jPanel1.add(pnlMakerDisct, null);
    pnlMakerDisct.add(txtMakerDiscount, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel213, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel212, null);
    pnlMakerDisct.add(txtMkrLumpSum, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel16, null);
    pnlMakerDisct.add(txtMakerDiscountPC, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel17, null);
    pnlMakerDisct.add(txtMakerDiscountDZ, null);
    jPanel1.add(blueBkgWhiteCharLabel219, null);
    jPanel1.add(txtShipStaffUsrCode, null);
    jPanel1.add(blueBkgWhiteCharLabel15, null);
    jPanel4.add(txtTel2, null);
    jPanel4.add(txtTel1, null);
    jPanel4.add(blueBkgWhiteCharLabel9, null);
    jPanel4.add(blueBkgWhiteCharLabel25, null);
    jPanel1.add(jPanel5, null);
    jPanel5.add(txtFax2, null);
    jPanel5.add(txtFax1, null);
    jPanel5.add(blueBkgWhiteCharLabel10, null);
    jPanel5.add(blueBkgWhiteCharLabel218, null);
    jPanel1.add(jPanel3, null);
    jPanel2.add(txtAddr2, null);
    jPanel2.add(txtAddr3, null);
    jPanel2.add(txtAddr4, null);
    jPanel2.add(txtAddr1, null);
    jPanel2.add(blueBkgWhiteCharLabel5, null);
    jPanel2.add(blueBkgWhiteCharLabel6, null);
    jPanel2.add(blueBkgWhiteCharLabel21, null);
    jPanel2.add(blueBkgWhiteCharLabel22, null);
    jPanel1.add(jScrollPane4Centers, null);
    jPanel1.add(blueBkgWhiteCharLabel12, null);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(chkBoxBymrkType_Buyer, null);
    jScrollPane4Centers.getViewport().add(pnlCenters, null);
    jPanel1.add(txtSewingCode, null);
    jPanel3.add(txt2ndAddr2, null);
    jPanel3.add(txt2ndAddr3, null);
    jPanel3.add(txt2ndAddr4, null);
    jPanel3.add(txt2ndAddr1, null);
    jPanel3.add(blueBkgWhiteCharLabel7, null);
    jPanel3.add(blueBkgWhiteCharLabel8, null);
    jPanel3.add(blueBkgWhiteCharLabel23, null);
    jPanel3.add(blueBkgWhiteCharLabel24, null);
    jPanel1.add(jPanel2, null);
    cmboDest.setEditable(true);
    this.setCmboData();
    buttonGroup1.add(rb_Y);
    buttonGroup1.add(rb_N);
    this.add(jPanel1, null);
    jPanel1.add(blueBkgWhiteCharLabel20, null);
    jPanel1.add(txtName, null);
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(blueBkgWhiteCharLabel3, null);
    jPanel1.add(blueBkgWhiteCharLabel4, null);
    jPanel1.add(txtBrief, null);
    jPanel1.add(txtChBrief, null);
    jPanel1.add(blueBkgWhiteCharLabel211, null);
    jPanel1.add(txtNameFullName2, null);
    jPanel1.add(pnlBuyerComm, null);
    jPanel1.add(chkBoxBymrkType_SewingShop, null);
    jPanel1.add(chkBoxBymrkType_WashMill, null);
    jPanel1.add(chkBoxBymrkType_FabricMill, null);
    jPanel1.add(chkBoxBymrkType_Maker, null);
    jPanel1.add(chkBoxBymrkType_Licensee, null);
    jPanel1.add(chkBoxBymrkType_Shipping, null);
    jPanel1.add(chkBoxBymrkType_Others, null);
    jPanel1.add(chkBoxBymrkType_MESSERS, null);
    jPanel1.add(chkBoxBymrkType_SUPPLIER, null);
    jPanel1.add(chkBoxBymrkType_MANUFACTURER, null);
    jPanel1.add(chkBoxBymrkType_CONSIGNEE, null);
    jPanel1.add(chkBoxBymrkType_Vendor, null);
  }

  void setCmboData() {
      java.util.Vector vDataCnty = null;
      java.util.Vector vQuota = null;
      java.util.Vector vCity = null;
      java.util.Vector vPay = null;
      java.util.Vector vPrice = null;
      java.util.Vector vDestinations=null;
      try {
       // exgui2.Stuff.getBuyMkType4JComboBox(cmboType);
        vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
        vQuota = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("DISTINCT QTA_CAT","QTA_CAT");
        vCity = exgui2.CONST.BASIC_MAIN_EJB.getCityAll("CITY_NAME", "CITY_NAME");
        vPay = exgui2.CONST.BASIC_MAIN_EJB.getPaymentTermAll("PYT_TRM", "PYT_TRM");
        vPrice = exgui2.CONST.BASIC_MAIN_EJB.getPriceTermAll("PRC_TRM", "PRC_TRM");
        vDestinations=
            newtimes.basic.destination.DB_Destinations.getInstance().getRecords(1,9999);
        dbJCBXdests =
            //new exgui.DataBindEditableJCombobox(cmboDest, vDestinations,
            new exgui.DataBindJCombobox(cmboDest, vDestinations,
                                          "Dest_name",
                                          "dest_name",
                                           null,
                                         "","");//,20);
        //set limit of destination.
        /*
         exgui.DataBindText txtDestLen=
      new exgui.DataBindText
         ((javax.swing.text.JTextComponent)cmboDest.getEditor().getEditorComponent(),"",
         null,20);*/


        if (vPay.size() > 0) {
          database.datatype.Record recPay = (database.datatype.Record)vPay.get(0);
          dbJCBXPay = new exgui.DataBindEditableJCombobox(cmboPay, vPay, "PYT_TRM", "PYT_TRM",
                                                   recPay.get("PYT_TRM"), "", "",60);
          cmboPay.setSelectedIndex(0);
        }

        if (vPrice.size() > 0) {
          database.datatype.Record recPrice = (database.datatype.Record) vPrice.get(0);
          dbJCBXPrice = new exgui.DataBindJCombobox(cmboPrice, vPrice, "PRC_TRM",
                                           "PRC_TRM", recPrice.get("PRC_TRM"),"","");
          cmboPrice.setSelectedIndex(0);
        }

        if (vDataCnty.size() > 0) {
          database.datatype.Record recCity = (database.datatype.Record)vCity.get(0);
          dbJCBXCity = new exgui.DataBindJCombobox(cmboCity, vCity, "CITY_NAME", "CITY_NAME",
                                                   recCity.get("CITY_NAME"), "", "");
          cmboCity.setSelectedIndex(0);
        }

        if (vDataCnty.size() > 0) {
          database.datatype.Record recCnty = (database.datatype.Record) vDataCnty.get(0);
          dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", recCnty.get("CNTY_NAME"));
          cmboCnty.setSelectedIndex(0);
        }
        if (vQuota.size() > 0) {
          database.datatype.Record recQuota = (database.datatype.Record) vQuota.get(0);
          dbJCBXQuota = new exgui.DataBindJCombobox(cmboCat, vQuota, "QTA_CAT",
                                           "QTA_CAT", recQuota.get("QTA_CAT"),"","");
          cmboCat.setSelectedIndex(0);
        }

      } catch (Exception e) {
        e.printStackTrace();
        util.ExceptionLog.exp2File(e, "buyer data:"+vDataCnty.toString());
      }
    }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtSewingCode, null, "", 5);
    tx = new exgui.DataBindText(txtName, null, "", 60);
    tx = new exgui.DataBindText(txtNameFullName2, null, "", 60);
    tx = new exgui.DataBindText(txtBrief, null, "", 15);
    tx = new exgui.DataBindText(txtChBrief, null, "", 50);
    tx = new exgui.DataBindText(txtAddr1, null, "", 60);
    tx = new exgui.DataBindText(txtAddr2, null, "", 60);
    tx = new exgui.DataBindText(txtAddr3, null, "", 60);
    tx = new exgui.DataBindText(txtAddr4, null, "", 60);
    tx = new exgui.DataBindText(txt2ndAddr1, null, "", 60);
    tx = new exgui.DataBindText(txt2ndAddr2, null, "", 60);
    tx = new exgui.DataBindText(txt2ndAddr3, null, "", 60);
    tx = new exgui.DataBindText(txt2ndAddr4, null, "", 60);
    tx = new exgui.DataBindText(txtTel1, null, "", 15);
    tx = new exgui.DataBindText(txtTel2, null, "", 15);
    tx = new exgui.DataBindText(txtFax1, null, "", 15);
    tx = new exgui.DataBindText(txtFax2, null, "", 15);
    tx = new exgui.DataBindText(txtBoss, null, "", 60);
    tx = new exgui.DataBindText(txtPerson, null, "", 60);
    tx = new exgui.DataBindText(txtEmail, null, "", 60);
    tx = new exgui.DataBindText(txtWeb, null, "", 60);
    tx = new exgui.DataBindText(txtWarehouse, null, "", 60);
   /*
    tx = new exgui.DataBindText(txtCommision1, null, "", 3);
    tx = new exgui.DataBindText(txtCommision1_1, null, "", 2);
    tx = new exgui.DataBindText(txtDiscount1, null, "", 3);
    tx = new exgui.DataBindText(txtDiscount1_1, null, "", 2);
    */
    //tx = new exgui.DataBindText(txtDes, null, "", 20);
    tx = new exgui.DataBindText(txtBenef, null, "", 50);
    tx = new exgui.DataBindText(txtOld, null, "", 15);
    tx = new exgui.DataBindText(txtAreaAudit, null, "", 400);
    Object n52vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,2);
    Object n43vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
    Object n53vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,3);
    Object n83vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,3);
    Object chr60=exgui.verification.CellFormat.getOrdinaryField(60);
    Object chr20=exgui.verification.CellFormat.getOrdinaryField(20);
    Object chr10=exgui.verification.CellFormat.getOrdinaryField(10);
    dbBuyerComm=
        new  DataBindTextWithChecker(txtBuyerComm,"",null,6,
                                (exgui.Object2String)n52vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n52vfy);

    dbShipBuyerComm=
        new  DataBindTextWithChecker(txtShipBuyerComm,"",null,6,
                                (exgui.Object2String)n52vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n52vfy);


    dbBuyerCommPc=
        new  DataBindTextWithChecker(txtBuyerCommPC,"",null,8,
                                (exgui.Object2String)n43vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n43vfy);
    dbBuyerCommDz=
        new  DataBindTextWithChecker(txtBuyerCommDz,"",null,9,
                                (exgui.Object2String)n53vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n53vfy);
    dbBuyerCommLumpSum=
        new  DataBindTextWithChecker(txtBuyerCommLumpSum,"",null,12,
                                (exgui.Object2String)n83vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n83vfy);


    dbMakerDiscount=
        new  DataBindTextWithChecker(txtMakerDiscount,"",null,6,
                                (exgui.Object2String)n52vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n52vfy);

    dbMakerDiscountPC=
        new  DataBindTextWithChecker(txtMakerDiscountPC,"",null,8,
                                (exgui.Object2String)n43vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n43vfy);
    dbMakerDiscountDZ=
        new  DataBindTextWithChecker(txtMakerDiscountDZ,"",null,9,
                                (exgui.Object2String)n53vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n53vfy);
    dbMakerLumpSum=
        new  DataBindTextWithChecker(txtMkrLumpSum,"",null,12,
                                (exgui.Object2String)n83vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n83vfy);

    db4Behalf=
        new  DataBindTextWithChecker(txt4Behalf,"",null,60,
                                (exgui.Object2String)chr60,
                                (exgui.ultratable.CellTxtEditorFormat)chr60);
    dbShipStaffCode =
         new  DataBindTextWithChecker(txtShipStaffUsrCode,"",null,20,
                                 (exgui.Object2String)chr20,
                                 (exgui.ultratable.CellTxtEditorFormat)chr20);
   dbHKCODE =
     new  DataBindTextWithChecker(txtBYMKR_HK_CODE ,"",null,10,
                             (exgui.Object2String)chr10,
                             (exgui.ultratable.CellTxtEditorFormat)chr10);


  }

  java.util.HashMap setData2HashMap() {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      hm.put("BYMKR_BRIEF", txtBrief.getText().trim().toUpperCase());
      //hm.put("BYMKR_TYPE", exgui2.Stuff.getBuyMkTypeValue4JComboBox(cmboType,false));
      hm.put("BYMKR_NAME", txtName.getText().trim().toUpperCase());
      hm.put("BYMKR_NAME2", txtNameFullName2.getText().trim().toUpperCase());
      hm.put("BYMKR_SEWING_SHOP_CODE", txtSewingCode.getText().trim().toUpperCase());
      hm.put("BYMKR_ADDR1", txtAddr1.getText().trim().toUpperCase());
      hm.put("BYMKR_ADDR2", txtAddr2.getText().trim().toUpperCase());
      hm.put("BYMKR_ADDR3", txtAddr3.getText().trim().toUpperCase());
      hm.put("BYMKR_ADDR4", txtAddr4.getText().trim().toUpperCase());
      hm.put("BYMKR_SEC_ADDR1", txt2ndAddr1.getText().trim().toUpperCase());
      hm.put("BYMKR_SEC_ADDR2", txt2ndAddr2.getText().trim().toUpperCase());
      hm.put("BYMKR_SEC_ADDR3", txt2ndAddr3.getText().trim().toUpperCase());
      hm.put("BYMKR_SEC_ADDR4", txt2ndAddr4.getText().trim().toUpperCase());
      hm.put("BYMKR_TRADING_CAT", dbJCBXQuota==null?"":dbJCBXQuota.getSelectedValue().toString());
      hm.put("BYMKR_TEL1", txtTel1.getText().trim().toUpperCase());
      hm.put("BYMKR_TEL2", txtTel2.getText().trim().toUpperCase());
      hm.put("BYMKR_FAX1", txtFax1.getText().trim().toUpperCase());
      hm.put("BYMKR_FAX2", txtFax2.getText().trim().toUpperCase());
      hm.put("BYMKR_BOSS", txtBoss.getText().trim().toUpperCase());
      hm.put("BYMKR_CONTACT_PERSON", txtPerson.getText().trim().toUpperCase());
      hm.put("BYMKR_EMAIL", txtEmail.getText().trim().toUpperCase());
      hm.put("BYMKR_WEBSITE", txtWeb.getText().trim().toUpperCase());
      hm.put("BYMKR_WAREHOUSE", txtWarehouse.getText().trim().toUpperCase());
      hm.put("BYMKR_CHINESE_BRIEF", txtChBrief.getText().trim().toUpperCase());
      /*
      hm.put("BYMKR_COMMISION", txtCommision1.getText()+"."+txtCommision1_1.getText());
      hm.put("BYMKR_DISCOUNT", txtDiscount1.getText()+"."+txtDiscount1_1.getText());
      */
      hm.put("BYMKR_PAYTERM", dbJCBXPay==null?"":dbJCBXPay.getSelectedValue().toString());
      hm.put("BYMKR_PRICETERM", dbJCBXPrice==null?"":dbJCBXPrice.getSelectedValue().toString());
      hm.put("BYMKR_PRICETERM_DEST",
             (cmboDest.getSelectedItem()==null)?"":
             cmboDest.getSelectedItem().toString().trim().toUpperCase());
      hm.put("BYMKR_CHECK_DIV", exgui2.Stuff.setRadioButtonYesOrNo(rb_Y, rb_N));
      //hm.put("BYMKR_MASTER_COMPANY", dbJCBXMasCo==null?"null":dbJCBXMasCo.getSelectedValue().toString());
      hm.put("BYMKR_MASTER_COMPANY",
             slkChzBuyer.getSelectedValue());
      hm.put("FOR_BEHALF",txt4Behalf.getText().trim().toUpperCase());
      hm.put("BYMKR_BENEFICIARY", txtBenef.getText().trim().toUpperCase());
      hm.put("BYMKR_CNTY_CODE", dbJCBXCnty==null?"":dbJCBXCnty.getSelectedValue().toString());
      hm.put("BYMKR_OLD", txtOld.getText().trim().toUpperCase());
      hm.put("BYMKR_COMPLIANCE_AUDIT", txtAreaAudit.getText().trim().toUpperCase());
      hm.put("BYMKR_CITY_NAME", dbJCBXCity==null?"":dbJCBXCity.getSelectedValue().toString());
      /*
         BUY_COMM                NUMBER(5,2),
         MKR_DSCT_PER            NUMBER(5,2),
         MKR_DSCT_PC             NUMBER(5,2),
         MKR_DSCT_DZ             NUMBER(5,2),
         MKR_DSCT_LUMP_SUM       NUMBER(10,2)
      */
      hm.put("BUY_COMM",txtBuyerComm.getText());
      hm.put("SHIP_BUY_COMM",txtShipBuyerComm.getText());
      hm.put("MKR_DSCT_PER",txtMakerDiscount.getText());
      hm.put("MKR_DSCT_PC",txtMakerDiscountPC.getText());
      hm.put("MKR_DSCT_DZ",txtMakerDiscountDZ.getText());
      hm.put("MKR_DSCT_LUMP_SUM",txtMkrLumpSum.getText());
      hm.put("SHIP_RESPONSIBLE_BY",txtShipStaffUsrCode.getText().trim().toUpperCase());
     hm.put("BUY_COMM_PC",txtBuyerCommPC.getText());
     hm.put("BUY_COMM_DZ",txtBuyerCommDz.getText());
     hm.put("BUY_COMM_LUMP_SUM",txtBuyerCommLumpSum.getText());

     StringBuffer sbBelongedCenter=new StringBuffer();
     for(int i=0;i<chkCbxCenters.length;i++){
        if(chkCbxCenters[i].isSelected()){
           String centerCode=(String)hmSeqJChkCbxCenterMap2Code.get(String.valueOf(i));
           sbBelongedCenter.append(",");
           sbBelongedCenter.append(centerCode);
           sbBelongedCenter.append(",");
        }
     }
     hm.put("SELECTABLE_CENTER",sbBelongedCenter.toString());

      //compose buyer maker multi-type string.
      boolean isOrgTypeAssigned=false;
      StringBuffer sb=new StringBuffer();
      if(chkBoxBymrkType_Buyer.isSelected()){
        sb.append(BYMKR_BUYER_TYPE);
        hm.put("BYMKR_TYPE","1");
        isOrgTypeAssigned=true;
      }
      if(chkBoxBymrkType_Maker.isSelected()){
        sb.append(BYMKR_MAKER_TYPE);
        hm.put("BYMKR_TYPE","2");
        isOrgTypeAssigned=true;
      }
      if(chkBoxBymrkType_FabricMill.isSelected()){
        sb.append(BYMKR_FABRIC_MILL_TYPE);
        hm.put("BYMKR_TYPE","3");
        isOrgTypeAssigned=true;
      }
      if(chkBoxBymrkType_WashMill.isSelected()){
        sb.append(BYMKR_WASH_MILL_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE","4");
          isOrgTypeAssigned=true;
        }
      }
      if(chkBoxBymrkType_SewingShop.isSelected()){
        sb.append(BYMKR_SWEING_SHOP_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE", "5");
          isOrgTypeAssigned=true;
        }
      }
      if(chkBoxBymrkType_Shipping.isSelected()){
        sb.append(BYMKR_SHIPPING_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE", "7");
          isOrgTypeAssigned=true;
        }
      }
      if(chkBoxBymrkType_Others.isSelected()){
        sb.append(BYMKR_OTHER_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE", "8");
          isOrgTypeAssigned=true;
        }
      }
     //MESSERS, SUPPLIER, MANUFACTURER & CONSIGNEE
      if(chkBoxBymrkType_MESSERS.isSelected()){
        sb.append(BYMKR_MESSERS_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE", "9");
          isOrgTypeAssigned=true;
        }
      }

      if(chkBoxBymrkType_SUPPLIER.isSelected()){
        sb.append(BYMKR_SUPPLIER_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE", "10");
          isOrgTypeAssigned=true;
        }
      }

      if(chkBoxBymrkType_MANUFACTURER.isSelected()){
        sb.append(BYMKR_MANUFACTURER_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE", "11");
          isOrgTypeAssigned=true;
        }
      }

      if(chkBoxBymrkType_CONSIGNEE.isSelected()){
        sb.append(BYMKR_CONSIGNEE_TYPE);
        if(!isOrgTypeAssigned){
          hm.put("BYMKR_TYPE", "12");
          isOrgTypeAssigned=true;
        }
      }

      if(chkBoxBymrkType_Licensee.isSelected()){
        sb.append(BYMKR_LICENSEE_TYPE);
        hm.put("BYMKR_TYPE","6");
      }

      if(chkBoxBymrkType_Vendor.isSelected()){
        sb.append(BYMKR_VENDOR_TYPE);
        hm.put("BYMKR_TYPE","13");
      }


      hm.put("BYMKR_MULTI_TYPE",sb.toString());
      hm.put("BYMKR_HK_CODE",dbHKCODE.getSelectedValue());
      return hm;
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm,
        "error at datas, when put datas in HashMap."+hm.toString());
    } finally {
      return hm;
    }
  }

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtName.getText().trim(),"Full Name can't be empty.");
    if(!nameNull) return false;

    boolean briefNull = exgui2.Stuff.checkNull(frame, txtBrief.getText().trim(),"Brief can't be empty.");
    if(!briefNull) return false;

    if(!dbBuyerComm.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision Foramt Error"
      );
      txtBuyerComm.grabFocus();
      return false;
    }
    if(!dbShipBuyerComm.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Ship Buyer Commision Foramt Error"
      );
      txtBuyerComm.grabFocus();
      return false;
    }

    if(!dbBuyerCommPc.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision PC Foramt Error"
      );
      txtBuyerCommPC.grabFocus();
      return false;
    }
    if(!dbBuyerCommDz.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision DZ Foramt Error"
      );
      txtBuyerCommDz.grabFocus();
      return false;
    }
    if(!dbBuyerCommLumpSum.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision LumpSum Foramt Error"
      );
      txtBuyerCommLumpSum.grabFocus();
      return false;
    }




    if(!dbMakerDiscount.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker Discount Commision Foramt Error"
      );
      txtMakerDiscount.grabFocus();
      return false;
    }
    if(!dbMakerDiscountPC.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker Dsicount PC  Foramt Error"
      );
      txtMakerDiscountPC.grabFocus();
      return false;
    }
    if(!dbMakerDiscountDZ.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker Discount DZ Foramt Error"
      );
      txtMakerDiscountDZ.grabFocus();
      return false;
    }
    if(!dbMakerLumpSum.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker LumpSum Foramt Error"
      );
      txtMkrLumpSum.grabFocus();
      return false;
    }
    if(!db4Behalf.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "\"Behalf\" Foramt Error"
      );
      db4Behalf.getGUIcomponent().grabFocus();
      return false;
    }
   if((!chkBoxBymrkType_Buyer.isSelected()) &&
      (!chkBoxBymrkType_Maker.isSelected()) &&
      (!chkBoxBymrkType_FabricMill.isSelected()) &&
      (!chkBoxBymrkType_WashMill.isSelected()) &&
      (!chkBoxBymrkType_SewingShop.isSelected()) &&
      (!chkBoxBymrkType_Shipping.isSelected()) &&
      (!chkBoxBymrkType_Licensee.isSelected()) &&
      (!chkBoxBymrkType_Others.isSelected()) &&
       (!chkBoxBymrkType_MESSERS.isSelected()) &&
       (!chkBoxBymrkType_MANUFACTURER.isSelected())&&
       (!chkBoxBymrkType_SUPPLIER.isSelected())&&
       (!chkBoxBymrkType_CONSIGNEE.isSelected())&&
       (!chkBoxBymrkType_Vendor.isSelected()))
      {
     exgui.verification.VerifyLib.showAlert(
      "Please Select A Buyer Maker Type","Please Select A Buyer Maker Type"
     );
     return false;
   }
   boolean centerSelected=false;
   for(int i=0;i<chkCbxCenters.length;i++){
    if(chkCbxCenters[i].isSelected()){
      centerSelected=true;
       break;
    }
   }
    if(!centerSelected){
      exgui.verification.VerifyLib.showAlert("Please Select At Least One Center For Buyer/Maker",
                                             "Please Select At Least One Center");
      return false;
    }
    return true;

  }

}

